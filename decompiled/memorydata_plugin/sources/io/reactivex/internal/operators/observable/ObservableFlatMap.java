package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.a.e;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.s;
import io.reactivex.t;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableFlatMap<T, U> extends a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends s<? extends U>> f16943b;
    final boolean c;
    final int d;
    final int e;

    static final class InnerObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements t<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final MergeObserver<T, U> parent;
        volatile f<U> queue;

        InnerObserver(MergeObserver<T, U> r1, long r2) {
            this.id = r2;
            this.parent = r1;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.parent.errors.addThrowable(r2) == true) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.parent.delayErrors == true) goto L7;
            this.parent.disposeAll();
        L7:
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.t
        public void onNext(U r2) {
            if (this.fusionMode != 0) goto L5;
            this.parent.tryEmit(r2, this);
            return;
        L5:
            this.parent.drain();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.setOnce(this, r4) == true) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.b.class) == false) goto L15;
            io.reactivex.internal.a.b r5 = (io.reactivex.internal.a.b) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.b.class, "com.obric.memorydata.plugin");
            int r0 = r5.requestFusion(7);
            if (r0 != 1) goto L11;
            this.fusionMode = r0;
            this.queue = r5;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r0 != 2) goto L16;
            this.fusionMode = r0;
            this.queue = r5;
            return;
        L16:
            return;
        }
    }

    static final class MergeObserver<T, U> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        static final InnerObserver<?, ?>[] CANCELLED = null;
        static final InnerObserver<?, ?>[] EMPTY = null;
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final t<? super U> downstream;
        final AtomicThrowable errors;
        long lastId;
        int lastIndex;
        final h<? super T, ? extends s<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile e<U> queue;
        Queue<s<? extends U>> sources;
        long uniqueId;
        io.reactivex.disposables.b upstream;
        int wip;

        static {
            EMPTY = new InnerObserver[0];
            CANCELLED = new InnerObserver[0];
        }

        MergeObserver(t<? super U> r3, h<? super T, ? extends s<? extends U>> r4, boolean r5, int r6, int r7) {
            t<? super U> r8 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends s<? extends U>> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.errors = new AtomicThrowable();
            this.downstream = r8;
            this.mapper = r9;
            this.delayErrors = r5;
            this.maxConcurrency = r6;
            this.bufferSize = r7;
            if (r6 == Integer.MAX_VALUE) goto L5;
            this.sources = new ArrayDeque(r6);
        L5:
            this.observers = new AtomicReference(EMPTY);
        }

        boolean addInner(InnerObserver<T, U> r5) {
        L2:
            InnerObserver<?, ?>[] r0 = (InnerObserver[]) ZeusTransformUtils.preCheckCast(this.observers.get(), InnerObserver[].class, "com.obric.memorydata.plugin");
            if (r0 == CANCELLED) goto L4;
            int r1 = r0.length;
            InnerObserver[] r3 = new InnerObserver[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (this.observers.compareAndSet(r0, (InnerObserver<?, ?>[]) r3) == false) goto L2;
            return true;
        L4:
            r5.dispose();
            return false;
        }

        boolean checkTerminate() {
            if (this.cancelled == false) goto L5;
            return true;
        L5:
            Throwable r0 = (Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin");
            if (this.delayErrors == true) goto L12;
            if (r0 == null) goto L14;
            disposeAll();
            Throwable r1 = this.errors.terminate();
            if (r1 == ExceptionHelper.f17150a) goto L11;
            this.downstream.onError(r1);
        L11:
            return true;
        L14:
            return false;
        L12:
            return false;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == true) goto L12;
            this.cancelled = true;
            if (disposeAll() == false) goto L13;
            Throwable r1 = this.errors.terminate();
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1 == ExceptionHelper.f17150a) goto L15;
            io.reactivex.d.a.a(r1);
            return;
        L15:
            return;
        L13:
            return;
        }

        boolean disposeAll() {
            this.upstream.dispose();
            InnerObserver<?, ?>[] r0 = (InnerObserver[]) ZeusTransformUtils.preCheckCast(this.observers.get(), InnerObserver[].class, "com.obric.memorydata.plugin");
            InnerObserver<?, ?>[] r1 = CANCELLED;
            int r3 = 0;
            if (r0 == r1) goto L11;
            InnerObserver<?, ?>[] r4 = (InnerObserver[]) ZeusTransformUtils.preCheckCast(this.observers.getAndSet(r1), InnerObserver[].class, "com.obric.memorydata.plugin");
            if (r4 == r1) goto L11;
            int r2 = r4.length;
        L7:
            if (r3 >= r2) goto L9;
            r4[r3].dispose();
            r3 = r3 + 1;
            goto L7
        L9:
            return true;
        L11:
            return false;
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        void drainLoop() {
            t<? super U> r0 = this.downstream;
            int r1 = 1;
        L4:
            if (checkTerminate() == true) goto L5;
            e<U> r2 = this.queue;
            int r4 = 0;
            if (r2 == null) goto L16;
        L9:
            if (checkTerminate() == true) goto L10;
            U r5 = r2.poll();
            if (r5 == null) goto L16;
            r0.onNext(r5);
            r4 = r4 + 1;
            goto L9
        L10:
            return;
        L16:
            if (r4 != 0) goto L18;
            boolean r6 = this.done;
            e<U> r7 = this.queue;
            InnerObserver<T, U>[] r8 = (InnerObserver[]) ZeusTransformUtils.preCheckCast(this.observers.get(), InnerObserver[].class, "com.obric.memorydata.plugin");
            int r9 = r8.length;
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L29;
            monitor-enter(this);
            int r10 = this.sources.size();     // Catch: Throwable -> L26
            monitor-exit(this);     // Catch: Throwable -> L26
        L30:
            if (r6 == false) goto L42;
            if (r7 != null) goto L33;
        L34:
            if (r9 != 0) goto L42;
            if (r10 != 0) goto L42;
            Throwable r13 = this.errors.terminate();
            if (r13 == ExceptionHelper.f17150a) goto L134;
            if (r13 != null) goto L40;
            r0.onComplete();
            return;
        L40:
            r0.onError(r13);
            return;
        L134:
            return;
        L33:
            if (r7.isEmpty() == true) goto L34;
        L42:
            if (r9 == 0) goto L93;
            long r11 = this.lastId;
            int r12 = this.lastIndex;
            if (r9 > r12) goto L46;
        L47:
            if (r9 > r12) goto L49;
            r12 = 0;
        L49:
            int r14 = 0;
        L50:
            if (r14 >= r9) goto L58;
            if (r8[r12].id == r11) goto L58;
            r12 = r12 + 1;
            if (r12 != r9) goto L57;
            r12 = 0;
        L57:
            r14 = r14 + 1;
        L58:
            this.lastIndex = r12;
            this.lastId = r8[r12].id;
        L59:
            int r15 = 0;
        L60:
            if (r15 >= r9) goto L92;
            if (checkTerminate() == true) goto L63;
            InnerObserver<T, U> r16 = r8[r12];
            f<U> r17 = r16.queue;
            if (r17 != null) goto L102;
        L79:
            boolean r18 = r16.done;
            f<U> r19 = r16.queue;
            if (r18 == false) goto L88;
            if (r19 != null) goto L83;
        L84:
            removeInner(r16);
            if (checkTerminate() == true) goto L86;
            r4 = r4 + 1;
            goto L88
        L86:
            return;
        L83:
            if (r19.isEmpty() == true) goto L84;
        L88:
            r12 = r12 + 1;
            if (r12 != r9) goto L91;
        L90:
            r12 = 0;
        L91:
            r15 = r15 + 1;
        L102:
            U r110 = r17.poll();     // Catch: Throwable -> L72
            if (r110 == null) goto L79;
            r0.onNext(r110);
            if (checkTerminate() == false) goto L102;
            return;
        L72:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r16.dispose();
            this.errors.addThrowable(th);
            if (checkTerminate() == true) goto L75;
            removeInner(r16);
            r4 = r4 + 1;
            r12 = r12 + 1;
            if (r12 != r9) goto L91;
        L75:
            return;
        L63:
            return;
        L92:
            this.lastIndex = r12;
            this.lastId = r8[r12].id;
            goto L93
        L46:
            if (r8[r12].id == r11) goto L59;
        L93:
            if (r4 != 0) goto L95;
            r1 = addAndGet(-r1);
            if (r1 != 0) goto L4;
            return;
        L95:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L4;
        L19:
            subscribeMore(r4);
        L26:
            th = move-exception;
            throw th;
        L29:
            r10 = 0;
            goto L30
        L18:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L4;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.done == false) goto L7;
            io.reactivex.d.a.a(r2);
            return;
        L7:
            if (this.errors.addThrowable(r2) == false) goto L9;
            this.done = true;
            drain();
            return;
        L9:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            if (this.done == false) goto L26;
            return;
        L26:
            s<? extends U> r4 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The mapper returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L20;
            monitor-enter(this);
            int r0 = this.wip;     // Catch: Throwable -> L17
            if (r0 != this.maxConcurrency) goto L14;
            this.sources.offer(r4);     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L17
            return;
        L14:
            this.wip = r0 + 1;     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        L20:
            subscribeInner(r4);
            return;
        L22:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        void removeInner(InnerObserver<T, U> r7) {
        L2:
            InnerObserver<T, U>[] r0 = (InnerObserver[]) ZeusTransformUtils.preCheckCast(this.observers.get(), InnerObserver[].class, "com.obric.memorydata.plugin");
            int r1 = r0.length;
            if (r1 == 0) goto L4;
            int r2 = -1;
            int r4 = 0;
        L6:
            if (r4 >= r1) goto L11;
            if (r0[r4] == r7) goto L9;
            r4 = r4 + 1;
            goto L6
        L9:
            r2 = r4;
        L11:
            if (r2 < 0) goto L12;
            if (r1 != 1) goto L16;
            InnerObserver<?, ?>[] r3 = EMPTY;
        L18:
            if (this.observers.compareAndSet(r0, r3) == false) goto L2;
            return;
        L16:
            InnerObserver<?, ?>[] r5 = new InnerObserver[r1 - 1];
            System.arraycopy(r0, 0, r5, 0, r2);
            System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
            r3 = r5;
            goto L18
        L12:
            return;
        }

        void subscribeInner(s<? extends U> r6) {
            s r7 = (s) ZeusTransformUtils.wrapperContextForParams(r6, s.class, "com.obric.memorydata.plugin");
        L4:
            if (ZeusTransformUtils.instanceOf(r7, Callable.class) == false) goto L21;
            if (tryEmitScalar((Callable) ZeusTransformUtils.preCheckCast(r7, Callable.class, "com.obric.memorydata.plugin")) == false) goto L33;
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L34;
            boolean r8 = false;
            monitor-enter(this);
            s r0 = (s) ZeusTransformUtils.preCheckCast(this.sources.poll(), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
            if (r0 != null) goto L14;
            this.wip--;     // Catch: Throwable -> L18
            r8 = true;
        L14:
            monitor-exit(this);     // Catch: Throwable -> L18
            if (r8 == true) goto L16;
            r7 = r0;
            goto L4
        L16:
            drain();
            return;
        L18:
            th = move-exception;
            throw th;
        L34:
            return;
        L33:
            return;
        L21:
            long r1 = this.uniqueId;
            this.uniqueId = 1 + r1;
            InnerObserver<T, U> r2 = new InnerObserver(this, r1);
            if (addInner(r2) == false) goto L32;
            r7.subscribe(r2);
            return;
        }

        void subscribeMore(int r4) {
        L2:
            int r0 = r4 - 1;
            if (r4 == 0) goto L16;
            monitor-enter(this);
            s<? extends U> r5 = (s) ZeusTransformUtils.preCheckCast(this.sources.poll(), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
            if (r5 != null) goto L10;
            this.wip--;     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
        L12:
            r4 = r0;
            goto L2
        L10:
            monitor-exit(this);     // Catch: Throwable -> L13
            subscribeInner(r5);
        L13:
            th = move-exception;
            throw th;
        }

        void tryEmit(U r3, InnerObserver<T, U> r4) {
            if (get() == 0) goto L5;
        L9:
            f r0 = r4.queue;
            if (r0 != null) goto L12;
            r0 = new io.reactivex.internal.queue.a(this.bufferSize);
            r4.queue = r0;
        L12:
            r0.offer(r3);
            if (getAndIncrement() == 0) goto L15;
            return;
        L15:
            drainLoop();
            return;
        L5:
            if (compareAndSet(0, 1) == false) goto L9;
            this.downstream.onNext(r3);
            if (decrementAndGet() != 0) goto L15;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v4, types: [io.reactivex.internal.a.e] */
        boolean tryEmitScalar(Callable<? extends U> r5) {
            Object r6 = ((Callable) ZeusTransformUtils.wrapperContextForParams(r5, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L29
            if (r6 != null) goto L7;
            return true;
        L7:
            if (get() == 0) goto L9;
        L13:
            e<U> r1 = this.queue;
            ?? r2 = r1;
            if (r1 == true) goto L21;
            if (this.maxConcurrency != Integer.MAX_VALUE) goto L18;
            e<U> r3 = new io.reactivex.internal.queue.a(this.bufferSize);
        L19:
            this.queue = r3;
            r2 = r3;
            goto L21
        L18:
            r3 = new SpscArrayQueue(this.maxConcurrency);
        L21:
            if (r2.offer(r6) == true) goto L25;
            onError(new IllegalStateException("Scalar queue full?!"));
            return true;
        L25:
            if (getAndIncrement() == 0) goto L27;
            return false;
        L27:
            drainLoop();
            return true;
        L9:
            if (compareAndSet(0, 1) == false) goto L13;
            this.downstream.onNext(r6);
            if (decrementAndGet() != 0) goto L27;
            return true;
        L29:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.errors.addThrowable(th);
            drain();
            return true;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super U> r8) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.memorydata.plugin");
        if (ObservableScalarXMap.a(this.f17034a, r1, this.f16943b) == false) goto L5;
        return;
    L5:
        this.f17034a.subscribe(new MergeObserver(r1, this.f16943b, this.c, this.d, this.e));
    }
}
