package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableConcatMapCompletable<T> extends io.reactivex.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observable<T> f16902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends e> f16903b;
    final ErrorMode c;
    final int d;

    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements b, t<T> {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        volatile boolean disposed;
        volatile boolean done;
        final c downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors;
        final ConcatMapInnerObserver inner;
        final h<? super T, ? extends e> mapper;
        final int prefetch;
        f<T> queue;
        b upstream;

        static final class ConcatMapInnerObserver extends AtomicReference<b> implements c {
            private static final long serialVersionUID = 5638352172918776687L;
            final ConcatMapCompletableObserver<?> parent;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> r1) {
                this.parent = r1;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.c
            public void onError(Throwable r1) {
                this.parent.innerError(r1);
            }

            @Override // io.reactivex.c
            public void onSubscribe(b r3) {
                DisposableHelper.replace(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
            }
        }

        ConcatMapCompletableObserver(c r3, h<? super T, ? extends e> r4, ErrorMode r5, int r6) {
            c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends e> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.mapper = r8;
            this.errorMode = r5;
            this.prefetch = r6;
            this.errors = new AtomicThrowable();
            this.inner = new ConcatMapInnerObserver(this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            AtomicThrowable r0 = this.errors;
            ErrorMode r1 = this.errorMode;
        L7:
            if (this.disposed == true) goto L8;
            if (this.active == true) goto L37;
            if (r1 == ErrorMode.BOUNDARY) goto L15;
        L18:
            boolean r2 = this.done;
            e r4 = null;
            T r5 = this.queue.poll();     // Catch: Throwable -> L33
            if (r5 == null) goto L23;
            r4 = (e) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r5), "The mapper returned a null CompletableSource"), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
            boolean r6 = false;
        L24:
            if (r2 == false) goto L31;
            if (r6 == false) goto L31;
            this.disposed = true;
            Throwable r3 = r0.terminate();
            c r7 = this.downstream;
            if (r3 == null) goto L29;
            r7.onError(r3);
            return;
        L29:
            r7.onComplete();
            return;
        L31:
            if (r6 == true) goto L37;
            this.active = true;
            r4.a(this.inner);
            goto L37
        L23:
            r6 = true;
        L33:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.disposed = true;
            this.queue.clear();
            this.upstream.dispose();
            r0.addThrowable(th);
            this.downstream.onError(r0.terminate());
            return;
        L15:
            if (r0.get() == null) goto L18;
            this.disposed = true;
            this.queue.clear();
            this.downstream.onError(r0.terminate());
            return;
        L37:
            if (decrementAndGet() != 0) goto L7;
            return;
        L8:
            this.queue.clear();
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void innerError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
            this.disposed = true;
            this.upstream.dispose();
            Throwable r3 = this.errors.terminate();
            if (r3 == ExceptionHelper.f17150a) goto L10;
            this.downstream.onError(r3);
        L10:
            if (getAndIncrement() != 0) goto L15;
            this.queue.clear();
            return;
        L15:
            return;
        L12:
            this.active = false;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r3) {
            if (this.errors.addThrowable(r3) == true) goto L5;
            io.reactivex.d.a.a(r3);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
            this.disposed = true;
            this.inner.dispose();
            Throwable r4 = this.errors.terminate();
            if (r4 == ExceptionHelper.f17150a) goto L10;
            this.downstream.onError(r4);
        L10:
            if (getAndIncrement() != 0) goto L15;
            this.queue.clear();
            return;
        L15:
            return;
        L12:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            if (r2 == null) goto L4;
            this.queue.offer(r2);
        L4:
            drain();
        }

        @Override // io.reactivex.t
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L16;
            this.upstream = r4;
            if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.b.class) == false) goto L14;
            io.reactivex.internal.a.b r5 = (io.reactivex.internal.a.b) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.b.class, "com.obric.memorydata.plugin");
            int r0 = r5.requestFusion(3);
            if (r0 != 1) goto L11;
            this.queue = r5;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
        L11:
            if (r0 != 2) goto L14;
            this.queue = r5;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new io.reactivex.internal.queue.a(this.prefetch);
            this.downstream.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.a
    public void b(c r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        if (a.a(this.f16902a, this.f16903b, r6) == true) goto L6;
        this.f16902a.subscribe(new ConcatMapCompletableObserver(r6, this.f16903b, this.c, this.d));
        return;
    }
}
