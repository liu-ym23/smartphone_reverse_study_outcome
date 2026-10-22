package com.obric.aikernel.runtime.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f5429a = null;

    static {
        f5429a = new g();
    }

    private g() {
    }

    public static /* synthetic */ String b(g r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return r10.a(r11, r12);
    }

    public final String a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Class<?> r12 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L5
        Object r13 = r12.getMethod("get", new Class[]{String.class, String.class}).invoke(r12, new Object[]{r10, r11});     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L5
        return (String) r13;
    L5:
        e = move-exception;
        d.f5417a.l("OSUtils", "get " + r10 + " failed: " + e);
        return r11;
    }
}
