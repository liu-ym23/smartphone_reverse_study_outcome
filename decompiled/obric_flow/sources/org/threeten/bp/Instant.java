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
public final class Instant extends fv.c implements org.threeten.bp.temporal.c, org.threeten.bp.temporal.e, Comparable<Instant>, Serializable {
    public static final Instant EPOCH = null;
    public static final org.threeten.bp.temporal.i FROM = null;
    public static final Instant MAX = null;
    public static final Instant MIN = null;
    private static final long serialVersionUID = -665713676816604388L;
    private final int nanos;
    private final long seconds;

    static {
        EPOCH = new Instant(0, 0);
        MIN = ofEpochSecond(-31557014167219200L, 0);
        MAX = ofEpochSecond(31556889864403199L, 999999999);
        FROM = new com.bytedance.frameworks.baselib.network.http.cronet.b(14);
    }

    public Instant(int r5, long r10) {
        this.seconds = r10;
        this.nanos = r5;
    }

    public static Instant a(int r5, long r10) {
        if ((((long) r5) | r10) != 0) goto L7;
        return EPOCH;
    L7:
        if (r10 < (-31557014167219200L)) goto L13;
        if (r10 > 31556889864403199L) goto L13;
        return new Instant(r5, r10);
    L13:
        throw new DateTimeException("Instant exceeds minimum or maximum instant");
    }

