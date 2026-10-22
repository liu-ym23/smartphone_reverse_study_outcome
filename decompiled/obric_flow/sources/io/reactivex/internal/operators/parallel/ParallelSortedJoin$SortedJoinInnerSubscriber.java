package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelSortedJoin$SortedJoinInnerSubscriber<T> extends AtomicReference<d> implements g {
    private static final long serialVersionUID = 6751017204873808094L;
    final int index;
    final ParallelSortedJoin$SortedJoinSubscription<T> parent;

    public ParallelSortedJoin$SortedJoinInnerSubscriber(ParallelSortedJoin$SortedJoinSubscription<T> r5, int r10) {
        this.parent = r5;
        this.index = r10;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // zu.c
    public void onComplete() {
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.parent.innerError(r5);
    }

    @Override // zu.c
    public /* bridge */ /* synthetic */ void onNext(Object r5) {
        onNext((List) r5);
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
    }

    public void onNext(List<T> r5) {
        this.parent.innerNext(r5, this.index);
    }
}
