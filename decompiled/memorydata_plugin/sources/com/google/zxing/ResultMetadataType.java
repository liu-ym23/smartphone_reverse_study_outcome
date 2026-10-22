package com.google.zxing;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum ResultMetadataType extends Enum<ResultMetadataType> {
    private static final /* synthetic */ ResultMetadataType[] $VALUES = null;
    public static final ResultMetadataType BYTE_SEGMENTS = null;
    public static final ResultMetadataType ERASURES_CORRECTED = null;
    public static final ResultMetadataType ERRORS_CORRECTED = null;
    public static final ResultMetadataType ERROR_CORRECTION_LEVEL = null;
    public static final ResultMetadataType ISSUE_NUMBER = null;
    public static final ResultMetadataType ORIENTATION = null;
    public static final ResultMetadataType OTHER = null;
    public static final ResultMetadataType PDF417_EXTRA_METADATA = null;
    public static final ResultMetadataType POSSIBLE_COUNTRY = null;
    public static final ResultMetadataType STRUCTURED_APPEND_PARITY = null;
    public static final ResultMetadataType STRUCTURED_APPEND_SEQUENCE = null;
    public static final ResultMetadataType SUGGESTED_PRICE = null;
    public static final ResultMetadataType SYMBOLOGY_IDENTIFIER = null;
    public static final ResultMetadataType UPC_EAN_EXTENSION = null;

    static {
        ResultMetadataType r0 = new ResultMetadataType("OTHER", 0);
        OTHER = r0;
        ResultMetadataType r1 = new ResultMetadataType("ORIENTATION", 1);
        ORIENTATION = r1;
        ResultMetadataType r3 = new ResultMetadataType("BYTE_SEGMENTS", 2);
        BYTE_SEGMENTS = r3;
        ResultMetadataType r5 = new ResultMetadataType("ERROR_CORRECTION_LEVEL", 3);
        ERROR_CORRECTION_LEVEL = r5;
        ResultMetadataType r7 = new ResultMetadataType("ERRORS_CORRECTED", 4);
        ERRORS_CORRECTED = r7;
        ResultMetadataType r9 = new ResultMetadataType("ERASURES_CORRECTED", 5);
        ERASURES_CORRECTED = r9;
        ResultMetadataType r11 = new ResultMetadataType("ISSUE_NUMBER", 6);
        ISSUE_NUMBER = r11;
        ResultMetadataType r13 = new ResultMetadataType("SUGGESTED_PRICE", 7);
        SUGGESTED_PRICE = r13;
        ResultMetadataType r15 = new ResultMetadataType("POSSIBLE_COUNTRY", 8);
        POSSIBLE_COUNTRY = r15;
        ResultMetadataType r14 = new ResultMetadataType("UPC_EAN_EXTENSION", 9);
        UPC_EAN_EXTENSION = r14;
        ResultMetadataType r12 = new ResultMetadataType("PDF417_EXTRA_METADATA", 10);
        PDF417_EXTRA_METADATA = r12;
        ResultMetadataType r10 = new ResultMetadataType("STRUCTURED_APPEND_SEQUENCE", 11);
        STRUCTURED_APPEND_SEQUENCE = r10;
        ResultMetadataType r8 = new ResultMetadataType("STRUCTURED_APPEND_PARITY", 12);
        STRUCTURED_APPEND_PARITY = r8;
        ResultMetadataType r6 = new ResultMetadataType("SYMBOLOGY_IDENTIFIER", 13);
        SYMBOLOGY_IDENTIFIER = r6;
        $VALUES = new ResultMetadataType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
    }

    private ResultMetadataType(String r1, int r2) {
        super(r1, r2);
    }

    public static ResultMetadataType valueOf(String r2) {
        return (ResultMetadataType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ResultMetadataType.class, r2), ResultMetadataType.class, "com.obric.memorydata.plugin");
    }

    public static ResultMetadataType[] values() {
        return (ResultMetadataType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ResultMetadataType[].class, "com.obric.memorydata.plugin");
    }
}
