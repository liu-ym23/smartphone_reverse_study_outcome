package com.bytedance.bmmt.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface RefCounted {
    void release();

    void retain();
}
