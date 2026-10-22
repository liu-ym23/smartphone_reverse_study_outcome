package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f17951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17952c;
    public final Object d;
    public Object e;

    public s0(mt.j r5) {
        this.f17950a = 1;
        this.d = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f17950a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f17951b.dispose();
        return;
    L6:
        this.f17951b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        switch(this.f17950a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f17951b.isDisposed();
    L7:
        return this.f17951b.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17950a) {
            case 0: goto L13;
            default: goto L5;
        };
    L5:
        if (this.f17952c == true) goto L18;
        this.f17952c = true;
        Object r5 = this.e;
        this.e = null;
        mt.j r10 = (mt.j) this.d;
        if (r5 != null) goto L10;
        r10.onComplete();
        return;
    L10:
        r10.onSuccess(r5);
        return;
    L18:
        return;
    L13:
        if (this.f17952c == true) goto L19;
        this.f17952c = true;
        ((mt.u) this.d).onComplete();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17950a) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (this.f17952c == false) goto L7;
        wn.f.k(r5);
        return;
    L7:
        this.f17952c = true;
        ((mt.j) this.d).onError(r5);
        return;
    L10:
        if (this.f17952c == false) goto L12;
        wn.f.k(r5);
        return;
    L12:
        this.f17952c = true;
        ((mt.u) this.d).onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17950a) {
            case 0: goto L13;
            default: goto L5;
        };
    L5:
        if (this.f17952c == false) goto L8;
        return;
    L8:
        if (this.e == null) goto L10;
        this.f17952c = true;
        this.f17951b.dispose();
        IllegalArgumentException r10 = new IllegalArgumentException("Sequence contains more than one element!");
        ((mt.j) this.d).onError(r10);
        return;
    L10:
        this.e = r5;
        return;
    L13:
        if (this.f17952c == true) goto L15;
        Object r11 = ((pt.o) this.e).apply(r5);     // Catch: Throwable -> L31
        io.reactivex.internal.functions.e.d(r11, "The selector returned a null Notification");     // Catch: Throwable -> L31
        mt.l r12 = (mt.l) r11;     // Catch: Throwable -> L31
        Object r13 = r12.f20170a;     // Catch: Throwable -> L31
        if (NotificationLite.isError(r13) == false) goto L23;
        this.f17951b.dispose();
        onError(r12.b());
        return;
    L23:
        if (r13 != null) goto L25;
        this.f17951b.dispose();
        onComplete();
        return;
    L25:
        if (r13 != null) goto L27;
    L29:
        r13 = null;
    L30:
        ((mt.u) this.d).onNext(r13);
        return;
    L27:
        if (NotificationLite.isError(r13) == true) goto L29;
    L31:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.f17951b.dispose();
        onError(th);
        return;
    L15:
        if ((r5 instanceof mt.l) == false) goto L38;
        mt.l r14 = (mt.l) r5;
        if (NotificationLite.isError(r14.f20170a) == false) goto L39;
        wn.f.k(r14.b());
        return;
    L39:
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17950a) {
            case 0: goto L9;
            default: goto L5;
        };
    L5:
        if (DisposableHelper.validate(this.f17951b, r5) == false) goto L12;
        this.f17951b = r5;
        ((mt.j) this.d).onSubscribe(this);
        return;
    L12:
        return;
    L9:
        if (DisposableHelper.validate(this.f17951b, r5) == false) goto L13;
        this.f17951b = r5;
        ((mt.u) this.d).onSubscribe(this);
        return;
    }

    public s0(mt.u r5, pt.o r10) {
        this.f17950a = 0;
        this.d = r5;
        this.e = r10;
    }
}
