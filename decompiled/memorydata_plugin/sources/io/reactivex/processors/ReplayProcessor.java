package io.reactivex.processors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class ReplayProcessor<T> extends io.reactivex.processors.a<T> {
    static final ReplaySubscription[] e = null;
    static final ReplaySubscription[] f = null;
    private static final Object[] g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a<T> f17165b;
    boolean c;
    final AtomicReference<ReplaySubscription<T>[]> d;

    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T r1) {
            this.value = r1;
        }
    }

    static final class ReplaySubscription<T> extends AtomicInteger implements d {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final c<? super T> downstream;
        long emitted;
        Object index;
        final AtomicLong requested;
        final ReplayProcessor<T> state;

        ReplaySubscription(c<? super T> r3, ReplayProcessor<T> r4) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.state = r4;
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.state.b(this);
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            this.state.f17165b.a(this);
            return;
        }
    }

    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T r1, long r2) {
            this.value = r1;
            this.time = r2;
        }
    }

    interface a<T> {
        void a();

        void a(ReplaySubscription<T> r1);

        void a(T r1);

        void a(Throwable r1);
    }

    static {
        g = new Object[0];
        e = new ReplaySubscription[0];
        f = new ReplaySubscription[0];
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        ReplaySubscription<T> r0 = new ReplaySubscription(r4, this);
        r4.onSubscribe(r0);
        if (a(r0) == true) goto L5;
    L8:
        this.f17165b.a(r0);
        return;
    L5:
        if (r0.cancelled == false) goto L8;
        b(r0);
    }

    boolean a(ReplaySubscription<T> r5) {
    L2:
        ReplaySubscription<T>[] r0 = (ReplaySubscription[]) ZeusTransformUtils.preCheckCast(this.d.get(), ReplaySubscription[].class, "com.obric.memorydata.plugin");
        if (r0 == f) goto L4;
        int r1 = r0.length;
        ReplaySubscription<T>[] r3 = new ReplaySubscription[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void b(ReplaySubscription<T> r7) {
    L2:
        ReplaySubscription<T>[] r0 = (ReplaySubscription[]) ZeusTransformUtils.preCheckCast(this.d.get(), ReplaySubscription[].class, "com.obric.memorydata.plugin");
        if (r0 == f) goto L21;
        if (r0 == e) goto L29;
        int r1 = r0.length;
        int r2 = -1;
        int r4 = 0;
    L8:
        if (r4 >= r1) goto L13;
        if (r0[r4] == r7) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        r2 = r4;
    L13:
        if (r2 < 0) goto L14;
        if (r1 != 1) goto L18;
        ReplaySubscription<T>[] r3 = e;
    L20:
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return;
    L18:
        ReplaySubscription<T>[] r5 = new ReplaySubscription[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L20
    L14:
        return;
    L29:
        return;
    }

    @Override // org.a.c
    public void onComplete() {
        if (this.c == false) goto L5;
        return;
    L5:
        this.c = true;
        a<T> r0 = this.f17165b;
        r0.a();
        ReplaySubscription<T>[] r4 = (ReplaySubscription[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(f), ReplaySubscription[].class, "com.obric.memorydata.plugin");
        int r1 = r4.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r0.a(r4[r2]);
        r2 = r2 + 1;
        goto L6
    }

    @Override // org.a.c
    public void onError(Throwable r4) {
        io.reactivex.internal.functions.a.a(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.c == false) goto L6;
        io.reactivex.d.a.a(r4);
        return;
    L6:
        this.c = true;
        a<T> r0 = this.f17165b;
        r0.a(r4);
        ReplaySubscription<T>[] r3 = (ReplaySubscription[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(f), ReplaySubscription[].class, "com.obric.memorydata.plugin");
        int r5 = r3.length;
        int r1 = 0;
    L7:
        if (r1 >= r5) goto L9;
        r0.a(r3[r1]);
        r1 = r1 + 1;
        goto L7
    }

    @Override // org.a.c
    public void onNext(T r4) {
        io.reactivex.internal.functions.a.a(r4, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.c == false) goto L5;
        return;
    L5:
        a<T> r0 = this.f17165b;
        r0.a(r4);
        ReplaySubscription<T>[] r3 = (ReplaySubscription[]) ZeusTransformUtils.preCheckCast(this.d.get(), ReplaySubscription[].class, "com.obric.memorydata.plugin");
        int r5 = r3.length;
        int r1 = 0;
    L6:
        if (r1 >= r5) goto L8;
        r0.a(r3[r1]);
        r1 = r1 + 1;
        goto L6
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (this.c == false) goto L6;
        r4.cancel();
        return;
    L6:
        r4.request(Long.MAX_VALUE);
    }
}
