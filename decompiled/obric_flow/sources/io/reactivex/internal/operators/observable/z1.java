package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class z1 implements pt.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.u f18092b;

    public /* synthetic */ z1(mt.u r5, int r10) {
        this.f18091a = r10;
        this.f18092b = r5;
    }

    @Override // pt.g
    public final void accept(Object r5) {
        switch(this.f18091a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f18092b.onNext(r5);
        return;
    L6:
        mt.u r10 = this.f18092b;
        r10.onError((Throwable) r5);
    }
}
