package com.bytedance.ies.abmock;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/abmock/ChunkPriorityType;", "", "(Ljava/lang/String;I)V", "HIGH_PRIORITY_DATA", "ALL_DATA", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ChunkPriorityType extends Enum<ChunkPriorityType> {
    private static final /* synthetic */ ChunkPriorityType[] $VALUES = null;
    public static final ChunkPriorityType ALL_DATA = null;
    public static final ChunkPriorityType HIGH_PRIORITY_DATA = null;

    private static final /* synthetic */ ChunkPriorityType[] $values() {
        return new ChunkPriorityType[]{HIGH_PRIORITY_DATA, ALL_DATA};
    }

    static {
        HIGH_PRIORITY_DATA = new ChunkPriorityType("HIGH_PRIORITY_DATA", 0);
        ALL_DATA = new ChunkPriorityType("ALL_DATA", 1);
        $VALUES = $values();
    }

    private ChunkPriorityType(String r1, int r2) {
        super(r1, r2);
    }

    public static ChunkPriorityType valueOf(String r2) {
        return (ChunkPriorityType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChunkPriorityType.class, r2), ChunkPriorityType.class, "com.obric.memorydata.plugin");
    }

    public static ChunkPriorityType[] values() {
        return (ChunkPriorityType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChunkPriorityType[].class, "com.obric.memorydata.plugin");
    }
}
