package com.google.zxing;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum EncodeHintType extends Enum<EncodeHintType> {
    private static final /* synthetic */ EncodeHintType[] $VALUES = null;
    public static final EncodeHintType AZTEC_LAYERS = null;
    public static final EncodeHintType CHARACTER_SET = null;
    public static final EncodeHintType CODE128_COMPACT = null;
    public static final EncodeHintType DATA_MATRIX_COMPACT = null;
    public static final EncodeHintType DATA_MATRIX_SHAPE = null;
    public static final EncodeHintType ERROR_CORRECTION = null;
    public static final EncodeHintType FORCE_C40 = null;
    public static final EncodeHintType FORCE_CODE_SET = null;
    public static final EncodeHintType GS1_FORMAT = null;
    public static final EncodeHintType MARGIN = null;

    @Deprecated
    public static final EncodeHintType MAX_SIZE = null;

    @Deprecated
    public static final EncodeHintType MIN_SIZE = null;
    public static final EncodeHintType PDF417_AUTO_ECI = null;
    public static final EncodeHintType PDF417_COMPACT = null;
    public static final EncodeHintType PDF417_COMPACTION = null;
    public static final EncodeHintType PDF417_DIMENSIONS = null;
    public static final EncodeHintType QR_COMPACT = null;
    public static final EncodeHintType QR_MASK_PATTERN = null;
    public static final EncodeHintType QR_VERSION = null;

    static {
        EncodeHintType r0 = new EncodeHintType("ERROR_CORRECTION", 0);
        ERROR_CORRECTION = r0;
        EncodeHintType r1 = new EncodeHintType("CHARACTER_SET", 1);
        CHARACTER_SET = r1;
        EncodeHintType r3 = new EncodeHintType("DATA_MATRIX_SHAPE", 2);
        DATA_MATRIX_SHAPE = r3;
        EncodeHintType r5 = new EncodeHintType("DATA_MATRIX_COMPACT", 3);
        DATA_MATRIX_COMPACT = r5;
        EncodeHintType r7 = new EncodeHintType("MIN_SIZE", 4);
        MIN_SIZE = r7;
        EncodeHintType r9 = new EncodeHintType("MAX_SIZE", 5);
        MAX_SIZE = r9;
        EncodeHintType r11 = new EncodeHintType("MARGIN", 6);
        MARGIN = r11;
        EncodeHintType r13 = new EncodeHintType("PDF417_COMPACT", 7);
        PDF417_COMPACT = r13;
        EncodeHintType r15 = new EncodeHintType("PDF417_COMPACTION", 8);
        PDF417_COMPACTION = r15;
        EncodeHintType r14 = new EncodeHintType("PDF417_DIMENSIONS", 9);
        PDF417_DIMENSIONS = r14;
        EncodeHintType r12 = new EncodeHintType("PDF417_AUTO_ECI", 10);
        PDF417_AUTO_ECI = r12;
        EncodeHintType r10 = new EncodeHintType("AZTEC_LAYERS", 11);
        AZTEC_LAYERS = r10;
        EncodeHintType r8 = new EncodeHintType("QR_VERSION", 12);
        QR_VERSION = r8;
        EncodeHintType r6 = new EncodeHintType("QR_MASK_PATTERN", 13);
        QR_MASK_PATTERN = r6;
        EncodeHintType r4 = new EncodeHintType("QR_COMPACT", 14);
        QR_COMPACT = r4;
        EncodeHintType r2 = new EncodeHintType("GS1_FORMAT", 15);
        GS1_FORMAT = r2;
        EncodeHintType r16 = new EncodeHintType("FORCE_CODE_SET", 16);
        FORCE_CODE_SET = r16;
        EncodeHintType r17 = new EncodeHintType("FORCE_C40", 17);
        FORCE_C40 = r17;
        EncodeHintType r18 = new EncodeHintType("CODE128_COMPACT", 18);
        CODE128_COMPACT = r18;
        $VALUES = new EncodeHintType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18};
    }

    private EncodeHintType(String r1, int r2) {
        super(r1, r2);
    }

    public static EncodeHintType valueOf(String r2) {
        return (EncodeHintType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EncodeHintType.class, r2), EncodeHintType.class, "com.obric.memorydata.plugin");
    }

    public static EncodeHintType[] values() {
        return (EncodeHintType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EncodeHintType[].class, "com.obric.memorydata.plugin");
    }
}
