package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y implements am3.c<a> {
    public y() {
    }

    public final Object decode(am3.g r6) throws Exception {
        a r0 = new a();
        r0.itemList = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.itemList.add(e0.a(r6));
        goto L3
    L7:
        am3.h.e(r6);
        goto L3
    L9:
        r6.d(r1);
        return r0;
    }
}
