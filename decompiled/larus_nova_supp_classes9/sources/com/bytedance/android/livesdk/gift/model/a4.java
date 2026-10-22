package com.bytedance.android.livesdk.gift.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a4 implements am3.c<n0> {
    public a4() {
    }

    public static n0 a(am3.g r5) throws Exception {
        n0 r0 = new n0();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L12;
        if (r3 != 1) goto L8;
        r0.minLevel = r5.i();
        goto L3
    L8:
        if (r3 != 2) goto L9;
        r0.insertPos = r5.i();
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
