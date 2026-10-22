package com.lynx.animax.base.bridge;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import r4a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap {
    @Override // com.lynx.animax.base.bridge.ReadableMap
    public HashMap<String, Object> asHashMap() {
        return this;
    }

    private static JavaOnlyMap create() {
        return new JavaOnlyMap();
    }

    public ArrayList<String> getKeys() {
        return new ArrayList(keySet());
    }

    public JavaOnlyMap() {
    }

    public JavaOnlyMap(Map r1) {
        super(r1);
    }

    public static JavaOnlyMap from(Map r1) {
        return new JavaOnlyMap(r1);
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public a getArray(String r5) {
        Object r0 = get(r5);
        if ((r0 instanceof JavaOnlyArray) == false) goto L7;
        return (JavaOnlyArray) r0;
    L7:
        throw new ClassCastException(r0.getClass().getName() + " cannot be cast to " + a.class.getName() + ", key: " + r5 + ", value: " + r0);
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public String getString(String r5) {
        Object r0 = get(r5);
        if ((r0 instanceof String) == false) goto L7;
        return (String) r0;
    L7:
        if ((r0 instanceof Boolean) == false) goto L14;
        if (((Boolean) r0).booleanValue() == false) goto L11;
        return "true";
    L11:
        return "false";
    L14:
        if ((r0 instanceof Number) == true) goto L16;
        if (r0 != null) goto L21;
        return null;
    L21:
        throw new ClassCastException(r0.getClass().getName() + " cannot be cast to java.lang.String, key: " + r5 + ", value: " + r0);
    L16:
        return ((Number) r0).toString();
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public ReadableType getType(String r5) {
        Object r0 = get(r5);
        if (r0 != null) goto L7;
        return ReadableType.Null;
    L7:
        if ((r0 instanceof Integer) == false) goto L11;
        return ReadableType.Int;
    L11:
        if ((r0 instanceof Long) == false) goto L15;
        return ReadableType.Long;
    L15:
        if ((r0 instanceof Number) == true) goto L38;
        if ((r0 instanceof Character) == true) goto L38;
        if ((r0 instanceof String) == false) goto L24;
        return ReadableType.String;
    L24:
        if ((r0 instanceof Boolean) == false) goto L28;
        return ReadableType.Boolean;
    L28:
        if ((r0 instanceof ReadableMap) == false) goto L32;
        return ReadableType.Map;
    L32:
        if ((r0 instanceof a) == false) goto L36;
        return ReadableType.Array;
    L36:
        throw new IllegalArgumentException("Invalid value " + r0.toString() + " for key " + r5 + "contained in JavaOnlyMap");
    L38:
        return ReadableType.Number;
    }

    public int getTypeIndex(String r1) {
        return getType(r1).ordinal();
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public double getDouble(String r2, double r3) {
        Object r4 = get(r2);
        if ((r4 instanceof Number) == false) goto L7;
        return ((Number) r4).doubleValue();
    L7:
        if ((r4 instanceof Boolean) == false) goto L14;
        if (((Boolean) r4).booleanValue() == false) goto L11;
        return 1.0d;
    L11:
        return 0.0d;
    L14:
        if ((r4 instanceof String) == true) goto L20;
    L19:
        return r3;
    L20:
        return CastDoubleProtector.parseDouble((String) r4);
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public int getInt(String r2, int r3) {
        Object r4 = get(r2);
        if ((r4 instanceof Number) == false) goto L7;
        return ((Number) r4).intValue();
    L7:
        if ((r4 instanceof Boolean) == false) goto L11;
        return ((Boolean) r4).booleanValue() ? 1 : 0;
    L11:
        if ((r4 instanceof String) == true) goto L17;
    L16:
        return r3;
    L17:
        return CastIntegerProtector.parseInt((String) r4);
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public long getLong(String r2, long r3) {
        Object r4 = get(r2);
        if ((r4 instanceof Number) == false) goto L7;
        return ((Number) r4).longValue();
    L7:
        if ((r4 instanceof Boolean) == false) goto L14;
        if (((Boolean) r4).booleanValue() == false) goto L11;
        return 1;
    L11:
        return 0;
    L14:
        if ((r4 instanceof String) == true) goto L20;
    L19:
        return r3;
    L20:
        return CastLongProtector.parseLong((String) r4);
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public void putArray(String r1, JavaOnlyArray r2) {
        put(r1, r2);
    }

    public void putByteArrayAsString(byte[] r2, byte[] r3) {
        put(new String(r2), new String(r3));
    }

    public void putDouble(String r1, double r2) {
        put(r1, Double.valueOf(r2));
    }

    public void putInt(String r1, int r2) {
        put(r1, Integer.valueOf(r2));
    }

    public void putString(String r1, String r2) {
        put(r1, r2);
    }
}
