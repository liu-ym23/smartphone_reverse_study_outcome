package com.obric.common.oea.foundation.blur;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class NativeReflect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6092a = 0;

    static {
        new NativeReflect();
    }

    public NativeReflect() {
    }

    public native Constructor getDeclaredConstructorNative(Class<?> r8, Class<?>[] r10);

    public native Field getDeclaredFieldNative(Class<?> r8, String r10);

    public native Method getDeclaredMethodNative(Class<?> r8, String r10, Class<?>[] r11);
}
