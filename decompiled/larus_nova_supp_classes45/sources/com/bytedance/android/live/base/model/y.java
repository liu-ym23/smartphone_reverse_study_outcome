package com.bytedance.android.live.base.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y implements am3.c<o> {
    public y() {
    }

    public static o a(am3.g r5) throws Exception {
        o r0 = new o();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L21;
        if (r3 != 1) goto L8;
        r0.bigCardUrl = am3.h.c(r5);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.containerType = r5.i();
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.width = r5.i();
        goto L3
    L12:
        if (r3 != 4) goto L14;
        r0.height = r5.i();
        goto L3
    L14:
        if (r3 != 5) goto L15;
        r0.duration = r5.i();
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
