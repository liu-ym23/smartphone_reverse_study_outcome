package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i0 implements am3.c<g> {
    public i0() {
    }

    public static g a(am3.g r5) throws Exception {
        g r0 = new g();
        r0.arguments = new ArrayList();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L12;
        if (r3 != 1) goto L8;
        r0.caller = o0.a(r5);
        goto L3
    L8:
        if (r3 != 2) goto L9;
        r0.arguments.add(d0.a(r5));
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
