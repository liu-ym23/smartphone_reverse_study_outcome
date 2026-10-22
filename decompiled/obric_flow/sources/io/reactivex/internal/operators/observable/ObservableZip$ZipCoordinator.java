package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableZip$ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 2983708048395377667L;
    volatile boolean cancelled;
    final boolean delayError;
    final mt.u downstream;
    final a5[] observers;
    final T[] row;
    final pt.o zipper;

    public ObservableZip$ZipCoordinator(mt.u r5, pt.o r10, int r11, boolean r12) {
        this.downstream = r5;
        this.zipper = r10;
        this.observers = new a5[r11];
        this.row = (T[]) new Object[r11];
        this.delayError = r12;
    }

    public void cancel() {
        clear();
        cancelSources();
    }

    public void cancelSources() {
        a5[] r5 = this.observers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        DisposableHelper.dispose(r5[r11].e);
        r11 = r11 + 1;
        goto L3
    }

    public boolean checkTerminated(boolean r5, boolean r10, mt.u r11, boolean r12, a5 r13) {
        if (this.cancelled == false) goto L6;
        cancel();
        return true;
    L6:
        if (r5 == false) goto L21;
        if (r12 == false) goto L14;
        if (r10 == false) goto L23;
        Throwable r14 = r13.d;
        this.cancelled = true;
        cancel();
        if (r14 == null) goto L12;
        r11.onError(r14);
    L13:
        return true;
    L12:
        r11.onComplete();
        goto L13
    L23:
        return false;
    L14:
        Throwable r15 = r13.d;
        if (r15 == null) goto L18;
        this.cancelled = true;
        cancel();
        r11.onError(r15);
        return true;
    L18:
        if (r10 == false) goto L24;
        this.cancelled = true;
        cancel();
        r11.onComplete();
        return true;
    L24:
        return false;
    L21:
        return false;
    }

    public void clear() {
        a5[] r5 = this.observers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].f17715b.clear();
        r11 = r11 + 1;
        goto L3
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        cancelSources();
        if (getAndIncrement() != 0) goto L9;
        clear();
        return;
    L9:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        a5[] r5 = this.observers;
        mt.u r10 = this.downstream;
        T[] r11 = this.row;
        boolean r12 = this.delayError;
        int r13 = 1;
    L6:
        int r14 = r5.length;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L7:
        if (r15 >= r14) goto L28;
        a5 r18 = r5[r15];
        if (r11[r17] != null) goto L21;
        boolean r19 = r18.f17716c;
        Object r110 = r18.f17715b.poll();
        if (r110 != null) goto L13;
        boolean r111 = true;
    L15:
        if (checkTerminated(r19, r111, r10, r12, r18) == true) goto L16;
        if (r111 == true) goto L19;
        r11[r17] = r110;
    L27:
        r17 = r17 + 1;
        r15 = r15 + 1;
        goto L7
    L19:
        r16 = r16 + 1;
        goto L27
    L16:
        return;
    L13:
        r111 = false;
        goto L15
    L21:
        if (r18.f17716c == false) goto L27;
        if (r12 == true) goto L27;
        Throwable r20 = r18.d;
        if (r20 == null) goto L27;
        this.cancelled = true;
        cancel();
        r10.onError(r20);
        return;
    L28:
        if (r16 != 0) goto L29;
        Object r21 = this.zipper.apply(r11.clone());     // Catch: Throwable -> L34
        io.reactivex.internal.functions.e.d(r21, "The zipper returned a null value");     // Catch: Throwable -> L34
        r10.onNext(r21);
        Arrays.fill(r11, null);
    L34:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancel();
        r10.onError(th);
        return;
    L29:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L6;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(mt.s[] r10, int r11) {
        a5[] r5 = this.observers;
        int r12 = r5.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r5[r14] = new a5(this, r11);
        r14 = r14 + 1;
        goto L3
    L5:
        lazySet(0);
        this.downstream.onSubscribe(this);
    L6:
        if (r13 >= r12) goto L11;
        if (this.cancelled == true) goto L9;
        r10[r13].subscribe(r5[r13]);
        r13 = r13 + 1;
        goto L6
    L9:
        return;
    }
}
