package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class j2 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f17829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.o f17830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.o f17831c;
    public final Callable d;
    public Disposable e;

    public j2(mt.u r5, pt.o r10, pt.o r11, Callable r12) {
        this.f17829a = r5;
        this.f17830b = r10;
        this.f17831c = r11;
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
        mt.u r5 = this.f17829a;
        Object r10 = this.d.call();     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r10, "The onComplete ObservableSource returned is null");     // Catch: Throwable -> L6
        r5.onNext((mt.s) r10);
        r5.onComplete();
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r5.onError(th);
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        mt.u r10 = this.f17829a;
        Object r11 = this.f17831c.apply(r5);     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r11, "The onError ObservableSource returned is null");     // Catch: Throwable -> L6
        r10.onNext((mt.s) r11);
        r10.onComplete();
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r10.onError(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        mt.u r10 = this.f17829a;
        Object r11 = this.f17830b.apply(r5);     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r11, "The onNext ObservableSource returned is null");     // Catch: Throwable -> L6
        r10.onNext((mt.s) r11);
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r10.onError(th);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.e, r5) == false) goto L6;
        this.e = r5;
        this.f17829a.onSubscribe(this);
        return;
    }
}
