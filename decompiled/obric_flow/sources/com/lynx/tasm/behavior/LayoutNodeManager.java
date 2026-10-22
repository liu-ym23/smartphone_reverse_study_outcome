package com.lynx.tasm.behavior;

import com.lynx.tasm.behavior.shadow.ShadowNode;

/* JADX INFO: loaded from: classes2.dex */
public class LayoutNodeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10138a;

    private native void nativeAlignNativeNode(long r5, int r10, float r11, float r12);

    private native int nativeGetFlexDirection(long r5, int r10);

    private native float nativeGetHeight(long r5, int r10);

    private native int[] nativeGetMargin(long r5, int r10);

    private native float nativeGetMaxHeight(long r5, int r10);

    private native float nativeGetMaxWidth(long r5, int r10);

    private native float nativeGetMinHeight(long r5, int r10);

    private native float nativeGetMinWidth(long r5, int r10);

    private native int[] nativeGetPadding(long r5, int r10);

    private native float nativeGetWidth(long r5, int r10);

    private native boolean nativeIsDirty(long r5, int r10);

    private native void nativeMarkDirty(long r5, int r10);

    private native long nativeMeasureNativeNode(long r5, int r10, float r11, int r12, float r13, int r14, boolean r15);

    private native int[] nativeMeasureNativeNodeReturnWithBaseline(long r5, int r10, float r11, int r12, float r13, int r14, boolean r15);

    private native void nativeSetMeasureFunc(long r5, int r10, Object r11);

    private native void nativeSetNeedsLayoutForce(long r5, int r10);

    public final float a(int r5) {
        return nativeGetHeight(this.f10138a, r5);
    }

    public final long b(int r10, float r11, int r12, float r13, int r14, boolean r15) {
        return nativeMeasureNativeNode(this.f10138a, r10, r11, r12, r13, r14, r15);
    }

    public final void c(float r10, float r11, int r12) {
        nativeAlignNativeNode(this.f10138a, r12, r10, r11);
    }

    public final void d(int r5, ShadowNode r10) {
        nativeSetMeasureFunc(this.f10138a, r5, r10);
    }

    public final int[] e(int r5) {
        return nativeGetMargin(this.f10138a, r5);
    }

    public final int[] f(int r10, float r11, int r12, float r13, int r14, boolean r15) {
        return nativeMeasureNativeNodeReturnWithBaseline(this.f10138a, r10, r11, r12, r13, r14, r15);
    }

    public final float g(int r5) {
        return nativeGetWidth(this.f10138a, r5);
    }

    public final void h(int r5) {
        nativeMarkDirty(this.f10138a, r5);
    }

    public final void i(int r5) {
        nativeSetNeedsLayoutForce(this.f10138a, r5);
    }
}
