package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class d<T> implements tc.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final tc.c<? super T> f9511c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final T f9512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f9513h;

    d(T r10, tc.c<? super T> r11) {
        this.f9512g = r10;
        this.f9511c = r11;
    }

    @Override // tc.d
    public void cancel() {
    }

    @Override // tc.d
    public void request(long r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        if (this.f9513h == true) goto L9;
        this.f9513h = true;
        tc.c<? super T> r11 = this.f9511c;
        r11.onNext(this.f9512g);
        r11.onComplete();
        return;
    }
}
