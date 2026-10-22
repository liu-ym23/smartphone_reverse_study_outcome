package com.bytedance.ies.abmock;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/abmock/ChunkUpdateType;", "", "(Ljava/lang/String;I)V", "CHUNK_ALL_UPDATE", "CHUNK_INCREMENT_UPDATE", "GET_ALL_UPDATE", "POST_ALL_UPDATE", "POST_INCREMENT_UPDATE", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ChunkUpdateType extends Enum<ChunkUpdateType> {
    private static final /* synthetic */ ChunkUpdateType[] $VALUES = null;
    public static final ChunkUpdateType CHUNK_ALL_UPDATE = null;
    public static final ChunkUpdateType CHUNK_INCREMENT_UPDATE = null;
    public static final ChunkUpdateType GET_ALL_UPDATE = null;
    public static final ChunkUpdateType POST_ALL_UPDATE = null;
    public static final ChunkUpdateType POST_INCREMENT_UPDATE = null;

    private static final /* synthetic */ ChunkUpdateType[] $values() {
        return new ChunkUpdateType[]{CHUNK_ALL_UPDATE, CHUNK_INCREMENT_UPDATE, GET_ALL_UPDATE, POST_ALL_UPDATE, POST_INCREMENT_UPDATE};
    }

    static {
        CHUNK_ALL_UPDATE = new ChunkUpdateType("CHUNK_ALL_UPDATE", 0);
        CHUNK_INCREMENT_UPDATE = new ChunkUpdateType("CHUNK_INCREMENT_UPDATE", 1);
        GET_ALL_UPDATE = new ChunkUpdateType("GET_ALL_UPDATE", 2);
        POST_ALL_UPDATE = new ChunkUpdateType("POST_ALL_UPDATE", 3);
        POST_INCREMENT_UPDATE = new ChunkUpdateType("POST_INCREMENT_UPDATE", 4);
        $VALUES = $values();
    }

    private ChunkUpdateType(String r1, int r2) {
        super(r1, r2);
    }

    public static ChunkUpdateType valueOf(String r2) {
        return (ChunkUpdateType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChunkUpdateType.class, r2), ChunkUpdateType.class, "com.obric.memorydata.plugin");
    }

    public static ChunkUpdateType[] values() {
        return (ChunkUpdateType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChunkUpdateType[].class, "com.obric.memorydata.plugin");
    }
}
