package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g1 implements Function1 {
    public final /* synthetic */ e5 a;
    public final /* synthetic */ s$r b;

    public /* synthetic */ g1(e5 r1, s$r r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r210) {
        e5 r1 = this.a;
        s$r r2 = this.b;
        f r3 = (f) r210;
        Intrinsics.checkNotNullParameter(r3, "it");
        w4 r16 = new w4(0, null, false, null, 31);
        if (r1 != null) goto L5;
        e5 r10 = r3.h();
    L7:
        if (r3.c().j() == DownloadPhase.CHECKING) goto L9;
    L11:
        l r4 = r3.c();
    L12:
        l r13 = r4;
        if (r1 == null) goto L15;
        s5 r5 = null;
    L16:
        s5 r15 = r5;
        if (r1 == null) goto L19;
        j5 r6 = j5.a(r3.m(), 0, "", 0, 0, 0, 0, 60);
    L21:
        return f.a(r3, null, null, null, null, null, r16, r10, null, null, r13, null, r15, null, r6, null, null, null, 240447);
    L19:
        r6 = r3.m();
        goto L21
    L15:
        r5 = r3.r();
        goto L16
    L9:
        if (r3.c().i() != r2.c()) goto L11;
        r4 = new l(null, 0, null, r3.c().g(), false, r3.c().h(), null, null, 3575);
        goto L12
    L5:
        r10 = r1;
        goto L7
    }
}
