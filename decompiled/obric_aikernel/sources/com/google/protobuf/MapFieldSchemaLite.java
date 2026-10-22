package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class MapFieldSchemaLite implements MapFieldSchema {
    MapFieldSchemaLite() {
    }

    private static <K, V> int getSerializedSizeLite(int r10, Object r11, Object r12) {
        MapFieldLite r13 = (MapFieldLite) r11;
        MapEntryLite r14 = (MapEntryLite) r12;
        int r15 = 0;
        if (r13.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<K, V>> r16 = r13.entrySet().iterator();
    L7:
        if (r16.hasNext() == false) goto L9;
        Map.Entry<K, V> r17 = r16.next();
        r15 = r15 + r14.computeMessageSize(r10, r17.getKey(), r17.getValue());
        goto L7
    L9:
        return r15;
    }

    private static <K, V> MapFieldLite<K, V> mergeFromLite(Object r10, Object r11) {
        MapFieldLite<K, V> r12 = (MapFieldLite) r10;
        MapFieldLite<K, V> r13 = (MapFieldLite) r11;
        if (r13.isEmpty() == false) goto L5;
    L8:
        return r12;
    L5:
        if (r12.isMutable() == true) goto L7;
        r12 = r12.mutableCopy();
    L7:
        r12.mergeFrom(r13);
        goto L8
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMapData(Object r10) {
        return (MapFieldLite) r10;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object r10) {
        return ((MapEntryLite) r10).getMetadata();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMutableMapData(Object r10) {
        return (MapFieldLite) r10;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public int getSerializedSize(int r10, Object r11, Object r12) {
        return getSerializedSizeLite(r10, r11, r12);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public boolean isImmutable(Object r10) {
        return !((MapFieldLite) r10).isMutable();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object mergeFrom(Object r10, Object r11) {
        return mergeFromLite(r10, r11);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object newMapField(Object r10) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object toImmutable(Object r10) {
        ((MapFieldLite) r10).makeImmutable();
        return r10;
    }
}
