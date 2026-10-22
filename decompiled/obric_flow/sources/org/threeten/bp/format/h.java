package org.threeten.bp.format;

import ai.j0;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChronoField f21214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21216c;
    public final boolean d;

    public h(ChronoField r5, int r10, int r11, boolean r12) {
        jm.c.p(r5, "field");
        if (r5.range().isFixed() == false) goto L20;
        if (r10 < 0) goto L18;
        if (r10 > 9) goto L18;
        if (r11 < 1) goto L16;
        if (r11 > 9) goto L16;
        if (r11 < r10) goto L14;
        this.f21214a = r5;
        this.f21215b = r10;
        this.f21216c = r11;
        this.d = r12;
        return;
    L14:
        throw new IllegalArgumentException(j0.f(r11, r10, "Maximum width must exceed or equal the minimum width but ", " < "));
    L16:
        throw new IllegalArgumentException(j0.g(r11, "Maximum width must be from 1 to 9 inclusive but was "));
    L18:
        throw new IllegalArgumentException(j0.g(r10, "Minimum width must be from 0 to 9 inclusive but was "));
    L20:
        throw new IllegalArgumentException("Field must have a fixed set of values: " + r5);
    }

    @Override // org.threeten.bp.format.g
    public final int parse(u r13, CharSequence r14, int r15) {
        boolean r5 = r13.e;
        if (r5 == false) goto L5;
        int r10 = this.f21215b;
    L7:
        if (r5 == false) goto L9;
        int r11 = this.f21216c;
    L10:
        int r12 = r14.length();
        if (r15 != r12) goto L15;
        if (r10 > 0) goto L14;
        return r15;
    L14:
        return ~r15;
    L15:
        z r16 = r13.f21251b;
        if (this.d == false) goto L23;
        char r17 = r14.charAt(r15);
        r16.getClass();
        if (r17 == '.') goto L22;
        if (r10 > 0) goto L21;
        return r15;
    L21:
        return ~r15;
    L22:
        r15 = r15 + 1;
    L23:
        int r18 = r15;
        int r19 = r10 + r18;
        if (r19 > r12) goto L26;
        int r110 = Math.min(r11 + r18, r12);
        int r20 = 0;
        int r111 = r18;
    L28:
        if (r111 >= r110) goto L39;
        int r21 = r111 + 1;
        char r22 = r14.charAt(r111);
        r16.getClass();
        int r23 = r22 - '0';
        if (r23 < 0) goto L33;
        if (r23 > 9) goto L33;
    L34:
        if (r23 < 0) goto L35;
        r20 = (r20 * 10) + r23;
        r111 = r21;
        goto L28
    L35:
        if (r21 >= r19) goto L39;
        return ~r18;
    L33:
        r23 = -1;
    L39:
        BigDecimal r112 = new BigDecimal(r20).movePointLeft(r111 - r18);
        ValueRange r113 = this.f21214a.range();
        BigDecimal r24 = BigDecimal.valueOf(r113.getMinimum());
        return r13.e(this.f21214a, r112.multiply(BigDecimal.valueOf(r113.getMaximum()).subtract(r24).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(r24).longValueExact(), r18, r111);
    L26:
        return ~r18;
    L9:
        r11 = 9;
        goto L10
    L5:
        r10 = 0;
        goto L7
    }

    @Override // org.threeten.bp.format.g
    public final boolean print(w r10, StringBuilder r11) {
        ChronoField r5 = this.f21214a;
        Long r12 = r10.a(r5);
        int r13 = 0;
        if (r12 != null) goto L5;
        return false;
    L5:
        long r14 = r12.longValue();
        ValueRange r15 = r5.range();
        r15.checkValidValue(r14, r5);
        BigDecimal r16 = BigDecimal.valueOf(r15.getMinimum());
        BigDecimal r17 = BigDecimal.valueOf(r15.getMaximum()).subtract(r16).add(BigDecimal.ONE);
        BigDecimal r18 = BigDecimal.valueOf(r14).subtract(r16);
        RoundingMode r19 = RoundingMode.FLOOR;
        BigDecimal r20 = r18.divide(r17, 9, r19);
        BigDecimal r21 = BigDecimal.ZERO;
        if (r20.compareTo(r21) == 0) goto L9;
        r21 = r20.stripTrailingZeros();
    L9:
        int r22 = r21.scale();
        z r23 = r10.f21258c;
        boolean r24 = this.d;
        int r25 = this.f21215b;
        if (r22 != 0) goto L16;
        if (r25 <= 0) goto L24;
        if (r24 == false) goto L14;
        r23.getClass();
        r11.append('.');
    L14:
        if (r13 >= r25) goto L25;
        r23.getClass();
        r11.append('0');
        r13 = r13 + 1;
        goto L14
    L25:
        return true;
    L24:
        return true;
    L16:
        String r26 = r21.setScale(Math.min(Math.max(r21.scale(), r25), this.f21216c), r19).toPlainString().substring(2);
        r23.getClass();
        if (r24 == false) goto L19;
        r11.append('.');
    L19:
        r11.append(r26);
        return true;
    }

    public final String toString() {
        if (this.d == false) goto L5;
        String r5 = ",DecimalPoint";
    L7:
        return "Fraction(" + this.f21214a + "," + this.f21215b + "," + this.f21216c + r5 + ")";
    L5:
        r5 = "";
        goto L7
    }
}
