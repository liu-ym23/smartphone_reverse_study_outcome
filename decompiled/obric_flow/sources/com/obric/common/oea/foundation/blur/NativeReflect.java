package com.obric.common.oea.foundation.blur;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class NativeReflect {
    public native Constructor getDeclaredConstructorNative(Class<?> r5, Class<?>[] r10);

    public native Field getDeclaredFieldNative(Class<?> r5, String r10);

    public native Method getDeclaredMethodNative(Class<?> r5, String r10, Class<?>[] r11);
}
