package com.google.zxing.pdf417.encoder;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum Compaction extends Enum<Compaction> {
    private static final /* synthetic */ Compaction[] $VALUES = null;
    public static final Compaction AUTO = null;
    public static final Compaction BYTE = null;
    public static final Compaction NUMERIC = null;
    public static final Compaction TEXT = null;

    static {
        Compaction r0 = new Compaction("AUTO", 0);
        AUTO = r0;
        Compaction r1 = new Compaction("TEXT", 1);
        TEXT = r1;
        Compaction r3 = new Compaction("BYTE", 2);
        BYTE = r3;
        Compaction r5 = new Compaction("NUMERIC", 3);
        NUMERIC = r5;
        $VALUES = new Compaction[]{r0, r1, r3, r5};
    }

    private Compaction(String r1, int r2) {
        super(r1, r2);
    }

    public static Compaction valueOf(String r2) {
        return (Compaction) ZeusTransformUtils.preCheckCast(Enum.valueOf(Compaction.class, r2), Compaction.class, "com.obric.memorydata.plugin");
    }

    public static Compaction[] values() {
        return (Compaction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Compaction[].class, "com.obric.memorydata.plugin");
    }
}
