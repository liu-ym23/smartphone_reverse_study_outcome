package com.lynx.react.bridge;

import android.util.Log;
import com.lynx.jsbridge.jsi.ILynxJSIObject;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.CalledByNative;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import pm.a;
import pm.b;
import pm.d;
import pm.f;

/* JADX INFO: loaded from: classes2.dex */
public class JavaOnlyArray extends ArrayList<Object> implements ReadableArray, WritableArray, f {
    public JavaOnlyArray(List r5) {
        super(r5);
    }

    public static JavaOnlyArray a(ReadableArray r5) {
        JavaOnlyArray r10 = new JavaOnlyArray();
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L17;
        ReadableType r13 = r5.getType(r12);
        switch(d.f21365a[r13.ordinal()]) {
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
        r10.pushByteArray(r5.getByteArray(r12));
        goto L16
    L8:
        r10.pushArray((WritableArray) r5.getArray(r12));
        goto L16
    L9:
        r10.pushMap((WritableMap) r5.getMap(r12));
        goto L16
    L10:
        r10.pushString(r5.getString(r12));
        goto L16
    L11:
        r10.pushDouble(r5.getDouble(r12));
        goto L16
    L12:
        r10.pushLong(r5.getLong(r12));
        goto L16
    L13:
        r10.pushInt(r5.getInt(r12));
        goto L16
    L14:
        r10.pushBoolean(r5.getBoolean(r12));
        goto L16
    L15:
        r10.pushNull();
    L16:
        r12 = r12 + 1;
        goto L3
    L17:
        return r10;
    }

    @CalledByNative
    private static JavaOnlyArray create() {
        return new JavaOnlyArray();
    }

    @CalledByNative
    private JavaOnlyArray shallowCopy() {
        return a(this);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ArrayList asArrayList() {
        return this;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    @CalledByNative
    public void clear() {
        super.clear();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public /* bridge */ /* synthetic */ ReadableArray getArray(int r5) {
        return getArray(r5);
    }

    @CalledByNative
    public Object getAt(int r5) {
        return get(r5);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public boolean getBoolean(int r5) {
        return ((Boolean) get(r5)).booleanValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final byte getByte(int r5) {
        return ((Number) get(r5)).byteValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public byte[] getByteArray(int r5) {
        return (byte[]) get(r5);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final char getChar(int r5) {
        return (char) ((Number) get(r5)).shortValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public double getDouble(int r5) {
        return ((Number) get(r5)).doubleValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final a getDynamic(int r5) {
        return new b(this, r5);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public int getInt(int r5) {
        return ((Number) get(r5)).intValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public long getLong(int r5) {
        return ((Number) get(r5)).longValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public /* bridge */ /* synthetic */ ReadableMap getMap(int r5) {
        return getMap(r5);
    }

    @CalledByNative
    public Object getObject(int r5) {
        return get(r5);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public PiperData getPiperData(int r5) {
        return (PiperData) get(r5);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final short getShort(int r5) {
        return ((Number) get(r5)).shortValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public String getString(int r5) {
        return (String) get(r5);
    }

    @Override // com.lynx.react.bridge.ReadableArray
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
        if ((r10 instanceof Number) == true) goto L54;
        if ((r10 instanceof Character) == true) goto L54;
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
        if ((r10 instanceof PiperData) == false) goto L44;
        return ReadableType.PiperData;
    L44:
        if ((r10 instanceof ILynxJSIObject) == false) goto L48;
        return ReadableType.LynxObject;
    L48:
        if ((r10 instanceof TemplateData) == false) goto L52;
        return ReadableType.TemplateData;
    L52:
        throw new IllegalArgumentException("unsupported type " + r10.getClass() + " contained in JavaOnlyArray");
    L54:
        return ReadableType.Number;
    }

    @CalledByNative
    public int getTypeIndex(int r5) {
        return getType(r5).ordinal();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final boolean isNull(int r5) {
        if (get(r5) != null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.lynx.react.bridge.WritableArray
    @CalledByNative
    public void pushArray(WritableArray r5) {
        add(r5);
    }

    @Override // com.lynx.react.bridge.WritableArray
    @CalledByNative
    public void pushBoolean(boolean r5) {
        add(Boolean.valueOf(r5));
    }

    @Override // com.lynx.react.bridge.WritableArray
    @CalledByNative
    public void pushByteArray(byte[] r5) {
        add(r5);
    }

    @CalledByNative
    public void pushByteArrayAsString(byte[] r5) {
        add(new String(r5));
    }

    @Override // com.lynx.react.bridge.WritableArray
    @CalledByNative
    public void pushDouble(double r5) {
        add(Double.valueOf(r5));
    }

    @Override // com.lynx.react.bridge.WritableArray
    @CalledByNative
    public void pushInt(int r5) {
        add(Integer.valueOf(r5));
    }

    @Override // com.lynx.react.bridge.WritableArray
    @CalledByNative
    public void pushLong(long r5) {
        add(Long.valueOf(r5));
    }

    @Override // com.lynx.react.bridge.WritableArray
    @CalledByNative
    public void pushMap(WritableMap r5) {
        add(r5);
    }

    @Override // com.lynx.react.bridge.WritableArray
    @CalledByNative
    public void pushNull() {
        add(null);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public final void pushPiperData(PiperData r5) {
        add(r5);
    }

    @Override // com.lynx.react.bridge.WritableArray
    @CalledByNative
    public void pushString(String r5) {
        add(r5);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public final void pushTemplateData(TemplateData r5) {
        add(r5);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List, com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public int size() {
        return super.size();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ArrayList toArrayList() {
        return new ArrayList(this);
    }

    public JavaOnlyArray() {
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public JavaOnlyArray getArray(int r5) {
        return (JavaOnlyArray) get(r5);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @CalledByNative
    public JavaOnlyMap getMap(int r5) {
        return (JavaOnlyMap) get(r5);
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
}
