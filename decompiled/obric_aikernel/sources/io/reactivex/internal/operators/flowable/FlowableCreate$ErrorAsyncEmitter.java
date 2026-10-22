package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableCreate$ErrorAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    private static final long serialVersionUID = 338953216916120960L;

    FlowableCreate$ErrorAsyncEmitter(tc.c<? super T> r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter
    void onOverflow() {
        onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }
}
