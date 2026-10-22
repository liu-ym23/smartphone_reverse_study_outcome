package org.threeten.bp.temporal;

import java.util.Locale;
import java.util.Map;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes3.dex */
public final enum ChronoField extends Enum<ChronoField> implements g {
    public static final ChronoField ALIGNED_DAY_OF_WEEK_IN_MONTH = null;
    public static final ChronoField ALIGNED_DAY_OF_WEEK_IN_YEAR = null;
    public static final ChronoField ALIGNED_WEEK_OF_MONTH = null;
    public static final ChronoField ALIGNED_WEEK_OF_YEAR = null;
    public static final ChronoField AMPM_OF_DAY = null;
    public static final ChronoField CLOCK_HOUR_OF_AMPM = null;
    public static final ChronoField CLOCK_HOUR_OF_DAY = null;
    public static final ChronoField DAY_OF_MONTH = null;
    public static final ChronoField DAY_OF_WEEK = null;
    public static final ChronoField DAY_OF_YEAR = null;
    public static final ChronoField EPOCH_DAY = null;
    public static final ChronoField ERA = null;
    public static final ChronoField HOUR_OF_AMPM = null;
    public static final ChronoField HOUR_OF_DAY = null;
    public static final ChronoField INSTANT_SECONDS = null;
    public static final ChronoField MICRO_OF_DAY = null;
    public static final ChronoField MICRO_OF_SECOND = null;
    public static final ChronoField MILLI_OF_DAY = null;
    public static final ChronoField MILLI_OF_SECOND = null;
    public static final ChronoField MINUTE_OF_DAY = null;
    public static final ChronoField MINUTE_OF_HOUR = null;
    public static final ChronoField MONTH_OF_YEAR = null;
    public static final ChronoField NANO_OF_DAY = null;
    public static final ChronoField NANO_OF_SECOND = null;
    public static final ChronoField OFFSET_SECONDS = null;
    public static final ChronoField PROLEPTIC_MONTH = null;
    public static final ChronoField SECOND_OF_DAY = null;
    public static final ChronoField SECOND_OF_MINUTE = null;
    public static final ChronoField YEAR = null;
    public static final ChronoField YEAR_OF_ERA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChronoField[] f21273a = null;
    private final j baseUnit;
    private final String name;
    private final ValueRange range;
    private final j rangeUnit;

