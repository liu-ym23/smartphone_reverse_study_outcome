package com.lynx.animax.base.bridge;

import com.lynx.animax.base.CalledByNative;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class JavaOnlyArray extends ArrayList<Object> {
    public JavaOnlyArray() {
    }

    @CalledByNative
    private static JavaOnlyArray create() {
        return new JavaOnlyArray();
    }

    @CalledByNative
    public String getString(int r5) {
        return (String) get(r5);
    }

    @CalledByNative
    public int getTypeIndex(int r5) {
        Object r10 = get(r5);
        if (r10 != null) goto L6;
        ReadableType r11 = ReadableType.Null;
    L32:
        return r11.ordinal();
    L6:
        if ((r10 instanceof Boolean) == false) goto L9;
        r11 = ReadableType.Boolean;
        goto L32
    L9:
        if ((r10 instanceof Integer) == false) goto L12;
        r11 = ReadableType.Int;
        goto L32
    L12:
        if ((r10 instanceof Long) == false) goto L15;
        r11 = ReadableType.Long;
        goto L32
    L15:
        if ((r10 instanceof Number) == false) goto L17;
    L30:
        r11 = ReadableType.Number;
        goto L32
    L17:
        if ((r10 instanceof Character) == true) goto L30;
        if ((r10 instanceof String) == false) goto L23;
        r11 = ReadableType.String;
        goto L32
    L23:
        if ((r10 instanceof ReadableMap) == false) goto L26;
        r11 = ReadableType.Map;
        goto L32
    L26:
        if ((r10 instanceof byte[]) == false) goto L29;
        r11 = ReadableType.ByteArray;
        goto L32
    L29:
        throw new IllegalArgumentException("unsupported type " + r10.getClass() + " contained in JavaOnlyArray");
    }

    @CalledByNative
    public void pushArray(JavaOnlyArray r5) {
        add(r5);
    }

    @CalledByNative
    public void pushByteArrayAsString(byte[] r5) {
        add(new String(r5));
    }

    @CalledByNative
    public void pushString(String r5) {
        add(r5);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    @CalledByNative
    public int size() {
        return super.size();
    }
}
