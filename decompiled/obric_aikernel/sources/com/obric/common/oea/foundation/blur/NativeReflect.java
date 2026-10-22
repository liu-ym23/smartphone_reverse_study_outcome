package com.obric.common.oea.foundation.blur;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class NativeReflect {
    static {
        new NativeReflect();
    }

    private NativeReflect() {
    }

    public static Method a(Class<?> r10, String r11, Class<?>[] r12) {
        return r10.getDeclaredMethod(r11, r12);
    }

    public native Constructor getDeclaredConstructorNative(Class<?> r10, Class<?>[] r11);

    public native Field getDeclaredFieldNative(Class<?> r10, String r11);

    public native Method getDeclaredMethodNative(Class<?> r10, String r11, Class<?>[] r12);
}
