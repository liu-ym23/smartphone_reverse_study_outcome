package com.bytedance.vmsdk.jsbridge.utils;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface WritableArray extends ReadableArray {
    void pushArray(WritableArray r5);

    void pushBoolean(boolean r5);

    void pushByteArray(byte[] r5);

    void pushByteArrayAsString(byte[] r5);

    void pushDouble(double r5);

    void pushInt(int r5);

    void pushLong(long r5);

    void pushMap(WritableMap r5);

    void pushNull();

    void pushString(String r5);

    void putNativeHostObject(NativeHostObject r5);
}
