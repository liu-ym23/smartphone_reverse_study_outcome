package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<U> f16927b;
    final s<? extends Open> c;
    final h<? super Open, ? extends s<? extends Close>> d;

    static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = -8466418554264089604L;
        final h<? super Open, ? extends s<? extends Close>> bufferClose;
        final s<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        Map<Long, C> buffers;
        volatile boolean cancelled;
        volatile boolean done;
        final t<? super C> downstream;
        final AtomicThrowable errors;
        long index;
        final io.reactivex.disposables.a observers;
        final io.reactivex.internal.queue.a<C> queue;
        final AtomicReference<io.reactivex.disposables.b> upstream;

        static final class BufferOpenObserver<Open> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<Open> {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundaryObserver<?, ?, Open, ?> parent;

            BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                if (get() != DisposableHelper.DISPOSED) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // io.reactivex.t
            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.openComplete(this);
            }

            @Override // io.reactivex.t
            public void onError(Throwable r2) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.boundaryError(this, r2);
            }

            @Override // io.reactivex.t
            public void onNext(Open r1) {
                this.parent.open(r1);
            }

            @Override // io.reactivex.t
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }
        }

        BufferBoundaryObserver(t<? super C> r3, s<? extends Open> r4, h<? super Open, ? extends s<? extends Close>> r5, Callable<C> r6) {
            t<? super C> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            s<? extends Open> r8 = (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin");
            h<? super Open, ? extends s<? extends Close>> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            Callable<C> r10 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.bufferSupplier = r10;
            this.bufferOpen = r8;
            this.bufferClose = r9;
            this.queue = new io.reactivex.internal.queue.a(Observable.a());
            this.observers = new io.reactivex.disposables.a();
            this.upstream = new AtomicReference();
            this.buffers = new LinkedHashMap();
            this.errors = new AtomicThrowable();
        }

        void boundaryError(io.reactivex.disposables.b r3, Throwable r4) {
            io.reactivex.disposables.b r5 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.dispose(this.upstream);
            this.observers.delete(r5);
            onError(r4);
        }

        void close(BufferCloseObserver<T, C> r4, long r5) {
            this.observers.delete(r4);
            if (this.observers.a() != 0) goto L5;
            DisposableHelper.dispose(this.upstream);
            boolean r6 = true;
        L6:
            monitor-enter(this);
            Map<Long, C> r1 = this.buffers;     // Catch: Throwable -> L17
            if (r1 != null) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L17
            return;
        L11:
            this.queue.offer(r1.remove(Long.valueOf(r5)));     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L17
            if (r6 == false) goto L15;
            this.done = true;
        L15:
            drain();
            return;
        L17:
            th = move-exception;
            throw th;
        L5:
            r6 = false;
            goto L6
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (DisposableHelper.dispose(this.upstream) == false) goto L15;
            this.cancelled = true;
            this.observers.dispose();
            monitor-enter(this);
            this.buffers = null;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            if (getAndIncrement() == 0) goto L18;
            this.queue.clear();
            return;
        L18:
            return;
        L12:
            th = move-exception;
            throw th;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            t<? super C> r0 = this.downstream;
            io.reactivex.internal.queue.a<C> r1 = this.queue;
            int r3 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            boolean r4 = this.done;
            if (r4 == true) goto L13;
        L16:
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r1.poll(), Collection.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L19;
            boolean r6 = true;
        L20:
            if (r4 == false) goto L24;
            if (r6 == false) goto L24;
            r0.onComplete();
            return;
        L24:
            if (r6 == true) goto L25;
            r0.onNext(r5);
            goto L7
        L25:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L7;
            return;
        L19:
            r6 = false;
            goto L20
        L13:
            if (this.errors.get() == null) goto L16;
            r1.clear();
            r0.onError(this.errors.terminate());
            return;
        L8:
            r1.clear();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.upstream.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.observers.dispose();
            monitor-enter(this);
            Map<Long, C> r0 = this.buffers;     // Catch: Throwable -> L16
            if (r0 != null) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L16
            return;
        L8:
            Iterator<C> r1 = r0.values().iterator();     // Catch: Throwable -> L16
        L10:
            if (r1.hasNext() == false) goto L12;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r1.next(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            this.queue.offer((C) r2);     // Catch: Throwable -> L16
            goto L10
        L12:
            this.buffers = null;     // Catch: Throwable -> L16
            monitor-exit(this);     // Catch: Throwable -> L16
            this.done = true;
            drain();
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L13;
            this.observers.dispose();
            monitor-enter(this);
            this.buffers = null;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            this.done = true;
            drain();
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r5) {
            monitor-enter(this);
            Map<Long, C> r0 = this.buffers;     // Catch: Throwable -> L13
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            Iterator<C> r1 = r0.values().iterator();     // Catch: Throwable -> L13
        L9:
            if (r1.hasNext() == false) goto L11;
            ((Collection) ZeusTransformUtils.preCheckCast(r1.next(), Collection.class, "com.obric.memorydata.plugin")).add(r5);     // Catch: Throwable -> L13
            goto L9
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.setOnce(this.upstream, r4) == false) goto L6;
            BufferOpenObserver r5 = new BufferOpenObserver(this);
            this.observers.a(r5);
            this.bufferOpen.subscribe(r5);
            return;
        }

        void open(Open r6) {
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection"), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            s r7 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.bufferClose.apply(r6), "The bufferClose returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            long r1 = this.index;
            this.index = 1 + r1;
            monitor-enter(this);
            Map<Long, C> r3 = this.buffers;     // Catch: Throwable -> L13
            if (r3 != null) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L9:
            r3.put(Long.valueOf(r1), (C) r0);     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            BufferCloseObserver r2 = new BufferCloseObserver(this, r1);
            this.observers.a(r2);
            r7.subscribe(r2);
            return;
        L13:
            th = move-exception;
            throw th;
        L16:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            DisposableHelper.dispose(this.upstream);
            onError(th);
        }

        void openComplete(BufferOpenObserver<Open> r2) {
            this.observers.delete(r2);
            if (this.observers.a() != 0) goto L6;
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            drain();
            return;
        }
    }

    static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<Object> {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final BufferBoundaryObserver<T, C, ?, ?> parent;

        BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> r1, long r2) {
            this.parent = r1;
            this.index = r2;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (get() == DisposableHelper.DISPOSED) goto L6;
            lazySet(DisposableHelper.DISPOSED);
            this.parent.close(this, this.index);
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r3) {
            if (get() == DisposableHelper.DISPOSED) goto L5;
            lazySet(DisposableHelper.DISPOSED);
            this.parent.boundaryError(this, r3);
            return;
        L5:
            io.reactivex.d.a.a(r3);
        }

        @Override // io.reactivex.t
        public void onNext(Object r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r4 == DisposableHelper.DISPOSED) goto L6;
            lazySet(DisposableHelper.DISPOSED);
            r4.dispose();
            this.parent.close(this, this.index);
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super U> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        BufferBoundaryObserver r0 = new BufferBoundaryObserver(r6, this.c, this.d, this.f16927b);
        r6.onSubscribe(r0);
        this.f17034a.subscribe(r0);
    }
}
