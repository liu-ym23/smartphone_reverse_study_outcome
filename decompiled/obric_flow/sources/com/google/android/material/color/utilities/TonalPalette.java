package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TonalPalette {
    Map<Integer, Integer> cache;
    double chroma;
    double hue;
    Hct keyColor;

    private TonalPalette(double r5, double r10, Hct r11) {
        this.cache = new HashMap();
        this.hue = r5;
        this.chroma = r10;
        this.keyColor = r11;
    }

    private static Hct createKeyColor(double r15, double r17) {
        Hct r5 = Hct.from(r15, r17, 50.0d);
        Hct r10 = r5;
        double r11 = Math.abs(r5.getChroma() - r17);
        double r13 = 1.0d;
    L4:
        if (r13 >= 50.0d) goto L15;
        if (Math.round(r17) == Math.round(r10.getChroma())) goto L7;
        Hct r12 = Hct.from(r15, r17, 50.0d + r13);
        double r14 = Math.abs(r12.getChroma() - r17);
        if (r14 >= r11) goto L11;
        r10 = r12;
        r11 = r14;
    L11:
        Hct r16 = Hct.from(r15, r17, 50.0d - r13);
        double r18 = Math.abs(r16.getChroma() - r17);
        if (r18 >= r11) goto L14;
        r10 = r16;
        r11 = r18;
    L14:
        r13 = r13 + 1.0d;
        goto L4
    L7:
        return r10;
    L15:
        return r10;
    }

    public static TonalPalette fromHct(Hct r10) {
        return new TonalPalette(r10.getHue(), r10.getChroma(), r10);
    }

    public static TonalPalette fromHueAndChroma(double r10, double r11) {
        return new TonalPalette(r10, r11, createKeyColor(r10, r11));
    }

    public static TonalPalette fromInt(int r5) {
        return fromHct(Hct.fromInt(r5));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double r10) {
        return Hct.from(this.hue, this.chroma, r10);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int r10) {
        Integer r5 = this.cache.get(Integer.valueOf(r10));
        if (r5 != null) goto L6;
        r5 = Integer.valueOf(Hct.from(this.hue, this.chroma, r10).toInt());
        this.cache.put(Integer.valueOf(r10), r5);
    L6:
        return r5.intValue();
    }
}
