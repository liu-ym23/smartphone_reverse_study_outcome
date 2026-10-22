package com.bytedance.vmsdk.jsbridge.utils;

import androidx.annotation.Keep;
import fk.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ReadableArray {
    ReadableArray getArray(int r5);

    boolean getBoolean(int r5);

    byte getByte(int r5);

    byte[] getByteArray(int r5);

    char getChar(int r5);

    double getDouble(int r5);

    a getDynamic(int r5);

    int getInt(int r5);

    long getLong(int r5);

    ReadableMap getMap(int r5);

    NativeHostObject getNativeHostObject(int r5);

    short getShort(int r5);

    String getString(int r5);

    ReadableType getType(int r5);

    boolean isNull(int r5);

    int size();

    ArrayList<Object> toArrayList();
}
