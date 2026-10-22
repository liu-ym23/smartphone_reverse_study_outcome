package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends io.reactivex.observers.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f17948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17949c;

    public s(t r5) {
        this.f17948b = r5;
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.f17949c == false) goto L5;
        return;
    L5:
        this.f17949c = true;
        this.f17948b.t();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.f17949c == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.f17949c = true;
        this.f17948b.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.f17949c == false) goto L5;
        return;
    L5:
        this.f17949c = true;
        dispose();
        this.f17948b.t();
    }
}
