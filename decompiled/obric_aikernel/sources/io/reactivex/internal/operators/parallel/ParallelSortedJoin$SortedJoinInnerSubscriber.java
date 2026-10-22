package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
final class ParallelSortedJoin$SortedJoinInnerSubscriber<T> extends AtomicReference<d> implements g<List<T>> {
    private static final long serialVersionUID = 6751017204873808094L;
    final int index;
    final ParallelSortedJoin$SortedJoinSubscription<T> parent;

    ParallelSortedJoin$SortedJoinInnerSubscriber(ParallelSortedJoin$SortedJoinSubscription<T> r10, int r11) {
        this.parent = r10;
        this.index = r11;
    }

    void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // tc.c
    public void onComplete() {
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.parent.innerError(r10);
    }

    @Override // tc.c
    public /* bridge */ /* synthetic */ void onNext(Object r10) {
        onNext((List) r10);
    }

    public void onNext(List<T> r10) {
        this.parent.innerNext(r10, this.index);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
