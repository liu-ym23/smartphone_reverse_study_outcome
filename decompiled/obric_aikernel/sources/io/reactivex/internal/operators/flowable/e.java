package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class e<K, T> extends yb.a<K, T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final FlowableGroupBy$State<T, K> f9514h;

    protected e(K r10, FlowableGroupBy$State<T, K> r11) {
        super(r10);
        this.f9514h = r11;
    }

    public static <T, K> e<K, T> d(K r10, int r11, FlowableGroupBy$GroupBySubscriber<?, K, T> r12, boolean r13) {
        return new e(r10, new FlowableGroupBy$State(r11, r12, r10, r13));
    }

    @Override // xb.e
    protected void c(tc.c<? super T> r10) {
        this.f9514h.subscribe(r10);
    }

    public void onComplete() {
        this.f9514h.onComplete();
    }

    public void onError(Throwable r10) {
        this.f9514h.onError(r10);
    }

    public void onNext(T r10) {
        this.f9514h.onNext(r10);
    }
}
