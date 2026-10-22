package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public final class o3 implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.u f17897b;

    public /* synthetic */ o3(mt.u r5, int r10) {
        this.f17896a = r10;
        this.f17897b = r5;
    }

    private final void a() {
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17896a) {
            case 0: goto L6;
            case 1: goto L8;
            default: goto L4;
        };
    L4:
        ((r0) this.f17897b).f17940b.onComplete();
        return;
    L6:
        ((ObservableSampleWithObservable$SampleMainObserver) this.f17897b).complete();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17896a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ((r0) this.f17897b).f17940b.onError(r5);
        return;
    L6:
        ((ObservableWithLatestFrom$WithLatestFromObserver) this.f17897b).otherError(r5);
        return;
    L8:
        ((ObservableSampleWithObservable$SampleMainObserver) this.f17897b).error(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17896a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ((r0) this.f17897b).f17940b.onNext(r5);
        return;
    L6:
        ((ObservableWithLatestFrom$WithLatestFromObserver) this.f17897b).lazySet(r5);
        return;
    L8:
        ((ObservableSampleWithObservable$SampleMainObserver) this.f17897b).run();
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17896a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ((r0) this.f17897b).f17941c.update(r5);
        return;
    L6:
        ((ObservableWithLatestFrom$WithLatestFromObserver) this.f17897b).setOther(r5);
        return;
    L8:
        ((ObservableSampleWithObservable$SampleMainObserver) this.f17897b).setOther(r5);
    }
}
