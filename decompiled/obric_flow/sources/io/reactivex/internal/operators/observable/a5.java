package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class a5 implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableZip$ZipCoordinator f17714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.b f17715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f17716c;
    public Throwable d;
    public final AtomicReference e;

    public a5(ObservableZip$ZipCoordinator r5, int r10) {
        this.e = new AtomicReference();
        this.f17714a = r5;
        this.f17715b = new io.reactivex.internal.queue.b(r10);
    }

    @Override // mt.u
    public final void onComplete() {
        this.f17716c = true;
        this.f17714a.drain();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.d = r5;
        this.f17716c = true;
        this.f17714a.drain();
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        this.f17715b.offer(r5);
        this.f17714a.drain();
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.e, r5);
    }
}
