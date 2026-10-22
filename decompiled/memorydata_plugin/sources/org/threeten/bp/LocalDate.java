package org.threeten.bp;

import com.bytedance.apm6.util.NetUtils;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoPeriod;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.Era;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;

/* JADX INFO: loaded from: classes8.dex */
public final class LocalDate extends ChronoLocalDate implements Serializable, Temporal, TemporalAdjuster {
    static final long DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    public static final TemporalQuery<LocalDate> FROM = null;
    public static final LocalDate MAX = null;
    public static final LocalDate MIN = null;
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;

    /* JADX INFO: renamed from: org.threeten.bp.LocalDate$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit = null;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0;
            r0[ChronoUnit.DAYS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L76:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L60:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MONTHS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L74:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.YEARS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L78:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L37
        L62:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L38
        L64:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L39
        L90:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L40
        L18:
            int[] r8 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r8;
            r8[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L84:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L86:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L58:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
        L80:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_WEEK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L45
        L94:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L46
        L54:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L47
        L66:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.EPOCH_DAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L48
        L92:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L49
        L56:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L50
        L82:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 11;     // Catch: NoSuchFieldError -> L51
        L88:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 12;     // Catch: NoSuchFieldError -> L52
        L72:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 13;     // Catch: NoSuchFieldError -> L53
            return;
        }
    }

    static {
        MIN = of(Year.MIN_VALUE, 1, 1);
        MAX = of(Year.MAX_VALUE, 12, 31);
        FROM = new AnonymousClass1();
    }

    private LocalDate(int r1, int r2, int r3) {
        this.year = r1;
        this.month = (short) r2;
        this.day = (short) r3;
    }

    private static LocalDate create(int r3, Month r4, int r5) {
        if (r5 <= 28) goto L13;
        if (r5 <= r4.length(IsoChronology.INSTANCE.isLeapYear(r3))) goto L13;
        if (r5 != 29) goto L11;
        throw new DateTimeException("Invalid date 'February 29' as '" + r3 + "' is not a leap year");
    L11:
        throw new DateTimeException("Invalid date '" + r4.name() + " " + r5 + "'");
    L13:
        return new LocalDate(r3, r4.getValue(), r5);
    }

    public static LocalDate from(TemporalAccessor r3) {
        TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin");
        LocalDate r0 = (LocalDate) ZeusTransformUtils.preCheckCast(r4.query(TemporalQueries.localDate()), LocalDate.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + r4 + ", type " + r4.getClass().getName());
    }

    private int get0(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.memorydata.plugin")).ordinal()]) {
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
        int r3 = this.year;
        if (r3 < 1) goto L31;
        return r3;
    L31:
        return 1 - r3;
    L5:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r5);
    L7:
        if (this.year >= 1) goto L38;
        return 0;
    L38:
        return 1;
    L12:
        return this.year;
    L14:
        throw new DateTimeException("Field too large for an int: " + r5);
    L16:
        return this.month;
    L18:
        return ((getDayOfYear() - 1) / 7) + 1;
    L20:
        throw new DateTimeException("Field too large for an int: " + r5);
    L22:
        return ((getDayOfYear() - 1) % 7) + 1;
    L24:
        return ((this.day - 1) % 7) + 1;
    L26:
        return getDayOfWeek().getValue();
    L33:
        return ((this.day - 1) / 7) + 1;
    L35:
        return getDayOfYear();
    L37:
        return this.day;
    }

    private long getProlepticMonth() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    private long monthsUntil(LocalDate r7) {
        long r0 = (getProlepticMonth() * 32) + ((long) getDayOfMonth());
        return (((r7.getProlepticMonth() * 32) + ((long) r7.getDayOfMonth())) - r0) / 32;
    }

    public static LocalDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDate now(Clock r4) {
        Jdk8Methods.requireNonNull(r4, "clock");
        Instant r0 = r4.instant();
        ZoneOffset r5 = r4.getZone().getRules().getOffset(r0);
        return ofEpochDay(Jdk8Methods.floorDiv(r0.getEpochSecond() + ((long) r5.getTotalSeconds()), TimeUtils.SECONDS_PER_DAY));
    }

    public static LocalDate now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static LocalDate of(int r3, int r4, int r5) {
        ChronoField.YEAR.checkValidValue(r3);
        ChronoField.MONTH_OF_YEAR.checkValidValue(r4);
        ChronoField.DAY_OF_MONTH.checkValidValue(r5);
        return create(r3, Month.of(r4), r5);
    }

    public static LocalDate of(int r3, Month r4, int r5) {
        ChronoField.YEAR.checkValidValue(r3);
        Jdk8Methods.requireNonNull(r4, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(r5);
        return create(r3, r4, r5);
    }

    public static LocalDate ofEpochDay(long r23) {
        ChronoField.EPOCH_DAY.checkValidValue(r23);
        long r0 = (r23 + DAYS_0000_TO_1970) - 60;
        if (r0 >= 0) goto L5;
        long r11 = ((r0 + 1) / 146097) - 1;
        long r13 = r11 * 400;
        r0 = r0 + ((-r11) * 146097);
    L6:
        long r12 = ((r0 * 400) + 591) / 146097;
        long r15 = r0 - ((((r12 * 365) + (r12 / 4)) - (r12 / 100)) + (r12 / 400));
        if (r15 >= 0) goto L9;
        r12 = r12 - 1;
        r15 = r0 - ((((365 * r12) + (r12 / 4)) - (r12 / 100)) + (r12 / 400));
    L9:
        int r1 = (int) r15;
        int r2 = ((r1 * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue((r12 + r13) + ((long) (r2 / 10))), ((r2 + 2) % 12) + 1, (r1 - (((r2 * 306) + 5) / 10)) + 1);
    L5:
        r13 = 0;
        goto L6
    }

    public static LocalDate ofYearDay(int r5, int r6) {
        long r1 = r5;
        ChronoField.YEAR.checkValidValue(r1);
        ChronoField.DAY_OF_YEAR.checkValidValue(r6);
        boolean r0 = IsoChronology.INSTANCE.isLeapYear(r1);
        if (r6 != 366) goto L8;
        if (r0 == true) goto L8;
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + r5 + "' is not a leap year");
    L8:
        Month r2 = Month.of(((r6 - 1) / 31) + 1);
        if (r6 <= ((r2.firstDayOfYear(r0) + r2.length(r0)) - 1)) goto L12;
        r2 = r2.plus(1);
    L12:
        return create(r5, r2, (r6 - r2.firstDayOfYear(r0)) + 1);
    }

    public static LocalDate parse(CharSequence r2) {
        return parse((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static LocalDate parse(CharSequence r2, DateTimeFormatter r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r3, "formatter");
        return (LocalDate) ZeusTransformUtils.preCheckCast(r3.parse(r4, FROM), LocalDate.class, "com.obric.memorydata.plugin");
    }

    static LocalDate readExternal(DataInput r2) {
        DataInput r3 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.memorydata.plugin");
        return of(r3.readInt(), r3.readByte(), r3.readByte());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static LocalDate resolvePreviousValid(int r3, int r4, int r5) {
        if (r4 == 2) goto L16;
        if (r4 != 4) goto L7;
    L13:
        int r0 = 30;
    L14:
        r5 = Math.min(r5, r0);
    L20:
        return of(r3, r4, r5);
    L7:
        if (r4 == 6) goto L13;
        if (r4 == 9) goto L13;
        if (r4 == 11) goto L13;
    L16:
        if (IsoChronology.INSTANCE.isLeapYear(r3) == false) goto L18;
        r0 = 29;
        goto L14
    L18:
        r0 = 28;
        goto L14
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r3) {
        return super.adjustInto((Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.memorydata.plugin"));
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.of(this, LocalTime.MIDNIGHT);
    }

    public ZonedDateTime atStartOfDay(ZoneId r3) {
        Jdk8Methods.requireNonNull(r3, "zone");
        LocalDateTime r2 = atTime(LocalTime.MIDNIGHT);
        if (ZeusTransformUtils.instanceOf(r3, ZoneOffset.class) == true) goto L10;
        ZoneOffsetTransition r0 = r3.getRules().getTransition(r2);
        if (r0 == null) goto L10;
        if (r0.isGap() == false) goto L10;
        r2 = r0.getDateTimeAfter();
    L10:
        return ZonedDateTime.of(r2, r3);
    }

    public LocalDateTime atTime(int r1, int r2) {
        return atTime(LocalTime.of(r1, r2));
    }

    public LocalDateTime atTime(int r1, int r2, int r3) {
        return atTime(LocalTime.of(r1, r2, r3));
    }

    public LocalDateTime atTime(int r1, int r2, int r3, int r4) {
        return atTime(LocalTime.of(r1, r2, r3, r4));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public LocalDateTime atTime(LocalTime r1) {
        return LocalDateTime.of(this, r1);
    }

    public OffsetDateTime atTime(OffsetTime r2) {
        return OffsetDateTime.of(LocalDateTime.of(this, r2.toLocalTime()), r2.getOffset());
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ ChronoLocalDateTime atTime(LocalTime r1) {
        return atTime(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, java.lang.Comparable
    public /* synthetic */ int compareTo(Object r3) {
        return compareTo((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r3, ChronoLocalDate.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int compareTo(ChronoLocalDate r3) {
        if (ZeusTransformUtils.instanceOf(r3, LocalDate.class) == false) goto L7;
        return compareTo0((LocalDate) ZeusTransformUtils.preCheckCast(r3, LocalDate.class, "com.obric.memorydata.plugin"));
    L7:
        return super.compareTo(r3);
    }

    int compareTo0(LocalDate r3) {
        int r0 = this.year - r3.year;
        if (r0 != 0) goto L8;
        int r1 = this.month - r3.month;
        if (r1 == 0) goto L7;
        return r1;
    L7:
        return this.day - r3.day;
    L8:
        return r0;
    }

    long daysUntil(LocalDate r3) {
        return r3.toEpochDay() - toEpochDay();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LocalDate.class) == true) goto L8;
        return false;
    L8:
        if (compareTo0((LocalDate) ZeusTransformUtils.preCheckCast(r5, LocalDate.class, "com.obric.memorydata.plugin")) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public String format(DateTimeFormatter r1) {
        return super.format(r1);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L7;
        return get0(r4);
    L7:
        return super.get(r4);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ Chronology getChronology() {
        return getChronology();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(Jdk8Methods.floorMod(toEpochDay() + 3, 7) + 1);
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Era getEra() {
        return super.getEra();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L15;
        if (r4 != ChronoField.EPOCH_DAY) goto L9;
        return toEpochDay();
    L9:
        if (r4 != ChronoField.PROLEPTIC_MONTH) goto L13;
        return getProlepticMonth();
    L13:
        return get0(r4);
    L15:
        return r4.getFrom(this);
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

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        int r0 = this.year;
        short r1 = this.month;
        int r2 = r0 & (-2048);
        int r3 = (r0 << 11) + (r1 << 6);
        return r2 ^ (r3 + this.day);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isAfter(ChronoLocalDate r3) {
        if (ZeusTransformUtils.instanceOf(r3, LocalDate.class) == false) goto L10;
        if (compareTo0((LocalDate) ZeusTransformUtils.preCheckCast(r3, LocalDate.class, "com.obric.memorydata.plugin")) <= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isAfter(r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isBefore(ChronoLocalDate r3) {
        if (ZeusTransformUtils.instanceOf(r3, LocalDate.class) == false) goto L10;
        if (compareTo0((LocalDate) ZeusTransformUtils.preCheckCast(r3, LocalDate.class, "com.obric.memorydata.plugin")) >= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isBefore(r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isEqual(ChronoLocalDate r3) {
        if (ZeusTransformUtils.instanceOf(r3, LocalDate.class) == false) goto L10;
        if (compareTo0((LocalDate) ZeusTransformUtils.preCheckCast(r3, LocalDate.class, "com.obric.memorydata.plugin")) != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isEqual(r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r3) {
        return super.isSupported((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        short r0 = this.month;
        if (r0 == 2) goto L17;
        if (r0 != 4) goto L7;
        return 30;
    L7:
        if (r0 != 6) goto L9;
        return 30;
    L9:
        if (r0 != 9) goto L11;
        return 30;
    L11:
        if (r0 == 11) goto L24;
        return 31;
    L24:
        return 30;
    L17:
        if (isLeapYear() == false) goto L19;
        return 29;
    L19:
        return 28;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int lengthOfYear() {
        if (isLeapYear() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDate minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalDate this = plus(Long.MAX_VALUE, r6);
        long r4 = 1;
    L7:
        return this.plus(r4, r6);
    L5:
        r4 = -r3;
        goto L7
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public LocalDate minus(TemporalAmount r3) {
        return (LocalDate) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).subtractFrom(this), LocalDate.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDate minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public /* synthetic */ ChronoLocalDate minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public /* synthetic */ Temporal minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public LocalDate minusDays(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalDate this = plusDays(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusDays(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public LocalDate minusMonths(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalDate this = plusMonths(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMonths(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public LocalDate minusWeeks(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalDate this = plusWeeks(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusWeeks(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public LocalDate minusYears(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalDate this = plusYears(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusYears(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public LocalDate plus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L25;
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) ZeusTransformUtils.preCheckCast(r6, ChronoUnit.class, "com.obric.memorydata.plugin")).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r6);
    L9:
        return with(ChronoField.ERA, Jdk8Methods.safeAdd(getLong(ChronoField.ERA), r3));
    L11:
        return plusYears(Jdk8Methods.safeMultiply(r3, 1000));
    L13:
        return plusYears(Jdk8Methods.safeMultiply(r3, 100));
    L15:
        return plusYears(Jdk8Methods.safeMultiply(r3, 10));
    L17:
        return plusYears(r3);
    L19:
        return plusMonths(r3);
    L21:
        return plusWeeks(r3);
    L23:
        return plusDays(r3);
    L25:
        return (LocalDate) ZeusTransformUtils.preCheckCast(r6.addTo(this, r3), LocalDate.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public LocalDate plus(TemporalAmount r3) {
        return (LocalDate) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).addTo(this), LocalDate.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDate plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public /* synthetic */ ChronoLocalDate plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public /* synthetic */ Temporal plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public LocalDate plusDays(long r3) {
        if (r3 != 0) goto L6;
        return this;
    L6:
        return ofEpochDay(Jdk8Methods.safeAdd(toEpochDay(), r3));
    }

    public LocalDate plusMonths(long r7) {
        if (r7 != 0) goto L5;
        return this;
    L5:
        long r0 = ((((long) this.year) * 12) + ((long) (this.month - 1))) + r7;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(Jdk8Methods.floorDiv(r0, 12)), Jdk8Methods.floorMod(r0, 12) + 1, this.day);
    }

    public LocalDate plusWeeks(long r2) {
        return plusDays(Jdk8Methods.safeMultiply(r2, 7));
    }

    public LocalDate plusYears(long r4) {
        if (r4 != 0) goto L6;
        return this;
    L6:
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(((long) this.year) + r4), this.month, this.day);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<LocalDate> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin");
        if (r4 != TemporalQueries.localDate()) goto L6;
        return this;
    L6:
        return (R) super.query(r4);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r5) {
        TemporalField r6 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r5, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoField.class) == false) goto L37;
        ChronoField r0 = (ChronoField) ZeusTransformUtils.preCheckCast(r6, ChronoField.class, "com.obric.memorydata.plugin");
        if (r0.isDateBased() == false) goto L35;
        int r1 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 != 1) goto L9;
        int r4 = lengthOfMonth();
    L32:
        return ValueRange.of(1, r4);
    L9:
        if (r1 != 2) goto L11;
        r4 = lengthOfYear();
        goto L32
    L11:
        if (r1 == 3) goto L23;
        if (r1 == 4) goto L17;
        return r6.range();
    L17:
        if (getYear() > 0) goto L19;
        long r7 = 1000000000;
    L21:
        return ValueRange.of(1, r7);
    L19:
        r7 = 999999999;
        goto L21
    L23:
        if (getMonth() == Month.FEBRUARY) goto L25;
    L27:
        long r8 = 5;
    L29:
        return ValueRange.of(1, r8);
    L25:
        if (isLeapYear() == true) goto L27;
        r8 = 4;
        goto L29
    L35:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r6);
    L37:
        return r6.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        long r0 = this.year;
        long r2 = this.month;
        long r4 = (365 * r0) + 0;
        if (r0 < 0) goto L5;
        long r5 = r4 + ((((3 + r0) / 4) - ((99 + r0) / 100)) + ((r0 + 399) / 400));
    L6:
        long r6 = (r5 + (((367 * r2) - 362) / 12)) + ((long) (this.day - 1));
        if (r2 <= 2) goto L12;
        r6 = r6 - 1;
        if (isLeapYear() == true) goto L12;
        r6 = r6 - 1;
    L12:
        return r6 - DAYS_0000_TO_1970;
    L5:
        r5 = r4 - (((r0 / (-4)) - (r0 / (-100))) + (r0 / (-400)));
        goto L6
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public String toString() {
        int r0 = this.year;
        short r1 = this.month;
        short r6 = this.day;
        int r2 = Math.abs(r0);
        StringBuilder r3 = new StringBuilder(10);
        if (r2 >= 1000) goto L9;
        if (r0 >= 0) goto L6;
        StringBuilder r4 = r3.append(r0 + NetUtils.NET_DEFAULT);
        int r5 = 1;
    L7:
        r4.deleteCharAt(r5);
    L12:
        String r7 = "-0";
        if (r1 >= 10) goto L15;
        String r8 = "-0";
    L16:
        StringBuilder r9 = r3.append(r8).append(r1);
        if (r6 < 10) goto L21;
        r7 = "-";
    L21:
        return r9.append(r7).append(r6).toString();
    L15:
        r8 = "-";
        goto L16
    L6:
        r4 = r3.append(r0 + 10000);
        r5 = 0;
        goto L7
    L9:
        if (r0 <= 9999) goto L11;
        r3.append('+');
    L11:
        r3.append(r0);
        goto L12
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r4, TemporalUnit r5) {
        Temporal r6 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.memorydata.plugin");
        TemporalUnit r7 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
        LocalDate r8 = from(r6);
        if (ZeusTransformUtils.instanceOf(r7, ChronoUnit.class) == false) goto L22;
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) ZeusTransformUtils.preCheckCast(r7, ChronoUnit.class, "com.obric.memorydata.plugin")).ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L7;
        };
    L10:
        long r3 = monthsUntil(r8);
        long r0 = 12000;
    L12:
        return r3 / r0;
    L13:
        r3 = monthsUntil(r8);
        r0 = 1200;
        goto L12
    L14:
        r3 = monthsUntil(r8);
        r0 = 120;
        goto L12
    L15:
        r3 = monthsUntil(r8);
        r0 = 12;
        goto L12
    L18:
        r3 = daysUntil(r8);
        r0 = 7;
        goto L12
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r7);
    L9:
        return r8.getLong(ChronoField.ERA) - getLong(ChronoField.ERA);
    L17:
        return monthsUntil(r8);
    L20:
        return daysUntil(r8);
    L22:
        return r7.between(this, r8);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Period until(ChronoLocalDate r7) {
        LocalDate r8 = from(r7);
        long r0 = r8.getProlepticMonth() - getProlepticMonth();
        int r2 = r8.day - this.day;
        if (r0 <= 0) goto L6;
        if (r2 >= 0) goto L6;
        r0 = r0 - 1;
        LocalDate r6 = plusMonths(r0);
        r2 = (int) (r8.toEpochDay() - r6.toEpochDay());
    L9:
        long r3 = r0 / 12;
        int r9 = Jdk8Methods.safeToInt(r3);
        return Period.of(r9, (int) (r0 % 12), r2);
    L6:
        if (r0 >= 0) goto L9;
        if (r2 <= 0) goto L9;
        r0 = r0 + 1;
        r2 = r2 - r8.lengthOfMonth();
        goto L9
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ ChronoPeriod until(ChronoLocalDate r1) {
        return until(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDate with(TemporalAdjuster r4) {
        TemporalAdjuster r5 = (TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAdjuster.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, LocalDate.class) == false) goto L7;
        Object r3 = ZeusTransformUtils.preCheckCast(r5, LocalDate.class, "com.obric.memorydata.plugin");
    L6:
        return (LocalDate) r3;
    L7:
        r3 = ZeusTransformUtils.preCheckCast(r5.adjustInto(this), LocalDate.class, "com.obric.memorydata.plugin");
        goto L6
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public LocalDate with(TemporalField r5, long r6) {
        TemporalField r7 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r5, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ChronoField.class) == false) goto L42;
        ChronoField r0 = (ChronoField) ZeusTransformUtils.preCheckCast(r7, ChronoField.class, "com.obric.memorydata.plugin");
        r0.checkValidValue(r6);
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()]) {
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
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r7);
    L9:
        if (getLong(ChronoField.ERA) != r6) goto L12;
        return this;
    L12:
        return withYear(1 - this.year);
    L14:
        return withYear((int) r6);
    L16:
        return plusMonths(r6 - getLong(ChronoField.PROLEPTIC_MONTH));
    L18:
        return withMonth((int) r6);
    L20:
        return plusWeeks(r6 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
    L22:
        return ofEpochDay(r6);
    L24:
        return plusDays(r6 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
    L26:
        return plusDays(r6 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
    L28:
        return plusDays(r6 - ((long) getDayOfWeek().getValue()));
    L30:
        if (this.year >= 1) goto L34;
        r6 = 1 - r6;
    L34:
        return withYear((int) r6);
    L36:
        return plusWeeks(r6 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
    L38:
        return withDayOfYear((int) r6);
    L40:
        return withDayOfMonth((int) r6);
    L42:
        return (LocalDate) ZeusTransformUtils.preCheckCast(r7.adjustInto(this, r6), LocalDate.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDate with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDate with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"), r4);
    }

    public LocalDate withDayOfMonth(int r2) {
        if (this.day != r2) goto L6;
        return this;
    L6:
        return of(this.year, this.month, r2);
    }

    public LocalDate withDayOfYear(int r2) {
        if (getDayOfYear() != r2) goto L6;
        return this;
    L6:
        return ofYearDay(this.year, r2);
    }

    public LocalDate withMonth(int r4) {
        if (this.month != r4) goto L5;
        return this;
    L5:
        ChronoField.MONTH_OF_YEAR.checkValidValue(r4);
        return resolvePreviousValid(this.year, r4, this.day);
    }

    public LocalDate withYear(int r4) {
        if (this.year != r4) goto L5;
        return this;
    L5:
        ChronoField.YEAR.checkValidValue(r4);
        return resolvePreviousValid(r4, this.month, this.day);
    }

    void writeExternal(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.memorydata.plugin");
        r4.writeInt(this.year);
        r4.writeByte(this.month);
        r4.writeByte(this.day);
    }
}
