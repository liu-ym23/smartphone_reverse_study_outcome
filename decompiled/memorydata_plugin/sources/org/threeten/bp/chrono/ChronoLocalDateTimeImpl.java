package org.threeten.bp.chrono;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes8.dex */
final class ChronoLocalDateTimeImpl<D extends ChronoLocalDate> extends ChronoLocalDateTime<D> implements Serializable, Temporal, TemporalAdjuster {
    private static final int HOURS_PER_DAY = 24;
    private static final long MICROS_PER_DAY = 86400000000L;
    private static final long MILLIS_PER_DAY = 86400000;
    private static final int MINUTES_PER_DAY = 1440;
    private static final int MINUTES_PER_HOUR = 60;
    private static final long NANOS_PER_DAY = 86400000000000L;
    private static final long NANOS_PER_HOUR = 3600000000000L;
    private static final long NANOS_PER_MINUTE = 60000000000L;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 4556003607393004514L;
    private final D date;
    private final LocalTime time;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.ChronoLocalDateTimeImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit = null;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0;
            r0[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    private ChronoLocalDateTimeImpl(D r2, LocalTime r3) {
        Jdk8Methods.requireNonNull(r2, "date");
        Jdk8Methods.requireNonNull(r3, OaidModel.KEY_TIME);
        this.date = r2;
        this.time = r3;
    }

    static <R extends ChronoLocalDate> ChronoLocalDateTimeImpl<R> of(R r1, LocalTime r2) {
        return new ChronoLocalDateTimeImpl(r1, r2);
    }

    private ChronoLocalDateTimeImpl<D> plusDays(long r3) {
        return with(this.date.plus(r3, ChronoUnit.DAYS), this.time);
    }

    private ChronoLocalDateTimeImpl<D> plusHours(long r11) {
        return plusWithOverflow(this.date, r11, 0, 0, 0);
    }

    private ChronoLocalDateTimeImpl<D> plusMinutes(long r11) {
        return plusWithOverflow(this.date, 0, r11, 0, 0);
    }

    private ChronoLocalDateTimeImpl<D> plusNanos(long r11) {
        return plusWithOverflow(this.date, 0, 0, 0, r11);
    }

    private ChronoLocalDateTimeImpl<D> plusWithOverflow(D r17, long r18, long r20, long r22, long r24) {
        ChronoLocalDate r1 = r17;
        if ((((r18 | r20) | r22) | r24) != 0) goto L7;
        LocalTime r2 = this.time;
    L6:
        return with(r1, r2);
    L7:
        long r4 = (((r24 / NANOS_PER_DAY) + (r22 / TimeUtils.SECONDS_PER_DAY)) + (r20 / 1440)) + (r18 / 24);
        long r12 = (((r24 % NANOS_PER_DAY) + ((r22 % TimeUtils.SECONDS_PER_DAY) * NANOS_PER_SECOND)) + ((r20 % 1440) * NANOS_PER_MINUTE)) + ((r18 % 24) * NANOS_PER_HOUR);
        long r6 = this.time.toNanoOfDay();
        long r13 = r12 + r6;
        long r5 = r4 + Jdk8Methods.floorDiv(r13, NANOS_PER_DAY);
        long r3 = Jdk8Methods.floorMod(r13, NANOS_PER_DAY);
        if (r3 != r6) goto L10;
        r2 = this.time;
    L11:
        r1 = r1.plus(r5, ChronoUnit.DAYS);
        goto L6
    L10:
        r2 = LocalTime.ofNanoOfDay(r3);
        goto L11
    }

    static ChronoLocalDateTime<?> readExternal(ObjectInput r3) {
        ObjectInput r4 = (ObjectInput) ZeusTransformUtils.wrapperContextForParams(r3, ObjectInput.class, "com.obric.memorydata.plugin");
        return ((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r4.readObject(), ChronoLocalDate.class, "com.obric.memorydata.plugin")).atTime((LocalTime) ZeusTransformUtils.preCheckCast(r4.readObject(), LocalTime.class, "com.obric.memorydata.plugin"));
    }

    private ChronoLocalDateTimeImpl<D> with(Temporal r3, LocalTime r4) {
        Temporal r5 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.memorydata.plugin");
        D r0 = this.date;
        if (r0 != r5) goto L8;
        if (this.time != r4) goto L8;
        return this;
    L8:
        return new ChronoLocalDateTimeImpl(r0.getChronology().ensureChronoLocalDate(r5), r4);
    }

    private Object writeReplace() {
        return new Ser((byte) 12, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoZonedDateTime<D> atZone(ZoneId r2) {
        return ChronoZonedDateTimeImpl.ofBest(this, r2, null);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L10;
        if (r5.isTimeBased() == false) goto L8;
        return this.time.get(r5);
    L8:
        return this.date.get(r5);
    L10:
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L10;
        if (r4.isTimeBased() == false) goto L8;
        return this.time.getLong(r4);
    L8:
        return this.date.getLong(r4);
    L10:
        return r4.getFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == true) goto L5;
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

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDateTime plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> plus(long r5, TemporalUnit r7) {
        TemporalUnit r8 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r7, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, ChronoUnit.class) == false) goto L23;
        ChronoUnit r0 = (ChronoUnit) ZeusTransformUtils.preCheckCast(r8, ChronoUnit.class, "com.obric.memorydata.plugin");
        switch(AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[r0.ordinal()]) {
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
        return with(this.date.plus(r5, r8), this.time);
    L9:
        return plusDays(r5 / 256).plusHours((r5 % 256) * 12);
    L11:
        return plusHours(r5);
    L13:
        return plusMinutes(r5);
    L15:
        return plusSeconds(r5);
    L17:
        return plusDays(r5 / 86400000).plusNanos((r5 % 86400000) * TimeUtils.NANOSECONDS_PER_MILLISECOND);
    L19:
        return plusDays(r5 / MICROS_PER_DAY).plusNanos((r5 % MICROS_PER_DAY) * 1000);
    L21:
        return plusNanos(r5);
    L23:
        return this.date.getChronology().ensureChronoLocalDateTime(r8.addTo(this, r5));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    ChronoLocalDateTimeImpl<D> plusSeconds(long r11) {
        return plusWithOverflow(this.date, 0, 0, r11, 0);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L10;
        if (r4.isTimeBased() == false) goto L8;
        return this.time.range(r4);
    L8:
        return this.date.range(r4);
    L10:
        return r4.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public D toLocalDate() {
        return this.date;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r6, TemporalUnit r7) {
        Temporal r8 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r6, Temporal.class, "com.obric.memorydata.plugin");
        TemporalUnit r9 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r7, TemporalUnit.class, "com.obric.memorydata.plugin");
        ChronoLocalDateTime<?> r10 = toLocalDate().getChronology().localDateTime(r8);
        if (ZeusTransformUtils.instanceOf(r9, ChronoUnit.class) == false) goto L26;
        ChronoUnit r0 = (ChronoUnit) ZeusTransformUtils.preCheckCast(r9, ChronoUnit.class, "com.obric.memorydata.plugin");
        if (r0.isTimeBased() == false) goto L20;
        long r1 = r10.getLong(ChronoField.EPOCH_DAY) - this.date.getLong(ChronoField.EPOCH_DAY);
        switch(AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[r0.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L19;
        };
    L9:
        int r2 = 2;
    L13:
        r1 = Jdk8Methods.safeMultiply(r1, r2);
        goto L19
    L10:
        r2 = 24;
        goto L13
    L11:
        r2 = MINUTES_PER_DAY;
        goto L13
    L12:
        r2 = SECONDS_PER_DAY;
        goto L13
    L14:
        long r3 = 86400000;
    L17:
        r1 = Jdk8Methods.safeMultiply(r1, r3);
        goto L19
    L15:
        r3 = MICROS_PER_DAY;
        goto L17
    L16:
        r3 = NANOS_PER_DAY;
    L19:
        return Jdk8Methods.safeAdd(r1, this.time.until(r10.toLocalTime(), r9));
    L20:
        ChronoLocalDate r4 = r10.toLocalDate();
        if (r10.toLocalTime().isBefore(this.time) == false) goto L24;
        r4 = r4.minus(1, ChronoUnit.DAYS);
    L24:
        return this.date.until(r4, r9);
    L26:
        return r9.between(this, r10);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDateTime with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDateTime with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> with(TemporalAdjuster r4) {
        TemporalAdjuster r5 = (TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAdjuster.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoLocalDate.class) == false) goto L7;
        return with((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r5, ChronoLocalDate.class, "com.obric.memorydata.plugin"), this.time);
    L7:
        if (ZeusTransformUtils.instanceOf(r5, LocalTime.class) == false) goto L11;
        return with(this.date, (LocalTime) ZeusTransformUtils.preCheckCast(r5, LocalTime.class, "com.obric.memorydata.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r5, ChronoLocalDateTimeImpl.class) == false) goto L15;
        return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) ZeusTransformUtils.preCheckCast(r5, ChronoLocalDateTimeImpl.class, "com.obric.memorydata.plugin"));
    L15:
        return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) ZeusTransformUtils.preCheckCast(r5.adjustInto(this), ChronoLocalDateTimeImpl.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> with(TemporalField r3, long r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L11;
        if (r5.isTimeBased() == false) goto L9;
        return with(this.date, this.time.with(r5, r4));
    L9:
        return with(this.date.with(r5, r4), this.time);
    L11:
        return this.date.getChronology().ensureChronoLocalDateTime(r5.adjustInto(this, r4));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"), r4);
    }

    void writeExternal(ObjectOutput r3) {
        ObjectOutput r4 = (ObjectOutput) ZeusTransformUtils.wrapperContextForParams(r3, ObjectOutput.class, "com.obric.memorydata.plugin");
        r4.writeObject(this.date);
        r4.writeObject(this.time);
    }
}
