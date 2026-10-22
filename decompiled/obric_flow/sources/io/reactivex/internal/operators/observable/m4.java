package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class m4 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17869c;
    public final int d;

    public m4(mt.n r5, long r10, long r11, int r12) {
        super(r5);
        this.f17868b = r10;
        this.f17869c = r11;
        this.d = r12;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r12) {
        long r5 = this.f17869c;
        long r10 = this.f17868b;
        mt.s r11 = this.f17702a;
        if (r10 != r5) goto L5;
        r11.subscribe(new ObservableWindow$WindowExactObserver(r12, r10, this.d));
        return;
    L5:
        long r13 = this.f17869c;
        int r14 = this.d;
        r11.subscribe(new ObservableWindow$WindowSkipObserver(r12, this.f17868b, r13, r14));
    }
}
