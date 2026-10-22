package com.ss.android.lark.resource.service;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class AvatarFsUnitParams implements Serializable {
    private AvatarResourceParams.CutType cutType;
    private AvatarResourceParams.ImageFormat imageFormat;
    private ImageSizeType imageSizeType;
    private boolean isNoop;
    private com.bytedance.lark.pb.media.v1.AvatarFsUnitParams.Quality quality;

    public static final enum ImageSizeType extends Enum<ImageSizeType> {
        public static final ImageSizeType BIG = null;
        public static final ImageSizeType MIDDLE = null;
        public static final ImageSizeType ORIGIN = null;
        public static final ImageSizeType SMALL = null;
        public static final /* synthetic */ ImageSizeType[] a = null;
        private int value;

        static {
            ImageSizeType r0 = new ImageSizeType("SMALL", 0, 1);
            SMALL = r0;
            ImageSizeType r1 = new ImageSizeType("MIDDLE", 1, 2);
            MIDDLE = r1;
            ImageSizeType r4 = new ImageSizeType("BIG", 2, 3);
            BIG = r4;
            ImageSizeType r6 = new ImageSizeType("ORIGIN", 3, 4);
            ORIGIN = r6;
            a = new ImageSizeType[]{r0, r1, r4, r6};
        }

        public static ImageSizeType[] values() {
            return (ImageSizeType[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ImageSizeType forNumber(int r1) {
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L15;
            if (r1 == 4) goto L13;
            return ORIGIN;
        L13:
            return ORIGIN;
        L15:
            return BIG;
        L17:
            return MIDDLE;
        L19:
            return SMALL;
        }

        public static ImageSizeType valueOf(String r1) {
            return (ImageSizeType) r27.a.a(ImageSizeType.class, r1);
        }

        public static ImageSizeType valueOf(int r0) {
            return forNumber(r0);
        }

        public ImageSizeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public AvatarFsUnitParams() {
        this.cutType = AvatarResourceParams.CutType.FACE;
        this.imageSizeType = ImageSizeType.ORIGIN;
        this.imageFormat = AvatarResourceParams.ImageFormat.PNG;
    }

    public AvatarResourceParams.CutType getCutType() {
        return this.cutType;
    }

    public AvatarResourceParams.ImageFormat getImageFormat() {
        return this.imageFormat;
    }

    public ImageSizeType getImageSizeType() {
        return this.imageSizeType;
    }

    public com.bytedance.lark.pb.media.v1.AvatarFsUnitParams.Quality getQuality() {
        return this.quality;
    }

    public boolean isNoop() {
        return this.isNoop;
    }

    public void setCutType(AvatarResourceParams.CutType r1) {
        this.cutType = r1;
    }

    public void setImageFormat(AvatarResourceParams.ImageFormat r1) {
        this.imageFormat = r1;
    }

    public void setImageSizeType(ImageSizeType r1) {
        this.imageSizeType = r1;
    }

    public void setNoop(boolean r1) {
        this.isNoop = r1;
    }

    public void setQuality(int r2) {
        if (r2 > 1) goto L6;
        this.quality = com.bytedance.lark.pb.media.v1.AvatarFsUnitParams.Quality.Q1;
        return;
    L6:
        if (r2 > 70) goto L8;
        this.quality = com.bytedance.lark.pb.media.v1.AvatarFsUnitParams.Quality.Q70;
        return;
    L8:
        this.quality = com.bytedance.lark.pb.media.v1.AvatarFsUnitParams.Quality.Q_NOOP;
    }
}
