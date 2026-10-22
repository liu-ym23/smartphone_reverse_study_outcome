package com.bytedance.frameworks.baselib.network.http.util;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static a d = null;
    private static final String e = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f2534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<b, ScheduledFuture> f2535b;
    private ConcurrentHashMap<b, Runnable> c;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.util.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.util.a$a, reason: collision with other inner class name */
    private class RunnableC0130a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f2536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f2537b;

        private RunnableC0130a(a r1, b r2) {
            this.f2536a = r1;
            this.f2537b = r2;
        }

        /* synthetic */ RunnableC0130a(a r1, b r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L8
            this.f2537b.run();     // Catch: Throwable -> L8
            if (Logger.debug() == false) goto L6;
            Logger.d(a.b(), "Task execute time: " + (System.currentTimeMillis() - r0));     // Catch: Throwable -> L8
        L6:
            if (this.f2537b.isLoop() == true) goto L13;
        L7:
            a.a(this.f2536a).remove(this.f2537b);
            a.b(this.f2536a).remove(this.f2537b);
            return;
        L13:
            return;
        L8:
            th = move-exception;
            Logger.e(a.b(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L14
            if (this.f2537b.isLoop() == false) goto L7;
            return;
        L14:
            th = move-exception;
            if (this.f2537b.isLoop() == true) goto L18;
            a.a(this.f2536a).remove(this.f2537b);
            a.b(this.f2536a).remove(this.f2537b);
        L18:
            throw th;
        }
    }

    static {
    }

    private a() {
        this.f2535b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        ScheduledThreadPoolExecutor r0 = new ScheduledThreadPoolExecutor(1, new h("ttnet-io"));
        this.f2534a = r0;
        r0.setRemoveOnCancelPolicy(true);
    }

    public static a a() {
        if (d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    static /* synthetic */ ConcurrentHashMap a(a r0) {
        return r0.f2535b;
    }

    static /* synthetic */ String b() {
        return e;
    }

    static /* synthetic */ ConcurrentHashMap b(a r0) {
        return r0.c;
    }

    public void a(b r9) {
        if (r9 != null) goto L13;
        return;
    L13:
        RunnableC0130a r7 = new RunnableC0130a(this, r9, null);     // Catch: Throwable -> L10
        if (r9.isLoop() == false) goto L7;
        ScheduledFuture<?> r0 = this.f2534a.scheduleWithFixedDelay(r7, r9.getInitialDelay(), r9.getLoopInterval(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.c.put(r9, r7);     // Catch: Throwable -> L10
        this.f2535b.put(r9, r0);     // Catch: Throwable -> L10
        return;
    L7:
        r0 = this.f2534a.schedule(r7, r9.getInitialDelay(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(e, "sendTask failed.", th);
    }

    public void a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L25;
        return;
    L25:
        Iterator<Map.Entry<b, Runnable>> r0 = this.c.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r0.hasNext() == false) goto L12;
        b r1 = (b) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r5.equals(r1.getTaskIdentifier()) == false) goto L8;
        r0.remove();     // Catch: Throwable -> L22
        this.f2534a.remove(r1);     // Catch: Throwable -> L22
        goto L8
    L12:
        Iterator<Map.Entry<b, ScheduledFuture>> r4 = this.f2535b.entrySet().iterator();     // Catch: Throwable -> L22
    L13:
        if (r4.hasNext() == false) goto L37;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r5.equals(((b) ZeusTransformUtils.preCheckCast(r2.getKey(), b.class, "com.obric.memorydata.plugin")).getTaskIdentifier()) == false) goto L13;
        ScheduledFuture r3 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(r2.getValue(), ScheduledFuture.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r3 == null) goto L20;
        r3.cancel(true);     // Catch: Throwable -> L22
    L20:
        r4.remove();     // Catch: Throwable -> L22
        goto L13
    L37:
        return;
    L22:
        th = move-exception;
        Logger.e(e, "removeTask failed", th);
    }
}
