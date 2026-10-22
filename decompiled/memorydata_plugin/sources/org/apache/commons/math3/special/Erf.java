package org.apache.commons.math3.special;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Erf {
    public static double erf(double r10) {
        if (FastMath.abs(r10) > 40.0d) goto L5;
        double r3 = Gamma.regularizedGammaP(0.5d, r10 * r10, 1.0E-15d, 10000);
        if (r10 < 0.0d) goto L12;
        return r3;
    L12:
        return -r3;
    L5:
        if (r10 <= 0.0d) goto L7;
        return 1.0d;
    L7:
        return -1.0d;
    }

    public static double erf(double r5, double r7) {
        if (r5 <= r7) goto L7;
        return -erf(r7, r5);
    L7:
        if (r5 >= (-0.4769362762044697d)) goto L12;
        if (r7 >= 0.0d) goto L16;
        double r8 = erfc(-r7);
        double r6 = erfc(-r5);
    L18:
        return r8 - r6;
    L16:
        r8 = erf(r7);
        r6 = erf(r5);
        goto L18
    L12:
        if (r7 <= 0.4769362762044697d) goto L16;
        if (r5 <= 0.0d) goto L16;
        return erfc(r5) - erfc(r7);
    }

    public static double erfInv(double r6) {
        double r0 = -FastMath.log((1.0d - r6) * (1.0d + r6));
        if (r0 >= 6.25d) goto L7;
        double r1 = r0 - 3.125d;
        double r2 = ((((((((((((((((((((((((((((((((((((((((((-3.64441206401782E-21d) * r1) - 1.6850591381820166E-19d) * r1) + 1.28584807152564E-18d) * r1) + 1.1157877678025181E-17d) * r1) - 1.333171662854621E-16d) * r1) + 2.0972767875968562E-17d) * r1) + 6.637638134358324E-15d) * r1) - 4.054566272975207E-14d) * r1) - 8.151934197605472E-14d) * r1) + 2.6335093153082323E-12d) * r1) - 1.2975133253453532E-11d) * r1) - 5.415412054294628E-11d) * r1) + 1.0512122733215323E-9d) * r1) - 4.112633980346984E-9d) * r1) - 2.9070369957882005E-8d) * r1) + 4.2347877827932404E-7d) * r1) - 1.3654692000834679E-6d) * r1) - 1.3882523362786469E-5d) * r1) + 1.8673420803405714E-4d) * r1) - 7.40702534166267E-4d) * r1) - 0.006033670871430149d) * r1) + 0.24015818242558962d;
        double r4 = 1.6536545626831027d;
    L5:
        double r3 = (r2 * r1) + r4;
    L14:
        return r3 * r6;
    L7:
        if (r0 >= 16.0d) goto L10;
        r1 = FastMath.sqrt(r0) - 3.25d;
        r2 = (((((((((((((((((((((((((((((((((2.2137376921775787E-9d * r1) + 9.075656193888539E-8d) * r1) - 2.7517406297064545E-7d) * r1) + 1.8239629214389228E-8d) * r1) + 1.5027403968909828E-6d) * r1) - 4.013867526981546E-6d) * r1) + 2.9234449089955446E-6d) * r1) + 1.2475304481671779E-5d) * r1) - 4.7318229009055734E-5d) * r1) + 6.828485145957318E-5d) * r1) + 2.4031110387097894E-5d) * r1) - 3.550375203628475E-4d) * r1) + 9.532893797373805E-4d) * r1) - 0.0016882755560235047d) * r1) + 0.002491442096107851d) * r1) - 0.003751208507569241d) * r1) + 0.005370914553590064d) * r1) + 1.0052589676941592d;
        r4 = 3.0838856104922208d;
        goto L5
    L10:
        if (Double.isInfinite(r0) == true) goto L12;
        r1 = FastMath.sqrt(r0) - 5.0d;
        r2 = ((((((((((((((((((((((((((((((-2.7109920616438573E-11d) * r1) - 2.555641816996525E-10d) * r1) + 1.5076572693500548E-9d) * r1) - 3.789465440126737E-9d) * r1) + 7.61570120807834E-9d) * r1) - 1.496002662714924E-8d) * r1) + 2.914795345090108E-8d) * r1) - 6.771199775845234E-8d) * r1) + 2.2900482228026655E-7d) * r1) - 9.9298272942317E-7d) * r1) + 4.526062597223154E-6d) * r1) - 1.968177810553167E-5d) * r1) + 7.599527703001776E-5d) * r1) - 2.1503011930044477E-4d) * r1) - 1.3871931833623122E-4d) * r1) + 1.0103004648645344d;
        r4 = 4.849906401408584d;
        goto L5
    L12:
        r3 = Double.POSITIVE_INFINITY;
        goto L14
    }

    public static double erfc(double r12) {
        if (FastMath.abs(r12) > 40.0d) goto L5;
        double r5 = Gamma.regularizedGammaQ(0.5d, r12 * r12, 1.0E-15d, 10000);
        if (r12 < 0.0d) goto L11;
        return r5;
    L11:
        return 2.0d - r5;
    L5:
        if (r12 > 0.0d) goto L7;
        return 2.0d;
    L7:
        return 0.0d;
    }

    public static double erfcInv(double r2) {
        return erfInv(1.0d - r2);
    }
}
