package com.bytedance.byted_bach_sdk.buffer;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class BachBitmapHandle {
    private long m_nativeHandle;

    static {
        System.loadLibrary("bach-sdk-jni");
    }

    public BachBitmapHandle() {
    }

    private native Bitmap nativeGetBitmap(long r1);

    private native BachGraphicsInfo nativeGetGraphicsInfo(long r1);

    public Bitmap get() {
        return getBitmap();
    }

    public Bitmap getBitmap() {
        return nativeGetBitmap(this.m_nativeHandle);
    }

    public BachGraphicsInfo getGraphicsInfo() {
        return nativeGetGraphicsInfo(this.m_nativeHandle);
    }
}
