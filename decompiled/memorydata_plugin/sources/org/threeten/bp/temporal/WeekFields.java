package org.threeten.bp.temporal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Year;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes8.dex */
public final class WeekFields implements Serializable {
    private static final ConcurrentMap<String, WeekFields> CACHE = null;
    public static final WeekFields ISO = null;
    public static final WeekFields SUNDAY_START = null;
    private static final long serialVersionUID = -1177360819670808121L;
    private final transient TemporalField dayOfWeek;
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    private final transient TemporalField weekBasedYear;
    private final transient TemporalField weekOfMonth;
    private final transient TemporalField weekOfWeekBasedYear;
    private final transient TemporalField weekOfYear;

    static class ComputedDayOfField implements TemporalField {
        private static final ValueRange DAY_OF_WEEK_RANGE = null;
        private static final ValueRange WEEK_BASED_YEAR_RANGE = null;
        private static final ValueRange WEEK_OF_MONTH_RANGE = null;
        private static final ValueRange WEEK_OF_WEEK_BASED_YEAR_RANGE = null;
        private static final ValueRange WEEK_OF_YEAR_RANGE = null;
        private final TemporalUnit baseUnit;
        private final String name;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;
        private final WeekFields weekDef;

        static {
            DAY_OF_WEEK_RANGE = ValueRange.of(1, 7);
            WEEK_OF_MONTH_RANGE = ValueRange.of(0, 1, 4, 6);
            WEEK_OF_YEAR_RANGE = ValueRange.of(0, 1, 52, 54);
            WEEK_OF_WEEK_BASED_YEAR_RANGE = ValueRange.of(1, 52, 53);
            WEEK_BASED_YEAR_RANGE = ChronoField.YEAR.range();
        }

        private ComputedDayOfField(String r3, WeekFields r4, TemporalUnit r5, TemporalUnit r6, ValueRange r7) {
            TemporalUnit r8 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
            TemporalUnit r9 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r6, TemporalUnit.class, "com.obric.memorydata.plugin");
            this.name = r3;
            this.weekDef = r4;
            this.baseUnit = r8;
            this.rangeUnit = r9;
            this.range = r7;
        }

        private int computeWeek(int r1, int r2) {
            return ((r1 + 7) + (r2 - 1)) / 7;
        }

        private int localizedDayOfWeek(TemporalAccessor r2, int r3) {
            return Jdk8Methods.floorMod(((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r2, TemporalAccessor.class, "com.obric.memorydata.plugin")).get(ChronoField.DAY_OF_WEEK) - r3, 7) + 1;
        }

        private int localizedWBY(TemporalAccessor r7) {
            TemporalAccessor r8 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r7, TemporalAccessor.class, "com.obric.memorydata.plugin");
            int r0 = Jdk8Methods.floorMod(r8.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            int r1 = r8.get(ChronoField.YEAR);
            long r2 = localizedWeekOfYear(r8, r0);
            if (r2 != 0) goto L7;
            return r1 - 1;
        L7:
            if (r2 >= 53) goto L9;
            return r1;
        L9:
            int r9 = startOfWeekOffset(r8.get(ChronoField.DAY_OF_YEAR), r0);
            if (Year.isLeap(r1) == false) goto L12;
            int r3 = 366;
        L14:
            if (r2 >= computeWeek(r9, r3 + this.weekDef.getMinimalDaysInFirstWeek())) goto L16;
            return r1;
        L16:
            return r1 + 1;
        L12:
            r3 = 365;
            goto L14
        }

        private int localizedWOWBY(TemporalAccessor r6) {
            TemporalAccessor r7 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r6, TemporalAccessor.class, "com.obric.memorydata.plugin");
            int r0 = Jdk8Methods.floorMod(r7.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            long r1 = localizedWeekOfYear(r7, r0);
            if (r1 != 0) goto L7;
            return ((int) localizedWeekOfYear(Chronology.from(r7).date(r7).minus(1, ChronoUnit.WEEKS), r0)) + 1;
        L7:
            if (r1 < 53) goto L17;
            int r2 = startOfWeekOffset(r7.get(ChronoField.DAY_OF_YEAR), r0);
            if (Year.isLeap(r7.get(ChronoField.YEAR)) == false) goto L11;
            int r8 = 366;
        L12:
            int r5 = computeWeek(r2, r8 + this.weekDef.getMinimalDaysInFirstWeek());
            if (r1 < r5) goto L17;
            return (int) (r1 - ((long) (r5 - 1)));
        L11:
            r8 = 365;
        L17:
            return (int) r1;
        }

