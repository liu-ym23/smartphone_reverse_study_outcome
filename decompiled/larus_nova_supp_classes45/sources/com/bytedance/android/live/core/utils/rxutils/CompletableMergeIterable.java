package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class CompletableMergeIterable extends Completable {
    public final Iterable<? extends CompletableSource> a;

    public static final class MergeCompletableObserver extends AtomicBoolean implements io.reactivex.b {
        private static final long serialVersionUID = -7730517613164279224L;
        final io.reactivex.b downstream;
        final CompositeDisposable set;
        final AtomicInteger wip;

        public void onComplete() {
            if (this.wip.decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (compareAndSet(false, true) == false) goto L9;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r3) {
            this.set.dispose();
            if (compareAndSet(false, true) == false) goto L5;
            this.downstream.onError(r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        public void onSubscribe(Disposable r2) {
            this.set.add(r2);
        }

        public MergeCompletableObserver(io.reactivex.b r1, CompositeDisposable r2, AtomicInteger r3) {
            this.downstream = r1;
            this.set = r2;
            this.wip = r3;
        }
    }

    public CompletableMergeIterable(Iterable<? extends CompletableSource> r1) {
        this.a = r1;
    }

    public final void subscribeActual(io.reactivex.b r6) {
        CompositeDisposable r0 = new CompositeDisposable();
        r6.onSubscribe(r0);
        Iterator r1 = (Iterator) ObjectHelper.requireNonNull(this.a.iterator(), "The source iterator returned is null");     // Catch: Throwable -> L26
        AtomicInteger r2 = new AtomicInteger(1);
        MergeCompletableObserver r3 = new MergeCompletableObserver(r6, r0, r2);
    L6:
        if (r0.isDisposed() == true) goto L7;
        if (r1.hasNext() == false) goto L10;
        if (r0.isDisposed() == true) goto L14;
        CompletableSource r7 = (CompletableSource) ObjectHelper.requireNonNull((CompletableSource) r1.next(), "The iterator returned a null CompletableSource");     // Catch: Throwable -> L20
        if (r0.isDisposed() == true) goto L18;
        r2.getAndIncrement();
        r7.subscribe(r3);
        goto L6
    L18:
        return;
    L20:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r0.dispose();
        r3.onError(th);
        return;
    L14:
        return;
    L10:
        r3.onComplete();
        return;
    L23:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r0.dispose();
        r3.onError(th);
        return;
    L7:
        return;
    L26:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r6.onError(th);
    }
}
