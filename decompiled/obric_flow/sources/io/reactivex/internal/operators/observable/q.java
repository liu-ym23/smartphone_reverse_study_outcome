package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17916c;
    public final Callable d;

    public q(mt.n r5, int r10, int r11, Callable r12) {
        super(r5);
        this.f17915b = r10;
        this.f17916c = r11;
        this.d = r12;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        mt.s r10 = this.f17702a;
        Callable r11 = this.d;
        int r12 = this.f17916c;
        int r13 = this.f17915b;
        if (r12 != r13) goto L7;
        p r14 = new p(r5, r13, r11);
        if (r14.a() == false) goto L9;
        r10.subscribe(r14);
        return;
    L9:
        return;
    L7:
        r10.subscribe(new ObservableBuffer$BufferSkipObserver(r5, r13, r12, r11));
    }
}
