package io.reactivex.subscribers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements j<T>, d {
    private final c<? super T> i;
    private volatile boolean j;
    private final AtomicReference<d> k;
    private final AtomicLong l;
    private io.reactivex.internal.a.d<T> m;

    static final enum EmptySubscriber extends Enum<EmptySubscriber> implements j<Object> {
        private static final /* synthetic */ EmptySubscriber[] $VALUES = null;
        public static final EmptySubscriber INSTANCE = null;

        static {
            EmptySubscriber r0 = new EmptySubscriber("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new EmptySubscriber[]{r0};
        }

        private EmptySubscriber(String r1, int r2) {
            super(r1, r2);
        }

        public static EmptySubscriber valueOf(String r2) {
            return (EmptySubscriber) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmptySubscriber.class, r2), EmptySubscriber.class, "com.obric.memorydata.plugin");
        }

        public static EmptySubscriber[] values() {
            return (EmptySubscriber[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmptySubscriber[].class, "com.obric.memorydata.plugin");
        }

        @Override // org.a.c
        public void onComplete() {
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
        }

        @Override // org.a.c
        public void onNext(Object r1) {
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r2) {
            d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
        }
    }

    public void a() {
    }

    @Override // org.a.d
    public final void cancel() {
        if (this.j == true) goto L6;
        this.j = true;
        SubscriptionHelper.cancel(this.k);
        return;
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        cancel();
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.j;
    }

    @Override // org.a.c
    public void onComplete() {
        if (this.f == true) goto L13;
        this.f = true;
        if (this.k.get() != null) goto L13;
        this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
    L13:
        this.e = Thread.currentThread();     // Catch: Throwable -> L10
        this.d++;     // Catch: Throwable -> L10
        this.i.onComplete();     // Catch: Throwable -> L10
        this.f17155a.countDown();
        return;
    L10:
        th = move-exception;
        this.f17155a.countDown();
        throw th;
    }

    @Override // org.a.c
    public void onError(Throwable r4) {
        if (this.f == true) goto L16;
        this.f = true;
        if (this.k.get() != null) goto L16;
        this.c.add(new NullPointerException("onSubscribe not called in proper order"));
    L16:
        this.e = Thread.currentThread();     // Catch: Throwable -> L13
        this.c.add(r4);     // Catch: Throwable -> L13
        if (r4 != null) goto L10;
        this.c.add(new IllegalStateException("onError received a null Throwable"));     // Catch: Throwable -> L13
    L10:
        this.i.onError(r4);     // Catch: Throwable -> L13
        this.f17155a.countDown();
        return;
    L13:
        th = move-exception;
        this.f17155a.countDown();
        throw th;
    }

    @Override // org.a.c
    public void onNext(T r4) {
        if (this.f == true) goto L7;
        this.f = true;
        if (this.k.get() != null) goto L7;
        this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
    L7:
        this.e = Thread.currentThread();
        if (this.h == 2) goto L21;
        this.f17156b.add(r4);
        if (r4 != null) goto L19;
        this.c.add(new NullPointerException("onNext received a null value"));
    L19:
        this.i.onNext(r4);
        return;
    L21:
        T r5 = this.m.poll();     // Catch: Throwable -> L13
        if (r5 == null) goto L25;
        this.f17156b.add(r5);     // Catch: Throwable -> L13
        goto L21
    L25:
        return;
    L13:
        th = move-exception;
        this.c.add(th);
        this.m.cancel();
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r6) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.memorydata.plugin");
        this.e = Thread.currentThread();
        if (r7 != null) goto L7;
        this.c.add(new NullPointerException("onSubscribe received a null Subscription"));
        return;
    L7:
        if (this.k.compareAndSet(null, r7) == true) goto L13;
        r7.cancel();
        if (this.k.get() == SubscriptionHelper.CANCELLED) goto L35;
        this.c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + r7));
        return;
    L35:
        return;
    L13:
        if (this.g != 0) goto L15;
    L27:
        this.i.onSubscribe(r7);
        long r3 = this.l.getAndSet(0);
        if (r3 == 0) goto L30;
        r7.request(r3);
    L30:
        a();
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r7, io.reactivex.internal.a.d.class) == false) goto L27;
        io.reactivex.internal.a.d<T> r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r7, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
        this.m = r0;
        int r1 = r0.requestFusion(this.g);
        this.h = r1;
        if (r1 != 1) goto L27;
        this.f = true;
        this.e = Thread.currentThread();
    L32:
        T r8 = this.m.poll();     // Catch: Throwable -> L24
        if (r8 == null) goto L22;
        this.f17156b.add(r8);     // Catch: Throwable -> L24
        goto L32
    L22:
        this.d++;     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        this.c.add(th);
    }

    @Override // org.a.d
    public final void request(long r2) {
        SubscriptionHelper.deferredRequest(this.k, this.l, r2);
    }
}
