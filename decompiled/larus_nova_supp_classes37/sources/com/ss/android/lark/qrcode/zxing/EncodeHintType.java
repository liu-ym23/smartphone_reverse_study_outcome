package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum EncodeHintType extends Enum<EncodeHintType> {
    public static final EncodeHintType AZTEC_LAYERS = null;
    public static final EncodeHintType CHARACTER_SET = null;
    public static final EncodeHintType DATA_MATRIX_SHAPE = null;
    public static final EncodeHintType ERROR_CORRECTION = null;
    public static final EncodeHintType GS1_FORMAT = null;
    public static final EncodeHintType MARGIN = null;
    public static final EncodeHintType MAX_SIZE = null;
    public static final EncodeHintType MIN_SIZE = null;
    public static final EncodeHintType PDF417_COMPACT = null;
    public static final EncodeHintType PDF417_COMPACTION = null;
    public static final EncodeHintType PDF417_DIMENSIONS = null;
    public static final EncodeHintType QR_VERSION = null;
    public static final /* synthetic */ EncodeHintType[] a = null;

    static {
        EncodeHintType r0 = new EncodeHintType("ERROR_CORRECTION", 0);
        ERROR_CORRECTION = r0;
        EncodeHintType r1 = new EncodeHintType("CHARACTER_SET", 1);
        CHARACTER_SET = r1;
        EncodeHintType r3 = new EncodeHintType("DATA_MATRIX_SHAPE", 2);
        DATA_MATRIX_SHAPE = r3;
        EncodeHintType r5 = new EncodeHintType("MIN_SIZE", 3);
        MIN_SIZE = r5;
        EncodeHintType r7 = new EncodeHintType("MAX_SIZE", 4);
        MAX_SIZE = r7;
        EncodeHintType r9 = new EncodeHintType("MARGIN", 5);
        MARGIN = r9;
        EncodeHintType r11 = new EncodeHintType("PDF417_COMPACT", 6);
        PDF417_COMPACT = r11;
        EncodeHintType r13 = new EncodeHintType("PDF417_COMPACTION", 7);
        PDF417_COMPACTION = r13;
        EncodeHintType r15 = new EncodeHintType("PDF417_DIMENSIONS", 8);
        PDF417_DIMENSIONS = r15;
        EncodeHintType r14 = new EncodeHintType("AZTEC_LAYERS", 9);
        AZTEC_LAYERS = r14;
        EncodeHintType r12 = new EncodeHintType("QR_VERSION", 10);
        QR_VERSION = r12;
        EncodeHintType r10 = new EncodeHintType("GS1_FORMAT", 11);
        GS1_FORMAT = r10;
        a = new EncodeHintType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
    }

    public static EncodeHintType[] values() {
        return (EncodeHintType[]) a.clone();
    }

    public static EncodeHintType valueOf(String r1) {
        return (EncodeHintType) r27.a.a(EncodeHintType.class, r1);
    }

    public EncodeHintType(String r1, int r2) {
        super(r1, r2);
    }
}
