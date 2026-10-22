package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class f2 extends mt.n implements rt.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f17780a;

    public f2(Object r5) {
        this.f17780a = r5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f17780a;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        ObservableScalarXMap$ScalarDisposable r10 = new ObservableScalarXMap$ScalarDisposable(r5, this.f17780a);
        r5.onSubscribe(r10);
        r10.run();
    }
}
