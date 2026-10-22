package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: loaded from: classes3.dex */
public final class b3 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17731c;

    public /* synthetic */ b3(mt.s r5, long r10, int r11) {
        this.f17730b = r11;
        super(r5);
        this.f17731c = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        switch(this.f17730b) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        b4 r5 = new b4(r10, this.f17731c);
        this.f17702a.subscribe(r5);
        return;
    L6:
        i0 r11 = new i0(r10, this.f17731c);
        this.f17702a.subscribe(r11);
        return;
    L8:
        SequentialDisposable r12 = new SequentialDisposable();
        r10.onSubscribe(r12);
        long r13 = this.f17731c;
        long r14 = Long.MAX_VALUE;
        if (r13 == Long.MAX_VALUE) goto L11;
        r14 = r13 - 1;
    L11:
        new ObservableRepeat$RepeatObserver(r10, r14, r12, this.f17702a).subscribeNext();
    }
}
