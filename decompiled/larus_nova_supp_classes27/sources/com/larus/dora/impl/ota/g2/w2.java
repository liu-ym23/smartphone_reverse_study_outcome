package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class w2 implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ s$m b;

    public /* synthetic */ w2(long r1, s$m r3) {
        this.a = r1;
        this.b = r3;
    }

    public final Object invoke(Object r31) {
        long r8 = this.a;
        s$m r10 = this.b;
        f r11 = (f) r31;
        Intrinsics.checkNotNullParameter(r11, "it");
        CheckPurpose r4 = CheckPurpose.INSTALL;
        OtaMode r1 = r10.d();
        OtaMode r12 = OtaMode.MANUAL;
        boolean r14 = false;
        if (r1 == r12) goto L5;
    L7:
        boolean r6 = false;
    L8:
        c4 r2 = c4.INSTANCE;
        String r3 = r10.a();
        r2.getClass();
        w4 r17 = new w4(r8, r4, true, r6, c4.F(r3, r8));
        InstallPhase r5 = InstallPhase.CHECKING;
        OtaMode r7 = r10.d();
        if (r10.d() != r12) goto L14;
        if (r10.b() == false) goto L14;
        r14 = true;
    L14:
        return f.a(r11, null, null, null, null, null, r17, null, null, null, null, new v4(r5, null, r8, r7, null, r14, 16370), null, null, null, q5.a(r11.q(), null, null, r10.a(), 3), null, null, 223167);
    L5:
        if (r10.b() == false) goto L7;
        r6 = true;
        goto L8
    }
}
