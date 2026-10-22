package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum TextDirection extends Enum<TextDirection> {
    private static final /* synthetic */ TextDirection[] $VALUES = null;
    public static final TextDirection HORIZONTAL = null;
    public static final TextDirection STACKED = null;
    public static final TextDirection VERTICAL = null;
    public static final TextDirection VERTICAL_270 = null;

    static {
        TextDirection r0 = new TextDirection("HORIZONTAL", 0);
        HORIZONTAL = r0;
        TextDirection r1 = new TextDirection("VERTICAL", 1);
        VERTICAL = r1;
        TextDirection r3 = new TextDirection("VERTICAL_270", 2);
        VERTICAL_270 = r3;
        TextDirection r5 = new TextDirection("STACKED", 3);
        STACKED = r5;
        $VALUES = new TextDirection[]{r0, r1, r3, r5};
    }

    private TextDirection(String r1, int r2) {
        super(r1, r2);
    }

    public static TextDirection valueOf(String r2) {
        return (TextDirection) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextDirection.class, r2), TextDirection.class, "com.obric.memorydata.plugin");
    }

    public static TextDirection[] values() {
        return (TextDirection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextDirection[].class, "com.obric.memorydata.plugin");
    }
}
