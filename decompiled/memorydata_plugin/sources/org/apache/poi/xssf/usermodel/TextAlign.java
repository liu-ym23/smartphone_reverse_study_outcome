package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum TextAlign extends Enum<TextAlign> {
    private static final /* synthetic */ TextAlign[] $VALUES = null;
    public static final TextAlign CENTER = null;
    public static final TextAlign DIST = null;
    public static final TextAlign JUSTIFY = null;
    public static final TextAlign JUSTIFY_LOW = null;
    public static final TextAlign LEFT = null;
    public static final TextAlign RIGHT = null;
    public static final TextAlign THAI_DIST = null;

    static {
        TextAlign r0 = new TextAlign("LEFT", 0);
        LEFT = r0;
        TextAlign r1 = new TextAlign("CENTER", 1);
        CENTER = r1;
        TextAlign r3 = new TextAlign("RIGHT", 2);
        RIGHT = r3;
        TextAlign r5 = new TextAlign("JUSTIFY", 3);
        JUSTIFY = r5;
        TextAlign r7 = new TextAlign("JUSTIFY_LOW", 4);
        JUSTIFY_LOW = r7;
        TextAlign r9 = new TextAlign("DIST", 5);
        DIST = r9;
        TextAlign r11 = new TextAlign("THAI_DIST", 6);
        THAI_DIST = r11;
        $VALUES = new TextAlign[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private TextAlign(String r1, int r2) {
        super(r1, r2);
    }

    public static TextAlign valueOf(String r2) {
        return (TextAlign) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextAlign.class, r2), TextAlign.class, "com.obric.memorydata.plugin");
    }

    public static TextAlign[] values() {
        return (TextAlign[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextAlign[].class, "com.obric.memorydata.plugin");
    }
}
