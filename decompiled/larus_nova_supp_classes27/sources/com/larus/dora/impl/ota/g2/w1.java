package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class w1 implements Function1 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ s$q b;

    public /* synthetic */ w1(boolean r1, s$q r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r34) {
        boolean r1 = this.a;
        s$q r2 = this.b;
        f r3 = (f) r34;
        Intrinsics.checkNotNullParameter(r3, "it");
        v4 r14 = r3.f();
        if (r1 == false) goto L5;
        long r4 = r2.c() + 5000;
    L7:
        return f.a(r3, null, null, null, null, null, null, null, null, null, null, v4.a(r14, null, 0, null, 0, 0, false, null, null, r4, 0, 0, null, null, false, 32255), null, null, null, null, null, null, 260095);
    L5:
        r4 = 0;
        goto L7
    }
}
