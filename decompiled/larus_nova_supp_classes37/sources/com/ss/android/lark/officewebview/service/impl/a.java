package com.ss.android.lark.officewebview.service.impl;

import android.view.View;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.officesdk.di.core.deps.webview.PlatformPluginVersion;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.webview_api.adapter.OfficeRenderInWebViewServiceAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import otb.i;
import otb.m;
import otb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements oxb.e {
    public final exb.b a;

    /* JADX INFO: renamed from: com.ss.android.lark.officewebview.service.impl.a$a, reason: collision with other inner class name */
    public static final class C0080a {
    }

    static {
    }

    @Override // oxb.e
    public final boolean d() {
        exb.b r0 = this.a;
        r0.a.getClass();
        exb.a.c("PlatformPluginManager", "switchMixRender");
        otb.e r2 = r0.c;
        if (r2 == null) goto L5;
        r2.isFeatureSupport("mixrender_sandwich_mode");
        HashMap<PlatformPluginVersion, Boolean> r4 = r0.e;
        PlatformPluginVersion r5 = PlatformPluginVersion.SANDWICH;
        Boolean r6 = Boolean.FALSE;
        r4.put(r5, r6);
        r2.isFeatureSupport("mixrender_embed_mode");
        r0.e.put(PlatformPluginVersion.EMBED, r6);
        r0.e.put(PlatformPluginVersion.SANDWICH_EMBED, false);
    L5:
        r0.a();
        r0.a.getClass();
        exb.a.c("PlatformPluginManager", "switchMixRender true result = false , isSupportMixSandwich = false , isSupportMixEmbed = false, isSupportSandwichEmbed = false");
        return false;
    }

    @Override // oxb.e
    public final exb.a getLogger() {
        return this.a.a;
    }

    @Override // oxb.e
    public final Map<PlatformPluginVersion, Boolean> p() {
        return new HashMap(this.a.e);
    }

    public a() {
        this.a = new exb.b();
    }

    @Override // oxb.e
    public final void G(OfficeRenderInWebViewServiceAdapter.a r6) {
        Intrinsics.checkNotNullParameter(r6, "factory");
        exb.d r0 = this.a.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "view");
        r0.a.d("PlatformViewRegistry", r6.viewId(), "register PlatformViewFactory");
        String r1 = r6.viewId();
        if (PatternProtector.compile("^[-\\+]?[\\d]*$").matcher(r1).matches() == true) goto L5;
        r0.a.getClass();
        exb.a.a("PlatformViewRegistry", "register view id is not numeric");
        return;
    L5:
        Map<String, i> r2 = r0.c;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(r6.viewId(), r6);
        exb.e r7 = r0.b(r6.viewId());
        if (r7 == null) goto L10;
        r7.g(true);
        return;
    }

    @Override // oxb.e
    public final void J(OfficeWebView r4) {
        Intrinsics.checkNotNullParameter(r4, "webView");
        exb.b r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "webView");
        exb.a r0 = r1.a;
        r0.getClass();
        r0.a = "";
        r1.a.getClass();
        exb.a.c("PlatformPluginManager", "initService");
        r1.d = new gxb.d(r4.getContext(), r1, r4);
        Lazy<n> r2 = TTWebViewUtil.a;
        otb.e r5 = TTWebViewUtil.a.a(r4);
        r1.c = r5;
        hxb.a r3 = new hxb.a(r1);
        ((m) r5).getClass();
        Intrinsics.checkNotNullParameter(r3, "factory");
        Intrinsics.checkNotNullParameter(new fxb.a(r1), "factory");
        r1.a();
    }

    @Override // oxb.e
    public final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "viewId");
        exb.b r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "viewId");
        gxb.d r2 = r1.d;
        if (r2 == null) goto L15;
        Intrinsics.checkNotNullParameter(r6, "viewId");
        r2.b.getClass();
        exb.a.c("OverlayPlatformViewManager", "removeNativeView viewId=" + r6);
        exb.d r3 = r2.a.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "viewId");
        otb.c r0 = r3.b.get(r6);
        if (r0 != null) goto L8;
        r2.b.getClass();
        exb.a.a("OverlayPlatformViewManager", "removeNativeView cannot find plugin");
        return;
    L8:
        if ((r0 instanceof gxb.e) == false) goto L10;
        gxb.e r4 = (gxb.e) r0;
    L11:
        if (r4 == null) goto L13;
        r4.destroy();
    L13:
        r2.a.b.a(r6);
        return;
    L10:
        r4 = null;
        goto L11
    }

    @Override // oxb.e
    public final otb.c c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "viewId");
        exb.d r1 = this.a.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "viewId");
        return r1.b.get(r3);
    }

    @Override // oxb.e
    public final exb.e f(String r2) {
        return this.a.b.b(r2);
    }

    @Override // oxb.e
    public final i g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewId");
        return (i) ((ConcurrentHashMap) this.a.b.c).get(r2);
    }

    @Override // oxb.e
    public final void h(String r5) {
        Intrinsics.checkNotNullParameter(r5, "viewId");
        exb.d r1 = this.a.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "viewId");
        r1.a.d("PlatformViewRegistry", r5, "unregister PlatformViewFactory");
        ((ConcurrentHashMap) r1.c).remove(r5);
        exb.e r0 = r1.b(r5);
        if (r0 == null) goto L6;
        r0.g(false);
        exb.e r6 = r1.d.remove(r5);
        return;
    }

    @Override // oxb.e
    public final void w(otb.b r3) {
        Intrinsics.checkNotNullParameter(r3, "monitor");
        exb.b r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "monitor");
        exb.d r2 = r1.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "monitor");
        ((ArrayList) r2.e).remove(r3);
    }

    @Override // oxb.e
    public final void x(otb.b r3) {
        Intrinsics.checkNotNullParameter(r3, "monitor");
        exb.b r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "monitor");
        exb.d r2 = r1.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "monitor");
        ((ArrayList) r2.e).add(r3);
    }

    @Override // oxb.e
    public final void I(String r12, gxb.c r13) {
        Intrinsics.checkNotNullParameter(r12, "viewId");
        Intrinsics.checkNotNullParameter(r13, "params");
        exb.b r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r12, "viewId");
        Intrinsics.checkNotNullParameter(r13, "params");
        gxb.d r3 = r2.d;
        if (r3 == null) goto L22;
        Intrinsics.checkNotNullParameter(r12, "viewId");
        Intrinsics.checkNotNullParameter(r13, "params");
        r3.b.d("OverlayPlatformViewManager", r12, "addNativeView viewId=" + r12 + ", params=" + r13);
        i r0 = (i) ((ConcurrentHashMap) r3.a.b.c).get(r12);
        if (r0 != null) goto L7;
        r3.b.getClass();
        exb.a.a("OverlayPlatformViewManager", "addNativeView cannot find platform view, viewId=" + r12);
        return;
    L7:
        gxb.e r4 = new gxb.e(r12, r0, r3.a.b, r3.c);
        Intrinsics.checkNotNullParameter(r13, "params");
        exb.a r14 = r4.e;
        String r1 = "addNativeView, viewId=" + r4.a;
        r14.getClass();
        exb.a.c("OverlayPlatformViewPlugin", r1);
        r4.g = r13;
        View r5 = r4.b.a(r4.d);
        r4.f = r5;
        if (r5 == null) goto L10;
        r4.d.addView(r5, new gxb.a.C0142a(r13.a, r13.b, r13.c, r13.d, r13.e, r13.f));
    L11:
        exb.d r15 = r3.a.b;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r4, "platformViewPlugin");
        r15.a.getClass();
        exb.a.c("PlatformViewRegistry", "regPlugin");
        String r6 = r4.a;
        if (r6 == null) goto L14;
        r15.b.put(r6, r4);
    L16:
        if (r4.b != null) goto L18;
        exb.a r7 = r15.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter("PlatformViewRegistry", "tag");
        Intrinsics.checkNotNullParameter("platformViewFactory is null, you must call register first", "msg");
        exb.a.a(r7.e("PlatformViewRegistry", r6), "platformViewFactory is null, you must call register first");
    L18:
        exb.e r16 = r15.b(r6);
        if (r16 == null) goto L24;
        r16.h(true);
        return;
    L24:
        return;
    L14:
        r15.a.getClass();
        exb.a.a("PlatformViewRegistry", "create TTWebViewPlugin error, viewid is null");
        goto L16
    L10:
        exb.a r17 = r4.e;
        String r8 = "addNativeView createNativeView returns null, viewId=" + r4.a;
        r17.getClass();
        exb.a.a("OverlayPlatformViewPlugin", r8);
        goto L11
    }

    @Override // oxb.e
    public final void L(String r10, gxb.c r11) {
        Intrinsics.checkNotNullParameter(r10, "viewId");
        Intrinsics.checkNotNullParameter(r11, "params");
        exb.b r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r10, "viewId");
        Intrinsics.checkNotNullParameter(r11, "params");
        gxb.d r3 = r2.d;
        if (r3 == null) goto L20;
        Intrinsics.checkNotNullParameter(r10, "viewId");
        Intrinsics.checkNotNullParameter(r11, "params");
        r3.b.d("OverlayPlatformViewManager", r10, "updateNativeView viewId=" + r10 + ", params=" + r11);
        exb.d r4 = r3.a.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r10, "viewId");
        otb.c r12 = r4.b.get(r10);
        if (r12 != null) goto L8;
        r3.b.getClass();
        exb.a.a("OverlayPlatformViewManager", "updateNativeView cannot find plugin");
        return;
    L8:
        if ((r12 instanceof gxb.e) == false) goto L10;
        gxb.e r13 = (gxb.e) r12;
    L11:
        if (r13 == null) goto L22;
        Intrinsics.checkNotNullParameter(r11, "params");
        exb.a r0 = r13.e;
        String r1 = "updateNativeView, viewId=" + r13.a;
        r0.getClass();
        exb.a.c("OverlayPlatformViewPlugin", r1);
        if (Intrinsics.areEqual(r13.g, r11) == false) goto L15;
        r13.e.getClass();
        exb.a.c("OverlayPlatformViewPlugin", "updateNativeView, same params");
        return;
    L15:
        r13.g = r11;
        View r5 = r13.f;
        if (r5 == null) goto L18;
        r5.setLayoutParams(new gxb.a.C0142a(r11.a, r11.b, r11.c, r11.d, r11.e, r11.f));
        return;
    L18:
        exb.a r14 = r13.e;
        String r15 = "updateNativeView nativeView null, viewId=" + r13.a;
        r14.getClass();
        exb.a.a("OverlayPlatformViewPlugin", r15);
        return;
    L22:
        return;
    L10:
        r13 = null;
        goto L11
    }
}
