package com.obric.memorydata.markdown.stream;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/markdown/stream/BlockType;", "", "<init>", "(Ljava/lang/String;I)V", "TABLE", "CODE_BLOCK", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum BlockType extends Enum<BlockType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BlockType[] $VALUES = null;
    public static final BlockType CODE_BLOCK = null;
    public static final BlockType TABLE = null;

    private static final /* synthetic */ BlockType[] $values() {
        return new BlockType[]{TABLE, CODE_BLOCK};
    }

    static {
        TABLE = new BlockType("TABLE", 0);
        CODE_BLOCK = new BlockType("CODE_BLOCK", 1);
        BlockType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private BlockType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<BlockType> getEntries() {
        return $ENTRIES;
    }

    public static BlockType valueOf(String r2) {
        return (BlockType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BlockType.class, r2), BlockType.class, "com.obric.memorydata.plugin");
    }

    public static BlockType[] values() {
        return (BlockType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BlockType[].class, "com.obric.memorydata.plugin");
    }
}