    static {
        ChronoUnit r10 = ChronoUnit.NANOS;
        ChronoUnit r37 = ChronoUnit.SECONDS;
        ChronoField r11 = new ChronoField("NANO_OF_SECOND", 0, "NanoOfSecond", r10, r37, ValueRange.of(0, 999999999));
        NANO_OF_SECOND = r11;
        ChronoUnit r28 = ChronoUnit.DAYS;
        ChronoField r12 = new ChronoField("NANO_OF_DAY", 1, "NanoOfDay", r10, r28, ValueRange.of(0, 86399999999999L));
        NANO_OF_DAY = r12;
        ChronoUnit r13 = ChronoUnit.MICROS;
        ChronoField r14 = new ChronoField("MICRO_OF_SECOND", 2, "MicroOfSecond", r13, r37, ValueRange.of(0, 999999));
        MICRO_OF_SECOND = r14;
        ChronoField r16 = new ChronoField("MICRO_OF_DAY", 3, "MicroOfDay", r13, r28, ValueRange.of(0, 86399999999L));
        MICRO_OF_DAY = r16;
        ChronoUnit r17 = ChronoUnit.MILLIS;
        ChronoField r18 = new ChronoField("MILLI_OF_SECOND", 4, "MilliOfSecond", r17, r37, ValueRange.of(0, 999));
        MILLI_OF_SECOND = r18;
        ChronoField r19 = new ChronoField("MILLI_OF_DAY", 5, "MilliOfDay", r17, r28, ValueRange.of(0, 86399999));
        MILLI_OF_DAY = r19;
        ChronoUnit r110 = ChronoUnit.MINUTES;
        ChronoField r111 = new ChronoField("SECOND_OF_MINUTE", 6, "SecondOfMinute", r37, r110, ValueRange.of(0, 59));
        SECOND_OF_MINUTE = r111;
        ChronoField r112 = new ChronoField("SECOND_OF_DAY", 7, "SecondOfDay", r37, r28, ValueRange.of(0, 86399));
        SECOND_OF_DAY = r112;
        ChronoUnit r21 = ChronoUnit.HOURS;
        ChronoField r113 = new ChronoField("MINUTE_OF_HOUR", 8, "MinuteOfHour", r110, r21, ValueRange.of(0, 59));
        MINUTE_OF_HOUR = r113;
        ChronoField r114 = new ChronoField("MINUTE_OF_DAY", 9, "MinuteOfDay", r110, r28, ValueRange.of(0, 1439));
        MINUTE_OF_DAY = r114;
        ChronoUnit r22 = ChronoUnit.HALF_DAYS;
        ChronoField r115 = new ChronoField("HOUR_OF_AMPM", 10, "HourOfAmPm", r21, r22, ValueRange.of(0, 11));
        HOUR_OF_AMPM = r115;
        ChronoField r116 = new ChronoField("CLOCK_HOUR_OF_AMPM", 11, "ClockHourOfAmPm", r21, r22, ValueRange.of(1, 12));
        CLOCK_HOUR_OF_AMPM = r116;
        ChronoField r20 = new ChronoField("HOUR_OF_DAY", 12, "HourOfDay", r21, r28, ValueRange.of(0, 23));
        HOUR_OF_DAY = r20;
        ChronoField r23 = new ChronoField("CLOCK_HOUR_OF_DAY", 13, "ClockHourOfDay", r21, r28, ValueRange.of(1, 24));
        CLOCK_HOUR_OF_DAY = r23;
        ChronoField r24 = new ChronoField("AMPM_OF_DAY", 14, "AmPmOfDay", r22, r28, ValueRange.of(0, 1));
        AMPM_OF_DAY = r24;
        ChronoUnit r30 = ChronoUnit.WEEKS;
        ChronoField r25 = new ChronoField("DAY_OF_WEEK", 15, "DayOfWeek", r28, r30, ValueRange.of(1, 7));
        DAY_OF_WEEK = r25;
        ChronoField r26 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_MONTH", 16, "AlignedDayOfWeekInMonth", r28, r30, ValueRange.of(1, 7));
        ALIGNED_DAY_OF_WEEK_IN_MONTH = r26;
        ChronoField r27 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_YEAR", 17, "AlignedDayOfWeekInYear", r28, r30, ValueRange.of(1, 7));
        ALIGNED_DAY_OF_WEEK_IN_YEAR = r27;
        ChronoUnit r33 = ChronoUnit.MONTHS;
        ChronoField r29 = new ChronoField("DAY_OF_MONTH", 18, "DayOfMonth", r28, r33, ValueRange.of(1, 28, 31));
        DAY_OF_MONTH = r29;
        ChronoUnit r34 = ChronoUnit.YEARS;
        ChronoField r210 = new ChronoField("DAY_OF_YEAR", 19, "DayOfYear", r28, r34, ValueRange.of(1, 365, 366));
        DAY_OF_YEAR = r210;
        ChronoUnit r40 = ChronoUnit.FOREVER;
        ChronoField r211 = new ChronoField("EPOCH_DAY", 20, "EpochDay", r28, r40, ValueRange.of(-365243219162L, 365241780471L));
        EPOCH_DAY = r211;
        ChronoField r212 = new ChronoField("ALIGNED_WEEK_OF_MONTH", 21, "AlignedWeekOfMonth", r30, r33, ValueRange.of(1, 4, 5));
        ALIGNED_WEEK_OF_MONTH = r212;
        ChronoField r35 = new ChronoField("ALIGNED_WEEK_OF_YEAR", 22, "AlignedWeekOfYear", r30, r34, ValueRange.of(1, 53));
        ALIGNED_WEEK_OF_YEAR = r35;
        ChronoField r36 = new ChronoField("MONTH_OF_YEAR", 23, "MonthOfYear", r33, r34, ValueRange.of(1, 12));
        MONTH_OF_YEAR = r36;
        ChronoField r32 = new ChronoField("PROLEPTIC_MONTH", 24, "ProlepticMonth", r33, r40, ValueRange.of(-11999999988L, 11999999999L));
        PROLEPTIC_MONTH = r32;
        ChronoField r38 = new ChronoField("YEAR_OF_ERA", 25, "YearOfEra", r34, r40, ValueRange.of(1, 999999999, 1000000000));
        YEAR_OF_ERA = r38;
        ChronoField r39 = new ChronoField("YEAR", 26, "Year", r34, r40, ValueRange.of(-999999999, 999999999));
        YEAR = r39;
        ChronoField r310 = new ChronoField("ERA", 27, "Era", ChronoUnit.ERAS, r40, ValueRange.of(0, 1));
        ERA = r310;
        ChronoField r15 = new ChronoField("INSTANT_SECONDS", 28, "InstantSeconds", r37, r40, ValueRange.of(Long.MIN_VALUE, Long.MAX_VALUE));
        INSTANT_SECONDS = r15;
        ChronoField r31 = new ChronoField("OFFSET_SECONDS", 29, "OffsetSeconds", r37, r40, ValueRange.of(-64800, 64800));
        OFFSET_SECONDS = r31;
        f21273a = new ChronoField[]{r11, r12, r14, r16, r18, r19, r111, r112, r113, r114, r115, r116, r20, r23, r24, r25, r26, r27, r29, r210, r211, r212, r35, r36, r32, r38, r39, r310, r15, r31};
    }

