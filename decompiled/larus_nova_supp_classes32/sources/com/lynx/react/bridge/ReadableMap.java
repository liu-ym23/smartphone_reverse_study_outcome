package com.lynx.react.bridge;

import com.lynx.tasm.TemplateData;
import f6a.a;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ReadableMap {
    HashMap<String, Object> asHashMap();

    ReadableArray getArray(String r1);

    ReadableArray getArray(String r1, ReadableArray r2);

    boolean getBoolean(String r1);

    boolean getBoolean(String r1, boolean r2);

    byte[] getByteArray(String r1);

    byte[] getByteArray(String r1, byte[] r2);

    ByteBuffer getByteBuffer(String r1);

    ByteBuffer getByteBuffer(String r1, ByteBuffer r2);

    double getDouble(String r1);

    double getDouble(String r1, double r2);

    a getDynamic(String r1);

    int getInt(String r1);

    int getInt(String r1, int r2);

    long getLong(String r1);

    long getLong(String r1, long r2);

    ReadableMap getMap(String r1);

    ReadableMap getMap(String r1, ReadableMap r2);

    PiperData getPiperData(String r1);

    PiperData getPiperData(String r1, PiperData r2);

    String getString(String r1);

    String getString(String r1, String r2);

    TemplateData getTemplateData(String r1);

    ReadableType getType(String r1);

    boolean hasKey(String r1);

    boolean isNull(String r1);

    ReadableMapKeySetIterator keySetIterator();

    int size();

    HashMap<String, Object> toHashMap();
}
