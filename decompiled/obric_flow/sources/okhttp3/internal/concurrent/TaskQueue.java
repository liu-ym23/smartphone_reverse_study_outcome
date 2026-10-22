package okhttp3.internal.concurrent;

import ai.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00013B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\r\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0002\b$J8\u0010%\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u000e2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0*H\u0086\bø\u0001\u0000J\u0006\u0010+\u001a\u00020,J.\u0010-\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020'0*H\u0086\bø\u0001\u0000J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020'J%\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u00100\u001a\u00020\u000eH\u0000¢\u0006\u0002\b1J\u0006\u0010\u001c\u001a\u00020\"J\b\u00102\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "name", "", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "activeTask", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "cancelActiveTask", "", "getCancelActiveTask$okhttp", "()Z", "setCancelActiveTask$okhttp", "(Z)V", "futureTasks", "", "getFutureTasks$okhttp", "()Ljava/util/List;", "getName$okhttp", "()Ljava/lang/String;", "scheduledTasks", "", "getScheduledTasks", "shutdown", "getShutdown$okhttp", "setShutdown$okhttp", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "cancelAll", "", "cancelAllAndDecide", "cancelAllAndDecide$okhttp", "execute", "delayNanos", "", "cancelable", "block", "Lkotlin/Function0;", "idleLatch", "Ljava/util/concurrent/CountDownLatch;", "schedule", "task", "scheduleAndDecide", "recurrence", "scheduleAndDecide$okhttp", "toString", "AwaitIdleTask", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue$AwaitIdleTask;", "Lokhttp3/internal/concurrent/Task;", "()V", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(j0.q(new StringBuilder(), Util.okHttpName, " awaitIdle"), false);
            this.latch = new CountDownLatch(1);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.concurrent.TaskQueue$execute$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 extends Task {
        final /* synthetic */ Function0 $block;
        final /* synthetic */ boolean $cancelable;
        final /* synthetic */ String $name;

        public AnonymousClass1(Function0 r5, String r10, boolean r11, String r12, boolean r13) {
            this.$block = r5;
            this.$name = r10;
            this.$cancelable = r11;
            super(r12, r13);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.$block.invoke();
            return -1;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.concurrent.TaskQueue$schedule$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$schedule$2", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass2 extends Task {
        final /* synthetic */ Function0 $block;
        final /* synthetic */ String $name;

        public AnonymousClass2(Function0 r5, String r10, String r11) {
            this.$block = r5;
            this.$name = r10;
            super(r11, false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            return ((Number) this.$block.invoke()).longValue();
        }
    }

    public TaskQueue(TaskRunner r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "taskRunner");
        Intrinsics.checkNotNullParameter(r10, "name");
        this.taskRunner = r5;
        this.name = r10;
        this.futureTasks = new ArrayList();
    }

    public static /* synthetic */ void execute$default(TaskQueue r10, String r11, long r12, boolean r13, Function0 r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L8;
        r13 = true;
    L8:
        boolean r5 = r13;
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r14, "block");
        r10.schedule(new AnonymousClass1(r14, r11, r5, r11, r5), r12);
    }

    public static /* synthetic */ void schedule$default(TaskQueue r5, Task r10, long r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = 0;
    L5:
        r5.schedule(r10, r11);
    }

    public final void cancelAll() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        TaskRunner r5 = this.taskRunner;
        monitor-enter(r5);
    L14:
        th = move-exception;
        throw th;
    L12:
        if (cancelAllAndDecide$okhttp() == false) goto L16;
        this.taskRunner.kickCoordinator$okhttp(this);     // Catch: Throwable -> L14
    L16:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r5);
        return;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task r5 = this.activeTask;
        if (r5 == null) goto L7;
        Intrinsics.checkNotNull(r5);
        if (r5.getCancelable() == false) goto L7;
        this.cancelActiveTask = true;
    L7:
        int r10 = this.futureTasks.size() - 1;
        boolean r11 = false;
    L8:
        if (r10 < 0) goto L16;
        if (this.futureTasks.get(r10).getCancelable() == false) goto L15;
        Task r12 = this.futureTasks.get(r10);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L14;
        TaskLoggerKt.access$log(r12, this, "canceled");
    L14:
        this.futureTasks.remove(r10);
        r11 = true;
    L15:
        r10 = r10 - 1;
        goto L8
    L16:
        return r11;
    }

    public final void execute(String r10, long r11, boolean r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r13, "block");
        schedule(new AnonymousClass1(r13, r10, r12, r10, r12), r11);
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final List<Task> getScheduledTasks() {
        TaskRunner r5 = this.taskRunner;
        monitor-enter(r5);
        List<Task> r10 = CollectionsKt.toList(this.futureTasks);     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        TaskRunner r5 = this.taskRunner;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.activeTask == null) goto L7;
    L13:
        Task r10 = this.activeTask;     // Catch: Throwable -> L11
        if ((r10 instanceof AwaitIdleTask) == false) goto L18;
        CountDownLatch r11 = ((AwaitIdleTask) r10).getLatch();     // Catch: Throwable -> L11
        monitor-exit(r5);
        return r11;
    L18:
        Iterator<Task> r12 = this.futureTasks.iterator();     // Catch: Throwable -> L11
    L20:
        if (r12.hasNext() == false) goto L26;
        Task r13 = r12.next();     // Catch: Throwable -> L11
        if ((r13 instanceof AwaitIdleTask) == false) goto L20;
        CountDownLatch r14 = ((AwaitIdleTask) r13).getLatch();     // Catch: Throwable -> L11
        monitor-exit(r5);
        return r14;
    L26:
        AwaitIdleTask r15 = new AwaitIdleTask();     // Catch: Throwable -> L11
        if (scheduleAndDecide$okhttp(r15, 0, false) == false) goto L29;
        this.taskRunner.kickCoordinator$okhttp(this);     // Catch: Throwable -> L11
    L29:
        CountDownLatch r16 = r15.getLatch();     // Catch: Throwable -> L11
        monitor-exit(r5);
        return r16;
    L7:
        if (this.futureTasks.isEmpty() == false) goto L13;
        CountDownLatch r17 = new CountDownLatch(0);     // Catch: Throwable -> L11
        monitor-exit(r5);
        return r17;
    }

    public final void schedule(Task r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "task");
        TaskRunner r11 = this.taskRunner;
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.shutdown == false) goto L22;
        if (r5.getCancelable() == false) goto L17;
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L14;
        TaskLoggerKt.access$log(r5, this, "schedule canceled (queue is shutdown)");     // Catch: Throwable -> L12
    L14:
        monitor-exit(r11);
        return;
    L17:
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L20;
        TaskLoggerKt.access$log(r5, this, "schedule failed (queue is shutdown)");     // Catch: Throwable -> L12
    L20:
        throw new RejectedExecutionException();     // Catch: Throwable -> L12
    L22:
        if (scheduleAndDecide$okhttp(r5, r10, false) == false) goto L24;
        this.taskRunner.kickCoordinator$okhttp(this);     // Catch: Throwable -> L12
    L24:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r11);
    }

    public final boolean scheduleAndDecide$okhttp(Task r10, long r11, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "task");
        r10.initQueue$okhttp(this);
        long r5 = this.taskRunner.getBackend().nanoTime();
        long r12 = r5 + r11;
        int r14 = this.futureTasks.indexOf(r10);
        if (r14 != (-1)) goto L5;
    L11:
        r10.setNextExecuteNanoTime$okhttp(r12);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L17;
        if (r13 == false) goto L15;
        String r15 = "run again after " + TaskLoggerKt.formatDuration(r12 - r5);
    L16:
        TaskLoggerKt.access$log(r10, this, r15);
        goto L17
    L15:
        r15 = "scheduled after " + TaskLoggerKt.formatDuration(r12 - r5);
    L17:
        Iterator<Task> r16 = this.futureTasks.iterator();
        int r17 = 0;
    L19:
        if (r16.hasNext() == false) goto L24;
        if ((r16.next().getNextExecuteNanoTime$okhttp() - r5) > r11) goto L25;
        r17 = r17 + 1;
    L25:
        if (r17 != (-1)) goto L27;
        r17 = this.futureTasks.size();
    L27:
        this.futureTasks.add(r17, r10);
        if (r17 != 0) goto L33;
        return true;
    L33:
        return false;
    L24:
        r17 = -1;
        goto L25
    L5:
        if (r10.getNextExecuteNanoTime$okhttp() <= r12) goto L7;
        this.futureTasks.remove(r14);
        goto L11
    L7:
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L9;
        TaskLoggerKt.access$log(r10, this, "already scheduled");
    L9:
        return false;
    }

    public final void setActiveTask$okhttp(Task r5) {
        this.activeTask = r5;
    }

    public final void setCancelActiveTask$okhttp(boolean r5) {
        this.cancelActiveTask = r5;
    }

    public final void setShutdown$okhttp(boolean r5) {
        this.shutdown = r5;
    }

    public final void shutdown() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        TaskRunner r5 = this.taskRunner;
        monitor-enter(r5);
        this.shutdown = true;     // Catch: Throwable -> L15
        if (cancelAllAndDecide$okhttp() == false) goto L17;
        this.taskRunner.kickCoordinator$okhttp(this);     // Catch: Throwable -> L15
    L17:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r5);
        return;
    L15:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue r5, String r10, long r11, Function0 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r11 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r12, "block");
        r5.schedule(new AnonymousClass2(r12, r10, r10), r11);
    }

    public final void schedule(String r5, long r10, Function0<Long> r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r11, "block");
        schedule(new AnonymousClass2(r11, r5, r5), r10);
    }
}
