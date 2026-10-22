package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservablePublishAlt$PublishConnection<T> extends AtomicReference<ObservablePublishAlt$InnerDisposable<T>[]> implements mt.u, Disposable {
    static final ObservablePublishAlt$InnerDisposable[] EMPTY = null;
    static final ObservablePublishAlt$InnerDisposable[] TERMINATED = null;
    private static final long serialVersionUID = -3251430252873581268L;
    final AtomicBoolean connect;
    final AtomicReference<ObservablePublishAlt$PublishConnection<T>> current;
    Throwable error;
    final AtomicReference<Disposable> upstream;

    static {
        EMPTY = new ObservablePublishAlt$InnerDisposable[0];
        TERMINATED = new ObservablePublishAlt$InnerDisposable[0];
    }

    public ObservablePublishAlt$PublishConnection(AtomicReference<ObservablePublishAlt$PublishConnection<T>> r5) {
        this.connect = new AtomicBoolean();
        this.current = r5;
        this.upstream = new AtomicReference();
        lazySet(EMPTY);
    }

    public boolean add(ObservablePublishAlt$InnerDisposable<T> r5) {
    L2:
        ObservablePublishAlt$InnerDisposable<T>[] r10 = get();
        if (r10 == TERMINATED) goto L4;
        int r11 = r10.length;
        ObservablePublishAlt$InnerDisposable[] r12 = new ObservablePublishAlt$InnerDisposable[r11 + 1];
        System.arraycopy(r10, 0, r12, 0, r11);
        r12[r11] = r5;
        if (compareAndSet(r10, r12) == false) goto L2;
        return true;
    L4:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        getAndSet(TERMINATED);
        AtomicReference<ObservablePublishAlt$PublishConnection<T>> r5 = this.current;
    L4:
        if (r5.compareAndSet(this, null) == true) goto L8;
        if (r5.get() == this) goto L4;
    L8:
        DisposableHelper.dispose(this.upstream);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.u
    public void onComplete() {
        this.upstream.lazySet(DisposableHelper.DISPOSED);
        ObservablePublishAlt$InnerDisposable<T>[] r5 = getAndSet(TERMINATED);
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].downstream.onComplete();
        r11 = r11 + 1;
        goto L3
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.error = r5;
        this.upstream.lazySet(DisposableHelper.DISPOSED);
        ObservablePublishAlt$InnerDisposable<T>[] r10 = getAndSet(TERMINATED);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].downstream.onError(r5);
        r12 = r12 + 1;
        goto L3
    }

    @Override // mt.u
    public void onNext(T r5) {
        ObservablePublishAlt$InnerDisposable<T>[] r10 = get();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].downstream.onNext(r5);
        r12 = r12 + 1;
        goto L3
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.upstream, r5);
    }

    public void remove(ObservablePublishAlt$InnerDisposable<T> r10) {
    L2:
        ObservablePublishAlt$InnerDisposable<T>[] r5 = get();
        int r11 = r5.length;
        if (r11 == 0) goto L4;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (r5[r12] == r10) goto L12;
        r12 = r12 + 1;
    L12:
        if (r12 < 0) goto L13;
        ObservablePublishAlt$InnerDisposable[] r13 = EMPTY;
        if (r11 == 1) goto L18;
        r13 = new ObservablePublishAlt$InnerDisposable[r11 - 1];
        System.arraycopy(r5, 0, r13, 0, r12);
        System.arraycopy(r5, r12 + 1, r13, r12, (r11 - r12) - 1);
    L18:
        if (compareAndSet(r5, r13) == false) goto L2;
        return;
    L13:
        return;
    L11:
        r12 = -1;
        goto L12
    }
}
