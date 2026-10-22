package com.bytedance.crash.util;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class DoubleReflectHelper {
    private DoubleReflectHelper() {
    }

    public static Field getField(Class<?> r1, String r2) {
        if (isAndroidPHigher() == false) goto L9;
        return getFieldInner(r1, r2);
    L6:
        return null;
    L9:
        return FieldUtils.getField(r1, r2);
    }

    public static Field getFieldInner(Class<?> r6, String r7) {
        Field r8 = (Field) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r7}), Field.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        r8.setAccessible(true);     // Catch: Throwable -> L4
        return r8;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Method getMethodInner(Class<?> r7, String r8, Class<?>... r9) {
        Method r10 = (Method) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9}), Method.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        r10.setAccessible(true);     // Catch: Throwable -> L4
        return r10;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static boolean isAndroidPHigher() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT == 27) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static Object readField(Object r1, String r2) {
        return getField(r1.getClass(), r2).get(r1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
