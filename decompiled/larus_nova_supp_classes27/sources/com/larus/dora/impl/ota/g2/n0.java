package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class n0 implements Function1 {
    public final /* synthetic */ s$o0 a;
    public final /* synthetic */ f b;

    public /* synthetic */ n0(s$o0 r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r40) {
        s$o0 r1 = this.a;
        f r2 = this.b;
        f r4 = (f) r40;
        Intrinsics.checkNotNullParameter(r4, "it");
        long r11 = r1.c();
        CheckPurpose r13 = CheckPurpose.INSTALL;
        c4 r15 = c4.INSTANCE;
        String r3 = r2.q().b();
        long r5 = r1.c();
        r15.getClass();
        return f.a(r4, null, null, null, null, null, new w4(r11, r13, true, c4.F(r3, r5), 8), null, null, null, null, v4.a(r4.f(), InstallPhase.CHECKING, 0, null, 0, 0, false, null, null, 0, 0, 0, null, null, false, 32766), null, null, null, null, null, null, 260031);
    }
}
