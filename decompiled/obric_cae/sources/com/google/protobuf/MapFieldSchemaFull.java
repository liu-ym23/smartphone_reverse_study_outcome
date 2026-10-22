package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class MapFieldSchemaFull implements MapFieldSchema {
    public MapFieldSchemaFull() {
    }

    private static <K, V> int getSerializedSizeFull(int r8, Object r10, Object r11) {
        int r12 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        Map<K, V> r13 = ((MapField) r10).getMap();
        MapEntry r14 = (MapEntry) r11;
        if (r13.isEmpty() == false) goto L8;
        return 0;
    L8:
        Iterator<Map.Entry<K, V>> r15 = r13.entrySet().iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        Map.Entry<K, V> r16 = r15.next();
        int r17 = CodedOutputStream.computeTagSize(r8);
        r12 = r12 + (CodedOutputStream.computeLengthDelimitedFieldSize(MapEntryLite.computeSerializedSize(r14.getMetadata(), r16.getKey(), r16.getValue())) + r17);
        goto L10
    L12:
        return r12;
    }

    private static <K, V> Object mergeFromFull(Object r8, Object r10) {
        MapField r11 = (MapField) r8;
        MapField<K, V> r12 = (MapField) r10;
        if (r11.isMutable() == true) goto L5;
        r11.copy();
    L5:
        r11.mergeFrom(r12);
        return r11;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMapData(Object r8) {
        return ((MapField) r8).getMap();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object r8) {
        return ((MapEntry) r8).getMetadata();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMutableMapData(Object r8) {
        return ((MapField) r8).getMutableMap();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public int getSerializedSize(int r8, Object r10, Object r11) {
        return getSerializedSizeFull(r8, r10, r11);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public boolean isImmutable(Object r8) {
        return !((MapField) r8).isMutable();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object mergeFrom(Object r8, Object r10) {
        return mergeFromFull(r8, r10);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object newMapField(Object r8) {
        return MapField.newMapField((MapEntry) r8);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object toImmutable(Object r8) {
        ((MapField) r8).makeImmutable();
        return r8;
    }
}
