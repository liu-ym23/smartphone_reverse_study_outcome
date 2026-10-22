package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableCache$CacheDisposable<T> extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 6770240836423125754L;
    volatile boolean disposed;
    final mt.u downstream;
    long index;
    a0 node;
    int offset;
    final b0 parent;

    public ObservableCache$CacheDisposable(mt.u r5, b0 r10) {
        this.downstream = r5;
        this.parent = r10;
        this.node = r10.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.disposed == true) goto L26;
        this.disposed = true;
        b0 r5 = this.parent;
    L5:
        AtomicReference r10 = r5.d;
        ObservableCache$CacheDisposable<T>[] r11 = (ObservableCache$CacheDisposable[]) r10.get();
        int r12 = r11.length;
        if (r12 == 0) goto L35;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L14;
        if (r11[r13] == this) goto L15;
        r13 = r13 + 1;
    L15:
        if (r13 < 0) goto L36;
        if (r12 != 1) goto L19;
        ObservableCache$CacheDisposable[] r14 = b0.f17719k;
    L21:
        if (r10.compareAndSet(r11, r14) == true) goto L37;
        if (r10.get() == r11) goto L21;
    L37:
        return;
    L19:
        ObservableCache$CacheDisposable[] r15 = new ObservableCache$CacheDisposable[r12 - 1];
        System.arraycopy(r11, 0, r15, 0, r13);
        System.arraycopy(r11, r13 + 1, r15, r13, (r12 - r13) - 1);
        r14 = r15;
        goto L21
    L36:
        return;
    L14:
        r13 = -1;
        goto L15
    L35:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }
}
