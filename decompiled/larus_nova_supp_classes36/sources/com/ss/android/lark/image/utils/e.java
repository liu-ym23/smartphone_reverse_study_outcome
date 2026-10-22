package com.ss.android.lark.image.utils;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static Object a(Object r3, String r4) {
        Class<?> r0 = r3.getClass();
    L4:
        if (r0 == Object.class) goto L8;
        Field r5 = r0.getDeclaredField(r4);     // Catch: Exception -> L7
    L9:
        r5.setAccessible(true);
        return r5.get(r3);
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L7:
        r0 = r0.getSuperclass();
        goto L4
    L8:
        r5 = null;
        goto L9
    }

    public static boolean b(Object r2, String r3, Object r4) {
        Class<?> r0 = r2.getClass();     // Catch: NullPointerException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
    L4:
        if (r0 == Object.class) goto L14;
        Field r5 = r0.getDeclaredField(r3);     // Catch: Exception -> L7
    L15:
        r5.setAccessible(true);     // Catch: NullPointerException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
        r5.set(r2, r4);     // Catch: NullPointerException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
        return true;
    L7:
        r0 = r0.getSuperclass();     // Catch: NullPointerException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
        goto L4
    L14:
        r5 = null;
    L10:
        e = e;
    L17:
        e.printStackTrace();
        return false;
    L12:
        e = e;
    L8:
        e = e;
        goto L17
    }
}
