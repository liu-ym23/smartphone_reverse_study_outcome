package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableRetryWhen$RepeatWhenObserver<T> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 802743776666017014L;
    volatile boolean active;
    final xb.o<? super T> downstream;
    final AtomicThrowable error;
    final ObservableRetryWhen$RepeatWhenObserver<T>.InnerRepeatObserver inner;
    final io.reactivex.subjects.a<Throwable> signaller;
    final xb.n<T> source;
    final AtomicReference<io.reactivex.disposables.b> upstream;
    final AtomicInteger wip;

    final class InnerRepeatObserver extends AtomicReference<io.reactivex.disposables.b> implements xb.o<Object> {
        private static final long serialVersionUID = 3254781284376480842L;
        final /* synthetic */ ObservableRetryWhen$RepeatWhenObserver this$0;

        InnerRepeatObserver(ObservableRetryWhen$RepeatWhenObserver r10) {
            this.this$0 = r10;
        }

        @Override // xb.o
        public void onComplete() {
            this.this$0.innerComplete();
        }

        @Override // xb.o
        public void onError(Throwable r10) {
            this.this$0.innerError(r10);
        }

        @Override // xb.o
        public void onNext(Object r10) {
            this.this$0.innerNext();
        }

        @Override // xb.o
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    ObservableRetryWhen$RepeatWhenObserver(xb.o<? super T> r10, io.reactivex.subjects.a<Throwable> r11, xb.n<T> r12) {
        this.downstream = r10;
        this.signaller = r11;
        this.source = r12;
        this.wip = new AtomicInteger();
        this.error = new AtomicThrowable();
        this.inner = new InnerRepeatObserver(this);
        this.upstream = new AtomicReference();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.inner);
    }

    void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        io.reactivex.internal.util.e.b(this.downstream, this, this.error);
    }

    void innerError(Throwable r10) {
        DisposableHelper.dispose(this.upstream);
        io.reactivex.internal.util.e.d(this.downstream, r10, this, this.error);
    }

    void innerNext() {
        subscribeNext();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // xb.o
    public void onComplete() {
        DisposableHelper.dispose(this.inner);
        io.reactivex.internal.util.e.b(this.downstream, this, this.error);
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        DisposableHelper.replace(this.upstream, null);
        this.active = false;
        this.signaller.onNext(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        io.reactivex.internal.util.e.f(this.downstream, r10, this, this.error);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.replace(this.upstream, r10);
    }

    void subscribeNext() {
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
}
