package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class x2 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18056b;

    public x2(long r5, long r10) {
        this.f18055a = r5;
        this.f18056b = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [io.reactivex.disposables.Disposable, io.reactivex.internal.operators.observable.ObservableRangeLong$RangeDisposable] */
    @Override // mt.n
    public final void subscribeActual(final mt.u r10) {
        long r5 = this.f18056b;
        final long r11 = this.f18055a;
        final long r12 = r11 + r5;
        ?? r13 = new ObservableRangeLong$RangeDisposable(r10, r11, r12);
        r10.onSubscribe(r13);
        r13.run();
    }
}
