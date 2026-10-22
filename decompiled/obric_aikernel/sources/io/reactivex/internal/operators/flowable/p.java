package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class p<T, B> extends io.reactivex.subscribers.a<B> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> f9521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f9522h;

    p(FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> r10) {
        this.f9521g = r10;
    }

    @Override // tc.c
    public void onComplete() {
        if (this.f9522h == false) goto L5;
        return;
    L5:
        this.f9522h = true;
        this.f9521g.innerComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.f9522h == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.f9522h = true;
        this.f9521g.innerError(r10);
    }

    @Override // tc.c
    public void onNext(B r10) {
        if (this.f9522h == false) goto L5;
        return;
    L5:
        this.f9521g.innerNext();
    }
}
