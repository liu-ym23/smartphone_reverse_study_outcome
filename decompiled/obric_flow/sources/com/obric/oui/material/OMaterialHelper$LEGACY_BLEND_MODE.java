package com.obric.oui.material;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final enum OMaterialHelper$LEGACY_BLEND_MODE extends Enum<OMaterialHelper$LEGACY_BLEND_MODE> {
    public static final OMaterialHelper$LEGACY_BLEND_MODE COLOR_BURN = null;
    public static final OMaterialHelper$LEGACY_BLEND_MODE COLOR_DODGE = null;
    public static final OMaterialHelper$LEGACY_BLEND_MODE DEFAULT = null;
    public static final OMaterialHelper$LEGACY_BLEND_MODE LUMINOSITY = null;
    public static final OMaterialHelper$LEGACY_BLEND_MODE OVERLAY = null;
    public static final OMaterialHelper$LEGACY_BLEND_MODE PLUS_DARKER = null;
    public static final OMaterialHelper$LEGACY_BLEND_MODE PLUS_LIGHTER = null;
    public static final OMaterialHelper$LEGACY_BLEND_MODE SOFT_LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OMaterialHelper$LEGACY_BLEND_MODE[] f13606a = null;

    static {
        OMaterialHelper$LEGACY_BLEND_MODE r5 = new OMaterialHelper$LEGACY_BLEND_MODE("DEFAULT", 0);
        DEFAULT = r5;
        OMaterialHelper$LEGACY_BLEND_MODE r10 = new OMaterialHelper$LEGACY_BLEND_MODE("COLOR_BURN", 1);
        COLOR_BURN = r10;
        OMaterialHelper$LEGACY_BLEND_MODE r11 = new OMaterialHelper$LEGACY_BLEND_MODE("COLOR_DODGE", 2);
        COLOR_DODGE = r11;
        OMaterialHelper$LEGACY_BLEND_MODE r12 = new OMaterialHelper$LEGACY_BLEND_MODE("PLUS_DARKER", 3);
        PLUS_DARKER = r12;
        OMaterialHelper$LEGACY_BLEND_MODE r13 = new OMaterialHelper$LEGACY_BLEND_MODE("PLUS_LIGHTER", 4);
        PLUS_LIGHTER = r13;
        OMaterialHelper$LEGACY_BLEND_MODE r14 = new OMaterialHelper$LEGACY_BLEND_MODE("LUMINOSITY", 5);
        LUMINOSITY = r14;
        OMaterialHelper$LEGACY_BLEND_MODE r15 = new OMaterialHelper$LEGACY_BLEND_MODE("OVERLAY", 6);
        OVERLAY = r15;
        OMaterialHelper$LEGACY_BLEND_MODE r16 = new OMaterialHelper$LEGACY_BLEND_MODE("SOFT_LIGHT", 7);
        SOFT_LIGHT = r16;
        f13606a = new OMaterialHelper$LEGACY_BLEND_MODE[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public static OMaterialHelper$LEGACY_BLEND_MODE valueOf(String r5) {
        return (OMaterialHelper$LEGACY_BLEND_MODE) Enum.valueOf(OMaterialHelper$LEGACY_BLEND_MODE.class, r5);
    }

    public static OMaterialHelper$LEGACY_BLEND_MODE[] values() {
        return (OMaterialHelper$LEGACY_BLEND_MODE[]) f13606a.clone();
    }
}
