package com.lynx.react.bridge;

import f6a.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ReadableArray {
    ArrayList<Object> asArrayList();

    ReadableArray getArray(int r1);

    boolean getBoolean(int r1);

    byte getByte(int r1);

    byte[] getByteArray(int r1);

    char getChar(int r1);

    double getDouble(int r1);

    a getDynamic(int r1);

    int getInt(int r1);

    long getLong(int r1);

    ReadableMap getMap(int r1);

    PiperData getPiperData(int r1);

    short getShort(int r1);

    String getString(int r1);

    ReadableType getType(int r1);

    boolean isNull(int r1);

    int size();

    ArrayList<Object> toArrayList();
}
