package com.squareup.wire.internal;

import ai.j0;
import com.squareup.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Internal {
    private Internal() {
    }

    public static void checkElementsNotNull(List<?> r5) {
        if (r5 == null) goto L12;
        int r10 = r5.size();
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L10;
        if (r5.get(r11) == null) goto L9;
        r11 = r11 + 1;
        goto L4
    L9:
        throw new NullPointerException(j0.h(r11, "Element at index ", " is null"));
    L10:
        return;
    L12:
        throw new NullPointerException("list == null");
    }

    public static <T> List<T> copyOf(String r5, List<T> r10) {
        if (r10 == null) goto L13;
        if (r10 == Collections.emptyList()) goto L11;
        if ((r10 instanceof ImmutableList) == true) goto L11;
        return new ArrayList(r10);
    L11:
        return new MutableOnWriteList(r10);
    L13:
        throw new NullPointerException(j0.j(r5, " == null"));
    }

    public static int countNonNull(Object r5, Object r10) {
        int r11 = 0;
        if (r5 == null) goto L5;
        int r12 = 1;
    L6:
        if (r10 == null) goto L9;
        r11 = 1;
    L9:
        return r12 + r11;
    L5:
        r12 = 0;
        goto L6
    }

    public static boolean equals(Object r5, Object r10) {
        if (r5 == r10) goto L8;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.equals(r10) == false) goto L7;
    L8:
        return true;
    }

    public static <T> List<T> immutableCopyOf(String r5, List<T> r10) {
        if (r10 == null) goto L18;
        if ((r10 instanceof MutableOnWriteList) == false) goto L7;
        r10 = ((MutableOnWriteList) r10).mutableList;
    L7:
        if (r10 != Collections.emptyList()) goto L9;
    L16:
        return r10;
    L9:
        if ((r10 instanceof ImmutableList) == true) goto L16;
        ImmutableList r11 = new ImmutableList(r10);
        if (r11.contains(null) == true) goto L15;
        return r11;
    L15:
        throw new IllegalArgumentException(j0.j(r5, ".contains(null)"));
    L18:
        throw new NullPointerException(j0.j(r5, " == null"));
    }

    public static IllegalStateException missingRequiredFields(Object... r5) {
        StringBuilder r10 = new StringBuilder();
        int r11 = r5.length;
        String r12 = "";
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L12;
        if (r5[r13] != null) goto L10;
        if (r10.length() <= 0) goto L9;
        r12 = "s";
    L9:
        r10.append("\n  ");
        r10.append(r5[r13 + 1]);
    L10:
        r13 = r13 + 2;
        goto L3
    L12:
        throw new IllegalStateException("Required field" + r12 + " not set:" + r10);
    }

    public static <T> List<T> newMutableList() {
        return new MutableOnWriteList(Collections.emptyList());
    }

    public static <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    public static <T> void redactElements(List<T> r5, ProtoAdapter<T> r10) {
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5.set(r12, r10.redact(r5.get(r12)));
        r12 = r12 + 1;
        goto L3
    }

    public static int countNonNull(Object r5, Object r10, Object r11) {
        int r12 = 0;
        if (r5 == null) goto L5;
        int r13 = 1;
    L6:
        if (r10 == null) goto L8;
        int r14 = 1;
    L9:
        int r15 = r13 + r14;
        if (r11 == null) goto L13;
        r12 = 1;
    L13:
        return r15 + r12;
    L8:
        r14 = 0;
        goto L9
    L5:
        r13 = 0;
        goto L6
    }

    public static int countNonNull(Object r5, Object r10, Object r11, Object r12, Object... r13) {
        int r14 = 0;
        if (r5 == null) goto L5;
        int r15 = 1;
    L6:
        if (r10 == null) goto L8;
        r15 = r15 + 1;
    L8:
        if (r11 == null) goto L10;
        r15 = r15 + 1;
    L10:
        if (r12 == null) goto L12;
        r15 = r15 + 1;
    L12:
        int r16 = r13.length;
    L13:
        if (r14 >= r16) goto L18;
        if (r13[r14] == null) goto L17;
        r15 = r15 + 1;
    L17:
        r14 = r14 + 1;
        goto L13
    L18:
        return r15;
    L5:
        r15 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void redactElements(Map<?, T> r5, ProtoAdapter<T> r10) {
        Iterator<Map.Entry<?, T>> r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = r11.next();
        r12.setValue(r10.redact(r12.getValue()));
        goto L4
    }

    public static void checkElementsNotNull(Map<?, ?> r5) {
        if (r5 == null) goto L17;
        Iterator<Map.Entry<?, ?>> r10 = r5.entrySet().iterator();
    L5:
        if (r10.hasNext() == false) goto L15;
        Map.Entry<?, ?> r11 = r10.next();
        if (r11.getKey() == null) goto L14;
        if (r11.getValue() != null) goto L5;
        throw new NullPointerException("Value for key " + r11.getKey() + " is null");
    L14:
        throw new NullPointerException("map.containsKey(null)");
    L15:
        return;
    L17:
        throw new NullPointerException("map == null");
    }

    public static <K, V> Map<K, V> copyOf(String r5, Map<K, V> r10) {
        if (r10 == null) goto L6;
        return new LinkedHashMap(r10);
    L6:
        throw new NullPointerException(j0.j(r5, " == null"));
    }

    public static <K, V> Map<K, V> immutableCopyOf(String r5, Map<K, V> r10) {
        if (r10 == null) goto L18;
        if (r10.isEmpty() == true) goto L6;
        LinkedHashMap r11 = new LinkedHashMap(r10);
        if (r11.containsKey(null) == true) goto L16;
        if (r11.containsValue(null) == true) goto L14;
        return Collections.unmodifiableMap(r11);
    L14:
        throw new IllegalArgumentException(j0.j(r5, ".containsValue(null)"));
    L16:
        throw new IllegalArgumentException(j0.j(r5, ".containsKey(null)"));
    L6:
        return Collections.emptyMap();
    L18:
        throw new NullPointerException(j0.j(r5, " == null"));
    }
}
