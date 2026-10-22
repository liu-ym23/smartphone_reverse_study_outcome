package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f17738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f17739c;
    public Disposable d;
    public boolean e;
    public final Object f;

    public /* synthetic */ c0(Object r5, Object r10, pt.b r11, int r12) {
        this.f17737a = r12;
        this.f = r5;
        this.f17738b = r11;
        this.f17739c = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f17737a) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        this.d.dispose();
        return;
    L6:
        this.d.dispose();
        return;
    L8:
        this.d.dispose();
        return;
    L10:
        this.d.dispose();
        return;
    L12:
        this.d.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        switch(this.f17737a) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        return this.d.isDisposed();
    L7:
        return this.d.isDisposed();
    L9:
        return this.d.isDisposed();
    L11:
        return this.d.isDisposed();
    L13:
        return this.d.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17737a) {
            case 0: goto L34;
            case 1: goto L29;
            case 2: goto L21;
            case 3: goto L10;
            default: goto L5;
        };
    L5:
        if (this.e == true) goto L38;
        this.e = true;
        ((mt.u) this.f).onComplete();
        return;
    L38:
        return;
    L10:
        if (this.e == true) goto L40;
        this.e = true;
        Object r5 = this.f17738b;
        this.f17738b = null;
        if (r5 != null) goto L15;
        r5 = this.f17739c;
    L15:
        mt.b0 r10 = (mt.b0) this.f;
        if (r5 == null) goto L18;
        r10.onSuccess(r5);
        return;
    L18:
        r10.onError(new NoSuchElementException());
        return;
    L40:
        return;
    L21:
        if (this.e == true) goto L42;
        this.e = true;
        Object r11 = this.f17739c;
        this.f17739c = null;
        mt.j r12 = (mt.j) this.f;
        if (r11 == null) goto L26;
        r12.onSuccess(r11);
        return;
    L26:
        r12.onComplete();
        return;
    L42:
        return;
    L29:
        if (this.e == true) goto L43;
        this.e = true;
        Object r13 = this.f17739c;
        ((mt.b0) this.f).onSuccess(r13);
        return;
    L43:
        return;
    L34:
        if (this.e == true) goto L44;
        this.e = true;
        Object r14 = this.f17739c;
        mt.u r15 = (mt.u) this.f;
        r15.onNext(r14);
        r15.onComplete();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17737a) {
            case 0: goto L25;
            case 1: goto L20;
            case 2: goto L15;
            case 3: goto L10;
            default: goto L5;
        };
    L5:
        if (this.e == false) goto L7;
        wn.f.k(r5);
        return;
    L7:
        this.e = true;
        ((mt.u) this.f).onError(r5);
        return;
    L10:
        if (this.e == false) goto L12;
        wn.f.k(r5);
        return;
    L12:
        this.e = true;
        ((mt.b0) this.f).onError(r5);
        return;
    L15:
        if (this.e == false) goto L17;
        wn.f.k(r5);
        return;
    L17:
        this.e = true;
        this.f17739c = null;
        ((mt.j) this.f).onError(r5);
        return;
    L20:
        if (this.e == false) goto L22;
        wn.f.k(r5);
        return;
    L22:
        this.e = true;
        ((mt.b0) this.f).onError(r5);
        return;
    L25:
        if (this.e == false) goto L27;
        wn.f.k(r5);
        return;
    L27:
        this.e = true;
        ((mt.u) this.f).onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        switch(this.f17737a) {
            case 0: goto L48;
            case 1: goto L40;
            case 2: goto L30;
            case 3: goto L22;
            default: goto L4;
        };
    L4:
        mt.u r5 = (mt.u) this.f;
        Iterator r11 = (Iterator) this.f17738b;
        if (this.e == false) goto L59;
        return;
    L59:
        Object r12 = r11.next();     // Catch: Throwable -> L18
        io.reactivex.internal.functions.e.d(r12, "The iterator returned a null value");     // Catch: Throwable -> L18
        Object r13 = ((pt.c) this.f17739c).apply(r10, r12);     // Catch: Throwable -> L16
        io.reactivex.internal.functions.e.d(r13, "The zipper function returned a null value");     // Catch: Throwable -> L16
        r5.onNext(r13);
        if (r11.hasNext() == true) goto L67;
        this.e = true;
        this.d.dispose();
        r5.onComplete();
        return;
    L67:
        return;
    L14:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.e = true;
        this.d.dispose();
        r5.onError(th);
        return;
    L16:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.e = true;
        this.d.dispose();
        r5.onError(th);
        return;
    L18:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.e = true;
        this.d.dispose();
        r5.onError(th);
        return;
    L22:
        if (this.e == false) goto L25;
        return;
    L25:
        if (this.f17738b == null) goto L27;
        this.e = true;
        this.d.dispose();
        IllegalArgumentException r14 = new IllegalArgumentException("Sequence contains more than one element!");
        ((mt.b0) this.f).onError(r14);
        return;
    L27:
        this.f17738b = r10;
        return;
    L30:
        if (this.e == true) goto L74;
        Object r15 = this.f17739c;
        if (r15 != null) goto L57;
        this.f17739c = r10;
        return;
    L57:
        Object r16 = ((pt.c) this.f17738b).apply(r15, r10);     // Catch: Throwable -> L36
        io.reactivex.internal.functions.e.d(r16, "The reducer returned a null value");     // Catch: Throwable -> L36
        this.f17739c = r16;     // Catch: Throwable -> L36
        return;
    L36:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d.dispose();
        onError(th);
        return;
    L74:
        return;
    L40:
        if (this.e == true) goto L77;
        ((pt.b) this.f17738b).accept(this.f17739c, r10);     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        this.d.dispose();
        onError(th);
        return;
    L77:
        return;
    L48:
        if (this.e == true) goto L79;
        ((pt.b) this.f17738b).accept(this.f17739c, r10);     // Catch: Throwable -> L52
        return;
    L52:
        th = move-exception;
        this.d.dispose();
        onError(th);
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17737a) {
            case 0: goto L21;
            case 1: goto L17;
            case 2: goto L13;
            case 3: goto L9;
            default: goto L5;
        };
    L5:
        if (DisposableHelper.validate(this.d, r5) == false) goto L24;
        this.d = r5;
        ((mt.u) this.f).onSubscribe(this);
        return;
    L24:
        return;
    L9:
        if (DisposableHelper.validate(this.d, r5) == false) goto L25;
        this.d = r5;
        ((mt.b0) this.f).onSubscribe(this);
        return;
    L25:
        return;
    L13:
        if (DisposableHelper.validate(this.d, r5) == false) goto L26;
        this.d = r5;
        ((mt.j) this.f).onSubscribe(this);
        return;
    L26:
        return;
    L17:
        if (DisposableHelper.validate(this.d, r5) == false) goto L27;
        this.d = r5;
        ((mt.b0) this.f).onSubscribe(this);
        return;
    L27:
        return;
    L21:
        if (DisposableHelper.validate(this.d, r5) == false) goto L28;
        this.d = r5;
        ((mt.u) this.f).onSubscribe(this);
        return;
    }

    public c0(mt.b0 r5, Object r10) {
        this.f17737a = 3;
        this.f = r5;
        this.f17739c = r10;
    }

    public c0(mt.j r5, pt.c r10) {
        this.f17737a = 2;
        this.f = r5;
        this.f17738b = r10;
    }

    public c0(mt.u r5, Iterator r10, pt.c r11) {
        this.f17737a = 4;
        this.f = r5;
        this.f17738b = r10;
        this.f17739c = r11;
    }
}
