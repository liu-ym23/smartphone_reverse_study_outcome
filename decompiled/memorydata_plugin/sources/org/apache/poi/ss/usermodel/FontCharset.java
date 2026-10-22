package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final enum FontCharset extends Enum<FontCharset> {
    private static final /* synthetic */ FontCharset[] $VALUES = null;
    public static final FontCharset ANSI = null;
    public static final FontCharset ARABIC = null;
    public static final FontCharset BALTIC = null;
    public static final FontCharset CHINESEBIG5 = null;
    public static final FontCharset DEFAULT = null;
    public static final FontCharset EASTEUROPE = null;
    public static final FontCharset GB2312 = null;
    public static final FontCharset GREEK = null;
    public static final FontCharset HANGEUL = null;
    public static final FontCharset HEBREW = null;
    public static final FontCharset JOHAB = null;
    public static final FontCharset MAC = null;
    public static final FontCharset OEM = null;
    public static final FontCharset RUSSIAN = null;
    public static final FontCharset SHIFTJIS = null;
    public static final FontCharset SYMBOL = null;
    public static final FontCharset THAI = null;
    public static final FontCharset TURKISH = null;
    public static final FontCharset VIETNAMESE = null;
    private static FontCharset[] _table;
    private int charset;

    static {
        FontCharset r0 = new FontCharset("ANSI", 0, 0);
        ANSI = r0;
        FontCharset r1 = new FontCharset("DEFAULT", 1, 1);
        DEFAULT = r1;
        FontCharset r3 = new FontCharset("SYMBOL", 2, 2);
        SYMBOL = r3;
        FontCharset r5 = new FontCharset("MAC", 3, 77);
        MAC = r5;
        FontCharset r7 = new FontCharset("SHIFTJIS", 4, 128);
        SHIFTJIS = r7;
        FontCharset r9 = new FontCharset("HANGEUL", 5, 129);
        HANGEUL = r9;
        FontCharset r11 = new FontCharset("JOHAB", 6, 130);
        JOHAB = r11;
        FontCharset r13 = new FontCharset("GB2312", 7, 134);
        GB2312 = r13;
        FontCharset r12 = new FontCharset("CHINESEBIG5", 8, 136);
        CHINESEBIG5 = r12;
        FontCharset r10 = new FontCharset("GREEK", 9, 161);
        GREEK = r10;
        FontCharset r8 = new FontCharset("TURKISH", 10, 162);
        TURKISH = r8;
        FontCharset r6 = new FontCharset("VIETNAMESE", 11, 163);
        VIETNAMESE = r6;
        FontCharset r4 = new FontCharset("HEBREW", 12, 177);
        HEBREW = r4;
        FontCharset r2 = new FontCharset("ARABIC", 13, 178);
        ARABIC = r2;
        FontCharset r14 = new FontCharset("BALTIC", 14, 186);
        BALTIC = r14;
        FontCharset r15 = new FontCharset("RUSSIAN", 15, 204);
        RUSSIAN = r15;
        FontCharset r16 = new FontCharset("THAI", 16, 222);
        THAI = r16;
        FontCharset r17 = new FontCharset("EASTEUROPE", 17, 238);
        EASTEUROPE = r17;
        FontCharset r18 = new FontCharset("OEM", 18, 255);
        OEM = r18;
        $VALUES = new FontCharset[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14, r15, r16, r17, r18};
        _table = new FontCharset[256];
        FontCharset[] r19 = values();
        int r20 = r19.length;
        int r21 = 0;
    L3:
        if (r21 >= r20) goto L5;
        FontCharset r22 = r19[r21];
        _table[r22.getValue()] = r22;
        r21 = r21 + 1;
        goto L3
    }

    private FontCharset(String r1, int r2, int r3) {
        super(r1, r2);
        this.charset = r3;
    }

    public static FontCharset valueOf(int r2) {
        FontCharset[] r0 = _table;
        if (r2 < r0.length) goto L7;
        return null;
    L7:
        return r0[r2];
    }

    public static FontCharset valueOf(String r2) {
        return (FontCharset) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontCharset.class, r2), FontCharset.class, "com.obric.memorydata.plugin");
    }

    public static FontCharset[] values() {
        return (FontCharset[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontCharset[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.charset;
    }
}
