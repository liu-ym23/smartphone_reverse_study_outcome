package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
final enum AutoDisposableHelper extends Enum<AutoDisposableHelper> implements Disposable {
    public static final AutoDisposableHelper DISPOSED = null;
    public static final /* synthetic */ AutoDisposableHelper[] a = null;

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    static {
        AutoDisposableHelper r0 = new AutoDisposableHelper();
        DISPOSED = r0;
        a = new AutoDisposableHelper[]{r0};
    }

    public AutoDisposableHelper() {
        super("DISPOSED", 0);
    }

    public static AutoDisposableHelper[] values() {
        return (AutoDisposableHelper[]) a.clone();
    }

    public static boolean dispose(AtomicReference<Disposable> r2) {
        Disposable r0 = r2.get();
        AutoDisposableHelper r1 = DISPOSED;
        if (r0 == r1) goto L10;
        Disposable r3 = r2.getAndSet(r1);
        if (r3 == r1) goto L13;
        if (r3 == null) goto L12;
        r3.dispose();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static AutoDisposableHelper valueOf(String r1) {
        return (AutoDisposableHelper) r27.a.a(AutoDisposableHelper.class, r1);
    }
}