    public static Instant from(org.threeten.bp.temporal.d r5) {
        return ofEpochSecond(r5.getLong(ChronoField.INSTANT_SECONDS), r5.get(ChronoField.NANO_OF_SECOND));
    L4:
        e = move-exception;
        throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName(), e);
    }

    public static Instant now() {
        return a.systemUTC().instant();
    }

    public static Instant ofEpochMilli(long r5) {
        long r10 = jm.c.l(r5, 1000);
        return a(jm.c.n(1000, r5) * DurationKt.NANOS_IN_MILLIS, r10);
    }

    public static Instant ofEpochSecond(long r5) {
        return a(0, r5);
    }

    public static Instant parse(CharSequence r5) {
        return (Instant) org.threeten.bp.format.b.f21203l.c(r5, FROM);
    }

    public static Instant readExternal(DataInput r5) throws IOException {
        return ofEpochSecond(r5.readLong(), r5.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return r5.with(ChronoField.INSTANT_SECONDS, this.seconds).with(ChronoField.NANO_OF_SECOND, this.nanos);
    }

    public OffsetDateTime atOffset(ZoneOffset r5) {
        return OffsetDateTime.ofInstant(this, r5);
    }

    public ZonedDateTime atZone(ZoneId r5) {
        return ZonedDateTime.ofInstant(this, r5);
    }

    public final Instant b(long r5, long r10) {
        if ((r5 | r10) != 0) goto L6;
        return this;
    L6:
        return ofEpochSecond(jm.c.r(jm.c.r(this.seconds, r5), r10 / 1000000000), this.nanos + (r10 % 1000000000));
    }

    public final long c(Instant r10) {
        long r5 = jm.c.w(r10.seconds, this.seconds);
        long r11 = r10.nanos - this.nanos;
        if (r5 > 0) goto L5;
    L7:
        if (r5 < 0) goto L9;
        return r5;
    L9:
        if (r11 > 0) goto L11;
        return r5;
    L11:
        return r5 + 1;
    L5:
        if (r11 >= 0) goto L7;
        return r5 - 1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Instant r5) {
        return compareTo2(r5);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Instant) == false) goto L14;
        Instant r11 = (Instant) r10;
        if (this.seconds != r11.seconds) goto L13;
        if (this.nanos != r11.nanos) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L19;
        int r10 = c.f21136a[((ChronoField) r5).ordinal()];
        if (r10 == 1) goto L17;
        if (r10 == 2) goto L15;
        if (r10 != 3) goto L13;
        return this.nanos / DurationKt.NANOS_IN_MILLIS;
    L13:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L15:
        return this.nanos / 1000;
    L17:
        return this.nanos;
    L19:
        return range(r5).checkValidIntValue(r5.getFrom(this), r5);
    }

    public long getEpochSecond() {
        return this.seconds;
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L22;
        int r10 = c.f21136a[((ChronoField) r5).ordinal()];
        if (r10 != 1) goto L7;
        int r11 = this.nanos;
    L18:
        return r11;
    L7:
        if (r10 != 2) goto L9;
        r11 = this.nanos / 1000;
        goto L18
    L9:
        if (r10 != 3) goto L11;
        r11 = this.nanos / DurationKt.NANOS_IN_MILLIS;
        goto L18
    L11:
        if (r10 != 4) goto L15;
        return this.seconds;
    L15:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L22:
        return r5.getFrom(this);
    }

    public int getNano() {
        return this.nanos;
    }

    public int hashCode() {
        long r5 = this.seconds;
        int r10 = this.nanos * 51;
        return r10 + ((int) (r5 ^ (r5 >>> 32)));
    }

    public boolean isAfter(Instant r5) {
        if (compareTo2(r5) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(Instant r5) {
        if (compareTo2(r5) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == true) goto L5;
        if (r5 == null) goto L20;
        if (r5.isSupportedBy(this) == false) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (r5 != ChronoField.INSTANT_SECONDS) goto L7;
        return true;
    L7:
        if (r5 != ChronoField.NANO_OF_SECOND) goto L9;
        return true;
    L9:
        if (r5 != ChronoField.MICRO_OF_SECOND) goto L11;
        return true;
    L11:
        if (r5 != ChronoField.MILLI_OF_SECOND) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    public Instant minusMillis(long r5) {
        if (r5 != Long.MIN_VALUE) goto L7;
        return plusMillis(Long.MAX_VALUE).plusMillis(1);
    L7:
        return plusMillis(-r5);
    }

    public Instant minusNanos(long r5) {
        if (r5 != Long.MIN_VALUE) goto L7;
        return plusNanos(Long.MAX_VALUE).plusNanos(1);
    L7:
        return plusNanos(-r5);
    }

    public Instant minusSeconds(long r5) {
        if (r5 != Long.MIN_VALUE) goto L7;
        return plusSeconds(Long.MAX_VALUE).plusSeconds(1);
    L7:
        return plusSeconds(-r5);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    public Instant plusMillis(long r5) {
        return b(r5 / 1000, (r5 % 1000) * 1000000);
    }

    public Instant plusNanos(long r5) {
        return b(0, r5);
    }

    public Instant plusSeconds(long r5) {
        return b(r5, 0);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L7;
        return (R) ChronoUnit.NANOS;
    L7:
        if (r5 != org.threeten.bp.temporal.h.f) goto L9;
        return null;
    L9:
        if (r5 != org.threeten.bp.temporal.h.g) goto L11;
        return null;
    L11:
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L13;
        return null;
    L13:
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L15;
        return null;
    L15:
        if (r5 != org.threeten.bp.temporal.h.d) goto L17;
        return null;
    L17:
        if (r5 != org.threeten.bp.temporal.h.e) goto L20;
        return null;
    L20:
        return (R) r5.d(this);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        return super.range(r5);
    }

    public long toEpochMilli() {
        long r5 = this.seconds;
        if (r5 < 0) goto L7;
        return jm.c.r(jm.c.u(r5, 1000), this.nanos / DurationKt.NANOS_IN_MILLIS);
    L7:
        return jm.c.w(jm.c.u(r5 + 1, 1000), 1000 - ((long) (this.nanos / DurationKt.NANOS_IN_MILLIS)));
    }

    public String toString() {
        return org.threeten.bp.format.b.f21203l.a(this);
    }

    public Instant truncatedTo(org.threeten.bp.temporal.j r10) {
        if (r10 != ChronoUnit.NANOS) goto L5;
        return this;
    L5:
        Duration r11 = r10.getDuration();
        if (r11.getSeconds() > 86400) goto L14;
        long r5 = r11.toNanos();
        if ((86400000000000L % r5) != 0) goto L12;
        long r12 = ((this.seconds % 86400) * 1000000000) + ((long) this.nanos);
        return plusNanos((jm.c.l(r12, r5) * r5) - r12);
    L12:
        throw new DateTimeException("Unit must divide into a standard day without remainder");
    L14:
        throw new DateTimeException("Unit is too large to be used for truncation");
    }

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r10, org.threeten.bp.temporal.j r11) {
        Instant r12 = from(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L25;
        switch(c.f21137b[((ChronoUnit) r11).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r11);
    L9:
        return c(r12) / 86400;
    L11:
        return c(r12) / 43200;
    L13:
        return c(r12) / 3600;
    L15:
        return c(r12) / 60;
    L17:
        return c(r12);
    L19:
        return jm.c.w(r12.toEpochMilli(), toEpochMilli());
    L21:
        return jm.c.r(jm.c.t(Http2Connection.DEGRADED_PONG_TIMEOUT_NS, jm.c.w(r12.seconds, this.seconds)), r12.nanos - this.nanos) / 1000;
    L23:
        return jm.c.r(jm.c.t(Http2Connection.DEGRADED_PONG_TIMEOUT_NS, jm.c.w(r12.seconds, this.seconds)), r12.nanos - this.nanos);
    L25:
        return r11.between(this, r12);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeLong(this.seconds);
        r5.writeInt(this.nanos);
    }

    public static Instant now(a r5) {
        jm.c.p(r5, "clock");
        return r5.instant();
    }

    public static Instant ofEpochSecond(long r5, long r10) {
        long r11 = jm.c.r(r5, jm.c.l(r10, 1000000000));
        return a(jm.c.n(Http2Connection.DEGRADED_PONG_TIMEOUT_NS, r10), r11);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Instant r5) {
        int r10 = jm.c.j(this.seconds, r5.seconds);
        if (r10 == 0) goto L6;
        return r10;
    L6:
        return this.nanos - r5.nanos;
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1646minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1647plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public Instant minus(org.threeten.bp.temporal.f r5) {
        return (Instant) r5.subtractFrom(this);
    }

    public Instant plus(org.threeten.bp.temporal.f r5) {
        return (Instant) r5.addTo(this);
    }

    @Override // org.threeten.bp.temporal.c
    public Instant with(org.threeten.bp.temporal.e r5) {
        return (Instant) r5.adjustInto(this);
    }

    public boolean isSupported(org.threeten.bp.temporal.j r5) {
        if ((r5 instanceof ChronoUnit) == true) goto L5;
        if (r5 == null) goto L16;
        if (r5.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r5.isTimeBased() == false) goto L7;
        return true;
    L7:
        if (r5 != ChronoUnit.DAYS) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.temporal.c
    public Instant minus(long r5, org.threeten.bp.temporal.j r10) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Instant this = plus(Long.MAX_VALUE, r10);
        long r11 = 1;
    L7:
        return this.plus(r11, r10);
    L6:
        r11 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public Instant plus(long r5, org.threeten.bp.temporal.j r10) {
        if ((r10 instanceof ChronoUnit) == false) goto L25;
        switch(c.f21137b[((ChronoUnit) r10).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    L9:
        return plusSeconds(jm.c.t(86400, r5));
    L11:
        return plusSeconds(jm.c.t(43200, r5));
    L13:
        return plusSeconds(jm.c.t(3600, r5));
    L15:
        return plusSeconds(jm.c.t(60, r5));
    L17:
        return plusSeconds(r5);
    L19:
        return plusMillis(r5);
    L21:
        return b(r5 / 1000000, (r5 % 1000000) * 1000);
    L23:
        return plusNanos(r5);
    L25:
        return (Instant) r10.addTo(this, r5);
    }

    @Override // org.threeten.bp.temporal.c
    public Instant with(org.threeten.bp.temporal.g r5, long r10) {
        if ((r5 instanceof ChronoField) == false) goto L31;
        ChronoField r11 = (ChronoField) r5;
        r11.checkValidValue(r10);
        int r12 = c.f21136a[r11.ordinal()];
        if (r12 == 1) goto L27;
        if (r12 != 2) goto L9;
        int r13 = ((int) r10) * 1000;
        if (r13 != this.nanos) goto L25;
        return this;
    L25:
        return a(r13, this.seconds);
    L9:
        if (r12 != 3) goto L11;
        int r14 = ((int) r10) * DurationKt.NANOS_IN_MILLIS;
        if (r14 != this.nanos) goto L21;
        return this;
    L21:
        return a(r14, this.seconds);
    L11:
        if (r12 != 4) goto L17;
        if (r10 != this.seconds) goto L15;
        return this;
    L15:
        return a(this.nanos, r10);
    L17:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L27:
        if (r10 != this.nanos) goto L29;
        return this;
    L29:
        return a((int) r10, this.seconds);
    L31:
        return (Instant) r5.adjustInto(this, r10);
    }
}
