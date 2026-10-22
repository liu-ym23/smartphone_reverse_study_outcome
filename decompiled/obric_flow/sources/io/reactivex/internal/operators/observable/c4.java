package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class c4 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17748c;
    public final TimeUnit d;
    public final mt.z e;
    public final int f;
    public final boolean g;

    public c4(mt.n r5, long r10, long r11, TimeUnit r12, mt.z r13, int r14, boolean r15) {
        super(r5);
        this.f17747b = r10;
        this.f17748c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r12) {
        int r10 = this.f;
        boolean r11 = this.g;
        ObservableTakeLastTimed$TakeLastTimedObserver r13 = new ObservableTakeLastTimed$TakeLastTimedObserver(r12, this.f17747b, this.f17748c, this.d, this.e, r10, r11);
        this.f17702a.subscribe(r13);
    }
}
