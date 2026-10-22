package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import mt.b0;
import mt.h;
import mt.k;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeEqualSingle$EqualCoordinator<T> extends AtomicInteger implements Disposable {
    final b0 downstream;
    final pt.d isEqual;
    final MaybeEqualSingle$EqualObserver<T> observer1;
    final MaybeEqualSingle$EqualObserver<T> observer2;

    public MaybeEqualSingle$EqualCoordinator(b0 r5, pt.d r10) {
        super(2);
        this.downstream = r5;
        this.isEqual = r10;
        this.observer1 = new MaybeEqualSingle$EqualObserver(this);
        this.observer2 = new MaybeEqualSingle$EqualObserver(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.observer1.dispose();
        this.observer2.dispose();
    }

    public void done() {
        if (decrementAndGet() != 0) goto L21;
        Object r5 = this.observer1.value;
        Object r10 = this.observer2.value;
        if (r5 == null) goto L12;
        if (r10 == null) goto L12;
        ((com.lynx.tasm.utils.c) this.isEqual).getClass();     // Catch: Throwable -> L9
        boolean r11 = io.reactivex.internal.functions.e.b(r5, r10);     // Catch: Throwable -> L9
        this.downstream.onSuccess(Boolean.valueOf(r11));
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
        return;
    L12:
        b0 r12 = this.downstream;
        if (r5 != null) goto L16;
        if (r10 != null) goto L16;
        boolean r13 = true;
    L17:
        r12.onSuccess(Boolean.valueOf(r13));
        return;
    L16:
        r13 = false;
        goto L17
    }

    public void error(MaybeEqualSingle$EqualObserver<T> r5, Throwable r10) {
        if (getAndSet(0) <= 0) goto L9;
        MaybeEqualSingle$EqualObserver<T> r11 = this.observer1;
        if (r5 != r11) goto L7;
        this.observer2.dispose();
    L8:
        this.downstream.onError(r10);
        return;
    L7:
        r11.dispose();
        goto L8
    L9:
        f.k(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.observer1.get());
    }

    public void subscribe(k r5, k r10) {
        h r11 = (h) r5;
        r11.b(this.observer1);
        h r12 = (h) r10;
        r12.b(this.observer2);
    }
}
