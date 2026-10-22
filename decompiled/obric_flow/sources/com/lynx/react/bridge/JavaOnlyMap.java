package com.lynx.react.bridge;

import android.util.Log;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.CalledByNative;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import pm.a;
import pm.c;
import pm.e;
import td.d;

/* JADX INFO: loaded from: classes2.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap, WritableMap {
    public JavaOnlyMap(Map r5) {
        super(r5);
    }

    public static JavaOnlyMap a(ReadableMap r5) {
        JavaOnlyMap r10 = new JavaOnlyMap();
        ReadableMapKeySetIterator r11 = r5.keySetIterator();
    L4:
        if (r11.hasNextKey() == false) goto L17;
        String r12 = r11.nextKey();
        ReadableType r13 = r5.getType(r12);
        switch(e.f21366a[r13.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L4;
        };
    L8:
        r10.putByteArray(r12, r5.getByteArray(r12));
        goto L4
    L9:
        r10.putArray(r12, (WritableArray) r5.getArray(r12));
        goto L4
    L10:
        r10.putMap(r12, (WritableMap) r5.getMap(r12));
        goto L4
    L11:
        r10.putString(r12, r5.getString(r12));
        goto L4
    L12:
        r10.putDouble(r12, r5.getDouble(r12));
        goto L4
    L13:
        r10.putLong(r12, r5.getLong(r12));
        goto L4
    L14:
        r10.putInt(r12, r5.getInt(r12));
        goto L4
    L15:
        r10.putBoolean(r12, r5.getBoolean(r12));
        goto L4
    L16:
        r10.putNull(r12);
        goto L4
    L17:
        return r10;
    }

    @CalledByNative
    private static JavaOnlyMap create() {
        return new JavaOnlyMap();
    }

    @CalledByNative
    private JavaOnlyMap shallowCopy() {
        return a(this);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final HashMap asHashMap() {
        return this;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final ReadableArray getArray(String r5, ReadableArray r10) {
        Object r11 = get(r5);
        if ((r11 instanceof ReadableArray) == true) goto L5;
        return r10;
    L5:
        return (ReadableArray) r11;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    @CalledByNative
    public boolean getBoolean(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof Boolean) == false) goto L7;
        return ((Boolean) r10).booleanValue();
    L7:
        if ((r10 instanceof String) == false) goto L16;
        String r11 = (String) r10;
        if (r11.equalsIgnoreCase("true") == false) goto L11;
    L14:
        return true;
    L11:
        if (r11.equalsIgnoreCase("yes") == true) goto L14;
        return false;
    L16:
        if ((r10 instanceof Number) == true) goto L18;
        if (r10 != null) goto L25;
        throw new NullPointerException(d.b("key: ", r5));
    L25:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to java.lang.Boolean, key: " + r5 + ", value: " + r10);
    L18:
        if (((Number) r10).intValue() == 0) goto L20;
        return true;
    L20:
        return false;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final byte[] getByteArray(String r5, byte[] r10) {
        Object r11 = get(r5);
        if ((r11 instanceof byte[]) == true) goto L5;
        return r10;
    L5:
        return (byte[]) r11;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final ByteBuffer getByteBuffer(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof ByteBuffer) == true) goto L5;
        if (r10 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to " + ByteBuffer.class.getName() + ", key: " + r5);
    L5:
        return (ByteBuffer) r10;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    @CalledByNative
    public double getDouble(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof Number) == false) goto L7;
        return ((Number) r10).doubleValue();
    L7:
        if ((r10 instanceof Boolean) == false) goto L15;
        if (((Boolean) r10).booleanValue() == false) goto L12;
        return 1.0d;
    L12:
        return 0.0d;
    L15:
        if ((r10 instanceof String) == true) goto L25;
        if (r10 != null) goto L24;
        throw new NullPointerException(d.b("key: ", r5));
    L24:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r5 + ", value: " + r10);
    L25:
        return Double.parseDouble((String) r10);
    L19:
        throw new IllegalArgumentException("String cannot be cast to double, key: " + r5 + ", value: " + r10);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final a getDynamic(String r5) {
        return new c(r5, this);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    @CalledByNative
    public int getInt(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof Number) == false) goto L7;
        return ((Number) r10).intValue();
    L7:
        if ((r10 instanceof Boolean) == false) goto L11;
        return ((Boolean) r10).booleanValue() ? 1 : 0;
    L11:
        if ((r10 instanceof String) == true) goto L21;
        if (r10 != null) goto L20;
        throw new NullPointerException(d.b("key: ", r5));
    L20:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r5 + ", value: " + r10);
    L21:
        return Integer.parseInt((String) r10);
    L15:
        throw new IllegalArgumentException("String cannot be cast to int, key: " + r5 + ", value: " + r10);
    }

    @CalledByNative
    public ArrayList<String> getKeys() {
        return new ArrayList(keySet());
    }

    @Override // com.lynx.react.bridge.ReadableMap
    @CalledByNative
    public long getLong(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof Number) == false) goto L7;
        return ((Number) r10).longValue();
    L7:
        if ((r10 instanceof Boolean) == false) goto L15;
        if (((Boolean) r10).booleanValue() == false) goto L12;
        return 1;
    L12:
        return 0;
    L15:
        if ((r10 instanceof String) == true) goto L25;
        if (r10 != null) goto L24;
        throw new NullPointerException(d.b("key: ", r5));
    L24:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to java.lang.Long, key: " + r5 + ", value: " + r10);
    L25:
        return Long.parseLong((String) r10);
    L19:
        throw new IllegalArgumentException("String cannot be cast to long int, key: " + r5 + ", value: " + r10);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    @CalledByNative
    public ReadableMap getMap(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof ReadableMap) == true) goto L5;
        if (r10 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to " + ReadableMap.class.getName() + ", key: " + r5 + ", value: " + r10);
    L5:
        return (ReadableMap) r10;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final PiperData getPiperData(String r5, PiperData r10) {
        Object r11 = get(r5);
        if ((r11 instanceof PiperData) == true) goto L5;
        return r10;
    L5:
        return (PiperData) r11;
    }

    @Override // com.lynx.react.bridge.ReadableMap
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

    @Override // com.lynx.react.bridge.ReadableMap
    @CalledByNative
    public TemplateData getTemplateData(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof TemplateData) == true) goto L5;
        return null;
    L5:
        return (TemplateData) r10;
    }

    @Override // com.lynx.react.bridge.ReadableMap
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
        if ((r10 instanceof Number) == true) goto L54;
        if ((r10 instanceof Character) == true) goto L54;
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
        if ((r10 instanceof PiperData) == false) goto L44;
        return ReadableType.PiperData;
    L44:
        if ((r10 instanceof TemplateData) == false) goto L48;
        return ReadableType.TemplateData;
    L48:
        if ((r10 instanceof a) == false) goto L52;
        return ((a) r10).getType();
    L52:
        throw new IllegalArgumentException("Invalid value " + r10.toString() + " for key " + r5 + "contained in JavaOnlyMap");
    L54:
        return ReadableType.Number;
    }

    @CalledByNative
    public int getTypeIndex(String r5) {
        return getType(r5).ordinal();
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final boolean hasKey(String r5) {
        return containsKey(r5);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final boolean isNull(String r5) {
        if (get(r5) != null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final ReadableMapKeySetIterator keySetIterator() {
        return new bd.d(this);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public final void merge(ReadableMap r5) {
        putAll(r5.asHashMap());
    }

    @Override // com.lynx.react.bridge.WritableMap
    @CalledByNative
    public void putArray(String r5, WritableArray r10) {
        put(r5, r10);
    }

    @Override // com.lynx.react.bridge.WritableMap
    @CalledByNative
    public void putBoolean(String r5, boolean r10) {
        put(r5, Boolean.valueOf(r10));
    }

    @Override // com.lynx.react.bridge.WritableMap
    @CalledByNative
    public void putByteArray(String r5, byte[] r10) {
        put(r5, r10);
    }

    @Override // com.lynx.react.bridge.WritableMap
    @CalledByNative
    public void putByteArrayAsString(byte[] r5, byte[] r10) {
        put(new String(r5), new String(r10));
    }

    @Override // com.lynx.react.bridge.WritableMap
    @CalledByNative
    public void putByteBuffer(String r5, ByteBuffer r10) {
        put(r5, r10);
    }

    @Override // com.lynx.react.bridge.WritableMap
    @CalledByNative
    public void putDouble(String r5, double r10) {
        put(r5, Double.valueOf(r10));
    }

    @Override // com.lynx.react.bridge.WritableMap
    @CalledByNative
    public void putInt(String r5, int r10) {
        put(r5, Integer.valueOf(r10));
    }

    @Override // com.lynx.react.bridge.WritableMap
    @CalledByNative
    public void putLong(String r5, long r10) {
        put(r5, Long.valueOf(r10));
    }

    @Override // com.lynx.react.bridge.WritableMap
    @CalledByNative
    public void putMap(String r5, WritableMap r10) {
        put(r5, r10);
    }

    @Override // com.lynx.react.bridge.WritableMap
    @CalledByNative
    public void putNull(String r5) {
        put(r5, null);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public final void putPiperData(String r5, PiperData r10) {
        put(r5, r10);
    }

    @Override // com.lynx.react.bridge.WritableMap
    @CalledByNative
    public void putString(String r5, String r10) {
        put(r5, r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, com.lynx.react.bridge.ReadableMap
    @CalledByNative
    public int size() {
        return super.size();
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final HashMap toHashMap() {
        return new HashMap(this);
    }

    public JavaOnlyMap() {
    }

    @Override // com.lynx.react.bridge.ReadableMap
    @CalledByNative
    public ReadableArray getArray(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof ReadableArray) == true) goto L5;
        if (r10 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to " + ReadableArray.class.getName() + ", key: " + r5 + ", value: " + r10);
    L5:
        return (ReadableArray) r10;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    @CalledByNative
    public byte[] getByteArray(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof byte[]) == true) goto L5;
        if (r10 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to " + byte[].class.getName() + ", key: " + r5 + ", value: " + r10);
    L5:
        return (byte[]) r10;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    @CalledByNative
    public PiperData getPiperData(String r5) {
        Object r10 = get(r5);
        if ((r10 instanceof PiperData) == true) goto L5;
        if (r10 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r10.getClass().getName() + " cannot be cast to " + PiperData.class.getName() + ", key: " + r5);
    L5:
        return (PiperData) r10;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final ByteBuffer getByteBuffer(String r5, ByteBuffer r10) {
        Object r11 = get(r5);
        if ((r11 instanceof ByteBuffer) == true) goto L5;
        return r10;
    L5:
        return (ByteBuffer) r11;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final ReadableMap getMap(String r5, ReadableMap r10) {
        Object r11 = get(r5);
        if ((r11 instanceof ReadableMap) == true) goto L5;
        return r10;
    L5:
        return (ReadableMap) r11;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final String getString(String r5, String r10) {
        Object r11 = get(r5);
        if ((r11 instanceof String) == false) goto L7;
        return (String) r11;
    L7:
        if ((r11 instanceof Boolean) == false) goto L15;
        if (((Boolean) r11).booleanValue() == false) goto L12;
        return "true";
    L12:
        return "false";
    L15:
        if ((r11 instanceof Number) == true) goto L17;
        return r10;
    L17:
        return ((Number) r11).toString();
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public final boolean getBoolean(String r5, boolean r10) {
        Object r11 = get(r5);
        if ((r11 instanceof Boolean) == false) goto L7;
        return ((Boolean) r11).booleanValue();
    L7:
        if ((r11 instanceof Number) == false) goto L13;
        if (((Number) r11).intValue() == 0) goto L11;
        return true;
    L11:
        return false;
    L13:
        if ((r11 instanceof String) == false) goto L25;
        String r12 = (String) r11;
        if (r12.equalsIgnoreCase("true") == false) goto L17;
    L24:
        return true;
    L17:
        if (r12.equalsIgnoreCase("yes") == true) goto L24;
        if (r12.equalsIgnoreCase("false") == false) goto L22;
    L23:
        return false;
    L22:
        if (r12.equalsIgnoreCase("no") == true) goto L23;
    L25:
        return r10;
    }

    @Override // com.lynx.react.bridge.ReadableMap
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

    @Override // com.lynx.react.bridge.ReadableMap
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

    @Override // com.lynx.react.bridge.ReadableMap
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
}
