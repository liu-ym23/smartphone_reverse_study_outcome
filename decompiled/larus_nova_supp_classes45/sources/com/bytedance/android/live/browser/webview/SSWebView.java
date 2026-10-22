package com.bytedance.android.live.browser.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.web.jsbridge2.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class SSWebView extends WebView implements x {
    public String getSafeUrl() {
        return "";
    }

    public SSWebView(Context r1) {
        super(r1);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r1) {
        super.setWebViewClient(r1);     // Catch: Exception -> L4
        return;
    }

    public SSWebView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public SSWebView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
