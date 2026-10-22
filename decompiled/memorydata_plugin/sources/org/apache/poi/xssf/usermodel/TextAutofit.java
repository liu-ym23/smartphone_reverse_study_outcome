package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum TextAutofit extends Enum<TextAutofit> {
    private static final /* synthetic */ TextAutofit[] $VALUES = null;
    public static final TextAutofit NONE = null;
    public static final TextAutofit NORMAL = null;
    public static final TextAutofit SHAPE = null;

    static {
        TextAutofit r0 = new TextAutofit("NONE", 0);
        NONE = r0;
        TextAutofit r1 = new TextAutofit("NORMAL", 1);
        NORMAL = r1;
        TextAutofit r3 = new TextAutofit("SHAPE", 2);
        SHAPE = r3;
        $VALUES = new TextAutofit[]{r0, r1, r3};
    }

    private TextAutofit(String r1, int r2) {
        super(r1, r2);
    }

    public static TextAutofit valueOf(String r2) {
        return (TextAutofit) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextAutofit.class, r2), TextAutofit.class, "com.obric.memorydata.plugin");
    }

    public static TextAutofit[] values() {
        return (TextAutofit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextAutofit[].class, "com.obric.memorydata.plugin");
    }
}
