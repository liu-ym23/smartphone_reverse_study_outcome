package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableTimeoutTimed<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final long c;
    final TimeUnit d;
    final u e;
    final org.a.b<? extends T> f;

    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements b, j<T> {
        private static final long serialVersionUID = 3764492702657003550L;
        long consumed;
        final org.a.c<? super T> downstream;
        org.a.b<? extends T> fallback;
        final AtomicLong index;
        final SequentialDisposable task;
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<org.a.d> upstream;
        final u.c worker;

        TimeoutFallbackSubscriber(org.a.c<? super T> r3, long r4, TimeUnit r6, u.c r7, org.a.b<? extends T> r8) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            org.a.b<? extends T> r9 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r8, org.a.b.class, "com.obric.memorydata.plugin");
            super(true);
            this.downstream = r5;
            this.timeout = r4;
            this.unit = r6;
            this.worker = r7;
            this.fallback = r9;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
            this.index = new AtomicLong();
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.a.d
        public void cancel() {
            super.cancel();
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r6) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r6);
            this.worker.dispose();
            return;
        L5:
            io.reactivex.d.a.a(r6);
        }

        @Override // org.a.c
        public void onNext(T r8) {
            long r0 = this.index.get();
            if (r0 == Long.MAX_VALUE) goto L9;
            long r5 = r0 + 1;
            if (this.index.compareAndSet(r0, r5) == false) goto L10;
            ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.task.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();
            this.consumed++;
            this.downstream.onNext(r8);
            startTimeout(r5);
            return;
        L10:
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.setOnce(this.upstream, r4) == false) goto L6;
            setSubscription(r4);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void onTimeout(long r4) {
            if (this.index.compareAndSet(r4, Long.MAX_VALUE) == false) goto L9;
            SubscriptionHelper.cancel(this.upstream);
            long r5 = this.consumed;
            if (r5 == 0) goto L7;
            produced(r5);
        L7:
            org.a.b<? extends T> r6 = this.fallback;
            this.fallback = null;
            r6.subscribe(new a(this.downstream, this));
            this.worker.dispose();
            return;
        }

        void startTimeout(long r4) {
            this.task.replace(this.worker.a(new c(r4, this), this.timeout, this.unit));
        }
    }

    static final class TimeoutSubscriber<T> extends AtomicLong implements b, j<T>, org.a.d {
        private static final long serialVersionUID = 3764492702657003550L;
        final org.a.c<? super T> downstream;
        final AtomicLong requested;
        final SequentialDisposable task;
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<org.a.d> upstream;
        final u.c worker;

        TimeoutSubscriber(org.a.c<? super T> r3, long r4, TimeUnit r6, u.c r7) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.timeout = r4;
            this.unit = r6;
            this.worker = r7;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r5) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r5);
            this.worker.dispose();
            return;
        L5:
            io.reactivex.d.a.a(r5);
        }

        @Override // org.a.c
        public void onNext(T r6) {
            long r0 = get();
            if (r0 == Long.MAX_VALUE) goto L9;
            long r2 = 1 + r0;
            if (compareAndSet(r0, r2) == false) goto L10;
            ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.task.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();
            this.downstream.onNext(r6);
            startTimeout(r2);
            return;
        L10:
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r4);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void onTimeout(long r4) {
            if (compareAndSet(r4, Long.MAX_VALUE) == false) goto L6;
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(new TimeoutException(ExceptionHelper.a(this.timeout, this.unit)));
            this.worker.dispose();
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }

        void startTimeout(long r4) {
            this.task.replace(this.worker.a(new c(r4, this), this.timeout, this.unit));
        }
    }

    static final class a<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final org.a.c<? super T> f16797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SubscriptionArbiter f16798b;

        a(org.a.c<? super T> r3, SubscriptionArbiter r4) {
            this.f16797a = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.f16798b = r4;
        }

        @Override // org.a.c
        public void onComplete() {
            this.f16797a.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.f16797a.onError(r1);
        }

        @Override // org.a.c
        public void onNext(T r1) {
            this.f16797a.onNext(r1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            this.f16798b.setSubscription(r4);
        }
    }

    interface b {
        void onTimeout(long r1);
    }

    static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f16799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f16800b;

        c(long r3, b r5) {
            b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
            this.f16800b = r3;
            this.f16799a = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16799a.onTimeout(this.f16800b);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r11) {
        org.a.c r12 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r11, org.a.c.class, "com.obric.memorydata.plugin");
        if (this.f != null) goto L5;
        TimeoutSubscriber r6 = new TimeoutSubscriber(r12, this.c, this.d, this.e.a());
        r12.onSubscribe(r6);
        r6.startTimeout(0);
        this.f16812b.a(r6);
        return;
    L5:
        TimeoutFallbackSubscriber r9 = new TimeoutFallbackSubscriber(r12, this.c, this.d, this.e.a(), this.f);
        r12.onSubscribe(r9);
        r9.startTimeout(0);
        this.f16812b.a(r9);
    }
}
