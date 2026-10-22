package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.e;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableOnBackpressureBuffer<T> extends a<T, T> {
    final int c;
    final boolean d;
    final boolean e;
    final io.reactivex.b.a f;

    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements j<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final org.a.c<? super T> downstream;
        Throwable error;
        final io.reactivex.b.a onOverflow;
        boolean outputFused;
        final e<T> queue;
        final AtomicLong requested;
        org.a.d upstream;

        BackpressureBufferSubscriber(org.a.c<? super T> r3, int r4, boolean r5, boolean r6, io.reactivex.b.a r7) {
            org.a.c<? super T> r8 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.a r9 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r7, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
            this.requested = new AtomicLong();
            this.downstream = r8;
            this.onOverflow = r9;
            this.delayError = r6;
            if (r5 == false) goto L5;
            e<T> r10 = new io.reactivex.internal.queue.a(r4);
        L6:
            this.queue = r10;
            return;
        L5:
            r10 = new SpscArrayQueue(r4);
            goto L6
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L10;
            this.cancelled = true;
            this.upstream.cancel();
            if (this.outputFused == false) goto L7;
            return;
        L7:
            if (getAndIncrement() != 0) goto L12;
            this.queue.clear();
            return;
        L12:
            return;
        }

        boolean checkTerminated(boolean r3, boolean r4, org.a.c<? super T> r5) {
            org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
            if (this.cancelled == false) goto L6;
            this.queue.clear();
            return true;
        L6:
            if (r3 == true) goto L8;
            return false;
        L8:
            if (this.delayError == false) goto L15;
            if (r4 == false) goto L24;
            Throwable r2 = this.error;
            if (r2 == null) goto L13;
            r6.onError(r2);
        L14:
            return true;
        L13:
            r6.onComplete();
            goto L14
        L24:
            return false;
        L15:
            Throwable r7 = this.error;
            if (r7 == null) goto L19;
            this.queue.clear();
            r6.onError(r7);
            return true;
        L19:
            if (r4 == false) goto L25;
            r6.onComplete();
            return true;
        L25:
            return false;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) goto L32;
            e<T> r0 = this.queue;
            org.a.c<? super T> r1 = this.downstream;
            int r3 = 1;
        L6:
            if (checkTerminated(this.done, r0.isEmpty(), r1) == true) goto L7;
            long r4 = this.requested.get();
            long r8 = 0;
        L10:
            if (r8 == r4) goto L21;
            boolean r11 = this.done;
            T r12 = r0.poll();
            if (r12 != null) goto L14;
            boolean r13 = true;
        L16:
            if (checkTerminated(r11, r13, r1) == true) goto L17;
            if (r13 == true) goto L21;
            r1.onNext(r12);
            r8 = r8 + 1;
            goto L10
        L17:
            return;
        L14:
            r13 = false;
        L21:
            if (r8 != r4) goto L26;
            if (checkTerminated(this.done, r0.isEmpty(), r1) == false) goto L26;
            return;
        L26:
            if (r8 != 0) goto L28;
        L30:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L6;
            return;
        L28:
            if (r4 == Long.MAX_VALUE) goto L30;
            this.requested.addAndGet(-r8);
            goto L30
        L7:
            return;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            if (this.outputFused == false) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.error = r2;
            this.done = true;
            if (this.outputFused == false) goto L5;
            this.downstream.onError(r2);
            return;
        L5:
            drain();
        }

        @Override // org.a.c
        public void onNext(T r2) {
            if (this.queue.offer(r2) == true) goto L12;
            this.upstream.cancel();
            MissingBackpressureException r3 = new MissingBackpressureException("Buffer is full");
            this.onOverflow.a();     // Catch: Throwable -> L7
        L9:
            onError(r3);
            return;
        L7:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r3.initCause(th);
            goto L9
        L12:
            if (this.outputFused == false) goto L14;
            this.downstream.onNext(null);
            return;
        L14:
            drain();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(Long.MAX_VALUE);
            return;
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            return this.queue.poll();
        }

        @Override // org.a.d
        public void request(long r2) {
            if (this.outputFused == false) goto L5;
            return;
        L5:
            if (SubscriptionHelper.validate(r2) == false) goto L9;
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
            return;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r8) {
        org.a.c r1 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r8, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new BackpressureBufferSubscriber(r1, this.c, this.d, this.e, this.f));
    }
}
