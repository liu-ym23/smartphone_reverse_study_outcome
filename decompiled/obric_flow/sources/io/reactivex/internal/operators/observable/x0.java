package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f18049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.g f18050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.g f18051c;
    public final pt.a d;
    public final pt.a e;
    public Disposable f;
    public boolean g;

    public x0(mt.u r5, pt.g r10, pt.g r11, pt.a r12, pt.a r13) {
        this.f18049a = r5;
        this.f18050b = r10;
        this.f18051c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.g == false) goto L15;
        return;
    L15:
        this.d.run();     // Catch: Throwable -> L12
        this.g = true;
        this.f18049a.onComplete();
        this.e.run();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        return;
    L12:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        onError(th);
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.g == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.g = true;
        this.f18051c.accept(r5);     // Catch: Throwable -> L9
    L11:
        this.f18049a.onError(r5);
        this.e.run();     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r5 = new CompositeException(new Throwable[]{r5, th});
        goto L11
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.g == false) goto L11;
        return;
    L11:
        this.f18050b.accept(r5);     // Catch: Throwable -> L8
        this.f18049a.onNext(r5);
        return;
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.f.dispose();
        onError(th);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.f, r5) == false) goto L6;
        this.f = r5;
        this.f18049a.onSubscribe(this);
        return;
    }
}
