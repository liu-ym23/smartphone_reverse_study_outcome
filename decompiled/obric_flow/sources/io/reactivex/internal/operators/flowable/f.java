package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements zu.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zu.c f17655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17657c;

    public f(Object r5, zu.c r10) {
        this.f17656b = r5;
        this.f17655a = r10;
    }

    @Override // zu.d
    public final void cancel() {
    }

    @Override // zu.d
    public final void request(long r5) {
        if (r5 > 0) goto L5;
        return;
    L5:
        if (this.f17657c == true) goto L9;
        this.f17657c = true;
        Object r10 = this.f17656b;
        zu.c r11 = this.f17655a;
        r11.onNext(r10);
        r11.onComplete();
        return;
    }
}
