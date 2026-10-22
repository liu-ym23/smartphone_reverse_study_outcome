package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STRectAlignment;

/* JADX INFO: loaded from: classes7.dex */
public final enum RectangleAlignment extends Enum<RectangleAlignment> {
    private static final /* synthetic */ RectangleAlignment[] $VALUES = null;
    public static final RectangleAlignment BOTTOM = null;
    public static final RectangleAlignment BOTTOM_LEFT = null;
    public static final RectangleAlignment BOTTOM_RIGHT = null;
    public static final RectangleAlignment CENTER = null;
    public static final RectangleAlignment LEFT = null;
    public static final RectangleAlignment RIGHT = null;
    public static final RectangleAlignment TOP = null;
    public static final RectangleAlignment TOP_LEFT = null;
    public static final RectangleAlignment TOP_RIGHT = null;
    private static final HashMap<STRectAlignment.Enum, RectangleAlignment> reverse = null;
    final STRectAlignment.Enum underlying;

    static {
        int r3 = 0;
        RectangleAlignment r0 = new RectangleAlignment("BOTTOM", 0, STRectAlignment.j);
        BOTTOM = r0;
        RectangleAlignment r1 = new RectangleAlignment("BOTTOM_LEFT", 1, STRectAlignment.i);
        BOTTOM_LEFT = r1;
        RectangleAlignment r2 = new RectangleAlignment("BOTTOM_RIGHT", 2, STRectAlignment.k);
        BOTTOM_RIGHT = r2;
        RectangleAlignment r4 = new RectangleAlignment("CENTER", 3, STRectAlignment.g);
        CENTER = r4;
        RectangleAlignment r6 = new RectangleAlignment("LEFT", 4, STRectAlignment.f);
        LEFT = r6;
        RectangleAlignment r8 = new RectangleAlignment("RIGHT", 5, STRectAlignment.h);
        RIGHT = r8;
        RectangleAlignment r10 = new RectangleAlignment("TOP", 6, STRectAlignment.d);
        TOP = r10;
        RectangleAlignment r12 = new RectangleAlignment("TOP_LEFT", 7, STRectAlignment.c);
        TOP_LEFT = r12;
        RectangleAlignment r14 = new RectangleAlignment("TOP_RIGHT", 8, STRectAlignment.e);
        TOP_RIGHT = r14;
        $VALUES = new RectangleAlignment[]{r0, r1, r2, r4, r6, r8, r10, r12, r14};
        reverse = new HashMap();
        RectangleAlignment[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        RectangleAlignment r9 = r5[r3];
        reverse.put(r9.underlying, r9);
        r3 = r3 + 1;
        goto L3
    }

    private RectangleAlignment(String r1, int r2, STRectAlignment.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static RectangleAlignment valueOf(String r2) {
        return (RectangleAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(RectangleAlignment.class, r2), RectangleAlignment.class, "com.obric.memorydata.plugin");
    }

    static RectangleAlignment valueOf(STRectAlignment.Enum r2) {
        return (RectangleAlignment) ZeusTransformUtils.preCheckCast(reverse.get(r2), RectangleAlignment.class, "com.obric.memorydata.plugin");
    }

    public static RectangleAlignment[] values() {
        return (RectangleAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RectangleAlignment[].class, "com.obric.memorydata.plugin");
    }
}
