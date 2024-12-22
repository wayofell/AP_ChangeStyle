package com.mado.ap_changestyle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mado.ap_changestyle.ChangeStyleTheme
import com.mado.ap_changestyle.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }

            ChangeStyleTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThemeSwitcher(isDarkTheme = isDarkTheme, onThemeChange = { isDarkTheme = !isDarkTheme })
                }
            }
        }
    }
}

@Composable
fun ThemeSwitcher(isDarkTheme: Boolean, onThemeChange: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = if (isDarkTheme) "Темная тема" else "Светлая тема",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onThemeChange) {
            Text(text = "Переключить тему")
        }
    }
}
