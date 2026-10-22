package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final enum TonePolarity extends Enum<TonePolarity> {
    private static final /* synthetic */ TonePolarity[] $VALUES = null;
    public static final TonePolarity DARKER = null;
    public static final TonePolarity FARTHER = null;
    public static final TonePolarity LIGHTER = null;
    public static final TonePolarity NEARER = null;

    static {
        TonePolarity r5 = new TonePolarity("DARKER", 0);
        DARKER = r5;
        TonePolarity r10 = new TonePolarity("LIGHTER", 1);
        LIGHTER = r10;
        TonePolarity r11 = new TonePolarity("NEARER", 2);
        NEARER = r11;
        TonePolarity r12 = new TonePolarity("FARTHER", 3);
        FARTHER = r12;
        $VALUES = new TonePolarity[]{r5, r10, r11, r12};
    }

    private TonePolarity(String r5, int r10) {
        super(r5, r10);
    }

    public static TonePolarity valueOf(String r5) {
        return (TonePolarity) Enum.valueOf(TonePolarity.class, r5);
    }

    public static TonePolarity[] values() {
        return (TonePolarity[]) $VALUES.clone();
    }
}
