package com.lynx.react.bridge;

import com.lynx.tasm.TemplateData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface WritableArray extends ReadableArray {
    void pushArray(WritableArray r1);

    void pushBoolean(boolean r1);

    void pushByteArray(byte[] r1);

    void pushDouble(double r1);

    void pushInt(int r1);

    void pushLong(long r1);

    void pushMap(WritableMap r1);

    void pushNull();

    void pushPiperData(PiperData r1);

    void pushString(String r1);

    void pushTemplateData(TemplateData r1);
}
