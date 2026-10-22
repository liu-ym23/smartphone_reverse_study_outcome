package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class j4 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f17834c;
    public final Object d;

    public j4(long r5, TimeUnit r10, mt.z r11) {
        this.f17832a = 0;
        this.f17833b = r5;
        this.f17834c = r10;
        this.d = r11;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        switch(this.f17832a) {
            case 0: goto L19;
            default: goto L4;
        };
    L4:
        DeferredScalarDisposable r5 = new DeferredScalarDisposable(r10);
        r10.onSubscribe(r5);
        if (r5.isDisposed() == true) goto L23;
        TimeUnit r11 = this.f17834c;     // Catch: Throwable -> L10
        Future r12 = (Future) this.d;
        if (r11 == null) goto L12;
        Object r13 = r12.get(this.f17833b, r11);     // Catch: Throwable -> L10
    L13:
        io.reactivex.internal.functions.e.d(r13, "Future returned null");     // Catch: Throwable -> L10
        r5.complete(r13);
        return;
    L12:
        r13 = r12.get();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        if (r5.isDisposed() == true) goto L25;
        r10.onError(th);
        return;
    L25:
        return;
    L23:
        return;
    L19:
        ObservableTimer$TimerObserver r14 = new ObservableTimer$TimerObserver(r10);
        r10.onSubscribe(r14);
        long r15 = this.f17833b;
        TimeUnit r16 = this.f17834c;
        r14.setResource(((mt.z) this.d).d(r14, r15, r16));
    }

    public j4(Future r5, long r10, TimeUnit r11) {
        this.f17832a = 1;
        this.d = r5;
        this.f17833b = r10;
        this.f17834c = r11;
    }
}
