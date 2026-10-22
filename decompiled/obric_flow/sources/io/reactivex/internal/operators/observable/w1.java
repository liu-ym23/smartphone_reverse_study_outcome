package io.reactivex.internal.operators.observable;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class w1 implements pt.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.o f18038b;

    public /* synthetic */ w1(pt.o r5, int r10) {
        this.f18037a = r10;
        this.f18038b = r5;
    }

    @Override // pt.o
    public final Object apply(Object r5) {
        switch(this.f18037a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        int r10 = mt.n.bufferSize();
        return mt.n.zipIterable((List) r5, this.f18038b, false, r10);
    L6:
        Object r11 = this.f18038b.apply(r5);
        io.reactivex.internal.functions.e.d(r11, "The itemDelay returned a null ObservableSource");
        return new b3((mt.s) r11, 1, 2).map(new com.airbnb.lottie.m(r5, 10)).defaultIfEmpty(r5);
    L8:
        Object r12 = this.f18038b.apply(r5);
        io.reactivex.internal.functions.e.d(r12, "The mapper returned a null Iterable");
        return new l0((Iterable) r12, 2);
    }
}
