package com.bytedance.android.live.base.model.user;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u0 implements am3.c<PublicAreaBadgeInfo> {
    public u0() {
    }

    public static PublicAreaBadgeInfo a(am3.g r12) throws Exception {
        PublicAreaBadgeInfo r0 = new PublicAreaBadgeInfo();
        r0.badgeInfoMap = new HashMap();
        r0.badgeList = new ArrayList();
        r0.webcastDslBadgeList = new ArrayList();
        long r1 = r12.c();
    L3:
        int r3 = r12.f();
        if (r3 == (-1)) goto L29;
        if (r3 != 1) goto L7;
        long r7 = r12.c();
        Long r4 = null;
        py.k r9 = null;
    L14:
        int r11 = r12.f();
        if (r11 == (-1)) goto L21;
        if (r11 != 1) goto L17;
        r4 = Long.valueOf(r12.j());
        goto L14
    L17:
        if (r11 != 2) goto L14;
        r9 = (py.k) vh7.f.a(r12, py.k.class);
        goto L14
    L21:
        r12.d(r7);
        if (r4 == null) goto L28;
        if (r9 == null) goto L26;
        r0.badgeInfoMap.put(r4, r9);
        goto L3
    L26:
        throw new IllegalStateException("Map value must not be null!");
    L28:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        if (r3 != 2) goto L9;
        r0.badgeList.add(Long.valueOf(r12.j()));
        goto L3
    L9:
        if (r3 != 3) goto L10;
        r0.webcastDslBadgeList.add(v0.a(r12));
        goto L3
    L10:
        am3.h.e(r12);
        goto L3
    L29:
        r12.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
