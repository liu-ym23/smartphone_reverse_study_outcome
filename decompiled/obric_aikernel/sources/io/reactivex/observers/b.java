package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.d;
import java.util.concurrent.atomic.AtomicReference;
import xb.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> implements o<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<io.reactivex.disposables.b> f9694c;

    public b() {
        this.f9694c = new AtomicReference();
    }

    protected void a() {
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        DisposableHelper.dispose(this.f9694c);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        if (this.f9694c.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.o
    public final void onSubscribe(io.reactivex.disposables.b r10) {
        if (d.c(this.f9694c, r10, getClass()) == false) goto L6;
        a();
        return;
    }
}
