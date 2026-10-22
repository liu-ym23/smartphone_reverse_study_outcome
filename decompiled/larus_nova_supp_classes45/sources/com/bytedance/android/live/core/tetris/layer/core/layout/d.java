package com.bytedance.android.live.core.tetris.layer.core.layout;

import j70.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Map r3, f r4, f r5) {
        List r6 = (List) ((LinkedHashMap) r3).get(r4);
        if (r6 != null) goto L6;
        return false;
    L6:
        if (r6.contains(r5) == false) goto L8;
        return true;
    L8:
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        if (a(r3, (f) r7.next(), r5) == false) goto L10;
        return true;
    L14:
        return false;
    }

    public static void c(Map r4, Map r5, f r6) {
        LinkedHashMap r0 = (LinkedHashMap) r5;
        Integer r1 = (Integer) r0.get(r6);
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L7:
        if (r5.containsKey(r6) == true) goto L9;
        r5.put(r6, Integer.valueOf(r2));
    L9:
        List r7 = (List) ((LinkedHashMap) r4).get(r6);
        if (r7 == null) goto L20;
        Iterator r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L29;
        f r3 = (f) r8.next();
        if (r5.containsKey(r3) == true) goto L16;
        r5.put(r3, Integer.valueOf(r2 + 1));
        c(r4, r5, r3);
        goto L13
    L16:
        Object r9 = r0.get(r3);
        Intrinsics.checkNotNull(r9);
        if (r2 < ((Number) r9).intValue()) goto L13;
        r5.put(r3, Integer.valueOf(r2 + 1));
        c(r4, r5, r3);
        goto L13
    L29:
        return;
    L20:
        return;
    L5:
        r2 = 0;
        goto L7
    }

    public static void b(Map r1, Map r2, f r3, f r4) throws CircleDependException {
        if (a(r1, r4, r3) == true) goto L16;
        if (a(r1, r3, r4) == false) goto L8;
        return;
    L8:
        if (r1.containsKey(r3) == true) goto L10;
        r1.put(r3, new ArrayList());
    L10:
        List r0 = (List) ((LinkedHashMap) r1).get(r3);
        if (r0 == null) goto L13;
        r0.add(r4);
    L13:
        c(r1, r2, r3);
        return;
    L16:
        throw new CircleDependException("发现了循环依赖");
    }
}
