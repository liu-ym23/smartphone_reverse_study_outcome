package com.lynx.tasm.behavior.render;

import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.ui.view.b;

/* JADX INFO: loaded from: classes2.dex */
public class PlatformRendererContext {
    @CalledByNative
    public void createPlatformRenderer(int r5, int r10) {
        if (r10 != 1) goto L5;
        new b(null);
        throw null;
    L5:
        if (r10 != 2) goto L7;
        throw null;
    L7:
        if (r10 == 3) goto L9;
        return;
    L9:
        new AndroidScrollView(null, new UIScrollView(null, null));
        throw null;
    }

    @CalledByNative
    public void destroyPlatformRenderer(int r5) {
        throw null;
    }

    @CalledByNative
    public void insertPlatformRenderer(int r5, int r10, int r11) {
        throw null;
    }

    @CalledByNative
    public void invalidatePlatformRenderer(int r5) {
        throw null;
    }

    public native long nativeCreateEmbeddedViewContext(PlatformRendererContext r5);

    @CalledByNative
    public void removePlatformRendererFromParent(int r5) {
        throw null;
    }
}
