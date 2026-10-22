package com.ss.android.lark.officesdk.di.core;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final a a;
    public final Map<Class<? extends b>, C0007a> b;
    public final Map<Class<? extends b>, Object> c;
    public final Map<Class<? extends c<?>>, c<?>> d;
    public final ReentrantReadWriteLock e;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.di.core.a$a, reason: collision with other inner class name */
    public static final class C0007a {
        public final Class<? extends c<?>> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0007a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0007a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ProviderInfo(providerClass=" + this.a + ')';
        }

        public C0007a(Class<? extends c<?>> r2) {
            Intrinsics.checkNotNullParameter(r2, "providerClass");
            this.a = r2;
        }
    }

    public final <T extends b> T a(Class<T> r6) {
        Intrinsics.checkNotNullParameter(r6, "type");
        ReentrantReadWriteLock.ReadLock r0 = this.e.readLock();
        r0.lock();
    L44:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (((C0007a) ((LinkedHashMap) this.b).get(r6)) == null) goto L13;
        Object r1 = ((LinkedHashMap) this.c).get(r6);     // Catch: Throwable -> L44
        if ((r1 instanceof b) == false) goto L9;
        T r2 = (T) r1;     // Catch: Throwable -> L44
    L10:
        if (r2 == null) goto L13;
        r0.unlock();
        return r2;
    L9:
        r2 = null;
    L13:
        r0.unlock();
        ReentrantReadWriteLock.WriteLock r3 = this.e.writeLock();
        r3.lock();
        Object r4 = ((LinkedHashMap) this.c).get(r6);     // Catch: Throwable -> L41
        if ((r4 instanceof b) == false) goto L18;
        T r5 = (T) r4;     // Catch: Throwable -> L41
    L19:
        if (r5 == null) goto L22;
        r3.unlock();
        return r5;
    L22:
        C0007a r7 = (C0007a) ((LinkedHashMap) this.b).get(r6);     // Catch: Throwable -> L41
        if (r7 == null) goto L37;
        Class<? extends c<?>> r8 = r7.a;     // Catch: Throwable -> L41
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type java.lang.Class<out com.ss.android.lark.officesdk.di.core.IDependencyProvider<T of com.ss.android.lark.officesdk.di.core.DependencyContext.getDependency>>");     // Catch: Throwable -> L41
        Object r9 = ((LinkedHashMap) this.d).get(r8);     // Catch: Throwable -> L41
        if ((r9 instanceof c) == false) goto L27;
        c<?> r10 = (c) r9;     // Catch: Throwable -> L41
    L28:
        if (r10 != null) goto L30;
        r10 = r8.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L41
        this.d.put(r8, r10);     // Catch: Throwable -> L41
    L30:
        if (r10 == null) goto L32;
        T r11 = (T) r10.create();
    L33:
        if (r11 == null) goto L37;
        this.c.put((Class<? extends b>) r6, r11);     // Catch: Throwable -> L41
        r3.unlock();
        return r11;
    L32:
        r11 = null;
        goto L33
    L27:
        r10 = null;
    L37:
        r3.unlock();
        a r12 = this.a;
        if (r12 != null) goto L40;
        return null;
    L40:
        return (T) r12.a(r6);
    L18:
        r5 = null;
    L41:
        th = move-exception;
        r3.unlock();
        throw th;
    }

    public a(DependencyContextUniqueId r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "uniqueId");
        this.a = r3;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new ReentrantReadWriteLock();
    }
}
