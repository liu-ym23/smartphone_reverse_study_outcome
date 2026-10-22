package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class t0 implements Function1 {
    public final /* synthetic */ s$a0 a;

    public /* synthetic */ t0(s$a0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r30) {
        s$a0 r1 = this.a;
        f r3 = (f) r30;
        Intrinsics.checkNotNullParameter(r3, "it");
        return f.a(r3, null, null, null, null, null, null, null, null, null, null, new v4(null, null, 0, OtaMode.MANUAL, null, r1.a(), 16375), null, null, null, null, null, null, 260095);
    }
}
