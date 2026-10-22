package com.lynx.react.bridge;

import androidx.annotation.Keep;
import com.lynx.tasm.TemplateData;
import java.nio.ByteBuffer;
import java.util.HashMap;
import pm.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ReadableMap {
    HashMap<String, Object> asHashMap();

    ReadableArray getArray(String r5);

    ReadableArray getArray(String r5, ReadableArray r10);

    boolean getBoolean(String r5);

    boolean getBoolean(String r5, boolean r10);

    byte[] getByteArray(String r5);

    byte[] getByteArray(String r5, byte[] r10);

    ByteBuffer getByteBuffer(String r5);

    ByteBuffer getByteBuffer(String r5, ByteBuffer r10);

    double getDouble(String r5);

    double getDouble(String r5, double r10);

    a getDynamic(String r5);

    int getInt(String r5);

    int getInt(String r5, int r10);

    long getLong(String r5);

    long getLong(String r5, long r10);

    ReadableMap getMap(String r5);

    ReadableMap getMap(String r5, ReadableMap r10);

    PiperData getPiperData(String r5);

    PiperData getPiperData(String r5, PiperData r10);

    String getString(String r5);

    String getString(String r5, String r10);

    TemplateData getTemplateData(String r5);

    ReadableType getType(String r5);

    boolean hasKey(String r5);

    boolean isNull(String r5);

    ReadableMapKeySetIterator keySetIterator();

    int size();

    @Deprecated
    HashMap<String, Object> toHashMap();
}
