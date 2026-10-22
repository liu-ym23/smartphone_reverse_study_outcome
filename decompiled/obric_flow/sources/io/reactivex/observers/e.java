package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import mt.b0;
import mt.j;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements u, j, b0, mt.b, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f18183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VolatileSizeArrayList f18184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VolatileSizeArrayList f18185c;
    public boolean d;
    public final u e;
    public final AtomicReference f;

    public e() {
        TestObserver$EmptyObserver r5 = TestObserver$EmptyObserver.INSTANCE;
        this.f18184b = new VolatileSizeArrayList();
        this.f18185c = new VolatileSizeArrayList();
        this.f18183a = new CountDownLatch(1);
        this.f = new AtomicReference();
        this.e = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f.get());
    }

    @Override // mt.u
    public final void onComplete() {
        CountDownLatch r5 = this.f18183a;
        if (this.d == true) goto L13;
        this.d = true;
        if (this.f.get() != null) goto L13;
        IllegalStateException r10 = new IllegalStateException("onSubscribe not called in proper order");
        this.f18185c.add(r10);
    L13:
        Thread.currentThread();     // Catch: Throwable -> L10
        this.e.onComplete();     // Catch: Throwable -> L10
        r5.countDown();
        return;
    L10:
        th = move-exception;
        r5.countDown();
        throw th;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        CountDownLatch r10 = this.f18183a;
        boolean r11 = this.d;
        VolatileSizeArrayList r12 = this.f18185c;
        if (r11 == true) goto L18;
        this.d = true;
        if (this.f.get() != null) goto L18;
        r12.add(new IllegalStateException("onSubscribe not called in proper order"));
    L18:
        Thread.currentThread();     // Catch: Throwable -> L10
        if (r5 != null) goto L12;
        r12.add(new NullPointerException("onError received a null Throwable"));     // Catch: Throwable -> L10
    L13:
        this.e.onError(r5);     // Catch: Throwable -> L10
        r10.countDown();
        return;
    L12:
        r12.add(r5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r10.countDown();
        throw th;
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        boolean r10 = this.d;
        VolatileSizeArrayList r11 = this.f18185c;
        if (r10 == true) goto L7;
        this.d = true;
        if (this.f.get() != null) goto L7;
        r11.add(new IllegalStateException("onSubscribe not called in proper order"));
    L7:
        Thread.currentThread();
        this.f18184b.add(r5);
        if (r5 != null) goto L10;
        r11.add(new NullPointerException("onNext received a null value"));
    L10:
        this.e.onNext(r5);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        Thread.currentThread();
        VolatileSizeArrayList r10 = this.f18185c;
        if (r5 != null) goto L6;
        r10.add(new NullPointerException("onSubscribe received a null Subscription"));
        return;
    L6:
        AtomicReference r11 = this.f;
    L8:
        if (r11.compareAndSet(null, r5) == true) goto L9;
        if (r11.get() == null) goto L8;
        r5.dispose();
        if (r11.get() == DisposableHelper.DISPOSED) goto L20;
        r10.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + r5));
        return;
    L20:
        return;
    L9:
        this.e.onSubscribe(r5);
    }

    @Override // mt.j
    public final void onSuccess(Object r5) {
        onNext(r5);
        onComplete();
    }
}
