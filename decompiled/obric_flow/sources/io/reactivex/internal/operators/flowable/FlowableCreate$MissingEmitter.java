package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableCreate$MissingEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 3776720187248809713L;

    public FlowableCreate$MissingEmitter(zu.c r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, mt.d
    public void onNext(T r5) {
        if (isCancelled() == false) goto L5;
        return;
    L5:
        if (r5 == null) goto L12;
        this.downstream.onNext(r5);
    L7:
        long r10 = get();
        if (r10 == 0) goto L11;
        if (compareAndSet(r10, r10 - 1) == false) goto L7;
        return;
    L11:
        return;
    L12:
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
    }
}
