package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j2 implements Function1 {
    public final /* synthetic */ s$h a;

    public /* synthetic */ j2(s$h r1) {
        this.a = r1;
    }

    public final Object invoke(Object r46) {
        s$h r1 = this.a;
        f r2 = (f) r46;
        Intrinsics.checkNotNullParameter(r2, "it");
        if (r1.a() >= r2.c().c()) goto L5;
        boolean r3 = true;
    L6:
        l r16 = r2.c();
        long r21 = r1.a();
        if (r3 == false) goto L9;
        long r4 = 0;
    L10:
        long r23 = r4;
        if (r3 == false) goto L13;
        int r25 = 0;
    L14:
        l r12 = l.a(r16, null, 0, null, r21, r23, r25, false, null, false, null, null, 3983);
        return f.a(r2, null, null, null, null, null, null, null, f5.a(r2.l(), null, null, r1.c(), r1.c() + j0.G2_OTA_PARTIAL_TTL_MS, 0, null, null, null, 491), null, r12, null, null, null, null, null, null, null, 260863);
    L13:
        r25 = r2.c().f();
        goto L14
    L9:
        r4 = r2.c().e();
        goto L10
    L5:
        r3 = false;
        goto L6
    }
}
