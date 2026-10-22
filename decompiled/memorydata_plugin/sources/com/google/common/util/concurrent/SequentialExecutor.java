package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class SequentialExecutor implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f4822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f4823b;
    private final Deque<Runnable> c;
    private WorkerRunningState d;
    private long e;
    private final a f;

    static final enum WorkerRunningState extends Enum<WorkerRunningState> {
        private static final /* synthetic */ WorkerRunningState[] $VALUES = null;
        public static final WorkerRunningState IDLE = null;
        public static final WorkerRunningState QUEUED = null;
        public static final WorkerRunningState QUEUING = null;
        public static final WorkerRunningState RUNNING = null;

        private static /* synthetic */ WorkerRunningState[] $values() {
            return new WorkerRunningState[]{IDLE, QUEUING, QUEUED, RUNNING};
        }

        static {
            IDLE = new WorkerRunningState("IDLE", 0);
            QUEUING = new WorkerRunningState("QUEUING", 1);
            QUEUED = new WorkerRunningState("QUEUED", 2);
            RUNNING = new WorkerRunningState("RUNNING", 3);
            $VALUES = $values();
        }

        private WorkerRunningState(String r1, int r2) {
            super(r1, r2);
        }

        public static WorkerRunningState valueOf(String r2) {
            return (WorkerRunningState) ZeusTransformUtils.preCheckCast(Enum.valueOf(WorkerRunningState.class, r2), WorkerRunningState.class, "com.obric.memorydata.plugin");
        }

        public static WorkerRunningState[] values() {
            return (WorkerRunningState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WorkerRunningState[].class, "com.obric.memorydata.plugin");
        }
    }

    private final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Runnable f4825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SequentialExecutor f4826b;

        private void a() {
            boolean r0 = false;
            boolean r1 = false;
        L43:
            Deque r2 = SequentialExecutor.a(this.f4826b);     // Catch: Throwable -> L36
            monitor-enter(r2);     // Catch: Throwable -> L36
            if (r0 == false) goto L42;
        L13:
            Runnable r3 = (Runnable) ZeusTransformUtils.preCheckCast(SequentialExecutor.a(this.f4826b).poll(), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
            this.f4825a = r3;     // Catch: Throwable -> L33
            if (r3 == null) goto L15;
            monitor-exit(r2);     // Catch: Throwable -> L33
            r1 = r1 | Thread.interrupted();
            this.f4825a.run();     // Catch: Throwable -> L26 RuntimeException -> L28
        L24:
            this.f4825a = null;     // Catch: Throwable -> L36
        L28:
            e = move-exception;
            SequentialExecutor.a().log(Level.SEVERE, "Exception while executing runnable " + this.f4825a, e);     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            this.f4825a = null;     // Catch: Throwable -> L36
            throw th;     // Catch: Throwable -> L36
        L15:
            SequentialExecutor.a(this.f4826b, WorkerRunningState.IDLE);     // Catch: Throwable -> L33
            monitor-exit(r2);     // Catch: Throwable -> L33
            if (r1 == false) goto L49;
            Thread.currentThread().interrupt();
            return;
        L49:
            return;
        L42:
        L33:
            th = move-exception;
            throw th;     // Catch: Throwable -> L36
        L7:
            if (SequentialExecutor.b(this.f4826b) == WorkerRunningState.RUNNING) goto L8;
            SequentialExecutor.c(this.f4826b);     // Catch: Throwable -> L33
            SequentialExecutor.a(this.f4826b, WorkerRunningState.RUNNING);     // Catch: Throwable -> L33
            r0 = true;
            goto L13
        L8:
            monitor-exit(r2);     // Catch: Throwable -> L33
            if (r1 == false) goto L48;
            Thread.currentThread().interrupt();
            return;
        L48:
            return;
        L36:
            th = move-exception;
            if (r1 == false) goto L39;
            Thread.currentThread().interrupt();
        L39:
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();     // Catch: Error -> L4
            return;
        L4:
            e = move-exception;
            monitor-enter(SequentialExecutor.a(this.f4826b));
            SequentialExecutor.a(this.f4826b, WorkerRunningState.IDLE);     // Catch: Throwable -> L10
            throw e;
        L10:
            th = move-exception;
            throw th;
        }

        public String toString() {
            Runnable r0 = this.f4825a;
            if (r0 == null) goto L7;
            StringBuilder r3 = new StringBuilder().append("SequentialExecutorWorker{running=").append(r0);
        L6:
            return r3.append("}").toString();
        L7:
            r3 = new StringBuilder().append("SequentialExecutorWorker{state=").append(SequentialExecutor.b(this.f4826b));
            goto L6
        }
    }

    static {
        f4822a = Logger.getLogger(SequentialExecutor.class.getName());
    }

    static /* synthetic */ WorkerRunningState a(SequentialExecutor r0, WorkerRunningState r1) {
        r0.d = r1;
        return r1;
    }

    static /* synthetic */ Deque a(SequentialExecutor r0) {
        return r0.c;
    }

    static /* synthetic */ Logger a() {
        return f4822a;
    }

    static /* synthetic */ WorkerRunningState b(SequentialExecutor r0) {
        return r0.d;
    }

    static /* synthetic */ long c(SequentialExecutor r4) {
        long r0 = r4.e;
        r4.e = 1 + r0;
        return r0;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r8) {
        final Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r9);
        Deque<Runnable> r0 = this.c;
        monitor-enter(r0);
    L54:
        th = move-exception;
        throw th;
    L5:
        if (this.d != WorkerRunningState.RUNNING) goto L7;
    L51:
        this.c.add(r9);     // Catch: Throwable -> L54
        monitor-exit(r0);     // Catch: Throwable -> L54
        return;
    L7:
        if (this.d == WorkerRunningState.QUEUED) goto L51;
        long r1 = this.e;     // Catch: Throwable -> L54
        Runnable r3 = new AnonymousClass1(this, r9);     // Catch: Throwable -> L54
        this.c.add(r3);     // Catch: Throwable -> L54
        this.d = WorkerRunningState.QUEUING;     // Catch: Throwable -> L54
        monitor-exit(r0);     // Catch: Throwable -> L54
        boolean r10 = true;
        this.f4823b.execute(this.f);     // Catch: Throwable -> L31
        if (this.d != WorkerRunningState.QUEUING) goto L17;
        r10 = false;
    L17:
        if (r10 == false) goto L19;
        return;
    L19:
        Deque<Runnable> r4 = this.c;
        monitor-enter(r4);
    L28:
        th = move-exception;
        throw th;
    L22:
        if (this.e == r1) goto L24;
    L26:
        monitor-exit(r4);     // Catch: Throwable -> L28
        return;
    L24:
        if (this.d != WorkerRunningState.QUEUING) goto L26;
        this.d = WorkerRunningState.QUEUED;     // Catch: Throwable -> L28
    L31:
        e = move-exception;
        monitor-enter(this.c);
    L48:
        th = move-exception;
        throw th;
    L35:
        if (this.d == WorkerRunningState.IDLE) goto L39;
        if (this.d == WorkerRunningState.QUEUING) goto L39;
    L41:
        r10 = false;
    L43:
        if (ZeusTransformUtils.instanceOf(e, RejectedExecutionException.class) == false) goto L47;
        if (r10 == true) goto L47;
        return;
    L47:
        throw e;     // Catch: Throwable -> L48
    L39:
        if (this.c.removeLastOccurrence(r3) == false) goto L41;
        goto L41
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f4823b + "}";
    }
}
