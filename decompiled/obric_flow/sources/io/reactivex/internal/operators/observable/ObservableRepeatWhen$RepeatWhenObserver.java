package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableRepeatWhen$RepeatWhenObserver<T> extends AtomicInteger implements mt.u, Disposable {
    private static final long serialVersionUID = 802743776666017014L;
    volatile boolean active;
    final mt.u downstream;
    final AtomicThrowable error;
    final ObservableRepeatWhen$RepeatWhenObserver<T>.InnerRepeatObserver inner;
    final io.reactivex.subjects.h signaller;
    final mt.s source;
    final AtomicReference<Disposable> upstream;
    final AtomicInteger wip;

    public final class InnerRepeatObserver extends AtomicReference<Disposable> implements mt.u {
        private static final long serialVersionUID = 3254781284376480842L;
        final /* synthetic */ ObservableRepeatWhen$RepeatWhenObserver this$0;

        public InnerRepeatObserver(ObservableRepeatWhen$RepeatWhenObserver r5) {
            this.this$0 = r5;
        }

        @Override // mt.u
        public void onComplete() {
            this.this$0.innerComplete();
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            this.this$0.innerError(r5);
        }

        @Override // mt.u
        public void onNext(Object r5) {
            this.this$0.innerNext();
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }
    }

    public ObservableRepeatWhen$RepeatWhenObserver(mt.u r5, io.reactivex.subjects.h r10, mt.s r11) {
        this.downstream = r5;
        this.signaller = r10;
        this.source = r11;
        this.wip = new AtomicInteger();
        this.error = new AtomicThrowable();
        this.inner = new InnerRepeatObserver(this);
        this.upstream = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.inner);
    }

    public void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        com.lynx.tasm.behavior.ui.utils.p.u(this.downstream, this, this.error);
    }

    public void innerError(Throwable r5) {
        DisposableHelper.dispose(this.upstream);
        com.lynx.tasm.behavior.ui.utils.p.w(this.downstream, r5, this, this.error);
    }

    public void innerNext() {
        subscribeNext();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // mt.u
    public void onComplete() {
        DisposableHelper.replace(this.upstream, null);
        this.active = false;
        this.signaller.onNext(0);
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        DisposableHelper.dispose(this.inner);
        com.lynx.tasm.behavior.ui.utils.p.w(this.downstream, r5, this, this.error);
    }

    @Override // mt.u
    public void onNext(T r5) {
        com.lynx.tasm.behavior.ui.utils.p.y(this.downstream, r5, this, this.error);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.upstream, r5);
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
}
