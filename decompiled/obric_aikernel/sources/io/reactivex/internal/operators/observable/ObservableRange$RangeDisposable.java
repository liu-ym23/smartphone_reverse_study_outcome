package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableRange$RangeDisposable extends BasicIntQueueDisposable<Integer> {
    private static final long serialVersionUID = 396518478098735504L;
    final xb.o<? super Integer> downstream;
    final long end;
    boolean fused;
    long index;

    ObservableRange$RangeDisposable(xb.o<? super Integer> r10, long r11, long r12) {
        this.downstream = r10;
        this.index = r11;
        this.end = r12;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public void clear() {
        this.index = this.end;
        lazySet(1);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public void dispose() {
        set(1);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public boolean isEmpty() {
        if (this.index != this.end) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public Integer poll() {
        long r10 = this.index;
        if (r10 == this.end) goto L6;
        this.index = 1 + r10;
        return Integer.valueOf((int) r10);
    L6:
        lazySet(1);
        return null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public /* bridge */ /* synthetic */ Object poll() {
        return poll();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.c
    public int requestFusion(int r10) {
        if ((r10 & 1) == 0) goto L6;
        this.fused = true;
        return 1;
    L6:
        return 0;
    }

    void run() {
        if (this.fused == false) goto L5;
        return;
    L5:
        xb.o<? super Integer> r10 = this.downstream;
        long r11 = this.end;
        long r12 = this.index;
    L7:
        if (r12 == r11) goto L12;
        if (get() != 0) goto L12;
        r10.onNext(Integer.valueOf((int) r12));
        r12 = r12 + 1;
    L12:
        if (get() != 0) goto L17;
        lazySet(1);
        r10.onComplete();
        return;
    }
}
