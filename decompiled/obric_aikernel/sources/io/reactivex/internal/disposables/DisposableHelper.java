package io.reactivex.internal.disposables;

import dc.a;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final enum DisposableHelper extends Enum<DisposableHelper> implements b {
    private static final /* synthetic */ DisposableHelper[] $VALUES = null;
    public static final DisposableHelper DISPOSED = null;

    static {
        DisposableHelper r10 = new DisposableHelper("DISPOSED", 0);
        DISPOSED = r10;
        $VALUES = new DisposableHelper[]{r10};
    }

    private DisposableHelper(String r10, int r11) {
        super(r10, r11);
    }

    public static boolean dispose(AtomicReference<b> r10) {
        b r11 = r10.get();
        DisposableHelper r12 = DISPOSED;
        if (r11 == r12) goto L10;
        b r13 = r10.getAndSet(r12);
        if (r13 == r12) goto L13;
        if (r13 == null) goto L12;
        r13.dispose();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean isDisposed(b r10) {
        if (r10 != DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean replace(AtomicReference<b> r10, b r11) {
    L2:
        b r12 = r10.get();
        if (r12 == DISPOSED) goto L4;
        if (r10.compareAndSet(r12, r11) == false) goto L2;
        return true;
    L4:
        if (r11 == null) goto L15;
        r11.dispose();
        return false;
    L15:
        return false;
    }

    public static void reportDisposableSet() {
        a.n(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<b> r10, b r11) {
    L2:
        b r12 = r10.get();
        if (r12 == DISPOSED) goto L4;
        if (r10.compareAndSet(r12, r11) == false) goto L2;
        if (r12 == null) goto L18;
        r12.dispose();
        return true;
    L18:
        return true;
    L4:
        if (r11 == null) goto L17;
        r11.dispose();
        return false;
    L17:
        return false;
    }

    public static boolean setOnce(AtomicReference<b> r10, b r11) {
        io.reactivex.internal.functions.a.d(r11, "d is null");
        if (r10.compareAndSet(null, r11) == true) goto L9;
        r11.dispose();
        if (r10.get() == DISPOSED) goto L11;
        reportDisposableSet();
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean trySet(AtomicReference<b> r10, b r11) {
        if (r10.compareAndSet(null, r11) == false) goto L5;
        return true;
    L5:
        if (r10.get() != DISPOSED) goto L11;
        r11.dispose();
        return false;
    L11:
        return false;
    }

    public static boolean validate(b r10, b r11) {
        if (r11 != null) goto L6;
        a.n(new NullPointerException("next is null"));
        return false;
    L6:
        if (r10 == null) goto L9;
        r11.dispose();
        reportDisposableSet();
        return false;
    L9:
        return true;
    }

    public static DisposableHelper valueOf(String r10) {
        return (DisposableHelper) Enum.valueOf(DisposableHelper.class, r10);
    }

    public static DisposableHelper[] values() {
        return (DisposableHelper[]) $VALUES.clone();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return true;
    }
}
