package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum BlockitEnv extends Enum<BlockitEnv> {
    public static final BlockitEnv BOE = null;
    public static final BlockitEnv ONLINE = null;
    public static final BlockitEnv PRE_RELEASE = null;
    public static final BlockitEnv STAGING = null;
    public static final /* synthetic */ BlockitEnv[] a = null;
    private int value;

    static {
        BlockitEnv r0 = new BlockitEnv("ONLINE", 0, 0);
        ONLINE = r0;
        BlockitEnv r1 = new BlockitEnv("PRE_RELEASE", 1, 1);
        PRE_RELEASE = r1;
        BlockitEnv r3 = new BlockitEnv("STAGING", 2, 2);
        STAGING = r3;
        BlockitEnv r5 = new BlockitEnv("BOE", 3, 3);
        BOE = r5;
        a = new BlockitEnv[]{r0, r1, r3, r5};
    }

    public static BlockitEnv[] values() {
        return (BlockitEnv[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static BlockitEnv forNumber(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return BOE;
    L14:
        return STAGING;
    L16:
        return PRE_RELEASE;
    L18:
        return ONLINE;
    }

    public static BlockitEnv valueOf(String r1) {
        return (BlockitEnv) r27.a.a(BlockitEnv.class, r1);
    }

    public static BlockitEnv valueOf(int r0) {
        return forNumber(r0);
    }

    public BlockitEnv(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
