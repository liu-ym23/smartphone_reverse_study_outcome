package io.reactivex.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.t;
import io.reactivex.x;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements c, m<T>, t<T>, x<T> {
    private final t<? super T> i;
    private final AtomicReference<io.reactivex.disposables.b> j;
    private io.reactivex.internal.a.b<T> k;

    static final enum EmptyObserver extends Enum<EmptyObserver> implements t<Object> {
        private static final /* synthetic */ EmptyObserver[] $VALUES = null;
        public static final EmptyObserver INSTANCE = null;

        static {
            EmptyObserver r0 = new EmptyObserver("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new EmptyObserver[]{r0};
        }

        private EmptyObserver(String r1, int r2) {
            super(r1, r2);
        }

        public static EmptyObserver valueOf(String r2) {
            return (EmptyObserver) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmptyObserver.class, r2), EmptyObserver.class, "com.obric.memorydata.plugin");
        }

        public static EmptyObserver[] values() {
            return (EmptyObserver[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmptyObserver[].class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.t
        public void onComplete() {
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
        }

        @Override // io.reactivex.t
        public void onNext(Object r1) {
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r2) {
            io.reactivex.disposables.b r1 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r2, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        }
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        DisposableHelper.dispose(this.j);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.j.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.c
    public void onComplete() {
        if (this.f == true) goto L13;
        this.f = true;
        if (this.j.get() != null) goto L13;
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

    @Override // io.reactivex.c
    public void onError(Throwable r4) {
        if (this.f == true) goto L17;
        this.f = true;
        if (this.j.get() != null) goto L17;
        this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
    L17:
        this.e = Thread.currentThread();     // Catch: Throwable -> L14
        if (r4 != null) goto L10;
        this.c.add(new NullPointerException("onError received a null Throwable"));     // Catch: Throwable -> L14
    L11:
        this.i.onError(r4);     // Catch: Throwable -> L14
        this.f17155a.countDown();
        return;
    L10:
        this.c.add(r4);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.f17155a.countDown();
        throw th;
    }

    @Override // io.reactivex.t
    public void onNext(T r4) {
        if (this.f == true) goto L7;
        this.f = true;
        if (this.j.get() != null) goto L7;
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
        T r5 = this.k.poll();     // Catch: Throwable -> L13
        if (r5 == null) goto L25;
        this.f17156b.add(r5);     // Catch: Throwable -> L13
        goto L21
    L25:
        return;
    L13:
        th = move-exception;
        this.c.add(th);
        this.k.dispose();
    }

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b r5) {
        io.reactivex.disposables.b r6 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        this.e = Thread.currentThread();
        if (r6 != null) goto L7;
        this.c.add(new NullPointerException("onSubscribe received a null Subscription"));
        return;
    L7:
        if (this.j.compareAndSet(null, r6) == true) goto L13;
        r6.dispose();
        if (this.j.get() == DisposableHelper.DISPOSED) goto L32;
        this.c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + r6));
        return;
    L32:
        return;
    L13:
        if (this.g != 0) goto L15;
    L27:
        this.i.onSubscribe(r6);
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r6, io.reactivex.internal.a.b.class) == false) goto L27;
        io.reactivex.internal.a.b<T> r0 = (io.reactivex.internal.a.b) ZeusTransformUtils.preCheckCast(r6, io.reactivex.internal.a.b.class, "com.obric.memorydata.plugin");
        this.k = r0;
        int r1 = r0.requestFusion(this.g);
        this.h = r1;
        if (r1 != 1) goto L27;
        this.f = true;
        this.e = Thread.currentThread();
    L29:
        T r7 = this.k.poll();     // Catch: Throwable -> L24
        if (r7 == null) goto L22;
        this.f17156b.add(r7);     // Catch: Throwable -> L24
        goto L29
    L22:
        this.d++;     // Catch: Throwable -> L24
        this.j.lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        this.c.add(th);
    }

    @Override // io.reactivex.m
    public void onSuccess(T r1) {
        onNext(r1);
        onComplete();
    }
}
