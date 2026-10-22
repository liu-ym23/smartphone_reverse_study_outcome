package com.bytedance.vmsdk.jsbridge.utils;

import android.util.Log;
import androidx.collection.ArrayMap;
import fk.a;
import fk.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import td.d;

/* JADX INFO: loaded from: classes2.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap, WritableMap {
    public JavaOnlyMap(Map r5) {
        super(r5);
    }

    @CalledByNative
    private static JavaOnlyMap create() {
        return new JavaOnlyMap();
    }

    public final JSONObject a() {
        JSONObject r5 = new JSONObject();
        if (size() == 0) goto L23;
        Iterator r10 = keySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L23;
        String r11 = (String) r10.next();
        Object r12 = get(r11);
        if (getType(r11) == ReadableType.Map) goto L11;
        if (getType(r11) == ReadableType.Array) goto L16;
        if (getType(r11) == ReadableType.Null) goto L19;
        r5.putOpt(r11, r12);     // Catch: Exception -> L12
        goto L7
    L19:
        r5.putOpt(r11, JSONObject.NULL);     // Catch: Exception -> L12
        goto L7
    L16:
        r5.putOpt(r11, ((JavaOnlyArray) r12).a());     // Catch: Exception -> L12
        goto L7
    L11:
        r5.putOpt(r11, ((JavaOnlyMap) r12).a());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Log.e("JavaOnlyMap", e.toString());
    L23:
        return r5;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    @CalledByNative
    public /* bridge */ /* synthetic */ ReadableArray getArray(String r5) {
        return getArray(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    @CalledByNative
    public boolean getBoolean(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof Boolean) == true) goto L5;
        if (r10 == null) goto L10;
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to java.lang.Boolean, key: " + r5);
    L10:
        throw new NullPointerException(d.b("key: ", r5));
    L5:
        return ((Boolean) r10).booleanValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final byte[] getByteArray(String r5, byte[] r10) {
        Object r11 = get(r5);
        if ((r11 instanceof byte[]) == true) goto L5;
        return r10;
    L5:
        return (byte[]) r11;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    @CalledByNative
    public double getDouble(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof Number) == true) goto L5;
        if (r10 == null) goto L10;
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r5);
    L10:
        throw new NullPointerException(d.b("key: ", r5));
    L5:
        return ((Number) r10).doubleValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final a getDynamic(String r5) {
        c r10 = (c) c.f16920c.acquire();
        if (r10 != null) goto L5;
        r10 = new c();
    L5:
        r10.f16921a = this;
        r10.f16922b = r5;
        return r10;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    @CalledByNative
    public int getInt(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof Number) == true) goto L5;
        if (r10 == null) goto L10;
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r5);
    L10:
        throw new NullPointerException(d.b("key: ", r5));
    L5:
        return ((Number) r10).intValue();
    }

    @CalledByNative
    public ArrayList<String> getKeys() {
        return new ArrayList(keySet());
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    @CalledByNative
    public long getLong(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof Number) == true) goto L5;
        if (r10 == null) goto L10;
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to java.lang.Long, key: " + r5);
    L10:
        throw new NullPointerException(d.b("key: ", r5));
    L5:
        return ((Number) r10).longValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    @CalledByNative
    public ReadableMap getMap(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof ReadableMap) == true) goto L5;
        if (r10 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to " + ReadableMap.class.getName() + ", key: " + r5);
    L5:
        return (ReadableMap) r10;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    @CalledByNative
    public NativeHostObject getNativeHostObject(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof NativeHostObject) == true) goto L5;
        if (r10 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to " + JavaOnlyArray.class.getName() + ", key: " + r5);
    L5:
        return (NativeHostObject) r10;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    @CalledByNative
    public String getString(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof String) == true) goto L5;
        if (r10 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to java.lang.String, key: " + r5);
    L5:
        return (String) r10;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final ReadableType getType(String r5) {
        Object r10 = get(r5);
        if (r10 != null) goto L7;
        return ReadableType.Null;
    L7:
        if ((r10 instanceof Integer) == false) goto L11;
        return ReadableType.Int;
    L11:
        if ((r10 instanceof Long) == false) goto L15;
        return ReadableType.Long;
    L15:
        if ((r10 instanceof Number) == true) goto L50;
        if ((r10 instanceof Character) == true) goto L50;
        if ((r10 instanceof String) == false) goto L24;
        return ReadableType.String;
    L24:
        if ((r10 instanceof Boolean) == false) goto L28;
        return ReadableType.Boolean;
    L28:
        if ((r10 instanceof ReadableMap) == false) goto L32;
        return ReadableType.Map;
    L32:
        if ((r10 instanceof ReadableArray) == false) goto L36;
        return ReadableType.Array;
    L36:
        if ((r10 instanceof byte[]) == false) goto L40;
        return ReadableType.ByteArray;
    L40:
        if ((r10 instanceof a) == false) goto L44;
        return ((a) r10).getType();
    L44:
        if ((r10 instanceof NativeHostObject) == false) goto L48;
        return ReadableType.NativeHostObject;
    L48:
        throw new IllegalArgumentException("Invalid value " + r10.toString() + " for key " + r5 + "contained in JavaOnlyMap");
    L50:
        return ReadableType.Number;
    }

    @CalledByNative
    public int getTypeIndex(String r5) {
        return getType(r5).ordinal();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final boolean hasKey(String r5) {
        return containsKey(r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final boolean isNull(String r5) {
        if (get(r5) != null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final ReadableMapKeySetIterator keySetIterator() {
        ym.d r5 = new ym.d();
        r5.f23297a = keySet().iterator();
        return r5;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public final void merge(ReadableMap r5) {
        putAll((JavaOnlyMap) r5);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    @CalledByNative
    public void putArray(String r5, WritableArray r10) {
        put(r5, r10);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    @CalledByNative
    public void putBoolean(String r5, boolean r10) {
        put(r5, Boolean.valueOf(r10));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    @CalledByNative
    public void putByteArray(String r5, byte[] r10) {
        put(r5, r10);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    @CalledByNative
    public void putByteArrayAsString(byte[] r5, byte[] r10) {
        put(new String(r5), new String(r10));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    @CalledByNative
    public void putDouble(String r5, double r10) {
        put(r5, Double.valueOf(r10));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    @CalledByNative
    public void putInt(String r5, int r10) {
        put(r5, Integer.valueOf(r10));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    @CalledByNative
    public void putLong(String r5, long r10) {
        put(r5, Long.valueOf(r10));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    @CalledByNative
    public void putMap(String r5, WritableMap r10) {
        put(r5, r10);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    @CalledByNative
    public void putNativeHostObject(String r5, NativeHostObject r10) {
        put(r5, r10);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    @CalledByNative
    public void putNull(String r5) {
        put(r5, null);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    @CalledByNative
    public void putString(String r5, String r10) {
        put(r5, r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    @CalledByNative
    public int size() {
        return super.size();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final ArrayMap toArrayMap() {
        ArrayMap r5 = new ArrayMap();
        r5.putAll(this);
        return r5;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final HashMap toHashMap() {
        return new HashMap(this);
    }

    public JavaOnlyMap() {
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final ReadableArray getArray(String r5, ReadableArray r10) {
        Object r11 = get(r5);
        if ((r11 instanceof ReadableArray) == true) goto L5;
        return r10;
    L5:
        return (ReadableArray) r11;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    @CalledByNative
    public byte[] getByteArray(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof byte[]) == true) goto L5;
        if (r10 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to " + byte[].class.getName() + ", key: " + r5);
    L5:
        return (byte[]) r10;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    @CalledByNative
    public JavaOnlyArray getArray(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof JavaOnlyArray) == true) goto L5;
        if (r10 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to " + JavaOnlyArray.class.getName() + ", key: " + r5);
    L5:
        return (JavaOnlyArray) r10;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final ReadableMap getMap(String r5, ReadableMap r10) {
        Object r11 = get(r5);
        if ((r11 instanceof ReadableMap) == true) goto L5;
        return r10;
    L5:
        return (ReadableMap) r11;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final String getString(String r5, String r10) {
        Object r11 = get(r5);
        if ((r11 instanceof String) == true) goto L5;
        return r10;
    L5:
        return (String) r11;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final boolean getBoolean(String r5, boolean r10) {
        Object r11 = get(r5);
        if ((r11 instanceof Boolean) == true) goto L5;
        return r10;
    L5:
        return ((Boolean) r11).booleanValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final double getDouble(String r5, double r10) {
        Object r11 = get(r5);
        if ((r11 instanceof Number) == true) goto L5;
        return r10;
    L5:
        return ((Number) r11).doubleValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final int getInt(String r5, int r10) {
        Object r11 = get(r5);
        if ((r11 instanceof Number) == true) goto L5;
        return r10;
    L5:
        return ((Number) r11).intValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public final long getLong(String r5, long r10) {
        Object r11 = get(r5);
        if ((r11 instanceof Number) == true) goto L5;
        return r10;
    L5:
        return ((Number) r11).longValue();
    }
}
