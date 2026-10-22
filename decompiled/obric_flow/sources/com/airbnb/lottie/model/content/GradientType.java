package com.airbnb.lottie.model.content;

/* JADX INFO: loaded from: classes.dex */
public final enum GradientType extends Enum<GradientType> {
    public static final GradientType LINEAR = null;
    public static final GradientType RADIAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GradientType[] f1284a = null;

    static {
        GradientType r5 = new GradientType("LINEAR", 0);
        LINEAR = r5;
        GradientType r10 = new GradientType("RADIAL", 1);
        RADIAL = r10;
        f1284a = new GradientType[]{r5, r10};
    }

    public static GradientType valueOf(String r5) {
        return (GradientType) Enum.valueOf(GradientType.class, r5);
    }

    public static GradientType[] values() {
        return (GradientType[]) f1284a.clone();
    }
}
