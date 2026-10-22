package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class q<T, B> extends io.reactivex.subscribers.a<B> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber<T, B> f9523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f9524h;

    q(FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber<T, B> r10) {
        this.f9523g = r10;
    }

    @Override // tc.c
    public void onComplete() {
        if (this.f9524h == false) goto L5;
        return;
    L5:
        this.f9524h = true;
        this.f9523g.innerComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.f9524h == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.f9524h = true;
        this.f9523g.innerError(r10);
    }

    @Override // tc.c
    public void onNext(B r10) {
        if (this.f9524h == false) goto L5;
        return;
    L5:
        this.f9524h = true;
        dispose();
        this.f9523g.innerNext(this);
    }
}
