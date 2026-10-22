package com.bytedance.android.live.revlink.impl.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w {
    public final HashMap<Integer, Integer> a;
    public final HashMap<Integer, Integer> b;
    public final HashMap<Integer, Integer> c;

    public w() {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
    }

    public static int a(Map r6) {
        HashMap r7 = (HashMap) r6;
        Iterator r0 = r7.keySet().iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L14;
        int r4 = ((Number) r0.next()).intValue();
        Integer r5 = (Integer) r7.get(Integer.valueOf(r4));
        if (r5 == null) goto L8;
        int r8 = r5.intValue();
    L9:
        r2 = r2 + r8;
        Integer r9 = (Integer) r7.get(Integer.valueOf(r4));
        if (r9 == null) goto L12;
        int r10 = r9.intValue();
    L13:
        r3 = r3 + (r4 * r10);
        goto L4
    L12:
        r10 = 0;
        goto L13
    L8:
        r8 = 0;
        goto L9
    L14:
        if (r2 != 0) goto L17;
        return 0;
    L17:
        return r3 / r2;
    }
}
