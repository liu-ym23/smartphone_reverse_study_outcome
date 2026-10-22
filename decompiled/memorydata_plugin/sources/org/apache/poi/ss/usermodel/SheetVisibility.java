package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum SheetVisibility extends Enum<SheetVisibility> {
    private static final /* synthetic */ SheetVisibility[] $VALUES = null;
    public static final SheetVisibility HIDDEN = null;
    public static final SheetVisibility VERY_HIDDEN = null;
    public static final SheetVisibility VISIBLE = null;

    static {
        SheetVisibility r0 = new SheetVisibility("VISIBLE", 0);
        VISIBLE = r0;
        SheetVisibility r1 = new SheetVisibility("HIDDEN", 1);
        HIDDEN = r1;
        SheetVisibility r3 = new SheetVisibility("VERY_HIDDEN", 2);
        VERY_HIDDEN = r3;
        $VALUES = new SheetVisibility[]{r0, r1, r3};
    }

    private SheetVisibility(String r1, int r2) {
        super(r1, r2);
    }

    public static SheetVisibility valueOf(String r2) {
        return (SheetVisibility) ZeusTransformUtils.preCheckCast(Enum.valueOf(SheetVisibility.class, r2), SheetVisibility.class, "com.obric.memorydata.plugin");
    }

    public static SheetVisibility[] values() {
        return (SheetVisibility[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SheetVisibility[].class, "com.obric.memorydata.plugin");
    }
}
