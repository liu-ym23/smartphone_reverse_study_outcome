package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableWithLatestFrom<T, U, R> extends io.reactivex.internal.operators.flowable.a<T, R> {
    final io.reactivex.b.c<? super T, ? super U, ? extends R> c;
    final org.a.b<? extends U> d;

    static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements io.reactivex.internal.a.a<T>, org.a.d {
        private static final long serialVersionUID = -312246233408980075L;
        final io.reactivex.b.c<? super T, ? super U, ? extends R> combiner;
        final org.a.c<? super R> downstream;
        final AtomicReference<org.a.d> other;
        final AtomicLong requested;
        final AtomicReference<org.a.d> upstream;

        WithLatestFromSubscriber(org.a.c<? super R> r3, io.reactivex.b.c<? super T, ? super U, ? extends R> r4) {
            org.a.c<? super R> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.c<? super T, ? super U, ? extends R> r6 = (io.reactivex.b.c) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.c.class, "com.obric.memorydata.plugin");
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
            this.other = new AtomicReference();
            this.downstream = r5;
            this.combiner = r6;
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        @Override // org.a.c
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            if (tryOnNext(r3) == true) goto L6;
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin")).request(1);
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r4);
        }

        public void otherError(Throwable r2) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(r2);
        }

        @Override // org.a.d
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }

        public boolean setOther(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            return SubscriptionHelper.setOnce(this.other, r4);
        }

        @Override // io.reactivex.internal.a.a
        public boolean tryOnNext(T r4) {
            U r0 = get();
            if (r0 != null) goto L10;
        L9:
            return false;
        L10:
            Object r5 = io.reactivex.internal.functions.a.a(this.combiner.apply(r4, r0), "The combiner returned a null value");     // Catch: Throwable -> L7
            this.downstream.onNext(r5);
            return true;
        L7:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancel();
            this.downstream.onError(th);
            goto L9
        }
    }

    final class a implements j<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlowableWithLatestFrom f16808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WithLatestFromSubscriber<T, U, R> f16809b;

        a(FlowableWithLatestFrom r1, WithLatestFromSubscriber<T, U, R> r2) {
            this.f16808a = r1;
            this.f16809b = r2;
        }

        @Override // org.a.c
        public void onComplete() {
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.f16809b.otherError(r1);
        }

        @Override // org.a.c
        public void onNext(U r1) {
            this.f16809b.lazySet(r1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (this.f16809b.setOther(r4) == false) goto L6;
            r4.request(Long.MAX_VALUE);
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r3) {
        io.reactivex.subscribers.b r0 = new io.reactivex.subscribers.b((org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin"));
        WithLatestFromSubscriber r4 = new WithLatestFromSubscriber(r0, this.c);
        r0.onSubscribe(r4);
        this.d.subscribe(new a(this, r4));
        this.f16812b.a(r4);
    }
}
