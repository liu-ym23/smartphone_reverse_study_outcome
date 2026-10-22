package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableWithLatestFromMany$WithLatestFromObserver<T, R> extends AtomicInteger implements mt.u, Disposable {
    private static final long serialVersionUID = 1577321883966341961L;
    final pt.o combiner;
    volatile boolean done;
    final mt.u downstream;
    final AtomicThrowable error;
    final ObservableWithLatestFromMany$WithLatestInnerObserver[] observers;
    final AtomicReference<Disposable> upstream;
    final AtomicReferenceArray<Object> values;

    public ObservableWithLatestFromMany$WithLatestFromObserver(mt.u r5, pt.o r10, int r11) {
        this.downstream = r5;
        this.combiner = r10;
        ObservableWithLatestFromMany$WithLatestInnerObserver[] r12 = new ObservableWithLatestFromMany$WithLatestInnerObserver[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = new ObservableWithLatestFromMany$WithLatestInnerObserver(this, r13);
        r13 = r13 + 1;
        goto L3
    L5:
        this.observers = r12;
        this.values = new AtomicReferenceArray(r11);
        this.upstream = new AtomicReference();
        this.error = new AtomicThrowable();
    }

    public void cancelAllBut(int r5) {
        ObservableWithLatestFromMany$WithLatestInnerObserver[] r10 = this.observers;
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L8;
        if (r11 == r5) goto L7;
        r10[r11].dispose();
    L7:
        r11 = r11 + 1;
        goto L4
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        ObservableWithLatestFromMany$WithLatestInnerObserver[] r5 = this.observers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].dispose();
        r11 = r11 + 1;
        goto L3
    }

    public void innerComplete(int r5, boolean r10) {
        if (r10 == true) goto L5;
        this.done = true;
        cancelAllBut(r5);
        com.lynx.tasm.behavior.ui.utils.p.u(this.downstream, this, this.error);
        return;
    }

    public void innerError(int r5, Throwable r10) {
        this.done = true;
        DisposableHelper.dispose(this.upstream);
        cancelAllBut(r5);
        com.lynx.tasm.behavior.ui.utils.p.w(this.downstream, r10, this, this.error);
    }

    public void innerNext(int r5, Object r10) {
        this.values.set(r5, r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // mt.u
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        cancelAllBut(-1);
        com.lynx.tasm.behavior.ui.utils.p.u(this.downstream, this, this.error);
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.done = true;
        cancelAllBut(-1);
        com.lynx.tasm.behavior.ui.utils.p.w(this.downstream, r5, this, this.error);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.done == false) goto L5;
        return;
    L5:
        AtomicReferenceArray<Object> r10 = this.values;
        int r11 = r10.length();
        Object[] r12 = new Object[r11 + 1];
        int r13 = 0;
        r12[0] = r5;
    L6:
        if (r13 >= r11) goto L17;
        Object r14 = r10.get(r13);
        if (r14 == null) goto L9;
        r13 = r13 + 1;
        r12[r13] = r14;
        goto L6
    L9:
        return;
    L17:
        Object r15 = this.combiner.apply(r12);     // Catch: Throwable -> L14
        io.reactivex.internal.functions.e.d(r15, "combiner returned a null value");     // Catch: Throwable -> L14
        com.lynx.tasm.behavior.ui.utils.p.y(this.downstream, r15, this, this.error);
        return;
    L14:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        dispose();
        onError(th);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.upstream, r5);
    }

    public void subscribe(mt.s[] r10, int r11) {
        ObservableWithLatestFromMany$WithLatestInnerObserver[] r5 = this.observers;
        AtomicReference<Disposable> r12 = this.upstream;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        if (DisposableHelper.isDisposed(r12.get()) == true) goto L14;
        if (this.done == true) goto L15;
        r10[r13].subscribe(r5[r13]);
        r13 = r13 + 1;
        goto L3
    L15:
        return;
    L14:
        return;
    }
}
