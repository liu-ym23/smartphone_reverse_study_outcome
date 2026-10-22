package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Comparator;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
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
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes8.dex */
public final class OffsetDateTime extends DefaultInterfaceTemporal implements Serializable, Comparable<OffsetDateTime>, Temporal, TemporalAdjuster {
    public static final TemporalQuery<OffsetDateTime> FROM = null;
    private static final Comparator<OffsetDateTime> INSTANT_COMPARATOR = null;
    public static final OffsetDateTime MAX = null;
    public static final OffsetDateTime MIN = null;
    private static final long serialVersionUID = 2287754244819255394L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;

    /* JADX INFO: renamed from: org.threeten.bp.OffsetDateTime$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.INSTANT_SECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.OFFSET_SECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        MIN = LocalDateTime.MIN.atOffset(ZoneOffset.MAX);
        MAX = LocalDateTime.MAX.atOffset(ZoneOffset.MIN);
        FROM = new AnonymousClass1();
        INSTANT_COMPARATOR = new AnonymousClass2();
    }

    private OffsetDateTime(LocalDateTime r3, ZoneOffset r4) {
        this.dateTime = (LocalDateTime) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r3, "dateTime"), LocalDateTime.class, "com.obric.memorydata.plugin");
        this.offset = (ZoneOffset) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r4, TypedValues.CycleType.S_WAVE_OFFSET), ZoneOffset.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [org.threeten.bp.OffsetDateTime] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, org.threeten.bp.temporal.TemporalAccessor] */
    public static OffsetDateTime from(TemporalAccessor r3) {
        Object r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, OffsetDateTime.class) == true) goto L5;
        ZoneOffset r0 = ZoneOffset.from(r4);     // Catch: DateTimeException -> L11
        r4 = of(LocalDateTime.from(r4), r0);     // Catch: DateTimeException -> L9
        return r4;
    L9:
        return ofInstant(Instant.from(r4), r0);
    L12:
        throw new DateTimeException("Unable to obtain OffsetDateTime from TemporalAccessor: " + r4 + ", type " + r4.getClass().getName());
    L5:
        return (OffsetDateTime) ZeusTransformUtils.preCheckCast(r4, OffsetDateTime.class, "com.obric.memorydata.plugin");
    }

    public static OffsetDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static OffsetDateTime now(Clock r1) {
        Jdk8Methods.requireNonNull(r1, "clock");
        Instant r0 = r1.instant();
        return ofInstant(r0, r1.getZone().getRules().getOffset(r0));
    }

    public static OffsetDateTime now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static OffsetDateTime of(int r0, int r1, int r2, int r3, int r4, int r5, int r6, ZoneOffset r7) {
        return new OffsetDateTime(LocalDateTime.of(r0, r1, r2, r3, r4, r5, r6), r7);
    }

    public static OffsetDateTime of(LocalDate r0, LocalTime r1, ZoneOffset r2) {
        return new OffsetDateTime(LocalDateTime.of(r0, r1), r2);
    }

    public static OffsetDateTime of(LocalDateTime r1, ZoneOffset r2) {
        return new OffsetDateTime(r1, r2);
    }

    public static OffsetDateTime ofInstant(Instant r2, ZoneId r3) {
        Jdk8Methods.requireNonNull(r2, "instant");
        Jdk8Methods.requireNonNull(r3, "zone");
        ZoneOffset r4 = r3.getRules().getOffset(r2);
        return new OffsetDateTime(LocalDateTime.ofEpochSecond(r2.getEpochSecond(), r2.getNano(), r4), r4);
    }

    public static OffsetDateTime parse(CharSequence r2) {
        return parse((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public static OffsetDateTime parse(CharSequence r2, DateTimeFormatter r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r3, "formatter");
        return (OffsetDateTime) ZeusTransformUtils.preCheckCast(r3.parse(r4, FROM), OffsetDateTime.class, "com.obric.memorydata.plugin");
    }

    static OffsetDateTime readExternal(DataInput r2) {
        DataInput r3 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.memorydata.plugin");
        return of(LocalDateTime.readExternal(r3), ZoneOffset.readExternal(r3));
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Comparator<OffsetDateTime> timeLineOrder() {
        return INSTANT_COMPARATOR;
    }

    private OffsetDateTime with(LocalDateTime r2, ZoneOffset r3) {
        if (this.dateTime != r2) goto L8;
        if (this.offset.equals(r3) == false) goto L8;
        return this;
    L8:
        return new OffsetDateTime(r2, r3);
    }

    private Object writeReplace() {
        return new Ser((byte) 69, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        return ((Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.memorydata.plugin")).with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, getOffset().getTotalSeconds());
    }

    public ZonedDateTime atZoneSameInstant(ZoneId r2) {
        return ZonedDateTime.ofInstant(this.dateTime, this.offset, r2);
    }

    public ZonedDateTime atZoneSimilarLocal(ZoneId r2) {
        return ZonedDateTime.ofLocal(this.dateTime, r2, this.offset);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(OffsetDateTime r3) {
        return compareTo2((OffsetDateTime) ZeusTransformUtils.preCheckCast(r3, OffsetDateTime.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(OffsetDateTime r5) {
        if (getOffset().equals(r5.getOffset()) == true) goto L5;
        int r0 = Jdk8Methods.compareLongs(toEpochSecond(), r5.toEpochSecond());
        if (r0 != 0) goto L12;
        int r1 = toLocalTime().getNano() - r5.toLocalTime().getNano();
        if (r1 == 0) goto L11;
        return r1;
    L11:
        return toLocalDateTime().compareTo(r5.toLocalDateTime());
    L12:
        return r0;
    L5:
        return toLocalDateTime().compareTo(r5.toLocalDateTime());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OffsetDateTime.class) == false) goto L14;
        OffsetDateTime r6 = (OffsetDateTime) ZeusTransformUtils.preCheckCast(r5, OffsetDateTime.class, "com.obric.memorydata.plugin");
        if (this.dateTime.equals(r6.dateTime) == false) goto L13;
        if (this.offset.equals(r6.offset) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L15;
        int r0 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.memorydata.plugin")).ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        return this.dateTime.get(r5);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        throw new DateTimeException("Field too large for an int: " + r5);
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

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L15;
        int r0 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.memorydata.plugin")).ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
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
        int r0 = this.dateTime.hashCode();
        return this.offset.hashCode() ^ r0;
    }

    public boolean isAfter(OffsetDateTime r5) {
        long r0 = toEpochSecond();
        long r2 = r5.toEpochSecond();
        if (r0 > r2) goto L9;
        if (r0 == r2) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() <= r5.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isBefore(OffsetDateTime r5) {
        long r0 = toEpochSecond();
        long r2 = r5.toEpochSecond();
        if (r0 < r2) goto L9;
        if (r0 == r2) goto L6;
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

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == true) goto L9;
        if (r4 != null) goto L6;
    L8:
        return false;
    L6:
        if (r4.isSupportedBy(this) == false) goto L8;
    L9:
        return true;
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
        if (r5.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r5.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public OffsetDateTime minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plus(Long.MAX_VALUE, r6);
        long r4 = 1;
    L7:
        return this.plus(r4, r6);
    L5:
        r4 = -r3;
        goto L7
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public OffsetDateTime minus(TemporalAmount r3) {
        return (OffsetDateTime) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).subtractFrom(this), OffsetDateTime.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public /* synthetic */ Temporal minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public OffsetDateTime minusDays(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusDays(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusDays(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusHours(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusHours(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusHours(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusMinutes(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusMinutes(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMinutes(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusMonths(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusMonths(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMonths(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusNanos(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusNanos(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusNanos(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusSeconds(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusSeconds(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusSeconds(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusWeeks(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusWeeks(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusWeeks(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusYears(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusYears(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusYears(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetDateTime plus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L7;
        return with(this.dateTime.plus(r3, r6), this.offset);
    L7:
        return (OffsetDateTime) ZeusTransformUtils.preCheckCast(r6.addTo(this, r3), OffsetDateTime.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public OffsetDateTime plus(TemporalAmount r3) {
        return (OffsetDateTime) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).addTo(this), OffsetDateTime.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public /* synthetic */ Temporal plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public OffsetDateTime plusDays(long r2) {
        return with(this.dateTime.plusDays(r2), this.offset);
    }

    public OffsetDateTime plusHours(long r2) {
        return with(this.dateTime.plusHours(r2), this.offset);
    }

    public OffsetDateTime plusMinutes(long r2) {
        return with(this.dateTime.plusMinutes(r2), this.offset);
    }

    public OffsetDateTime plusMonths(long r2) {
        return with(this.dateTime.plusMonths(r2), this.offset);
    }

    public OffsetDateTime plusNanos(long r2) {
        return with(this.dateTime.plusNanos(r2), this.offset);
    }

    public OffsetDateTime plusSeconds(long r2) {
        return with(this.dateTime.plusSeconds(r2), this.offset);
    }

    public OffsetDateTime plusWeeks(long r2) {
        return with(this.dateTime.plusWeeks(r2), this.offset);
    }

    public OffsetDateTime plusYears(long r2) {
        return with(this.dateTime.plusYears(r2), this.offset);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<R> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin");
        if (r4 != TemporalQueries.chronology()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r4 != TemporalQueries.precision()) goto L11;
        return (R) ChronoUnit.NANOS;
    L11:
        if (r4 == TemporalQueries.offset()) goto L30;
        if (r4 == TemporalQueries.zone()) goto L30;
        if (r4 != TemporalQueries.localDate()) goto L20;
        return (R) toLocalDate();
    L20:
        if (r4 != TemporalQueries.localTime()) goto L24;
        return (R) toLocalTime();
    L24:
        if (r4 != TemporalQueries.zoneId()) goto L28;
        return null;
    L28:
        return (R) super.query(r4);
    L30:
        return (R) getOffset();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L14;
        if (r4 == ChronoField.INSTANT_SECONDS) goto L12;
        if (r4 == ChronoField.OFFSET_SECONDS) goto L12;
        return this.dateTime.range(r4);
    L12:
        return r4.range();
    L14:
        return r4.rangeRefinedBy(this);
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

    public OffsetDateTime truncatedTo(TemporalUnit r3) {
        TemporalUnit r4 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r3, TemporalUnit.class, "com.obric.memorydata.plugin");
        return with(this.dateTime.truncatedTo(r4), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r3, TemporalUnit r4) {
        Temporal r5 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.memorydata.plugin");
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r4, TemporalUnit.class, "com.obric.memorydata.plugin");
        OffsetDateTime r7 = from(r5);
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L7;
        OffsetDateTime r8 = r7.withOffsetSameInstant(this.offset);
        return this.dateTime.until(r8.dateTime, r6);
    L7:
        return r6.between(this, r7);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public OffsetDateTime with(TemporalAdjuster r4) {
        TemporalAdjuster r5 = (TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAdjuster.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, LocalDate.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r5, LocalTime.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r5, LocalDateTime.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r5, Instant.class) == false) goto L14;
        return ofInstant((Instant) ZeusTransformUtils.preCheckCast(r5, Instant.class, "com.obric.memorydata.plugin"), this.offset);
    L14:
        if (ZeusTransformUtils.instanceOf(r5, ZoneOffset.class) == false) goto L18;
        return with(this.dateTime, (ZoneOffset) ZeusTransformUtils.preCheckCast(r5, ZoneOffset.class, "com.obric.memorydata.plugin"));
    L18:
        if (ZeusTransformUtils.instanceOf(r5, OffsetDateTime.class) == false) goto L22;
        return (OffsetDateTime) ZeusTransformUtils.preCheckCast(r5, OffsetDateTime.class, "com.obric.memorydata.plugin");
    L22:
        return (OffsetDateTime) ZeusTransformUtils.preCheckCast(r5.adjustInto(this), OffsetDateTime.class, "com.obric.memorydata.plugin");
    L24:
        return with(this.dateTime.with(r5), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetDateTime with(TemporalField r4, long r5) {
        TemporalField r6 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoField.class) == false) goto L15;
        ChronoField r0 = (ChronoField) ZeusTransformUtils.preCheckCast(r6, ChronoField.class, "com.obric.memorydata.plugin");
        int r1 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L11;
        return with(this.dateTime.with(r6, r5), this.offset);
    L11:
        return with(this.dateTime, ZoneOffset.ofTotalSeconds(r0.checkValidIntValue(r5)));
    L13:
        return ofInstant(Instant.ofEpochSecond(r5, getNano()), this.offset);
    L15:
        return (OffsetDateTime) ZeusTransformUtils.preCheckCast(r6.adjustInto(this, r5), OffsetDateTime.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"), r4);
    }

    public OffsetDateTime withDayOfMonth(int r2) {
        return with(this.dateTime.withDayOfMonth(r2), this.offset);
    }

    public OffsetDateTime withDayOfYear(int r2) {
        return with(this.dateTime.withDayOfYear(r2), this.offset);
    }

    public OffsetDateTime withHour(int r2) {
        return with(this.dateTime.withHour(r2), this.offset);
    }

    public OffsetDateTime withMinute(int r2) {
        return with(this.dateTime.withMinute(r2), this.offset);
    }

    public OffsetDateTime withMonth(int r2) {
        return with(this.dateTime.withMonth(r2), this.offset);
    }

    public OffsetDateTime withNano(int r2) {
        return with(this.dateTime.withNano(r2), this.offset);
    }

    public OffsetDateTime withOffsetSameInstant(ZoneOffset r3) {
        if (r3.equals(this.offset) == false) goto L6;
        return this;
    L6:
        return new OffsetDateTime(this.dateTime.plusSeconds(r3.getTotalSeconds() - this.offset.getTotalSeconds()), r3);
    }

    public OffsetDateTime withOffsetSameLocal(ZoneOffset r2) {
        return with(this.dateTime, r2);
    }

    public OffsetDateTime withSecond(int r2) {
        return with(this.dateTime.withSecond(r2), this.offset);
    }

    public OffsetDateTime withYear(int r2) {
        return with(this.dateTime.withYear(r2), this.offset);
    }

    void writeExternal(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.memorydata.plugin");
        this.dateTime.writeExternal(r4);
        this.offset.writeExternal(r4);
    }
}
