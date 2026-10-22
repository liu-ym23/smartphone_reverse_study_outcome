package com.bumptech.glide;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum MemoryCategory extends Enum<MemoryCategory> {
    private static final /* synthetic */ MemoryCategory[] $VALUES = null;
    public static final MemoryCategory HIGH = null;
    public static final MemoryCategory LOW = null;
    public static final MemoryCategory NORMAL = null;
    private final float multiplier;

    private static /* synthetic */ MemoryCategory[] $values() {
        return new MemoryCategory[]{LOW, NORMAL, HIGH};
    }

    static {
        LOW = new MemoryCategory("LOW", 0, 0.5f);
        NORMAL = new MemoryCategory("NORMAL", 1, 1.0f);
        HIGH = new MemoryCategory("HIGH", 2, 1.5f);
        $VALUES = $values();
    }

    private MemoryCategory(String r1, int r2, float r3) {
        super(r1, r2);
        this.multiplier = r3;
    }

    public static MemoryCategory valueOf(String r2) {
        return (MemoryCategory) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryCategory.class, r2), MemoryCategory.class, "com.obric.memorydata.plugin");
    }

    public static MemoryCategory[] values() {
        return (MemoryCategory[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryCategory[].class, "com.obric.memorydata.plugin");
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
