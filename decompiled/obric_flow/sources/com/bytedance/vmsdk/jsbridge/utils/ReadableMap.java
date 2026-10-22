package com.bytedance.vmsdk.jsbridge.utils;

import androidx.annotation.Keep;
import androidx.collection.ArrayMap;
import fk.a;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ReadableMap {
    ReadableArray getArray(String r5);

    ReadableArray getArray(String r5, ReadableArray r10);

    boolean getBoolean(String r5);

    boolean getBoolean(String r5, boolean r10);

    byte[] getByteArray(String r5);

    byte[] getByteArray(String r5, byte[] r10);

    double getDouble(String r5);

    double getDouble(String r5, double r10);

    a getDynamic(String r5);

    int getInt(String r5);

    int getInt(String r5, int r10);

    long getLong(String r5);

    long getLong(String r5, long r10);

    ReadableMap getMap(String r5);

    ReadableMap getMap(String r5, ReadableMap r10);

    NativeHostObject getNativeHostObject(String r5);

    String getString(String r5);

    String getString(String r5, String r10);

    ReadableType getType(String r5);

    boolean hasKey(String r5);

    boolean isNull(String r5);

    ReadableMapKeySetIterator keySetIterator();

    int size();

    ArrayMap<String, Object> toArrayMap();

    HashMap<String, Object> toHashMap();
}
