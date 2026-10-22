package org.threeten.bp.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

/* JADX INFO: loaded from: classes8.dex */
final class DateTimePrintContext {
    private Locale locale;
    private int optional;
    private DecimalStyle symbols;
    private TemporalAccessor temporal;

    DateTimePrintContext(TemporalAccessor r3, DateTimeFormatter r4) {
        this.temporal = adjust((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin"), r4);
        this.locale = r4.getLocale();
        this.symbols = r4.getDecimalStyle();
    }

    private static TemporalAccessor adjust(TemporalAccessor r10, DateTimeFormatter r11) {
        final TemporalAccessor r12 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r10, TemporalAccessor.class, "com.obric.memorydata.plugin");
        Chronology r0 = r11.getChronology();
        ZoneId r13 = r11.getZone();
        if (r0 != null) goto L6;
        if (r13 != null) goto L6;
        return r12;
    L6:
        Chronology r2 = (Chronology) ZeusTransformUtils.preCheckCast(r12.query(TemporalQueries.chronology()), Chronology.class, "com.obric.memorydata.plugin");
        final ZoneId r3 = (ZoneId) ZeusTransformUtils.preCheckCast(r12.query(TemporalQueries.zoneId()), ZoneId.class, "com.obric.memorydata.plugin");
        final ChronoLocalDate r5 = null;
        if (Jdk8Methods.equals(r2, r0) == false) goto L10;
        r0 = null;
    L10:
        if (Jdk8Methods.equals(r3, r13) == false) goto L12;
        r13 = null;
    L12:
        if (r0 != null) goto L15;
        if (r13 != null) goto L15;
        return r12;
    L15:
        if (r0 == null) goto L17;
        final Chronology r4 = r0;
    L18:
        if (r13 == null) goto L21;
        r3 = r13;
    L21:
        if (r13 != null) goto L23;
    L37:
        if (r0 == null) goto L55;
        if (r12.isSupported(ChronoField.EPOCH_DAY) == false) goto L42;
        r5 = r4.date(r12);
        goto L55
    L42:
        if (r0 != IsoChronology.INSTANCE) goto L44;
        if (r2 == null) goto L55;
    L44:
        ChronoField[] r14 = ChronoField.values();
        int r1 = r14.length;
        int r6 = 0;
    L45:
        if (r6 >= r1) goto L55;
        ChronoField r7 = r14[r6];
        if (r7.isDateBased() == false) goto L53;
        if (r12.isSupported(r7) == false) goto L53;
        throw new DateTimeException("Invalid override chronology for temporal: " + r0 + " " + r12);
    L53:
        r6 = r6 + 1;
    L55:
        return new AnonymousClass1(r5, r12, r4, r3);
    L23:
        if (r12.isSupported(ChronoField.INSTANT_SECONDS) == false) goto L29;
        if (r4 != null) goto L28;
        r4 = IsoChronology.INSTANCE;
    L28:
        return r4.zonedDateTime(Instant.from(r12), r13);
    L29:
        ZoneId r8 = r13.normalized();
        ZoneOffset r9 = (ZoneOffset) ZeusTransformUtils.preCheckCast(r12.query(TemporalQueries.offset()), ZoneOffset.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, ZoneOffset.class) == false) goto L37;
        if (r9 == null) goto L37;
        if (r8.equals(r9) == true) goto L37;
        throw new DateTimeException("Invalid override zone for temporal: " + r13 + " " + r12);
    L17:
        r4 = r2;
        goto L18
    }

    void endOptional() {
        this.optional--;
    }

    Locale getLocale() {
        return this.locale;
    }

    DecimalStyle getSymbols() {
        return this.symbols;
    }

    TemporalAccessor getTemporal() {
        return this.temporal;
    }

    Long getValue(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        return Long.valueOf(this.temporal.getLong(r4));
    L5:
        e = move-exception;
        if (this.optional <= 0) goto L10;
        return null;
    L10:
        throw e;
    }

    <R> R getValue(TemporalQuery<R> r3) {
        R r4 = (R) this.temporal.query((TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin"));
        if (r4 == null) goto L5;
    L9:
        return r4;
    L5:
        if (this.optional != 0) goto L9;
        throw new DateTimeException("Unable to extract value: " + this.temporal.getClass());
    }

    void startOptional() {
        this.optional++;
    }

    public String toString() {
        return this.temporal.toString();
    }
}
