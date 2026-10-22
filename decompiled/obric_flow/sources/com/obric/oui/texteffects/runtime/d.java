package com.obric.oui.texteffects.runtime;

import com.obric.oui.texteffects.core.EffectProperty;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f14754a = null;

    static {
        int[] r5 = new int[EffectProperty.values().length];
        r5[EffectProperty.Alpha.ordinal()] = 1;
        r5[EffectProperty.Tracking.ordinal()] = 2;
        r5[EffectProperty.GradientAlphaScan.ordinal()] = 3;
        r5[EffectProperty.Visibility.ordinal()] = 4;
        r5[EffectProperty.BlurRadius.ordinal()] = 5;
        r5[EffectProperty.TranslationX.ordinal()] = 6;
        r5[EffectProperty.TranslationY.ordinal()] = 7;
        f14754a = r5;
    }
}
