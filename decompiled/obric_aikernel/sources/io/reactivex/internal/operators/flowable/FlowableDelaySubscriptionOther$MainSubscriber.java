package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableDelaySubscriptionOther$MainSubscriber<T> extends AtomicLong implements xb.g<T>, tc.d {
    private static final long serialVersionUID = 2259811067697317255L;
    final tc.c<? super T> downstream;
    final tc.b<? extends T> main;
    final FlowableDelaySubscriptionOther$MainSubscriber<T>.OtherSubscriber other;
    final AtomicReference<tc.d> upstream;

    final class OtherSubscriber extends AtomicReference<tc.d> implements xb.g<Object> {
        private static final long serialVersionUID = -3892798459447644106L;
        final /* synthetic */ FlowableDelaySubscriptionOther$MainSubscriber this$0;

        OtherSubscriber(FlowableDelaySubscriptionOther$MainSubscriber r10) {
            this.this$0 = r10;
        }

        @Override // tc.c
        public void onComplete() {
            if (get() == SubscriptionHelper.CANCELLED) goto L6;
            this.this$0.next();
            return;
        }

        @Override // tc.c
        public void onError(Throwable r10) {
            if (get() == SubscriptionHelper.CANCELLED) goto L5;
            this.this$0.downstream.onError(r10);
            return;
        L5:
            dc.a.n(r10);
        }

        @Override // tc.c
        public void onNext(Object r10) {
            tc.d r11 = get();
            SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
            if (r11 == r12) goto L6;
            lazySet(r12);
            r11.cancel();
            this.this$0.next();
            return;
        }

        @Override // xb.g, tc.c
        public void onSubscribe(tc.d r10) {
            if (SubscriptionHelper.setOnce(this, r10) == false) goto L6;
            r10.request(Long.MAX_VALUE);
            return;
        }
    }

    FlowableDelaySubscriptionOther$MainSubscriber(tc.c<? super T> r10, tc.b<? extends T> r11) {
        this.downstream = r10;
        this.main = r11;
        this.other = new OtherSubscriber(this);
        this.upstream = new AtomicReference();
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        SubscriptionHelper.cancel(this.upstream);
    }

    void next() {
        this.main.subscribe(this);
    }

    @Override // tc.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this, r10);
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        SubscriptionHelper.deferredRequest(this.upstream, this, r10);
        return;
    }
}
