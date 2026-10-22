package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v0 implements am3.c<y> {
    public v0() {
    }

    public final Object decode(am3.g r6) throws Exception {
        y r0 = new y();
        r0.featureData = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.featureData.add(n0.a(r6));
        goto L3
    L7:
        am3.h.e(r6);
        goto L3
    L9:
        r6.d(r1);
        return r0;
    }
}
