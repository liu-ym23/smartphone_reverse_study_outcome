package org.threeten.bp.temporal;

import java.util.HashMap;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Year;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements g {
    public static final ValueRange f = null;
    public static final ValueRange g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ValueRange f21289h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ValueRange f21290i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ValueRange f21291j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeekFields f21293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Enum f21294c;
    public final Enum d;
    public final ValueRange e;

    static {
        f = ValueRange.of(1, 7);
        g = ValueRange.of(0, 1, 4, 6);
        f21289h = ValueRange.of(0, 1, 52, 54);
        f21290i = ValueRange.of(1, 52, 53);
        f21291j = ChronoField.YEAR.range();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(String r5, WeekFields r10, j r11, j r12, ValueRange r13) {
        this.f21292a = r5;
        this.f21293b = r10;
        this.f21294c = (Enum) r11;
        this.d = (Enum) r12;
        this.e = r13;
    }

    public static int a(int r5, int r10) {
        return ((r10 - 1) + (r5 + 7)) / 7;
    }

    public static int b(org.threeten.bp.chrono.b r5, int r10) {
        return jm.c.m(r5.get(ChronoField.DAY_OF_WEEK) - r10) + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, org.threeten.bp.temporal.j] */
    @Override // org.threeten.bp.temporal.g
    public final c adjustInto(c r10, long r11) {
        int r5 = this.e.checkValidIntValue(r11, this);
        int r12 = r10.get(this);
        if (r5 != r12) goto L6;
        return r10;
    L6:
        if (this.d != ChronoUnit.FOREVER) goto L19;
        WeekFields r13 = this.f21293b;
        int r14 = r10.get(WeekFields.access$000(r13));
        long r15 = (long) ((r11 - ((long) r12)) * 52.1775d);
        ChronoUnit r16 = ChronoUnit.WEEKS;
        c r17 = r10.plus(r15, r16);
        if (r17.get(this) <= r5) goto L11;
        return r17.minus(r17.get(WeekFields.access$000(r13)), r16);
    L11:
        if (r17.get(this) >= r5) goto L13;
        r17 = r17.plus(2, r16);
    L13:
        c r18 = r17.plus(r14 - r17.get(WeekFields.access$000(r13)), r16);
        if (r18.get(this) <= r5) goto L17;
        return r18.minus(1, r16);
    L17:
        return r18;
    L19:
        return r10.plus(r5 - r12, this.f21294c);
    }

    public final long c(d r5, int r10) {
        int r11 = r5.get(ChronoField.DAY_OF_YEAR);
        return a(e(r11, r10), r11);
    }

    public final ValueRange d(d r10) {
        WeekFields r5 = this.f21293b;
        int r11 = jm.c.m(r10.get(ChronoField.DAY_OF_WEEK) - r5.getFirstDayOfWeek().getValue()) + 1;
        long r12 = c(r10, r11);
        if (r12 == 0) goto L5;
        int r13 = e(r10.get(ChronoField.DAY_OF_YEAR), r11);
        if (Year.isLeap(r10.get(ChronoField.YEAR)) == false) goto L9;
        int r14 = 366;
    L10:
        int r15 = a(r13, r5.getMinimalDaysInFirstWeek() + r14);
        if (r12 < r15) goto L15;
        return d(org.threeten.bp.chrono.i.from(r10).date(r10).plus(2, ChronoUnit.WEEKS));
    L15:
        return ValueRange.of(1, r15 - 1);
    L9:
        r14 = 365;
        goto L10
    L5:
        return d(org.threeten.bp.chrono.i.from(r10).date(r10).minus(2, ChronoUnit.WEEKS));
    }

    public final int e(int r5, int r10) {
        int r11 = jm.c.m(r5 - r10);
        int r12 = -r11;
        if ((r11 + 1) > this.f21293b.getMinimalDaysInFirstWeek()) goto L5;
        return r12;
    L5:
        return 7 - r11;
    }

    @Override // org.threeten.bp.temporal.g
    public final long getFrom(d r14) {
        WeekFields r5 = this.f21293b;
        int r10 = r5.getFirstDayOfWeek().getValue();
        ChronoField r11 = ChronoField.DAY_OF_WEEK;
        int r12 = jm.c.m(r14.get(r11) - r10) + 1;
        ChronoUnit r13 = ChronoUnit.WEEKS;
        Enum r15 = this.d;
        if (r15 != r13) goto L7;
        return r12;
    L7:
        if (r15 != ChronoUnit.MONTHS) goto L12;
        int r16 = r14.get(ChronoField.DAY_OF_MONTH);
        int r17 = a(e(r16, r12), r16);
    L10:
        return r17;
    L12:
        if (r15 != ChronoUnit.YEARS) goto L14;
        int r18 = r14.get(ChronoField.DAY_OF_YEAR);
        r17 = a(e(r18, r12), r18);
        goto L10
    L14:
        int r19 = 365;
        if (r15 != b.d) goto L31;
        int r20 = jm.c.m(r14.get(r11) - r5.getFirstDayOfWeek().getValue()) + 1;
        long r110 = c(r14, r20);
        if (r110 != 0) goto L20;
        int r111 = ((int) c(org.threeten.bp.chrono.i.from(r14).date(r14).minus(1, r13), r20)) + 1;
    L29:
        return r111;
    L20:
        if (r110 < 53) goto L27;
        int r112 = e(r14.get(ChronoField.DAY_OF_YEAR), r20);
        if (Year.isLeap(r14.get(ChronoField.YEAR)) == false) goto L24;
        r19 = 366;
    L24:
        int r113 = a(r112, r5.getMinimalDaysInFirstWeek() + r19);
        if (r110 < r113) goto L27;
        r110 = r110 - ((long) (r113 - 1));
    L27:
        r111 = (int) r110;
        goto L29
    L31:
        if (r15 != ChronoUnit.FOREVER) goto L47;
        int r21 = jm.c.m(r14.get(r11) - r5.getFirstDayOfWeek().getValue()) + 1;
        int r22 = r14.get(ChronoField.YEAR);
        long r23 = c(r14, r21);
        if (r23 != 0) goto L36;
        r22 = r22 - 1;
    L45:
        return r22;
    L36:
        if (r23 < 53) goto L45;
        int r114 = e(r14.get(ChronoField.DAY_OF_YEAR), r21);
        if (Year.isLeap(r22) == false) goto L42;
        r19 = 366;
    L42:
        if (r23 < a(r114, r5.getMinimalDaysInFirstWeek() + r19)) goto L45;
        r22 = r22 + 1;
        goto L45
    L47:
        throw new IllegalStateException("unreachable");
    }

    @Override // org.threeten.bp.temporal.g
    public final boolean isDateBased() {
        return true;
    }

    @Override // org.threeten.bp.temporal.g
    public final boolean isSupportedBy(d r5) {
        if (r5.isSupported(ChronoField.DAY_OF_WEEK) == false) goto L24;
        ChronoUnit r10 = ChronoUnit.WEEKS;
        Enum r11 = this.d;
        if (r11 != r10) goto L9;
        return true;
    L9:
        if (r11 != ChronoUnit.MONTHS) goto L13;
        return r5.isSupported(ChronoField.DAY_OF_MONTH);
    L13:
        if (r11 != ChronoUnit.YEARS) goto L17;
        return r5.isSupported(ChronoField.DAY_OF_YEAR);
    L17:
        if (r11 != b.d) goto L21;
        return r5.isSupported(ChronoField.EPOCH_DAY);
    L21:
        if (r11 == ChronoUnit.FOREVER) goto L23;
        return false;
    L23:
        return r5.isSupported(ChronoField.EPOCH_DAY);
    L24:
        return false;
    }

    @Override // org.threeten.bp.temporal.g
    public final boolean isTimeBased() {
        throw null;
    }

    @Override // org.threeten.bp.temporal.g
    public final ValueRange range() {
        return this.e;
    }

    @Override // org.threeten.bp.temporal.g
    public final ValueRange rangeRefinedBy(d r5) {
        ChronoUnit r10 = ChronoUnit.WEEKS;
        Enum r11 = this.d;
        if (r11 != r10) goto L7;
        return this.e;
    L7:
        if (r11 != ChronoUnit.MONTHS) goto L10;
        ChronoField r12 = ChronoField.DAY_OF_MONTH;
    L12:
        int r13 = e(r5.get(r12), jm.c.m(r5.get(ChronoField.DAY_OF_WEEK) - this.f21293b.getFirstDayOfWeek().getValue()) + 1);
        ValueRange r14 = r5.range(r12);
        return ValueRange.of(a(r13, (int) r14.getMinimum()), a(r13, (int) r14.getMaximum()));
    L10:
        if (r11 != ChronoUnit.YEARS) goto L15;
        r12 = ChronoField.DAY_OF_YEAR;
        goto L12
    L15:
        if (r11 != b.d) goto L19;
        return d(r5);
    L19:
        if (r11 != ChronoUnit.FOREVER) goto L23;
        return r5.range(ChronoField.YEAR);
    L23:
        throw new IllegalStateException("unreachable");
    }

    @Override // org.threeten.bp.temporal.g
    public final d resolve(Map r21, d r22, ResolverStyle r23) {
        WeekFields r5 = this.f21293b;
        int r10 = r5.getFirstDayOfWeek().getValue();
        ChronoUnit r11 = ChronoUnit.WEEKS;
        Enum r12 = this.d;
        ValueRange r13 = this.e;
        if (r12 != r11) goto L6;
        HashMap r14 = (HashMap) r21;
        r14.put(ChronoField.DAY_OF_WEEK, Long.valueOf(jm.c.m((r13.checkValidIntValue(((Long) r14.remove(this)).longValue(), this) - 1) + (r10 - 1)) + 1));
        return null;
    L6:
        ChronoField r15 = ChronoField.DAY_OF_WEEK;
        HashMap r16 = (HashMap) r21;
        if (r16.containsKey(r15) == true) goto L10;
        return null;
    L10:
        if (r12 == ChronoUnit.FOREVER) goto L12;
        ChronoField r17 = ChronoField.YEAR;
        if (r16.containsKey(r17) == true) goto L31;
        return null;
    L31:
        int r18 = jm.c.m(r15.checkValidIntValue(((Long) r16.get(r15)).longValue()) - r10) + 1;
        int r19 = r17.checkValidIntValue(((Long) r16.get(r17)).longValue());
        org.threeten.bp.chrono.i r110 = org.threeten.bp.chrono.i.from(r22);
        ChronoUnit r111 = ChronoUnit.MONTHS;
        if (r12 != r111) goto L50;
        ChronoField r20 = ChronoField.MONTH_OF_YEAR;
        if (r16.containsKey(r20) == true) goto L36;
        return null;
    L36:
        long r24 = ((Long) r16.remove(this)).longValue();
        if (r23 != ResolverStyle.LENIENT) goto L39;
        HashMap r25 = r16;
        org.threeten.bp.chrono.b r26 = r110.date(r19, 1, 1).plus(((Long) r25.get(r20)).longValue() - 1, r111);
        int r27 = b(r26, r10);
        int r112 = r26.get(ChronoField.DAY_OF_MONTH);
        long r28 = ((r24 - ((long) a(e(r112, r27), r112))) * 7) + ((long) (r18 - r27));
    L40:
        org.threeten.bp.chrono.b r29 = r26.plus(r28, ChronoUnit.DAYS);
        if (r23 == ResolverStyle.STRICT) goto L43;
    L47:
        r25.remove(this);
        r25.remove(r17);
        r25.remove(r20);
        r25.remove(r15);
        return r29;
    L43:
        if (r29.getLong(r20) == ((Long) r25.get(r20)).longValue()) goto L47;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L39:
        r25 = r16;
        org.threeten.bp.chrono.b r113 = r110.date(r19, r20.checkValidIntValue(((Long) r25.get(r20)).longValue()), 8);
        int r30 = b(r113, r10);
        long r31 = r13.checkValidIntValue(r24, this);
        int r32 = r113.get(ChronoField.DAY_OF_MONTH);
        r28 = ((r31 - ((long) a(e(r32, r30), r32))) * 7) + ((long) (r18 - r30));
        r26 = r113;
        goto L40
    L50:
        if (r12 != ChronoUnit.YEARS) goto L66;
        long r33 = ((Long) r16.remove(this)).longValue();
        org.threeten.bp.chrono.b r34 = r110.date(r19, 1, 1);
        if (r23 != ResolverStyle.LENIENT) goto L55;
        int r35 = b(r34, r10);
        long r36 = r33 - c(r34, r35);
        long r114 = 7;
    L56:
        org.threeten.bp.chrono.b r37 = r34.plus((r36 * r114) + ((long) (r18 - r35)), ChronoUnit.DAYS);
        if (r23 == ResolverStyle.STRICT) goto L59;
    L63:
        r16.remove(this);
        r16.remove(r17);
        r16.remove(r15);
        return r37;
    L59:
        if (r37.getLong(r17) == ((Long) r16.get(r17)).longValue()) goto L63;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L55:
        r114 = 7;
        r35 = b(r34, r10);
        r36 = ((long) r13.checkValidIntValue(r33, this)) - c(r34, r35);
        goto L56
    L66:
        throw new IllegalStateException("unreachable");
    L12:
        if (r16.containsKey(WeekFields.access$000(r5)) == true) goto L14;
        return null;
    L14:
        org.threeten.bp.chrono.i r38 = org.threeten.bp.chrono.i.from(r22);
        int r39 = jm.c.m(r15.checkValidIntValue(((Long) r16.get(r15)).longValue()) - r10) + 1;
        int r40 = r13.checkValidIntValue(((Long) r16.get(this)).longValue(), this);
        if (r23 != ResolverStyle.LENIENT) goto L18;
        org.threeten.bp.chrono.b r41 = r38.date(r40, 1, r5.getMinimalDaysInFirstWeek());
        long r115 = ((Long) r16.get(WeekFields.access$000(r5))).longValue();
        int r42 = b(r41, r10);
        long r116 = c(r41, r42);
    L19:
        org.threeten.bp.chrono.b r43 = r41.plus(((r115 - r116) * 7) + ((long) (r39 - r42)), ChronoUnit.DAYS);
        if (r23 == ResolverStyle.STRICT) goto L22;
    L26:
        r16.remove(this);
        r16.remove(WeekFields.access$000(r5));
        r16.remove(r15);
        return r43;
    L22:
        if (r43.getLong(this) == ((Long) r16.get(this)).longValue()) goto L26;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L18:
        r41 = r38.date(r40, 1, r5.getMinimalDaysInFirstWeek());
        r115 = WeekFields.access$000(r5).range().checkValidIntValue(((Long) r16.get(WeekFields.access$000(r5))).longValue(), WeekFields.access$000(r5));
        r42 = b(r41, r10);
        r116 = c(r41, r42);
        goto L19
    }

    public final String toString() {
        return this.f21292a + "[" + this.f21293b.toString() + "]";
    }
}
