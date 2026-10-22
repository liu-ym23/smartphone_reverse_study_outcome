package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
final class o<T, B> extends io.reactivex.observers.b<B> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ObservableWindowBoundary$WindowBoundaryMainObserver<T, B> f9580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f9581h;

    o(ObservableWindowBoundary$WindowBoundaryMainObserver<T, B> r10) {
        this.f9580g = r10;
    }

    @Override // xb.o
    public void onComplete() {
        if (this.f9581h == false) goto L5;
        return;
    L5:
        this.f9581h = true;
        this.f9580g.innerComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.f9581h == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.f9581h = true;
        this.f9580g.innerError(r10);
    }

    @Override // xb.o
    public void onNext(B r10) {
        if (this.f9581h == false) goto L5;
        return;
    L5:
        this.f9580g.innerNext();
    }
}
