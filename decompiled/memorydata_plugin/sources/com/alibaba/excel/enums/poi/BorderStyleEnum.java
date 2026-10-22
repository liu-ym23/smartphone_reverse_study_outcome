package com.alibaba.excel.enums.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.BorderStyle;

/* JADX INFO: loaded from: classes.dex */
public final enum BorderStyleEnum extends Enum<BorderStyleEnum> {
    private static final /* synthetic */ BorderStyleEnum[] $VALUES = null;
    public static final BorderStyleEnum DASHED = null;
    public static final BorderStyleEnum DASH_DOT = null;
    public static final BorderStyleEnum DASH_DOT_DOT = null;
    public static final BorderStyleEnum DEFAULT = null;
    public static final BorderStyleEnum DOTTED = null;
    public static final BorderStyleEnum DOUBLE = null;
    public static final BorderStyleEnum HAIR = null;
    public static final BorderStyleEnum MEDIUM = null;
    public static final BorderStyleEnum MEDIUM_DASHED = null;
    public static final BorderStyleEnum MEDIUM_DASH_DOT = null;
    public static final BorderStyleEnum MEDIUM_DASH_DOT_DOT = null;
    public static final BorderStyleEnum NONE = null;
    public static final BorderStyleEnum SLANTED_DASH_DOT = null;
    public static final BorderStyleEnum THICK = null;
    public static final BorderStyleEnum THIN = null;
    BorderStyle poiBorderStyle;

    static {
        BorderStyleEnum r0 = new BorderStyleEnum("DEFAULT", 0, null);
        DEFAULT = r0;
        BorderStyleEnum r1 = new BorderStyleEnum("NONE", 1, BorderStyle.NONE);
        NONE = r1;
        BorderStyleEnum r3 = new BorderStyleEnum("THIN", 2, BorderStyle.THIN);
        THIN = r3;
        BorderStyleEnum r4 = new BorderStyleEnum("MEDIUM", 3, BorderStyle.MEDIUM);
        MEDIUM = r4;
        BorderStyleEnum r6 = new BorderStyleEnum("DASHED", 4, BorderStyle.DASHED);
        DASHED = r6;
        BorderStyleEnum r8 = new BorderStyleEnum("DOTTED", 5, BorderStyle.DOTTED);
        DOTTED = r8;
        BorderStyleEnum r10 = new BorderStyleEnum("THICK", 6, BorderStyle.THICK);
        THICK = r10;
        BorderStyleEnum r12 = new BorderStyleEnum("DOUBLE", 7, BorderStyle.DOUBLE);
        DOUBLE = r12;
        BorderStyleEnum r14 = new BorderStyleEnum("HAIR", 8, BorderStyle.HAIR);
        HAIR = r14;
        BorderStyleEnum r13 = new BorderStyleEnum("MEDIUM_DASHED", 9, BorderStyle.MEDIUM_DASHED);
        MEDIUM_DASHED = r13;
        BorderStyleEnum r11 = new BorderStyleEnum("DASH_DOT", 10, BorderStyle.DASH_DOT);
        DASH_DOT = r11;
        BorderStyleEnum r9 = new BorderStyleEnum("MEDIUM_DASH_DOT", 11, BorderStyle.MEDIUM_DASH_DOT);
        MEDIUM_DASH_DOT = r9;
        BorderStyleEnum r7 = new BorderStyleEnum("DASH_DOT_DOT", 12, BorderStyle.DASH_DOT_DOT);
        DASH_DOT_DOT = r7;
        BorderStyleEnum r5 = new BorderStyleEnum("MEDIUM_DASH_DOT_DOT", 13, BorderStyle.MEDIUM_DASH_DOT_DOT);
        MEDIUM_DASH_DOT_DOT = r5;
        BorderStyleEnum r2 = new BorderStyleEnum("SLANTED_DASH_DOT", 14, BorderStyle.SLANTED_DASH_DOT);
        SLANTED_DASH_DOT = r2;
        $VALUES = new BorderStyleEnum[]{r0, r1, r3, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r2};
    }

    private BorderStyleEnum(String r1, int r2, BorderStyle r3) {
        super(r1, r2);
        this.poiBorderStyle = r3;
    }

    public static BorderStyleEnum valueOf(String r2) {
        return (BorderStyleEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(BorderStyleEnum.class, r2), BorderStyleEnum.class, "com.obric.memorydata.plugin");
    }

    public static BorderStyleEnum[] values() {
        return (BorderStyleEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BorderStyleEnum[].class, "com.obric.memorydata.plugin");
    }

    public BorderStyle getPoiBorderStyle() {
        return this.poiBorderStyle;
    }
}
