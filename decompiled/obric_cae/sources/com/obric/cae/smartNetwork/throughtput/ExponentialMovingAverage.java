package com.obric.cae.smartNetwork.throughtput;

/* JADX INFO: loaded from: classes2.dex */
public class ExponentialMovingAverage {
    private double alpha;
    private Double ema;

    public ExponentialMovingAverage(double r8) {
        if (r8 <= 0.0d) goto L9;
        if (r8 >= 1.0d) goto L9;
        this.alpha = r8;
        this.ema = null;
        return;
    L9:
        throw new IllegalArgumentException("The smoothing coefficient alpha should be between 0 and 1.");
    }

    public double add(double r8) {
        Double r10 = this.ema;
        if (r10 != null) goto L5;
        Double r11 = Double.valueOf(r8);
    L6:
        this.ema = r11;
        return this.ema.doubleValue();
    L5:
        double r12 = this.alpha;
        double r13 = r10.doubleValue();
        double r14 = r13 * (1.0d - r12);
        r11 = Double.valueOf(r14 + (r8 * r12));
        goto L6
    }

    public double getCurrentEma() {
        Double r8 = this.ema;
        if (r8 != null) goto L7;
        return -1.0d;
    L7:
        return r8.doubleValue();
    }
}
