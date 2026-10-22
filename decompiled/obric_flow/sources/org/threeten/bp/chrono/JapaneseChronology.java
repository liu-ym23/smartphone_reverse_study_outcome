package org.threeten.bp.chrono;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
public final class JapaneseChronology extends i implements Serializable {
    public static final JapaneseChronology INSTANCE = null;
    static final Locale LOCALE = null;
    private static final long serialVersionUID = 459996390165777884L;

    static {
        LOCALE = new Locale("ja", "JP", "JP");
        INSTANCE = new JapaneseChronology();
        HashMap r5 = new HashMap();
        HashMap r10 = new HashMap();
        HashMap r11 = new HashMap();
        r5.put("en", new String[]{"Unknown", "K", "M", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "H"});
        r5.put("ja", new String[]{"Unknown", "K", "M", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "H"});
        r10.put("en", new String[]{"Unknown", "K", "M", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "H"});
        r10.put("ja", new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        r11.put("en", new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        r11.put("ja", new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private JapaneseChronology() {
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
    public /* bridge */ /* synthetic */ b m1684dateNow() {
        return dateNow();
    }

    /* JADX INFO: renamed from: dateYearDay, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1687dateYearDay(int r5, int r10) {
        return dateYearDay(r5, r10);
    }

    @Override // org.threeten.bp.chrono.i
    public /* bridge */ /* synthetic */ j eraOf(int r5) {
        return eraOf(r5);
    }

    public List<j> eras() {
        return Arrays.asList(JapaneseEra.values());
    }

    @Override // org.threeten.bp.chrono.i
    public String getCalendarType() {
        return "japanese";
    }

    @Override // org.threeten.bp.chrono.i
    public String getId() {
        return "Japanese";
    }

    @Override // org.threeten.bp.chrono.i
    public boolean isLeapYear(long r5) {
        return IsoChronology.INSTANCE.isLeapYear(r5);
    }

    @Override // org.threeten.bp.chrono.i
    public c localDateTime(org.threeten.bp.temporal.d r5) {
        return super.localDateTime(r5);
    }

    public int prolepticYear(j r5, int r10) {
        if ((r5 instanceof JapaneseEra) == false) goto L7;
        JapaneseEra r11 = (JapaneseEra) r5;
        int r12 = (r11.startDate().getYear() + r10) - 1;
        ValueRange.of(1, (r11.endDate().getYear() - r11.startDate().getYear()) + 1).checkValidValue(r10, ChronoField.YEAR_OF_ERA);
        return r12;
    L7:
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // org.threeten.bp.chrono.i
    public ValueRange range(ChronoField r11) {
        int[] r10 = l.f21178a;
        switch(r10[r11.ordinal()]) {
            case 1: goto L27;
            case 2: goto L27;
            case 3: goto L27;
            case 4: goto L27;
            case 5: goto L27;
            case 6: goto L27;
            case 7: goto L27;
            case 8: goto L27;
            case 9: goto L27;
            case 10: goto L27;
            case 11: goto L27;
            case 12: goto L27;
            case 13: goto L27;
            case 14: goto L27;
            case 15: goto L27;
            case 16: goto L27;
            case 17: goto L27;
            case 18: goto L27;
            default: goto L4;
        };
    L4:
        Calendar r5 = Calendar.getInstance(LOCALE);
        int r12 = 0;
        switch(r10[r11.ordinal()]) {
            case 19: goto L24;
            case 20: goto L22;
            case 21: goto L16;
            case 22: goto L15;
            case 23: goto L8;
            default: goto L7;
        };
    L8:
        JapaneseEra[] r13 = JapaneseEra.values();
        int r14 = 366;
    L10:
        if (r12 >= r13.length) goto L13;
        r14 = Math.min(r14, (r13[r12].startDate().lengthOfYear() - r13[r12].startDate().getDayOfYear()) + 1);
        r12 = r12 + 1;
        goto L10
    L13:
        return ValueRange.of(1, r14, 366);
    L16:
        JapaneseEra[] r15 = JapaneseEra.values();
        int r16 = (r15[r15.length - 1].endDate().getYear() - r15[r15.length - 1].startDate().getYear()) + 1;
        int r17 = Integer.MAX_VALUE;
    L18:
        if (r12 >= r15.length) goto L21;
        r17 = Math.min(r17, (r15[r12].endDate().getYear() - r15[r12].startDate().getYear()) + 1);
        r12 = r12 + 1;
        goto L18
    L21:
        return ValueRange.of(1, 6, r17, r16);
    L22:
        JapaneseEra[] r18 = JapaneseEra.values();
        return ValueRange.of(JapaneseDate.MIN_DATE.getYear(), r18[r18.length - 1].endDate().getYear());
    L24:
        JapaneseEra[] r19 = JapaneseEra.values();
        return ValueRange.of(r19[0].getValue(), r19[r19.length - 1].getValue());
    L7:
        throw new UnsupportedOperationException("Unimplementable field: " + r11);
    L15:
        return ValueRange.of(r5.getMinimum(2) + 1, r5.getGreatestMinimum(2) + 1, r5.getLeastMaximum(2) + 1, r5.getMaximum(2) + 1);
    L27:
        return r11.range();
    }

    /* JADX INFO: renamed from: resolveDate, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1689resolveDate(Map r5, ResolverStyle r10) {
        return resolveDate(r5, r10);
    }

    @Override // org.threeten.bp.chrono.i
    public g zonedDateTime(org.threeten.bp.temporal.d r5) {
        return super.zonedDateTime(r5);
    }

    /* JADX INFO: renamed from: date, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1683date(j r5, int r10, int r11, int r12) {
        return date(r5, r10, r11, r12);
    }

    @Override // org.threeten.bp.chrono.i
    public JapaneseDate dateEpochDay(long r5) {
        return new JapaneseDate(LocalDate.ofEpochDay(r5));
    }

    /* JADX INFO: renamed from: dateNow, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1686dateNow(org.threeten.bp.a r5) {
        return dateNow(r5);
    }

    /* JADX INFO: renamed from: dateYearDay, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ b m1688dateYearDay(j r5, int r10, int r11) {
        return dateYearDay(r5, r10, r11);
    }

    @Override // org.threeten.bp.chrono.i
    public JapaneseEra eraOf(int r5) {
        return JapaneseEra.of(r5);
    }

    public JapaneseDate resolveDate(Map<org.threeten.bp.temporal.g, Long> r13, ResolverStyle r14) {
        ChronoField r5 = ChronoField.EPOCH_DAY;
        if (r13.containsKey(r5) == true) goto L5;
        ChronoField r10 = ChronoField.PROLEPTIC_MONTH;
        Long r11 = r13.remove(r10);
        if (r11 != null) goto L9;
    L12:
        ChronoField r12 = ChronoField.ERA;
        Long r15 = r13.get(r12);
        if (r15 == null) goto L15;
        JapaneseEra r16 = eraOf(range(r12).checkValidIntValue(r15.longValue(), r12));
    L16:
        ChronoField r17 = ChronoField.YEAR_OF_ERA;
        Long r18 = r13.get(r17);
        if (r18 == null) goto L63;
        int r19 = range(r17).checkValidIntValue(r18.longValue(), r17);
        if (r16 == null) goto L21;
    L25:
        if (r16 == null) goto L55;
        ChronoField r20 = ChronoField.MONTH_OF_YEAR;
        if (r13.containsKey(r20) == false) goto L55;
        ChronoField r110 = ChronoField.DAY_OF_MONTH;
        if (r13.containsKey(r110) == false) goto L55;
        r13.remove(r12);
        r13.remove(r17);
        if (r14 != ResolverStyle.LENIENT) goto L33;
        int r111 = (r16.startDate().getYear() + r19) - 1;
        long r21 = jm.c.w(r13.remove(r20).longValue(), 1);
        return date(r111, 1, 1).plus(r21, ChronoUnit.MONTHS).plus(jm.c.w(r13.remove(r110).longValue(), 1), ChronoUnit.DAYS);
    L33:
        int r22 = range(r20).checkValidIntValue(r13.remove(r20).longValue(), r20);
        int r112 = range(r110).checkValidIntValue(r13.remove(r110).longValue(), r110);
        if (r14 != ResolverStyle.SMART) goto L54;
        if (r19 < 1) goto L52;
        int r113 = (r16.startDate().getYear() + r19) - 1;
        if (r112 <= 28) goto L39;
        r112 = Math.min(r112, date(r113, r22, 1).lengthOfMonth());
    L39:
        JapaneseDate r114 = date(r113, r22, r112);
        if (r114.getEra() != r16) goto L42;
        return r114;
    L42:
        if (Math.abs(r114.getEra().getValue() - r16.getValue()) > 1) goto L50;
        if (r114.get(r17) == 1) goto L150;
        if (r19 != 1) goto L48;
        return r114;
    L48:
        throw new DateTimeException("Invalid Era/YearOfEra: " + r16 + " " + r19);
    L150:
        return r114;
    L50:
        throw new DateTimeException("Invalid Era/YearOfEra: " + r16 + " " + r19);
    L52:
        throw new DateTimeException(j0.g(r19, "Invalid YearOfEra: "));
    L54:
        return date(r16, r19, r22, r112);
    L55:
        if (r16 == null) goto L63;
        ChronoField r23 = ChronoField.DAY_OF_YEAR;
        if (r13.containsKey(r23) == false) goto L63;
        r13.remove(r12);
        r13.remove(r17);
        if (r14 != ResolverStyle.LENIENT) goto L62;
        int r115 = (r16.startDate().getYear() + r19) - 1;
        return dateYearDay(r115, 1).plus(jm.c.w(r13.remove(r23).longValue(), 1), ChronoUnit.DAYS);
    L62:
        return dateYearDay(r16, r19, range(r23).checkValidIntValue(r13.remove(r23).longValue(), r23));
    L21:
        if (r14 == ResolverStyle.STRICT) goto L25;
        if (r13.containsKey(ChronoField.YEAR) == true) goto L25;
        r16 = (JapaneseEra) j0.e(eras(), 1);
    L63:
        ChronoField r24 = ChronoField.YEAR;
        if (r13.containsKey(r24) == false) goto L147;
        ChronoField r25 = ChronoField.MONTH_OF_YEAR;
        if (r13.containsKey(r25) == false) goto L109;
        ChronoField r26 = ChronoField.DAY_OF_MONTH;
        if (r13.containsKey(r26) == false) goto L79;
        int r27 = r24.checkValidIntValue(r13.remove(r24).longValue());
        if (r14 != ResolverStyle.LENIENT) goto L73;
        long r28 = jm.c.w(r13.remove(r25).longValue(), 1);
        return date(r27, 1, 1).plusMonths(r28).plusDays(jm.c.w(r13.remove(r26).longValue(), 1));
    L73:
        int r29 = range(r25).checkValidIntValue(r13.remove(r25).longValue(), r25);
        int r116 = range(r26).checkValidIntValue(r13.remove(r26).longValue(), r26);
        if (r14 != ResolverStyle.SMART) goto L78;
        if (r116 <= 28) goto L78;
        r116 = Math.min(r116, date(r27, r29, 1).lengthOfMonth());
    L78:
        return date(r27, r29, r116);
    L79:
        ChronoField r30 = ChronoField.ALIGNED_WEEK_OF_MONTH;
        if (r13.containsKey(r30) == false) goto L109;
        ChronoField r31 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
        if (r13.containsKey(r31) == false) goto L95;
        int r32 = r24.checkValidIntValue(r13.remove(r24).longValue());
        if (r14 != ResolverStyle.LENIENT) goto L87;
        long r33 = jm.c.w(r13.remove(r25).longValue(), 1);
        long r34 = jm.c.w(r13.remove(r30).longValue(), 1);
        return date(r32, 1, 1).plus(r33, ChronoUnit.MONTHS).plus(r34, ChronoUnit.WEEKS).plus(jm.c.w(r13.remove(r31).longValue(), 1), ChronoUnit.DAYS);
    L87:
        int r35 = r25.checkValidIntValue(r13.remove(r25).longValue());
        int r36 = r30.checkValidIntValue(r13.remove(r30).longValue());
        JapaneseDate r117 = date(r32, r35, 1).plus((r31.checkValidIntValue(r13.remove(r31).longValue()) - 1) + ((r36 - 1) * 7), ChronoUnit.DAYS);
        if (r14 == ResolverStyle.STRICT) goto L90;
    L94:
        return r117;
    L90:
        if (r117.get(r25) == r35) goto L94;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L95:
        ChronoField r37 = ChronoField.DAY_OF_WEEK;
        if (r13.containsKey(r37) == false) goto L109;
        int r38 = r24.checkValidIntValue(r13.remove(r24).longValue());
        if (r14 != ResolverStyle.LENIENT) goto L101;
        long r39 = jm.c.w(r13.remove(r25).longValue(), 1);
        long r40 = jm.c.w(r13.remove(r30).longValue(), 1);
        return date(r38, 1, 1).plus(r39, ChronoUnit.MONTHS).plus(r40, ChronoUnit.WEEKS).plus(jm.c.w(r13.remove(r37).longValue(), 1), ChronoUnit.DAYS);
    L101:
        int r41 = r25.checkValidIntValue(r13.remove(r25).longValue());
        JapaneseDate r118 = date(r38, r41, 1).plus(r30.checkValidIntValue(r13.remove(r30).longValue()) - 1, ChronoUnit.WEEKS).with(org.threeten.bp.temporal.h.a(DayOfWeek.of(r37.checkValidIntValue(r13.remove(r37).longValue()))));
        if (r14 == ResolverStyle.STRICT) goto L104;
    L108:
        return r118;
    L104:
        if (r118.get(r25) == r41) goto L108;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L109:
        ChronoField r42 = ChronoField.DAY_OF_YEAR;
        if (r13.containsKey(r42) == false) goto L117;
        int r43 = r24.checkValidIntValue(r13.remove(r24).longValue());
        if (r14 != ResolverStyle.LENIENT) goto L116;
        return dateYearDay(r43, 1).plusDays(jm.c.w(r13.remove(r42).longValue(), 1));
    L116:
        return dateYearDay(r43, r42.checkValidIntValue(r13.remove(r42).longValue()));
    L117:
        ChronoField r44 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (r13.containsKey(r44) == false) goto L147;
        ChronoField r45 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (r13.containsKey(r45) == false) goto L133;
        int r46 = r24.checkValidIntValue(r13.remove(r24).longValue());
        if (r14 != ResolverStyle.LENIENT) goto L125;
        long r47 = jm.c.w(r13.remove(r44).longValue(), 1);
        return date(r46, 1, 1).plus(r47, ChronoUnit.WEEKS).plus(jm.c.w(r13.remove(r45).longValue(), 1), ChronoUnit.DAYS);
    L125:
        int r48 = r44.checkValidIntValue(r13.remove(r44).longValue());
        JapaneseDate r119 = date(r46, 1, 1).plusDays((r45.checkValidIntValue(r13.remove(r45).longValue()) - 1) + ((r48 - 1) * 7));
        if (r14 == ResolverStyle.STRICT) goto L128;
    L132:
        return r119;
    L128:
        if (r119.get(r24) == r46) goto L132;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L133:
        ChronoField r49 = ChronoField.DAY_OF_WEEK;
        if (r13.containsKey(r49) == false) goto L147;
        int r50 = r24.checkValidIntValue(r13.remove(r24).longValue());
        if (r14 != ResolverStyle.LENIENT) goto L139;
        long r51 = jm.c.w(r13.remove(r44).longValue(), 1);
        return date(r50, 1, 1).plus(r51, ChronoUnit.WEEKS).plus(jm.c.w(r13.remove(r49).longValue(), 1), ChronoUnit.DAYS);
    L139:
        JapaneseDate r120 = date(r50, 1, 1).plus(r44.checkValidIntValue(r13.remove(r44).longValue()) - 1, ChronoUnit.WEEKS).with(org.threeten.bp.temporal.h.a(DayOfWeek.of(r49.checkValidIntValue(r13.remove(r49).longValue()))));
        if (r14 == ResolverStyle.STRICT) goto L142;
    L146:
        return r120;
    L142:
        if (r120.get(r24) == r50) goto L146;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L147:
        return null;
    L15:
        r16 = null;
        goto L16
    L9:
        if (r14 == ResolverStyle.LENIENT) goto L11;
        r10.checkValidValue(r11.longValue());
    L11:
        updateResolveMap(r13, ChronoField.MONTH_OF_YEAR, jm.c.n(12, r11.longValue()) + 1);
        updateResolveMap(r13, ChronoField.YEAR, jm.c.l(r11.longValue(), 12));
        goto L12
    L5:
        return dateEpochDay(r13.remove(r5).longValue());
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
    public /* bridge */ /* synthetic */ b m1685dateNow(ZoneId r5) {
        return dateNow(r5);
    }

    public JapaneseDate dateYearDay(j r5, int r10, int r11) {
        if ((r5 instanceof JapaneseEra) == false) goto L7;
        return JapaneseDate.ofYearDay((JapaneseEra) r5, r10, r11);
    L7:
        throw new ClassCastException("Era must be JapaneseEra");
    }

    public JapaneseDate date(j r5, int r10, int r11, int r12) {
        if ((r5 instanceof JapaneseEra) == false) goto L7;
        return JapaneseDate.of((JapaneseEra) r5, r10, r11, r12);
    L7:
        throw new ClassCastException("Era must be JapaneseEra");
    }

    public JapaneseDate dateNow(org.threeten.bp.a r5) {
        jm.c.p(r5, "clock");
        return (JapaneseDate) date(LocalDate.now(r5));
    }

    public JapaneseDate dateYearDay(int r5, int r10) {
        LocalDate r11 = LocalDate.ofYearDay(r5, r10);
        return date(r5, r11.getMonthValue(), r11.getDayOfMonth());
    }

    @Override // org.threeten.bp.chrono.i
    public JapaneseDate date(int r5, int r10, int r11) {
        return new JapaneseDate(LocalDate.of(r5, r10, r11));
    }

    public JapaneseDate dateNow() {
        return (JapaneseDate) m1686dateNow(org.threeten.bp.a.systemDefaultZone());
    }

    @Override // org.threeten.bp.chrono.i
    public JapaneseDate date(org.threeten.bp.temporal.d r5) {
        if ((r5 instanceof JapaneseDate) == false) goto L7;
        return (JapaneseDate) r5;
    L7:
        return new JapaneseDate(LocalDate.from(r5));
    }

    public JapaneseDate dateNow(ZoneId r5) {
        return (JapaneseDate) m1686dateNow(org.threeten.bp.a.system(r5));
    }
}
