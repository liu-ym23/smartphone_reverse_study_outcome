package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableTakeUntil$TakeUntilMainSubscriber<T> extends AtomicInteger implements mt.g, zu.d {
    private static final long serialVersionUID = -4945480365982832967L;
    final zu.c downstream;
    final AtomicThrowable error;
    final FlowableTakeUntil$TakeUntilMainSubscriber<T>.OtherSubscriber other;
    final AtomicLong requested;
    final AtomicReference<zu.d> upstream;

    public final class OtherSubscriber extends AtomicReference<zu.d> implements mt.g {
        private static final long serialVersionUID = -3592821756711087922L;
        final /* synthetic */ FlowableTakeUntil$TakeUntilMainSubscriber this$0;

        public OtherSubscriber(FlowableTakeUntil$TakeUntilMainSubscriber r5) {
            this.this$0 = r5;
        }

        @Override // zu.c
        public void onComplete() {
            SubscriptionHelper.cancel(this.this$0.upstream);
            FlowableTakeUntil$TakeUntilMainSubscriber r5 = this.this$0;
            com.lynx.tasm.behavior.ui.utils.p.v(r5.downstream, r5, r5.error);
        }

        @Override // zu.c
        public void onError(Throwable r5) {
            SubscriptionHelper.cancel(this.this$0.upstream);
            FlowableTakeUntil$TakeUntilMainSubscriber r10 = this.this$0;
            com.lynx.tasm.behavior.ui.utils.p.x(r10.downstream, r5, r10, r10.error);
        }

        @Override // zu.c
        public void onNext(Object r5) {
            SubscriptionHelper.cancel(this);
            onComplete();
        }

        @Override // zu.c
        public void onSubscribe(zu.d r5) {
            SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
        }
    }

    public FlowableTakeUntil$TakeUntilMainSubscriber(zu.c r5) {
        this.downstream = r5;
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
        this.other = new OtherSubscriber(this);
        this.error = new AtomicThrowable();
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // zu.c
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        com.lynx.tasm.behavior.ui.utils.p.v(this.downstream, this, this.error);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        SubscriptionHelper.cancel(this.other);
        com.lynx.tasm.behavior.ui.utils.p.x(this.downstream, r5, this, this.error);
    }

    @Override // zu.c
    public void onNext(T r5) {
        com.lynx.tasm.behavior.ui.utils.p.z(this.downstream, r5, this, this.error);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r5);
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r5);
    }
}
