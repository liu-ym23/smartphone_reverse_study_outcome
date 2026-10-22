package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class s1 implements Function1 {
    public final /* synthetic */ w4 a;

    public /* synthetic */ s1(w4 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r35) {
        w4 r1 = this.a;
        f r2 = (f) r35;
        Intrinsics.checkNotNullParameter(r2, "it");
        w4 r21 = new w4(0, null, false, null, 31);
        if (r2.c().j() == DownloadPhase.CHECKING) goto L5;
    L7:
        l r8 = r2.c();
    L8:
        l r12 = r8;
        if (r2.f().j() == InstallPhase.CHECKING) goto L11;
    L13:
        v4 r3 = r2.f();
    L15:
        return f.a(r2, null, null, null, null, null, r21, null, null, null, r12, r3, null, null, null, null, null, null, 259007);
    L11:
        if (r2.f().g() != r1.c()) goto L13;
        r3 = new v4(null, null, 0, r2.f().e(), null, r2.f().c(), 16375);
        goto L15
    L5:
        if (r2.c().i() != r1.c()) goto L7;
        r8 = new l(null, 0, null, r2.c().g(), false, r2.c().h(), null, null, 3575);
        goto L8
    }
}
