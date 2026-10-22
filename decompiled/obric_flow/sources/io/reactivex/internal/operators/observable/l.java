package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.b0 f17846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.p f17847c;
    public Disposable d;
    public boolean e;

    public /* synthetic */ l(mt.b0 r5, pt.p r10, int r11) {
        this.f17845a = r11;
        this.f17846b = r5;
        this.f17847c = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f17845a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.d.dispose();
        return;
    L6:
        this.d.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        switch(this.f17845a) {
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
        switch(this.f17845a) {
            case 0: goto L9;
            default: goto L5;
        };
    L5:
        if (this.e == true) goto L13;
        this.e = true;
        Boolean r5 = Boolean.FALSE;
        this.f17846b.onSuccess(r5);
        return;
    L13:
        return;
    L9:
        if (this.e == true) goto L14;
        this.e = true;
        Boolean r10 = Boolean.TRUE;
        this.f17846b.onSuccess(r10);
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17845a) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (this.e == false) goto L7;
        wn.f.k(r5);
        return;
    L7:
        this.e = true;
        this.f17846b.onError(r5);
        return;
    L10:
        if (this.e == false) goto L12;
        wn.f.k(r5);
        return;
    L12:
        this.e = true;
        this.f17846b.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17845a) {
            case 0: goto L14;
            default: goto L5;
        };
    L5:
        if (this.e == true) goto L28;
        if (this.f17847c.test(r5) == false) goto L26;
        this.e = true;
        this.d.dispose();
        Boolean r10 = Boolean.TRUE;
        this.f17846b.onSuccess(r10);
        return;
    L26:
        return;
    L10:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d.dispose();
        onError(th);
        return;
    L28:
        return;
    L14:
        if (this.e == true) goto L31;
        if (this.f17847c.test(r5) == true) goto L29;
        this.e = true;
        this.d.dispose();
        Boolean r11 = Boolean.FALSE;
        this.f17846b.onSuccess(r11);
        return;
    L29:
        return;
    L19:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d.dispose();
        onError(th);
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17845a) {
            case 0: goto L9;
            default: goto L5;
        };
    L5:
        if (DisposableHelper.validate(this.d, r5) == false) goto L12;
        this.d = r5;
        this.f17846b.onSubscribe(this);
        return;
    L12:
        return;
    L9:
        if (DisposableHelper.validate(this.d, r5) == false) goto L13;
        this.d = r5;
        this.f17846b.onSubscribe(this);
        return;
    }
}
