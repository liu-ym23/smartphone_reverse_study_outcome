package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes.dex */
public final enum PreferredColorSpace extends Enum<PreferredColorSpace> {
    public static final PreferredColorSpace DISPLAY_P3 = null;
    public static final PreferredColorSpace SRGB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreferredColorSpace[] f1417a = null;

    static {
        PreferredColorSpace r5 = new PreferredColorSpace("SRGB", 0);
        SRGB = r5;
        PreferredColorSpace r10 = new PreferredColorSpace("DISPLAY_P3", 1);
        DISPLAY_P3 = r10;
        f1417a = new PreferredColorSpace[]{r5, r10};
    }

    public static PreferredColorSpace valueOf(String r5) {
        return (PreferredColorSpace) Enum.valueOf(PreferredColorSpace.class, r5);
    }

    public static PreferredColorSpace[] values() {
        return (PreferredColorSpace[]) f1417a.clone();
    }
}
