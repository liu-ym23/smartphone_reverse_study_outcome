package com.ivy.ivykit.plugin.impl.render;

import android.net.Uri;
import android.view.View;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f9525a;

    public e(f r5) {
        this.f9525a = r5;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void b() {
        tl.b.a("onOpen");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void f() {
        tl.b.a("onBulletViewCreate");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final vc.c getLynxClient() {
        return new d(this.f9525a);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void n() {
        tl.b.a("onBulletViewRelease");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void o(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        tl.b.c("PluginView", "onKitViewCreate");
        f r11 = this.f9525a;
        ol.c r12 = r11.f21519a;
        if (r12 == null) goto L5;
        r12.d(r11.f9526b);
    L5:
        if (r10 == null) goto L14;
        View r13 = r10.a();
        if ((r13 instanceof LynxView) == false) goto L9;
        LynxView r14 = (LynxView) r13;
    L10:
        if (r14 == null) goto L15;
        String r15 = k5.d.f18613r;
        Intrinsics.checkNotNullParameter(r15, "bid");
        com.obric.oui.constraintlayout.core.widgets.analyzer.f r16 = new com.obric.oui.constraintlayout.core.widgets.analyzer.f(r15, new com.bytedance.android.monitorV2.webview.a());
        String r17 = k5.d.f18613r;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.f12569c = r17;
        r16.f12567a = true;
        Intrinsics.checkNotNullParameter("perf_destroy", "<set-?>");
        r16.f = "perf_destroy";
        r16.e = new m.b(8);
        qo.a.h(r14, r16);
        return;
    L15:
        return;
    L9:
        r14 = null;
        goto L10
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void p(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        tl.b.a("onLoadUriSuccess");
        f r11 = this.f9525a;
        if (r11.f21519a == null) goto L6;
        Intrinsics.checkNotNullParameter(r11.f9526b, "view");
        return;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void q(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        tl.b.c("PluginView", "onFallback");
        if (this.f9525a.f21519a == null) goto L6;
        Intrinsics.checkNotNullParameter(r10, "e");
        return;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void r(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        tl.b.b("PluginView", "onLoadFail");
        if (this.f9525a.f21519a == null) goto L6;
        Intrinsics.checkNotNullParameter(r10, "e");
        return;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void s(Uri r5, hb.a r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        tl.b.c("PluginView", "onKitViewDestroy");
        ol.c r11 = this.f9525a.f21519a;
        View r12 = r10.a();
        if ((r12 instanceof LynxView) == false) goto L5;
        LynxView r13 = (LynxView) r12;
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        qo.a.g(r13);
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void u(Uri r5, com.bytedance.ies.bullet.core.container.e r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        tl.b.a("onLoadStart");
        ol.c r11 = this.f9525a.f21519a;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void v(Uri r5, com.bytedance.ies.bullet.service.base.h r10, rd.e r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "schemaModelUnion");
        tl.b.a("onLoadModelSuccess");
        BulletContainerView r12 = this.f9525a.f9526b;
        r12.getClass();
        com.bytedance.ies.bullet.service.base.b.a(6, "message:BulletContainerView dispatchShowLoading", null);
        r12.l();
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void w(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        tl.b.a("onRuntimeReady");
        f r11 = this.f9525a;
        if (r11.f21519a == null) goto L6;
        Intrinsics.checkNotNullParameter(r11.f9526b, "view");
        return;
    }
}
