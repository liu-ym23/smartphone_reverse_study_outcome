package org.apache.poi.hwmf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum HwmfBrushStyle extends Enum<HwmfBrushStyle> {
    private static final /* synthetic */ HwmfBrushStyle[] $VALUES = null;
    public static final HwmfBrushStyle BS_DIBPATTERN = null;
    public static final HwmfBrushStyle BS_DIBPATTERN8X8 = null;
    public static final HwmfBrushStyle BS_DIBPATTERNPT = null;
    public static final HwmfBrushStyle BS_HATCHED = null;
    public static final HwmfBrushStyle BS_INDEXED = null;
    public static final HwmfBrushStyle BS_LINEAR_GRADIENT = null;
    public static final HwmfBrushStyle BS_MONOPATTERN = null;
    public static final HwmfBrushStyle BS_NULL = null;
    public static final HwmfBrushStyle BS_PATTERN = null;
    public static final HwmfBrushStyle BS_PATTERN8X8 = null;
    public static final HwmfBrushStyle BS_SOLID = null;
    int flag;

    static {
        HwmfBrushStyle r0 = new HwmfBrushStyle("BS_SOLID", 0, 0);
        BS_SOLID = r0;
        HwmfBrushStyle r1 = new HwmfBrushStyle("BS_NULL", 1, 1);
        BS_NULL = r1;
        HwmfBrushStyle r3 = new HwmfBrushStyle("BS_HATCHED", 2, 2);
        BS_HATCHED = r3;
        HwmfBrushStyle r5 = new HwmfBrushStyle("BS_PATTERN", 3, 3);
        BS_PATTERN = r5;
        HwmfBrushStyle r7 = new HwmfBrushStyle("BS_INDEXED", 4, 4);
        BS_INDEXED = r7;
        HwmfBrushStyle r9 = new HwmfBrushStyle("BS_DIBPATTERN", 5, 5);
        BS_DIBPATTERN = r9;
        HwmfBrushStyle r11 = new HwmfBrushStyle("BS_DIBPATTERNPT", 6, 6);
        BS_DIBPATTERNPT = r11;
        HwmfBrushStyle r13 = new HwmfBrushStyle("BS_PATTERN8X8", 7, 7);
        BS_PATTERN8X8 = r13;
        HwmfBrushStyle r15 = new HwmfBrushStyle("BS_DIBPATTERN8X8", 8, 8);
        BS_DIBPATTERN8X8 = r15;
        HwmfBrushStyle r14 = new HwmfBrushStyle("BS_MONOPATTERN", 9, 9);
        BS_MONOPATTERN = r14;
        HwmfBrushStyle r12 = new HwmfBrushStyle("BS_LINEAR_GRADIENT", 10, 256);
        BS_LINEAR_GRADIENT = r12;
        $VALUES = new HwmfBrushStyle[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
    }

    private HwmfBrushStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.flag = r3;
    }

    public static HwmfBrushStyle valueOf(int r5) {
        HwmfBrushStyle[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        HwmfBrushStyle r3 = r0[r2];
        if (r3.flag == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static HwmfBrushStyle valueOf(String r2) {
        return (HwmfBrushStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfBrushStyle.class, r2), HwmfBrushStyle.class, "com.obric.memorydata.plugin");
    }

    public static HwmfBrushStyle[] values() {
        return (HwmfBrushStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfBrushStyle[].class, "com.obric.memorydata.plugin");
    }
}
