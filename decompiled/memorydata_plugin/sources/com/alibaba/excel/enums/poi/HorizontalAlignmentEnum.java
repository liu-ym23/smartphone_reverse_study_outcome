package com.alibaba.excel.enums.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

/* JADX INFO: loaded from: classes.dex */
public final enum HorizontalAlignmentEnum extends Enum<HorizontalAlignmentEnum> {
    private static final /* synthetic */ HorizontalAlignmentEnum[] $VALUES = null;
    public static final HorizontalAlignmentEnum CENTER = null;
    public static final HorizontalAlignmentEnum CENTER_SELECTION = null;
    public static final HorizontalAlignmentEnum DEFAULT = null;
    public static final HorizontalAlignmentEnum DISTRIBUTED = null;
    public static final HorizontalAlignmentEnum FILL = null;
    public static final HorizontalAlignmentEnum GENERAL = null;
    public static final HorizontalAlignmentEnum JUSTIFY = null;
    public static final HorizontalAlignmentEnum LEFT = null;
    public static final HorizontalAlignmentEnum RIGHT = null;
    HorizontalAlignment poiHorizontalAlignment;

    static {
        HorizontalAlignmentEnum r0 = new HorizontalAlignmentEnum("DEFAULT", 0, null);
        DEFAULT = r0;
        HorizontalAlignmentEnum r1 = new HorizontalAlignmentEnum("GENERAL", 1, HorizontalAlignment.GENERAL);
        GENERAL = r1;
        HorizontalAlignmentEnum r3 = new HorizontalAlignmentEnum("LEFT", 2, HorizontalAlignment.LEFT);
        LEFT = r3;
        HorizontalAlignmentEnum r4 = new HorizontalAlignmentEnum("CENTER", 3, HorizontalAlignment.CENTER);
        CENTER = r4;
        HorizontalAlignmentEnum r6 = new HorizontalAlignmentEnum("RIGHT", 4, HorizontalAlignment.RIGHT);
        RIGHT = r6;
        HorizontalAlignmentEnum r8 = new HorizontalAlignmentEnum("FILL", 5, HorizontalAlignment.FILL);
        FILL = r8;
        HorizontalAlignmentEnum r10 = new HorizontalAlignmentEnum("JUSTIFY", 6, HorizontalAlignment.JUSTIFY);
        JUSTIFY = r10;
        HorizontalAlignmentEnum r12 = new HorizontalAlignmentEnum("CENTER_SELECTION", 7, HorizontalAlignment.CENTER_SELECTION);
        CENTER_SELECTION = r12;
        HorizontalAlignmentEnum r14 = new HorizontalAlignmentEnum("DISTRIBUTED", 8, HorizontalAlignment.DISTRIBUTED);
        DISTRIBUTED = r14;
        $VALUES = new HorizontalAlignmentEnum[]{r0, r1, r3, r4, r6, r8, r10, r12, r14};
    }

    private HorizontalAlignmentEnum(String r1, int r2, HorizontalAlignment r3) {
        super(r1, r2);
        this.poiHorizontalAlignment = r3;
    }

    public static HorizontalAlignmentEnum valueOf(String r2) {
        return (HorizontalAlignmentEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(HorizontalAlignmentEnum.class, r2), HorizontalAlignmentEnum.class, "com.obric.memorydata.plugin");
    }

    public static HorizontalAlignmentEnum[] values() {
        return (HorizontalAlignmentEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HorizontalAlignmentEnum[].class, "com.obric.memorydata.plugin");
    }

    public HorizontalAlignment getPoiHorizontalAlignment() {
        return this.poiHorizontalAlignment;
    }
}
