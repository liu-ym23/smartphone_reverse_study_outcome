package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class a1 implements Function1 {
    public final /* synthetic */ s$g a;

    public /* synthetic */ a1(s$g r1) {
        this.a = r1;
    }

    public final Object invoke(Object r35) {
        s$g r1 = this.a;
        f r12 = (f) r35;
        Intrinsics.checkNotNullParameter(r12, "it");
        return f.a(r12, null, null, null, null, null, null, null, null, null, l.a(r12.c(), DownloadPhase.PAUSED, 0, null, 0, 0, 0, false, null, false, r1.d(), null, 3070), null, null, null, null, null, null, null, 261119);
    }
}
