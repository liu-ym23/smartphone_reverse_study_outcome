package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f0 implements am3.c<OptItem> {
    public f0() {
    }

    public static OptItem a(am3.g r5) throws Exception {
        OptItem r0 = new OptItem();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.itemId = r5.j();
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.area = r5.j();
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.priority = r5.j();
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
