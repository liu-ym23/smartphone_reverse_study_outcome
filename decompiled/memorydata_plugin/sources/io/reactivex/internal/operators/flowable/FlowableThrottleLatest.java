package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableThrottleLatest<T> extends a<T, T> {
    final long c;
    final TimeUnit d;
    final u e;
    final boolean f;

    static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final org.a.c<? super T> downstream;
        final boolean emitLast;
        long emitted;
        Throwable error;
        final AtomicReference<T> latest;
        final AtomicLong requested;
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        org.a.d upstream;
        final u.c worker;

        ThrottleLatestSubscriber(org.a.c<? super T> r3, long r4, TimeUnit r6, u.c r7, boolean r8) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.timeout = r4;
            this.unit = r6;
            this.worker = r7;
            this.emitLast = r8;
            this.latest = new AtomicReference();
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.latest.lazySet(null);
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            AtomicReference<T> r0 = this.latest;
            AtomicLong r1 = this.requested;
            org.a.c<? super T> r2 = this.downstream;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            boolean r5 = this.done;
            if (r5 == false) goto L19;
            if (this.error == null) goto L19;
            r0.lazySet(null);
            Throwable r3 = this.error;
        L15:
            r2.onError(r3);
        L16:
            this.worker.dispose();
            return;
        L19:
            if (r0.get() != null) goto L21;
            boolean r7 = true;
        L23:
            if (r5 == true) goto L24;
            if (r7 == true) goto L35;
            if (this.timerRunning == false) goto L45;
            if (this.timerFired == true) goto L45;
        L42:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L45:
            T r6 = r0.getAndSet(null);
            long r8 = this.emitted;
            if (r8 == r1.get()) goto L48;
            r2.onNext(r6);
            this.emitted = r8 + 1;
            this.timerFired = false;
            this.timerRunning = true;
            this.worker.a(this, this.timeout, this.unit);
            goto L7
        L48:
            this.upstream.cancel();
            r3 = new MissingBackpressureException("Could not emit value due to lack of requests");
            goto L15
        L35:
            if (this.timerFired == false) goto L42;
            this.timerRunning = false;
            this.timerFired = false;
            goto L42
        L24:
            if (r7 == false) goto L26;
        L31:
            r0.lazySet(null);
        L32:
            r2.onComplete();
            goto L16
        L26:
            if (this.emitLast == false) goto L31;
            T r9 = r0.getAndSet(null);
            long r10 = this.emitted;
            if (r10 == r1.get()) goto L30;
            this.emitted = r10 + 1;
            r2.onNext(r9);
            goto L32
        L30:
            r3 = new MissingBackpressureException("Could not emit final value due to lack of requests");
            goto L15
        L21:
            r7 = false;
            goto L23
        L8:
            r0.lazySet(null);
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onNext(T r2) {
            this.latest.set(r2);
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

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            drain();
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r9) {
        org.a.c r1 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r9, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new ThrottleLatestSubscriber(r1, this.c, this.d, this.e.a(), this.f));
    }
}
