package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f17810c;
    public Disposable d;

    public /* synthetic */ i0(Object r5, int r10) {
        this.f17808a = r10;
        this.f17809b = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f17808a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.d.dispose();
        this.d = DisposableHelper.DISPOSED;
        return;
    L6:
        this.d.dispose();
        return;
    L8:
        this.d.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        switch(this.f17808a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.d.isDisposed();
    L7:
        return this.d.isDisposed();
    L9:
        return this.d.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17808a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.d = DisposableHelper.DISPOSED;
        Long r5 = Long.valueOf(this.f17810c);
        ((mt.b0) this.f17809b).onSuccess(r5);
        return;
    L6:
        ((mt.u) this.f17809b).onComplete();
        return;
    L8:
        Long r10 = Long.valueOf(this.f17810c);
        mt.u r11 = (mt.u) this.f17809b;
        r11.onNext(r10);
        r11.onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17808a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.d = DisposableHelper.DISPOSED;
        ((mt.b0) this.f17809b).onError(r5);
        return;
    L6:
        ((mt.u) this.f17809b).onError(r5);
        return;
    L8:
        ((mt.u) this.f17809b).onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17808a) {
            case 0: goto L11;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f17810c++;
        return;
    L6:
        long r10 = this.f17810c;
        if (r10 == 0) goto L9;
        this.f17810c = r10 - 1;
        return;
    L9:
        ((mt.u) this.f17809b).onNext(r5);
        return;
    L11:
        this.f17810c++;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17808a) {
            case 0: goto L13;
            case 1: goto L9;
            default: goto L5;
        };
    L5:
        if (DisposableHelper.validate(this.d, r5) == false) goto L16;
        this.d = r5;
        ((mt.b0) this.f17809b).onSubscribe(this);
        return;
    L16:
        return;
    L9:
        if (DisposableHelper.validate(this.d, r5) == false) goto L17;
        this.d = r5;
        ((mt.u) this.f17809b).onSubscribe(this);
        return;
    L17:
        return;
    L13:
        if (DisposableHelper.validate(this.d, r5) == false) goto L18;
        this.d = r5;
        ((mt.u) this.f17809b).onSubscribe(this);
        return;
    }

    public i0(mt.u r5, long r10) {
        this.f17808a = 1;
        this.f17809b = r5;
        this.f17810c = r10;
    }
}
