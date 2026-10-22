package com.ivy.ivykit.plugin.impl.web;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ies.bullet.service.base.YieldError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends hc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f9537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f9538b;

    public d(h r5, j r10) {
        this.f9537a = r5;
        this.f9538b = r10;
    }

    @Override // bd.c
    public final void a(com.bytedance.frameworks.baselib.network.http.cronet.b r5) {
        if (this.f9537a.f9543b == null) goto L7;
        if (r5 == null) goto L7;
        Intrinsics.checkNotNullParameter(r5, "<this>");
    L7:
        throw new YieldError();
    }

    @Override // bd.c
    public final boolean b(WebView r5, ValueCallback r10, ym.d r11) {
        if (this.f9537a.f9543b == null) goto L7;
        new c(r11);
        return false;
    L7:
        throw new YieldError();
    }

    @Override // bd.c, android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        return this.f9538b.g;
    }

    @Override // android.webkit.WebChromeClient
    public final void onConsoleMessage(String r5, int r10, String r11) {
        super.onConsoleMessage(r5, r10, r11);
        ol.d r12 = this.f9537a.f9543b;
        if (r12 == null) goto L6;
        r12.i(r5, r10, r11);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        super.onHideCustomView();
        ol.d r5 = this.f9537a.f9543b;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r5, int r10) {
        super.onProgressChanged(r5, r10);
        ol.d r11 = this.f9537a.f9543b;
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r5, String r10) {
        super.onReceivedTitle(r5, r10);
        ol.d r11 = this.f9537a.f9543b;
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r5, WebChromeClient.CustomViewCallback r10) {
        super.onShowCustomView(r5, r10);
        ol.d r11 = this.f9537a.f9543b;
    }

    @Override // bd.c, android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r5, ValueCallback r10, WebChromeClient.FileChooserParams r11) {
        if (this.f9537a.f9543b == null) goto L7;
        return false;
    L7:
        return super.onShowFileChooser(r5, r10, r11);
    }
}
