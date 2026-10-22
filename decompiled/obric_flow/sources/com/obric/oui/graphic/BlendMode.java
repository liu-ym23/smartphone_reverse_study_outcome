package com.obric.oui.graphic;

import android.graphics.PorterDuff;
import androidx.annotation.RequiresApi;
import com.obric.oui.material.OMaterialHelper$LEGACY_BLEND_MODE;
import qr.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum BlendMode extends Enum<BlendMode> {
    public static final BlendMode[] BLEND_MODES = null;
    public static final BlendMode CLEAR = null;
    public static final BlendMode COLOR = null;
    public static final BlendMode COLOR_BURN = null;
    public static final BlendMode COLOR_DODGE = null;
    public static final BlendMode DARKEN = null;
    public static final BlendMode DIFFERENCE = null;
    public static final BlendMode DST = null;
    public static final BlendMode DST_ATOP = null;
    public static final BlendMode DST_IN = null;
    public static final BlendMode DST_OUT = null;
    public static final BlendMode DST_OVER = null;
    public static final BlendMode EXCLUSION = null;
    public static final BlendMode HARD_LIGHT = null;
    public static final BlendMode HUE = null;
    public static final BlendMode LIGHTEN = null;
    public static final BlendMode LUMINOSITY = null;
    public static final BlendMode MODULATE = null;
    public static final BlendMode MULTIPLY = null;
    public static final BlendMode OVERLAY = null;
    public static final BlendMode PLUS = null;
    public static final BlendMode PLUS_DARKER = null;
    public static final BlendMode PLUS_LIGHTER = null;
    public static final BlendMode SATURATION = null;
    public static final BlendMode SCREEN = null;
    public static final BlendMode SOFT_LIGHT = null;
    public static final BlendMode SRC = null;
    public static final BlendMode SRC_ATOP = null;
    public static final BlendMode SRC_IN = null;
    public static final BlendMode SRC_OUT = null;
    public static final BlendMode SRC_OVER = null;
    public static final BlendMode XOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlendMode[] f13370a = null;
    public final int porterDuffMode;

    static {
        BlendMode r5 = new BlendMode("CLEAR", 0, 0);
        CLEAR = r5;
        BlendMode r10 = new BlendMode("SRC", 1, 1);
        SRC = r10;
        BlendMode r11 = new BlendMode("DST", 2, 2);
        DST = r11;
        BlendMode r12 = new BlendMode("SRC_OVER", 3, 3);
        SRC_OVER = r12;
        BlendMode r13 = new BlendMode("DST_OVER", 4, 4);
        DST_OVER = r13;
        BlendMode r14 = new BlendMode("SRC_IN", 5, 5);
        SRC_IN = r14;
        BlendMode r15 = new BlendMode("DST_IN", 6, 6);
        DST_IN = r15;
        BlendMode r16 = new BlendMode("SRC_OUT", 7, 7);
        SRC_OUT = r16;
        BlendMode r17 = new BlendMode("DST_OUT", 8, 8);
        DST_OUT = r17;
        BlendMode r18 = new BlendMode("SRC_ATOP", 9, 9);
        SRC_ATOP = r18;
        BlendMode r19 = new BlendMode("DST_ATOP", 10, 10);
        DST_ATOP = r19;
        BlendMode r110 = new BlendMode("XOR", 11, 11);
        XOR = r110;
        BlendMode r111 = new BlendMode("PLUS", 12, 12);
        PLUS = r111;
        BlendMode r112 = new BlendMode("MODULATE", 13, 13);
        MODULATE = r112;
        BlendMode r20 = new BlendMode("SCREEN", 14, 14);
        SCREEN = r20;
        BlendMode r21 = new BlendMode("OVERLAY", 15, 15);
        OVERLAY = r21;
        BlendMode r22 = new BlendMode("DARKEN", 16, 16);
        DARKEN = r22;
        BlendMode r23 = new BlendMode("LIGHTEN", 17, 17);
        LIGHTEN = r23;
        BlendMode r24 = new BlendMode("COLOR_DODGE", 18, 18);
        COLOR_DODGE = r24;
        BlendMode r25 = new BlendMode("COLOR_BURN", 19, 19);
        COLOR_BURN = r25;
        BlendMode r26 = new BlendMode("HARD_LIGHT", 20, 20);
        HARD_LIGHT = r26;
        BlendMode r27 = new BlendMode("SOFT_LIGHT", 21, 21);
        SOFT_LIGHT = r27;
        BlendMode r28 = new BlendMode("DIFFERENCE", 22, 22);
        DIFFERENCE = r28;
        BlendMode r29 = new BlendMode("EXCLUSION", 23, 23);
        EXCLUSION = r29;
        BlendMode r30 = new BlendMode("MULTIPLY", 24, 24);
        MULTIPLY = r30;
        BlendMode r31 = new BlendMode("HUE", 25, 25);
        HUE = r31;
        BlendMode r32 = new BlendMode("SATURATION", 26, 26);
        SATURATION = r32;
        BlendMode r33 = new BlendMode("COLOR", 27, 27);
        COLOR = r33;
        BlendMode r34 = new BlendMode("LUMINOSITY", 28, 28);
        LUMINOSITY = r34;
        BlendMode r35 = new BlendMode("PLUS_DARKER", 29, 101);
        PLUS_DARKER = r35;
        BlendMode r36 = new BlendMode("PLUS_LIGHTER", 30, 102);
        PLUS_LIGHTER = r36;
        f13370a = new BlendMode[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36};
        BLEND_MODES = values();
    }

    public BlendMode(String r5, int r10, int r11) {
        super(r5, r10);
        this.porterDuffMode = r11;
    }

    public static PorterDuff.Mode blendModeToPorterDuffMode(BlendMode r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        switch(a.f21563a[r5.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            default: goto L7;
        };
    L7:
        return null;
    L9:
        return PorterDuff.Mode.OVERLAY;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.LIGHTEN;
    L19:
        return PorterDuff.Mode.DARKEN;
    L21:
        return PorterDuff.Mode.XOR;
    L23:
        return PorterDuff.Mode.DST_ATOP;
    L25:
        return PorterDuff.Mode.SRC_ATOP;
    L27:
        return PorterDuff.Mode.DST_OUT;
    L29:
        return PorterDuff.Mode.SRC_OUT;
    L31:
        return PorterDuff.Mode.DST_IN;
    L33:
        return PorterDuff.Mode.SRC_IN;
    L35:
        return PorterDuff.Mode.DST_OVER;
    L37:
        return PorterDuff.Mode.SRC_OVER;
    L39:
        return PorterDuff.Mode.DST;
    L41:
        return PorterDuff.Mode.SRC;
    L43:
        return PorterDuff.Mode.CLEAR;
    }

    public static BlendMode fromValue(int r5) {
        BlendMode[] r10 = BLEND_MODES;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        BlendMode r13 = r10[r12];
        if (r13.porterDuffMode == r5) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return null;
    }

    public static int mapToLegacyObricBlend(int r5) {
        return mapToLegacyObricBlend(r5, false);
    }

    @RequiresApi(29)
    public static android.graphics.BlendMode toAndroidBlendMode(BlendMode r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        switch(a.f21563a[r5.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            default: goto L7;
        };
    L7:
        return null;
    L9:
        return android.graphics.BlendMode.OVERLAY;
    L11:
        return android.graphics.BlendMode.PLUS;
    L13:
        return android.graphics.BlendMode.SCREEN;
    L15:
        return android.graphics.BlendMode.MULTIPLY;
    L17:
        return android.graphics.BlendMode.LIGHTEN;
    L19:
        return android.graphics.BlendMode.DARKEN;
    L21:
        return android.graphics.BlendMode.XOR;
    L23:
        return android.graphics.BlendMode.DST_ATOP;
    L25:
        return android.graphics.BlendMode.SRC_ATOP;
    L27:
        return android.graphics.BlendMode.DST_OUT;
    L29:
        return android.graphics.BlendMode.SRC_OUT;
    L31:
        return android.graphics.BlendMode.DST_IN;
    L33:
        return android.graphics.BlendMode.SRC_IN;
    L35:
        return android.graphics.BlendMode.DST_OVER;
    L37:
        return android.graphics.BlendMode.SRC_OVER;
    L39:
        return android.graphics.BlendMode.DST;
    L41:
        return android.graphics.BlendMode.SRC;
    L43:
        return android.graphics.BlendMode.CLEAR;
    }

    public static int toValue(BlendMode r5) {
        return r5.porterDuffMode;
    }

    public static BlendMode valueOf(String r5) {
        return (BlendMode) Enum.valueOf(BlendMode.class, r5);
    }

    public static BlendMode[] values() {
        return (BlendMode[]) f13370a.clone();
    }

    public int getPorterDuffMode() {
        return this.porterDuffMode;
    }

    public static int mapToLegacyObricBlend(int r5, boolean r10) {
        if (r10 == true) goto L5;
        return r5;
    L5:
        if (r5 != SRC_OVER.ordinal()) goto L9;
        return OMaterialHelper$LEGACY_BLEND_MODE.DEFAULT.ordinal();
    L9:
        if (r5 != COLOR_BURN.ordinal()) goto L13;
        return OMaterialHelper$LEGACY_BLEND_MODE.COLOR_BURN.ordinal();
    L13:
        if (r5 != COLOR_DODGE.ordinal()) goto L17;
        return OMaterialHelper$LEGACY_BLEND_MODE.COLOR_DODGE.ordinal();
    L17:
        if (r5 != PLUS_DARKER.ordinal()) goto L21;
        return OMaterialHelper$LEGACY_BLEND_MODE.PLUS_DARKER.ordinal();
    L21:
        if (r5 != PLUS_LIGHTER.ordinal()) goto L25;
        return OMaterialHelper$LEGACY_BLEND_MODE.PLUS_LIGHTER.ordinal();
    L25:
        if (r5 != LUMINOSITY.ordinal()) goto L29;
        return OMaterialHelper$LEGACY_BLEND_MODE.LUMINOSITY.ordinal();
    L29:
        if (r5 != OVERLAY.ordinal()) goto L33;
        return OMaterialHelper$LEGACY_BLEND_MODE.OVERLAY.ordinal();
    L33:
        if (r5 != SOFT_LIGHT.ordinal()) goto L37;
        return OMaterialHelper$LEGACY_BLEND_MODE.SOFT_LIGHT.ordinal();
    L37:
        return OMaterialHelper$LEGACY_BLEND_MODE.DEFAULT.ordinal();
    }

    public static int mapToLegacyObricBlend(BlendMode r5) {
        return mapToLegacyObricBlend(r5, false);
    }

    public static int mapToLegacyObricBlend(BlendMode r5, boolean r10) {
        if (r10 == true) goto L8;
        if (r5 != null) goto L6;
        r5 = SRC_OVER;
    L6:
        return r5.porterDuffMode;
    L8:
        if (r5 != SRC_OVER) goto L12;
        return OMaterialHelper$LEGACY_BLEND_MODE.DEFAULT.ordinal();
    L12:
        if (r5 != COLOR_BURN) goto L16;
        return OMaterialHelper$LEGACY_BLEND_MODE.COLOR_BURN.ordinal();
    L16:
        if (r5 != COLOR_DODGE) goto L20;
        return OMaterialHelper$LEGACY_BLEND_MODE.COLOR_DODGE.ordinal();
    L20:
        if (r5 != PLUS_DARKER) goto L24;
        return OMaterialHelper$LEGACY_BLEND_MODE.PLUS_DARKER.ordinal();
    L24:
        if (r5 != PLUS_LIGHTER) goto L28;
        return OMaterialHelper$LEGACY_BLEND_MODE.PLUS_LIGHTER.ordinal();
    L28:
        if (r5 != LUMINOSITY) goto L32;
        return OMaterialHelper$LEGACY_BLEND_MODE.LUMINOSITY.ordinal();
    L32:
        if (r5 != OVERLAY) goto L36;
        return OMaterialHelper$LEGACY_BLEND_MODE.OVERLAY.ordinal();
    L36:
        if (r5 != SOFT_LIGHT) goto L40;
        return OMaterialHelper$LEGACY_BLEND_MODE.SOFT_LIGHT.ordinal();
    L40:
        return OMaterialHelper$LEGACY_BLEND_MODE.DEFAULT.ordinal();
    }
}
