package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f4267a = null;

    class a extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f4268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f4269c;

        a(Method r10, Object r11) {
            this.f4268b = r10;
            this.f4269c = r11;
        }

        @Override // com.google.gson.internal.k
        public <T> T d(Class<T> r10) {
            k.a(r10);
            return (T) this.f4268b.invoke(this.f4269c, new Object[]{r10});
        }
    }

    class b extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f4270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f4271c;

        b(Method r10, int r11) {
            this.f4270b = r10;
            this.f4271c = r11;
        }

        @Override // com.google.gson.internal.k
        public <T> T d(Class<T> r10) {
            k.a(r10);
            return (T) this.f4270b.invoke(null, new Object[]{r10, Integer.valueOf(this.f4271c)});
        }
    }

    class c extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f4272b;

        c(Method r10) {
            this.f4272b = r10;
        }

        @Override // com.google.gson.internal.k
        public <T> T d(Class<T> r10) {
            k.a(r10);
            return (T) this.f4272b.invoke(null, new Object[]{r10, Object.class});
        }
    }

    class d extends k {
        d() {
        }

        @Override // com.google.gson.internal.k
        public <T> T d(Class<T> r10) {
            throw new UnsupportedOperationException("Cannot allocate " + r10 + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    static {
        f4267a = c();
    }

    public k() {
    }

    static /* synthetic */ void a(Class r10) {
        b(r10);
    }

    private static void b(Class<?> r10) {
        String r11 = com.google.gson.internal.b.a(r10);
        if (r11 != null) goto L6;
        return;
    L6:
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + r11);
    }

    private static k c() {
        Class<?> r10 = Class.forName("sun.misc.Unsafe");     // Catch: Exception -> L5
        Field r11 = r10.getDeclaredField("theUnsafe");     // Catch: Exception -> L5
        r11.setAccessible(true);     // Catch: Exception -> L5
        return new a(r10.getMethod("allocateInstance", new Class[]{Class.class}), r11.get(null));
    L14:
        Method r12 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});     // Catch: Exception -> L8
        r12.setAccessible(true);     // Catch: Exception -> L8
        int r13 = ((Integer) r12.invoke(null, new Object[]{Object.class})).intValue();     // Catch: Exception -> L8
        Method r14 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});     // Catch: Exception -> L8
        r14.setAccessible(true);     // Catch: Exception -> L8
        return new b(r14, r13);
    L8:
        Method r15 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});     // Catch: Exception -> L10
        r15.setAccessible(true);     // Catch: Exception -> L10
        return new c(r15);
    L11:
        return new d();
    }

    public abstract <T> T d(Class<T> r10);
}
