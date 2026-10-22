package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.s;
import io.reactivex.t;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableConcatMapEager<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends s<? extends R>> f16934b;
    final ErrorMode c;
    final int d;
    final int e;

    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements io.reactivex.disposables.b, io.reactivex.internal.observers.b<R>, t<T> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        volatile boolean cancelled;
        InnerQueuedObserver<R> current;
        volatile boolean done;
        final t<? super R> downstream;
        final AtomicThrowable error;
        final ErrorMode errorMode;
        final h<? super T, ? extends s<? extends R>> mapper;
        final int maxConcurrency;
        final ArrayDeque<InnerQueuedObserver<R>> observers;
        final int prefetch;
        f<T> queue;
        int sourceMode;
        io.reactivex.disposables.b upstream;

        ConcatMapEagerMainObserver(t<? super R> r3, h<? super T, ? extends s<? extends R>> r4, int r5, int r6, ErrorMode r7) {
            t<? super R> r8 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends s<? extends R>> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r8;
            this.mapper = r9;
            this.maxConcurrency = r5;
            this.prefetch = r6;
            this.errorMode = r7;
            this.error = new AtomicThrowable();
            this.observers = new ArrayDeque();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            this.upstream.dispose();
            drainAndDispose();
        }

        void disposeAll() {
            InnerQueuedObserver<R> r0 = this.current;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            InnerQueuedObserver r1 = (InnerQueuedObserver) ZeusTransformUtils.preCheckCast(this.observers.poll(), InnerQueuedObserver.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L7;
            r1.dispose();
            goto L5
        }

        @Override // io.reactivex.internal.observers.b
        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            f<T> r0 = this.queue;
            ArrayDeque<InnerQueuedObserver<R>> r1 = this.observers;
            t<? super R> r2 = this.downstream;
            ErrorMode r3 = this.errorMode;
            int r5 = 1;
        L6:
            int r6 = this.activeCount;
        L8:
            if (r6 == this.maxConcurrency) goto L27;
            if (this.cancelled == true) goto L11;
            if (r3 == ErrorMode.IMMEDIATE) goto L16;
        L88:
            T r7 = r0.poll();     // Catch: Throwable -> L24
            if (r7 == null) goto L27;
            s r8 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r7), "The mapper returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
            InnerQueuedObserver<R> r9 = new InnerQueuedObserver(this, this.prefetch);
            r1.offer(r9);
            r8.subscribe(r9);
            r6 = r6 + 1;
        L24:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.dispose();
            r0.clear();
            disposeAll();
            this.error.addThrowable(th);
            r2.onError(this.error.terminate());
            return;
        L16:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L88;
            r0.clear();
            disposeAll();
            r2.onError(this.error.terminate());
            return;
        L11:
            r0.clear();
            disposeAll();
            return;
        L27:
            this.activeCount = r6;
            if (this.cancelled == true) goto L29;
            if (r3 == ErrorMode.IMMEDIATE) goto L34;
        L37:
            InnerQueuedObserver<R> r10 = this.current;
            if (r10 == null) goto L40;
        L59:
            if (r10 == null) goto L85;
            f<R> r11 = r10.queue();
        L62:
            if (this.cancelled == true) goto L63;
            boolean r12 = r10.isDone();
            if (r3 != ErrorMode.IMMEDIATE) goto L90;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L90;
            r0.clear();
            disposeAll();
            r2.onError(this.error.terminate());
            return;
        L90:
            R r13 = r11.poll();     // Catch: Throwable -> L82
            if (r13 != null) goto L75;
            boolean r14 = true;
        L76:
            if (r12 == false) goto L79;
            if (r14 == false) goto L79;
        L84:
            this.current = null;
            this.activeCount--;
        L79:
            if (r14 == true) goto L85;
            r2.onNext(r13);
            goto L62
        L75:
            r14 = false;
        L82:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.error.addThrowable(th);
            goto L84
        L63:
            r0.clear();
            disposeAll();
            return;
        L85:
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L6;
            return;
        L40:
            if (r3 == ErrorMode.BOUNDARY) goto L42;
        L45:
            boolean r15 = this.done;
            InnerQueuedObserver<R> r16 = (InnerQueuedObserver) ZeusTransformUtils.preCheckCast(r1.poll(), InnerQueuedObserver.class, "com.obric.memorydata.plugin");
            if (r16 != null) goto L48;
            boolean r17 = true;
        L49:
            if (r15 == false) goto L56;
            if (r17 == false) goto L56;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L54;
            r0.clear();
            disposeAll();
            r2.onError(this.error.terminate());
            return;
        L54:
            r2.onComplete();
            return;
        L56:
            if (r17 == true) goto L58;
            this.current = r16;
        L58:
            r10 = r16;
            goto L59
        L48:
            r17 = false;
            goto L49
        L42:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L45;
            r0.clear();
            disposeAll();
            r2.onError(this.error.terminate());
            return;
        L34:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L37;
            r0.clear();
            disposeAll();
            r2.onError(this.error.terminate());
            return;
        L29:
            r0.clear();
            disposeAll();
        }

        void drainAndDispose() {
            if (getAndIncrement() != 0) goto L6;
        L4:
            this.queue.clear();
            disposeAll();
            if (decrementAndGet() != 0) goto L4;
            return;
        }

        @Override // io.reactivex.internal.observers.b
        public void innerComplete(InnerQueuedObserver<R> r1) {
            r1.setDone();
            drain();
        }

        @Override // io.reactivex.internal.observers.b
        public void innerError(InnerQueuedObserver<R> r2, Throwable r3) {
            if (this.error.addThrowable(r3) == true) goto L5;
            io.reactivex.d.a.a(r3);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
            this.upstream.dispose();
        L7:
            r2.setDone();
            drain();
        }

        @Override // io.reactivex.internal.observers.b
        public void innerNext(InnerQueuedObserver<R> r1, R r2) {
            r1.queue().offer(r2);
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            if (this.sourceMode != 0) goto L5;
            this.queue.offer(r2);
        L5:
            drain();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L16;
            this.upstream = r4;
            if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.b.class) == false) goto L14;
            io.reactivex.internal.a.b r5 = (io.reactivex.internal.a.b) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.b.class, "com.obric.memorydata.plugin");
            int r0 = r5.requestFusion(3);
            if (r0 != 1) goto L11;
            this.sourceMode = r0;
            this.queue = r5;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
        L11:
            if (r0 != 2) goto L14;
            this.sourceMode = r0;
            this.queue = r5;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new io.reactivex.internal.queue.a(this.prefetch);
            this.downstream.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r8) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new ConcatMapEagerMainObserver(r1, this.f16934b, this.d, this.e, this.c));
    }
}
