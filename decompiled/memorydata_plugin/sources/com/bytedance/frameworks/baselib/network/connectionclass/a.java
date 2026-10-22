package com.bytedance.frameworks.baselib.network.connectionclass;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f2307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f2308b;
    private AtomicReference<ConnectionQuality> c;
    private AtomicReference<ConnectionQuality> d;
    private ArrayList<b> e;
    private int f;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.connectionclass.a$a, reason: collision with other inner class name */
    private static class C0120a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2309a = null;

        static {
            f2309a = new a();
        }
    }

    public interface b {
        void onBandwidthStateChange(ConnectionQuality r1);
    }

    public a() {
        this.f2307a = new c(0.05d);
        this.f2308b = false;
        this.c = new AtomicReference(ConnectionQuality.UNKNOWN);
        this.e = new ArrayList();
    }

    private ConnectionQuality a(double r3) {
        if (r3 >= 0.0d) goto L7;
        return ConnectionQuality.UNKNOWN;
    L7:
        if (r3 >= 28.0d) goto L11;
        return ConnectionQuality.POOR;
    L11:
        if (r3 >= 112.0d) goto L15;
        return ConnectionQuality.MODERATE;
    L15:
        if (r3 >= 560.0d) goto L19;
        return ConnectionQuality.GOOD;
    L19:
        return ConnectionQuality.EXCELLENT;
    }

    public static a a() {
        return C0120a.f2309a;
    }

    private boolean c() {
        if (this.f2307a != null) goto L29;
        return false;
    L29:
        ConnectionQuality r0 = (ConnectionQuality) ZeusTransformUtils.preCheckCast(this.c.get(), ConnectionQuality.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        double r3 = 560.0d;
        double r5 = 112.0d;
        if (ConnectionQuality.POOR != r0) goto L9;
        r5 = 0.0d;
        r3 = 28.0d;
    L17:
        double r7 = this.f2307a.a();     // Catch: Throwable -> L26
        if (r7 <= r3) goto L24;
        if (r7 <= (r3 * 1.25d)) goto L28;
        return true;
    L28:
        return false;
    L24:
        if (r7 >= (r5 * 0.8d)) goto L28;
    L25:
        return true;
    L9:
        if (ConnectionQuality.MODERATE != r0) goto L12;
        r3 = 112.0d;
        r5 = 28.0d;
        goto L17
    L12:
        if (ConnectionQuality.GOOD == r0) goto L17;
        if (ConnectionQuality.EXCELLENT != r0) goto L25;
        r3 = 3.4028234663852886E38d;
        r5 = 560.0d;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    private void d() {
        int r1 = this.e.size();     // Catch: Throwable -> L7
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L13;
        ((b) ZeusTransformUtils.preCheckCast(this.e.get(r2), b.class, "com.obric.memorydata.plugin")).onBandwidthStateChange((ConnectionQuality) ZeusTransformUtils.preCheckCast(this.c.get(), ConnectionQuality.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        r2 = r2 + 1;
        goto L4
    L13:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public ConnectionQuality a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.e.add(r4);
    L6:
        return (ConnectionQuality) ZeusTransformUtils.preCheckCast(this.c.get(), ConnectionQuality.class, "com.obric.memorydata.plugin");
    }

    public synchronized void a(long r6, long r8) {
        monitor-enter(this);
        double r0 = ((r6 * 1.0d) / r8) * 8.0d;
        if (r8 != 0) goto L6;
    L28:
        monitor-exit(this);
        return;
    L6:
        if (r0 < 3.0d) goto L28;
        if (Logger.debug() == false) goto L11;
        Logger.d("ConnectionClassManager", "bytes = " + r6 + " timeInMs = " + r8 + " bandwidth = " + r0);     // Catch: Throwable -> L30
    L11:
        this.f2307a.a(r0);     // Catch: Throwable -> L30
        if (this.f2308b == false) goto L24;
        this.f++;     // Catch: Throwable -> L30
        if (b() == this.d.get()) goto L17;
        this.f2308b = false;     // Catch: Throwable -> L30
        this.f = 1;     // Catch: Throwable -> L30
    L17:
        if (this.f >= 5.0d) goto L19;
    L21:
        monitor-exit(this);
        return;
    L19:
        if (c() == false) goto L21;
        this.f2308b = false;     // Catch: Throwable -> L30
        this.f = 1;     // Catch: Throwable -> L30
        this.c.set((ConnectionQuality) ZeusTransformUtils.preCheckCast(this.d.get(), ConnectionQuality.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L30
        d();     // Catch: Throwable -> L30
        goto L21
    L24:
        if (this.c.get() == b()) goto L26;
        this.f2308b = true;     // Catch: Throwable -> L30
        this.d = new AtomicReference(b());     // Catch: Throwable -> L30
    L26:
        monitor-exit(this);
    }

    public synchronized ConnectionQuality b() {
        monitor-enter(this);
        c r0 = this.f2307a;     // Catch: Throwable -> L15
        if (r0 != null) goto L18;
        ConnectionQuality r1 = ConnectionQuality.UNKNOWN;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r1;
    L18:
        ConnectionQuality r2 = a(r0.a());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        return ConnectionQuality.UNKNOWN;
    L15:
        th = move-exception;
        throw th;
    }
}
