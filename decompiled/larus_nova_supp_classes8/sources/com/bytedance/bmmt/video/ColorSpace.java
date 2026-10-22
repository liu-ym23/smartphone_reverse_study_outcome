package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final enum ColorSpace extends Enum<ColorSpace> {
    private static final /* synthetic */ ColorSpace[] $VALUES = null;
    public static final ColorSpace kUnknown = null;
    public static final ColorSpace kYCbCrBT601FullRange = null;
    public static final ColorSpace kYCbCrBT601LimitedRange = null;
    public static final ColorSpace kYCbCrBT709FullRange = null;
    public static final ColorSpace kYCbCrBT709LimitedRange = null;
    private int colorSpace;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.ColorSpace$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$ColorSpace = null;

        static {
            int[] r0 = new int[ColorSpace.values().length];
            $SwitchMap$com$bytedance$bmmt$video$ColorSpace = r0;
            r0[ColorSpace.kUnknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bytedance$bmmt$video$ColorSpace[ColorSpace.kYCbCrBT601LimitedRange.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bytedance$bmmt$video$ColorSpace[ColorSpace.kYCbCrBT601FullRange.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$bytedance$bmmt$video$ColorSpace[ColorSpace.kYCbCrBT709LimitedRange.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$bytedance$bmmt$video$ColorSpace[ColorSpace.kYCbCrBT709FullRange.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private static /* synthetic */ ColorSpace[] $values() {
        return new ColorSpace[]{kUnknown, kYCbCrBT601LimitedRange, kYCbCrBT601FullRange, kYCbCrBT709LimitedRange, kYCbCrBT709FullRange};
    }

    static {
        kUnknown = new ColorSpace("kUnknown", 0, 0);
        kYCbCrBT601LimitedRange = new ColorSpace("kYCbCrBT601LimitedRange", 1, 1);
        kYCbCrBT601FullRange = new ColorSpace("kYCbCrBT601FullRange", 2, 2);
        kYCbCrBT709LimitedRange = new ColorSpace("kYCbCrBT709LimitedRange", 3, 3);
        kYCbCrBT709FullRange = new ColorSpace("kYCbCrBT709FullRange", 4, 4);
        $VALUES = $values();
    }

    public static ColorSpace[] values() {
        return (ColorSpace[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$ColorSpace[ordinal()];
        if (r0 != 2) goto L5;
        return "kYCbCrBT601LimitedRange";
    L5:
        if (r0 != 3) goto L7;
        return "kYCbCrBT601FullRange";
    L7:
        if (r0 != 4) goto L9;
        return "kYCbCrBT709LimitedRange";
    L9:
        if (r0 == 5) goto L12;
        return "kUnknown";
    L12:
        return "kYCbCrBT709FullRange";
    }

    private int value() {
        return this.colorSpace;
    }

    public int getColorSpace() {
        return this.colorSpace;
    }

    public static ColorSpace fromId(int r5) {
        ColorSpace[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        ColorSpace r3 = r0[r2];
        if (r3.value() == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static ColorSpace valueOf(String r1) {
        return (ColorSpace) r27.a.a(ColorSpace.class, r1);
    }

    private ColorSpace(String r1, int r2, int r3) {
        super(r1, r2);
        this.colorSpace = r3;
    }
}
