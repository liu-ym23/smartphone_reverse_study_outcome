package com.obric.oui.texteffects.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/texteffects/core/BlendSpec;", "", "CLEAR", "SRC", "DST", "SRC_OVER", "DST_OVER", "SRC_IN", "DST_IN", "SRC_OUT", "DST_OUT", "SRC_ATOP", "DST_ATOP", "XOR", "PLUS", "MODULATE", "SCREEN", "OVERLAY", "DARKEN", "LIGHTEN", "COLOR_DODGE", "COLOR_BURN", "HARD_LIGHT", "SOFT_LIGHT", "DIFFERENCE", "EXCLUSION", "MULTIPLY", "HUE", "SATURATION", "COLOR", "LUMINOSITY", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum BlendSpec extends Enum<BlendSpec> {
    public static final BlendSpec CLEAR = null;
    public static final BlendSpec COLOR = null;
    public static final BlendSpec COLOR_BURN = null;
    public static final BlendSpec COLOR_DODGE = null;
    public static final BlendSpec DARKEN = null;
    public static final BlendSpec DIFFERENCE = null;
    public static final BlendSpec DST = null;
    public static final BlendSpec DST_ATOP = null;
    public static final BlendSpec DST_IN = null;
    public static final BlendSpec DST_OUT = null;
    public static final BlendSpec DST_OVER = null;
    public static final BlendSpec EXCLUSION = null;
    public static final BlendSpec HARD_LIGHT = null;
    public static final BlendSpec HUE = null;
    public static final BlendSpec LIGHTEN = null;
    public static final BlendSpec LUMINOSITY = null;
    public static final BlendSpec MODULATE = null;
    public static final BlendSpec MULTIPLY = null;
    public static final BlendSpec OVERLAY = null;
    public static final BlendSpec PLUS = null;
    public static final BlendSpec SATURATION = null;
    public static final BlendSpec SCREEN = null;
    public static final BlendSpec SOFT_LIGHT = null;
    public static final BlendSpec SRC = null;
    public static final BlendSpec SRC_ATOP = null;
    public static final BlendSpec SRC_IN = null;
    public static final BlendSpec SRC_OUT = null;
    public static final BlendSpec SRC_OVER = null;
    public static final BlendSpec XOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlendSpec[] f14731a = null;

    static {
        BlendSpec r5 = new BlendSpec("CLEAR", 0);
        CLEAR = r5;
        BlendSpec r10 = new BlendSpec("SRC", 1);
        SRC = r10;
        BlendSpec r11 = new BlendSpec("DST", 2);
        DST = r11;
        BlendSpec r12 = new BlendSpec("SRC_OVER", 3);
        SRC_OVER = r12;
        BlendSpec r13 = new BlendSpec("DST_OVER", 4);
        DST_OVER = r13;
        BlendSpec r14 = new BlendSpec("SRC_IN", 5);
        SRC_IN = r14;
        BlendSpec r15 = new BlendSpec("DST_IN", 6);
        DST_IN = r15;
        BlendSpec r16 = new BlendSpec("SRC_OUT", 7);
        SRC_OUT = r16;
        BlendSpec r17 = new BlendSpec("DST_OUT", 8);
        DST_OUT = r17;
        BlendSpec r18 = new BlendSpec("SRC_ATOP", 9);
        SRC_ATOP = r18;
        BlendSpec r19 = new BlendSpec("DST_ATOP", 10);
        DST_ATOP = r19;
        BlendSpec r110 = new BlendSpec("XOR", 11);
        XOR = r110;
        BlendSpec r111 = new BlendSpec("PLUS", 12);
        PLUS = r111;
        BlendSpec r112 = new BlendSpec("MODULATE", 13);
        MODULATE = r112;
        BlendSpec r113 = new BlendSpec("SCREEN", 14);
        SCREEN = r113;
        BlendSpec r114 = new BlendSpec("OVERLAY", 15);
        OVERLAY = r114;
        BlendSpec r115 = new BlendSpec("DARKEN", 16);
        DARKEN = r115;
        BlendSpec r116 = new BlendSpec("LIGHTEN", 17);
        LIGHTEN = r116;
        BlendSpec r117 = new BlendSpec("COLOR_DODGE", 18);
        COLOR_DODGE = r117;
        BlendSpec r118 = new BlendSpec("COLOR_BURN", 19);
        COLOR_BURN = r118;
        BlendSpec r119 = new BlendSpec("HARD_LIGHT", 20);
        HARD_LIGHT = r119;
        BlendSpec r120 = new BlendSpec("SOFT_LIGHT", 21);
        SOFT_LIGHT = r120;
        BlendSpec r121 = new BlendSpec("DIFFERENCE", 22);
        DIFFERENCE = r121;
        BlendSpec r122 = new BlendSpec("EXCLUSION", 23);
        EXCLUSION = r122;
        BlendSpec r123 = new BlendSpec("MULTIPLY", 24);
        MULTIPLY = r123;
        BlendSpec r124 = new BlendSpec("HUE", 25);
        HUE = r124;
        BlendSpec r125 = new BlendSpec("SATURATION", 26);
        SATURATION = r125;
        BlendSpec r126 = new BlendSpec("COLOR", 27);
        COLOR = r126;
        BlendSpec r127 = new BlendSpec("LUMINOSITY", 28);
        LUMINOSITY = r127;
        f14731a = new BlendSpec[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
    }

    public static BlendSpec valueOf(String r5) {
        return (BlendSpec) Enum.valueOf(BlendSpec.class, r5);
    }

    public static BlendSpec[] values() {
        return (BlendSpec[]) f14731a.clone();
    }
}
