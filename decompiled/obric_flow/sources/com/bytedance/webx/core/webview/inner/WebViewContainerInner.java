package com.bytedance.webx.core.webview.inner;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import qk.a;
import tk.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WebViewContainerInner extends WebView {
    public WebViewContainerInner(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }

    public a getExtendableContext() {
        return null;
    }

    public tk.a getExtendableWebChromeClient() {
        return null;
    }

    public b getExtendableWebViewClient() {
        return null;
    }

    @Override // android.webkit.WebView
    public WebChromeClient getWebChromeClient() {
        return super.getWebChromeClient();
    }

    public WebChromeClient getWebChromeClientCompat() {
        throw null;
    }

    @Override // android.webkit.WebView
    public WebViewClient getWebViewClient() {
        return super.getWebViewClient();
    }

    public WebViewClient getWebViewClientCompat() {
        throw null;
    }

    @Override // android.webkit.WebView
    @RequiresApi(29)
    public WebViewRenderProcess getWebViewRenderProcess() {
        return super.getWebViewRenderProcess();
    }

    @Override // android.webkit.WebView
    @Nullable
    @RequiresApi(29)
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return super.getWebViewRenderProcessClient();
    }

    public void setExtendableWebViewClient(b r5) {
        super.setWebViewClient(null);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r5) {
        super.setWebChromeClient(r5);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r5) {
        super.setWebViewClient(r5);
    }

    @Override // android.webkit.WebView
    @RequiresApi(29)
    public void setWebViewRenderProcessClient(@Nullable WebViewRenderProcessClient r5) {
        super.setWebViewRenderProcessClient(r5);
    }

    public void setExtendableWebViewClient(tk.a r5) {
        super.setWebChromeClient(null);
    }
}
