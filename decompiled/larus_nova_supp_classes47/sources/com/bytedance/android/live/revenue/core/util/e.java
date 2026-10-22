package com.bytedance.android.live.revenue.core.util;

import com.bytedance.android.scope.m;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    static {
        h.c();
    }

    @JvmStatic
    public static final <T extends com.bytedance.live.kmp.core.c> T a(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        m r0 = m.e;
        cy0.e.a.getClass();
        T r1 = (T) r0.d(cy0.e.a.a, r2);
        if (r1 == null) goto L5;
        return r1;
    L5:
        c.a(r2);
        throw null;
    }

    @JvmStatic
    public static final <T extends com.bytedance.live.kmp.core.d> T b(com.bytedance.android.live.revenue.core.b r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "instance");
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        T r3 = (T) m.e.d(r1.e(), r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        c.a(r2);
        throw null;
    }

    @JvmStatic
    public static final <T extends com.bytedance.live.kmp.core.d> T c(com.bytedance.android.live.revenue.core.b r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        if (r1 != null) goto L7;
        return null;
    L7:
        return (T) m.e.d(r1.e(), r2);
    }
}
