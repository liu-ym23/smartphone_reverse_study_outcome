package com.tom_roush.pdfbox.pdmodel.font;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum FontFormat extends Enum<FontFormat> {
    private static final /* synthetic */ FontFormat[] $VALUES = null;
    public static final FontFormat OTF = null;
    public static final FontFormat PFB = null;
    public static final FontFormat TTF = null;

    static {
        FontFormat r0 = new FontFormat("TTF", 0);
        TTF = r0;
        FontFormat r1 = new FontFormat("OTF", 1);
        OTF = r1;
        FontFormat r3 = new FontFormat("PFB", 2);
        PFB = r3;
        $VALUES = new FontFormat[]{r0, r1, r3};
    }

    private FontFormat(String r1, int r2) {
        super(r1, r2);
    }

    public static FontFormat valueOf(String r2) {
        return (FontFormat) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontFormat.class, r2), FontFormat.class, "com.obric.memorydata.plugin");
    }

    public static FontFormat[] values() {
        return (FontFormat[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontFormat[].class, "com.obric.memorydata.plugin");
    }
}
