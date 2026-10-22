package com.bytedance.android.ec.adapter.api.message.model;

import am3.g;
import am3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements am3.c<UpdatedCartInfo> {
    public a() {
    }

    public static UpdatedCartInfo a(g r10) throws Exception {
        UpdatedCartInfo r0 = new UpdatedCartInfo();
        long r1 = r10.c();
    L3:
        int r11 = r10.f();
        if (r11 == (-1)) goto L12;
        if (r11 != 1) goto L8;
        r0.vertical = c.a(r10);
        goto L3
    L8:
        if (r11 != 2) goto L9;
        r0.horizontal = b.a(r10);
        goto L3
    L9:
        h.e(r10);
        goto L3
    L12:
        r10.d(r1);
        return r0;
    }

    public final Object decode(g r1) throws Exception {
        return a(r1);
    }
}
