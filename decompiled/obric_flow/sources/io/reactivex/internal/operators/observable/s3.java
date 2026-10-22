package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public final class s3 implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableSequenceEqualSingle$EqualCoordinator f17958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.b f17959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17960c;
    public volatile boolean d;
    public Throwable e;

    public s3(ObservableSequenceEqualSingle$EqualCoordinator r5, int r10, int r11) {
        this.f17958a = r5;
        this.f17960c = r10;
        this.f17959b = new io.reactivex.internal.queue.b(r11);
    }

    @Override // mt.u
    public final void onComplete() {
        this.d = true;
        this.f17958a.drain();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.e = r5;
        this.d = true;
        this.f17958a.drain();
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        this.f17959b.offer(r5);
        this.f17958a.drain();
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        this.f17958a.setDisposable(r5, this.f17960c);
    }
}
