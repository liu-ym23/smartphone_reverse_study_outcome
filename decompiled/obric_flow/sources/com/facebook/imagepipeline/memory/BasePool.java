package com.facebook.imagepipeline.memory;

import ai.j0;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Throwables;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasePool<V> implements Pool<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f8199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MemoryTrimmableRegistry f8200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PoolParams f8201c;
    public final SparseArray d;
    public final Set e;
    public final boolean f;
    public final Counter g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Counter f8202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PoolStatsTracker f8203i;

    public static class Counter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8205b;

        public Counter() {
        }

        public final void a(int r5) {
            int r10 = this.f8205b;
            if (r10 < r5) goto L8;
            int r11 = this.f8204a;
            if (r11 <= 0) goto L8;
            this.f8204a = r11 - 1;
            this.f8205b = r10 - r5;
            return;
        L8:
            FLog.a("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", new Object[]{Integer.valueOf(r5), Integer.valueOf(this.f8205b), Integer.valueOf(this.f8204a)});
        }
    }

    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Integer r5) {
            super("Invalid size: " + r5.toString());
        }
    }

    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int r5, int r10, int r11, int r12) {
            StringBuilder r13 = j0.v("Pool hard cap violation? Hard cap = ", r5, r10, " Used size = ", " Free size = ");
            r13.append(r11);
            r13.append(" Request size = ");
            r13.append(r12);
            super(r13.toString());
        }
    }

    public BasePool(MemoryTrimmableRegistry r10, PoolParams r11, PoolStatsTracker r12) {
        this.f8199a = getClass();
        r10.getClass();
        this.f8200b = r10;
        r11.getClass();
        this.f8201c = r11;
        r12.getClass();
        this.f8203i = r12;
        SparseArray r13 = new SparseArray();
        this.d = r13;
        SparseIntArray r14 = new SparseIntArray(0);
        monitor-enter(this);
        r13.clear();     // Catch: Throwable -> L10
        SparseIntArray r15 = r11.f8249c;     // Catch: Throwable -> L10
        if (r15 == null) goto L13;
        int r16 = 0;
    L8:
        if (r16 >= r15.size()) goto L12;
        int r5 = r15.keyAt(r16);     // Catch: Throwable -> L10
        int r17 = r15.valueAt(r16);     // Catch: Throwable -> L10
        int r18 = r14.get(r5, 0);     // Catch: Throwable -> L10
        SparseArray r19 = this.d;     // Catch: Throwable -> L10
        int r20 = f(r5);     // Catch: Throwable -> L10
        this.f8201c.getClass();     // Catch: Throwable -> L10
        r19.put(r5, new Bucket(r20, r17, r18));     // Catch: Throwable -> L10
        r16 = r16 + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        this.f = false;     // Catch: Throwable -> L10
    L14:
        monitor-exit(this);     // Catch: Throwable -> L10
        this.e = Sets.a();
        this.f8202h = new Counter();
        this.g = new Counter();
        return;
    L13:
        this.f = true;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public abstract Object a(int r5);

    public synchronized Object a(Bucket r5) {
        monitor-enter(this);
        Object r10 = r5.a();     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        r5.d++;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r10;
    L10:
        monitor-exit(this);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    public abstract void a(Object r5);

    public abstract int b(Object r5);

    public final synchronized boolean b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if ((this.g.f8205b + this.f8202h.f8205b) <= this.f8201c.f8248b) goto L6;
        boolean r5 = true;
    L7:
        if (r5 == false) goto L13;
        this.f8203i.getClass();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r5;
    L13:
        monitor-exit(this);
        return r5;
    L6:
        r5 = false;
        goto L7
    }

    public final void c() {
        FLogDefaultLoggingDelegate r5 = FLogDefaultLoggingDelegate.f7658a;
        if (r5.a(2) == false) goto L8;
        Class r10 = this.f8199a;
        int r11 = this.g.f8204a;
        int r12 = this.g.f8205b;
        int r13 = this.f8202h.f8204a;
        int r14 = this.f8202h.f8205b;
        if (r5.a(2) == false) goto L9;
        String r15 = r10.getSimpleName();
        StringBuilder r16 = j0.v("Used = (", r11, r12, ", ", "); Free = (");
        r16.append(r13);
        r16.append(", ");
        r16.append(r14);
        r16.append(")");
        String r17 = r16.toString();
        Log.println(2, FLogDefaultLoggingDelegate.a(r15), r17);
        return;
    L9:
        return;
    }

    public final synchronized void d() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (b() == false) goto L10;
        h(this.f8201c.f8248b);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        monitor-exit(this);
    }

    public abstract int e(int r5);

    public abstract int f(int r5);

    public Bucket g(int r5) {
        int r10 = f(r5);
        this.f8201c.getClass();
        return new Bucket(r10, Integer.MAX_VALUE, 0);
    }

    @Override // com.facebook.common.memory.Pool
    public final Object get(int r10) {
        a();
        int r11 = e(r10);
        monitor-enter(this);
        Bucket r5 = c(r11);     // Catch: Throwable -> L13
        if (r5 == null) goto L19;
        Object r12 = a(r5);     // Catch: Throwable -> L13
        if (r12 == null) goto L19;
        if (this.e.add(r12) == false) goto L18;
        int r13 = b(r12);     // Catch: Throwable -> L13
        int r14 = f(r13);     // Catch: Throwable -> L13
        Counter r15 = this.g;     // Catch: Throwable -> L13
        r15.f8204a++;     // Catch: Throwable -> L13
        r15.f8205b += r14;     // Catch: Throwable -> L13
        this.f8202h.a(r14);     // Catch: Throwable -> L13
        this.f8203i.getClass();     // Catch: Throwable -> L13
        c();     // Catch: Throwable -> L13
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L15;
        FLog.a(this.f8199a, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r12)), Integer.valueOf(r13));     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);     // Catch: Throwable -> L13
        return r12;
    L18:
        throw new IllegalStateException();     // Catch: Throwable -> L13
    L19:
        int r16 = f(r11);     // Catch: Throwable -> L13
        if (b(r16) == false) goto L57;
        Counter r17 = this.g;     // Catch: Throwable -> L13
        r17.f8204a++;     // Catch: Throwable -> L13
        r17.f8205b += r16;     // Catch: Throwable -> L13
        if (r5 == null) goto L24;
        r5.d++;     // Catch: Throwable -> L13
    L24:
        monitor-exit(this);     // Catch: Throwable -> L13
        Object r18 = a(r11);     // Catch: Throwable -> L27
    L40:
        monitor-enter(this);
    L46:
        th = move-exception;
        throw th;
    L42:
        if (this.e.add(r18) == false) goto L51;
        d();     // Catch: Throwable -> L46
        this.f8203i.getClass();     // Catch: Throwable -> L46
        c();     // Catch: Throwable -> L46
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L48;
        FLog.a(this.f8199a, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r18)), Integer.valueOf(r11));     // Catch: Throwable -> L46
    L48:
        monitor-exit(this);     // Catch: Throwable -> L46
        return r18;
    L51:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L27:
        th = move-exception;
        monitor-enter(this);
        this.g.a(r16);     // Catch: Throwable -> L34
        Bucket r19 = c(r11);     // Catch: Throwable -> L34
        if (r19 == null) goto L39;
        int r20 = r19.d;     // Catch: Throwable -> L34
        if (r20 <= 0) goto L37;
        r19.d = r20 - 1;     // Catch: Throwable -> L34
        goto L39
    L37:
        throw new IllegalStateException();     // Catch: Throwable -> L34
    L39:
        Throwables.a(th, Error.class);
        Throwables.a(th, RuntimeException.class);
        r18 = null;
    L34:
        th = move-exception;
        throw th;
    L57:
        throw new PoolSizeViolationException(this.f8201c.f8247a, this.g.f8205b, this.f8202h.f8205b, r16);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void h(int r10) {
        monitor-enter(this);
        int r5 = this.g.f8205b;     // Catch: Throwable -> L9
        int r11 = this.f8202h.f8205b;     // Catch: Throwable -> L9
        int r12 = Math.min((r5 + r11) - r10, r11);     // Catch: Throwable -> L9
        if (r12 > 0) goto L7;
    L28:
        monitor-exit(this);
        return;
    L7:
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L11;
        FLog.a(this.f8199a, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(r10), Integer.valueOf(this.g.f8205b + this.f8202h.f8205b), Integer.valueOf(r12));     // Catch: Throwable -> L9
    L11:
        c();     // Catch: Throwable -> L9
        int r13 = 0;
    L13:
        if (r13 >= this.d.size()) goto L23;
        if (r12 <= 0) goto L23;
        Bucket r14 = (Bucket) this.d.valueAt(r13);     // Catch: Throwable -> L9
    L17:
        if (r12 <= 0) goto L22;
        Object r15 = r14.a();     // Catch: Throwable -> L9
        if (r15 == null) goto L22;
        a(r15);     // Catch: Throwable -> L9
        int r16 = r14.f8206a;     // Catch: Throwable -> L9
        r12 = r12 - r16;     // Catch: Throwable -> L9
        this.f8202h.a(r16);     // Catch: Throwable -> L9
    L22:
        r13 = r13 + 1;     // Catch: Throwable -> L9
    L23:
        c();     // Catch: Throwable -> L9
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L28;
        FLog.a(this.f8199a, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(r10), Integer.valueOf(this.g.f8205b + this.f8202h.f8205b));     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.references.ResourceReleaser
    public final void release(Object r10) {
        r10.getClass();
        int r5 = b(r10);
        int r11 = f(r5);
        monitor-enter(this);
        Bucket r12 = d(r5);     // Catch: Throwable -> L9
        if (this.e.remove(r10) == true) goto L13;
        Class r13 = this.f8199a;     // Catch: Throwable -> L9
        Object[] r14 = {Integer.valueOf(System.identityHashCode(r10)), Integer.valueOf(r5)};     // Catch: Throwable -> L9
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L11;
        String r15 = r13.getSimpleName();     // Catch: Throwable -> L9
        Log.println(6, FLogDefaultLoggingDelegate.a(r15), String.format(null, "release (free, value unrecognized) (object, size) = (%x, %s)", r14));     // Catch: Throwable -> L9
    L11:
        a(r10);     // Catch: Throwable -> L9
        this.f8203i.getClass();     // Catch: Throwable -> L9
    L41:
        c();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L13:
        if (r12 != null) goto L15;
    L31:
        if (r12 == null) goto L38;
        int r16 = r12.d;     // Catch: Throwable -> L9
        if (r16 <= 0) goto L36;
        r12.d = r16 - 1;     // Catch: Throwable -> L9
        goto L38
    L36:
        throw new IllegalStateException();     // Catch: Throwable -> L9
    L38:
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L40;
        FLog.a(this.f8199a, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r10)), Integer.valueOf(r5));     // Catch: Throwable -> L9
    L40:
        a(r10);     // Catch: Throwable -> L9
        this.g.a(r11);     // Catch: Throwable -> L9
        this.f8203i.getClass();     // Catch: Throwable -> L9
        goto L41
    L15:
        if ((r12.f8208c.size() + r12.d) > r12.f8207b) goto L31;
        if (b() == true) goto L31;
        if (c(r10) == false) goto L31;
        int r17 = r12.d;     // Catch: Throwable -> L9
        if (r17 <= 0) goto L25;
        r12.d = r17 - 1;     // Catch: Throwable -> L9
        r12.a(r10);     // Catch: Throwable -> L9
    L28:
        Counter r18 = this.f8202h;     // Catch: Throwable -> L9
        r18.f8204a++;     // Catch: Throwable -> L9
        r18.f8205b += r11;     // Catch: Throwable -> L9
        this.g.a(r11);     // Catch: Throwable -> L9
        this.f8203i.getClass();     // Catch: Throwable -> L9
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L41;
        FLog.a(this.f8199a, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r10)), Integer.valueOf(r5));     // Catch: Throwable -> L9
        goto L41
    L25:
        Object[] r19 = {r10};     // Catch: Throwable -> L9
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L28;
        Log.println(6, FLogDefaultLoggingDelegate.a("BUCKET"), String.format(null, "Tried to release value %s from an empty bucket!", r19));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void a() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (b() == true) goto L6;
    L12:
        monitor-exit(this);
        return;
    L6:
        if (this.f8202h.f8205b == 0) goto L12;
        throw new IllegalStateException();     // Catch: Throwable -> L10
    }

    public final synchronized boolean b(int r10) {
        monitor-enter(this);
        PoolParams r5 = this.f8201c;     // Catch: Throwable -> L8
        int r11 = r5.f8247a;     // Catch: Throwable -> L8
        int r12 = this.g.f8205b;     // Catch: Throwable -> L8
        if (r10 <= (r11 - r12)) goto L10;
        this.f8203i.getClass();     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L10:
        int r13 = r5.f8248b;     // Catch: Throwable -> L8
        if (r10 <= (r13 - (r12 + this.f8202h.f8205b))) goto L14;
        h(r13 - r10);     // Catch: Throwable -> L8
    L14:
        if (r10 <= (r11 - (this.g.f8205b + this.f8202h.f8205b))) goto L18;
        this.f8203i.getClass();     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L18:
        monitor-exit(this);
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized Bucket d(int r5) {
        monitor-enter(this);
        Bucket r10 = (Bucket) this.d.get(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean c(Object r5) {
        r5.getClass();
        return true;
    }

    public final synchronized Bucket c(int r5) {
        monitor-enter(this);
        Bucket r10 = (Bucket) this.d.get(r5);     // Catch: Throwable -> L11
        if (r10 == null) goto L6;
    L16:
        monitor-exit(this);
        return r10;
    L6:
        if (this.f == false) goto L16;
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L13;
        FLog.a(this.f8199a, "creating new bucket %s", Integer.valueOf(r5));     // Catch: Throwable -> L11
    L13:
        Bucket r11 = g(r5);     // Catch: Throwable -> L11
        this.d.put(r5, r11);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r11;
    L11:
        th = move-exception;
        throw th;
    }
}
