package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MapFieldSchemaLite implements MapFieldSchema {
    MapFieldSchemaLite() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> int getSerializedSizeLite(int r4, Object r5, Object r6) {
        MapFieldLite r7 = (MapFieldLite) ZeusTransformUtils.preCheckCast(r5, MapFieldLite.class, "com.obric.memorydata.plugin");
        MapEntryLite r8 = (MapEntryLite) ZeusTransformUtils.preCheckCast(r6, MapEntryLite.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (r7.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<K, V>> r9 = r7.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r2 = r2 + r8.computeMessageSize(r4, r0.getKey(), r0.getValue());
        goto L7
    L9:
        return r2;
    }

    private static <K, V> MapFieldLite<K, V> mergeFromLite(Object r2, Object r3) {
        MapFieldLite<K, V> r4 = (MapFieldLite) ZeusTransformUtils.preCheckCast(r2, MapFieldLite.class, "com.obric.memorydata.plugin");
        MapFieldLite<K, V> r5 = (MapFieldLite) ZeusTransformUtils.preCheckCast(r3, MapFieldLite.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L5;
    L8:
        return r4;
    L5:
        if (r4.isMutable() == true) goto L7;
        r4 = r4.mutableCopy();
    L7:
        r4.mergeFrom(r5);
        goto L8
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMapData(Object r2) {
        return (MapFieldLite) ZeusTransformUtils.preCheckCast(r2, MapFieldLite.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MapFieldSchema
    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object r2) {
        return ((MapEntryLite) ZeusTransformUtils.preCheckCast(r2, MapEntryLite.class, "com.obric.memorydata.plugin")).getMetadata();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMutableMapData(Object r2) {
        return (MapFieldLite) ZeusTransformUtils.preCheckCast(r2, MapFieldLite.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MapFieldSchema
    public int getSerializedSize(int r1, Object r2, Object r3) {
        return getSerializedSizeLite(r1, r2, r3);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public boolean isImmutable(Object r2) {
        return !((MapFieldLite) ZeusTransformUtils.preCheckCast(r2, MapFieldLite.class, "com.obric.memorydata.plugin")).isMutable();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object mergeFrom(Object r1, Object r2) {
        return mergeFromLite(r1, r2);
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object newMapField(Object r1) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object toImmutable(Object r2) {
        ((MapFieldLite) ZeusTransformUtils.preCheckCast(r2, MapFieldLite.class, "com.obric.memorydata.plugin")).makeImmutable();
        return r2;
    }
}
