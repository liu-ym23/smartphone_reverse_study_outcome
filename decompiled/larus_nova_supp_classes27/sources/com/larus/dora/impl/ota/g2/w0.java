package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class w0 implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ s$a0 b;

    public /* synthetic */ w0(long r1, s$a0 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final Object invoke(Object r42) {
        long r2 = this.a;
        s$a0 r1 = this.b;
        f r9 = (f) r42;
        Intrinsics.checkNotNullParameter(r9, "it");
        CheckPurpose r5 = CheckPurpose.MANUAL_HANDOFF;
        boolean r7 = r1.a();
        c4 r15 = c4.INSTANCE;
        String r3 = r1.e();
        r15.getClass();
        return f.a(r9, null, null, null, null, null, new w4(r2, r5, true, r7, c4.T(r3, r2)), null, null, null, l.a(r9.c(), null, 0, OtaMode.MANUAL, 0, 0, 0, false, null, false, null, null, 4087), null, null, null, null, null, null, null, 261055);
    }
}
