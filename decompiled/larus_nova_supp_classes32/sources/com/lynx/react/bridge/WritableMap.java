package com.lynx.react.bridge;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface WritableMap extends ReadableMap {
    void merge(ReadableMap r1);

    void putArray(String r1, WritableArray r2);

    void putBoolean(String r1, boolean r2);

    void putByteArray(String r1, byte[] r2);

    void putByteArrayAsString(byte[] r1, byte[] r2);

    void putByteBuffer(String r1, ByteBuffer r2);

    void putDouble(String r1, double r2);

    void putInt(String r1, int r2);

    void putLong(String r1, long r2);

    void putMap(String r1, WritableMap r2);

    void putNull(String r1);

    void putPiperData(String r1, PiperData r2);

    void putString(String r1, String r2);
}
