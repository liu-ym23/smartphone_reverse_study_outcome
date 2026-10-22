package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableSamplePublisher<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<T> f16790b;
    final org.a.b<?> c;
    final boolean d;

    static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        SampleMainEmitLast(org.a.c<? super T> r3, org.a.b<?> r4) {
            super((org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin"), (org.a.b) ZeusTransformUtils.wrapperContextForParams(r4, org.a.b.class, "com.obric.memorydata.plugin"));
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void completion() {
            this.done = true;
            if (this.wip.getAndIncrement() != 0) goto L6;
            emit();
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void run() {
            if (this.wip.getAndIncrement() != 0) goto L10;
        L4:
            boolean r0 = this.done;
            emit();
            if (r0 == true) goto L6;
            if (this.wip.decrementAndGet() != 0) goto L4;
            return;
        L6:
            this.downstream.onComplete();
            return;
        }
    }

    static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(org.a.c<? super T> r3, org.a.b<?> r4) {
            super((org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin"), (org.a.b) ZeusTransformUtils.wrapperContextForParams(r4, org.a.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void completion() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void run() {
            emit();
        }
    }

    static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements j<T>, org.a.d {
        private static final long serialVersionUID = -3517602651313910099L;
        final org.a.c<? super T> downstream;
        final AtomicReference<org.a.d> other;
        final AtomicLong requested;
        final org.a.b<?> sampler;
        org.a.d upstream;

        SamplePublisherSubscriber(org.a.c<? super T> r3, org.a.b<?> r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            org.a.b<?> r6 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r4, org.a.b.class, "com.obric.memorydata.plugin");
            this.requested = new AtomicLong();
            this.other = new AtomicReference();
            this.downstream = r5;
            this.sampler = r6;
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            this.upstream.cancel();
        }

        public void complete() {
            this.upstream.cancel();
            completion();
        }

        abstract void completion();

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

        public void error(Throwable r2) {
            this.upstream.cancel();
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            completion();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r1) {
            lazySet(r1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L8;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            if (this.other.get() != null) goto L9;
            this.sampler.subscribe(new a(this));
            r4.request(Long.MAX_VALUE);
            return;
        L9:
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            return;
        }

        abstract void run();

        void setOther(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.setOnce(this.other, r4, Long.MAX_VALUE);
        }
    }

    static final class a<T> implements j<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SamplePublisherSubscriber<T> f16791a;

        a(SamplePublisherSubscriber<T> r1) {
            this.f16791a = r1;
        }

        @Override // org.a.c
        public void onComplete() {
            this.f16791a.complete();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.f16791a.error(r1);
        }

        @Override // org.a.c
        public void onNext(Object r1) {
            this.f16791a.run();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            this.f16791a.setOther(r4);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        io.reactivex.subscribers.b r0 = new io.reactivex.subscribers.b((org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin"));
        if (this.d == false) goto L5;
        org.a.b<T> r4 = this.f16790b;
        org.a.c<? super T> r1 = new SampleMainEmitLast(r0, this.c);
    L6:
        r4.subscribe(r1);
        return;
    L5:
        r4 = this.f16790b;
        r1 = new SampleMainNoLast(r0, this.c);
        goto L6
    }
}
