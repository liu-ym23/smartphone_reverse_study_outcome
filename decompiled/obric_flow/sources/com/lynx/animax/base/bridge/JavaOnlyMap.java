package com.lynx.animax.base.bridge;

import com.lynx.animax.base.CalledByNative;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap {
    public JavaOnlyMap(HashMap r5) {
        super(r5);
    }

    @CalledByNative
    private static JavaOnlyMap create() {
        return new JavaOnlyMap();
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public final HashMap asHashMap() {
        return this;
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public final double getDouble(String r5, double r10) {
        Object r11 = get(r5);
        if ((r11 instanceof Number) == false) goto L7;
        return ((Number) r11).doubleValue();
    L7:
        if ((r11 instanceof Boolean) == false) goto L15;
        if (((Boolean) r11).booleanValue() == false) goto L12;
        return 1.0d;
    L12:
        return 0.0d;
    L15:
        if ((r11 instanceof String) == true) goto L21;
    L20:
        return r10;
    L21:
        return Double.parseDouble((String) r11);
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public final int getInt(String r5, int r10) {
        Object r11 = get(r5);
        if ((r11 instanceof Number) == false) goto L7;
        return ((Number) r11).intValue();
    L7:
        if ((r11 instanceof Boolean) == false) goto L11;
        return ((Boolean) r11).booleanValue() ? 1 : 0;
    L11:
        if ((r11 instanceof String) == true) goto L17;
    L16:
        return r10;
    L17:
        return Integer.parseInt((String) r11);
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    @CalledByNative
    public ArrayList<String> getKeys() {
        return new ArrayList(keySet());
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public final long getLong(String r5, long r10) {
        Object r11 = get(r5);
        if ((r11 instanceof Number) == false) goto L7;
        return ((Number) r11).longValue();
    L7:
        if ((r11 instanceof Boolean) == false) goto L15;
        if (((Boolean) r11).booleanValue() == false) goto L12;
        return 1;
    L12:
        return 0;
    L15:
        if ((r11 instanceof String) == true) goto L21;
    L20:
        return r10;
    L21:
        return Long.parseLong((String) r11);
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    @CalledByNative
    public String getString(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof String) == false) goto L7;
        return (String) r10;
    L7:
        if ((r10 instanceof Boolean) == false) goto L15;
        if (((Boolean) r10).booleanValue() == false) goto L12;
        return "true";
    L12:
        return "false";
    L15:
        if ((r10 instanceof Number) == true) goto L17;
        if (r10 != null) goto L22;
        return null;
    L22:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to java.lang.String, key: " + r5 + ", value: " + r10);
    L17:
        return ((Number) r10).toString();
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
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
        if ((r10 instanceof Number) == true) goto L34;
        if ((r10 instanceof Character) == true) goto L34;
        if ((r10 instanceof String) == false) goto L24;
        return ReadableType.String;
    L24:
        if ((r10 instanceof Boolean) == false) goto L28;
        return ReadableType.Boolean;
    L28:
        if ((r10 instanceof ReadableMap) == false) goto L32;
        return ReadableType.Map;
    L32:
        throw new IllegalArgumentException("Invalid value " + r10.toString() + " for key " + r5 + "contained in JavaOnlyMap");
    L34:
        return ReadableType.Number;
    }

    @CalledByNative
    public int getTypeIndex(String r5) {
        return getType(r5).ordinal();
    }

    @CalledByNative
    public void putArray(String r5, JavaOnlyArray r10) {
        put(r5, r10);
    }

    @CalledByNative
    public void putByteArrayAsString(byte[] r5, byte[] r10) {
        put(new String(r5), new String(r10));
    }

    @CalledByNative
    public void putDouble(String r5, double r10) {
        put(r5, Double.valueOf(r10));
    }

    @CalledByNative
    public void putInt(String r5, int r10) {
        put(r5, Integer.valueOf(r10));
    }

    @CalledByNative
    public void putString(String r5, String r10) {
        put(r5, r10);
    }

    public JavaOnlyMap() {
    }
}
