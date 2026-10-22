package com.bytedance.bmmt.base;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class JniCommon {
    public JniCommon() {
    }

    public static native void nativeAddRef(long r0);

    public static native ByteBuffer nativeAllocateByteBuffer(int r0);

    public static native void nativeFreeByteBuffer(ByteBuffer r0);

    public static native void nativeReleaseRef(long r0);
}
