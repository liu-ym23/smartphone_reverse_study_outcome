package com.larus.settings.performance;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a<T> implements ReadWriteProperty<Object, T> {
    public final Function0<T> a;
    public final Object b;
    public Object c;

    /* JADX INFO: renamed from: com.larus.settings.performance.a$a, reason: collision with other inner class name */
    public static final class C0026a {
        public static final C0026a a = null;

        static {
            a = new C0026a();
        }

        public C0026a() {
        }
    }

    public a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        this.a = r2;
        this.b = new Object();
        this.c = C0026a.a;
    }

    public final T getValue(Object r2, KProperty<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "property");
        Object r4 = this.b;
        monitor-enter(r4);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.c != C0026a.a) goto L7;
        this.c = this.a.invoke();     // Catch: Throwable -> L10
    L7:
        T r5 = (T) this.c;
        monitor-exit(r4);
        return r5;
    }

    public final void setValue(Object r2, KProperty<?> r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "property");
        Object r5 = this.b;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.c != C0026a.a) goto L8;
        monitor-exit(r5);
        return;
    L8:
        this.c = r4;     // Catch: Throwable -> L11
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r5);
    }
}
