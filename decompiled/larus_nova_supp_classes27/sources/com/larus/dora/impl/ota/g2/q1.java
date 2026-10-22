package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class q1 implements Function1 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ s$d b;

    public /* synthetic */ q1(boolean r1, s$d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r40) {
        boolean r1 = this.a;
        s$d r2 = this.b;
        f r3 = (f) r40;
        Intrinsics.checkNotNullParameter(r3, "it");
        v4 r20 = r3.f();
        if (r1 == false) goto L5;
        InstallPhase r4 = InstallPhase.AWAITING_RECONNECT;
    L7:
        return f.a(r3, null, null, null, null, null, null, null, null, null, null, v4.a(r20, r4, 0, null, r2.e(), r2.d(), false, null, null, 0, 0, 0, null, null, false, 32718), null, null, null, null, null, null, 260095);
    L5:
        r4 = InstallPhase.DEVICE_OWNED;
        goto L7
    }
}
