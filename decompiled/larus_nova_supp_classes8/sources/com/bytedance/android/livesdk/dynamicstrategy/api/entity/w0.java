package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w0 implements am3.c<z> {
    public w0() {
    }

    public final Object decode(am3.g r6) throws Exception {
        z r0 = new z();
        r0.fullStrategies = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.incrementStrategies = p0.a(r6);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.fullStrategies.add(x0.a(r6));
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.responseType = r6.i();
        goto L3
    L11:
        am3.h.e(r6);
        goto L3
    L15:
        r6.d(r1);
        return r0;
    }
}
