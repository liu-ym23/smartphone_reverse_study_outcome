package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n0 implements am3.c<m> {
    public n0() {
    }

    public static m a(am3.g r5) throws Exception {
        m r0 = new m();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L14;
        switch(r3) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        r0.nfaInfo = new s(r5);
        goto L3
    L8:
        r0.featureType = r5.i();
        goto L3
    L9:
        r0.featureValue = m0.a(r5);
        goto L3
    L10:
        r0.refreshInterval = r5.i();
        goto L3
    L11:
        r0.timeliness = r5.i();
        goto L3
    L12:
        r0.source = r5.i();
        goto L3
    L13:
        r0.name = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L14:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
