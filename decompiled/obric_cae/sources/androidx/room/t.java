package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class t implements a1.e, a1.d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final TreeMap<Integer, t> f2691s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f2693b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long[] f2694m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final double[] f2695n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String[] f2696o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final byte[][] f2697p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int[] f2698q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2699r;

    static {
        f2691s = new TreeMap();
    }

    public t(int r8) {
        this.f2692a = r8;
        int r10 = r8 + 1;
        this.f2698q = new int[r10];
        this.f2694m = new long[r10];
        this.f2695n = new double[r10];
        this.f2696o = new String[r10];
        this.f2697p = new byte[r10][];
    }

    public static final t k(int r8, String r10) {
        he.i.f(r10, "query");
        TreeMap<Integer, t> r11 = f2691s;
        monitor-enter(r11);
        Map.Entry<Integer, t> r12 = r11.ceilingEntry(Integer.valueOf(r8));     // Catch: Throwable -> L13
        if (r12 == null) goto L9;
        r11.remove(r12.getKey());     // Catch: Throwable -> L13
        t r13 = r12.getValue();     // Catch: Throwable -> L13
        r13.getClass();     // Catch: Throwable -> L13
        r13.f2693b = r10;     // Catch: Throwable -> L13
        r13.f2699r = r8;     // Catch: Throwable -> L13
        monitor-exit(r11);
        return r13;
    L9:
        xd.j r14 = xd.j.f13877a;     // Catch: Throwable -> L13
        monitor-exit(r11);
        t r15 = new t(r8);
        r15.f2693b = r10;
        r15.f2699r = r8;
        return r15;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // a1.d
    public final void R(int r8, String r10) {
        he.i.f(r10, "value");
        this.f2698q[r8] = 4;
        this.f2696o[r8] = r10;
    }

    @Override // a1.d
    public final void W(int r8, long r10) {
        this.f2698q[r8] = 2;
        this.f2694m[r8] = r10;
    }

    @Override // a1.d
    public final void Y(int r8, byte[] r10) {
        this.f2698q[r8] = 5;
        this.f2697p[r8] = r10;
    }

    @Override // a1.e
    public final String a() {
        String r8 = this.f2693b;
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // a1.d
    public final void g0(int r8) {
        this.f2698q[r8] = 1;
    }

    @Override // a1.e
    public final void i(o r8) {
        int r10 = this.f2699r;
        if (1 > r10) goto L31;
        int r11 = 1;
    L5:
        int r12 = this.f2698q[r11];
        if (r12 != 1) goto L8;
        r8.g0(r11);
    L29:
        if (r11 == r10) goto L35;
        r11 = r11 + 1;
        goto L5
    L35:
        return;
    L8:
        if (r12 != 2) goto L10;
        r8.W(r11, this.f2694m[r11]);
        goto L29
    L10:
        if (r12 != 3) goto L12;
        r8.a(r11, this.f2695n[r11]);
        goto L29
    L12:
        if (r12 != 4) goto L14;
        String r13 = this.f2696o[r11];
        if (r13 == null) goto L25;
        r8.R(r11, r13);
        goto L29
    L25:
        throw new IllegalArgumentException("Required value was null.".toString());
    L14:
        if (r12 != 5) goto L29;
        byte[] r14 = this.f2697p[r11];
        if (r14 == null) goto L20;
        r8.Y(r11, r14);
        goto L29
    L20:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void n() {
        TreeMap<Integer, t> r8 = f2691s;
        monitor-enter(r8);
        r8.put(Integer.valueOf(this.f2692a), this);     // Catch: Throwable -> L13
        if (r8.size() <= 15) goto L10;
        int r10 = r8.size() - 10;     // Catch: Throwable -> L13
        Iterator<Integer> r11 = r8.descendingKeySet().iterator();     // Catch: Throwable -> L13
        he.i.e(r11, "queryPool.descendingKeySet().iterator()");     // Catch: Throwable -> L13
    L7:
        int r12 = r10 - 1;     // Catch: Throwable -> L13
        if (r10 <= 0) goto L10;
        r11.next();     // Catch: Throwable -> L13
        r11.remove();     // Catch: Throwable -> L13
        r10 = r12;
    L10:
        xd.j r13 = xd.j.f13877a;     // Catch: Throwable -> L13
        monitor-exit(r8);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
