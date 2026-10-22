package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class n3 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17881c;
    public final TimeUnit d;
    public final mt.z e;
    public final boolean f;

    public /* synthetic */ n3(int r5, long r10, TimeUnit r11, mt.n r12, mt.z r13, boolean r14) {
        this.f17880b = r5;
        super(r12);
        this.f17881c = r10;
        this.d = r11;
        this.e = r13;
        this.f = r14;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        switch(this.f17880b) {
            case 0: goto L12;
            case 1: goto L10;
            default: goto L5;
        };
    L10:
        mt.y r5 = this.e.a();
        ObservableThrottleLatest$ThrottleLatestObserver r11 = new ObservableThrottleLatest$ThrottleLatestObserver(r10, this.f17881c, this.d, r5, this.f);
        this.f17702a.subscribe(r11);
        return;
    L12:
        final io.reactivex.observers.d r12 = new io.reactivex.observers.d(r10);
        boolean r13 = this.f;
        mt.s r14 = this.f17702a;
        if (r13 == false) goto L15;
        final mt.z r15 = this.e;
        final long r16 = this.f17881c;
        final TimeUnit r17 = this.d;
        r14.subscribe(new ObservableSampleTimed$SampleTimedEmitLast(r12, r16, r17, r15));
        return;
    L15:
        final mt.z r18 = this.e;
        final long r19 = this.f17881c;
        final TimeUnit r20 = this.d;
        r14.subscribe(new ObservableSampleTimed$SampleTimedNoLast(r12, r19, r20, r18));
        return;
    L5:
        if (this.f == false) goto L7;
        mt.u r21 = r10;
    L8:
        mt.y r22 = this.e.a();
        boolean r23 = this.f;
        q0 r24 = new q0(r21, this.f17881c, this.d, r22, r23);
        this.f17702a.subscribe(r24);
        return;
    L7:
        r21 = new io.reactivex.observers.d(r10);
        goto L8
    }
}
