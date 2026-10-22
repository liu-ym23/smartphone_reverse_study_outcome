package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum TextCap extends Enum<TextCap> {
    private static final /* synthetic */ TextCap[] $VALUES = null;
    public static final TextCap ALL = null;
    public static final TextCap NONE = null;
    public static final TextCap SMALL = null;

    static {
        TextCap r0 = new TextCap("NONE", 0);
        NONE = r0;
        TextCap r1 = new TextCap("SMALL", 1);
        SMALL = r1;
        TextCap r3 = new TextCap("ALL", 2);
        ALL = r3;
        $VALUES = new TextCap[]{r0, r1, r3};
    }

    private TextCap(String r1, int r2) {
        super(r1, r2);
    }

    public static TextCap valueOf(String r2) {
        return (TextCap) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextCap.class, r2), TextCap.class, "com.obric.memorydata.plugin");
    }

    public static TextCap[] values() {
        return (TextCap[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextCap[].class, "com.obric.memorydata.plugin");
    }
}
