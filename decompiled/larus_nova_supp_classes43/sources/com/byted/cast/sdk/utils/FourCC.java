package com.byted.cast.sdk.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class FourCC {
    public static final int FOURCC_ABGR = 0;
    public static final int FOURCC_I420 = 0;
    public static final int FOURCC_NV12 = 0;
    public static final int FOURCC_NV21 = 0;
    public static final int FOURCC_UNKNOWN = -1;

    public static int makeFourCC(char r0, char r1, char r10, char r11) {
        return ((r0 | (r1 << '\b')) | (r10 << 16)) | (r11 << 24);
    }

    static {
        FOURCC_I420 = makeFourCC('I', '4', '2', '0');
        FOURCC_NV21 = makeFourCC('N', 'V', '2', '1');
        FOURCC_NV12 = makeFourCC('N', 'V', '1', '2');
        FOURCC_ABGR = makeFourCC('A', 'B', 'G', 'R');
    }

    public FourCC() {
    }
}
