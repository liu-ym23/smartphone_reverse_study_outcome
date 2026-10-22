package hja;

import com.obric.common.oea.foundation.animation.token.Token$Easing;
import ija.b;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements gja.a<Float> {
    public final int a;
    public final int b;
    public final Token$Easing c;

    public a() {
        this(300, 0, Token$Easing.OUI_ANIMATION_EASING_STANDARD);
    }

    @Override // gja.a
    public final String dump() {
        return "FloatTweenSpec(durationMillis: " + this.a + ", delay: " + this.b + ", easing: " + this.c + ')';
    }

    public final int hashCode() {
        return (((this.a * 31) + this.c.hashCode()) * 31) + this.b;
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof a) == false) goto L12;
        a r5 = (a) r4;
        if (r5.a == this.a) goto L7;
        return false;
    L7:
        if (r5.b == this.b) goto L9;
        return false;
    L9:
        if (r5.c != this.c) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    @Override // gja.a
    public final boolean a(long r5, long r7) {
        if (r5 < (r7 + (((long) this.b) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    public a(int r2, int r3, Token$Easing r4) {
        Intrinsics.checkNotNullParameter(r4, "easing");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // gja.a
    public final long b(Float r3, Float r4, float r5) {
        r3.floatValue();
        r4.floatValue();
        return ((long) this.a) * 1000000;
    }

    public final Float e(long r29, float r31, float r32) {
        long r1 = RangesKt.coerceIn(r29 - (((long) this.b) * 1000000), 0, ((long) this.a) * 1000000);
        int r5 = this.a;
        if (r5 != 0) goto L5;
        float r2 = 1.0f;
    L6:
        Token$Easing r3 = this.c;
        if (r3 != Token$Easing.OUI_ANIMATION_EASING_LINEAR) goto L9;
        Intrinsics.checkNotNullParameter(r3, "$this$toLinearEasing");
    L171:
        int r4 = b.a;
        return Float.valueOf(((1 - r2) * r31) + (r2 * r32));
    L9:
        Intrinsics.checkNotNullParameter(r3, "$this$toCubicBezierEasing");
        if (r3.getValues().length != 4) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L174;
        float r7 = r3.getValues()[0];
        float r8 = r3.getValues()[1];
        float r9 = r3.getValues()[2];
        float r10 = r3.getValues()[3];
        ija.a r11 = new ija.a(r7, r8, r9, r10);
        if (r2 >= 0.0f) goto L18;
        r2 = 0.0f;
    L18:
        if (r2 <= 1.0f) goto L21;
        r2 = 1.0f;
    L21:
        if (r2 <= 0.0f) goto L171;
        if (r2 >= 1.0f) goto L171;
        float r12 = 0.0f - r2;
        float r13 = r7 - r2;
        float r14 = r9 - r2;
        int r15 = b.a;
        double r16 = r12;
        double r17 = ((r16 - (((double) r13) * 2.0d)) + ((double) r14)) * 3.0d;
        double r18 = ((double) (r13 - r12)) * 3.0d;
        double r19 = (((double) (-r12)) + (((double) (r13 - r14)) * 3.0d)) + ((double) (1.0f - r2));
        if (Math.abs(r19 - 0.0d) >= 1.0E-7d) goto L27;
        boolean r20 = true;
    L29:
        if (r20 == true) goto L31;
        double r21 = r17 / r19;
        double r22 = r18 / r19;
        double r25 = ((r22 * 3.0d) - (r21 * r21)) / 9.0d;
        double r23 = (((((2.0d * r21) * r21) * r21) - ((9.0d * r21) * r22)) + ((r16 / r19) * 27.0d)) / 54.0d;
        double r110 = (r25 * r25) * r25;
        double r24 = (r23 * r23) + r110;
        double r111 = r21 / 3.0d;
        if (r24 >= 0.0d) goto L121;
        double r26 = Math.sqrt(-r110);
        double r27 = (-r23) / r26;
        if (r27 >= (-1.0d)) goto L81;
        r27 = -1.0d;
    L81:
        if (r27 <= 1.0d) goto L83;
        r27 = 1.0d;
    L83:
        double r28 = Math.acos(r27);
        double r30 = b.a((float) r26) * 2.0f;
        float r112 = (float) ((Math.cos(r28 / 3.0d) * r30) - r111);
        if (r112 >= 0.0f) goto L89;
        if (r112 < (-8.34465E-7f)) goto L93;
        r112 = 0.0f;
    L95:
        if (Float.isNaN(r112) == true) goto L97;
    L96:
        float r113 = r112;
    L160:
        if (Float.isNaN(r113) == true) goto L170;
        float r33 = (r8 - r10) + 0.33333334f;
        float r34 = (((((r33 * r113) + (r10 - (2.0f * r8))) * r113) + r8) * 3.0f) * r113;
        float r35 = r11.a;
        float r36 = r11.b;
        if (r34 >= r35) goto L165;
        r34 = r35;
    L165:
        if (r34 > r36) goto L168;
        r36 = r34;
    L168:
        r2 = r36;
        goto L171
    L170:
        throw new IllegalArgumentException("The cubic curve with parameters (" + r7 + ", " + r8 + ", " + r9 + ", " + r10 + ") has no solution at " + r2);
    L97:
        r112 = (float) ((Math.cos((6.283185307179586d + r28) / 3.0d) * r30) - r111);
        if (r112 >= 0.0f) goto L103;
        if (r112 < (-8.34465E-7f)) goto L107;
        r112 = 0.0f;
    L109:
        if (Float.isNaN(r112) == false) goto L96;
        float r37 = (float) ((r30 * Math.cos((r28 + 12.566370614359172d) / 3.0d)) - r111);
        if (r37 >= 0.0f) goto L117;
        if (r37 >= (-8.34465E-7f)) goto L150;
    L156:
        float r38 = Float.NaN;
    L158:
        r113 = r38;
    L150:
        r38 = 0.0f;
        goto L158
    L117:
        if (r37 > 1.0f) goto L119;
    L157:
        r38 = r37;
        goto L158
    L119:
        if (r37 > 1.0000008f) goto L156;
    L155:
        r38 = 1.0f;
    L107:
        r112 = Float.NaN;
        goto L109
    L103:
        if (r112 <= 1.0f) goto L109;
        if (r112 > 1.0000008f) goto L107;
        r112 = 1.0f;
    L93:
        r112 = Float.NaN;
        goto L95
    L89:
        if (r112 <= 1.0f) goto L95;
        if (r112 > 1.0000008f) goto L93;
        r112 = 1.0f;
        goto L95
    L121:
        if (r24 != 0.0d) goto L146;
        float r39 = -b.a((float) r23);
        float r40 = (float) r111;
        r38 = (r39 * 2.0f) - r40;
        if (r38 >= 0.0f) goto L128;
        if (r38 < (-8.34465E-7f)) goto L132;
        r38 = 0.0f;
    L134:
        if (Float.isNaN(r38) == false) goto L158;
        r37 = (-r39) - r40;
        if (r37 >= 0.0f) goto L142;
        if (r37 < (-8.34465E-7f)) goto L156;
    L142:
        if (r37 <= 1.0f) goto L157;
        if (r37 > 1.0000008f) goto L156;
    L132:
        r38 = Float.NaN;
        goto L134
    L128:
        if (r38 <= 1.0f) goto L134;
        if (r38 > 1.0000008f) goto L132;
        r38 = 1.0f;
        goto L134
    L146:
        double r41 = Math.sqrt(r24);
        r37 = (float) (((double) (b.a((float) ((-r23) + r41)) - b.a((float) (r23 + r41)))) - r111);
        if (r37 >= 0.0f) goto L152;
        if (r37 < (-8.34465E-7f)) goto L156;
    L152:
        if (r37 <= 1.0f) goto L157;
        if (r37 > 1.0000008f) goto L156;
    L31:
        if (Math.abs(r17 - 0.0d) >= 1.0E-7d) goto L33;
        boolean r42 = true;
    L34:
        if (r42 == true) goto L36;
        double r43 = Math.sqrt((r18 * r18) - ((4.0d * r17) * r16));
        double r114 = r17 * 2.0d;
        float r44 = (float) ((r43 - r18) / r114);
        if (r44 >= 0.0f) goto L57;
        if (r44 < (-8.34465E-7f)) goto L61;
        r44 = 0.0f;
    L63:
        if (Float.isNaN(r44) == true) goto L65;
        r113 = r44;
        goto L160
    L65:
        r37 = (float) (((-r18) - r43) / r114);
        if (r37 >= 0.0f) goto L71;
        if (r37 < (-8.34465E-7f)) goto L156;
    L71:
        if (r37 <= 1.0f) goto L157;
        if (r37 > 1.0000008f) goto L156;
    L61:
        r44 = Float.NaN;
        goto L63
    L57:
        if (r44 <= 1.0f) goto L63;
        if (r44 > 1.0000008f) goto L61;
        r44 = 1.0f;
        goto L63
    L36:
        if (Math.abs(r18 - 0.0d) >= 1.0E-7d) goto L38;
        boolean r210 = true;
    L39:
        if (r210 == false) goto L41;
        r113 = Float.NaN;
        goto L160
    L41:
        r37 = (float) ((-r16) / r18);
        if (r37 >= 0.0f) goto L47;
        if (r37 < (-8.34465E-7f)) goto L156;
    L47:
        if (r37 <= 1.0f) goto L157;
        if (r37 > 1.0000008f) goto L156;
    L38:
        r210 = false;
        goto L39
    L33:
        r42 = false;
        goto L34
    L27:
        r20 = false;
        goto L29
    L174:
        throw new IllegalArgumentException("Easing values must contain exactly 4 floats for cubic bezier.".toString());
    L12:
        r6 = false;
        goto L13
    L5:
        r2 = r1 / (((long) r5) * 1000000);
        goto L6
    }

    @Override // gja.a
    public final /* bridge */ /* synthetic */ Float c(long r1, Float r3, Float r4, float r5) {
        return e(r1, r3.floatValue(), r4.floatValue());
    }

    @Override // gja.a
    public final float d(long r11, Float r13, Float r14, float r15) {
        float r16 = r13.floatValue();
        float r17 = r14.floatValue();
        long r12 = RangesKt.coerceIn(r11 - (((long) this.b) * 1000000), 0, ((long) this.a) * 1000000);
        if (r12 >= 0) goto L5;
        return 0.0f;
    L5:
        if (r12 == 0) goto L10;
        float r18 = e(r12 - 1000000, r16, r17).floatValue();
        return (e(r12, r16, r17).floatValue() - r18) * 1000.0f;
    L10:
        return r15;
    }
}
