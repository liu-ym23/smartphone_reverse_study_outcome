package com.lynx.react.bridge;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.tasm.TemplateData;
import f6a.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap, WritableMap {
    private static final String TAG = "JavaOnlyMap";

    public class a implements ReadableMapKeySetIterator {
        public final Iterator<String> a;

        @Override // com.lynx.react.bridge.ReadableMapKeySetIterator
        public final boolean hasNextKey() {
            return this.a.hasNext();
        }

        @Override // com.lynx.react.bridge.ReadableMapKeySetIterator
        public final String nextKey() {
            return this.a.next();
        }

        public a(JavaOnlyMap r1) {
            this.a = r1.keySet().iterator();
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            a = r0;
            r0[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            a[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            a[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            a[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            a[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            a[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            a[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            a[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            a[ReadableType.ByteArray.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public HashMap<String, Object> asHashMap() {
        return this;
    }

    private static JavaOnlyMap create() {
        return new JavaOnlyMap();
    }

    public ArrayList<String> getKeys() {
        return new ArrayList(keySet());
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableMapKeySetIterator keySetIterator() {
        return new a(this);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public HashMap<String, Object> toHashMap() {
        return new HashMap(this);
    }

    public JSONObject toJSONObject() {
        JSONObject r0 = new JSONObject();
        if (size() != 0) goto L5;
        return r0;
    L5:
        Iterator r1 = keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L22;
        String r2 = (String) r1.next();
        Object r3 = get(r2);
        if (getType(r2) == ReadableType.Map) goto L11;
        if (getType(r2) == ReadableType.Array) goto L14;
        if (getType(r2) == ReadableType.Null) goto L17;
        r0.putOpt(r2, r3);     // Catch: Exception -> L20
        goto L7
    L17:
        r0.putOpt(r2, JSONObject.NULL);     // Catch: Exception -> L20
        goto L7
    L14:
        r0.putOpt(r2, ((JavaOnlyArray) r3).toJSONArray());     // Catch: Exception -> L20
        goto L7
    L11:
        r0.putOpt(r2, ((JavaOnlyMap) r3).toJSONObject());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.toString();
        goto L7
    L22:
        return r0;
    }

    private JavaOnlyMap shallowCopy() {
        return shallowCopy(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, com.lynx.react.bridge.ReadableMap
    public int size() {
        return super.size();
    }

    public JavaOnlyMap() {
    }

    private JavaOnlyMap(Map r1) {
        super(r1);
    }

    public static JavaOnlyMap deepClone(ReadableMap r5) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        ReadableMapKeySetIterator r1 = r5.keySetIterator();
    L4:
        if (r1.hasNextKey() == false) goto L17;
        String r2 = r1.nextKey();
        ReadableType r3 = r5.getType(r2);
        switch(b.a[r3.ordinal()]) {
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
        r0.putByteArray(r2, (byte[]) r5.getByteArray(r2).clone());
        goto L4
    L9:
        r0.putArray(r2, JavaOnlyArray.deepClone(r5.getArray(r2)));
        goto L4
    L10:
        r0.putMap(r2, deepClone(r5.getMap(r2)));
        goto L4
    L11:
        r0.putString(r2, r5.getString(r2));
        goto L4
    L12:
        r0.putDouble(r2, r5.getDouble(r2));
        goto L4
    L13:
        r0.putLong(r2, r5.getLong(r2));
        goto L4
    L14:
        r0.putInt(r2, r5.getInt(r2));
        goto L4
    L15:
        r0.putBoolean(r2, r5.getBoolean(r2));
        goto L4
    L16:
        r0.putNull(r2);
        goto L4
    L17:
        return r0;
    }

    public static JavaOnlyMap from(Map r1) {
        return new JavaOnlyMap(r1);
    }

    public static JavaOnlyMap shallowCopy(ReadableMap r5) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        ReadableMapKeySetIterator r1 = r5.keySetIterator();
    L4:
        if (r1.hasNextKey() == false) goto L17;
        String r2 = r1.nextKey();
        ReadableType r3 = r5.getType(r2);
        switch(b.a[r3.ordinal()]) {
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
        r0.putByteArray(r2, r5.getByteArray(r2));
        goto L4
    L9:
        r0.putArray(r2, (WritableArray) r5.getArray(r2));
        goto L4
    L10:
        r0.putMap(r2, (WritableMap) r5.getMap(r2));
        goto L4
    L11:
        r0.putString(r2, r5.getString(r2));
        goto L4
    L12:
        r0.putDouble(r2, r5.getDouble(r2));
        goto L4
    L13:
        r0.putLong(r2, r5.getLong(r2));
        goto L4
    L14:
        r0.putInt(r2, r5.getInt(r2));
        goto L4
    L15:
        r0.putBoolean(r2, r5.getBoolean(r2));
        goto L4
    L16:
        r0.putNull(r2);
        goto L4
    L17:
        return r0;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableArray getArray(String r5) {
        Object r0 = get(r5);
        if ((r0 instanceof ReadableArray) == true) goto L5;
        if (r0 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r0.getClass().getName() + " cannot be cast to " + ReadableArray.class.getName() + ", key: " + r5 + ", value: " + r0);
    L5:
        return (ReadableArray) r0;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean getBoolean(String r5) {
        Object r0 = get(r5);
        if ((r0 instanceof Boolean) == false) goto L7;
        return ((Boolean) r0).booleanValue();
    L7:
        if ((r0 instanceof String) == false) goto L15;
        String r1 = (String) r0;
        if (r1.equalsIgnoreCase("true") == false) goto L11;
    L12:
        return true;
    L11:
        if (r1.equalsIgnoreCase("yes") == true) goto L12;
        return false;
    L15:
        if ((r0 instanceof Number) == true) goto L17;
        if (r0 != null) goto L24;
        throw new NullPointerException("key: " + r5);
    L24:
        throw new ClassCastException(r0.getClass().getName() + " cannot be cast to java.lang.Boolean, key: " + r5 + ", value: " + r0);
    L17:
        if (((Number) r0).intValue() == 0) goto L26;
        return true;
    L26:
        return false;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public byte[] getByteArray(String r5) {
        Object r0 = get(r5);
        if ((r0 instanceof byte[]) == true) goto L5;
        if (r0 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r0.getClass().getName() + " cannot be cast to " + byte[].class.getName() + ", key: " + r5 + ", value: " + r0);
    L5:
        return (byte[]) r0;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ByteBuffer getByteBuffer(String r4) {
        Object r0 = get(r4);
        if ((r0 instanceof ByteBuffer) == true) goto L5;
        if (r0 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r0.getClass().getName() + " cannot be cast to " + ByteBuffer.class.getName() + ", key: " + r4);
    L5:
        return (ByteBuffer) r0;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public double getDouble(String r6) {
        Object r0 = get(r6);
        if ((r0 instanceof Number) == false) goto L7;
        return ((Number) r0).doubleValue();
    L7:
        if ((r0 instanceof Boolean) == false) goto L14;
        if (((Boolean) r0).booleanValue() == false) goto L11;
        return 1.0d;
    L11:
        return 0.0d;
    L14:
        if ((r0 instanceof String) == true) goto L24;
        if (r0 != null) goto L23;
        throw new NullPointerException("key: " + r6);
    L23:
        throw new ClassCastException(r0.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r6 + ", value: " + r0);
    L24:
        return CastDoubleProtector.parseDouble((String) r0);
    L18:
        throw new IllegalArgumentException("String cannot be cast to double, key: " + r6 + ", value: " + r0);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public f6a.a getDynamic(String r2) {
        return new c(this, r2);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public int getInt(String r6) {
        Object r0 = get(r6);
        if ((r0 instanceof Number) == false) goto L7;
        return ((Number) r0).intValue();
    L7:
        if ((r0 instanceof Boolean) == false) goto L11;
        return ((Boolean) r0).booleanValue() ? 1 : 0;
    L11:
        if ((r0 instanceof String) == true) goto L21;
        if (r0 != null) goto L20;
        throw new NullPointerException("key: " + r6);
    L20:
        throw new ClassCastException(r0.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r6 + ", value: " + r0);
    L21:
        return CastIntegerProtector.parseInt((String) r0);
    L15:
        throw new IllegalArgumentException("String cannot be cast to int, key: " + r6 + ", value: " + r0);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public long getLong(String r6) {
        Object r0 = get(r6);
        if ((r0 instanceof Number) == false) goto L7;
        return ((Number) r0).longValue();
    L7:
        if ((r0 instanceof Boolean) == false) goto L14;
        if (((Boolean) r0).booleanValue() == false) goto L11;
        return 1;
    L11:
        return 0;
    L14:
        if ((r0 instanceof String) == true) goto L24;
        if (r0 != null) goto L23;
        throw new NullPointerException("key: " + r6);
    L23:
        throw new ClassCastException(r0.getClass().getName() + " cannot be cast to java.lang.Long, key: " + r6 + ", value: " + r0);
    L24:
        return CastLongProtector.parseLong((String) r0);
    L18:
        throw new IllegalArgumentException("String cannot be cast to long int, key: " + r6 + ", value: " + r0);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableMap getMap(String r5) {
        Object r0 = get(r5);
        if ((r0 instanceof ReadableMap) == true) goto L5;
        if (r0 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r0.getClass().getName() + " cannot be cast to " + ReadableMap.class.getName() + ", key: " + r5 + ", value: " + r0);
    L5:
        return (ReadableMap) r0;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public PiperData getPiperData(String r4) {
        Object r0 = get(r4);
        if ((r0 instanceof PiperData) == true) goto L5;
        if (r0 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r0.getClass().getName() + " cannot be cast to " + PiperData.class.getName() + ", key: " + r4);
    L5:
        return (PiperData) r0;
    }

    @Override // com.lynx.react.bridge.ReadableMap
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

    @Override // com.lynx.react.bridge.ReadableMap
    public TemplateData getTemplateData(String r2) {
        Object r3 = get(r2);
        if ((r3 instanceof TemplateData) == true) goto L5;
        return null;
    L5:
        return (TemplateData) r3;
    }

    @Override // com.lynx.react.bridge.ReadableMap
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
        if ((r0 instanceof Number) == true) goto L54;
        if ((r0 instanceof Character) == true) goto L54;
        if ((r0 instanceof String) == false) goto L24;
        return ReadableType.String;
    L24:
        if ((r0 instanceof Boolean) == false) goto L28;
        return ReadableType.Boolean;
    L28:
        if ((r0 instanceof ReadableMap) == false) goto L32;
        return ReadableType.Map;
    L32:
        if ((r0 instanceof ReadableArray) == false) goto L36;
        return ReadableType.Array;
    L36:
        if ((r0 instanceof byte[]) == false) goto L40;
        return ReadableType.ByteArray;
    L40:
        if ((r0 instanceof PiperData) == false) goto L44;
        return ReadableType.PiperData;
    L44:
        if ((r0 instanceof TemplateData) == false) goto L48;
        return ReadableType.TemplateData;
    L48:
        if ((r0 instanceof f6a.a) == false) goto L52;
        return ((f6a.a) r0).getType();
    L52:
        throw new IllegalArgumentException("Invalid value " + r0.toString() + " for key " + r5 + "contained in JavaOnlyMap");
    L54:
        return ReadableType.Number;
    }

    public int getTypeIndex(String r1) {
        return getType(r1).ordinal();
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean hasKey(String r1) {
        return containsKey(r1);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean isNull(String r1) {
        if (get(r1) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void merge(ReadableMap r1) {
        putAll(r1.asHashMap());
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putNull(String r2) {
        put(r2, null);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableArray getArray(String r2, ReadableArray r3) {
        Object r4 = get(r2);
        if ((r4 instanceof ReadableArray) == true) goto L5;
        return r3;
    L5:
        return (ReadableArray) r4;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean getBoolean(String r4, boolean r5) {
        Object r6 = get(r4);
        if ((r6 instanceof Boolean) == false) goto L7;
        return ((Boolean) r6).booleanValue();
    L7:
        if ((r6 instanceof Number) == false) goto L14;
        if (((Number) r6).intValue() != 0) goto L27;
        return false;
    L27:
        return true;
    L14:
        if ((r6 instanceof String) == false) goto L26;
        String r7 = (String) r6;
        if (r7.equalsIgnoreCase("true") == false) goto L18;
    L25:
        return true;
    L18:
        if (r7.equalsIgnoreCase("yes") == true) goto L25;
        if (r7.equalsIgnoreCase("false") == false) goto L23;
    L24:
        return false;
    L23:
        if (r7.equalsIgnoreCase("no") == true) goto L24;
    L26:
        return r5;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public byte[] getByteArray(String r2, byte[] r3) {
        Object r4 = get(r2);
        if ((r4 instanceof byte[]) == true) goto L5;
        return r3;
    L5:
        return (byte[]) r4;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ByteBuffer getByteBuffer(String r2, ByteBuffer r3) {
        Object r4 = get(r2);
        if ((r4 instanceof ByteBuffer) == true) goto L5;
        return r3;
    L5:
        return (ByteBuffer) r4;
    }

    @Override // com.lynx.react.bridge.ReadableMap
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

    @Override // com.lynx.react.bridge.ReadableMap
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

    @Override // com.lynx.react.bridge.ReadableMap
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

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableMap getMap(String r2, ReadableMap r3) {
        Object r4 = get(r2);
        if ((r4 instanceof ReadableMap) == true) goto L5;
        return r3;
    L5:
        return (ReadableMap) r4;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public PiperData getPiperData(String r2, PiperData r3) {
        Object r4 = get(r2);
        if ((r4 instanceof PiperData) == true) goto L5;
        return r3;
    L5:
        return (PiperData) r4;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public String getString(String r2, String r3) {
        Object r4 = get(r2);
        if ((r4 instanceof String) == false) goto L7;
        return (String) r4;
    L7:
        if ((r4 instanceof Boolean) == false) goto L14;
        if (((Boolean) r4).booleanValue() == false) goto L11;
        return "true";
    L11:
        return "false";
    L14:
        if ((r4 instanceof Number) == true) goto L16;
        return r3;
    L16:
        return ((Number) r4).toString();
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putArray(String r1, WritableArray r2) {
        put(r1, r2);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putBoolean(String r1, boolean r2) {
        put(r1, Boolean.valueOf(r2));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putByteArray(String r1, byte[] r2) {
        put(r1, r2);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putByteArrayAsString(byte[] r2, byte[] r3) {
        put(new String(r2), new String(r3));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putByteBuffer(String r1, ByteBuffer r2) {
        put(r1, r2);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putDouble(String r1, double r2) {
        put(r1, Double.valueOf(r2));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putInt(String r1, int r2) {
        put(r1, Integer.valueOf(r2));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putLong(String r1, long r2) {
        put(r1, Long.valueOf(r2));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putMap(String r1, WritableMap r2) {
        put(r1, r2);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putPiperData(String r1, PiperData r2) {
        put(r1, r2);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putString(String r1, String r2) {
        put(r1, r2);
    }
}
