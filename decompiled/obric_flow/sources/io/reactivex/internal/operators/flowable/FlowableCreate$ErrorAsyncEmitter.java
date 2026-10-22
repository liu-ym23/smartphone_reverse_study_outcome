package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableCreate$ErrorAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    private static final long serialVersionUID = 338953216916120960L;

    public FlowableCreate$ErrorAsyncEmitter(zu.c r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter
    public void onOverflow() {
        onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }
}
