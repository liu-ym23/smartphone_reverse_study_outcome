package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class x0 implements Function1 {
    public final /* synthetic */ boolean a;

    public /* synthetic */ x0(boolean r1) {
        this.a = r1;
    }

    public final Object invoke(Object r33) {
        boolean r1 = this.a;
        f r2 = (f) r33;
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.b().getClass();
        d r4 = new d(false, true, true);
        if (r1 == false) goto L5;
        v4 r3 = v4.a(r2.f(), InstallPhase.AWAITING_RECONNECT, 0, null, 0, 0, false, null, null, 0, 0, 0, null, null, false, 30718);
    L7:
        return f.a(r2, null, r4, null, null, null, null, null, null, null, null, r3, null, null, null, null, null, null, 260091);
    L5:
        r3 = r2.f();
        goto L7
    }
}
