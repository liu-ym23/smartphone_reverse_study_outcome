package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class MapFieldSchemaFull implements MapFieldSchema {
    MapFieldSchemaFull() {
    }

    private static <K, V> int getSerializedSizeFull(int r10, Object r11, Object r12) {
        int r13 = 0;
        if (r11 != null) goto L5;
        return 0;
    L5:
        Map<K, V> r14 = ((MapField) r11).getMap();
        MapEntry r15 = (MapEntry) r12;
        if (r14.isEmpty() == false) goto L8;
        return 0;
    L8:
        Iterator<Map.Entry<K, V>> r16 = r14.entrySet().iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        Map.Entry<K, V> r17 = r16.next();
        r13 = r13 + (CodedOutputStream.computeTagSize(r10) + CodedOutputStream.computeLengthDelimitedFieldSize(MapEntryLite.computeSerializedSize(r15.getMetadata(), r17.getKey(), r17.getValue())));
        goto L10
    L12:
        return r13;
    }

    private static <K, V> Object mergeFromFull(Object r10, Object r11) {
        MapField r12 = (MapField) r10;
        MapField<K, V> r13 = (MapField) r11;
        if (r12.isMutable() == true) goto L5;
        r12.copy();
    L5:
        r12.mergeFrom(r13);
        return r12;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMapData(Object r10) {
        return ((MapField) r10).getMap();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object r10) {
        return ((MapEntry) r10).getMetadata();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMutableMapData(Object r10) {
        return ((MapField) r10).getMutableMap();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public int getSerializedSize(int r10, Object r11, Object r12) {
        return getSerializedSizeFull(r10, r11, r12);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public boolean isImmutable(Object r10) {
        return !((MapField) r10).isMutable();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object mergeFrom(Object r10, Object r11) {
        return mergeFromFull(r10, r11);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object newMapField(Object r10) {
        return MapField.newMapField((MapEntry) r10);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object toImmutable(Object r10) {
        ((MapField) r10).makeImmutable();
        return r10;
    }
}
