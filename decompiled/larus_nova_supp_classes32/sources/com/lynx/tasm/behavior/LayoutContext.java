package com.lynx.tasm.behavior;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.behavior.ui.PropBundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class LayoutContext {
    public long a;
    public boolean b;
    public long c;

    private native long nativeCreateLayoutContext(Object r1);

    private native void nativeTriggerLayout(long r1);

    public abstract void attachLayoutNodeManager(long r1);

    public void b() {
        this.b = true;
    }

    public abstract int createNode(int r1, String r2, PropBundle r3, ReadableMapBuffer r4, boolean r5);

    public abstract void destroyNodes(int[] r1);

    public abstract void dispatchOnLayout(int r1, int r2, int r3, int r4, int r5);

    public abstract void dispatchOnLayoutBefore(int r1);

    public abstract Object getExtraBundle(int r1);

    public abstract void insertNode(int r1, int r2, int r3);

    public abstract void removeNode(int r1, int r2, int r3);

    public abstract void scheduleLayout();

    public abstract void setFontFaces(ReadableMap r1);

    public abstract void updateProps(int r1, PropBundle r2, ReadableMapBuffer r3);

    public void c() {
        long r0 = this.a;
        if (r0 == 0) goto L6;
        nativeTriggerLayout(r0);
        return;
    }

    public void detachNativePtr() {
        this.a = 0;
    }

    public LayoutContext() {
        this.a = 0;
        this.c = 0;
    }

    public void a(v0 r3) {
        this.c = nativeCreateLayoutContext(r3);
    }

    public void attachNativePtr(long r1) {
        this.a = r1;
    }
}
