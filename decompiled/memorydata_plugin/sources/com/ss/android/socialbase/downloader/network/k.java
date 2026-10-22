package com.ss.android.socialbase.downloader.network;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f15597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f15598b;
    private final AtomicReference<NetworkQuality> c;
    private AtomicReference<NetworkQuality> d;
    private final List<j.b> e;
    private int f;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.k$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15599a = null;

        static {
            int[] r0 = new int[NetworkQuality.values().length];
            f15599a = r0;
            r0[NetworkQuality.POOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f15599a[NetworkQuality.MODERATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f15599a[NetworkQuality.GOOD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f15599a[NetworkQuality.EXCELLENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f15600a = null;

        static {
            f15600a = new k(null);
        }
    }

    private k() {
        this.f15597a = new d(0.05d);
        this.f15598b = false;
        this.c = new AtomicReference(NetworkQuality.UNKNOWN);
        this.e = new CopyOnWriteArrayList();
    }

    /* synthetic */ k(AnonymousClass1 r1) {
        this();
    }

    private NetworkQuality a(double r3) {
        if (r3 >= 0.0d) goto L7;
        return NetworkQuality.UNKNOWN;
    L7:
        if (r3 >= 150.0d) goto L11;
        return NetworkQuality.POOR;
    L11:
        if (r3 >= 550.0d) goto L15;
        return NetworkQuality.MODERATE;
    L15:
        if (r3 >= 2000.0d) goto L19;
        return NetworkQuality.GOOD;
    L19:
        return NetworkQuality.EXCELLENT;
    }

    public static k a() {
        return a.f15600a;
    }

    private boolean e() {
        if (this.f15597a != null) goto L29;
        return false;
    L29:
        int r0 = AnonymousClass1.f15599a[((NetworkQuality) ZeusTransformUtils.preCheckCast(this.c.get(), NetworkQuality.class, "com.obric.memorydata.plugin")).ordinal()];     // Catch: Throwable -> L26
        double r2 = 2000.0d;
        double r4 = 550.0d;
        if (r0 != 1) goto L8;
        r4 = 0.0d;
        r2 = 150.0d;
    L17:
        double r6 = this.f15597a.a();     // Catch: Throwable -> L26
        if (r6 <= r2) goto L24;
        if (r6 <= (r2 * 1.25d)) goto L28;
        return true;
    L28:
        return false;
    L24:
        if (r6 >= (r4 * 0.8d)) goto L28;
        return true;
    L8:
        if (r0 != 2) goto L10;
        r2 = 550.0d;
        r4 = 150.0d;
        goto L17
    L10:
        if (r0 == 3) goto L17;
        if (r0 == 4) goto L14;
        return true;
    L14:
        r2 = 3.4028234663852886E38d;
        r4 = 2000.0d;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    private void f() {
        int r1 = this.e.size();     // Catch: Throwable -> L7
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L13;
        ((j.b) ZeusTransformUtils.preCheckCast(this.e.get(r2), j.b.class, "com.obric.memorydata.plugin")).a((NetworkQuality) ZeusTransformUtils.preCheckCast(this.c.get(), NetworkQuality.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        r2 = r2 + 1;
        goto L4
    L13:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public synchronized void a(long r3, long r5) {
        monitor-enter(this);
        double r4 = ((r3 * 1.0d) / r5) * 8.0d;
        if (r5 != 0) goto L6;
    L25:
        monitor-exit(this);
        return;
    L6:
        if (r4 < 3.0d) goto L25;
        this.f15597a.a(r4);     // Catch: Throwable -> L27
        NetworkQuality r6 = b();     // Catch: Throwable -> L27
        if (this.f15598b == false) goto L21;
        this.f++;     // Catch: Throwable -> L27
        if (r6 == this.d.get()) goto L14;
        this.f15598b = false;     // Catch: Throwable -> L27
        this.f = 1;     // Catch: Throwable -> L27
    L14:
        if (this.f >= 5.0d) goto L16;
    L18:
        monitor-exit(this);
        return;
    L16:
        if (e() == false) goto L18;
        this.f15598b = false;     // Catch: Throwable -> L27
        this.f = 1;     // Catch: Throwable -> L27
        this.c.set(this.d.get());     // Catch: Throwable -> L27
        f();     // Catch: Throwable -> L27
        goto L18
    L21:
        if (this.c.get() == r6) goto L23;
        this.f15598b = true;     // Catch: Throwable -> L27
        this.d = new AtomicReference(r6);     // Catch: Throwable -> L27
    L23:
        monitor-exit(this);
    }

    public synchronized NetworkQuality b() {
        monitor-enter(this);
        d r0 = this.f15597a;     // Catch: Throwable -> L15
        if (r0 != null) goto L18;
        NetworkQuality r1 = NetworkQuality.UNKNOWN;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r1;
    L18:
        NetworkQuality r2 = a(r0.a());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        return NetworkQuality.UNKNOWN;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized double c() {
        monitor-enter(this);
        d r0 = this.f15597a;     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        double r1 = -1.0d;
    L7:
        monitor-exit(this);
        return r1;
    L6:
        r1 = r0.a();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public double d() {
        d r2 = this.f15597a;
        if (r2 != null) goto L6;
        return 0.0d;
    L6:
        return r2.b();
    }
}
