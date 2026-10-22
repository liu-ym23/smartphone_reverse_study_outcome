package com.obric.oui.window.permission;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.ClientCertRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.net.MailTo;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewActivity f14925a;

    public f(WebViewActivity r5) {
        this.f14925a = r5;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView r5, String r10) {
        super.onPageFinished(r5, r10);
        WebViewActivity r11 = this.f14925a;
        if (r11.f14919w == false) goto L8;
        r11.f14919w = false;
        com.obric.oui.lisitem.a r12 = r11.f14918v;
        if (r12 == null) goto L7;
        r5.removeCallbacks(r12);
    L7:
        r11.f14916t.setVisibility(8);
        r11.s.setVisibility(0);
    L8:
        r5.evaluateJavascript("(function() { document.body.style.paddingTop = '80px';var style = document.createElement('style');style.type = 'text/css';style.innerHTML = 'html, body, * { text-spacing-trim: space-all !important;  }';document.head.appendChild(style);})()", null);
        r5.postDelayed(r11.f14917u, 100);
        androidx.constraintlayout.motion.widget.a.B(new StringBuilder("onPageFinished: "), r10, "WebViewActivity");
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView r5, String r10, Bitmap r11) {
        androidx.constraintlayout.motion.widget.a.A("onPageStarted: ", r10, "WebViewActivity");
        super.onPageStarted(r5, r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r5, ClientCertRequest r10) {
        if (r10 == null) goto L4;
        String r11 = r10.getHost();
    L5:
        Log.w("WebViewActivity", "onReceivedClientCertRequest: " + r11);
        super.onReceivedClientCertRequest(r5, r10);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r5, WebResourceRequest r10, WebResourceError r11) {
        super.onReceivedError(r5, r10, r11);
        StringBuilder r12 = new StringBuilder("onReceivedError: ");
        if (r11 == null) goto L5;
        CharSequence r13 = r11.getDescription();
    L6:
        r12.append(r13);
        Log.e("WebViewActivity", r12.toString());
        int r14 = WebViewActivity.f14915x;
        this.f14925a.x();
        return;
    L5:
        r13 = "unknown error";
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r5, WebResourceRequest r10, WebResourceResponse r11) {
        super.onReceivedHttpError(r5, r10, r11);
        Log.e("WebViewActivity", "onReceivedHttpError: " + r11);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r5, SslErrorHandler r10, SslError r11) {
        Log.e("WebViewActivity", "onReceivedSslError: " + r11);
        int r12 = WebViewActivity.f14915x;
        this.f14925a.x();
        super.onReceivedSslError(r5, r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r5, WebResourceRequest r10) {
        String r11 = null;
        if (r10 == null) goto L5;
        Uri r12 = r10.getUrl();
    L6:
        if (r12 == null) goto L8;
        r11 = r12.toString();
    L8:
        androidx.constraintlayout.motion.widget.a.A("shouldInterceptRequest: ", r11, "WebViewActivity");
        return super.shouldInterceptRequest(r5, r10);
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r5, WebResourceRequest r10) {
        String r11 = r10.getUrl().toString();
        if (r11.startsWith("tel:") == false) goto L5;
    L24:
        Intent r12 = new Intent("android.intent.action.VIEW", Uri.parse(r11));     // Catch: Exception -> L21
        r5.getContext().startActivity(r12);     // Catch: Exception -> L21
        return true;
    L21:
        Log.e("WebViewActivity", "shouldOverrideUrlLoading can resolve : ".concat(r11));
    L22:
        Log.d("WebViewActivity", "shouldOverrideUrlLoading: ".concat(r11));
        return false;
    L5:
        if (r11.startsWith(MailTo.MAILTO_SCHEME) == true) goto L24;
        if (r11.startsWith("sms:") == true) goto L24;
        if (r11.startsWith("smsto:") == true) goto L24;
        if (r11.startsWith("market:") == true) goto L24;
        if (r11.startsWith("geo:") == true) goto L24;
        if (r11.startsWith("whatsapp:") == true) goto L24;
        if (r11.startsWith("intent:") == false) goto L22;
        goto L22
    }
}
