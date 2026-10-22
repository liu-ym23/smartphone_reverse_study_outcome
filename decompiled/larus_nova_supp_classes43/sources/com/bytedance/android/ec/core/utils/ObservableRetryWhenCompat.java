package com.bytedance.android.ec.core.utils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ObservableRetryWhenCompat<T> extends Observable<T> {
    public final Function<? super Observable<Throwable>, ? extends ObservableSource<?>> a;
    public final ObservableSource<T> b;

    public static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final Observer<? super T> downstream;
        final AtomicThrowable error;
        final RepeatWhenObserver<T>.InnerRepeatObserver inner;
        final Subject<Throwable> signaller;
        final ObservableSource<T> source;
        final AtomicReference<Disposable> upstream;
        final AtomicInteger wip;

        public final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            private static final long serialVersionUID = 3254781284376480842L;
            final /* synthetic */ RepeatWhenObserver this$0;

            public void onComplete() {
                this.this$0.innerComplete();
            }

            public InnerRepeatObserver(RepeatWhenObserver r1) {
                this.this$0 = r1;
            }

            public void onError(Throwable r10) {
                this.this$0.innerError(r10);
            }

            public void onNext(Object r1) {
                this.this$0.innerNext();
            }

            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.inner);
        }

        public void innerComplete() {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.inner);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        public void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            if (isDisposed() == true) goto L6;
            if (this.active == true) goto L11;
            this.active = true;
            this.source.subscribe(this);
        L11:
            if (this.wip.decrementAndGet() != 0) goto L5;
            return;
        }

        public void innerNext() {
            subscribeNext();
        }

        public void innerError(Throwable r10) {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.c(this.downstream, r10, this, this.error);
        }

        public void onError(Throwable r10) {
            DisposableHelper.replace(this.upstream, null);
            this.active = false;
            this.signaller.onNext(r10);
        }

        public void onNext(T r10) {
            io.reactivex.internal.util.g.e(this.downstream, r10, this, this.error);
        }

        public void onSubscribe(Disposable r10) {
            DisposableHelper.replace(this.upstream, r10);
        }

        public RepeatWhenObserver(Observer<? super T> r1, Subject<Throwable> r10, ObservableSource<T> r11) {
            this.downstream = r1;
            this.signaller = r10;
            this.source = r11;
            this.wip = new AtomicInteger();
            this.error = new AtomicThrowable();
            this.inner = new InnerRepeatObserver(this);
            this.upstream = new AtomicReference();
        }
    }

    public final void subscribeActual(Observer<? super T> r10) {
        Subject r0 = PublishSubject.create().toSerialized();
        ObservableSource r1 = (ObservableSource) ObjectHelper.requireNonNull((ObservableSource) this.a.apply(r0), "The handler returned a null ObservableSource");     // Catch: Throwable -> L6
        RepeatWhenObserver r11 = new RepeatWhenObserver(r10, r0, this.b);
        r10.onSubscribe(r11);
        r1.subscribe(r11.inner);
        r11.subscribeNext();
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r10);
    }

    public ObservableRetryWhenCompat(Observable r1, ha3.b r10) {
        this.b = r1;
        this.a = r10;
    }
}
