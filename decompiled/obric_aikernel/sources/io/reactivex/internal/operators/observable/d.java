package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
final class d<K, T> extends cc.a<K, T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ObservableGroupBy$State<T, K> f9559g;

    protected d(K r10, ObservableGroupBy$State<T, K> r11) {
        super(r10);
        this.f9559g = r11;
    }

    public static <T, K> d<K, T> h(K r10, int r11, ObservableGroupBy$GroupByObserver<?, K, T> r12, boolean r13) {
        return new d(r10, new ObservableGroupBy$State(r11, r12, r10, r13));
    }

    @Override // io.reactivex.Observable
    protected void f(xb.o<? super T> r10) {
        this.f9559g.subscribe(r10);
    }

    public void onComplete() {
        this.f9559g.onComplete();
    }

    public void onError(Throwable r10) {
        this.f9559g.onError(r10);
    }

    public void onNext(T r10) {
        this.f9559g.onNext(r10);
    }
}
