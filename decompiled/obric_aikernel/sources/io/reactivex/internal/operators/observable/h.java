package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
final class h<T> implements xb.o<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ObservableSampleWithObservable$SampleMainObserver<T> f9565c;

    h(ObservableSampleWithObservable$SampleMainObserver<T> r10) {
        this.f9565c = r10;
    }

    @Override // xb.o
    public void onComplete() {
        this.f9565c.complete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.f9565c.error(r10);
    }

    @Override // xb.o
    public void onNext(Object r10) {
        this.f9565c.run();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        this.f9565c.setOther(r10);
    }
}
