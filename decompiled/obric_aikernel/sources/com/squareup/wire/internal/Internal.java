package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Internal {
    private Internal() {
    }

    public static void checkElementsNotNull(List<?> r10) {
        Objects.requireNonNull(r10, "list == null");
        int r11 = 0;
        int r12 = r10.size();
    L3:
        if (r11 >= r12) goto L9;
        if (r10.get(r11) == null) goto L8;
        r11 = r11 + 1;
        goto L3
    L8:
        throw new NullPointerException("Element at index " + r11 + " is null");
    }

    public static void checkElementsNotNull(Map<?, ?> r10) {
        Objects.requireNonNull(r10, "map == null");
        Iterator<Map.Entry<?, ?>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Map.Entry<?, ?> r12 = r11.next();
        Objects.requireNonNull(r12.getKey(), "map.containsKey(null)");
        if (r12.getValue() != null) goto L4;
        throw new NullPointerException("Value for key " + r12.getKey() + " is null");
    }

    public static <T> List<T> copyOf(String r10, List<T> r11) {
        if (r11 == null) goto L13;
        if (r11 == Collections.emptyList()) goto L11;
        if ((r11 instanceof ImmutableList) == true) goto L11;
        return new ArrayList(r11);
    L11:
        return new MutableOnWriteList(r11);
    L13:
        throw new NullPointerException(r10 + " == null");
    }

    public static <K, V> Map<K, V> copyOf(String r10, Map<K, V> r11) {
        if (r11 == null) goto L6;
        return new LinkedHashMap(r11);
    L6:
        throw new NullPointerException(r10 + " == null");
    }

    public static int countNonNull(Object r10, Object r11) {
        int r12 = 1;
        if (r10 == null) goto L5;
        int r13 = 1;
    L6:
        if (r11 != null) goto L10;
        r12 = 0;
    L10:
        return r13 + r12;
    L5:
        r13 = 0;
        goto L6
    }

    public static int countNonNull(Object r10, Object r11, Object r12) {
        int r13 = 1;
        if (r10 == null) goto L5;
        int r14 = 1;
    L6:
        if (r11 == null) goto L8;
        int r15 = 1;
    L9:
        int r16 = r14 + r15;
        if (r12 != null) goto L14;
        r13 = 0;
    L14:
        return r16 + r13;
    L8:
        r15 = 0;
        goto L9
    L5:
        r14 = 0;
        goto L6
    }

    public static int countNonNull(Object r10, Object r11, Object r12, Object r13, Object... r14) {
        int r15 = 0;
        if (r10 == null) goto L5;
        int r16 = 1;
    L6:
        if (r11 == null) goto L8;
        r16 = r16 + 1;
    L8:
        if (r12 == null) goto L10;
        r16 = r16 + 1;
    L10:
        if (r13 == null) goto L12;
        r16 = r16 + 1;
    L12:
        int r17 = r14.length;
    L13:
        if (r15 >= r17) goto L18;
        if (r14[r15] == null) goto L17;
        r16 = r16 + 1;
    L17:
        r15 = r15 + 1;
        goto L13
    L18:
        return r16;
    L5:
        r16 = 0;
        goto L6
    }

    public static boolean equals(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    public static <T> List<T> immutableCopyOf(String r10, List<T> r11) {
        if (r11 == null) goto L18;
        if ((r11 instanceof MutableOnWriteList) == false) goto L7;
        r11 = ((MutableOnWriteList) r11).mutableList;
    L7:
        if (r11 != Collections.emptyList()) goto L9;
    L16:
        return r11;
    L9:
        if ((r11 instanceof ImmutableList) == true) goto L16;
        ImmutableList r12 = new ImmutableList(r11);
        if (r12.contains(null) == true) goto L15;
        return r12;
    L15:
        throw new IllegalArgumentException(r10 + ".contains(null)");
    L18:
        throw new NullPointerException(r10 + " == null");
    }

    public static <K, V> Map<K, V> immutableCopyOf(String r10, Map<K, V> r11) {
        if (r11 == null) goto L18;
        if (r11.isEmpty() == true) goto L6;
        LinkedHashMap r12 = new LinkedHashMap(r11);
        if (r12.containsKey(null) == true) goto L16;
        if (r12.containsValue(null) == true) goto L14;
        return Collections.unmodifiableMap(r12);
    L14:
        throw new IllegalArgumentException(r10 + ".containsValue(null)");
    L16:
        throw new IllegalArgumentException(r10 + ".containsKey(null)");
    L6:
        return Collections.emptyMap();
    L18:
        throw new NullPointerException(r10 + " == null");
    }

    public static IllegalStateException missingRequiredFields(Object... r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.length;
        String r13 = "";
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L12;
        if (r10[r14] != null) goto L10;
        if (r11.length() <= 0) goto L9;
        r13 = "s";
    L9:
        r11.append("\n  ");
        r11.append(r10[r14 + 1]);
    L10:
        r14 = r14 + 2;
        goto L3
    L12:
        throw new IllegalStateException("Required field" + r13 + " not set:" + r11);
    }

    public static <T> List<T> newMutableList() {
        return new MutableOnWriteList(Collections.emptyList());
    }

    public static <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    public static <T> void redactElements(List<T> r10, ProtoAdapter<T> r11) {
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.set(r13, r11.redact(r10.get(r13)));
        r13 = r13 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void redactElements(Map<?, T> r10, ProtoAdapter<T> r11) {
        Iterator<Map.Entry<?, T>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry r13 = r12.next();
        r13.setValue(r11.redact(r13.getValue()));
        goto L4
    }
}
