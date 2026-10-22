package io.reactivex.processors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class PublishProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final PublishSubscription[] f17164b = null;
    static final PublishSubscription[] c = null;
    final AtomicReference<PublishSubscription<T>[]> d;
    Throwable e;

    static final class PublishSubscription<T> extends AtomicLong implements d {
        private static final long serialVersionUID = 3562861878281475070L;
        final c<? super T> downstream;
        final PublishProcessor<T> parent;

        PublishSubscription(c<? super T> r3, PublishProcessor<T> r4) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.parent = r4;
        }

        @Override // org.a.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.b(this);
            return;
        }

        public boolean isCancelled() {
            if (get() != Long.MIN_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isFull() {
            if (get() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void onComplete() {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r5) {
            if (get() == Long.MIN_VALUE) goto L5;
            this.downstream.onError(r5);
            return;
        L5:
            io.reactivex.d.a.a(r5);
        }

        public void onNext(T r5) {
            long r0 = get();
            if (r0 != Long.MIN_VALUE) goto L6;
            return;
        L6:
            if (r0 == 0) goto L8;
            this.downstream.onNext(r5);
            io.reactivex.internal.util.b.d(this, 1);
            return;
        L8:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.b(this, r2);
            return;
        }
    }

    static {
        f17164b = new PublishSubscription[0];
        c = new PublishSubscription[0];
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        PublishSubscription<T> r0 = new PublishSubscription(r4, this);
        r4.onSubscribe(r0);
        if (a(r0) == true) goto L5;
        Throwable r2 = this.e;
        if (r2 == null) goto L10;
        r4.onError(r2);
        return;
    L10:
        r4.onComplete();
        return;
    L5:
        if (r0.isCancelled() == false) goto L12;
        b(r0);
        return;
    }

    boolean a(PublishSubscription<T> r5) {
    L2:
        PublishSubscription<T>[] r0 = (PublishSubscription[]) ZeusTransformUtils.preCheckCast(this.d.get(), PublishSubscription[].class, "com.obric.memorydata.plugin");
        if (r0 == f17164b) goto L4;
        int r1 = r0.length;
        PublishSubscription<T>[] r3 = new PublishSubscription[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void b(PublishSubscription<T> r7) {
    L2:
        PublishSubscription<T>[] r0 = (PublishSubscription[]) ZeusTransformUtils.preCheckCast(this.d.get(), PublishSubscription[].class, "com.obric.memorydata.plugin");
        if (r0 == f17164b) goto L21;
        if (r0 == c) goto L29;
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
        PublishSubscription<T>[] r3 = c;
    L20:
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return;
    L18:
        PublishSubscription<T>[] r5 = new PublishSubscription[r1 - 1];
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
        PublishSubscription<T>[] r0 = this.d.get();
        PublishSubscription<T>[] r1 = f17164b;
        if (r0 != r1) goto L5;
        return;
    L5:
        PublishSubscription[] r3 = (PublishSubscription[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(r1), PublishSubscription[].class, "com.obric.memorydata.plugin");
        int r2 = r3.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L8;
        r3[r4].onComplete();
        r4 = r4 + 1;
        goto L6
    }

    @Override // org.a.c
    public void onError(Throwable r4) {
        io.reactivex.internal.functions.a.a(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] r0 = this.d.get();
        PublishSubscription<T>[] r1 = f17164b;
        if (r0 != r1) goto L6;
        io.reactivex.d.a.a(r4);
        return;
    L6:
        this.e = r4;
        PublishSubscription[] r3 = (PublishSubscription[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(r1), PublishSubscription[].class, "com.obric.memorydata.plugin");
        int r2 = r3.length;
        int r5 = 0;
    L7:
        if (r5 >= r2) goto L9;
        r3[r5].onError(r4);
        r5 = r5 + 1;
        goto L7
    }

    @Override // org.a.c
    public void onNext(T r4) {
        io.reactivex.internal.functions.a.a(r4, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription[] r3 = (PublishSubscription[]) ZeusTransformUtils.preCheckCast(this.d.get(), PublishSubscription[].class, "com.obric.memorydata.plugin");
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].onNext(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (this.d.get() != f17164b) goto L6;
        r4.cancel();
        return;
    L6:
        r4.request(Long.MAX_VALUE);
    }
}
