package org.tensorflow.lite;

/* JADX INFO: loaded from: classes2.dex */
final class NativeSignatureRunnerWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9818c;

    public NativeSignatureRunnerWrapper(long r8, String r10, long r11) {
        this.f9818c = false;
        this.f9817b = r11;
        long r12 = nativeGetSignatureRunner(r8, r10);
        this.f9816a = r12;
        if (r12 == (-1)) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(defpackage.b.d("Input error: Signature ", r10, " not found."));
    }

    private static native void nativeAllocateTensors(long r8, long r10);

    private static native int nativeGetInputIndex(long r8, String r10);

    private static native int nativeGetOutputIndex(long r8, String r10);

    private static native long nativeGetSignatureRunner(long r8, String r10);

    private static native int nativeGetSubgraphIndex(long r8);

    private static native String[] nativeInputNames(long r8);

    private static native void nativeInvoke(long r8, long r10);

    private static native String[] nativeOutputNames(long r8);

    private static native boolean nativeResizeInput(long r8, long r10, String r11, int[] r12);

    public final void a() {
        if (this.f9818c == false) goto L5;
        return;
    L5:
        nativeAllocateTensors(this.f9816a, this.f9817b);
        this.f9818c = true;
    }

    public final int b(String r8) {
        int r10 = nativeGetInputIndex(this.f9816a, r8);
        if (r10 == (-1)) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(defpackage.b.d("Input error: input ", r8, " not found."));
    }

    public final int c(String r8) {
        int r10 = nativeGetOutputIndex(this.f9816a, r8);
        if (r10 == (-1)) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(defpackage.b.d("Input error: output ", r8, " not found."));
    }

    public final int d() {
        return nativeGetSubgraphIndex(this.f9816a);
    }

    public final void e() {
        nativeInvoke(this.f9816a, this.f9817b);
    }

    public final void f(int[] r8, String r10) {
        this.f9818c = false;
        nativeResizeInput(this.f9816a, this.f9817b, r10, r8);
    }
}
