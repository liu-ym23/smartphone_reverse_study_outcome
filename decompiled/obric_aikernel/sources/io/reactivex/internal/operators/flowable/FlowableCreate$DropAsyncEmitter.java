package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableCreate$DropAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    private static final long serialVersionUID = 8360058422307496563L;

    FlowableCreate$DropAsyncEmitter(tc.c<? super T> r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter
    void onOverflow() {
    }
}
