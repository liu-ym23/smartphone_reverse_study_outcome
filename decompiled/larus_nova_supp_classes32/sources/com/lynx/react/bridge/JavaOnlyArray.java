package com.lynx.react.bridge;

import com.lynx.jsbridge.jsi.ILynxJSIObject;
import com.lynx.tasm.TemplateData;
import f6a.b;
import f6a.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class JavaOnlyArray extends ArrayList<Object> implements ReadableArray, WritableArray, d {
    private static final String TAG = "JavaOnlyArray";

    public static /* synthetic */ class a {
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

    @Override // com.lynx.react.bridge.ReadableArray
    public ArrayList<Object> asArrayList() {
        return this;
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushNull() {
        add(null);
    }

    private static JavaOnlyArray create() {
        return new JavaOnlyArray();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public ArrayList<Object> toArrayList() {
        return new ArrayList(this);
    }

    public JSONArray toJSONArray() {
        JSONArray r0 = new JSONArray();
        int r1 = size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L16;
        Object r3 = get(r2);
        if (getType(r2) != ReadableType.Map) goto L9;
        r0.put(((JavaOnlyMap) r3).toJSONObject());     // Catch: Exception -> L13
    L15:
        r2 = r2 + 1;
        goto L3
    L9:
        if (getType(r2) != ReadableType.Array) goto L11;
        r0.put(((JavaOnlyArray) r3).toJSONArray());     // Catch: Exception -> L13
        goto L15
    L11:
        r0.put(r3);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.toString();
        goto L15
    L16:
        return r0;
    }

    private JavaOnlyArray shallowCopy() {
        return shallowCopy(this);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List, com.lynx.react.bridge.ReadableArray
    public int size() {
        return super.size();
    }

    public JavaOnlyArray() {
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        super.clear();
    }

    public JavaOnlyArray(List r1) {
        super(r1);
    }

    public static JavaOnlyArray deepClone(ReadableArray r5) {
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L17;
        ReadableType r3 = r5.getType(r2);
        switch(a.a[r3.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L16;
        };
    L7:
        r0.pushByteArray((byte[]) r5.getByteArray(r2).clone());
        goto L16
    L8:
        r0.pushArray(deepClone(r5.getArray(r2)));
        goto L16
    L9:
        r0.pushMap(JavaOnlyMap.deepClone(r5.getMap(r2)));
        goto L16
    L10:
        r0.pushString(r5.getString(r2));
        goto L16
    L11:
        r0.pushDouble(r5.getDouble(r2));
        goto L16
    L12:
        r0.pushLong(r5.getLong(r2));
        goto L16
    L13:
        r0.pushInt(r5.getInt(r2));
        goto L16
    L14:
        r0.pushBoolean(r5.getBoolean(r2));
        goto L16
    L15:
        r0.pushNull();
    L16:
        r2 = r2 + 1;
        goto L3
    L17:
        return r0;
    }

    public static JavaOnlyArray from(List r1) {
        return new JavaOnlyArray(r1);
    }

    public static JavaOnlyArray of(Object... r1) {
        return new JavaOnlyArray(Arrays.asList(r1));
    }

    public static JavaOnlyArray shallowCopy(ReadableArray r5) {
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L17;
        ReadableType r3 = r5.getType(r2);
        switch(a.a[r3.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L16;
        };
    L7:
        r0.pushByteArray(r5.getByteArray(r2));
        goto L16
    L8:
        r0.pushArray((WritableArray) r5.getArray(r2));
        goto L16
    L9:
        r0.pushMap((WritableMap) r5.getMap(r2));
        goto L16
    L10:
        r0.pushString(r5.getString(r2));
        goto L16
    L11:
        r0.pushDouble(r5.getDouble(r2));
        goto L16
    L12:
        r0.pushLong(r5.getLong(r2));
        goto L16
    L13:
        r0.pushInt(r5.getInt(r2));
        goto L16
    L14:
        r0.pushBoolean(r5.getBoolean(r2));
        goto L16
    L15:
        r0.pushNull();
    L16:
        r2 = r2 + 1;
        goto L3
    L17:
        return r0;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public JavaOnlyArray getArray(int r1) {
        return (JavaOnlyArray) get(r1);
    }

    public Object getAt(int r1) {
        return get(r1);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public boolean getBoolean(int r1) {
        return ((Boolean) get(r1)).booleanValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public byte getByte(int r1) {
        return ((Number) get(r1)).byteValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public byte[] getByteArray(int r1) {
        return (byte[]) get(r1);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public char getChar(int r1) {
        return (char) ((Number) get(r1)).shortValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public double getDouble(int r3) {
        return ((Number) get(r3)).doubleValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public f6a.a getDynamic(int r2) {
        return new b(this, r2);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public int getInt(int r1) {
        return ((Number) get(r1)).intValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public long getLong(int r3) {
        return ((Number) get(r3)).longValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public JavaOnlyMap getMap(int r1) {
        return (JavaOnlyMap) get(r1);
    }

    public Object getObject(int r1) {
        return get(r1);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public PiperData getPiperData(int r1) {
        return (PiperData) get(r1);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public short getShort(int r1) {
        return ((Number) get(r1)).shortValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public String getString(int r1) {
        return (String) get(r1);
    }

    @Override // com.lynx.react.bridge.ReadableArray
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
        if ((r5 instanceof Number) == true) goto L54;
        if ((r5 instanceof Character) == true) goto L54;
        if ((r5 instanceof String) == false) goto L28;
        return ReadableType.String;
    L28:
        if ((r5 instanceof ReadableArray) == false) goto L32;
        return ReadableType.Array;
    L32:
        if ((r5 instanceof ReadableMap) == false) goto L36;
        return ReadableType.Map;
    L36:
        if ((r5 instanceof byte[]) == false) goto L40;
        return ReadableType.ByteArray;
    L40:
        if ((r5 instanceof PiperData) == false) goto L44;
        return ReadableType.PiperData;
    L44:
        if ((r5 instanceof ILynxJSIObject) == false) goto L48;
        return ReadableType.LynxObject;
    L48:
        if ((r5 instanceof TemplateData) == false) goto L52;
        return ReadableType.TemplateData;
    L52:
        throw new IllegalArgumentException("unsupported type " + r5.getClass() + " contained in JavaOnlyArray");
    L54:
        return ReadableType.Number;
    }

    public int getTypeIndex(int r1) {
        return getType(r1).ordinal();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public boolean isNull(int r1) {
        if (get(r1) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushArray(WritableArray r1) {
        add(r1);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushBoolean(boolean r1) {
        add(Boolean.valueOf(r1));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushByteArray(byte[] r1) {
        add(r1);
    }

    public void pushByteArrayAsString(byte[] r2) {
        add(new String(r2));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushDouble(double r1) {
        add(Double.valueOf(r1));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushInt(int r1) {
        add(Integer.valueOf(r1));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushLong(long r1) {
        add(Long.valueOf(r1));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushMap(WritableMap r1) {
        add(r1);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushPiperData(PiperData r1) {
        add(r1);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushString(String r1) {
        add(r1);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushTemplateData(TemplateData r1) {
        add(r1);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public /* bridge */ /* synthetic */ ReadableArray getArray(int r1) {
        return getArray(r1);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public /* bridge */ /* synthetic */ ReadableMap getMap(int r1) {
        return getMap(r1);
    }
}
