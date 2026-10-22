package com.bytedance.android.live.initialize;

import android.os.Looper;
import com.bytedance.android.live.initialize.api.IWTOLogger;
import com.bytedance.android.live.initialize.model.WTOTaskProxy;
import com.bytedance.android.live.initialize.model.c;
import com.bytedance.android.live.initialize.scheduler.WTOSchedulerNotify;
import com.bytedance.android.live.initialize.scheduler.WTOTaskScheduler;
import com.bytedance.android.live.initialize.state.WTOSchedulerStatus;
import com.bytedance.android.live.initialize.state.WTOTaskStatus;
import com.bytedance.android.livesdkapi.init.ILiveInitTaskController;
import com.bytedance.android.livesdkapi.init.ILiveInitTaskListener;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bL\u0010MJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\fJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0004J\u0012\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016R\"\u0010#\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R$\u0010,\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER'\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020G0F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010:\u001a\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/bytedance/android/live/initialize/LiveWTO;", "Lcom/bytedance/android/livesdkapi/init/ILiveInitTaskController;", "Lcom/bytedance/android/live/initialize/a;", "period", "", "isInit", "", "triggerWTOPeriodTaskExecute", "Lcom/bytedance/android/live/initialize/IWTOTask;", "iWTOTask", "commitRepeatableTask", "cancelRepeatableTask", "", "taskId", "ensureTaskReady", "Lwa0/c;", "listener", "Lwa0/a;", "observeTaskState", "Lwa0/b;", "observeScheduleState", "Lcom/bytedance/android/live/initialize/api/IWTOLogger;", "IWTOLogger", "configLogger", "size", "configThreadPoolSize", "configIoThreadPoolSize", "Ljava/util/concurrent/Executor;", "executor", "configInitExecutor", "jatoOpt", "configJatoOpt", "Lcom/bytedance/android/livesdkapi/init/ILiveInitTaskListener;", "taskListener", "setInitTaskListener", "initThreadPoolSize", "I", "getInitThreadPoolSize", "()I", "setInitThreadPoolSize", "(I)V", "ioThreadPoolSize", "getIoThreadPoolSize", "setIoThreadPoolSize", "initExecutor", "Ljava/util/concurrent/Executor;", "getInitExecutor", "()Ljava/util/concurrent/Executor;", "setInitExecutor", "(Ljava/util/concurrent/Executor;)V", "enableJatoOpt", "Z", "getEnableJatoOpt", "()Z", "setEnableJatoOpt", "(Z)V", "Lcom/bytedance/android/live/initialize/scheduler/WTOSchedulerNotify;", "mSchedulerNotify$delegate", "Lkotlin/Lazy;", "getMSchedulerNotify", "()Lcom/bytedance/android/live/initialize/scheduler/WTOSchedulerNotify;", "mSchedulerNotify", "Lcom/bytedance/android/live/initialize/model/b;", "mWTOTaskManager$delegate", "getMWTOTaskManager", "()Lcom/bytedance/android/live/initialize/model/b;", "mWTOTaskManager", "Lcom/bytedance/android/live/initialize/b;", "taskListenerAdapter", "Lcom/bytedance/android/live/initialize/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/android/live/initialize/scheduler/WTOTaskScheduler;", "mWTOPeriodTaskSchedulers$delegate", "getMWTOPeriodTaskSchedulers", "()Ljava/util/concurrent/ConcurrentHashMap;", "mWTOPeriodTaskSchedulers", "<init>", "()V", "live-initialize-scheduler_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveWTO implements ILiveInitTaskController {
    public static final LiveWTO INSTANCE = null;
    private static boolean enableJatoOpt;
    private static Executor initExecutor;
    private static int initThreadPoolSize;
    private static int ioThreadPoolSize;
    private static final Lazy mSchedulerNotify$delegate = null;
    private static final Lazy mWTOPeriodTaskSchedulers$delegate = null;
    private static final Lazy mWTOTaskManager$delegate = null;
    private static b taskListenerAdapter;

    private LiveWTO() {
    }

    private final WTOSchedulerNotify getMSchedulerNotify() {
        return (WTOSchedulerNotify) mSchedulerNotify$delegate.getValue();
    }

    private final ConcurrentHashMap<a, WTOTaskScheduler> getMWTOPeriodTaskSchedulers() {
        return (ConcurrentHashMap) mWTOPeriodTaskSchedulers$delegate.getValue();
    }

    private final com.bytedance.android.live.initialize.model.b getMWTOTaskManager() {
        return (com.bytedance.android.live.initialize.model.b) mWTOTaskManager$delegate.getValue();
    }

    static {
        INSTANCE = new LiveWTO();
        initThreadPoolSize = 5;
        ioThreadPoolSize = 5;
        mSchedulerNotify$delegate = LazyKt.lazy(LiveWTO$mSchedulerNotify$2.INSTANCE);
        mWTOTaskManager$delegate = LazyKt.lazy(LiveWTO$mWTOTaskManager$2.INSTANCE);
        mWTOPeriodTaskSchedulers$delegate = LazyKt.lazy(LiveWTO$mWTOPeriodTaskSchedulers$2.INSTANCE);
    }

    public final boolean getEnableJatoOpt() {
        return enableJatoOpt;
    }

    public final Executor getInitExecutor() {
        return initExecutor;
    }

    public final int getInitThreadPoolSize() {
        return initThreadPoolSize;
    }

    public final int getIoThreadPoolSize() {
        return ioThreadPoolSize;
    }

    public static final /* synthetic */ WTOSchedulerNotify access$getMSchedulerNotify$p(LiveWTO r0) {
        return r0.getMSchedulerNotify();
    }

    public static final /* synthetic */ com.bytedance.android.live.initialize.model.b access$getMWTOTaskManager$p(LiveWTO r0) {
        return r0.getMWTOTaskManager();
    }

    public final void cancelRepeatableTask(IWTOTask r4) {
        Intrinsics.checkNotNullParameter(r4, "iWTOTask");
        com.bytedance.android.live.initialize.model.b r0 = getMWTOTaskManager();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "mWTOTask");
        r0.b.remove(r4);
        if (r0.c.get(r4.taskExecutePeriod()) == null) goto L12;
        CopyOnWriteArrayList<IWTOTask> r1 = r0.c.get(r4.taskExecutePeriod());
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.contains(r4) != true) goto L14;
        CopyOnWriteArrayList<IWTOTask> r2 = r0.c.get(r4.taskExecutePeriod());
        if (r2 == null) goto L15;
        r2.remove(r4);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void commitRepeatableTask(IWTOTask r5) {
        Intrinsics.checkNotNullParameter(r5, "iWTOTask");
        com.bytedance.android.live.initialize.model.b r0 = getMWTOTaskManager();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "mWTOTask");
        r0.b.add(r5);
        if (r0.c.get(r5.taskExecutePeriod()) != null) goto L5;
        r0.c.put(r5.taskExecutePeriod(), new CopyOnWriteArrayList());
    L5:
        CopyOnWriteArrayList<IWTOTask> r1 = r0.c.get(r5.taskExecutePeriod());
        if (r1 == null) goto L8;
        r1.add(r5);
    L8:
        triggerWTOPeriodTaskExecute$default(this, r5.taskExecutePeriod(), false, 2, null);
    }

    public final LiveWTO configInitExecutor(Executor r1) {
        initExecutor = r1;
        return this;
    }

    public final LiveWTO configIoThreadPoolSize(int r1) {
        ioThreadPoolSize = r1;
        return this;
    }

    public final void configJatoOpt(boolean r1) {
        enableJatoOpt = r1;
    }

    public final LiveWTO configLogger(IWTOLogger r2) {
        Intrinsics.checkNotNullParameter(r2, "IWTOLogger");
        IWTOLogger r0 = ya0.a.a;
        ya0.a.a = r2;
        return this;
    }

    public final LiveWTO configThreadPoolSize(int r1) {
        initThreadPoolSize = r1;
        return this;
    }

    public final boolean ensureTaskReady(int r7) {
        IWTOTask r8 = getMWTOTaskManager().a.get(Integer.valueOf(r7));
        boolean r0 = false;
        if (r8 != null) goto L5;
        return false;
    L5:
        if (c.a(r8).a == WTOTaskStatus.IDLE) goto L19;
        b r1 = taskListenerAdapter;
        if (r1 == null) goto L11;
        ILiveInitTaskListener r2 = r1.d;
        if (r2 == null) goto L11;
        r2.onWaitTask(r8.taskBusinessInfo());
    L11:
        WTOTaskProxy r9 = c.a(r8);
        ReentrantLock r3 = r9.b;
        r3.lock();
        if (r9.a != WTOTaskStatus.FINISHED) goto L15;
        r0 = true;
    L15:
        r3.unlock();
        return r0;
    L16:
        th = move-exception;
        r3.unlock();
        throw th;
    L19:
        WTOTaskProxy r4 = c.a(r8);
        WTOTaskScheduler r11 = INSTANCE.getMWTOPeriodTaskSchedulers().get(r8.taskExecutePeriod());
        if (r11 == null) goto L23;
        WTOTaskScheduler.g(r11, r4, "ensureReady", null, 4);
    L23:
        if (r4.a != WTOTaskStatus.FINISHED) goto L30;
        return true;
    L30:
        return false;
    }

    public final wa0.a observeScheduleState(wa0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return getMSchedulerNotify().b(r2);
    }

    public final wa0.a observeTaskState(wa0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return getMSchedulerNotify().c(r2);
    }

    public final void setEnableJatoOpt(boolean r1) {
        enableJatoOpt = r1;
    }

    public final void setInitExecutor(Executor r1) {
        initExecutor = r1;
    }

    public void setInitTaskListener(ILiveInitTaskListener r4) {
        if (r4 == null) goto L7;
        b r0 = taskListenerAdapter;
        if (r0 != null) goto L6;
        taskListenerAdapter = new b(getMSchedulerNotify(), r4);
        return;
    L6:
        r0.d = r4;
        return;
    L7:
        b r5 = taskListenerAdapter;
        if (r5 == null) goto L10;
        WTOSchedulerNotify r1 = r5.c;
        b.C0204b r2 = r5.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        r1.a().remove(r2);
        WTOSchedulerNotify r3 = r5.c;
        b.a r6 = r5.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "listener");
        ((CopyOnWriteArrayList) r3.b.getValue()).remove(r6);
    L10:
        b r7 = taskListenerAdapter;
        if (r7 == null) goto L13;
        r7.d = null;
    L13:
        taskListenerAdapter = null;
    }

    public final void setInitThreadPoolSize(int r1) {
        initThreadPoolSize = r1;
    }

    public final void setIoThreadPoolSize(int r1) {
        ioThreadPoolSize = r1;
    }

    public final void triggerWTOPeriodTaskExecute(a r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "period");
        int r1 = 0;
        if (Intrinsics.areEqual(r8, a.i.c) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L28;
        com.bytedance.android.live.initialize.model.b r2 = getMWTOTaskManager();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r8, "executePeriod");
        com.bytedance.android.live.initialize.model.b.a r3 = (com.bytedance.android.live.initialize.model.b.a) ((LinkedHashMap) r2.d).get(r8);
        if (r3 == null) goto L28;
        if (r3.e == false) goto L28;
        LinkedHashSet r4 = new LinkedHashSet();
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        int r7 = r3.d.size();
    L15:
        if (r1 >= r7) goto L22;
        if (r4.contains(Integer.valueOf(r3.d.get(r1).taskID())) == true) goto L21;
        if (r3.a(r3.d.get(r1), r4, r5, r6) == false) goto L21;
        List r11 = r6.subList(r6.indexOf(CollectionsKt.last(r6)), r6.size());
    L23:
        if (r11 == null) goto L28;
        throw new RuntimeException("启动任务存在环：" + r11);
    L21:
        r1 = r1 + 1;
        goto L15
    L22:
        r11 = null;
    L28:
        if (getMWTOPeriodTaskSchedulers().get(r8) != null) goto L30;
        LiveWTO r12 = INSTANCE;
        r12.getMWTOPeriodTaskSchedulers().put(r8, new WTOTaskScheduler(r8, r12.getMWTOTaskManager(), WTOThreadPoolHelper.INSTANCE.getMCpuMixedCommonThreadPool(), r12.getMSchedulerNotify()));
        Unit r13 = Unit.INSTANCE;
    L30:
        WTOTaskScheduler r14 = getMWTOPeriodTaskSchedulers().get(r8);
        if (r14 != null) goto L33;
        return;
    L33:
        if (r14.a != WTOSchedulerStatus.IDLE) goto L75;
        Looper r15 = Looper.myLooper();
        if (r15 == null) goto L39;
        r14.j = new com.bytedance.android.live.initialize.scheduler.a(r14, r15);
    L39:
        r14.i.lock();
        r14.f = System.currentTimeMillis();
        r14.a = WTOSchedulerStatus.RUNNING;
        r14.o.d(10004, r14.l);
        IWTOLogger r16 = ya0.a.a;
        a r17 = r14.l;
        LinkedHashMap r18 = new LinkedHashMap();
        r18.put("startTime", Long.valueOf(r14.f));
        r18.put("scheduleThreadId", Long.valueOf(ThreadMethodProxy.currentThread().getId()));
        r18.put("allTaskSize", Integer.valueOf(r14.d));
        r18.put("blockTaskSize", Integer.valueOf(r14.b));
        Unit r19 = Unit.INSTANCE;
        ya0.a.d(r17, "______SCHEDULE STARTED______", r18);
        if (r9 == false) goto L42;
        r14.i();
        return;
    L42:
        monitor-enter(r14);
    L62:
        th = move-exception;
        throw th;
    L44:
        if (r14.b <= 0) goto L57;
        Object r21 = r14.h;     // Catch: Throwable -> L62
        monitor-enter(r21);     // Catch: Throwable -> L62
    L67:
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    L48:
        if (r14.c.get() == r14.b) goto L50;
        r14.h();     // Catch: Throwable -> L53
        r14.h.wait();     // Catch: Throwable -> L53
        goto L67
    L50:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(r21);     // Catch: Throwable -> L62
        r14.e();     // Catch: Throwable -> L62
        goto L57
    L57:
        if (r14.e.get() == r14.d) goto L59;
        r14.g = r14.o.c(r14);     // Catch: Throwable -> L62
        r14.h();     // Catch: Throwable -> L62
    L60:
        monitor-exit(r14);
        return;
    L59:
        r14.f();     // Catch: Throwable -> L62
        goto L60
    L75:
        return;
    L5:
        if (Intrinsics.areEqual(r8, a.c.c) == true) goto L8;
        r0 = false;
        goto L9
    }

    public static /* synthetic */ void triggerWTOPeriodTaskExecute$default(LiveWTO r0, a r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.triggerWTOPeriodTaskExecute(r1, r2);
    }
}
