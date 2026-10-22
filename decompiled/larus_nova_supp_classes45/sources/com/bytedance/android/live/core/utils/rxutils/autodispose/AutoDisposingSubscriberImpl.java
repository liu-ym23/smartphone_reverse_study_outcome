package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
final class AutoDisposingSubscriberImpl<T> extends AtomicInteger implements io.reactivex.g, wwc.c, Disposable {
    private final wwc.b<? super T> delegate;
    private final AtomicThrowable error;
    final AtomicReference<wwc.c> mainSubscription;
    private final AtomicReference<wwc.c> ref;
    private final AtomicLong requested;
    private final CompletableSource scope;
    final AtomicReference<Disposable> scopeDisposable;

    public class a extends io.reactivex.observers.b {
        public final /* synthetic */ AutoDisposingSubscriberImpl b;

        public final void onComplete() {
            this.b.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoSubscriptionHelper.cancel(this.b.mainSubscription);
        }

        public a(AutoDisposingSubscriberImpl r1) {
            this.b = r1;
        }

        public final void onError(Throwable r3) {
            this.b.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            this.b.onError(r3);
        }
    }

    public void cancel() {
        AutoDisposableHelper.dispose(this.scopeDisposable);
        AutoSubscriptionHelper.cancel(this.mainSubscription);
    }

    public boolean isDisposed() {
        if (this.mainSubscription.get() != AutoSubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public void onComplete() {
        if (isDisposed() == true) goto L11;
        this.mainSubscription.lazySet(AutoSubscriptionHelper.CANCELLED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        wwc.b<? super T> r0 = this.delegate;
        AtomicThrowable r1 = this.error;
        if (getAndIncrement() != 0) goto L12;
        Throwable r2 = r1.terminate();
        if (r2 == null) goto L9;
        r0.onError(r2);
        return;
    L9:
        r0.onComplete();
        return;
    L12:
        return;
    }

    public wwc.b<? super T> delegateSubscriber() {
        return this.delegate;
    }

    public void dispose() {
        cancel();
    }

    public void onError(Throwable r4) {
        if (isDisposed() == true) goto L11;
        this.mainSubscription.lazySet(AutoSubscriptionHelper.CANCELLED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        wwc.b<? super T> r0 = this.delegate;
        AtomicThrowable r1 = this.error;
        if (r1.addThrowable(r4) == true) goto L7;
        RxJavaPlugins.onError(r4);
        return;
    L7:
        if (getAndIncrement() != 0) goto L12;
        r0.onError(r1.terminate());
        return;
    L12:
        return;
    }

    public void onNext(T r6) {
        if (isDisposed() == true) goto L18;
        wwc.b<? super T> r0 = this.delegate;
        AtomicThrowable r1 = this.error;
        boolean r3 = false;
        if (get() == 0) goto L7;
    L15:
        if (r3 == false) goto L19;
        this.mainSubscription.lazySet(AutoSubscriptionHelper.CANCELLED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        return;
    L19:
        return;
    L7:
        if (compareAndSet(0, 1) == false) goto L15;
        r0.onNext(r6);
        if (decrementAndGet() == 0) goto L15;
        Throwable r7 = r1.terminate();
        if (r7 == null) goto L13;
        r0.onError(r7);
    L14:
        r3 = true;
        goto L15
    L13:
        r0.onComplete();
        goto L14
    }

    public void onSubscribe(wwc.c r6) {
        a r0 = new a(this);
        if (l.b(this.scopeDisposable, r0, AutoDisposingSubscriberImpl.class) == false) goto L22;
        this.delegate.onSubscribe(this);
        this.scope.subscribe(r0);
        AtomicReference<wwc.c> r1 = this.mainSubscription;
        q.a(r6, "next is null");
    L5:
        boolean r3 = false;
        if (r1.compareAndSet(null, r6) == true) goto L7;
        if (r1.get() == null) goto L5;
        boolean r2 = false;
    L11:
        if (r2 == true) goto L15;
        r6.cancel();
        if (r1.get() == AutoSubscriptionHelper.CANCELLED) goto L16;
        l.a(AutoDisposingSubscriberImpl.class);
    L16:
        if (r3 == false) goto L23;
        AutoSubscriptionHelper.deferredSetOnce(this.ref, this.requested, r6);
        return;
    L23:
        return;
    L15:
        r3 = true;
        goto L16
    L7:
        r2 = true;
        goto L11
    }

    public void request(long r3) {
        AutoSubscriptionHelper.deferredRequest(this.ref, this.requested, r3);
    }

    public AutoDisposingSubscriberImpl(CompletableSource r2, wwc.b<? super T> r3) {
        this.mainSubscription = new AtomicReference();
        this.scopeDisposable = new AtomicReference();
        this.error = new AtomicThrowable();
        this.ref = new AtomicReference();
        this.requested = new AtomicLong();
        this.scope = r2;
        this.delegate = r3;
    }
}
