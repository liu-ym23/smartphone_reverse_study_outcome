package com.bytedance.android.live.core.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z0 {
    public static final <K, V> Map.Entry<K, V> a(Map<K, ? extends V> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$firstEntryOfMap");
        if (r1.entrySet().iterator().hasNext() == true) goto L5;
        return null;
    L5:
        return r1.entrySet().iterator().next();
    }

    public static final <T> T b(h80.c<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$value");
        T r2 = r1.a;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2;
    }

    public static final String c(Object r0) {
        if (r0 == null) goto L4;
        int r1 = r0.hashCode();
    L6:
        return Integer.toHexString(r1);
    L4:
        r1 = 0;
        goto L6
    }
}
