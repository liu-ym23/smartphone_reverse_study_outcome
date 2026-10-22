package org.threeten.bp.chrono;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
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

/* JADX INFO: loaded from: classes8.dex */
public abstract class ChronoLocalDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Comparable<ChronoLocalDateTime<?>>, TemporalAdjuster {
    private static final Comparator<ChronoLocalDateTime<?>> DATE_TIME_COMPARATOR = null;

    static {
        DATE_TIME_COMPARATOR = new AnonymousClass1();
    }

    public ChronoLocalDateTime() {
    }

    public static ChronoLocalDateTime<?> from(TemporalAccessor r3) {
        TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r4, "temporal");
        if (ZeusTransformUtils.instanceOf(r4, ChronoLocalDateTime.class) == true) goto L5;
        Chronology r0 = (Chronology) ZeusTransformUtils.preCheckCast(r4.query(TemporalQueries.chronology()), Chronology.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L11;
        return r0.localDateTime(r4);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoLocalDateTime: " + r4.getClass());
    L5:
        return (ChronoLocalDateTime) ZeusTransformUtils.preCheckCast(r4, ChronoLocalDateTime.class, "com.obric.memorydata.plugin");
    }

    public static Comparator<ChronoLocalDateTime<?>> timeLineOrder() {
        return DATE_TIME_COMPARATOR;
    }

    public Temporal adjustInto(Temporal r4) {
        return ((Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.memorydata.plugin")).with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay());
    }

    public abstract ChronoZonedDateTime<D> atZone(ZoneId r1);

    public /* synthetic */ int compareTo(Object r3) {
        return compareTo((ChronoLocalDateTime) ZeusTransformUtils.preCheckCast(r3, ChronoLocalDateTime.class, "com.obric.memorydata.plugin"));
    }

    public int compareTo(ChronoLocalDateTime<?> r3) {
        int r0 = toLocalDate().compareTo(r3.toLocalDate());
        if (r0 != 0) goto L8;
        int r1 = toLocalTime().compareTo2(r3.toLocalTime());
        if (r1 == 0) goto L7;
        return r1;
    L7:
        return getChronology().compareTo2(r3.getChronology());
    L8:
        return r0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ChronoLocalDateTime.class) == true) goto L8;
        return false;
    L8:
        if (compareTo((ChronoLocalDateTime) ZeusTransformUtils.preCheckCast(r5, ChronoLocalDateTime.class, "com.obric.memorydata.plugin")) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    public Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    public int hashCode() {
        int r0 = toLocalDate().hashCode();
        return toLocalTime().hashCode() ^ r0;
    }

    public boolean isAfter(ChronoLocalDateTime<?> r5) {
        long r0 = toLocalDate().toEpochDay();
        long r2 = r5.toLocalDate().toEpochDay();
        if (r0 > r2) goto L9;
        if (r0 == r2) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().toNanoOfDay() <= r5.toLocalTime().toNanoOfDay()) goto L8;
    L9:
        return true;
    }

    public boolean isBefore(ChronoLocalDateTime<?> r5) {
        long r0 = toLocalDate().toEpochDay();
        long r2 = r5.toLocalDate().toEpochDay();
        if (r0 < r2) goto L9;
        if (r0 == r2) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().toNanoOfDay() >= r5.toLocalTime().toNanoOfDay()) goto L8;
    L9:
        return true;
    }

    public boolean isEqual(ChronoLocalDateTime<?> r5) {
        if (toLocalTime().toNanoOfDay() == r5.toLocalTime().toNanoOfDay()) goto L5;
    L7:
        return false;
    L5:
        if (toLocalDate().toEpochDay() != r5.toLocalDate().toEpochDay()) goto L7;
        return true;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTime<D> minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.minus(r3, r6));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public ChronoLocalDateTime<D> minus(TemporalAmount r3) {
        TemporalAmount r4 = (TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin");
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.minus(r4));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public /* synthetic */ Temporal minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public abstract ChronoLocalDateTime<D> plus(long r1, TemporalUnit r3);

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public ChronoLocalDateTime<D> plus(TemporalAmount r3) {
        TemporalAmount r4 = (TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin");
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.plus(r4));
    }

    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public /* synthetic */ Temporal plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<R> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin");
        if (r4 != TemporalQueries.chronology()) goto L7;
        return (R) getChronology();
    L7:
        if (r4 != TemporalQueries.precision()) goto L11;
        return (R) ChronoUnit.NANOS;
    L11:
        if (r4 != TemporalQueries.localDate()) goto L15;
        return (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay());
    L15:
        if (r4 != TemporalQueries.localTime()) goto L19;
        return (R) toLocalTime();
    L19:
        if (r4 != TemporalQueries.zone()) goto L21;
        return null;
    L21:
        if (r4 != TemporalQueries.zoneId()) goto L23;
        return null;
    L23:
        if (r4 != TemporalQueries.offset()) goto L26;
        return null;
    L26:
        return (R) super.query(r4);
    }

    public long toEpochSecond(ZoneOffset r5) {
        Jdk8Methods.requireNonNull(r5, TypedValues.CycleType.S_WAVE_OFFSET);
        return ((toLocalDate().toEpochDay() * TimeUtils.SECONDS_PER_DAY) + ((long) toLocalTime().toSecondOfDay())) - ((long) r5.getTotalSeconds());
    }

    public Instant toInstant(ZoneOffset r3) {
        return Instant.ofEpochSecond(toEpochSecond(r3), toLocalTime().getNano());
    }

    public abstract D toLocalDate();

    public abstract LocalTime toLocalTime();

    public String toString() {
        return toLocalDate().toString() + 'T' + toLocalTime().toString();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTime<D> with(TemporalAdjuster r3) {
        TemporalAdjuster r4 = (TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin");
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.with(r4));
    }

    public abstract ChronoLocalDateTime<D> with(TemporalField r1, long r2);

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"), r4);
    }
}
