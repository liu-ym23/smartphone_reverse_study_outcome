package com.obric.oui.texteffects;

import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.TextSource;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f14729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f14730b = null;

    static {
        int[] r5 = new int[TextSource.values().length];
        r5[TextSource.Current.ordinal()] = 1;
        r5[TextSource.Old.ordinal()] = 2;
        r5[TextSource.New.ordinal()] = 3;
        f14729a = r5;
        int[] r10 = new int[BlendSpec.values().length];
        r10[BlendSpec.CLEAR.ordinal()] = 1;
        r10[BlendSpec.SRC.ordinal()] = 2;
        r10[BlendSpec.DST.ordinal()] = 3;
        r10[BlendSpec.SRC_OVER.ordinal()] = 4;
        r10[BlendSpec.DST_OVER.ordinal()] = 5;
        r10[BlendSpec.SRC_IN.ordinal()] = 6;
        r10[BlendSpec.DST_IN.ordinal()] = 7;
        r10[BlendSpec.SRC_OUT.ordinal()] = 8;
        r10[BlendSpec.DST_OUT.ordinal()] = 9;
        r10[BlendSpec.SRC_ATOP.ordinal()] = 10;
        r10[BlendSpec.DST_ATOP.ordinal()] = 11;
        r10[BlendSpec.XOR.ordinal()] = 12;
        r10[BlendSpec.PLUS.ordinal()] = 13;
        r10[BlendSpec.MODULATE.ordinal()] = 14;
        r10[BlendSpec.SCREEN.ordinal()] = 15;
        r10[BlendSpec.OVERLAY.ordinal()] = 16;
        r10[BlendSpec.DARKEN.ordinal()] = 17;
        r10[BlendSpec.LIGHTEN.ordinal()] = 18;
        r10[BlendSpec.COLOR_DODGE.ordinal()] = 19;
        r10[BlendSpec.COLOR_BURN.ordinal()] = 20;
        r10[BlendSpec.HARD_LIGHT.ordinal()] = 21;
        r10[BlendSpec.SOFT_LIGHT.ordinal()] = 22;
        r10[BlendSpec.DIFFERENCE.ordinal()] = 23;
        r10[BlendSpec.EXCLUSION.ordinal()] = 24;
        r10[BlendSpec.MULTIPLY.ordinal()] = 25;
        r10[BlendSpec.HUE.ordinal()] = 26;
        r10[BlendSpec.SATURATION.ordinal()] = 27;
        r10[BlendSpec.COLOR.ordinal()] = 28;
        r10[BlendSpec.LUMINOSITY.ordinal()] = 29;
        f14730b = r10;
    }
}
