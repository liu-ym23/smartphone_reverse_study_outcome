package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
abstract class FlowableCreate$NoOverflowBaseAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 4127754106204442833L;

    FlowableCreate$NoOverflowBaseAsyncEmitter(tc.c<? super T> r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, xb.d
    public final void onNext(T r10) {
        if (isCancelled() == false) goto L5;
        return;
    L5:
        if (r10 != null) goto L9;
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L9:
        if (get() == 0) goto L11;
        this.downstream.onNext(r10);
        io.reactivex.internal.util.b.e(this, 1);
        return;
    L11:
        onOverflow();
    }

    abstract void onOverflow();
}
