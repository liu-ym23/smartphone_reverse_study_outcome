package io.reactivex.internal.disposables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.f;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CancellableDisposable extends AtomicReference<f> implements io.reactivex.disposables.b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f r3) {
        super((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (get() == null) goto L13;
        f r2 = (f) ZeusTransformUtils.preCheckCast(getAndSet(null), f.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        r2.a();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        io.reactivex.exceptions.a.a(e);
        io.reactivex.d.a.a(e);
        return;
    L14:
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
