package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;
import mt.j;
import pt.o;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeZipArray$ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = -5556924161382950569L;
    final j downstream;
    final MaybeZipArray$ZipMaybeObserver<T>[] observers;
    final Object[] values;
    final o zipper;

    public MaybeZipArray$ZipCoordinator(j r5, int r10, o r11) {
        super(r10);
        this.downstream = r5;
        this.zipper = r11;
        MaybeZipArray$ZipMaybeObserver<T>[] r12 = new MaybeZipArray$ZipMaybeObserver[r10];
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L5;
        r12[r13] = new MaybeZipArray$ZipMaybeObserver(this, r13);
        r13 = r13 + 1;
        goto L3
    L5:
        this.observers = r12;
        this.values = new Object[r10];
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        int r5 = 0;
        if (getAndSet(0) <= 0) goto L7;
        MaybeZipArray$ZipMaybeObserver<T>[] r10 = this.observers;
        int r11 = r10.length;
    L5:
        if (r5 >= r11) goto L9;
        r10[r5].dispose();
        r5 = r5 + 1;
        goto L5
    L9:
        return;
    }

    public void disposeExcept(int r5) {
        MaybeZipArray$ZipMaybeObserver<T>[] r10 = this.observers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L5;
        r10[r12].dispose();
        r12 = r12 + 1;
    L5:
        r5 = r5 + 1;
        if (r5 >= r11) goto L8;
        r10[r5].dispose();
        goto L5
    }

    public void innerComplete(int r5) {
        if (getAndSet(0) <= 0) goto L6;
        disposeExcept(r5);
        this.downstream.onComplete();
        return;
    }

    public void innerError(Throwable r5, int r10) {
        if (getAndSet(0) <= 0) goto L5;
        disposeExcept(r10);
        this.downstream.onError(r5);
        return;
    L5:
        f.k(r5);
    }

    public void innerSuccess(T r5, int r10) {
        this.values[r10] = r5;
        if (decrementAndGet() != 0) goto L11;
        Object r11 = this.zipper.apply(this.values);     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r11, "The zipper returned a null value");     // Catch: Throwable -> L6
        this.downstream.onSuccess(r11);
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() > 0) goto L5;
        return true;
    L5:
        return false;
    }
}
