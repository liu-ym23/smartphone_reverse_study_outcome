package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g0 implements am3.c<e> {
    public g0() {
    }

    public static e a(am3.g r5) throws Exception {
        e r0 = new e();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.operator = am3.h.c(r5);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.left = d0.a(r5);
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.right = d0.a(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
