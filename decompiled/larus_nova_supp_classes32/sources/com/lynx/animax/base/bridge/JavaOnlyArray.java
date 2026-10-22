package com.lynx.animax.base.bridge;

import java.util.ArrayList;
import r4a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class JavaOnlyArray extends ArrayList<Object> implements a {
    public ArrayList<Object> asArrayList() {
        return this;
    }

    private static JavaOnlyArray create() {
        return new JavaOnlyArray();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return super.size();
    }

    public JavaOnlyArray() {
    }

    public String getString(int r1) {
        return (String) get(r1);
    }

    public ReadableType getType(int r4) {
        Object r5 = get(r4);
        if (r5 != null) goto L7;
        return ReadableType.Null;
    L7:
        if ((r5 instanceof Boolean) == false) goto L11;
        return ReadableType.Boolean;
    L11:
        if ((r5 instanceof Integer) == false) goto L15;
        return ReadableType.Int;
    L15:
        if ((r5 instanceof Long) == false) goto L19;
        return ReadableType.Long;
    L19:
        if ((r5 instanceof Number) == true) goto L38;
        if ((r5 instanceof Character) == true) goto L38;
        if ((r5 instanceof String) == false) goto L28;
        return ReadableType.String;
    L28:
        if ((r5 instanceof ReadableMap) == false) goto L32;
        return ReadableType.Map;
    L32:
        if ((r5 instanceof byte[]) == false) goto L36;
        return ReadableType.ByteArray;
    L36:
        throw new IllegalArgumentException("unsupported type " + r5.getClass() + " contained in JavaOnlyArray");
    L38:
        return ReadableType.Number;
    }

    public int getTypeIndex(int r1) {
        return getType(r1).ordinal();
    }

    public void pushArray(JavaOnlyArray r1) {
        add(r1);
    }

    public void pushByteArrayAsString(byte[] r2) {
        add(new String(r2));
    }

    public void pushString(String r1) {
        add(r1);
    }
}
