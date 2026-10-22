package com.bytedance.android.ec.adapter.api.message.model;

import am3.g;
import am3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements am3.c<UpdatedCartInfo.RoomCartStateVertical> {
    public c() {
    }

    public static UpdatedCartInfo.RoomCartStateVertical a(g r10) throws Exception {
        UpdatedCartInfo.RoomCartStateVertical r0 = new UpdatedCartInfo.RoomCartStateVertical();
        long r1 = r10.c();
    L3:
        int r11 = r10.f();
        if (r11 == (-1)) goto L9;
        if (r11 != 1) goto L7;
        r0.allowShowCart = h.a(r10);
        goto L3
    L7:
        h.e(r10);
        goto L3
    L9:
        r10.d(r1);
        return r0;
    }

    public final Object decode(g r1) throws Exception {
        return a(r1);
    }
}
