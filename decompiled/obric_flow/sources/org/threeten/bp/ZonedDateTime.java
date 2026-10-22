package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;

/* JADX INFO: loaded from: classes3.dex */
public final class ZonedDateTime extends org.threeten.bp.chrono.g implements Serializable {
    public static final org.threeten.bp.temporal.i FROM = null;
    private static final long serialVersionUID = -6260982410461394882L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    static {
        FROM = new uj.a();
    }

    public ZonedDateTime(LocalDateTime r5, ZoneOffset r10, ZoneId r11) {
        this.dateTime = r5;
        this.offset = r10;
        this.zone = r11;
    }

    public static ZonedDateTime a(long r5, int r10, ZoneId r11) {
        ZoneOffset r12 = r11.getRules().getOffset(Instant.ofEpochSecond(r5, r10));
        return new ZonedDateTime(LocalDateTime.ofEpochSecond(r5, r10, r12), r12, r11);
    }

    public static ZonedDateTime from(org.threeten.bp.temporal.d r5) {
        if ((r5 instanceof ZonedDateTime) == true) goto L5;
        ZoneId r10 = ZoneId.from(r5);     // Catch: DateTimeException -> L12
        ChronoField r11 = ChronoField.INSTANT_SECONDS;     // Catch: DateTimeException -> L12
        if (r5.isSupported(r11) == true) goto L15;
    L10:
        return of(LocalDateTime.from(r5), r10);
    L15:
        return a(r5.getLong(r11), r5.get(ChronoField.NANO_OF_SECOND), r10);
    L13:
        throw new DateTimeException("Unable to obtain ZonedDateTime from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    L5:
        return (ZonedDateTime) r5;
    }

    public static ZonedDateTime now() {
        return now(a.systemDefaultZone());
    }

    public static ZonedDateTime of(LocalDate r5, LocalTime r10, ZoneId r11) {
        return of(LocalDateTime.of(r5, r10), r11);
    }

    public static ZonedDateTime ofInstant(Instant r5, ZoneId r10) {
        jm.c.p(r5, "instant");
        jm.c.p(r10, "zone");
        return a(r5.getEpochSecond(), r5.getNano(), r10);
    }

    public static ZonedDateTime ofLocal(LocalDateTime r5, ZoneId r10, ZoneOffset r11) {
        jm.c.p(r5, "localDateTime");
        jm.c.p(r10, "zone");
        if ((r10 instanceof ZoneOffset) == true) goto L5;
        org.threeten.bp.zone.d r12 = r10.getRules();
        List r13 = r12.getValidOffsets(r5);
        if (r13.size() != 1) goto L10;
        r11 = (ZoneOffset) r13.get(0);
    L18:
        return new ZonedDateTime(r5, r11, r10);
    L10:
        if (r13.size() != 0) goto L12;
        ZoneOffsetTransition r14 = r12.getTransition(r5);
        r5 = r5.plusSeconds(r14.getDuration().getSeconds());
        r11 = r14.getOffsetAfter();
        goto L18
    L12:
        if (r11 != null) goto L14;
    L16:
        Object r15 = r13.get(0);
        jm.c.p(r15, "offset");
        r11 = (ZoneOffset) r15;
        goto L18
    L14:
        if (r13.contains(r11) == false) goto L16;
    L5:
        return new ZonedDateTime(r5, (ZoneOffset) r10, r10);
    }

    public static ZonedDateTime ofStrict(LocalDateTime r5, ZoneOffset r10, ZoneId r11) {
        jm.c.p(r5, "localDateTime");
        jm.c.p(r10, "offset");
        jm.c.p(r11, "zone");
        org.threeten.bp.zone.d r12 = r11.getRules();
        if (r12.isValidOffset(r5, r10) == true) goto L13;
        ZoneOffsetTransition r13 = r12.getTransition(r5);
        if (r13 == null) goto L11;
        if (r13.isGap() == false) goto L11;
        throw new DateTimeException("LocalDateTime '" + r5 + "' does not exist in zone '" + r11 + "' due to a gap in the local time-line, typically caused by daylight savings");
    L11:
        throw new DateTimeException("ZoneOffset '" + r10 + "' is not valid for LocalDateTime '" + r5 + "' in zone '" + r11 + "'");
    L13:
        return new ZonedDateTime(r5, r10, r11);
    }

    public static ZonedDateTime parse(CharSequence r5) {
        return parse(r5, org.threeten.bp.format.b.f21202k);
    }

    public static ZonedDateTime readExternal(DataInput r5) throws IOException {
        LocalDateTime r10 = LocalDateTime.readExternal(r5);
        ZoneOffset r11 = ZoneOffset.readExternal(r5);
        ZoneId r12 = (ZoneId) Ser.read(r5);
        jm.c.p(r10, "localDateTime");
        jm.c.p(r11, "offset");
        jm.c.p(r12, "zone");
        if ((r12 instanceof ZoneOffset) == false) goto L10;
        if (r11.equals(r12) == true) goto L10;
        throw new IllegalArgumentException("ZoneId must match ZoneOffset");
    L10:
        return new ZonedDateTime(r10, r11, r12);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    public final ZonedDateTime b(LocalDateTime r5) {
        return ofLocal(r5, this.zone, this.offset);
    }

    public final ZonedDateTime c(ZoneOffset r5) {
        if (r5.equals(this.offset) == false) goto L5;
    L8:
        return this;
    L5:
        if (this.zone.getRules().isValidOffset(this.dateTime, r5) == false) goto L8;
        return new ZonedDateTime(this.dateTime, r5, this.zone);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ZonedDateTime) == false) goto L16;
        ZonedDateTime r10 = (ZonedDateTime) r5;
        if (this.dateTime.equals(r10.dateTime) == false) goto L15;
        if (this.offset.equals(r10.offset) == false) goto L15;
        if (this.zone.equals(r10.zone) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // org.threeten.bp.chrono.g
    public String format(org.threeten.bp.format.b r5) {
        return super.format(r5);
    }

    @Override // org.threeten.bp.chrono.g, fv.c, org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        int r10 = n.f21272a[((ChronoField) r5).ordinal()];
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

    @Override // org.threeten.bp.chrono.g, org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        int r10 = n.f21272a[((ChronoField) r5).ordinal()];
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

    @Override // org.threeten.bp.chrono.g
    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.dateTime.getSecond();
    }

    public int getYear() {
        return this.dateTime.getYear();
    }

    @Override // org.threeten.bp.chrono.g
    public ZoneId getZone() {
        return this.zone;
    }

    public int hashCode() {
        int r5 = this.dateTime.hashCode() ^ this.offset.hashCode();
        return Integer.rotateLeft(this.zone.hashCode(), 3) ^ r5;
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

    @Override // org.threeten.bp.chrono.g, fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.g minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    public ZonedDateTime minusDays(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusDays(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusDays(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public ZonedDateTime minusHours(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusHours(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusHours(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public ZonedDateTime minusMinutes(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusMinutes(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusMinutes(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public ZonedDateTime minusMonths(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusMonths(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusMonths(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public ZonedDateTime minusNanos(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusNanos(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusNanos(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public ZonedDateTime minusSeconds(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusSeconds(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusSeconds(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public ZonedDateTime minusWeeks(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusWeeks(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusWeeks(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public ZonedDateTime minusYears(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusYears(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusYears(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.g plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    public ZonedDateTime plusDays(long r5) {
        return b(this.dateTime.plusDays(r5));
    }

    public ZonedDateTime plusHours(long r5) {
        return ofInstant(this.dateTime.plusHours(r5), this.offset, this.zone);
    }

    public ZonedDateTime plusMinutes(long r5) {
        return ofInstant(this.dateTime.plusMinutes(r5), this.offset, this.zone);
    }

    public ZonedDateTime plusMonths(long r5) {
        return b(this.dateTime.plusMonths(r5));
    }

    public ZonedDateTime plusNanos(long r5) {
        return ofInstant(this.dateTime.plusNanos(r5), this.offset, this.zone);
    }

    public ZonedDateTime plusSeconds(long r5) {
        return ofInstant(this.dateTime.plusSeconds(r5), this.offset, this.zone);
    }

    public ZonedDateTime plusWeeks(long r5) {
        return b(this.dateTime.plusWeeks(r5));
    }

    public ZonedDateTime plusYears(long r5) {
        return b(this.dateTime.plusYears(r5));
    }

    @Override // org.threeten.bp.chrono.g, fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f) goto L7;
        return (R) toLocalDate();
    L7:
        return (R) super.query(r5);
    }

