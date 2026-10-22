package io.reactivex.disposables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
final class FutureDisposable extends AtomicReference<Future<?>> implements b {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    FutureDisposable(Future<?> r3, boolean r4) {
        super((Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.memorydata.plugin"));
        this.allowInterrupt = r4;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future r0 = (Future) ZeusTransformUtils.preCheckCast(getAndSet(null), Future.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.cancel(this.allowInterrupt);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        Future r2 = (Future) ZeusTransformUtils.preCheckCast(get(), Future.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        return true;
    L5:
        if (r2.isDone() == true) goto L8;
        return false;
    }
}
