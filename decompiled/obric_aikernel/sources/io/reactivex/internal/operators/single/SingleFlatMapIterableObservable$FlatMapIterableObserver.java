package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
import xb.o;
import xb.r;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class SingleFlatMapIterableObservable$FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements r<T> {
    private static final long serialVersionUID = -8938804753851907758L;
    volatile boolean cancelled;
    final o<? super R> downstream;
    volatile Iterator<? extends R> it;
    final h<? super T, ? extends Iterable<? extends R>> mapper;
    boolean outputFused;
    b upstream;

    SingleFlatMapIterableObservable$FlatMapIterableObserver(o<? super R> r10, h<? super T, ? extends Iterable<? extends R>> r11) {
        this.downstream = r10;
        this.mapper = r11;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public void clear() {
        this.it = null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public boolean isEmpty() {
        if (this.it != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(r10);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        o<? super R> r11 = this.downstream;
        Iterator<? extends R> r12 = this.mapper.apply(r10).iterator();     // Catch: Throwable -> L28
        if (r12.hasNext() == true) goto L8;
        r11.onComplete();
        return;
    L8:
        if (this.outputFused == false) goto L12;
        this.it = r12;
        r11.onNext(null);
        r11.onComplete();
        return;
    L12:
        if (this.cancelled == true) goto L13;
        r11.onNext(r12.next());
        if (this.cancelled == true) goto L17;
        if (r12.hasNext() == true) goto L12;
        r11.onComplete();
        return;
    L22:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r11.onError(th);
        return;
    L17:
        return;
    L25:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r11.onError(th);
        return;
    L13:
        return;
    L28:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public R poll() {
        Iterator<? extends R> r10 = this.it;
        if (r10 == null) goto L8;
        R r11 = (R) io.reactivex.internal.functions.a.d(r10.next(), "The iterator returned a null value");
        if (r10.hasNext() == true) goto L7;
        this.it = null;
    L7:
        return r11;
    L8:
        return null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.c
    public int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }
}