    @Override // org.threeten.bp.chrono.g, fv.c, org.threeten.bp.temporal.d
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

    @Override // org.threeten.bp.chrono.g
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b toLocalDate() {
        return toLocalDate();
    }

    @Override // org.threeten.bp.chrono.g
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.c toLocalDateTime() {
        return toLocalDateTime();
    }

    @Override // org.threeten.bp.chrono.g
    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetDateTime toOffsetDateTime() {
        return OffsetDateTime.of(this.dateTime, this.offset);
    }

    public String toString() {
        String r5 = this.dateTime.toString() + this.offset.toString();
        if (this.offset != this.zone) goto L5;
        return r5;
    L5:
        return r5 + '[' + this.zone.toString() + ']';
    }

    public ZonedDateTime truncatedTo(org.threeten.bp.temporal.j r5) {
        return b(this.dateTime.truncatedTo(r5));
    }

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r5, org.threeten.bp.temporal.j r10) {
        ZonedDateTime r11 = from(r5);
        if ((r10 instanceof ChronoUnit) == false) goto L11;
        ZonedDateTime r12 = r11.withZoneSameInstant(this.zone);
        if (r10.isDateBased() == false) goto L9;
        return this.dateTime.until(r12.dateTime, r10);
    L9:
        return toOffsetDateTime().until(r12.toOffsetDateTime(), r10);
    L11:
        return r10.between(this, r11);
    }

    @Override // org.threeten.bp.chrono.g, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.g with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public ZonedDateTime withDayOfMonth(int r5) {
        return b(this.dateTime.withDayOfMonth(r5));
    }

    public ZonedDateTime withDayOfYear(int r5) {
        return b(this.dateTime.withDayOfYear(r5));
    }

    /* JADX INFO: renamed from: withEarlierOffsetAtOverlap, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.g m1667withEarlierOffsetAtOverlap() {
        return withEarlierOffsetAtOverlap();
    }

    public ZonedDateTime withFixedOffsetZone() {
        if (this.zone.equals(this.offset) == true) goto L7;
        LocalDateTime r5 = this.dateTime;
        ZoneOffset r10 = this.offset;
        return new ZonedDateTime(r5, r10, r10);
    L7:
        return this;
    }

    public ZonedDateTime withHour(int r5) {
        return b(this.dateTime.withHour(r5));
    }

    /* JADX INFO: renamed from: withLaterOffsetAtOverlap, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.g m1668withLaterOffsetAtOverlap() {
        return withLaterOffsetAtOverlap();
    }

    public ZonedDateTime withMinute(int r5) {
        return b(this.dateTime.withMinute(r5));
    }

    public ZonedDateTime withMonth(int r5) {
        return b(this.dateTime.withMonth(r5));
    }

    public ZonedDateTime withNano(int r5) {
        return b(this.dateTime.withNano(r5));
    }

    public ZonedDateTime withSecond(int r5) {
        return b(this.dateTime.withSecond(r5));
    }

    public ZonedDateTime withYear(int r5) {
        return b(this.dateTime.withYear(r5));
    }

    @Override // org.threeten.bp.chrono.g
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.g withZoneSameInstant(ZoneId r5) {
        return withZoneSameInstant(r5);
    }

    @Override // org.threeten.bp.chrono.g
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.g withZoneSameLocal(ZoneId r5) {
        return withZoneSameLocal(r5);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        this.dateTime.writeExternal(r5);
        this.offset.writeExternal(r5);
        this.zone.write(r5);
    }

    public static ZonedDateTime now(ZoneId r5) {
        return now(a.system(r5));
    }

    public static ZonedDateTime of(LocalDateTime r5, ZoneId r10) {
        return ofLocal(r5, r10, null);
    }

    public static ZonedDateTime parse(CharSequence r5, org.threeten.bp.format.b r10) {
        jm.c.p(r10, "formatter");
        return (ZonedDateTime) r10.c(r5, FROM);
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

    @Override // org.threeten.bp.chrono.g
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.g minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    @Override // org.threeten.bp.chrono.g
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.g plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.chrono.g
    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    @Override // org.threeten.bp.chrono.g
    public LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.g with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public ZonedDateTime withEarlierOffsetAtOverlap() {
        ZoneOffsetTransition r5 = getZone().getRules().getTransition(this.dateTime);
        if (r5 != null) goto L5;
    L10:
        return this;
    L5:
        if (r5.isOverlap() == false) goto L10;
        ZoneOffset r10 = r5.getOffsetBefore();
        if (r10.equals(this.offset) == true) goto L10;
        return new ZonedDateTime(this.dateTime, r10, this.zone);
    }

    public ZonedDateTime withLaterOffsetAtOverlap() {
        ZoneOffsetTransition r5 = getZone().getRules().getTransition(toLocalDateTime());
        if (r5 == null) goto L8;
        ZoneOffset r10 = r5.getOffsetAfter();
        if (r10.equals(this.offset) == true) goto L8;
        return new ZonedDateTime(this.dateTime, r10, this.zone);
    L8:
        return this;
    }

    @Override // org.threeten.bp.chrono.g
    public ZonedDateTime withZoneSameInstant(ZoneId r5) {
        jm.c.p(r5, "zone");
        if (this.zone.equals(r5) == false) goto L6;
        return this;
    L6:
        return a(this.dateTime.toEpochSecond(this.offset), this.dateTime.getNano(), r5);
    }

    @Override // org.threeten.bp.chrono.g
    public ZonedDateTime withZoneSameLocal(ZoneId r5) {
        jm.c.p(r5, "zone");
        if (this.zone.equals(r5) == false) goto L6;
        return this;
    L6:
        return ofLocal(this.dateTime, r5, this.offset);
    }

    public static ZonedDateTime now(a r5) {
        jm.c.p(r5, "clock");
        return ofInstant(r5.instant(), r5.getZone());
    }

    public static ZonedDateTime of(int r5, int r10, int r11, int r12, int r13, int r14, int r15, ZoneId r16) {
        return ofLocal(LocalDateTime.of(r5, r10, r11, r12, r13, r14, r15), r16, null);
    }

    @Override // org.threeten.bp.chrono.g, fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.g, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public static ZonedDateTime ofInstant(LocalDateTime r5, ZoneOffset r10, ZoneId r11) {
        jm.c.p(r5, "localDateTime");
        jm.c.p(r10, "offset");
        jm.c.p(r11, "zone");
        return a(r5.toEpochSecond(r10), r5.getNano(), r11);
    }

    @Override // org.threeten.bp.chrono.g
    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1665minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    @Override // org.threeten.bp.chrono.g
    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1666plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    @Override // org.threeten.bp.chrono.g
    public ZonedDateTime minus(org.threeten.bp.temporal.f r5) {
        return (ZonedDateTime) r5.subtractFrom(this);
    }

    @Override // org.threeten.bp.chrono.g
    public ZonedDateTime plus(org.threeten.bp.temporal.f r5) {
        return (ZonedDateTime) r5.addTo(this);
    }

    @Override // org.threeten.bp.chrono.g, org.threeten.bp.temporal.c
    public ZonedDateTime with(org.threeten.bp.temporal.e r5) {
        if ((r5 instanceof LocalDate) == false) goto L7;
        return b(LocalDateTime.of((LocalDate) r5, this.dateTime.toLocalTime()));
    L7:
        if ((r5 instanceof LocalTime) == false) goto L11;
        return b(LocalDateTime.of(this.dateTime.toLocalDate(), (LocalTime) r5));
    L11:
        if ((r5 instanceof LocalDateTime) == false) goto L15;
        return b((LocalDateTime) r5);
    L15:
        if ((r5 instanceof Instant) == false) goto L19;
        Instant r10 = (Instant) r5;
        return a(r10.getEpochSecond(), r10.getNano(), this.zone);
    L19:
        if ((r5 instanceof ZoneOffset) == false) goto L23;
        return c((ZoneOffset) r5);
    L23:
        return (ZonedDateTime) r5.adjustInto(this);
    }

    @Override // org.threeten.bp.chrono.g, fv.b, org.threeten.bp.temporal.c
    public ZonedDateTime minus(long r5, org.threeten.bp.temporal.j r10) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plus(Long.MAX_VALUE, r10);
        long r11 = 1;
    L7:
        return this.plus(r11, r10);
    L6:
        r11 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public ZonedDateTime plus(long r5, org.threeten.bp.temporal.j r10) {
        if ((r10 instanceof ChronoUnit) == false) goto L11;
        if (r10.isDateBased() == false) goto L9;
        return b(this.dateTime.plus(r5, r10));
    L9:
        return ofInstant(this.dateTime.plus(r5, r10), this.offset, this.zone);
    L11:
        return (ZonedDateTime) r10.addTo(this, r5);
    }

    @Override // org.threeten.bp.temporal.c
    public ZonedDateTime with(org.threeten.bp.temporal.g r5, long r10) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        ChronoField r11 = (ChronoField) r5;
        int r12 = n.f21272a[r11.ordinal()];
        if (r12 == 1) goto L13;
        if (r12 == 2) goto L11;
        return b(this.dateTime.with(r5, r10));
    L11:
        return c(ZoneOffset.ofTotalSeconds(r11.checkValidIntValue(r10)));
    L13:
        return a(r10, getNano(), this.zone);
    L15:
        return (ZonedDateTime) r5.adjustInto(this, r10);
    }
}
