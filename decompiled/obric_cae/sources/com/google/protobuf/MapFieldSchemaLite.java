package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class MapFieldSchemaLite implements MapFieldSchema {
    public MapFieldSchemaLite() {
    }

    private static <K, V> int getSerializedSizeLite(int r8, Object r10, Object r11) {
        MapFieldLite r12 = (MapFieldLite) r10;
        MapEntryLite r13 = (MapEntryLite) r11;
        int r14 = 0;
        if (r12.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<K, V>> r15 = r12.entrySet().iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        Map.Entry<K, V> r16 = r15.next();
        r14 = r14 + r13.computeMessageSize(r8, r16.getKey(), r16.getValue());
        goto L7
    L9:
        return r14;
    }

    private static <K, V> MapFieldLite<K, V> mergeFromLite(Object r8, Object r10) {
        MapFieldLite<K, V> r11 = (MapFieldLite) r8;
        MapFieldLite<K, V> r12 = (MapFieldLite) r10;
        if (r12.isEmpty() == false) goto L5;
    L8:
        return r11;
    L5:
        if (r11.isMutable() == true) goto L7;
        r11 = r11.mutableCopy();
    L7:
        r11.mergeFrom(r12);
        goto L8
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMapData(Object r8) {
        return (MapFieldLite) r8;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object r8) {
        return ((MapEntryLite) r8).getMetadata();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMutableMapData(Object r8) {
        return (MapFieldLite) r8;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public int getSerializedSize(int r8, Object r10, Object r11) {
        return getSerializedSizeLite(r8, r10, r11);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public boolean isImmutable(Object r8) {
        return !((MapFieldLite) r8).isMutable();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object mergeFrom(Object r8, Object r10) {
        return mergeFromLite(r8, r10);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object newMapField(Object r8) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object toImmutable(Object r8) {
        ((MapFieldLite) r8).makeImmutable();
        return r8;
    }
}
