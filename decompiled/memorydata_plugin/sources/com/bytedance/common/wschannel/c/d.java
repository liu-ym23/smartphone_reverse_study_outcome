package com.bytedance.common.wschannel.c;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static d d = null;
    private static final String e = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f2012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<e, ScheduledFuture> f2013b;
    private ConcurrentHashMap<e, Runnable> c;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.c.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e f2015b;

        private a(d r1, e r2) {
            this.f2014a = r1;
            this.f2015b = r2;
        }

        /* synthetic */ a(d r1, e r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L8
            this.f2015b.run();     // Catch: Throwable -> L8
            if (Logger.debug() == false) goto L6;
            Logger.d(d.b(), "Task execute time: " + (System.currentTimeMillis() - r0));     // Catch: Throwable -> L8
        L6:
            if (this.f2015b.b() == true) goto L13;
        L7:
            d.a(this.f2014a).remove(this.f2015b);
            d.b(this.f2014a).remove(this.f2015b);
            return;
        L13:
            return;
        L8:
            th = move-exception;
            Logger.e(d.b(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L14
            if (this.f2015b.b() == false) goto L7;
            return;
        L14:
            th = move-exception;
            if (this.f2015b.b() == true) goto L18;
            d.a(this.f2014a).remove(this.f2015b);
            d.b(this.f2014a).remove(this.f2015b);
        L18:
            throw th;
        }
    }

    static {
    }

    private d() {
        this.f2013b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.f2012a = new ScheduledThreadPoolExecutor(1, new f("frontier"));
    }

    public static d a() {
        if (d != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    static /* synthetic */ ConcurrentHashMap a(d r0) {
        return r0.f2013b;
    }

    static /* synthetic */ String b() {
        return e;
    }

    static /* synthetic */ ConcurrentHashMap b(d r0) {
        return r0.c;
    }

    public void a(e r9) {
        if (r9 != null) goto L13;
        return;
    L13:
        a r7 = new a(this, r9, null);     // Catch: Throwable -> L10
        if (r9.b() == false) goto L7;
        ScheduledFuture<?> r0 = this.f2012a.scheduleWithFixedDelay(r7, r9.a(), r9.c(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.c.put(r9, r7);     // Catch: Throwable -> L10
        this.f2013b.put(r9, r0);     // Catch: Throwable -> L10
        return;
    L7:
        r0 = this.f2012a.schedule(r7, r9.a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(e, "sendTask failed.", th);
    }
}
