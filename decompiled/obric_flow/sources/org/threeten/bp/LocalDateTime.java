package org.threeten.bp;

import cn.nubia.neopush.commons.AppUtil;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalDateTime extends org.threeten.bp.chrono.c implements Serializable {
    public static final org.threeten.bp.temporal.i FROM = null;
    public static final LocalDateTime MAX = null;
    public static final LocalDateTime MIN = null;
    private static final long serialVersionUID = 6207766400415563566L;
    private final LocalDate date;
    private final LocalTime time;

    static {
        MIN = of(LocalDate.MIN, LocalTime.MIN);
        MAX = of(LocalDate.MAX, LocalTime.MAX);
        FROM = new com.bytedance.sdk.xbridge.cn.auth.g(14);
    }

    public LocalDateTime(LocalDate r5, LocalTime r10) {
        this.date = r5;
        this.time = r10;
    }

    public static LocalDateTime from(org.threeten.bp.temporal.d r5) {
        if ((r5 instanceof LocalDateTime) == false) goto L7;
        return (LocalDateTime) r5;
    L7:
        if ((r5 instanceof ZonedDateTime) == true) goto L9;
        return new LocalDateTime(LocalDate.from(r5), LocalTime.from(r5));
    L13:
        throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    L9:
        return ((ZonedDateTime) r5).toLocalDateTime();
    }

    public static LocalDateTime now() {
        return now(a.systemDefaultZone());
    }

    public static LocalDateTime of(int r5, Month r10, int r11, int r12, int r13) {
        return new LocalDateTime(LocalDate.of(r5, r10, r11), LocalTime.of(r12, r13));
    }

    public static LocalDateTime ofEpochSecond(long r5, int r10, ZoneOffset r11) {
        jm.c.p(r11, "offset");
        long r12 = r5 + ((long) r11.getTotalSeconds());
        return new LocalDateTime(LocalDate.ofEpochDay(jm.c.l(r12, 86400)), LocalTime.ofSecondOfDay(jm.c.n(86400, r12), r10));
    }

    public static LocalDateTime ofInstant(Instant r5, ZoneId r10) {
        jm.c.p(r5, "instant");
        jm.c.p(r10, "zone");
        ZoneOffset r11 = r10.getRules().getOffset(r5);
        return ofEpochSecond(r5.getEpochSecond(), r5.getNano(), r11);
    }

    public static LocalDateTime parse(CharSequence r5) {
        return parse(r5, org.threeten.bp.format.b.f21200i);
    }

    public static LocalDateTime readExternal(DataInput r5) throws IOException {
        return of(LocalDate.readExternal(r5), LocalTime.readExternal(r5));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    public final int a(LocalDateTime r5) {
        int r10 = this.date.compareTo0(r5.toLocalDate());
        if (r10 == 0) goto L5;
        return r10;
    L5:
        return this.time.compareTo2(r5.toLocalTime());
    }

    @Override // org.threeten.bp.chrono.c, org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return super.adjustInto(r5);
    }

    public OffsetDateTime atOffset(ZoneOffset r5) {
        return OffsetDateTime.of(this, r5);
    }

    @Override // org.threeten.bp.chrono.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.g atZone(ZoneId r5) {
        return atZone(r5);
    }

    public final LocalDateTime b(LocalDate r19, long r20, long r22, long r24, long r26, int r28) {
        if ((((r20 | r22) | r24) | r26) == 0) goto L5;
        long r10 = r22 / 1440;
        long r12 = r20 / 24;
        long r13 = r12 + (r10 + ((r24 / 86400) + (r26 / 86400000000000L)));
        long r11 = r28;
        long r5 = (r22 % 1440) * 60000000000L;
        long r14 = ((r20 % 24) * 3600000000000L) + (r5 + (((r24 % 86400) * 1000000000) + (r26 % 86400000000000L)));
        long r15 = this.time.toNanoOfDay();
        long r16 = (r14 * r11) + r15;
        long r17 = jm.c.l(r16, 86400000000000L) + (r13 * r11);
        long r18 = jm.c.o(r16, 86400000000000L);
        if (r18 != r15) goto L9;
        LocalTime r21 = this.time;
    L11:
        return c(r19.plusDays(r17), r21);
    L9:
        r21 = LocalTime.ofNanoOfDay(r18);
        goto L11
    L5:
        return c(r19, this.time);
    }

    public final LocalDateTime c(LocalDate r5, LocalTime r10) {
        if (this.date != r5) goto L8;
        if (this.time != r10) goto L8;
        return this;
    L8:
        return new LocalDateTime(r5, r10);
    }

    @Override // org.threeten.bp.chrono.c, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r5) {
        return compareTo((org.threeten.bp.chrono.c) r5);
    }

    @Override // org.threeten.bp.chrono.c
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LocalDateTime) == false) goto L14;
        LocalDateTime r10 = (LocalDateTime) r5;
        if (this.date.equals(r10.date) == false) goto L13;
        if (this.time.equals(r10.time) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // org.threeten.bp.chrono.c
    public String format(org.threeten.bp.format.b r5) {
        return super.format(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L10;
        if (r5.isTimeBased() == false) goto L8;
        return this.time.get(r5);
    L8:
        return this.date.get(r5);
    L10:
        return super.get(r5);
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.date.getDayOfWeek();
    }

    public int getDayOfYear() {
        return this.date.getDayOfYear();
    }

    public int getHour() {
        return this.time.getHour();
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L10;
        if (r5.isTimeBased() == false) goto L8;
        return this.time.getLong(r5);
    L8:
        return this.date.getLong(r5);
    L10:
        return r5.getFrom(this);
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public Month getMonth() {
        return this.date.getMonth();
    }

    public int getMonthValue() {
        return this.date.getMonthValue();
    }

    public int getNano() {
        return this.time.getNano();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getYear() {
        return this.date.getYear();
    }

    @Override // org.threeten.bp.chrono.c
    public int hashCode() {
        int r5 = this.date.hashCode();
        return this.time.hashCode() ^ r5;
    }

    @Override // org.threeten.bp.chrono.c
    public boolean isAfter(org.threeten.bp.chrono.c r5) {
        if ((r5 instanceof LocalDateTime) == false) goto L10;
        if (a((LocalDateTime) r5) <= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isAfter(r5);
    }

    @Override // org.threeten.bp.chrono.c
    public boolean isBefore(org.threeten.bp.chrono.c r5) {
        if ((r5 instanceof LocalDateTime) == false) goto L10;
        if (a((LocalDateTime) r5) >= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isBefore(r5);
    }

    @Override // org.threeten.bp.chrono.c
    public boolean isEqual(org.threeten.bp.chrono.c r5) {
        if ((r5 instanceof LocalDateTime) == false) goto L10;
        if (a((LocalDateTime) r5) != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isEqual(r5);
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == true) goto L5;
        if (r5 == null) goto L16;
        if (r5.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r5.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r5.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.chrono.c, fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    public LocalDateTime minusDays(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        LocalDateTime this = plusDays(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusDays(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public LocalDateTime minusHours(long r12) {
        return b(this.date, r12, 0, 0, 0, -1);
    }

    public LocalDateTime minusMinutes(long r12) {
        return b(this.date, 0, r12, 0, 0, -1);
    }

    public LocalDateTime minusMonths(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        LocalDateTime this = plusMonths(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusMonths(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public LocalDateTime minusNanos(long r12) {
        return b(this.date, 0, 0, 0, r12, -1);
    }

    public LocalDateTime minusSeconds(long r12) {
        return b(this.date, 0, 0, r12, 0, -1);
    }

    public LocalDateTime minusWeeks(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        LocalDateTime this = plusWeeks(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusWeeks(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public LocalDateTime minusYears(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        LocalDateTime this = plusYears(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusYears(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    public LocalDateTime plusDays(long r5) {
        return c(this.date.plusDays(r5), this.time);
    }

    public LocalDateTime plusHours(long r12) {
        return b(this.date, r12, 0, 0, 0, 1);
    }

    public LocalDateTime plusMinutes(long r12) {
        return b(this.date, 0, r12, 0, 0, 1);
    }

    public LocalDateTime plusMonths(long r5) {
        return c(this.date.plusMonths(r5), this.time);
    }

    public LocalDateTime plusNanos(long r12) {
        return b(this.date, 0, 0, 0, r12, 1);
    }

    public LocalDateTime plusSeconds(long r12) {
        return b(this.date, 0, 0, r12, 0, 1);
    }

    public LocalDateTime plusWeeks(long r5) {
        return c(this.date.plusWeeks(r5), this.time);
    }

    public LocalDateTime plusYears(long r5) {
        return c(this.date.plusYears(r5), this.time);
    }

    @Override // org.threeten.bp.chrono.c, fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f) goto L7;
        return (R) toLocalDate();
    L7:
        return (R) super.query(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L10;
        if (r5.isTimeBased() == false) goto L8;
        return this.time.range(r5);
    L8:
        return this.date.range(r5);
    L10:
        return r5.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b toLocalDate() {
        return toLocalDate();
    }

    @Override // org.threeten.bp.chrono.c
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // org.threeten.bp.chrono.c
    public String toString() {
        return this.date.toString() + 'T' + this.time.toString();
    }

    public LocalDateTime truncatedTo(org.threeten.bp.temporal.j r5) {
        return c(this.date, this.time.truncatedTo(r5));
    }

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r12, org.threeten.bp.temporal.j r13) {
        LocalDateTime r14 = from(r12);
        if ((r13 instanceof ChronoUnit) == false) goto L46;
        ChronoUnit r5 = (ChronoUnit) r13;
        if (r5.isTimeBased() == false) goto L33;
        long r10 = this.date.daysUntil(r14.date);
        long r11 = r14.time.toNanoOfDay() - this.time.toNanoOfDay();
        if (r10 > 0) goto L9;
    L11:
        if (r10 < 0) goto L13;
    L16:
        switch(e.f21186a[r5.ordinal()]) {
            case 1: goto L32;
            case 2: goto L30;
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L24;
            case 6: goto L22;
            case 7: goto L20;
            default: goto L18;
        };
    L18:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r13);
    L20:
        return jm.c.r(jm.c.t(2, r10), r11 / 43200000000000L);
    L22:
        return jm.c.r(jm.c.t(24, r10), r11 / 3600000000000L);
    L24:
        return jm.c.r(jm.c.t(1440, r10), r11 / 60000000000L);
    L26:
        return jm.c.r(jm.c.t(86400, r10), r11 / 1000000000);
    L28:
        return jm.c.r(jm.c.u(r10, AppUtil.MILLIS_IN_DAYS), r11 / 1000000);
    L30:
        return jm.c.r(jm.c.u(r10, 86400000000L), r11 / 1000);
    L32:
        return jm.c.r(jm.c.u(r10, 86400000000000L), r11);
    L13:
        if (r11 <= 0) goto L16;
        r10 = r10 + 1;
        r11 = r11 - 86400000000000L;
        goto L16
    L9:
        if (r11 >= 0) goto L11;
        r10 = r10 - 1;
        r11 = r11 + 86400000000000L;
        goto L16
    L33:
        LocalDate r15 = r14.date;
        if (r15.isAfter(this.date) == false) goto L39;
        if (r14.time.isBefore(this.time) == false) goto L39;
        r15 = r15.minusDays(1);
    L44:
        return this.date.until(r15, r13);
    L39:
        if (r15.isBefore(this.date) == false) goto L44;
        if (r14.time.isAfter(this.time) == false) goto L44;
        r15 = r15.plusDays(1);
        goto L44
    L46:
        return r13.between(this, r14);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public LocalDateTime withDayOfMonth(int r5) {
        return c(this.date.withDayOfMonth(r5), this.time);
    }

    public LocalDateTime withDayOfYear(int r5) {
        return c(this.date.withDayOfYear(r5), this.time);
    }

    public LocalDateTime withHour(int r5) {
        LocalTime r10 = this.time.withHour(r5);
        return c(this.date, r10);
    }

    public LocalDateTime withMinute(int r5) {
        LocalTime r10 = this.time.withMinute(r5);
        return c(this.date, r10);
    }

    public LocalDateTime withMonth(int r5) {
        return c(this.date.withMonth(r5), this.time);
    }

    public LocalDateTime withNano(int r5) {
        LocalTime r10 = this.time.withNano(r5);
        return c(this.date, r10);
    }

    public LocalDateTime withSecond(int r5) {
        LocalTime r10 = this.time.withSecond(r5);
        return c(this.date, r10);
    }

    public LocalDateTime withYear(int r5) {
        return c(this.date.withYear(r5), this.time);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        this.date.writeExternal(r5);
        this.time.writeExternal(r5);
    }

    public static LocalDateTime now(ZoneId r5) {
        return now(a.system(r5));
    }

    public static LocalDateTime parse(CharSequence r5, org.threeten.bp.format.b r10) {
        jm.c.p(r10, "formatter");
        return (LocalDateTime) r10.c(r5, FROM);
    }

    @Override // org.threeten.bp.chrono.c
    public ZonedDateTime atZone(ZoneId r5) {
        return ZonedDateTime.of(this, r5);
    }

    @Override // org.threeten.bp.chrono.c
    public int compareTo(org.threeten.bp.chrono.c r5) {
        if ((r5 instanceof LocalDateTime) == false) goto L7;
        return a((LocalDateTime) r5);
    L7:
        return super.compareTo(r5);
    }

    @Override // org.threeten.bp.chrono.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.c minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    @Override // org.threeten.bp.chrono.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.c plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.chrono.c
    public LocalDate toLocalDate() {
        return this.date;
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public static LocalDateTime now(a r5) {
        jm.c.p(r5, "clock");
        Instant r10 = r5.instant();
        ZoneOffset r11 = r5.getZone().getRules().getOffset(r10);
        return ofEpochSecond(r10.getEpochSecond(), r10.getNano(), r11);
    }

    @Override // org.threeten.bp.chrono.c, fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public static LocalDateTime of(int r5, Month r10, int r11, int r12, int r13, int r14) {
        return new LocalDateTime(LocalDate.of(r5, r10, r11), LocalTime.of(r12, r13, r14));
    }

    public boolean isSupported(org.threeten.bp.temporal.j r5) {
        if ((r5 instanceof ChronoUnit) == true) goto L5;
        if (r5 == null) goto L16;
        if (r5.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r5.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r5.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.chrono.c
    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1650minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    @Override // org.threeten.bp.chrono.c
    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1651plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    @Override // org.threeten.bp.chrono.c
    public LocalDateTime minus(org.threeten.bp.temporal.f r5) {
        return (LocalDateTime) r5.subtractFrom(this);
    }

    @Override // org.threeten.bp.chrono.c
    public LocalDateTime plus(org.threeten.bp.temporal.f r5) {
        return (LocalDateTime) r5.addTo(this);
    }

    @Override // org.threeten.bp.temporal.c
    public LocalDateTime with(org.threeten.bp.temporal.e r5) {
        if ((r5 instanceof LocalDate) == false) goto L7;
        return c((LocalDate) r5, this.time);
    L7:
        if ((r5 instanceof LocalTime) == false) goto L11;
        return c(this.date, (LocalTime) r5);
    L11:
        if ((r5 instanceof LocalDateTime) == false) goto L15;
        return (LocalDateTime) r5;
    L15:
        return (LocalDateTime) r5.adjustInto(this);
    }

    @Override // org.threeten.bp.chrono.c, fv.b, org.threeten.bp.temporal.c
    public LocalDateTime minus(long r5, org.threeten.bp.temporal.j r10) {
        if (r5 != Long.MIN_VALUE) goto L6;
        LocalDateTime this = plus(Long.MAX_VALUE, r10);
        long r11 = 1;
    L7:
        return this.plus(r11, r10);
    L6:
        r11 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public LocalDateTime plus(long r5, org.threeten.bp.temporal.j r10) {
        if ((r10 instanceof ChronoUnit) == false) goto L23;
        switch(e.f21186a[((ChronoUnit) r10).ordinal()]) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        return c(this.date.plus(r5, r10), this.time);
    L9:
        return plusDays(r5 / 256).plusHours((r5 % 256) * 12);
    L11:
        return plusHours(r5);
    L13:
        return plusMinutes(r5);
    L15:
        return plusSeconds(r5);
    L17:
        return plusDays(r5 / AppUtil.MILLIS_IN_DAYS).plusNanos((r5 % AppUtil.MILLIS_IN_DAYS) * 1000000);
    L19:
        return plusDays(r5 / 86400000000L).plusNanos((r5 % 86400000000L) * 1000);
    L21:
        return plusNanos(r5);
    L23:
        return (LocalDateTime) r10.addTo(this, r5);
    }

    public static LocalDateTime of(int r5, Month r10, int r11, int r12, int r13, int r14, int r15) {
        return new LocalDateTime(LocalDate.of(r5, r10, r11), LocalTime.of(r12, r13, r14, r15));
    }

    public static LocalDateTime of(int r5, int r10, int r11, int r12, int r13) {
        return new LocalDateTime(LocalDate.of(r5, r10, r11), LocalTime.of(r12, r13));
    }

    @Override // org.threeten.bp.temporal.c
    public LocalDateTime with(org.threeten.bp.temporal.g r5, long r10) {
        if ((r5 instanceof ChronoField) == false) goto L11;
        if (r5.isTimeBased() == false) goto L9;
        return c(this.date, this.time.with(r5, r10));
    L9:
        return c(this.date.with(r5, r10), this.time);
    L11:
        return (LocalDateTime) r5.adjustInto(this, r10);
    }

    public static LocalDateTime of(int r5, int r10, int r11, int r12, int r13, int r14) {
        return new LocalDateTime(LocalDate.of(r5, r10, r11), LocalTime.of(r12, r13, r14));
    }

    public static LocalDateTime of(int r5, int r10, int r11, int r12, int r13, int r14, int r15) {
        return new LocalDateTime(LocalDate.of(r5, r10, r11), LocalTime.of(r12, r13, r14, r15));
    }

    public static LocalDateTime of(LocalDate r5, LocalTime r10) {
        jm.c.p(r5, "date");
        jm.c.p(r10, "time");
        return new LocalDateTime(r5, r10);
    }
}