        private long localizedWeekOfMonth(TemporalAccessor r3, int r4) {
            int r5 = ((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin")).get(ChronoField.DAY_OF_MONTH);
            return computeWeek(startOfWeekOffset(r5, r4), r5);
        }

        private long localizedWeekOfYear(TemporalAccessor r3, int r4) {
            int r5 = ((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin")).get(ChronoField.DAY_OF_YEAR);
            return computeWeek(startOfWeekOffset(r5, r4), r5);
        }

        static ComputedDayOfField ofDayOfWeekField(WeekFields r7) {
            return new ComputedDayOfField("DayOfWeek", r7, ChronoUnit.DAYS, ChronoUnit.WEEKS, DAY_OF_WEEK_RANGE);
        }

        static ComputedDayOfField ofWeekBasedYearField(WeekFields r7) {
            return new ComputedDayOfField("WeekBasedYear", r7, IsoFields.WEEK_BASED_YEARS, ChronoUnit.FOREVER, WEEK_BASED_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekOfMonthField(WeekFields r7) {
            return new ComputedDayOfField("WeekOfMonth", r7, ChronoUnit.WEEKS, ChronoUnit.MONTHS, WEEK_OF_MONTH_RANGE);
        }

        static ComputedDayOfField ofWeekOfWeekBasedYearField(WeekFields r7) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", r7, ChronoUnit.WEEKS, IsoFields.WEEK_BASED_YEARS, WEEK_OF_WEEK_BASED_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekOfYearField(WeekFields r7) {
            return new ComputedDayOfField("WeekOfYear", r7, ChronoUnit.WEEKS, ChronoUnit.YEARS, WEEK_OF_YEAR_RANGE);
        }

        private ValueRange rangeWOWBY(TemporalAccessor r9) {
            TemporalAccessor r10 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r9, TemporalAccessor.class, "com.obric.memorydata.plugin");
            int r0 = Jdk8Methods.floorMod(r10.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            long r1 = localizedWeekOfYear(r10, r0);
            if (r1 == 0) goto L5;
            int r2 = startOfWeekOffset(r10.get(ChronoField.DAY_OF_YEAR), r0);
            if (Year.isLeap(r10.get(ChronoField.YEAR)) == false) goto L9;
            int r3 = 366;
        L10:
            int r4 = computeWeek(r2, r3 + this.weekDef.getMinimalDaysInFirstWeek());
            if (r1 < r4) goto L15;
            return rangeWOWBY(Chronology.from(r10).date(r10).plus(2, ChronoUnit.WEEKS));
        L15:
            return ValueRange.of(1, r4 - 1);
        L9:
            r3 = 365;
            goto L10
        L5:
            return rangeWOWBY(Chronology.from(r10).date(r10).minus(2, ChronoUnit.WEEKS));
        }

        private int startOfWeekOffset(int r3, int r4) {
            int r5 = Jdk8Methods.floorMod(r3 - r4, 7);
            int r0 = -r5;
            if ((r5 + 1) > this.weekDef.getMinimalDaysInFirstWeek()) goto L5;
            return r0;
        L5:
            return 7 - r5;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public <R extends Temporal> R adjustInto(R r6, long r7) {
            R r8 = (R) ZeusTransformUtils.wrapperContextForParams(r6, Temporal.class, "com.obric.memorydata.plugin");
            int r0 = this.range.checkValidIntValue(r7, this);
            int r1 = r8.get(this);
            if (r0 != r1) goto L6;
            return r8;
        L6:
            if (this.rangeUnit != ChronoUnit.FOREVER) goto L20;
            int r2 = r8.get(WeekFields.access$000(this.weekDef));
            R r9 = (R) r8.plus((long) ((r7 - ((long) r1)) * 52.1775d), ChronoUnit.WEEKS);
            if (r9.get(this) <= r0) goto L12;
            long r10 = r9.get(WeekFields.access$000(this.weekDef));
        L21:
            return (R) r9.minus(r10, ChronoUnit.WEEKS);
        L12:
            if (r9.get(this) >= r0) goto L14;
            r9 = (R) r9.plus(2, ChronoUnit.WEEKS);
        L14:
            r9 = (R) r9.plus(r2 - r9.get(WeekFields.access$000(this.weekDef)), ChronoUnit.WEEKS);
            if (r9.get(this) <= r0) goto L18;
            r10 = 1;
            goto L21
        L18:
            return r9;
        L20:
            return (R) r8.plus(r0 - r1, this.baseUnit);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public long getFrom(TemporalAccessor r4) {
            TemporalAccessor r5 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAccessor.class, "com.obric.memorydata.plugin");
            int r0 = Jdk8Methods.floorMod(r5.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            if (this.rangeUnit != ChronoUnit.WEEKS) goto L7;
            return r0;
        L7:
            if (this.rangeUnit != ChronoUnit.MONTHS) goto L13;
            ChronoField r1 = ChronoField.DAY_OF_MONTH;
        L9:
            int r6 = r5.get(r1);
            int r3 = computeWeek(startOfWeekOffset(r6, r0), r6);
        L11:
            return r3;
        L13:
            if (this.rangeUnit != ChronoUnit.YEARS) goto L16;
            r1 = ChronoField.DAY_OF_YEAR;
            goto L9
        L16:
            if (this.rangeUnit != IsoFields.WEEK_BASED_YEARS) goto L19;
            r3 = localizedWOWBY(r5);
            goto L11
        L19:
            if (this.rangeUnit != ChronoUnit.FOREVER) goto L22;
            r3 = localizedWBY(r5);
            goto L11
        L22:
            throw new IllegalStateException("unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isSupportedBy(TemporalAccessor r3) {
            TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin");
            if (r4.isSupported(ChronoField.DAY_OF_WEEK) == true) goto L5;
            return false;
        L5:
            if (this.rangeUnit != ChronoUnit.WEEKS) goto L9;
            return true;
        L9:
            if (this.rangeUnit != ChronoUnit.MONTHS) goto L14;
            ChronoField r2 = ChronoField.DAY_OF_MONTH;
        L12:
            return r4.isSupported(r2);
        L14:
            if (this.rangeUnit != ChronoUnit.YEARS) goto L17;
            r2 = ChronoField.DAY_OF_YEAR;
            goto L12
        L17:
            if (this.rangeUnit != IsoFields.WEEK_BASED_YEARS) goto L20;
        L18:
            r2 = ChronoField.EPOCH_DAY;
            goto L12
        L20:
            if (this.rangeUnit == ChronoUnit.FOREVER) goto L18;
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange range() {
            return this.range;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor r7) {
            TemporalAccessor r8 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r7, TemporalAccessor.class, "com.obric.memorydata.plugin");
            if (this.rangeUnit != ChronoUnit.WEEKS) goto L7;
            return this.range;
        L7:
            if (this.rangeUnit != ChronoUnit.MONTHS) goto L10;
            ChronoField r0 = ChronoField.DAY_OF_MONTH;
        L12:
            int r1 = startOfWeekOffset(r8.get(r0), Jdk8Methods.floorMod(r8.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1);
            ValueRange r9 = r8.range(r0);
            return ValueRange.of(computeWeek(r1, (int) r9.getMinimum()), computeWeek(r1, (int) r9.getMaximum()));
        L10:
            if (this.rangeUnit != ChronoUnit.YEARS) goto L15;
            r0 = ChronoField.DAY_OF_YEAR;
            goto L12
        L15:
            if (this.rangeUnit != IsoFields.WEEK_BASED_YEARS) goto L19;
            return rangeWOWBY(r8);
        L19:
            if (this.rangeUnit != ChronoUnit.FOREVER) goto L23;
            return r8.range(ChronoField.YEAR);
        L23:
            throw new IllegalStateException("unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor resolve(Map<TemporalField, Long> r13, TemporalAccessor r14, ResolverStyle r15) {
            Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
            TemporalAccessor r17 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r14, TemporalAccessor.class, "com.obric.memorydata.plugin");
            int r0 = this.weekDef.getFirstDayOfWeek().getValue();
            if (this.rangeUnit != ChronoUnit.WEEKS) goto L7;
            r16.put(ChronoField.DAY_OF_WEEK, Long.valueOf(Jdk8Methods.floorMod((r0 - 1) + (this.range.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r16.remove(this), Long.class, "com.obric.memorydata.plugin")).longValue(), this) - 1), 7) + 1));
            return null;
        L7:
            if (r16.containsKey(ChronoField.DAY_OF_WEEK) == true) goto L10;
            return null;
        L10:
            if (this.rangeUnit != ChronoUnit.FOREVER) goto L29;
            if (r16.containsKey(WeekFields.access$000(this.weekDef)) == true) goto L14;
            return null;
        L14:
            Chronology r18 = Chronology.from(r17);
            int r2 = Jdk8Methods.floorMod(ChronoField.DAY_OF_WEEK.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r16.get(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.memorydata.plugin")).longValue()) - r0, 7) + 1;
            int r3 = range().checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r16.get(this), Long.class, "com.obric.memorydata.plugin")).longValue(), this);
            if (r15 != ResolverStyle.LENIENT) goto L17;
            ChronoLocalDate r19 = r18.date(r3, 1, this.weekDef.getMinimalDaysInFirstWeek());
            long r4 = ((Long) ZeusTransformUtils.preCheckCast(r16.get(WeekFields.access$000(this.weekDef)), Long.class, "com.obric.memorydata.plugin")).longValue();
        L18:
            int r1 = localizedDayOfWeek(r19, r0);
            ChronoLocalDate r110 = r19.plus(((r4 - localizedWeekOfYear(r19, r1)) * 7) + ((long) (r2 - r1)), ChronoUnit.DAYS);
            if (r15 == ResolverStyle.STRICT) goto L21;
        L25:
            r16.remove(this);
            Object r12 = WeekFields.access$000(this.weekDef);
        L26:
            r16.remove(r12);
            r16.remove(ChronoField.DAY_OF_WEEK);
            return r110;
        L21:
            if (r110.getLong(this) == ((Long) ZeusTransformUtils.preCheckCast(r16.get(this), Long.class, "com.obric.memorydata.plugin")).longValue()) goto L25;
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        L17:
            r19 = r18.date(r3, 1, this.weekDef.getMinimalDaysInFirstWeek());
            r4 = WeekFields.access$000(this.weekDef).range().checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r16.get(WeekFields.access$000(this.weekDef)), Long.class, "com.obric.memorydata.plugin")).longValue(), WeekFields.access$000(this.weekDef));
            goto L18
        L29:
            if (r16.containsKey(ChronoField.YEAR) == true) goto L31;
            return null;
        L31:
            int r5 = Jdk8Methods.floorMod(ChronoField.DAY_OF_WEEK.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r16.get(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.memorydata.plugin")).longValue()) - r0, 7) + 1;
            int r6 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r16.get(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
            Chronology r111 = Chronology.from(r17);
            if (this.rangeUnit != ChronoUnit.MONTHS) goto L49;
            if (r16.containsKey(ChronoField.MONTH_OF_YEAR) == true) goto L36;
            return null;
        L36:
            long r7 = ((Long) ZeusTransformUtils.preCheckCast(r16.remove(this), Long.class, "com.obric.memorydata.plugin")).longValue();
            if (r15 != ResolverStyle.LENIENT) goto L39;
            ChronoLocalDate r112 = r111.date(r6, 1, 1).plus(((Long) ZeusTransformUtils.preCheckCast(r16.get(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue() - 1, ChronoUnit.MONTHS);
            int r8 = localizedDayOfWeek(r112, r0);
            long r9 = ((r7 - localizedWeekOfMonth(r112, r8)) * 7) + ((long) (r5 - r8));
        L40:
            r110 = r112.plus(r9, ChronoUnit.DAYS);
            if (r15 == ResolverStyle.STRICT) goto L43;
        L47:
            r16.remove(this);
            r16.remove(ChronoField.YEAR);
            r12 = ChronoField.MONTH_OF_YEAR;
            goto L26
        L43:
            if (r110.getLong(ChronoField.MONTH_OF_YEAR) == ((Long) ZeusTransformUtils.preCheckCast(r16.get(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue()) goto L47;
            throw new DateTimeException("Strict mode rejected date parsed to a different month");
        L39:
            r112 = r111.date(r6, ChronoField.MONTH_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r16.get(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue()), 8);
            int r10 = localizedDayOfWeek(r112, r0);
            r9 = ((((long) this.range.checkValidIntValue(r7, this)) - localizedWeekOfMonth(r112, r10)) * 7) + ((long) (r5 - r10));
            goto L40
        L49:
            if (this.rangeUnit != ChronoUnit.YEARS) goto L63;
            long r11 = ((Long) ZeusTransformUtils.preCheckCast(r16.remove(this), Long.class, "com.obric.memorydata.plugin")).longValue();
            ChronoLocalDate r113 = r111.date(r6, 1, 1);
            ResolverStyle r20 = ResolverStyle.LENIENT;
            int r21 = localizedDayOfWeek(r113, r0);
            if (r15 != r20) goto L53;
            long r22 = ((r11 - localizedWeekOfYear(r113, r21)) * 7) + ((long) (r5 - r21));
        L54:
            r110 = r113.plus(r22, ChronoUnit.DAYS);
            if (r15 == ResolverStyle.STRICT) goto L57;
        L61:
            r16.remove(this);
            r12 = ChronoField.YEAR;
            goto L26
        L57:
            if (r110.getLong(ChronoField.YEAR) == ((Long) ZeusTransformUtils.preCheckCast(r16.get(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue()) goto L61;
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        L53:
            r22 = ((((long) this.range.checkValidIntValue(r11, this)) - localizedWeekOfYear(r113, r21)) * 7) + ((long) (r5 - r21));
            goto L54
        L63:
            throw new IllegalStateException("unreachable");
        }

        public String toString() {
            return this.name + "[" + this.weekDef.toString() + "]";
        }
    }

    static {
        CACHE = new ConcurrentHashMap(4, 0.75f, 2);
        ISO = new WeekFields(DayOfWeek.MONDAY, 4);
        SUNDAY_START = of(DayOfWeek.SUNDAY, 1);
    }

    private WeekFields(DayOfWeek r2, int r3) {
        this.dayOfWeek = ComputedDayOfField.ofDayOfWeekField(this);
        this.weekOfMonth = ComputedDayOfField.ofWeekOfMonthField(this);
        this.weekOfYear = ComputedDayOfField.ofWeekOfYearField(this);
        this.weekOfWeekBasedYear = ComputedDayOfField.ofWeekOfWeekBasedYearField(this);
        this.weekBasedYear = ComputedDayOfField.ofWeekBasedYearField(this);
        Jdk8Methods.requireNonNull(r2, "firstDayOfWeek");
        if (r3 < 1) goto L9;
        if (r3 > 7) goto L9;
        this.firstDayOfWeek = r2;
        this.minimalDays = r3;
        return;
    L9:
        throw new IllegalArgumentException("Minimal number of days is invalid");
    }

    static /* synthetic */ TemporalField access$000(WeekFields r0) {
        return r0.weekOfWeekBasedYear;
    }

    public static WeekFields of(Locale r4) {
        Jdk8Methods.requireNonNull(r4, "locale");
        GregorianCalendar r5 = new GregorianCalendar(new Locale(r4.getLanguage(), r4.getCountry()));
        return of(DayOfWeek.SUNDAY.plus(r5.getFirstDayOfWeek() - 1), r5.getMinimalDaysInFirstWeek());
    }

    public static WeekFields of(DayOfWeek r5, int r6) {
        String r1 = r5.toString() + r6;
        ConcurrentMap<String, WeekFields> r2 = CACHE;
        WeekFields r3 = (WeekFields) ZeusTransformUtils.preCheckCast(r2.get(r1), WeekFields.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        r2.putIfAbsent(r1, new WeekFields(r5, r6));
        return (WeekFields) ZeusTransformUtils.preCheckCast(r2.get(r1), WeekFields.class, "com.obric.memorydata.plugin");
    L6:
        return r3;
    }

    private Object readResolve() {
        return of(this.firstDayOfWeek, this.minimalDays);
    L4:
        e = move-exception;
        throw new InvalidObjectException("Invalid WeekFields" + e.getMessage());
    }

    public TemporalField dayOfWeek() {
        return this.dayOfWeek;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, WeekFields.class) == true) goto L8;
        return false;
    L8:
        if (hashCode() != r4.hashCode()) goto L11;
        return true;
    L11:
        return false;
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        return "WeekFields[" + this.firstDayOfWeek + ',' + this.minimalDays + ']';
    }

    public TemporalField weekBasedYear() {
        return this.weekBasedYear;
    }

    public TemporalField weekOfMonth() {
        return this.weekOfMonth;
    }

    public TemporalField weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }

    public TemporalField weekOfYear() {
        return this.weekOfYear;
    }
}
