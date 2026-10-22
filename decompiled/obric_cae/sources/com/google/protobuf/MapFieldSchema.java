package com.google.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface MapFieldSchema {
    Map<?, ?> forMapData(Object r8);

    MapEntryLite.Metadata<?, ?> forMapMetadata(Object r8);

    Map<?, ?> forMutableMapData(Object r8);

    int getSerializedSize(int r8, Object r10, Object r11);

    boolean isImmutable(Object r8);

    @CanIgnoreReturnValue
    Object mergeFrom(Object r8, Object r10);

    Object newMapField(Object r8);

    Object toImmutable(Object r8);
}
