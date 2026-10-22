package com.tencent.open.web;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.open.log.SLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a {
    private static void a(WebSettings r2) {
        r2.setSavePassword(false);     // Catch: Exception -> L5
        r2.setAllowFileAccess(false);     // Catch: Exception -> L5
        r2.setAllowFileAccessFromFileURLs(false);     // Catch: Exception -> L5
        r2.setAllowUniversalAccessFromFileURLs(false);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        SLog.e("WebViewUtils", "Exception", e);
    }

    private static void b(WebView r1) {
        r1.removeJavascriptInterface("searchBoxJavaBridge_");
        r1.removeJavascriptInterface("accessibility");
        r1.removeJavascriptInterface("accessibilityTraversal");
    }

    public static void a(WebView r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        b(r0);
        WebSettings r1 = r0.getSettings();
        if (r1 == null) goto L8;
        a(r1);
        b(r1);
        return;
    }

    private static void b(WebSettings r1) {
        r1.setJavaScriptEnabled(true);
    }
}
