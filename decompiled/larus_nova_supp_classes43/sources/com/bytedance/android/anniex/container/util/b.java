package com.bytedance.android.anniex.container.util;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final ia.c a(IBDXBridgeContext r1) {
        if (r1 == null) goto L8;
        m16.b r10 = (m16.b) r1.getService(m16.b.class);
        if (r10 == null) goto L10;
        ia.c r11 = (ia.c) r10.c(ia.c.class);
        if ((r11 instanceof ia.d) == false) goto L11;
        return r11;
    L11:
        return null;
    L10:
        return null;
    L8:
        return null;
    }

    public static final ia.c b(IBDXBridgeContext r1) {
        if (r1 == null) goto L8;
        m16.b r10 = (m16.b) r1.getService(m16.b.class);
        if (r10 == null) goto L10;
        ia.c r11 = (ia.c) r10.c(ia.c.class);
        if ((r11 instanceof com.bytedance.android.anniex.container.d) == false) goto L11;
        return r11;
    L11:
        return null;
    L10:
        return null;
    L8:
        return null;
    }
}
