package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends io.reactivex.subscribers.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber f17674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17675c;

    public z(FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber r5) {
        this.f17674b = r5;
    }

    @Override // zu.c
    public final void onComplete() {
        if (this.f17675c == false) goto L5;
        return;
    L5:
        this.f17675c = true;
        this.f17674b.innerComplete();
    }

    @Override // zu.c
    public final void onError(Throwable r5) {
        if (this.f17675c == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.f17675c = true;
        this.f17674b.innerError(r5);
    }

    @Override // zu.c
    public final void onNext(Object r5) {
        if (this.f17675c == false) goto L5;
        return;
    L5:
        this.f17675c = true;
        dispose();
        this.f17674b.innerNext(this);
    }
}
