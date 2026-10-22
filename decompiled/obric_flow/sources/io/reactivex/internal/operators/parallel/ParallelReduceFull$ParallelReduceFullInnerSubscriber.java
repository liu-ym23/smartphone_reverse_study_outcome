package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.functions.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import pt.c;
import wn.f;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelReduceFull$ParallelReduceFullInnerSubscriber<T> extends AtomicReference<d> implements g {
    private static final long serialVersionUID = -7954444275102466525L;
    boolean done;
    final ParallelReduceFull$ParallelReduceFullMainSubscriber<T> parent;
    final c reducer;
    T value;

    public ParallelReduceFull$ParallelReduceFullInnerSubscriber(ParallelReduceFull$ParallelReduceFullMainSubscriber<T> r5, c r10) {
        this.parent = r5;
        this.reducer = r10;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        this.parent.innerComplete(this.value);
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        f.k(r5);
        return;
    L6:
        this.done = true;
        this.parent.innerError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.done == true) goto L14;
        T r10 = this.value;
        if (r10 != null) goto L12;
        this.value = r5;
        return;
    L12:
        T r11 = (T) this.reducer.apply(r10, r5);
        e.d(r11, "The reducer returned a null value");     // Catch: Throwable -> L9
        this.value = r11;
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        get().cancel();
        onError(th);
        return;
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
    }
}
