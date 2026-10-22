package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableTakeUntil$TakeUntilMainSubscriber<T> extends AtomicInteger implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -4945480365982832967L;
    final tc.c<? super T> downstream;
    final AtomicThrowable error;
    final FlowableTakeUntil$TakeUntilMainSubscriber<T>.OtherSubscriber other;
    final AtomicLong requested;
    final AtomicReference<tc.d> upstream;

    final class OtherSubscriber extends AtomicReference<tc.d> implements xb.g<Object> {
        private static final long serialVersionUID = -3592821756711087922L;
        final /* synthetic */ FlowableTakeUntil$TakeUntilMainSubscriber this$0;

        OtherSubscriber(FlowableTakeUntil$TakeUntilMainSubscriber r10) {
            this.this$0 = r10;
        }

        @Override // tc.c
        public void onComplete() {
            SubscriptionHelper.cancel(this.this$0.upstream);
            FlowableTakeUntil$TakeUntilMainSubscriber r10 = this.this$0;
            io.reactivex.internal.util.e.a(r10.downstream, r10, r10.error);
        }

        @Override // tc.c
        public void onError(Throwable r10) {
            SubscriptionHelper.cancel(this.this$0.upstream);
            FlowableTakeUntil$TakeUntilMainSubscriber r11 = this.this$0;
            io.reactivex.internal.util.e.c(r11.downstream, r10, r11, r11.error);
        }

        @Override // tc.c
        public void onNext(Object r10) {
            SubscriptionHelper.cancel(this);
            onComplete();
        }

        @Override // xb.g, tc.c
        public void onSubscribe(tc.d r10) {
            SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
        }
    }

    FlowableTakeUntil$TakeUntilMainSubscriber(tc.c<? super T> r10) {
        this.downstream = r10;
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
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
        io.reactivex.internal.util.e.e(this.downstream, r10, this, this.error);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }
}
