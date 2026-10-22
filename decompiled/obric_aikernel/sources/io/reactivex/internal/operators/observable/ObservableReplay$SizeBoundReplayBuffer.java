package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableReplay$SizeBoundReplayBuffer<T> extends ObservableReplay$BoundedReplayBuffer<T> {
    private static final long serialVersionUID = -5898283885385201806L;
    final int limit;

    ObservableReplay$SizeBoundReplayBuffer(int r10) {
        this.limit = r10;
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
    void truncate() {
        if (this.size <= this.limit) goto L6;
        removeFirst();
        return;
    }
}
