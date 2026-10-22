package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes3.dex */
public final class v2 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.o f18018c;

    public /* synthetic */ v2(mt.s r5, pt.o r10, int r11) {
        this.f18017b = r11;
        super(r5);
        this.f18018c = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f18017b) {
            case 0: goto L14;
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        i1 r10 = new i1(r5, this.f18018c, 1);
        this.f17702a.subscribe(r10);
        return;
    L6:
        w0 r11 = new w0(r5, this.f18018c, 2);
        this.f17702a.subscribe(r11);
        return;
    L8:
        i1 r12 = new i1(r5, this.f18018c, 0);
        this.f17702a.subscribe(r12);
        return;
    L10:
        s0 r13 = new s0(r5, this.f18018c);
        this.f17702a.subscribe(r13);
        return;
    L12:
        n0 r14 = new n0(new io.reactivex.observers.d(r5), this.f18018c);
        this.f17702a.subscribe(r14);
        return;
    L14:
        io.reactivex.subjects.d r15 = new io.reactivex.subjects.d();
        Object r16 = this.f18018c.apply(r15);     // Catch: Throwable -> L17
        io.reactivex.internal.functions.e.d(r16, "The selector returned a null ObservableSource");     // Catch: Throwable -> L17
        mt.s r17 = (mt.s) r16;     // Catch: Throwable -> L17
        ObservablePublishSelector$TargetObserver r18 = new ObservablePublishSelector$TargetObserver(r5);
        r17.subscribe(r18);
        u2 r19 = new u2(r15, r18, 0);
        this.f17702a.subscribe(r19);
        return;
    L17:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
    }
}
