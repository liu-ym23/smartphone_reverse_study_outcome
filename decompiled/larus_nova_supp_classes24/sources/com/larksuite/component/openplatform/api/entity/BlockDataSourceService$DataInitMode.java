package com.larksuite.component.openplatform.api.entity;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum BlockDataSourceService$DataInitMode extends Enum<BlockDataSourceService$DataInitMode> {
    public static final BlockDataSourceService$DataInitMode LAZY_EVERY = null;
    public static final BlockDataSourceService$DataInitMode LAZY_ONCE = null;
    public static final /* synthetic */ BlockDataSourceService$DataInitMode[] a = null;

    static {
        BlockDataSourceService$DataInitMode r0 = new BlockDataSourceService$DataInitMode("LAZY_ONCE", 0);
        LAZY_ONCE = r0;
        BlockDataSourceService$DataInitMode r1 = new BlockDataSourceService$DataInitMode("LAZY_EVERY", 1);
        LAZY_EVERY = r1;
        a = new BlockDataSourceService$DataInitMode[]{r0, r1};
    }

    public static BlockDataSourceService$DataInitMode[] values() {
        return (BlockDataSourceService$DataInitMode[]) a.clone();
    }

    public static BlockDataSourceService$DataInitMode valueOf(String r1) {
        return (BlockDataSourceService$DataInitMode) a.a(BlockDataSourceService$DataInitMode.class, r1);
    }

    public BlockDataSourceService$DataInitMode(String r1, int r2) {
        super(r1, r2);
    }
}
