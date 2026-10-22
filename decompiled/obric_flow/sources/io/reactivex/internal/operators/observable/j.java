package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.u f17823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.p f17824c;
    public Disposable d;
    public boolean e;

    public /* synthetic */ j(mt.u r5, pt.p r10, int r11) {
        this.f17822a = r11;
        this.f17823b = r5;
        this.f17824c = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f17822a) {
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
        switch(this.f17822a) {
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
        switch(this.f17822a) {
            case 0: goto L20;
            case 1: goto L16;
            case 2: goto L13;
            case 3: goto L10;
            default: goto L5;
        };
    L13:
        this.f17823b.onComplete();
        return;
    L5:
        if (this.e == true) goto L24;
        this.e = true;
        this.f17823b.onComplete();
        return;
    L24:
        return;
    L10:
        if (this.e == true) goto L25;
        this.e = true;
        this.f17823b.onComplete();
        return;
    L25:
        return;
    L16:
        if (this.e == true) goto L26;
        this.e = true;
        Boolean r5 = Boolean.FALSE;
        mt.u r10 = this.f17823b;
        r10.onNext(r5);
        r10.onComplete();
        return;
    L26:
        return;
    L20:
        if (this.e == true) goto L27;
        this.e = true;
        Boolean r11 = Boolean.TRUE;
        mt.u r12 = this.f17823b;
        r12.onNext(r11);
        r12.onComplete();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17822a) {
            case 0: goto L22;
            case 1: goto L17;
            case 2: goto L14;
            case 3: goto L10;
            default: goto L5;
        };
    L14:
        this.f17823b.onError(r5);
        return;
    L5:
        if (this.e == false) goto L7;
        wn.f.k(r5);
        return;
    L7:
        this.e = true;
        this.f17823b.onError(r5);
        return;
    L10:
        if (this.e == true) goto L12;
        this.e = true;
        this.f17823b.onError(r5);
        return;
    L12:
        wn.f.k(r5);
        return;
    L17:
        if (this.e == false) goto L19;
        wn.f.k(r5);
        return;
    L19:
        this.e = true;
        this.f17823b.onError(r5);
        return;
    L22:
        if (this.e == false) goto L24;
        wn.f.k(r5);
        return;
    L24:
        this.e = true;
        this.f17823b.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17822a) {
            case 0: goto L43;
            case 1: goto L34;
            case 2: goto L24;
            case 3: goto L16;
            default: goto L5;
        };
    L24:
        boolean r10 = this.e;
        mt.u r11 = this.f17823b;
        if (r10 == false) goto L53;
        r11.onNext(r5);
        return;
    L53:
        if (this.f17824c.test(r5) == true) goto L68;
        this.e = true;
        r11.onNext(r5);
        return;
    L68:
        return;
    L30:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d.dispose();
        r11.onError(th);
        return;
    L5:
        if (this.e == true) goto L63;
        boolean r12 = this.f17824c.test(r5);     // Catch: Throwable -> L12
        mt.u r13 = this.f17823b;
        if (r12 == true) goto L11;
        this.e = true;
        this.d.dispose();
        r13.onComplete();
        return;
    L11:
        r13.onNext(r5);
        return;
    L12:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d.dispose();
        onError(th);
        return;
    L63:
        return;
    L16:
        if (this.e == true) goto L64;
        mt.u r14 = this.f17823b;
        r14.onNext(r5);
        if (this.f17824c.test(r5) == false) goto L65;
        this.e = true;
        this.d.dispose();
        r14.onComplete();
        return;
    L65:
        return;
    L21:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d.dispose();
        onError(th);
        return;
    L64:
        return;
    L34:
        if (this.e == true) goto L72;
        if (this.f17824c.test(r5) == false) goto L70;
        this.e = true;
        this.d.dispose();
        Boolean r15 = Boolean.TRUE;
        mt.u r16 = this.f17823b;
        r16.onNext(r15);
        r16.onComplete();
        return;
    L70:
        return;
    L39:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d.dispose();
        onError(th);
        return;
    L72:
        return;
    L43:
        if (this.e == true) goto L75;
        if (this.f17824c.test(r5) == true) goto L73;
        this.e = true;
        this.d.dispose();
        Boolean r17 = Boolean.FALSE;
        mt.u r18 = this.f17823b;
        r18.onNext(r17);
        r18.onComplete();
        return;
    L73:
        return;
    L48:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d.dispose();
        onError(th);
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17822a) {
            case 0: goto L21;
            case 1: goto L17;
            case 2: goto L13;
            case 3: goto L9;
            default: goto L5;
        };
    L5:
        if (DisposableHelper.validate(this.d, r5) == false) goto L24;
        this.d = r5;
        this.f17823b.onSubscribe(this);
        return;
    L24:
        return;
    L9:
        if (DisposableHelper.validate(this.d, r5) == false) goto L25;
        this.d = r5;
        this.f17823b.onSubscribe(this);
        return;
    L25:
        return;
    L13:
        if (DisposableHelper.validate(this.d, r5) == false) goto L26;
        this.d = r5;
        this.f17823b.onSubscribe(this);
        return;
    L26:
        return;
    L17:
        if (DisposableHelper.validate(this.d, r5) == false) goto L27;
        this.d = r5;
        this.f17823b.onSubscribe(this);
        return;
    L27:
        return;
    L21:
        if (DisposableHelper.validate(this.d, r5) == false) goto L28;
        this.d = r5;
        this.f17823b.onSubscribe(this);
        return;
    }
}
