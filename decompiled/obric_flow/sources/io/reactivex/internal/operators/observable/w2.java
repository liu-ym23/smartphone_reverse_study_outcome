package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class w2 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18040b;

    public w2(int r5, int r10) {
        this.f18039a = r5;
        this.f18040b = ((long) r5) + ((long) r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [io.reactivex.disposables.Disposable, io.reactivex.internal.operators.observable.ObservableRange$RangeDisposable] */
    @Override // mt.n
    public final void subscribeActual(final mt.u r10) {
        final long r5 = this.f18039a;
        final long r11 = this.f18040b;
        ?? r12 = new ObservableRange$RangeDisposable(r10, r5, r11);
        r10.onSubscribe(r12);
        r12.run();
    }
}
