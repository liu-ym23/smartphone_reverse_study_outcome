package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements am3.c<b> {
    public t() {
    }

    public static b a(am3.g r5) throws Exception {
        b r0 = new b();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.content = am3.h.c(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
