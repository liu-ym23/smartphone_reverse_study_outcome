package com.bytedance.bmmt.video;

import com.bytedance.bmmt.base.RefCounted;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface VideoFrameHelperInterface extends RefCounted {
    long getNativeHandle();

    @Override // com.bytedance.bmmt.base.RefCounted
    void release();

    @Override // com.bytedance.bmmt.base.RefCounted
    void retain();
}
