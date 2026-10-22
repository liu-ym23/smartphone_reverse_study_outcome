package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.o;
import xb.r;
import xb.s;

/* JADX INFO: loaded from: classes2.dex */
final class SingleDelayWithObservable$OtherSubscriber<T, U> extends AtomicReference<b> implements o<U>, b {
    private static final long serialVersionUID = -8565274649390031272L;
    boolean done;
    final r<? super T> downstream;
    final s<T> source;

    SingleDelayWithObservable$OtherSubscriber(r<? super T> r10, s<T> r11) {
        this.downstream = r10;
        this.source = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.o
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.source.a(new io.reactivex.internal.observers.b(this, this.downstream));
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(U r10) {
        get().dispose();
        onComplete();
    }

    @Override // xb.o
    public void onSubscribe(b r10) {
        if (DisposableHelper.set(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }
}
