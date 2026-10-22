package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Hct {
    private int argb;
    private double chroma;
    private double hue;
    private double tone;

    private Hct(int r5) {
        setInternalState(r5);
    }

    public static Hct from(double r5, double r10, double r11) {
        return new Hct(HctSolver.solveToInt(r5, r10, r11));
    }

    public static Hct fromInt(int r5) {
        return new Hct(r5);
    }

    private void setInternalState(int r5) {
        this.argb = r5;
        Cam16 r10 = Cam16.fromInt(r5);
        this.hue = r10.getHue();
        this.chroma = r10.getChroma();
        this.tone = ColorUtils.lstarFromArgb(r5);
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getTone() {
        return this.tone;
    }

    public Hct inViewingConditions(ViewingConditions r10) {
        double[] r11 = Cam16.fromInt(toInt()).xyzInViewingConditions(r10, null);
        Cam16 r5 = Cam16.fromXyzInViewingConditions(r11[0], r11[1], r11[2], ViewingConditions.DEFAULT);
        return from(r5.getHue(), r5.getChroma(), ColorUtils.lstarFromY(r11[1]));
    }

    public void setChroma(double r10) {
        setInternalState(HctSolver.solveToInt(this.hue, r10, this.tone));
    }

    public void setHue(double r10) {
        setInternalState(HctSolver.solveToInt(r10, this.chroma, this.tone));
    }

    public void setTone(double r10) {
        setInternalState(HctSolver.solveToInt(this.hue, this.chroma, r10));
    }

    public int toInt() {
        return this.argb;
    }
}
