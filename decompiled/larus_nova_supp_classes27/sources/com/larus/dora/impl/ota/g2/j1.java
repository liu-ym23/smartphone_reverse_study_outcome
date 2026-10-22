package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j1 implements Function1 {
    public final /* synthetic */ e5 a;
    public final /* synthetic */ long b;

    public /* synthetic */ j1(e5 r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r48) {
        e5 r3 = this.a;
        long r10 = this.b;
        f r15 = (f) r48;
        Intrinsics.checkNotNullParameter(r15, "it");
        PackagePhase r2 = PackagePhase.CLEANING;
        ManualOnlyReason r13 = r15.l().e();
        if (r15.l().e() == null) goto L7;
        d5 r1 = r15.l().d();
        if (r1 != null) goto L9;
        r1 = r3.h();
    L9:
        return f.a(r15, null, null, null, null, null, null, null, new f5(r2, r3, 0, 0, 0, r10, null, r13, r1, 92), null, new l(null, 0, null, r15.c().g(), false, false, null, null, 4087), null, null, null, null, null, null, null, 260863);
    L7:
        r1 = null;
        goto L9
    }
}
