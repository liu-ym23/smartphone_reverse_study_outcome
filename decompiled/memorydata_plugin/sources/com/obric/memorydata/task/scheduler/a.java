package com.obric.memorydata.task.scheduler;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.TaskParameter;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.task.scheduler.impl.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\nH&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"H\u0002J\u001e\u0010#\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"H\u0002J\u0016\u0010$\u001a\u0004\u0018\u00010\u00152\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\u0002J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0015J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0015J$\u0010)\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00102\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00190+J\u000e\u0010-\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0010J\u000e\u0010.\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0010J\u000e\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0010J\u000e\u00101\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0010J\u0018\u00102\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u0019H\u0002J\u0016\u00104\u001a\u00020\u00132\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00100\u001eH\u0003J\b\u00106\u001a\u00020\u0013H\u0007J\b\u00107\u001a\u00020\u0013H\u0007J\u0010\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020:H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/memorydata/task/scheduler/AbsTaskExecutor;", "Lcom/obric/memorydata/task/scheduler/TaskExecutor;", "<init>", "()V", "lock", "", "serialExecutor", "Lcom/obric/memorydata/task/scheduler/impl/TaskSerialExecutor;", "longTimeCostSerialExecutor", "schedulerExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "mainHandler", "Landroid/os/Handler;", "createDefaultExecutor", "Ljava/util/concurrent/Executor;", "threadNamePrefix", "", "createSchedulerExecutor", "execute", "", "runnable", "Ljava/lang/Runnable;", "postToMainThread", "executeOnBackgroundThread", "executeImmediately", "", "schedule", "taskTimeUnit", "Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "getTasks", "", "Lcom/obric/memorydata/task/scheduler/impl/EnqueueRunnable;", "taskName", "queue", "Ljava/util/concurrent/BlockingQueue;", "hasTask", "getTaskFromRunnableAdapter", "future", "Ljava/util/concurrent/FutureTask;", "command", "removeTaskIfMatchName", "removeTask", "retainPredicate", "Lkotlin/Function1;", "Lcom/obric/memorydata/task/AbsTaskRequest;", "removeScheduledTask", "cancelActiveTask", "cancelTaskId", "taskId", "removeTaskId", "removeTaskIdOutsideSerialQueues", "markCancelled", "cancelAlarmTask", "uuids", "removeAllTask", "printAll", "createMainHandler", "looper", "Landroid/os/Looper;", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0707a f12953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f12954b;
    private final d c;
    private final d d;
    private final ScheduledThreadPoolExecutor e;

    /* JADX INFO: renamed from: com.obric.memorydata.task.scheduler.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/task/scheduler/AbsTaskExecutor$Companion;", "", "<init>", "()V", "TAG", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0707a {
        private C0707a() {
        }

        public /* synthetic */ C0707a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12953a = new C0707a(null);
    }

    public a() {
        this.f12954b = new Object();
        this.c = new d(a("task-thread-"), true);
        this.d = new d(a("long-time-task-thread-"), false);
        this.e = a();
    }

    private final Runnable a(FutureTask<?> r4) {
        Field r0 = ZeusTransformUtils.forName("java.util.concurrent.FutureTask", "com.obric.memorydata.plugin").getDeclaredField("callable");     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        Object r5 = r0.get(r4);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.util.concurrent.Callable<*>");     // Catch: Exception -> L5
        Callable r6 = (Callable) ZeusTransformUtils.preCheckCast(r5, Callable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        Field r1 = ZeusTransformUtils.forName("java.util.concurrent.Executors$RunnableAdapter", "com.obric.memorydata.plugin").getDeclaredField("task");     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        Object r7 = r1.get(r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.lang.Runnable");     // Catch: Exception -> L5
        return (Runnable) ZeusTransformUtils.preCheckCast(r7, Runnable.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<com.obric.memorydata.task.scheduler.impl.a> a(String r5, BlockingQueue<Runnable> r6) {
        BlockingQueue r7 = (BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r6, BlockingQueue.class, "com.obric.memorydata.plugin");
        List<com.obric.memorydata.task.scheduler.impl.a> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        Runnable r2 = (Runnable) ZeusTransformUtils.preCheckCast(r8.next(), Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.util.concurrent.FutureTask<*>");
        Runnable r3 = a((FutureTask) ZeusTransformUtils.preCheckCast(r2, FutureTask.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L4;
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b(), r5) == false) goto L4;
        r0.add(r3);
        goto L4
    L10:
        return r0;
    }

    public static /* synthetic */ void a(a r2, String r3, Function1 r4, int r5, Object r6) {
        Function1<? super AbsTaskRequest, Boolean> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r7 = $$Lambda$a$6FeO4YtlpUW4NUoL75lCmPcvGgE.INSTANCE;
    L7:
        r2.a(r3, r7);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeTask");
    }

    private final void a(List<String> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Object r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager r9 = (AlarmManager) ZeusTransformUtils.preCheckCast(r8, AlarmManager.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L20;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.a().get(r1), Pair.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L19;
        PendingIntent r3 = (PendingIntent) ZeusTransformUtils.preCheckCast(r2.getSecond(), PendingIntent.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L21;
    L13:
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.b().get(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r2.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getName()), Integer.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L19;
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r5 > 1) goto L18;
        com.obric.memorydata.task.scheduler.impl.c.f12961a.b().remove(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r2.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getName());
        goto L19
    L18:
        ((Map) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.b(), Map.class, "com.obric.memorydata.plugin")).put(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r2.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getName(), Integer.valueOf(r5 - 1));
        goto L19
    L21:
        r9.cancel(r3);     // Catch: RuntimeException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L19:
        com.obric.memorydata.task.scheduler.impl.c.f12961a.a().remove(r1);
        com.obric.memorydata.task.utils.b.f12969a.a(r1);
        goto L4
    }

    private static final boolean a(AbsTaskRequest r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return false;
    }

    private static final boolean a(a r2, Runnable r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.util.concurrent.FutureTask<*>");
        Runnable r7 = r2.a((FutureTask) ZeusTransformUtils.preCheckCast(r6, FutureTask.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.task.scheduler.impl.a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b(), ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b()) == false) goto L7;
        return true;
    }

    private static final boolean a(a r2, String r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.util.concurrent.FutureTask<*>");
        Runnable r6 = r2.a((FutureTask) ZeusTransformUtils.preCheckCast(r5, FutureTask.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.task.scheduler.impl.a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b(), r3) == false) goto L7;
        ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().setCancelled();
        return true;
    }

    private static final boolean a(a r2, String r3, Function1 r4, Runnable r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.util.concurrent.FutureTask<*>");
        Runnable r8 = r2.a((FutureTask) ZeusTransformUtils.preCheckCast(r7, FutureTask.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.task.scheduler.impl.a.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b(), r3) == false) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L9;
        ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().setCancelled();
        return true;
    }

    private static final boolean a(a r2, String r3, boolean r4, Runnable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.util.concurrent.FutureTask<*>");
        Runnable r7 = r2.a((FutureTask) ZeusTransformUtils.preCheckCast(r6, FutureTask.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.task.scheduler.impl.a.class) == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).c(), r3) == false) goto L11;
        if (r4 == true) goto L8;
    L10:
        return true;
    L8:
        if (((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().getTaskInfo().c().isFinished() == true) goto L10;
        ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().setCancelled();
        goto L10
    }

    private final boolean a(Runnable r7, BlockingQueue<Runnable> r8) {
        Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast((BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r8, BlockingQueue.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        boolean r2 = false;
    L5:
        if (r10.hasNext() == false) goto L18;
        Runnable r3 = (Runnable) ZeusTransformUtils.preCheckCast(r10.next(), Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.util.concurrent.FutureTask<*>");
        Runnable r4 = a((FutureTask) ZeusTransformUtils.preCheckCast(r3, FutureTask.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L12;
        if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L12;
        RunLog.INSTANCE.debug("AbsTaskExecutor", "hasTask it name: " + ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b() + " runnable name:" + ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b());
    L12:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L3;
        if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L3;
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b(), ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b()) == false) goto L3;
        r2 = true;
        goto L5
    L18:
        return r2;
    }

    private final boolean a(final String r9, final boolean r10) {
        BlockingQueue<Runnable> r0 = this.e.getQueue();
        final Function1 r1 = new $$Lambda$a$tBAM5qe_C0j9h9uxndfRWTWmDqs(this, r9, r10);
        boolean r2 = r0.removeIf(new $$Lambda$a$TWQu1SeuGyEcCm7gUdsnvOJzok(r1));
        Set<String> r3 = com.obric.memorydata.task.scheduler.impl.c.f12961a.a().keySet();
        Intrinsics.checkNotNullExpressionValue(r3, "<get-keys>(...)");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L3:
        boolean r7 = false;
        if (r6.hasNext() == false) goto L11;
        Object r8 = r6.next();
        Pair r11 = (Pair) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.a().get((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin")), Pair.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L9;
        r7 = Intrinsics.areEqual(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r11.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getUuid().toString(), r9);
    L9:
        if (r7 == false) goto L3;
        r5.add(r8);
        goto L3
    L11:
        List<String> r12 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r13.hasNext() == false) goto L22;
        Pair r14 = (Pair) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.a().get((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin")), Pair.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L13;
        AbsTaskRequest r15 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r14.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L13;
        if (r10 == false) goto L13;
        if (r15.getTaskInfo().c().isFinished() == true) goto L13;
        r15.setCancelled();
        goto L13
    L22:
        a(r12);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L26;
        if (r2 == true) goto L26;
        return false;
    L26:
        return true;
    }

    private static final boolean a(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean b(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean c(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean d(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static /* synthetic */ boolean lambda$1x7IWEDumiZMDi2Jnv8AsfjSeVA(a r0, String r1, Function1 r2, Runnable r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$2QtW72rePCQWGjjb_tzDLTXVy-I, reason: not valid java name */
    public static /* synthetic */ boolean m1196lambda$2QtW72rePCQWGjjb_tzDLTXVyI(a r0, String r1, Runnable r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$34CHM2GuvIyg_kwko1GsBB1_QUU(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$6FeO4YtlpUW4NUoL75lCmPcvGgE(AbsTaskRequest r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$PAsMZojo1VzON48KKKBhbiaURVI(Function1 r0, Object r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$TWQu1SeuGyEc-Cm7gUdsnvOJzok, reason: not valid java name */
    public static /* synthetic */ boolean m1197lambda$TWQu1SeuGyEcCm7gUdsnvOJzok(Function1 r0, Object r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ boolean lambda$YJ9qn7jssFnP8rbaFtrRuIGlR0o(a r0, Runnable r1, Runnable r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$jgxnR8OWUBkL9nzZxq75zHe6piU(Function1 r0, Object r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ boolean lambda$tBAM5qe_C0j9h9uxndfRWTWmDqs(a r0, String r1, boolean r2, Runnable r3) {
        return a(r0, r1, r2, r3);
    }

    public abstract Executor a(String r1);

    public abstract ScheduledThreadPoolExecutor a();

    public void a(Runnable r2) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "runnable");
        r1.run();
    }

    public void a(Runnable r6, g r7) {
        final Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "runnable");
        Intrinsics.checkNotNullParameter(r7, "taskTimeUnit");
        if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L26;
        ExistingTaskPolicy r0 = ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().getTaskParameter().getExistingTaskPolicy();
        if (r0 == null) goto L26;
        if (r0 != ExistingTaskPolicy.KEEP_IN_QUEUE) goto L13;
        RunLog.INSTANCE.debug("AbsTaskExecutor", "ExistingTaskPolicy.KEEP ");
        BlockingQueue<Runnable> r1 = this.e.getQueue();
        Intrinsics.checkNotNullExpressionValue(r1, "getQueue(...)");
        if (a(r8, r1) == false) goto L26;
        RunLog.INSTANCE.debug("AbsTaskExecutor", "ExistingTaskPolicy.KEEP containsTask return");
        return;
    L13:
        if (r0 != ExistingTaskPolicy.REPLACE_IN_QUEUE) goto L15;
    L16:
        String r2 = ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b();
        BlockingQueue<Runnable> r3 = this.e.getQueue();
        Intrinsics.checkNotNullExpressionValue(r3, "getQueue(...)");
        List<com.obric.memorydata.task.scheduler.impl.a> r4 = a(r2, r3);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L26;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r5.hasNext() == false) goto L22;
        ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().cancel();
        goto L20
    L22:
        BlockingQueue<Runnable> r9 = this.e.getQueue();
        final Function1 r10 = new $$Lambda$a$YJ9qn7jssFnP8rbaFtrRuIGlR0o(this, r8);
        if (r9.removeIf(new $$Lambda$a$34CHM2GuvIyg_kwko1GsBB1_QUU(r10)) == false) goto L26;
        RunLog.INSTANCE.debug("AbsTaskExecutor", "ExistingTaskPolicy.REPLACE remove pre task");
        goto L26
    L15:
        if (r0 == ExistingTaskPolicy.CANCEL_EXISTING) goto L16;
    L26:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L28;
        RunLog.INSTANCE.debug("AbsTaskExecutor", "schedule task " + ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a());
    L28:
        this.e.schedule(r8, r7.a(), r7.b());
    }

    public void a(Runnable r3, boolean r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "runnable");
        if (r4 == false) goto L5;
        d r2 = this.c;
    L6:
        r2.execute(r5);
        return;
    L5:
        r2 = this.d;
        goto L6
    }

    public final synchronized void a(final String r9, Function1<? super AbsTaskRequest, Boolean> r10) {
        monitor-enter(this);
        final Function1<? super AbsTaskRequest, Boolean> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r9, "taskName");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r11, "retainPredicate");     // Catch: Throwable -> L19
        this.c.a(r9, r11);     // Catch: Throwable -> L19
        this.d.a(r9, r11);     // Catch: Throwable -> L19
        BlockingQueue<Runnable> r0 = this.e.getQueue();     // Catch: Throwable -> L19
        final Function1 r1 = new $$Lambda$a$1x7IWEDumiZMDi2Jnv8AsfjSeVA(this, r9, r11);     // Catch: Throwable -> L19
        r0.removeIf(new $$Lambda$a$PAsMZojo1VzON48KKKBhbiaURVI(r1));     // Catch: Throwable -> L19
        Set<String> r2 = com.obric.memorydata.task.scheduler.impl.c.f12961a.a().keySet();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r2, "<get-keys>(...)");     // Catch: Throwable -> L19
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L19
    L5:
        if (r5.hasNext() == false) goto L16;
        Object r6 = r5.next();     // Catch: Throwable -> L19
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Pair r8 = (Pair) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.a().get(r7), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        boolean r12 = false;
        if (r8 != null) goto L10;
    L14:
        if (r12 == false) goto L5;
        r4.add(r6);     // Catch: Throwable -> L19
        goto L5
    L10:
        if (Intrinsics.areEqual(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r8.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getName(), r9) == false) goto L14;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11.invoke(r8.getFirst()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L14;
        r12 = true;
        goto L14
    L16:
        a((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(final String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "taskName");     // Catch: Throwable -> L20
        BlockingQueue<Runnable> r0 = this.e.getQueue();     // Catch: Throwable -> L20
        final Function1 r1 = new $$Lambda$a$2QtW72rePCQWGjjb_tzDLTXVyI(this, r7);     // Catch: Throwable -> L20
        r0.removeIf(new $$Lambda$a$jgxnR8OWUBkL9nzZxq75zHe6piU(r1));     // Catch: Throwable -> L20
        Set<String> r2 = com.obric.memorydata.task.scheduler.impl.c.f12961a.a().keySet();     // Catch: Throwable -> L20
        Intrinsics.checkNotNullExpressionValue(r2, "<get-keys>(...)");     // Catch: Throwable -> L20
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L20
    L5:
        if (r5.hasNext() == false) goto L17;
        Object r6 = r5.next();     // Catch: Throwable -> L20
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Pair r9 = (Pair) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.a().get(r8), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r9 == null) goto L13;
        AbsTaskRequest r10 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r9.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r10 == null) goto L13;
        TaskParameter r11 = r10.getTaskParameter();     // Catch: Throwable -> L20
        if (r11 == null) goto L13;
        String r12 = r11.getName();     // Catch: Throwable -> L20
    L15:
        if (Intrinsics.areEqual(r12, r7) == false) goto L5;
        r4.add(r6);     // Catch: Throwable -> L20
    L13:
        r12 = null;
        goto L15
    L17:
        a((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final boolean b(Runnable r11) {
        Runnable r12 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r11, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "command");
        if (ZeusTransformUtils.instanceOf(r12, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L14;
        BlockingQueue<Runnable> r0 = this.e.getQueue();
        Intrinsics.checkNotNullExpressionValue(r0, "getQueue(...)");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L5:
        boolean r4 = false;
    L7:
        if (r1.hasNext() == false) goto L16;
        Runnable r5 = (Runnable) ZeusTransformUtils.preCheckCast(r1.next(), Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.util.concurrent.FutureTask<*>");
        Runnable r6 = a((FutureTask) ZeusTransformUtils.preCheckCast(r5, FutureTask.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L12;
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b(), ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r12, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b()) == false) goto L12;
    L13:
        r4 = true;
    L12:
        if (r4 == false) goto L5;
    L16:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L34;
        Set<String> r2 = com.obric.memorydata.task.scheduler.impl.c.f12961a.a().keySet();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-keys>(...)");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        boolean r7 = false;
    L20:
        if (r3.hasNext() == false) goto L29;
        Pair r8 = (Pair) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.scheduler.impl.c.f12961a.a().get((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")), Pair.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L20;
        if (Intrinsics.areEqual(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r8.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getName(), ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r12, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b()) == true) goto L27;
        if (r7 == false) goto L18;
    L27:
        r7 = true;
        goto L20
    L29:
        if (((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r12, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().getTaskParameter().getDelay().a() != 0) goto L36;
        if (((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r12, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().getTaskParameter().getExistingTaskPolicy() == ExistingTaskPolicy.KEEP_IN_QUEUE) goto L36;
        c(r12);
        return false;
    L36:
        if (this.c.a(r12) == false) goto L38;
        return true;
    L38:
        if (this.d.a(r12) == true) goto L57;
        if (r4 == true) goto L58;
        if (r7 == false) goto L43;
        return true;
    L43:
        return false;
    L58:
        return true;
    L57:
        return true;
    L34:
        r7 = false;
        goto L36
    L14:
        r4 = false;
        goto L16
    }

    public final void c(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "command");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L6;
        a(this, ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b(), null, 2, null);
        return;
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskName");
        this.c.c(r2);
        this.d.c(r2);
    }

    public final boolean d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        boolean r0 = this.c.d(r5);
        if (this.d.d(r5) == true) goto L7;
        if (r0 == true) goto L7;
        boolean r1 = false;
    L9:
        if (a(r5, true) == true) goto L12;
        if (r1 == true) goto L12;
        return false;
    L12:
        return true;
    L7:
        r1 = true;
        goto L9
    }

    public final synchronized boolean e(String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "taskId");     // Catch: Throwable -> L16
        boolean r0 = this.c.b(r5);     // Catch: Throwable -> L16
        boolean r2 = true;
        if (this.d.b(r5) == true) goto L8;
        if (r0 == true) goto L8;
        boolean r1 = false;
    L9:
        if (a(r5, false) == true) goto L14;
        if (r1 == true) goto L14;
        r2 = false;
    L14:
        monitor-exit(this);
        return r2;
    L8:
        r1 = true;
    L16:
        th = move-exception;
        throw th;
    }
}
