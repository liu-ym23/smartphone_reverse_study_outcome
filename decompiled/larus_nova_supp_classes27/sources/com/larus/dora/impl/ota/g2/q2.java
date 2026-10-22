package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class q2 implements Function1 {
    public /* synthetic */ q2() {
    }

    public final Object invoke(Object r28) {
        f r1 = (f) r28;
        Intrinsics.checkNotNullParameter(r1, "it");
        return f.a(r1, null, null, null, null, null, null, null, null, null, null, new v4(InstallPhase.QUEUED, null, 0, OtaMode.SILENT_G2, BlockReason.GLOBAL_SERIAL_BUSY, false, 28662), null, null, null, null, null, null, 260095);
    }
}
