package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableSkipUntil$SkipUntilMainSubscriber<T> extends AtomicInteger implements bc.a<T>, tc.d {
    private static final long serialVersionUID = -6270983465606289181L;
    final tc.c<? super T> downstream;
    final AtomicThrowable error;
    volatile boolean gate;
    final FlowableSkipUntil$SkipUntilMainSubscriber<T>.OtherSubscriber other;
    final AtomicLong requested;
    final AtomicReference<tc.d> upstream;

    final class OtherSubscriber extends AtomicReference<tc.d> implements xb.g<Object> {
        private static final long serialVersionUID = -5592042965931999169L;
        final /* synthetic */ FlowableSkipUntil$SkipUntilMainSubscriber this$0;

        OtherSubscriber(FlowableSkipUntil$SkipUntilMainSubscriber r10) {
            this.this$0 = r10;
        }

        @Override // tc.c
        public void onComplete() {
            this.this$0.gate = true;
        }

        @Override // tc.c
        public void onError(Throwable r10) {
            SubscriptionHelper.cancel(this.this$0.upstream);
            FlowableSkipUntil$SkipUntilMainSubscriber r11 = this.this$0;
            io.reactivex.internal.util.e.c(r11.downstream, r10, r11, r11.error);
        }

        @Override // tc.c
        public void onNext(Object r10) {
            this.this$0.gate = true;
            get().cancel();
        }

        @Override // xb.g, tc.c
        public void onSubscribe(tc.d r10) {
            SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
        }
    }

    FlowableSkipUntil$SkipUntilMainSubscriber(tc.c<? super T> r10) {
        this.downstream = r10;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.other = new OtherSubscriber(this);
        this.error = new AtomicThrowable();
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // tc.c
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        io.reactivex.internal.util.e.a(this.downstream, this, this.error);
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        SubscriptionHelper.cancel(this.other);
        io.reactivex.internal.util.e.c(this.downstream, r10, this, this.error);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (tryOnNext(r10) == true) goto L6;
        this.upstream.get().request(1);
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }

    @Override // bc.a
    public boolean tryOnNext(T r10) {
        if (this.gate == false) goto L6;
        io.reactivex.internal.util.e.e(this.downstream, r10, this, this.error);
        return true;
    L6:
        return false;
    }
}
