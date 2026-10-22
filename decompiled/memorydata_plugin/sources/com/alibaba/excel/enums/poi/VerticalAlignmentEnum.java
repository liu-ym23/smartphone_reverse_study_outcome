package com.alibaba.excel.enums.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/* JADX INFO: loaded from: classes.dex */
public final enum VerticalAlignmentEnum extends Enum<VerticalAlignmentEnum> {
    private static final /* synthetic */ VerticalAlignmentEnum[] $VALUES = null;
    public static final VerticalAlignmentEnum BOTTOM = null;
    public static final VerticalAlignmentEnum CENTER = null;
    public static final VerticalAlignmentEnum DEFAULT = null;
    public static final VerticalAlignmentEnum DISTRIBUTED = null;
    public static final VerticalAlignmentEnum JUSTIFY = null;
    public static final VerticalAlignmentEnum TOP = null;
    VerticalAlignment poiVerticalAlignmentEnum;

    static {
        VerticalAlignmentEnum r0 = new VerticalAlignmentEnum("DEFAULT", 0, null);
        DEFAULT = r0;
        VerticalAlignmentEnum r1 = new VerticalAlignmentEnum("TOP", 1, VerticalAlignment.TOP);
        TOP = r1;
        VerticalAlignmentEnum r3 = new VerticalAlignmentEnum("CENTER", 2, VerticalAlignment.CENTER);
        CENTER = r3;
        VerticalAlignmentEnum r4 = new VerticalAlignmentEnum("BOTTOM", 3, VerticalAlignment.BOTTOM);
        BOTTOM = r4;
        VerticalAlignmentEnum r6 = new VerticalAlignmentEnum("JUSTIFY", 4, VerticalAlignment.JUSTIFY);
        JUSTIFY = r6;
        VerticalAlignmentEnum r8 = new VerticalAlignmentEnum("DISTRIBUTED", 5, VerticalAlignment.DISTRIBUTED);
        DISTRIBUTED = r8;
        $VALUES = new VerticalAlignmentEnum[]{r0, r1, r3, r4, r6, r8};
    }

    private VerticalAlignmentEnum(String r1, int r2, VerticalAlignment r3) {
        super(r1, r2);
        this.poiVerticalAlignmentEnum = r3;
    }

    public static VerticalAlignmentEnum valueOf(String r2) {
        return (VerticalAlignmentEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(VerticalAlignmentEnum.class, r2), VerticalAlignmentEnum.class, "com.obric.memorydata.plugin");
    }

    public static VerticalAlignmentEnum[] values() {
        return (VerticalAlignmentEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VerticalAlignmentEnum[].class, "com.obric.memorydata.plugin");
    }

    public VerticalAlignment getPoiVerticalAlignmentEnum() {
        return this.poiVerticalAlignmentEnum;
    }
}
