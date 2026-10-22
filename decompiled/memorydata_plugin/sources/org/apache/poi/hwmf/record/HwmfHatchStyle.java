package org.apache.poi.hwmf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum HwmfHatchStyle extends Enum<HwmfHatchStyle> {
    private static final /* synthetic */ HwmfHatchStyle[] $VALUES = null;
    public static final HwmfHatchStyle HS_BDIAGONAL = null;
    public static final HwmfHatchStyle HS_CROSS = null;
    public static final HwmfHatchStyle HS_DIAGCROSS = null;
    public static final HwmfHatchStyle HS_DITHEREDBKCLR = null;
    public static final HwmfHatchStyle HS_DITHEREDCLR = null;
    public static final HwmfHatchStyle HS_DITHEREDTEXTCLR = null;
    public static final HwmfHatchStyle HS_FDIAGONAL = null;
    public static final HwmfHatchStyle HS_HORIZONTAL = null;
    public static final HwmfHatchStyle HS_SOLIDBKCLR = null;
    public static final HwmfHatchStyle HS_SOLIDCLR = null;
    public static final HwmfHatchStyle HS_SOLIDTEXTCLR = null;
    public static final HwmfHatchStyle HS_VERTICAL = null;
    private final int flag;
    private final long pattern;

    static {
        HwmfHatchStyle r6 = new HwmfHatchStyle("HS_HORIZONTAL", 0, 0, 1095216660735L);
        HS_HORIZONTAL = r6;
        HwmfHatchStyle r0 = new HwmfHatchStyle("HS_VERTICAL", 1, 1, -8608480567731124088L);
        HS_VERTICAL = r0;
        HwmfHatchStyle r1 = new HwmfHatchStyle("HS_FDIAGONAL", 2, 2, 577588857680175120L);
        HS_FDIAGONAL = r1;
        HwmfHatchStyle r2 = new HwmfHatchStyle("HS_BDIAGONAL", 3, 3, 1161999622378488840L);
        HS_BDIAGONAL = r2;
        HwmfHatchStyle r3 = new HwmfHatchStyle("HS_CROSS", 4, 4, 1229783960449520127L);
        HS_CROSS = r3;
        HwmfHatchStyle r4 = new HwmfHatchStyle("HS_DIAGCROSS", 5, 5, 1739588480058663960L);
        HS_DIAGCROSS = r4;
        HwmfHatchStyle r5 = new HwmfHatchStyle("HS_SOLIDCLR", 6, 6, -1);
        HS_SOLIDCLR = r5;
        HwmfHatchStyle r13 = new HwmfHatchStyle("HS_DITHEREDCLR", 7, 7, -6172840429334713771L);
        HS_DITHEREDCLR = r13;
        HwmfHatchStyle r7 = new HwmfHatchStyle("HS_SOLIDTEXTCLR", 8, 8, -1);
        HS_SOLIDTEXTCLR = r7;
        HwmfHatchStyle r8 = new HwmfHatchStyle("HS_DITHEREDTEXTCLR", 9, 9, -6172840429334713771L);
        HS_DITHEREDTEXTCLR = r8;
        HwmfHatchStyle r9 = new HwmfHatchStyle("HS_SOLIDBKCLR", 10, 10, 0);
        HS_SOLIDBKCLR = r9;
        HwmfHatchStyle r10 = new HwmfHatchStyle("HS_DITHEREDBKCLR", 11, 11, -6172840429334713771L);
        HS_DITHEREDBKCLR = r10;
        $VALUES = new HwmfHatchStyle[]{r6, r0, r1, r2, r3, r4, r5, r13, r7, r8, r9, r10};
    }

    private HwmfHatchStyle(String r1, int r2, int r3, long r4) {
        super(r1, r2);
        this.flag = r3;
        this.pattern = r4;
    }

    public static HwmfHatchStyle valueOf(int r5) {
        HwmfHatchStyle[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        HwmfHatchStyle r3 = r0[r2];
        if (r3.flag == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static HwmfHatchStyle valueOf(String r2) {
        return (HwmfHatchStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfHatchStyle.class, r2), HwmfHatchStyle.class, "com.obric.memorydata.plugin");
    }

    public static HwmfHatchStyle[] values() {
        return (HwmfHatchStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfHatchStyle[].class, "com.obric.memorydata.plugin");
    }

    public int getFlag() {
        return this.flag;
    }

    public long getPattern() {
        return this.pattern;
    }
}
