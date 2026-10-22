package org.threeten.bp;

import androidx.room.writer.DaoWriter;
import com.bytedance.ai.event.MessageIndication;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes3.dex */
public final class Period extends org.threeten.bp.chrono.e implements Serializable {
    public static final Period ZERO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f21126a = null;
    private static final long serialVersionUID = -8290556941213247973L;
    private final int days;
    private final int months;
    private final int years;

    static {
        ZERO = new Period(0, 0, 0);
        f21126a = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    }

    public Period(int r5, int r10, int r11) {
        this.years = r5;
        this.months = r10;
        this.days = r11;
    }

    public static Period a(int r5, int r10, int r11) {
        if (((r5 | r10) | r11) != 0) goto L7;
        return ZERO;
    L7:
        return new Period(r5, r10, r11);
    }

    public static int b(int r5, CharSequence r10, String r11) {
        if (r11 != null) goto L11;
        return 0;
    L11:
        return jm.c.s(Integer.parseInt(r11), r5);
    L8:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", r10, 0).initCause(e));
    }

    public static Period between(LocalDate r5, LocalDate r10) {
        return r5.until(r10);
    }

    public static Period from(org.threeten.bp.temporal.f r10) {
        if ((r10 instanceof Period) == false) goto L7;
        return (Period) r10;
    L7:
        if ((r10 instanceof org.threeten.bp.chrono.e) == true) goto L9;
    L13:
        jm.c.p(r10, "amount");
        Iterator r5 = r10.getUnits().iterator();
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L15:
        if (r5.hasNext() == false) goto L28;
        org.threeten.bp.temporal.j r14 = (org.threeten.bp.temporal.j) r5.next();
        long r15 = r10.get(r14);
        if (r14 == ChronoUnit.YEARS) goto L18;
        if (r14 == ChronoUnit.MONTHS) goto L21;
        if (r14 != ChronoUnit.DAYS) goto L26;
        r13 = jm.c.x(r15);
        goto L15
    L26:
        throw new DateTimeException("Unit must be Years, Months or Days, but was " + r14);
    L21:
        r12 = jm.c.x(r15);
        goto L15
    L18:
        r11 = jm.c.x(r15);
        goto L15
    L28:
        return a(r11, r12, r13);
    L9:
        if (IsoChronology.INSTANCE.equals(((org.threeten.bp.chrono.e) r10).getChronology()) == true) goto L13;
        throw new DateTimeException("Period requires ISO chronology: " + r10);
    }

    public static Period of(int r5, int r10, int r11) {
        return a(r5, r10, r11);
    }

    public static Period ofDays(int r5) {
        return a(0, 0, r5);
    }

    public static Period ofMonths(int r5) {
        return a(0, r5, 0);
    }

    public static Period ofWeeks(int r5) {
        return a(0, 0, jm.c.s(r5, 7));
    }

    public static Period ofYears(int r5) {
        return a(r5, 0, 0);
    }

    public static Period parse(CharSequence r10) {
        jm.c.p(r10, MessageIndication.CONTENT_TYPE_TEXT);
        Matcher r5 = f21126a.matcher(r10);
        if (r5.matches() == false) goto L18;
        int r11 = 1;
        if (DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD.equals(r5.group(1)) == false) goto L7;
        r11 = -1;
    L7:
        String r12 = r5.group(2);
        String r13 = r5.group(3);
        String r14 = r5.group(4);
        String r15 = r5.group(5);
        if (r12 != null) goto L19;
        if (r13 != null) goto L19;
        if (r14 != null) goto L19;
        if (r15 == null) goto L18;
    L19:
        int r16 = b(r11, r10, r12);     // Catch: NumberFormatException -> L14
        int r17 = b(r11, r10, r13);     // Catch: NumberFormatException -> L14
        int r18 = b(r11, r10, r14);     // Catch: NumberFormatException -> L14
        return a(r16, r17, jm.c.q(b(r11, r10, r15), jm.c.s(r18, 7)));
    L14:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", r10, 0).initCause(e));
    L18:
        throw new DateTimeParseException("Text cannot be parsed to a Period", r10, 0);
    }

    private Object readResolve() {
        if (((this.years | this.months) | this.days) == 0) goto L5;
        return this;
    L5:
        return ZERO;
    }

