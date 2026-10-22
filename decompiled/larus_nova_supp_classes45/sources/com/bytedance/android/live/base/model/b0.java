package com.bytedance.android.live.base.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 implements am3.c<q.a.C0014a> {
    public b0() {
    }

    public static q.a.C0014a a(am3.g r5) throws Exception {
        q.a.C0014a r0 = new q.a.C0014a();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L13;
        switch(r3) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        r0.radius = r5.i();
        goto L3
    L8:
        r0.height = r5.i();
        goto L3
    L9:
        r0.width = r5.i();
        goto L3
    L10:
        r0.y = r5.i();
        goto L3
    L11:
        r0.x = r5.i();
        goto L3
    L12:
        r0.url = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
