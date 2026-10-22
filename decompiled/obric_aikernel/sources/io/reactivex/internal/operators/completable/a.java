package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.b;

/* JADX INFO: loaded from: classes2.dex */
final class a implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<io.reactivex.disposables.b> f9492c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final b f9493g;

    public a(AtomicReference<io.reactivex.disposables.b> r10, b r11) {
        this.f9492c = r10;
        this.f9493g = r11;
    }

    @Override // xb.b
    public void onComplete() {
        this.f9493g.onComplete();
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        this.f9493g.onError(r10);
    }

    @Override // xb.b
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.replace(this.f9492c, r10);
    }
}
