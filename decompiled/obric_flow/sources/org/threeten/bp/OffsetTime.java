package org.threeten.bp;

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
public final class OffsetTime extends fv.c implements org.threeten.bp.temporal.c, org.threeten.bp.temporal.e, Comparable<OffsetTime>, Serializable {
    public static final org.threeten.bp.temporal.i FROM = null;
    public static final OffsetTime MAX = null;
    public static final OffsetTime MIN = null;
    private static final long serialVersionUID = 7264499704384272492L;
    private final ZoneOffset offset;
    private final LocalTime time;

    static {
        MIN = LocalTime.MIN.atOffset(ZoneOffset.MAX);
        MAX = LocalTime.MAX.atOffset(ZoneOffset.MIN);
        FROM = new m.b(14);
    }

    public OffsetTime(LocalTime r5, ZoneOffset r10) {
        jm.c.p(r5, "time");
        this.time = r5;
        jm.c.p(r10, "offset");
        this.offset = r10;
    }

    public static OffsetTime from(org.threeten.bp.temporal.d r5) {
        if ((r5 instanceof OffsetTime) == true) goto L5;
        return new OffsetTime(LocalTime.from(r5), ZoneOffset.from(r5));
    L9:
        throw new DateTimeException("Unable to obtain OffsetTime from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    L5:
        return (OffsetTime) r5;
    }

    public static OffsetTime now() {
        return now(a.systemDefaultZone());
    }

    public static OffsetTime of(LocalTime r5, ZoneOffset r10) {
        return new OffsetTime(r5, r10);
    }

    public static OffsetTime ofInstant(Instant r10, ZoneId r11) {
        jm.c.p(r10, "instant");
        jm.c.p(r11, "zone");
        ZoneOffset r12 = r11.getRules().getOffset(r10);
        long r5 = ((r10.getEpochSecond() % 86400) + ((long) r12.getTotalSeconds())) % 86400;
        if (r5 >= 0) goto L6;
        r5 = r5 + 86400;
    L6:
        return new OffsetTime(LocalTime.ofSecondOfDay(r5, r10.getNano()), r12);
    }

    public static OffsetTime parse(CharSequence r5) {
        return parse(r5, org.threeten.bp.format.b.f21199h);
    }

    public static OffsetTime readExternal(DataInput r5) throws IOException {
        return of(LocalTime.readExternal(r5), ZoneOffset.readExternal(r5));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 66, this);
    }

    public final long a() {
        return this.time.toNanoOfDay() - (((long) this.offset.getTotalSeconds()) * 1000000000);
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return r5.with(ChronoField.NANO_OF_DAY, this.time.toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, getOffset().getTotalSeconds());
    }

    public OffsetDateTime atDate(LocalDate r5) {
        return OffsetDateTime.of(r5, this.time, this.offset);
    }

