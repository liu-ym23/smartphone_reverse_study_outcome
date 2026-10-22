package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Comparator;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class OffsetDateTime extends fv.b implements org.threeten.bp.temporal.e, Comparable<OffsetDateTime>, Serializable {
    public static final org.threeten.bp.temporal.i FROM = null;
    public static final OffsetDateTime MAX = null;
    public static final OffsetDateTime MIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ca.d f21125a = null;
    private static final long serialVersionUID = 2287754244819255394L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;

    static {
        MIN = LocalDateTime.MIN.atOffset(ZoneOffset.MAX);
        MAX = LocalDateTime.MAX.atOffset(ZoneOffset.MIN);
        FROM = new ib.d(14);
        f21125a = new ca.d(26);
    }

    public OffsetDateTime(LocalDateTime r5, ZoneOffset r10) {
        jm.c.p(r5, "dateTime");
        this.dateTime = r5;
        jm.c.p(r10, "offset");
        this.offset = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [org.threeten.bp.OffsetDateTime] */
    public static OffsetDateTime from(Object r5) {
        if ((r5 instanceof OffsetDateTime) == true) goto L5;
        ZoneOffset r10 = ZoneOffset.from(r5);     // Catch: DateTimeException -> L11
        r5 = of(LocalDateTime.from(r5), r10);     // Catch: DateTimeException -> L9
        return r5;
    L9:
        return ofInstant(Instant.from(r5), r10);
    L12:
        throw new DateTimeException("Unable to obtain OffsetDateTime from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    L5:
        return (OffsetDateTime) r5;
    }

    public static OffsetDateTime now() {
        return now(a.systemDefaultZone());
    }

    public static OffsetDateTime of(LocalDate r5, LocalTime r10, ZoneOffset r11) {
        return new OffsetDateTime(LocalDateTime.of(r5, r10), r11);
    }

    public static OffsetDateTime ofInstant(Instant r5, ZoneId r10) {
        jm.c.p(r5, "instant");
        jm.c.p(r10, "zone");
        ZoneOffset r11 = r10.getRules().getOffset(r5);
        return new OffsetDateTime(LocalDateTime.ofEpochSecond(r5.getEpochSecond(), r5.getNano(), r11), r11);
    }

    public static OffsetDateTime parse(CharSequence r5) {
        return parse(r5, org.threeten.bp.format.b.f21201j);
    }

    public static OffsetDateTime readExternal(DataInput r5) throws IOException {
        return of(LocalDateTime.readExternal(r5), ZoneOffset.readExternal(r5));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Comparator<OffsetDateTime> timeLineOrder() {
        return f21125a;
    }

    private Object writeReplace() {
        return new Ser((byte) 69, this);
    }

    public final OffsetDateTime a(LocalDateTime r5, ZoneOffset r10) {
        if (this.dateTime != r5) goto L8;
        if (this.offset.equals(r10) == false) goto L8;
        return this;
    L8:
        return new OffsetDateTime(r5, r10);
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return r5.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, getOffset().getTotalSeconds());
    }

    public ZonedDateTime atZoneSameInstant(ZoneId r5) {
        return ZonedDateTime.ofInstant(this.dateTime, this.offset, r5);
    }

    public ZonedDateTime atZoneSimilarLocal(ZoneId r5) {
        return ZonedDateTime.ofLocal(this.dateTime, r5, this.offset);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(OffsetDateTime r5) {
        return compareTo2(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OffsetDateTime) == false) goto L14;
        OffsetDateTime r10 = (OffsetDateTime) r5;
        if (this.dateTime.equals(r10.dateTime) == false) goto L13;
        if (this.offset.equals(r10.offset) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public String format(org.threeten.bp.format.b r5) {
        jm.c.p(r5, "formatter");
        return r5.a(this);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        int r10 = i.f21264a[((ChronoField) r5).ordinal()];
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L11;
        return this.dateTime.get(r5);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        throw new DateTimeException(kotlin.collections.a.h("Field too large for an int: ", r5));
    L15:
        return super.get(r5);
    }

    public int getDayOfMonth() {
        return this.dateTime.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.dateTime.getDayOfWeek();
    }

    public int getDayOfYear() {
        return this.dateTime.getDayOfYear();
    }

    public int getHour() {
        return this.dateTime.getHour();
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        int r10 = i.f21264a[((ChronoField) r5).ordinal()];
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L11;
        return this.dateTime.getLong(r5);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        return toEpochSecond();
    L15:
        return r5.getFrom(this);
    }

    public int getMinute() {
        return this.dateTime.getMinute();
    }

    public Month getMonth() {
        return this.dateTime.getMonth();
    }

    public int getMonthValue() {
        return this.dateTime.getMonthValue();
    }

    public int getNano() {
        return this.dateTime.getNano();
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.dateTime.getSecond();
    }

    public int getYear() {
        return this.dateTime.getYear();
    }

    public int hashCode() {
        int r5 = this.dateTime.hashCode();
        return this.offset.hashCode() ^ r5;
    }

    public boolean isAfter(OffsetDateTime r5) {
        long r10 = toEpochSecond();
        long r11 = r5.toEpochSecond();
        if (r10 > r11) goto L9;
        if (r10 == r11) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() <= r5.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isBefore(OffsetDateTime r5) {
        long r10 = toEpochSecond();
        long r11 = r5.toEpochSecond();
        if (r10 < r11) goto L9;
        if (r10 == r11) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() >= r5.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isEqual(OffsetDateTime r5) {
        if (toEpochSecond() == r5.toEpochSecond()) goto L5;
    L7:
        return false;
    L5:
        if (toLocalTime().getNano() != r5.toLocalTime().getNano()) goto L7;
        return true;
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == true) goto L9;
        if (r5 != null) goto L6;
    L8:
        return false;
    L6:
        if (r5.isSupportedBy(this) == false) goto L8;
    L9:
        return true;
    }

    @Override // fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    public OffsetDateTime minusDays(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusDays(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusDays(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public OffsetDateTime minusHours(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusHours(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusHours(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public OffsetDateTime minusMinutes(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusMinutes(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusMinutes(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public OffsetDateTime minusMonths(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusMonths(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusMonths(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public OffsetDateTime minusNanos(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusNanos(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusNanos(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public OffsetDateTime minusSeconds(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusSeconds(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusSeconds(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public OffsetDateTime minusWeeks(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusWeeks(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusWeeks(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public OffsetDateTime minusYears(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusYears(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusYears(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    public OffsetDateTime plusDays(long r5) {
        return a(this.dateTime.plusDays(r5), this.offset);
    }

    public OffsetDateTime plusHours(long r5) {
        return a(this.dateTime.plusHours(r5), this.offset);
    }

    public OffsetDateTime plusMinutes(long r5) {
        return a(this.dateTime.plusMinutes(r5), this.offset);
    }

    public OffsetDateTime plusMonths(long r5) {
        return a(this.dateTime.plusMonths(r5), this.offset);
    }

    public OffsetDateTime plusNanos(long r5) {
        return a(this.dateTime.plusNanos(r5), this.offset);
    }

    public OffsetDateTime plusSeconds(long r5) {
        return a(this.dateTime.plusSeconds(r5), this.offset);
    }

    public OffsetDateTime plusWeeks(long r5) {
        return a(this.dateTime.plusWeeks(r5), this.offset);
    }

    public OffsetDateTime plusYears(long r5) {
        return a(this.dateTime.plusYears(r5), this.offset);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L11;
        return (R) ChronoUnit.NANOS;
    L11:
        if (r5 == org.threeten.bp.temporal.h.e) goto L30;
        if (r5 == org.threeten.bp.temporal.h.d) goto L30;
        if (r5 != org.threeten.bp.temporal.h.f) goto L20;
        return (R) toLocalDate();
    L20:
        if (r5 != org.threeten.bp.temporal.h.g) goto L24;
        return (R) toLocalTime();
    L24:
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L28;
        return null;
    L28:
        return (R) super.query(r5);
    L30:
        return (R) getOffset();
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L14;
        if (r5 == ChronoField.INSTANT_SECONDS) goto L12;
        if (r5 == ChronoField.OFFSET_SECONDS) goto L12;
        return this.dateTime.range(r5);
    L12:
        return r5.range();
    L14:
        return r5.rangeRefinedBy(this);
    }

    public long toEpochSecond() {
        return this.dateTime.toEpochSecond(this.offset);
    }

    public Instant toInstant() {
        return this.dateTime.toInstant(this.offset);
    }

    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    public LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetTime toOffsetTime() {
        return OffsetTime.of(this.dateTime.toLocalTime(), this.offset);
    }

    public String toString() {
        return this.dateTime.toString() + this.offset.toString();
    }

    public ZonedDateTime toZonedDateTime() {
        return ZonedDateTime.of(this.dateTime, this.offset);
    }

    public OffsetDateTime truncatedTo(org.threeten.bp.temporal.j r5) {
        return a(this.dateTime.truncatedTo(r5), this.offset);
    }

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r5, org.threeten.bp.temporal.j r10) {
        OffsetDateTime r11 = from(r5);
        if ((r10 instanceof ChronoUnit) == false) goto L7;
        OffsetDateTime r12 = r11.withOffsetSameInstant(this.offset);
        return this.dateTime.until(r12.dateTime, r10);
    L7:
        return r10.between(this, r11);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public OffsetDateTime withDayOfMonth(int r5) {
        return a(this.dateTime.withDayOfMonth(r5), this.offset);
    }

    public OffsetDateTime withDayOfYear(int r5) {
        return a(this.dateTime.withDayOfYear(r5), this.offset);
    }

    public OffsetDateTime withHour(int r5) {
        return a(this.dateTime.withHour(r5), this.offset);
    }

    public OffsetDateTime withMinute(int r5) {
        return a(this.dateTime.withMinute(r5), this.offset);
    }

    public OffsetDateTime withMonth(int r5) {
        return a(this.dateTime.withMonth(r5), this.offset);
    }

    public OffsetDateTime withNano(int r5) {
        return a(this.dateTime.withNano(r5), this.offset);
    }

    public OffsetDateTime withOffsetSameInstant(ZoneOffset r5) {
        if (r5.equals(this.offset) == false) goto L6;
        return this;
    L6:
        return new OffsetDateTime(this.dateTime.plusSeconds(r5.getTotalSeconds() - this.offset.getTotalSeconds()), r5);
    }

    public OffsetDateTime withOffsetSameLocal(ZoneOffset r5) {
        return a(this.dateTime, r5);
    }

    public OffsetDateTime withSecond(int r5) {
        return a(this.dateTime.withSecond(r5), this.offset);
    }

    public OffsetDateTime withYear(int r5) {
        return a(this.dateTime.withYear(r5), this.offset);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        this.dateTime.writeExternal(r5);
        this.offset.writeExternal(r5);
    }

    public static OffsetDateTime now(ZoneId r5) {
        return now(a.system(r5));
    }

    public static OffsetDateTime parse(CharSequence r5, org.threeten.bp.format.b r10) {
        jm.c.p(r10, "formatter");
        return (OffsetDateTime) r10.c(r5, FROM);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(OffsetDateTime r5) {
        if (getOffset().equals(r5.getOffset()) == true) goto L5;
        int r10 = jm.c.j(toEpochSecond(), r5.toEpochSecond());
        if (r10 != 0) goto L12;
        int r11 = toLocalTime().getNano() - r5.toLocalTime().getNano();
        if (r11 == 0) goto L11;
        return r11;
    L11:
        return toLocalDateTime().compareTo(r5.toLocalDateTime());
    L12:
        return r10;
    L5:
        return toLocalDateTime().compareTo(r5.toLocalDateTime());
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

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1654minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1655plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public static OffsetDateTime now(a r5) {
        jm.c.p(r5, "clock");
        Instant r10 = r5.instant();
        return ofInstant(r10, r5.getZone().getRules().getOffset(r10));
    }

    public static OffsetDateTime of(LocalDateTime r5, ZoneOffset r10) {
        return new OffsetDateTime(r5, r10);
    }

    public OffsetDateTime minus(org.threeten.bp.temporal.f r5) {
        return (OffsetDateTime) r5.subtractFrom(this);
    }

    public OffsetDateTime plus(org.threeten.bp.temporal.f r5) {
        return (OffsetDateTime) r5.addTo(this);
    }

    @Override // org.threeten.bp.temporal.c
    public OffsetDateTime with(org.threeten.bp.temporal.e r5) {
        if ((r5 instanceof LocalDate) == true) goto L24;
        if ((r5 instanceof LocalTime) == true) goto L24;
        if ((r5 instanceof LocalDateTime) == true) goto L24;
        if ((r5 instanceof Instant) == false) goto L14;
        return ofInstant((Instant) r5, this.offset);
    L14:
        if ((r5 instanceof ZoneOffset) == false) goto L18;
        return a(this.dateTime, (ZoneOffset) r5);
    L18:
        if ((r5 instanceof OffsetDateTime) == false) goto L22;
        return (OffsetDateTime) r5;
    L22:
        return (OffsetDateTime) r5.adjustInto(this);
    L24:
        return a(this.dateTime.with(r5), this.offset);
    }

    public static OffsetDateTime of(int r5, int r10, int r11, int r12, int r13, int r14, int r15, ZoneOffset r16) {
        return new OffsetDateTime(LocalDateTime.of(r5, r10, r11, r12, r13, r14, r15), r16);
    }

    @Override // fv.b, org.threeten.bp.temporal.c
    public OffsetDateTime minus(long r5, org.threeten.bp.temporal.j r10) {
        if (r5 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plus(Long.MAX_VALUE, r10);
        long r11 = 1;
    L7:
        return this.plus(r11, r10);
    L6:
        r11 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public OffsetDateTime plus(long r5, org.threeten.bp.temporal.j r10) {
        if ((r10 instanceof ChronoUnit) == false) goto L7;
        return a(this.dateTime.plus(r5, r10), this.offset);
    L7:
        return (OffsetDateTime) r10.addTo(this, r5);
    }

    @Override // org.threeten.bp.temporal.c
    public OffsetDateTime with(org.threeten.bp.temporal.g r5, long r10) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        ChronoField r11 = (ChronoField) r5;
        int r12 = i.f21264a[r11.ordinal()];
        if (r12 == 1) goto L13;
        if (r12 == 2) goto L11;
        return a(this.dateTime.with(r5, r10), this.offset);
    L11:
        return a(this.dateTime, ZoneOffset.ofTotalSeconds(r11.checkValidIntValue(r10)));
    L13:
        return ofInstant(Instant.ofEpochSecond(r10, getNano()), this.offset);
    L15:
        return (OffsetDateTime) r5.adjustInto(this, r10);
    }
}
