package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class z3 implements Function1 {
    public final /* synthetic */ OtaMode a;

    public /* synthetic */ z3(OtaMode r1) {
        this.a = r1;
    }

    public final Object invoke(Object r30) {
        OtaMode r6 = this.a;
        f r1 = (f) r30;
        Intrinsics.checkNotNullParameter(r1, "it");
        return f.a(r1, null, null, null, null, null, null, null, null, null, null, new v4(InstallPhase.QUEUED, null, 0, r6, BlockReason.GLOBAL_SERIAL_BUSY, r1.f().c(), 12278), null, null, null, null, null, null, 260095);
    }
}
