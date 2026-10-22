package org.threeten.bp;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.ChronoPeriod;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes8.dex */
public final class Period extends ChronoPeriod implements Serializable {
    private static final Pattern PATTERN = null;
    public static final Period ZERO = null;
    private static final long serialVersionUID = -8290556941213247973L;
    private final int days;
    private final int months;
    private final int years;

    static {
        ZERO = new Period(0, 0, 0);
        PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    }

    private Period(int r1, int r2, int r3) {
        this.years = r1;
        this.months = r2;
        this.days = r3;
    }

    public static Period between(LocalDate r0, LocalDate r1) {
        return r0.until(r1);
    }

    private static Period create(int r1, int r2, int r3) {
        if (((r1 | r2) | r3) != 0) goto L7;
        return ZERO;
    L7:
        return new Period(r1, r2, r3);
    }

    public static Period from(TemporalAmount r9) {
        TemporalAmount r10 = (TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r9, TemporalAmount.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Period.class) == false) goto L7;
        return (Period) ZeusTransformUtils.preCheckCast(r10, Period.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r10, ChronoPeriod.class) == true) goto L9;
    L13:
        Jdk8Methods.requireNonNull(r10, "amount");
        Iterator<TemporalUnit> r0 = r10.getUnits().iterator();
        int r1 = 0;
        int r3 = 0;
        int r4 = 0;
    L15:
        if (r0.hasNext() == false) goto L28;
        TemporalUnit r5 = (TemporalUnit) ZeusTransformUtils.preCheckCast(r0.next(), TemporalUnit.class, "com.obric.memorydata.plugin");
        long r6 = r10.get(r5);
        if (r5 == ChronoUnit.YEARS) goto L18;
        if (r5 == ChronoUnit.MONTHS) goto L21;
        if (r5 != ChronoUnit.DAYS) goto L26;
        r4 = Jdk8Methods.safeToInt(r6);
        goto L15
    L26:
        throw new DateTimeException("Unit must be Years, Months or Days, but was " + r5);
    L21:
        r3 = Jdk8Methods.safeToInt(r6);
        goto L15
    L18:
        r1 = Jdk8Methods.safeToInt(r6);
        goto L15
    L28:
        return create(r1, r3, r4);
    L9:
        if (IsoChronology.INSTANCE.equals(((ChronoPeriod) ZeusTransformUtils.preCheckCast(r10, ChronoPeriod.class, "com.obric.memorydata.plugin")).getChronology()) == true) goto L13;
        throw new DateTimeException("Period requires ISO chronology: " + r10);
    }

    public static Period of(int r0, int r1, int r2) {
        return create(r0, r1, r2);
    }

    public static Period ofDays(int r1) {
        return create(0, 0, r1);
    }

    public static Period ofMonths(int r1) {
        return create(0, r1, 0);
    }

    public static Period ofWeeks(int r1) {
        return create(0, 0, Jdk8Methods.safeMultiply(r1, 7));
    }

    public static Period ofYears(int r1) {
        return create(r1, 0, 0);
    }

    public static Period parse(CharSequence r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r10, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Matcher r0 = PATTERN.matcher(r10);
        if (r0.matches() == false) goto L18;
        int r2 = 1;
        if ("-".equals(r0.group(1)) == false) goto L7;
        r2 = -1;
    L7:
        String r5 = r0.group(2);
        String r6 = r0.group(3);
        String r7 = r0.group(4);
        String r1 = r0.group(5);
        if (r5 != null) goto L19;
        if (r6 != null) goto L19;
        if (r7 != null) goto L19;
        if (r1 == null) goto L18;
    L19:
        int r8 = parseNumber(r10, r5, r2);     // Catch: NumberFormatException -> L14
        int r11 = parseNumber(r10, r6, r2);     // Catch: NumberFormatException -> L14
        int r12 = parseNumber(r10, r7, r2);     // Catch: NumberFormatException -> L14
        return create(r8, r11, Jdk8Methods.safeAdd(parseNumber(r10, r1, r2), Jdk8Methods.safeMultiply(r12, 7)));
    L14:
        e = move-exception;
        throw ((DateTimeParseException) ZeusTransformUtils.preCheckCast(new DateTimeParseException("Text cannot be parsed to a Period", r10, 0).initCause(e), DateTimeParseException.class, "com.obric.memorydata.plugin"));
    L18:
        throw new DateTimeParseException("Text cannot be parsed to a Period", r10, 0);
    }

    private static int parseNumber(CharSequence r3, String r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L11;
        return 0;
    L11:
        return Jdk8Methods.safeMultiply(Integer.parseInt(r4), r5);
    L8:
        e = move-exception;
        throw ((DateTimeParseException) ZeusTransformUtils.preCheckCast(new DateTimeParseException("Text cannot be parsed to a Period", r6, 0).initCause(e), DateTimeParseException.class, "com.obric.memorydata.plugin"));
    }

    private Object readResolve() {
        if (((this.years | this.months) | this.days) == 0) goto L5;
        return this;
    L5:
        return ZERO;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public Temporal addTo(Temporal r4) {
        Temporal r5 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r5, "temporal");
        int r0 = this.years;
        if (r0 != 0) goto L5;
        int r1 = this.months;
        if (r1 == 0) goto L13;
        long r2 = r1;
    L11:
        ChronoUnit r3 = ChronoUnit.MONTHS;
    L12:
        r5 = r5.plus(r2, r3);
    L13:
        int r6 = this.days;
        if (r6 != 0) goto L16;
        return r5;
    L16:
        return r5.plus(r6, ChronoUnit.DAYS);
    L5:
        if (this.months == 0) goto L7;
        r2 = toTotalMonths();
        goto L11
    L7:
        r2 = r0;
        r3 = ChronoUnit.YEARS;
        goto L12
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Period.class) == false) goto L16;
        Period r6 = (Period) ZeusTransformUtils.preCheckCast(r5, Period.class, "com.obric.memorydata.plugin");
        if (this.years != r6.years) goto L15;
        if (this.months != r6.months) goto L15;
        if (this.days != r6.days) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public long get(TemporalUnit r3) {
        TemporalUnit r4 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r3, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (r4 != ChronoUnit.YEARS) goto L8;
        int r2 = this.years;
    L6:
        return r2;
    L8:
        if (r4 != ChronoUnit.MONTHS) goto L11;
        r2 = this.months;
        goto L6
    L11:
        if (r4 != ChronoUnit.DAYS) goto L14;
        r2 = this.days;
        goto L6
    L14:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r4);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Chronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public int getDays() {
        return this.days;
    }

    public int getMonths() {
        return this.months;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    public int getYears() {
        return this.years;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public int hashCode() {
        return (this.years + Integer.rotateLeft(this.months, 8)) + Integer.rotateLeft(this.days, 16);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public boolean isNegative() {
        if (this.years >= 0) goto L5;
    L10:
        return true;
    L5:
        if (this.months < 0) goto L10;
        if (this.days < 0) goto L10;
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public boolean isZero() {
        if (this != ZERO) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Period minus(TemporalAmount r4) {
        Period r5 = from((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAmount.class, "com.obric.memorydata.plugin"));
        return create(Jdk8Methods.safeSubtract(this.years, r5.years), Jdk8Methods.safeSubtract(this.months, r5.months), Jdk8Methods.safeSubtract(this.days, r5.days));
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public /* synthetic */ ChronoPeriod minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public Period minusDays(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Period this = plusDays(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusDays(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public Period minusMonths(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Period this = plusMonths(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMonths(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public Period minusYears(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Period this = plusYears(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusYears(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Period multipliedBy(int r3) {
        if (this != ZERO) goto L5;
        return this;
    L5:
        if (r3 != 1) goto L8;
        return this;
    L8:
        return create(Jdk8Methods.safeMultiply(this.years, r3), Jdk8Methods.safeMultiply(this.months, r3), Jdk8Methods.safeMultiply(this.days, r3));
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public /* bridge */ /* synthetic */ ChronoPeriod multipliedBy(int r1) {
        return multipliedBy(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Period negated() {
        return multipliedBy(-1);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public /* bridge */ /* synthetic */ ChronoPeriod negated() {
        return negated();
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Period normalized() {
        long r0 = toTotalMonths();
        long r4 = r0 / 12;
        int r1 = (int) (r0 % 12);
        if (r4 != this.years) goto L8;
        if (r1 != this.months) goto L8;
        return this;
    L8:
        return create(Jdk8Methods.safeToInt(r4), r1, this.days);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public /* bridge */ /* synthetic */ ChronoPeriod normalized() {
        return normalized();
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Period plus(TemporalAmount r4) {
        Period r5 = from((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAmount.class, "com.obric.memorydata.plugin"));
        return create(Jdk8Methods.safeAdd(this.years, r5.years), Jdk8Methods.safeAdd(this.months, r5.months), Jdk8Methods.safeAdd(this.days, r5.days));
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public /* synthetic */ ChronoPeriod plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public Period plusDays(long r5) {
        if (r5 != 0) goto L6;
        return this;
    L6:
        return create(this.years, this.months, Jdk8Methods.safeToInt(Jdk8Methods.safeAdd(this.days, r5)));
    }

    public Period plusMonths(long r4) {
        if (r4 != 0) goto L6;
        return this;
    L6:
        return create(this.years, Jdk8Methods.safeToInt(Jdk8Methods.safeAdd(this.months, r4)), this.days);
    }

    public Period plusYears(long r3) {
        if (r3 != 0) goto L6;
        return this;
    L6:
        return create(Jdk8Methods.safeToInt(Jdk8Methods.safeAdd(this.years, r3)), this.months, this.days);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal r4) {
        Temporal r5 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r5, "temporal");
        int r0 = this.years;
        if (r0 != 0) goto L5;
        int r1 = this.months;
        if (r1 == 0) goto L13;
        long r2 = r1;
    L11:
        ChronoUnit r3 = ChronoUnit.MONTHS;
    L12:
        r5 = r5.minus(r2, r3);
    L13:
        int r6 = this.days;
        if (r6 != 0) goto L16;
        return r5;
    L16:
        return r5.minus(r6, ChronoUnit.DAYS);
    L5:
        if (this.months == 0) goto L7;
        r2 = toTotalMonths();
        goto L11
    L7:
        r2 = r0;
        r3 = ChronoUnit.YEARS;
        goto L12
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public String toString() {
        if (this != ZERO) goto L6;
        return "P0D";
    L6:
        StringBuilder r0 = new StringBuilder();
        r0.append('P');
        int r1 = this.years;
        if (r1 == 0) goto L9;
        r0.append(r1).append('Y');
    L9:
        int r2 = this.months;
        if (r2 == 0) goto L12;
        r0.append(r2).append('M');
    L12:
        int r3 = this.days;
        if (r3 == 0) goto L16;
        r0.append(r3).append('D');
    L16:
        return r0.toString();
    }

    public long toTotalMonths() {
        return (((long) this.years) * 12) + ((long) this.months);
    }

    public Period withDays(int r2) {
        if (r2 != this.days) goto L6;
        return this;
    L6:
        return create(this.years, this.months, r2);
    }

    public Period withMonths(int r2) {
        if (r2 != this.months) goto L6;
        return this;
    L6:
        return create(this.years, r2, this.days);
    }

    public Period withYears(int r2) {
        if (r2 != this.years) goto L6;
        return this;
    L6:
        return create(r2, this.months, this.days);
    }
}
