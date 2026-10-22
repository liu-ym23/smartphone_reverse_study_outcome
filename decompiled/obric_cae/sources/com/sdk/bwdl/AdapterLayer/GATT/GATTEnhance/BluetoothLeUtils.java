package com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance;

import android.util.SparseArray;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothLeUtils {
    public BluetoothLeUtils() {
    }

    public static boolean equals(SparseArray<byte[]> r8, SparseArray<byte[]> r10) {
        if (r8 != r10) goto L6;
        return true;
    L6:
        if (r8 == null) goto L23;
        if (r10 == null) goto L23;
        if (r8.size() == r10.size()) goto L12;
        return false;
    L12:
        int r11 = 0;
    L14:
        if (r11 >= r8.size()) goto L22;
        if (r8.keyAt(r11) != r10.keyAt(r11)) goto L21;
        if (Arrays.equals(r8.valueAt(r11), r10.valueAt(r11)) == false) goto L21;
        r11 = r11 + 1;
    L21:
        return false;
    L22:
        return true;
    L23:
        return false;
    }

    public static String toString(SparseArray<byte[]> r8) {
        if (r8 != null) goto L6;
        return "null";
    L6:
        if (r8.size() != 0) goto L9;
        return "{}";
    L9:
        StringBuilder r10 = new StringBuilder("{");
        int r11 = 0;
    L11:
        if (r11 >= r8.size()) goto L13;
        r10.append(r8.keyAt(r11));
        r10.append("=");
        r10.append(Arrays.toString(r8.valueAt(r11)));
        r11 = r11 + 1;
        goto L11
    L13:
        r10.append('}');
        return r10.toString();
    }

    public static <T> boolean equals(Map<T, byte[]> r8, Map<T, byte[]> r10) {
        if (r8 != r10) goto L6;
        return true;
    L6:
        if (r8 == null) goto L22;
        if (r10 == null) goto L22;
        if (r8.size() == r10.size()) goto L12;
        return false;
    L12:
        Set<T> r11 = r8.keySet();
        if (r11.equals(r10.keySet()) == true) goto L15;
        return false;
    L15:
        Iterator<T> r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L21;
        T r13 = r12.next();
        if (Objects.deepEquals(r8.get(r13), r10.get(r13)) == true) goto L17;
        return false;
    L21:
        return true;
    L22:
        return false;
    }

    public static <T> String toString(Map<T, byte[]> r8) {
        if (r8 != null) goto L6;
        return "null";
    L6:
        if (r8.isEmpty() == false) goto L9;
        return "{}";
    L9:
        StringBuilder r10 = new StringBuilder("{");
        Iterator<Map.Entry<T, byte[]>> r11 = r8.entrySet().iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        T r12 = r11.next().getKey();
        r10.append(r12);
        r10.append("=");
        r10.append(Arrays.toString(r8.get(r12)));
        if (r11.hasNext() == false) goto L11;
        r10.append(", ");
        goto L11
    L15:
        r10.append('}');
        return r10.toString();
    }

    public static <T> boolean equals(byte[] r8, byte[] r10) {
        if (r8 != r10) goto L6;
        return true;
    L6:
        if (r8 == null) goto L16;
        if (r10 == null) goto L16;
        if (r8.length == r10.length) goto L13;
        return false;
    L13:
        if (Objects.deepEquals(r8, r10) == true) goto L15;
        return false;
    L15:
        return true;
    L16:
        return false;
    }

    public static <T> String toString(byte[] r8) {
        if (r8 != null) goto L6;
        return "null";
    L6:
        if (r8.length != 0) goto L9;
        return "{}";
    L9:
        StringBuilder r10 = new StringBuilder("{");
        int r11 = 0;
    L11:
        if (r11 >= r8.length) goto L15;
        r10.append(r8[r11]);
        r11 = r11 + 1;
        if (r11 >= r8.length) goto L11;
        r10.append(", ");
        goto L11
    L15:
        r10.append('}');
        return r10.toString();
    }
}
