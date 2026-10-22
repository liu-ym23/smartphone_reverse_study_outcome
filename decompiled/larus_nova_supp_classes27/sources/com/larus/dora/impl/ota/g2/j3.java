package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j3 implements Function1 {
    public final /* synthetic */ e5 a;
    public final /* synthetic */ ManualOnlyReason b;

    public /* synthetic */ j3(e5 r1, ManualOnlyReason r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r33) {
        e5 r9 = this.a;
        ManualOnlyReason r10 = this.b;
        f r12 = (f) r33;
        Intrinsics.checkNotNullParameter(r12, "it");
        return f.a(r12, null, null, null, null, null, new w4(0, null, false, null, 31), r9, f5.a(r12.l(), null, null, 0, 0, 0, null, r10, r9.h(), 127), null, null, new v4(null, null, 0, OtaMode.SILENT_G2, BlockReason.MANUAL_ONLY, false, 28663), null, null, null, null, null, null, 259647);
    }
}
