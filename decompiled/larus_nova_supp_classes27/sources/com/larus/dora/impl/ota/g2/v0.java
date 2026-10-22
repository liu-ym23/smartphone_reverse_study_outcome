package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class v0 implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ s$a0 b;
    public final /* synthetic */ w4 c;

    public /* synthetic */ v0(long r1, s$a0 r3, w4 r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    public final Object invoke(Object r53) {
        long r8 = this.a;
        s$a0 r15 = this.b;
        w4 r14 = this.c;
        f r13 = (f) r53;
        Intrinsics.checkNotNullParameter(r13, "it");
        CheckPurpose r4 = CheckPurpose.MANUAL_HANDOFF;
        boolean r6 = r15.a();
        c4 r1 = c4.INSTANCE;
        String r2 = r15.e();
        r1.getClass();
        w4 r22 = new w4(r8, r4, true, r6, c4.T(r2, r8));
        if (r13.c().j() != DownloadPhase.CHECKING) goto L5;
        f r35 = r13;
        l r3 = l.a(r13.c(), null, r8, OtaMode.MANUAL, 0, 0, 0, false, null, false, null, null, 4085);
    L7:
        if (r14.d() != CheckPurpose.INSTALL) goto L9;
        v4 r5 = new v4(null, null, 0, OtaMode.MANUAL, null, r15.a(), 16375);
    L10:
        f r16 = r35;
        l r26 = r3;
        return f.a(r16, null, null, null, null, null, r22, null, null, null, r26, r5, null, null, null, null, null, null, 259007);
    L9:
        r5 = r35.f();
        goto L10
    L5:
        r35 = r13;
        r3 = l.a(r35.c(), null, 0, OtaMode.MANUAL, 0, 0, 0, false, null, false, null, null, 4087);
        goto L7
    }
}
