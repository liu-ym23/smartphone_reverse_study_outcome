package org.tensorflow.lite.nnapi;

import org.tensorflow.lite.TensorFlowLite;
import org.tensorflow.lite.b;

/* JADX INFO: loaded from: classes2.dex */
public class NnApiDelegateImpl implements b, AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9847a;

    public NnApiDelegateImpl(a.C0132a r11) {
        TensorFlowLite.a();
        r11.getClass();
        this.f9847a = createDelegate(-1, null, null, null, -1, false, true, false, 0);
    }

    private static native long createDelegate(int r8, String r10, String r11, String r12, int r13, boolean r14, boolean r15, boolean r16, long r17);

    private static native void deleteDelegate(long r8);

    private static native int getNnapiErrno(long r8);

    @Override // org.tensorflow.lite.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long r8 = this.f9847a;
        if (r8 == 0) goto L6;
        deleteDelegate(r8);
        this.f9847a = 0;
        return;
    }

    @Override // org.tensorflow.lite.b
    public final long getNativeHandle() {
        return this.f9847a;
    }
}
