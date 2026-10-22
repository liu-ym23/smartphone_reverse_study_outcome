package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.ErrorMode;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.o f17777c;
    public final int d;
    public final Object e;

    public f0(mt.s r5, pt.o r10, int r11, ErrorMode r12) {
        this.f17776b = 0;
        super(r5);
        this.f17777c = r10;
        this.e = r12;
        this.d = Math.max(8, r11);
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        switch(this.f17776b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        io.reactivex.observers.d r5 = new io.reactivex.observers.d(r10);
        int r11 = this.d;
        q4 r12 = new q4(r5, (mt.s) this.e, this.f17777c, r11);
        this.f17702a.subscribe(r12);
        return;
    L6:
        mt.s r13 = this.f17702a;
        pt.o r14 = this.f17777c;
        if (com.lynx.tasm.base.h.i(r10, r14, r13) == true) goto L19;
        ErrorMode r15 = ErrorMode.IMMEDIATE;
        int r16 = this.d;
        ErrorMode r17 = (ErrorMode) this.e;
        if (r17 != r15) goto L13;
        r13.subscribe(new ObservableConcatMap$SourceObserver(new io.reactivex.observers.d(r10), r14, r16));
        return;
    L13:
        if (r17 != ErrorMode.END) goto L15;
        boolean r18 = true;
    L16:
        r13.subscribe(new ObservableConcatMap$ConcatMapDelayErrorObserver(r10, r14, r16, r18));
        return;
    L15:
        r18 = false;
        goto L16
    }

    public f0(mt.n r5, mt.s r10, pt.o r11, int r12) {
        this.f17776b = 1;
        super(r5);
        this.e = r10;
        this.f17777c = r11;
        this.d = r12;
    }
}
