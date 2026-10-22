package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public final class q3 implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableSequenceEqual$EqualCoordinator f17925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.b f17926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17927c;
    public volatile boolean d;
    public Throwable e;

    public q3(ObservableSequenceEqual$EqualCoordinator r5, int r10, int r11) {
        this.f17925a = r5;
        this.f17927c = r10;
        this.f17926b = new io.reactivex.internal.queue.b(r11);
    }

    @Override // mt.u
    public final void onComplete() {
        this.d = true;
        this.f17925a.drain();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.e = r5;
        this.d = true;
        this.f17925a.drain();
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        this.f17926b.offer(r5);
        this.f17925a.drain();
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        this.f17925a.setDisposable(r5, this.f17927c);
    }
}
