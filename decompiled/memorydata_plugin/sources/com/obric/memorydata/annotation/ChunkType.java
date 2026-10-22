package com.obric.memorydata.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/annotation/ChunkType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "PROACTIVE_MEMORY", "entityAnnotation_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ChunkType extends Enum<ChunkType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ChunkType[] $VALUES = null;
    public static final ChunkType DEFAULT = null;
    public static final ChunkType PROACTIVE_MEMORY = null;

    private static final /* synthetic */ ChunkType[] $values() {
        return new ChunkType[]{DEFAULT, PROACTIVE_MEMORY};
    }

    static {
        DEFAULT = new ChunkType("DEFAULT", 0);
        PROACTIVE_MEMORY = new ChunkType("PROACTIVE_MEMORY", 1);
        ChunkType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ChunkType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ChunkType> getEntries() {
        return $ENTRIES;
    }

    public static ChunkType valueOf(String r2) {
        return (ChunkType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChunkType.class, r2), ChunkType.class, "com.obric.memorydata.plugin");
    }

    public static ChunkType[] values() {
        return (ChunkType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChunkType[].class, "com.obric.memorydata.plugin");
    }
}
