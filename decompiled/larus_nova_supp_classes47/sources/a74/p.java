package a74;

import android.content.Context;
import android.content.Intent;
import com.bytedance.badger.service.SensorDataService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public static volatile Context a;
    public static volatile SensorDataService b;
    public static final AtomicBoolean c = null;
    public static final AtomicBoolean d = null;
    public static final ArrayDeque e = null;
    public static final Object f = null;
    public static final h g = null;

    static {
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
        e = new ArrayDeque();
        f = new Object();
        g = new h();
    }

    public static synchronized void a(final int r3, final int r4, final q r5) {
        monitor-enter(p.class);
        com.bytedance.badger.utils.m.a().b(new n(r3, r4, r5));     // Catch: Throwable -> L7
        monitor-exit(p.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void b(Context r2) {
        if (r2 != null) goto L8;
        String r3 = "init ignored: context null";
    L5:
        com.bytedance.badger.e.g("event_behavior# ", r3);
        return;
    L8:
        if (a == null) goto L10;
        return;
    L10:
        a = r2.getApplicationContext();
        r3 = "init done " + ThreadMethodProxy.currentThread().getName();
        goto L5
    }

    public static void c(String r2) {
    L2:
        Object r0 = f;
        monitor-enter(r0);
        m r1 = (m) e.pollFirst();     // Catch: Throwable -> L11
        if (r1 == null) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L11
        r1.c.a(r2);     // Catch: Throwable -> L14
        goto L2
    L6:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void e() {
        AtomicBoolean r0 = d;
        if (r0.get() == false) goto L5;
        StringBuilder r1 = new StringBuilder("processNext# isCollecting return... ");
    L11:
        r1.append(ThreadMethodProxy.currentThread().getName());
        com.bytedance.badger.e.g("event_behavior# ", r1.toString());
        return;
    L5:
        Object r2 = f;
        monitor-enter(r2);
        ArrayDeque r3 = e;     // Catch: Throwable -> L39
        m r4 = (m) r3.pollFirst();     // Catch: Throwable -> L39
        monitor-exit(r2);     // Catch: Throwable -> L39
        if (r4 != null) goto L13;
        r1 = new StringBuilder("queue empty return... ");
        goto L11
    L13:
        SensorDataService r5 = b;
        if (r5 != null) goto L24;
        monitor-enter(r2);
        r3.addFirst(r4);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        d();
        return;
    L20:
        th = move-exception;
        throw th;
    L24:
        if (r0.compareAndSet(false, true) == true) goto L32;
        monitor-enter(r2);
        r3.addFirst(r4);     // Catch: Throwable -> L29
        monitor-exit(r2);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    L32:
        com.bytedance.badger.e.f("event_behavior# ", "start collect... " + ThreadMethodProxy.currentThread().getName());
        r5.e(r4.a, r4.b, new l(r4));     // Catch: Throwable -> L35
        return;
    L35:
        d.set(false);
        r4.c.a("collect_failed");     // Catch: Throwable -> L42
    L37:
        e();
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public static void d() {
        if (b == null) goto L6;
        com.bytedance.badger.e.f("event_behavior# ", "ensureBoundAndProcess# service is ok... " + ThreadMethodProxy.currentThread().getName());
        e();
        return;
    L6:
        Context r0 = a;
        if (r0 != null) goto L10;
        c("context_null");
        return;
    L10:
        boolean r2 = false;
        if (c.compareAndSet(false, true) == true) goto L20;
        return;
    L20:
        r2 = r0.bindService(new Intent(r0, SensorDataService.class), g, 1);     // Catch: Throwable -> L16
    L17:
        if (r2 == true) goto L22;
        com.bytedance.badger.utils.m.a().b(new o());
        return;
    }
}
