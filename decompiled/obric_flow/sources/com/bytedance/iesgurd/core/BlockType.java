package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/iesgurd/core/BlockType;", "", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum BlockType extends Enum<BlockType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BlockType f6596b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BlockType f6597c = null;
    public static final BlockType d = null;
    public static final /* synthetic */ BlockType[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6598a;

    static {
        BlockType r5 = new BlockType("LAZY_UPDATE", 0, 1);
        f6596b = r5;
        BlockType r10 = new BlockType("CLEAN_BLOCKLIST", 1, 2);
        BlockType r11 = new BlockType("LOW_STORAGE", 2, 3);
        f6597c = r11;
        BlockType r12 = new BlockType("OCCASION_UPDATE", 3, 4);
        d = r12;
        e = new BlockType[]{r5, r10, r11, r12};
    }

    public BlockType(String r5, int r10, int r11) {
        super(r5, r10);
        this.f6598a = r11;
    }

    public static BlockType valueOf(String r5) {
        return (BlockType) Enum.valueOf(BlockType.class, r5);
    }

    public static BlockType[] values() {
        return (BlockType[]) e.clone();
    }
}
