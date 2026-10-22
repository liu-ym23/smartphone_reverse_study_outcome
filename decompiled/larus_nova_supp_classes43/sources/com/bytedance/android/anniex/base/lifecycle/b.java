package com.bytedance.android.anniex.base.lifecycle;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.android.anniex.container.AnnieXContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends WebViewClient {
    public final AnnieXContainer a;
    public final WebViewClient b;

    public static final class a {
    }

    static {
    }

    public b(AnnieXContainer r10, WebViewClient r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        this.a = r10;
        this.b = r11;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r10, String r11) {
        super.onLoadResource(r10, r11);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onLoadResource(r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r10, String r11) {
        super.onPageCommitVisible(r10, r11);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPageCommitVisible(r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r10, String r11) {
        super.onPageFinished(r10, r11);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L5;
        r0.onPageFinished(r10, r11);
    L5:
        this.a.onWebPageFinish(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r10, ClientCertRequest r11) {
        super.onReceivedClientCertRequest(r10, r11);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedClientCertRequest(r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r10, RenderProcessGoneDetail r11) {
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onRenderProcessGone(r10, r11);
    L6:
        return super.onRenderProcessGone(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r10, KeyEvent r11) {
        super.onUnhandledKeyEvent(r10, r11);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onUnhandledKeyEvent(r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r10, WebResourceRequest r11) {
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.shouldInterceptRequest(r10, r11);
    L6:
        return super.shouldInterceptRequest(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r10, KeyEvent r11) {
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.shouldOverrideKeyEvent(r10, r11);
    L6:
        return super.shouldOverrideKeyEvent(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r10, WebResourceRequest r11) {
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.shouldOverrideUrlLoading(r10, r11);
    L6:
        return super.shouldOverrideUrlLoading(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r10, String r11) {
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.shouldInterceptRequest(r10, r11);
    L6:
        return super.shouldInterceptRequest(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r10, String r11) {
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.shouldOverrideUrlLoading(r10, r11);
    L6:
        return super.shouldOverrideUrlLoading(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r10, String r11, boolean r12) {
        super.doUpdateVisitedHistory(r10, r11, r12);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.doUpdateVisitedHistory(r10, r11, r12);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView r10, Message r11, Message r12) {
        super.onFormResubmission(r10, r11, r12);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFormResubmission(r10, r11, r12);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r10, String r11, Bitmap r12) {
        super.onPageStarted(r10, r11, r12);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPageStarted(r10, r11, r12);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r10, WebResourceRequest r11, WebResourceError r12) {
        super.onReceivedError(r10, r11, r12);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedError(r10, r11, r12);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r10, WebResourceRequest r11, WebResourceResponse r12) {
        super.onReceivedHttpError(r10, r11, r12);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedHttpError(r10, r11, r12);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r10, SslErrorHandler r11, SslError r12) {
        super.onReceivedSslError(r10, r11, r12);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedSslError(r10, r11, r12);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView r10, float r11, float r12) {
        super.onScaleChanged(r10, r11, r12);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onScaleChanged(r10, r11, r12);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView r10, Message r11, Message r12) {
        super.onTooManyRedirects(r10, r11, r12);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onTooManyRedirects(r10, r11, r12);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r10, int r11, String r12, String r13) {
        super.onReceivedError(r10, r11, r12, r13);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedError(r10, r11, r12, r13);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r10, HttpAuthHandler r11, String r12, String r13) {
        super.onReceivedHttpAuthRequest(r10, r11, r12, r13);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedHttpAuthRequest(r10, r11, r12, r13);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r10, String r11, String r12, String r13) {
        super.onReceivedLoginRequest(r10, r11, r12, r13);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedLoginRequest(r10, r11, r12, r13);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r10, WebResourceRequest r11, int r12, SafeBrowsingResponse r13) {
        WebViewClient r0 = this.b;
        if (r0 == null) goto L5;
        r0.onSafeBrowsingHit(r10, r11, r12, r13);
    L5:
        super.onSafeBrowsingHit(r10, r11, r12, r13);
    }
}
