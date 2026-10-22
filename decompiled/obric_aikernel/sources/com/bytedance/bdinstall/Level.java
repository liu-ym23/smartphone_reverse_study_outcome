package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes.dex */
public final enum Level extends Enum<Level> {
    private static final /* synthetic */ Level[] $VALUES = null;
    public static final Level L0 = null;
    public static final Level L1 = null;
    private final int mLevel;

    static {
        Level r10 = new Level("L0", 0, 0);
        L0 = r10;
        Level r11 = new Level("L1", 1, 1);
        L1 = r11;
        $VALUES = new Level[]{r10, r11};
    }

    private Level(String r10, int r11, int r12) {
        super(r10, r11);
        this.mLevel = r12;
    }

    public static Level valueOf(String r10) {
        return (Level) Enum.valueOf(Level.class, r10);
    }

    public static Level[] values() {
        return (Level[]) $VALUES.clone();
    }

    public int value() {
        return this.mLevel;
    }
}
