package com.bytedance.android.live.revlink.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t {
    public static final long a(long r2) {
        i97.a r0 = i97.a.a;
        return System.currentTimeMillis() - r2;
    }

    public static final void b(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r2, "tag");
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(jy0.c.class));
        Intrinsics.checkNotNull(r1);
        jy0.c r4 = (jy0.c) ((f80.a) r1);
        if (r3 == null) goto L5;
        StackTraceElement[] r5 = r3.getStackTrace();
    L6:
        r4.stacktrace(6, r2, r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
