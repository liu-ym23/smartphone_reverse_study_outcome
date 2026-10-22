package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TemperatureCache {
    private final Hct input;
    private Hct precomputedComplement;
    private List<Hct> precomputedHctsByHue;
    private List<Hct> precomputedHctsByTemp;
    private Map<Hct, Double> precomputedTempsByHct;

    private TemperatureCache() {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ Double a(TemperatureCache r5, Hct r10) {
        return r5.lambda$getHctsByTemp$0(r10);
    }

    private Hct getColdest() {
        return getHctsByTemp().get(0);
    }

    private List<Hct> getHctsByHue() {
        List<Hct> r5 = this.precomputedHctsByHue;
        if (r5 == null) goto L5;
        return r5;
    L5:
        ArrayList r10 = new ArrayList();
        double r11 = 0.0d;
    L7:
        if (r11 > 360.0d) goto L9;
        double r12 = this.input.getChroma();
        double r13 = this.input.getTone();
        r10.add(Hct.from(r11, r12, r13));
        r11 = r11 + 1.0d;
        goto L7
    L9:
        List<Hct> r14 = Collections.unmodifiableList(r10);
        this.precomputedHctsByHue = r14;
        return r14;
    }

    private List<Hct> getHctsByTemp() {
        List<Hct> r5 = this.precomputedHctsByTemp;
        if (r5 == null) goto L5;
        return r5;
    L5:
        ArrayList r10 = new ArrayList(getHctsByHue());
        r10.add(this.input);
        Collections.sort(r10, Comparator.comparing(new a(this, 2), new androidx.room.vo.a(1)));
        this.precomputedHctsByTemp = r10;
        return r10;
    }

    private Map<Hct, Double> getTempsByHct() {
        Map<Hct, Double> r5 = this.precomputedTempsByHct;
        if (r5 == null) goto L5;
        return r5;
    L5:
        ArrayList r10 = new ArrayList(getHctsByHue());
        r10.add(this.input);
        HashMap r11 = new HashMap();
        Iterator r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Hct r13 = (Hct) r12.next();
        r11.put(r13, Double.valueOf(rawTemperature(r13)));
        goto L7
    L9:
        this.precomputedTempsByHct = r11;
        return r11;
    }

    private Hct getWarmest() {
        return getHctsByTemp().get(getHctsByTemp().size() - 1);
    }

    private static boolean isBetween(double r5, double r10, double r11) {
        if (r10 >= r11) goto L11;
        if (r10 <= r5) goto L7;
        return false;
    L7:
        if (r5 <= r11) goto L9;
        return false;
    L9:
        return true;
    L11:
        if (r10 <= r5) goto L15;
        if (r5 <= r11) goto L15;
        return false;
    L15:
        return true;
    }

    private /* synthetic */ Double lambda$getHctsByTemp$0(Hct r5) {
        return getTempsByHct().get(r5);
    }

    public static double rawTemperature(Hct r10) {
        double[] r11 = ColorUtils.labFromArgb(r10.toInt());
        double r5 = MathUtils.sanitizeDegreesDouble(Math.toDegrees(Math.atan2(r11[2], r11[1])));
        return (Math.cos(Math.toRadians(MathUtils.sanitizeDegreesDouble(r5 - 50.0d))) * (Math.pow(Math.hypot(r11[1], r11[2]), 1.07d) * 0.02d)) - 0.5d;
    }

    public List<Hct> getAnalogousColors() {
        return getAnalogousColors(5, 12);
    }

    public Hct getComplement() {
        Hct r5 = this.precomputedComplement;
        if (r5 == null) goto L5;
        return r5;
    L5:
        double r10 = getColdest().getHue();
        double r11 = getTempsByHct().get(getColdest()).doubleValue();
        double r12 = getWarmest().getHue();
        double r14 = getTempsByHct().get(getWarmest()).doubleValue() - r11;
        boolean r13 = isBetween(this.input.getHue(), r10, r12);
        if (r13 == false) goto L8;
        double r16 = r12;
    L9:
        if (r13 == true) goto L12;
        r10 = r12;
    L12:
        Hct r15 = getHctsByHue().get((int) Math.round(this.input.getHue()));
        double r18 = 1.0d - getRelativeTemperature(this.input);
        double r20 = 1000.0d;
        double r22 = 0.0d;
    L14:
        if (r22 > 360.0d) goto L22;
        double r24 = MathUtils.sanitizeDegreesDouble((1.0d * r22) + r16);
        if (isBetween(r24, r16, r10) == false) goto L21;
        Hct r17 = getHctsByHue().get((int) Math.round(r24));
        double r19 = Math.abs(r18 - ((getTempsByHct().get(r17).doubleValue() - r11) / r14));
        if (r19 >= r20) goto L21;
        r15 = r17;
        r20 = r19;
    L21:
        r22 = r22 + 1.0d;
        goto L14
    L22:
        this.precomputedComplement = r15;
        return r15;
    L8:
        r16 = r10;
        goto L9
    }

    public double getRelativeTemperature(Hct r5) {
        double r10 = getTempsByHct().get(getWarmest()).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        double r11 = getTempsByHct().get(r5).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        if (r10 != 0.0d) goto L7;
        return 0.5d;
    L7:
        return r11 / r10;
    }

    public List<Hct> getAnalogousColors(int r19, int r20) {
        int r5 = (int) Math.round(this.input.getHue());
        Hct r10 = getHctsByHue().get(r5);
        double r11 = getRelativeTemperature(r10);
        ArrayList r12 = new ArrayList();
        r12.add(r10);
        double r13 = 0.0d;
        double r14 = 0.0d;
        int r15 = 0;
    L4:
        if (r15 >= 360) goto L6;
        double r16 = getRelativeTemperature(getHctsByHue().get(MathUtils.sanitizeDegreesInt(r5 + r15)));
        r14 = r14 + Math.abs(r16 - r11);
        r15 = r15 + 1;
        r11 = r16;
        goto L4
    L6:
        double r17 = r14 / ((double) r20);
        double r18 = getRelativeTemperature(r10);
        int r110 = 1;
    L8:
        if (r12.size() >= r20) goto L28;
        Hct r21 = getHctsByHue().get(MathUtils.sanitizeDegreesInt(r5 + r110));
        double r111 = getRelativeTemperature(r21);
        r13 = r13 + Math.abs(r111 - r18);
        if (r13 < (((double) r12.size()) * r17)) goto L12;
        boolean r22 = true;
    L13:
        int r23 = 1;
    L14:
        if (r22 == false) goto L22;
        if (r12.size() >= r20) goto L22;
        r12.add(r21);
        if (r13 < (((double) (r12.size() + r23)) * r17)) goto L20;
        r22 = true;
    L21:
        r23 = r23 + 1;
        goto L14
    L20:
        r22 = false;
    L22:
        r110 = r110 + 1;
        if (r110 > 360) goto L25;
        r18 = r111;
    L25:
        if (r12.size() >= r20) goto L28;
        r12.add(r21);
        goto L25
    L12:
        r22 = false;
    L28:
        ArrayList r24 = new ArrayList();
        r24.add(this.input);
        int r25 = (int) Math.floor((((double) r19) - 1.0d) / 2.0d);
        int r26 = 1;
    L30:
        if (r26 >= (r25 + 1)) goto L38;
        int r27 = 0 - r26;
    L32:
        if (r27 >= 0) goto L35;
        r27 = r27 + r12.size();
        goto L32
    L35:
        if (r27 < r12.size()) goto L37;
        r27 = r27 % r12.size();
    L37:
        r24.add(0, (Hct) r12.get(r27));
        r26 = r26 + 1;
        goto L30
    L38:
        int r28 = r19 - r25;
        int r29 = 1;
    L39:
        if (r29 >= r28) goto L47;
        int r30 = r29;
    L41:
        if (r30 >= 0) goto L44;
        r30 = r30 + r12.size();
        goto L41
    L44:
        if (r30 < r12.size()) goto L46;
        r30 = r30 % r12.size();
    L46:
        r24.add((Hct) r12.get(r30));
        r29 = r29 + 1;
        goto L39
    L47:
        return r24;
    }

    public TemperatureCache(Hct r5) {
        this.input = r5;
    }
}
