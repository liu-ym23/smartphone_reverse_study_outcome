package com.bytedance.crash.util;

import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class DoubleReflectHelper {
    private DoubleReflectHelper() {
    }

    public static Field getField(Class<?> r10, String r11) {
        if (isAndroidPHigher() == false) goto L9;
        return getFieldInner(r10, r11);
    L6:
        return null;
    L9:
        return FieldUtils.getField(r10, r11);
    }

    public static Field getFieldInner(Class<?> r10, String r11) {
        Field r12 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r10, new Object[]{r11});     // Catch: Throwable -> L4
        r12.setAccessible(true);     // Catch: Throwable -> L4
        return r12;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Method getMethodInner(Class<?> r10, String r11, Class<?>... r12) {
        Method r13 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r10, new Object[]{r11, r12});     // Catch: Throwable -> L4
        r13.setAccessible(true);     // Catch: Throwable -> L4
        return r13;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static boolean isAndroidPHigher() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 28) goto L5;
    L10:
        return true;
    L5:
        if (r10 == 27) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static Object readField(Object r10, String r11) {
        return getField(r10.getClass(), r11).get(r10);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
