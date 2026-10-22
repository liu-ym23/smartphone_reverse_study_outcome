package com.obric.oui.texteffects.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectProperty;", "", "Alpha", "BlurRadius", "TranslationX", "TranslationY", "Tracking", "GradientAlphaScan", "Visibility", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum EffectProperty extends Enum<EffectProperty> {
    public static final EffectProperty Alpha = null;
    public static final EffectProperty BlurRadius = null;
    public static final EffectProperty GradientAlphaScan = null;
    public static final EffectProperty Tracking = null;
    public static final EffectProperty TranslationX = null;
    public static final EffectProperty TranslationY = null;
    public static final EffectProperty Visibility = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EffectProperty[] f14733a = null;

    static {
        EffectProperty r5 = new EffectProperty("Alpha", 0);
        Alpha = r5;
        EffectProperty r10 = new EffectProperty("BlurRadius", 1);
        BlurRadius = r10;
        EffectProperty r11 = new EffectProperty("TranslationX", 2);
        TranslationX = r11;
        EffectProperty r12 = new EffectProperty("TranslationY", 3);
        TranslationY = r12;
        EffectProperty r13 = new EffectProperty("Tracking", 4);
        Tracking = r13;
        EffectProperty r14 = new EffectProperty("GradientAlphaScan", 5);
        GradientAlphaScan = r14;
        EffectProperty r15 = new EffectProperty("Visibility", 6);
        Visibility = r15;
        f14733a = new EffectProperty[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public static EffectProperty valueOf(String r5) {
        return (EffectProperty) Enum.valueOf(EffectProperty.class, r5);
    }

    public static EffectProperty[] values() {
        return (EffectProperty[]) f14733a.clone();
    }
}
