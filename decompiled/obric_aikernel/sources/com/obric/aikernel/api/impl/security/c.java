package com.obric.aikernel.api.impl.security;

import android.content.Context;
import android.os.Bundle;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.runtime.utils.i;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f4467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Class<?> f4468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Object f4469c;

    static {
        f4467a = new c();
    }

    private c() {
    }

    private final Object b() {
        Method r10 = c().getMethod("getInstance", new Class[0]);
        Intrinsics.checkNotNullExpressionValue(r10, "getManagerClass().getMethod(\"getInstance\")");
        Object r11 = r10.invoke(null, new Object[0]);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalArgumentException("RotProvisionManager.getInstance() returned null".toString());
    }

    private final Class<?> c() {
        Class<?> r10 = f4468b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        monitor-enter(this);
        Class<?> r11 = f4468b;     // Catch: Throwable -> L12
        if (r11 != null) goto L9;
        r11 = Class.forName(i.g());     // Catch: Throwable -> L12
        f4468b = r11;     // Catch: Throwable -> L12
    L9:
        monitor-exit(this);
        Intrinsics.checkNotNullExpressionValue(r11, "synchronized(this) {\n   …t\n            }\n        }");
        return r11;
    L12:
        th = move-exception;
        throw th;
    }

    private final Object d() {
        Object r10 = f4469c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        monitor-enter(this);
        Object r11 = f4469c;     // Catch: Throwable -> L11
        if (r11 != null) goto L9;
        r11 = f4467a.b();     // Catch: Throwable -> L11
        f4469c = r11;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r11;
    L11:
        th = move-exception;
        throw th;
    }

    private final Object e(String r10, Class<?>[] r11, Object[] r12) {
        return c().getMethod(r10, (Class[]) Arrays.copyOf(r11, r11.length)).invoke(d(), Arrays.copyOf(r12, r12.length));
    }

    public final String a(Context r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "args");
        Object r12 = e("checkState", new Class[]{Context.class, Bundle.class}, new Object[]{r10, r11});
        String r13 = a.f4466a.a(r12);
        if (r13 == null) goto L16;
    L15:
        return r13;
    L16:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L13
        AIKLog r15 = AIKLog.INSTANCE;     // Catch: Throwable -> L13
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L13
        r16.append("checkState returned ");     // Catch: Throwable -> L13
        if (r12 == null) goto L7;
        String r17 = r12.getClass().getName();     // Catch: Throwable -> L13
    L8:
        if (r17 != null) goto L10;
        r17 = "null";
    L11:
        r16.append(r17);     // Catch: Throwable -> L13
        r15.w("RotProvisionManagerBridge", r16.toString());     // Catch: Throwable -> L13
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        goto L15
    L10:
        Intrinsics.checkNotNullExpressionValue(r17, "result?.javaClass?.name ?: \"null\"");     // Catch: Throwable -> L13
        goto L11
    L7:
        r17 = null;
    L13:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
