package org.threeten.bp.chrono;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class IsoChronology extends i implements Serializable {
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

    @Override // org.threeten.bp.chrono.i
    public /* bridge */ /* synthetic */ b date(int r5, int r10, int r11) {
        return date(r5, r10, r11);
    }

    @Override // org.threeten.bp.chrono.i
    public /* bridge */ /* synthetic */ b dateEpochDay(long r5) {
        return dateEpochDay(r5);
    }

    /* JADX INFO: renamed from: dateNow, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1677dateNow() {
        return dateNow();
    }

    /* JADX INFO: renamed from: dateYearDay, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1680dateYearDay(int r5, int r10) {
        return dateYearDay(r5, r10);
    }

    @Override // org.threeten.bp.chrono.i
    public /* bridge */ /* synthetic */ j eraOf(int r5) {
        return eraOf(r5);
    }

    public List<j> eras() {
        return Arrays.asList(IsoEra.values());
    }

    @Override // org.threeten.bp.chrono.i
    public String getCalendarType() {
        return "iso8601";
    }

    @Override // org.threeten.bp.chrono.i
    public String getId() {
        return ExifInterface.TAG_RW2_ISO;
    }

    @Override // org.threeten.bp.chrono.i
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

    @Override // org.threeten.bp.chrono.i
    public /* bridge */ /* synthetic */ c localDateTime(org.threeten.bp.temporal.d r5) {
        return localDateTime(r5);
    }

    public int prolepticYear(j r5, int r10) {
        if ((r5 instanceof IsoEra) == false) goto L10;
        if (r5 != IsoEra.CE) goto L8;
        return r10;
    L8:
        return 1 - r10;
    L10:
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // org.threeten.bp.chrono.i
    public ValueRange range(ChronoField r5) {
        return r5.range();
    }

    /* JADX INFO: renamed from: resolveDate, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1682resolveDate(Map r5, ResolverStyle r10) {
        return resolveDate(r5, r10);
    }

    @Override // org.threeten.bp.chrono.i
    public /* bridge */ /* synthetic */ g zonedDateTime(Instant r5, ZoneId r10) {
        return zonedDateTime(r5, r10);
    }

    /* JADX INFO: renamed from: date, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1676date(j r5, int r10, int r11, int r12) {
        return date(r5, r10, r11, r12);
    }

    @Override // org.threeten.bp.chrono.i
    public LocalDate dateEpochDay(long r5) {
        return LocalDate.ofEpochDay(r5);
    }

    /* JADX INFO: renamed from: dateNow, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1679dateNow(org.threeten.bp.a r5) {
        return dateNow(r5);
    }

    /* JADX INFO: renamed from: dateYearDay, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1681dateYearDay(j r5, int r10, int r11) {
        return dateYearDay(r5, r10, r11);
    }

    @Override // org.threeten.bp.chrono.i
    public IsoEra eraOf(int r5) {
        return IsoEra.of(r5);
    }

    @Override // org.threeten.bp.chrono.i
    public LocalDateTime localDateTime(org.threeten.bp.temporal.d r5) {
        return LocalDateTime.from(r5);
    }

    public LocalDate resolveDate(Map<org.threeten.bp.temporal.g, Long> r11, ResolverStyle r12) {
        ChronoField r5 = ChronoField.EPOCH_DAY;
        if (r11.containsKey(r5) == true) goto L5;
        ChronoField r10 = ChronoField.PROLEPTIC_MONTH;
        Long r13 = r11.remove(r10);
        if (r13 != null) goto L9;
    L12:
        ChronoField r14 = ChronoField.YEAR_OF_ERA;
        Long r15 = r11.remove(r14);
        if (r15 != null) goto L15;
        ChronoField r16 = ChronoField.ERA;
        if (r11.containsKey(r16) == false) goto L46;
        r16.checkValidValue(r11.get(r16).longValue());
    L46:
        ChronoField r17 = ChronoField.YEAR;
        if (r11.containsKey(r17) == false) goto L143;
        ChronoField r18 = ChronoField.MONTH_OF_YEAR;
        if (r11.containsKey(r18) == false) goto L105;
        ChronoField r19 = ChronoField.DAY_OF_MONTH;
        if (r11.containsKey(r19) == false) goto L75;
        int r110 = r17.checkValidIntValue(r11.remove(r17).longValue());
        int r20 = jm.c.x(r11.remove(r18).longValue());
        int r111 = jm.c.x(r11.remove(r19).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L57;
        long r21 = jm.c.v(r20, 1);
        return LocalDate.of(r110, 1, 1).plusMonths(r21).plusDays(jm.c.v(r111, 1));
    L57:
        if (r12 != ResolverStyle.SMART) goto L74;
        r19.checkValidValue(r111);
        if (r20 != 4) goto L61;
    L70:
        r111 = Math.min(r111, 30);
    L72:
        return LocalDate.of(r110, r20, r111);
    L61:
        if (r20 == 6) goto L70;
        if (r20 == 9) goto L70;
        if (r20 == 11) goto L70;
        if (r20 != 2) goto L72;
        r111 = Math.min(r111, Month.FEBRUARY.length(Year.isLeap(r110)));
        goto L72
    L74:
        return LocalDate.of(r110, r20, r111);
    L75:
        ChronoField r22 = ChronoField.ALIGNED_WEEK_OF_MONTH;
        if (r11.containsKey(r22) == false) goto L105;
        ChronoField r23 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
        if (r11.containsKey(r23) == false) goto L91;
        int r112 = r17.checkValidIntValue(r11.remove(r17).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L83;
        long r24 = jm.c.w(r11.remove(r18).longValue(), 1);
        long r25 = jm.c.w(r11.remove(r22).longValue(), 1);
        return LocalDate.of(r112, 1, 1).plusMonths(r24).plusWeeks(r25).plusDays(jm.c.w(r11.remove(r23).longValue(), 1));
    L83:
        int r26 = r18.checkValidIntValue(r11.remove(r18).longValue());
        int r27 = r22.checkValidIntValue(r11.remove(r22).longValue());
        LocalDate r113 = LocalDate.of(r112, r26, 1).plusDays((r23.checkValidIntValue(r11.remove(r23).longValue()) - 1) + ((r27 - 1) * 7));
        if (r12 == ResolverStyle.STRICT) goto L86;
    L90:
        return r113;
    L86:
        if (r113.get(r18) == r26) goto L90;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L91:
        ChronoField r28 = ChronoField.DAY_OF_WEEK;
        if (r11.containsKey(r28) == false) goto L105;
        int r114 = r17.checkValidIntValue(r11.remove(r17).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L97;
        long r29 = jm.c.w(r11.remove(r18).longValue(), 1);
        long r30 = jm.c.w(r11.remove(r22).longValue(), 1);
        return LocalDate.of(r114, 1, 1).plusMonths(r29).plusWeeks(r30).plusDays(jm.c.w(r11.remove(r28).longValue(), 1));
    L97:
        int r31 = r18.checkValidIntValue(r11.remove(r18).longValue());
        LocalDate r115 = LocalDate.of(r114, r31, 1).plusWeeks(r22.checkValidIntValue(r11.remove(r22).longValue()) - 1).with(org.threeten.bp.temporal.h.a(DayOfWeek.of(r28.checkValidIntValue(r11.remove(r28).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L100;
    L104:
        return r115;
    L100:
        if (r115.get(r18) == r31) goto L104;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L105:
        ChronoField r32 = ChronoField.DAY_OF_YEAR;
        if (r11.containsKey(r32) == false) goto L113;
        int r116 = r17.checkValidIntValue(r11.remove(r17).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L112;
        return LocalDate.ofYearDay(r116, 1).plusDays(jm.c.w(r11.remove(r32).longValue(), 1));
    L112:
        return LocalDate.ofYearDay(r116, r32.checkValidIntValue(r11.remove(r32).longValue()));
    L113:
        ChronoField r33 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (r11.containsKey(r33) == false) goto L145;
        ChronoField r34 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (r11.containsKey(r34) == false) goto L129;
        int r35 = r17.checkValidIntValue(r11.remove(r17).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L121;
        long r36 = jm.c.w(r11.remove(r33).longValue(), 1);
        return LocalDate.of(r35, 1, 1).plusWeeks(r36).plusDays(jm.c.w(r11.remove(r34).longValue(), 1));
    L121:
        int r37 = r33.checkValidIntValue(r11.remove(r33).longValue());
        LocalDate r117 = LocalDate.of(r35, 1, 1).plusDays((r34.checkValidIntValue(r11.remove(r34).longValue()) - 1) + ((r37 - 1) * 7));
        if (r12 == ResolverStyle.STRICT) goto L124;
    L128:
        return r117;
    L124:
        if (r117.get(r17) == r35) goto L128;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L129:
        ChronoField r38 = ChronoField.DAY_OF_WEEK;
        if (r11.containsKey(r38) == false) goto L146;
        int r39 = r17.checkValidIntValue(r11.remove(r17).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L135;
        long r40 = jm.c.w(r11.remove(r33).longValue(), 1);
        return LocalDate.of(r39, 1, 1).plusWeeks(r40).plusDays(jm.c.w(r11.remove(r38).longValue(), 1));
    L135:
        LocalDate r118 = LocalDate.of(r39, 1, 1).plusWeeks(r33.checkValidIntValue(r11.remove(r33).longValue()) - 1).with(org.threeten.bp.temporal.h.a(DayOfWeek.of(r38.checkValidIntValue(r11.remove(r38).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L138;
    L142:
        return r118;
    L138:
        if (r118.get(r17) == r39) goto L142;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L146:
        return null;
    L145:
        return null;
    L143:
        return null;
    L15:
        if (r12 == ResolverStyle.LENIENT) goto L17;
        r14.checkValidValue(r15.longValue());
    L17:
        Long r41 = r11.remove(ChronoField.ERA);
        if (r41 != null) goto L36;
        ChronoField r42 = ChronoField.YEAR;
        Long r43 = r11.get(r42);
        if (r12 != ResolverStyle.STRICT) goto L28;
        if (r43 != null) goto L23;
        r11.put(r14, r15);
        goto L46
    L23:
        if (r43.longValue() <= 0) goto L25;
        long r44 = r15.longValue();
    L26:
        updateResolveMap(r11, r42, r44);
        goto L46
    L25:
        r44 = jm.c.w(1, r15.longValue());
        goto L26
    L28:
        if (r43 != null) goto L30;
    L33:
        long r45 = r15.longValue();
    L34:
        updateResolveMap(r11, r42, r45);
        goto L46
    L30:
        if (r43.longValue() > 0) goto L33;
        r45 = jm.c.w(1, r15.longValue());
        goto L34
    L36:
        if (r41.longValue() != 1) goto L39;
        updateResolveMap(r11, ChronoField.YEAR, r15.longValue());
        goto L46
    L39:
        if (r41.longValue() != 0) goto L42;
        updateResolveMap(r11, ChronoField.YEAR, jm.c.w(1, r15.longValue()));
        goto L46
    L42:
        throw new DateTimeException("Invalid value for era: " + r41);
    L9:
        if (r12 == ResolverStyle.LENIENT) goto L11;
        r10.checkValidValue(r13.longValue());
    L11:
        updateResolveMap(r11, ChronoField.MONTH_OF_YEAR, jm.c.n(12, r13.longValue()) + 1);
        updateResolveMap(r11, ChronoField.YEAR, jm.c.l(r13.longValue(), 12));
        goto L12
    L5:
        return LocalDate.ofEpochDay(r11.remove(r5).longValue());
    }

    @Override // org.threeten.bp.chrono.i
    public /* bridge */ /* synthetic */ g zonedDateTime(org.threeten.bp.temporal.d r5) {
        return zonedDateTime(r5);
    }

    @Override // org.threeten.bp.chrono.i
    public /* bridge */ /* synthetic */ b date(org.threeten.bp.temporal.d r5) {
        return date(r5);
    }

    /* JADX INFO: renamed from: dateNow, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1678dateNow(ZoneId r5) {
        return dateNow(r5);
    }

    public LocalDate dateYearDay(j r5, int r10, int r11) {
        return dateYearDay(prolepticYear(r5, r10), r11);
    }

    @Override // org.threeten.bp.chrono.i
    public ZonedDateTime zonedDateTime(org.threeten.bp.temporal.d r5) {
        return ZonedDateTime.from(r5);
    }

    public LocalDate date(j r5, int r10, int r11, int r12) {
        return date(prolepticYear(r5, r10), r11, r12);
    }

    public LocalDate dateNow() {
        return dateNow(org.threeten.bp.a.systemDefaultZone());
    }

    public LocalDate dateYearDay(int r5, int r10) {
        return LocalDate.ofYearDay(r5, r10);
    }

    @Override // org.threeten.bp.chrono.i
    public ZonedDateTime zonedDateTime(Instant r5, ZoneId r10) {
        return ZonedDateTime.ofInstant(r5, r10);
    }

    @Override // org.threeten.bp.chrono.i
    public LocalDate date(int r5, int r10, int r11) {
        return LocalDate.of(r5, r10, r11);
    }

    public LocalDate dateNow(ZoneId r5) {
        return dateNow(org.threeten.bp.a.system(r5));
    }

    @Override // org.threeten.bp.chrono.i
    public LocalDate date(org.threeten.bp.temporal.d r5) {
        return LocalDate.from(r5);
    }

    public LocalDate dateNow(org.threeten.bp.a r5) {
        jm.c.p(r5, "clock");
        return date(LocalDate.now(r5));
    }
}
