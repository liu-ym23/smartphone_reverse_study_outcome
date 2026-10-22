package com.bytedance.monitor.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Field> f2884a = null;

    static {
        f2884a = new HashMap();
    }

    public static Object a(Object r1, String r2) {
        Field r3 = a(r1.getClass(), r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return a(r3, r1);
    }

    public static Object a(Field r1, Object r2) {
        if (r1.isAccessible() == true) goto L6;
        r1.setAccessible(true);
    L6:
        return r1.get(r2);
    }

    public static Field a(Class<?> r5, String r6) {
        String r0 = b(r5, r6);
        Map<String, Field> r1 = f2884a;
        monitor-enter(r1);
        Field r2 = (Field) ZeusTransformUtils.preCheckCast(r1.get(r0), Field.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        monitor-exit(r1);     // Catch: Throwable -> L27
        if (r2 != null) goto L9;
    L12:
        if (r5 == null) goto L25;
        Field r3 = r5.getDeclaredField(r6);     // Catch: NoSuchFieldException -> L24
        if (r3.isAccessible() == true) goto L16;
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L24
    L16:
        Map<String, Field> r4 = f2884a;     // Catch: NoSuchFieldException -> L24
        monitor-enter(r4);     // Catch: NoSuchFieldException -> L24
        r4.put(r0, r3);     // Catch: Throwable -> L21
        monitor-exit(r4);     // Catch: Throwable -> L21
    L20:
        return r3;
    L21:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L24
    L24:
        r5 = r5.getSuperclass();
        goto L12
    L25:
        return null;
    L9:
        if (r2.isAccessible() == true) goto L11;
        r2.setAccessible(true);
    L11:
        return r2;
    L27:
        th = move-exception;
        throw th;
    }

    private static String b(Class<?> r2, String r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.toString()).append("#").append(r3);
        return r0.toString();
    }
}
