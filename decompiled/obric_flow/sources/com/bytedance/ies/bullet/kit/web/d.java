package com.bytedance.ies.bullet.kit.web;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends bd.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5492a;

    public /* synthetic */ d(int r5) {
        this.f5492a = r5;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r5, String r10) {
        switch(this.f5492a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.onPageFinished(r5, r10);
        return;
    L6:
        super.onPageFinished(r5, r10);
        com.bytedance.android.monitorV2.webview.k r11 = com.bytedance.android.monitorV2.webview.k.d;
        r11.getClass();
        d5.b.f("WebViewMonitorHelper", "onPageFinished: " + r10);
        if (r11.v() == true) goto L9;
    L11:
        r11.u(r5, r10);
        return;
    L9:
        if (r11.f3799b.f(r5) == false) goto L11;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView r5, String r10, Bitmap r11) {
        switch(this.f5492a) {
            case 0: goto L15;
            default: goto L4;
        };
    L4:
        super.onPageStarted(r5, r10, r11);
        ConcurrentHashMap r12 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r13 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r13 == null) goto L9;
        xc.f r14 = (xc.f) r13.a(xc.f.class);
        if (r14 == null) goto L9;
        boolean r15 = r14.g();
    L10:
        if (r15 == false) goto L22;
        if (r5 == null) goto L23;
        if (r10 == null) goto L24;
        com.bytedance.android.monitorV2.webview.k.d.o("anniex_ssp_pv", String.valueOf(r5.hashCode()), r10, null);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L9:
        r15 = false;
        goto L10
    L15:
        super.onPageStarted(r5, r10, r11);
        com.bytedance.android.monitorV2.webview.k r16 = com.bytedance.android.monitorV2.webview.k.d;
        r16.getClass();
        d5.b.f("WebViewMonitorHelper", "onPageStarted:" + r10);
        if (r16.v() == true) goto L18;
    L20:
        r16.x(r5, r10);
        return;
    L18:
        if (r16.f3799b.f(r5) == false) goto L20;
    }

    @Override // bd.e, android.webkit.WebViewClient
    public void onReceivedError(WebView r5, WebResourceRequest r10, WebResourceError r11) {
        switch(this.f5492a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.onReceivedError(r5, r10, r11);
        return;
    L6:
        super.onReceivedError(r5, r10, r11);
        com.bytedance.android.monitorV2.webview.k r12 = com.bytedance.android.monitorV2.webview.k.d;
        r12.getClass();
        d5.b.f("WebViewMonitorHelper", "handleRequestError: " + d5.b.a(r5) + ", errorCode: " + r11.getErrorCode());
        if (r12.v() == true) goto L9;
    L11:
        r12.s(r5, r10, r11);
        return;
    L9:
        if (r12.f3799b.f(r5) == false) goto L11;
    }

    @Override // bd.e, android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r5, WebResourceRequest r10, WebResourceResponse r11) {
        switch(this.f5492a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.onReceivedHttpError(r5, r10, r11);
        return;
    L6:
        if (r10 == null) goto L8;
        Intrinsics.checkNotNullParameter(r10, "<this>");
    L8:
        com.bytedance.android.monitorV2.webview.k r12 = com.bytedance.android.monitorV2.webview.k.d;
        r12.getClass();
        d5.b.f("WebViewMonitorHelper", "handleRequestHttpError: " + d5.b.a(r5) + ", request: " + r10 + ", statusCode: " + r11.getStatusCode());
        if (r12.v() == true) goto L11;
    L13:
        r12.t(r5, r10, r11);
        return;
    L11:
        if (r12.f3799b.f(r5) == false) goto L13;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r5, int r10, String r11, String r12) {
        switch(this.f5492a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.onReceivedError(r5, r10, r11, r12);
        return;
    L6:
        super.onReceivedError(r5, r10, r11, r12);
        com.bytedance.android.monitorV2.webview.k r13 = com.bytedance.android.monitorV2.webview.k.d;
        r13.getClass();
        d5.b.f("WebViewMonitorHelper", "handleRequestError: " + d5.b.a(r5) + ", errorCode: " + r10);
        if (r13.v() == true) goto L9;
    L11:
        r13.q();
        return;
    L9:
        if (r13.f3799b.f(r5) == false) goto L11;
    }
}
