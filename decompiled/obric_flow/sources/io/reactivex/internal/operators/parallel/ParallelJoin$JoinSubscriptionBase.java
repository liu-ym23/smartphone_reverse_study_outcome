package io.reactivex.internal.operators.parallel;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import zu.c;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
abstract class ParallelJoin$JoinSubscriptionBase<T> extends AtomicInteger implements d {
    private static final long serialVersionUID = 3100232009247827843L;
    volatile boolean cancelled;
    final AtomicInteger done;
    final c downstream;
    final AtomicThrowable errors;
    final AtomicLong requested;
    final ParallelJoin$JoinInnerSubscriber<T>[] subscribers;

    public ParallelJoin$JoinSubscriptionBase(c r5, int r10, int r11) {
        this.errors = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.done = new AtomicInteger();
        this.downstream = r5;
        ParallelJoin$JoinInnerSubscriber<T>[] r12 = new ParallelJoin$JoinInnerSubscriber[r10];
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L5;
        r12[r13] = new ParallelJoin$JoinInnerSubscriber(this, r11);
        r13 = r13 + 1;
        goto L3
    L5:
        this.subscribers = r12;
        this.done.lazySet(r10);
    }

    @Override // zu.d
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() != 0) goto L9;
        cleanup();
        return;
    L9:
        return;
    }

    public void cancelAll() {
        ParallelJoin$JoinInnerSubscriber<T>[] r5 = this.subscribers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].cancel();
        r11 = r11 + 1;
        goto L3
    }

    public void cleanup() {
        ParallelJoin$JoinInnerSubscriber<T>[] r5 = this.subscribers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].queue = null;
        r11 = r11 + 1;
        goto L3
    }

    public abstract void drain();

    public abstract void onComplete();

    public abstract void onError(Throwable r5);

    public abstract void onNext(ParallelJoin$JoinInnerSubscriber<T> r5, T r10);

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        drain();
        return;
    }
}
