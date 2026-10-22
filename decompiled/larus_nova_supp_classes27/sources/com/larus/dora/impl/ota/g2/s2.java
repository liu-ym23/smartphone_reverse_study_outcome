package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class s2 implements Function1 {
    public final /* synthetic */ s$p a;

    public /* synthetic */ s2(s$p r1) {
        this.a = r1;
    }

    public final Object invoke(Object r27) {
        s$p r1 = this.a;
        f r10 = (f) r27;
        Intrinsics.checkNotNullParameter(r10, "it");
        f5 r13 = r10.l();
        PackagePhase r14 = PackagePhase.CLEANING;
        long r20 = r1.a();
        return f.a(r10, null, null, null, null, null, null, null, f5.a(r13, r14, null, r1.c(), r1.c() + 1800000, r20, null, null, null, 458), null, null, null, null, null, null, null, null, null, 261887);
    }
}
