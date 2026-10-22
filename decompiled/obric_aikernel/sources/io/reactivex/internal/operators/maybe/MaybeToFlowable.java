package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import xb.e;
import xb.j;
import xb.k;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeToFlowable<T> extends e<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final k<T> f9539g;

    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements j<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        io.reactivex.disposables.b upstream;

        MaybeToFlowableSubscriber(tc.c<? super T> r10) {
            super(r10);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // xb.j
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xb.j
        public void onError(Throwable r10) {
            this.downstream.onError(r10);
        }

        @Override // xb.j
        public void onSubscribe(io.reactivex.disposables.b r10) {
            if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
            this.upstream = r10;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // xb.j
        public void onSuccess(T r10) {
            complete(r10);
        }
    }

    public MaybeToFlowable(k<T> r10) {
        this.f9539g = r10;
    }

    @Override // xb.e
    protected void c(tc.c<? super T> r10) {
        this.f9539g.a(new MaybeToFlowableSubscriber(r10));
    }
}
