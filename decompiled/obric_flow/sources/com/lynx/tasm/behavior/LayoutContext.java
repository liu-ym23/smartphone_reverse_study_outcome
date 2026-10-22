package com.lynx.tasm.behavior;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.behavior.ui.PropBundle;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LayoutContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10137c;

    private native long nativeCreateLayoutContext(Object r5);

    private native void nativeTriggerLayout(long r5);

    public final void a() {
        long r5 = this.f10135a;
        if (r5 == 0) goto L6;
        nativeTriggerLayout(r5);
        return;
    }

    @CalledByNative
    public abstract void attachLayoutNodeManager(long r5);

    @CalledByNative
    public void attachNativePtr(long r5) {
        this.f10135a = r5;
    }

    public final void b(w0 r5) {
        this.f10137c = nativeCreateLayoutContext(r5);
    }

    @CalledByNative
    public abstract int createNode(int r5, String r10, PropBundle r11, ReadableMapBuffer r12, boolean r13);

    @CalledByNative
    public abstract void destroyNodes(int[] r5);

    @CalledByNative
    public void detachNativePtr() {
        this.f10135a = 0;
    }

    @CalledByNative
    public abstract void dispatchOnLayout(int r5, int r10, int r11, int r12, int r13);

    @CalledByNative
    public abstract void dispatchOnLayoutBefore(int r5);

    @CalledByNative
    public abstract Object getExtraBundle(int r5);

    @CalledByNative
    public abstract void insertNode(int r5, int r10, int r11);

    @CalledByNative
    public abstract void moveNode(int r5, int r10, int r11, int r12);

    @CalledByNative
    public abstract void removeNode(int r5, int r10, int r11);

    @CalledByNative
    public abstract void scheduleLayout();

    @CalledByNative
    public abstract void setFontFaces(ReadableMap r5);

    @CalledByNative
    public abstract void updateProps(int r5, PropBundle r10, ReadableMapBuffer r11);
}
