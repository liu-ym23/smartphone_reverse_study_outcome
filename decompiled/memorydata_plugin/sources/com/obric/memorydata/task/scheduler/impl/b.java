package com.obric.memorydata.task.scheduler.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/MemoryTaskExecutor;", "Lcom/obric/memorydata/task/scheduler/AbsTaskExecutor;", "<init>", "()V", "createDefaultExecutor", "Ljava/util/concurrent/Executor;", "namePrefix", "", "createSchedulerExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "createDefaultThreadFactory", "Ljava/util/concurrent/ThreadFactory;", "HighPriorityThreadFactory", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends com.obric.memorydata.task.scheduler.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12958b = null;
    private static final Lazy<b> c = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/MemoryTaskExecutor$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/obric/memorydata/task/scheduler/impl/MemoryTaskExecutor;", "getINSTANCE", "()Lcom/obric/memorydata/task/scheduler/impl/MemoryTaskExecutor;", "INSTANCE$delegate", "Lkotlin/Lazy;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final b a() {
            return (b) ZeusTransformUtils.preCheckCast(b.b().getValue(), b.class, "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.task.scheduler.impl.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/MemoryTaskExecutor$HighPriorityThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "namePrefix", "", "<init>", "(Ljava/lang/String;)V", "getNamePrefix", "()Ljava/lang/String;", "threadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "group", "Ljava/lang/ThreadGroup;", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class ThreadFactoryC0709b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f12960b;
        private final ThreadGroup c;

        public ThreadFactoryC0709b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "namePrefix");
            this.f12959a = r2;
            this.f12960b = new AtomicInteger(1);
            SecurityManager r3 = System.getSecurityManager();
            if (r3 == null) goto L5;
            ThreadGroup r4 = r3.getThreadGroup();
        L6:
            Intrinsics.checkNotNull(r4);
            this.c = r4;
            return;
        L5:
            r4 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r7) {
            Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "r");
            Thread r8 = new Thread(this.c, r2, this.f12959a + this.f12960b.getAndIncrement(), 0);
            if (r8.isDaemon() == true) goto L6;
            r8.setDaemon(true);
        L6:
            if (r8.getPriority() == 10) goto L8;
            r8.setPriority(10);
        L8:
            return r8;
        }
    }

    static {
        f12958b = new a(null);
        c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$b$Qlcg10Wq3i1NIQJQXVpXbZwtyI4.INSTANCE);
    }

    public b() {
    }

    public static final /* synthetic */ Lazy b() {
        return c;
    }

    private static final b c() {
        return new b();
    }

    private final ThreadFactory f(String r2) {
        return (ThreadFactory) ZeusTransformUtils.preCheckCast(new ThreadFactoryC0709b(r2), ThreadFactory.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ b lambda$Qlcg10Wq3i1NIQJQXVpXbZwtyI4() {
        return c();
    }

    @Override // com.obric.memorydata.task.scheduler.a
    public Executor a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "namePrefix");
        ExecutorService r1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2, f(r2));
        Intrinsics.checkNotNullExpressionValue(r1, "newFixedThreadPool(...)");
        return (Executor) ZeusTransformUtils.preCheckCast(r1, Executor.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.task.scheduler.a
    public ScheduledThreadPoolExecutor a() {
        return new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, f("scheduler-thread-"));
    }
}
