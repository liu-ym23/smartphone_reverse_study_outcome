package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class t2 implements Function1 {
    public /* synthetic */ t2() {
    }

    public final Object invoke(Object r20) {
        f r0 = (f) r20;
        Intrinsics.checkNotNullParameter(r0, "current");
        a5 r2 = r0.j();
        d5 r1 = null;
        if (r2 != null) goto L5;
        a5 r17 = null;
    L10:
        f5 r3 = r0.l();
        ManualOnlyReason r12 = r0.l().e();
        if (r12 != null) goto L13;
        r12 = ManualOnlyReason.MANUAL_INSTALL;
    L13:
        d5 r13 = r0.l().d();
        if (r13 != null) goto L25;
        e5 r14 = r0.l().h();
        if (r14 == null) goto L18;
        r13 = r14.h();
    L19:
        if (r13 != null) goto L25;
        e5 r15 = r0.h();
        if (r15 == null) goto L23;
        r1 = r15.h();
    L23:
        r13 = r1;
        goto L25
    L18:
        r13 = null;
    L25:
        return f.a(r0, null, null, null, null, null, null, null, f5.a(r3, null, null, 0, 0, 0, null, r12, r13, 127), null, null, null, null, null, null, null, null, r17, 130815);
    L5:
        if (r2.f() == false) goto L7;
        a5 r4 = a5.a(r2, 0, false, null, 0, 115);
    L8:
        r17 = r4;
        goto L10
    L7:
        r4 = null;
        goto L8
    }
}
