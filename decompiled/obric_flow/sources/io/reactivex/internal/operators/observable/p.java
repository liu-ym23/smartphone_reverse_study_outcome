package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f17900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable f17902c;
    public Collection d;
    public int e;
    public Disposable f;

    public p(mt.u r5, int r10, Callable r11) {
        this.f17900a = r5;
        this.f17901b = r10;
        this.f17902c = r11;
    }

    public final boolean a() {
        Object r5 = this.f17902c.call();     // Catch: Throwable -> L5
        io.reactivex.internal.functions.e.d(r5, "Empty buffer supplied");     // Catch: Throwable -> L5
        this.d = (Collection) r5;
        return true;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d = null;
        Disposable r10 = this.f;
        mt.u r11 = this.f17900a;
        if (r10 != null) goto L9;
        EmptyDisposable.error(th, r11);
        return false;
    L9:
        r10.dispose();
        r11.onError(th);
        return false;
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
        Collection r5 = this.d;
        if (r5 == null) goto L9;
        this.d = null;
        boolean r10 = r5.isEmpty();
        mt.u r11 = this.f17900a;
        if (r10 == true) goto L7;
        r11.onNext(r5);
    L7:
        r11.onComplete();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.d = null;
        this.f17900a.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        Collection r10 = this.d;
        if (r10 == null) goto L8;
        r10.add(r5);
        int r11 = this.e + 1;
        this.e = r11;
        if (r11 < this.f17901b) goto L9;
        this.f17900a.onNext(r10);
        this.e = 0;
        a();
        return;
    L9:
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.f, r5) == false) goto L6;
        this.f = r5;
        this.f17900a.onSubscribe(this);
        return;
    }
}
