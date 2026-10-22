package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: loaded from: classes3.dex */
public final class l3 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.p f17854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17855c;

    public l3(mt.n r5, long r10, pt.p r11) {
        super(r5);
        this.f17854b = r11;
        this.f17855c = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        SequentialDisposable r5 = new SequentialDisposable();
        r10.onSubscribe(r5);
        pt.p r11 = this.f17854b;
        mt.s r12 = this.f17702a;
        new ObservableRetryPredicate$RepeatObserver(r10, this.f17855c, r11, r5, r12).subscribeNext();
    }
}
