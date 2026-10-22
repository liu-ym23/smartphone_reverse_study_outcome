package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements am3.c<MicDress.LinkmicBadge> {
    public n() {
    }

    public final Object decode(am3.g r7) throws Exception {
        MicDress.LinkmicBadge r0 = new MicDress.LinkmicBadge();
        r0.setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L12;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L8;
        r0.dressId = am3.h.c(r7);
        goto L3
    L8:
        if (r3 != 2) goto L9;
        r0.showType = r7.i();
        goto L3
    L9:
        am3.h.d(r4, r7);
        goto L3
    L12:
        r7.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }
}
