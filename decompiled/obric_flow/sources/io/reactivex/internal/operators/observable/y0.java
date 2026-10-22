package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f18075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f18077c;
    public final boolean d;
    public Disposable e;
    public long f;
    public boolean g;

    public y0(mt.u r5, long r10, Object r11, boolean r12) {
        this.f18075a = r5;
        this.f18076b = r10;
        this.f18077c = r11;
        this.d = r12;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.e.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.e.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.g == true) goto L13;
        this.g = true;
        mt.u r5 = this.f18075a;
        Object r10 = this.f18077c;
        if (r10 == null) goto L7;
    L9:
        if (r10 == null) goto L11;
        r5.onNext(r10);
    L11:
        r5.onComplete();
        return;
    L7:
        if (this.d == false) goto L9;
        r5.onError(new NoSuchElementException());
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.g == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.g = true;
        this.f18075a.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.g == false) goto L5;
        return;
    L5:
        long r10 = this.f;
        if (r10 != this.f18076b) goto L9;
        this.g = true;
        this.e.dispose();
        mt.u r11 = this.f18075a;
        r11.onNext(r5);
        r11.onComplete();
        return;
    L9:
        this.f = r10 + 1;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.e, r5) == false) goto L6;
        this.e = r5;
        this.f18075a.onSubscribe(this);
        return;
    }
}
