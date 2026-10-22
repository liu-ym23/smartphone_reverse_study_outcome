package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UnsafeAllocator {
    public static final UnsafeAllocator INSTANCE = null;

    static {
        INSTANCE = create();
    }

    public UnsafeAllocator() {
    }

    public static /* synthetic */ void access$000(Class r5) {
        assertInstantiable(r5);
    }

    private static void assertInstantiable(Class<?> r5) {
        String r10 = ConstructorConstructor.checkInstantiable(r5);
        if (r10 != null) goto L6;
        return;
    L6:
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(r10));
    }

    private static UnsafeAllocator create() {
        Class<?> r5 = Class.forName("sun.misc.Unsafe");     // Catch: Exception -> L5
        Field r10 = r5.getDeclaredField("theUnsafe");     // Catch: Exception -> L5
        r10.setAccessible(true);     // Catch: Exception -> L5
        final Object r11 = r10.get(null);     // Catch: Exception -> L5
        final Method r12 = r5.getMethod("allocateInstance", new Class[]{Class.class});     // Catch: Exception -> L5
        return new AnonymousClass1(r12, r11);
    L5:
        Method r13 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});     // Catch: Exception -> L7
        r13.setAccessible(true);     // Catch: Exception -> L7
        final int r14 = ((Integer) r13.invoke(null, new Object[]{Object.class})).intValue();     // Catch: Exception -> L7
        final Method r15 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});     // Catch: Exception -> L7
        r15.setAccessible(true);     // Catch: Exception -> L7
        return new AnonymousClass2(r15, r14);
    L7:
        final Method r16 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});     // Catch: Exception -> L9
        r16.setAccessible(true);     // Catch: Exception -> L9
        return new AnonymousClass3(r16);
    L10:
        return new AnonymousClass4();
    }

    public abstract <T> T newInstance(Class<T> r5) throws Exception;
}
