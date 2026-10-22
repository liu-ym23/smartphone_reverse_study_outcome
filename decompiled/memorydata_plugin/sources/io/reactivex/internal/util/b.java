package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static long a(long r0, long r2) {
        long r1 = r0 + r2;
        if (r1 >= 0) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r1;
    }

    public static long a(AtomicLong r5, long r6) {
    L2:
        long r0 = r5.get();
        if (r0 == Long.MAX_VALUE) goto L4;
        if (r5.compareAndSet(r0, a(r0, r6)) == false) goto L2;
        return r0;
    L4:
        return Long.MAX_VALUE;
    }

    public static long b(long r6, long r8) {
        long r0 = r6 * r8;
        if (((r6 | r8) >>> 31) != 0) goto L5;
    L8:
        return r0;
    L5:
        if ((r0 / r6) == r8) goto L8;
        return Long.MAX_VALUE;
    }

    public static long b(AtomicLong r5, long r6) {
    L2:
        long r0 = r5.get();
        if (r0 == Long.MIN_VALUE) goto L4;
        if (r0 == Long.MAX_VALUE) goto L7;
        if (r5.compareAndSet(r0, a(r0, r6)) == false) goto L2;
        return r0;
    L7:
        return Long.MAX_VALUE;
    L4:
        return Long.MIN_VALUE;
    }

    public static long c(AtomicLong r9, long r10) {
    L2:
        long r0 = r9.get();
        if (r0 == Long.MAX_VALUE) goto L4;
        long r2 = r0 - r10;
        if (r2 >= 0) goto L9;
        io.reactivex.d.a.a(new IllegalStateException("More produced than requested: " + r2));
        r2 = 0;
    L9:
        if (r9.compareAndSet(r0, r2) == false) goto L2;
        return r2;
    L4:
        return Long.MAX_VALUE;
    }

    public static long d(AtomicLong r9, long r10) {
    L2:
        long r0 = r9.get();
        if (r0 == Long.MIN_VALUE) goto L4;
        if (r0 == Long.MAX_VALUE) goto L7;
        long r2 = r0 - r10;
        if (r2 >= 0) goto L12;
        io.reactivex.d.a.a(new IllegalStateException("More produced than requested: " + r2));
        r2 = 0;
    L12:
        if (r9.compareAndSet(r0, r2) == false) goto L2;
        return r2;
    L7:
        return Long.MAX_VALUE;
    L4:
        return Long.MIN_VALUE;
    }
}
