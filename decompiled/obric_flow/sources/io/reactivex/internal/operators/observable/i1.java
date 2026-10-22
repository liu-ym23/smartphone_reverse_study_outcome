package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class i1 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.u f17812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.o f17813c;
    public Disposable d;

    public /* synthetic */ i1(mt.u r5, pt.o r10, int r11) {
        this.f17811a = r11;
        this.f17812b = r5;
        this.f17813c = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f17811a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.d.dispose();
        return;
    L6:
        this.d.dispose();
        this.d = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        switch(this.f17811a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.d.isDisposed();
    L7:
        return this.d.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17811a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f17812b.onComplete();
        return;
    L6:
        Disposable r5 = this.d;
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (r5 == r10) goto L11;
        this.d = r10;
        this.f17812b.onComplete();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17811a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        mt.u r10 = this.f17812b;
        Object r11 = this.f17813c.apply(r5);     // Catch: Throwable -> L9
        if (r11 != null) goto L8;
        NullPointerException r12 = new NullPointerException("The supplied value is null");
        r12.initCause(r5);
        r10.onError(r12);
        return;
    L8:
        r10.onNext(r11);
        r10.onComplete();
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r10.onError(new CompositeException(new Throwable[]{r5, th}));
        return;
    L12:
        Disposable r13 = this.d;
        DisposableHelper r14 = DisposableHelper.DISPOSED;
        if (r13 != r14) goto L15;
        wn.f.k(r5);
        return;
    L15:
        this.d = r14;
        this.f17812b.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17811a) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        this.f17812b.onNext(r5);
        return;
    L7:
        if (this.d == DisposableHelper.DISPOSED) goto L30;
        Iterator r10 = ((Iterable) this.f17813c.apply(r5)).iterator();     // Catch: Throwable -> L18
    L21:
        if (r10.hasNext() == false) goto L31;
        Object r11 = r10.next();     // Catch: Throwable -> L14
        io.reactivex.internal.functions.e.d(r11, "The iterator returned a null value");     // Catch: Throwable -> L14
        this.f17812b.onNext(r11);
    L14:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d.dispose();
        onError(th);
        return;
    L31:
        return;
    L16:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d.dispose();
        onError(th);
        return;
    L18:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d.dispose();
        onError(th);
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17811a) {
            case 0: goto L9;
            default: goto L5;
        };
    L5:
        if (DisposableHelper.validate(this.d, r5) == false) goto L12;
        this.d = r5;
        this.f17812b.onSubscribe(this);
        return;
    L12:
        return;
    L9:
        if (DisposableHelper.validate(this.d, r5) == false) goto L13;
        this.d = r5;
        this.f17812b.onSubscribe(this);
        return;
    }
}
