package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
final class i<T> implements xb.o<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ObservableSequenceEqual$EqualCoordinator<T> f9566c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final io.reactivex.internal.queue.a<T> f9567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f9568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    volatile boolean f9569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Throwable f9570j;

    i(ObservableSequenceEqual$EqualCoordinator<T> r10, int r11, int r12) {
        this.f9566c = r10;
        this.f9568h = r11;
        this.f9567g = new io.reactivex.internal.queue.a(r12);
    }

    @Override // xb.o
    public void onComplete() {
        this.f9569i = true;
        this.f9566c.drain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.f9570j = r10;
        this.f9569i = true;
        this.f9566c.drain();
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.f9567g.offer(r10);
        this.f9566c.drain();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        this.f9566c.setDisposable(r10, this.f9568h);
    }
}
