package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends io.reactivex.subscribers.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowableWindowBoundary$WindowBoundaryMainSubscriber f17672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17673c;

    public y(FlowableWindowBoundary$WindowBoundaryMainSubscriber r5) {
        this.f17672b = r5;
    }

    @Override // zu.c
    public final void onComplete() {
        if (this.f17673c == false) goto L5;
        return;
    L5:
        this.f17673c = true;
        this.f17672b.innerComplete();
    }

    @Override // zu.c
    public final void onError(Throwable r5) {
        if (this.f17673c == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.f17673c = true;
        this.f17672b.innerError(r5);
    }

    @Override // zu.c
    public final void onNext(Object r5) {
        if (this.f17673c == false) goto L5;
        return;
    L5:
        this.f17672b.innerNext();
    }
}
