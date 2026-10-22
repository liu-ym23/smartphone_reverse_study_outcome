package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class o2 implements Function1 {
    public final /* synthetic */ e5 a;
    public final /* synthetic */ s$k b;

    public /* synthetic */ o2(e5 r1, s$k r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r410) {
        e5 r15 = this.a;
        s$k r1 = this.b;
        f r14 = (f) r410;
        Intrinsics.checkNotNullParameter(r14, "it");
        return f.a(r14, null, null, null, null, null, null, null, new f5(PackagePhase.READY, r15, r1.b(), r1.b(), 0, 0, null, r14.l().e(), r14.l().d(), 96), null, l.a(r14.c(), DownloadPhase.IDLE, 0, null, r15.h().e(), 0, 0, false, null, false, BlockReason.NONE, FailureReason.NONE, 1006), null, null, null, j5.a(r14.m(), 0, null, 0, 0, 0, 0, 3), null, null, null, 244479);
    }
}
