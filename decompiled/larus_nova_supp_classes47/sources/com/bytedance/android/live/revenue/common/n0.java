package com.bytedance.android.live.revenue.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n0 {
    public static final pc0.e a(m0 r9) {
        Intrinsics.checkNotNullParameter(pc0.e.f, "$this$from");
        Intrinsics.checkNotNullParameter(r9, "rtcData");
        fr2.e r0 = r9.a;
        fr2.p r1 = r9.d;
        if (r0 == null) goto L5;
        vc0.a r3 = vc0.b.a(r0);
    L6:
        boolean r4 = r9.b;
        vc0.c r5 = new vc0.c(r9.c);
        if (r1 == null) goto L9;
        vc0.a r6 = vc0.b.a(r1);
    L11:
        return new pc0.e(r3, r4, r5, r6, r9.e);
    L9:
        r6 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }
}
