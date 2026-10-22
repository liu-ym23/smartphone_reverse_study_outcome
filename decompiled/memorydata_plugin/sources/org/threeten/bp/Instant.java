package org.threeten.bp;

import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes8.dex */
public final class Instant extends DefaultInterfaceTemporalAccessor implements Serializable, Comparable<Instant>, Temporal, TemporalAdjuster {
    public static final Instant EPOCH = null;
    public static final TemporalQuery<Instant> FROM = null;
    public static final Instant MAX = null;
    private static final long MAX_SECOND = 31556889864403199L;
    private static final long MILLIS_PER_SEC = 1000;
    public static final Instant MIN = null;
    private static final long MIN_SECOND = -31557014167219200L;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final long serialVersionUID = -665713676816604388L;
    private final int nanos;
    private final long seconds;

    /* JADX INFO: renamed from: org.threeten.bp.Instant$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit = null;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0;
            r0[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L32:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L38:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L54:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L34:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L40:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L44:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DAYS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L14:
            int[] r4 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r4;
            r4[ChronoField.NANO_OF_SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L42:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_SECOND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L46:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_SECOND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L36:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.INSTANT_SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    static {
        EPOCH = new Instant(0, 0);
        MIN = ofEpochSecond(MIN_SECOND, 0);
        MAX = ofEpochSecond(MAX_SECOND, 999999999);
        FROM = new AnonymousClass1();
    }

    private Instant(long r1, int r3) {
        this.seconds = r1;
        this.nanos = r3;
    }

    private static Instant create(long r4, int r6) {
        if ((((long) r6) | r4) != 0) goto L7;
        return EPOCH;
    L7:
        if (r4 < MIN_SECOND) goto L13;
        if (r4 > MAX_SECOND) goto L13;
        return new Instant(r4, r6);
    L13:
        throw new DateTimeException("Instant exceeds minimum or maximum instant");
    }

    public static Instant from(TemporalAccessor r4) {
        TemporalAccessor r5 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAccessor.class, "com.obric.memorydata.plugin");
        return ofEpochSecond(r5.getLong(ChronoField.INSTANT_SECONDS), r5.get(ChronoField.NANO_OF_SECOND));
    L5:
        e = move-exception;
        throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName(), e);
    }

    private long nanosUntil(Instant r5) {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(Jdk8Methods.safeSubtract(r5.seconds, this.seconds), NANOS_PER_SECOND), r5.nanos - this.nanos);
    }

    public static Instant now() {
        return Clock.systemUTC().instant();
    }

    public static Instant now(Clock r1) {
        Jdk8Methods.requireNonNull(r1, "clock");
        return r1.instant();
    }

    public static Instant ofEpochMilli(long r3) {
        return create(Jdk8Methods.floorDiv(r3, 1000), Jdk8Methods.floorMod(r3, 1000) * 1000000);
    }

    public static Instant ofEpochSecond(long r1) {
        return create(r1, 0);
    }

    public static Instant ofEpochSecond(long r2, long r4) {
        return create(Jdk8Methods.safeAdd(r2, Jdk8Methods.floorDiv(r4, 1000000000)), Jdk8Methods.floorMod(r4, NANOS_PER_SECOND));
    }

    public static Instant parse(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        return (Instant) ZeusTransformUtils.preCheckCast(DateTimeFormatter.ISO_INSTANT.parse(r4, FROM), Instant.class, "com.obric.memorydata.plugin");
    }

    private Instant plus(long r5, long r7) {
        if ((r5 | r7) != 0) goto L6;
        return this;
    L6:
        return ofEpochSecond(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(this.seconds, r5), r7 / 1000000000), this.nanos + (r7 % 1000000000));
    }

    static Instant readExternal(DataInput r4) {
        DataInput r5 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r4, DataInput.class, "com.obric.memorydata.plugin");
        return ofEpochSecond(r5.readLong(), r5.readInt());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private long secondsUntil(Instant r9) {
        long r0 = Jdk8Methods.safeSubtract(r9.seconds, this.seconds);
        long r8 = r9.nanos - this.nanos;
        if (r0 > 0) goto L5;
    L7:
        if (r0 < 0) goto L9;
        return r0;
    L9:
        if (r8 > 0) goto L11;
        return r0;
    L11:
        return r0 + 1;
    L5:
        if (r8 >= 0) goto L7;
        return r0 - 1;
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        return ((Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.memorydata.plugin")).with(ChronoField.INSTANT_SECONDS, this.seconds).with(ChronoField.NANO_OF_SECOND, this.nanos);
    }

    public OffsetDateTime atOffset(ZoneOffset r1) {
        return OffsetDateTime.ofInstant(this, r1);
    }

    public ZonedDateTime atZone(ZoneId r1) {
        return ZonedDateTime.ofInstant(this, r1);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Instant r3) {
        return compareTo2((Instant) ZeusTransformUtils.preCheckCast(r3, Instant.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Instant r5) {
        int r0 = Jdk8Methods.compareLongs(this.seconds, r5.seconds);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return this.nanos - r5.nanos;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Instant.class) == false) goto L14;
        Instant r10 = (Instant) ZeusTransformUtils.preCheckCast(r9, Instant.class, "com.obric.memorydata.plugin");
        if (this.seconds != r10.seconds) goto L13;
        if (this.nanos != r10.nanos) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L19;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.memorydata.plugin")).ordinal()];
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L13;
        return this.nanos / 1000000;
    L13:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r5);
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

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L22;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.memorydata.plugin")).ordinal()];
        if (r0 != 1) goto L7;
        int r3 = this.nanos;
    L18:
        return r3;
    L7:
        if (r0 != 2) goto L9;
        r3 = this.nanos / 1000;
        goto L18
    L9:
        if (r0 != 3) goto L11;
        r3 = this.nanos / 1000000;
        goto L18
    L11:
        if (r0 != 4) goto L15;
        return this.seconds;
    L15:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r5);
    L22:
        return r5.getFrom(this);
    }

    public int getNano() {
        return this.nanos;
    }

    public int hashCode() {
        long r0 = this.seconds;
        return ((int) (r0 ^ (r0 >>> 32))) + (this.nanos * 51);
    }

    public boolean isAfter(Instant r1) {
        if (compareTo2(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(Instant r1) {
        if (compareTo2(r1) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == true) goto L5;
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

    public boolean isSupported(TemporalUnit r4) {
        TemporalUnit r5 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r4, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoUnit.class) == true) goto L5;
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

    @Override // org.threeten.bp.temporal.Temporal
    public Instant minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (r3 != Long.MIN_VALUE) goto L5;
        Instant this = plus(Long.MAX_VALUE, r6);
        long r4 = 1;
    L7:
        return this.plus(r4, r6);
    L5:
        r4 = -r3;
        goto L7
    }

    public Instant minus(TemporalAmount r3) {
        return (Instant) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).subtractFrom(this), Instant.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* synthetic */ Temporal m3213minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public Instant minusMillis(long r3) {
        if (r3 != Long.MIN_VALUE) goto L7;
        Instant this = plusMillis(Long.MAX_VALUE);
        long r4 = 1;
    L6:
        return this.plusMillis(r4);
    L7:
        r4 = -r3;
        goto L6
    }

