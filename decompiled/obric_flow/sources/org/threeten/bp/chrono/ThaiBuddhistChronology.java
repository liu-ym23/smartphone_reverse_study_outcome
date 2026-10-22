package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class ThaiBuddhistChronology extends i implements Serializable {
    public static final ThaiBuddhistChronology INSTANCE = null;
    static final int YEARS_DIFFERENCE = 543;
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        INSTANCE = new ThaiBuddhistChronology();
        HashMap r5 = new HashMap();
        HashMap r10 = new HashMap();
        HashMap r11 = new HashMap();
        r5.put("en", new String[]{"BB", "BE"});
        r5.put("th", new String[]{"BB", "BE"});
        r10.put("en", new String[]{"B.B.", "B.E."});
        r10.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        r11.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        r11.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private ThaiBuddhistChronology() {
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
    public /* bridge */ /* synthetic */ b m1698dateNow() {
        return dateNow();
    }

    /* JADX INFO: renamed from: dateYearDay, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1701dateYearDay(int r5, int r10) {
        return dateYearDay(r5, r10);
    }

    @Override // org.threeten.bp.chrono.i
    public /* bridge */ /* synthetic */ j eraOf(int r5) {
        return eraOf(r5);
    }

    public List<j> eras() {
        return Arrays.asList(ThaiBuddhistEra.values());
    }

    @Override // org.threeten.bp.chrono.i
    public String getCalendarType() {
        return "buddhist";
    }

    @Override // org.threeten.bp.chrono.i
    public String getId() {
        return "ThaiBuddhist";
    }

    @Override // org.threeten.bp.chrono.i
    public boolean isLeapYear(long r5) {
        return IsoChronology.INSTANCE.isLeapYear(r5 - 543);
    }

    @Override // org.threeten.bp.chrono.i
    public c localDateTime(org.threeten.bp.temporal.d r5) {
        return super.localDateTime(r5);
    }

    public int prolepticYear(j r5, int r10) {
        if ((r5 instanceof ThaiBuddhistEra) == false) goto L10;
        if (r5 != ThaiBuddhistEra.BE) goto L8;
        return r10;
    L8:
        return 1 - r10;
    L10:
        throw new ClassCastException("Era must be BuddhistEra");
    }

    @Override // org.threeten.bp.chrono.i
    public ValueRange range(ChronoField r14) {
        int r13 = p.f21182a[r14.ordinal()];
        if (r13 != 1) goto L5;
        ValueRange r15 = ChronoField.PROLEPTIC_MONTH.range();
        return ValueRange.of(r15.getMinimum() + 6516, r15.getMaximum() + 6516);
    L5:
        if (r13 != 2) goto L7;
        ValueRange r16 = ChronoField.YEAR.range();
        return ValueRange.of(1, (-(r16.getMinimum() + 543)) + 1, r16.getMaximum() + 543);
    L7:
        if (r13 != 3) goto L9;
        ValueRange r17 = ChronoField.YEAR.range();
        return ValueRange.of(r17.getMinimum() + 543, r17.getMaximum() + 543);
    L9:
        return r14.range();
    }

    /* JADX INFO: renamed from: resolveDate, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1703resolveDate(Map r5, ResolverStyle r10) {
        return resolveDate(r5, r10);
    }

    @Override // org.threeten.bp.chrono.i
    public g zonedDateTime(org.threeten.bp.temporal.d r5) {
        return super.zonedDateTime(r5);
    }

    /* JADX INFO: renamed from: date, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1697date(j r5, int r10, int r11, int r12) {
        return date(r5, r10, r11, r12);
    }

    @Override // org.threeten.bp.chrono.i
    public ThaiBuddhistDate dateEpochDay(long r5) {
        return new ThaiBuddhistDate(LocalDate.ofEpochDay(r5));
    }

    /* JADX INFO: renamed from: dateNow, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1700dateNow(org.threeten.bp.a r5) {
        return dateNow(r5);
    }

    /* JADX INFO: renamed from: dateYearDay, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1702dateYearDay(j r5, int r10, int r11) {
        return dateYearDay(r5, r10, r11);
    }

    @Override // org.threeten.bp.chrono.i
    public ThaiBuddhistEra eraOf(int r5) {
        return ThaiBuddhistEra.of(r5);
    }

    public ThaiBuddhistDate resolveDate(Map<org.threeten.bp.temporal.g, Long> r11, ResolverStyle r12) {
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
        if (r11.containsKey(r17) == false) goto L131;
        ChronoField r18 = ChronoField.MONTH_OF_YEAR;
        if (r11.containsKey(r18) == false) goto L93;
        ChronoField r19 = ChronoField.DAY_OF_MONTH;
        if (r11.containsKey(r19) == false) goto L63;
        int r20 = r17.checkValidIntValue(r11.remove(r17).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L56;
        long r21 = jm.c.w(r11.remove(r18).longValue(), 1);
        return date(r20, 1, 1).plusMonths(r21).plusDays(jm.c.w(r11.remove(r19).longValue(), 1));
    L56:
        int r22 = range(r18).checkValidIntValue(r11.remove(r18).longValue(), r18);
        int r110 = range(r19).checkValidIntValue(r11.remove(r19).longValue(), r19);
        if (r12 != ResolverStyle.SMART) goto L62;
        if (r110 <= 28) goto L62;
        r110 = Math.min(r110, date(r20, r22, 1).lengthOfMonth());
    L62:
        return date(r20, r22, r110);
    L63:
        ChronoField r23 = ChronoField.ALIGNED_WEEK_OF_MONTH;
        if (r11.containsKey(r23) == false) goto L93;
        ChronoField r24 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
        if (r11.containsKey(r24) == false) goto L79;
        int r25 = r17.checkValidIntValue(r11.remove(r17).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L71;
        long r26 = jm.c.w(r11.remove(r18).longValue(), 1);
        long r27 = jm.c.w(r11.remove(r23).longValue(), 1);
        return date(r25, 1, 1).plus(r26, ChronoUnit.MONTHS).plus(r27, ChronoUnit.WEEKS).plus(jm.c.w(r11.remove(r24).longValue(), 1), ChronoUnit.DAYS);
    L71:
        int r28 = r18.checkValidIntValue(r11.remove(r18).longValue());
        int r29 = r23.checkValidIntValue(r11.remove(r23).longValue());
        ThaiBuddhistDate r111 = date(r25, r28, 1).plus((r24.checkValidIntValue(r11.remove(r24).longValue()) - 1) + ((r29 - 1) * 7), ChronoUnit.DAYS);
        if (r12 == ResolverStyle.STRICT) goto L74;
    L78:
        return r111;
    L74:
        if (r111.get(r18) == r28) goto L78;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L79:
        ChronoField r30 = ChronoField.DAY_OF_WEEK;
        if (r11.containsKey(r30) == false) goto L93;
        int r31 = r17.checkValidIntValue(r11.remove(r17).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L85;
        long r32 = jm.c.w(r11.remove(r18).longValue(), 1);
        long r33 = jm.c.w(r11.remove(r23).longValue(), 1);
        return date(r31, 1, 1).plus(r32, ChronoUnit.MONTHS).plus(r33, ChronoUnit.WEEKS).plus(jm.c.w(r11.remove(r30).longValue(), 1), ChronoUnit.DAYS);
    L85:
        int r34 = r18.checkValidIntValue(r11.remove(r18).longValue());
        ThaiBuddhistDate r112 = date(r31, r34, 1).plus(r23.checkValidIntValue(r11.remove(r23).longValue()) - 1, ChronoUnit.WEEKS).with(org.threeten.bp.temporal.h.a(DayOfWeek.of(r30.checkValidIntValue(r11.remove(r30).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L88;
    L92:
        return r112;
    L88:
        if (r112.get(r18) == r34) goto L92;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L93:
        ChronoField r35 = ChronoField.DAY_OF_YEAR;
        if (r11.containsKey(r35) == false) goto L101;
        int r36 = r17.checkValidIntValue(r11.remove(r17).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L100;
        return dateYearDay(r36, 1).plusDays(jm.c.w(r11.remove(r35).longValue(), 1));
    L100:
        return dateYearDay(r36, r35.checkValidIntValue(r11.remove(r35).longValue()));
    L101:
        ChronoField r37 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (r11.containsKey(r37) == false) goto L133;
        ChronoField r38 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (r11.containsKey(r38) == false) goto L117;
        int r39 = r17.checkValidIntValue(r11.remove(r17).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L109;
        long r40 = jm.c.w(r11.remove(r37).longValue(), 1);
        return date(r39, 1, 1).plus(r40, ChronoUnit.WEEKS).plus(jm.c.w(r11.remove(r38).longValue(), 1), ChronoUnit.DAYS);
    L109:
        int r41 = r37.checkValidIntValue(r11.remove(r37).longValue());
        ThaiBuddhistDate r113 = date(r39, 1, 1).plusDays((r38.checkValidIntValue(r11.remove(r38).longValue()) - 1) + ((r41 - 1) * 7));
        if (r12 == ResolverStyle.STRICT) goto L112;
    L116:
        return r113;
    L112:
        if (r113.get(r17) == r39) goto L116;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L117:
        ChronoField r42 = ChronoField.DAY_OF_WEEK;
        if (r11.containsKey(r42) == false) goto L134;
        int r43 = r17.checkValidIntValue(r11.remove(r17).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L123;
        long r44 = jm.c.w(r11.remove(r37).longValue(), 1);
        return date(r43, 1, 1).plus(r44, ChronoUnit.WEEKS).plus(jm.c.w(r11.remove(r42).longValue(), 1), ChronoUnit.DAYS);
    L123:
        ThaiBuddhistDate r114 = date(r43, 1, 1).plus(r37.checkValidIntValue(r11.remove(r37).longValue()) - 1, ChronoUnit.WEEKS).with(org.threeten.bp.temporal.h.a(DayOfWeek.of(r42.checkValidIntValue(r11.remove(r42).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L126;
    L130:
        return r114;
    L126:
        if (r114.get(r17) == r43) goto L130;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L134:
        return null;
    L133:
        return null;
    L131:
        return null;
    L15:
        if (r12 == ResolverStyle.LENIENT) goto L17;
        r14.checkValidValue(r15.longValue());
    L17:
        Long r45 = r11.remove(ChronoField.ERA);
        if (r45 != null) goto L36;
        ChronoField r46 = ChronoField.YEAR;
        Long r47 = r11.get(r46);
        if (r12 != ResolverStyle.STRICT) goto L28;
        if (r47 != null) goto L23;
        r11.put(r14, r15);
        goto L46
    L23:
        if (r47.longValue() <= 0) goto L25;
        long r48 = r15.longValue();
    L26:
        updateResolveMap(r11, r46, r48);
        goto L46
    L25:
        r48 = jm.c.w(1, r15.longValue());
        goto L26
    L28:
        if (r47 != null) goto L30;
    L33:
        long r49 = r15.longValue();
    L34:
        updateResolveMap(r11, r46, r49);
        goto L46
    L30:
        if (r47.longValue() > 0) goto L33;
        r49 = jm.c.w(1, r15.longValue());
        goto L34
    L36:
        if (r45.longValue() != 1) goto L39;
        updateResolveMap(r11, ChronoField.YEAR, r15.longValue());
        goto L46
    L39:
        if (r45.longValue() != 0) goto L42;
        updateResolveMap(r11, ChronoField.YEAR, jm.c.w(1, r15.longValue()));
        goto L46
    L42:
        throw new DateTimeException("Invalid value for era: " + r45);
    L9:
        if (r12 == ResolverStyle.LENIENT) goto L11;
        r10.checkValidValue(r13.longValue());
    L11:
        updateResolveMap(r11, ChronoField.MONTH_OF_YEAR, jm.c.n(12, r13.longValue()) + 1);
        updateResolveMap(r11, ChronoField.YEAR, jm.c.l(r13.longValue(), 12));
        goto L12
    L5:
        return dateEpochDay(r11.remove(r5).longValue());
    }

    @Override // org.threeten.bp.chrono.i
    public g zonedDateTime(Instant r5, ZoneId r10) {
        return ChronoZonedDateTimeImpl.ofInstant(this, r5, r10);
    }

    @Override // org.threeten.bp.chrono.i
    public /* bridge */ /* synthetic */ b date(org.threeten.bp.temporal.d r5) {
        return date(r5);
    }

    /* JADX INFO: renamed from: dateNow, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1699dateNow(ZoneId r5) {
        return dateNow(r5);
    }

    public ThaiBuddhistDate dateYearDay(int r5, int r10) {
        return new ThaiBuddhistDate(LocalDate.ofYearDay(r5 - 543, r10));
    }

    @Override // org.threeten.bp.chrono.i
    public ThaiBuddhistDate date(int r5, int r10, int r11) {
        return new ThaiBuddhistDate(LocalDate.of(r5 - 543, r10, r11));
    }

    public ThaiBuddhistDate dateNow(org.threeten.bp.a r5) {
        jm.c.p(r5, "clock");
        return (ThaiBuddhistDate) date(LocalDate.now(r5));
    }

    public ThaiBuddhistDate dateYearDay(j r5, int r10, int r11) {
        return (ThaiBuddhistDate) m1701dateYearDay(prolepticYear(r5, r10), r11);
    }

    @Override // org.threeten.bp.chrono.i
    public ThaiBuddhistDate date(org.threeten.bp.temporal.d r5) {
        if ((r5 instanceof ThaiBuddhistDate) == false) goto L7;
        return (ThaiBuddhistDate) r5;
    L7:
        return new ThaiBuddhistDate(LocalDate.from(r5));
    }

    public ThaiBuddhistDate dateNow() {
        return (ThaiBuddhistDate) m1700dateNow(org.threeten.bp.a.systemDefaultZone());
    }

    public ThaiBuddhistDate date(j r5, int r10, int r11, int r12) {
        return (ThaiBuddhistDate) date(prolepticYear(r5, r10), r11, r12);
    }

    public ThaiBuddhistDate dateNow(ZoneId r5) {
        return (ThaiBuddhistDate) m1700dateNow(org.threeten.bp.a.system(r5));
    }
}
