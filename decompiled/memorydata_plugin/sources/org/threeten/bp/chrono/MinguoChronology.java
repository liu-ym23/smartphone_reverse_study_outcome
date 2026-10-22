package org.threeten.bp.chrono;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes8.dex */
public final class MinguoChronology extends Chronology implements Serializable {
    public static final MinguoChronology INSTANCE = null;
    static final int YEARS_DIFFERENCE = 1911;
    private static final long serialVersionUID = 1039765215346859963L;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.MinguoChronology$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.PROLEPTIC_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        INSTANCE = new MinguoChronology();
    }

    private MinguoChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate date(int r1, int r2, int r3) {
        return date(r1, r2, r3);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* synthetic */ ChronoLocalDate date(Era r3, int r4, int r5, int r6) {
        return date((Era) ZeusTransformUtils.wrapperContextForParams(r3, Era.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* synthetic */ ChronoLocalDate date(TemporalAccessor r3) {
        return date((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public MinguoDate date(int r1, int r2, int r3) {
        return new MinguoDate(LocalDate.of(r1 + YEARS_DIFFERENCE, r2, r3));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public MinguoDate date(Era r3, int r4, int r5, int r6) {
        return (MinguoDate) ZeusTransformUtils.preCheckCast(super.date((Era) ZeusTransformUtils.wrapperContextForParams(r3, Era.class, "com.obric.memorydata.plugin"), r4, r5, r6), MinguoDate.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public MinguoDate date(TemporalAccessor r2) {
        TemporalAccessor r1 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r2, TemporalAccessor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, MinguoDate.class) == false) goto L7;
        return (MinguoDate) ZeusTransformUtils.preCheckCast(r1, MinguoDate.class, "com.obric.memorydata.plugin");
    L7:
        return new MinguoDate(LocalDate.from(r1));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateEpochDay(long r1) {
        return dateEpochDay(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public MinguoDate dateEpochDay(long r1) {
        return new MinguoDate(LocalDate.ofEpochDay(r1));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateNow() {
        return dateNow();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateNow(Clock r1) {
        return dateNow(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateNow(ZoneId r1) {
        return dateNow(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public MinguoDate dateNow() {
        return (MinguoDate) ZeusTransformUtils.preCheckCast(super.dateNow(), MinguoDate.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public MinguoDate dateNow(Clock r2) {
        Jdk8Methods.requireNonNull(r2, "clock");
        return (MinguoDate) ZeusTransformUtils.preCheckCast(super.dateNow(r2), MinguoDate.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public MinguoDate dateNow(ZoneId r2) {
        return (MinguoDate) ZeusTransformUtils.preCheckCast(super.dateNow(r2), MinguoDate.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateYearDay(int r1, int r2) {
        return dateYearDay(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* synthetic */ ChronoLocalDate dateYearDay(Era r3, int r4, int r5) {
        return dateYearDay((Era) ZeusTransformUtils.wrapperContextForParams(r3, Era.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public MinguoDate dateYearDay(int r1, int r2) {
        return new MinguoDate(LocalDate.ofYearDay(r1 + YEARS_DIFFERENCE, r2));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public MinguoDate dateYearDay(Era r3, int r4, int r5) {
        return (MinguoDate) ZeusTransformUtils.preCheckCast(super.dateYearDay((Era) ZeusTransformUtils.wrapperContextForParams(r3, Era.class, "com.obric.memorydata.plugin"), r4, r5), MinguoDate.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ Era eraOf(int r1) {
        return eraOf(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public MinguoEra eraOf(int r1) {
        return MinguoEra.of(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public List<Era> eras() {
        return Arrays.asList(MinguoEra.values());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "roc";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "Minguo";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public boolean isLeapYear(long r3) {
        return IsoChronology.INSTANCE.isLeapYear(r3 + 1911);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime<MinguoDate> localDateTime(TemporalAccessor r3) {
        return super.localDateTime((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public int prolepticYear(Era r2, int r3) {
        Era r1 = (Era) ZeusTransformUtils.wrapperContextForParams(r2, Era.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, MinguoEra.class) == false) goto L10;
        if (r1 != MinguoEra.ROC) goto L8;
        return r3;
    L8:
        return 1 - r3;
    L10:
        throw new ClassCastException("Era must be MinguoEra");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ValueRange range(ChronoField r10) {
        int r9 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r10.ordinal()];
        if (r9 != 1) goto L5;
        ValueRange r11 = ChronoField.PROLEPTIC_MONTH.range();
        return ValueRange.of(r11.getMinimum() - 22932, r11.getMaximum() - 22932);
    L5:
        if (r9 != 2) goto L7;
        ValueRange r12 = ChronoField.YEAR.range();
        return ValueRange.of(1, r12.getMaximum() - 1911, ((-r12.getMinimum()) + 1) + 1911);
    L7:
        if (r9 != 3) goto L9;
        ValueRange r13 = ChronoField.YEAR.range();
        return ValueRange.of(r13.getMinimum() - 1911, r13.getMaximum() - 1911);
    L9:
        return r10.range();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* synthetic */ ChronoLocalDate resolveDate(Map r3, ResolverStyle r4) {
        return resolveDate((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public MinguoDate resolveDate(Map<TemporalField, Long> r12, ResolverStyle r13) {
        Map<TemporalField, Long> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if (r14.containsKey(ChronoField.EPOCH_DAY) == true) goto L5;
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.PROLEPTIC_MONTH), Long.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
    L12:
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR_OF_ERA), Long.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L44;
        if (r13 == ResolverStyle.LENIENT) goto L17;
        ChronoField.YEAR_OF_ERA.checkValidValue(r1.longValue());
    L17:
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ERA), Long.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L35;
        Long r6 = (Long) ZeusTransformUtils.preCheckCast(r14.get(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin");
        if (r13 != ResolverStyle.STRICT) goto L26;
        if (r6 == null) goto L25;
        ChronoField r8 = ChronoField.YEAR;
        if (r6.longValue() > 0) goto L32;
    L31:
        long r7 = Jdk8Methods.safeSubtract(1, r1.longValue());
    L33:
        updateResolveMap(r14, r8, r7);
    L47:
        if (r14.containsKey(ChronoField.YEAR) == true) goto L49;
        return null;
    L49:
        if (r14.containsKey(ChronoField.MONTH_OF_YEAR) == false) goto L94;
        if (r14.containsKey(ChronoField.DAY_OF_MONTH) == false) goto L64;
        int r2 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L56;
        long r9 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        return date(r2, 1, 1).plusMonths(r9).plusDays(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue(), 1));
    L56:
        int r3 = range(ChronoField.MONTH_OF_YEAR).checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), ChronoField.MONTH_OF_YEAR);
        int r15 = range(ChronoField.DAY_OF_MONTH).checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue(), ChronoField.DAY_OF_MONTH);
        if (r13 != ResolverStyle.SMART) goto L62;
        if (r15 <= 28) goto L62;
        r15 = Math.min(r15, date(r2, r3, 1).lengthOfMonth());
    L62:
        return date(r2, r3, r15);
    L64:
        if (r14.containsKey(ChronoField.ALIGNED_WEEK_OF_MONTH) == false) goto L94;
        if (r14.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH) == false) goto L80;
        int r4 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L71;
        long r10 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        long r11 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        return date(r4, 1, 1).plus(r10, ChronoUnit.MONTHS).plus(r11, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue(), 1), ChronoUnit.DAYS);
    L71:
        int r16 = ChronoField.MONTH_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        MinguoDate r17 = date(r4, r16, 1).plus(((ChronoField.ALIGNED_WEEK_OF_MONTH.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1) * 7) + (ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1), ChronoUnit.DAYS);
        if (r13 == ResolverStyle.STRICT) goto L74;
    L78:
        return r17;
    L74:
        if (r17.get(ChronoField.MONTH_OF_YEAR) == r16) goto L78;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L80:
        if (r14.containsKey(ChronoField.DAY_OF_WEEK) == false) goto L94;
        int r18 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L85;
        long r19 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        long r20 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        return date(r18, 1, 1).plus(r19, ChronoUnit.MONTHS).plus(r20, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.memorydata.plugin")).longValue(), 1), ChronoUnit.DAYS);
    L85:
        int r21 = ChronoField.MONTH_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        MinguoDate r110 = date(r18, r21, 1).plus(ChronoField.ALIGNED_WEEK_OF_MONTH.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1, ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(ChronoField.DAY_OF_WEEK.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.memorydata.plugin")).longValue()))));
        if (r13 == ResolverStyle.STRICT) goto L88;
    L92:
        return r110;
    L88:
        if (r110.get(ChronoField.MONTH_OF_YEAR) == r21) goto L92;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L94:
        if (r14.containsKey(ChronoField.DAY_OF_YEAR) == false) goto L102;
        int r22 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L100;
        return dateYearDay(r22, 1).plusDays(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1));
    L100:
        return dateYearDay(r22, ChronoField.DAY_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue()));
    L102:
        if (r14.containsKey(ChronoField.ALIGNED_WEEK_OF_YEAR) == true) goto L104;
        return null;
    L104:
        if (r14.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) == false) goto L118;
        int r23 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L109;
        long r24 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        return date(r23, 1, 1).plus(r24, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1), ChronoUnit.DAYS);
    L109:
        MinguoDate r111 = date(r23, 1, 1).plusDays(((ChronoField.ALIGNED_WEEK_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1) * 7) + (ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1));
        if (r13 == ResolverStyle.STRICT) goto L112;
    L116:
        return r111;
    L112:
        if (r111.get(ChronoField.YEAR) == r23) goto L116;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L118:
        if (r14.containsKey(ChronoField.DAY_OF_WEEK) == false) goto L134;
        int r25 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L123;
        long r26 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        return date(r25, 1, 1).plus(r26, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.memorydata.plugin")).longValue(), 1), ChronoUnit.DAYS);
    L123:
        MinguoDate r112 = date(r25, 1, 1).plus(ChronoField.ALIGNED_WEEK_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1, ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(ChronoField.DAY_OF_WEEK.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.memorydata.plugin")).longValue()))));
        if (r13 == ResolverStyle.STRICT) goto L126;
    L130:
        return r112;
    L126:
        if (r112.get(ChronoField.YEAR) == r25) goto L130;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L134:
        return null;
    L32:
        r7 = r1.longValue();
        goto L33
    L25:
        r14.put(ChronoField.YEAR_OF_ERA, r1);
        goto L47
    L26:
        r8 = ChronoField.YEAR;
        if (r6 == null) goto L32;
        if (r6.longValue() <= 0) goto L31;
    L35:
        if (r5.longValue() != 1) goto L39;
        ChronoField r27 = ChronoField.YEAR;
        long r28 = r1.longValue();
    L37:
        updateResolveMap(r14, r27, r28);
        goto L47
    L39:
        if (r5.longValue() != 0) goto L42;
        r27 = ChronoField.YEAR;
        r28 = Jdk8Methods.safeSubtract(1, r1.longValue());
        goto L37
    L42:
        throw new DateTimeException("Invalid value for era: " + r5);
    L44:
        if (r14.containsKey(ChronoField.ERA) == false) goto L47;
        ChronoField.ERA.checkValidValue(((Long) ZeusTransformUtils.preCheckCast(r14.get(ChronoField.ERA), Long.class, "com.obric.memorydata.plugin")).longValue());
        goto L47
    L9:
        if (r13 == ResolverStyle.LENIENT) goto L11;
        ChronoField.PROLEPTIC_MONTH.checkValidValue(r0.longValue());
    L11:
        updateResolveMap(r14, ChronoField.MONTH_OF_YEAR, Jdk8Methods.floorMod(r0.longValue(), 12) + 1);
        updateResolveMap(r14, ChronoField.YEAR, Jdk8Methods.floorDiv(r0.longValue(), 12));
        goto L12
    L5:
        return dateEpochDay(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.EPOCH_DAY), Long.class, "com.obric.memorydata.plugin")).longValue());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<MinguoDate> zonedDateTime(Instant r1, ZoneId r2) {
        return super.zonedDateTime(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<MinguoDate> zonedDateTime(TemporalAccessor r3) {
        return super.zonedDateTime((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin"));
    }
}
