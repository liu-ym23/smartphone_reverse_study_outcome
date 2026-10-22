package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c2 implements Function1 {
    public final /* synthetic */ s.c a;

    public /* synthetic */ c2(s.c r1) {
        this.a = r1;
    }

    public final Object invoke(Object r27) {
        s.c r1 = this.a;
        f r10 = (f) r27;
        Intrinsics.checkNotNullParameter(r10, "it");
        return f.a(r10, null, null, null, null, null, null, null, f5.a(r10.l(), null, null, 0, r1.b() + j0.G2_OTA_PARTIAL_TTL_MS, 0, null, null, null, 495), null, null, null, null, null, null, null, null, null, 261887);
    }
}
