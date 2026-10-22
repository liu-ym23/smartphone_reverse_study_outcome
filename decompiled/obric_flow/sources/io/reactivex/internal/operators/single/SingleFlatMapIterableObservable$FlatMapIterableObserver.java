package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.e;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
import mt.b0;
import mt.u;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class SingleFlatMapIterableObservable$FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements b0 {
    private static final long serialVersionUID = -8938804753851907758L;
    volatile boolean cancelled;
    final u downstream;
    volatile Iterator<? extends R> it;
    final o mapper;
    boolean outputFused;
    Disposable upstream;

    public SingleFlatMapIterableObservable$FlatMapIterableObserver(u r5, o r10) {
        this.downstream = r5;
        this.mapper = r10;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public void clear() {
        this.it = null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public boolean isEmpty() {
        if (this.it != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        u r10 = this.downstream;
        Iterator<? extends R> r11 = ((Iterable) this.mapper.apply(r5)).iterator();     // Catch: Throwable -> L28
        if (r11.hasNext() == true) goto L8;
        r10.onComplete();
        return;
    L8:
        if (this.outputFused == false) goto L12;
        this.it = r11;
        r10.onNext(null);
        r10.onComplete();
        return;
    L12:
        if (this.cancelled == true) goto L13;
        r10.onNext(r11.next());
        if (this.cancelled == true) goto L17;
        if (r11.hasNext() == true) goto L12;
        r10.onComplete();
        return;
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r10.onError(th);
        return;
    L17:
        return;
    L25:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r10.onError(th);
        return;
    L13:
        return;
    L28:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public R poll() throws Exception {
        Iterator<? extends R> r5 = this.it;
        if (r5 == null) goto L8;
        R r10 = r5.next();
        e.d(r10, "The iterator returned a null value");
        if (r5.hasNext() == true) goto L7;
        this.it = null;
    L7:
        return r10;
    L8:
        return null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.d
    public int requestFusion(int r5) {
        if ((r5 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }
}
