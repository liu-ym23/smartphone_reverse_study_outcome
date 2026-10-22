package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x extends l {
    public final v v;

    @Override // com.bytedance.ai.applet.app.foundation.performance.l
    public final void p(long r10) {
        k.d(this, AppletPerformanceOutcome.SUCCESS, r10, AppletPerformanceErrorCode.SUCCESS, null, 8);
    }

    public x(c r10, final v r11) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r11, "config");
        super(r10, r11.a, new w(r11));
        this.v = r11;
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.k
    public final e b(AppletPerformanceOutcome r25, long r26, AppletPerformanceErrorCode r28, String r29) {
        Intrinsics.checkNotNullParameter(r25, "outcome");
        Intrinsics.checkNotNullParameter(r28, "errorCode");
        c r10 = this.a;
        String r11 = r10.a;
        String r12 = r10.b;
        long r13 = this.c;
        long r14 = this.b;
        long r15 = r26 - r14;
        Long r16 = Long.valueOf(this.v.c);
        Long r17 = Long.valueOf(this.v.b);
        Long r18 = l.e(this.n, this.o);
        Long r19 = l.e(this.q, this.r);
        Long r110 = l.e(this.s, this.t);
        Long r20 = this.t;
        o r111 = this.k;
        if (r111 == null) goto L5;
        Long r112 = Long.valueOf(r111.b);
    L6:
        Long r113 = l.e(r20, r112);
        boolean r21 = this.p;
        Long r22 = this.u;
        v r23 = this.v;
        return new j(r11, r12, r13, r14, r15, r28, r29, r16, r17, r18, r19, r110, r113, r21, r22, r23.d, r23.e, r23.f);
    L5:
        r112 = null;
        goto L6
    }
}
