package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.u;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ExecutorScheduler extends u {
    static final u e = null;
    final boolean c;
    final Executor d;

    static final class DelayedRunnable extends AtomicReference<Runnable> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct;
        final SequentialDisposable timed;

        DelayedRunnable(Runnable r3) {
            super((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (getAndSet(null) == null) goto L6;
            this.timed.dispose();
            this.direct.dispose();
            return;
        }

        public Runnable getWrappedRunnable() {
            Runnable r2 = (Runnable) ZeusTransformUtils.preCheckCast(get(), Runnable.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L6;
            return r2;
        L6:
            return Functions.f16717b;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(get(), Runnable.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L11;
            return;
        L11:
            r0.run();     // Catch: Throwable -> L7
            lazySet(null);
            this.timed.lazySet(DisposableHelper.DISPOSED);
            this.direct.lazySet(DisposableHelper.DISPOSED);
            return;
        L7:
            th = move-exception;
            lazySet(null);
            this.timed.lazySet(DisposableHelper.DISPOSED);
            this.direct.lazySet(DisposableHelper.DISPOSED);
            throw th;
        }
    }

    public static final class ExecutorWorker extends u.c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f17109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f17110b;
        final MpscLinkedQueue<Runnable> c;
        volatile boolean d;
        final AtomicInteger e;
        final io.reactivex.disposables.a f;

        static final class BooleanRunnable extends AtomicBoolean implements io.reactivex.disposables.b, Runnable {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            BooleanRunnable(Runnable r3) {
                this.actual = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == false) goto L12;
                return;
            L12:
                this.actual.run();     // Catch: Throwable -> L9
                lazySet(true);
                return;
            L9:
                th = move-exception;
                lazySet(true);
                throw th;
            }
        }

        static final class InterruptibleRunnable extends AtomicInteger implements io.reactivex.disposables.b, Runnable {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final io.reactivex.internal.disposables.a tasks;
            volatile Thread thread;

            InterruptibleRunnable(Runnable r3, io.reactivex.internal.disposables.a r4) {
                Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
                io.reactivex.internal.disposables.a r6 = (io.reactivex.internal.disposables.a) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.internal.disposables.a.class, "com.obric.memorydata.plugin");
                this.run = r5;
                this.tasks = r6;
            }

            void cleanup() {
                io.reactivex.internal.disposables.a r0 = this.tasks;
                if (r0 == null) goto L6;
                r0.delete(this);
                return;
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
            L2:
                int r0 = get();
                if (r0 >= 2) goto L25;
                if (r0 == 0) goto L8;
                if (compareAndSet(1, 3) == false) goto L2;
                Thread r1 = this.thread;
                if (r1 == null) goto L15;
                r1.interrupt();
                this.thread = null;
            L15:
                set(4);
            L9:
                cleanup();
                return;
            L8:
                if (compareAndSet(0, 4) == false) goto L2;
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                if (get() < 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() != 0) goto L30;
                this.thread = Thread.currentThread();
                if (compareAndSet(0, 1) == true) goto L26;
                this.thread = null;
                return;
            L26:
                this.run.run();     // Catch: Throwable -> L15
                this.thread = null;
                if (compareAndSet(1, 2) == false) goto L12;
                cleanup();
                return;
            L12:
                if (get() != 3) goto L14;
                Thread.yield();
                goto L12
            L14:
                Thread.interrupted();
                return;
            L15:
                th = move-exception;
                this.thread = null;
                if (compareAndSet(1, 2) == false) goto L19;
                cleanup();
            L23:
                throw th;
            L19:
                if (get() != 3) goto L21;
                Thread.yield();
                goto L19
            L21:
                Thread.interrupted();
                goto L23
            }
        }

        final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ExecutorWorker f17111a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final SequentialDisposable f17112b;
            private final Runnable c;

            a(ExecutorWorker r3, SequentialDisposable r4, Runnable r5) {
                Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
                this.f17111a = r3;
                this.f17112b = r4;
                this.c = r6;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f17112b.replace(this.f17111a.a(this.c));
            }
        }

        public ExecutorWorker(Executor r3, boolean r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            this.e = new AtomicInteger();
            this.f = new io.reactivex.disposables.a();
            this.f17110b = r5;
            this.c = new MpscLinkedQueue();
            this.f17109a = r4;
        }

        @Override // io.reactivex.u.c
        public io.reactivex.disposables.b a(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            if (this.d == true) goto L5;
            Runnable r5 = io.reactivex.d.a.a(r4);
            if (this.f17109a == false) goto L9;
            io.reactivex.disposables.b r0 = new InterruptibleRunnable(r5, this.f);
            this.f.a(r0);
        L10:
            this.c.offer(r0);
            if (this.e.getAndIncrement() == 0) goto L18;
        L17:
            return r0;
        L18:
            this.f17110b.execute(this);     // Catch: RejectedExecutionException -> L14
        L14:
            e = move-exception;
            this.d = true;
            this.c.clear();
            io.reactivex.d.a.a(e);
            return EmptyDisposable.INSTANCE;
        L9:
            r0 = new BooleanRunnable(r5);
            goto L10
        L5:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.u.c
        public io.reactivex.disposables.b a(Runnable r6, long r7, TimeUnit r9) {
            Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
            if (r7 > 0) goto L7;
            return a(r8);
        L7:
            if (this.d == true) goto L9;
            SequentialDisposable r0 = new SequentialDisposable();
            SequentialDisposable r2 = new SequentialDisposable(r0);
            ScheduledRunnable r3 = new ScheduledRunnable(new a(this, r2, io.reactivex.d.a.a(r8)), this.f);
            this.f.a(r3);
            if (ZeusTransformUtils.instanceOf(this.f17110b, ScheduledExecutorService.class) == true) goto L20;
            r3.setFuture(new b(ExecutorScheduler.e.a(r3, r7, r9)));
        L18:
            r0.replace(r3);
            return r2;
        L20:
            r3.setFuture(((ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.f17110b, ScheduledExecutorService.class, "com.obric.memorydata.plugin")).schedule(r3, r7, r9));     // Catch: RejectedExecutionException -> L14
        L14:
            e = move-exception;
            this.d = true;
            io.reactivex.d.a.a(e);
            return EmptyDisposable.INSTANCE;
        L9:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.d == true) goto L8;
            this.d = true;
            this.f.dispose();
            if (this.e.getAndIncrement() != 0) goto L9;
            this.c.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d;
        }

        @Override // java.lang.Runnable
        public void run() {
            MpscLinkedQueue<Runnable> r0 = this.c;
            int r1 = 1;
        L4:
            if (this.d == true) goto L5;
        L7:
            Runnable r2 = (Runnable) ZeusTransformUtils.preCheckCast(r0.poll(), Runnable.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L10;
            r2.run();
            if (this.d == false) goto L7;
            r0.clear();
            return;
        L10:
            if (this.d == true) goto L11;
            r1 = this.e.addAndGet(-r1);
            if (r1 != 0) goto L4;
            return;
        L11:
            r0.clear();
            return;
        L5:
            r0.clear();
        }
    }

    final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExecutorScheduler f17113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DelayedRunnable f17114b;

        a(ExecutorScheduler r1, DelayedRunnable r2) {
            this.f17113a = r1;
            this.f17114b = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17114b.direct.replace(this.f17113a.a(this.f17114b));
        }
    }

    static {
        e = io.reactivex.e.a.a();
    }

    @Override // io.reactivex.u
    public io.reactivex.disposables.b a(Runnable r4) {
        Runnable r5 = io.reactivex.d.a.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin"));
    L13:
        e = move-exception;
        io.reactivex.d.a.a(e);
        return EmptyDisposable.INSTANCE;
    L4:
        if (ZeusTransformUtils.instanceOf(this.d, ExecutorService.class) == false) goto L8;
        ScheduledDirectTask r0 = new ScheduledDirectTask(r5);     // Catch: RejectedExecutionException -> L13
        r0.setFuture(((ExecutorService) ZeusTransformUtils.preCheckCast(this.d, ExecutorService.class, "com.obric.memorydata.plugin")).submit(r0));     // Catch: RejectedExecutionException -> L13
        return r0;
    L8:
        if (this.c == false) goto L11;
        ExecutorWorker.InterruptibleRunnable r1 = new ExecutorWorker.InterruptibleRunnable(r5, null);     // Catch: RejectedExecutionException -> L13
        this.d.execute(r1);     // Catch: RejectedExecutionException -> L13
        return r1;
    L11:
        ExecutorWorker.BooleanRunnable r2 = new ExecutorWorker.BooleanRunnable(r5);     // Catch: RejectedExecutionException -> L13
        this.d.execute(r2);     // Catch: RejectedExecutionException -> L13
        return r2;
    }

    @Override // io.reactivex.u
    public io.reactivex.disposables.b a(Runnable r10, long r11, long r13, TimeUnit r15) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r10, Runnable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this.d, ScheduledExecutorService.class) == false) goto L11;
        ScheduledDirectPeriodicTask r0 = new ScheduledDirectPeriodicTask(io.reactivex.d.a.a(r3));     // Catch: RejectedExecutionException -> L7
        r0.setFuture(((ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.d, ScheduledExecutorService.class, "com.obric.memorydata.plugin")).scheduleAtFixedRate(r0, r11, r13, r15));     // Catch: RejectedExecutionException -> L7
        return r0;
    L7:
        e = move-exception;
        io.reactivex.d.a.a(e);
        return EmptyDisposable.INSTANCE;
    L11:
        return super.a(r3, r11, r13, r15);
    }

    @Override // io.reactivex.u
    public io.reactivex.disposables.b a(Runnable r4, long r5, TimeUnit r7) {
        Runnable r6 = io.reactivex.d.a.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(this.d, ScheduledExecutorService.class) == true) goto L11;
        DelayedRunnable r0 = new DelayedRunnable(r6);
        io.reactivex.disposables.b r3 = e.a(new a(this, r0), r5, r7);
        r0.timed.replace(r3);
        return r0;
    L11:
        ScheduledDirectTask r1 = new ScheduledDirectTask(r6);     // Catch: RejectedExecutionException -> L6
        r1.setFuture(((ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.d, ScheduledExecutorService.class, "com.obric.memorydata.plugin")).schedule(r1, r5, r7));     // Catch: RejectedExecutionException -> L6
        return r1;
    L6:
        e = move-exception;
        io.reactivex.d.a.a(e);
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.u
    public u.c a() {
        return new ExecutorWorker(this.d, this.c);
    }
}
