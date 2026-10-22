package com.bytedance.android.live.base.model.data;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements am3.c<a> {
    public o() {
    }

    public final Object decode(am3.g r6) throws Exception {
        a r0 = new a();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.likeStatus = (int) r6.j();
        goto L3
    L7:
        am3.h.e(r6);
        goto L3
    L9:
        r6.d(r1);
        return r0;
    }
}
