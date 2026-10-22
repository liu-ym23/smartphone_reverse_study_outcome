package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.NoSuchElementException;
import mt.b0;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f17633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17634c;
    public final Object d;
    public Object e;

    public /* synthetic */ e(Object r5, int r10, Object r11, Object r12) {
        this.f17632a = r10;
        this.f17634c = r5;
        this.d = r11;
        this.e = r12;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f17632a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f17633b.dispose();
        return;
    L6:
        this.f17633b.dispose();
        this.f17633b = DisposableHelper.DISPOSED;
        return;
    L8:
        Disposable r5 = this.f17633b;
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (r5 == r10) goto L19;
        this.f17633b = r10;
        ((pt.a) this.e).run();     // Catch: Throwable -> L13
    L15:
        r5.dispose();
        return;
    L13:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        goto L15
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        switch(this.f17632a) {
            case 0: goto L12;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.f17633b.isDisposed();
    L7:
        if (this.f17633b != DisposableHelper.DISPOSED) goto L9;
        return true;
    L9:
        return false;
    L12:
        return this.f17633b.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17632a) {
            case 0: goto L16;
            case 1: goto L8;
            default: goto L4;
        };
    L4:
        Object r5 = this.e;
        if (r5 == null) goto L20;
        this.e = null;
        ((b0) this.f17634c).onSuccess(r5);
        return;
    L20:
        return;
    L8:
        this.f17633b = DisposableHelper.DISPOSED;
        Object r10 = this.e;
        b0 r11 = (b0) this.f17634c;
        if (r10 == null) goto L11;
        this.e = null;
        r11.onSuccess(r10);
        return;
    L11:
        Object r12 = this.d;
        if (r12 == null) goto L14;
        r11.onSuccess(r12);
        return;
    L14:
        r11.onError(new NoSuchElementException());
        return;
    L16:
        Disposable r13 = this.f17633b;
        DisposableHelper r14 = DisposableHelper.DISPOSED;
        if (r13 == r14) goto L23;
        this.f17633b = r14;
        ((u) this.f17634c).onComplete();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17632a) {
            case 0: goto L11;
            case 1: goto L9;
            default: goto L5;
        };
    L9:
        this.f17633b = DisposableHelper.DISPOSED;
        this.e = null;
        ((b0) this.f17634c).onError(r5);
        return;
    L11:
        Disposable r10 = this.f17633b;
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L14;
        this.f17633b = r11;
        ((u) this.f17634c).onError(r5);
        return;
    L14:
        wn.f.k(r5);
        return;
    L5:
        if (this.e == null) goto L7;
        this.e = null;
        ((b0) this.f17634c).onError(r5);
        return;
    L7:
        wn.f.k(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17632a) {
            case 0: goto L13;
            case 1: goto L11;
            default: goto L4;
        };
    L4:
        Object r10 = this.e;
        if (r10 == null) goto L17;
        Object r11 = ((pt.c) this.d).apply(r10, r5);     // Catch: Throwable -> L8
        io.reactivex.internal.functions.e.d(r11, "The reducer returned a null value");     // Catch: Throwable -> L8
        this.e = r11;     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.f17633b.dispose();
        onError(th);
        return;
    L17:
        return;
    L11:
        this.e = r5;
        return;
    L13:
        ((u) this.f17634c).onNext(r5);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17632a) {
            case 0: goto L12;
            case 1: goto L9;
            default: goto L5;
        };
    L12:
        u r10 = (u) this.f17634c;
        ((pt.g) this.d).accept(r5);     // Catch: Throwable -> L17
        if (DisposableHelper.validate(this.f17633b, r5) == false) goto L24;
        this.f17633b = r5;
        r10.onSubscribe(this);
        return;
    L24:
        return;
    L17:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r5.dispose();
        this.f17633b = DisposableHelper.DISPOSED;
        EmptyDisposable.error(th, r10);
        return;
    L5:
        if (DisposableHelper.validate(this.f17633b, r5) == false) goto L22;
        this.f17633b = r5;
        ((b0) this.f17634c).onSubscribe(this);
        return;
    L22:
        return;
    L9:
        if (DisposableHelper.validate(this.f17633b, r5) == false) goto L23;
        this.f17633b = r5;
        ((b0) this.f17634c).onSubscribe(this);
        return;
    }

    public e(b0 r5, Object r10) {
        this.f17632a = 1;
        this.f17634c = r5;
        this.d = r10;
    }
}
