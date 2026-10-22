package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final enum VideoScaleFilter extends Enum<VideoScaleFilter> {
    private static final /* synthetic */ VideoScaleFilter[] $VALUES = null;
    public static final VideoScaleFilter kFFMPegBicubic = null;
    public static final VideoScaleFilter kFFMPegBilinear = null;
    public static final VideoScaleFilter kFFMPegFastBilinear = null;
    public static final VideoScaleFilter kFFMPegGauss = null;
    public static final VideoScaleFilter kFFMPegLanczos = null;
    public static final VideoScaleFilter kLibYUVBilinear = null;
    public static final VideoScaleFilter kLibYUVBox = null;
    public static final VideoScaleFilter kLibYUVLinear = null;
    public static final VideoScaleFilter kLibYUVNone = null;
    public static final VideoScaleFilter kOpenGLBicubic = null;
    public static final VideoScaleFilter kOpenGLBilinear = null;
    public static final VideoScaleFilter kOpenGLBox = null;
    public static final VideoScaleFilter kOpenGLOrigin = null;
    private int value;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.VideoScaleFilter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter = null;

        static {
            int[] r0 = new int[VideoScaleFilter.values().length];
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter = r0;
            r0[VideoScaleFilter.kLibYUVNone.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kLibYUVLinear.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L40:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kLibYUVBilinear.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L54:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kLibYUVBox.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kFFMPegFastBilinear.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kFFMPegBilinear.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kFFMPegBicubic.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L50:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kFFMPegGauss.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L32:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kFFMPegLanczos.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kOpenGLOrigin.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kOpenGLBilinear.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L48:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kOpenGLBicubic.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L30:
            $SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[VideoScaleFilter.kOpenGLBox.ordinal()] = 13;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    private static /* synthetic */ VideoScaleFilter[] $values() {
        return new VideoScaleFilter[]{kLibYUVNone, kLibYUVLinear, kLibYUVBilinear, kLibYUVBox, kFFMPegFastBilinear, kFFMPegBilinear, kFFMPegBicubic, kFFMPegGauss, kFFMPegLanczos, kOpenGLOrigin, kOpenGLBilinear, kOpenGLBicubic, kOpenGLBox};
    }

    static {
        kLibYUVNone = new VideoScaleFilter("kLibYUVNone", 0, 0);
        kLibYUVLinear = new VideoScaleFilter("kLibYUVLinear", 1, 1);
        kLibYUVBilinear = new VideoScaleFilter("kLibYUVBilinear", 2, 2);
        kLibYUVBox = new VideoScaleFilter("kLibYUVBox", 3, 3);
        kFFMPegFastBilinear = new VideoScaleFilter("kFFMPegFastBilinear", 4, 4);
        kFFMPegBilinear = new VideoScaleFilter("kFFMPegBilinear", 5, 5);
        kFFMPegBicubic = new VideoScaleFilter("kFFMPegBicubic", 6, 6);
        kFFMPegGauss = new VideoScaleFilter("kFFMPegGauss", 7, 7);
        kFFMPegLanczos = new VideoScaleFilter("kFFMPegLanczos", 8, 8);
        kOpenGLOrigin = new VideoScaleFilter("kOpenGLOrigin", 9, 9);
        kOpenGLBilinear = new VideoScaleFilter("kOpenGLBilinear", 10, 10);
        kOpenGLBicubic = new VideoScaleFilter("kOpenGLBicubic", 11, 11);
        kOpenGLBox = new VideoScaleFilter("kOpenGLBox", 12, 12);
        $VALUES = $values();
    }

    public static VideoScaleFilter[] values() {
        return (VideoScaleFilter[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$VideoScaleFilter[ordinal()]) {
            case 1: goto L30;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L24;
            case 5: goto L22;
            case 6: goto L20;
            case 7: goto L18;
            case 8: goto L16;
            case 9: goto L14;
            case 10: goto L12;
            case 11: goto L10;
            case 12: goto L8;
            case 13: goto L6;
            default: goto L4;
        };
    L4:
        return "unknownValue";
    L6:
        return "kOpenGLBox";
    L8:
        return "kOpenGLBicubic";
    L10:
        return "kOpenGLBilinear";
    L12:
        return "kOpenGLOrigin";
    L14:
        return "kFFMPegLanczos";
    L16:
        return "kFFMPegGauss";
    L18:
        return "kFFMPegBicubic";
    L20:
        return "kFFMPegBilinear";
    L22:
        return "kFFMPegFastBilinear";
    L24:
        return "kLibYUVBox";
    L26:
        return "kLibYUVBilinear";
    L28:
        return "kLibYUVLinear";
    L30:
        return "kLibYUVNone";
    }

    public int value() {
        return this.value;
    }

    public static VideoScaleFilter fromId(int r5) {
        VideoScaleFilter[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        VideoScaleFilter r3 = r0[r2];
        if (r3.value() == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static VideoScaleFilter valueOf(String r1) {
        return (VideoScaleFilter) r27.a.a(VideoScaleFilter.class, r1);
    }

    private VideoScaleFilter(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
