package okhttp3.internal.concurrent;

import ai.j0;
import com.bytedance.keva.KevaImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 #2\u00020\u0001:\u0003\"#$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u001c\u001a\u00020\u0016J\u0015\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001fJ\u0006\u0010 \u001a\u00020\tJ\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner;", "", "backend", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;)V", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "busyQueues", "", "Lokhttp3/internal/concurrent/TaskQueue;", "coordinatorWaiting", "", "coordinatorWakeUpAt", "", "nextQueueName", "", "readyQueues", "runnable", "Ljava/lang/Runnable;", "activeQueues", "", "afterRun", "", "task", "Lokhttp3/internal/concurrent/Task;", "delayNanos", "awaitTaskToRun", "beforeRun", "cancelAll", "kickCoordinator", "taskQueue", "kickCoordinator$okhttp", "newQueue", "runTask", "Backend", "Companion", "RealBackend", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class TaskRunner {
    public static final Companion Companion = null;

    @JvmField
    public static final TaskRunner INSTANCE = null;
    private static final Logger logger = null;
    private final Backend backend;
    private final List<TaskQueue> busyQueues;
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    private int nextQueueName;
    private final List<TaskQueue> readyQueues;
    private final Runnable runnable;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Backend;", "", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Backend {
        void beforeTask(TaskRunner r5);

        void coordinatorNotify(TaskRunner r5);

        void coordinatorWait(TaskRunner r5, long r10);

        void execute(Runnable r5);

        long nanoTime();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Companion;", "", "()V", "INSTANCE", "Lokhttp3/internal/concurrent/TaskRunner;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final Logger getLogger() {
            return TaskRunner.access$getLogger$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(Ljava/util/concurrent/ThreadFactory;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "shutdown", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class RealBackend implements Backend {
        private final ThreadPoolExecutor executor;

        public RealBackend(ThreadFactory r10) {
            Intrinsics.checkNotNullParameter(r10, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), r10);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void beforeTask(TaskRunner r5) {
            Intrinsics.checkNotNullParameter(r5, "taskRunner");
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorNotify(TaskRunner r5) {
            Intrinsics.checkNotNullParameter(r5, "taskRunner");
            r5.notify();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorWait(TaskRunner r10, long r11) throws InterruptedException {
            Intrinsics.checkNotNullParameter(r10, "taskRunner");
            long r5 = r11 / 1000000;
            long r12 = r11 - (1000000 * r5);
            if (r5 <= 0) goto L5;
        L6:
            r10.wait(r5, (int) r12);
            return;
        L5:
            if (r11 > 0) goto L6;
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void execute(Runnable r5) {
            Intrinsics.checkNotNullParameter(r5, "runnable");
            this.executor.execute(r5);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public long nanoTime() {
            return System.nanoTime();
        }

        public final void shutdown() {
            this.executor.shutdown();
        }
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new TaskRunner(new RealBackend(Util.threadFactory(Util.okHttpName + " TaskRunner", true)));
        logger = Logger.getLogger(TaskRunner.class.getName());
    }

    public TaskRunner(Backend r5) {
        Intrinsics.checkNotNullParameter(r5, "backend");
        this.backend = r5;
        this.nextQueueName = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new TaskRunner$runnable$1(this);
    }

    public static final /* synthetic */ Logger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ void access$runTask(TaskRunner r5, Task r10) {
        r5.runTask(r10);
    }

    private final void afterRun(Task r10, long r11) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        TaskQueue r5 = r10.getQueue$okhttp();
        Intrinsics.checkNotNull(r5);
        if (r5.getActiveTask$okhttp() != r10) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L25;
        boolean r13 = r5.getCancelActiveTask$okhttp();
        r5.setCancelActiveTask$okhttp(false);
        r5.setActiveTask$okhttp(null);
        this.busyQueues.remove(r5);
        if (r11 == (-1)) goto L21;
        if (r13 == true) goto L21;
        if (r5.getShutdown$okhttp() == true) goto L21;
        r5.scheduleAndDecide$okhttp(r10, r11, true);
    L21:
        if (r5.getFutureTasks$okhttp().isEmpty() == true) goto L26;
        this.readyQueues.add(r5);
        return;
    L26:
        return;
    L25:
        throw new IllegalStateException("Check failed.");
    L12:
        r12 = false;
        goto L13
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    private final void beforeRun(Task r5) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        r5.setNextExecuteNanoTime$okhttp(-1);
        TaskQueue r10 = r5.getQueue$okhttp();
        Intrinsics.checkNotNull(r10);
        r10.getFutureTasks$okhttp().remove(r5);
        this.readyQueues.remove(r10);
        r10.setActiveTask$okhttp(r5);
        this.busyQueues.add(r10);
        return;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    private final void runTask(Task r10) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        Thread r5 = Thread.currentThread();
        String r11 = r5.getName();
        r5.setName(r10.getName());
        long r12 = r10.runOnce();     // Catch: Throwable -> L19
        monitor-enter(this);
        afterRun(r10, r12);     // Catch: Throwable -> L16
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        r5.setName(r11);
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        monitor-enter(this);
        afterRun(r10, -1);     // Catch: Throwable -> L26
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r5.setName(r11);
        throw th;
    L26:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final List<TaskQueue> activeQueues() {
        monitor-enter(this);
        List<TaskQueue> r5 = CollectionsKt.plus(this.busyQueues, this.readyQueues);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final Task awaitTaskToRun() {
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (this.readyQueues.isEmpty() == true) goto L11;
        long r5 = this.backend.nanoTime();
        Iterator<TaskQueue> r10 = this.readyQueues.iterator();
        long r11 = Long.MAX_VALUE;
        Task r12 = null;
    L14:
        if (r10.hasNext() == false) goto L21;
        Task r13 = r10.next().getFutureTasks$okhttp().get(0);
        long r14 = Math.max(0, r13.getNextExecuteNanoTime$okhttp() - r5);
        if (r14 > 0) goto L17;
        if (r12 != null) goto L19;
        r12 = r13;
        goto L14
    L19:
        boolean r15 = true;
    L22:
        if (r12 != null) goto L23;
        if (this.coordinatorWaiting == true) goto L34;
        this.coordinatorWaiting = true;
        this.coordinatorWakeUpAt = r5 + r11;
        this.backend.coordinatorWait(this, r11);     // Catch: Throwable -> L40 InterruptedException -> L42
    L39:
        this.coordinatorWaiting = false;
    L40:
        th = move-exception;
        this.coordinatorWaiting = false;
        throw th;
    L42:
        cancelAll();     // Catch: Throwable -> L40
        goto L39
    L34:
        if (r11 >= (this.coordinatorWakeUpAt - r5)) goto L36;
        this.backend.coordinatorNotify(this);
    L36:
        return null;
    L23:
        beforeRun(r12);
        if (r15 == false) goto L26;
    L29:
        this.backend.execute(this.runnable);
    L30:
        return r12;
    L26:
        if (this.coordinatorWaiting == true) goto L30;
        if (this.readyQueues.isEmpty() == true) goto L30;
    L17:
        r11 = Math.min(r14, r11);
        goto L14
    L21:
        r15 = false;
        goto L22
    L11:
        return null;
    }

    public final void cancelAll() {
        int r5 = this.busyQueues.size() - 1;
    L3:
        if (r5 < 0) goto L5;
        this.busyQueues.get(r5).cancelAllAndDecide$okhttp();
        r5 = r5 - 1;
        goto L3
    L5:
        int r10 = this.readyQueues.size() - 1;
    L6:
        if (r10 < 0) goto L11;
        TaskQueue r11 = this.readyQueues.get(r10);
        r11.cancelAllAndDecide$okhttp();
        if (r11.getFutureTasks$okhttp().isEmpty() == false) goto L10;
        this.readyQueues.remove(r10);
    L10:
        r10 = r10 - 1;
        goto L6
    }

    public final Backend getBackend() {
        return this.backend;
    }

    public final void kickCoordinator$okhttp(TaskQueue r5) {
        Intrinsics.checkNotNullParameter(r5, "taskQueue");
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (r5.getActiveTask$okhttp() != null) goto L16;
        if (r5.getFutureTasks$okhttp().isEmpty() == true) goto L14;
        Util.addIfAbsent(this.readyQueues, r5);
        goto L16
    L14:
        this.readyQueues.remove(r5);
    L16:
        if (this.coordinatorWaiting == false) goto L18;
        this.backend.coordinatorNotify(this);
        return;
    L18:
        this.backend.execute(this.runnable);
    }

    public final TaskQueue newQueue() {
        monitor-enter(this);
        int r5 = this.nextQueueName;     // Catch: Throwable -> L7
        this.nextQueueName = r5 + 1;     // Catch: Throwable -> L7
        monitor-exit(this);
        return new TaskQueue(this, j0.g(r5, "Q"));
    L7:
        th = move-exception;
        throw th;
    }
}
