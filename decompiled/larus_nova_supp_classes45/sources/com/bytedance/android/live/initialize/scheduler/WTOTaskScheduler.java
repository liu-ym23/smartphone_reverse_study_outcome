package com.bytedance.android.live.initialize.scheduler;

import com.bytedance.android.live.initialize.IWTORepeatableTask;
import com.bytedance.android.live.initialize.IWTOTask;
import com.bytedance.android.live.initialize.LiveWTO;
import com.bytedance.android.live.initialize.WTOPriorityType;
import com.bytedance.android.live.initialize.WTOThreadPoolHelper;
import com.bytedance.android.live.initialize.WTOThreadWorkType;
import com.bytedance.android.live.initialize.api.IWTOLogger;
import com.bytedance.android.live.initialize.model.WTOTaskProxy;
import com.bytedance.android.live.initialize.state.WTOSchedulerStatus;
import com.bytedance.android.live.initialize.state.WTOTaskStatus;
import com.bytedance.common.jato.Jato;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class WTOTaskScheduler implements wa0.c {
    public volatile WTOSchedulerStatus a;
    public final int b;
    public final AtomicInteger c;
    public final int d;
    public final AtomicInteger e;
    public long f;
    public com.bytedance.android.live.initialize.model.a g;
    public final Object h;
    public final ReentrantLock i;
    public com.bytedance.android.live.initialize.scheduler.a j;
    public final Function0<Boolean> k;
    public final com.bytedance.android.live.initialize.a l;
    public final com.bytedance.android.live.initialize.model.b m;
    public ExecutorService n;
    public final WTOSchedulerNotify o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/initialize/scheduler/WTOTaskScheduler$TaskExecuteError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "msg", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "live-initialize-scheduler_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TaskExecuteError extends RuntimeException {
        private final Exception exception;
        private final String msg;

        public static /* synthetic */ TaskExecuteError copy$default(TaskExecuteError r0, String r1, Exception r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.msg;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.exception;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.msg;
        }

        public final Exception component2() {
            return this.exception;
        }

        public final TaskExecuteError copy(String r2, Exception r3) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return new TaskExecuteError(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof TaskExecuteError) == false) goto L10;
            TaskExecuteError r4 = (TaskExecuteError) r3;
            if (Intrinsics.areEqual(this.msg, r4.msg) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.exception, r4.exception) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.msg;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Exception r4 = this.exception;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "TaskExecuteError(msg=" + this.msg + ", exception=" + this.exception + ")";
        }

        public final Exception getException() {
            return this.exception;
        }

        public final String getMsg() {
            return this.msg;
        }

        public TaskExecuteError(String r2, Exception r3) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            super(r2, r3);
            this.msg = r2;
            this.exception = r3;
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ WTOTaskProxy a;
        public final /* synthetic */ WTOTaskScheduler b;

        public b(WTOTaskProxy r1, WTOTaskScheduler r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            IWTOLogger r0 = ya0.a.a;
            ya0.a.c("thread:" + ThreadMethodProxy.currentThread().getId() + ", " + this.a.k.taskBusinessInfo() + " execute finish!");
            if (Intrinsics.areEqual(this.a.k.taskExecutePeriod(), this.b.l) == true) goto L5;
            return;
        L5:
            if (this.b.c.get() != this.b.b) goto L7;
            ya0.a.c("thread:" + ThreadMethodProxy.currentThread().getId() + ", " + this.b.l.b + " block task execute finish!");
            this.b.e();
        L7:
            int r1 = this.b.e.get();
            WTOTaskScheduler r2 = this.b;
            if (r1 == r2.d) goto L12;
            r2.d();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ IWTOTask a;
        public final /* synthetic */ WTOTaskScheduler b;

        public c(IWTOTask r1, WTOTaskScheduler r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WTOTaskScheduler.g(this.b, com.bytedance.android.live.initialize.model.c.a(this.a), null, null, 6);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ WTOTaskScheduler a;

        public d(WTOTaskScheduler r1) {
            this.a = r1;
        }

        public final void a() {
            IWTOLogger r0 = ya0.a.a;
            ya0.a.c("new thread" + ThreadMethodProxy.currentThread().getId() + " to execute task");
            this.a.d();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void d() {
        Object r0 = this.h;
        monitor-enter(r0);
        IWTOTask r1 = (IWTOTask) CollectionsKt.firstOrNull(this.m.a(this.l));     // Catch: Throwable -> L14
        if (r1 == null) goto L7;
        WTOTaskProxy r2 = com.bytedance.android.live.initialize.model.c.a(r1);     // Catch: Throwable -> L14
    L8:
        if (r2 == null) goto L10;
        r2.a = WTOTaskStatus.QUEUE;     // Catch: Throwable -> L14
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L10:
        monitor-exit(r0);
        if (r2 == null) goto L19;
        g(this, r2, null, new b(r2, this), 2);
        return;
    L19:
        return;
    L7:
        r2 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public final void e() {
        WTOSchedulerStatus r0 = this.a;
        WTOSchedulerStatus r1 = WTOSchedulerStatus.BLOCK_FINISHED;
        if (r0 == r1) goto L11;
        this.a = r1;
        if (((Boolean) this.k.invoke()).booleanValue() == true) goto L9;
        com.bytedance.android.live.initialize.scheduler.a r2 = this.j;
        if (r2 == null) goto L9;
        r2.sendMessage(r2.obtainMessage(10000001));
    L9:
        IWTOLogger r3 = ya0.a.a;
        com.bytedance.android.live.initialize.a r4 = this.l;
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("finishTime", Long.valueOf(System.currentTimeMillis()));
        r5.put("duration", Long.valueOf(System.currentTimeMillis() - this.f));
        r5.put("schedule_thread_id", Long.valueOf(ThreadMethodProxy.currentThread().getId()));
        r5.put("all_block_size", Integer.valueOf(this.b));
        r5.put("complete_block_size", this.c);
        r5.put("lock_status", Boolean.valueOf(this.i.isLocked()));
        Unit r6 = Unit.INSTANCE;
        ya0.a.d(r4, "     SCHEDULE UNLOCK     ", r5);
        return;
    }

    public final void f() {
        WTOSchedulerStatus r0 = this.a;
        WTOSchedulerStatus r1 = WTOSchedulerStatus.FINISHED;
        if (r0 == r1) goto L6;
        this.a = r1;
        long r2 = System.currentTimeMillis() - this.f;
        com.bytedance.android.live.initialize.a r3 = this.l;
        r3.a = r2;
        this.o.d(10005, r3);
        IWTOLogger r4 = ya0.a.a;
        com.bytedance.android.live.initialize.a r5 = this.l;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("finishTime", Long.valueOf(System.currentTimeMillis()));
        r6.put("duration", Long.valueOf(r2));
        r6.put("schedule_thread_id", Long.valueOf(ThreadMethodProxy.currentThread().getId()));
        r6.put("all_task_size", Integer.valueOf(this.d));
        r6.put("complete_size", this.e);
        Unit r7 = Unit.INSTANCE;
        ya0.a.d(r5, "______SCHEDULE FINISHED______", r6);
        return;
    }

    public final void h() {
        Iterator<T> r0 = this.m.a(this.l).iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        IWTOTask r1 = (IWTOTask) r0.next();
        WTOTaskProxy r2 = com.bytedance.android.live.initialize.model.c.a(r1);
        r2.a = WTOTaskStatus.QUEUE;
        if ((r1 instanceof IWTORepeatableTask) == false) goto L11;
        if (((IWTORepeatableTask) r1).taskThreadWorkType() != WTOThreadWorkType.IO) goto L11;
        ExecutorService r3 = WTOThreadPoolHelper.INSTANCE.getMIOThreadPool();
    L14:
        this.n = r3;
        r3.execute(new c(r1, this));
    L11:
        if (r1.taskPriorityType() != WTOPriorityType.NOW) goto L13;
        r3 = WTOThreadPoolHelper.INSTANCE.getMCpuMixedHighPriorityThreadPool();
        goto L14
    L13:
        r3 = WTOThreadPoolHelper.INSTANCE.getMCpuMixedCommonThreadPool();
        goto L14
    }

    public final void i() {
        IWTOLogger r0 = ya0.a.a;
        ya0.a.c("thread:" + ThreadMethodProxy.currentThread().getId() + ", start schedule " + this.l.b + " tasks");
        IntIterator r1 = RangesKt.until(1, LiveWTO.INSTANCE.getInitThreadPoolSize()).iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        r1.nextInt();
        Executor r2 = LiveWTO.INSTANCE.getInitExecutor();
        if (r2 != null) goto L8;
        r2 = WTOThreadPoolHelper.INSTANCE.getMCpuMixedCommonThreadPool();
    L8:
        r2.execute(new d(this));
        goto L4
    L9:
        d();
        Object r3 = this.h;
        monitor-enter(r3);
    L21:
    L18:
        th = move-exception;
        throw th;
    L12:
        if (this.e.get() >= this.d) goto L14;
        IWTOLogger r4 = ya0.a.a;     // Catch: Throwable -> L18
        ya0.a.c("thread:" + ThreadMethodProxy.currentThread().getId() + ",  wait task execute finish!");     // Catch: Throwable -> L18
        this.h.wait();     // Catch: Throwable -> L18
        goto L21
    L14:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r3);
        f();
        IWTOLogger r6 = ya0.a.a;
        ya0.a.c(this.l.b + " all task execute finish!");
    }

    @Override // wa0.c
    public final void a(WTOTaskProxy r2) {
        Intrinsics.checkNotNullParameter(r2, "taskProxy");
        Intrinsics.checkNotNullParameter(r2, "taskProxy");
    }

    @Override // wa0.c
    public final void b(WTOTaskProxy r2) {
        Intrinsics.checkNotNullParameter(r2, "taskProxy");
        Intrinsics.checkNotNullParameter(r2, "taskProxy");
    }

    @Override // wa0.c
    public final void c(WTOTaskProxy r3) {
        Intrinsics.checkNotNullParameter(r3, "taskProxy");
        Intrinsics.checkNotNullParameter(r3, "taskProxy");
        if (Intrinsics.areEqual(r3.k.taskExecutePeriod(), this.l) == true) goto L5;
        return;
    L5:
        if (this.e.get() != this.d) goto L13;
        com.bytedance.android.live.initialize.model.a r4 = this.g;
        if (r4 == null) goto L12;
        Object r0 = r4.a.get();
        if (r0 == null) goto L11;
        r4.b.invoke(r0);
    L11:
        r4.a.clear();
    L12:
        f();
        return;
    L13:
        h();
    }

    public WTOTaskScheduler(com.bytedance.android.live.initialize.a r3, com.bytedance.android.live.initialize.model.b r4, ExecutorService r5, WTOSchedulerNotify r6) {
        Intrinsics.checkNotNullParameter(r3, "period");
        Intrinsics.checkNotNullParameter(r4, "mWTOTaskManager");
        Intrinsics.checkNotNullParameter(r5, "executorService");
        Intrinsics.checkNotNullParameter(r6, "schedulerNotify");
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        this.a = WTOSchedulerStatus.IDLE;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "period");
        CopyOnWriteArrayList<IWTOTask> r7 = r4.c.get(r3);
        if (r7 == null) goto L11;
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L6:
        if (r9.hasNext() == false) goto L10;
        Object r11 = r9.next();
        if (((Boolean) com.bytedance.android.live.initialize.model.c.a((IWTOTask) r11).c.getValue()).booleanValue() == false) goto L6;
        r8.add(r11);
        goto L6
    L10:
        int r12 = r8.size();
    L12:
        this.b = r12;
        this.c = new AtomicInteger(0);
        com.bytedance.android.live.initialize.model.b r13 = this.m;
        com.bytedance.android.live.initialize.a r14 = this.l;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "period");
        CopyOnWriteArrayList<IWTOTask> r15 = r13.c.get(r14);
        if (r15 == null) goto L15;
        int r16 = r15.size();
    L16:
        this.d = r16;
        this.e = new AtomicInteger(0);
        this.h = new Object();
        this.i = new ReentrantLock();
        this.k = new WTOTaskScheduler$unLockAction$1(this);
        return;
    L15:
        r16 = 0;
        goto L16
    L11:
        r12 = 0;
        goto L12
    }

    public static void g(final WTOTaskScheduler r8, final WTOTaskProxy r9, String r11, b r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        r11 = "scheduler";
    L5:
        final String r5 = r11;
        int r14 = r13 & 4;
        Exception r15 = null;
        if (r14 == 0) goto L8;
        final b r6 = null;
    L9:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "task");
        Intrinsics.checkNotNullParameter(r5, "source");
        final long r3 = System.currentTimeMillis();
        IWTOLogger r16 = ya0.a.a;
        com.bytedance.android.live.initialize.a r17 = r8.l;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("taskName", (String) r9.e.getValue());
        r0.put("source", r5);
        r0.put("taskInfo", Integer.valueOf(r9.k.taskID()));
        r0.put("startTime", Long.valueOf(r3));
        r0.put("threadId", Long.valueOf(ThreadMethodProxy.currentThread().getId()));
        r0.put("taskDetail", (String) r9.g.getValue());
        Unit r18 = Unit.INSTANCE;
        ya0.a.d(r17, "TASK STARTED", r0);
        WTOSchedulerNotify r19 = r8.o;
        Function2<Boolean, Exception, Unit> r110 = new WTOTaskScheduler$runTask$2(r8, r9, r3, r5, r6);
        Intrinsics.checkNotNullParameter(r19, "schNotify");
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (r9.a != WTOTaskStatus.IDLE) goto L12;
    L13:
        r9.b.lock();
        WTOTaskStatus r1 = r9.a;
        WTOTaskStatus r2 = WTOTaskStatus.FINISHED;
        boolean r4 = false;
        if (r1 != r2) goto L58;
    L53:
        r9.b.unlock();
        if (r9.a != r2) goto L56;
        r4 = true;
    L56:
        r110.invoke(Boolean.valueOf(r4), null);
        return;
    L58:
        if (r9.a == WTOTaskStatus.FAILED) goto L53;
        r9.a = WTOTaskStatus.RUNNING;     // Catch: Throwable -> L21 Exception -> L41
        Thread r7 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L21 Exception -> L41
        String r21 = r7.getName();     // Catch: Throwable -> L21 Exception -> L41
        if ((!Intrinsics.areEqual((String) r9.f.getValue(), "")) == false) goto L23;
        String r22 = (String) r9.f.getValue();     // Catch: Throwable -> L21 Exception -> L41
    L24:
        ThreadMethodProxy.setName(r7, r22);     // Catch: Throwable -> L21 Exception -> L41
        r9.h = r7.getId();     // Catch: Throwable -> L21 Exception -> L41
        r19.d(10001, r9);     // Catch: Throwable -> L21 Exception -> L41
        if (((Boolean) r9.i.getValue()).booleanValue() == true) goto L27;
    L33:
        boolean r111 = false;
    L34:
        r9.k.run();     // Catch: Throwable -> L21 Exception -> L41
        if (r111 == false) goto L37;
        Jato.resetCoreBind((int) r9.h);     // Catch: Throwable -> L21 Exception -> L41
        Jato.releaseBoost();     // Catch: Throwable -> L21 Exception -> L41
    L37:
        r9.a = r2;     // Catch: Throwable -> L21 Exception -> L41
        LinkedHashMap r23 = new LinkedHashMap();     // Catch: Throwable -> L21 Exception -> L41
        r23.put("threadName", r7.getName());     // Catch: Throwable -> L21 Exception -> L41
        ya0.a.a("runWithCallback before reset origin name", r23.toString());     // Catch: Throwable -> L21 Exception -> L41
        ThreadMethodProxy.setName(r7, r21);     // Catch: Throwable -> L21 Exception -> L41
        LinkedHashMap r24 = new LinkedHashMap();     // Catch: Throwable -> L21 Exception -> L41
        r24.put("threadName", r7.getName());     // Catch: Throwable -> L21 Exception -> L41
        ya0.a.a("runWithCallback after reset origin name", r24.toString());     // Catch: Throwable -> L21 Exception -> L41
        r9.b.unlock();
        if (r9.a == r2) goto L46;
    L47:
        r110.invoke(Boolean.valueOf(r4), r15);
        return;
    L46:
        r4 = true;
        goto L47
    L27:
        if (r9.k.taskPriorityType() != WTOPriorityType.BACKGROUND) goto L30;
        Jato.bindLittleCore((int) r9.h);     // Catch: Throwable -> L21 Exception -> L41
    L32:
        r111 = true;
        goto L34
    L30:
        if (r9.k.taskPriorityType() != WTOPriorityType.NOW) goto L33;
        Jato.bindBigCore((int) r9.h);     // Catch: Throwable -> L21 Exception -> L41
        Jato.tryCpuBoost(1000);     // Catch: Throwable -> L21 Exception -> L41
        goto L32
    L23:
        r22 = "WTO_" + ((String) r9.e.getValue());     // Catch: Throwable -> L21 Exception -> L41
    L41:
        e = move-exception;
        r15 = e;
        r9.a = WTOTaskStatus.FAILED;     // Catch: Throwable -> L21
        r9.b.unlock();
        if (r9.a != WTOTaskStatus.FINISHED) goto L47;
    L21:
        th = move-exception;
        r9.b.unlock();
        if (r9.a != WTOTaskStatus.FINISHED) goto L51;
        r4 = true;
    L51:
        r110.invoke(Boolean.valueOf(r4), null);
        throw th;
    L12:
        if (r9.a == WTOTaskStatus.QUEUE) goto L13;
        return;
    L8:
        r6 = r12;
        goto L9
    }
}
