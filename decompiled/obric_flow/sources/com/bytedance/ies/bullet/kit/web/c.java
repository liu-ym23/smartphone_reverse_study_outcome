package com.bytedance.ies.bullet.kit.web;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends bd.c {
    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r5, int r10) {
        super.onProgressChanged(r5, r10);
        com.bytedance.android.monitorV2.webview.k r11 = com.bytedance.android.monitorV2.webview.k.d;
        r11.getClass();
        d5.b.f("WebViewMonitorHelper", "onProgressChanged: " + d5.b.a(r5) + ", newProgress: " + r10);
        if (r11.v() == true) goto L5;
    L7:
        r11.e(r5, r10);
        return;
    L5:
        if (r11.f3799b.f(r5) == false) goto L7;
    }
}
