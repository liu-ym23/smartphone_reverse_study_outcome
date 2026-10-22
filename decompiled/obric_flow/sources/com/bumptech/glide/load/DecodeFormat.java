package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes.dex */
public final enum DecodeFormat extends Enum<DecodeFormat> {
    public static final DecodeFormat DEFAULT = null;
    public static final DecodeFormat PREFER_ARGB_8888 = null;
    public static final DecodeFormat PREFER_RGB_565 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodeFormat[] f1415a = null;

    static {
        DecodeFormat r5 = new DecodeFormat("PREFER_ARGB_8888", 0);
        PREFER_ARGB_8888 = r5;
        DecodeFormat r10 = new DecodeFormat("PREFER_RGB_565", 1);
        PREFER_RGB_565 = r10;
        f1415a = new DecodeFormat[]{r5, r10};
        DEFAULT = r5;
    }

    public static DecodeFormat valueOf(String r5) {
        return (DecodeFormat) Enum.valueOf(DecodeFormat.class, r5);
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[]) f1415a.clone();
    }
}
