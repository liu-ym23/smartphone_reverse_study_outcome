package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ExecutionSequencer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<l<Void>> f4814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f4815b;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.util.concurrent.ExecutionSequencer$1, reason: invalid class name */
    class AnonymousClass1<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callable f4816a;

        @Override // com.google.common.util.concurrent.e
        public l<T> call() {
            return h.a(this.f4816a.call());
        }

        public String toString() {
            return this.f4816a.toString();
        }
    }

    static final enum RunningState extends Enum<RunningState> {
        private static final /* synthetic */ RunningState[] $VALUES = null;
        public static final RunningState CANCELLED = null;
        public static final RunningState NOT_RUN = null;
        public static final RunningState STARTED = null;

        private static /* synthetic */ RunningState[] $values() {
            return new RunningState[]{NOT_RUN, CANCELLED, STARTED};
        }

        static {
            NOT_RUN = new RunningState("NOT_RUN", 0);
            CANCELLED = new RunningState("CANCELLED", 1);
            STARTED = new RunningState("STARTED", 2);
            $VALUES = $values();
        }

        private RunningState(String r1, int r2) {
            super(r1, r2);
        }

        public static RunningState valueOf(String r2) {
            return (RunningState) ZeusTransformUtils.preCheckCast(Enum.valueOf(RunningState.class, r2), RunningState.class, "com.obric.memorydata.plugin");
        }

        public static RunningState[] values() {
            return (RunningState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RunningState[].class, "com.obric.memorydata.plugin");
        }
    }

    private static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Runnable, Executor {
        Executor delegate;
        ExecutionSequencer sequencer;
        Thread submitting;
        Runnable task;

        private TaskNonReentrantExecutor(Executor r3, ExecutionSequencer r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            super(RunningState.NOT_RUN);
            this.delegate = r5;
            this.sequencer = r4;
        }

        /* synthetic */ TaskNonReentrantExecutor(Executor r2, ExecutionSequencer r3, AnonymousClass1 r4) {
            this((Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin"), r3);
        }

        static /* synthetic */ boolean access$200(TaskNonReentrantExecutor r0) {
            return r0.trySetStarted();
        }

        static /* synthetic */ boolean access$400(TaskNonReentrantExecutor r0) {
            return r0.trySetCancelled();
        }

        private boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }

        private boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r6) {
            Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
            if (get() != RunningState.CANCELLED) goto L6;
            this.delegate = null;
            this.sequencer = null;
            return;
        L6:
            this.submitting = Thread.currentThread();
            a r0 = ExecutionSequencer.a((ExecutionSequencer) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.sequencer), ExecutionSequencer.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
            if (r0.f4817a != this.submitting) goto L14;
            this.sequencer = null;     // Catch: Throwable -> L17
            if (r0.f4818b != null) goto L12;
            boolean r2 = true;
        L13:
            com.google.common.base.n.b(r2);     // Catch: Throwable -> L17
            r0.f4818b = r7;     // Catch: Throwable -> L17
            r0.c = (Executor) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.delegate), Executor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
            this.delegate = null;     // Catch: Throwable -> L17
        L15:
            this.submitting = null;
            return;
        L12:
            r2 = false;
            goto L13
        L14:
            Executor r1 = (Executor) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.delegate), Executor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
            this.delegate = null;     // Catch: Throwable -> L17
            this.task = r7;     // Catch: Throwable -> L17
            r1.execute(this);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            this.submitting = null;
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread r0 = Thread.currentThread();
            AnonymousClass1 r3 = null;
            if (r0 == this.submitting) goto L6;
            Runnable r1 = (Runnable) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.task), Runnable.class, "com.obric.memorydata.plugin");
            this.task = null;
            r1.run();
            return;
        L6:
            a r2 = new a(r3);
            r2.f4817a = r0;
            ExecutionSequencer.a((ExecutionSequencer) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.sequencer), ExecutionSequencer.class, "com.obric.memorydata.plugin"), r2);
            this.sequencer = null;
            Runnable r4 = (Runnable) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.task), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            this.task = null;     // Catch: Throwable -> L16
            r4.run();     // Catch: Throwable -> L16
        L8:
            Runnable r5 = r2.f4818b;     // Catch: Throwable -> L16
            if (r5 == null) goto L14;
            Executor r6 = r2.c;     // Catch: Throwable -> L16
            if (r6 == null) goto L14;
            r2.f4818b = null;     // Catch: Throwable -> L16
            r2.c = null;     // Catch: Throwable -> L16
            r6.execute(r5);     // Catch: Throwable -> L16
        L14:
            r2.f4817a = null;
            return;
        L16:
            th = move-exception;
            r2.f4817a = null;
            throw th;
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Thread f4817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Runnable f4818b;
        Executor c;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    private ExecutionSequencer() {
        this.f4814a = new AtomicReference(h.a());
        this.f4815b = new a(null);
    }

    static /* synthetic */ a a(ExecutionSequencer r0) {
        return r0.f4815b;
    }

    static /* synthetic */ a a(ExecutionSequencer r0, a r1) {
        r0.f4815b = r1;
        return r1;
    }
}
