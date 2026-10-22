package com.bytedance.android.monitorV2.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.salamander.anniex.b0;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements j5.d {
    public static final k d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f3799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3800c;

    static {
        d = new k();
    }

    public k() {
        int r5 = 1;
        int r10 = 0;
        this.f3798a = false;
        this.f3799b = new m();
        this.f3800c = false;
        j5.b r11 = j5.e.f18241a;
        Intrinsics.checkNotNullParameter("web", "name");
        Intrinsics.checkNotNullParameter(this, "action");
        j5.e.f18242b.put("web", this);
        Class<?> r12 = Class.forName("com.bytedance.lynx.webview.TTWebSdk");     // Catch: Throwable -> L5
        r12.getDeclaredMethod("registerGlobalWebViewHandler", new Class[]{InvocationHandler.class}).invoke(null, new Object[]{new d(2)});     // Catch: Throwable -> L5
        r12.getDeclaredMethod("registerGlobalWebViewHandler", new Class[]{InvocationHandler.class}).invoke(null, new Object[]{new d(r5)});     // Catch: Throwable -> L5
        r12.getDeclaredMethod("registerGlobalWebViewHandler", new Class[]{InvocationHandler.class}).invoke(null, new Object[]{new d(r10)});     // Catch: Throwable -> L5
        this.f3798a = true;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        this.f3798a = false;
        mn.h.g("default_handle", th);
    }

    @Override // j5.d
    public final void a(String r5, Object r10) {
    }

    @Override // j5.d
    public final void b(View r5, String r10, JSONObject r11) {
        if ((r5 instanceof WebView) == false) goto L22;
        WebView r12 = (WebView) r5;
        d5.b.f("WebViewMonitorHelper", "handleNativeInfo: eventTYpe: ".concat(r10));
        Intrinsics.checkNotNullParameter(r10, "eventType");
        com.bytedance.android.monitorV2.event.a r13 = new com.bytedance.android.monitorV2.event.a(r10);
        r13.e();
    L9:
        th = move-exception;
        r13.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", th);
        return;
    L6:
        if (p() == true) goto L11;
        r13.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L9
        return;
    L11:
        if (r12 != null) goto L15;
        r13.b(HybridEvent$TerminateType.f3541b);     // Catch: Throwable -> L9
        return;
    L15:
        if (this.f3799b.e(r12) == true) goto L18;
        r13.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L9
        return;
    L18:
        h(r12, r13, r11);     // Catch: Throwable -> L9
        return;
    L22:
        d5.b.e("WebViewMonitorHelper", "handleNativeInfo: view not match WebView");
    }

    @Override // j5.d
    public final void c(View r5, x4.c r10) {
        if ((r5 instanceof WebView) == false) goto L6;
        l((WebView) r5, r10);
        return;
    L6:
        d5.b.e("WebViewMonitorHelper", "customReport: view not match WebView");
    }

    public final void d(WebView r5) {
    L13:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L4:
        if (p() == false) goto L18;
        m r10 = this.f3799b;     // Catch: Throwable -> L13
        r10.getClass();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r5, "webView");     // Catch: Throwable -> L13
        i r11 = r10.d(r5);     // Catch: Throwable -> L13
        r11.e(true);     // Catch: Throwable -> L13
        r11.c(WebViewLifeState.d);     // Catch: Throwable -> L13
        WebView r12 = r11.a();     // Catch: Throwable -> L13
        if (r12 == null) goto L11;
        g r13 = r11.f3782h;     // Catch: Throwable -> L13
        if (r13 == null) goto L11;
        Intrinsics.checkNotNullParameter(r12, "webView");     // Catch: Throwable -> L13
        r12.removeOnAttachStateChangeListener(r13);     // Catch: Throwable -> L13
    L11:
        String r14 = m.b(r5);     // Catch: Throwable -> L13
        r10.d.remove(r14);     // Catch: Throwable -> L13
        r10.e.remove(r14);     // Catch: Throwable -> L13
        r10.f3804b.remove(r14);     // Catch: Throwable -> L13
        return;
    }

    public final void e(WebView r5, int r10) {
        m r11 = this.f3799b;
    L16:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L4:
        if (p() == false) goto L24;
        if (r5 == null) goto L25;
    L13:
        th = move-exception;
        mn.h.g("default_handle", th);     // Catch: Throwable -> L16
        return;
    L9:
        if (r11.e(r5) == false) goto L23;
        r11.getClass();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r5, "webView");     // Catch: Throwable -> L13
        r11.d(r5).n(r10);     // Catch: Throwable -> L13
    L26:
        return;
    L23:
        return;
    L25:
        return;
    }

    public final void f(WebView r10, RenderProcessGoneDetail r11) {
        m r5 = this.f3799b;
        Intrinsics.checkNotNullParameter("nativeError", "eventType");
        com.bytedance.android.monitorV2.event.a r12 = new com.bytedance.android.monitorV2.event.a("nativeError");
        r12.e();
    L7:
        th = move-exception;
        r12.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", th);
        return;
    L4:
        if (p() == true) goto L9;
        r12.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L9:
        if (r10 == null) goto L36;
        if (r11 == null) goto L36;
        if (TextUtils.isEmpty(r10.getUrl()) == true) goto L36;
        if (r5.e(r10) == true) goto L18;
        r12.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L18:
        r5.getClass();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r10, "webView");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r11, "detail");     // Catch: Throwable -> L7
        i r13 = r5.d(r10);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r11, "webdetail");     // Catch: Throwable -> L7
        WebView r14 = r13.a();     // Catch: Throwable -> L7
        if (r14 == null) goto L30;
        String r15 = r14.getUrl();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r15) == true) goto L30;
        if (r15 == null) goto L30;
        if (r13.f != null) goto L29;
        r13.f = new c(r13, r15);     // Catch: Throwable -> L7
    L29:
        d5.b.c("WebViewDataManager", "handleRenderProcessGone: ");     // Catch: Throwable -> L7
    L30:
        r5.d.remove(m.b(r10));     // Catch: Throwable -> L7
        r5.e.remove(m.b(r10));     // Catch: Throwable -> L7
        if (r11.didCrash() == false) goto L33;
        String r16 = "cause by crash";
    L34:
        h(r10, r12, cl.a.f(r10.getUrl(), null, -10000, r16, null));     // Catch: Throwable -> L7
        g(r10, r12, -10000, r16);     // Catch: Throwable -> L7
        return;
    L33:
        r16 = "cause by system";
    L36:
        r12.b(HybridEvent$TerminateType.f3541b);     // Catch: Throwable -> L7
    }

    public final void g(WebView r5, com.bytedance.android.monitorV2.event.a r10, int r11, String r12) {
        m r13 = this.f3799b;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "webView");
        Intrinsics.checkNotNullParameter(r10, "event");
        i r14 = r13.d(r5);
        Intrinsics.checkNotNullParameter(r10, "event");
        c r15 = r14.f;
        if (r15 == null) goto L9;
        Intrinsics.checkNotNullParameter(r10, "event");
        if (r12 != null) goto L7;
        r12 = "";
    L7:
        r15.f3759j.t(r10, r11, r12);
        return;
    }

    public final void h(WebView r5, com.bytedance.android.monitorV2.event.a r10, JSONObject r11) {
        m r12 = this.f3799b;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r5, "webView");
        Intrinsics.checkNotNullParameter(r10, "event");
        i r13 = r12.d(r5);
        Intrinsics.checkNotNullParameter(r10, "event");
        c r14 = r13.f;
        if (r14 == null) goto L5;
        r14.a(r10, r11);
        Unit r15 = Unit.INSTANCE;
    L6:
        if (r15 != null) goto L9;
        r10.b(HybridEvent$TerminateType.e);
        return;
    L9:
        return;
    L5:
        r15 = null;
        goto L6
    }

    public final void i(WebView r5, b0 r10) {
        d5.b.f("WebViewMonitorHelper", "handleJSBError: " + d5.b.a(r5));
        Intrinsics.checkNotNullParameter("jsbError", "eventType");
        com.bytedance.android.monitorV2.event.a r11 = new com.bytedance.android.monitorV2.event.a("jsbError");
        r11.e();
    L7:
        th = move-exception;
        r11.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", th);
        return;
    L4:
        if (p() == true) goto L9;
        r11.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L9:
        if (r5 != null) goto L13;
        r11.b(HybridEvent$TerminateType.f3541b);     // Catch: Throwable -> L7
        return;
    L13:
        if (this.f3799b.e(r5) == true) goto L16;
        r11.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L16:
        com.bytedance.android.monitorV2.h.e().a().d().getClass();     // Catch: Throwable -> L7
        if (Switches.e.f3600a == true) goto L20;
        r11.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L20:
        h(r5, r11, cl.a.e(r10));     // Catch: Throwable -> L7
        g(r5, r11, r10.f7246b, (String) r10.f7247c);     // Catch: Throwable -> L7
    }

    public final void j(WebView r5, String r10) {
        m r11 = this.f3799b;
    L14:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L4:
        if (p() == true) goto L7;
        return;
    L7:
        if (r11.e(r5) == true) goto L10;
        return;
    L10:
        if (r10.contains("javascript:") == true) goto L21;
        r11.getClass();     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r5, "webView");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r10, "url");     // Catch: Throwable -> L14
        r11.d(r5).k(r10);     // Catch: Throwable -> L14
        return;
    }

    public final void k(WebView r5, String r10, JSONObject r11, JSONObject r12) {
        boolean r13 = true;
        com.bytedance.ies.web.jsbridge2.l r14 = new com.bytedance.ies.web.jsbridge2.l("pia_" + r10, 1);     // Catch: Throwable -> L10
        r14.f6292h = r11;     // Catch: Throwable -> L10
        r14.f6293i = r12;     // Catch: Throwable -> L10
        r14.f6294j = null;     // Catch: Throwable -> L10
        r14.f6296l = null;     // Catch: Throwable -> L10
        r14.b(3);     // Catch: Throwable -> L10
        x4.c r15 = r14.a();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r15, "customInfo");     // Catch: Throwable -> L10
        com.bytedance.android.monitorV2.event.e r16 = new com.bytedance.android.monitorV2.event.e(r15);     // Catch: Throwable -> L10
        boolean r17 = p();     // Catch: Throwable -> L10
        m r18 = this.f3799b;
        if (r17 == true) goto L7;
    L12:
        r16.d(r13, HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L10
        if (r13 == true) goto L23;
        if (r5 != null) goto L18;
        com.bytedance.android.monitorV2.dataprocessor.b r19 = com.bytedance.android.monitorV2.c.f3517a;     // Catch: Throwable -> L10
        com.bytedance.android.monitorV2.c.d(r16, Boolean.TRUE);     // Catch: Throwable -> L10
        return;
    L18:
        r18.getClass();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r5, "webView");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r16, "customEvent");     // Catch: Throwable -> L10
        r18.d(r5).i(r16);     // Catch: Throwable -> L10
        return;
    L23:
        return;
    L7:
        if (r18.e(r5) == false) goto L12;
        r13 = false;
    L10:
        th = move-exception;
        mn.h.g("default_handle", th);
    }

    public final void l(WebView r5, x4.c r10) {
        com.bytedance.android.monitorV2.event.b r11 = new com.bytedance.android.monitorV2.event.b(r10);
        if (p() == true) goto L6;
        r11.b(HybridEvent$TerminateType.f3540a);
        return;
    L6:
        if (r5 != null) goto L9;
        com.bytedance.android.monitorV2.dataprocessor.b r12 = com.bytedance.android.monitorV2.c.f3517a;
        com.bytedance.android.monitorV2.c.d(r11, Boolean.TRUE);
        return;
    L9:
        m r13 = this.f3799b;
        if (r13.e(r5) == true) goto L13;
        r11.b(HybridEvent$TerminateType.f3540a);
        return;
    L13:
        Intrinsics.checkNotNullParameter(r5, "webView");
        Intrinsics.checkNotNullParameter(r11, "customEvent");
        r13.d(r5).i(r11);
    }

    public final void m(WebView r5, x4.e r10) {
        d5.b.f("WebViewMonitorHelper", "handleJSBInfo: " + d5.b.a(r5));
        Intrinsics.checkNotNullParameter("jsbPerf", "eventType");
        com.bytedance.android.monitorV2.event.a r11 = new com.bytedance.android.monitorV2.event.a("jsbPerf");
        r11.e();
    L7:
        th = move-exception;
        r11.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", th);
        return;
    L4:
        if (p() == true) goto L9;
        r11.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L9:
        if (r5 != null) goto L13;
        r11.b(HybridEvent$TerminateType.f3541b);     // Catch: Throwable -> L7
        return;
    L13:
        if (this.f3799b.e(r5) == true) goto L16;
        r11.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L16:
        com.bytedance.android.monitorV2.h.e().a().d().getClass();     // Catch: Throwable -> L7
        if (Switches.e.f3600a == true) goto L20;
        r11.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L20:
        h(r5, r11, cl.a.g(r10));     // Catch: Throwable -> L7
    }

    public final void n(SSWebView r5) {
        d5.b.f("WebViewMonitorHelper", r5.getClass().getSimpleName() + " attachToWindow, container: " + r5.getContext().getClass().getName() + ", isTTWebEnable: " + v());
        boolean r10 = v();
        m r11 = this.f3799b;
        if (r10 == true) goto L5;
    L23:
    L20:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L8:
        if (p() == true) goto L11;
        return;
    L11:
        if (r11.e(r5) == false) goto L27;
        Intrinsics.checkNotNullParameter(r5, "webView");     // Catch: Throwable -> L20
        i r12 = r11.d(r5);     // Catch: Throwable -> L20
        if (r12.f3782h != null) goto L16;
        d5.b.e("WebViewDataManager", "handleViewCreated not work, onAttachedToWindow invoked");     // Catch: Throwable -> L20
        r12.j();     // Catch: Throwable -> L20
        r12.c(WebViewLifeState.f3744b);     // Catch: Throwable -> L20
    L16:
        WebView r13 = r12.a();     // Catch: Throwable -> L20
        if (r13 == null) goto L25;
        j5.b.e(r13, new h(r12));     // Catch: Throwable -> L20
        return;
    L25:
        return;
    L27:
        return;
    L5:
        if (r11.f(r5) == false) goto L23;
    }

    public final void o(String r5, String r10, String r11, LinkedHashMap r12) {
        m r13 = this.f3799b;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "eventType");
        Intrinsics.checkNotNullParameter(r10, "engineHash");
        Intrinsics.checkNotNullParameter(r11, "url");
        i r14 = (i) r13.d.get(r10);
        if (r14 == null) goto L46;
        Intrinsics.checkNotNullParameter(r5, "eventType");
        Intrinsics.checkNotNullParameter(r11, "url");
        s r15 = (s) r14.f3793t.getValue();
        c r16 = r14.f;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        if (Intrinsics.areEqual(r15.f3820a, r15.f3822c) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r5, "anniex_ssp_pv") == false) goto L14;
        ((LinkedBlockingDeque) r15.f3821b.getValue()).add(r11);
        m5.a r17 = new m5.a();     // Catch: Exception -> L11
        r15.a(r17, r11, r16);     // Catch: Exception -> L11
        r17.f19981j = r15.d;     // Catch: Exception -> L11
        Method r18 = u4.d.f22248a;     // Catch: Exception -> L11
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L11
        r17.m(r19);     // Catch: Exception -> L11
        u4.d.c("anniex_ssp_pv", r19);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        if (Intrinsics.areEqual(r5, "anniex_ssp_res_loader_info") == false) goto L49;
        m5.a r20 = new m5.a();     // Catch: Exception -> L21
        r15.a(r20, r11, r16);     // Catch: Exception -> L21
        if (r12 == null) goto L38;
        Object r21 = r12.get("res_format_src");     // Catch: Exception -> L21
        if (r21 == null) goto L23;
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L21
        r20.f19988q = (String) r21;     // Catch: Exception -> L21
    L23:
        Object r22 = r12.get("res_full_src");     // Catch: Exception -> L21
        if (r22 == null) goto L26;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L21
        r20.f19989r = (String) r22;     // Catch: Exception -> L21
    L26:
        Object r23 = r12.get("res_from");     // Catch: Exception -> L21
        if (r23 == null) goto L29;
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L21
        r20.s = (String) r23;     // Catch: Exception -> L21
    L29:
        Object r24 = r12.get("res_size");     // Catch: Exception -> L21
        if (r24 == null) goto L32;
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L21
        r20.f19990t = (Integer) r24;     // Catch: Exception -> L21
    L32:
        Object r25 = r12.get("res_type");     // Catch: Exception -> L21
        if (r25 == null) goto L35;
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L21
        r20.f19991u = (String) r25;     // Catch: Exception -> L21
    L35:
        Object r26 = r12.get("request_method");     // Catch: Exception -> L21
        if (r26 == null) goto L38;
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L21
        r20.f19992v = (String) r26;     // Catch: Exception -> L21
    L38:
        r20.f19981j = r15.e;     // Catch: Exception -> L21
        Method r27 = u4.d.f22248a;     // Catch: Exception -> L21
        JSONObject r28 = new JSONObject();     // Catch: Exception -> L21
        r20.m(r28);     // Catch: Exception -> L21
        u4.d.c("anniex_ssp_res_loader_info", r28);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L49:
        return;
    }

    public final boolean p() {
        com.bytedance.android.monitorV2.h.e().a().d().getClass();
        if (Switches.f3587b.f3600a == false) goto L7;
        com.bytedance.android.monitorV2.h.e().a().d().getClass();
        if (Switches.f3588c.f3600a == false) goto L7;
        boolean r5 = true;
    L9:
        if (this.f3800c == r5) goto L11;
        d5.b.f("WebViewMonitorHelper", "monitor enabled: " + r5);
        this.f3800c = r5;
    L11:
        return r5;
    L7:
        r5 = false;
        goto L9
    }

    public final void q() {
        Intrinsics.checkNotNullParameter("nativeError", "eventType");
        com.bytedance.android.monitorV2.event.a r5 = new com.bytedance.android.monitorV2.event.a("nativeError");
        r5.e();
    L7:
        th = move-exception;
        r5.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", th);
        return;
    L4:
        if (p() == true) goto L9;
        r5.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L9:
        r5.b(HybridEvent$TerminateType.f3541b);     // Catch: Throwable -> L7
    }

    public final void r(WebView r5) {
        m r10 = this.f3799b;
    L11:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L4:
        if (p() == true) goto L7;
        return;
    L7:
        if (r10.e(r5) == false) goto L17;
        r10.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r5, "webView");     // Catch: Throwable -> L11
        i r11 = r10.d(r5);     // Catch: Throwable -> L11
        r11.f();     // Catch: Throwable -> L11
        r11.g(false);     // Catch: Throwable -> L11
        return;
    }

    public final void s(WebView r10, WebResourceRequest r11, WebResourceError r12) {
        Intrinsics.checkNotNullParameter("nativeError", "eventType");
        com.bytedance.android.monitorV2.event.a r5 = new com.bytedance.android.monitorV2.event.a("nativeError");
        r5.e();
    L7:
        th = move-exception;
        r5.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", th);
        return;
    L4:
        if (p() == true) goto L9;
        r5.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L9:
        if (r10 == null) goto L29;
        if (r11 == null) goto L29;
        if (r12 == null) goto L29;
        if (r11.isForMainFrame() == true) goto L19;
        Uri r13 = r11.getUrl();     // Catch: Throwable -> L7
        if (r13 == null) goto L19;
        String r14 = r13.getPath();     // Catch: Throwable -> L7
        if (r14 == null) goto L19;
        boolean r15 = r14.endsWith("favicon.ico");     // Catch: Throwable -> L7
    L20:
        if (r15 == false) goto L24;
        r5.b(HybridEvent$TerminateType.e);     // Catch: Throwable -> L7
        return;
    L24:
        if (this.f3799b.e(r10) == true) goto L27;
        r5.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L27:
        h(r10, r5, cl.a.f(r11.getUrl().toString(), Boolean.valueOf(r11.isForMainFrame()), Integer.valueOf(r12.getErrorCode()), r12.getDescription().toString(), 0));     // Catch: Throwable -> L7
        g(r10, r5, r12.getErrorCode(), r12.getDescription().toString());     // Catch: Throwable -> L7
        return;
    L19:
        r15 = false;
    L29:
        r5.b(HybridEvent$TerminateType.f3541b);     // Catch: Throwable -> L7
    }

    public final void t(WebView r10, WebResourceRequest r11, WebResourceResponse r12) {
        Intrinsics.checkNotNullParameter("nativeError", "eventType");
        com.bytedance.android.monitorV2.event.a r5 = new com.bytedance.android.monitorV2.event.a("nativeError");
        r5.e();
    L7:
        th = move-exception;
        r5.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", th);
        return;
    L4:
        if (p() == true) goto L9;
        r5.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L9:
        if (r10 == null) goto L29;
        if (r11 == null) goto L29;
        if (r12 == null) goto L29;
        if (r11.isForMainFrame() == true) goto L19;
        Uri r13 = r11.getUrl();     // Catch: Throwable -> L7
        if (r13 == null) goto L19;
        String r14 = r13.getPath();     // Catch: Throwable -> L7
        if (r14 == null) goto L19;
        boolean r15 = r14.endsWith("favicon.ico");     // Catch: Throwable -> L7
    L20:
        if (r15 == false) goto L24;
        r5.b(HybridEvent$TerminateType.e);     // Catch: Throwable -> L7
        return;
    L24:
        if (this.f3799b.e(r10) == true) goto L27;
        r5.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L27:
        h(r10, r5, cl.a.f(r11.getUrl().toString(), Boolean.valueOf(r11.isForMainFrame()), 0, r12.getReasonPhrase(), Integer.valueOf(r12.getStatusCode())));     // Catch: Throwable -> L7
        g(r10, r5, r12.getStatusCode(), r12.getReasonPhrase());     // Catch: Throwable -> L7
        return;
    L19:
        r15 = false;
    L29:
        r5.b(HybridEvent$TerminateType.f3541b);     // Catch: Throwable -> L7
    }

    public final void u(WebView r5, String r10) {
        m r11 = this.f3799b;
    L8:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L4:
        if (r11.e(r5) == false) goto L13;
        r11.getClass();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r5, "webView");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r10, "url");     // Catch: Throwable -> L8
        r11.d(r5).l(r10);     // Catch: Throwable -> L8
        return;
    }

    public final boolean v() {
        if (this.f3798a == false) goto L8;
        com.bytedance.android.monitorV2.h.e().a().d().getClass();
        if (Switches.f3592k.f3600a == false) goto L10;
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public final void w(WebView r5) {
    L9:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L3:
        if (p() == false) goto L14;
        if (r5 == null) goto L15;
        m r10 = this.f3799b;     // Catch: Throwable -> L9
        r10.getClass();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r5, "webView");     // Catch: Throwable -> L9
        r10.d(r5).o();     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    public final void x(WebView r5, String r10) {
        m r11 = this.f3799b;
        Intrinsics.checkNotNullParameter("navigationStart", "eventType");
        com.bytedance.android.monitorV2.event.a r12 = new com.bytedance.android.monitorV2.event.a("navigationStart");
        r12.e();     // Catch: Throwable -> L10
        if (r5 != null) goto L7;
        return;
    L7:
        if (r11.e(r5) == true) goto L12;
        r12.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L10
        return;
    L12:
        r12.f.f22973a = r10;     // Catch: Throwable -> L10
        r11.getClass();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r5, "webView");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r12, "event");     // Catch: Throwable -> L10
        r11.d(r5).m(r12);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        r12.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", th);
    }

    @Override // j5.d
    public final void a(View r10, String r11, x4.a r12, j5.c r13) {
        Intrinsics.checkNotNullParameter("containerError", "eventType");
        com.bytedance.android.monitorV2.event.a r5 = new com.bytedance.android.monitorV2.event.a("containerError");
        r5.e();
    L7:
        th = move-exception;
        r5.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", th);
        return;
    L4:
        if (p() == true) goto L9;
        r5.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L7
        return;
    L9:
        String r14 = r13.f18239b;
        int r15 = r13.f18238a;
        if (r10 != null) goto L12;
        r5.f3560h = r12;     // Catch: Throwable -> L7
        r5.f3551n = new x4.a(1, MapsKt.mapOf(new Pair[]{TuplesKt.to("container_load_error_code", Integer.valueOf(r15)), TuplesKt.to("container_load_error_msg", r14)}));     // Catch: Throwable -> L7
        m5.b r16 = new m5.b();     // Catch: Throwable -> L7
        r16.f = r13.f18240c;     // Catch: Throwable -> L7
        r16.f22975c = "web";     // Catch: Throwable -> L7
        sk.a.c(r11, null, r16);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r16, "<set-?>");     // Catch: Throwable -> L7
        r5.f = r16;     // Catch: Throwable -> L7
        r5.f3550m = new x4.b();     // Catch: Throwable -> L7
        com.bytedance.android.monitorV2.dataprocessor.b r17 = com.bytedance.android.monitorV2.c.f3517a;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r5, "commonEvent");     // Catch: Throwable -> L7
        com.bytedance.android.monitorV2.c.b(r5, Boolean.TRUE);     // Catch: Throwable -> L7
        return;
    L12:
        if ((r10 instanceof WebView) == false) goto L20;
        r5.f3551n = new x4.a(1, MapsKt.mapOf(new Pair[]{TuplesKt.to("container_load_error_code", Integer.valueOf(r15)), TuplesKt.to("container_load_error_msg", r14)}));     // Catch: Throwable -> L7
        h((WebView) r10, r5, null);     // Catch: Throwable -> L7
        return;
    }

    @Override // j5.d
    public final x4.d a(View r5) {
        if (r5 == null) goto L14;
        if ((r5 instanceof WebView) == false) goto L12;
        WebView r10 = (WebView) r5;
        m r11 = this.f3799b;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "webView");
        c r12 = r11.d(r10).f;
        if (r12 == null) goto L10;
        x4.d r13 = r12.f3759j;
        if (r13 == null) goto L10;
        return r13;
    L10:
        return new x4.d(new x4.h());
    L12:
        return new x4.d(new x4.h());
    L14:
        return new x4.d(new x4.h());
    }
}
