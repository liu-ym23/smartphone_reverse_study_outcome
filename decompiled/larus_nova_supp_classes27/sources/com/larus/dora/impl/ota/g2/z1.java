package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class z1 implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ FailureReason b;

    public /* synthetic */ z1(long r1, FailureReason r3) {
        this.a = r1;
        this.b = r3;
    }

    public final Object invoke(Object r42) {
        long r1 = this.a;
        FailureReason r3 = this.b;
        f r4 = (f) r42;
        Intrinsics.checkNotNullParameter(r4, "it");
        return f.a(r4, null, null, null, null, null, null, null, null, null, null, v4.a(r4.f(), InstallPhase.CANCELLING, 0, null, 0, 0, false, null, null, 0, 0, r1 + j0.G2_OTA_DISCONNECT_WATCHDOG_MS, null, r3, false, 22526), null, null, null, null, null, null, 260095);
    }
}
