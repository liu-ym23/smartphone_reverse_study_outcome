package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final enum Variant extends Enum<Variant> {
    private static final /* synthetic */ Variant[] $VALUES = null;
    public static final Variant CONTENT = null;
    public static final Variant EXPRESSIVE = null;
    public static final Variant FIDELITY = null;
    public static final Variant FRUIT_SALAD = null;
    public static final Variant MONOCHROME = null;
    public static final Variant NEUTRAL = null;
    public static final Variant RAINBOW = null;
    public static final Variant TONAL_SPOT = null;
    public static final Variant VIBRANT = null;

    static {
        Variant r5 = new Variant("MONOCHROME", 0);
        MONOCHROME = r5;
        Variant r10 = new Variant("NEUTRAL", 1);
        NEUTRAL = r10;
        Variant r11 = new Variant("TONAL_SPOT", 2);
        TONAL_SPOT = r11;
        Variant r12 = new Variant("VIBRANT", 3);
        VIBRANT = r12;
        Variant r13 = new Variant("EXPRESSIVE", 4);
        EXPRESSIVE = r13;
        Variant r14 = new Variant("FIDELITY", 5);
        FIDELITY = r14;
        Variant r15 = new Variant("CONTENT", 6);
        CONTENT = r15;
        Variant r16 = new Variant("RAINBOW", 7);
        RAINBOW = r16;
        Variant r17 = new Variant("FRUIT_SALAD", 8);
        FRUIT_SALAD = r17;
        $VALUES = new Variant[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    private Variant(String r5, int r10) {
        super(r5, r10);
    }

    public static Variant valueOf(String r5) {
        return (Variant) Enum.valueOf(Variant.class, r5);
    }

    public static Variant[] values() {
        return (Variant[]) $VALUES.clone();
    }
}
