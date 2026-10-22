package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableReplay$Node extends AtomicReference<FlowableReplay$Node> {
    private static final long serialVersionUID = 245354315435971818L;
    final long index;
    final Object value;

    FlowableReplay$Node(Object r10, long r11) {
        this.value = r10;
        this.index = r11;
    }
}
