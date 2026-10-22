package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum HorizontalAlignment extends Enum<HorizontalAlignment> {
    private static final /* synthetic */ HorizontalAlignment[] $VALUES = null;
    public static final HorizontalAlignment CENTER = null;
    public static final HorizontalAlignment CENTER_SELECTION = null;
    public static final HorizontalAlignment DISTRIBUTED = null;
    public static final HorizontalAlignment FILL = null;
    public static final HorizontalAlignment GENERAL = null;
    public static final HorizontalAlignment JUSTIFY = null;
    public static final HorizontalAlignment LEFT = null;
    public static final HorizontalAlignment RIGHT = null;

    static {
        HorizontalAlignment r0 = new HorizontalAlignment("GENERAL", 0);
        GENERAL = r0;
        HorizontalAlignment r1 = new HorizontalAlignment("LEFT", 1);
        LEFT = r1;
        HorizontalAlignment r3 = new HorizontalAlignment("CENTER", 2);
        CENTER = r3;
        HorizontalAlignment r5 = new HorizontalAlignment("RIGHT", 3);
        RIGHT = r5;
        HorizontalAlignment r7 = new HorizontalAlignment("FILL", 4);
        FILL = r7;
        HorizontalAlignment r9 = new HorizontalAlignment("JUSTIFY", 5);
        JUSTIFY = r9;
        HorizontalAlignment r11 = new HorizontalAlignment("CENTER_SELECTION", 6);
        CENTER_SELECTION = r11;
        HorizontalAlignment r13 = new HorizontalAlignment("DISTRIBUTED", 7);
        DISTRIBUTED = r13;
        $VALUES = new HorizontalAlignment[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    private HorizontalAlignment(String r1, int r2) {
        super(r1, r2);
    }

    public static HorizontalAlignment forInt(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= values().length) goto L8;
        return values()[r3];
    L8:
        throw new IllegalArgumentException("Invalid HorizontalAlignment code: " + r3);
    }

    public static HorizontalAlignment valueOf(String r2) {
        return (HorizontalAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(HorizontalAlignment.class, r2), HorizontalAlignment.class, "com.obric.memorydata.plugin");
    }

    public static HorizontalAlignment[] values() {
        return (HorizontalAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HorizontalAlignment[].class, "com.obric.memorydata.plugin");
    }

    public short getCode() {
        return (short) ordinal();
    }
}
