package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class o0 implements Function1 {
    public final /* synthetic */ s$l0 a;

    public /* synthetic */ o0(s$l0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r40) {
        s$l0 r1 = this.a;
        f r3 = (f) r40;
        Intrinsics.checkNotNullParameter(r3, "it");
        return f.a(r3, null, null, null, null, null, null, null, null, null, null, v4.a(r3.f(), null, 0, null, 0, Math.max(r3.f().k(), RangesKt.coerceIn(r1.e(), 0, 100)), false, null, null, 0, 0, r1.b() + 1800000, null, null, false, 30687), null, null, null, null, null, null, 260095);
    }
}
