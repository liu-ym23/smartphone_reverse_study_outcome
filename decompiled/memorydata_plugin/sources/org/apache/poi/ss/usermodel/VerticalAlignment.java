package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum VerticalAlignment extends Enum<VerticalAlignment> {
    private static final /* synthetic */ VerticalAlignment[] $VALUES = null;
    public static final VerticalAlignment BOTTOM = null;
    public static final VerticalAlignment CENTER = null;
    public static final VerticalAlignment DISTRIBUTED = null;
    public static final VerticalAlignment JUSTIFY = null;
    public static final VerticalAlignment TOP = null;

    static {
        VerticalAlignment r0 = new VerticalAlignment("TOP", 0);
        TOP = r0;
        VerticalAlignment r1 = new VerticalAlignment("CENTER", 1);
        CENTER = r1;
        VerticalAlignment r3 = new VerticalAlignment("BOTTOM", 2);
        BOTTOM = r3;
        VerticalAlignment r5 = new VerticalAlignment("JUSTIFY", 3);
        JUSTIFY = r5;
        VerticalAlignment r7 = new VerticalAlignment("DISTRIBUTED", 4);
        DISTRIBUTED = r7;
        $VALUES = new VerticalAlignment[]{r0, r1, r3, r5, r7};
    }

    private VerticalAlignment(String r1, int r2) {
        super(r1, r2);
    }

    public static VerticalAlignment forInt(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= values().length) goto L8;
        return values()[r3];
    L8:
        throw new IllegalArgumentException("Invalid VerticalAlignment code: " + r3);
    }

    public static VerticalAlignment valueOf(String r2) {
        return (VerticalAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(VerticalAlignment.class, r2), VerticalAlignment.class, "com.obric.memorydata.plugin");
    }

    public static VerticalAlignment[] values() {
        return (VerticalAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VerticalAlignment[].class, "com.obric.memorydata.plugin");
    }

    public short getCode() {
        return (short) ordinal();
    }
}
