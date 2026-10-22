package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class v3 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f18020c;
    public final mt.z d;
    public final int e;
    public final boolean f;

    public v3(int r5, long r10, TimeUnit r11, mt.n r12, mt.z r13, boolean r14) {
        super(r12);
        this.f18019b = r10;
        this.f18020c = r11;
        this.d = r13;
        this.e = r5;
        this.f = r14;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        int r11 = this.e;
        boolean r12 = this.f;
        ObservableSkipLastTimed$SkipLastTimedObserver r13 = new ObservableSkipLastTimed$SkipLastTimedObserver(r10, this.f18019b, this.f18020c, this.d, r11, r12);
        this.f17702a.subscribe(r13);
    }
}
