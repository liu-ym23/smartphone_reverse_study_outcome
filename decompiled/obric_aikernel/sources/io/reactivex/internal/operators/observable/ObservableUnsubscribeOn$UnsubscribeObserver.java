package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableUnsubscribeOn$UnsubscribeObserver<T> extends AtomicBoolean implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 1015244841293359600L;
    final xb.o<? super T> downstream;
    final xb.p scheduler;
    io.reactivex.disposables.b upstream;

    final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ObservableUnsubscribeOn$UnsubscribeObserver f9557c;

        a(ObservableUnsubscribeOn$UnsubscribeObserver r10) {
            this.f9557c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9557c.upstream.dispose();
        }
    }

    ObservableUnsubscribeOn$UnsubscribeObserver(xb.o<? super T> r10, xb.p r11) {
        this.downstream = r10;
        this.scheduler = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (compareAndSet(false, true) == false) goto L6;
        this.scheduler.c(new a(this));
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get();
    }

    @Override // xb.o
    public void onComplete() {
        if (get() == true) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (get() == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (get() == true) goto L6;
        this.downstream.onNext(r10);
        return;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
