package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<Disposable> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int r5) {
        super(r5);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        int r5 = 0;
        if (get(0) == DisposableHelper.DISPOSED) goto L13;
        int r10 = length();
    L5:
        if (r5 >= r10) goto L19;
        Disposable r11 = get(r5);
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L12;
        Disposable r13 = getAndSet(r5, r12);
        if (r13 == r12) goto L12;
        if (r13 == null) goto L12;
        r13.dispose();
    L12:
        r5 = r5 + 1;
        goto L5
    L19:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get(0) != DisposableHelper.DISPOSED) goto L6;
        return true;
    L6:
        return false;
    }

    public Disposable replaceResource(int r5, Disposable r10) {
    L2:
        Disposable r11 = get(r5);
        if (r11 == DisposableHelper.DISPOSED) goto L4;
        if (compareAndSet(r5, r11, r10) == false) goto L2;
        return r11;
    L4:
        r10.dispose();
        return null;
    }

    public boolean setResource(int r5, Disposable r10) {
    L2:
        Disposable r11 = get(r5);
        if (r11 == DisposableHelper.DISPOSED) goto L4;
        if (compareAndSet(r5, r11, r10) == false) goto L2;
        if (r11 == null) goto L15;
        r11.dispose();
        return true;
    L15:
        return true;
    L4:
        r10.dispose();
        return false;
    }
}
