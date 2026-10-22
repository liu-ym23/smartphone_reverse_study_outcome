package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class i4 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f17821c;
    public final mt.z d;
    public final mt.s e;

    public i4(mt.n r5, long r10, TimeUnit r11, mt.z r12, mt.s r13) {
        super(r5);
        this.f17820b = r10;
        this.f17821c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r12) {
        mt.s r5 = this.e;
        mt.s r10 = this.f17702a;
        mt.z r11 = this.d;
        if (r5 != null) goto L5;
        mt.y r13 = r11.a();
        ObservableTimeoutTimed$TimeoutObserver r14 = new ObservableTimeoutTimed$TimeoutObserver(r12, this.f17820b, this.f17821c, r13);
        r12.onSubscribe(r14);
        r14.startTimeout(0);
        r10.subscribe(r14);
        return;
    L5:
        mt.y r15 = r11.a();
        ObservableTimeoutTimed$TimeoutFallbackObserver r16 = new ObservableTimeoutTimed$TimeoutFallbackObserver(r12, this.f17820b, this.f17821c, r15, this.e);
        r12.onSubscribe(r16);
        r16.startTimeout(0);
        r10.subscribe(r16);
    }
}
