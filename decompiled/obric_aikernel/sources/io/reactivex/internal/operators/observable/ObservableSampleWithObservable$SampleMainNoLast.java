package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableSampleWithObservable$SampleMainNoLast<T> extends ObservableSampleWithObservable$SampleMainObserver<T> {
    private static final long serialVersionUID = -3029755663834015785L;

    ObservableSampleWithObservable$SampleMainNoLast(xb.o<? super T> r10, xb.n<?> r11) {
        super(r10, r11);
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
    void completeMain() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
    void completeOther() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
    void run() {
        emit();
    }
}
