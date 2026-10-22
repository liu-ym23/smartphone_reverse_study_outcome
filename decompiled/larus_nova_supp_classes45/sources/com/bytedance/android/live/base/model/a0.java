package com.bytedance.android.live.base.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 implements am3.c<q> {
    public a0() {
    }

    public static q a(am3.g r5) throws Exception {
        q r0 = new q();
        r0.businessList = new ArrayList();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L20;
        switch(r3) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        r0.accessibleName = am3.h.c(r5);
        goto L3
    L8:
        r0.animationShowTimes = r5.i();
        goto L3
    L9:
        r0.imgLayers = c0.a(r5);
        goto L3
    L10:
        r0.businessList.add(am3.h.c(r5));
        goto L3
    L11:
        r0.animationType = r5.i();
        goto L3
    L12:
        r0.showAnimation = r5.i();
        goto L3
    L13:
        r0.jumpSchema = am3.h.c(r5);
        goto L3
    L14:
        r0.imageUrl = am3.h.c(r5);
        goto L3
    L15:
        r0.height = r5.i();
        goto L3
    L16:
        r0.width = r5.i();
        goto L3
    L17:
        r0.containerType = r5.i();
        goto L3
    L18:
        r0.fallbackUrl = am3.h.c(r5);
        goto L3
    L19:
        r0.loadUrl = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L20:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
