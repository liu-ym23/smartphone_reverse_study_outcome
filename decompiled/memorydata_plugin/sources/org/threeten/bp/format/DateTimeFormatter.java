package org.threeten.bp.format;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;

/* JADX INFO: loaded from: classes8.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter BASIC_ISO_DATE = null;
    public static final DateTimeFormatter ISO_DATE = null;
    public static final DateTimeFormatter ISO_DATE_TIME = null;
    public static final DateTimeFormatter ISO_INSTANT = null;
    public static final DateTimeFormatter ISO_LOCAL_DATE = null;
    public static final DateTimeFormatter ISO_LOCAL_DATE_TIME = null;
    public static final DateTimeFormatter ISO_LOCAL_TIME = null;
    public static final DateTimeFormatter ISO_OFFSET_DATE = null;
    public static final DateTimeFormatter ISO_OFFSET_DATE_TIME = null;
    public static final DateTimeFormatter ISO_OFFSET_TIME = null;
    public static final DateTimeFormatter ISO_ORDINAL_DATE = null;
    public static final DateTimeFormatter ISO_TIME = null;
    public static final DateTimeFormatter ISO_WEEK_DATE = null;
    public static final DateTimeFormatter ISO_ZONED_DATE_TIME = null;
    private static final TemporalQuery<Period> PARSED_EXCESS_DAYS = null;
    private static final TemporalQuery<Boolean> PARSED_LEAP_SECOND = null;
    public static final DateTimeFormatter RFC_1123_DATE_TIME = null;
    private final Chronology chrono;
    private final DecimalStyle decimalStyle;
    private final Locale locale;
    private final DateTimeFormatterBuilder.CompositePrinterParser printerParser;
    private final Set<TemporalField> resolverFields;
    private final ResolverStyle resolverStyle;
    private final ZoneId zone;

    static class ClassicFormat extends Format {
        private final DateTimeFormatter formatter;
        private final TemporalQuery<?> query;

        public ClassicFormat(DateTimeFormatter r3, TemporalQuery<?> r4) {
            TemporalQuery<?> r5 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r4, TemporalQuery.class, "com.obric.memorydata.plugin");
            this.formatter = r3;
            this.query = r5;
        }

        @Override // java.text.Format
        public StringBuffer format(Object r2, StringBuffer r3, FieldPosition r4) {
            Jdk8Methods.requireNonNull(r2, "obj");
            Jdk8Methods.requireNonNull(r3, "toAppendTo");
            Jdk8Methods.requireNonNull(r4, "pos");
            if (ZeusTransformUtils.instanceOf(r2, TemporalAccessor.class) == false) goto L11;
            r4.setBeginIndex(0);
            r4.setEndIndex(0);
            this.formatter.formatTo((TemporalAccessor) ZeusTransformUtils.preCheckCast(r2, TemporalAccessor.class, "com.obric.memorydata.plugin"), r3);     // Catch: RuntimeException -> L7
            return r3;
        L7:
            e = move-exception;
            throw new IllegalArgumentException(e.getMessage(), e);
        L11:
            throw new IllegalArgumentException("Format target must implement TemporalAccessor");
        }

        @Override // java.text.Format
        public Object parseObject(String r3) {
            Jdk8Methods.requireNonNull(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            TemporalQuery<?> r0 = this.query;     // Catch: RuntimeException -> L9 DateTimeParseException -> L12
            if (r0 != null) goto L8;
            return DateTimeFormatter.access$000(this.formatter, r3, null).resolve(this.formatter.getResolverStyle(), this.formatter.getResolverFields());
        L8:
            return this.formatter.parse(r3, r0);
        L12:
            e = move-exception;
            throw new ParseException(e.getMessage(), e.getErrorIndex());
        L9:
            e = move-exception;
            throw ((ParseException) ZeusTransformUtils.preCheckCast(new ParseException(e.getMessage(), 0).initCause(e), ParseException.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.text.Format
        public Object parseObject(String r5, ParsePosition r6) {
            Jdk8Methods.requireNonNull(r5, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            DateTimeParseContext.Parsed r7 = DateTimeFormatter.access$100(this.formatter, r5, r6);     // Catch: IndexOutOfBoundsException -> L16
            if (r7 == null) goto L6;
            DateTimeBuilder r8 = r7.toBuilder().resolve(this.formatter.getResolverStyle(), this.formatter.getResolverFields());     // Catch: RuntimeException -> L14
            TemporalQuery<?> r4 = this.query;     // Catch: RuntimeException -> L14
            if (r4 != null) goto L12;
            return r8;
        L12:
            return r8.build(r4);
        L14:
            r6.setErrorIndex(0);
            return null;
        L6:
            if (r6.getErrorIndex() >= 0) goto L8;
            r6.setErrorIndex(0);
        L8:
            return null;
        L17:
            if (r6.getErrorIndex() >= 0) goto L19;
            r6.setErrorIndex(0);
        L19:
            return null;
        }
    }

    static {
        DateTimeFormatter r0 = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('-').appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('-').appendValue(ChronoField.DAY_OF_MONTH, 2).toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_LOCAL_DATE = r0;
        ISO_OFFSET_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r0).appendOffsetId().toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r0).optionalStart().appendOffsetId().toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        DateTimeFormatter r2 = new DateTimeFormatterBuilder().appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(':').appendValue(ChronoField.MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).optionalStart().appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true).toFormatter(ResolverStyle.STRICT);
        ISO_LOCAL_TIME = r2;
        ISO_OFFSET_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r2).appendOffsetId().toFormatter(ResolverStyle.STRICT);
        ISO_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r2).optionalStart().appendOffsetId().toFormatter(ResolverStyle.STRICT);
        DateTimeFormatter r1 = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r0).appendLiteral('T').append(r2).toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_LOCAL_DATE_TIME = r1;
        DateTimeFormatter r3 = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r1).appendOffsetId().toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_OFFSET_DATE_TIME = r3;
        ISO_ZONED_DATE_TIME = new DateTimeFormatterBuilder().append(r3).optionalStart().appendLiteral('[').parseCaseSensitive().appendZoneRegionId().appendLiteral(']').toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_DATE_TIME = new DateTimeFormatterBuilder().append(r1).optionalStart().appendOffsetId().optionalStart().appendLiteral('[').parseCaseSensitive().appendZoneRegionId().appendLiteral(']').toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_ORDINAL_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('-').appendValue(ChronoField.DAY_OF_YEAR, 3).optionalStart().appendOffsetId().toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_WEEK_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(IsoFields.WEEK_BASED_YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral("-W").appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2).appendLiteral('-').appendValue(ChronoField.DAY_OF_WEEK, 1).optionalStart().appendOffsetId().toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_INSTANT = new DateTimeFormatterBuilder().parseCaseInsensitive().appendInstant().toFormatter(ResolverStyle.STRICT);
        BASIC_ISO_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(ChronoField.YEAR, 4).appendValue(ChronoField.MONTH_OF_YEAR, 2).appendValue(ChronoField.DAY_OF_MONTH, 2).optionalStart().appendOffset("+HHMMss", "Z").toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        HashMap r4 = new HashMap();
        r4.put(1L, "Mon");
        r4.put(2L, "Tue");
        r4.put(3L, "Wed");
        r4.put(4L, "Thu");
        r4.put(5L, "Fri");
        r4.put(6L, "Sat");
        r4.put(7L, "Sun");
        HashMap r12 = new HashMap();
        r12.put(1L, "Jan");
        r12.put(2L, "Feb");
        r12.put(3L, "Mar");
        r12.put(4L, "Apr");
        r12.put(5L, "May");
        r12.put(6L, "Jun");
        r12.put(7L, "Jul");
        r12.put(8L, "Aug");
        r12.put(9L, "Sep");
        r12.put(10L, "Oct");
        r12.put(11L, "Nov");
        r12.put(12L, "Dec");
        RFC_1123_DATE_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().parseLenient().optionalStart().appendText(ChronoField.DAY_OF_WEEK, r4).appendLiteral(", ").optionalEnd().appendValue(ChronoField.DAY_OF_MONTH, 1, 2, SignStyle.NOT_NEGATIVE).appendLiteral(' ').appendText(ChronoField.MONTH_OF_YEAR, r12).appendLiteral(' ').appendValue(ChronoField.YEAR, 4).appendLiteral(' ').appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(':').appendValue(ChronoField.MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).optionalEnd().appendLiteral(' ').appendOffset("+HHMM", "GMT").toFormatter(ResolverStyle.SMART).withChronology(IsoChronology.INSTANCE);
        PARSED_EXCESS_DAYS = new AnonymousClass1();
        PARSED_LEAP_SECOND = new AnonymousClass2();
    }

    DateTimeFormatter(DateTimeFormatterBuilder.CompositePrinterParser r3, Locale r4, DecimalStyle r5, ResolverStyle r6, Set<TemporalField> r7, Chronology r8, ZoneId r9) {
        Set<TemporalField> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        this.printerParser = (DateTimeFormatterBuilder.CompositePrinterParser) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r3, "printerParser"), DateTimeFormatterBuilder.CompositePrinterParser.class, "com.obric.memorydata.plugin");
        this.locale = (Locale) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r4, "locale"), Locale.class, "com.obric.memorydata.plugin");
        this.decimalStyle = (DecimalStyle) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r5, "decimalStyle"), DecimalStyle.class, "com.obric.memorydata.plugin");
        this.resolverStyle = (ResolverStyle) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r6, "resolverStyle"), ResolverStyle.class, "com.obric.memorydata.plugin");
        this.resolverFields = r10;
        this.chrono = r8;
        this.zone = r9;
    }

    static /* synthetic */ DateTimeBuilder access$000(DateTimeFormatter r2, CharSequence r3, ParsePosition r4) {
        return r2.parseToBuilder((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ DateTimeParseContext.Parsed access$100(DateTimeFormatter r2, CharSequence r3, ParsePosition r4) {
        return r2.parseUnresolved0((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
    }

    private DateTimeParseException createError(CharSequence r5, RuntimeException r6) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4.length() <= 64) goto L5;
        String r7 = r4.subSequence(0, 64).toString() + "...";
    L7:
        return new DateTimeParseException("Text '" + r7 + "' could not be parsed: " + r6.getMessage(), r4, 0, r6);
    L5:
        r7 = r4.toString();
        goto L7
    }

    public static DateTimeFormatter ofPattern(String r1) {
        return new DateTimeFormatterBuilder().appendPattern(r1).toFormatter();
    }

    public static DateTimeFormatter ofPattern(String r1, Locale r2) {
        return new DateTimeFormatterBuilder().appendPattern(r1).toFormatter(r2);
    }

    private DateTimeBuilder parseToBuilder(CharSequence r4, ParsePosition r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        ParsePosition r1 = r5;
    L6:
        DateTimeParseContext.Parsed r3 = parseUnresolved0(r6, r1);
        if (r3 == null) goto L17;
        if (r1.getErrorIndex() >= 0) goto L17;
        if (r5 != null) goto L15;
        if (r1.getIndex() < r6.length()) goto L17;
    L15:
        return r3.toBuilder();
    L17:
        if (r6.length() <= 64) goto L19;
        String r7 = r6.subSequence(0, 64).toString() + "...";
    L21:
        if (r1.getErrorIndex() < 0) goto L25;
        throw new DateTimeParseException("Text '" + r7 + "' could not be parsed at index " + r1.getErrorIndex(), r6, r1.getErrorIndex());
    L25:
        throw new DateTimeParseException("Text '" + r7 + "' could not be parsed, unparsed text found at index " + r1.getIndex(), r6, r1.getIndex());
    L19:
        r7 = r6.toString();
        goto L21
    L5:
        r1 = new ParsePosition(0);
        goto L6
    }

    private DateTimeParseContext.Parsed parseUnresolved0(CharSequence r3, ParsePosition r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r5, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Jdk8Methods.requireNonNull(r4, "position");
        DateTimeParseContext r0 = new DateTimeParseContext(this);
        int r1 = r4.getIndex();
        int r2 = this.printerParser.parse(r0, r5, r1);
        if (r2 >= 0) goto L6;
        r4.setErrorIndex(~r2);
        return null;
    L6:
        r4.setIndex(r2);
        return r0.toParsed();
    }

    public String format(TemporalAccessor r3) {
        TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder(32);
        formatTo(r4, r0);
        return r0.toString();
    }

    public void formatTo(TemporalAccessor r3, Appendable r4) {
        TemporalAccessor r5 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin");
        Appendable r6 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r5, "temporal");
        Jdk8Methods.requireNonNull(r6, "appendable");
        DateTimePrintContext r0 = new DateTimePrintContext(r5, this);     // Catch: IOException -> L8
        if (ZeusTransformUtils.instanceOf(r6, StringBuilder.class) == false) goto L6;
        this.printerParser.print(r0, (StringBuilder) ZeusTransformUtils.preCheckCast(r6, StringBuilder.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L8
        return;
    L6:
        StringBuilder r7 = new StringBuilder(32);     // Catch: IOException -> L8
        this.printerParser.print(r0, r7);     // Catch: IOException -> L8
        r6.append(r7);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new DateTimeException(e.getMessage(), e);
    }

    public Chronology getChronology() {
        return this.chrono;
    }

    public DecimalStyle getDecimalStyle() {
        return this.decimalStyle;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public Set<TemporalField> getResolverFields() {
        return this.resolverFields;
    }

    public ResolverStyle getResolverStyle() {
        return this.resolverStyle;
    }

    public ZoneId getZone() {
        return this.zone;
    }

    public <T> T parse(CharSequence r4, TemporalQuery<T> r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        TemporalQuery r7 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r5, TemporalQuery.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Jdk8Methods.requireNonNull(r7, "type");
        return (T) parseToBuilder(r6, null).resolve(this.resolverStyle, this.resolverFields).build(r7);
    L8:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        throw createError(r6, e);
    }

    DateTimeFormatterBuilder.CompositePrinterParser toPrinterParser(boolean r1) {
        return this.printerParser.withOptional(r1);
    }

    public String toString() {
        String r2 = this.printerParser.toString();
        if (r2.startsWith("[") == false) goto L6;
        return r2;
    L6:
        return r2.substring(1, r2.length() - 1);
    }

    public DateTimeFormatter withChronology(Chronology r10) {
        if (Jdk8Methods.equals(this.chrono, r10) == false) goto L6;
        return this;
    L6:
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, this.resolverFields, r10, this.zone);
    }

    public DateTimeFormatter withResolverStyle(ResolverStyle r10) {
        Jdk8Methods.requireNonNull(r10, "resolverStyle");
        if (Jdk8Methods.equals(this.resolverStyle, r10) == false) goto L6;
        return this;
    L6:
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, r10, this.resolverFields, this.chrono, this.zone);
    }
}
