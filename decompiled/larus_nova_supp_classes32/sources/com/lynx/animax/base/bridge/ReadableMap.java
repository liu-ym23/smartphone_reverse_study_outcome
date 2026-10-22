package com.lynx.animax.base.bridge;

import java.util.HashMap;
import r4a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ReadableMap {
    HashMap<String, Object> asHashMap();

    a getArray(String r1);

    double getDouble(String r1, double r2);

    int getInt(String r1, int r2);

    long getLong(String r1, long r2);

    String getString(String r1);

    ReadableType getType(String r1);
}
