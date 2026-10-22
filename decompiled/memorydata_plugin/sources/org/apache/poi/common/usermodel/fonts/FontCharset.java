package org.apache.poi.common.usermodel.fonts;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.logging.log4j.b;

/* JADX INFO: loaded from: classes4.dex */
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
    public static final FontCharset HANGUL = null;
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
    private Charset charset;
    private int nativeId;

    static {
        FontCharset r0 = new FontCharset("ANSI", 0, 0, "Cp1252");
        ANSI = r0;
        FontCharset r1 = new FontCharset("DEFAULT", 1, 1, "Cp1252");
        DEFAULT = r1;
        FontCharset r4 = new FontCharset("SYMBOL", 2, 2, "");
        SYMBOL = r4;
        FontCharset r6 = new FontCharset("MAC", 3, 77, "MacRoman");
        MAC = r6;
        FontCharset r8 = new FontCharset("SHIFTJIS", 4, 128, "Shift_JIS");
        SHIFTJIS = r8;
        FontCharset r10 = new FontCharset("HANGUL", 5, 129, "cp949");
        HANGUL = r10;
        FontCharset r12 = new FontCharset("JOHAB", 6, 130, "x-Johab");
        JOHAB = r12;
        FontCharset r11 = new FontCharset("GB2312", 7, 134, "GB2312");
        GB2312 = r11;
        FontCharset r13 = new FontCharset("CHINESEBIG5", 8, 136, "Big5");
        CHINESEBIG5 = r13;
        FontCharset r7 = new FontCharset("GREEK", 9, 161, "Cp1253");
        GREEK = r7;
        FontCharset r5 = new FontCharset("TURKISH", 10, 162, "Cp1254");
        TURKISH = r5;
        FontCharset r2 = new FontCharset("VIETNAMESE", 11, 163, "Cp1258");
        VIETNAMESE = r2;
        FontCharset r9 = new FontCharset("HEBREW", 12, 177, "Cp1255");
        HEBREW = r9;
        FontCharset r3 = new FontCharset("ARABIC", 13, 178, "Cp1256");
        ARABIC = r3;
        FontCharset r14 = new FontCharset("BALTIC", 14, 186, "Cp1257");
        BALTIC = r14;
        FontCharset r15 = new FontCharset("RUSSIAN", 15, 204, "Cp1251");
        RUSSIAN = r15;
        FontCharset r16 = new FontCharset("THAI", 16, 222, "x-windows-874");
        THAI = r16;
        FontCharset r17 = new FontCharset("EASTEUROPE", 17, 238, "Cp1250");
        EASTEUROPE = r17;
        FontCharset r18 = new FontCharset("OEM", 18, 255, "Cp1252");
        OEM = r18;
        $VALUES = new FontCharset[]{r0, r1, r4, r6, r8, r10, r12, r11, r13, r7, r5, r2, r9, r3, r14, r15, r16, r17, r18};
        _table = new FontCharset[256];
        FontCharset[] r19 = values();
        int r20 = r19.length;
        int r21 = 0;
    L3:
        if (r21 >= r20) goto L5;
        FontCharset r22 = r19[r21];
        _table[r22.getNativeId()] = r22;
        r21 = r21 + 1;
        goto L3
    }

    private FontCharset(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.nativeId = r3;
        if (r4.length() > 0) goto L9;
    L7:
        this.charset = null;
        return;
    L9:
        this.charset = Charset.forName(r4);     // Catch: UnsupportedCharsetException -> L6
        return;
    L6:
        b.a(FontCharset.class).atWarn().a("Unsupported charset: {}", r4);
        goto L7
    }

    public static FontCharset valueOf(int r2) {
        if (r2 < 0) goto L7;
        FontCharset[] r0 = _table;
        if (r2 >= r0.length) goto L7;
        return r0[r2];
    L7:
        return null;
    }

    public static FontCharset valueOf(String r2) {
        return (FontCharset) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontCharset.class, r2), FontCharset.class, "com.obric.memorydata.plugin");
    }

    public static FontCharset[] values() {
        return (FontCharset[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontCharset[].class, "com.obric.memorydata.plugin");
    }

    public Charset getCharset() {
        return this.charset;
    }

    public int getNativeId() {
        return this.nativeId;
    }
}
