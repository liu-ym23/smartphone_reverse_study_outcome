package com.tom_roush.pdfbox.rendering;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract enum ImageType extends Enum<ImageType> {
    private static final /* synthetic */ ImageType[] $VALUES = null;
    public static final ImageType ARGB = null;
    public static final ImageType BGR = null;
    public static final ImageType BINARY = null;
    public static final ImageType GRAY = null;
    public static final ImageType RGB = null;

    static {
        final String r1 = "BINARY";
        final int r2 = 0;
        ImageType r0 = new AnonymousClass1(r1, r2);
        BINARY = r0;
        final String r3 = "GRAY";
        final int r4 = 1;
        ImageType r5 = new AnonymousClass2(r3, r4);
        GRAY = r5;
        final String r6 = "RGB";
        final int r7 = 2;
        ImageType r8 = new AnonymousClass3(r6, r7);
        RGB = r8;
        final String r9 = "ARGB";
        final int r10 = 3;
        ImageType r11 = new AnonymousClass4(r9, r10);
        ARGB = r11;
        final String r12 = "BGR";
        final int r13 = 4;
        ImageType r14 = new AnonymousClass5(r12, r13);
        BGR = r14;
        $VALUES = new ImageType[]{r0, r5, r8, r11, r14};
    }

    private ImageType(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ ImageType(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static ImageType valueOf(String r2) {
        return (ImageType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ImageType.class, r2), ImageType.class, "com.obric.memorydata.plugin");
    }

    public static ImageType[] values() {
        return (ImageType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ImageType[].class, "com.obric.memorydata.plugin");
    }

    abstract Bitmap.Config toBitmapConfig();
}
