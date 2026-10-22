package org.threeten.bp.chrono;

import androidx.exifinterface.media.ExifInterface;
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
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes8.dex */
public final class IsoChronology extends Chronology implements Serializable {
    public static final IsoChronology INSTANCE = null;
    private static final long serialVersionUID = -1440403870442975015L;

    static {
        INSTANCE = new IsoChronology();
    }

    private IsoChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate date(int r1, int r2, int r3) {
        return LocalDate.of(r1, r2, r3);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate date(Era r3, int r4, int r5, int r6) {
        return date(prolepticYear((Era) ZeusTransformUtils.wrapperContextForParams(r3, Era.class, "com.obric.memorydata.plugin"), r4), r5, r6);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate date(TemporalAccessor r2) {
        return LocalDate.from((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r2, TemporalAccessor.class, "com.obric.memorydata.plugin"));
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
    public LocalDate dateEpochDay(long r1) {
        return LocalDate.ofEpochDay(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateEpochDay(long r1) {
        return dateEpochDay(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateNow(Clock r2) {
        Jdk8Methods.requireNonNull(r2, "clock");
        return date(LocalDate.now(r2));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateNow(ZoneId r1) {
        return dateNow(Clock.system(r1));
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
    public LocalDate dateYearDay(int r1, int r2) {
        return LocalDate.ofYearDay(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateYearDay(Era r3, int r4, int r5) {
        return dateYearDay(prolepticYear((Era) ZeusTransformUtils.wrapperContextForParams(r3, Era.class, "com.obric.memorydata.plugin"), r4), r5);
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
    public /* bridge */ /* synthetic */ Era eraOf(int r1) {
        return eraOf(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public IsoEra eraOf(int r1) {
        return IsoEra.of(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public List<Era> eras() {
        return Arrays.asList(IsoEra.values());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "iso8601";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return ExifInterface.TAG_RW2_ISO;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public boolean isLeapYear(long r5) {
        if ((3 & r5) == 0) goto L5;
    L9:
        return false;
    L5:
        if ((r5 % 100) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r5 % 400) != 0) goto L9;
        goto L8
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDateTime localDateTime(TemporalAccessor r2) {
        return LocalDateTime.from((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r2, TemporalAccessor.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* synthetic */ ChronoLocalDateTime localDateTime(TemporalAccessor r3) {
        return localDateTime((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public int prolepticYear(Era r2, int r3) {
        Era r1 = (Era) ZeusTransformUtils.wrapperContextForParams(r2, Era.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, IsoEra.class) == false) goto L10;
        if (r1 != IsoEra.CE) goto L8;
        return r3;
    L8:
        return 1 - r3;
    L10:
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ValueRange range(ChronoField r1) {
        return r1.range();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate resolveDate(Map<TemporalField, Long> r12, ResolverStyle r13) {
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
        if (r14.containsKey(ChronoField.MONTH_OF_YEAR) == false) goto L107;
        if (r14.containsKey(ChronoField.DAY_OF_MONTH) == false) goto L77;
        int r11 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        int r2 = Jdk8Methods.safeToInt(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        int r15 = Jdk8Methods.safeToInt(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L57;
        long r3 = Jdk8Methods.safeSubtract(r2, 1);
        return LocalDate.of(r11, 1, 1).plusMonths(r3).plusDays(Jdk8Methods.safeSubtract(r15, 1));
    L57:
        if (r13 != ResolverStyle.SMART) goto L75;
        ChronoField.DAY_OF_MONTH.checkValidValue(r15);
        if (r2 != 4) goto L61;
    L70:
        int r16 = 30;
    L71:
        r15 = Math.min(r15, r16);
    L73:
        return LocalDate.of(r11, r2, r15);
    L61:
        if (r2 == 6) goto L70;
        if (r2 == 9) goto L70;
        if (r2 == 11) goto L70;
        if (r2 != 2) goto L73;
        r16 = Month.FEBRUARY.length(Year.isLeap(r11));
        goto L71
    L75:
        return LocalDate.of(r11, r2, r15);
    L77:
        if (r14.containsKey(ChronoField.ALIGNED_WEEK_OF_MONTH) == false) goto L107;
        if (r14.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH) == false) goto L93;
        int r17 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L84;
        long r9 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        long r10 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        return LocalDate.of(r17, 1, 1).plusMonths(r9).plusWeeks(r10).plusDays(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue(), 1));
    L84:
        int r4 = ChronoField.MONTH_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        LocalDate r18 = LocalDate.of(r17, r4, 1).plusDays(((ChronoField.ALIGNED_WEEK_OF_MONTH.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1) * 7) + (ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1));
        if (r13 == ResolverStyle.STRICT) goto L87;
    L91:
        return r18;
    L87:
        if (r18.get(ChronoField.MONTH_OF_YEAR) == r4) goto L91;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L93:
        if (r14.containsKey(ChronoField.DAY_OF_WEEK) == false) goto L107;
        int r19 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L98;
        long r20 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        long r21 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        return LocalDate.of(r19, 1, 1).plusMonths(r20).plusWeeks(r21).plusDays(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.memorydata.plugin")).longValue(), 1));
    L98:
        int r22 = ChronoField.MONTH_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        LocalDate r110 = LocalDate.of(r19, r22, 1).plusWeeks(ChronoField.ALIGNED_WEEK_OF_MONTH.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(ChronoField.DAY_OF_WEEK.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.memorydata.plugin")).longValue()))));
        if (r13 == ResolverStyle.STRICT) goto L101;
    L105:
        return r110;
    L101:
        if (r110.get(ChronoField.MONTH_OF_YEAR) == r22) goto L105;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L107:
        if (r14.containsKey(ChronoField.DAY_OF_YEAR) == false) goto L115;
        int r111 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L113;
        return LocalDate.ofYearDay(r111, 1).plusDays(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1));
    L113:
        return LocalDate.ofYearDay(r111, ChronoField.DAY_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue()));
    L115:
        if (r14.containsKey(ChronoField.ALIGNED_WEEK_OF_YEAR) == true) goto L117;
        return null;
    L117:
        if (r14.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) == false) goto L131;
        int r112 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L122;
        long r23 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        return LocalDate.of(r112, 1, 1).plusWeeks(r23).plusDays(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1));
    L122:
        LocalDate r113 = LocalDate.of(r112, 1, 1).plusDays(((ChronoField.ALIGNED_WEEK_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1) * 7) + (ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1));
        if (r13 == ResolverStyle.STRICT) goto L125;
    L129:
        return r113;
    L125:
        if (r113.get(ChronoField.YEAR) == r112) goto L129;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L131:
        if (r14.containsKey(ChronoField.DAY_OF_WEEK) == false) goto L147;
        int r114 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.YEAR), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L136;
        long r24 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue(), 1);
        return LocalDate.of(r114, 1, 1).plusWeeks(r24).plusDays(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.memorydata.plugin")).longValue(), 1));
    L136:
        LocalDate r115 = LocalDate.of(r114, 1, 1).plusWeeks(ChronoField.ALIGNED_WEEK_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.memorydata.plugin")).longValue()) - 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(ChronoField.DAY_OF_WEEK.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.memorydata.plugin")).longValue()))));
        if (r13 == ResolverStyle.STRICT) goto L139;
    L143:
        return r115;
    L139:
        if (r115.get(ChronoField.YEAR) == r114) goto L143;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L147:
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
        ChronoField r25 = ChronoField.YEAR;
        long r26 = r1.longValue();
    L37:
        updateResolveMap(r14, r25, r26);
        goto L47
    L39:
        if (r5.longValue() != 0) goto L42;
        r25 = ChronoField.YEAR;
        r26 = Jdk8Methods.safeSubtract(1, r1.longValue());
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
        return LocalDate.ofEpochDay(((Long) ZeusTransformUtils.preCheckCast(r14.remove(ChronoField.EPOCH_DAY), Long.class, "com.obric.memorydata.plugin")).longValue());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* synthetic */ ChronoLocalDate resolveDate(Map r3, ResolverStyle r4) {
        return resolveDate((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ZonedDateTime zonedDateTime(Instant r1, ZoneId r2) {
        return ZonedDateTime.ofInstant(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ZonedDateTime zonedDateTime(TemporalAccessor r2) {
        return ZonedDateTime.from((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r2, TemporalAccessor.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoZonedDateTime zonedDateTime(Instant r1, ZoneId r2) {
        return zonedDateTime(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* synthetic */ ChronoZonedDateTime zonedDateTime(TemporalAccessor r3) {
        return zonedDateTime((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin"));
    }
}
