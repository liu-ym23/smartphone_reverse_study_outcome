package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
public final enum MemoryCategory extends Enum<MemoryCategory> {
    public static final MemoryCategory HIGH = null;
    public static final MemoryCategory LOW = null;
    public static final MemoryCategory NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MemoryCategory[] f1377a = null;
    private final float multiplier;

    static {
        MemoryCategory r5 = new MemoryCategory(0, "LOW", 0.5f);
        LOW = r5;
        MemoryCategory r10 = new MemoryCategory(1, "NORMAL", 1.0f);
        NORMAL = r10;
        MemoryCategory r11 = new MemoryCategory(2, "HIGH", 1.5f);
        HIGH = r11;
        f1377a = new MemoryCategory[]{r5, r10, r11};
    }

    public MemoryCategory(int r5, String r10, float r11) {
        super(r10, r5);
        this.multiplier = r11;
    }

    public static MemoryCategory valueOf(String r5) {
        return (MemoryCategory) Enum.valueOf(MemoryCategory.class, r5);
    }

    public static MemoryCategory[] values() {
        return (MemoryCategory[]) f1377a.clone();
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
