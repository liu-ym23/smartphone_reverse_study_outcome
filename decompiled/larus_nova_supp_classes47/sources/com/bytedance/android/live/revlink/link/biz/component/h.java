package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends com.bytedance.android.live.revlink.link.biz.doublecomponent.a implements com.bytedance.android.live.revlink.link.biz.service.a {
    public String d;
    public int e;
    public boolean f;
    public int g;
    public long h;
    public boolean i;
    public boolean j;
    public long k;
    public boolean l;
    public String m;
    public Integer n;
    public Integer o;
    public Map<String, String> p;
    public boolean q;
    public final NextLiveData<Unit> r;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a s;

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.s;
    }

    public h(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, com.bytedance.android.live.revenuelink.rtc.i r3, com.bytedance.android.livesdk.revenue.service.room.c r4, x11.a r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "anchorRtcManager");
        Intrinsics.checkNotNullParameter(r4, "roomService");
        Intrinsics.checkNotNullParameter(r5, "internalLinkService");
        super(r2, r4, r5);
        this.s = r2;
        this.g = 1;
        this.r = new NextLiveData();
    }

    public final void a(boolean r2, com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r3, com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r4, boolean r5) {
        this.f = r2;
        if (r2 == false) goto L22;
        if (r3 == null) goto L8;
        boolean r0 = true;
        if (r3.isBattleShow() != true) goto L8;
    L9:
        this.l = r0;
        Map<String, String> r6 = null;
        if (r4 == null) goto L12;
        String r7 = r4.getInviteModeStatus();
    L13:
        this.m = r7;
        this.o = Integer.valueOf(com.bytedance.android.live.revlink.link.biz.service.i.t(this).c());
        if (r3 == null) goto L16;
        Integer r8 = Integer.valueOf(r3.getCustomizePlayType());
    L17:
        this.n = r8;
        if (r3 == null) goto L20;
        r6 = r3.getServerEventTrackingInfo();
    L20:
        this.p = r6;
        this.q = r5;
        return;
    L16:
        r8 = null;
        goto L17
    L12:
        r7 = null;
    L8:
        r0 = false;
        goto L9
    }
}
