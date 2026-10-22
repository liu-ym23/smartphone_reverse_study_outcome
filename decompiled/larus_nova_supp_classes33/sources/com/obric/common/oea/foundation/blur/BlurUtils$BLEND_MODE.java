package com.obric.common.oea.foundation.blur;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final enum BlurUtils$BLEND_MODE extends Enum<BlurUtils$BLEND_MODE> {
    public static final BlurUtils$BLEND_MODE COLOR_BURN = null;
    public static final BlurUtils$BLEND_MODE COLOR_DODGE = null;
    public static final BlurUtils$BLEND_MODE DEFAULT = null;
    public static final BlurUtils$BLEND_MODE LUMINOSITY = null;
    public static final BlurUtils$BLEND_MODE OVERLAY = null;
    public static final BlurUtils$BLEND_MODE PLUS_DARKER = null;
    public static final BlurUtils$BLEND_MODE PLUS_LIGHTER = null;
    public static final BlurUtils$BLEND_MODE SOFT_LIGHT = null;
    public static final /* synthetic */ BlurUtils$BLEND_MODE[] a = null;

    static {
        BlurUtils$BLEND_MODE r0 = new BlurUtils$BLEND_MODE("DEFAULT", 0);
        DEFAULT = r0;
        BlurUtils$BLEND_MODE r1 = new BlurUtils$BLEND_MODE("COLOR_BURN", 1);
        COLOR_BURN = r1;
        BlurUtils$BLEND_MODE r3 = new BlurUtils$BLEND_MODE("COLOR_DODGE", 2);
        COLOR_DODGE = r3;
        BlurUtils$BLEND_MODE r5 = new BlurUtils$BLEND_MODE("PLUS_DARKER", 3);
        PLUS_DARKER = r5;
        BlurUtils$BLEND_MODE r7 = new BlurUtils$BLEND_MODE("PLUS_LIGHTER", 4);
        PLUS_LIGHTER = r7;
        BlurUtils$BLEND_MODE r9 = new BlurUtils$BLEND_MODE("LUMINOSITY", 5);
        LUMINOSITY = r9;
        BlurUtils$BLEND_MODE r11 = new BlurUtils$BLEND_MODE("OVERLAY", 6);
        OVERLAY = r11;
        BlurUtils$BLEND_MODE r13 = new BlurUtils$BLEND_MODE("SOFT_LIGHT", 7);
        SOFT_LIGHT = r13;
        a = new BlurUtils$BLEND_MODE[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public static BlurUtils$BLEND_MODE[] values() {
        return (BlurUtils$BLEND_MODE[]) a.clone();
    }

    public static BlurUtils$BLEND_MODE valueOf(String r1) {
        return (BlurUtils$BLEND_MODE) a.a(BlurUtils$BLEND_MODE.class, r1);
    }

    public BlurUtils$BLEND_MODE(String r1, int r2) {
        super(r1, r2);
    }
}
