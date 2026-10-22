package com.bumptech.glide;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum Priority extends Enum<Priority> {
    private static final /* synthetic */ Priority[] $VALUES = null;
    public static final Priority HIGH = null;
    public static final Priority IMMEDIATE = null;
    public static final Priority LOW = null;
    public static final Priority NORMAL = null;

    private static /* synthetic */ Priority[] $values() {
        return new Priority[]{IMMEDIATE, HIGH, NORMAL, LOW};
    }

    static {
        IMMEDIATE = new Priority("IMMEDIATE", 0);
        HIGH = new Priority("HIGH", 1);
        NORMAL = new Priority("NORMAL", 2);
        LOW = new Priority("LOW", 3);
        $VALUES = $values();
    }

    private Priority(String r1, int r2) {
        super(r1, r2);
    }

    public static Priority valueOf(String r2) {
        return (Priority) ZeusTransformUtils.preCheckCast(Enum.valueOf(Priority.class, r2), Priority.class, "com.obric.memorydata.plugin");
    }

    public static Priority[] values() {
        return (Priority[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Priority[].class, "com.obric.memorydata.plugin");
    }
}
