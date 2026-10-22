package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.android.live.base.model.message.a5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements am3.c<RiskAdviseSyncData> {
    public q() {
    }

    public final Object decode(am3.g r6) throws Exception {
        RiskAdviseSyncData r0 = new RiskAdviseSyncData();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L12;
        if (r3 != 1) goto L8;
        r0.createTime = r6.j();
        goto L3
    L8:
        if (r3 != 2) goto L9;
        r0.adviseText = (a5) vh7.f.a(r6, a5.class);
        goto L3
    L9:
        am3.h.e(r6);
        goto L3
    L12:
        r6.d(r1);
        return r0;
    }
}
