package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableSkipUntil$SkipUntilMainSubscriber<T> extends AtomicInteger implements rt.a, zu.d {
    private static final long serialVersionUID = -6270983465606289181L;
    final zu.c downstream;
    final AtomicThrowable error;
    volatile boolean gate;
    final FlowableSkipUntil$SkipUntilMainSubscriber<T>.OtherSubscriber other;
    final AtomicLong requested;
    final AtomicReference<zu.d> upstream;

    public final class OtherSubscriber extends AtomicReference<zu.d> implements mt.g {
        private static final long serialVersionUID = -5592042965931999169L;
        final /* synthetic */ FlowableSkipUntil$SkipUntilMainSubscriber this$0;

        public OtherSubscriber(FlowableSkipUntil$SkipUntilMainSubscriber r5) {
            this.this$0 = r5;
        }

        @Override // zu.c
        public void onComplete() {
            this.this$0.gate = true;
        }

        @Override // zu.c
        public void onError(Throwable r5) {
            SubscriptionHelper.cancel(this.this$0.upstream);
            FlowableSkipUntil$SkipUntilMainSubscriber r10 = this.this$0;
            com.lynx.tasm.behavior.ui.utils.p.x(r10.downstream, r5, r10, r10.error);
        }

        @Override // zu.c
        public void onNext(Object r5) {
            this.this$0.gate = true;
            get().cancel();
        }

        @Override // zu.c
        public void onSubscribe(zu.d r5) {
            SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
        }
    }

    public FlowableSkipUntil$SkipUntilMainSubscriber(zu.c r5) {
        this.downstream = r5;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
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
        if (tryOnNext(r5) == true) goto L6;
        this.upstream.get().request(1);
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r5);
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r5);
    }

    @Override // rt.a
    public boolean tryOnNext(T r5) {
        if (this.gate == false) goto L6;
        com.lynx.tasm.behavior.ui.utils.p.z(this.downstream, r5, this, this.error);
        return true;
    L6:
        return false;
    }
}
