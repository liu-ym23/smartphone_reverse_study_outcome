package com.obric.oui.material;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
class NativeReflect {
    public static final /* synthetic */ int a = 0;

    public NativeReflect() {
    }

    public native Constructor getDeclaredConstructorNative(Class<?> r1, Class<?>[] r2);

    public native Field getDeclaredFieldNative(Class<?> r1, String r2);

    public native Method getDeclaredMethodNative(Class<?> r1, String r2, Class<?>[] r3);

    static {
        new NativeReflect();
    }
}
