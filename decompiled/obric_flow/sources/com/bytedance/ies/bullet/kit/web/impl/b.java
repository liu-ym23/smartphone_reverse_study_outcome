package com.bytedance.ies.bullet.kit.web.impl;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.web.pia.j;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends hc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5507b;

    public /* synthetic */ b(Object r5, int r10) {
        this.f5506a = r10;
        this.f5507b = r5;
    }

    @Override // bd.e
    public void a() {
        switch(this.f5506a) {
            case 1: goto L7;
            default: goto L4;
        };
    L4:
        super.a();
        return;
    L7:
        throw new YieldError();
    }

    @Override // bd.e
    public final boolean b(WebView r5, bd.d r10) {
        switch(this.f5506a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        i r11 = (i) this.f5507b;
        if (r10 == null) goto L23;
        Uri r12 = ((WebResourceRequest) r10.f905a).getUrl();
        if (r12 == null) goto L23;
        j r13 = r11.g;
        if (r13 == null) goto L23;
        String r14 = r12.toString();
        Intrinsics.checkNotNullParameter(r14, "url");
        nh.b r15 = r13.f6235a;
        r15.getClass();
        if (r14 == null) goto L15;
        Uri r16 = Uri.parse(r14);
    L17:
        if (com.bytedance.pia.core.utils.j.z(r16) == false) goto L23;
        r15.f20235c = true;
        if (((nh.d) r15.f) == null) goto L23;
        r15.c();
        r15.f = r15.b(r14);
        goto L23
    L15:
        r16 = null;
    L23:
        if (r5 == null) goto L28;
        r11.getClass();
        if (Intrinsics.areEqual(null, Boolean.TRUE) == false) goto L28;
        return true;
    L28:
        throw new YieldError();
    L5:
        throw new YieldError();
    }

    @Override // bd.e
    public boolean c(WebView r5, wc.f r10) {
        switch(this.f5506a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        ConcurrentHashMap r11 = tl.b.f22138a;
        StringBuilder r12 = new StringBuilder("onRenderProcessGone url: ");
        sj.e r13 = null;
        if (r5 == null) goto L9;
        String r14 = r5.getUrl();
    L10:
        r12.append(r14);
        tl.b.b("com.ivy.ivykit.plugin.impl.web.PluginWebView", r12.toString());
        ol.d r15 = ((com.ivy.ivykit.plugin.impl.web.h) this.f5507b).f9543b;
        if (r15 == null) goto L17;
        if (r10 == null) goto L14;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r13 = new sj.e();
    L14:
        r15.c(r13);
        return true;
    L17:
        throw new YieldError();
    L9:
        r14 = null;
        goto L10
    L5:
        return super.c(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r5, String r10) {
        switch(this.f5506a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.onLoadResource(r5, r10);
        return;
    L6:
        super.onLoadResource(r5, r10);
        i r11 = (i) this.f5507b;
        if (r11.f5526i == false) goto L15;
        if (r10 == null) goto L20;
        com.bytedance.sdk.xbridge.cn.platform.web.b r12 = r11.f5527j;
        if (r12 == null) goto L21;
        Iterator r13 = r12.f7414o.iterator();
    L13:
        if (r13.hasNext() == false) goto L23;
        ((com.bytedance.sdk.xbridge.cn.platform.web.e) r13.next()).m(r10);
        goto L13
    L23:
        return;
    L21:
        return;
    L20:
        return;
    L15:
        com.bytedance.ies.bullet.kit.web.jsbridge.d r14 = r11.f5525h;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.jsbridge.WebJsBridge");
        ce.b r15 = r14.f5553j;
        if (r15 == null) goto L22;
        r15.l(r10);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView r5, String r10) {
        switch(this.f5506a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        super.onPageFinished(r5, r10);
        ol.d r11 = ((com.ivy.ivykit.plugin.impl.web.h) this.f5507b).f9543b;
        if (r11 == null) goto L34;
        r11.f(r5, r10);
        return;
    L34:
        return;
    L8:
        if (r10 == null) goto L27;
        j r12 = ((i) this.f5507b).g;
        if (r12 == null) goto L35;
        Intrinsics.checkNotNullParameter(r10, "url");
        nh.d r13 = (nh.d) r12.f6235a.f;
        if (r13 != null) goto L14;
        return;
    L14:
        if (r13.C.get() == false) goto L17;
        Intrinsics.checkNotNullParameter("[Runtime] call onLoadFinished after release.", "message");
        com.bytedance.pia.core.utils.j.x("[Runtime] call onLoadFinished after release.", null);
        return;
    L17:
        if (r13.B.compareAndSet(false, true) == true) goto L19;
        Intrinsics.checkNotNullParameter("[Runtime] onLoadFinished more than once!", "message");
        com.bytedance.pia.core.utils.j.x("[Runtime] onLoadFinished more than once!", null);
        return;
    L19:
        r13.f20239j.c();
        r13.s.c(".pf", System.currentTimeMillis() - r13.f20252x);
        Iterator r14 = r13.f20248t.iterator();
    L21:
        if (r14.hasNext() == false) goto L39;
        nh.c r15 = (nh.c) r14.next();
        r15.getClass();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        String r16 = "[Runtime] " + r15.c() + " onLoadFinished error:";
        Intrinsics.checkNotNullParameter(r16, "message");
        com.bytedance.pia.core.utils.j.w(4, r16, th);
        goto L21
    L39:
        return;
    L35:
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView r10, String r11, Bitmap r12) {
        Object r5 = this.f5507b;
        int r13 = 0;
        switch(this.f5506a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        super.onPageStarted(r10, r11, r12);
        ol.d r14 = ((com.ivy.ivykit.plugin.impl.web.h) r5).f9543b;
        if (r14 == null) goto L43;
        r14.a(r11);
        return;
    L43:
        return;
    L8:
        i r15 = (i) r5;
        if (r11 == null) goto L28;
        rb.b r16 = r15.f();
        Intrinsics.checkNotNullParameter(r11, "url");
        com.bytedance.ies.bullet.service.base.c r17 = new com.bytedance.ies.bullet.service.base.c(r13);
        r16.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.base.c.class, "clazz");
        r16.b(com.bytedance.ies.bullet.service.base.c.class, new rb.a(r17, 0));
        boolean r18 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "onPageStart url: ".concat(r11), "XWebKit");
        j r19 = r15.g;
        if (r19 == null) goto L30;
        Intrinsics.checkNotNullParameter(r11, "url");
        nh.b r20 = r19.f6235a;
        r20.f20235c = false;
        nh.d r21 = (nh.d) r20.f;
        if (r21 == null) goto L30;
        if (r21.C.get() == false) goto L18;
        Intrinsics.checkNotNullParameter("[Runtime] call onLoadStarted after release.", "message");
        com.bytedance.pia.core.utils.j.x("[Runtime] call onLoadStarted after release.", null);
        goto L30
    L18:
        if (r21.A.compareAndSet(false, true) == true) goto L20;
        Intrinsics.checkNotNullParameter("[Runtime] onLoadStarted more than once!", "message");
        com.bytedance.pia.core.utils.j.x("[Runtime] onLoadStarted more than once!", null);
        goto L30
    L20:
        Iterator r22 = r21.f20248t.iterator();
    L22:
        if (r22.hasNext() == false) goto L30;
        nh.c r110 = (nh.c) r22.next();
        r110.g();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        String r111 = "[Runtime] " + r110.c() + " onLoadStarted error:";
        Intrinsics.checkNotNullParameter(r111, "message");
        com.bytedance.pia.core.utils.j.w(4, r111, th);
    L30:
        if (r15.f5529l != null) goto L32;
        return;
    L32:
        if (Intrinsics.areEqual(r15.d().f, "webcast") == false) goto L45;
        String r23 = androidx.room.jarjarred.org.antlr.runtime.a.p("window.__globalProps=", ';', new Gson().toJson(r15.f5529l));
        if (r10 == null) goto L46;
        r10.evaluateJavascript(r23, null);
        return;
    L46:
        return;
    L45:
        return;
    L28:
        r15.f().c(com.bytedance.ies.bullet.service.base.c.class);
        com.bytedance.ies.bullet.service.base.b.a(2, "onPageStart url: empty", "XWebKit");
        goto L30
    }

    @Override // bd.e, android.webkit.WebViewClient
    public void onReceivedError(WebView r5, WebResourceRequest r10, WebResourceError r11) {
        switch(this.f5506a) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.onReceivedError(r5, r10, r11);
        return;
    L6:
        super.onReceivedError(r5, r10, r11);
        ol.d r12 = ((com.ivy.ivykit.plugin.impl.web.h) this.f5507b).f9543b;
        if (r12 == null) goto L10;
        r12.j(r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView r5, SslErrorHandler r10, SslError r11) {
        switch(this.f5506a) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.onReceivedSslError(r5, r10, r11);
        return;
    L6:
        super.onReceivedSslError(r5, r10, r11);
        ol.d r12 = ((com.ivy.ivykit.plugin.impl.web.h) this.f5507b).f9543b;
    }

    @Override // bd.e, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r5, String r10) {
        switch(this.f5506a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        ConcurrentHashMap r11 = tl.b.f22138a;
        tl.b.b("AIPackageWebView", "PluginWebView shouldInterceptRequest: " + r10);
        throw new YieldError();
    L5:
        return super.shouldInterceptRequest(r5, r10);
    }

    @Override // bd.e, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r5, String r10) {
        switch(this.f5506a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        ol.d r11 = ((com.ivy.ivykit.plugin.impl.web.h) this.f5507b).f9543b;
        if (r11 == null) goto L10;
        if (r11.b(r10) != true) goto L10;
        return true;
    L10:
        throw new YieldError();
    L11:
        i r12 = (i) this.f5507b;
        if (r12.f5526i == false) goto L19;
        com.bytedance.sdk.xbridge.cn.platform.web.b r13 = r12.f5527j;
        if (r13 == null) goto L42;
        Iterator r14 = r13.f7414o.iterator();
    L17:
        if (r14.hasNext() == false) goto L42;
        ((com.bytedance.sdk.xbridge.cn.platform.web.e) r14.next()).n(r10);
    L42:
        throw new YieldError();
    L19:
        com.bytedance.ies.bullet.kit.web.jsbridge.d r15 = r12.f5525h;
        if (r15 == null) goto L42;
        ce.b r16 = r15.f5553j;
        if (r16 == null) goto L42;
        if (TextUtils.isEmpty(r10) == false) goto L26;
    L33:
        boolean r17 = false;
    L34:
        Boolean r18 = Boolean.valueOf(r17);
        if (r17 == true) goto L38;
        r18 = null;
    L38:
        if (r18 == null) goto L42;
        return r18.booleanValue();
    L26:
        if (TextUtils.isEmpty(r16.f1174a) == true) goto L33;
        String r19 = Uri.parse(r10).getScheme().toLowerCase();
        if (r16.f1174a.equals(r19) == false) goto L33;
        if (r16.l(r10) == false) goto L33;
        r17 = true;
        goto L34
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r5, int r10, String r11, String r12) {
        switch(this.f5506a) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.onReceivedError(r5, r10, r11, r12);
        return;
    L6:
        super.onReceivedError(r5, r10, r11, r12);
        ol.d r13 = ((com.ivy.ivykit.plugin.impl.web.h) this.f5507b).f9543b;
        if (r13 == null) goto L10;
        r13.b(r10, r11, r12);
        return;
    }
}
