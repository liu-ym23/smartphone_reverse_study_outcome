package com.bytedance.android.anniex.scene.handler.idle;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static final h a = null;
    public static final PriorityQueue<c<?>> b = null;
    public static final Set<String> c = null;
    public static final ScheduledExecutorService d = null;
    public static final ScheduledExecutorService e = null;
    public static final AtomicBoolean f = null;
    public static final ConcurrentHashMap<Pair<TaskType, String>, TaskStatus> g = null;
    public static final ConcurrentHashMap<TaskType, List<i>> h = null;

    public h() {
    }

    static {
        a = new h();
        b = new PriorityQueue();
        c = new LinkedHashSet();
        d = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("IdleTaskQueue"));
        e = PThreadExecutorsUtils.newScheduledThreadPool(3, new DefaultThreadFactory("IdleTaskQueue"));
        f = new AtomicBoolean(false);
        g = new ConcurrentHashMap();
        h = new ConcurrentHashMap();
    }

    public final void d() {
        AtomicBoolean r0 = f;
        int r10 = 0;
        if (r0.get() == true) goto L17;
        c<?> r1 = c(false);
        if (r1 == null) goto L17;
        r0.set(true);
        IdleSignalCenter r11 = IdleSignalCenter.a;
        monitor-enter(r11);
        r11.b();     // Catch: Throwable -> L13
        boolean r12 = ((ArrayList) IdleSignalCenter.b).isEmpty();     // Catch: Throwable -> L13
        monitor-exit(r11);
        if (r12 == true) goto L12;
        r0.set(false);
        d.schedule(e.a, 1000, TimeUnit.MILLISECONDS);
        goto L17
    L12:
        d.execute(new f(r1));
    L13:
        th = move-exception;
        throw th;
    L17:
        if (r10 >= 3) goto L26;
        c<?> r13 = c(true);
        if (r13 == null) goto L34;
        if (IdleSignalCenter.a.a() == true) goto L24;
        b(r13, TaskStatus.TIMEOUT);
    L25:
        r10 = r10 + 1;
        goto L17
    L24:
        e.execute(new d(r13));
        goto L25
    L34:
        return;
    }

    public final synchronized void a(c r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "task");     // Catch: Throwable -> L17
        Set<String> r0 = c;     // Catch: Throwable -> L17
        if (r0.contains(r10.a) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r10.i != null) goto L11;
    L14:
        b.offer(r10);     // Catch: Throwable -> L17
        r0.add(r10.a);     // Catch: Throwable -> L17
        b(r10, TaskStatus.QUEUED);     // Catch: Throwable -> L17
        d();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L11:
        if (System.currentTimeMillis() <= r10.i.longValue()) goto L14;
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final c<?> c(boolean r10) {
        monitor-enter(this);
    L23:
        PriorityQueue<c<?>> r0 = b;     // Catch: Throwable -> L20
        c<?> r1 = r0.peek();     // Catch: Throwable -> L20
        if (r1 == null) goto L6;
        if (r1.i == null) goto L14;
        if (System.currentTimeMillis() <= r1.i.longValue()) goto L14;
        r0.poll();     // Catch: Throwable -> L20
        c.remove(r1.a);     // Catch: Throwable -> L20
        b(r1, TaskStatus.TIMEOUT);     // Catch: Throwable -> L20
    L14:
        if (r1.g != r10) goto L18;
        r0.poll();     // Catch: Throwable -> L20
        c.remove(r1.a);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r1;
    L18:
        monitor-exit(this);
        return null;
    L6:
        monitor-exit(this);
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    public static void b(c r10, TaskStatus r11) {
        g.put(TuplesKt.to(r10.b, r10.a), r11);
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.f("IdleTaskQueue", "Status [" + r10.b + "][" + r10.a + "] -> " + r11, null, 12);
        List<i> r1 = h.get(r10.b);
        if (r1 == null) goto L9;
        Iterator<T> r12 = r1.iterator();
    L6:
        if (r12.hasNext() == false) goto L9;
        ((i) r12.next()).a(r10.b, r10.a, r10.c, r10.d, r11);
    L9:
        if (r11 != TaskStatus.SUCCESS) goto L11;
    L14:
        TaskType r13 = r10.b;
        String r14 = r10.d;
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.f("TaskReport", "Report: type=" + r13 + " tag=" + r14 + " status=" + r11, null, 12);
        return;
    L11:
        if (r11 == TaskStatus.FAILED) goto L14;
        if (r11 == TaskStatus.TIMEOUT) goto L14;
    }
}
