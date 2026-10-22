package com.ss.android.lark.chameleon.util;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.bridge.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SafeJSExecutor {
    private static final String TAG = "SafeJSExecutor";

    public SafeJSExecutor() {
    }

    private static boolean webViewNotOk(WebView r1) {
        if (r1 != null) goto L5;
        new IllegalStateException("execJS no webView !");
        return true;
    L5:
        return false;
    }

    public static void execJS(WebView r1, String r2) {
        execJS(r1, r2, null, null);
    }

    public static void execJS(WebView r1, String r2, JsonObject r3) {
        execJS(r1, r2, r3, null);
    }

    public static void execJS(WebView r1, String r2, NonProguard r3) {
        execJS(r1, r2, r3, null);
    }

    public static void execJS(WebView r1, String r2, JsonObject r3, ValueCallback<String> r4) {
        if (webViewNotOk(r1) == false) goto L5;
        return;
    L5:
        r1.evaluateJavascript(JsonUtils.INSTANCE.combineRequestContent(r2, r3), r4);
    }

    public static void execJS(WebView r1, String r2, NonProguard r3, ValueCallback<String> r4) {
        if (webViewNotOk(r1) == false) goto L5;
        return;
    L5:
        r1.evaluateJavascript(JsonUtils.INSTANCE.combineRequestContent(r2, r3), r4);
    }
}
