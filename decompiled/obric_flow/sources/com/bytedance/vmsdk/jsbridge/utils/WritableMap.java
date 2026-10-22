package com.bytedance.vmsdk.jsbridge.utils;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface WritableMap extends ReadableMap {
    void merge(ReadableMap r5);

    void putArray(String r5, WritableArray r10);

    void putBoolean(String r5, boolean r10);

    void putByteArray(String r5, byte[] r10);

    void putByteArrayAsString(byte[] r5, byte[] r10);

    void putDouble(String r5, double r10);

    void putInt(String r5, int r10);

    void putLong(String r5, long r10);

    void putMap(String r5, WritableMap r10);

    void putNativeHostObject(String r5, NativeHostObject r10);

    void putNull(String r5);

    void putString(String r5, String r10);
}
