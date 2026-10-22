package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;

/* JADX INFO: loaded from: classes3.dex */
public final class y3 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mt.s f18082c;

    public /* synthetic */ y3(mt.n r5, mt.s r10, int r11) {
        this.f18081b = r11;
        super(r5);
        this.f18082c = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f18081b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        r0 r10 = new r0(r5, this.f18082c);
        r5.onSubscribe(r10.f17941c);
        this.f17702a.subscribe(r10);
        return;
    L6:
        io.reactivex.observers.d r11 = new io.reactivex.observers.d(r5);
        ArrayCompositeDisposable r12 = new ArrayCompositeDisposable(2);
        r11.onSubscribe(r12);
        x3 r13 = new x3(r11, r12);
        w3 r14 = new w3(r12, r13, r11);
        this.f18082c.subscribe(r14);
        this.f17702a.subscribe(r13);
    }
}
