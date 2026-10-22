package io.reactivex.internal.disposables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final enum DisposableHelper extends Enum<DisposableHelper> implements io.reactivex.disposables.b {
    private static final /* synthetic */ DisposableHelper[] $VALUES = null;
    public static final DisposableHelper DISPOSED = null;

    static {
        DisposableHelper r0 = new DisposableHelper("DISPOSED", 0);
        DISPOSED = r0;
        $VALUES = new DisposableHelper[]{r0};
    }

    private DisposableHelper(String r1, int r2) {
        super(r1, r2);
    }

    public static boolean dispose(AtomicReference<io.reactivex.disposables.b> r3) {
        io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(r3.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        DisposableHelper r1 = DISPOSED;
        if (r0 == r1) goto L10;
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(r3.getAndSet(r1), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (r4 == r1) goto L13;
        if (r4 == null) goto L12;
        r4.dispose();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean isDisposed(io.reactivex.disposables.b r2) {
        if (((io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r2, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) != DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean replace(AtomicReference<io.reactivex.disposables.b> r3, io.reactivex.disposables.b r4) {
        io.reactivex.disposables.b r5 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
    L3:
        io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(r3.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (r0 == DISPOSED) goto L5;
        if (r3.compareAndSet(r0, r5) == false) goto L3;
        return true;
    L5:
        if (r5 == null) goto L16;
        r5.dispose();
        return false;
    L16:
        return false;
    }

    public static void reportDisposableSet() {
        io.reactivex.d.a.a(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<io.reactivex.disposables.b> r3, io.reactivex.disposables.b r4) {
        io.reactivex.disposables.b r5 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
    L3:
        io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(r3.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (r0 == DISPOSED) goto L5;
        if (r3.compareAndSet(r0, r5) == false) goto L3;
        if (r0 == null) goto L19;
        r0.dispose();
        return true;
    L19:
        return true;
    L5:
        if (r5 == null) goto L18;
        r5.dispose();
        return false;
    L18:
        return false;
    }

    public static boolean setOnce(AtomicReference<io.reactivex.disposables.b> r2, io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "d is null");
        if (r2.compareAndSet(null, r4) == true) goto L9;
        r4.dispose();
        if (r2.get() == DISPOSED) goto L11;
        reportDisposableSet();
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean trySet(AtomicReference<io.reactivex.disposables.b> r2, io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (r2.compareAndSet(null, r4) == false) goto L5;
        return true;
    L5:
        if (r2.get() != DISPOSED) goto L11;
        r4.dispose();
        return false;
    L11:
        return false;
    }

    public static boolean validate(io.reactivex.disposables.b r2, io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r2, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        io.reactivex.disposables.b r5 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        io.reactivex.d.a.a(new NullPointerException("next is null"));
        return false;
    L6:
        if (r4 == null) goto L9;
        r5.dispose();
        reportDisposableSet();
        return false;
    L9:
        return true;
    }

    public static DisposableHelper valueOf(String r2) {
        return (DisposableHelper) ZeusTransformUtils.preCheckCast(Enum.valueOf(DisposableHelper.class, r2), DisposableHelper.class, "com.obric.memorydata.plugin");
    }

    public static DisposableHelper[] values() {
        return (DisposableHelper[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DisposableHelper[].class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return true;
    }
}
