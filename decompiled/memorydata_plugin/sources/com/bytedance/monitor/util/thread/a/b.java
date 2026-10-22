package com.bytedance.monitor.util.thread.a;

import android.util.Pair;
import com.bytedance.monitor.util.thread.d;
import com.bytedance.monitor.util.thread.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class b extends ScheduledThreadPoolExecutor implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2901b;
    private e c;
    private final Map<Integer, List<ScheduledFuture<?>>> d;
    private final Map<ScheduledFuture<?>, Pair<Integer, Boolean>> e;
    private ExecutorService f;
    private ThreadPoolExecutor g;
    private int h;
    private a i;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f2902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Thread f2903b;
        public long c;
        public int d;
        final /* synthetic */ b e;

        public a(b r3, Runnable r4, Thread r5, int r6) {
            Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
            this.e = r3;
            this.f2902a = r7;
            this.f2903b = r5;
            this.c = System.currentTimeMillis();
            this.d = r6;
        }

        public boolean a() {
            if ((System.currentTimeMillis() - this.c) <= this.d) goto L5;
            return true;
        L5:
            return false;
        }

        public void b() {
            Runnable r0 = this.f2902a;
            if (r0 != null) goto L6;
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r0, FutureTask.class) == false) goto L11;
            boolean r1 = ((FutureTask) ZeusTransformUtils.preCheckCast(this.f2902a, FutureTask.class, "com.obric.memorydata.plugin")).cancel(true);
            if (b.a(this.e) == false) goto L12;
            b.a(this.e, "TimeSensitive + mCancelOverTimeTaskRunnable run ------------ cancel FutureTask, canceled?" + r1);
            return;
        L12:
            return;
        }
    }

    public b(int r3, ThreadFactory r4) {
        super(r3, (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r4, ThreadFactory.class, "com.obric.memorydata.plugin"));
        this.f2900a = "ApmInnerThreadPool";
        this.f2901b = false;
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
    }

    private String a(Runnable r2) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.class) == true) goto L5;
        if (r1 != null) goto L10;
        return "null";
    L10:
        return r1.toString();
    L5:
        return ((d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.memorydata.plugin")).a();
    }

    static /* synthetic */ void a(b r0, String r1) {
        r0.a(r1);
    }

    private void a(Integer r4, ScheduledFuture r5) {
        ScheduledFuture r6 = (ScheduledFuture) ZeusTransformUtils.wrapperContextForParams(r5, ScheduledFuture.class, "com.obric.memorydata.plugin");
        List r0 = (List) ZeusTransformUtils.preCheckCast(this.d.get(r4), List.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        boolean r1 = r0.remove(r6);
        if (r0.isEmpty() == false) goto L8;
        this.d.remove(r4);
    L8:
        this.e.remove(r6);
        if (b() == false) goto L12;
        a("z-debug removeMapRecord: " + r6 + ", removed: " + r1);
        return;
    L12:
        return;
    L7:
        r1 = false;
        goto L8
    }

    private void a(String r2) {
        com.bytedance.monitor.util.thread.b.a(this.c, "ApmInnerThreadPool", r2);
    }

    private void a(ScheduledFuture<?> r4, int r5, boolean r6) {
        ScheduledFuture<?> r7 = (ScheduledFuture) ZeusTransformUtils.wrapperContextForParams(r4, ScheduledFuture.class, "com.obric.memorydata.plugin");
        List<ScheduledFuture<?>> r0 = (List) ZeusTransformUtils.preCheckCast(this.d.get(Integer.valueOf(r5)), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new CopyOnWriteArrayList();
        this.d.put(Integer.valueOf(r5), r0);
    L5:
        r0.add(r7);
        this.e.put(r7, new Pair(Integer.valueOf(r5), Boolean.valueOf(r6)));
        if (b() == false) goto L9;
        a("z-debug saveToMap -current task count: " + getQueue().size() + ", thread-count; " + getActiveCount());
        a("z-debug saveToMap >>>>>> mTaskFutureMap size: " + this.d.size() + ", mFutureTaskMap size: " + this.e.size());
        a("z-debug saveToMap >>>>>> sameHashCodeFutures size: " + r0.size());
        return;
    }

    private void a(boolean r3, Runnable r4, Thread r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if (a() == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        a r7 = new a(this, r6, r5, this.h);
    L8:
        this.i = r7;
        return;
    L7:
        r7 = null;
        goto L8
    }

    private boolean a() {
        if (this.h <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean a(b r0) {
        return r0.b();
    }

    private boolean b() {
        if (this.f2901b == false) goto L9;
        e r1 = this.c;
        if (r1 == null) goto L9;
        if (r1.a() == false) goto L9;
        return true;
    L9:
        return false;
    }

    private void c() {
        a r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a() == false) goto L9;
        this.i.b();
        this.i = null;
        return;
    }

    private boolean c(d r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r9 != null) goto L5;
        return false;
    L5:
        int r2 = r9.hashCode();
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.d.get(Integer.valueOf(r2)), List.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = new StringBuilder().append("z-debug scheduledFutures in ?");
        if (r3 == null) goto L8;
        boolean r6 = true;
    L9:
        a(r4.append(r6).toString());
        if (r3 != null) goto L12;
    L25:
        return r0;
    L12:
        if (r3.isEmpty() == true) goto L25;
        if (b() == false) goto L16;
        a("z-debug-removeTask from mTaskFutureMap" + com.bytedance.monitor.util.thread.b.a(r9));
        a("z-debug scheduledFutures size:" + r3.size());
    L16:
        Iterator r10 = r3.iterator();
    L18:
        if (r10.hasNext() == false) goto L25;
        ScheduledFuture r5 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(r10.next(), ScheduledFuture.class, "com.obric.memorydata.plugin");
        if (r5.isCancelled() == true) goto L18;
        if (r5.cancel(true) == false) goto L24;
        r0 = true;
    L24:
        a(Integer.valueOf(r2), r5);
        goto L18
    L8:
        r6 = false;
        goto L9
    }

    @Override // com.bytedance.monitor.util.thread.a.c
    public void a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (b() == false) goto L5;
        a("post " + com.bytedance.monitor.util.thread.b.a(r4));
    L5:
        submit(r4);
        c();
        if (this.f == null) goto L8;
        return;
    L8:
        if (b() == false) goto L12;
        a("current task count: " + getQueue().size());
        return;
    }

    @Override // com.bytedance.monitor.util.thread.a.c
    public void a(d r3, long r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return;
    L6:
        if (b() == false) goto L8;
        a("postDelayed " + com.bytedance.monitor.util.thread.b.a(r5));
    L8:
        a(schedule(r5, r4, TimeUnit.MILLISECONDS), r5.hashCode(), false);
        c();
    }

    @Override // com.bytedance.monitor.util.thread.a.c
    public void a(d r8, long r9, long r11) {
        d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L6;
        return;
    L6:
        if (b() == false) goto L8;
        a("scheduleWithFixedDelay " + com.bytedance.monitor.util.thread.b.a(r10) + ", initialDelay: " + r9 + ", delayInMillis: " + r11 + "\n task count: " + getQueue().size());
    L8:
        c(r10);
        a(scheduleWithFixedDelay(r10, r9, r11, TimeUnit.MILLISECONDS), r10.hashCode(), true);
        c();
    }

    public void a(e r3) {
        this.c = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable r5, Throwable r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        super.afterExecute(r7, r6);
        a(false, r7, null);
        if (ZeusTransformUtils.instanceOf(r7, ScheduledFuture.class) == false) goto L18;
        ScheduledFuture r8 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(r7, ScheduledFuture.class, "com.obric.memorydata.plugin");
        Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(this.e.get(r8), Pair.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.first == null) goto L20;
        int r2 = ((Integer) ZeusTransformUtils.preCheckCast(r0.first, Integer.class, "com.obric.memorydata.plugin")).intValue();
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(r0.second, Boolean.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.booleanValue() == false) goto L14;
        return;
    L14:
        if (b() == false) goto L16;
        a("z-debug postDelay or scheduled task: " + r7 + ", taskHashCode: " + r2 + ", in map? " + this.d.containsKey(Integer.valueOf(r2)));
    L16:
        a(Integer.valueOf(r2), r8);
        return;
    L20:
        return;
    }

    @Override // com.bytedance.monitor.util.thread.a.c
    public void b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        ThreadPoolExecutor r0 = this.g;
        if (r0 == null) goto L6;
        r0.remove(r4);
    L6:
        if (c(r4) == false) goto L8;
        return;
    L8:
        if (b() == false) goto L12;
        a("z-debug-removeTask " + com.bytedance.monitor.util.thread.b.a(r4) + ", remove failed");
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        a(true, r5, r3);
        super.beforeExecute(r3, r5);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (this.f == null) goto L10;
        if (b() == false) goto L8;
        a("submit task to outer-executor: " + a(r4));
    L8:
        return this.f.submit(r4);
    L10:
        return super.submit(r4);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r3, T r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (this.f == null) goto L10;
        if (b() == false) goto L8;
        a("submit task to outer-executor: " + a(r5));
    L8:
        return this.f.submit(r5, r4);
    L10:
        return super.submit(r5, r4);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r3) {
        Callable<T> r4 = (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin");
        if (this.f == null) goto L10;
        if (b() == false) goto L8;
        a("submit task to outer-executor: " + r4);
    L8:
        return this.f.submit(r4);
    L10:
        return super.submit(r4);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void terminated() {
        super.terminated();
    }
}
