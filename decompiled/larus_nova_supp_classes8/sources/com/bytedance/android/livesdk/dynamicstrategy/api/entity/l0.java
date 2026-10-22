package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l0 implements am3.c<j> {
    public l0() {
    }

    public static j a(am3.g r5) throws Exception {
        j r0 = new j();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.value = Double.longBitsToDouble(r5.h());
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
