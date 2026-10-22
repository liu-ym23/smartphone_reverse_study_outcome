package com.bytedance.bmmt.video.agfx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class GPUCacheCtrl {
    private static GPUCacheCtrl instance;
    private long nativeHandle;

    private static native void nativeBind(long r0);

    private static native GPUCacheCtrl nativeGetInstance();

    private static native void nativeUnBind(long r0);

    public void bind() {
        nativeBind(this.nativeHandle);
    }

    public void unbind() {
        nativeUnBind(this.nativeHandle);
    }

    public static GPUCacheCtrl getInstance() {
        GPUCacheCtrl r0 = nativeGetInstance();
        instance = r0;
        return r0;
    }

    private GPUCacheCtrl(long r1) {
        this.nativeHandle = r1;
    }
}
