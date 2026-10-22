package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i3 implements Function1 {
    public final /* synthetic */ CheckPurpose a;
    public final /* synthetic */ f b;
    public final /* synthetic */ e5 c;

    public /* synthetic */ i3(CheckPurpose r1, f r2, e5 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r32) {
        CheckPurpose r1 = this.a;
        f r2 = this.b;
        e5 r10 = this.c;
        f r3 = (f) r32;
        Intrinsics.checkNotNullParameter(r3, "it");
        w4 r9 = new w4(0, null, false, null, 31);
        CheckPurpose r4 = CheckPurpose.INSTALL;
        if (r1 != r4) goto L5;
        v4 r5 = v4.a(r3.f(), InstallPhase.IDLE, 0, null, 0, 0, false, null, null, 0, 0, 0, BlockReason.PACKAGE_INVALID, null, false, 28670);
    L6:
        v4 r14 = r5;
        if (r1 != r4) goto L9;
        l r6 = r3.c();
    L11:
        return f.a(r3, null, null, null, null, null, r9, r10, null, null, r6, r14, null, null, j5.a(r3.m(), 0, "", 0, 0, 0, 0, 60), null, null, null, 238399);
    L9:
        r6 = l.a(r3.c(), DownloadPhase.FAILED, 0, null, 0, 0, 0, false, null, false, null, r2.l().g(), 2046);
        goto L11
    L5:
        r5 = r3.f();
        goto L6
    }
}
