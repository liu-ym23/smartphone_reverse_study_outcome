package io.reactivex.internal.disposables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes6.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int r1) {
        super(r1);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        int r0 = 0;
        if (get(0) == DisposableHelper.DISPOSED) goto L13;
        int r1 = length();
    L5:
        if (r0 >= r1) goto L19;
        if (((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(r0), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) == DisposableHelper.DISPOSED) goto L12;
        io.reactivex.disposables.b r2 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(getAndSet(r0, DisposableHelper.DISPOSED), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (r2 == DisposableHelper.DISPOSED) goto L12;
        if (r2 == null) goto L12;
        r2.dispose();
    L12:
        r0 = r0 + 1;
        goto L5
    L19:
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get(0) != DisposableHelper.DISPOSED) goto L6;
        return true;
    L6:
        return false;
    }

    public io.reactivex.disposables.b replaceResource(int r4, io.reactivex.disposables.b r5) {
        io.reactivex.disposables.b r6 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
    L3:
        io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(r4), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (r0 == DisposableHelper.DISPOSED) goto L5;
        if (compareAndSet(r4, r0, r6) == false) goto L3;
        return r0;
    L5:
        r6.dispose();
        return null;
    }

    public boolean setResource(int r4, io.reactivex.disposables.b r5) {
        io.reactivex.disposables.b r6 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
    L3:
        io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(r4), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (r0 == DisposableHelper.DISPOSED) goto L5;
        if (compareAndSet(r4, r0, r6) == false) goto L3;
        if (r0 == null) goto L16;
        r0.dispose();
        return true;
    L16:
        return true;
    L5:
        r6.dispose();
        return false;
    }
}
