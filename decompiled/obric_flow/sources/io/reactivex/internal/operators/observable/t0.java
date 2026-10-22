package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f17970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f17971c;

    public /* synthetic */ t0() {
        this.f17969a = 0;
    }

    private final void a(Object r5) {
    }

    private final void b(Object r5) {
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f17969a) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        this.f17971c.dispose();
        return;
    L6:
        this.f17971c.dispose();
        return;
    L8:
        this.f17971c.dispose();
        return;
    L10:
        this.f17971c.dispose();
        return;
    L12:
        Disposable r5 = this.f17971c;
        this.f17971c = EmptyComponent.INSTANCE;
        this.f17970b = EmptyComponent.asObserver();
        r5.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        switch(this.f17969a) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        return this.f17971c.isDisposed();
    L7:
        return this.f17971c.isDisposed();
    L9:
        return this.f17971c.isDisposed();
    L11:
        return this.f17971c.isDisposed();
    L13:
        return this.f17971c.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17969a) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        ((mt.b) this.f17970b).onComplete();
        return;
    L6:
        mt.l r5 = mt.l.f20169b;
        mt.u r10 = (mt.u) this.f17970b;
        r10.onNext(r5);
        r10.onComplete();
        return;
    L8:
        ((mt.u) this.f17970b).onComplete();
        return;
    L10:
        ((mt.u) this.f17970b).onComplete();
        return;
    L12:
        mt.u r11 = (mt.u) this.f17970b;
        this.f17971c = EmptyComponent.INSTANCE;
        this.f17970b = EmptyComponent.asObserver();
        r11.onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17969a) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        ((mt.b) this.f17970b).onError(r5);
        return;
    L6:
        mt.l r10 = mt.l.a(r5);
        mt.u r11 = (mt.u) this.f17970b;
        r11.onNext(r10);
        r11.onComplete();
        return;
    L8:
        ((mt.u) this.f17970b).onError(r5);
        return;
    L10:
        ((mt.u) this.f17970b).onError(r5);
        return;
    L12:
        mt.u r12 = (mt.u) this.f17970b;
        this.f17971c = EmptyComponent.INSTANCE;
        this.f17970b = EmptyComponent.asObserver();
        r12.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17969a) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L11;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        io.reactivex.internal.functions.e.d(r5, "value is null");
        mt.l r10 = new mt.l(r5);
        ((mt.u) this.f17970b).onNext(r10);
        return;
    L7:
        ((mt.u) this.f17970b).onNext(r5);
        return;
    L9:
        ((mt.u) this.f17970b).onNext(r5);
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17969a) {
            case 0: goto L17;
            case 1: goto L13;
            case 2: goto L10;
            case 3: goto L7;
            default: goto L4;
        };
    L4:
        this.f17971c = r5;
        ((mt.b) this.f17970b).onSubscribe(this);
        return;
    L10:
        this.f17971c = r5;
        ((mt.u) this.f17970b).onSubscribe(this);
        return;
    L7:
        if (DisposableHelper.validate(this.f17971c, r5) == false) goto L20;
        this.f17971c = r5;
        ((mt.u) this.f17970b).onSubscribe(this);
        return;
    L20:
        return;
    L13:
        if (DisposableHelper.validate(this.f17971c, r5) == false) goto L21;
        this.f17971c = r5;
        ((mt.u) this.f17970b).onSubscribe(this);
        return;
    L21:
        return;
    L17:
        if (DisposableHelper.validate(this.f17971c, r5) == false) goto L22;
        this.f17971c = r5;
        ((mt.u) this.f17970b).onSubscribe(this);
        return;
    }

    public /* synthetic */ t0(Object r5, int r10) {
        this.f17969a = r10;
        this.f17970b = r5;
    }
}
