package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.observers.d f17887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f17889c;
    public final mt.y d;
    public Disposable e;
    public Disposable f;
    public volatile long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f17890h;

    public o0(io.reactivex.observers.d r5, long r10, TimeUnit r11, mt.y r12) {
        this.f17887a = r5;
        this.f17888b = r10;
        this.f17889c = r11;
        this.d = r12;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.e.dispose();
        this.d.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.d.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.f17890h == false) goto L5;
        return;
    L5:
        this.f17890h = true;
        Disposable r5 = this.f;
        if (r5 == null) goto L8;
        r5.dispose();
    L8:
        ObservableDebounceTimed$DebounceEmitter r10 = (ObservableDebounceTimed$DebounceEmitter) r5;
        if (r10 == null) goto L11;
        r10.run();
    L11:
        this.f17887a.onComplete();
        this.d.dispose();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.f17890h == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        Disposable r10 = this.f;
        if (r10 == null) goto L9;
        r10.dispose();
    L9:
        this.f17890h = true;
        this.f17887a.onError(r5);
        this.d.dispose();
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.f17890h == false) goto L5;
        return;
    L5:
        long r10 = this.g + 1;
        this.g = r10;
        Disposable r11 = this.f;
        if (r11 == null) goto L8;
        r11.dispose();
    L8:
        ObservableDebounceTimed$DebounceEmitter r12 = new ObservableDebounceTimed$DebounceEmitter(r5, r10, this);
        this.f = r12;
        r12.setResource(this.d.b(r12, this.f17888b, this.f17889c));
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.e, r5) == false) goto L6;
        this.e = r5;
        this.f17887a.onSubscribe(this);
        return;
    }
}
