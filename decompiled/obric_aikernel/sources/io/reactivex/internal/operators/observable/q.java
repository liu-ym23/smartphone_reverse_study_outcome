package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class q<T, R> implements xb.o<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ObservableZip$ZipCoordinator<T, R> f9584c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final io.reactivex.internal.queue.a<T> f9585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    volatile boolean f9586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Throwable f9587i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final AtomicReference<io.reactivex.disposables.b> f9588j;

    q(ObservableZip$ZipCoordinator<T, R> r10, int r11) {
        this.f9588j = new AtomicReference();
        this.f9584c = r10;
        this.f9585g = new io.reactivex.internal.queue.a(r11);
    }

    public void a() {
        DisposableHelper.dispose(this.f9588j);
    }

    @Override // xb.o
    public void onComplete() {
        this.f9586h = true;
        this.f9584c.drain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.f9587i = r10;
        this.f9586h = true;
        this.f9584c.drain();
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.f9585g.offer(r10);
        this.f9584c.drain();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this.f9588j, r10);
    }
}
