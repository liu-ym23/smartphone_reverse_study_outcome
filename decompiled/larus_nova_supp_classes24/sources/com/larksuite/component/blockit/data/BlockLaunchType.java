package com.larksuite.component.blockit.data;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum BlockLaunchType extends Enum<BlockLaunchType> {
    public static final BlockLaunchType ENTITY = null;
    public static final BlockLaunchType ID = null;
    public static final /* synthetic */ BlockLaunchType[] a = null;

    static {
        BlockLaunchType r0 = new BlockLaunchType("ENTITY", 0);
        ENTITY = r0;
        BlockLaunchType r1 = new BlockLaunchType("ID", 1);
        ID = r1;
        a = new BlockLaunchType[]{r0, r1};
    }

    public static BlockLaunchType[] values() {
        return (BlockLaunchType[]) a.clone();
    }

    public static BlockLaunchType valueOf(String r1) {
        return (BlockLaunchType) a.a(BlockLaunchType.class, r1);
    }

    public BlockLaunchType(String r1, int r2) {
        super(r1, r2);
    }
}
