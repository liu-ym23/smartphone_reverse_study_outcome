package com.obric.aikernel.utils;

import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f5601a = null;

    static {
        f5601a = new k();
    }

    private k() {
    }

    public final String a() {
        return com.obric.aikernel.api.b.f4431a.a().f();
    }

    public final String b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Class<?> r12 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L5
        Object r13 = r12.getMethod("get", new Class[]{String.class, String.class}).invoke(r12, new Object[]{r10, r11});     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L5
        return (String) r13;
    L5:
        e = move-exception;
        e.printStackTrace();
        AIKLog.INSTANCE.w("OSUtils", "get " + r10 + " failed: " + e.getMessage(), e);
        return r11;
    }
}
