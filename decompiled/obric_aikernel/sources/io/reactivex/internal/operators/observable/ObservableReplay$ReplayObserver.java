package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableReplay$ReplayObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<T>, io.reactivex.disposables.b {
    static final ObservableReplay$InnerDisposable[] EMPTY = null;
    static final ObservableReplay$InnerDisposable[] TERMINATED = null;
    private static final long serialVersionUID = -533785617179540163L;
    final g<T> buffer;
    boolean done;
    final AtomicReference<ObservableReplay$InnerDisposable[]> observers;
    final AtomicBoolean shouldConnect;

    static {
        EMPTY = new ObservableReplay$InnerDisposable[0];
        TERMINATED = new ObservableReplay$InnerDisposable[0];
    }

    ObservableReplay$ReplayObserver(g<T> r10) {
        this.buffer = r10;
        this.observers = new AtomicReference(EMPTY);
        this.shouldConnect = new AtomicBoolean();
    }

    boolean add(ObservableReplay$InnerDisposable<T> r10) {
    L2:
        ObservableReplay$InnerDisposable[] r11 = this.observers.get();
        if (r11 == TERMINATED) goto L4;
        int r12 = r11.length;
        ObservableReplay$InnerDisposable[] r13 = new ObservableReplay$InnerDisposable[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (this.observers.compareAndSet(r11, r13) == false) goto L2;
        return true;
    L4:
        return false;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.observers.set(TERMINATED);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this.observers.get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.o
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        this.buffer.complete();
        replayFinal();
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.done == true) goto L5;
        this.done = true;
        this.buffer.error(r10);
        replayFinal();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (this.done == true) goto L6;
        this.buffer.next(r10);
        replay();
        return;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        replay();
        return;
    }

    void remove(ObservableReplay$InnerDisposable<T> r10) {
    L2:
        ObservableReplay$InnerDisposable[] r11 = this.observers.get();
        int r12 = r11.length;
        if (r12 == 0) goto L4;
        int r13 = -1;
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L11;
        if (r11[r14].equals(r10) == true) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        r13 = r14;
    L11:
        if (r13 < 0) goto L12;
        if (r12 != 1) goto L16;
        ObservableReplay$InnerDisposable[] r15 = EMPTY;
    L18:
        if (this.observers.compareAndSet(r11, r15) == false) goto L2;
        return;
    L16:
        ObservableReplay$InnerDisposable[] r16 = new ObservableReplay$InnerDisposable[r12 - 1];
        System.arraycopy(r11, 0, r16, 0, r13);
        System.arraycopy(r11, r13 + 1, r16, r13, (r12 - r13) - 1);
        r15 = r16;
        goto L18
    L12:
        return;
    }

    void replay() {
        ObservableReplay$InnerDisposable<T>[] r10 = this.observers.get();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ObservableReplay$InnerDisposable<T> r13 = r10[r12];
        this.buffer.replay(r13);
        r12 = r12 + 1;
        goto L3
    }

    void replayFinal() {
        ObservableReplay$InnerDisposable<T>[] r10 = this.observers.getAndSet(TERMINATED);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ObservableReplay$InnerDisposable<T> r13 = r10[r12];
        this.buffer.replay(r13);
        r12 = r12 + 1;
        goto L3
    }
}
