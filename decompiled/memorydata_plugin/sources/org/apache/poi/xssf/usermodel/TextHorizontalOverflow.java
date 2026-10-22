package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum TextHorizontalOverflow extends Enum<TextHorizontalOverflow> {
    private static final /* synthetic */ TextHorizontalOverflow[] $VALUES = null;
    public static final TextHorizontalOverflow CLIP = null;
    public static final TextHorizontalOverflow OVERFLOW = null;

    static {
        TextHorizontalOverflow r0 = new TextHorizontalOverflow("OVERFLOW", 0);
        OVERFLOW = r0;
        TextHorizontalOverflow r1 = new TextHorizontalOverflow("CLIP", 1);
        CLIP = r1;
        $VALUES = new TextHorizontalOverflow[]{r0, r1};
    }

    private TextHorizontalOverflow(String r1, int r2) {
        super(r1, r2);
    }

    public static TextHorizontalOverflow valueOf(String r2) {
        return (TextHorizontalOverflow) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextHorizontalOverflow.class, r2), TextHorizontalOverflow.class, "com.obric.memorydata.plugin");
    }

    public static TextHorizontalOverflow[] values() {
        return (TextHorizontalOverflow[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextHorizontalOverflow[].class, "com.obric.memorydata.plugin");
    }
}
