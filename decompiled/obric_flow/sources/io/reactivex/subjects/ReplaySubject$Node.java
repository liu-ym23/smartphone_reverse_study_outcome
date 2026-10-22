package io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ReplaySubject$Node<T> extends AtomicReference<ReplaySubject$Node<T>> {
    private static final long serialVersionUID = 6404226426336033100L;
    final T value;

    public ReplaySubject$Node(T r5) {
        this.value = r5;
    }
}
