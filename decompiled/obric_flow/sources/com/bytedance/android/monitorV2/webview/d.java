package com.bytedance.android.monitorV2.webview;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3772a;

    public /* synthetic */ d(int r5) {
        this.f3772a = r5;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r13, Method r14, Object[] r15) {
        switch(this.f3772a) {
            case 0: goto L101;
            case 1: goto L96;
            default: goto L99;
        };
    L99:
        String r5 = (String) r15[0];     // Catch: Throwable -> L13
        Integer r10 = (Integer) r15[1];     // Catch: Throwable -> L13
        HashMap r16 = (HashMap) r15[2];     // Catch: Throwable -> L13
        Object[] r11 = (Object[]) r16.get("args");     // Catch: Throwable -> L13
        k r12 = k.d;     // Catch: Throwable -> L13
        if (r12.v() == true) goto L9;
    L98:
    L33:
        return null;
    L9:
        if ("ttwebviewdelegate".equals(r5) == true) goto L17;
        if (1 != r10.intValue()) goto L98;
    L17:
        if ("init".equals(r16.get("name")) == false) goto L20;
        d5.b.f("TTWebViewDelegateHandler", "handleViewCreate: " + d5.b.a((WebView) r11[0]));     // Catch: Throwable -> L13
        r12.w((WebView) r11[0]);     // Catch: Throwable -> L13
        goto L98
    L20:
        if ("loadUrl".equals(r16.get("name")) == false) goto L23;
        d5.b.f("TTWebViewDelegateHandler", "onLoadUrl: " + r11[1]);     // Catch: Throwable -> L13
        r12.j((WebView) r11[0], (String) r11[1]);     // Catch: Throwable -> L13
        goto L98
    L23:
        if ("goBack".equals(r16.get("name")) == false) goto L26;
        d5.b.f("TTWebViewDelegateHandler", "goBack: " + d5.b.a((WebView) r11[0]));     // Catch: Throwable -> L13
        r12.r((WebView) r11[0]);     // Catch: Throwable -> L13
        goto L98
    L26:
        if ("reload".equals(r16.get("name")) == false) goto L29;
        d5.b.f("TTWebViewDelegateHandler", "reload: " + d5.b.a((WebView) r11[0]));     // Catch: Throwable -> L13
        WebView r17 = (WebView) r11[0];     // Catch: Throwable -> L13
        goto L98
    L29:
        if ("destroy".equals(r16.get("name")) == false) goto L98;
        d5.b.f("TTWebViewDelegateHandler", "destroy: " + d5.b.a((WebView) r11[0]));     // Catch: Throwable -> L13
        r12.d((WebView) r11[0]);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        mn.h.g("default_handle", th);
        goto L33
    L96:
        String r18 = (String) r15[0];     // Catch: Throwable -> L43
        Integer r19 = (Integer) r15[1];     // Catch: Throwable -> L43
        HashMap r110 = (HashMap) r15[2];     // Catch: Throwable -> L43
        Object[] r20 = (Object[]) r110.get("args");     // Catch: Throwable -> L43
        k r111 = k.d;     // Catch: Throwable -> L43
        if (r111.v() == true) goto L39;
    L95:
    L75:
        return null;
    L39:
        if ("ttwebviewdelegate".equals(r18) == true) goto L47;
        if (1 != r19.intValue()) goto L95;
    L47:
        if ("onPageStarted".equals(r110.get("name")) == false) goto L50;
        d5.b.f("TTWebViewClientDelegateHandler", "onPageStarted:" + r20[1]);     // Catch: Throwable -> L43
        r111.x((WebView) r20[0], (String) r20[1]);     // Catch: Throwable -> L43
        goto L95
    L50:
        if ("onPageFinished".equals(r110.get("name")) == false) goto L54;
        d5.b.f("TTWebViewClientDelegateHandler", "onPageFinished: " + r20[1]);     // Catch: Throwable -> L43
        r111.u((WebView) r20[0], (String) r20[1]);     // Catch: Throwable -> L43
        goto L95
    L54:
        if ("onReceivedError".equals(r110.get("name")) == false) goto L59;
        if (r20.length != 3) goto L59;
        d5.b.f("TTWebViewClientDelegateHandler", "handleRequestError: " + d5.b.a((WebView) r20[0]) + ", error: " + r20[2]);     // Catch: Throwable -> L43
        r111.s((WebView) r20[0], (WebResourceRequest) r20[1], (WebResourceError) r20[2]);     // Catch: Throwable -> L43
    L59:
        if ("onReceivedError".equals(r110.get("name")) == false) goto L64;
        if (r20.length != 4) goto L64;
        d5.b.f("TTWebViewClientDelegateHandler", "handleRequestError: " + d5.b.a((WebView) r20[0]) + ", errorCode: " + r20[1]);     // Catch: Throwable -> L43
        WebView r112 = (WebView) r20[0];     // Catch: Throwable -> L43
        ((Integer) r20[1]).getClass();     // Catch: Throwable -> L43
        String r113 = (String) r20[2];     // Catch: Throwable -> L43
        String r114 = (String) r20[3];     // Catch: Throwable -> L43
        r111.q();     // Catch: Throwable -> L43
    L64:
        if ("onReceivedHttpError".equals(r110.get("name")) == false) goto L69;
        if (r20.length != 3) goto L69;
        d5.b.f("TTWebViewClientDelegateHandler", "handleRequestHttpError: " + d5.b.a((WebView) r20[0]) + ", request: " + r20[1]);     // Catch: Throwable -> L43
        r111.t((WebView) r20[0], (WebResourceRequest) r20[1], (WebResourceResponse) r20[2]);     // Catch: Throwable -> L43
    L69:
        if ("onRenderProcessGone".equals(r110.get("name")) == false) goto L95;
        if (r20.length != 2) goto L95;
        d5.b.f("TTWebViewClientDelegateHandler", "handleRenderProcessGone: " + d5.b.a((WebView) r20[0]) + ", detail: " + r20[1]);     // Catch: Throwable -> L43
        r111.f((WebView) r20[0], (RenderProcessGoneDetail) r20[1]);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        mn.h.g("default_handle", th);
        goto L75
    L101:
        String r21 = (String) r15[0];     // Catch: Throwable -> L85
        Integer r22 = (Integer) r15[1];     // Catch: Throwable -> L85
        HashMap r115 = (HashMap) r15[2];     // Catch: Throwable -> L85
        Object[] r23 = (Object[]) r115.get("args");     // Catch: Throwable -> L85
        k r24 = k.d;     // Catch: Throwable -> L85
        if (r24.v() == true) goto L81;
    L94:
        return null;
    L81:
        if ("ttwebviewdelegate".equals(r21) == true) goto L88;
        if (1 != r22.intValue()) goto L94;
    L88:
        if ("onProgressChanged".equals(r115.get("name")) == false) goto L94;
        if (r23.length != 2) goto L94;
        d5.b.f("TTWebChromeClientDelegateHandler", "onProgressChanged: " + d5.b.a((WebView) r23[0]) + ", newProgress: " + r23[1]);     // Catch: Throwable -> L85
        r24.e((WebView) r23[0], ((Integer) r23[1]).intValue());     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        mn.h.g("default_handle", th);
        goto L94
    }
}
