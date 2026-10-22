package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d1 implements Function1 {
    public final /* synthetic */ g5 a;
    public final /* synthetic */ s$g b;

    public /* synthetic */ d1(g5 r1, s$g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r32) {
        g5 r1 = this.a;
        s$g r2 = this.b;
        f r3 = (f) r32;
        Intrinsics.checkNotNullParameter(r3, "it");
        PackagePhase r13 = PackagePhase.PARTIAL;
        e5 r14 = r1.f();
        long r15 = r2.b();
        long r110 = r2.b() + j0.G2_OTA_PARTIAL_TTL_MS;
        ManualOnlyReason r24 = r1.b();
        d5 r4 = r1.f().h();
        if (r1.b() == null) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        d5 r25 = r4;
    L10:
        return f.a(r3, null, null, null, null, null, null, null, new f5(r13, r14, r15, 0, r110, 0, null, r24, r25, 104), null, new l(null, 0, null, null, false, false, null, null, 4095), null, null, null, null, null, null, null, 260863);
    L8:
        r25 = null;
        goto L10
    L5:
        r5 = false;
        goto L6
    }
}
