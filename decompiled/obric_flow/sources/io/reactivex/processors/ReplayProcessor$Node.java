package io.reactivex.processors;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ReplayProcessor$Node<T> extends AtomicReference<ReplayProcessor$Node<T>> {
    private static final long serialVersionUID = 6404226426336033100L;
    final T value;

    public ReplayProcessor$Node(T r5) {
        this.value = r5;
    }
}
