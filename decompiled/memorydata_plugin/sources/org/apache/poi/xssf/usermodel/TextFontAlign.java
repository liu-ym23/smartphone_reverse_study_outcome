package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum TextFontAlign extends Enum<TextFontAlign> {
    private static final /* synthetic */ TextFontAlign[] $VALUES = null;
    public static final TextFontAlign AUTO = null;
    public static final TextFontAlign BASELINE = null;
    public static final TextFontAlign BOTTOM = null;
    public static final TextFontAlign CENTER = null;
    public static final TextFontAlign TOP = null;

    static {
        TextFontAlign r0 = new TextFontAlign("AUTO", 0);
        AUTO = r0;
        TextFontAlign r1 = new TextFontAlign("TOP", 1);
        TOP = r1;
        TextFontAlign r3 = new TextFontAlign("CENTER", 2);
        CENTER = r3;
        TextFontAlign r5 = new TextFontAlign("BASELINE", 3);
        BASELINE = r5;
        TextFontAlign r7 = new TextFontAlign("BOTTOM", 4);
        BOTTOM = r7;
        $VALUES = new TextFontAlign[]{r0, r1, r3, r5, r7};
    }

    private TextFontAlign(String r1, int r2) {
        super(r1, r2);
    }

    public static TextFontAlign valueOf(String r2) {
        return (TextFontAlign) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextFontAlign.class, r2), TextFontAlign.class, "com.obric.memorydata.plugin");
    }

    public static TextFontAlign[] values() {
        return (TextFontAlign[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextFontAlign[].class, "com.obric.memorydata.plugin");
    }
}
