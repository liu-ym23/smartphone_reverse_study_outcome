package com.bytedance.android.live.base.model.user;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t0 implements am3.c<PublicAreaBadgeInfo.DslRule> {
    public t0() {
    }

    public static PublicAreaBadgeInfo.DslRule a(am3.g r11) throws Exception {
        PublicAreaBadgeInfo.DslRule r0 = new PublicAreaBadgeInfo.DslRule();
        r0.versionCode = new ArrayList();
        r0.abParams = new HashMap();
        r0.appId = new ArrayList();
        long r1 = r11.c();
    L3:
        int r3 = r11.f();
        if (r3 == (-1)) goto L30;
        if (r3 != 1) goto L8;
        r0.appId.add(Long.valueOf(r11.j()));
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.versionCode.add(Long.valueOf(r11.j()));
        goto L3
    L10:
        if (r3 != 3) goto L11;
        long r7 = r11.c();
        String r4 = null;
        String r9 = null;
    L13:
        int r12 = r11.f();
        if (r12 == (-1)) goto L20;
        if (r12 != 1) goto L16;
        r4 = am3.h.c(r11);
        goto L13
    L16:
        if (r12 != 2) goto L13;
        r9 = am3.h.c(r11);
        goto L13
    L20:
        r11.d(r7);
        if (r4 == null) goto L27;
        if (r9 == null) goto L25;
        r0.abParams.put(r4, r9);
        goto L3
    L25:
        throw new IllegalStateException("Map value must not be null!");
    L27:
        throw new IllegalStateException("Map key must not be null!");
    L11:
        am3.h.e(r11);
        goto L3
    L30:
        r11.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
