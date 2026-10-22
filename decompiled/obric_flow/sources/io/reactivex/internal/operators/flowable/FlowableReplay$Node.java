package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableReplay$Node extends AtomicReference<FlowableReplay$Node> {
    private static final long serialVersionUID = 245354315435971818L;
    final long index;
    final Object value;

    public FlowableReplay$Node(Object r5, long r10) {
        this.value = r5;
        this.index = r10;
    }
}
