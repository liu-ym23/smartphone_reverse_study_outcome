package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableBuffer$BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements mt.u, Disposable {
    private static final long serialVersionUID = -8223395059921494546L;
    final Callable<U> bufferSupplier;
    final ArrayDeque<U> buffers;
    final int count;
    final mt.u downstream;
    long index;
    final int skip;
    Disposable upstream;

    public ObservableBuffer$BufferSkipObserver(mt.u r5, int r10, int r11, Callable<U> r12) {
        this.downstream = r5;
        this.count = r10;
        this.skip = r11;
        this.bufferSupplier = r12;
        this.buffers = new ArrayDeque();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // mt.u
    public void onComplete() {
    L3:
        if (this.buffers.isEmpty() == true) goto L5;
        this.downstream.onNext(this.buffers.poll());
        goto L3
    L5:
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.buffers.clear();
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        long r10 = this.index;
        this.index = 1 + r10;
        if ((r10 % ((long) this.skip)) == 0) goto L16;
    L9:
        Iterator<U> r11 = this.buffers.iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        U r12 = r11.next();
        r12.add(r5);
        if (this.count > r12.size()) goto L11;
        r11.remove();
        this.downstream.onNext(r12);
        goto L11
    L15:
        return;
    L16:
        U r13 = this.bufferSupplier.call();     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r13, "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L6
        U r14 = r13;     // Catch: Throwable -> L6
        this.buffers.offer(r14);
    L6:
        th = move-exception;
        this.buffers.clear();
        this.upstream.dispose();
        this.downstream.onError(th);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
