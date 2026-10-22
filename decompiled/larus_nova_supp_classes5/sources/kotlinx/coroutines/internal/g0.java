package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.h0;
import kotlinx.coroutines.r0$c;
import kotlinx.coroutines.r0$d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class g0<T extends h0 & Comparable<? super T>> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = null;
    private volatile /* synthetic */ int _size$volatile;
    public T[] a;

    static {
        b = AtomicIntegerFieldUpdater.newUpdater(g0.class, "_size$volatile");
    }

    public g0() {
    }

    public final T c() {
        monitor-enter(this);
        T[] r0 = this.a;     // Catch: Throwable -> L7
        if (r0 == null) goto L9;
        T r1 = r0[0];     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r1;
    L9:
        r1 = null;
    L7:
        th = move-exception;
        throw th;
    }

    public final int b() {
        return b.get(this);
    }

    public final void a(r0$c r5) {
        r5.c((r0$d) this);
        T[] r0 = this.a;
        if (r0 != null) goto L6;
        r0 = (T[]) new h0[4];
        this.a = r0;
    L8:
        int r1 = b();
        AtomicIntegerFieldUpdater r3 = b;
        r3.set(this, r1 + 1);
        r0[r1] = r5;
        r5.b = r1;
        f(r1);
        return;
    L6:
        if (b() < r0.length) goto L8;
        r0 = (T[]) ((h0[]) Arrays.copyOf(r0, b() * 2));
        this.a = r0;
        goto L8
    }

    public final void d(h0 r2) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (r2.a() == null) goto L7;
        e(r2.getIndex());     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    public final T e(int r8) {
        T[] r0 = this.a;
        Intrinsics.checkNotNull(r0);
        b.set(this, b() - 1);
        if (r8 >= b()) goto L21;
        g(r8, b());
        int r1 = (r8 - 1) / 2;
        if (r8 <= 0) goto L9;
        T r3 = r0[r8];
        Intrinsics.checkNotNull(r3);
        T r4 = r0[r1];
        Intrinsics.checkNotNull(r4);
        if (((Comparable) r3).compareTo(r4) >= 0) goto L9;
        g(r8, r1);
        f(r1);
    L9:
        int r2 = (r8 * 2) + 1;
        if (r2 >= b()) goto L21;
        T[] r5 = this.a;
        Intrinsics.checkNotNull(r5);
        int r6 = r2 + 1;
        if (r6 >= b()) goto L17;
        T r7 = r5[r6];
        Intrinsics.checkNotNull(r7);
        T r9 = r5[r2];
        Intrinsics.checkNotNull(r9);
        if (((Comparable) r7).compareTo(r9) >= 0) goto L17;
        r2 = r6;
    L17:
        T r10 = r5[r8];
        Intrinsics.checkNotNull(r10);
        T r11 = r5[r2];
        Intrinsics.checkNotNull(r11);
        if (((Comparable) r10).compareTo(r11) <= 0) goto L21;
        g(r8, r2);
        r8 = r2;
    L21:
        T r12 = r0[b()];
        Intrinsics.checkNotNull(r12);
        r12.c(null);
        r12.setIndex(-1);
        r0[b()] = null;
        return r12;
    }

    public final void f(int r4) {
    L2:
        if (r4 <= 0) goto L3;
        T[] r0 = this.a;
        Intrinsics.checkNotNull(r0);
        int r1 = (r4 - 1) / 2;
        T r2 = r0[r1];
        Intrinsics.checkNotNull(r2);
        T r3 = r0[r4];
        Intrinsics.checkNotNull(r3);
        if (((Comparable) r2).compareTo(r3) <= 0) goto L6;
        g(r4, r1);
        r4 = r1;
        goto L2
    L6:
        return;
    }

    public final void g(int r4, int r5) {
        T[] r0 = this.a;
        Intrinsics.checkNotNull(r0);
        T r1 = r0[r5];
        Intrinsics.checkNotNull(r1);
        T r2 = r0[r4];
        Intrinsics.checkNotNull(r2);
        r0[r4] = r1;
        r0[r5] = r2;
        r1.setIndex(r4);
        r2.setIndex(r5);
    }
}
