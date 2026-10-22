package com.lynx.animax.base.bridge;

import androidx.annotation.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ReadableMap {
    HashMap<String, Object> asHashMap();

    double getDouble(String r5, double r10);

    int getInt(String r5, int r10);

    long getLong(String r5, long r10);

    String getString(String r5);

    ReadableType getType(String r5);
}
