package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes3.dex */
public final class c3 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.o f17746b;

    public c3(mt.n r5, pt.o r10) {
        super(r5);
        this.f17746b = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        io.reactivex.subjects.f r10 = new io.reactivex.subjects.f(new io.reactivex.subjects.d());
        Object r11 = this.f17746b.apply(r10);     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r11, "The handler returned a null ObservableSource");     // Catch: Throwable -> L6
        mt.s r12 = (mt.s) r11;     // Catch: Throwable -> L6
        ObservableRepeatWhen$RepeatWhenObserver r13 = new ObservableRepeatWhen$RepeatWhenObserver(r5, r10, this.f17702a);
        r5.onSubscribe(r13);
        r12.subscribe(r13.inner);
        r13.subscribeNext();
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
    }
}
