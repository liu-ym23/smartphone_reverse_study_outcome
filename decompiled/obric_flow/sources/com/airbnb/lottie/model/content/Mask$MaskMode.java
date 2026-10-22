package com.airbnb.lottie.model.content;

/* JADX INFO: loaded from: classes.dex */
public final enum Mask$MaskMode extends Enum<Mask$MaskMode> {
    public static final Mask$MaskMode MASK_MODE_ADD = null;
    public static final Mask$MaskMode MASK_MODE_INTERSECT = null;
    public static final Mask$MaskMode MASK_MODE_NONE = null;
    public static final Mask$MaskMode MASK_MODE_SUBTRACT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Mask$MaskMode[] f1285a = null;

    static {
        Mask$MaskMode r5 = new Mask$MaskMode("MASK_MODE_ADD", 0);
        MASK_MODE_ADD = r5;
        Mask$MaskMode r10 = new Mask$MaskMode("MASK_MODE_SUBTRACT", 1);
        MASK_MODE_SUBTRACT = r10;
        Mask$MaskMode r11 = new Mask$MaskMode("MASK_MODE_INTERSECT", 2);
        MASK_MODE_INTERSECT = r11;
        Mask$MaskMode r12 = new Mask$MaskMode("MASK_MODE_NONE", 3);
        MASK_MODE_NONE = r12;
        f1285a = new Mask$MaskMode[]{r5, r10, r11, r12};
    }

    public static Mask$MaskMode valueOf(String r5) {
        return (Mask$MaskMode) Enum.valueOf(Mask$MaskMode.class, r5);
    }

    public static Mask$MaskMode[] values() {
        return (Mask$MaskMode[]) f1285a.clone();
    }
}
