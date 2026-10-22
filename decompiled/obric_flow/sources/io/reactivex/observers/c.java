package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import mt.u;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f18177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f18178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18179c;

    public c(u r5) {
        this.f18177a = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f18178b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18178b.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.f18179c == false) goto L5;
        return;
    L5:
        this.f18179c = true;
        Disposable r5 = this.f18178b;
        u r10 = this.f18177a;
        if (r5 != null) goto L25;
        NullPointerException r11 = new NullPointerException("Subscription not set!");
        r10.onSubscribe(EmptyDisposable.INSTANCE);     // Catch: Throwable -> L13
        r10.onError(r11);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(new CompositeException(new Throwable[]{r11, th}));
        return;
    L13:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(new CompositeException(new Throwable[]{r11, th}));
        return;
    L25:
        r10.onComplete();     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(th);
    }

    @Override // mt.u
    public final void onError(Throwable r10) {
        if (this.f18179c == false) goto L6;
        f.k(r10);
        return;
    L6:
        this.f18179c = true;
        Disposable r5 = this.f18178b;
        u r11 = this.f18177a;
        if (r5 != null) goto L18;
        NullPointerException r12 = new NullPointerException("Subscription not set!");
        r11.onSubscribe(EmptyDisposable.INSTANCE);     // Catch: Throwable -> L15
        r11.onError(new CompositeException(new Throwable[]{r10, r12}));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(new CompositeException(new Throwable[]{r10, r12, th}));
        return;
    L15:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(new CompositeException(new Throwable[]{r10, r12, th}));
        return;
    L18:
        if (r10 != null) goto L27;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L27:
        r11.onError(r10);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        if (this.f18179c == false) goto L5;
        return;
    L5:
        Disposable r5 = this.f18178b;
        u r11 = this.f18177a;
        if (r5 != null) goto L16;
        this.f18179c = true;
        NullPointerException r12 = new NullPointerException("Subscription not set!");
        r11.onSubscribe(EmptyDisposable.INSTANCE);     // Catch: Throwable -> L13
        r11.onError(r12);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(new CompositeException(new Throwable[]{r12, th}));
        return;
    L13:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(new CompositeException(new Throwable[]{r12, th}));
        return;
    L16:
        if (r10 != null) goto L42;
        NullPointerException r13 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.f18178b.dispose();     // Catch: Throwable -> L21
        onError(r13);
        return;
    L21:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        onError(new CompositeException(new Throwable[]{r13, th}));
        return;
    L42:
        r11.onNext(r10);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.f18178b.dispose();     // Catch: Throwable -> L31
        onError(th);
        return;
    L31:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        onError(new CompositeException(new Throwable[]{th, th}));
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.f18178b, r5) == false) goto L18;
        this.f18178b = r5;
        this.f18177a.onSubscribe(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.f18179c = true;
        r5.dispose();     // Catch: Throwable -> L11
        f.k(th);
        return;
    L11:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(new CompositeException(new Throwable[]{th, th}));
        return;
    }
}
