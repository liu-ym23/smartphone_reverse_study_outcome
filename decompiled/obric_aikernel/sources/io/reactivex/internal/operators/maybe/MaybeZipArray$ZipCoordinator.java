package io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicInteger;
import xb.j;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeZipArray$ZipCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
    private static final long serialVersionUID = -5556924161382950569L;
    final j<? super R> downstream;
    final MaybeZipArray$ZipMaybeObserver<T>[] observers;
    final Object[] values;
    final h<? super Object[], ? extends R> zipper;

    MaybeZipArray$ZipCoordinator(j<? super R> r10, int r11, h<? super Object[], ? extends R> r12) {
        super(r11);
        this.downstream = r10;
        this.zipper = r12;
        MaybeZipArray$ZipMaybeObserver<T>[] r13 = new MaybeZipArray$ZipMaybeObserver[r11];
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r13[r14] = new MaybeZipArray$ZipMaybeObserver(this, r14);
        r14 = r14 + 1;
        goto L3
    L5:
        this.observers = r13;
        this.values = new Object[r11];
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        int r10 = 0;
        if (getAndSet(0) <= 0) goto L7;
        MaybeZipArray$ZipMaybeObserver<T>[] r11 = this.observers;
        int r12 = r11.length;
    L5:
        if (r10 >= r12) goto L9;
        r11[r10].dispose();
        r10 = r10 + 1;
        goto L5
    L9:
        return;
    }

    void disposeExcept(int r10) {
        MaybeZipArray$ZipMaybeObserver<T>[] r11 = this.observers;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L5;
        r11[r13].dispose();
        r13 = r13 + 1;
    L5:
        r10 = r10 + 1;
        if (r10 >= r12) goto L8;
        r11[r10].dispose();
        goto L5
    }

    void innerComplete(int r10) {
        if (getAndSet(0) <= 0) goto L6;
        disposeExcept(r10);
        this.downstream.onComplete();
        return;
    }

    void innerError(Throwable r10, int r11) {
        if (getAndSet(0) <= 0) goto L5;
        disposeExcept(r11);
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    void innerSuccess(T r10, int r11) {
        this.values[r11] = r10;
        if (decrementAndGet() != 0) goto L11;
        Object r12 = io.reactivex.internal.functions.a.d(this.zipper.apply(this.values), "The zipper returned a null value");     // Catch: Throwable -> L6
        this.downstream.onSuccess(r12);
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() > 0) goto L5;
        return true;
    L5:
        return false;
    }
}
