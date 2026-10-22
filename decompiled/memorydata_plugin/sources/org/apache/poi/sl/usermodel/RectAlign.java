package org.apache.poi.sl.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum RectAlign extends Enum<RectAlign> {
    private static final /* synthetic */ RectAlign[] $VALUES = null;
    public static final RectAlign BOTTOM = null;
    public static final RectAlign BOTTOM_LEFT = null;
    public static final RectAlign BOTTOM_RIGHT = null;
    public static final RectAlign CENTER = null;
    public static final RectAlign LEFT = null;
    public static final RectAlign RIGHT = null;
    public static final RectAlign TOP = null;
    public static final RectAlign TOP_LEFT = null;
    public static final RectAlign TOP_RIGHT = null;
    private final String dir;

    static {
        RectAlign r0 = new RectAlign("TOP_LEFT", 0, "tl");
        TOP_LEFT = r0;
        RectAlign r1 = new RectAlign("TOP", 1, "t");
        TOP = r1;
        RectAlign r3 = new RectAlign("TOP_RIGHT", 2, "tr");
        TOP_RIGHT = r3;
        RectAlign r5 = new RectAlign("LEFT", 3, "l");
        LEFT = r5;
        RectAlign r7 = new RectAlign("CENTER", 4, "ctr");
        CENTER = r7;
        RectAlign r9 = new RectAlign("RIGHT", 5, "r");
        RIGHT = r9;
        RectAlign r11 = new RectAlign("BOTTOM_LEFT", 6, "bl");
        BOTTOM_LEFT = r11;
        RectAlign r13 = new RectAlign("BOTTOM", 7, "b");
        BOTTOM = r13;
        RectAlign r12 = new RectAlign("BOTTOM_RIGHT", 8, "br");
        BOTTOM_RIGHT = r12;
        $VALUES = new RectAlign[]{r0, r1, r3, r5, r7, r9, r11, r13, r12};
    }

    private RectAlign(String r1, int r2, String r3) {
        super(r1, r2);
        this.dir = r3;
    }

    public static RectAlign valueOf(String r2) {
        return (RectAlign) ZeusTransformUtils.preCheckCast(Enum.valueOf(RectAlign.class, r2), RectAlign.class, "com.obric.memorydata.plugin");
    }

    public static RectAlign[] values() {
        return (RectAlign[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RectAlign[].class, "com.obric.memorydata.plugin");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.dir;
    }
}
