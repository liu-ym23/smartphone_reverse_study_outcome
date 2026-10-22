package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c3 implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ long b;

    public /* synthetic */ c3(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }

    public final Object invoke(Object r40) {
        long r3 = this.a;
        long r14 = this.b;
        f r1 = (f) r40;
        Intrinsics.checkNotNullParameter(r1, "it");
        return f.a(r1, null, null, null, null, null, null, null, null, null, null, v4.a(r1.f(), InstallPhase.CONNECTING, r3, null, 0, 0, false, null, null, 0, 0, r14 + 1800000, null, null, false, 30714), null, null, null, null, null, null, 260095);
    }
}