    public ChronoField(String r5, int r10, String r11, j r12, ChronoUnit r13, ValueRange r14) {
        super(r5, r10);
        this.name = r11;
        this.baseUnit = r12;
        this.rangeUnit = r13;
        this.range = r14;
    }

    public static ChronoField valueOf(String r5) {
        return (ChronoField) Enum.valueOf(ChronoField.class, r5);
    }

    public static ChronoField[] values() {
        return (ChronoField[]) f21273a.clone();
    }

    @Override // org.threeten.bp.temporal.g
    public <R extends c> R adjustInto(R r5, long r10) {
        return (R) r5.with(this, r10);
    }

    public int checkValidIntValue(long r5) {
        return range().checkValidIntValue(r5, this);
    }

    public long checkValidValue(long r5) {
        return range().checkValidValue(r5, this);
    }

    public j getBaseUnit() {
        return this.baseUnit;
    }

    public String getDisplayName(Locale r5) {
        jm.c.p(r5, "locale");
        return toString();
    }

    @Override // org.threeten.bp.temporal.g
    public long getFrom(d r5) {
        return r5.getLong(this);
    }

    public j getRangeUnit() {
        return this.rangeUnit;
    }

    @Override // org.threeten.bp.temporal.g
    public boolean isDateBased() {
        if (ordinal() >= DAY_OF_WEEK.ordinal()) goto L5;
    L7:
        return false;
    L5:
        if (ordinal() > ERA.ordinal()) goto L7;
        return true;
    }

    @Override // org.threeten.bp.temporal.g
    public boolean isSupportedBy(d r5) {
        return r5.isSupported(this);
    }

    @Override // org.threeten.bp.temporal.g
    public boolean isTimeBased() {
        if (ordinal() >= DAY_OF_WEEK.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.g
    public ValueRange range() {
        return this.range;
    }

    @Override // org.threeten.bp.temporal.g
    public ValueRange rangeRefinedBy(d r5) {
        return r5.range(this);
    }

    @Override // org.threeten.bp.temporal.g
    public d resolve(Map<g, Long> r5, d r10, ResolverStyle r11) {
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
