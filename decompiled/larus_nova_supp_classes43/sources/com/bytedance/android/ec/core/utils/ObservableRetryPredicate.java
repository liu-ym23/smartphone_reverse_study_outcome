package com.bytedance.android.ec.core.utils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ObservableRetryPredicate<T> extends Observable<T> {
    public final Predicate<? super Throwable> a;
    public final Observable b;
    public final long c;

    public static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Observer<? super T> downstream;
        final Predicate<? super Throwable> predicate;
        long remaining;
        final ObservableSource<? extends T> source;
        final SequentialDisposable upstream;

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void subscribeNext() {
            if (getAndIncrement() != 0) goto L10;
            int r0 = 1;
        L6:
            if (this.upstream.isDisposed() == true) goto L7;
            this.source.subscribe(this);
            r0 = addAndGet(-r0);
            if (r0 != 0) goto L6;
            return;
        L7:
            return;
        }

        public void onError(Throwable r10) {
            long r0 = this.remaining;
            if (r0 == Long.MAX_VALUE) goto L6;
            this.remaining = r0 - 1;
        L6:
            if (r0 != 0) goto L17;
            this.downstream.onError(r10);
            return;
        L17:
            if (this.predicate.test(r10) == true) goto L12;
            this.downstream.onError(r10);
            return;
        L12:
            subscribeNext();
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
        }

        public void onNext(T r10) {
            this.downstream.onNext(r10);
        }

        public void onSubscribe(Disposable r10) {
            this.upstream.replace(r10);
        }

        public RepeatObserver(Observer<? super T> r1, long r10, Predicate<? super Throwable> r11, SequentialDisposable r12, ObservableSource<? extends T> r13) {
            this.downstream = r1;
            this.upstream = r12;
            this.source = r13;
            this.predicate = r11;
            this.remaining = r10;
        }
    }

    public final void subscribeActual(Observer<? super T> r10) {
        SequentialDisposable r11 = new SequentialDisposable();
        r10.onSubscribe(r11);
        new RepeatObserver(r10, this.c, this.a, r11, this.b).subscribeNext();
    }

    public ObservableRetryPredicate(Observable r1, Predicate r10) {
        this.b = r1;
        this.a = r10;
        this.c = 3;
    }
}
