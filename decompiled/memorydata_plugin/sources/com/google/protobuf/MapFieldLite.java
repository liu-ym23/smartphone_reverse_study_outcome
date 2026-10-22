package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
    private static final MapFieldLite<?, ?> EMPTY_MAP_FIELD = null;
    private boolean isMutable;

    static {
        MapFieldLite<?, ?> r0 = new MapFieldLite();
        EMPTY_MAP_FIELD = r0;
        r0.makeImmutable();
    }

    private MapFieldLite() {
        this.isMutable = true;
    }

    private MapFieldLite(Map<K, V> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
        this.isMutable = true;
    }

    static <K, V> int calculateHashCodeForMap(Map<K, V> r4) {
        Iterator<Map.Entry<K, V>> r5 = ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r3 = calculateHashCodeForObject(r2.getKey());
        r0 = r0 + (calculateHashCodeForObject(r2.getValue()) ^ r3);
        goto L4
    L6:
        return r0;
    }

    private static int calculateHashCodeForObject(Object r2) {
        if ((r2 instanceof byte[]) == false) goto L7;
        return Internal.hashCode((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Internal.EnumLite.class) == true) goto L11;
        return r2.hashCode();
    L11:
        throw new UnsupportedOperationException();
    }

    private static void checkForNullKeysAndValues(Map<?, ?> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Iterator<K> r0 = r3.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        K r1 = r0.next();
        Internal.checkNotNull(r1);
        Internal.checkNotNull(r3.get(r1));
        goto L4
    }

    private static Object copy(Object r2) {
        if ((r2 instanceof byte[]) == false) goto L6;
        byte[] r3 = (byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin");
        return Arrays.copyOf(r3, r3.length);
    L6:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> Map<K, V> copy(Map<K, V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        LinkedHashMap r0 = new LinkedHashMap(((r5.size() * 4) / 3) + 1);
        Iterator<Map.Entry<K, V>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.put(r2.getKey(), copy(r2.getValue()));
        goto L4
    L6:
        return r0;
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

    private static boolean equals(Object r2, Object r3) {
        if ((r2 instanceof byte[]) == false) goto L9;
        if ((r3 instanceof byte[]) == false) goto L9;
        return Arrays.equals((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"));
    L9:
        return r2.equals(r3);
    }

    static <K, V> boolean equals(Map<K, V> r5, Map<K, V> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r7 != r8) goto L6;
        return true;
    L6:
        if (r7.size() == r8.size()) goto L8;
        return false;
    L8:
        Iterator<Map.Entry<K, V>> r9 = r7.entrySet().iterator();
    L10:
        if (r9.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r8.containsKey(r2.getKey()) == false) goto L13;
        if (equals(r2.getValue(), r8.get(r2.getKey())) == true) goto L10;
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
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Map.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (equals(this, (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")) == false) goto L7;
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

    public void mergeFrom(MapFieldLite<K, V> r2) {
        ensureMutable();
        if (r2.isEmpty() == true) goto L6;
        putAll(r2);
        return;
    }

    public MapFieldLite<K, V> mutableCopy() {
        if (isEmpty() == false) goto L6;
        return new MapFieldLite();
    L6:
        return new MapFieldLite(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K r1, V r2) {
        ensureMutable();
        Internal.checkNotNull(r1);
        Internal.checkNotNull(r2);
        return (V) super.put(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V put(Map.Entry<K, V> r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        return (V) put(r4.getKey(), r4.getValue());
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        ensureMutable();
        checkForNullKeysAndValues(r4);
        super.putAll(r4);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object r1) {
        ensureMutable();
        return (V) super.remove(r1);
    }
}
