package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class ObservableGroupBy$GroupByObserver<T, K, V> extends AtomicInteger implements mt.u, Disposable {
    static final Object NULL_KEY = null;
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final AtomicBoolean cancelled;
    final boolean delayError;
    final mt.u downstream;
    final Map<Object, p1> groups;
    final pt.o keySelector;
    Disposable upstream;
    final pt.o valueSelector;

    static {
        NULL_KEY = new Object();
    }

    public ObservableGroupBy$GroupByObserver(mt.u r5, pt.o r10, pt.o r11, int r12, boolean r13) {
        this.cancelled = new AtomicBoolean();
        this.downstream = r5;
        this.keySelector = r10;
        this.valueSelector = r11;
        this.bufferSize = r12;
        this.delayError = r13;
        this.groups = new ConcurrentHashMap();
        lazySet(1);
    }

    public void cancel(K r5) {
        if (r5 != null) goto L5;
        r5 = (K) NULL_KEY;
    L5:
        this.groups.remove(r5);
        if (decrementAndGet() != 0) goto L9;
        this.upstream.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (decrementAndGet() != 0) goto L9;
        this.upstream.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    @Override // mt.u
    public void onComplete() {
        ArrayList r5 = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((p1) r10.next()).f17906b.onComplete();
        goto L4
    L6:
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        ArrayList r10 = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((p1) r11.next()).f17906b.onError(r5);
        goto L4
    L6:
        this.downstream.onError(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mt.u
    public void onNext(T r10) {
        Object r5 = this.keySelector.apply(r10);     // Catch: Throwable -> L18
        if (r5 == null) goto L5;
        Object r11 = r5;
    L6:
        p1 r12 = this.groups.get(r11);
        if (r12 == null) goto L9;
    L23:
        Object r13 = this.valueSelector.apply(r10);     // Catch: Throwable -> L15
        io.reactivex.internal.functions.e.d(r13, "The value supplied is null");     // Catch: Throwable -> L15
        r12.f17906b.onNext(r13);
        return;
    L15:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.dispose();
        onError(th);
        return;
    L9:
        if (this.cancelled.get() == false) goto L11;
        return;
    L11:
        r12 = new p1(r5, new ObservableGroupBy$State(this.bufferSize, this, r5, this.delayError));
        this.groups.put(r11, r12);
        getAndIncrement();
        this.downstream.onNext(r12);
        goto L23
    L5:
        r11 = NULL_KEY;
    L18:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
