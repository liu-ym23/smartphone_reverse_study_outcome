package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import xb.k;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeEqualSingle$EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b {
    final r<? super Boolean> downstream;
    final zb.d<? super T, ? super T> isEqual;
    final MaybeEqualSingle$EqualObserver<T> observer1;
    final MaybeEqualSingle$EqualObserver<T> observer2;

    MaybeEqualSingle$EqualCoordinator(r<? super Boolean> r10, zb.d<? super T, ? super T> r11) {
        super(2);
        this.downstream = r10;
        this.isEqual = r11;
        this.observer1 = new MaybeEqualSingle$EqualObserver(this);
        this.observer2 = new MaybeEqualSingle$EqualObserver(this);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.observer1.dispose();
        this.observer2.dispose();
    }

    void done() {
        if (decrementAndGet() != 0) goto L21;
        Object r10 = this.observer1.value;
        Object r11 = this.observer2.value;
        if (r10 == null) goto L12;
        if (r11 == null) goto L12;
        boolean r12 = this.isEqual.a(r10, r11);     // Catch: Throwable -> L9
        r<? super Boolean> r13 = this.downstream;
    L17:
        r13.onSuccess(Boolean.valueOf(r12));
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
        return;
    L12:
        r13 = this.downstream;
        if (r10 != null) goto L16;
        if (r11 != null) goto L16;
        r12 = true;
    L16:
        r12 = false;
        goto L17
    }

    void error(MaybeEqualSingle$EqualObserver<T> r10, Throwable r11) {
        if (getAndSet(0) <= 0) goto L9;
        MaybeEqualSingle$EqualObserver<T> r12 = this.observer1;
        if (r10 != r12) goto L7;
        this.observer2.dispose();
    L8:
        this.downstream.onError(r11);
        return;
    L7:
        r12.dispose();
        goto L8
    L9:
        dc.a.n(r11);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.observer1.get());
    }

    void subscribe(k<? extends T> r10, k<? extends T> r11) {
        r10.a(this.observer1);
        r11.a(this.observer2);
    }
}
