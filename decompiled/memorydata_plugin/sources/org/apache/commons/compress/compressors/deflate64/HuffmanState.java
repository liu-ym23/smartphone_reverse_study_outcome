package org.apache.commons.compress.compressors.deflate64;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final enum HuffmanState extends Enum<HuffmanState> {
    private static final /* synthetic */ HuffmanState[] $VALUES = null;
    public static final HuffmanState DYNAMIC_CODES = null;
    public static final HuffmanState FIXED_CODES = null;
    public static final HuffmanState INITIAL = null;
    public static final HuffmanState STORED = null;

    static {
        HuffmanState r0 = new HuffmanState("INITIAL", 0);
        INITIAL = r0;
        HuffmanState r1 = new HuffmanState("STORED", 1);
        STORED = r1;
        HuffmanState r3 = new HuffmanState("DYNAMIC_CODES", 2);
        DYNAMIC_CODES = r3;
        HuffmanState r5 = new HuffmanState("FIXED_CODES", 3);
        FIXED_CODES = r5;
        $VALUES = new HuffmanState[]{r0, r1, r3, r5};
    }

    private HuffmanState(String r1, int r2) {
        super(r1, r2);
    }

    public static HuffmanState valueOf(String r2) {
        return (HuffmanState) ZeusTransformUtils.preCheckCast(Enum.valueOf(HuffmanState.class, r2), HuffmanState.class, "com.obric.memorydata.plugin");
    }

    public static HuffmanState[] values() {
        return (HuffmanState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HuffmanState[].class, "com.obric.memorydata.plugin");
    }
}
