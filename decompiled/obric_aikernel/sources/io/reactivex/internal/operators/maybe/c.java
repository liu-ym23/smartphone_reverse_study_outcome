package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
final class c<R> implements r<R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<io.reactivex.disposables.b> f9544c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final j<? super R> f9545g;

    c(AtomicReference<io.reactivex.disposables.b> r10, j<? super R> r11) {
        this.f9544c = r10;
        this.f9545g = r11;
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        this.f9545g.onError(r10);
    }

    @Override // xb.r
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.replace(this.f9544c, r10);
    }

    @Override // xb.r
    public void onSuccess(R r10) {
        this.f9545g.onSuccess(r10);
    }
}
