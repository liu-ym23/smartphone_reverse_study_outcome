package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import kotlin.time.DurationKt;
import okhttp3.internal.http2.Http2Connection;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalTime extends fv.c implements org.threeten.bp.temporal.c, org.threeten.bp.temporal.e, Comparable<LocalTime>, Serializable {
    public static final org.threeten.bp.temporal.i FROM = null;
    static final int HOURS_PER_DAY = 24;
    public static final LocalTime MAX = null;
    static final long MICROS_PER_DAY = 86400000000L;
    public static final LocalTime MIDNIGHT = null;
    static final long MILLIS_PER_DAY = 86400000;
    public static final LocalTime MIN = null;
    static final int MINUTES_PER_DAY = 1440;
    static final int MINUTES_PER_HOUR = 60;
    static final long NANOS_PER_DAY = 86400000000000L;
    static final long NANOS_PER_HOUR = 3600000000000L;
    static final long NANOS_PER_MINUTE = 60000000000L;
    static final long NANOS_PER_SECOND = 1000000000;
    public static final LocalTime NOON = null;
    static final int SECONDS_PER_DAY = 86400;
    static final int SECONDS_PER_HOUR = 3600;
    static final int SECONDS_PER_MINUTE = 60;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalTime[] f21121a = null;
    private static final long serialVersionUID = 6414437269572265201L;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    static {
        FROM = new com.lynx.tasm.behavior.d(14);
        f21121a = new LocalTime[24];
        int r5 = 0;
    L3:
        LocalTime[] r10 = f21121a;
        if (r5 >= r10.length) goto L6;
        r10[r5] = new LocalTime(r5, 0, 0, 0);
        r5 = r5 + 1;
        goto L3
    L6:
        LocalTime r11 = r10[0];
        MIDNIGHT = r11;
        NOON = r10[12];
        MIN = r11;
        MAX = new LocalTime(23, 59, 59, Year.MAX_VALUE);
    }

    public LocalTime(int r5, int r10, int r11, int r12) {
        this.hour = (byte) r5;
        this.minute = (byte) r10;
        this.second = (byte) r11;
        this.nano = r12;
    }

    public static LocalTime a(int r5, int r10, int r11, int r12) {
        if (((r10 | r11) | r12) != 0) goto L7;
        return f21121a[r5];
    L7:
        return new LocalTime(r5, r10, r11, r12);
    }

    public static LocalTime from(org.threeten.bp.temporal.d r5) {
        LocalTime r10 = (LocalTime) r5.query(org.threeten.bp.temporal.h.g);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    }

    public static LocalTime now() {
        return now(a.systemDefaultZone());
    }

    public static LocalTime of(int r5, int r10) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r5);
        if (r10 == 0) goto L5;
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r10);
        return new LocalTime(r5, r10, 0, 0);
    L5:
        return f21121a[r5];
    }

    public static LocalTime ofNanoOfDay(long r10) {
        ChronoField.NANO_OF_DAY.checkValidValue(r10);
        int r5 = (int) (r10 / NANOS_PER_HOUR);
        long r11 = r10 - (((long) r5) * NANOS_PER_HOUR);
        int r12 = (int) (r11 / NANOS_PER_MINUTE);
        long r13 = r11 - (((long) r12) * NANOS_PER_MINUTE);
        int r14 = (int) (r13 / NANOS_PER_SECOND);
        return a(r5, r12, r14, (int) (r13 - (((long) r14) * NANOS_PER_SECOND)));
    }

    public static LocalTime ofSecondOfDay(long r5) {
        ChronoField.SECOND_OF_DAY.checkValidValue(r5);
        int r10 = (int) (r5 / 3600);
        long r11 = r5 - ((long) (r10 * SECONDS_PER_HOUR));
        int r12 = (int) (r11 / 60);
        return a(r10, r12, (int) (r11 - ((long) (r12 * 60))), 0);
    }

    public static LocalTime parse(CharSequence r5) {
        return parse(r5, org.threeten.bp.format.b.g);
    }

    public static LocalTime readExternal(DataInput r5) throws IOException {
        int r10 = r5.readByte();
        int r11 = 0;
        if (r10 >= 0) goto L5;
        r10 = ~r10;
        int r12 = 0;
        int r13 = 0;
    L14:
        return of(r10, r11, r12, r13);
    L5:
        byte r14 = r5.readByte();
        if (r14 >= 0) goto L8;
        int r15 = ~r14;
        r13 = 0;
        r11 = r15;
        r12 = 0;
        goto L14
    L8:
        byte r16 = r5.readByte();
        if (r16 >= 0) goto L12;
        r12 = ~r16;
    L11:
        r13 = r11;
        r11 = r14;
        goto L14
    L12:
        r11 = r5.readInt();
        r12 = r16;
        goto L11
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return r5.with(ChronoField.NANO_OF_DAY, toNanoOfDay());
    }

    public LocalDateTime atDate(LocalDate r5) {
        return LocalDateTime.of(r5, this);
    }

    public OffsetTime atOffset(ZoneOffset r5) {
        return OffsetTime.of(this, r5);
    }

    public final int b(org.threeten.bp.temporal.g r5) {
        switch(f.f21187a[((ChronoField) r5).ordinal()]) {
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            case 6: goto L30;
            case 7: goto L28;
            case 8: goto L26;
            case 9: goto L24;
            case 10: goto L22;
            case 11: goto L20;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L8;
            case 15: goto L7;
            default: goto L5;
        };
    L8:
        byte r10 = this.hour;
        if (r10 != 0) goto L41;
        return 24;
    L41:
        return r10;
    L14:
        int r11 = this.hour % 12;
        if ((r11 % 12) != 0) goto L18;
        return 12;
    L18:
        return r11;
    L5:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L7:
        return this.hour / 12;
    L13:
        return this.hour;
    L20:
        return this.hour % 12;
    L22:
        return (this.hour * 60) + this.minute;
    L24:
        return this.minute;
    L26:
        return toSecondOfDay();
    L28:
        return this.second;
    L30:
        return (int) (toNanoOfDay() / 1000000);
    L32:
        return this.nano / DurationKt.NANOS_IN_MILLIS;
    L34:
        throw new DateTimeException(kotlin.collections.a.h("Field too large for an int: ", r5));
    L36:
        return this.nano / 1000;
    L38:
        throw new DateTimeException(kotlin.collections.a.h("Field too large for an int: ", r5));
    L40:
        return this.nano;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(LocalTime r5) {
        return compareTo2(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LocalTime) == false) goto L18;
        LocalTime r10 = (LocalTime) r5;
        if (this.hour != r10.hour) goto L17;
        if (this.minute != r10.minute) goto L17;
        if (this.second != r10.second) goto L17;
        if (this.nano != r10.nano) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public String format(org.threeten.bp.format.b r5) {
        jm.c.p(r5, "formatter");
        return r5.a(this);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L7;
        return b(r5);
    L7:
        return super.get(r5);
    }

    public int getHour() {
        return this.hour;
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        if (r5 != ChronoField.NANO_OF_DAY) goto L9;
        return toNanoOfDay();
    L9:
        if (r5 != ChronoField.MICRO_OF_DAY) goto L13;
        return toNanoOfDay() / 1000;
    L13:
        return b(r5);
    L15:
        return r5.getFrom(this);
    }

    public int getMinute() {
        return this.minute;
    }

    public int getNano() {
        return this.nano;
    }

    public int getSecond() {
        return this.second;
    }

    public int hashCode() {
        long r5 = toNanoOfDay();
        return (int) (r5 ^ (r5 >>> 32));
    }

    public boolean isAfter(LocalTime r5) {
        if (compareTo2(r5) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(LocalTime r5) {
        if (compareTo2(r5) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == true) goto L5;
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
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    public LocalTime minusHours(long r5) {
        return plusHours(-(r5 % 24));
    }

    public LocalTime minusMinutes(long r5) {
        return plusMinutes(-(r5 % 1440));
    }

    public LocalTime minusNanos(long r5) {
        return plusNanos(-(r5 % NANOS_PER_DAY));
    }

    public LocalTime minusSeconds(long r5) {
        return plusSeconds(-(r5 % 86400));
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    public LocalTime plusHours(long r5) {
        if (r5 != 0) goto L6;
        return this;
    L6:
        return a(((((int) (r5 % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime plusMinutes(long r5) {
        if (r5 != 0) goto L5;
        return this;
    L5:
        int r10 = (this.hour * 60) + this.minute;
        int r11 = ((((int) (r5 % 1440)) + r10) + MINUTES_PER_DAY) % MINUTES_PER_DAY;
        if (r10 != r11) goto L9;
        return this;
    L9:
        return a(r11 / 60, r11 % 60, this.second, this.nano);
    }

    public LocalTime plusNanos(long r10) {
        if (r10 != 0) goto L5;
        return this;
    L5:
        long r5 = toNanoOfDay();
        long r11 = (((r10 % NANOS_PER_DAY) + r5) + NANOS_PER_DAY) % NANOS_PER_DAY;
        if (r5 != r11) goto L9;
        return this;
    L9:
        return a((int) (r11 / NANOS_PER_HOUR), (int) ((r11 / NANOS_PER_MINUTE) % 60), (int) ((r11 / NANOS_PER_SECOND) % 60), (int) (r11 % NANOS_PER_SECOND));
    }

    public LocalTime plusSeconds(long r5) {
        if (r5 != 0) goto L5;
        return this;
    L5:
        int r10 = this.hour * 3600;
        int r11 = ((this.minute * 60) + r10) + this.second;
        int r12 = ((((int) (r5 % 86400)) + r11) + SECONDS_PER_DAY) % SECONDS_PER_DAY;
        if (r11 != r12) goto L9;
        return this;
    L9:
        return a(r12 / SECONDS_PER_HOUR, (r12 / 60) % 60, r12 % 60, this.nano);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L7;
        return (R) ChronoUnit.NANOS;
    L7:
        if (r5 != org.threeten.bp.temporal.h.g) goto L10;
        return this;
    L10:
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L12;
        return null;
    L12:
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L14;
        return null;
    L14:
        if (r5 != org.threeten.bp.temporal.h.d) goto L16;
        return null;
    L16:
        if (r5 != org.threeten.bp.temporal.h.e) goto L18;
        return null;
    L18:
        if (r5 != org.threeten.bp.temporal.h.f) goto L21;
        return null;
    L21:
        return (R) r5.d(this);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        return super.range(r5);
    }

    public long toNanoOfDay() {
        long r5 = ((long) this.hour) * NANOS_PER_HOUR;
        long r10 = (((long) this.minute) * NANOS_PER_MINUTE) + r5;
        return ((((long) this.second) * NANOS_PER_SECOND) + r10) + ((long) this.nano);
    }

    public int toSecondOfDay() {
        int r5 = this.hour * 3600;
        return ((this.minute * 60) + r5) + this.second;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder(18);
        byte r10 = this.hour;
        byte r11 = this.minute;
        byte r12 = this.second;
        int r13 = this.nano;
        if (r10 >= 10) goto L5;
        String r14 = "0";
    L6:
        r5.append(r14);
        r5.append(r10);
        String r15 = ":";
        if (r11 >= 10) goto L9;
        String r16 = ":0";
    L10:
        r5.append(r16);
        r5.append(r11);
        if (r12 > 0) goto L13;
        if (r13 > 0) goto L13;
    L25:
        return r5.toString();
    L13:
        if (r12 >= 10) goto L15;
        r15 = ":0";
    L15:
        r5.append(r15);
        r5.append(r12);
        if (r13 <= 0) goto L25;
        r5.append('.');
        if ((r13 % DurationKt.NANOS_IN_MILLIS) != 0) goto L21;
        r5.append(Integer.toString((r13 / DurationKt.NANOS_IN_MILLIS) + 1000).substring(1));
        goto L25
    L21:
        if ((r13 % 1000) != 0) goto L23;
        r5.append(Integer.toString((r13 / 1000) + DurationKt.NANOS_IN_MILLIS).substring(1));
        goto L25
    L23:
        r5.append(Integer.toString(r13 + Http2Connection.DEGRADED_PONG_TIMEOUT_NS).substring(1));
        goto L25
    L9:
        r16 = ":";
        goto L10
    L5:
        r14 = "";
        goto L6
    }

    public LocalTime truncatedTo(org.threeten.bp.temporal.j r10) {
        if (r10 != ChronoUnit.NANOS) goto L5;
        return this;
    L5:
        Duration r11 = r10.getDuration();
        if (r11.getSeconds() > 86400) goto L14;
        long r5 = r11.toNanos();
        if ((NANOS_PER_DAY % r5) != 0) goto L12;
        return ofNanoOfDay((toNanoOfDay() / r5) * r5);
    L12:
        throw new DateTimeException("Unit must divide into a standard day without remainder");
    L14:
        throw new DateTimeException("Unit is too large to be used for truncation");
    }

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r5, org.threeten.bp.temporal.j r10) {
        LocalTime r11 = from(r5);
        if ((r10 instanceof ChronoUnit) == false) goto L21;
        long r12 = r11.toNanoOfDay() - toNanoOfDay();
        switch(f.f21188b[((ChronoUnit) r10).ordinal()]) {
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
        return r12 / NANOS_PER_HOUR;
    L13:
        return r12 / NANOS_PER_MINUTE;
    L15:
        return r12 / NANOS_PER_SECOND;
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

    public LocalTime withHour(int r5) {
        if (this.hour != r5) goto L5;
        return this;
    L5:
        ChronoField.HOUR_OF_DAY.checkValidValue(r5);
        return a(r5, this.minute, this.second, this.nano);
    }

    public LocalTime withMinute(int r5) {
        if (this.minute != r5) goto L5;
        return this;
    L5:
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r5);
        return a(this.hour, r5, this.second, this.nano);
    }

    public LocalTime withNano(int r5) {
        if (this.nano != r5) goto L5;
        return this;
    L5:
        ChronoField.NANO_OF_SECOND.checkValidValue(r5);
        return a(this.hour, this.minute, this.second, r5);
    }

    public LocalTime withSecond(int r5) {
        if (this.second != r5) goto L5;
        return this;
    L5:
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r5);
        return a(this.hour, this.minute, r5, this.nano);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        if (this.nano == 0) goto L5;
        r5.writeByte(this.hour);
        r5.writeByte(this.minute);
        r5.writeByte(this.second);
        r5.writeInt(this.nano);
        return;
    L5:
        if (this.second == 0) goto L7;
        r5.writeByte(this.hour);
        r5.writeByte(this.minute);
        r5.writeByte(~this.second);
        return;
    L7:
        if (this.minute != 0) goto L9;
        r5.writeByte(~this.hour);
        return;
    L9:
        r5.writeByte(this.hour);
        r5.writeByte(~this.minute);
    }

    public static LocalTime now(ZoneId r5) {
        return now(a.system(r5));
    }

    public static LocalTime parse(CharSequence r5, org.threeten.bp.format.b r10) {
        jm.c.p(r10, "formatter");
        return (LocalTime) r10.c(r5, FROM);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(LocalTime r10) {
        byte r5 = this.hour;
        byte r11 = r10.hour;
        int r12 = 0;
        if (r5 >= r11) goto L5;
        int r13 = -1;
    L8:
        if (r13 != 0) goto L30;
        byte r14 = this.minute;
        byte r15 = r10.minute;
        if (r14 >= r15) goto L12;
        int r16 = -1;
    L15:
        if (r16 != 0) goto L31;
        byte r17 = this.second;
        byte r18 = r10.second;
        if (r17 >= r18) goto L19;
        int r19 = -1;
    L22:
        if (r19 != 0) goto L32;
        int r20 = this.nano;
        int r21 = r10.nano;
        if (r20 >= r21) goto L26;
        r12 = -1;
    L29:
        return r12;
    L26:
        if (r20 <= r21) goto L29;
        r12 = 1;
        goto L29
    L32:
        return r19;
    L19:
        if (r17 <= r18) goto L21;
        r19 = 1;
        goto L22
    L21:
        r19 = 0;
        goto L22
    L31:
        return r16;
    L12:
        if (r14 <= r15) goto L14;
        r16 = 1;
        goto L15
    L14:
        r16 = 0;
        goto L15
    L30:
        return r13;
    L5:
        if (r5 <= r11) goto L7;
        r13 = 1;
        goto L8
    L7:
        r13 = 0;
        goto L8
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1652minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1653plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public static LocalTime now(a r10) {
        jm.c.p(r10, "clock");
        Instant r5 = r10.instant();
        ZoneOffset r11 = r10.getZone().getRules().getOffset(r5);
        long r12 = ((r5.getEpochSecond() % 86400) + ((long) r11.getTotalSeconds())) % 86400;
        if (r12 >= 0) goto L6;
        r12 = r12 + 86400;
    L6:
        return ofSecondOfDay(r12, r5.getNano());
    }

    public LocalTime minus(org.threeten.bp.temporal.f r5) {
        return (LocalTime) r5.subtractFrom(this);
    }

    public LocalTime plus(org.threeten.bp.temporal.f r5) {
        return (LocalTime) r5.addTo(this);
    }

    @Override // org.threeten.bp.temporal.c
    public LocalTime with(org.threeten.bp.temporal.e r5) {
        if ((r5 instanceof LocalTime) == false) goto L7;
        return (LocalTime) r5;
    L7:
        return (LocalTime) r5.adjustInto(this);
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
    public LocalTime minus(long r5, org.threeten.bp.temporal.j r10) {
        if (r5 != Long.MIN_VALUE) goto L6;
        LocalTime this = plus(Long.MAX_VALUE, r10);
        long r11 = 1;
    L7:
        return this.plus(r11, r10);
    L6:
        r11 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public LocalTime plus(long r5, org.threeten.bp.temporal.j r10) {
        if ((r10 instanceof ChronoUnit) == false) goto L23;
        switch(f.f21188b[((ChronoUnit) r10).ordinal()]) {
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
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    L9:
        return plusHours((r5 % 2) * 12);
    L11:
        return plusHours(r5);
    L13:
        return plusMinutes(r5);
    L15:
        return plusSeconds(r5);
    L17:
        return plusNanos((r5 % 86400000) * 1000000);
    L19:
        return plusNanos((r5 % MICROS_PER_DAY) * 1000);
    L21:
        return plusNanos(r5);
    L23:
        return (LocalTime) r10.addTo(this, r5);
    }

    public static LocalTime of(int r5, int r10, int r11) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r5);
        if ((r10 | r11) == 0) goto L5;
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r10);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r11);
        return new LocalTime(r5, r10, r11, 0);
    L5:
        return f21121a[r5];
    }

    public static LocalTime ofSecondOfDay(long r5, int r10) {
        ChronoField.SECOND_OF_DAY.checkValidValue(r5);
        ChronoField.NANO_OF_SECOND.checkValidValue(r10);
        int r11 = (int) (r5 / 3600);
        long r12 = r5 - ((long) (r11 * SECONDS_PER_HOUR));
        int r13 = (int) (r12 / 60);
        return a(r11, r13, (int) (r12 - ((long) (r13 * 60))), r10);
    }

    @Override // org.threeten.bp.temporal.c
    public LocalTime with(org.threeten.bp.temporal.g r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L45;
        ChronoField r5 = (ChronoField) r10;
        r5.checkValidValue(r11);
        switch(f.f21187a[r5.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L18;
            case 13: goto L16;
            case 14: goto L11;
            case 15: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r10));
    L9:
        return plusHours((r11 - ((long) (this.hour / 12))) * 12);
    L11:
        if (r11 != 24) goto L14;
        r11 = 0;
    L14:
        return withHour((int) r11);
    L16:
        return withHour((int) r11);
    L18:
        if (r11 != 12) goto L21;
        r11 = 0;
    L21:
        return plusHours(r11 - ((long) (this.hour % 12)));
    L23:
        return plusHours(r11 - ((long) (this.hour % 12)));
    L25:
        return plusMinutes(r11 - ((long) ((this.hour * 60) + this.minute)));
    L27:
        return withMinute((int) r11);
    L29:
        return plusSeconds(r11 - ((long) toSecondOfDay()));
    L31:
        return withSecond((int) r11);
    L33:
        return ofNanoOfDay(r11 * 1000000);
    L35:
        return withNano(((int) r11) * DurationKt.NANOS_IN_MILLIS);
    L37:
        return ofNanoOfDay(r11 * 1000);
    L39:
        return withNano(((int) r11) * 1000);
    L41:
        return ofNanoOfDay(r11);
    L43:
        return withNano((int) r11);
    L45:
        return (LocalTime) r10.adjustInto(this, r11);
    }

    public static LocalTime of(int r5, int r10, int r11, int r12) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r5);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r10);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r11);
        ChronoField.NANO_OF_SECOND.checkValidValue(r12);
        return a(r5, r10, r11, r12);
    }
}
