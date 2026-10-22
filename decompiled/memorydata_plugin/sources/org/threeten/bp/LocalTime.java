package org.threeten.bp;

import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.apache.logging.log4j.message.ParameterizedMessage;
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
public final class LocalTime extends DefaultInterfaceTemporalAccessor implements Serializable, Comparable<LocalTime>, Temporal, TemporalAdjuster {
    public static final TemporalQuery<LocalTime> FROM = null;
    private static final LocalTime[] HOURS = null;
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
    private static final long serialVersionUID = 6414437269572265201L;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    /* JADX INFO: renamed from: org.threeten.bp.LocalTime$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit = null;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0;
            r0[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L81:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L61:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L77:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L83:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L37
        L65:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L38
        L67:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L39
        L16:
            int[] r7 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r7;
            r7[ChronoField.NANO_OF_SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L59:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.NANO_OF_DAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L87:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_SECOND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L97:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_DAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
        L57:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_SECOND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L71:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_DAY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L45
        L95:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.SECOND_OF_MINUTE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L46
        L55:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.SECOND_OF_DAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L47
        L85:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MINUTE_OF_HOUR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
        L89:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MINUTE_OF_DAY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
        L73:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.HOUR_OF_AMPM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
        L79:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
        L63:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.HOUR_OF_DAY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
        L69:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 14;     // Catch: NoSuchFieldError -> L53
        L93:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.AMPM_OF_DAY.ordinal()] = 15;     // Catch: NoSuchFieldError -> L54
            return;
        }
    }

    static {
        FROM = new AnonymousClass1();
        HOURS = new LocalTime[24];
        int r1 = 0;
    L3:
        LocalTime[] r2 = HOURS;
        if (r1 >= r2.length) goto L6;
        r2[r1] = new LocalTime(r1, 0, 0, 0);
        r1 = r1 + 1;
        goto L3
    L6:
        MIDNIGHT = r2[0];
        NOON = r2[12];
        MIN = r2[0];
        MAX = new LocalTime(23, 59, 59, Year.MAX_VALUE);
    }

    private LocalTime(int r1, int r2, int r3, int r4) {
        this.hour = (byte) r1;
        this.minute = (byte) r2;
        this.second = (byte) r3;
        this.nano = r4;
    }

    private static LocalTime create(int r1, int r2, int r3, int r4) {
        if (((r2 | r3) | r4) != 0) goto L7;
        return HOURS[r1];
    L7:
        return new LocalTime(r1, r2, r3, r4);
    }

    public static LocalTime from(TemporalAccessor r3) {
        TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin");
        LocalTime r0 = (LocalTime) ZeusTransformUtils.preCheckCast(r4.query(TemporalQueries.localTime()), LocalTime.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + r4 + ", type " + r4.getClass().getName());
    }

    private int get0(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.memorydata.plugin")).ordinal()]) {
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
        byte r3 = this.hour;
        if (r3 != 0) goto L41;
        return 24;
    L41:
        return r3;
    L14:
        int r6 = this.hour % 12;
        if ((r6 % 12) != 0) goto L18;
        return 12;
    L18:
        return r6;
    L5:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r5);
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
        return (int) (toNanoOfDay() / TimeUtils.NANOSECONDS_PER_MILLISECOND);
    L32:
        return this.nano / 1000000;
    L34:
        throw new DateTimeException("Field too large for an int: " + r5);
    L36:
        return this.nano / 1000;
    L38:
        throw new DateTimeException("Field too large for an int: " + r5);
    L40:
        return this.nano;
    }

    public static LocalTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalTime now(Clock r7) {
        Jdk8Methods.requireNonNull(r7, "clock");
        Instant r0 = r7.instant();
        ZoneOffset r8 = r7.getZone().getRules().getOffset(r0);
        long r1 = ((r0.getEpochSecond() % TimeUtils.SECONDS_PER_DAY) + ((long) r8.getTotalSeconds())) % TimeUtils.SECONDS_PER_DAY;
        if (r1 >= 0) goto L6;
        r1 = r1 + TimeUtils.SECONDS_PER_DAY;
    L6:
        return ofSecondOfDay(r1, r0.getNano());
    }

    public static LocalTime now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static LocalTime of(int r3, int r4) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r3);
        if (r4 == 0) goto L5;
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r4);
        return new LocalTime(r3, r4, 0, 0);
    L5:
        return HOURS[r3];
    }

    public static LocalTime of(int r3, int r4, int r5) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r3);
        if ((r4 | r5) == 0) goto L5;
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r4);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r5);
        return new LocalTime(r3, r4, r5, 0);
    L5:
        return HOURS[r3];
    }

    public static LocalTime of(int r3, int r4, int r5, int r6) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r3);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r4);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r5);
        ChronoField.NANO_OF_SECOND.checkValidValue(r6);
        return create(r3, r4, r5, r6);
    }

    public static LocalTime ofNanoOfDay(long r7) {
        ChronoField.NANO_OF_DAY.checkValidValue(r7);
        int r2 = (int) (r7 / NANOS_PER_HOUR);
        long r8 = r7 - (((long) r2) * NANOS_PER_HOUR);
        int r3 = (int) (r8 / NANOS_PER_MINUTE);
        long r9 = r8 - (((long) r3) * NANOS_PER_MINUTE);
        int r4 = (int) (r9 / NANOS_PER_SECOND);
        return create(r2, r3, r4, (int) (r9 - (((long) r4) * NANOS_PER_SECOND)));
    }

    public static LocalTime ofSecondOfDay(long r4) {
        ChronoField.SECOND_OF_DAY.checkValidValue(r4);
        int r0 = (int) (r4 / TimeUtils.SECONDS_PER_HOUR);
        long r5 = r4 - ((long) (r0 * SECONDS_PER_HOUR));
        int r1 = (int) (r5 / 60);
        return create(r0, r1, (int) (r5 - ((long) (r1 * 60))), 0);
    }

    static LocalTime ofSecondOfDay(long r4, int r6) {
        ChronoField.SECOND_OF_DAY.checkValidValue(r4);
        ChronoField.NANO_OF_SECOND.checkValidValue(r6);
        int r0 = (int) (r4 / TimeUtils.SECONDS_PER_HOUR);
        long r5 = r4 - ((long) (r0 * SECONDS_PER_HOUR));
        int r1 = (int) (r5 / 60);
        return create(r0, r1, (int) (r5 - ((long) (r1 * 60))), r6);
    }

    public static LocalTime parse(CharSequence r2) {
        return parse((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), DateTimeFormatter.ISO_LOCAL_TIME);
    }

    public static LocalTime parse(CharSequence r2, DateTimeFormatter r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r3, "formatter");
        return (LocalTime) ZeusTransformUtils.preCheckCast(r3.parse(r4, FROM), LocalTime.class, "com.obric.memorydata.plugin");
    }

    static LocalTime readExternal(DataInput r5) {
        DataInput r6 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r5, DataInput.class, "com.obric.memorydata.plugin");
        int r0 = r6.readByte();
        int r1 = 0;
        if (r0 >= 0) goto L5;
        r0 = ~r0;
        int r7 = 0;
        int r2 = 0;
    L14:
        return of(r0, r1, r7, r2);
    L5:
        byte r3 = r6.readByte();
        if (r3 >= 0) goto L8;
        int r8 = ~r3;
        r2 = 0;
        r1 = r8;
        r7 = 0;
        goto L14
    L8:
        byte r4 = r6.readByte();
        if (r4 >= 0) goto L11;
        r7 = ~r4;
    L12:
        r2 = r1;
        r1 = r3;
        goto L14
    L11:
        r1 = r6.readInt();
        r7 = r4;
        goto L12
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        return ((Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.memorydata.plugin")).with(ChronoField.NANO_OF_DAY, toNanoOfDay());
    }

    public LocalDateTime atDate(LocalDate r1) {
        return LocalDateTime.of(r1, this);
    }

    public OffsetTime atOffset(ZoneOffset r1) {
        return OffsetTime.of(this, r1);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(LocalTime r3) {
        return compareTo2((LocalTime) ZeusTransformUtils.preCheckCast(r3, LocalTime.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(LocalTime r3) {
        int r0 = Jdk8Methods.compareInts(this.hour, r3.hour);
        if (r0 != 0) goto L10;
        int r1 = Jdk8Methods.compareInts(this.minute, r3.minute);
        if (r1 != 0) goto L11;
        int r2 = Jdk8Methods.compareInts(this.second, r3.second);
        if (r2 == 0) goto L9;
        return r2;
    L9:
        return Jdk8Methods.compareInts(this.nano, r3.nano);
    L11:
        return r1;
    L10:
        return r0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LocalTime.class) == false) goto L18;
        LocalTime r6 = (LocalTime) ZeusTransformUtils.preCheckCast(r5, LocalTime.class, "com.obric.memorydata.plugin");
        if (this.hour != r6.hour) goto L17;
        if (this.minute != r6.minute) goto L17;
        if (this.second != r6.second) goto L17;
        if (this.nano != r6.nano) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L7;
        return get0(r4);
    L7:
        return super.get(r4);
    }

    public int getHour() {
        return this.hour;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L15;
        if (r4 != ChronoField.NANO_OF_DAY) goto L9;
        return toNanoOfDay();
    L9:
        if (r4 != ChronoField.MICRO_OF_DAY) goto L13;
        return toNanoOfDay() / 1000;
    L13:
        return get0(r4);
    L15:
        return r4.getFrom(this);
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
        long r0 = toNanoOfDay();
        return (int) (r0 ^ (r0 >>> 32));
    }

    public boolean isAfter(LocalTime r1) {
        if (compareTo2(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(LocalTime r1) {
        if (compareTo2(r1) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == true) goto L5;
        if (r4 != null) goto L8;
    L10:
        return false;
    L8:
        if (r4.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r4.isTimeBased();
    }

    public boolean isSupported(TemporalUnit r3) {
        TemporalUnit r4 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r3, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoUnit.class) == true) goto L5;
        if (r4 != null) goto L8;
    L10:
        return false;
    L8:
        if (r4.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r4.isTimeBased();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalTime this = plus(Long.MAX_VALUE, r6);
        long r4 = 1;
    L7:
        return this.plus(r4, r6);
    L5:
        r4 = -r3;
        goto L7
    }

    public LocalTime minus(TemporalAmount r3) {
        return (LocalTime) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).subtractFrom(this), LocalTime.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* synthetic */ Temporal m3215minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public LocalTime minusHours(long r3) {
        return plusHours(-(r3 % 24));
    }

