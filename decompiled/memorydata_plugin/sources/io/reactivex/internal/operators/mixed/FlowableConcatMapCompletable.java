package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableConcatMapCompletable<T> extends io.reactivex.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g<T> f16889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends e> f16890b;
    final ErrorMode c;
    final int d;

    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements b, j<T> {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        int consumed;
        volatile boolean disposed;
        volatile boolean done;
        final c downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors;
        final ConcatMapInnerObserver inner;
        final h<? super T, ? extends e> mapper;
        final int prefetch;
        final io.reactivex.internal.a.e<T> queue;
        d upstream;

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
            this.queue = new SpscArrayQueue(r6);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
            this.inner.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.disposed == true) goto L7;
            if (this.active == true) goto L39;
            if (this.errorMode == ErrorMode.BOUNDARY) goto L14;
        L17:
            boolean r0 = this.done;
            T r1 = this.queue.poll();
            if (r1 != null) goto L20;
            boolean r4 = true;
        L21:
            if (r0 == false) goto L28;
            if (r4 == false) goto L28;
            Throwable r2 = this.errors.terminate();
            c r6 = this.downstream;
            if (r2 == null) goto L26;
            r6.onError(r2);
            return;
        L26:
            r6.onComplete();
            return;
        L28:
            if (r4 == true) goto L39;
            int r3 = this.prefetch;
            int r5 = r3 - (r3 >> 1);
            int r7 = this.consumed + 1;
            if (r7 != r5) goto L32;
            this.consumed = 0;
            this.upstream.request(r5);
        L41:
            e r8 = (e) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r1), "The mapper returned a null CompletableSource"), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
            this.active = true;
            r8.a(this.inner);
        L35:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.queue.clear();
            this.upstream.cancel();
            this.errors.addThrowable(th);
            this.downstream.onError(this.errors.terminate());
            return;
        L32:
            this.consumed = r7;
            goto L41
        L20:
            r4 = false;
            goto L21
        L14:
            if (this.errors.get() == null) goto L17;
            this.queue.clear();
            this.downstream.onError(this.errors.terminate());
            return;
        L39:
            if (decrementAndGet() != 0) goto L6;
            return;
        L7:
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
            this.upstream.cancel();
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

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
            this.inner.dispose();
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
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onNext(T r2) {
            if (this.queue.offer(r2) == false) goto L5;
            drain();
            return;
        L5:
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(this.prefetch);
            return;
        }
    }

    @Override // io.reactivex.a
    public void b(c r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        this.f16889a.a(new ConcatMapCompletableObserver(r6, this.f16890b, this.c, this.d));
    }
}
