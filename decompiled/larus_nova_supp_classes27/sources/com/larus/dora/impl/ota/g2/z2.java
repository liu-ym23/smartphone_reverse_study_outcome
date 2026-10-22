package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class z2 implements Function1 {
    public final /* synthetic */ s$c0 a;

    public /* synthetic */ z2(s$c0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r310) {
        s$c0 r1 = this.a;
        f r13 = (f) r310;
        Intrinsics.checkNotNullParameter(r13, "it");
        return f.a(r13, null, null, null, null, null, null, null, null, null, null, v4.a(r13.f(), InstallPhase.TRANSFERRING, 0, null, 0, 0, false, null, null, 0, 0, r1.b() + 1800000, null, null, false, 30654), null, null, null, null, null, null, 260095);
    }
}
