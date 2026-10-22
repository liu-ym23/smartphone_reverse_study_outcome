package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableSampleTimed<T> extends a<T, T> {
    final long c;
    final TimeUnit d;
    final u e;
    final boolean f;

    static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        SampleTimedEmitLast(org.a.c<? super T> r7, long r8, TimeUnit r10, u r11) {
            super((org.a.c) ZeusTransformUtils.wrapperContextForParams(r7, org.a.c.class, "com.obric.memorydata.plugin"), r8, r10, r11);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void complete() {
            emit();
            if (this.wip.decrementAndGet() != 0) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() != 2) goto L8;
            emit();
            if (this.wip.decrementAndGet() != 0) goto L9;
            this.downstream.onComplete();
            return;
        L9:
            return;
        }
    }

    static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(org.a.c<? super T> r7, long r8, TimeUnit r10, u r11) {
            super((org.a.c) ZeusTransformUtils.wrapperContextForParams(r7, org.a.c.class, "com.obric.memorydata.plugin"), r8, r10, r11);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void complete() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = -3517602651313910099L;
        final org.a.c<? super T> downstream;
        final long period;
        final AtomicLong requested;
        final u scheduler;
        final SequentialDisposable timer;
        final TimeUnit unit;
        org.a.d upstream;

        SampleTimedSubscriber(org.a.c<? super T> r3, long r4, TimeUnit r6, u r7) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.requested = new AtomicLong();
            this.timer = new SequentialDisposable();
            this.downstream = r5;
            this.period = r4;
            this.unit = r6;
            this.scheduler = r7;
        }

        @Override // org.a.d
        public void cancel() {
            cancelTimer();
            this.upstream.cancel();
        }

        void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        abstract void complete();

        void emit() {
            T r0 = getAndSet(null);
            if (r0 != null) goto L5;
            return;
        L5:
            if (this.requested.get() == 0) goto L7;
            this.downstream.onNext(r0);
            io.reactivex.internal.util.b.c(this.requested, 1);
            return;
        L7:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }

        @Override // org.a.c
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            cancelTimer();
            this.downstream.onError(r1);
        }

        @Override // org.a.c
        public void onNext(T r1) {
            lazySet(r1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r9) {
            org.a.d r10 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r9, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
            this.upstream = r10;
            this.downstream.onSubscribe(this);
            SequentialDisposable r0 = this.timer;
            u r1 = this.scheduler;
            long r5 = this.period;
            r0.replace(r1.a(this, r5, r5, this.unit));
            r10.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r8) {
        io.reactivex.subscribers.b r1 = new io.reactivex.subscribers.b((org.a.c) ZeusTransformUtils.wrapperContextForParams(r8, org.a.c.class, "com.obric.memorydata.plugin"));
        if (this.f == false) goto L5;
        g<T> r9 = this.f16812b;
        j<? super T> r6 = new SampleTimedEmitLast(r1, this.c, this.d, this.e);
    L6:
        r9.a(r6);
        return;
    L5:
        r9 = this.f16812b;
        r6 = new SampleTimedNoLast(r1, this.c, this.d, this.e);
        goto L6
    }
}
