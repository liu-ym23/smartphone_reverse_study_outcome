package com.bytedance.vmsdk.jsbridge.utils;

import android.util.Log;
import fk.a;
import fk.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class JavaOnlyArray extends ArrayList<Object> implements ReadableArray, WritableArray {
    public JavaOnlyArray(List r5) {
        super(r5);
    }

    @CalledByNative
    private static JavaOnlyArray create() {
        return new JavaOnlyArray();
    }

    public final JSONArray a() {
        JSONArray r5 = new JSONArray();
        int r10 = size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L17;
        Object r12 = get(r11);
        if (getType(r11) != ReadableType.Map) goto L11;
        r5.put(((JavaOnlyMap) r12).a());     // Catch: Exception -> L8
    L16:
        r11 = r11 + 1;
        goto L3
    L11:
        if (getType(r11) != ReadableType.Array) goto L13;
        r5.put(((JavaOnlyArray) r12).a());     // Catch: Exception -> L8
        goto L16
    L13:
        r5.put(r12);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.e("JavaOnlyArray", e.toString());
        goto L16
    L17:
        return r5;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    @CalledByNative
    public void clear() {
        super.clear();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public /* bridge */ /* synthetic */ ReadableArray getArray(int r5) {
        return getArray(r5);
    }

    @CalledByNative
    public Object getAt(int r5) {
        return get(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public boolean getBoolean(int r5) {
        return ((Boolean) get(r5)).booleanValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public final byte getByte(int r5) {
        return ((Number) get(r5)).byteValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public byte[] getByteArray(int r5) {
        return (byte[]) get(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public final char getChar(int r5) {
        return (char) ((Number) get(r5)).shortValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public double getDouble(int r5) {
        return ((Number) get(r5)).doubleValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public final a getDynamic(int r5) {
        b r10 = (b) b.f16917c.acquire();
        if (r10 != null) goto L5;
        r10 = new b();
        r10.f16919b = -1;
    L5:
        r10.f16918a = this;
        r10.f16919b = r5;
        return r10;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public int getInt(int r5) {
        return ((Number) get(r5)).intValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public long getLong(int r5) {
        return ((Number) get(r5)).longValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public /* bridge */ /* synthetic */ ReadableMap getMap(int r5) {
        return getMap(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public NativeHostObject getNativeHostObject(int r5) {
        return (NativeHostObject) get(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public final short getShort(int r5) {
        return ((Number) get(r5)).shortValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public String getString(int r5) {
        return (String) get(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public final ReadableType getType(int r5) {
        Object r10 = get(r5);
        if (r10 != null) goto L7;
        return ReadableType.Null;
    L7:
        if ((r10 instanceof Boolean) == false) goto L11;
        return ReadableType.Boolean;
    L11:
        if ((r10 instanceof Integer) == false) goto L15;
        return ReadableType.Int;
    L15:
        if ((r10 instanceof Long) == false) goto L19;
        return ReadableType.Long;
    L19:
        if ((r10 instanceof Number) == true) goto L46;
        if ((r10 instanceof Character) == true) goto L46;
        if ((r10 instanceof String) == false) goto L28;
        return ReadableType.String;
    L28:
        if ((r10 instanceof ReadableArray) == false) goto L32;
        return ReadableType.Array;
    L32:
        if ((r10 instanceof ReadableMap) == false) goto L36;
        return ReadableType.Map;
    L36:
        if ((r10 instanceof byte[]) == false) goto L40;
        return ReadableType.ByteArray;
    L40:
        if ((r10 instanceof NativeHostObject) == true) goto L42;
        return null;
    L42:
        return ReadableType.NativeHostObject;
    L46:
        return ReadableType.Number;
    }

    @CalledByNative
    public int getTypeIndex(int r5) {
        return getType(r5).ordinal();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public final boolean isNull(int r5) {
        if (get(r5) != null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    @CalledByNative
    public void pushArray(WritableArray r5) {
        add(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    @CalledByNative
    public void pushBoolean(boolean r5) {
        add(Boolean.valueOf(r5));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    @CalledByNative
    public void pushByteArray(byte[] r5) {
        add(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    @CalledByNative
    public void pushByteArrayAsString(byte[] r5) {
        add(new String(r5));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    @CalledByNative
    public void pushDouble(double r5) {
        add(Double.valueOf(r5));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    @CalledByNative
    public void pushInt(int r5) {
        add(Integer.valueOf(r5));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    @CalledByNative
    public void pushLong(long r5) {
        add(Long.valueOf(r5));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    @CalledByNative
    public void pushMap(WritableMap r5) {
        add(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    @CalledByNative
    public void pushNull() {
        add(null);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    @CalledByNative
    public void pushString(String r5) {
        add(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    @CalledByNative
    public void putNativeHostObject(NativeHostObject r5) {
        add(r5);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List, com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public int size() {
        return super.size();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public final ArrayList toArrayList() {
        return new ArrayList(this);
    }

    public JavaOnlyArray() {
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public JavaOnlyArray getArray(int r5) {
        return (JavaOnlyArray) get(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    @CalledByNative
    public JavaOnlyMap getMap(int r5) {
        return (JavaOnlyMap) get(r5);
    }
}