    public final OffsetTime b(LocalTime r5, ZoneOffset r10) {
        if (this.time != r5) goto L8;
        if (this.offset.equals(r10) == false) goto L8;
        return this;
    L8:
        return new OffsetTime(r5, r10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(OffsetTime r5) {
        return compareTo2(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OffsetTime) == false) goto L14;
        OffsetTime r10 = (OffsetTime) r5;
        if (this.time.equals(r10.time) == false) goto L13;
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
        return super.get(r5);
    }

    public int getHour() {
        return this.time.getHour();
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L11;
        if (r5 != ChronoField.OFFSET_SECONDS) goto L9;
        return getOffset().getTotalSeconds();
    L9:
        return this.time.getLong(r5);
    L11:
        return r5.getFrom(this);
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public int getNano() {
        return this.time.getNano();
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int hashCode() {
        int r5 = this.time.hashCode();
        return this.offset.hashCode() ^ r5;
    }

    public boolean isAfter(OffsetTime r5) {
        if (a() <= r5.a()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(OffsetTime r5) {
        if (a() >= r5.a()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEqual(OffsetTime r5) {
        if (a() != r5.a()) goto L5;
        return true;
    L5:
        return false;
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
        if (r5.isTimeBased() == false) goto L7;
        return true;
    L7:
        if (r5 != ChronoField.OFFSET_SECONDS) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    public OffsetTime minusHours(long r5) {
        return b(this.time.minusHours(r5), this.offset);
    }

    public OffsetTime minusMinutes(long r5) {
        return b(this.time.minusMinutes(r5), this.offset);
    }

    public OffsetTime minusNanos(long r5) {
        return b(this.time.minusNanos(r5), this.offset);
    }

    public OffsetTime minusSeconds(long r5) {
        return b(this.time.minusSeconds(r5), this.offset);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    public OffsetTime plusHours(long r5) {
        return b(this.time.plusHours(r5), this.offset);
    }

    public OffsetTime plusMinutes(long r5) {
        return b(this.time.plusMinutes(r5), this.offset);
    }

    public OffsetTime plusNanos(long r5) {
        return b(this.time.plusNanos(r5), this.offset);
    }

    public OffsetTime plusSeconds(long r5) {
        return b(this.time.plusSeconds(r5), this.offset);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L7;
        return (R) ChronoUnit.NANOS;
    L7:
        if (r5 == org.threeten.bp.temporal.h.e) goto L27;
        if (r5 == org.threeten.bp.temporal.h.d) goto L27;
        if (r5 != org.threeten.bp.temporal.h.g) goto L16;
        return (R) this.time;
    L16:
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L18;
        return null;
    L18:
        if (r5 != org.threeten.bp.temporal.h.f) goto L20;
        return null;
    L20:
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L23;
        return null;
    L23:
        return (R) super.query(r5);
    L27:
        return (R) getOffset();
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L11;
        if (r5 != ChronoField.OFFSET_SECONDS) goto L9;
        return r5.range();
    L9:
        return this.time.range(r5);
    L11:
        return r5.rangeRefinedBy(this);
    }

    public LocalTime toLocalTime() {
        return this.time;
    }

    public String toString() {
        return this.time.toString() + this.offset.toString();
    }

    public OffsetTime truncatedTo(org.threeten.bp.temporal.j r5) {
        return b(this.time.truncatedTo(r5), this.offset);
    }

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r5, org.threeten.bp.temporal.j r10) {
        OffsetTime r11 = from(r5);
        if ((r10 instanceof ChronoUnit) == false) goto L21;
        long r12 = r11.a() - a();
        switch(j.f21265a[((ChronoUnit) r10).ordinal()]) {
            case 1: goto L22;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L22:
        return r12;
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    L9:
        return r12 / 43200000000000L;
    L11:
        return r12 / 3600000000000L;
    L13:
        return r12 / 60000000000L;
    L15:
        return r12 / 1000000000;
    L17:
        return r12 / 1000000;
    L19:
        return r12 / 1000;
    L21:
        return r10.between(this, r11);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public OffsetTime withHour(int r5) {
        return b(this.time.withHour(r5), this.offset);
    }

    public OffsetTime withMinute(int r5) {
        return b(this.time.withMinute(r5), this.offset);
    }

    public OffsetTime withNano(int r5) {
        return b(this.time.withNano(r5), this.offset);
    }

    public OffsetTime withOffsetSameInstant(ZoneOffset r5) {
        if (r5.equals(this.offset) == false) goto L6;
        return this;
    L6:
        return new OffsetTime(this.time.plusSeconds(r5.getTotalSeconds() - this.offset.getTotalSeconds()), r5);
    }

    public OffsetTime withOffsetSameLocal(ZoneOffset r5) {
        if (r5 == null) goto L7;
        if (r5.equals(this.offset) == false) goto L7;
        return this;
    L7:
        return new OffsetTime(this.time, r5);
    }

    public OffsetTime withSecond(int r5) {
        return b(this.time.withSecond(r5), this.offset);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        this.time.writeExternal(r5);
        this.offset.writeExternal(r5);
    }

    public static OffsetTime now(ZoneId r5) {
        return now(a.system(r5));
    }

    public static OffsetTime of(int r5, int r10, int r11, int r12, ZoneOffset r13) {
        return new OffsetTime(LocalTime.of(r5, r10, r11, r12), r13);
    }

    public static OffsetTime parse(CharSequence r5, org.threeten.bp.format.b r10) {
        jm.c.p(r10, "formatter");
        return (OffsetTime) r10.c(r5, FROM);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(OffsetTime r5) {
        if (this.offset.equals(r5.offset) == true) goto L5;
        int r10 = jm.c.j(a(), r5.a());
        if (r10 == 0) goto L9;
        return r10;
    L9:
        return this.time.compareTo2(r5.time);
    L5:
        return this.time.compareTo2(r5.time);
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1656minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1657plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public static OffsetTime now(a r5) {
        jm.c.p(r5, "clock");
        Instant r10 = r5.instant();
        return ofInstant(r10, r5.getZone().getRules().getOffset(r10));
    }

    public OffsetTime minus(org.threeten.bp.temporal.f r5) {
        return (OffsetTime) r5.subtractFrom(this);
    }

    public OffsetTime plus(org.threeten.bp.temporal.f r5) {
        return (OffsetTime) r5.addTo(this);
    }

    @Override // org.threeten.bp.temporal.c
    public OffsetTime with(org.threeten.bp.temporal.e r5) {
        if ((r5 instanceof LocalTime) == false) goto L7;
        return b((LocalTime) r5, this.offset);
    L7:
        if ((r5 instanceof ZoneOffset) == false) goto L11;
        return b(this.time, (ZoneOffset) r5);
    L11:
        if ((r5 instanceof OffsetTime) == false) goto L15;
        return (OffsetTime) r5;
    L15:
        return (OffsetTime) r5.adjustInto(this);
    }

    public boolean isSupported(org.threeten.bp.temporal.j r5) {
        if ((r5 instanceof ChronoUnit) == true) goto L5;
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r5.isTimeBased();
    }

    @Override // org.threeten.bp.temporal.c
    public OffsetTime minus(long r5, org.threeten.bp.temporal.j r10) {
        if (r5 != Long.MIN_VALUE) goto L6;
        OffsetTime this = plus(Long.MAX_VALUE, r10);
        long r11 = 1;
    L7:
        return this.plus(r11, r10);
    L6:
        r11 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public OffsetTime plus(long r5, org.threeten.bp.temporal.j r10) {
        if ((r10 instanceof ChronoUnit) == false) goto L7;
        return b(this.time.plus(r5, r10), this.offset);
    L7:
        return (OffsetTime) r10.addTo(this, r5);
    }

    @Override // org.threeten.bp.temporal.c
    public OffsetTime with(org.threeten.bp.temporal.g r5, long r10) {
        if ((r5 instanceof ChronoField) == false) goto L11;
        if (r5 != ChronoField.OFFSET_SECONDS) goto L9;
        return b(this.time, ZoneOffset.ofTotalSeconds(((ChronoField) r5).checkValidIntValue(r10)));
    L9:
        return b(this.time.with(r5, r10), this.offset);
    L11:
        return (OffsetTime) r5.adjustInto(this, r10);
    }
}
