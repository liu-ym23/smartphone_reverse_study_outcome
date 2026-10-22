package a74;

import android.content.Context;
import android.os.SystemClock;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static volatile long a;
    public static final Object b = null;
    public static final AtomicBoolean c = null;
    public static volatile boolean d;
    public static volatile int e;
    public static volatile boolean f;
    public static final ArrayDeque g = null;
    public static final ArrayDeque h = null;

    static {
        b = new Object();
        c = new AtomicBoolean(false);
        d = false;
        e = 0;
        f = false;
        g = new ArrayDeque();
        h = new ArrayDeque();
    }

    public static void c() {
        Object r0 = b;
        monitor-enter(r0);
        d = false;     // Catch: Throwable -> L8
        a = 0;     // Catch: Throwable -> L8
        g.clear();     // Catch: Throwable -> L8
        h.clear();     // Catch: Throwable -> L8
        e = 0;     // Catch: Throwable -> L8
        f = false;     // Catch: Throwable -> L8
        com.bytedance.badger.e.g("event_behavior# ", "stop: sensor window stopped and clear!");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void b() {
        Object r0 = b;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (d == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L8:
        long r1 = e;     // Catch: Throwable -> L20
        com.bytedance.badger.v.d.f0.getClass();     // Catch: Throwable -> L20
        com.bytedance.badger.v.k r3 = com.bytedance.badger.v.d.b0;     // Catch: Throwable -> L20
        KProperty[] r4 = com.bytedance.badger.v.d.a;     // Catch: Throwable -> L20
        KProperty r5 = r4[54];     // Catch: Throwable -> L20
        if (r1 < ((Number) r3.a()).longValue()) goto L13;
        com.bytedance.badger.e.g("event_behavior# ", "batch > max count return");     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L20
        if (c.compareAndSet(false, true) == true) goto L18;
        com.bytedance.badger.e.g("event_behavior# ", "isCollecting return..." + ThreadMethodProxy.currentThread().getName());
        return;
    L18:
        com.bytedance.badger.e.f("event_behavior# ", "scheduleNext..." + ThreadMethodProxy.currentThread().getName());
        com.bytedance.badger.v.h r2 = com.bytedance.badger.v.d.O;
        KProperty r6 = r4[41];
        int r7 = ((Number) r2.a()).intValue();
        com.bytedance.badger.v.h r8 = com.bytedance.badger.v.d.P;
        KProperty r9 = r4[42];
        p.a(r7, ((Number) r8.a()).intValue(), new d());
    }

    public static void a(Context r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        p.b(r8.getApplicationContext());
        long r1 = SystemClock.uptimeMillis();
        Object r9 = b;
        monitor-enter(r9);
        long r3 = r1 - a;     // Catch: Throwable -> L23
        com.bytedance.badger.v.d.f0.getClass();     // Catch: Throwable -> L23
        com.bytedance.badger.v.k r5 = com.bytedance.badger.v.d.X;     // Catch: Throwable -> L23
        KProperty r6 = com.bytedance.badger.v.d.a[50];     // Catch: Throwable -> L23
        if (r3 >= ((Number) r5.a()).longValue()) goto L12;
        monitor-exit(r9);     // Catch: Throwable -> L23
        return;
    L12:
        if (f == true) goto L14;
    L19:
        a = r1;     // Catch: Throwable -> L23
        d = true;     // Catch: Throwable -> L23
        e = 0;     // Catch: Throwable -> L23
        f = true;     // Catch: Throwable -> L23
        g.clear();     // Catch: Throwable -> L23
        h.clear();     // Catch: Throwable -> L23
        com.bytedance.badger.e.f("event_behavior# ", "start: begin sensor window collection");     // Catch: Throwable -> L23
        monitor-exit(r9);     // Catch: Throwable -> L23
        b();
        return;
    L14:
        if (e <= 0) goto L19;
        com.bytedance.badger.e.g("event_behavior# ", "start skipped: previous data not consumed, batchCount=" + e);     // Catch: Throwable -> L23
        monitor-exit(r9);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }
}