    public LocalTime minusMinutes(long r3) {
        return plusMinutes(-(r3 % 1440));
    }

    public LocalTime minusNanos(long r3) {
        return plusNanos(-(r3 % NANOS_PER_DAY));
    }

    public LocalTime minusSeconds(long r3) {
        return plusSeconds(-(r3 % TimeUtils.SECONDS_PER_DAY));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime plus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L23;
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) ZeusTransformUtils.preCheckCast(r6, ChronoUnit.class, "com.obric.memorydata.plugin")).ordinal()]) {
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
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r6);
    L9:
        return plusHours((r3 % 2) * 12);
    L11:
        return plusHours(r3);
    L13:
        return plusMinutes(r3);
    L15:
        return plusSeconds(r3);
    L17:
        return plusNanos((r3 % 86400000) * TimeUtils.NANOSECONDS_PER_MILLISECOND);
    L19:
        return plusNanos((r3 % MICROS_PER_DAY) * 1000);
    L21:
        return plusNanos(r3);
    L23:
        return (LocalTime) ZeusTransformUtils.preCheckCast(r6.addTo(this, r3), LocalTime.class, "com.obric.memorydata.plugin");
    }

    public LocalTime plus(TemporalAmount r3) {
        return (LocalTime) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).addTo(this), LocalTime.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* synthetic */ Temporal m3216plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public LocalTime plusHours(long r3) {
        if (r3 != 0) goto L6;
        return this;
    L6:
        return create(((((int) (r3 % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime plusMinutes(long r4) {
        if (r4 != 0) goto L5;
        return this;
    L5:
        int r0 = (this.hour * 60) + this.minute;
        int r5 = ((((int) (r4 % 1440)) + r0) + MINUTES_PER_DAY) % MINUTES_PER_DAY;
        if (r0 != r5) goto L9;
        return this;
    L9:
        return create(r5 / 60, r5 % 60, this.second, this.nano);
    }

    public LocalTime plusNanos(long r9) {
        if (r9 != 0) goto L5;
        return this;
    L5:
        long r0 = toNanoOfDay();
        long r10 = (((r9 % NANOS_PER_DAY) + r0) + NANOS_PER_DAY) % NANOS_PER_DAY;
        if (r0 != r10) goto L9;
        return this;
    L9:
        return create((int) (r10 / NANOS_PER_HOUR), (int) ((r10 / NANOS_PER_MINUTE) % 60), (int) ((r10 / NANOS_PER_SECOND) % 60), (int) (r10 % NANOS_PER_SECOND));
    }

    public LocalTime plusSeconds(long r4) {
        if (r4 != 0) goto L5;
        return this;
    L5:
        int r0 = ((this.hour * 3600) + (this.minute * 60)) + this.second;
        int r5 = ((((int) (r4 % TimeUtils.SECONDS_PER_DAY)) + r0) + SECONDS_PER_DAY) % SECONDS_PER_DAY;
        if (r0 != r5) goto L9;
        return this;
    L9:
        return create(r5 / SECONDS_PER_HOUR, (r5 / 60) % 60, r5 % 60, this.nano);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<TemporalUnit> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin");
        if (r4 != TemporalQueries.precision()) goto L7;
        return (R) ChronoUnit.NANOS;
    L7:
        if (r4 != TemporalQueries.localTime()) goto L10;
        return this;
    L10:
        if (r4 != TemporalQueries.chronology()) goto L12;
        return null;
    L12:
        if (r4 != TemporalQueries.zoneId()) goto L14;
        return null;
    L14:
        if (r4 != TemporalQueries.zone()) goto L16;
        return null;
    L16:
        if (r4 != TemporalQueries.offset()) goto L18;
        return null;
    L18:
        if (r4 != TemporalQueries.localDate()) goto L21;
        return null;
    L21:
        return (R) r4.queryFrom(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        return super.range((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"));
    }

    public long toNanoOfDay() {
        return (((((long) this.hour) * NANOS_PER_HOUR) + (((long) this.minute) * NANOS_PER_MINUTE)) + (((long) this.second) * NANOS_PER_SECOND)) + ((long) this.nano);
    }

    public int toSecondOfDay() {
        return ((this.hour * 3600) + (this.minute * 60)) + this.second;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(18);
        byte r1 = this.hour;
        byte r2 = this.minute;
        byte r3 = this.second;
        int r8 = this.nano;
        if (r1 >= 10) goto L5;
        String r5 = "0";
    L6:
        StringBuilder r4 = r0.append(r5).append(r1);
        String r6 = ":0";
        if (r2 >= 10) goto L9;
        String r7 = ":0";
    L10:
        r4.append(r7).append(r2);
        if (r3 > 0) goto L13;
        if (r8 > 0) goto L13;
    L28:
        return r0.toString();
    L13:
        if (r3 < 10) goto L16;
        r6 = ParameterizedMessage.ERROR_MSG_SEPARATOR;
    L16:
        r0.append(r6).append(r3);
        if (r8 <= 0) goto L28;
        r0.append('.');
        int r9 = 1000000;
        if ((r8 % 1000000) != 0) goto L23;
        int r10 = (r8 / 1000000) + 1000;
    L21:
        r0.append(Integer.toString(r10).substring(1));
        goto L28
    L23:
        if ((r8 % 1000) != 0) goto L25;
        r8 = r8 / 1000;
    L26:
        r10 = r8 + r9;
        goto L21
    L25:
        r9 = 1000000000;
        goto L26
    L9:
        r7 = ParameterizedMessage.ERROR_MSG_SEPARATOR;
        goto L10
    L5:
        r5 = "";
        goto L6
    }

    public LocalTime truncatedTo(TemporalUnit r7) {
        TemporalUnit r8 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r7, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (r8 != ChronoUnit.NANOS) goto L5;
        return this;
    L5:
        Duration r9 = r8.getDuration();
        if (r9.getSeconds() > TimeUtils.SECONDS_PER_DAY) goto L14;
        long r0 = r9.toNanos();
        if ((NANOS_PER_DAY % r0) != 0) goto L12;
        return ofNanoOfDay((toNanoOfDay() / r0) * r0);
    L12:
        throw new DateTimeException("Unit must divide into a standard day without remainder");
    L14:
        throw new DateTimeException("Unit is too large to be used for truncation");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r5, TemporalUnit r6) {
        Temporal r7 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r5, Temporal.class, "com.obric.memorydata.plugin");
        TemporalUnit r8 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r6, TemporalUnit.class, "com.obric.memorydata.plugin");
        LocalTime r9 = from(r7);
        if (ZeusTransformUtils.instanceOf(r8, ChronoUnit.class) == false) goto L18;
        long r2 = r9.toNanoOfDay() - toNanoOfDay();
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) ZeusTransformUtils.preCheckCast(r8, ChronoUnit.class, "com.obric.memorydata.plugin")).ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        long r4 = 43200000000000L;
    L10:
        return r2 / r4;
    L11:
        r4 = NANOS_PER_HOUR;
        goto L10
    L12:
        r4 = NANOS_PER_MINUTE;
        goto L10
    L13:
        r4 = NANOS_PER_SECOND;
        goto L10
    L14:
        r4 = TimeUtils.NANOSECONDS_PER_MILLISECOND;
        goto L10
    L15:
        r4 = 1000;
        goto L10
    L16:
        return r2;
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r8);
    L18:
        return r8.between(this, r9);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime with(TemporalAdjuster r4) {
        TemporalAdjuster r5 = (TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAdjuster.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, LocalTime.class) == false) goto L7;
        Object r3 = ZeusTransformUtils.preCheckCast(r5, LocalTime.class, "com.obric.memorydata.plugin");
    L6:
        return (LocalTime) r3;
    L7:
        r3 = ZeusTransformUtils.preCheckCast(r5.adjustInto(this), LocalTime.class, "com.obric.memorydata.plugin");
        goto L6
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime with(TemporalField r6, long r7) {
        TemporalField r8 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r6, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, ChronoField.class) == false) goto L45;
        ChronoField r0 = (ChronoField) ZeusTransformUtils.preCheckCast(r8, ChronoField.class, "com.obric.memorydata.plugin");
        r0.checkValidValue(r7);
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()]) {
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
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r8);
    L9:
        return plusHours((r7 - ((long) (this.hour / 12))) * 12);
    L11:
        if (r7 != 24) goto L14;
        r7 = 0;
    L14:
        return withHour((int) r7);
    L16:
        return withHour((int) r7);
    L18:
        if (r7 != 12) goto L21;
        r7 = 0;
    L21:
        return plusHours(r7 - ((long) (this.hour % 12)));
    L23:
        return plusHours(r7 - ((long) (this.hour % 12)));
    L25:
        return plusMinutes(r7 - ((long) ((this.hour * 60) + this.minute)));
    L27:
        return withMinute((int) r7);
    L29:
        return plusSeconds(r7 - ((long) toSecondOfDay()));
    L31:
        return withSecond((int) r7);
    L33:
        return ofNanoOfDay(r7 * TimeUtils.NANOSECONDS_PER_MILLISECOND);
    L35:
        return withNano(((int) r7) * 1000000);
    L37:
        return ofNanoOfDay(r7 * 1000);
    L39:
        return withNano(((int) r7) * 1000);
    L41:
        return ofNanoOfDay(r7);
    L43:
        return withNano((int) r7);
    L45:
        return (LocalTime) ZeusTransformUtils.preCheckCast(r8.adjustInto(this, r7), LocalTime.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"), r4);
    }

    public LocalTime withHour(int r4) {
        if (this.hour != r4) goto L5;
        return this;
    L5:
        ChronoField.HOUR_OF_DAY.checkValidValue(r4);
        return create(r4, this.minute, this.second, this.nano);
    }

    public LocalTime withMinute(int r4) {
        if (this.minute != r4) goto L5;
        return this;
    L5:
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r4);
        return create(this.hour, r4, this.second, this.nano);
    }

    public LocalTime withNano(int r4) {
        if (this.nano != r4) goto L5;
        return this;
    L5:
        ChronoField.NANO_OF_SECOND.checkValidValue(r4);
        return create(this.hour, this.minute, this.second, r4);
    }

    public LocalTime withSecond(int r4) {
        if (this.second != r4) goto L5;
        return this;
    L5:
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r4);
        return create(this.hour, this.minute, r4, this.nano);
    }

    void writeExternal(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.memorydata.plugin");
        if (this.nano == 0) goto L5;
        r4.writeByte(this.hour);
        r4.writeByte(this.minute);
        r4.writeByte(this.second);
        r4.writeInt(this.nano);
        return;
    L5:
        if (this.second == 0) goto L7;
        r4.writeByte(this.hour);
        r4.writeByte(this.minute);
        byte r2 = this.second;
    L11:
        r4.writeByte(~r2);
        return;
    L7:
        if (this.minute != 0) goto L9;
        r2 = this.hour;
        goto L11
    L9:
        r4.writeByte(this.hour);
        r2 = this.minute;
        goto L11
    }
}
