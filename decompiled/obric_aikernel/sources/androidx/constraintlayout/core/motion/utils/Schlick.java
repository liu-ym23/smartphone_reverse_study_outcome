package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double eps;
    double mS;
    double mT;

    Schlick(String r10) {
        this.str = r10;
        int r11 = r10.indexOf(40);
        int r12 = r10.indexOf(44, r11);
        this.mS = Double.parseDouble(r10.substring(r11 + 1, r12).trim());
        int r13 = r12 + 1;
        this.mT = Double.parseDouble(r10.substring(r13, r10.indexOf(44, r13)).trim());
    }

    private double dfunc(double r13) {
        double r10 = this.mT;
        if (r13 >= r10) goto L6;
        double r11 = this.mS;
        return ((r11 * r10) * r10) / ((((r10 - r13) * r11) + r13) * ((r11 * (r10 - r13)) + r13));
    L6:
        double r12 = this.mS;
        return (((r10 - 1.0d) * r12) * (r10 - 1.0d)) / (((((-r12) * (r10 - r13)) - r13) + 1.0d) * ((((-r12) * (r10 - r13)) - r13) + 1.0d));
    }

    private double func(double r10) {
        double r11 = this.mT;
        if (r10 >= r11) goto L7;
        return (r11 * r10) / (r10 + (this.mS * (r11 - r10)));
    L7:
        return ((1.0d - r11) * (r10 - 1.0d)) / ((1.0d - r10) - (this.mS * (r11 - r10)));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double r10) {
        return func(r10);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double r10) {
        return dfunc(r10);
    }
}
