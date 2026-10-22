package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableSequenceEqualSingle$EqualCoordinator<T> extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = -6178010334400373240L;
    volatile boolean cancelled;
    final pt.d comparer;
    final mt.b0 downstream;
    final mt.s first;
    final s3[] observers;
    final ArrayCompositeDisposable resources;
    final mt.s second;
    T v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    T f17701v2;

    public ObservableSequenceEqualSingle$EqualCoordinator(mt.b0 r5, int r10, mt.s r11, mt.s r12, pt.d r13) {
        this.downstream = r5;
        this.first = r11;
        this.second = r12;
        this.comparer = r13;
        this.observers = new s3[]{new s3(this, 0, r10), new s3(this, 1, r10)};
        this.resources = new ArrayCompositeDisposable(2);
    }

    public void cancel(io.reactivex.internal.queue.b r5, io.reactivex.internal.queue.b r10) {
        this.cancelled = true;
        r5.clear();
        r10.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.resources.dispose();
        if (getAndIncrement() != 0) goto L9;
        s3[] r5 = this.observers;
        r5[0].f17959b.clear();
        r5[1].f17959b.clear();
        return;
    L9:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        s3[] r5 = this.observers;
        s3 r10 = r5[0];
        io.reactivex.internal.queue.b r11 = r10.f17959b;
        s3 r12 = r5[1];
        io.reactivex.internal.queue.b r13 = r12.f17959b;
        int r14 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r15 = r10.d;
        if (r15 == false) goto L16;
        Throwable r16 = r10.e;
        if (r16 == null) goto L16;
        cancel(r11, r13);
        this.downstream.onError(r16);
        return;
    L16:
        boolean r17 = r12.d;
        if (r17 == false) goto L23;
        Throwable r18 = r12.e;
        if (r18 == null) goto L23;
        cancel(r11, r13);
        this.downstream.onError(r18);
        return;
    L23:
        if (this.v1 != null) goto L26;
        this.v1 = (T) r11.poll();
    L26:
        if (this.v1 != null) goto L28;
        boolean r19 = true;
    L30:
        if (this.f17701v2 != null) goto L32;
        this.f17701v2 = (T) r13.poll();
    L32:
        T r110 = this.f17701v2;
        if (r110 != null) goto L35;
        boolean r111 = true;
    L36:
        if (r15 == false) goto L42;
        if (r17 == false) goto L42;
        if (r19 == false) goto L42;
        if (r111 == false) goto L42;
        this.downstream.onSuccess(Boolean.TRUE);
        return;
    L42:
        if (r15 == false) goto L47;
        if (r17 == false) goto L47;
        if (r19 == r111) goto L47;
        cancel(r11, r13);
        this.downstream.onSuccess(Boolean.FALSE);
        return;
    L47:
        if (r19 == true) goto L57;
        if (r111 == true) goto L57;
        pt.d r20 = this.comparer;     // Catch: Throwable -> L54
        T r21 = this.v1;     // Catch: Throwable -> L54
        ((com.lynx.tasm.utils.c) r20).getClass();     // Catch: Throwable -> L54
        if (io.reactivex.internal.functions.e.b(r21, r110) == false) goto L51;
        this.v1 = null;
        this.f17701v2 = null;
        goto L57
    L51:
        cancel(r11, r13);
        this.downstream.onSuccess(Boolean.FALSE);
        return;
    L54:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancel(r11, r13);
        this.downstream.onError(th);
        return;
    L57:
        if (r19 == true) goto L59;
        if (r111 == false) goto L7;
    L59:
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L7;
        return;
    L35:
        r111 = false;
        goto L36
    L28:
        r19 = false;
        goto L30
    L8:
        r11.clear();
        r13.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    public boolean setDisposable(Disposable r5, int r10) {
        return this.resources.setResource(r10, r5);
    }

    public void subscribe() {
        s3[] r5 = this.observers;
        this.first.subscribe(r5[0]);
        this.second.subscribe(r5[1]);
    }
}
