package com.bytedance.crash.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class FieldUtils {
    private static final Map<String, Field> FIELD_CACHE = null;

    static {
        FIELD_CACHE = new HashMap();
    }

    private FieldUtils() {
    }

    public static Field getField(Class<?> r10, String r11) {
        String r12 = getKey(r10, r11);
        Map<String, Field> r13 = FIELD_CACHE;
        monitor-enter(r13);
        Field r14 = r13.get(r12);     // Catch: Throwable -> L27
        monitor-exit(r13);     // Catch: Throwable -> L27
        if (r14 != null) goto L9;
    L12:
        if (r10 == null) goto L25;
        Field r15 = r10.getDeclaredField(r11);     // Catch: NoSuchFieldException -> L24
        if (r15.isAccessible() == true) goto L16;
        r15.setAccessible(true);     // Catch: NoSuchFieldException -> L24
    L16:
        Map<String, Field> r16 = FIELD_CACHE;     // Catch: NoSuchFieldException -> L24
        monitor-enter(r16);     // Catch: NoSuchFieldException -> L24
        r16.put(r12, r15);     // Catch: Throwable -> L21
        monitor-exit(r16);     // Catch: Throwable -> L21
    L20:
        return r15;
    L21:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L24
    L24:
        r10 = r10.getSuperclass();
        goto L12
    L25:
        return null;
    L9:
        if (r14.isAccessible() == true) goto L11;
        r14.setAccessible(true);
    L11:
        return r14;
    L27:
        th = move-exception;
        throw th;
    }

    private static String getKey(Class<?> r10, String r11) {
        return r10.toString() + "#" + r11;
    }

    public static Object readField(Object r10, String r11) {
        Field r12 = getField(r10.getClass(), r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return readField(r12, r10);
    }

    public static Object readField(Field r10, Object r11) {
        if (r10.isAccessible() == true) goto L6;
        r10.setAccessible(true);
    L6:
        return r10.get(r11);
    }

    public static Object readStaticField(Class<?> r10, String r11) {
        Field r12 = getField(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return readStaticField(r12);
    }

    public static Object readStaticField(Field r10) {
        return readField(r10, null);
    }

    public static void writeField(Object r10, String r11, Object r12) {
        Field r13 = getField(r10.getClass(), r11);
        if (r13 == null) goto L6;
        writeField(r13, r10, r12);
        return;
    }

    public static void writeField(Field r10, Object r11, Object r12) {
        if (r10.isAccessible() == true) goto L5;
        r10.setAccessible(true);
    L5:
        r10.set(r11, r12);
    }

    public static void writeStaticField(Class<?> r10, String r11, Object r12) {
        Field r13 = getField(r10, r11);
        if (r13 == null) goto L6;
        writeStaticField(r13, r12);
        return;
    }

    public static void writeStaticField(Field r10, Object r11) {
        writeField(r10, null, r11);
    }
}
