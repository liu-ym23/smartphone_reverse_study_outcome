package com.bytedance.crash.util;

import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ReflexHelper {
    public ReflexHelper() {
    }

    @Nullable
    public static Field getField(String r10, String r11) {
        Field r12 = Class.forName(r10).getDeclaredField(r11);     // Catch: Exception -> L4
        r12.setAccessible(true);     // Catch: Exception -> L4
        return r12;
    L4:
        return null;
    }

    public static Method getMethod(Object r10, String r11, Class<?>... r12) {
        return r10.getClass().getMethod(r11, r12);
    }

    public static Method getMethod(String r10, String r11, Class<?>... r12) {
        return Class.forName(r10).getMethod(r11, r12);
    }

    @Nullable
    public static Object getObject(Field r10, Object r11) {
        return r10.get(r11);
    L4:
        return null;
    }

    public static int getStaticInt(String r10, String r11) {
        return Class.forName(r10).getField(r11).getInt(null);
    }

    public static Object getStaticObject(String r10, String r11) {
        return Class.forName(r10).getField(r11).get(null);
    }
}
