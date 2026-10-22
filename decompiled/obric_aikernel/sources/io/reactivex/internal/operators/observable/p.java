package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
final class p<T, B> extends io.reactivex.observers.b<B> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ObservableWindowBoundarySupplier$WindowBoundaryMainObserver<T, B> f9582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f9583h;

    p(ObservableWindowBoundarySupplier$WindowBoundaryMainObserver<T, B> r10) {
        this.f9582g = r10;
    }

    @Override // xb.o
    public void onComplete() {
        if (this.f9583h == false) goto L5;
        return;
    L5:
        this.f9583h = true;
        this.f9582g.innerComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.f9583h == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.f9583h = true;
        this.f9582g.innerError(r10);
    }

    @Override // xb.o
    public void onNext(B r10) {
        if (this.f9583h == false) goto L5;
        return;
    L5:
        this.f9583h = true;
        dispose();
        this.f9582g.innerNext(this);
    }
}
