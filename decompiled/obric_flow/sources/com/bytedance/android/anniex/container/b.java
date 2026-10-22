package com.bytedance.android.anniex.container;

import android.net.Uri;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.bytedance.ies.bullet.core.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnieXContainer f3137a;

    public b(AnnieXContainer r5) {
        this.f3137a = r5;
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void o(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        AnnieXContainer r11 = this.f3137a;
        AnnieXContainer.access$bindKitView(r11, r5, r10);
        AnnieXContainer.access$observerKitViewLayoutChanged(r11);
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void p(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        StringBuilder r12 = new StringBuilder("onLoadUriSuccess: ");
        AnnieXContainer r13 = this.f3137a;
        oo.j.g(r13, r12);
        AnnieXContainer.access$sendWindowSizeEvent(r13);
        AnnieXContainer.access$setLoadSuccess$p(r13, true);
        AnnieXContainer.access$putState(r13, 3);
        AnnieXContainer.access$getLifecycleDispatcher$p(r13).j(AnnieXContainer.access$getCurrentSchema$p(r13), r13);
        r13.getBulletContext().f5293c.l().p(r5, r10);
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void q(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        AnnieXContainer r11 = this.f3137a;
        AnnieXContainer.access$getLifecycleDispatcher$p(r11).e(AnnieXContainer.access$getCurrentSchema$p(r11), r11, r10);
        r11.getBulletContext().f5293c.l().q(r5, r10);
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void r(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        StringBuilder r12 = new StringBuilder("onLoadFail: schema===> ");
        AnnieXContainer r13 = this.f3137a;
        r12.append(r13.getUrl());
        r12.append(" error===> ");
        r12.append(r10.getMessage());
        r12.append("  } ");
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXContainer", r12.toString(), null, 12);
        AnnieXContainer.access$setLoadSuccess$p(r13, false);
        AnnieXContainer.access$putState(r13, 3);
        AnnieXContainer.access$getLifecycleDispatcher$p(r13).g(AnnieXContainer.access$getCurrentSchema$p(r13), r13, r10);
        r13.getBulletContext().f5293c.l().r(r5, r10);
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void s(Uri r10, hb.a r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r12 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r10.toString()), TuplesKt.to("message", null)});
        AnnieXContainer r13 = this.f3137a;
        com.bytedance.ies.bullet.base.utils.logger.b r14 = (com.bytedance.ies.bullet.base.utils.logger.b) r13.getBulletContext().f5292b.getValue();
        Intrinsics.checkNotNullParameter("AnnieXContainer", "moduleTag");
        Intrinsics.checkNotNullParameter("kit_view_destroy", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "AnnieXContainer", "kit_view_destroy", r12, r14);
        AnnieXContainer.access$getLifecycleDispatcher$p(r13).h(AnnieXContainer.access$getCurrentSchema$p(r13), r13);
        r13.getBulletContext().f5293c.l().getClass();
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void v(Uri r5, com.bytedance.ies.bullet.service.base.h r10, rd.e r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "schemaModelUnion");
        this.f3137a.getBulletContext().f5293c.l().v(r5, r10, r11);
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void w(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        StringBuilder r12 = new StringBuilder("===onRuntimeReady:  ");
        AnnieXContainer r13 = this.f3137a;
        oo.j.g(r13, r12);
        AnnieXContainer.access$putState(r13, 4);
        AnnieXContainer.access$getLifecycleDispatcher$p(r13).k(AnnieXContainer.access$getCurrentSchema$p(r13), r13);
    }
}
