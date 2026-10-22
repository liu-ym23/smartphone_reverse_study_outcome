package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class u2 implements Function1 {
    public final /* synthetic */ f a;

    public /* synthetic */ u2(f r1) {
        this.a = r1;
    }

    public final Object invoke(Object r35) {
        f r1 = this.a;
        f r2 = (f) r35;
        Intrinsics.checkNotNullParameter(r2, "it");
        w4 r21 = new w4(0, null, false, null, 31);
        if (r2.c().j() == DownloadPhase.CHECKING) goto L5;
    L7:
        l r3 = r2.c();
    L9:
        return f.a(r2, null, null, null, null, null, r21, null, null, null, r3, null, null, null, null, null, null, null, 261055);
    L5:
        if (r2.c().i() != r1.i().c()) goto L7;
        r3 = new l(null, 0, null, OtaMode.MANUAL, false, r2.c().h(), null, null, 3575);
        goto L9
    }
}
