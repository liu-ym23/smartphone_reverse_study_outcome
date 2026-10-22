package com.obric.common.oea.foundation.blur;

/* JADX INFO: loaded from: classes2.dex */
public final enum BlurUtils$BLEND_MODE extends Enum<BlurUtils$BLEND_MODE> {
    public static final BlurUtils$BLEND_MODE COLOR_BURN = null;
    public static final BlurUtils$BLEND_MODE COLOR_DODGE = null;
    public static final BlurUtils$BLEND_MODE DEFAULT = null;
    public static final BlurUtils$BLEND_MODE LUMINOSITY = null;
    public static final BlurUtils$BLEND_MODE OVERLAY = null;
    public static final BlurUtils$BLEND_MODE PLUS_DARKER = null;
    public static final BlurUtils$BLEND_MODE PLUS_LIGHTER = null;
    public static final BlurUtils$BLEND_MODE SOFT_LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlurUtils$BLEND_MODE[] f11331a = null;

    static {
        BlurUtils$BLEND_MODE r5 = new BlurUtils$BLEND_MODE("DEFAULT", 0);
        DEFAULT = r5;
        BlurUtils$BLEND_MODE r10 = new BlurUtils$BLEND_MODE("COLOR_BURN", 1);
        COLOR_BURN = r10;
        BlurUtils$BLEND_MODE r11 = new BlurUtils$BLEND_MODE("COLOR_DODGE", 2);
        COLOR_DODGE = r11;
        BlurUtils$BLEND_MODE r12 = new BlurUtils$BLEND_MODE("PLUS_DARKER", 3);
        PLUS_DARKER = r12;
        BlurUtils$BLEND_MODE r13 = new BlurUtils$BLEND_MODE("PLUS_LIGHTER", 4);
        PLUS_LIGHTER = r13;
        BlurUtils$BLEND_MODE r14 = new BlurUtils$BLEND_MODE("LUMINOSITY", 5);
        LUMINOSITY = r14;
        BlurUtils$BLEND_MODE r15 = new BlurUtils$BLEND_MODE("OVERLAY", 6);
        OVERLAY = r15;
        BlurUtils$BLEND_MODE r16 = new BlurUtils$BLEND_MODE("SOFT_LIGHT", 7);
        SOFT_LIGHT = r16;
        f11331a = new BlurUtils$BLEND_MODE[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public static BlurUtils$BLEND_MODE valueOf(String r5) {
        return (BlurUtils$BLEND_MODE) Enum.valueOf(BlurUtils$BLEND_MODE.class, r5);
    }

    public static BlurUtils$BLEND_MODE[] values() {
        return (BlurUtils$BLEND_MODE[]) f11331a.clone();
    }
}
