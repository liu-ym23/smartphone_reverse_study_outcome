package org.apache.poi.sl.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum VerticalAlignment extends Enum<VerticalAlignment> {
    private static final /* synthetic */ VerticalAlignment[] $VALUES = null;
    public static final VerticalAlignment BOTTOM = null;
    public static final VerticalAlignment DISTRIBUTED = null;
    public static final VerticalAlignment JUSTIFIED = null;
    public static final VerticalAlignment MIDDLE = null;
    public static final VerticalAlignment TOP = null;

    static {
        VerticalAlignment r0 = new VerticalAlignment("TOP", 0);
        TOP = r0;
        VerticalAlignment r1 = new VerticalAlignment("MIDDLE", 1);
        MIDDLE = r1;
        VerticalAlignment r3 = new VerticalAlignment("BOTTOM", 2);
        BOTTOM = r3;
        VerticalAlignment r5 = new VerticalAlignment("JUSTIFIED", 3);
        JUSTIFIED = r5;
        VerticalAlignment r7 = new VerticalAlignment("DISTRIBUTED", 4);
        DISTRIBUTED = r7;
        $VALUES = new VerticalAlignment[]{r0, r1, r3, r5, r7};
    }

    private VerticalAlignment(String r1, int r2) {
        super(r1, r2);
    }

    public static VerticalAlignment valueOf(String r2) {
        return (VerticalAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(VerticalAlignment.class, r2), VerticalAlignment.class, "com.obric.memorydata.plugin");
    }

    public static VerticalAlignment[] values() {
        return (VerticalAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VerticalAlignment[].class, "com.obric.memorydata.plugin");
    }
}
