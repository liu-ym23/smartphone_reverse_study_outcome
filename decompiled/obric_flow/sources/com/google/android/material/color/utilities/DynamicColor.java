package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final ContrastCurve contrastCurve;
    private final HashMap<DynamicScheme, Hct> hctCache;
    public final boolean isBackground;
    public final String name;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, TonalPalette> palette;
    public final Function<DynamicScheme, DynamicColor> secondBackground;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaPair> toneDeltaPair;

    public DynamicColor(@NonNull String r5, @NonNull Function<DynamicScheme, TonalPalette> r10, @NonNull Function<DynamicScheme, Double> r11, boolean r12, @Nullable Function<DynamicScheme, DynamicColor> r13, @Nullable Function<DynamicScheme, DynamicColor> r14, @Nullable ContrastCurve r15, @Nullable Function<DynamicScheme, ToneDeltaPair> r16) {
        this.hctCache = new HashMap();
        this.name = r5;
        this.palette = r10;
        this.tone = r11;
        this.isBackground = r12;
        this.background = r13;
        this.secondBackground = r14;
        this.contrastCurve = r15;
        this.toneDeltaPair = r16;
        this.opacity = null;
    }

    public static /* synthetic */ Double a(Hct r5, DynamicScheme r10) {
        return lambda$fromArgb$1(r5, r10);
    }

    public static /* synthetic */ TonalPalette b(TonalPalette r5, DynamicScheme r10) {
        return lambda$fromArgb$0(r5, r10);
    }

    public static double enableLightForeground(double r5) {
        if (tonePrefersLightForeground(r5) == true) goto L5;
        return r5;
    L5:
        if (toneAllowsLightForeground(r5) == true) goto L9;
        return 49.0d;
    L9:
        return r5;
    }

    public static double foregroundTone(double r10, double r12) {
        double r5 = Contrast.lighterUnsafe(r10, r12);
        double r11 = Contrast.darkerUnsafe(r10, r12);
        double r13 = Contrast.ratioOfTones(r5, r10);
        double r14 = Contrast.ratioOfTones(r11, r10);
        if (tonePrefersLightForeground(r10) == false) goto L21;
        if (Math.abs(r13 - r14) < 0.1d) goto L7;
    L11:
        boolean r15 = false;
    L13:
        if (r13 < r12) goto L15;
    L19:
        return r5;
    L15:
        if (r13 >= r14) goto L19;
        if (r15 == true) goto L19;
        return r11;
    L7:
        if (r13 >= r12) goto L11;
        if (r14 >= r12) goto L11;
        r15 = true;
        goto L13
    L21:
        if (r14 >= r12) goto L25;
        if (r14 >= r13) goto L25;
        return r5;
    L25:
        return r11;
    }

    @NonNull
    public static DynamicColor fromArgb(@NonNull String r5, int r10) {
        Hct r11 = Hct.fromInt(r10);
        return fromPalette(r5, new a(TonalPalette.fromInt(r10), 0), new a(r11, 1));
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String r10, @NonNull Function<DynamicScheme, TonalPalette> r11, @NonNull Function<DynamicScheme, Double> r12) {
        return new DynamicColor(r10, r11, r12, false, null, null, null, null);
    }

    private static /* synthetic */ TonalPalette lambda$fromArgb$0(TonalPalette r5, DynamicScheme r10) {
        return r5;
    }

    private static /* synthetic */ Double lambda$fromArgb$1(Hct r5, DynamicScheme r10) {
        return Double.valueOf(r5.getTone());
    }

    public static boolean toneAllowsLightForeground(double r5) {
        if (Math.round(r5) > 49) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean tonePrefersLightForeground(double r5) {
        if (Math.round(r5) >= 60) goto L5;
        return true;
    L5:
        return false;
    }

    public int getArgb(@NonNull DynamicScheme r5) {
        int r10 = getHct(r5).toInt();
        Function<DynamicScheme, Double> r11 = this.opacity;
        if (r11 != null) goto L5;
        return r10;
    L5:
        int r12 = MathUtils.clampInt(0, 255, (int) Math.round(r11.apply(r5).doubleValue() * 255.0d));
        int r13 = r12 << 24;
        return r13 | (16777215 & r10);
    }

    @NonNull
    public Hct getHct(@NonNull DynamicScheme r5) {
        Hct r10 = this.hctCache.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        double r11 = getTone(r5);
        Hct r12 = this.palette.apply(r5).getHct(r11);
        if (this.hctCache.size() <= 4) goto L8;
        this.hctCache.clear();
    L8:
        this.hctCache.put(r5, r12);
        return r12;
    }

    public double getTone(@NonNull DynamicScheme r31) {
        if (r31.contrastLevel >= 0.0d) goto L5;
        boolean r5 = true;
    L6:
        Function<DynamicScheme, ToneDeltaPair> r10 = this.toneDeltaPair;
        if (r10 == null) goto L72;
        ToneDeltaPair r11 = r10.apply(r31);
        DynamicColor r16 = r11.getRoleA();
        DynamicColor r17 = r11.getRoleB();
        double r18 = r11.getDelta();
        TonePolarity r12 = r11.getPolarity();
        boolean r13 = r11.getStayTogether();
        double r14 = this.background.apply(r31).getTone(r31);
        if (r12 != TonePolarity.NEARER) goto L11;
    L20:
        boolean r15 = true;
    L21:
        if (r15 == false) goto L23;
        DynamicColor r19 = r16;
    L24:
        if (r15 == false) goto L26;
        DynamicColor r20 = r17;
    L27:
        boolean r21 = this.name.equals(r19.name);
        if (r31.isDark == false) goto L30;
        double r22 = 1.0d;
    L31:
        double r23 = r19.contrastCurve.getContrast(r31.contrastLevel);
        double r110 = r20.contrastCurve.getContrast(r31.contrastLevel);
        double r111 = r19.tone.apply(r31).doubleValue();
        if (Contrast.ratioOfTones(r14, r111) >= r23) goto L35;
        r111 = foregroundTone(r14, r23);
    L35:
        double r24 = r20.tone.apply(r31).doubleValue();
        if (Contrast.ratioOfTones(r14, r24) >= r110) goto L39;
        r24 = foregroundTone(r14, r110);
    L39:
        if (r5 == false) goto L42;
        r111 = foregroundTone(r14, r23);
        r24 = foregroundTone(r14, r110);
    L42:
        if (((r24 - r111) * r22) >= r18) goto L47;
        double r25 = r18 * r22;
        r24 = MathUtils.clampDouble(0.0d, 100.0d, r111 + r25);
        if (((r24 - r111) * r22) >= r18) goto L47;
        r111 = MathUtils.clampDouble(0.0d, 100.0d, r24 - r25);
    L47:
        if (50.0d > r111) goto L56;
        if (r111 >= 60.0d) goto L56;
        if (r22 <= 0.0d) goto L53;
        double r112 = Math.max(r24, (r18 * r22) + 60.0d);
        r111 = 60.0d;
    L69:
        if (r21 == true) goto L71;
        return r112;
    L71:
        return r111;
    L53:
        double r26 = Math.min(r24, (r18 * r22) + 49.0d);
    L54:
        r112 = r26;
        r111 = 49.0d;
    L56:
        if (50.0d <= r24) goto L58;
    L68:
        r112 = r24;
        goto L69
    L58:
        if (r24 >= 60.0d) goto L68;
        if (r13 == false) goto L65;
        if (r22 <= 0.0d) goto L63;
        r112 = Math.max(r24, (r18 * r22) + 60.0d);
        r111 = 60.0d;
        goto L69
    L63:
        r26 = Math.min(r24, (r18 * r22) + 49.0d);
        goto L54
    L65:
        if (r22 <= 0.0d) goto L67;
        r112 = 60.0d;
        goto L69
    L67:
        r112 = 49.0d;
        goto L69
    L30:
        r22 = -1.0d;
        goto L31
    L26:
        r20 = r16;
        goto L27
    L23:
        r19 = r17;
        goto L24
    L11:
        if (r12 != TonePolarity.LIGHTER) goto L15;
        if (r31.isDark == false) goto L20;
    L15:
        if (r12 == TonePolarity.DARKER) goto L17;
    L19:
        r15 = false;
        goto L21
    L17:
        if (r31.isDark == false) goto L19;
    L72:
        double r27 = this.tone.apply(r31).doubleValue();
        Function<DynamicScheme, DynamicColor> r28 = this.background;
        if (r28 != null) goto L75;
        return r27;
    L75:
        double r29 = r28.apply(r31).getTone(r31);
        double r30 = this.contrastCurve.getContrast(r31.contrastLevel);
        if (Contrast.ratioOfTones(r29, r27) >= r30) goto L79;
        r27 = foregroundTone(r29, r30);
    L79:
        if (r5 == false) goto L82;
        r27 = foregroundTone(r29, r30);
    L82:
        if (this.isBackground == true) goto L84;
    L91:
        double r113 = r27;
    L93:
        if (this.secondBackground == null) goto L121;
        double r32 = this.background.apply(r31).getTone(r31);
        double r33 = this.secondBackground.apply(r31).getTone(r31);
        double r34 = Math.max(r32, r33);
        double r114 = Math.min(r32, r33);
        if (Contrast.ratioOfTones(r34, r113) >= r30) goto L97;
    L99:
        double r35 = Contrast.lighter(r34, r30);
        double r36 = Contrast.darker(r114, r30);
        ArrayList r37 = new ArrayList();
        if (r35 == (-1.0d)) goto L103;
        r37.add(Double.valueOf(r35));
    L103:
        if (r36 == (-1.0d)) goto L106;
        r37.add(Double.valueOf(r36));
    L106:
        if (tonePrefersLightForeground(r32) == false) goto L108;
    L118:
        if (r35 != (-1.0d)) goto L124;
        return 100.0d;
    L124:
        return r35;
    L108:
        if (tonePrefersLightForeground(r33) == true) goto L118;
        if (r37.size() == 1) goto L113;
        if (r36 != (-1.0d)) goto L117;
        return 0.0d;
    L117:
        return r36;
    L113:
        return ((Double) r37.get(0)).doubleValue();
    L97:
        if (Contrast.ratioOfTones(r114, r113) < r30) goto L99;
        return r113;
    L121:
        return r113;
    L84:
        if (50.0d > r27) goto L91;
        if (r27 >= 60.0d) goto L91;
        if (Contrast.ratioOfTones(49.0d, r29) < r30) goto L90;
        r113 = 49.0d;
        goto L93
    L90:
        r113 = 60.0d;
        goto L93
    L5:
        r5 = false;
        goto L6
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String r10, @NonNull Function<DynamicScheme, TonalPalette> r11, @NonNull Function<DynamicScheme, Double> r12, boolean r13) {
        return new DynamicColor(r10, r11, r12, r13, null, null, null, null);
    }

    public DynamicColor(@NonNull String r5, @NonNull Function<DynamicScheme, TonalPalette> r10, @NonNull Function<DynamicScheme, Double> r11, boolean r12, @Nullable Function<DynamicScheme, DynamicColor> r13, @Nullable Function<DynamicScheme, DynamicColor> r14, @Nullable ContrastCurve r15, @Nullable Function<DynamicScheme, ToneDeltaPair> r16, @Nullable Function<DynamicScheme, Double> r17) {
        this.hctCache = new HashMap();
        this.name = r5;
        this.palette = r10;
        this.tone = r11;
        this.isBackground = r12;
        this.background = r13;
        this.secondBackground = r14;
        this.contrastCurve = r15;
        this.toneDeltaPair = r16;
        this.opacity = r17;
    }
}
