package com.bytedance.vmsdk.jsbridge.utils;

/* JADX INFO: loaded from: classes2.dex */
public class NativeHostObjectTest implements NativeHostObject {
    @Override // com.bytedance.vmsdk.jsbridge.utils.NativeHostObject
    public final long getPtr(long r5) {
        return nativeGetHostObject(r5);
    }

    public native long nativeGetHostObject(long r5);
}
