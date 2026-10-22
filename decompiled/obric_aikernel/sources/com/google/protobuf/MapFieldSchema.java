package com.google.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
interface MapFieldSchema {
    Map<?, ?> forMapData(Object r10);

    MapEntryLite.Metadata<?, ?> forMapMetadata(Object r10);

    Map<?, ?> forMutableMapData(Object r10);

    int getSerializedSize(int r10, Object r11, Object r12);

    boolean isImmutable(Object r10);

    @CanIgnoreReturnValue
    Object mergeFrom(Object r10, Object r11);

    Object newMapField(Object r10);

    Object toImmutable(Object r10);
}
