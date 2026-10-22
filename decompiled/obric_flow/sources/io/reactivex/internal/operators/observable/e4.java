package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class e4 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17773c;
    public final TimeUnit d;
    public final mt.z e;

    public /* synthetic */ e4(int r5, long r10, TimeUnit r11, mt.n r12, mt.z r13) {
        this.f17772b = r5;
        super(r12);
        this.f17773c = r10;
        this.d = r11;
        this.e = r13;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        switch(this.f17772b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        io.reactivex.observers.d r5 = new io.reactivex.observers.d(r10);
        mt.y r11 = this.e.a();
        o0 r12 = new o0(r5, this.f17773c, this.d, r11);
        this.f17702a.subscribe(r12);
        return;
    L6:
        io.reactivex.observers.d r13 = new io.reactivex.observers.d(r10);
        mt.y r14 = this.e.a();
        ObservableThrottleFirstTimed$DebounceTimedObserver r15 = new ObservableThrottleFirstTimed$DebounceTimedObserver(r13, this.f17773c, this.d, r14);
        this.f17702a.subscribe(r15);
    }
}
