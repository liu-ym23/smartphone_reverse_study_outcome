package com.bytedance.android.ec.core.rxjava;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.b;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECCompletableMergeArray extends Completable {
    public final CompletableSource[] a;

    public static final class InnerCompletableObserver extends AtomicInteger implements b {
        private static final long serialVersionUID = -8360547806504310570L;
        final b downstream;
        final AtomicBoolean once;
        final CompositeDisposable set;

        public void onComplete() {
            if (decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (this.once.compareAndSet(false, true) == false) goto L9;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r10) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true) == false) goto L5;
            this.downstream.onError(r10);
            return;
        L5:
            RxJavaPlugins.onError(r10);
        }

        public void onSubscribe(Disposable r10) {
            this.set.add(r10);
        }

        public InnerCompletableObserver(b r1, AtomicBoolean r10, CompositeDisposable r11, int r12) {
            this.downstream = r1;
            this.once = r10;
            this.set = r11;
            lazySet(r12);
        }
    }

    public ECCompletableMergeArray(CompletableSource[] r1) {
        this.a = r1;
    }

    public final void subscribeActual(b r10) {
        CompositeDisposable r0 = new CompositeDisposable();
        InnerCompletableObserver r11 = new InnerCompletableObserver(r10, new AtomicBoolean(), r0, this.a.length + 1);
        r10.onSubscribe(r0);
        CompletableSource[] r12 = this.a;
        int r1 = r12.length;
        int r13 = 0;
    L3:
        if (r13 >= r1) goto L11;
        CompletableSource r14 = r12[r13];
        if (r0.isDisposed() == true) goto L6;
        if (r14 == null) goto L8;
        r14.subscribe(r11);
        r13 = r13 + 1;
        goto L3
    L8:
        r0.dispose();
        r11.onError(new NullPointerException("A completable source is null"));
        return;
    L6:
        return;
    L11:
        r11.onComplete();
    }
}
