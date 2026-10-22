package buc;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e<T> {
    public static final AtomicReferenceFieldUpdater<e<?>, Object> b = null;
    public final f a;
    private volatile T value;

    public static final class a {
    }

    static {
        b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "value");
    }

    public final String toString() {
        return String.valueOf(this.value);
    }

    public final T c() {
        return this.value;
    }

    public final T b(T r5) {
        T r0 = (T) b.getAndSet(this, r5);
        f.a r1 = this.a;
        if (r1 == f.a.a) goto L5;
        r1.getClass();
        f.a("getAndSet(" + r5 + "):" + r0);
    L5:
        return r0;
    }

    public final void d(T r4) {
        this.value = r4;
        f.a r0 = this.a;
        if (r0 == f.a.a) goto L6;
        r0.getClass();
        f.a("set(" + r4 + ')');
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Object r2, f.a r3) {
        Intrinsics.checkNotNullParameter(r3, "trace");
        this.a = r3;
        this.value = r2;
    }

    public final boolean a(T r5, T r6) {
        AtomicReferenceFieldUpdater<e<?>, Object> r0 = b;
    L4:
        if (r0.compareAndSet(this, r5, r6) == true) goto L5;
        if (r0.get(this) == r5) goto L4;
        boolean r1 = false;
    L9:
        if (r1 == false) goto L13;
        f.a r2 = this.a;
        if (r2 == f.a.a) goto L13;
        r2.getClass();
        f.a("CAS(" + r5 + ", " + r6 + ')');
    L13:
        return r1;
    L5:
        r1 = true;
        goto L9
    }
}
