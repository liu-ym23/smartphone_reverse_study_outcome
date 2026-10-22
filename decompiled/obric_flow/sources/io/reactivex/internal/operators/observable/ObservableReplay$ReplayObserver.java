package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableReplay$ReplayObserver<T> extends AtomicReference<Disposable> implements mt.u, Disposable {
    static final ObservableReplay$InnerDisposable[] EMPTY = null;
    static final ObservableReplay$InnerDisposable[] TERMINATED = null;
    private static final long serialVersionUID = -533785617179540163L;
    final f3 buffer;
    boolean done;
    final AtomicReference<ObservableReplay$InnerDisposable[]> observers;
    final AtomicBoolean shouldConnect;

    static {
        EMPTY = new ObservableReplay$InnerDisposable[0];
        TERMINATED = new ObservableReplay$InnerDisposable[0];
    }

    public ObservableReplay$ReplayObserver(f3 r5) {
        this.buffer = r5;
        this.observers = new AtomicReference(EMPTY);
        this.shouldConnect = new AtomicBoolean();
    }

    public boolean add(ObservableReplay$InnerDisposable<T> r5) {
    L2:
        ObservableReplay$InnerDisposable[] r10 = this.observers.get();
        if (r10 == TERMINATED) goto L4;
        int r11 = r10.length;
        ObservableReplay$InnerDisposable[] r12 = new ObservableReplay$InnerDisposable[r11 + 1];
        System.arraycopy(r10, 0, r12, 0, r11);
        r12[r11] = r5;
        AtomicReference<ObservableReplay$InnerDisposable[]> r13 = this.observers;
    L7:
        if (r13.compareAndSet(r10, r12) == true) goto L8;
        if (r13.get() == r10) goto L7;
    L8:
        return true;
    L4:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.observers.set(TERMINATED);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.observers.get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.u
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        this.buffer.complete();
        replayFinal();
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.done == true) goto L5;
        this.done = true;
        this.buffer.error(r5);
        replayFinal();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.done == true) goto L6;
        this.buffer.next(r5);
        replay();
        return;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        replay();
        return;
    }

    public void remove(ObservableReplay$InnerDisposable<T> r10) {
    L2:
        ObservableReplay$InnerDisposable[] r5 = this.observers.get();
        int r11 = r5.length;
        if (r11 == 0) goto L4;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (r5[r12].equals(r10) == true) goto L12;
        r12 = r12 + 1;
    L12:
        if (r12 < 0) goto L13;
        if (r11 != 1) goto L17;
        ObservableReplay$InnerDisposable[] r13 = EMPTY;
    L18:
        AtomicReference<ObservableReplay$InnerDisposable[]> r14 = this.observers;
    L20:
        if (r14.compareAndSet(r5, r13) == true) goto L21;
        if (r14.get() == r5) goto L20;
    L21:
        return;
    L17:
        ObservableReplay$InnerDisposable[] r15 = new ObservableReplay$InnerDisposable[r11 - 1];
        System.arraycopy(r5, 0, r15, 0, r12);
        System.arraycopy(r5, r12 + 1, r15, r12, (r11 - r12) - 1);
        r13 = r15;
        goto L18
    L13:
        return;
    L11:
        r12 = -1;
        goto L12
    }

    public void replay() {
        ObservableReplay$InnerDisposable[] r5 = this.observers.get();
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        ObservableReplay$InnerDisposable r12 = r5[r11];
        this.buffer.replay(r12);
        r11 = r11 + 1;
        goto L3
    }

    public void replayFinal() {
        ObservableReplay$InnerDisposable[] r5 = this.observers.getAndSet(TERMINATED);
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        ObservableReplay$InnerDisposable r12 = r5[r11];
        this.buffer.replay(r12);
        r11 = r11 + 1;
        goto L3
    }
}
