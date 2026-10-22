package io.reactivex.internal.operators.parallel;

import dc.a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.g;
import zb.c;

/* JADX INFO: loaded from: classes2.dex */
final class ParallelReduceFull$ParallelReduceFullInnerSubscriber<T> extends AtomicReference<d> implements g<T> {
    private static final long serialVersionUID = -7954444275102466525L;
    boolean done;
    final ParallelReduceFull$ParallelReduceFullMainSubscriber<T> parent;
    final c<T, T, T> reducer;
    T value;

    ParallelReduceFull$ParallelReduceFullInnerSubscriber(ParallelReduceFull$ParallelReduceFullMainSubscriber<T> r10, c<T, T, T> r11) {
        this.parent = r10;
        this.reducer = r11;
    }

    void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        this.parent.innerComplete(this.value);
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        a.n(r10);
        return;
    L6:
        this.done = true;
        this.parent.innerError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == true) goto L14;
        T r11 = this.value;
        if (r11 != null) goto L12;
    L6:
        this.value = r10;
        return;
    L12:
        r10 = (T) io.reactivex.internal.functions.a.d(this.reducer.apply(r11, r10), "The reducer returned a null value");
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        get().cancel();
        onError(th);
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
