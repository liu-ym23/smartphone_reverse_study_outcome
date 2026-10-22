package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.e;
import java.util.concurrent.atomic.AtomicReference;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
public final enum DisposableHelper extends Enum<DisposableHelper> implements Disposable {
    public static final DisposableHelper DISPOSED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisposableHelper[] f17610a = null;

    static {
        DisposableHelper r5 = new DisposableHelper("DISPOSED", 0);
        DISPOSED = r5;
        f17610a = new DisposableHelper[]{r5};
    }

    public static boolean replace(AtomicReference<Disposable> r5, Disposable r10) {
    L2:
        Disposable r11 = r5.get();
        if (r11 == DISPOSED) goto L4;
    L9:
        if (r5.compareAndSet(r11, r10) == true) goto L10;
        if (r5.get() == r11) goto L9;
    L10:
        return true;
    L4:
        if (r10 == null) goto L19;
        r10.dispose();
        return false;
    L19:
        return false;
    }

    public static void reportDisposableSet() {
        f.k(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<Disposable> r5, Disposable r10) {
    L2:
        Disposable r11 = r5.get();
        if (r11 == DISPOSED) goto L4;
    L9:
        if (r5.compareAndSet(r11, r10) == true) goto L10;
        if (r5.get() == r11) goto L9;
    L10:
        if (r11 == null) goto L22;
        r11.dispose();
        return true;
    L22:
        return true;
    L4:
        if (r10 == null) goto L21;
        r10.dispose();
        return false;
    L21:
        return false;
    }

    public static boolean setOnce(AtomicReference<Disposable> r5, Disposable r10) {
        e.d(r10, "d is null");
    L4:
        if (r5.compareAndSet(null, r10) == true) goto L5;
        if (r5.get() == null) goto L4;
        r10.dispose();
        if (r5.get() == DISPOSED) goto L17;
        reportDisposableSet();
        return false;
    L17:
        return false;
    L5:
        return true;
    }

    public static boolean trySet(AtomicReference<Disposable> r5, Disposable r10) {
    L3:
        if (r5.compareAndSet(null, r10) == true) goto L4;
        if (r5.get() == null) goto L3;
        if (r5.get() != DISPOSED) goto L16;
        r10.dispose();
        return false;
    L16:
        return false;
    L4:
        return true;
    }

    public static boolean validate(Disposable r5, Disposable r10) {
        if (r10 != null) goto L6;
        f.k(new NullPointerException("next is null"));
        return false;
    L6:
        if (r5 == null) goto L9;
        r10.dispose();
        reportDisposableSet();
        return false;
    L9:
        return true;
    }

    public static DisposableHelper valueOf(String r5) {
        return (DisposableHelper) Enum.valueOf(DisposableHelper.class, r5);
    }

    public static DisposableHelper[] values() {
        return (DisposableHelper[]) f17610a.clone();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    public static boolean dispose(AtomicReference<Disposable> r5) {
        Disposable r10 = r5.get();
        DisposableHelper r11 = DISPOSED;
        if (r10 == r11) goto L10;
        Disposable r12 = r5.getAndSet(r11);
        if (r12 == r11) goto L13;
        if (r12 == null) goto L12;
        r12.dispose();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean isDisposed(Disposable r5) {
        if (r5 != DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }
}
