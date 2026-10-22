package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ResultMetadataType extends Enum<ResultMetadataType> {
    public static final ResultMetadataType BYTE_SEGMENTS = null;
    public static final ResultMetadataType ERROR_CORRECTION_LEVEL = null;
    public static final ResultMetadataType ISSUE_NUMBER = null;
    public static final ResultMetadataType ORIENTATION = null;
    public static final ResultMetadataType OTHER = null;
    public static final ResultMetadataType PDF417_EXTRA_METADATA = null;
    public static final ResultMetadataType POSSIBLE_COUNTRY = null;
    public static final ResultMetadataType STRUCTURED_APPEND_PARITY = null;
    public static final ResultMetadataType STRUCTURED_APPEND_SEQUENCE = null;
    public static final ResultMetadataType SUGGESTED_PRICE = null;
    public static final ResultMetadataType UPC_EAN_EXTENSION = null;
    public static final /* synthetic */ ResultMetadataType[] a = null;

    static {
        ResultMetadataType r0 = new ResultMetadataType("OTHER", 0);
        OTHER = r0;
        ResultMetadataType r1 = new ResultMetadataType("ORIENTATION", 1);
        ORIENTATION = r1;
        ResultMetadataType r3 = new ResultMetadataType("BYTE_SEGMENTS", 2);
        BYTE_SEGMENTS = r3;
        ResultMetadataType r5 = new ResultMetadataType("ERROR_CORRECTION_LEVEL", 3);
        ERROR_CORRECTION_LEVEL = r5;
        ResultMetadataType r7 = new ResultMetadataType("ISSUE_NUMBER", 4);
        ISSUE_NUMBER = r7;
        ResultMetadataType r9 = new ResultMetadataType("SUGGESTED_PRICE", 5);
        SUGGESTED_PRICE = r9;
        ResultMetadataType r11 = new ResultMetadataType("POSSIBLE_COUNTRY", 6);
        POSSIBLE_COUNTRY = r11;
        ResultMetadataType r13 = new ResultMetadataType("UPC_EAN_EXTENSION", 7);
        UPC_EAN_EXTENSION = r13;
        ResultMetadataType r15 = new ResultMetadataType("PDF417_EXTRA_METADATA", 8);
        PDF417_EXTRA_METADATA = r15;
        ResultMetadataType r14 = new ResultMetadataType("STRUCTURED_APPEND_SEQUENCE", 9);
        STRUCTURED_APPEND_SEQUENCE = r14;
        ResultMetadataType r12 = new ResultMetadataType("STRUCTURED_APPEND_PARITY", 10);
        STRUCTURED_APPEND_PARITY = r12;
        a = new ResultMetadataType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
    }

    public static ResultMetadataType[] values() {
        return (ResultMetadataType[]) a.clone();
    }

    public static ResultMetadataType valueOf(String r1) {
        return (ResultMetadataType) r27.a.a(ResultMetadataType.class, r1);
    }

    public ResultMetadataType(String r1, int r2) {
        super(r1, r2);
    }
}
