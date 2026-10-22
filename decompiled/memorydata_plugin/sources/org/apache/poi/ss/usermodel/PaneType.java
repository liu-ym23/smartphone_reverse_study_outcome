package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum PaneType extends Enum<PaneType> {
    private static final /* synthetic */ PaneType[] $VALUES = null;
    public static final PaneType LOWER_LEFT = null;
    public static final PaneType LOWER_RIGHT = null;
    public static final PaneType UPPER_LEFT = null;
    public static final PaneType UPPER_RIGHT = null;

    static {
        PaneType r0 = new PaneType("LOWER_RIGHT", 0);
        LOWER_RIGHT = r0;
        PaneType r1 = new PaneType("UPPER_RIGHT", 1);
        UPPER_RIGHT = r1;
        PaneType r3 = new PaneType("LOWER_LEFT", 2);
        LOWER_LEFT = r3;
        PaneType r5 = new PaneType("UPPER_LEFT", 3);
        UPPER_LEFT = r5;
        $VALUES = new PaneType[]{r0, r1, r3, r5};
    }

    private PaneType(String r1, int r2) {
        super(r1, r2);
    }

    public static PaneType valueOf(String r2) {
        return (PaneType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PaneType.class, r2), PaneType.class, "com.obric.memorydata.plugin");
    }

    public static PaneType[] values() {
        return (PaneType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PaneType[].class, "com.obric.memorydata.plugin");
    }
}
