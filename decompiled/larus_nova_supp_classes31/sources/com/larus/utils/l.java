package com.larus.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l {
    public static final WeakHashMap<Object, Map<String, Object>> a = null;

    static {
        a = new WeakHashMap();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Extras.kt uses a process-global weak-key cache, but values are strongly referenced and may leak lifecycle-bound objects. Do not add new usages. Use explicit fields, lifecycle-bound state, View.setTag(id, value), or a module-owned cache with clear cleanup instead.")
    public static final void a(rt8.a r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Result.constructor-impl(a.remove(r1));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Extras.kt uses a process-global weak-key cache, but values are strongly referenced and may leak lifecycle-bound objects. Do not add new usages. Use explicit fields, lifecycle-bound state, View.setTag(id, value), or a module-owned cache with clear cleanup instead.")
    public static final <T> T b(Object r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        WeakHashMap<Object, Map<String, Object>> r0 = a;
        monitor-enter(r0);
        Map<String, Object> r3 = r0.get(r1);     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        T r4 = (T) r3.get(r2);
        if (r4 == null) goto L9;
    L10:
        monitor-exit(r0);
        return r4;
    L9:
        r4 = null;
    L12:
        th = move-exception;
        throw th;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Extras.kt uses a process-global weak-key cache, but values are strongly referenced and may leak lifecycle-bound objects. Do not add new usages. Use explicit fields, lifecycle-bound state, View.setTag(id, value), or a module-owned cache with clear cleanup instead.")
    public static final void d(Object r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        WeakHashMap<Object, Map<String, Object>> r0 = a;
        monitor-enter(r0);
        Map<String, Object> r3 = r0.get(r1);     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        r3.remove(r2);     // Catch: Throwable -> L11
    L8:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Extras.kt uses a process-global weak-key cache, but values are strongly referenced and may leak lifecycle-bound objects. Do not add new usages. Use explicit fields, lifecycle-bound state, View.setTag(id, value), or a module-owned cache with clear cleanup instead.")
    public static final void c(Object r2, String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        WeakHashMap<Object, Map<String, Object>> r0 = a;
        monitor-enter(r0);
        Map<String, Object> r1 = r0.get(r2);     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r1 = new LinkedHashMap();     // Catch: Throwable -> L10
        r0.put(r2, r1);     // Catch: Throwable -> L10
    L7:
        r1.put(r3, r4);     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
