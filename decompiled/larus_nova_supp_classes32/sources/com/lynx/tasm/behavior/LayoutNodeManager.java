package com.lynx.tasm.behavior;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LayoutNodeManager {
    public long a;

    private native void nativeAlignNativeNode(long r1, int r3, float r4, float r5);

    private native int nativeGetFlexDirection(long r1, int r3);

    private native float nativeGetHeight(long r1, int r3);

    private native int[] nativeGetMargin(long r1, int r3);

    private native float nativeGetMaxHeight(long r1, int r3);

    private native float nativeGetMaxWidth(long r1, int r3);

    private native float nativeGetMinHeight(long r1, int r3);

    private native float nativeGetMinWidth(long r1, int r3);

    private native int[] nativeGetPadding(long r1, int r3);

    private native float nativeGetWidth(long r1, int r3);

    private native boolean nativeIsDirty(long r1, int r3);

    private native void nativeMarkDirty(long r1, int r3);

    private native long nativeMeasureNativeNode(long r1, int r3, float r4, int r5, float r6, int r7, boolean r8);

    private native int[] nativeMeasureNativeNodeReturnWithBaseline(long r1, int r3, float r4, int r5, float r6, int r7, boolean r8);

    private native void nativeSetMeasureFunc(long r1, int r3, Object r4);

    private native void nativeSetNeedsLayoutForce(long r1, int r3);

    public LayoutNodeManager() {
        this.a = 0;
    }

    public float b(int r3) {
        return nativeGetHeight(this.a, r3);
    }

    public int[] c(int r3) {
        return nativeGetMargin(this.a, r3);
    }

    public float d(int r3) {
        return nativeGetWidth(this.a, r3);
    }

    public boolean e(int r3) {
        return nativeIsDirty(this.a, r3);
    }

    public void f(int r3) {
        nativeMarkDirty(this.a, r3);
    }

    public final void j(int r3) {
        nativeSetNeedsLayoutForce(this.a, r3);
    }

    public void i(int r3, Object r4) {
        nativeSetMeasureFunc(this.a, r3, r4);
    }

    public void a(int r7, float r8, float r9) {
        nativeAlignNativeNode(this.a, r7, r8, r9);
    }

    public long g(int r10, float r11, int r12, float r13, int r14, boolean r15) {
        return nativeMeasureNativeNode(this.a, r10, r11, r12, r13, r14, r15);
    }

    public int[] h(int r10, float r11, int r12, float r13, int r14, boolean r15) {
        return nativeMeasureNativeNodeReturnWithBaseline(this.a, r10, r11, r12, r13, r14, r15);
    }
}
