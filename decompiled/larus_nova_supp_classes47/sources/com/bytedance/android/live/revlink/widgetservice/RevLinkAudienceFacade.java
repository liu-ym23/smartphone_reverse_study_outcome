package com.bytedance.android.live.revlink.widgetservice;

import com.bytedance.android.live.revlink.impl.LynxCentralManager;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.l;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.m;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.RevLinkBizContext;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.k;
import com.bytedance.android.livesdk.revenue.service.message.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o51.i;
import sc0.b;
import u51.c;
import wq2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkAudienceFacade {
    public h a;
    public i b;
    public final RevLinkAudienceLaunchParam c;
    public final c d;
    public final o11.a e;
    public final com.bytedance.android.livesdk.revenue.service.room.c f;
    public final x51.a g;
    public final f h;
    public final yz0.f i;
    public final d j;
    public final ld.a k;
    public final x11.a l;
    public final String m;
    public final l n;
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.h o;
    public final m p;

    public final h getContext() {
        return this.a;
    }

    public final h a(final RevLinkAudienceLaunchParam r5) {
        int r0 = com.bytedance.android.live.revlink.link.infra.lifecontrol.context.f.a;
        Function1<com.bytedance.android.live.revlink.link.infra.lifecontrol.context.c, Unit> r1 = new RevLinkAudienceFacade$buildRevLinkBizAudienceContext$1(this, r5);
        Intrinsics.checkNotNullParameter(r1, "initFunc");
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.c r6 = new com.bytedance.android.live.revlink.link.infra.lifecontrol.context.c();
        r1.invoke(r6);
        RevLinkBizContext r2 = k.a(r6);
        b r3 = r6.v;
        sc0.d r4 = r6.w;
        com.bytedance.android.live.revlink.link.domain.anchorimpl.h r7 = r6.x;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.l.a(r7);
        return new h(r2, r3, r4, r7);
    }

    public RevLinkAudienceFacade(RevLinkAudienceLaunchParam r2, c r3, o11.a r4, com.bytedance.android.livesdk.revenue.service.room.c r5, LynxCentralManager r6, f r7, yz0.f r8, d r9, ld.a r10, x11.a r12, String r13, com.bytedance.android.live.revlink.impl.multianchor.widget.i r14, com.bytedance.android.live.revlink.impl.multianchor.widget.c r15, com.bytedance.android.live.revlink.impl.multianchor.widget.l r16) {
        Intrinsics.checkNotNullParameter(r2, "launchParam");
        Intrinsics.checkNotNullParameter(r3, "infraScope");
        Intrinsics.checkNotNullParameter(r4, "linkScope");
        Intrinsics.checkNotNullParameter(r5, "revRoomService");
        Intrinsics.checkNotNullParameter(r6, "lynxCentralService");
        Intrinsics.checkNotNullParameter(r7, "roomDataCenterService");
        Intrinsics.checkNotNullParameter(r13, "selfUID");
        Intrinsics.checkNotNullParameter(r14, "performanceMonitor");
        Intrinsics.checkNotNullParameter(r15, "commonService");
        Intrinsics.checkNotNullParameter(r16, "windowService");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r12;
        this.m = r13;
        this.n = r14;
        this.o = r15;
        this.p = r16;
    }
}
