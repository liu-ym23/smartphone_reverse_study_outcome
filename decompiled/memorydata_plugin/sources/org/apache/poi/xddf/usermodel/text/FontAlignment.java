package org.apache.poi.xddf.usermodel.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType;

/* JADX INFO: loaded from: classes7.dex */
public final enum FontAlignment extends Enum<FontAlignment> {
    private static final /* synthetic */ FontAlignment[] $VALUES = null;
    public static final FontAlignment AUTOMATIC = null;
    public static final FontAlignment BASELINE = null;
    public static final FontAlignment BOTTOM = null;
    public static final FontAlignment CENTER = null;
    public static final FontAlignment TOP = null;
    private static final HashMap<STTextFontAlignType.Enum, FontAlignment> reverse = null;
    final STTextFontAlignType.Enum underlying;

    static {
        int r3 = 0;
        FontAlignment r0 = new FontAlignment("AUTOMATIC", 0, STTextFontAlignType.c);
        AUTOMATIC = r0;
        FontAlignment r1 = new FontAlignment("BOTTOM", 1, STTextFontAlignType.g);
        BOTTOM = r1;
        FontAlignment r2 = new FontAlignment("BASELINE", 2, STTextFontAlignType.f);
        BASELINE = r2;
        FontAlignment r4 = new FontAlignment("CENTER", 3, STTextFontAlignType.e);
        CENTER = r4;
        FontAlignment r6 = new FontAlignment("TOP", 4, STTextFontAlignType.d);
        TOP = r6;
        $VALUES = new FontAlignment[]{r0, r1, r2, r4, r6};
        reverse = new HashMap();
        FontAlignment[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        FontAlignment r8 = r5[r3];
        reverse.put(r8.underlying, r8);
        r3 = r3 + 1;
        goto L3
    }

    private FontAlignment(String r1, int r2, STTextFontAlignType.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static FontAlignment valueOf(String r2) {
        return (FontAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontAlignment.class, r2), FontAlignment.class, "com.obric.memorydata.plugin");
    }

    static FontAlignment valueOf(STTextFontAlignType.Enum r2) {
        return (FontAlignment) ZeusTransformUtils.preCheckCast(reverse.get(r2), FontAlignment.class, "com.obric.memorydata.plugin");
    }

    public static FontAlignment[] values() {
        return (FontAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontAlignment[].class, "com.obric.memorydata.plugin");
    }
}
