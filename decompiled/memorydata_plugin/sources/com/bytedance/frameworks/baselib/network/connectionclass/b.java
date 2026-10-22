package com.bytedance.frameworks.baselib.network.connectionclass;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static long g = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.frameworks.baselib.network.connectionclass.a f2310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f2311b;
    private HandlerC0121b c;
    private HandlerThread d;
    private boolean e;
    private long f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f2312a = null;

        static {
            f2312a = new b(com.bytedance.frameworks.baselib.network.connectionclass.a.a());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.connectionclass.b$b, reason: collision with other inner class name */
    private class HandlerC0121b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f2313a;

        public HandlerC0121b(b r1, Looper r2) {
            this.f2313a = r1;
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
        L7:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (r4.what != 1) goto L12;
            this.f2313a.d();     // Catch: Throwable -> L7
            sendEmptyMessageDelayed(1, 1000);     // Catch: Throwable -> L7
            return;
        }
    }

    static {
    }

    public b(com.bytedance.frameworks.baselib.network.connectionclass.a r2) {
        this.e = false;
        this.f2310a = r2;
        this.f2311b = new AtomicInteger();     // Catch: Throwable -> L5
        HandlerThread r3 = com.bytedance.frameworks.baselib.network.f.a.a("ParseThread");     // Catch: Throwable -> L5
        this.d = r3;     // Catch: Throwable -> L5
        r3.start();     // Catch: Throwable -> L5
        this.c = new HandlerC0121b(this, this.d.getLooper());     // Catch: Throwable -> L5
        return;
    L5:
        this.e = true;
    }

    public static b a() {
        return a.f2312a;
    }

    public void b() {
        if (this.e == false) goto L6;
        return;
    L6:
        if (this.f2311b.getAndIncrement() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "startSampling");     // Catch: Throwable -> L12
    L10:
        this.c.a();     // Catch: Throwable -> L12
        this.f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        return;
    }

    public void c() {
        if (this.e == false) goto L6;
        return;
    L6:
        if (this.f2311b.decrementAndGet() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "stopSampling");     // Catch: Throwable -> L12
    L10:
        this.c.b();     // Catch: Throwable -> L12
        e();     // Catch: Throwable -> L12
        return;
    }

    public void d() {
        long r0 = TrafficStats.getTotalRxBytes();     // Catch: Throwable -> L13
        long r2 = g;     // Catch: Throwable -> L13
        long r4 = r0 - r2;     // Catch: Throwable -> L13
        if (r2 < 0) goto L11;
        monitor-enter(this);     // Catch: Throwable -> L13
        long r3 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        this.f2310a.a(r4, r3 - this.f);     // Catch: Throwable -> L8
        this.f = r3;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L11:
        g = r0;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    public void e() {
        d();
        g = -1;
    }
}
