package com.bytedance.android.live.browser;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 {
    public static final ArrayList<Class<? extends Object>> a = null;

    static {
        a = new ArrayList();
    }

    public static void a(Class r2) {
        Intrinsics.checkNotNullParameter(r2, "method");
        ArrayList<Class<? extends Object>> r0 = a;
        if (r0.contains(r2) == true) goto L6;
        r0.add(r2);
        return;
    }

    public static void b(ArrayList r3) {
        Intrinsics.checkNotNullParameter(r3, "bridgeList");
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Class<? extends Object> r0 = (Class) r4.next();
        ArrayList<Class<? extends Object>> r1 = a;
        if (r1.contains(r0) == true) goto L4;
        r1.add(r0);
        goto L4
    }
}
