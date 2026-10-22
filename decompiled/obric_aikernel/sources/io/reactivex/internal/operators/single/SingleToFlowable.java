package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import tc.c;
import xb.e;
import xb.r;
import xb.s;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleToFlowable<T> extends e<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final s<? extends T> f9594g;

    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements r<T> {
        private static final long serialVersionUID = 187782011903685568L;
        b upstream;

        SingleToFlowableObserver(c<? super T> r10) {
            super(r10);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // xb.r
        public void onError(Throwable r10) {
            this.downstream.onError(r10);
        }

        @Override // xb.r
        public void onSubscribe(b r10) {
            if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
            this.upstream = r10;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // xb.r
        public void onSuccess(T r10) {
            complete(r10);
        }
    }

    public SingleToFlowable(s<? extends T> r10) {
        this.f9594g = r10;
    }

    @Override // xb.e
    public void c(c<? super T> r10) {
        this.f9594g.a(new SingleToFlowableObserver(r10));
    }
}