    public Instant minusNanos(long r3) {
        if (r3 != Long.MIN_VALUE) goto L7;
        Instant this = plusNanos(Long.MAX_VALUE);
        long r4 = 1;
    L6:
        return this.plusNanos(r4);
    L7:
        r4 = -r3;
        goto L6
    }

    public Instant minusSeconds(long r3) {
        if (r3 != Long.MIN_VALUE) goto L7;
        Instant this = plusSeconds(Long.MAX_VALUE);
        long r4 = 1;
    L6:
        return this.plusSeconds(r4);
    L7:
        r4 = -r3;
        goto L6
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant plus(long r5, TemporalUnit r7) {
        TemporalUnit r8 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r7, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, ChronoUnit.class) == false) goto L25;
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) ZeusTransformUtils.preCheckCast(r8, ChronoUnit.class, "com.obric.memorydata.plugin")).ordinal()]) {
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
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r8);
    L9:
        return plusSeconds(Jdk8Methods.safeMultiply(r5, 86400));
    L11:
        return plusSeconds(Jdk8Methods.safeMultiply(r5, 43200));
    L13:
        return plusSeconds(Jdk8Methods.safeMultiply(r5, 3600));
    L15:
        return plusSeconds(Jdk8Methods.safeMultiply(r5, 60));
    L17:
        return plusSeconds(r5);
    L19:
        return plusMillis(r5);
    L21:
        return plus(r5 / TimeUtils.NANOSECONDS_PER_MILLISECOND, (r5 % TimeUtils.NANOSECONDS_PER_MILLISECOND) * 1000);
    L23:
        return plusNanos(r5);
    L25:
        return (Instant) ZeusTransformUtils.preCheckCast(r8.addTo(this, r5), Instant.class, "com.obric.memorydata.plugin");
    }

    public Instant plus(TemporalAmount r3) {
        return (Instant) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).addTo(this), Instant.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* synthetic */ Temporal m3214plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public Instant plusMillis(long r5) {
        return plus(r5 / 1000, (r5 % 1000) * TimeUtils.NANOSECONDS_PER_MILLISECOND);
    }

    public Instant plusNanos(long r3) {
        return plus(0, r3);
    }

    public Instant plusSeconds(long r3) {
        return plus(r3, 0);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<TemporalUnit> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin");
        if (r4 != TemporalQueries.precision()) goto L7;
        return (R) ChronoUnit.NANOS;
    L7:
        if (r4 != TemporalQueries.localDate()) goto L9;
        return null;
    L9:
        if (r4 != TemporalQueries.localTime()) goto L11;
        return null;
    L11:
        if (r4 != TemporalQueries.chronology()) goto L13;
        return null;
    L13:
        if (r4 != TemporalQueries.zoneId()) goto L15;
        return null;
    L15:
        if (r4 != TemporalQueries.zone()) goto L17;
        return null;
    L17:
        if (r4 != TemporalQueries.offset()) goto L20;
        return null;
    L20:
        return (R) r4.queryFrom(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        return super.range((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"));
    }

    public long toEpochMilli() {
        long r0 = this.seconds;
        if (r0 < 0) goto L7;
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r0, 1000), this.nanos / 1000000);
    L7:
        return Jdk8Methods.safeSubtract(Jdk8Methods.safeMultiply(r0 + 1, 1000), 1000 - ((long) (this.nanos / 1000000)));
    }

    public String toString() {
        return DateTimeFormatter.ISO_INSTANT.format(this);
    }

    public Instant truncatedTo(TemporalUnit r9) {
        TemporalUnit r10 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r9, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (r10 != ChronoUnit.NANOS) goto L5;
        return this;
    L5:
        Duration r11 = r10.getDuration();
        if (r11.getSeconds() > TimeUtils.SECONDS_PER_DAY) goto L14;
        long r0 = r11.toNanos();
        if ((86400000000000L % r0) != 0) goto L12;
        long r4 = ((this.seconds % TimeUtils.SECONDS_PER_DAY) * 1000000000) + ((long) this.nanos);
        return plusNanos((Jdk8Methods.floorDiv(r4, r0) * r0) - r4);
    L12:
        throw new DateTimeException("Unit must divide into a standard day without remainder");
    L14:
        throw new DateTimeException("Unit is too large to be used for truncation");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r3, TemporalUnit r4) {
        Temporal r5 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.memorydata.plugin");
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r4, TemporalUnit.class, "com.obric.memorydata.plugin");
        Instant r7 = from(r5);
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L25;
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) ZeusTransformUtils.preCheckCast(r6, ChronoUnit.class, "com.obric.memorydata.plugin")).ordinal()]) {
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
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r6);
    L9:
        return secondsUntil(r7) / TimeUtils.SECONDS_PER_DAY;
    L11:
        return secondsUntil(r7) / 43200;
    L13:
        return secondsUntil(r7) / TimeUtils.SECONDS_PER_HOUR;
    L15:
        return secondsUntil(r7) / 60;
    L17:
        return secondsUntil(r7);
    L19:
        return Jdk8Methods.safeSubtract(r7.toEpochMilli(), toEpochMilli());
    L21:
        return nanosUntil(r7) / 1000;
    L23:
        return nanosUntil(r7);
    L25:
        return r6.between(this, r7);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant with(TemporalAdjuster r3) {
        return (Instant) ZeusTransformUtils.preCheckCast(((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin")).adjustInto(this), Instant.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant with(TemporalField r3, long r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L31;
        ChronoField r0 = (ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.memorydata.plugin");
        r0.checkValidValue(r4);
        int r1 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L27;
        if (r1 != 2) goto L9;
        int r6 = ((int) r4) * 1000;
        if (r6 != this.nanos) goto L25;
        return this;
    L25:
        return create(this.seconds, r6);
    L9:
        if (r1 != 3) goto L11;
        int r7 = ((int) r4) * 1000000;
        if (r7 != this.nanos) goto L21;
        return this;
    L21:
        return create(this.seconds, r7);
    L11:
        if (r1 != 4) goto L17;
        if (r4 != this.seconds) goto L15;
        return this;
    L15:
        return create(r4, this.nanos);
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r5);
    L27:
        if (r4 != this.nanos) goto L29;
        return this;
    L29:
        return create(this.seconds, (int) r4);
    L31:
        return (Instant) ZeusTransformUtils.preCheckCast(r5.adjustInto(this, r4), Instant.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"), r4);
    }

    void writeExternal(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.memorydata.plugin");
        r4.writeLong(this.seconds);
        r4.writeInt(this.nanos);
    }
}
