package com.lynx.animax;

import android.view.Choreographer;
import com.lynx.animax.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class VSyncMonitor {
    public static void a(long r5, long r10) {
        nativeInvokeCallback(r5, r10);
    }

    private static native void nativeInvokeCallback(long r5, long r10);

    @CalledByNative
    public static void requestVSync(long r5) {
        Choreographer.getInstance().postFrameCallback(new j(0, r5));
    }
}
