package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.u f17940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SequentialDisposable f17941c;
    public boolean d;
    public final mt.s e;

    public r0(mt.u r5, mt.s r10) {
        this.f17939a = 1;
        this.f17940b = r5;
        this.e = r10;
        this.d = true;
        this.f17941c = new SequentialDisposable();
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17939a) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (this.d == false) goto L7;
        this.d = false;
        this.e.subscribe(this);
        return;
    L7:
        this.f17940b.onComplete();
        return;
    L10:
        if (this.d == true) goto L15;
        this.d = true;
        ((mt.n) ((o) this.e).f17885b).subscribe(new o3(this, 2));
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17939a) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        this.f17940b.onError(r5);
        return;
    L7:
        if (this.d == false) goto L9;
        wn.f.k(r5);
        return;
    L9:
        this.d = true;
        this.f17940b.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17939a) {
            case 0: goto L9;
            default: goto L5;
        };
    L9:
        onComplete();
        return;
    L5:
        if (this.d == false) goto L7;
        this.d = false;
    L7:
        this.f17940b.onNext(r5);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17939a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f17941c.update(r5);
        return;
    L6:
        this.f17941c.update(r5);
    }

    public r0(o r5, SequentialDisposable r10, mt.u r11) {
        this.f17939a = 0;
        this.e = r5;
        this.f17941c = r10;
        this.f17940b = r11;
    }
}
