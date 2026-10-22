package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f3 implements Function1 {
    public final /* synthetic */ g5 a;

    public /* synthetic */ f3(g5 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r37) {
        g5 r12 = this.a;
        f r1 = (f) r37;
        Intrinsics.checkNotNullParameter(r1, "it");
        return f.a(r1, null, null, null, null, null, null, null, null, null, l.a(r1.c(), DownloadPhase.PAUSING, 0, null, 0, 0, 0, false, r12, false, BlockReason.PACKAGE_INVALID, null, 2814), null, null, null, null, null, null, null, 261119);
    }
}
