package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum TextVerticalOverflow extends Enum<TextVerticalOverflow> {
    private static final /* synthetic */ TextVerticalOverflow[] $VALUES = null;
    public static final TextVerticalOverflow CLIP = null;
    public static final TextVerticalOverflow ELLIPSIS = null;
    public static final TextVerticalOverflow OVERFLOW = null;

    static {
        TextVerticalOverflow r0 = new TextVerticalOverflow("OVERFLOW", 0);
        OVERFLOW = r0;
        TextVerticalOverflow r1 = new TextVerticalOverflow("ELLIPSIS", 1);
        ELLIPSIS = r1;
        TextVerticalOverflow r3 = new TextVerticalOverflow("CLIP", 2);
        CLIP = r3;
        $VALUES = new TextVerticalOverflow[]{r0, r1, r3};
    }

    private TextVerticalOverflow(String r1, int r2) {
        super(r1, r2);
    }

    public static TextVerticalOverflow valueOf(String r2) {
        return (TextVerticalOverflow) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextVerticalOverflow.class, r2), TextVerticalOverflow.class, "com.obric.memorydata.plugin");
    }

    public static TextVerticalOverflow[] values() {
        return (TextVerticalOverflow[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextVerticalOverflow[].class, "com.obric.memorydata.plugin");
    }
}
