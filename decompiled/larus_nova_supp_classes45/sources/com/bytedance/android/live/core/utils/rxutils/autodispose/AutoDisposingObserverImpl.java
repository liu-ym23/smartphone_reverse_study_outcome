package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
final class AutoDisposingObserverImpl<T> extends AtomicInteger implements Observer, Disposable {
    private final Observer<? super T> delegate;
    private final AtomicThrowable error;
    final AtomicReference<Disposable> mainDisposable;
    private final CompletableSource scope;
    final AtomicReference<Disposable> scopeDisposable;

    public class a extends io.reactivex.observers.b {
        public final /* synthetic */ AutoDisposingObserverImpl b;

        public final void onComplete() {
            this.b.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(this.b.mainDisposable);
        }

        public a(AutoDisposingObserverImpl r1) {
            this.b = r1;
        }

        public final void onError(Throwable r3) {
            this.b.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            this.b.onError(r3);
        }
    }

    public void dispose() {
        AutoDisposableHelper.dispose(this.scopeDisposable);
        AutoDisposableHelper.dispose(this.mainDisposable);
    }

    public boolean isDisposed() {
        if (this.mainDisposable.get() != AutoDisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    public void onComplete() {
        if (isDisposed() == true) goto L11;
        this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        Observer<? super T> r0 = this.delegate;
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

    public Observer<? super T> delegateObserver() {
        return this.delegate;
    }

    public void onError(Throwable r4) {
        if (isDisposed() == true) goto L11;
        this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        Observer<? super T> r0 = this.delegate;
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
        Observer<? super T> r0 = this.delegate;
        AtomicThrowable r1 = this.error;
        boolean r3 = false;
        if (get() == 0) goto L7;
    L15:
        if (r3 == false) goto L19;
        this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
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

    public void onSubscribe(Disposable r4) {
        a r0 = new a(this);
        if (l.b(this.scopeDisposable, r0, AutoDisposingObserverImpl.class) == false) goto L6;
        this.delegate.onSubscribe(this);
        this.scope.subscribe(r0);
        l.b(this.mainDisposable, r4, AutoDisposingObserverImpl.class);
        return;
    }

    public AutoDisposingObserverImpl(CompletableSource r2, Observer<? super T> r3) {
        this.mainDisposable = new AtomicReference();
        this.scopeDisposable = new AtomicReference();
        this.error = new AtomicThrowable();
        this.scope = r2;
        this.delegate = r3;
    }
}
