package hc;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import bd.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewClient f17298a;

    public a(WebViewClient r5) {
        Intrinsics.checkNotNullParameter(r5, "webViewClient");
        this.f17298a = r5;
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r5, String r10, boolean r11) {
        this.f17298a.doUpdateVisitedHistory(r5, r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView r5, Message r10, Message r11) {
        this.f17298a.onFormResubmission(r5, r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView r5, String r10) {
        this.f17298a.onLoadResource(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView r5, String r10) {
        this.f17298a.onPageCommitVisible(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView r5, String r10) {
        this.f17298a.onPageFinished(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView r5, String r10, Bitmap r11) {
        this.f17298a.onPageStarted(r5, r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r5, ClientCertRequest r10) {
        this.f17298a.onReceivedClientCertRequest(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r5, int r10, String r11, String r12) {
        this.f17298a.onReceivedError(r5, r10, r11, r12);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r5, HttpAuthHandler r10, String r11, String r12) {
        this.f17298a.onReceivedHttpAuthRequest(r5, r10, r11, r12);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r5, String r10, String r11, String r12) {
        this.f17298a.onReceivedLoginRequest(r5, r10, r11, r12);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r5, SslErrorHandler r10, SslError r11) {
        this.f17298a.onReceivedSslError(r5, r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r5, WebResourceRequest r10, int r11, SafeBrowsingResponse r12) {
        this.f17298a.onSafeBrowsingHit(r5, r10, r11, r12);
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView r5, float r10, float r11) {
        this.f17298a.onScaleChanged(r5, r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView r5, Message r10, Message r11) {
        this.f17298a.onTooManyRedirects(r5, r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r5, KeyEvent r10) {
        this.f17298a.onUnhandledKeyEvent(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r5, KeyEvent r10) {
        return this.f17298a.shouldOverrideKeyEvent(r5, r10);
    }
}
