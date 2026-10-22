package io.reactivex.internal.operators.parallel;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import wn.f;
import zu.c;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelSortedJoin$SortedJoinSubscription<T> extends AtomicInteger implements d {
    private static final long serialVersionUID = 3481980673745556697L;
    volatile boolean cancelled;
    final Comparator<? super T> comparator;
    final c downstream;
    final AtomicReference<Throwable> error;
    final int[] indexes;
    final List<T>[] lists;
    final AtomicInteger remaining;
    final AtomicLong requested;
    final ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] subscribers;

    public ParallelSortedJoin$SortedJoinSubscription(c r5, int r10, Comparator<? super T> r11) {
        this.requested = new AtomicLong();
        this.remaining = new AtomicInteger();
        this.error = new AtomicReference();
        this.downstream = r5;
        this.comparator = r11;
        ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] r12 = new ParallelSortedJoin$SortedJoinInnerSubscriber[r10];
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L5;
        r12[r13] = new ParallelSortedJoin$SortedJoinInnerSubscriber(this, r13);
        r13 = r13 + 1;
        goto L3
    L5:
        this.subscribers = r12;
        this.lists = new List[r10];
        this.indexes = new int[r10];
        this.remaining.lazySet(r10);
    }

    @Override // zu.d
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() != 0) goto L9;
        Arrays.fill(this.lists, null);
        return;
    L9:
        return;
    }

    public void cancelAll() {
        ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] r5 = this.subscribers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].cancel();
        r11 = r11 + 1;
        goto L3
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        c r5 = this.downstream;
        List<T>[] r10 = this.lists;
        int[] r11 = this.indexes;
        int r12 = r11.length;
        int r13 = 1;
    L6:
        long r14 = this.requested.get();
        long r15 = 0;
    L7:
        int r16 = 0;
        if (r15 == r14) goto L45;
        if (this.cancelled == true) goto L11;
        Throwable r17 = this.error.get();
        if (r17 != null) goto L15;
        int r18 = -1;
        T r19 = null;
    L18:
        if (r16 >= r12) goto L40;
        List<T> r110 = r10[r16];
        int r20 = r11[r16];
        if (r110.size() == r20) goto L39;
        if (r19 != null) goto L24;
        r19 = r110.get(r20);
    L23:
        r18 = r16;
        goto L39
    L24:
        T r21 = r110.get(r20);
        if (this.comparator.compare(r19, r21) <= 0) goto L39;
        r19 = r21;
    L28:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancelAll();
        Throwable r22 = null;
        Arrays.fill(r10, null);
        AtomicReference<Throwable> r111 = this.error;
    L31:
        if (r111.compareAndSet(r22, th) == true) goto L36;
        if (r111.get() != null) goto L35;
        r22 = null;
        goto L31
    L35:
        f.k(th);
    L36:
        r5.onError(this.error.get());
        return;
    L39:
        r16 = r16 + 1;
        goto L18
    L40:
        if (r19 == null) goto L41;
        r5.onNext(r19);
        r11[r18] = r11[r18] + 1;
        r15 = r15 + 1;
        goto L7
    L41:
        Arrays.fill(r10, null);
        r5.onComplete();
        return;
    L15:
        cancelAll();
        Arrays.fill(r10, null);
        r5.onError(r17);
        return;
    L11:
        Arrays.fill(r10, null);
        return;
    L45:
        if (r15 != r14) goto L62;
        if (this.cancelled == true) goto L48;
        Throwable r112 = this.error.get();
        if (r112 != null) goto L52;
    L54:
        if (r16 >= r12) goto L59;
        if (r11[r16] != r10[r16].size()) goto L62;
        r16 = r16 + 1;
        goto L54
    L59:
        Arrays.fill(r10, null);
        r5.onComplete();
        return;
    L52:
        cancelAll();
        Arrays.fill(r10, null);
        r5.onError(r112);
        return;
    L48:
        Arrays.fill(r10, null);
        return;
    L62:
        if (r15 != 0) goto L64;
    L66:
        int r23 = get();
        if (r23 != r13) goto L71;
        r23 = addAndGet(-r13);
        if (r23 != 0) goto L71;
        return;
    L71:
        r13 = r23;
        goto L6
    L64:
        if (r14 == Long.MAX_VALUE) goto L66;
        this.requested.addAndGet(-r15);
        goto L66
    }

    public void innerError(Throwable r5) {
        AtomicReference<Throwable> r10 = this.error;
    L4:
        if (r10.compareAndSet(null, r5) == true) goto L5;
        if (r10.get() == null) goto L4;
        if (r5 == this.error.get()) goto L16;
        f.k(r5);
        return;
    L16:
        return;
    L5:
        drain();
    }

    public void innerNext(List<T> r5, int r10) {
        this.lists[r10] = r5;
        if (this.remaining.decrementAndGet() != 0) goto L6;
        drain();
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L8;
        v0.r(this.requested, r5);
        if (this.remaining.get() != 0) goto L9;
        drain();
        return;
    L9:
        return;
    }
}
