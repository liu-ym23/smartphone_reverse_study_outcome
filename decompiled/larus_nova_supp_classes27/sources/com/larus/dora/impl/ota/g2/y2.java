package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class y2 implements Function1 {
    public final /* synthetic */ a5 a;
    public final /* synthetic */ s$b0 b;
    public final /* synthetic */ long c;

    public /* synthetic */ y2(a5 r1, s$b0 r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r210) {
        a5 r1 = this.a;
        s$b0 r2 = this.b;
        long r6 = this.c;
        f r3 = (f) r210;
        Intrinsics.checkNotNullParameter(r3, "it");
        c4 r4 = c4.INSTANCE;
        long r5 = r2.c();
        r4.getClass();
        return f.a(r3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, a5.a(r1, c4.m(r5, r6), false, null, r6, 57), 131071);
    }
}