    @Override // org.threeten.bp.temporal.f
    public org.threeten.bp.temporal.c addTo(org.threeten.bp.temporal.c r5) {
        jm.c.p(r5, "temporal");
        int r10 = this.years;
        if (r10 != 0) goto L5;
        int r11 = this.months;
        if (r11 == 0) goto L11;
        r5 = r5.plus(r11, ChronoUnit.MONTHS);
    L11:
        int r12 = this.days;
        if (r12 != 0) goto L14;
        return r5;
    L14:
        return r5.plus(r12, ChronoUnit.DAYS);
    L5:
        if (this.months == 0) goto L7;
        r5 = r5.plus(toTotalMonths(), ChronoUnit.MONTHS);
        goto L11
    L7:
        r5 = r5.plus(r10, ChronoUnit.YEARS);
        goto L11
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Period) == false) goto L16;
        Period r10 = (Period) r5;
        if (this.years != r10.years) goto L15;
        if (this.months != r10.months) goto L15;
        if (this.days != r10.days) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // org.threeten.bp.temporal.f
    public long get(org.threeten.bp.temporal.j r5) {
        if (r5 != ChronoUnit.YEARS) goto L8;
        int r10 = this.years;
    L6:
        return r10;
    L8:
        if (r5 != ChronoUnit.MONTHS) goto L11;
        r10 = this.months;
        goto L6
    L11:
        if (r5 != ChronoUnit.DAYS) goto L14;
        r10 = this.days;
        goto L6
    L14:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r5);
    }

    @Override // org.threeten.bp.chrono.e
    public org.threeten.bp.chrono.i getChronology() {
        return IsoChronology.INSTANCE;
    }

    public int getDays() {
        return this.days;
    }

    public int getMonths() {
        return this.months;
    }

    @Override // org.threeten.bp.temporal.f
    public List<org.threeten.bp.temporal.j> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    public int getYears() {
        return this.years;
    }

    public int hashCode() {
        int r5 = this.years;
        int r10 = Integer.rotateLeft(this.months, 8) + r5;
        return Integer.rotateLeft(this.days, 16) + r10;
    }

    @Override // org.threeten.bp.chrono.e
    public boolean isNegative() {
        if (this.years >= 0) goto L5;
    L10:
        return true;
    L5:
        if (this.months < 0) goto L10;
        if (this.days < 0) goto L10;
        return false;
    }

    @Override // org.threeten.bp.chrono.e
    public boolean isZero() {
        if (this != ZERO) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.e m1658minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    public Period minusDays(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Period this = plusDays(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusDays(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public Period minusMonths(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Period this = plusMonths(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusMonths(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public Period minusYears(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Period this = plusYears(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusYears(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.e multipliedBy(int r5) {
        return multipliedBy(r5);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.e negated() {
        return negated();
    }

    /* JADX INFO: renamed from: normalized, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.e m1659normalized() {
        return normalized();
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.e m1660plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    public Period plusDays(long r5) {
        if (r5 != 0) goto L6;
        return this;
    L6:
        return a(this.years, this.months, jm.c.x(jm.c.r(this.days, r5)));
    }

    public Period plusMonths(long r5) {
        if (r5 != 0) goto L6;
        return this;
    L6:
        return a(this.years, jm.c.x(jm.c.r(this.months, r5)), this.days);
    }

    public Period plusYears(long r5) {
        if (r5 != 0) goto L6;
        return this;
    L6:
        return a(jm.c.x(jm.c.r(this.years, r5)), this.months, this.days);
    }

    @Override // org.threeten.bp.temporal.f
    public org.threeten.bp.temporal.c subtractFrom(org.threeten.bp.temporal.c r5) {
        jm.c.p(r5, "temporal");
        int r10 = this.years;
        if (r10 != 0) goto L5;
        int r11 = this.months;
        if (r11 == 0) goto L11;
        r5 = r5.minus(r11, ChronoUnit.MONTHS);
    L11:
        int r12 = this.days;
        if (r12 != 0) goto L14;
        return r5;
    L14:
        return r5.minus(r12, ChronoUnit.DAYS);
    L5:
        if (this.months == 0) goto L7;
        r5 = r5.minus(toTotalMonths(), ChronoUnit.MONTHS);
        goto L11
    L7:
        r5 = r5.minus(r10, ChronoUnit.YEARS);
        goto L11
    }

    public String toString() {
        if (this != ZERO) goto L6;
        return "P0D";
    L6:
        StringBuilder r5 = new StringBuilder("P");
        int r10 = this.years;
        if (r10 == 0) goto L9;
        r5.append(r10);
        r5.append('Y');
    L9:
        int r11 = this.months;
        if (r11 == 0) goto L12;
        r5.append(r11);
        r5.append('M');
    L12:
        int r12 = this.days;
        if (r12 == 0) goto L16;
        r5.append(r12);
        r5.append('D');
    L16:
        return r5.toString();
    }

    public long toTotalMonths() {
        return (((long) this.years) * 12) + ((long) this.months);
    }

    public Period withDays(int r5) {
        if (r5 != this.days) goto L6;
        return this;
    L6:
        return a(this.years, this.months, r5);
    }

    public Period withMonths(int r5) {
        if (r5 != this.months) goto L6;
        return this;
    L6:
        return a(this.years, r5, this.days);
    }

    public Period withYears(int r5) {
        if (r5 != this.years) goto L6;
        return this;
    L6:
        return a(r5, this.months, this.days);
    }

    public Period minus(org.threeten.bp.temporal.f r5) {
        Period r10 = from(r5);
        return a(jm.c.v(this.years, r10.years), jm.c.v(this.months, r10.months), jm.c.v(this.days, r10.days));
    }

    @Override // org.threeten.bp.chrono.e
    public Period multipliedBy(int r5) {
        if (this != ZERO) goto L5;
        return this;
    L5:
        if (r5 != 1) goto L8;
        return this;
    L8:
        return a(jm.c.s(this.years, r5), jm.c.s(this.months, r5), jm.c.s(this.days, r5));
    }

    @Override // org.threeten.bp.chrono.e
    public Period negated() {
        return multipliedBy(-1);
    }

    public Period normalized() {
        long r5 = toTotalMonths();
        long r10 = r5 / 12;
        int r11 = (int) (r5 % 12);
        if (r10 != this.years) goto L8;
        if (r11 != this.months) goto L8;
        return this;
    L8:
        return a(jm.c.x(r10), r11, this.days);
    }

    public Period plus(org.threeten.bp.temporal.f r5) {
        Period r10 = from(r5);
        return a(jm.c.q(this.years, r10.years), jm.c.q(this.months, r10.months), jm.c.q(this.days, r10.days));
    }
}
