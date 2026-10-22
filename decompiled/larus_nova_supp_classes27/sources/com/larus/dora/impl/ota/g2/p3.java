package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class p3 implements Function1 {
    public final /* synthetic */ long a;

    public /* synthetic */ p3(long r1) {
        this.a = r1;
    }

    public final Object invoke(Object r28) {
        long r1 = this.a;
        f r3 = (f) r28;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.c().j() == DownloadPhase.CHECKING) goto L5;
    L7:
        l r2 = r3.c();
    L9:
        return f.a(r3, null, null, null, null, null, null, null, null, null, r2, null, null, null, null, null, null, null, 261119);
    L5:
        if (r3.c().i() != r1) goto L7;
        r2 = new l(null, 0, null, r3.c().g(), false, r3.c().h(), null, null, 3575);
        goto L9
    }
}
