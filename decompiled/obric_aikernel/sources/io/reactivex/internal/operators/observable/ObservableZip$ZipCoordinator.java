package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableZip$ZipCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
    private static final long serialVersionUID = 2983708048395377667L;
    volatile boolean cancelled;
    final boolean delayError;
    final xb.o<? super R> downstream;
    final q<T, R>[] observers;
    final T[] row;
    final zb.h<? super Object[], ? extends R> zipper;

    ObservableZip$ZipCoordinator(xb.o<? super R> r10, zb.h<? super Object[], ? extends R> r11, int r12, boolean r13) {
        this.downstream = r10;
        this.zipper = r11;
        this.observers = new q[r12];
        this.row = (T[]) new Object[r12];
        this.delayError = r13;
    }

    void cancel() {
        clear();
        cancelSources();
    }

    void cancelSources() {
        q<T, R>[] r10 = this.observers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].a();
        r12 = r12 + 1;
        goto L3
    }

    boolean checkTerminated(boolean r10, boolean r11, xb.o<? super R> r12, boolean r13, q<?, ?> r14) {
        if (this.cancelled == false) goto L6;
        cancel();
        return true;
    L6:
        if (r10 == false) goto L21;
        if (r13 == false) goto L14;
        if (r11 == false) goto L23;
        Throwable r15 = r14.f9587i;
        cancel();
        if (r15 == null) goto L12;
        r12.onError(r15);
    L13:
        return true;
    L12:
        r12.onComplete();
        goto L13
    L23:
        return false;
    L14:
        Throwable r16 = r14.f9587i;
        if (r16 == null) goto L18;
        cancel();
        r12.onError(r16);
        return true;
    L18:
        if (r11 == false) goto L24;
        cancel();
        r12.onComplete();
        return true;
    L24:
        return false;
    L21:
        return false;
    }

    void clear() {
        q<T, R>[] r10 = this.observers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].f9585g.clear();
        r12 = r12 + 1;
        goto L3
    }

    @Override // io.reactivex.disposables.b
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
        q<T, R>[] r10 = this.observers;
        xb.o<? super R> r11 = this.downstream;
        T[] r12 = this.row;
        boolean r13 = this.delayError;
        int r14 = 1;
    L6:
        int r15 = r10.length;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
    L7:
        if (r16 >= r15) goto L28;
        q<T, R> r19 = r10[r16];
        if (r12[r18] != null) goto L21;
        boolean r20 = r19.f9586h;
        T r110 = r19.f9585g.poll();
        if (r110 != null) goto L13;
        boolean r111 = true;
    L15:
        if (checkTerminated(r20, r111, r11, r13, r19) == true) goto L16;
        if (r111 == true) goto L19;
        r12[r18] = r110;
    L27:
        r18 = r18 + 1;
        r16 = r16 + 1;
        goto L7
    L19:
        r17 = r17 + 1;
        goto L27
    L16:
        return;
    L13:
        r111 = false;
        goto L15
    L21:
        if (r19.f9586h == false) goto L27;
        if (r13 == true) goto L27;
        Throwable r21 = r19.f9587i;
        if (r21 == null) goto L27;
        cancel();
        r11.onError(r21);
        return;
    L28:
        if (r17 != 0) goto L29;
        r11.onNext((Object) io.reactivex.internal.functions.a.d(this.zipper.apply(r12.clone()), "The zipper returned a null value"));
        Arrays.fill(r12, null);
    L34:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        r11.onError(th);
        return;
    L29:
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L6;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(ObservableSource<? extends T>[] r10, int r11) {
        q<T, R>[] r12 = this.observers;
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r12[r15] = new q(this, r11);
        r15 = r15 + 1;
        goto L3
    L5:
        lazySet(0);
        this.downstream.onSubscribe(this);
    L6:
        if (r14 >= r13) goto L11;
        if (this.cancelled == true) goto L9;
        r10[r14].subscribe(r12[r14]);
        r14 = r14 + 1;
        goto L6
    L9:
        return;
    }
}
