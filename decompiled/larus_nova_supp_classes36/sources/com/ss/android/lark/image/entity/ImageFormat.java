package com.ss.android.lark.image.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum ImageFormat extends Enum<ImageFormat> {
    public static final ImageFormat HEIC = null;
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
        ImageFormat r6 = new ImageFormat("HEIC", 3, 4);
        HEIC = r6;
        a = new ImageFormat[]{r0, r1, r4, r6};
    }

    public static ImageFormat[] values() {
        return (ImageFormat[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ImageFormat forNumber(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return PNG;
    L13:
        return HEIC;
    L15:
        return PNG;
    L17:
        return JPEG;
    L19:
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
