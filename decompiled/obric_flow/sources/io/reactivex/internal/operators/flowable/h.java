package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements mt.u, zu.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.g f17660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f17661b;

    public h(mt.g r5) {
        this.f17660a = r5;
    }

    @Override // zu.d
    public final void cancel() {
        this.f17661b.dispose();
    }

    @Override // mt.u
    public final void onComplete() {
        this.f17660a.onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.f17660a.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        this.f17660a.onNext(r5);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        this.f17661b = r5;
        this.f17660a.onSubscribe(this);
    }

    @Override // zu.d
    public final void request(long r5) {
    }
}
