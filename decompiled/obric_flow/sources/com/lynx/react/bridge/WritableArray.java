package com.lynx.react.bridge;

import androidx.annotation.Keep;
import com.lynx.tasm.TemplateData;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface WritableArray extends ReadableArray {
    void pushArray(WritableArray r5);

    void pushBoolean(boolean r5);

    void pushByteArray(byte[] r5);

    void pushDouble(double r5);

    void pushInt(int r5);

    void pushLong(long r5);

    void pushMap(WritableMap r5);

    void pushNull();

    void pushPiperData(PiperData r5);

    void pushString(String r5);

    void pushTemplateData(TemplateData r5);
}
