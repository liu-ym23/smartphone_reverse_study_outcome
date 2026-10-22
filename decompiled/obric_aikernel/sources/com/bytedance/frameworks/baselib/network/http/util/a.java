package com.bytedance.frameworks.baselib.network.http.util;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f1854d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f1855e = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f1856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<com.bytedance.frameworks.baselib.network.http.util.b, ScheduledFuture> f1857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<com.bytedance.frameworks.baselib.network.http.util.b, Runnable> f1858c;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.util.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0058a {
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.bytedance.frameworks.baselib.network.http.util.b f1859c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f1860g;

        private b(a r10, com.bytedance.frameworks.baselib.network.http.util.b r11) {
            this.f1860g = r10;
            this.f1859c = r11;
        }

        /* synthetic */ b(a r10, com.bytedance.frameworks.baselib.network.http.util.b r11, C0058a r12) {
            this(r10, r11);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r10 = System.currentTimeMillis();     // Catch: Throwable -> L8
            this.f1859c.run();     // Catch: Throwable -> L8
            if (Logger.debug() == false) goto L6;
            Logger.d(a.a(), "Task execute time: " + (System.currentTimeMillis() - r10));     // Catch: Throwable -> L8
        L6:
            if (this.f1859c.isLoop() == true) goto L13;
        L7:
            a.b(this.f1860g).remove(this.f1859c);
            a.c(this.f1860g).remove(this.f1859c);
            return;
        L13:
            return;
        L8:
            th = move-exception;
            Logger.e(a.a(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L14
            if (this.f1859c.isLoop() == false) goto L7;
            return;
        L14:
            th = move-exception;
            if (this.f1859c.isLoop() == true) goto L18;
            a.b(this.f1860g).remove(this.f1859c);
            a.c(this.f1860g).remove(this.f1859c);
        L18:
            throw th;
        }
    }

    static {
    }

    private a() {
        this.f1857b = new ConcurrentHashMap();
        this.f1858c = new ConcurrentHashMap();
        ScheduledThreadPoolExecutor r10 = new ScheduledThreadPoolExecutor(1, new h("ttnet-io"));
        this.f1856a = r10;
        r10.setRemoveOnCancelPolicy(true);
    }

    static /* synthetic */ String a() {
        return f1855e;
    }

    static /* synthetic */ ConcurrentHashMap b(a r10) {
        return r10.f1857b;
    }

    static /* synthetic */ ConcurrentHashMap c(a r10) {
        return r10.f1858c;
    }

    public static a d() {
        if (f1854d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1854d != null) goto L9;
        f1854d = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f1854d;
    }

    public void e(com.bytedance.frameworks.baselib.network.http.util.b r10) {
        if (r10 != null) goto L13;
        return;
    L13:
        b r11 = new b(this, r10, null);     // Catch: Throwable -> L10
        if (r10.isLoop() == false) goto L7;
        ScheduledFuture<?> r12 = this.f1856a.scheduleWithFixedDelay(r11, r10.getInitialDelay(), r10.getLoopInterval(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.f1858c.put(r10, r11);     // Catch: Throwable -> L10
        this.f1857b.put(r10, r12);     // Catch: Throwable -> L10
        return;
    L7:
        r12 = this.f1856a.schedule(r11, r10.getInitialDelay(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(f1855e, "sendTask failed.", th);
    }

    public void f(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L24;
        return;
    L24:
        Iterator<Map.Entry<com.bytedance.frameworks.baselib.network.http.util.b, Runnable>> r11 = this.f1858c.entrySet().iterator();     // Catch: Throwable -> L21
    L7:
        if (r11.hasNext() == false) goto L11;
        com.bytedance.frameworks.baselib.network.http.util.b r12 = r11.next().getKey();     // Catch: Throwable -> L21
        if (r10.equals(r12.getTaskIdentifier()) == false) goto L7;
        r11.remove();     // Catch: Throwable -> L21
        this.f1856a.remove(r12);     // Catch: Throwable -> L21
        goto L7
    L11:
        Iterator<Map.Entry<com.bytedance.frameworks.baselib.network.http.util.b, ScheduledFuture>> r13 = this.f1857b.entrySet().iterator();     // Catch: Throwable -> L21
    L12:
        if (r13.hasNext() == false) goto L36;
        Map.Entry<com.bytedance.frameworks.baselib.network.http.util.b, ScheduledFuture> r14 = r13.next();     // Catch: Throwable -> L21
        if (r10.equals(r14.getKey().getTaskIdentifier()) == false) goto L12;
        ScheduledFuture r15 = r14.getValue();     // Catch: Throwable -> L21
        if (r15 == null) goto L19;
        r15.cancel(true);     // Catch: Throwable -> L21
    L19:
        r13.remove();     // Catch: Throwable -> L21
        goto L12
    L36:
        return;
    L21:
        th = move-exception;
        Logger.e(f1855e, "removeTask failed", th);
    }
}
