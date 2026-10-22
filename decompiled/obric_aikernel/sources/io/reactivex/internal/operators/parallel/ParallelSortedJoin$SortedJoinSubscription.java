package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.c;
import tc.d;

/* JADX INFO: loaded from: classes2.dex */
final class ParallelSortedJoin$SortedJoinSubscription<T> extends AtomicInteger implements d {
    private static final long serialVersionUID = 3481980673745556697L;
    volatile boolean cancelled;
    final Comparator<? super T> comparator;
    final c<? super T> downstream;
    final AtomicReference<Throwable> error;
    final int[] indexes;
    final List<T>[] lists;
    final AtomicInteger remaining;
    final AtomicLong requested;
    final ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] subscribers;

    ParallelSortedJoin$SortedJoinSubscription(c<? super T> r10, int r11, Comparator<? super T> r12) {
        this.requested = new AtomicLong();
        this.remaining = new AtomicInteger();
        this.error = new AtomicReference();
        this.downstream = r10;
        this.comparator = r12;
        ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] r13 = new ParallelSortedJoin$SortedJoinInnerSubscriber[r11];
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r13[r14] = new ParallelSortedJoin$SortedJoinInnerSubscriber(this, r14);
        r14 = r14 + 1;
        goto L3
    L5:
        this.subscribers = r13;
        this.lists = new List[r11];
        this.indexes = new int[r11];
        this.remaining.lazySet(r11);
    }

    @Override // tc.d
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

    void cancelAll() {
        ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] r10 = this.subscribers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].cancel();
        r12 = r12 + 1;
        goto L3
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        c<? super T> r10 = this.downstream;
        List<T>[] r11 = this.lists;
        int[] r12 = this.indexes;
        int r13 = r12.length;
        int r14 = 1;
    L6:
        long r15 = this.requested.get();
        long r16 = 0;
    L8:
        if (r16 == r15) goto L43;
        if (this.cancelled == true) goto L11;
        Throwable r17 = this.error.get();
        if (r17 != null) goto L15;
        int r18 = -1;
        T r19 = null;
        int r110 = 0;
    L18:
        if (r110 >= r13) goto L38;
        List<T> r111 = r11[r110];
        int r20 = r12[r110];
        if (r111.size() == r20) goto L37;
        if (r19 != null) goto L24;
        r19 = r111.get(r20);
    L23:
        r18 = r110;
        goto L37
    L24:
        T r21 = r111.get(r20);
        if (this.comparator.compare(r19, r21) <= 0) goto L28;
        boolean r112 = true;
    L29:
        if (r112 == false) goto L37;
        r19 = r21;
        goto L23
    L28:
        r112 = false;
    L31:
        th = move-exception;
        a.a(th);
        cancelAll();
        Arrays.fill(r11, null);
        if (this.error.compareAndSet(null, th) == true) goto L35;
        dc.a.n(th);
    L35:
        r10.onError(this.error.get());
        return;
    L37:
        r110 = r110 + 1;
        goto L18
    L38:
        if (r19 == null) goto L39;
        r10.onNext(r19);
        r12[r18] = r12[r18] + 1;
        r16 = r16 + 1;
        goto L8
    L39:
        Arrays.fill(r11, null);
        r10.onComplete();
        return;
    L15:
        cancelAll();
        Arrays.fill(r11, null);
        r10.onError(r17);
        return;
    L11:
        Arrays.fill(r11, null);
        return;
    L43:
        if (r16 != r15) goto L63;
        if (this.cancelled == true) goto L46;
        Throwable r113 = this.error.get();
        if (r113 != null) goto L50;
        int r22 = 0;
    L53:
        if (r22 >= r13) goto L58;
        if (r12[r22] != r11[r22].size()) goto L56;
        r22 = r22 + 1;
        goto L53
    L56:
        boolean r114 = false;
    L59:
        if (r114 == false) goto L63;
        Arrays.fill(r11, null);
        r10.onComplete();
        return;
    L58:
        r114 = true;
        goto L59
    L50:
        cancelAll();
        Arrays.fill(r11, null);
        r10.onError(r113);
        return;
    L46:
        Arrays.fill(r11, null);
        return;
    L63:
        if (r16 != 0) goto L65;
    L67:
        int r23 = get();
        if (r23 != r14) goto L72;
        r23 = addAndGet(-r14);
        if (r23 != 0) goto L72;
        return;
    L72:
        r14 = r23;
        goto L6
    L65:
        if (r15 == Long.MAX_VALUE) goto L67;
        this.requested.addAndGet(-r16);
        goto L67
    }

    void innerError(Throwable r10) {
        if (this.error.compareAndSet(null, r10) == false) goto L6;
        drain();
        return;
    L6:
        if (r10 == this.error.get()) goto L10;
        dc.a.n(r10);
        return;
    }

    void innerNext(List<T> r10, int r11) {
        this.lists[r11] = r10;
        if (this.remaining.decrementAndGet() != 0) goto L6;
        drain();
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L8;
        b.a(this.requested, r10);
        if (this.remaining.get() != 0) goto L9;
        drain();
        return;
    L9:
        return;
    }
}
