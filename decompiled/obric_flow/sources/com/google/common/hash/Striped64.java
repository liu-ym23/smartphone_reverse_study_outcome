package com.google.common.hash;

import java.security.AccessController;
import java.util.Random;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
abstract class Striped64 extends Number {
    static final int NCPU = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f9268a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f9269b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f9270c = 0;
    static final Random rng = null;
    static final ThreadLocal<int[]> threadHashCode = null;
    volatile transient long base;
    volatile transient int busy;
    volatile transient c0[] cells;

    static {
        threadHashCode = new ThreadLocal();
        rng = new Random();
        NCPU = Runtime.getRuntime().availableProcessors();
        Unsafe r5 = a();     // Catch: Exception -> L5
        f9268a = r5;     // Catch: Exception -> L5
        f9269b = r5.objectFieldOffset(Striped64.class.getDeclaredField("base"));     // Catch: Exception -> L5
        f9270c = r5.objectFieldOffset(Striped64.class.getDeclaredField("busy"));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new Error(e);
    }

    public Striped64() {
    }

    public static Unsafe a() {
        return Unsafe.getUnsafe();
    L4:
        return (Unsafe) AccessController.doPrivileged(new b0());
    L6:
        e = move-exception;
        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
    }

    public static /* synthetic */ Unsafe access$000() {
        return a();
    }

    public final boolean casBase(long r10, long r11) {
        return f9268a.compareAndSwapLong(this, f9269b, r10, r11);
    }

    public final boolean casBusy() {
        return f9268a.compareAndSwapInt(this, f9270c, 0, 1);
    }

    public abstract long fn(long r5, long r10);

    public final void internalReset(long r5) {
        c0[] r10 = this.cells;
        this.base = r5;
        if (r10 == null) goto L10;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L14;
        c0 r13 = r10[r12];
        if (r13 == null) goto L9;
        r13.f9281a = r5;
    L9:
        r12 = r12 + 1;
        goto L5
    L14:
        return;
    }

    public final void retryUpdate(long r17, int[] r19, boolean r20) {
        if (r19 != null) goto L8;
        int[] r10 = new int[1];
        threadHashCode.set(r10);
        int r5 = rng.nextInt();
        if (r5 != 0) goto L7;
        r5 = 1;
    L7:
        r10[0] = r5;
    L9:
        boolean r11 = false;
        int r12 = r5;
        boolean r13 = r20;
    L10:
        c0[] r14 = this.cells;
        if (r14 == null) goto L68;
        int r15 = r14.length;
        if (r15 <= 0) goto L68;
        c0 r16 = r14[(r15 - 1) & r12];
        if (r16 == null) goto L17;
        if (r13 == false) goto L40;
        long r18 = r16.f9281a;
        if (r16.a(r18, fn(r18, r17)) == true) goto L122;
        if (r15 >= NCPU) goto L38;
        if (this.cells != r14) goto L38;
        if (r11 == false) goto L50;
        if (this.busy != 0) goto L66;
        if (casBusy() == false) goto L66;
        if (this.cells != r14) goto L63;
        c0[] r21 = new c0[r15 << 1];     // Catch: Throwable -> L60
        int r110 = 0;
    L58:
        if (r110 >= r15) goto L62;
        r21[r110] = r14[r110];     // Catch: Throwable -> L60
        r110 = r110 + 1;     // Catch: Throwable -> L60
        goto L58
    L62:
        this.cells = r21;     // Catch: Throwable -> L60
    L63:
        this.busy = 0;
        r11 = false;
    L60:
        th = move-exception;
        this.busy = 0;
        throw th;
    L66:
        int r22 = r12 ^ (r12 << 13);
        int r23 = r22 ^ (r22 >>> 17);
        r12 = r23 ^ (r23 << 5);
        r10[0] = r12;
        goto L10
    L50:
        r11 = true;
    L38:
        r11 = false;
        goto L66
    L122:
        return;
    L40:
        r13 = true;
        goto L66
    L17:
        if (this.busy != 0) goto L38;
        c0 r24 = new c0(r17);
        if (this.busy != 0) goto L38;
        if (casBusy() == false) goto L38;
        c0[] r111 = this.cells;     // Catch: Throwable -> L30
        if (r111 == null) goto L32;
        int r112 = r111.length;     // Catch: Throwable -> L30
        if (r112 <= 0) goto L32;
        int r113 = (r112 - 1) & r12;     // Catch: Throwable -> L30
        if (r111[r113] != null) goto L32;
        r111[r113] = r24;     // Catch: Throwable -> L30
        boolean r25 = true;
    L33:
        this.busy = 0;
        if (r25 == false) goto L10;
        return;
    L32:
        r25 = false;
    L30:
        th = move-exception;
        this.busy = 0;
        throw th;
    L68:
        if (this.busy != 0) goto L85;
        if (this.cells != r14) goto L85;
        if (casBusy() == false) goto L85;
    L77:
        th = move-exception;
        this.busy = 0;
        throw th;
    L74:
        if (this.cells != r14) goto L79;
        c0[] r26 = new c0[2];     // Catch: Throwable -> L77
        r26[r12 & 1] = new c0(r17);     // Catch: Throwable -> L77
        this.cells = r26;     // Catch: Throwable -> L77
        boolean r27 = true;
    L80:
        this.busy = 0;
        if (r27 == false) goto L10;
        return;
    L79:
        r27 = false;
    L85:
        long r28 = this.base;
        if (casBase(r28, fn(r28, r17)) == false) goto L10;
        return;
    L8:
        r5 = r19[0];
        r10 = r19;
        goto L9
    }
}
