package org.threeten.bp;

import ai.j0;
import androidx.room.writer.DaoWriter;
import com.bytedance.keva.KevaImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalDate extends org.threeten.bp.chrono.b implements Serializable {
    static final long DAYS_0000_TO_1970 = 719528;
    public static final org.threeten.bp.temporal.i FROM = null;
    public static final LocalDate MAX = null;
    public static final LocalDate MIN = null;
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;

    static {
        MIN = of(Year.MIN_VALUE, 1, 1);
        MAX = of(Year.MAX_VALUE, 12, 31);
        FROM = new com.bytedance.ies.bullet.service.base.c(14);
    }

    public LocalDate(int r5, int r10, int r11) {
        this.year = r5;
        this.month = (short) r10;
        this.day = (short) r11;
    }

    public static LocalDate a(int r5, Month r10, int r11) {
        if (r11 <= 28) goto L13;
        if (r11 <= r10.length(IsoChronology.INSTANCE.isLeapYear(r5))) goto L13;
        if (r11 != 29) goto L11;
        throw new DateTimeException(j0.h(r5, "Invalid date 'February 29' as '", "' is not a leap year"));
    L11:
        throw new DateTimeException("Invalid date '" + r10.name() + " " + r11 + "'");
    L13:
        return new LocalDate(r5, r10.getValue(), r11);
    }

    public static LocalDate f(int r5, int r10, int r11) {
        if (r10 == 2) goto L15;
        if (r10 != 4) goto L7;
    L13:
        r11 = Math.min(r11, 30);
    L20:
        return of(r5, r10, r11);
    L7:
        if (r10 == 6) goto L13;
        if (r10 == 9) goto L13;
        if (r10 == 11) goto L13;
    L15:
        if (IsoChronology.INSTANCE.isLeapYear(r5) == false) goto L17;
        int r12 = 29;
    L18:
        r11 = Math.min(r11, r12);
        goto L20
    L17:
        r12 = 28;
        goto L18
    }

    public static LocalDate from(org.threeten.bp.temporal.d r5) {
        LocalDate r10 = (LocalDate) r5.query(org.threeten.bp.temporal.h.f);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    }

    public static LocalDate now() {
        return now(a.systemDefaultZone());
    }

    public static LocalDate of(int r5, Month r10, int r11) {
        ChronoField.YEAR.checkValidValue(r5);
        jm.c.p(r10, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(r11);
        return a(r5, r10, r11);
    }

    public static LocalDate ofEpochDay(long r23) {
        ChronoField.EPOCH_DAY.checkValidValue(r23);
        long r5 = 719468 + r23;
        if (r5 >= 0) goto L5;
        long r10 = ((r23 + 719469) / 146097) - 1;
        long r13 = r10 * 400;
        r5 = r5 + ((-r10) * 146097);
    L6:
        long r11 = ((r5 * 400) + 591) / 146097;
        long r19 = r5 - ((r11 / 400) + (((r11 / 4) + (r11 * 365)) - (r11 / 100)));
        if (r19 >= 0) goto L9;
        r11 = r11 - 1;
        r19 = r5 - ((r11 / 400) + (((r11 / 4) + (365 * r11)) - (r11 / 100)));
    L9:
        int r12 = (int) r19;
        int r14 = ((r12 * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue((r11 + r13) + ((long) (r14 / 10))), ((r14 + 2) % 12) + 1, (r12 - (((r14 * 306) + 5) / 10)) + 1);
    L5:
        r13 = 0;
        goto L6
    }

    public static LocalDate ofYearDay(int r5, int r10) {
        long r11 = r5;
        ChronoField.YEAR.checkValidValue(r11);
        ChronoField.DAY_OF_YEAR.checkValidValue(r10);
        boolean r12 = IsoChronology.INSTANCE.isLeapYear(r11);
        if (r10 != 366) goto L8;
        if (r12 == true) goto L8;
        throw new DateTimeException(j0.h(r5, "Invalid date 'DayOfYear 366' as '", "' is not a leap year"));
    L8:
        Month r13 = Month.of(((r10 - 1) / 31) + 1);
        if (r10 <= ((r13.length(r12) + r13.firstDayOfYear(r12)) - 1)) goto L12;
        r13 = r13.plus(1);
    L12:
        return a(r5, r13, (r10 - r13.firstDayOfYear(r12)) + 1);
    }

    public static LocalDate parse(CharSequence r5) {
        return parse(r5, org.threeten.bp.format.b.f);
    }

    public static LocalDate readExternal(DataInput r5) throws IOException {
        return of(r5.readInt(), r5.readByte(), r5.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return super.adjustInto(r5);
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.of(this, LocalTime.MIDNIGHT);
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.c atTime(LocalTime r5) {
        return atTime(r5);
    }

    public final int b(org.threeten.bp.temporal.g r5) {
        switch(d.f21184a[((ChronoField) r5).ordinal()]) {
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L24;
            case 7: goto L22;
            case 8: goto L20;
            case 9: goto L18;
            case 10: goto L16;
            case 11: goto L14;
            case 12: goto L12;
            case 13: goto L7;
            default: goto L5;
        };
    L27:
        int r10 = this.year;
        if (r10 < 1) goto L31;
        return r10;
    L31:
        return 1 - r10;
    L5:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L7:
        if (this.year >= 1) goto L38;
        return 0;
    L38:
        return 1;
    L12:
        return this.year;
    L14:
        throw new DateTimeException(kotlin.collections.a.h("Field too large for an int: ", r5));
    L16:
        return this.month;
    L18:
        return ((getDayOfYear() - 1) / 7) + 1;
    L20:
        throw new DateTimeException(kotlin.collections.a.h("Field too large for an int: ", r5));
    L22:
        return ((getDayOfYear() - 1) % 7) + 1;
    L24:
        return ((this.day - 1) % 7) + 1;
    L26:
        return getDayOfWeek().getValue();
    L33:
        return j0.c(this.day, 1, 7, 1);
    L35:
        return getDayOfYear();
    L37:
        return this.day;
    }

    public final long c() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    @Override // org.threeten.bp.chrono.b, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r5) {
        return compareTo((org.threeten.bp.chrono.b) r5);
    }

    public int compareTo0(LocalDate r5) {
        int r10 = this.year - r5.year;
        if (r10 != 0) goto L8;
        int r11 = this.month - r5.month;
        if (r11 == 0) goto L7;
        return r11;
    L7:
        return this.day - r5.day;
    L8:
        return r10;
    }

    public long daysUntil(LocalDate r5) {
        return r5.toEpochDay() - toEpochDay();
    }

    public final long e(LocalDate r10) {
        long r5 = (c() * 32) + ((long) getDayOfMonth());
        return (((r10.c() * 32) + ((long) r10.getDayOfMonth())) - r5) / 32;
    }

    @Override // org.threeten.bp.chrono.b
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LocalDate) == true) goto L8;
        return false;
    L8:
        if (compareTo0((LocalDate) r5) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // org.threeten.bp.chrono.b
    public String format(org.threeten.bp.format.b r5) {
        return super.format(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L7;
        return b(r5);
    L7:
        return super.get(r5);
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.i getChronology() {
        return getChronology();
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(jm.c.n(7, toEpochDay() + 3) + 1);
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    @Override // org.threeten.bp.chrono.b
    public org.threeten.bp.chrono.j getEra() {
        return super.getEra();
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        if (r5 != ChronoField.EPOCH_DAY) goto L9;
        return toEpochDay();
    L9:
        if (r5 != ChronoField.PROLEPTIC_MONTH) goto L13;
        return c();
    L13:
        return b(r5);
    L15:
        return r5.getFrom(this);
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    @Override // org.threeten.bp.chrono.b
    public int hashCode() {
        int r5 = this.year;
        short r10 = this.month;
        int r11 = r5 & (-2048);
        int r12 = (r5 << 11) + (r10 << 6);
        return r11 ^ (r12 + this.day);
    }

    @Override // org.threeten.bp.chrono.b
    public boolean isAfter(org.threeten.bp.chrono.b r5) {
        if ((r5 instanceof LocalDate) == false) goto L10;
        if (compareTo0((LocalDate) r5) <= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isAfter(r5);
    }

    @Override // org.threeten.bp.chrono.b
    public boolean isBefore(org.threeten.bp.chrono.b r5) {
        if ((r5 instanceof LocalDate) == false) goto L10;
        if (compareTo0((LocalDate) r5) >= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isBefore(r5);
    }

    @Override // org.threeten.bp.chrono.b
    public boolean isEqual(org.threeten.bp.chrono.b r5) {
        if ((r5 instanceof LocalDate) == false) goto L10;
        if (compareTo0((LocalDate) r5) != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isEqual(r5);
    }

    @Override // org.threeten.bp.chrono.b
    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        return super.isSupported(r5);
    }

    @Override // org.threeten.bp.chrono.b
    public int lengthOfMonth() {
        short r5 = this.month;
        if (r5 == 2) goto L17;
        if (r5 != 4) goto L7;
        return 30;
    L7:
        if (r5 != 6) goto L9;
        return 30;
    L9:
        if (r5 != 9) goto L11;
        return 30;
    L11:
        if (r5 == 11) goto L24;
        return 31;
    L24:
        return 30;
    L17:
        if (isLeapYear() == false) goto L19;
        return 29;
    L19:
        return 28;
    }

    @Override // org.threeten.bp.chrono.b
    public int lengthOfYear() {
        if (isLeapYear() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // org.threeten.bp.chrono.b, fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    public LocalDate minusDays(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        LocalDate this = plusDays(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusDays(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public LocalDate minusMonths(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        LocalDate this = plusMonths(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusMonths(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public LocalDate minusWeeks(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        LocalDate this = plusWeeks(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusWeeks(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public LocalDate minusYears(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        LocalDate this = plusYears(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusYears(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    public LocalDate plusDays(long r5) {
        if (r5 != 0) goto L6;
        return this;
    L6:
        return ofEpochDay(jm.c.r(toEpochDay(), r5));
    }

    public LocalDate plusMonths(long r10) {
        if (r10 != 0) goto L5;
        return this;
    L5:
        long r5 = ((((long) this.year) * 12) + ((long) (this.month - 1))) + r10;
        return f(ChronoField.YEAR.checkValidIntValue(jm.c.l(r5, 12)), jm.c.n(12, r5) + 1, this.day);
    }

    public LocalDate plusWeeks(long r5) {
        return plusDays(jm.c.t(7, r5));
    }

    public LocalDate plusYears(long r5) {
        if (r5 != 0) goto L6;
        return this;
    L6:
        return f(ChronoField.YEAR.checkValidIntValue(((long) this.year) + r5), this.month, this.day);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.chrono.b, fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f) goto L6;
        return this;
    L6:
        return (R) super.query(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L37;
        ChronoField r10 = (ChronoField) r5;
        if (r10.isDateBased() == false) goto L35;
        int r11 = d.f21184a[r10.ordinal()];
        if (r11 == 1) goto L33;
        if (r11 == 2) goto L31;
        if (r11 == 3) goto L23;
        if (r11 == 4) goto L17;
        return r5.range();
    L17:
        if (getYear() > 0) goto L20;
        long r12 = 1000000000;
    L21:
        return ValueRange.of(1, r12);
    L20:
        r12 = 999999999;
        goto L21
    L23:
        if (getMonth() == Month.FEBRUARY) goto L25;
    L27:
        long r13 = 5;
    L29:
        return ValueRange.of(1, r13);
    L25:
        if (isLeapYear() == true) goto L27;
        r13 = 4;
        goto L29
    L31:
        return ValueRange.of(1, lengthOfYear());
    L33:
        return ValueRange.of(1, lengthOfMonth());
    L35:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L37:
        return r5.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.b
    public long toEpochDay() {
        long r5 = this.year;
        long r10 = this.month;
        long r11 = 365 * r5;
        if (r5 < 0) goto L5;
        long r12 = (((r5 + 399) / 400) + (((3 + r5) / 4) - ((99 + r5) / 100))) + r11;
    L6:
        long r13 = ((((367 * r10) - 362) / 12) + r12) + ((long) (this.day - 1));
        if (r10 <= 2) goto L13;
        long r14 = r13 - 1;
        if (isLeapYear() == true) goto L11;
        r13 = r13 - 2;
        goto L13
    L11:
        r13 = r14;
    L13:
        return r13 - DAYS_0000_TO_1970;
    L5:
        r12 = r11 - ((r5 / (-400)) + ((r5 / (-4)) - (r5 / (-100))));
        goto L6
    }

    @Override // org.threeten.bp.chrono.b
    public String toString() {
        int r5 = this.year;
        short r10 = this.month;
        short r11 = this.day;
        int r12 = Math.abs(r5);
        StringBuilder r13 = new StringBuilder(10);
        if (r12 >= 1000) goto L8;
        if (r5 >= 0) goto L6;
        r13.append(r5 - 10000);
        r13.deleteCharAt(1);
    L11:
        String r14 = DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
        if (r10 >= 10) goto L14;
        String r15 = "-0";
    L15:
        r13.append(r15);
        r13.append(r10);
        if (r11 >= 10) goto L18;
        r14 = "-0";
    L18:
        r13.append(r14);
        r13.append(r11);
        return r13.toString();
    L14:
        r15 = DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
        goto L15
    L6:
        r13.append(r5 + KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        r13.deleteCharAt(0);
        goto L11
    L8:
        if (r5 <= 9999) goto L10;
        r13.append('+');
    L10:
        r13.append(r5);
        goto L11
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.e until(org.threeten.bp.chrono.b r5) {
        return until(r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public LocalDate withDayOfMonth(int r5) {
        if (this.day != r5) goto L6;
        return this;
    L6:
        return of(this.year, this.month, r5);
    }

    public LocalDate withDayOfYear(int r5) {
        if (getDayOfYear() != r5) goto L6;
        return this;
    L6:
        return ofYearDay(this.year, r5);
    }

    public LocalDate withMonth(int r5) {
        if (this.month != r5) goto L5;
        return this;
    L5:
        ChronoField.MONTH_OF_YEAR.checkValidValue(r5);
        return f(this.year, r5, this.day);
    }

    public LocalDate withYear(int r5) {
        if (this.year != r5) goto L5;
        return this;
    L5:
        ChronoField.YEAR.checkValidValue(r5);
        return f(r5, this.month, this.day);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeInt(this.year);
        r5.writeByte(this.month);
        r5.writeByte(this.day);
    }

    public static LocalDate now(ZoneId r5) {
        return now(a.system(r5));
    }

    public static LocalDate parse(CharSequence r5, org.threeten.bp.format.b r10) {
        jm.c.p(r10, "formatter");
        return (LocalDate) r10.c(r5, FROM);
    }

    public ZonedDateTime atStartOfDay(ZoneId r5) {
        jm.c.p(r5, "zone");
        LocalDateTime r10 = atTime(LocalTime.MIDNIGHT);
        if ((r5 instanceof ZoneOffset) == true) goto L10;
        ZoneOffsetTransition r11 = r5.getRules().getTransition(r10);
        if (r11 == null) goto L10;
        if (r11.isGap() == false) goto L10;
        r10 = r11.getDateTimeAfter();
    L10:
        return ZonedDateTime.of(r10, r5);
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDateTime atTime(LocalTime r5) {
        return LocalDateTime.of(this, r5);
    }

    @Override // org.threeten.bp.chrono.b
    public int compareTo(org.threeten.bp.chrono.b r5) {
        if ((r5 instanceof LocalDate) == false) goto L7;
        return compareTo0((LocalDate) r5);
    L7:
        return super.compareTo(r5);
    }

    @Override // org.threeten.bp.chrono.b
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r5, org.threeten.bp.temporal.j r10) {
        LocalDate r11 = from(r5);
        if ((r10 instanceof ChronoUnit) == false) goto L25;
        switch(d.f21185b[((ChronoUnit) r10).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        ChronoField r12 = ChronoField.ERA;
        return r11.getLong(r12) - getLong(r12);
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    L11:
        return e(r11) / 12000;
    L13:
        return e(r11) / 1200;
    L15:
        return e(r11) / 120;
    L17:
        return e(r11) / 12;
    L19:
        return e(r11);
    L21:
        return daysUntil(r11) / 7;
    L23:
        return daysUntil(r11);
    L25:
        return r10.between(this, r11);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public static LocalDate now(a r5) {
        jm.c.p(r5, "clock");
        Instant r10 = r5.instant();
        ZoneOffset r11 = r5.getZone().getRules().getOffset(r10);
        return ofEpochDay(jm.c.l(r10.getEpochSecond() + ((long) r11.getTotalSeconds()), 86400));
    }

    public LocalDateTime atTime(int r5, int r10) {
        return atTime(LocalTime.of(r5, r10));
    }

    @Override // org.threeten.bp.chrono.b, fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public LocalDateTime atTime(int r5, int r10, int r11) {
        return atTime(LocalTime.of(r5, r10, r11));
    }

    @Override // org.threeten.bp.chrono.b
    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1648minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    @Override // org.threeten.bp.chrono.b
    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1649plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public static LocalDate of(int r5, int r10, int r11) {
        ChronoField.YEAR.checkValidValue(r5);
        ChronoField.MONTH_OF_YEAR.checkValidValue(r10);
        ChronoField.DAY_OF_MONTH.checkValidValue(r11);
        return a(r5, Month.of(r10), r11);
    }

    public LocalDateTime atTime(int r5, int r10, int r11, int r12) {
        return atTime(LocalTime.of(r5, r10, r11, r12));
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate minus(org.threeten.bp.temporal.f r5) {
        return (LocalDate) r5.subtractFrom(this);
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate plus(org.threeten.bp.temporal.f r5) {
        return (LocalDate) r5.addTo(this);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public LocalDate with(org.threeten.bp.temporal.e r5) {
        if ((r5 instanceof LocalDate) == false) goto L7;
        return (LocalDate) r5;
    L7:
        return (LocalDate) r5.adjustInto(this);
    }

    public OffsetDateTime atTime(OffsetTime r5) {
        return OffsetDateTime.of(LocalDateTime.of(this, r5.toLocalTime()), r5.getOffset());
    }

    @Override // org.threeten.bp.chrono.b, fv.b, org.threeten.bp.temporal.c
    public LocalDate minus(long r5, org.threeten.bp.temporal.j r10) {
        if (r5 != Long.MIN_VALUE) goto L6;
        LocalDate this = plus(Long.MAX_VALUE, r10);
        long r11 = 1;
    L7:
        return this.plus(r11, r10);
    L6:
        r11 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public LocalDate plus(long r5, org.threeten.bp.temporal.j r10) {
        if ((r10 instanceof ChronoUnit) == false) goto L25;
        switch(d.f21185b[((ChronoUnit) r10).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        ChronoField r11 = ChronoField.ERA;
        return with(r11, jm.c.r(getLong(r11), r5));
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    L11:
        return plusYears(jm.c.t(1000, r5));
    L13:
        return plusYears(jm.c.t(100, r5));
    L15:
        return plusYears(jm.c.t(10, r5));
    L17:
        return plusYears(r5);
    L19:
        return plusMonths(r5);
    L21:
        return plusWeeks(r5);
    L23:
        return plusDays(r5);
    L25:
        return (LocalDate) r10.addTo(this, r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public LocalDate with(org.threeten.bp.temporal.g r5, long r10) {
        if ((r5 instanceof ChronoField) == false) goto L42;
        ChronoField r11 = (ChronoField) r5;
        r11.checkValidValue(r10);
        switch(d.f21184a[r11.ordinal()]) {
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L30;
            case 5: goto L28;
            case 6: goto L26;
            case 7: goto L24;
            case 8: goto L22;
            case 9: goto L20;
            case 10: goto L18;
            case 11: goto L16;
            case 12: goto L14;
            case 13: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L9:
        if (getLong(ChronoField.ERA) != r10) goto L12;
        return this;
    L12:
        return withYear(1 - this.year);
    L14:
        return withYear((int) r10);
    L16:
        return plusMonths(r10 - getLong(ChronoField.PROLEPTIC_MONTH));
    L18:
        return withMonth((int) r10);
    L20:
        return plusWeeks(r10 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
    L22:
        return ofEpochDay(r10);
    L24:
        return plusDays(r10 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
    L26:
        return plusDays(r10 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
    L28:
        return plusDays(r10 - ((long) getDayOfWeek().getValue()));
    L30:
        if (this.year >= 1) goto L34;
        r10 = 1 - r10;
    L34:
        return withYear((int) r10);
    L36:
        return plusWeeks(r10 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
    L38:
        return withDayOfYear((int) r10);
    L40:
        return withDayOfMonth((int) r10);
    L42:
        return (LocalDate) r5.adjustInto(this, r10);
    }

    @Override // org.threeten.bp.chrono.b
    public Period until(org.threeten.bp.chrono.b r10) {
        LocalDate r11 = from(r10);
        long r5 = r11.c() - c();
        int r12 = r11.day - this.day;
        if (r5 <= 0) goto L6;
        if (r12 >= 0) goto L6;
        r5 = r5 - 1;
        LocalDate r13 = plusMonths(r5);
        r12 = (int) (r11.toEpochDay() - r13.toEpochDay());
    L9:
        long r14 = r5 / 12;
        int r15 = jm.c.x(r14);
        return Period.of(r15, (int) (r5 % 12), r12);
    L6:
        if (r5 >= 0) goto L9;
        if (r12 <= 0) goto L9;
        r5 = r5 + 1;
        r12 = r12 - r11.lengthOfMonth();
        goto L9
    }
}
