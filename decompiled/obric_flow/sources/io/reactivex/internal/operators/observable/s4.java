package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class s4 extends io.reactivex.observers.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableWindowBoundarySupplier$WindowBoundaryMainObserver f17961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17962c;

    public s4(ObservableWindowBoundarySupplier$WindowBoundaryMainObserver r5) {
        this.f17961b = r5;
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.f17962c == false) goto L5;
        return;
    L5:
        this.f17962c = true;
        this.f17961b.innerComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.f17962c == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.f17962c = true;
        this.f17961b.innerError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.f17962c == false) goto L5;
        return;
    L5:
        this.f17962c = true;
        dispose();
        this.f17961b.innerNext(this);
    }
}
