package com.bytedance.android.live.base.model.user;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w0 implements am3.c<UserExtra> {
    public w0() {
    }

    public final Object decode(am3.g r6) throws Exception {
        UserExtra r0 = new UserExtra();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L12;
        if (r3 != 1) goto L8;
        r0.anonymousIsSilence = am3.h.a(r6);
        goto L3
    L8:
        if (r3 != 2) goto L9;
        r0.mysteryDetailJumpSchema = am3.h.c(r6);
        goto L3
    L9:
        am3.h.e(r6);
        goto L3
    L12:
        r6.d(r1);
        return r0;
    }
}
