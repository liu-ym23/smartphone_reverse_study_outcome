package com.bytedance.android.live.base.model.user;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v0 implements am3.c<PublicAreaBadgeInfo.WebcastDslBadgeList> {
    public v0() {
    }

    public static PublicAreaBadgeInfo.WebcastDslBadgeList a(am3.g r6) throws Exception {
        PublicAreaBadgeInfo.WebcastDslBadgeList r0 = new PublicAreaBadgeInfo.WebcastDslBadgeList();
        r0.badgeList = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.badgeList.add(Long.valueOf(r6.j()));
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.targetDslRule = t0.a(r6);
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.filterDslRule = t0.a(r6);
        goto L3
    L11:
        am3.h.e(r6);
        goto L3
    L15:
        r6.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
