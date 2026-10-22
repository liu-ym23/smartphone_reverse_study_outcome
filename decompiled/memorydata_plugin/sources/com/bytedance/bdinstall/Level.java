package com.bytedance.bdinstall;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum Level extends Enum<Level> {
    private static final /* synthetic */ Level[] $VALUES = null;
    public static final Level L0 = null;
    public static final Level L1 = null;
    private final int mLevel;

    static {
        Level r0 = new Level("L0", 0, 0);
        L0 = r0;
        Level r1 = new Level("L1", 1, 1);
        L1 = r1;
        $VALUES = new Level[]{r0, r1};
    }

    private Level(String r1, int r2, int r3) {
        super(r1, r2);
        this.mLevel = r3;
    }

    public static Level valueOf(String r2) {
        return (Level) ZeusTransformUtils.preCheckCast(Enum.valueOf(Level.class, r2), Level.class, "com.obric.memorydata.plugin");
    }

    public static Level[] values() {
        return (Level[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Level[].class, "com.obric.memorydata.plugin");
    }

    public int value() {
        return this.mLevel;
    }
}
