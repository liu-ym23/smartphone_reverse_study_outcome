package com.bytedance.android.live.profit.redpacket;

import android.content.Context;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0 implements com.bytedance.android.scope.o, yz0.m {
    public final cy0.f a;
    public final yz0.k b;
    public final n01.a c;
    public final yz0.l d;
    public final ny0.a e;
    public final c01.a f;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // yz0.m
    public final void i() {
        boolean r1 = false;
        if (this.b.getRoom().isStar() == false) goto L5;
    L18:
        boolean r0 = false;
    L19:
        if (r0 == false) goto L45;
        n1 r2 = new n1(this.a);
        Intrinsics.checkNotNullParameter(r2, "scope");
        Context r3 = this.b.getContext();
        Intrinsics.checkNotNullParameter(r3, "value");
        r2.e = r3;
        if (com.bytedance.android.live.revenue.common.b0.b().b0() <= 0) goto L23;
        boolean r5 = true;
    L24:
        long r6 = System.currentTimeMillis();
        String r10 = null;
        if (((Number) i1.q.getValue(null, i1.a[14])).intValue() <= 0) goto L27;
        r1 = true;
    L27:
        l r4 = new l(r5, r6, r1);
        Intrinsics.checkNotNullParameter(r4, "value");
        r2.f = r4;
        Object r7 = e33.k.a;
        if (r2.e != r7) goto L30;
        r10 = "context";
    L41:
        if (r10 != null) goto L44;
        com.bytedance.android.scope.l.a(r2);
        return;
    L44:
        throw new UninitializedPropertyAccessException(r10);
    L30:
        if (r4 != r7) goto L33;
        r10 = "redPacketContext";
        goto L41
    L33:
        if (r2.g != r7) goto L36;
        r10 = "revenueInstance";
        goto L41
    L36:
        if (r2.h != r7) goto L39;
        r10 = "revenueInstanceExt";
        goto L41
    L39:
        if (r2.i != r7) goto L41;
        r10 = "roomInstance";
        goto L41
    L23:
        r5 = false;
        goto L24
    L45:
        int r8 = com.bytedance.android.live.revenue.common.v.a;
        StringBuilder r9 = new StringBuilder("RedPacket is not loaded, isStarRoom=");
        r9.append(this.b.getRoom().isStar());
        r9.append(", isKoiRoom=");
        r9.append(this.b.getRoom().isKoiRoom());
        r9.append(", isAudienceMediaRoom=");
        if (this.b.getRoom().isMediaRoom() == true) goto L48;
    L50:
        r9.append(r1);
        r9.append(", isVs=");
        r9.append(this.c.Fm());
        com.bytedance.android.live.revenue.common.v.a("ttlive_red_packet", r9.toString());
        return;
    L48:
        if (this.b.isAnchor() == true) goto L50;
        r1 = true;
        goto L50
    L5:
        if (this.b.getRoom().isKoiRoom() == true) goto L18;
        if (this.b.getRoom().isMediaRoom() == true) goto L9;
    L11:
        boolean r12 = false;
    L12:
        if (r12 == true) goto L18;
        if (this.c.Fm() == true) goto L18;
        r0 = true;
        goto L19
    L9:
        if (this.b.isAnchor() == true) goto L11;
        r12 = true;
        goto L12
    }

    public p0(cy0.f r2, yz0.k r3, n01.a r4, yz0.l r5, ny0.a r6, c01.a r7) {
        Intrinsics.checkNotNullParameter(r2, "instScope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "vsService");
        Intrinsics.checkNotNullParameter(r5, "messageService");
        Intrinsics.checkNotNullParameter(r6, "rpcService");
        Intrinsics.checkNotNullParameter(r7, "stiService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
