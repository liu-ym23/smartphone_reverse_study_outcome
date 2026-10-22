package com.google.zxing;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final enum DecodeHintType extends Enum<DecodeHintType> {
    private static final /* synthetic */ DecodeHintType[] $VALUES = null;
    public static final DecodeHintType ALLOWED_EAN_EXTENSIONS = null;
    public static final DecodeHintType ALLOWED_LENGTHS = null;
    public static final DecodeHintType ALSO_INVERTED = null;
    public static final DecodeHintType ASSUME_CODE_39_CHECK_DIGIT = null;
    public static final DecodeHintType ASSUME_GS1 = null;
    public static final DecodeHintType CHARACTER_SET = null;
    public static final DecodeHintType NEED_RESULT_POINT_CALLBACK = null;
    public static final DecodeHintType OTHER = null;
    public static final DecodeHintType POSSIBLE_FORMATS = null;
    public static final DecodeHintType PURE_BARCODE = null;
    public static final DecodeHintType RETURN_CODABAR_START_END = null;
    public static final DecodeHintType TRY_HARDER = null;
    private final Class<?> valueType;

    static {
        DecodeHintType r1 = new DecodeHintType("OTHER", 0, Object.class);
        OTHER = r1;
        DecodeHintType r2 = new DecodeHintType("PURE_BARCODE", 1, Void.class);
        PURE_BARCODE = r2;
        DecodeHintType r3 = new DecodeHintType("POSSIBLE_FORMATS", 2, List.class);
        POSSIBLE_FORMATS = r3;
        DecodeHintType r5 = new DecodeHintType("TRY_HARDER", 3, Void.class);
        TRY_HARDER = r5;
        DecodeHintType r7 = new DecodeHintType("CHARACTER_SET", 4, String.class);
        CHARACTER_SET = r7;
        DecodeHintType r9 = new DecodeHintType("ALLOWED_LENGTHS", 5, int[].class);
        ALLOWED_LENGTHS = r9;
        DecodeHintType r11 = new DecodeHintType("ASSUME_CODE_39_CHECK_DIGIT", 6, Void.class);
        ASSUME_CODE_39_CHECK_DIGIT = r11;
        DecodeHintType r14 = new DecodeHintType("ASSUME_GS1", 7, Void.class);
        ASSUME_GS1 = r14;
        DecodeHintType r13 = new DecodeHintType("RETURN_CODABAR_START_END", 8, Void.class);
        RETURN_CODABAR_START_END = r13;
        DecodeHintType r12 = new DecodeHintType("NEED_RESULT_POINT_CALLBACK", 9, c.class);
        NEED_RESULT_POINT_CALLBACK = r12;
        DecodeHintType r10 = new DecodeHintType("ALLOWED_EAN_EXTENSIONS", 10, int[].class);
        ALLOWED_EAN_EXTENSIONS = r10;
        DecodeHintType r0 = new DecodeHintType("ALSO_INVERTED", 11, Void.class);
        ALSO_INVERTED = r0;
        $VALUES = new DecodeHintType[]{r1, r2, r3, r5, r7, r9, r11, r14, r13, r12, r10, r0};
    }

    private DecodeHintType(String r1, int r2, Class r3) {
        super(r1, r2);
        this.valueType = r3;
    }

    public static DecodeHintType valueOf(String r2) {
        return (DecodeHintType) ZeusTransformUtils.preCheckCast(Enum.valueOf(DecodeHintType.class, r2), DecodeHintType.class, "com.obric.memorydata.plugin");
    }

    public static DecodeHintType[] values() {
        return (DecodeHintType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DecodeHintType[].class, "com.obric.memorydata.plugin");
    }

    public Class<?> getValueType() {
        return this.valueType;
    }
}
