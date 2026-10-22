package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class x3 implements Function1 {
    public /* synthetic */ x3() {
    }

    public final Object invoke(Object r23) {
        f r0 = (f) r23;
        Intrinsics.checkNotNullParameter(r0, "it");
        if (r0.f().b() != BlockReason.MANUAL_ENTERED_TONIGHT) goto L5;
        v4 r1 = v4.a(r0.f(), null, 0, null, 0, 0, false, null, null, 0, 0, 0, BlockReason.NONE, null, false, 28671);
    L7:
        return f.a(r0, null, null, null, null, null, null, null, null, null, null, r1, null, null, null, null, null, null, 129023);
    L5:
        r1 = r0.f();
        goto L7
    }
}
