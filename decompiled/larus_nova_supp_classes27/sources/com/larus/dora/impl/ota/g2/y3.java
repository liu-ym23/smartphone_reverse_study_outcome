package com.larus.dora.impl.ota.g2;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class y3 implements Function1 {
    public final /* synthetic */ e5 a;
    public final /* synthetic */ long b;

    public /* synthetic */ y3(e5 r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r27) {
        e5 r2 = this.a;
        long r3 = this.b;
        f r1 = (f) r27;
        Intrinsics.checkNotNullParameter(r1, "it");
        return f.a(r1, null, null, null, null, null, null, null, null, CollectionsKt.plus(r1.k(), new c5(r2, r3, 0)), null, null, null, null, null, null, null, null, 261631);
    }
}
