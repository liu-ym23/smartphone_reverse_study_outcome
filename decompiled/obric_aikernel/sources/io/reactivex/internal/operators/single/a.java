package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
final class a<R> implements j<R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<b> f9596c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final j<? super R> f9597g;

    a(AtomicReference<b> r10, j<? super R> r11) {
        this.f9596c = r10;
        this.f9597g = r11;
    }

    @Override // xb.j
    public void onComplete() {
        this.f9597g.onComplete();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.f9597g.onError(r10);
    }

    @Override // xb.j
    public void onSubscribe(b r10) {
        DisposableHelper.replace(this.f9596c, r10);
    }

    @Override // xb.j
    public void onSuccess(R r10) {
        this.f9597g.onSuccess(r10);
    }
}
