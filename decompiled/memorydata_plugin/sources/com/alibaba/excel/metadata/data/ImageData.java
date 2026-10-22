package com.alibaba.excel.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ImageData extends ClientAnchorData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageType f269b;

    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType PICTURE_TYPE_DIB = null;
        public static final ImageType PICTURE_TYPE_EMF = null;
        public static final ImageType PICTURE_TYPE_JPEG = null;
        public static final ImageType PICTURE_TYPE_PICT = null;
        public static final ImageType PICTURE_TYPE_PNG = null;
        public static final ImageType PICTURE_TYPE_WMF = null;
        int value;

        static {
            ImageType r0 = new ImageType("PICTURE_TYPE_EMF", 0, 2);
            PICTURE_TYPE_EMF = r0;
            ImageType r1 = new ImageType("PICTURE_TYPE_WMF", 1, 3);
            PICTURE_TYPE_WMF = r1;
            ImageType r4 = new ImageType("PICTURE_TYPE_PICT", 2, 4);
            PICTURE_TYPE_PICT = r4;
            ImageType r7 = new ImageType("PICTURE_TYPE_JPEG", 3, 5);
            PICTURE_TYPE_JPEG = r7;
            ImageType r9 = new ImageType("PICTURE_TYPE_PNG", 4, 6);
            PICTURE_TYPE_PNG = r9;
            ImageType r11 = new ImageType("PICTURE_TYPE_DIB", 5, 7);
            PICTURE_TYPE_DIB = r11;
            $VALUES = new ImageType[]{r0, r1, r4, r7, r9, r11};
        }

        private ImageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static ImageType valueOf(String r2) {
            return (ImageType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ImageType.class, r2), ImageType.class, "com.obric.memorydata.plugin");
        }

        public static ImageType[] values() {
            return (ImageType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ImageType[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.value;
        }
    }

    public ImageData() {
    }

    @Override // com.alibaba.excel.metadata.data.ClientAnchorData, com.alibaba.excel.metadata.data.c
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, ImageData.class);
    }

    @Override // com.alibaba.excel.metadata.data.ClientAnchorData, com.alibaba.excel.metadata.data.c
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ImageData.class) == true) goto L8;
        return false;
    L8:
        ImageData r0 = (ImageData) ZeusTransformUtils.preCheckCast(r5, ImageData.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L15;
        return false;
    L15:
        if (Arrays.equals(f(), r0.f()) == true) goto L17;
        return false;
    L17:
        ImageType r4 = g();
        ImageType r6 = r0.g();
        if (r4 != null) goto L22;
        if (r6 != null) goto L23;
    L24:
        return true;
    L23:
        return false;
    L22:
        if (r4.equals(r6) == true) goto L24;
        goto L23
    }

    public byte[] f() {
        return this.f268a;
    }

    public ImageType g() {
        return this.f269b;
    }

    @Override // com.alibaba.excel.metadata.data.ClientAnchorData, com.alibaba.excel.metadata.data.c
    public int hashCode() {
        int r0 = (super.hashCode() * 59) + Arrays.hashCode(f());
        ImageType r2 = g();
        int r1 = r0 * 59;
        if (r2 != null) goto L5;
        int r3 = 43;
    L7:
        return r1 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }
}
