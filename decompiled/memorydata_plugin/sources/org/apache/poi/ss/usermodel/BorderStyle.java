package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum BorderStyle extends Enum<BorderStyle> {
    private static final /* synthetic */ BorderStyle[] $VALUES = null;
    public static final BorderStyle DASHED = null;
    public static final BorderStyle DASH_DOT = null;
    public static final BorderStyle DASH_DOT_DOT = null;
    public static final BorderStyle DOTTED = null;
    public static final BorderStyle DOUBLE = null;
    public static final BorderStyle HAIR = null;
    public static final BorderStyle MEDIUM = null;
    public static final BorderStyle MEDIUM_DASHED = null;
    public static final BorderStyle MEDIUM_DASH_DOT = null;
    public static final BorderStyle MEDIUM_DASH_DOT_DOT = null;
    public static final BorderStyle NONE = null;
    public static final BorderStyle SLANTED_DASH_DOT = null;
    public static final BorderStyle THICK = null;
    public static final BorderStyle THIN = null;
    private static final BorderStyle[] _table = null;
    private final short code;

    static {
        BorderStyle r0 = new BorderStyle("NONE", 0, 0);
        NONE = r0;
        BorderStyle r1 = new BorderStyle("THIN", 1, 1);
        THIN = r1;
        BorderStyle r3 = new BorderStyle("MEDIUM", 2, 2);
        MEDIUM = r3;
        BorderStyle r5 = new BorderStyle("DASHED", 3, 3);
        DASHED = r5;
        BorderStyle r7 = new BorderStyle("DOTTED", 4, 4);
        DOTTED = r7;
        BorderStyle r9 = new BorderStyle("THICK", 5, 5);
        THICK = r9;
        BorderStyle r11 = new BorderStyle("DOUBLE", 6, 6);
        DOUBLE = r11;
        BorderStyle r13 = new BorderStyle("HAIR", 7, 7);
        HAIR = r13;
        BorderStyle r15 = new BorderStyle("MEDIUM_DASHED", 8, 8);
        MEDIUM_DASHED = r15;
        BorderStyle r14 = new BorderStyle("DASH_DOT", 9, 9);
        DASH_DOT = r14;
        BorderStyle r12 = new BorderStyle("MEDIUM_DASH_DOT", 10, 10);
        MEDIUM_DASH_DOT = r12;
        BorderStyle r10 = new BorderStyle("DASH_DOT_DOT", 11, 11);
        DASH_DOT_DOT = r10;
        BorderStyle r8 = new BorderStyle("MEDIUM_DASH_DOT_DOT", 12, 12);
        MEDIUM_DASH_DOT_DOT = r8;
        BorderStyle r6 = new BorderStyle("SLANTED_DASH_DOT", 13, 13);
        SLANTED_DASH_DOT = r6;
        $VALUES = new BorderStyle[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
        _table = new BorderStyle[14];
        BorderStyle[] r2 = values();
        int r4 = r2.length;
        int r16 = 0;
    L3:
        if (r16 >= r4) goto L5;
        BorderStyle r17 = r2[r16];
        _table[r17.getCode()] = r17;
        r16 = r16 + 1;
        goto L3
    }

    private BorderStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = (short) r3;
    }

    public static BorderStyle valueOf(String r2) {
        return (BorderStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(BorderStyle.class, r2), BorderStyle.class, "com.obric.memorydata.plugin");
    }

    public static BorderStyle valueOf(short r1) {
        return _table[r1];
    }

    public static BorderStyle[] values() {
        return (BorderStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BorderStyle[].class, "com.obric.memorydata.plugin");
    }

    public short getCode() {
        return this.code;
    }
}
