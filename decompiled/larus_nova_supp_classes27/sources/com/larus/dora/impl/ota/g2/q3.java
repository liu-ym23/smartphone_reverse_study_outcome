package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class q3 implements Function1 {
    public final /* synthetic */ OtaMode a;
    public final /* synthetic */ BlockReason b;
    public final /* synthetic */ b5 c;
    public final /* synthetic */ long d;

    public /* synthetic */ q3(OtaMode r1, BlockReason r2, b5 r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r43) {
        OtaMode r6 = this.a;
        BlockReason r7 = this.b;
        b5 r10 = this.c;
        long r11 = this.d;
        f r14 = (f) r43;
        Intrinsics.checkNotNullParameter(r14, "it");
        v4 r1 = new v4(null, null, 0, r6, r7, false, 28663);
        j5 r31 = r14.m();
        c4.INSTANCE.getClass();
        return f.a(r14, null, null, null, null, null, null, null, null, null, null, r1, null, null, j5.a(r31, 0, null, 0, 0, 0, c4.E(r10, r11), 31), null, null, null, 243711);
    }
}
