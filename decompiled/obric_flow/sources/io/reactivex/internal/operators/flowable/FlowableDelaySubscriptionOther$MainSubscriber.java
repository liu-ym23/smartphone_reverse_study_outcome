package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableDelaySubscriptionOther$MainSubscriber<T> extends AtomicLong implements mt.g, zu.d {
    private static final long serialVersionUID = 2259811067697317255L;
    final zu.c downstream;
    final zu.b main;
    final FlowableDelaySubscriptionOther$MainSubscriber<T>.OtherSubscriber other;
    final AtomicReference<zu.d> upstream;

    public final class OtherSubscriber extends AtomicReference<zu.d> implements mt.g {
        private static final long serialVersionUID = -3892798459447644106L;
        final /* synthetic */ FlowableDelaySubscriptionOther$MainSubscriber this$0;

        public OtherSubscriber(FlowableDelaySubscriptionOther$MainSubscriber r5) {
            this.this$0 = r5;
        }

        @Override // zu.c
        public void onComplete() {
            if (get() == SubscriptionHelper.CANCELLED) goto L6;
            this.this$0.next();
            return;
        }

        @Override // zu.c
        public void onError(Throwable r5) {
            if (get() == SubscriptionHelper.CANCELLED) goto L5;
            this.this$0.downstream.onError(r5);
            return;
        L5:
            wn.f.k(r5);
        }

        @Override // zu.c
        public void onNext(Object r5) {
            zu.d r10 = get();
            SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
            if (r10 == r11) goto L6;
            lazySet(r11);
            r10.cancel();
            this.this$0.next();
            return;
        }

        @Override // zu.c
        public void onSubscribe(zu.d r5) {
            if (SubscriptionHelper.setOnce(this, r5) == false) goto L6;
            r5.request(Long.MAX_VALUE);
            return;
        }
    }

    public FlowableDelaySubscriptionOther$MainSubscriber(zu.c r5, zu.b r10) {
        this.downstream = r5;
        this.main = r10;
        this.other = new OtherSubscriber(this);
        this.upstream = new AtomicReference();
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        SubscriptionHelper.cancel(this.upstream);
    }

    public void next() {
        this.main.subscribe(this);
    }

    @Override // zu.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this, r5);
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        SubscriptionHelper.deferredRequest(this.upstream, this, r5);
        return;
    }
}
