package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m0 implements am3.c<n> {
    public m0() {
    }

    public static n a(am3.g r10) throws Exception {
        n r0 = new n();
        r0.booleanArrayVal = new ArrayList();
        r0.longArrayVal = new ArrayList();
        r0.stringArrayVal = new ArrayList();
        r0.mapVal = new HashMap();
        r0.doubleArrayVal = new ArrayList();
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
        r0.doubleArrayVal.add(Double.valueOf(Double.longBitsToDouble(r10.h())));
        goto L3
    L8:
        r0.booleanArrayVal.add(Boolean.valueOf(am3.h.a(r10)));
        goto L3
    L9:
        r0.stringArrayVal.add(am3.h.c(r10));
        goto L3
    L10:
        r0.longArrayVal.add(Long.valueOf(r10.j()));
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
        r0.mapVal.put(r4, r7);
        goto L3
    L26:
        throw new IllegalStateException("Map value must not be null!");
    L28:
        throw new IllegalStateException("Map key must not be null!");
    L29:
        r0.stringVal = am3.h.c(r10);
        goto L3
    L30:
        r0.float64Val = Double.longBitsToDouble(r10.h());
        goto L3
    L31:
        r0.boolVal = am3.h.a(r10);
        goto L3
    L32:
        r0.int64Val = r10.j();
        goto L3
    L33:
        r0.valType = r10.i();
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
