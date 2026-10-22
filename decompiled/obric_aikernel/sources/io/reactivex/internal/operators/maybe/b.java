package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
final class b<R> implements r<R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<io.reactivex.disposables.b> f9542c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final r<? super R> f9543g;

    b(AtomicReference<io.reactivex.disposables.b> r10, r<? super R> r11) {
        this.f9542c = r10;
        this.f9543g = r11;
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        this.f9543g.onError(r10);
    }

    @Override // xb.r
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.replace(this.f9542c, r10);
    }

    @Override // xb.r
    public void onSuccess(R r10) {
        this.f9543g.onSuccess(r10);
    }
}
