package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;

/* JADX INFO: loaded from: classes3.dex */
abstract class FlowableCreate$NoOverflowBaseAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 4127754106204442833L;

    public FlowableCreate$NoOverflowBaseAsyncEmitter(zu.c r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, mt.d
    public final void onNext(T r5) {
        if (isCancelled() == false) goto L5;
        return;
    L5:
        if (r5 != null) goto L9;
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L9:
        if (get() == 0) goto L11;
        this.downstream.onNext(r5);
        v0.y(this, 1);
        return;
    L11:
        onOverflow();
    }

    public abstract void onOverflow();
}
