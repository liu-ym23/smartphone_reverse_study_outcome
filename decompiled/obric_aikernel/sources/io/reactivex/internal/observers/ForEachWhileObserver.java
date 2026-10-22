package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.o;
import zb.g;
import zb.i;

/* JADX INFO: loaded from: classes2.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final zb.a onComplete;
    final g<? super Throwable> onError;
    final i<? super T> onNext;

    public ForEachWhileObserver(i<? super T> r10, g<? super Throwable> r11, zb.a r12) {
        this.onNext = r10;
        this.onError = r11;
        this.onComplete = r12;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.o
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.onComplete.run();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.done = true;
        this.onError.accept(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.onNext.test(r10) == true) goto L14;
        dispose();
        onComplete();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dispose();
        onError(th);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
