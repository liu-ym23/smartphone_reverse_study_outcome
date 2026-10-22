package com.lynx.react.bridge;

import androidx.annotation.Keep;
import java.util.ArrayList;
import pm.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ReadableArray {
    ArrayList<Object> asArrayList();

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

    PiperData getPiperData(int r5);

    short getShort(int r5);

    String getString(int r5);

    ReadableType getType(int r5);

    boolean isNull(int r5);

    int size();

    @Deprecated
    ArrayList<Object> toArrayList();
}
