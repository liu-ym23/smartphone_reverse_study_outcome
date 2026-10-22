package org.apache.poi.hwmf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum HwmfEmbeddedType extends Enum<HwmfEmbeddedType> {
    private static final /* synthetic */ HwmfEmbeddedType[] $VALUES = null;
    public static final HwmfEmbeddedType BITMAP = null;
    public static final HwmfEmbeddedType BMP = null;
    public static final HwmfEmbeddedType EMF = null;
    public static final HwmfEmbeddedType EPS = null;
    public static final HwmfEmbeddedType GIF = null;
    public static final HwmfEmbeddedType JPEG = null;
    public static final HwmfEmbeddedType PNG = null;
    public static final HwmfEmbeddedType TIFF = null;
    public static final HwmfEmbeddedType UNKNOWN = null;
    public static final HwmfEmbeddedType WMF = null;
    public final String extension;

    static {
        HwmfEmbeddedType r0 = new HwmfEmbeddedType("BITMAP", 0, ".bitmap");
        BITMAP = r0;
        HwmfEmbeddedType r1 = new HwmfEmbeddedType("WMF", 1, ".wmf");
        WMF = r1;
        HwmfEmbeddedType r3 = new HwmfEmbeddedType("EMF", 2, ".emf");
        EMF = r3;
        HwmfEmbeddedType r5 = new HwmfEmbeddedType("EPS", 3, ".eps");
        EPS = r5;
        HwmfEmbeddedType r7 = new HwmfEmbeddedType("JPEG", 4, ".jpg");
        JPEG = r7;
        HwmfEmbeddedType r9 = new HwmfEmbeddedType("GIF", 5, ".gif");
        GIF = r9;
        HwmfEmbeddedType r11 = new HwmfEmbeddedType("TIFF", 6, ".tiff");
        TIFF = r11;
        HwmfEmbeddedType r13 = new HwmfEmbeddedType("PNG", 7, ".png");
        PNG = r13;
        HwmfEmbeddedType r12 = new HwmfEmbeddedType("BMP", 8, ".bmp");
        BMP = r12;
        HwmfEmbeddedType r10 = new HwmfEmbeddedType("UNKNOWN", 9, ".dat");
        UNKNOWN = r10;
        $VALUES = new HwmfEmbeddedType[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10};
    }

    private HwmfEmbeddedType(String r1, int r2, String r3) {
        super(r1, r2);
        this.extension = r3;
    }

    public static HwmfEmbeddedType valueOf(String r2) {
        return (HwmfEmbeddedType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfEmbeddedType.class, r2), HwmfEmbeddedType.class, "com.obric.memorydata.plugin");
    }

    public static HwmfEmbeddedType[] values() {
        return (HwmfEmbeddedType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfEmbeddedType[].class, "com.obric.memorydata.plugin");
    }
}
