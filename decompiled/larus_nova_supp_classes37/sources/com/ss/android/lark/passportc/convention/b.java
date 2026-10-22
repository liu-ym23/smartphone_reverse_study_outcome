package com.ss.android.lark.passportc.convention;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b<T> {
    public volatile Provider<T> a;
    public final Class<T> b;
    public final Map<C0095b, c<T>> c;

    public static final class a<T> implements Provider {
        public final /* synthetic */ T a;

        public a(T r1) {
            this.a = r1;
        }

        public final T get() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passportc.convention.b$b, reason: collision with other inner class name */
    public static final class C0095b {
        public final Class<?> a;
        public final Object b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0095b) == true) goto L8;
            return false;
        L8:
            C0095b r6 = (C0095b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ObserverKey(type=" + this.a + ", observer=" + this.b + ')';
        }

        public final Class<?> getType() {
            return this.a;
        }

        public C0095b(Class<?> r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "observer");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c<T> {
        public final Function1<T, Unit> a;
        public final Function1<T, Unit> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ObserverPayload(doObserve=" + this.a + ", undoObserve=" + this.b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super T, Unit> r2, Function1<? super T, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "doObserve");
            Intrinsics.checkNotNullParameter(r3, "undoObserve");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d implements InvocationHandler {
        public final /* synthetic */ b<T> a;

        public d(b<T> r1) {
            this.a = r1;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r2, Method r3, Object[] r4) {
            Intrinsics.checkNotNullParameter(r3, "method");
            if (Intrinsics.areEqual(r3.getDeclaringClass(), Object.class) == false) goto L7;
            if (r4 == null) goto L12;
            return r3.invoke(this, Arrays.copyOf(r4, r4.length));
        L12:
            return r3.invoke(this, new Object[0]);
        L7:
            if (r4 == null) goto L10;
            return r3.invoke(this.a.c(), Arrays.copyOf(r4, r4.length));
        L10:
            return r3.invoke(this.a.c(), new Object[0]);
        }
    }

    public static final class e<T> implements Provider {
        public final /* synthetic */ T a;

        public e(T r1) {
            this.a = r1;
        }

        public final T get() {
            return this.a;
        }
    }

    public b() {
        throw null;
    }

    public final T b() {
        d r0 = new d(this);
        return (T) Proxy.newProxyInstance(this.b.getClassLoader(), new Class[]{this.b}, r0);
    }

    public final T c() {
        return (T) this.a.get();
    }

    public final void d(C0095b r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        monitor-enter(this);
        c<T> r3 = this.c.remove(r2);     // Catch: Throwable -> L9
        if (r3 == null) goto L7;
        r3.b.invoke(c());     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void e(T r4) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (Intrinsics.areEqual(this.a.get(), r4) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<T> r0 = ((LinkedHashMap) this.c).values().iterator();     // Catch: Throwable -> L18
    L9:
        if (r0.hasNext() == false) goto L11;
        ((c) r0.next()).b.invoke(this.a.get());     // Catch: Throwable -> L18
        goto L9
    L11:
        this.a = new e(r4);     // Catch: Throwable -> L18
        Iterator<T> r5 = ((LinkedHashMap) this.c).values().iterator();     // Catch: Throwable -> L18
    L13:
        if (r5.hasNext() == false) goto L15;
        ((c) r5.next()).a.invoke(this.a.get());     // Catch: Throwable -> L18
        goto L13
    L15:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
    }

    public b(T r3, Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        a r1 = new a(r3);
        Intrinsics.checkNotNullParameter(r1, "instance");
        Intrinsics.checkNotNullParameter(r4, "clazz");
        this.a = r1;
        this.b = r4;
        this.c = new LinkedHashMap();
    }

    public final void a(C0095b r2, c<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "payload");
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.c.containsKey(r2) == true) goto L7;
        this.c.put(r2, r3);     // Catch: Throwable -> L10
        r3.a.invoke(c());     // Catch: Throwable -> L10
    L7:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
    }
}
