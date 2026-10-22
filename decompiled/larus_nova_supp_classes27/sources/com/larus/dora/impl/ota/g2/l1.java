package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class l1 implements Function1 {
    public /* synthetic */ l1() {
    }

    public final Object invoke(Object r40) {
        f r0 = (f) r40;
        Intrinsics.checkNotNullParameter(r0, "it");
        if (r0.l().e() != null) goto L5;
        f5 r8 = new f5(null, null, 0, 0, 0, 0, null, null, null, 511);
    L7:
        return f.a(r0, null, null, null, null, null, null, null, r8, null, null, null, null, null, j5.a(r0.m(), 0, null, 0, 0, 0, 0, 47), null, null, null, 245503);
    L5:
        r8 = new f5(null, r0.l().h(), 0, 0, 0, 0, null, r0.l().e(), r0.l().d(), 125);
        goto L7
    }
}
