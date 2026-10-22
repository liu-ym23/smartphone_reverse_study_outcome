package com.bytedance.android.ec.adapter.impl.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Map<String, Field> a = null;

    static {
        a = new HashMap();
    }

    public static Object a(Object r10) throws IllegalAccessException {
        Class<?> r1 = r10.getClass();
        String r11 = r1.toString() + "#mTargetActivity";
        Map<String, Field> r12 = a;
        monitor-enter(r12);
        Field r13 = (Field) ((HashMap) r12).get(r11);     // Catch: Throwable -> L31
        monitor-exit(r12);     // Catch: Throwable -> L31
        if (r13 != null) goto L9;
    L11:
        if (r1 == null) goto L24;
        r13 = r1.getDeclaredField("mTargetActivity");     // Catch: NoSuchFieldException -> L23
        if (r13.isAccessible() == true) goto L15;
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L23
    L15:
        Map<String, Field> r14 = a;     // Catch: NoSuchFieldException -> L23
        monitor-enter(r14);     // Catch: NoSuchFieldException -> L23
        ((HashMap) r14).put(r11, r13);     // Catch: Throwable -> L20
        monitor-exit(r14);     // Catch: Throwable -> L20
    L25:
        if (r13 != null) goto L27;
        return null;
    L27:
        if (r13.isAccessible() == true) goto L30;
        r13.setAccessible(true);
    L30:
        return r13.get(r10);
    L20:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L23
    L23:
        r1 = r1.getSuperclass();
        goto L11
    L24:
        r13 = null;
        goto L25
    L9:
        if (r13.isAccessible() == true) goto L25;
        r13.setAccessible(true);
    L31:
        th = move-exception;
        throw th;
    }
}
