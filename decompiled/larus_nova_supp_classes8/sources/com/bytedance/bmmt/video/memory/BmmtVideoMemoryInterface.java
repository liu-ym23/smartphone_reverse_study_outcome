package com.bytedance.bmmt.video.memory;

import com.bytedance.bmmt.base.RefCounted;
import com.bytedance.bmmt.video.BmmtVideoMemoryType;
import com.bytedance.bmmt.video.PixelFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface BmmtVideoMemoryInterface extends RefCounted {
    int getHeight();

    BmmtVideoMemoryType getMemoryType();

    long getNativeHandle();

    PixelFormat getPixelFormat();

    int getWidth();

    @Override // com.bytedance.bmmt.base.RefCounted
    void release();

    @Override // com.bytedance.bmmt.base.RefCounted
    void retain();
}
