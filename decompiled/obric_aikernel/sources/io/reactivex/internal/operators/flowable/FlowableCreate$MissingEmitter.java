package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableCreate$MissingEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 3776720187248809713L;

    FlowableCreate$MissingEmitter(tc.c<? super T> r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, xb.d
    public void onNext(T r10) {
        if (isCancelled() == false) goto L5;
        return;
    L5:
        if (r10 == null) goto L12;
        this.downstream.onNext(r10);
    L7:
        long r11 = get();
        if (r11 == 0) goto L11;
        if (compareAndSet(r11, r11 - 1) == false) goto L7;
        return;
    L11:
        return;
    L12:
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
    }
}
