package com.ss.android.socialbase.downloader.network;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15582a = "b";
    private static volatile int f = 0;
    private static long h = -1;
    private static volatile b i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f15583b;
    private final j c;
    private final AtomicInteger d;
    private final HandlerC0835b e;
    private long g;
    private volatile long j;
    private long k;

    public interface a {
        void c();
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.b$b, reason: collision with other inner class name */
    private class HandlerC0835b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f15584a;

        public HandlerC0835b(b r1, Looper r2) {
            this.f15584a = r1;
            super(r2);
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            if (r4.what != 1) goto L7;
            this.f15584a.i();
            sendEmptyMessageDelayed(1, 1000);
            return;
        }
    }

    static {
    }

    private b() {
        this.f15583b = new CopyOnWriteArrayList();
        this.j = 0;
        this.k = 0;
        this.c = j.a();
        this.d = new AtomicInteger();
        this.e = new HandlerC0835b(this, com.ss.android.socialbase.downloader.h.c.a());
    }

    public static b a() {
        if (i != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (i != null) goto L9;
        i = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return i;
    }

    public static long e() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void f() {
        f = com.ss.android.socialbase.downloader.utils.g.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static boolean g() {
        if (f == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean h() {
        if (f != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.f15583b.add(r4);
    }

    public void b() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a(f15582a, "startSampling", "SamplingCounter = " + this.d);     // Catch: Throwable -> L9
    L6:
        if (this.d.getAndIncrement() != 0) goto L12;
        this.e.a();     // Catch: Throwable -> L9
        this.g = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        this.k = System.currentTimeMillis();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public void b(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.f15583b.remove(r4);
    }

    public long c() {
        return this.j;
    }

    public void d() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a(f15582a, "stopSampling", "SamplingCounter = " + this.d);     // Catch: Throwable -> L9
    L6:
        if (this.d.decrementAndGet() != 0) goto L12;
        this.e.b();     // Catch: Throwable -> L9
        j();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public void i() {
        this.j = System.currentTimeMillis() - this.k;     // Catch: Exception -> L20
        f();     // Catch: Exception -> L20
        if (g() == false) goto L5;
        long r0 = e();     // Catch: Exception -> L20
    L6:
        long r2 = h;     // Catch: Exception -> L20
        long r4 = r0 - r2;     // Catch: Exception -> L20
        if (r2 < 0) goto L15;
        monitor-enter(this);     // Catch: Exception -> L20
        long r3 = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        this.c.a(r4, r3 - this.g);     // Catch: Throwable -> L12
        this.g = r3;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L15:
        h = r0;     // Catch: Exception -> L20
        Iterator<a> r9 = this.f15583b.iterator();     // Catch: Exception -> L20
    L17:
        if (r9.hasNext() == false) goto L27;
        ((a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.memorydata.plugin")).c();     // Catch: Exception -> L20
        goto L17
    L27:
        return;
    L5:
        r0 = TrafficStats.getMobileRxBytes();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    }

    public void j() {
        this.j = 0;
        i();
        h = -1;
    }
}
