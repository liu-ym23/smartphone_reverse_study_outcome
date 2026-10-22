package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
final class j<T> implements xb.o<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ObservableSequenceEqualSingle$EqualCoordinator<T> f9571c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final io.reactivex.internal.queue.a<T> f9572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f9573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    volatile boolean f9574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Throwable f9575j;

    j(ObservableSequenceEqualSingle$EqualCoordinator<T> r10, int r11, int r12) {
        this.f9571c = r10;
        this.f9573h = r11;
        this.f9572g = new io.reactivex.internal.queue.a(r12);
    }

    @Override // xb.o
    public void onComplete() {
        this.f9574i = true;
        this.f9571c.drain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.f9575j = r10;
        this.f9574i = true;
        this.f9571c.drain();
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.f9572g.offer(r10);
        this.f9571c.drain();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        this.f9571c.setDisposable(r10, this.f9573h);
    }
}
