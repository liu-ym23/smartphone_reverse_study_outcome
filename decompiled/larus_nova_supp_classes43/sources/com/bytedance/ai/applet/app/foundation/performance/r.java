package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r extends l {
    public final p v;
    public Long w;
    public boolean x;
    public a y;

    @Override // com.bytedance.ai.applet.app.foundation.performance.l
    public final long f() {
        Object r0 = this.d;
        monitor-enter(r0);
        Long r1 = this.w;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        long r10 = r1.longValue();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);
        return r10;
    L7:
        r10 = this.v.a;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void t() {
        long r0 = System.currentTimeMillis();
        Object r10 = this.d;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (a(r0) == true) goto L7;
    L10:
        monitor-exit(r10);
        return;
    L7:
        if (this.w != null) goto L10;
        this.w = Long.valueOf(r0);     // Catch: Throwable -> L12
        goto L10
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.l
    public final void p(long r10) {
        u(r10);
        k.d(this, AppletPerformanceOutcome.SUCCESS, r10, AppletPerformanceErrorCode.SUCCESS, null, 8);
        Object r11 = this.d;
        monitor-enter(r11);
        a r12 = this.y;     // Catch: Throwable -> L11
        monitor-exit(r11);
        if (r12 == null) goto L16;
        f r13 = r12.a;
        if (r13 == null) goto L17;
        this.a.j(r13);
        return;
    L17:
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void u(long r13) {
        Object r0 = this.d;
        monitor-enter(r0);
        Long r10 = this.w;     // Catch: Throwable -> L18
        if (a(r13) == false) goto L12;
        if (r10 == null) goto L12;
        if (this.x == true) goto L12;
        this.x = true;     // Catch: Throwable -> L18
        p r1 = this.v;     // Catch: Throwable -> L18
        long r11 = r1.a;     // Catch: Throwable -> L18
        long r12 = r13 - r11;     // Catch: Throwable -> L18
        g.a r14 = new g.a(this.c, r1.b);     // Catch: Throwable -> L18
        p r15 = this.v;     // Catch: Throwable -> L18
        f.h r16 = new f.h(r11, r12, r14, r15.d, r15.e, r10, r15.c);     // Catch: Throwable -> L18
    L13:
        monitor-exit(r0);
        if (r16 != null) goto L16;
        return;
    L16:
        this.a.j(r16);
        return;
    L12:
        r16 = null;
    L18:
        th = move-exception;
        throw th;
    }

    public r(c r10, final p r11) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r11, "config");
        super(r10, r11.a, new q(r11));
        this.v = r11;
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.k
    public final e b(AppletPerformanceOutcome r26, long r27, AppletPerformanceErrorCode r29, String r30) {
        Intrinsics.checkNotNullParameter(r26, "outcome");
        Intrinsics.checkNotNullParameter(r29, "errorCode");
        boolean r10 = true;
        if (r26 != AppletPerformanceOutcome.SUCCESS) goto L22;
        c r0 = this.a;
        long r11 = this.c;
        p r12 = this.v;
        String r13 = r12.b;
        Long r14 = this.w;
        AppletPerformanceNavigationType r15 = r12.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r13, "path");
        Object r16 = r0.c;
        monitor-enter(r16);
        Long r17 = r0.g;     // Catch: Throwable -> L19
        if (r0.i == false) goto L9;
    L16:
        a r1 = null;
    L17:
        monitor-exit(r16);
        this.y = r1;
    L23:
        Long r18 = this.w;
        if (r18 == null) goto L33;
        Long r19 = Long.valueOf(r18.longValue() - this.v.a);
        if (r19.longValue() >= 0) goto L29;
        r10 = false;
    L29:
        if (r10 == true) goto L32;
        r19 = null;
    L32:
        Long r23 = r19;
    L34:
        c r20 = this.a;
        String r21 = r20.a;
        String r22 = r20.b;
        long r24 = this.c;
        long r25 = this.b;
        long r110 = r27 - r25;
        Long r111 = l.e(this.n, this.o);
        Long r112 = l.e(this.q, this.r);
        Long r113 = l.e(this.s, this.t);
        Long r28 = this.t;
        o r114 = this.k;
        if (r114 == null) goto L37;
        Long r31 = Long.valueOf(r114.b);
    L38:
        Long r210 = l.e(r28, r31);
        boolean r115 = this.p;
        Long r32 = this.u;
        p r33 = this.v;
        String r34 = r33.b;
        AppletPerformanceNavigationType r35 = r33.c;
        if (r35 == null) goto L41;
        String r211 = r35.getValue();
    L42:
        String r36 = this.v.d;
        if (r1 == null) goto L45;
        Long r212 = Long.valueOf(r1.b);
    L47:
        return new b(r21, r22, r24, r25, r110, r29, r30, r111, r112, r113, r210, r115, r32, r34, r211, r36, r23, r212);
    L45:
        r212 = null;
        goto L47
    L41:
        r211 = null;
        goto L42
    L37:
        r31 = null;
        goto L38
    L33:
        r23 = null;
        goto L34
    L9:
        if (r0.h == true) goto L16;
        if (r17 == null) goto L16;
        if (r27 < r17.longValue()) goto L16;
        r0.h = true;     // Catch: Throwable -> L19
        r0.g = null;     // Catch: Throwable -> L19
        long r116 = r27 - r17.longValue();     // Catch: Throwable -> L19
        r1 = new a(new f.a(r17.longValue(), r116, new g.a(r11, r13), r14, r15), r116);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L22:
        r1 = null;
        goto L23
    }
}
