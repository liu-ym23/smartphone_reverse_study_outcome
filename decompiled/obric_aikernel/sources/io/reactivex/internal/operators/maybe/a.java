package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
final class a<T> implements j<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<io.reactivex.disposables.b> f9540c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final j<? super T> f9541g;

    a(AtomicReference<io.reactivex.disposables.b> r10, j<? super T> r11) {
        this.f9540c = r10;
        this.f9541g = r11;
    }

    @Override // xb.j
    public void onComplete() {
        this.f9541g.onComplete();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.f9541g.onError(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.replace(this.f9540c, r10);
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.f9541g.onSuccess(r10);
    }
}
