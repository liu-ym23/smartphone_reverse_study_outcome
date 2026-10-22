package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes.dex */
public final enum ImageHeaderParser$ImageType extends Enum<ImageHeaderParser$ImageType> {
    private static final /* synthetic */ ImageHeaderParser$ImageType[] $VALUES = null;
    public static final ImageHeaderParser$ImageType GIF = null;
    public static final ImageHeaderParser$ImageType JPEG = null;
    public static final ImageHeaderParser$ImageType PNG = null;
    public static final ImageHeaderParser$ImageType PNG_A = null;
    public static final ImageHeaderParser$ImageType RAW = null;
    public static final ImageHeaderParser$ImageType UNKNOWN = null;
    public static final ImageHeaderParser$ImageType WEBP = null;
    public static final ImageHeaderParser$ImageType WEBP_A = null;
    private final boolean hasAlpha;

    static {
        ImageHeaderParser$ImageType r5 = new ImageHeaderParser$ImageType("GIF", 0, true);
        GIF = r5;
        ImageHeaderParser$ImageType r10 = new ImageHeaderParser$ImageType("JPEG", 1, false);
        JPEG = r10;
        ImageHeaderParser$ImageType r11 = new ImageHeaderParser$ImageType("RAW", 2, false);
        RAW = r11;
        ImageHeaderParser$ImageType r12 = new ImageHeaderParser$ImageType("PNG_A", 3, true);
        PNG_A = r12;
        ImageHeaderParser$ImageType r13 = new ImageHeaderParser$ImageType("PNG", 4, false);
        PNG = r13;
        ImageHeaderParser$ImageType r14 = new ImageHeaderParser$ImageType("WEBP_A", 5, true);
        WEBP_A = r14;
        ImageHeaderParser$ImageType r15 = new ImageHeaderParser$ImageType("WEBP", 6, false);
        WEBP = r15;
        ImageHeaderParser$ImageType r16 = new ImageHeaderParser$ImageType("UNKNOWN", 7, false);
        UNKNOWN = r16;
        $VALUES = new ImageHeaderParser$ImageType[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public ImageHeaderParser$ImageType(String r5, int r10, boolean r11) {
        super(r5, r10);
        this.hasAlpha = r11;
    }

    public static ImageHeaderParser$ImageType valueOf(String r5) {
        return (ImageHeaderParser$ImageType) Enum.valueOf(ImageHeaderParser$ImageType.class, r5);
    }

    public static ImageHeaderParser$ImageType[] values() {
        return (ImageHeaderParser$ImageType[]) $VALUES.clone();
    }

    public boolean hasAlpha() {
        return this.hasAlpha;
    }
}
