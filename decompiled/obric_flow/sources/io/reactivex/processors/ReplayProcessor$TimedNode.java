package io.reactivex.processors;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ReplayProcessor$TimedNode<T> extends AtomicReference<ReplayProcessor$TimedNode<T>> {
    private static final long serialVersionUID = 6404226426336033100L;
    final long time;
    final T value;

    public ReplayProcessor$TimedNode(T r5, long r10) {
        this.value = r5;
        this.time = r10;
    }
}
