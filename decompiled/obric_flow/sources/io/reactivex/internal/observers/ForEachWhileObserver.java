package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;
import pt.p;

/* JADX INFO: loaded from: classes3.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements u, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final pt.a onComplete;
    final pt.g onError;
    final p onNext;

    public ForEachWhileObserver(p r5, pt.g r10, pt.a r11) {
        this.onNext = r5;
        this.onError = r10;
        this.onComplete = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.u
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.onComplete.run();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.done = true;
        this.onError.accept(r5);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.onNext.test(r5) == true) goto L14;
        dispose();
        onComplete();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        dispose();
        onError(th);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
