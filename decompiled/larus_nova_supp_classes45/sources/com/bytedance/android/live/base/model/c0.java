package com.bytedance.android.live.base.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0 implements am3.c<q.a> {
    public c0() {
    }

    public static q.a a(am3.g r5) throws Exception {
        q.a r0 = new q.a();
        r0.layers = new ArrayList();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.layers.add(b0.a(r5));
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.baseWidth = r5.i();
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.baseHeight = r5.i();
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
