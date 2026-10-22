package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i2 implements Function1 {
    public final /* synthetic */ s.c a;

    public /* synthetic */ i2(s.c r1) {
        this.a = r1;
    }

    public final Object invoke(Object r310) {
        s.c r1 = this.a;
        f r13 = (f) r310;
        Intrinsics.checkNotNullParameter(r13, "it");
        return f.a(r13, null, null, null, null, null, null, null, null, null, null, v4.a(r13.f(), null, 0, null, 0, 0, false, null, null, 0, 0, r1.b() + j0.G2_OTA_DISCONNECT_WATCHDOG_MS, null, null, false, 30719), null, null, null, null, null, null, 260095);
    }
}
