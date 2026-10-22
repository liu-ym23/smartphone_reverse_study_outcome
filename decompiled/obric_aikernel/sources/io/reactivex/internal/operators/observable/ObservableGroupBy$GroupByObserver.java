package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableGroupBy$GroupByObserver<T, K, V> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b {
    static final Object NULL_KEY = null;
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final AtomicBoolean cancelled;
    final boolean delayError;
    final xb.o<? super cc.a<K, V>> downstream;
    final Map<Object, d<K, V>> groups;
    final zb.h<? super T, ? extends K> keySelector;
    io.reactivex.disposables.b upstream;
    final zb.h<? super T, ? extends V> valueSelector;

    static {
        NULL_KEY = new Object();
    }

    public ObservableGroupBy$GroupByObserver(xb.o<? super cc.a<K, V>> r10, zb.h<? super T, ? extends K> r11, zb.h<? super T, ? extends V> r12, int r13, boolean r14) {
        this.cancelled = new AtomicBoolean();
        this.downstream = r10;
        this.keySelector = r11;
        this.valueSelector = r12;
        this.bufferSize = r13;
        this.delayError = r14;
        this.groups = new ConcurrentHashMap();
        lazySet(1);
    }

    public void cancel(K r10) {
        if (r10 != null) goto L5;
        r10 = (K) NULL_KEY;
    L5:
        this.groups.remove(r10);
        if (decrementAndGet() != 0) goto L9;
        this.upstream.dispose();
        return;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (decrementAndGet() != 0) goto L9;
        this.upstream.dispose();
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    @Override // xb.o
    public void onComplete() {
        ArrayList r10 = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).onComplete();
        goto L4
    L6:
        this.downstream.onComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        ArrayList r11 = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((d) r12.next()).onError(r10);
        goto L4
    L6:
        this.downstream.onError(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xb.o
    public void onNext(T r10) {
        K r11 = this.keySelector.apply(r10);     // Catch: Throwable -> L15
        if (r11 == null) goto L5;
        Object r12 = r11;
    L6:
        d<K, V> r13 = this.groups.get(r12);
        d r14 = r13;
        if (r13 == false) goto L9;
    L12:
        r14.onNext(io.reactivex.internal.functions.a.d(this.valueSelector.apply(r10), "The value supplied is null"));
        return;
    L9:
        if (this.cancelled.get() == false) goto L11;
        return;
    L11:
        d<K, V> r15 = d.h(r11, this.bufferSize, this, this.delayError);
        this.groups.put(r12, r15);
        getAndIncrement();
        this.downstream.onNext(r15);
        r14 = r15;
        goto L12
    L5:
        r12 = NULL_KEY;
    L15:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
