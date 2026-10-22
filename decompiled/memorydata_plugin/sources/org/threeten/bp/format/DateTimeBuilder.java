package org.threeten.bp.format;

import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

/* JADX INFO: loaded from: classes8.dex */
final class DateTimeBuilder extends DefaultInterfaceTemporalAccessor implements Cloneable {
    Chronology chrono;
    ChronoLocalDate date;
    Period excessDays;
    final Map<TemporalField, Long> fieldValues;
    boolean leapSecond;
    LocalTime time;
    ZoneId zone;

    public DateTimeBuilder() {
        this.fieldValues = new HashMap();
    }

    private void checkDate(LocalDate r9) {
        if (r9 == null) goto L16;
        addObject(r9);
        Iterator<TemporalField> r0 = this.fieldValues.keySet().iterator();
    L5:
        if (r0.hasNext() == false) goto L28;
        TemporalField r1 = (TemporalField) ZeusTransformUtils.preCheckCast(r0.next(), TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, ChronoField.class) == false) goto L5;
        if (r1.isDateBased() == false) goto L5;
        long r4 = r9.getLong(r1);     // Catch: DateTimeException -> L17
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(r1), Long.class, "com.obric.memorydata.plugin");
        if (r4 == r2.longValue()) goto L5;
        throw new DateTimeException("Conflict found: Field " + r1 + " " + r4 + " differs from " + r1 + " " + r2 + " derived from " + r9);
    L28:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.threeten.bp.chrono.ChronoLocalDate] */
    /* JADX WARN: Type inference failed for: r0v3, types: [org.threeten.bp.LocalTime] */
    /* JADX WARN: Type inference failed for: r0v4, types: [org.threeten.bp.temporal.TemporalAccessor] */
    /* JADX WARN: Type inference failed for: r0v5, types: [org.threeten.bp.chrono.ChronoLocalDateTime] */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.threeten.bp.format.DateTimeBuilder] */
    private void crossCheck() {
        if (this.fieldValues.size() <= 0) goto L14;
        ?? r0 = this.date;
        if (r0 == 0) goto L9;
        LocalTime r1 = this.time;
        if (r1 == null) goto L9;
        r0 = r0.atTime(r1);
    L10:
        crossCheck(r0);
        return;
    L9:
        if (r0 != 0) goto L10;
        r0 = this.time;
        if (r0 != 0) goto L10;
        return;
    }

    private void crossCheck(TemporalAccessor r8) {
        TemporalAccessor r9 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r8, TemporalAccessor.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<TemporalField, Long>> r7 = this.fieldValues.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        TemporalField r2 = (TemporalField) ZeusTransformUtils.preCheckCast(r0.getKey(), TemporalField.class, "com.obric.memorydata.plugin");
        long r3 = ((Long) ZeusTransformUtils.preCheckCast(r0.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r9.isSupported(r2) == false) goto L4;
        long r5 = r9.getLong(r2);     // Catch: RuntimeException -> L14
        if (r5 != r3) goto L12;
        r7.remove();
        goto L4
    L12:
        throw new DateTimeException("Cross check failed: " + r2 + " " + r5 + " vs " + r2 + " " + r3);
    }

    private Long getFieldValue0(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        return (Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(r4), Long.class, "com.obric.memorydata.plugin");
    }

    private void mergeDate(ResolverStyle r3) {
        if (ZeusTransformUtils.instanceOf(this.chrono, IsoChronology.class) == false) goto L6;
        checkDate(IsoChronology.INSTANCE.resolveDate(this.fieldValues, r3));
        return;
    L6:
        if (this.fieldValues.containsKey(ChronoField.EPOCH_DAY) == false) goto L10;
        checkDate(LocalDate.ofEpochDay(((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.EPOCH_DAY), Long.class, "com.obric.memorydata.plugin")).longValue()));
        return;
    }

    private void mergeInstantFields() {
        if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS) == false) goto L10;
        ZoneId r0 = this.zone;
        if (r0 == null) goto L7;
    L6:
        mergeInstantFields0(r0);
        return;
    L7:
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.OFFSET_SECONDS), Long.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L12;
        r0 = ZoneOffset.ofTotalSeconds(r1.intValue());
        goto L6
    L12:
        return;
    }

    private void mergeInstantFields0(ZoneId r4) {
        ChronoZonedDateTime<?> r5 = this.chrono.zonedDateTime(Instant.ofEpochSecond(((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.INSTANT_SECONDS), Long.class, "com.obric.memorydata.plugin")).longValue()), r4);
        if (this.date != null) goto L5;
        addObject(r5.toLocalDate());
    L6:
        addFieldValue(ChronoField.SECOND_OF_DAY, r5.toLocalTime().toSecondOfDay());
        return;
    L5:
        resolveMakeChanges(ChronoField.INSTANT_SECONDS, r5.toLocalDate());
        goto L6
    }

    private void mergeTime(ResolverStyle r13) {
        long r1 = 0;
        if (this.fieldValues.containsKey(ChronoField.CLOCK_HOUR_OF_DAY) == false) goto L17;
        long r4 = ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.CLOCK_HOUR_OF_DAY), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r13 != ResolverStyle.LENIENT) goto L7;
    L12:
        ChronoField r0 = ChronoField.HOUR_OF_DAY;
        if (r4 != 24) goto L15;
        r4 = 0;
    L15:
        addFieldValue(r0, r4);
        goto L17
    L7:
        if (r13 == ResolverStyle.SMART) goto L9;
    L11:
        ChronoField.CLOCK_HOUR_OF_DAY.checkValidValue(r4);
        goto L12
    L9:
        if (r4 != 0) goto L11;
    L17:
        if (this.fieldValues.containsKey(ChronoField.CLOCK_HOUR_OF_AMPM) == false) goto L32;
        long r6 = ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.CLOCK_HOUR_OF_AMPM), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r13 != ResolverStyle.LENIENT) goto L21;
    L26:
        ChronoField r2 = ChronoField.HOUR_OF_AMPM;
        if (r6 == 12) goto L30;
        r1 = r6;
    L30:
        addFieldValue(r2, r1);
        goto L32
    L21:
        if (r13 == ResolverStyle.SMART) goto L23;
    L25:
        ChronoField.CLOCK_HOUR_OF_AMPM.checkValidValue(r6);
        goto L26
    L23:
        if (r6 != 0) goto L25;
    L32:
        if (r13 == ResolverStyle.LENIENT) goto L40;
        if (this.fieldValues.containsKey(ChronoField.AMPM_OF_DAY) == false) goto L37;
        ChronoField.AMPM_OF_DAY.checkValidValue(((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.AMPM_OF_DAY), Long.class, "com.obric.memorydata.plugin")).longValue());
    L37:
        if (this.fieldValues.containsKey(ChronoField.HOUR_OF_AMPM) == false) goto L40;
        ChronoField.HOUR_OF_AMPM.checkValidValue(((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.HOUR_OF_AMPM), Long.class, "com.obric.memorydata.plugin")).longValue());
    L40:
        if (this.fieldValues.containsKey(ChronoField.AMPM_OF_DAY) == false) goto L45;
        if (this.fieldValues.containsKey(ChronoField.HOUR_OF_AMPM) == false) goto L45;
        long r3 = ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.AMPM_OF_DAY), Long.class, "com.obric.memorydata.plugin")).longValue();
        addFieldValue(ChronoField.HOUR_OF_DAY, (r3 * 12) + ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.HOUR_OF_AMPM), Long.class, "com.obric.memorydata.plugin")).longValue());
    L45:
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_DAY) == false) goto L51;
        long r5 = ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.NANO_OF_DAY), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r13 == ResolverStyle.LENIENT) goto L49;
        ChronoField.NANO_OF_DAY.checkValidValue(r5);
    L49:
        addFieldValue(ChronoField.SECOND_OF_DAY, r5 / 1000000000);
        addFieldValue(ChronoField.NANO_OF_SECOND, r5 % 1000000000);
    L51:
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_DAY) == false) goto L57;
        long r7 = ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.MICRO_OF_DAY), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r13 == ResolverStyle.LENIENT) goto L55;
        ChronoField.MICRO_OF_DAY.checkValidValue(r7);
    L55:
        addFieldValue(ChronoField.SECOND_OF_DAY, r7 / TimeUtils.NANOSECONDS_PER_MILLISECOND);
        addFieldValue(ChronoField.MICRO_OF_SECOND, r7 % TimeUtils.NANOSECONDS_PER_MILLISECOND);
    L57:
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_DAY) == false) goto L63;
        long r8 = ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.MILLI_OF_DAY), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r13 == ResolverStyle.LENIENT) goto L61;
        ChronoField.MILLI_OF_DAY.checkValidValue(r8);
    L61:
        addFieldValue(ChronoField.SECOND_OF_DAY, r8 / 1000);
        addFieldValue(ChronoField.MILLI_OF_SECOND, r8 % 1000);
    L63:
        if (this.fieldValues.containsKey(ChronoField.SECOND_OF_DAY) == false) goto L69;
        long r9 = ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.SECOND_OF_DAY), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r13 == ResolverStyle.LENIENT) goto L67;
        ChronoField.SECOND_OF_DAY.checkValidValue(r9);
    L67:
        addFieldValue(ChronoField.HOUR_OF_DAY, r9 / TimeUtils.SECONDS_PER_HOUR);
        addFieldValue(ChronoField.MINUTE_OF_HOUR, (r9 / 60) % 60);
        addFieldValue(ChronoField.SECOND_OF_MINUTE, r9 % 60);
    L69:
        if (this.fieldValues.containsKey(ChronoField.MINUTE_OF_DAY) == false) goto L75;
        long r10 = ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.MINUTE_OF_DAY), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r13 == ResolverStyle.LENIENT) goto L73;
        ChronoField.MINUTE_OF_DAY.checkValidValue(r10);
    L73:
        addFieldValue(ChronoField.HOUR_OF_DAY, r10 / 60);
        addFieldValue(ChronoField.MINUTE_OF_HOUR, r10 % 60);
    L75:
        if (r13 == ResolverStyle.LENIENT) goto L83;
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND) == false) goto L80;
        ChronoField.MILLI_OF_SECOND.checkValidValue(((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.MILLI_OF_SECOND), Long.class, "com.obric.memorydata.plugin")).longValue());
    L80:
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND) == false) goto L83;
        ChronoField.MICRO_OF_SECOND.checkValidValue(((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.MICRO_OF_SECOND), Long.class, "com.obric.memorydata.plugin")).longValue());
    L83:
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND) == false) goto L88;
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND) == false) goto L88;
        addFieldValue(ChronoField.MICRO_OF_SECOND, (((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.MILLI_OF_SECOND), Long.class, "com.obric.memorydata.plugin")).longValue() * 1000) + (((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.MICRO_OF_SECOND), Long.class, "com.obric.memorydata.plugin")).longValue() % 1000));
    L88:
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND) == false) goto L93;
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND) == false) goto L93;
        addFieldValue(ChronoField.MICRO_OF_SECOND, ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.NANO_OF_SECOND), Long.class, "com.obric.memorydata.plugin")).longValue() / 1000);
        this.fieldValues.remove(ChronoField.MICRO_OF_SECOND);
    L93:
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND) == false) goto L98;
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND) == false) goto L98;
        addFieldValue(ChronoField.MILLI_OF_SECOND, ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.NANO_OF_SECOND), Long.class, "com.obric.memorydata.plugin")).longValue() / TimeUtils.NANOSECONDS_PER_MILLISECOND);
        this.fieldValues.remove(ChronoField.MILLI_OF_SECOND);
    L98:
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND) == false) goto L101;
        addFieldValue(ChronoField.NANO_OF_SECOND, ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.MICRO_OF_SECOND), Long.class, "com.obric.memorydata.plugin")).longValue() * 1000);
        return;
    L101:
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND) == false) goto L105;
        addFieldValue(ChronoField.NANO_OF_SECOND, ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.remove(ChronoField.MILLI_OF_SECOND), Long.class, "com.obric.memorydata.plugin")).longValue() * TimeUtils.NANOSECONDS_PER_MILLISECOND);
        return;
    }

    private DateTimeBuilder putFieldValue0(TemporalField r3, long r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        this.fieldValues.put(r5, Long.valueOf(r4));
        return this;
    }

    private boolean resolveFields(ResolverStyle r8) {
        int r1 = 0;
    L4:
        if (r1 >= 100) goto L35;
        Iterator<Map.Entry<TemporalField, Long>> r3 = this.fieldValues.entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L35;
        TemporalField r4 = (TemporalField) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), TemporalField.class, "com.obric.memorydata.plugin");
        TemporalAccessor r5 = r4.resolve(this.fieldValues, this, r8);
        if (r5 != null) goto L11;
        if (this.fieldValues.containsKey(r4) == true) goto L7;
    L34:
        r1 = r1 + 1;
        goto L4
    L11:
        if (ZeusTransformUtils.instanceOf(r5, ChronoZonedDateTime.class) == false) goto L21;
        ChronoZonedDateTime r2 = (ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r5, ChronoZonedDateTime.class, "com.obric.memorydata.plugin");
        ZoneId r6 = this.zone;
        if (r6 != null) goto L16;
        this.zone = r2.getZone();
    L17:
        r5 = r2.toLocalDateTime();
        goto L21
    L16:
        if (r6.equals(r2.getZone()) == true) goto L17;
        throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + this.zone);
    L21:
        if (ZeusTransformUtils.instanceOf(r5, ChronoLocalDate.class) == false) goto L24;
        resolveMakeChanges(r4, (ChronoLocalDate) ZeusTransformUtils.preCheckCast(r5, ChronoLocalDate.class, "com.obric.memorydata.plugin"));
        goto L34
    L24:
        if (ZeusTransformUtils.instanceOf(r5, LocalTime.class) == false) goto L28;
        LocalTime r7 = (LocalTime) ZeusTransformUtils.preCheckCast(r5, LocalTime.class, "com.obric.memorydata.plugin");
    L26:
        resolveMakeChanges(r4, r7);
        goto L34
    L28:
        if (ZeusTransformUtils.instanceOf(r5, ChronoLocalDateTime.class) == false) goto L31;
        ChronoLocalDateTime r9 = (ChronoLocalDateTime) ZeusTransformUtils.preCheckCast(r5, ChronoLocalDateTime.class, "com.obric.memorydata.plugin");
        resolveMakeChanges(r4, r9.toLocalDate());
        r7 = r9.toLocalTime();
        goto L26
    L31:
        throw new DateTimeException("Unknown type: " + r5.getClass().getName());
    L35:
        if (r1 == 100) goto L40;
        if (r1 <= 0) goto L50;
        return true;
    L50:
        return false;
    L40:
        throw new DateTimeException("Badly written field");
    }

    private void resolveFractional() {
        if (this.time == null) goto L5;
        return;
    L5:
        if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS) == true) goto L11;
        if (this.fieldValues.containsKey(ChronoField.SECOND_OF_DAY) == true) goto L11;
        if (this.fieldValues.containsKey(ChronoField.SECOND_OF_MINUTE) == true) goto L11;
        return;
    L11:
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND) == false) goto L13;
        long r0 = ((Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.NANO_OF_SECOND), Long.class, "com.obric.memorydata.plugin")).longValue();
        this.fieldValues.put(ChronoField.MICRO_OF_SECOND, Long.valueOf(r0 / 1000));
        this.fieldValues.put(ChronoField.MILLI_OF_SECOND, Long.valueOf(r0 / TimeUtils.NANOSECONDS_PER_MILLISECOND));
        return;
    L13:
        this.fieldValues.put(ChronoField.NANO_OF_SECOND, 0L);
        this.fieldValues.put(ChronoField.MICRO_OF_SECOND, 0L);
        this.fieldValues.put(ChronoField.MILLI_OF_SECOND, 0L);
    }

    private void resolveInstant() {
        ChronoLocalDate r0 = this.date;
        if (r0 == null) goto L13;
        LocalTime r1 = this.time;
        if (r1 != null) goto L7;
        return;
    L7:
        if (this.zone == null) goto L10;
        TemporalAccessor r2 = r0.atTime(r1).atZone(this.zone);
    L9:
        long r3 = r2.getLong(ChronoField.INSTANT_SECONDS);
        this.fieldValues.put(ChronoField.INSTANT_SECONDS, Long.valueOf(r3));
        return;
    L10:
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.OFFSET_SECONDS), Long.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L16;
        ZoneOffset r5 = ZoneOffset.ofTotalSeconds(r4.intValue());
        r2 = this.date.atTime(this.time).atZone(r5);
        goto L9
    L16:
        return;
    }

    private void resolveMakeChanges(TemporalField r6, LocalTime r7) {
        TemporalField r8 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r6, TemporalField.class, "com.obric.memorydata.plugin");
        long r2 = r7.toNanoOfDay();
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(this.fieldValues.put(ChronoField.NANO_OF_DAY, Long.valueOf(r2)), Long.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.longValue() != r2) goto L8;
        return;
    L8:
        throw new DateTimeException("Conflict found: " + LocalTime.ofNanoOfDay(r5.longValue()) + " differs from " + r7 + " while resolving  " + r8);
    }

    private void resolveMakeChanges(TemporalField r7, ChronoLocalDate r8) {
        TemporalField r9 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r7, TemporalField.class, "com.obric.memorydata.plugin");
        if (this.chrono.equals(r8.getChronology()) == false) goto L13;
        long r2 = r8.toEpochDay();
        Long r6 = (Long) ZeusTransformUtils.preCheckCast(this.fieldValues.put(ChronoField.EPOCH_DAY, Long.valueOf(r2)), Long.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.longValue() != r2) goto L10;
        return;
    L10:
        throw new DateTimeException("Conflict found: " + LocalDate.ofEpochDay(r6.longValue()) + " differs from " + LocalDate.ofEpochDay(r2) + " while resolving  " + r9);
    L13:
        throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.chrono);
    }

    private void resolveTimeInferZeroes(ResolverStyle r13) {
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.HOUR_OF_DAY), Long.class, "com.obric.memorydata.plugin");
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.MINUTE_OF_HOUR), Long.class, "com.obric.memorydata.plugin");
        Long r3 = (Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.SECOND_OF_MINUTE), Long.class, "com.obric.memorydata.plugin");
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(this.fieldValues.get(ChronoField.NANO_OF_SECOND), Long.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r1 != null) goto L9;
        if (r3 != null) goto L8;
        if (r2 == null) goto L9;
        return;
    L8:
        return;
    L9:
        if (r1 == null) goto L14;
        if (r3 != null) goto L14;
        if (r2 == null) goto L14;
        return;
    L14:
        if (r13 == ResolverStyle.LENIENT) goto L44;
        if (r0 != null) goto L17;
    L54:
        this.fieldValues.remove(ChronoField.HOUR_OF_DAY);
        this.fieldValues.remove(ChronoField.MINUTE_OF_HOUR);
        this.fieldValues.remove(ChronoField.SECOND_OF_MINUTE);
        this.fieldValues.remove(ChronoField.NANO_OF_SECOND);
        return;
    L17:
        if (r13 == ResolverStyle.SMART) goto L19;
    L30:
        int r14 = ChronoField.HOUR_OF_DAY.checkValidIntValue(r0.longValue());
        if (r1 == null) goto L41;
        int r4 = ChronoField.MINUTE_OF_HOUR.checkValidIntValue(r1.longValue());
        if (r3 == null) goto L39;
        int r5 = ChronoField.SECOND_OF_MINUTE.checkValidIntValue(r3.longValue());
        if (r2 == null) goto L37;
        LocalTime r15 = LocalTime.of(r14, r4, r5, ChronoField.NANO_OF_SECOND.checkValidIntValue(r2.longValue()));
    L38:
        addObject(r15);
        goto L54
    L37:
        r15 = LocalTime.of(r14, r4, r5);
        goto L38
    L39:
        if (r2 != null) goto L54;
        r15 = LocalTime.of(r14, r4);
        goto L38
    L41:
        if (r3 != null) goto L54;
        if (r2 != null) goto L54;
        r15 = LocalTime.of(r14, 0);
        goto L38
    L19:
        if (r0.longValue() != 24) goto L30;
        if (r1 != null) goto L22;
    L23:
        if (r3 != null) goto L25;
    L26:
        if (r2 != null) goto L28;
    L29:
        r0 = 0L;
        this.excessDays = Period.ofDays(1);
        goto L30
    L28:
        if (r2.longValue() != 0) goto L30;
    L25:
        if (r3.longValue() != 0) goto L30;
    L22:
        if (r1.longValue() != 0) goto L30;
    L44:
        if (r0 == null) goto L54;
        long r10 = r0.longValue();
        if (r1 == null) goto L52;
        if (r3 == null) goto L51;
        if (r2 != null) goto L50;
        r2 = 0L;
    L50:
        long r6 = Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r10, 3600000000000L), Jdk8Methods.safeMultiply(r1.longValue(), 60000000000L)), Jdk8Methods.safeMultiply(r3.longValue(), 1000000000)), r2.longValue());
        int r16 = (int) Jdk8Methods.floorDiv(r6, 86400000000000L);
        LocalTime r7 = LocalTime.ofNanoOfDay(Jdk8Methods.floorMod(r6, 86400000000000L));
    L53:
        addObject(r7);
        this.excessDays = Period.ofDays(r16);
        goto L54
    L51:
        long r8 = Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r10, TimeUtils.SECONDS_PER_HOUR), Jdk8Methods.safeMultiply(r1.longValue(), 60));
        r16 = (int) Jdk8Methods.floorDiv(r8, TimeUtils.SECONDS_PER_DAY);
        r7 = LocalTime.ofSecondOfDay(Jdk8Methods.floorMod(r8, TimeUtils.SECONDS_PER_DAY));
        goto L53
    L52:
        r16 = Jdk8Methods.safeToInt(Jdk8Methods.floorDiv(r10, 24));
        r7 = LocalTime.of(Jdk8Methods.floorMod(r10, 24), 0);
        goto L53
    }

    DateTimeBuilder addFieldValue(TemporalField r5, long r6) {
        TemporalField r7 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r5, TemporalField.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r7, "field");
        Long r0 = getFieldValue0(r7);
        if (r0 == null) goto L10;
        if (r0.longValue() == r6) goto L10;
        throw new DateTimeException("Conflict found: " + r7 + " " + r0 + " differs from " + r7 + " " + r6 + ": " + this);
    L10:
        return putFieldValue0(r7, r6);
    }

    void addObject(LocalTime r1) {
        this.time = r1;
    }

    void addObject(ChronoLocalDate r1) {
        this.date = r1;
    }

    public <R> R build(TemporalQuery<R> r3) {
        return (R) ((TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin")).queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r4, "field");
        Long r0 = getFieldValue0(r4);
        if (r0 != null) goto L19;
        ChronoLocalDate r1 = this.date;
        if (r1 != null) goto L7;
    L10:
        LocalTime r2 = this.time;
        if (r2 == null) goto L17;
        if (r2.isSupported(r4) == false) goto L17;
        return this.time.getLong(r4);
    L17:
        throw new DateTimeException("Field not found: " + r4);
    L7:
        if (r1.isSupported(r4) == false) goto L10;
        return this.date.getLong(r4);
    L19:
        return r0.longValue();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return false;
    L6:
        if (this.fieldValues.containsKey(r4) == true) goto L15;
        ChronoLocalDate r1 = this.date;
        if (r1 != null) goto L10;
    L11:
        LocalTime r2 = this.time;
        if (r2 != null) goto L14;
        return false;
    L14:
        if (r2.isSupported(r4) == true) goto L15;
        return false;
    L10:
        if (r1.isSupported(r4) == false) goto L11;
    L15:
        return true;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<ZoneOffset> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin");
        if (r4 != TemporalQueries.zoneId()) goto L7;
        return (R) this.zone;
    L7:
        if (r4 != TemporalQueries.chronology()) goto L11;
        return (R) this.chrono;
    L11:
        if (r4 != TemporalQueries.localDate()) goto L17;
        ChronoLocalDate r2 = this.date;
        if (r2 != null) goto L15;
        return null;
    L15:
        return (R) LocalDate.from(r2);
    L17:
        if (r4 != TemporalQueries.localTime()) goto L21;
        return (R) this.time;
    L21:
        if (r4 == TemporalQueries.zone()) goto L31;
        if (r4 == TemporalQueries.offset()) goto L31;
        if (r4 != TemporalQueries.precision()) goto L29;
        return null;
    L29:
        return (R) r4.queryFrom(this);
    L31:
        return (R) r4.queryFrom(this);
    }

    public DateTimeBuilder resolve(ResolverStyle r3, Set<TemporalField> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        this.fieldValues.keySet().retainAll(r5);
    L5:
        mergeInstantFields();
        mergeDate(r3);
        mergeTime(r3);
        if (resolveFields(r3) == false) goto L8;
        mergeInstantFields();
        mergeDate(r3);
        mergeTime(r3);
    L8:
        resolveTimeInferZeroes(r3);
        crossCheck();
        Period r6 = this.excessDays;
        if (r6 != null) goto L11;
    L17:
        resolveFractional();
        resolveInstant();
        return this;
    L11:
        if (r6.isZero() == true) goto L17;
        ChronoLocalDate r7 = this.date;
        if (r7 == null) goto L17;
        if (this.time == null) goto L17;
        this.date = r7.plus(this.excessDays);
        this.excessDays = Period.ZERO;
        goto L17
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("DateTimeBuilder[");
        if (this.fieldValues.size() <= 0) goto L5;
        r0.append("fields=").append(this.fieldValues);
    L5:
        r0.append(", ").append(this.chrono);
        r0.append(", ").append(this.zone);
        r0.append(", ").append(this.date);
        r0.append(", ").append(this.time);
        r0.append(']');
        return r0.toString();
    }
}
