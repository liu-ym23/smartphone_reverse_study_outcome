package buc;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public static final AtomicLongFieldUpdater<d> b = null;
    public final f a;
    private volatile long value;

    public static final class a {
    }

    static {
        b = AtomicLongFieldUpdater.newUpdater(d.class, "value");
    }

    public final long d() {
        long r0 = b.incrementAndGet(this);
        f.a r2 = this.a;
        if (r2 == f.a.a) goto L5;
        r2.getClass();
        f.a("incAndGet():" + r0);
    L5:
        return r0;
    }

    public final String toString() {
        return String.valueOf(this.value);
    }

    public final long c() {
        return this.value;
    }

    public final long a(long r6) {
        long r0 = b.addAndGet(this, r6);
        f.a r2 = this.a;
        if (r2 == f.a.a) goto L5;
        r2.getClass();
        f.a("addAndGet(" + r6 + "):" + r0);
    L5:
        return r0;
    }

    public final void e(long r4) {
        this.value = r4;
        f.a r0 = this.a;
        if (r0 == f.a.a) goto L6;
        r0.getClass();
        f.a("set(" + r4 + ')');
        return;
    }

    public d(long r2, f.a r4) {
        Intrinsics.checkNotNullParameter(r4, "trace");
        this.a = r4;
        this.value = r2;
    }

    public final boolean b(long r7, long r9) {
        boolean r0 = b.compareAndSet(this, r7, r9);
        if (r0 == false) goto L7;
        f.a r1 = this.a;
        if (r1 == f.a.a) goto L7;
        r1.getClass();
        f.a("CAS(" + r7 + ", " + r9 + ')');
    L7:
        return r0;
    }
}
