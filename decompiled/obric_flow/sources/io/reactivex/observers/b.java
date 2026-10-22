package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f18176a;

    public b() {
        this.f18176a = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f18176a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f18176a.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        AtomicReference r10 = this.f18176a;
        Class<?> r11 = getClass();
        io.reactivex.internal.functions.e.d(r5, "next is null");
    L4:
        if (r10.compareAndSet(null, r5) == true) goto L16;
        if (r10.get() == null) goto L4;
        r5.dispose();
        if (r10.get() == DisposableHelper.DISPOSED) goto L15;
        com.lynx.tasm.behavior.ui.utils.e.p(r11);
        return;
    L15:
        return;
    }
}
