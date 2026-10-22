package io.reactivex.processors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class AsyncProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final AsyncSubscription[] f17161b = null;
    static final AsyncSubscription[] c = null;
    final AtomicReference<AsyncSubscription<T>[]> d;
    Throwable e;
    T f;

    static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        AsyncSubscription(c<? super T> r3, AsyncProcessor<T> r4) {
            super((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin"));
            this.parent = r4;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            if (super.tryCancel() == false) goto L6;
            this.parent.b(this);
            return;
        }

        void onComplete() {
            if (isCancelled() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        void onError(Throwable r2) {
            if (isCancelled() == false) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            this.downstream.onError(r2);
        }
    }

    static {
        f17161b = new AsyncSubscription[0];
        c = new AsyncSubscription[0];
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        AsyncSubscription<T> r0 = new AsyncSubscription(r4, this);
        r4.onSubscribe(r0);
        if (a(r0) == true) goto L5;
        Throwable r1 = this.e;
        if (r1 == null) goto L10;
        r4.onError(r1);
        return;
    L10:
        T r2 = this.f;
        if (r2 == null) goto L13;
        r0.complete(r2);
        return;
    L13:
        r0.onComplete();
        return;
    L5:
        if (r0.isCancelled() == false) goto L15;
        b(r0);
        return;
    }

    boolean a(AsyncSubscription<T> r5) {
    L2:
        AsyncSubscription<T>[] r0 = (AsyncSubscription[]) ZeusTransformUtils.preCheckCast(this.d.get(), AsyncSubscription[].class, "com.obric.memorydata.plugin");
        if (r0 == c) goto L4;
        int r1 = r0.length;
        AsyncSubscription<T>[] r3 = new AsyncSubscription[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void b(AsyncSubscription<T> r7) {
    L2:
        AsyncSubscription<T>[] r0 = (AsyncSubscription[]) ZeusTransformUtils.preCheckCast(this.d.get(), AsyncSubscription[].class, "com.obric.memorydata.plugin");
        int r1 = r0.length;
        if (r1 == 0) goto L4;
        int r2 = -1;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L11;
        if (r0[r4] == r7) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        r2 = r4;
    L11:
        if (r2 < 0) goto L12;
        if (r1 != 1) goto L16;
        AsyncSubscription<T>[] r3 = f17161b;
    L18:
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return;
    L16:
        AsyncSubscription<T>[] r5 = new AsyncSubscription[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L18
    L12:
        return;
    }

    @Override // org.a.c
    public void onComplete() {
        AsyncSubscription<T>[] r0 = this.d.get();
        AsyncSubscription<T>[] r1 = c;
        if (r0 != r1) goto L5;
        return;
    L5:
        T r2 = this.f;
        AsyncSubscription[] r4 = (AsyncSubscription[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(r1), AsyncSubscription[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
        if (r2 != null) goto L10;
        int r5 = r4.length;
    L8:
        if (r3 >= r5) goto L13;
        r4[r3].onComplete();
        r3 = r3 + 1;
        goto L8
    L13:
        return;
    L10:
        int r6 = r4.length;
    L11:
        if (r3 >= r6) goto L16;
        r4[r3].complete(r2);
        r3 = r3 + 1;
        goto L11
    }

    @Override // org.a.c
    public void onError(Throwable r4) {
        io.reactivex.internal.functions.a.a(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncSubscription<T>[] r0 = this.d.get();
        AsyncSubscription<T>[] r1 = c;
        if (r0 != r1) goto L6;
        io.reactivex.d.a.a(r4);
        return;
    L6:
        this.f = null;
        this.e = r4;
        AsyncSubscription[] r3 = (AsyncSubscription[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(r1), AsyncSubscription[].class, "com.obric.memorydata.plugin");
        int r2 = r3.length;
        int r5 = 0;
    L7:
        if (r5 >= r2) goto L9;
        r3[r5].onError(r4);
        r5 = r5 + 1;
        goto L7
    }

    @Override // org.a.c
    public void onNext(T r3) {
        io.reactivex.internal.functions.a.a(r3, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.d.get() != c) goto L5;
        return;
    L5:
        this.f = r3;
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (this.d.get() != c) goto L6;
        r4.cancel();
        return;
    L6:
        r4.request(Long.MAX_VALUE);
    }
}
