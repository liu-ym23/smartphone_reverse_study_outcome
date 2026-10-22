package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class a3 implements Function1 {
    public final /* synthetic */ s$f a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ f e;
    public final /* synthetic */ b5 f;

    public /* synthetic */ a3(s$f r1, long r2, int r4, int r5, f r6, b5 r7) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public final Object invoke(Object r33) {
        s$f r1 = this.a;
        long r6 = this.b;
        int r8 = this.c;
        int r9 = this.d;
        f r2 = this.e;
        b5 r3 = this.f;
        f r13 = (f) r33;
        Intrinsics.checkNotNullParameter(r13, "it");
        l r23 = l.a(r13.c(), DownloadPhase.FAILED, 0, null, 0, 0, 0, false, null, false, null, r1.e(), 2046);
        f5 r21 = r13.l();
        j5 r4 = r13.m();
        if (r2.c().m() == false) goto L5;
        c4 r5 = c4.INSTANCE;
        long r14 = r1.c();
        r5.getClass();
        long r7 = c4.E(r3, r14);
    L7:
        return f.a(r13, null, null, null, null, null, null, null, r21, null, r23, null, null, null, j5.a(r4, 0, null, r6, r8, r9, r7, 3), null, null, null, 244479);
    L5:
        r7 = r13.m().d();
        goto L7
    }
}
