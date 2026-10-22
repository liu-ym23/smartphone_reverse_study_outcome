package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
    private static final MapFieldLite<?, ?> EMPTY_MAP_FIELD = null;
    private boolean isMutable;

    static {
        MapFieldLite<?, ?> r10 = new MapFieldLite();
        EMPTY_MAP_FIELD = r10;
        r10.makeImmutable();
    }

    private MapFieldLite() {
        this.isMutable = true;
    }

    private MapFieldLite(Map<K, V> r10) {
        super(r10);
        this.isMutable = true;
    }

    static <K, V> int calculateHashCodeForMap(Map<K, V> r10) {
        Iterator<Map.Entry<K, V>> r11 = r10.entrySet().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<K, V> r13 = r11.next();
        int r14 = calculateHashCodeForObject(r13.getKey());
        r12 = r12 + (calculateHashCodeForObject(r13.getValue()) ^ r14);
        goto L4
    L6:
        return r12;
    }

    private static int calculateHashCodeForObject(Object r10) {
        if ((r10 instanceof byte[]) == false) goto L7;
        return Internal.hashCode((byte[]) r10);
    L7:
        if ((r10 instanceof Internal.EnumLite) == true) goto L11;
        return r10.hashCode();
    L11:
        throw new UnsupportedOperationException();
    }

    private static void checkForNullKeysAndValues(Map<?, ?> r10) {
        Iterator<?> r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Object r12 = r11.next();
        Internal.checkNotNull(r12);
        Internal.checkNotNull(r10.get(r12));
        goto L4
    }

    private static Object copy(Object r10) {
        if ((r10 instanceof byte[]) == false) goto L6;
        byte[] r11 = (byte[]) r10;
        return Arrays.copyOf(r11, r11.length);
    L6:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> Map<K, V> copy(Map<K, V> r10) {
        LinkedHashMap r11 = new LinkedHashMap(((r10.size() * 4) / 3) + 1);
        Iterator<Map.Entry<K, V>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<K, V> r13 = r12.next();
        r11.put(r13.getKey(), copy(r13.getValue()));
        goto L4
    L6:
        return r11;
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

    private static boolean equals(Object r10, Object r11) {
        if ((r10 instanceof byte[]) == false) goto L9;
        if ((r11 instanceof byte[]) == false) goto L9;
        return Arrays.equals((byte[]) r10, (byte[]) r11);
    L9:
        return r10.equals(r11);
    }

    static <K, V> boolean equals(Map<K, V> r10, Map<K, V> r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r10.size() == r11.size()) goto L8;
        return false;
    L8:
        Iterator<Map.Entry<K, V>> r12 = r10.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L17;
        Map.Entry<K, V> r13 = r12.next();
        if (r11.containsKey(r13.getKey()) == false) goto L13;
        if (equals(r13.getValue(), r11.get(r13.getKey())) == true) goto L10;
        return false;
    L13:
        return false;
    L17:
        return true;
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
    public boolean equals(Object r10) {
        if ((r10 instanceof Map) == true) goto L5;
    L7:
        return false;
    L5:
        if (equals(this, (Map) r10) == false) goto L7;
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

    public void mergeFrom(MapFieldLite<K, V> r10) {
        ensureMutable();
        if (r10.isEmpty() == true) goto L6;
        putAll(r10);
        return;
    }

    public MapFieldLite<K, V> mutableCopy() {
        if (isEmpty() == false) goto L6;
        return new MapFieldLite();
    L6:
        return new MapFieldLite(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K r10, V r11) {
        ensureMutable();
        Internal.checkNotNull(r10);
        Internal.checkNotNull(r11);
        return (V) super.put(r10, r11);
    }

    public V put(Map.Entry<K, V> r10) {
        return put(r10.getKey(), r10.getValue());
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r10) {
        ensureMutable();
        checkForNullKeysAndValues(r10);
        super.putAll(r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object r10) {
        ensureMutable();
        return (V) super.remove(r10);
    }
}
