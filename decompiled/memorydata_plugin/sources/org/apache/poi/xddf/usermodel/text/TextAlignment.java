package org.apache.poi.xddf.usermodel.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;

/* JADX INFO: loaded from: classes7.dex */
public final enum TextAlignment extends Enum<TextAlignment> {
    private static final /* synthetic */ TextAlignment[] $VALUES = null;
    public static final TextAlignment CENTER = null;
    public static final TextAlignment DISTRIBUTED = null;
    public static final TextAlignment JUSTIFIED = null;
    public static final TextAlignment JUSTIFIED_LOW = null;
    public static final TextAlignment LEFT = null;
    public static final TextAlignment RIGHT = null;
    public static final TextAlignment THAI_DISTRIBUTED = null;
    private static final HashMap<STTextAlignType.Enum, TextAlignment> reverse = null;
    final STTextAlignType.Enum underlying;

    static {
        int r3 = 0;
        TextAlignment r0 = new TextAlignment("CENTER", 0, STTextAlignType.d);
        CENTER = r0;
        TextAlignment r1 = new TextAlignment("DISTRIBUTED", 1, STTextAlignType.h);
        DISTRIBUTED = r1;
        TextAlignment r2 = new TextAlignment("JUSTIFIED", 2, STTextAlignType.f);
        JUSTIFIED = r2;
        TextAlignment r4 = new TextAlignment("JUSTIFIED_LOW", 3, STTextAlignType.g);
        JUSTIFIED_LOW = r4;
        TextAlignment r6 = new TextAlignment("LEFT", 4, STTextAlignType.c);
        LEFT = r6;
        TextAlignment r8 = new TextAlignment("RIGHT", 5, STTextAlignType.e);
        RIGHT = r8;
        TextAlignment r10 = new TextAlignment("THAI_DISTRIBUTED", 6, STTextAlignType.i);
        THAI_DISTRIBUTED = r10;
        $VALUES = new TextAlignment[]{r0, r1, r2, r4, r6, r8, r10};
        reverse = new HashMap();
        TextAlignment[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        TextAlignment r9 = r5[r3];
        reverse.put(r9.underlying, r9);
        r3 = r3 + 1;
        goto L3
    }

    private TextAlignment(String r1, int r2, STTextAlignType.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static TextAlignment valueOf(String r2) {
        return (TextAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextAlignment.class, r2), TextAlignment.class, "com.obric.memorydata.plugin");
    }

    static TextAlignment valueOf(STTextAlignType.Enum r2) {
        return (TextAlignment) ZeusTransformUtils.preCheckCast(reverse.get(r2), TextAlignment.class, "com.obric.memorydata.plugin");
    }

    public static TextAlignment[] values() {
        return (TextAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextAlignment[].class, "com.obric.memorydata.plugin");
    }
}
