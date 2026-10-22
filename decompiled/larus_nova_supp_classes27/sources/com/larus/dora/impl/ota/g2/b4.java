package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class b4 implements Function1 {
    public final /* synthetic */ b5 a;
    public final /* synthetic */ s$o0 b;

    public /* synthetic */ b4(b5 r1, s$o0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r34) {
        b5 r1 = this.a;
        s$o0 r2 = this.b;
        f r4 = (f) r34;
        Intrinsics.checkNotNullParameter(r4, "it");
        v4 r21 = new v4(null, null, 0, r4.f().e(), BlockReason.WIFI_ENABLE_FAILED, false, 28663);
        j5 r22 = r4.m();
        c4 r5 = c4.INSTANCE;
        long r12 = r2.b();
        r5.getClass();
        return f.a(r4, null, null, null, null, null, null, null, null, null, null, r21, null, null, j5.a(r22, 0, null, 0, 0, 0, c4.E(r1, r12), 31), null, null, null, 243711);
    }
}
