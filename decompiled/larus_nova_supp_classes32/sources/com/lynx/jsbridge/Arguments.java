package com.lynx.jsbridge;

import android.os.Bundle;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class Arguments {

    public static class a extends AbstractList {
        public final /* synthetic */ Object a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return Array.getLength(this.a);
        }

        public a(Object r1) {
            this.a = r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int r2) {
            return Array.get(this.a, r2);
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            a = r0;
            r0[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[ReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[ReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[ReadableType.Map.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[ReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public Arguments() {
    }

    public static WritableArray createArray() {
        return new JavaOnlyArray();
    }

    public static WritableMap createMap() {
        return new JavaOnlyMap();
    }

    public static WritableArray fromArray(Object r5) {
        WritableArray r0 = createArray();
        int r2 = 0;
        if ((r5 instanceof String[]) == false) goto L8;
        String[] r6 = (String[]) r5;
        int r1 = r6.length;
    L5:
        if (r2 >= r1) goto L32;
        r0.pushString(r6[r2]);
        r2 = r2 + 1;
    L32:
        return r0;
    L8:
        if ((r5 instanceof Bundle[]) == false) goto L13;
        Bundle[] r7 = (Bundle[]) r5;
        int r3 = r7.length;
    L10:
        if (r2 >= r3) goto L32;
        r0.pushMap(fromBundle(r7[r2]));
        r2 = r2 + 1;
        goto L10
    L13:
        if ((r5 instanceof int[]) == false) goto L18;
        int[] r8 = (int[]) r5;
        int r4 = r8.length;
    L15:
        if (r2 >= r4) goto L32;
        r0.pushInt(r8[r2]);
        r2 = r2 + 1;
        goto L15
    L18:
        if ((r5 instanceof float[]) == false) goto L23;
        float[] r9 = (float[]) r5;
        int r10 = r9.length;
    L20:
        if (r2 >= r10) goto L32;
        r0.pushDouble(r9[r2]);
        r2 = r2 + 1;
        goto L20
    L23:
        if ((r5 instanceof double[]) == false) goto L28;
        double[] r11 = (double[]) r5;
        int r12 = r11.length;
    L25:
        if (r2 >= r12) goto L32;
        r0.pushDouble(r11[r2]);
        r2 = r2 + 1;
        goto L25
    L28:
        if ((r5 instanceof boolean[]) == false) goto L34;
        boolean[] r13 = (boolean[]) r5;
        int r14 = r13.length;
    L30:
        if (r2 >= r14) goto L32;
        r0.pushBoolean(r13[r2]);
        r2 = r2 + 1;
        goto L30
    L34:
        throw new IllegalArgumentException("Unknown array type " + r5.getClass());
    }

    public static WritableMap fromBundle(Bundle r5) {
        WritableMap r0 = createMap();
        Iterator<String> r1 = r5.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L31;
        String r2 = r1.next();
        Object r3 = r5.get(r2);
        if (r3 == null) goto L7;
        if (r3.getClass().isArray() == true) goto L10;
        if ((r3 instanceof String) == true) goto L13;
        if ((r3 instanceof Number) == true) goto L17;
        if ((r3 instanceof Boolean) == true) goto L22;
        if ((r3 instanceof Bundle) == true) goto L25;
        if ((r3 instanceof List) == false) goto L30;
        r0.putArray(r2, fromList((List) r3));
        goto L4
    L30:
        throw new IllegalArgumentException("Could not convert " + r3.getClass());
    L25:
        r0.putMap(r2, fromBundle((Bundle) r3));
        goto L4
    L22:
        r0.putBoolean(r2, ((Boolean) r3).booleanValue());
        goto L4
    L17:
        if ((r3 instanceof Integer) == true) goto L18;
        r0.putDouble(r2, ((Number) r3).doubleValue());
        goto L4
    L18:
        r0.putInt(r2, ((Integer) r3).intValue());
        goto L4
    L13:
        r0.putString(r2, (String) r3);
        goto L4
    L10:
        r0.putArray(r2, fromArray(r3));
        goto L4
    L7:
        r0.putNull(r2);
        goto L4
    L31:
        return r0;
    }

    public static JavaOnlyArray fromJavaArgs(Object[] r5) {
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L32;
        Object r2 = r5[r1];
        if (r2 != null) goto L8;
        r0.pushNull();
    L29:
        r1 = r1 + 1;
        goto L4
    L8:
        Class<?> r3 = r2.getClass();
        if (r3 != Boolean.class) goto L12;
        r0.pushBoolean(((Boolean) r2).booleanValue());
        goto L29
    L12:
        if (r3 != Integer.class) goto L15;
        r0.pushDouble(((Integer) r2).doubleValue());
        goto L29
    L15:
        if (r3 != Double.class) goto L18;
        r0.pushDouble(((Double) r2).doubleValue());
        goto L29
    L18:
        if (r3 != Float.class) goto L21;
        r0.pushDouble(((Float) r2).doubleValue());
        goto L29
    L21:
        if (r3 != String.class) goto L24;
        r0.pushString(r2.toString());
        goto L29
    L24:
        if (r3 != JavaOnlyMap.class) goto L27;
        r0.pushMap((JavaOnlyMap) r2);
        goto L29
    L27:
        if (r3 != JavaOnlyArray.class) goto L31;
        r0.pushArray((JavaOnlyArray) r2);
        goto L29
    L31:
        throw new RuntimeException("Cannot convert argument of type " + r3);
    L32:
        return r0;
    }

    public static WritableArray fromList(List r3) {
        WritableArray r0 = createArray();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L31;
        Object r1 = r4.next();
        if (r1 == null) goto L7;
        if (r1.getClass().isArray() == true) goto L10;
        if ((r1 instanceof Bundle) == true) goto L13;
        if ((r1 instanceof List) == true) goto L16;
        if ((r1 instanceof String) == true) goto L19;
        if ((r1 instanceof Integer) == true) goto L22;
        if ((r1 instanceof Number) == true) goto L25;
        if ((r1 instanceof Boolean) == false) goto L30;
        r0.pushBoolean(((Boolean) r1).booleanValue());
        goto L4
    L30:
        throw new IllegalArgumentException("Unknown value type " + r1.getClass());
    L25:
        r0.pushDouble(((Number) r1).doubleValue());
        goto L4
    L22:
        r0.pushInt(((Integer) r1).intValue());
        goto L4
    L19:
        r0.pushString((String) r1);
        goto L4
    L16:
        r0.pushArray(fromList((List) r1));
        goto L4
    L13:
        r0.pushMap(fromBundle((Bundle) r1));
        goto L4
    L10:
        r0.pushArray(fromArray(r1));
        goto L4
    L7:
        r0.pushNull();
        goto L4
    L31:
        return r0;
    }

    public static JavaOnlyArray makeNativeArray(List r3) {
        JavaOnlyArray r0 = new JavaOnlyArray();
        if (r3 != null) goto L5;
        return r0;
    L5:
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L31;
        Object r1 = makeNativeObject(r4.next());
        if (r1 == null) goto L10;
        if ((r1 instanceof Boolean) == true) goto L13;
        if ((r1 instanceof Integer) == true) goto L16;
        if ((r1 instanceof Double) == true) goto L19;
        if ((r1 instanceof String) == true) goto L22;
        if ((r1 instanceof JavaOnlyArray) == true) goto L25;
        if ((r1 instanceof JavaOnlyMap) == false) goto L30;
        r0.pushMap((JavaOnlyMap) r1);
        goto L7
    L30:
        throw new IllegalArgumentException("Could not convert " + r1.getClass());
    L25:
        r0.pushArray((JavaOnlyArray) r1);
        goto L7
    L22:
        r0.pushString((String) r1);
        goto L7
    L19:
        r0.pushDouble(((Double) r1).doubleValue());
        goto L7
    L16:
        r0.pushInt(((Integer) r1).intValue());
        goto L7
    L13:
        r0.pushBoolean(((Boolean) r1).booleanValue());
        goto L7
    L10:
        r0.pushNull();
        goto L7
    L31:
        return r0;
    }

    public static JavaOnlyMap makeNativeMap(Map<String, Object> r3) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        if (r3 != null) goto L5;
        return r0;
    L5:
        Iterator<Map.Entry<String, Object>> r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        Map.Entry<String, Object> r1 = r4.next();
        addEntry(r0, r1.getKey(), r1.getValue());
        goto L7
    L9:
        return r0;
    }

    private static Object makeNativeObject(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof Float) == true) goto L31;
        if ((r2 instanceof Long) == true) goto L31;
        if ((r2 instanceof Byte) == true) goto L31;
        if ((r2 instanceof Short) == true) goto L31;
        if (r2.getClass().isArray() == false) goto L19;
        return makeNativeArray(r2);
    L19:
        if ((r2 instanceof List) == false) goto L23;
        return makeNativeArray((List) r2);
    L23:
        if ((r2 instanceof Map) == false) goto L27;
        return makeNativeMap((Map) r2);
    L27:
        if ((r2 instanceof Bundle) == true) goto L29;
        return r2;
    L29:
        return makeNativeMap((Bundle) r2);
    L31:
        return Double.valueOf(((Number) r2).doubleValue());
    }

    public static Bundle toBundle(ReadableMap r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        ReadableMapKeySetIterator r1 = r6.keySetIterator();
        Bundle r2 = new Bundle();
    L7:
        if (r1.hasNextKey() == false) goto L18;
        String r3 = r1.nextKey();
        switch(b.a[r6.getType(r3).ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L11:
        throw new IllegalArgumentException("Could not convert object with key: " + r3 + ".");
    L13:
        r2.putBundle(r3, toBundle(r6.getMap(r3)));
        goto L7
    L14:
        r2.putString(r3, r6.getString(r3));
        goto L7
    L15:
        r2.putDouble(r3, r6.getDouble(r3));
        goto L7
    L16:
        r2.putBoolean(r3, r6.getBoolean(r3));
        goto L7
    L17:
        r2.putString(r3, null);
        goto L7
    L12:
        r2.putSerializable(r3, toList(r6.getArray(r3)));
        goto L7
    L18:
        return r2;
    }

    public static ArrayList toList(ReadableArray r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        int r2 = 0;
    L7:
        if (r2 >= r8.size()) goto L22;
        switch(b.a[r8.getType(r2).ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        r1.add(toList(r8.getArray(r2)));
    L21:
        r2 = r2 + 1;
        goto L7
    L13:
        r1.add(toBundle(r8.getMap(r2)));
        goto L21
    L14:
        r1.add(r8.getString(r2));
        goto L21
    L15:
        double r3 = r8.getDouble(r2);
        if (r3 != Math.rint(r3)) goto L18;
        r1.add(Integer.valueOf((int) r3));
        goto L21
    L18:
        r1.add(Double.valueOf(r3));
        goto L21
    L19:
        r1.add(Boolean.valueOf(r8.getBoolean(r2)));
        goto L21
    L20:
        r1.add(null);
        goto L21
    L11:
        throw new IllegalArgumentException("Could not convert object in array.");
    L22:
        return r1;
    }

    public static <T> JavaOnlyArray makeNativeArray(Object r1) {
        if (r1 != null) goto L6;
        return new JavaOnlyArray();
    L6:
        return makeNativeArray(new a(r1));
    }

    public static JavaOnlyMap makeNativeMap(Bundle r4) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        if (r4 != null) goto L5;
        return r0;
    L5:
        Iterator<String> r1 = r4.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = r1.next();
        addEntry(r0, r2, r4.get(r2));
        goto L7
    L9:
        return r0;
    }

    private static void addEntry(JavaOnlyMap r2, String r3, Object r4) {
        Object r5 = makeNativeObject(r4);
        if (r5 != null) goto L6;
        r2.putNull(r3);
        return;
    L6:
        if ((r5 instanceof Boolean) == false) goto L9;
        r2.putBoolean(r3, ((Boolean) r5).booleanValue());
        return;
    L9:
        if ((r5 instanceof Integer) == false) goto L12;
        r2.putInt(r3, ((Integer) r5).intValue());
        return;
    L12:
        if ((r5 instanceof Number) == false) goto L15;
        r2.putDouble(r3, ((Number) r5).doubleValue());
        return;
    L15:
        if ((r5 instanceof String) == false) goto L18;
        r2.putString(r3, (String) r5);
        return;
    L18:
        if ((r5 instanceof JavaOnlyArray) == false) goto L21;
        r2.putArray(r3, (JavaOnlyArray) r5);
        return;
    L21:
        if ((r5 instanceof JavaOnlyMap) == false) goto L25;
        r2.putMap(r3, (JavaOnlyMap) r5);
        return;
    L25:
        throw new IllegalArgumentException("Could not convert " + r5.getClass());
    }
}
