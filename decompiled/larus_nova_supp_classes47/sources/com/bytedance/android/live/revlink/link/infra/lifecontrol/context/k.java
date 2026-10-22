package com.bytedance.android.live.revlink.link.infra.lifecontrol.context;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    static {
    }

    public static RevLinkBizContext a(BaseContextBuilder r26) {
        Intrinsics.checkNotNullParameter(r26, "builder");
        String r3 = r26.a;
        boolean r4 = r26.b;
        long r5 = r26.c;
        String r7 = r26.d;
        int r8 = r26.e;
        long r9 = r26.f;
        Function0<Integer> r12 = r26.h;
        Function0<Integer> r13 = r26.g;
        o11.a r14 = r26.j;
        l.a(r14);
        com.bytedance.android.live.revlink.impl.global.c r15 = r26.k;
        l.a(r15);
        x51.a r16 = r26.l;
        l.a(r16);
        wq2.f r1 = r26.m;
        l.a(r1);
        yz0.f r2 = r26.n;
        l.a(r2);
        com.bytedance.android.livesdk.revenue.service.message.d r6 = r26.o;
        l.a(r6);
        ld.a r10 = r26.p;
        l.a(r10);
        x11.a r17 = r26.q;
        l.a(r17);
        com.bytedance.android.live.revlink.link.domain.anchorimpl.l r18 = r26.r;
        l.a(r18);
        com.bytedance.android.live.revlink.link.domain.anchorimpl.j r19 = r26.s;
        l.a(r19);
        com.bytedance.android.live.revlink.link.domain.anchorimpl.m r20 = r26.t;
        l.a(r20);
        Function0<? extends IRoom> r0 = r26.u;
        l.a(r0);
        return new RevLinkBizContext(r3, r4, r5, r7, r8, r9, r13, r12, r14, r15, r16, r1, r2, r6, r10, r17, r18, r19, r20, r0);
    }
}
