package com.ss.android.lark.resource.service;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class AvatarResourceParams implements Serializable {
    private CutType cutType;
    private ImageFormat format;
    private String fsUnit;
    private int height;
    private boolean isOnlyLocal;
    private boolean noop;
    private int quality;
    private int width;

    public static final enum CutType extends Enum<CutType> {
        public static final CutType BOTTOM = null;
        public static final CutType CENTER = null;
        public static final CutType FACE = null;
        public static final CutType LEFT = null;
        public static final CutType NOOP = null;
        public static final CutType RIGHT = null;
        public static final CutType TOP = null;
        public static final /* synthetic */ CutType[] a = null;
        private int value;

        static {
            CutType r0 = new CutType("TOP", 0, 1);
            TOP = r0;
            CutType r1 = new CutType("BOTTOM", 1, 2);
            BOTTOM = r1;
            CutType r4 = new CutType("LEFT", 2, 3);
            LEFT = r4;
            CutType r6 = new CutType("RIGHT", 3, 4);
            RIGHT = r6;
            CutType r8 = new CutType("CENTER", 4, 5);
            CENTER = r8;
            CutType r10 = new CutType("FACE", 5, 6);
            FACE = r10;
            CutType r12 = new CutType("NOOP", 6, 7);
            NOOP = r12;
            a = new CutType[]{r0, r1, r4, r6, r8, r10, r12};
        }

        public static CutType[] values() {
            return (CutType[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static CutType forNumber(int r0) {
            switch(r0) {
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L4;
            };
        L4:
            return FACE;
        L6:
            return NOOP;
        L8:
            return FACE;
        L10:
            return CENTER;
        L12:
            return RIGHT;
        L14:
            return LEFT;
        L16:
            return BOTTOM;
        L18:
            return TOP;
        }

        public static CutType valueOf(String r1) {
            return (CutType) r27.a.a(CutType.class, r1);
        }

        public static CutType valueOf(int r0) {
            return forNumber(r0);
        }

        public CutType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum ImageFormat extends Enum<ImageFormat> {
        public static final ImageFormat JPEG = null;
        public static final ImageFormat PNG = null;
        public static final ImageFormat WEBP = null;
        public static final /* synthetic */ ImageFormat[] a = null;
        private int value;

        static {
            ImageFormat r0 = new ImageFormat("WEBP", 0, 1);
            WEBP = r0;
            ImageFormat r1 = new ImageFormat("JPEG", 1, 2);
            JPEG = r1;
            ImageFormat r4 = new ImageFormat("PNG", 2, 3);
            PNG = r4;
            a = new ImageFormat[]{r0, r1, r4};
        }

        public static ImageFormat[] values() {
            return (ImageFormat[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ImageFormat forNumber(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return PNG;
        L11:
            return PNG;
        L13:
            return JPEG;
        L15:
            return WEBP;
        }

        public static ImageFormat valueOf(String r1) {
            return (ImageFormat) r27.a.a(ImageFormat.class, r1);
        }

        public static ImageFormat valueOf(int r0) {
            return forNumber(r0);
        }

        public ImageFormat(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public int getQuality() {
        int r0 = this.quality;
        if (r0 > 1) goto L6;
        return 1;
    L6:
        if (r0 > 70) goto L8;
        return 70;
    L8:
        return 100;
    }

    public AvatarResourceParams() {
        this.cutType = CutType.FACE;
        this.format = ImageFormat.PNG;
        this.quality = 70;
    }

    public CutType getCutType() {
        return this.cutType;
    }

    public ImageFormat getFormat() {
        return this.format;
    }

    public String getFsUnit() {
        return this.fsUnit;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isNoop() {
        return this.noop;
    }

    public boolean isOnlyLocal() {
        return this.isOnlyLocal;
    }

    public void setCutType(CutType r1) {
        this.cutType = r1;
    }

    public void setFormat(ImageFormat r1) {
        this.format = r1;
    }

    public void setFsUnit(String r1) {
        this.fsUnit = r1;
    }

    public void setHeight(int r1) {
        this.height = r1;
    }

    public void setIsOnlyLocal(boolean r1) {
        this.isOnlyLocal = r1;
    }

    public void setNoop(boolean r1) {
        this.noop = r1;
    }

    public void setQuality(int r1) {
        this.quality = r1;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }
}
