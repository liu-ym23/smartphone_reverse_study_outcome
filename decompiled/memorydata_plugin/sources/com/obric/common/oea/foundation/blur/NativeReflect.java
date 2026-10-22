package com.obric.common.oea.foundation.blur;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class NativeReflect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final NativeReflect f7730a = null;

    static {
        f7730a = new NativeReflect();
    }

    private NativeReflect() {
    }

    public static Method a(Class<?> r0, String r1, Class<?>[] r2) {
        return r0.getDeclaredMethod(r1, r2);
    }

    public native Constructor getDeclaredConstructorNative(Class<?> r1, Class<?>[] r2);

    public native Field getDeclaredFieldNative(Class<?> r1, String r2);

    public native Method getDeclaredMethodNative(Class<?> r1, String r2, Class<?>[] r3);
}
