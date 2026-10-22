package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t0 implements am3.c<v> {
    public t0() {
    }

    public final Object decode(am3.g r6) throws Exception {
        v r0 = new v();
        r0.strategies = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.strategies.add(x0.a(r6));
        goto L3
    L7:
        am3.h.e(r6);
        goto L3
    L9:
        r6.d(r1);
        return r0;
    }
}
