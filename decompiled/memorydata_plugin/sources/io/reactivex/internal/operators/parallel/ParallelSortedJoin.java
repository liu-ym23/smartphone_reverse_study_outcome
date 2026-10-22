package io.reactivex.internal.operators.parallel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import io.reactivex.j;
import io.reactivex.parallel.a;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class ParallelSortedJoin<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a<List<T>> f17050b;
    final Comparator<? super T> c;

    static final class SortedJoinInnerSubscriber<T> extends AtomicReference<d> implements j<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> r1, int r2) {
            this.parent = r1;
            this.index = r2;
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.a.c
        public void onComplete() {
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.parent.innerError(r1);
        }

        @Override // org.a.c
        public /* synthetic */ void onNext(Object r3) {
            onNext((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
        }

        public void onNext(List<T> r3) {
            List<T> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            this.parent.innerNext(r4, this.index);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            SubscriptionHelper.setOnce(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
        }
    }

    static final class SortedJoinSubscription<T> extends AtomicInteger implements d {
        private static final long serialVersionUID = 3481980673745556697L;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final c<? super T> downstream;
        final AtomicReference<Throwable> error;
        final int[] indexes;
        final List<T>[] lists;
        final AtomicInteger remaining;
        final AtomicLong requested;
        final SortedJoinInnerSubscriber<T>[] subscribers;

        SortedJoinSubscription(c<? super T> r3, int r4, Comparator<? super T> r5) {
            c<? super T> r6 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            Comparator<? super T> r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r5, Comparator.class, "com.obric.memorydata.plugin");
            this.requested = new AtomicLong();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference();
            this.downstream = r6;
            this.comparator = r7;
            SortedJoinInnerSubscriber<T>[] r8 = new SortedJoinInnerSubscriber[r4];
            int r9 = 0;
        L3:
            if (r9 >= r4) goto L5;
            r8[r9] = new SortedJoinInnerSubscriber(this, r9);
            r9 = r9 + 1;
            goto L3
        L5:
            this.subscribers = r8;
            this.lists = new List[r4];
            this.indexes = new int[r4];
            this.remaining.lazySet(r4);
        }

        @Override // org.a.d
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
            SortedJoinInnerSubscriber<T>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L3
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            c<? super T> r2 = this.downstream;
            List<T>[] r3 = this.lists;
            int[] r0 = this.indexes;
            int r4 = r0.length;
            int r6 = 1;
        L6:
            long r7 = this.requested.get();
            long r11 = 0;
        L8:
            if (r11 == r7) goto L43;
            if (this.cancelled == true) goto L11;
            Throwable r9 = (Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L15;
            int r10 = -1;
            T r13 = null;
            int r12 = 0;
        L18:
            if (r12 >= r4) goto L38;
            List<T> r5 = r3[r12];
            int r15 = r0[r12];
            int r16 = r6;
            if (r5.size() == r15) goto L37;
            if (r13 != null) goto L24;
            r13 = r5.get(r15);
        L23:
            r10 = r12;
            goto L37
        L24:
            T r8 = r5.get(r15);
            if (this.comparator.compare(r13, r8) <= 0) goto L28;
            boolean r14 = true;
        L29:
            if (r14 == false) goto L37;
            r13 = r8;
            goto L23
        L28:
            r14 = false;
        L31:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancelAll();
            Arrays.fill(r3, null);
            if (this.error.compareAndSet(null, th) == true) goto L35;
            io.reactivex.d.a.a(th);
        L35:
            r2.onError((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin"));
            return;
        L37:
            r12 = r12 + 1;
            r6 = r16;
            goto L18
        L38:
            int r17 = r6;
            if (r13 == null) goto L40;
            r2.onNext(r13);
            r0[r10] = r0[r10] + 1;
            r11 = r11 + 1;
            r6 = r17;
            goto L8
        L40:
            Arrays.fill(r3, null);
            r2.onComplete();
            return;
        L15:
            cancelAll();
            Arrays.fill(r3, null);
            r2.onError(r9);
            return;
        L11:
            Arrays.fill(r3, null);
            return;
        L43:
            int r18 = r6;
            if (r11 != r7) goto L64;
            if (this.cancelled == true) goto L47;
            Throwable r19 = (Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin");
            if (r19 != null) goto L51;
            int r20 = 0;
        L54:
            if (r20 >= r4) goto L59;
            if (r0[r20] != r3[r20].size()) goto L57;
            r20 = r20 + 1;
            goto L54
        L57:
            boolean r110 = false;
        L60:
            if (r110 == false) goto L64;
            Arrays.fill(r3, null);
            r2.onComplete();
            return;
        L59:
            r110 = true;
            goto L60
        L51:
            cancelAll();
            Arrays.fill(r3, null);
            r2.onError(r19);
            return;
        L47:
            Arrays.fill(r3, null);
            return;
        L64:
            if (r11 != 0) goto L66;
        L68:
            int r21 = get();
            if (r21 != r18) goto L73;
            r21 = addAndGet(-r18);
            if (r21 != 0) goto L73;
            return;
        L73:
            r6 = r21;
            goto L6
        L66:
            if (r7 == Long.MAX_VALUE) goto L68;
            this.requested.addAndGet(-r11);
            goto L68
        }

        void innerError(Throwable r3) {
            if (this.error.compareAndSet(null, r3) == false) goto L6;
            drain();
            return;
        L6:
            if (r3 == this.error.get()) goto L10;
            io.reactivex.d.a.a(r3);
            return;
        }

        void innerNext(List<T> r3, int r4) {
            List<T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            this.lists[r4] = r5;
            if (this.remaining.decrementAndGet() != 0) goto L6;
            drain();
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L8;
            b.a(this.requested, r2);
            if (this.remaining.get() != 0) goto L9;
            drain();
            return;
        L9:
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        SortedJoinSubscription r0 = new SortedJoinSubscription(r5, this.f17050b.a(), this.c);
        r5.onSubscribe(r0);
        this.f17050b.a(r0.subscribers);
    }
}
