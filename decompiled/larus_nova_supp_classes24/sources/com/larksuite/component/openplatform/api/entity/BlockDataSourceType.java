package com.larksuite.component.openplatform.api.entity;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum BlockDataSourceType extends Enum<BlockDataSourceType> {
    public static final BlockDataSourceType ENTITY = null;
    public static final BlockDataSourceType GUIDE_INFO = null;
    public static final /* synthetic */ BlockDataSourceType[] a = null;
    public String type;

    static {
        BlockDataSourceType r0 = new BlockDataSourceType("ENTITY", 0, "entity");
        ENTITY = r0;
        BlockDataSourceType r1 = new BlockDataSourceType("GUIDE_INFO", 1, "guideInfo");
        GUIDE_INFO = r1;
        a = new BlockDataSourceType[]{r0, r1};
    }

    public static BlockDataSourceType[] values() {
        return (BlockDataSourceType[]) a.clone();
    }

    public static BlockDataSourceType valueOf(String r1) {
        return (BlockDataSourceType) a.a(BlockDataSourceType.class, r1);
    }

    public BlockDataSourceType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
