package com.tom_roush.pdfbox.pdmodel.graphics.state;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum RenderingIntent extends Enum<RenderingIntent> {
    private static final /* synthetic */ RenderingIntent[] $VALUES = null;
    public static final RenderingIntent ABSOLUTE_COLORIMETRIC = null;
    public static final RenderingIntent PERCEPTUAL = null;
    public static final RenderingIntent RELATIVE_COLORIMETRIC = null;
    public static final RenderingIntent SATURATION = null;
    private final String value;

    static {
        RenderingIntent r0 = new RenderingIntent("ABSOLUTE_COLORIMETRIC", 0, "AbsoluteColorimetric");
        ABSOLUTE_COLORIMETRIC = r0;
        RenderingIntent r1 = new RenderingIntent("RELATIVE_COLORIMETRIC", 1, "RelativeColorimetric");
        RELATIVE_COLORIMETRIC = r1;
        RenderingIntent r3 = new RenderingIntent("SATURATION", 2, ExifInterface.TAG_SATURATION);
        SATURATION = r3;
        RenderingIntent r5 = new RenderingIntent("PERCEPTUAL", 3, "Perceptual");
        PERCEPTUAL = r5;
        $VALUES = new RenderingIntent[]{r0, r1, r3, r5};
    }

    private RenderingIntent(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static RenderingIntent fromString(String r5) {
        RenderingIntent[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        RenderingIntent r3 = r0[r2];
        if (r3.value.equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return RELATIVE_COLORIMETRIC;
    }

    public static RenderingIntent valueOf(String r2) {
        return (RenderingIntent) ZeusTransformUtils.preCheckCast(Enum.valueOf(RenderingIntent.class, r2), RenderingIntent.class, "com.obric.memorydata.plugin");
    }

    public static RenderingIntent[] values() {
        return (RenderingIntent[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RenderingIntent[].class, "com.obric.memorydata.plugin");
    }

    public String stringValue() {
        return this.value;
    }
}
