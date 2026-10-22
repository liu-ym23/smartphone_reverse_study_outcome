package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class n4 extends io.reactivex.observers.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableWindowBoundary$WindowBoundaryMainObserver f17882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17883c;

    public n4(ObservableWindowBoundary$WindowBoundaryMainObserver r5) {
        this.f17882b = r5;
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.f17883c == false) goto L5;
        return;
    L5:
        this.f17883c = true;
        this.f17882b.innerComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.f17883c == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.f17883c = true;
        this.f17882b.innerError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.f17883c == false) goto L5;
        return;
    L5:
        this.f17882b.innerNext();
    }
}
