package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.a.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.j;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableConcatMapSingle<T, R> extends g<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g<T> f16892b;
    final h<? super T, ? extends z<? extends R>> c;
    final ErrorMode d;
    final int e;

    static final class ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements j<T>, d {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final c<? super R> downstream;
        long emitted;
        final ErrorMode errorMode;
        final AtomicThrowable errors;
        final ConcatMapSingleObserver<R> inner;
        R item;
        final h<? super T, ? extends z<? extends R>> mapper;
        final int prefetch;
        final e<T> queue;
        final AtomicLong requested;
        volatile int state;
        d upstream;

        static final class ConcatMapSingleObserver<R> extends AtomicReference<b> implements x<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapSingleSubscriber<?, R> parent;

            ConcatMapSingleObserver(ConcatMapSingleSubscriber<?, R> r1) {
                this.parent = r1;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.x
            public void onError(Throwable r1) {
                this.parent.innerError(r1);
            }

            @Override // io.reactivex.x
            public void onSubscribe(b r3) {
                DisposableHelper.replace(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.reactivex.x
            public void onSuccess(R r1) {
                this.parent.innerSuccess(r1);
            }
        }

        ConcatMapSingleSubscriber(c<? super R> r3, h<? super T, ? extends z<? extends R>> r4, int r5, ErrorMode r6) {
            c<? super R> r7 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends z<? extends R>> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.mapper = r8;
            this.prefetch = r5;
            this.errorMode = r6;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
            this.inner = new ConcatMapSingleObserver(this);
            this.queue = new SpscArrayQueue(r5);
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.inner.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            this.item = null;
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            c<? super R> r0 = this.downstream;
            ErrorMode r1 = this.errorMode;
            e<T> r2 = this.queue;
            AtomicThrowable r3 = this.errors;
            AtomicLong r4 = this.requested;
            int r5 = this.prefetch;
            int r6 = r5 - (r5 >> 1);
            int r7 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            int r8 = this.state;
            if (r3.get() == null) goto L20;
            if (r1 == ErrorMode.IMMEDIATE) goto L16;
            if (r1 != ErrorMode.BOUNDARY) goto L20;
            if (r8 != 0) goto L20;
        L16:
            r2.clear();
            this.item = null;
        L17:
            r0.onError(r3.terminate());
            return;
        L20:
            if (r8 == 0) goto L21;
            if (r8 != 2) goto L47;
            long r11 = this.emitted;
            if (r11 == r4.get()) goto L47;
            R r9 = this.item;
            this.item = null;
            r0.onNext(r9);
            this.emitted = r11 + 1;
            this.state = 0;
        L47:
            r7 = addAndGet(-r7);
            if (r7 != 0) goto L7;
            return;
        L21:
            boolean r10 = this.done;
            T r12 = r2.poll();
            if (r12 != null) goto L24;
            boolean r13 = true;
        L25:
            if (r10 == false) goto L32;
            if (r13 == false) goto L32;
            Throwable r15 = r3.terminate();
            if (r15 != null) goto L30;
            r0.onComplete();
            return;
        L30:
            r0.onError(r15);
            return;
        L32:
            if (r13 == true) goto L47;
            int r14 = this.consumed + 1;
            if (r14 != r6) goto L37;
            this.consumed = 0;
            this.upstream.request(r6);
        L50:
            z r16 = (z) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r12), "The mapper returned a null SingleSource"), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
            this.state = 1;
            r16.a(this.inner);
        L40:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            r2.clear();
            r3.addThrowable(th);
            goto L17
        L37:
            this.consumed = r14;
            goto L50
        L24:
            r13 = false;
            goto L25
        L8:
            r2.clear();
            this.item = null;
            goto L47
        }

        void innerError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.errorMode == ErrorMode.END) goto L7;
            this.upstream.cancel();
        L7:
            this.state = 0;
            drain();
        }

        void innerSuccess(R r1) {
            this.item = r1;
            this.state = 2;
            drain();
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
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
            this.inner.dispose();
        L7:
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onNext(T r2) {
            if (this.queue.offer(r2) == true) goto L6;
            this.upstream.cancel();
            onError(new MissingBackpressureException("queue full?!"));
            return;
        L6:
            drain();
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

        @Override // org.a.d
        public void request(long r2) {
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
        }
    }

    @Override // io.reactivex.g
    public void a(c<? super R> r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        this.f16892b.a(new ConcatMapSingleSubscriber(r6, this.c, this.e, this.d));
    }
}
