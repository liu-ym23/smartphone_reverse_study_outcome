package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class c1 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.b0 f17740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17742c;
    public Disposable d;
    public long e;
    public boolean f;

    public c1(mt.b0 r5, long r10, Object r11) {
        this.f17740a = r5;
        this.f17741b = r10;
        this.f17742c = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.d.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.d.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.f == true) goto L9;
        this.f = true;
        mt.b0 r5 = this.f17740a;
        Object r10 = this.f17742c;
        if (r10 == null) goto L7;
        r5.onSuccess(r10);
        return;
    L7:
        r5.onError(new NoSuchElementException());
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.f == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.f = true;
        this.f17740a.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.f == false) goto L5;
        return;
    L5:
        long r10 = this.e;
        if (r10 != this.f17741b) goto L9;
        this.f = true;
        this.d.dispose();
        this.f17740a.onSuccess(r5);
        return;
    L9:
        this.e = r10 + 1;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.d, r5) == false) goto L6;
        this.d = r5;
        this.f17740a.onSubscribe(this);
        return;
    }
}
