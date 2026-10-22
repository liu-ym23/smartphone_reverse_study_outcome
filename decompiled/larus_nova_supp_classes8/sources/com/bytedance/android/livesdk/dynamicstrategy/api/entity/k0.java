package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k0 implements am3.c<i> {
    public k0() {
    }

    public static i a(am3.g r10) throws Exception {
        i r0 = new i();
        r0.defaultBooleanArrayValue = new ArrayList();
        r0.defaultMapValue = new HashMap();
        r0.defaultLongArrayValue = new ArrayList();
        r0.defaultStringArrayValue = new ArrayList();
        r0.defaultDoubleArrayValue = new ArrayList();
        long r1 = r10.c();
    L3:
        int r3 = r10.f();
        if (r3 == (-1)) goto L34;
        switch(r3) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        r0.defaultDoubleArrayValue.add(Double.valueOf(Double.longBitsToDouble(r10.h())));
        goto L3
    L8:
        r0.defaultBooleanArrayValue.add(Boolean.valueOf(am3.h.a(r10)));
        goto L3
    L9:
        r0.defaultStringArrayValue.add(am3.h.c(r10));
        goto L3
    L10:
        r0.defaultLongArrayValue.add(Long.valueOf(r10.j()));
        goto L3
    L11:
        long r5 = r10.c();
        String r4 = null;
        String r7 = null;
    L12:
        int r8 = r10.f();
        if (r8 == (-1)) goto L21;
        if (r8 != 1) goto L17;
        r4 = am3.h.c(r10);
        goto L12
    L17:
        if (r8 != 2) goto L12;
        r7 = am3.h.c(r10);
        goto L12
    L21:
        r10.d(r5);
        if (r4 == null) goto L28;
        if (r7 == null) goto L26;
        r0.defaultMapValue.put(r4, r7);
        goto L3
    L26:
        throw new IllegalStateException("Map value must not be null!");
    L28:
        throw new IllegalStateException("Map key must not be null!");
    L29:
        r0.defaultBooleanValue = am3.h.a(r10);
        goto L3
    L30:
        r0.defaultStringValue = am3.h.c(r10);
        goto L3
    L31:
        r0.defaultDoubleValue = Double.longBitsToDouble(r10.h());
        goto L3
    L32:
        r0.defaultLongValue = r10.j();
        goto L3
    L33:
        r0.resultType = r10.i();
        goto L3
    L6:
        am3.h.e(r10);
        goto L3
    L34:
        r10.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
