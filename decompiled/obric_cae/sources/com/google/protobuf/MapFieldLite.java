package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
    private static final MapFieldLite<?, ?> EMPTY_MAP_FIELD = null;
    private boolean isMutable;

    static {
        MapFieldLite<?, ?> r8 = new MapFieldLite();
        EMPTY_MAP_FIELD = r8;
        r8.makeImmutable();
    }

    private MapFieldLite() {
        this.isMutable = true;
    }

    public static <K, V> int calculateHashCodeForMap(Map<K, V> r8) {
        Iterator<Map.Entry<K, V>> r10 = r8.entrySet().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<K, V> r12 = r10.next();
        int r13 = calculateHashCodeForObject(r12.getKey());
        r11 = r11 + (calculateHashCodeForObject(r12.getValue()) ^ r13);
        goto L4
    L6:
        return r11;
    }

    private static int calculateHashCodeForObject(Object r8) {
        if ((r8 instanceof byte[]) == false) goto L7;
        return Internal.hashCode((byte[]) r8);
    L7:
        if ((r8 instanceof Internal.EnumLite) == true) goto L11;
        return r8.hashCode();
    L11:
        throw new UnsupportedOperationException();
    }

    private static void checkForNullKeysAndValues(Map<?, ?> r8) {
        Iterator<?> r10 = r8.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Object r11 = r10.next();
        Internal.checkNotNull(r11);
        Internal.checkNotNull(r8.get(r11));
        goto L4
    }

    private static Object copy(Object r8) {
        if ((r8 instanceof byte[]) == false) goto L6;
        byte[] r10 = (byte[]) r8;
        return Arrays.copyOf(r10, r10.length);
    L6:
        return r8;
    }

    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return (MapFieldLite<K, V>) EMPTY_MAP_FIELD;
    }

    private void ensureMutable() {
        if (isMutable() == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        ensureMutable();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (isEmpty() == false) goto L6;
        return Collections.emptySet();
    L6:
        return super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object r8) {
        if ((r8 instanceof Map) == true) goto L5;
    L7:
        return false;
    L5:
        if (equals(this, (Map) r8) == false) goto L7;
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return calculateHashCodeForMap(this);
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public void mergeFrom(MapFieldLite<K, V> r8) {
        ensureMutable();
        if (r8.isEmpty() == true) goto L6;
        putAll(r8);
        return;
    }

    public MapFieldLite<K, V> mutableCopy() {
        if (isEmpty() == false) goto L6;
        return new MapFieldLite();
    L6:
        return new MapFieldLite(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K r8, V r10) {
        ensureMutable();
        Internal.checkNotNull(r8);
        Internal.checkNotNull(r10);
        return (V) super.put(r8, r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r8) {
        ensureMutable();
        checkForNullKeysAndValues(r8);
        super.putAll(r8);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object r8) {
        ensureMutable();
        return (V) super.remove(r8);
    }

    private MapFieldLite(Map<K, V> r8) {
        super(r8);
        this.isMutable = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> copy(Map<K, V> r8) {
        LinkedHashMap r10 = new LinkedHashMap(((r8.size() * 4) / 3) + 1);
        Iterator<Map.Entry<K, V>> r11 = r8.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<K, V> r12 = r11.next();
        r10.put(r12.getKey(), copy(r12.getValue()));
        goto L4
    L6:
        return r10;
    }

    private static boolean equals(Object r8, Object r10) {
        if ((r8 instanceof byte[]) == false) goto L9;
        if ((r10 instanceof byte[]) == false) goto L9;
        return Arrays.equals((byte[]) r8, (byte[]) r10);
    L9:
        return r8.equals(r10);
    }

    public V put(Map.Entry<K, V> r8) {
        return put(r8.getKey(), r8.getValue());
    }

    public static <K, V> boolean equals(Map<K, V> r8, Map<K, V> r10) {
        if (r8 != r10) goto L6;
        return true;
    L6:
        if (r8.size() == r10.size()) goto L8;
        return false;
    L8:
        Iterator<Map.Entry<K, V>> r11 = r8.entrySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L17;
        Map.Entry<K, V> r12 = r11.next();
        if (r10.containsKey(r12.getKey()) == false) goto L13;
        if (equals(r12.getValue(), r10.get(r12.getKey())) == true) goto L10;
        return false;
    L13:
        return false;
    L17:
        return true;
    }
}
