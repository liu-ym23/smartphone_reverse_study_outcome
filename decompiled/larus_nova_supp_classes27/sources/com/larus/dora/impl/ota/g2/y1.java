package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class y1 implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ s$i c;

    public /* synthetic */ y1(long r1, boolean r3, s$i r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    public final Object invoke(Object r51) {
        long r14 = this.a;
        boolean r1 = this.b;
        s$i r13 = this.c;
        f r12 = (f) r51;
        Intrinsics.checkNotNullParameter(r12, "it");
        l r17 = r12.c();
        if (r1 == false) goto L5;
        long r22 = r14;
    L6:
        if (r1 == false) goto L8;
        f r36 = r12;
        int r2 = l.a(r12.c(), null, 0, null, r14, 0, 0, false, null, false, null, null, 4079).n();
    L9:
        long r8 = r22;
        l r27 = l.a(r17, null, 0, null, r14, r8, r2, false, null, false, null, null, 3983);
        f r18 = r36;
        return f.a(r18, null, null, null, null, null, null, null, f5.a(r36.l(), null, null, r13.c(), r13.c() + j0.G2_OTA_PARTIAL_TTL_MS, 0, null, null, null, 491), null, r27, null, null, null, null, null, null, null, 260863);
    L8:
        r36 = r12;
        r2 = r36.c().f();
        goto L9
    L5:
        r22 = r12.c().e();
        goto L6
    }
}
