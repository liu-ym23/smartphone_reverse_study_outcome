package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum ChartTypes extends Enum<ChartTypes> {
    private static final /* synthetic */ ChartTypes[] $VALUES = null;
    public static final ChartTypes AREA = null;
    public static final ChartTypes AREA3D = null;
    public static final ChartTypes BAR = null;
    public static final ChartTypes BAR3D = null;
    public static final ChartTypes DOUGHNUT = null;
    public static final ChartTypes LINE = null;
    public static final ChartTypes LINE3D = null;
    public static final ChartTypes PIE = null;
    public static final ChartTypes PIE3D = null;
    public static final ChartTypes RADAR = null;
    public static final ChartTypes SCATTER = null;
    public static final ChartTypes SURFACE = null;
    public static final ChartTypes SURFACE3D = null;

    static {
        ChartTypes r0 = new ChartTypes("AREA", 0);
        AREA = r0;
        ChartTypes r1 = new ChartTypes("AREA3D", 1);
        AREA3D = r1;
        ChartTypes r3 = new ChartTypes("BAR", 2);
        BAR = r3;
        ChartTypes r5 = new ChartTypes("BAR3D", 3);
        BAR3D = r5;
        ChartTypes r7 = new ChartTypes("DOUGHNUT", 4);
        DOUGHNUT = r7;
        ChartTypes r9 = new ChartTypes("LINE", 5);
        LINE = r9;
        ChartTypes r11 = new ChartTypes("LINE3D", 6);
        LINE3D = r11;
        ChartTypes r13 = new ChartTypes("PIE", 7);
        PIE = r13;
        ChartTypes r15 = new ChartTypes("PIE3D", 8);
        PIE3D = r15;
        ChartTypes r14 = new ChartTypes("RADAR", 9);
        RADAR = r14;
        ChartTypes r12 = new ChartTypes("SCATTER", 10);
        SCATTER = r12;
        ChartTypes r10 = new ChartTypes("SURFACE", 11);
        SURFACE = r10;
        ChartTypes r8 = new ChartTypes("SURFACE3D", 12);
        SURFACE3D = r8;
        $VALUES = new ChartTypes[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
    }

    private ChartTypes(String r1, int r2) {
        super(r1, r2);
    }

    public static ChartTypes valueOf(String r2) {
        return (ChartTypes) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChartTypes.class, r2), ChartTypes.class, "com.obric.memorydata.plugin");
    }

    public static ChartTypes[] values() {
        return (ChartTypes[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChartTypes[].class, "com.obric.memorydata.plugin");
    }
}
