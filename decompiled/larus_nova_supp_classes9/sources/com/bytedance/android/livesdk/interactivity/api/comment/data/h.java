package com.bytedance.android.livesdk.interactivity.api.comment.data;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements am3.c<IntercomChangeSyncData> {
    public h() {
    }

    public final Object decode(am3.g r6) throws Exception {
        IntercomChangeSyncData r0 = new IntercomChangeSyncData();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L12;
        if (r3 != 1) goto L8;
        r0.intercomStatus = r6.j();
        goto L3
    L8:
        if (r3 != 2) goto L9;
        r0.closeReason = r6.j();
        goto L3
    L9:
        am3.h.e(r6);
        goto L3
    L12:
        r6.d(r1);
        return r0;
    }
}
