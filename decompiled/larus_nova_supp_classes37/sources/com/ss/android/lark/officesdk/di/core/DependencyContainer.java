package com.ss.android.lark.officesdk.di.core;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DependencyContainer {
    public static final DependencyContainer a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public static final class a {
        public final com.ss.android.lark.officesdk.di.core.a a;

        public a(com.ss.android.lark.officesdk.di.core.a r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
        }

        public final void a(Class r4, Class r5) {
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, "providerClass");
            com.ss.android.lark.officesdk.di.core.a r2 = this.a;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, "providerClass");
            ReentrantReadWriteLock.ReadLock r0 = r2.e.readLock();
            r0.lock();
            if (((com.ss.android.lark.officesdk.di.core.a.C0007a) ((LinkedHashMap) r2.b).get(r4)) == null) goto L6;
            r0.unlock();
            return;
        L6:
            r0.unlock();
            ReentrantReadWriteLock.WriteLock r1 = r2.e.writeLock();
            r1.lock();
            r2.b.put(r4, new com.ss.android.lark.officesdk.di.core.a.C0007a(r5));     // Catch: Throwable -> L10
            r1.unlock();
            return;
        L10:
            th = move-exception;
            r1.unlock();
            throw th;
        L13:
            th = move-exception;
            r0.unlock();
            throw th;
        }
    }

    public DependencyContainer() {
    }

    static {
        a = new DependencyContainer();
        b = LazyKt.lazy(DependencyContainer$globalDependencyContext$2.INSTANCE);
        c = LazyKt.lazy(DependencyContainer$bizDependencyContexts$2.INSTANCE);
    }

    public static b a(Class r1, DependencyContextUniqueId r2) {
        Intrinsics.checkNotNullParameter(r1, "type");
        if (r2 == null) goto L9;
        com.ss.android.lark.officesdk.di.core.a r3 = (com.ss.android.lark.officesdk.di.core.a) ((Map) c.getValue()).get(r2);
        if (r3 == null) goto L9;
        return r3.a(r1);
    L9:
        return ((com.ss.android.lark.officesdk.di.core.a) b.getValue()).a(r1);
    }

    public final void b(DependencyContextUniqueId r4, Function1<? super a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "init");
        if (r4 != null) goto L5;
        com.ss.android.lark.officesdk.di.core.a r1 = (com.ss.android.lark.officesdk.di.core.a) b.getValue();
    L22:
        r5.invoke(new a(r1));
        return;
    L5:
        if (r4 == DependencyContextUniqueId.Global) goto L20;
        Lazy r0 = c;
        r1 = (com.ss.android.lark.officesdk.di.core.a) ((Map) r0.getValue()).get(r4);
        if (r1 != null) goto L22;
        monitor-enter(this);
        Map r2 = (Map) r0.getValue();     // Catch: Throwable -> L16
        Object r3 = r2.get(r4);     // Catch: Throwable -> L16
        if (r3 != null) goto L13;
        r3 = new com.ss.android.lark.officesdk.di.core.a(r4, (com.ss.android.lark.officesdk.di.core.a) b.getValue());     // Catch: Throwable -> L16
        r2.put(r4, r3);     // Catch: Throwable -> L16
    L13:
        r1 = (com.ss.android.lark.officesdk.di.core.a) r3;     // Catch: Throwable -> L16
        monitor-exit(this);
    L16:
        th = move-exception;
        throw th;
    L20:
        throw new IllegalArgumentException("Global context cannot be created");
    }
}
