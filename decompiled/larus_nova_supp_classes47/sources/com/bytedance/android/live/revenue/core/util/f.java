package com.bytedance.android.live.revenue.core.util;

import com.bytedance.android.scope.m;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final <T extends dy0.c> T a(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        h.c();
        m r0 = m.e;
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        T r3 = (T) r0.d(r1, r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        b.a(r2, r1);
        throw null;
    }

    @JvmStatic
    public static final <T extends f80.b> T b(com.bytedance.android.live.revenue.core.b r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        Intrinsics.checkNotNullParameter(r3, "serviceCls");
        h.c();
        com.bytedance.android.live.revenue.core.a r4 = (com.bytedance.android.live.revenue.core.a) r2;
        Intrinsics.checkNotNullParameter(r4, "instance");
        Intrinsics.checkNotNullParameter(r3, "serviceCls");
        h.c();
        T r0 = (T) m.e.d(r4.getScope(), r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        b.a(r3, r4.getScope());
        throw null;
    }

    @JvmStatic
    public static final <T extends f80.b> T c(com.bytedance.android.live.revenue.core.a r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        h.c();
        if (r1 != null) goto L7;
        return null;
    L7:
        return (T) m.e.d(r1.getScope(), r2);
    }

    @JvmStatic
    public static final <T extends f80.b> T d(com.bytedance.android.live.revenue.core.b r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "serviceCls");
        h.c();
        if ((r2 instanceof com.bytedance.android.live.revenue.core.a) == true) goto L5;
        r2 = null;
    L5:
        com.bytedance.android.live.revenue.core.a r4 = (com.bytedance.android.live.revenue.core.a) r2;
        if (r4 != null) goto L8;
        return null;
    L8:
        return (T) c(r4, r3);
    }
}
