package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x0 implements am3.c<a0> {
    public x0() {
    }

    public static a0 a(am3.g r5) throws Exception {
        a0 r0 = new a0();
        r0.features = new ArrayList();
        r0.rules = new ArrayList();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L15;
        switch(r3) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        r0.strategyStatus = r5.i();
        goto L3
    L8:
        r0.version = (int) r5.j();
        goto L3
    L9:
        r0.ruleType = r5.i();
        goto L3
    L10:
        r0.rules.add(u0.a(r5));
        goto L3
    L11:
        r0.defaultResult = k0.a(r5);
        goto L3
    L12:
        r0.features.add(n0.a(r5));
        goto L3
    L13:
        r0.strategyName = am3.h.c(r5);
        goto L3
    L14:
        r0.strategyId = r5.j();
        goto L3
    L6:
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
