package org.threeten.bp.format;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.slf4j.Marker;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.WeekFields;
import org.threeten.bp.zone.ZoneRulesProvider;

/* JADX INFO: loaded from: classes8.dex */
public final class DateTimeFormatterBuilder {
    private static final Map<Character, TemporalField> FIELD_MAP = null;
    static final Comparator<String> LENGTH_SORT = null;
    private static final TemporalQuery<ZoneId> QUERY_REGION_ONLY = null;
    private DateTimeFormatterBuilder active;
    private final boolean optional;
    private char padNextChar;
    private int padNextWidth;
    private final DateTimeFormatterBuilder parent;
    private final List<DateTimePrinterParser> printerParsers;
    private int valueParserIndex;

    /* JADX INFO: renamed from: org.threeten.bp.format.DateTimeFormatterBuilder$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$format$SignStyle = null;

        static {
            int[] r0 = new int[SignStyle.values().length];
            $SwitchMap$org$threeten$bp$format$SignStyle = r0;
            r0[SignStyle.EXCEEDS_PAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.ALWAYS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.NOT_NEGATIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char literal;

        CharLiteralPrinterParser(char r1) {
            this.literal = r1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r3, CharSequence r4, int r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            if (r5 == r6.length()) goto L5;
            char r7 = r6.charAt(r5);
            if (r3.charEquals(this.literal, r7) == true) goto L11;
            return ~r5;
        L11:
            return r5 + 1;
        L5:
            return ~r5;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r1, StringBuilder r2) {
            r2.append(this.literal);
            return true;
        }

        public String toString() {
            if (this.literal != '\'') goto L7;
            return "''";
        L7:
            return "'" + this.literal + "'";
        }
    }

    static final class ChronoPrinterParser implements DateTimePrinterParser {
        private final TextStyle textStyle;

        ChronoPrinterParser(TextStyle r1) {
            this.textStyle = r1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r12, CharSequence r13, int r14) {
            CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
            if (r14 < 0) goto L20;
            if (r14 > r11.length()) goto L20;
            Iterator<Chronology> r15 = Chronology.getAvailableChronologies().iterator();
            Chronology r7 = null;
            int r8 = -1;
        L8:
            if (r15.hasNext() == false) goto L14;
            Chronology r9 = (Chronology) ZeusTransformUtils.preCheckCast(r15.next(), Chronology.class, "com.obric.memorydata.plugin");
            String r4 = r9.getId();
            int r10 = r4.length();
            if (r10 <= r8) goto L8;
            if (r12.subSequenceEquals(r11, r14, r4, 0, r10) == false) goto L8;
            r7 = r9;
            r8 = r10;
            goto L8
        L14:
            if (r7 == null) goto L16;
            r12.setParsed(r7);
            return r14 + r8;
        L16:
            return ~r14;
        L20:
            throw new IndexOutOfBoundsException();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r4, StringBuilder r5) {
            Chronology r0 = (Chronology) ZeusTransformUtils.preCheckCast(r4.getValue(TemporalQueries.chronology()), Chronology.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L7;
            return false;
        L7:
            if (this.textStyle != null) goto L9;
        L8:
            r5.append(r0.getId());
            return true;
        L9:
            ResourceBundle r3 = ResourceBundle.getBundle("org.threeten.bp.format.ChronologyText", r4.getLocale(), DateTimeFormatterBuilder.class.getClassLoader());
            r5.append(r3.getString(r0.getId()));     // Catch: MissingResourceException -> L13
            return true;
        }
    }

    static final class CompositePrinterParser implements DateTimePrinterParser {
        private final boolean optional;
        private final DateTimePrinterParser[] printerParsers;

        CompositePrinterParser(List<DateTimePrinterParser> r3, boolean r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            this((DateTimePrinterParser[]) ZeusTransformUtils.preCheckCast(r5.toArray(new DateTimePrinterParser[r5.size()]), DateTimePrinterParser[].class, "com.obric.memorydata.plugin"), r4);
        }

        CompositePrinterParser(DateTimePrinterParser[] r1, boolean r2) {
            this.printerParsers = r1;
            this.optional = r2;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r6, CharSequence r7, int r8) {
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
            int r1 = 0;
            if (this.optional == false) goto L13;
            r6.startOptional();
            DateTimePrinterParser[] r5 = this.printerParsers;
            int r0 = r5.length;
            int r3 = r8;
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L11;
            r3 = r5[r2].parse(r6, r9, r3);
            if (r3 < 0) goto L8;
            r2 = r2 + 1;
            goto L5
        L8:
            r6.endOptional(false);
            return r8;
        L11:
            r6.endOptional(true);
            return r3;
        L13:
            DateTimePrinterParser[] r10 = this.printerParsers;
            int r4 = r10.length;
        L14:
            if (r1 >= r4) goto L19;
            r8 = r10[r1].parse(r6, r9, r8);
            if (r8 < 0) goto L19;
            r1 = r1 + 1;
        L19:
            return r8;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r7, StringBuilder r8) {
            int r0 = r8.length();
            if (this.optional == false) goto L25;
            r7.startOptional();
        L25:
            DateTimePrinterParser[] r1 = this.printerParsers;     // Catch: Throwable -> L20
            int r2 = r1.length;     // Catch: Throwable -> L20
            int r3 = 0;
        L7:
            if (r3 >= r2) goto L17;
            if (r1[r3].print(r7, r8) == false) goto L10;
            r3 = r3 + 1;
            goto L7
        L10:
            r8.setLength(r0);     // Catch: Throwable -> L20
            if (this.optional == false) goto L14;
            r7.endOptional();
        L14:
            return true;
        L17:
            if (this.optional == false) goto L19;
            r7.endOptional();
        L19:
            return true;
        L20:
            th = move-exception;
            if (this.optional == false) goto L24;
            r7.endOptional();
        L24:
            throw th;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            if (this.printerParsers == null) goto L17;
            if (this.optional == false) goto L7;
            String r1 = "[";
        L8:
            r0.append(r1);
            DateTimePrinterParser[] r2 = this.printerParsers;
            int r3 = r2.length;
            int r4 = 0;
        L9:
            if (r4 >= r3) goto L12;
            r0.append(r2[r4]);
            r4 = r4 + 1;
            goto L9
        L12:
            if (this.optional == false) goto L14;
            String r5 = "]";
        L15:
            r0.append(r5);
            goto L17
        L14:
            r5 = ")";
            goto L15
        L7:
            r1 = "(";
        L17:
            return r0.toString();
        }

        public CompositePrinterParser withOptional(boolean r2) {
            if (r2 != this.optional) goto L6;
            return this;
        L6:
            return new CompositePrinterParser(this.printerParsers, r2);
        }
    }

    interface DateTimePrinterParser {
        int parse(DateTimeParseContext r1, CharSequence r2, int r3);

        boolean print(DateTimePrintContext r1, StringBuilder r2);
    }

    static final class FractionPrinterParser implements DateTimePrinterParser {
        private final boolean decimalPoint;
        private final TemporalField field;
        private final int maxWidth;
        private final int minWidth;

        FractionPrinterParser(TemporalField r3, int r4, int r5, boolean r6) {
            TemporalField r7 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
            Jdk8Methods.requireNonNull(r7, "field");
            if (r7.range().isFixed() == false) goto L20;
            if (r4 < 0) goto L18;
            if (r4 > 9) goto L18;
            if (r5 < 1) goto L16;
            if (r5 > 9) goto L16;
            if (r5 < r4) goto L14;
            this.field = r7;
            this.minWidth = r4;
            this.maxWidth = r5;
            this.decimalPoint = r6;
            return;
        L14:
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + r5 + " < " + r4);
        L16:
            throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + r5);
        L18:
            throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + r4);
        L20:
            throw new IllegalArgumentException("Field must have a fixed set of values: " + r7);
        }

        private long convertFromFraction(BigDecimal r4) {
            ValueRange r3 = this.field.range();
            BigDecimal r0 = BigDecimal.valueOf(r3.getMinimum());
            return r4.multiply(BigDecimal.valueOf(r3.getMaximum()).subtract(r0).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(r0).longValueExact();
        }

        private BigDecimal convertToFraction(long r4) {
            ValueRange r0 = this.field.range();
            r0.checkValidValue(r4, this.field);
            BigDecimal r3 = BigDecimal.valueOf(r0.getMinimum());
            BigDecimal r1 = BigDecimal.valueOf(r0.getMaximum()).subtract(r3).add(BigDecimal.ONE);
            BigDecimal r5 = BigDecimal.valueOf(r4).subtract(r3).divide(r1, 9, RoundingMode.FLOOR);
            if (r5.compareTo(BigDecimal.ZERO) != 0) goto L6;
            return BigDecimal.ZERO;
        L6:
            return r5.stripTrailingZeros();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r11, CharSequence r12, int r13) {
            CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
            int r1 = 0;
            if (r11.isStrict() == false) goto L5;
            int r0 = this.minWidth;
        L7:
            if (r11.isStrict() == false) goto L9;
            int r2 = this.maxWidth;
        L10:
            int r3 = r14.length();
            if (r13 != r3) goto L16;
            if (r0 > 0) goto L14;
            return r13;
        L14:
            return ~r13;
        L16:
            if (this.decimalPoint == true) goto L18;
        L23:
            int r8 = r13;
            int r4 = r0 + r8;
            if (r4 > r3) goto L26;
            int r15 = Math.min(r2 + r8, r3);
            int r5 = r8;
        L28:
            if (r5 >= r15) goto L36;
            int r6 = r5 + 1;
            int r7 = r11.getSymbols().convertToDigit(r14.charAt(r5));
            if (r7 < 0) goto L31;
            r1 = (r1 * 10) + r7;
            r5 = r6;
            goto L28
        L31:
            if (r6 < r4) goto L33;
            int r9 = r6 - 1;
        L38:
            return r11.setParsedField(this.field, convertFromFraction(new BigDecimal(r1).movePointLeft(r9 - r8)), r8, r9);
        L33:
            return ~r8;
        L36:
            r9 = r5;
            goto L38
        L26:
            return ~r8;
        L18:
            if (r14.charAt(r13) == r11.getSymbols().getDecimalSeparator()) goto L22;
            if (r0 > 0) goto L21;
            return r13;
        L21:
            return ~r13;
        L22:
            r13 = r13 + 1;
            goto L23
        L9:
            r2 = 9;
            goto L10
        L5:
            r0 = 0;
            goto L7
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r5, StringBuilder r6) {
            Long r0 = r5.getValue(this.field);
            int r1 = 0;
            if (r0 != null) goto L5;
            return false;
        L5:
            DecimalStyle r7 = r5.getSymbols();
            BigDecimal r2 = convertToFraction(r0.longValue());
            if (r2.scale() == 0) goto L8;
            String r3 = r7.convertNumberToI18N(r2.setScale(Math.min(Math.max(r2.scale(), this.minWidth), this.maxWidth), RoundingMode.FLOOR).toPlainString().substring(2));
            if (this.decimalPoint == false) goto L18;
            r6.append(r7.getDecimalSeparator());
        L18:
            r6.append(r3);
            return true;
        L8:
            if (this.minWidth > 0) goto L10;
            return true;
        L10:
            if (this.decimalPoint == false) goto L13;
            r6.append(r7.getDecimalSeparator());
        L13:
            if (r1 >= this.minWidth) goto L24;
            r6.append(r7.getZeroDigit());
            r1 = r1 + 1;
            goto L13
        L24:
            return true;
        }

        public String toString() {
            if (this.decimalPoint == false) goto L5;
            String r0 = ",DecimalPoint";
        L7:
            return "Fraction(" + this.field + "," + this.minWidth + "," + this.maxWidth + r0 + ")";
        L5:
            r0 = "";
            goto L7
        }
    }

    static final class InstantPrinterParser implements DateTimePrinterParser {
        private final int fractionalDigits;

        InstantPrinterParser(int r1) {
            this.fractionalDigits = r1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r19, CharSequence r20, int r21) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r20, CharSequence.class, "com.obric.memorydata.plugin");
            DateTimeParseContext r1 = r19.copy();
            int r2 = this.fractionalDigits;
            int r3 = 0;
            if (r2 >= 0) goto L5;
            int r4 = 0;
        L6:
            if (r2 >= 0) goto L8;
            r2 = 9;
        L8:
            int r5 = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE).appendLiteral('T').appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(':').appendValue(ChronoField.MINUTE_OF_HOUR, 2).appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).appendFraction(ChronoField.NANO_OF_SECOND, r4, r2, true).appendLiteral('Z').toFormatter().toPrinterParser(false).parse(r1, r0, r21);
            if (r5 >= 0) goto L11;
            return r5;
        L11:
            long r9 = r1.getParsed(ChronoField.YEAR).longValue();
            int r12 = r1.getParsed(ChronoField.MONTH_OF_YEAR).intValue();
            int r13 = r1.getParsed(ChronoField.DAY_OF_MONTH).intValue();
            int r6 = r1.getParsed(ChronoField.HOUR_OF_DAY).intValue();
            int r15 = r1.getParsed(ChronoField.MINUTE_OF_HOUR).intValue();
            Long r7 = r1.getParsed(ChronoField.SECOND_OF_MINUTE);
            Long r8 = r1.getParsed(ChronoField.NANO_OF_SECOND);
            if (r7 == null) goto L14;
            int r10 = r7.intValue();
        L15:
            if (r8 == null) goto L17;
            int r11 = r8.intValue();
        L18:
            int r14 = ((int) r9) % 10000;
            if (r6 != 24) goto L25;
            if (r15 != 0) goto L25;
            if (r10 != 0) goto L25;
            if (r11 != 0) goto L25;
            int r16 = r10;
            int r17 = 0;
            r3 = 1;
        L37:
            return r19.setParsedField(ChronoField.NANO_OF_SECOND, r11, r21, r19.setParsedField(ChronoField.INSTANT_SECONDS, Jdk8Methods.safeMultiply(r9 / 10000, 315569520000L) + LocalDateTime.of(r14, r12, r13, r17, r15, r16, 0).plusDays(r3).toEpochSecond(ZoneOffset.UTC), r21, r5));
        L36:
            return ~r21;
        L25:
            if (r6 != 23) goto L30;
            if (r15 != 59) goto L30;
            if (r10 != 60) goto L30;
            r19.setParsedLeapSecond();
            r17 = r6;
            r16 = 59;
        L30:
            r17 = r6;
            r16 = r10;
            goto L37
        L17:
            r11 = 0;
            goto L18
        L14:
            r10 = 0;
            goto L15
        L5:
            r4 = r2;
            goto L6
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r17, StringBuilder r18) {
            Long r2 = r17.getValue(ChronoField.INSTANT_SECONDS);
            Long r6 = 0L;
            if (r17.getTemporal().isSupported(ChronoField.NANO_OF_SECOND) == false) goto L5;
            r6 = Long.valueOf(r17.getTemporal().getLong(ChronoField.NANO_OF_SECOND));
        L5:
            int r3 = 0;
            if (r2 != null) goto L8;
            return false;
        L8:
            long r7 = r2.longValue();
            int r4 = ChronoField.NANO_OF_SECOND.checkValidIntValue(r6.longValue());
            if (r7 < (-62167219200L)) goto L16;
            long r8 = (r7 - 315569520000L) + 62167219200L;
            long r5 = Jdk8Methods.floorDiv(r8, 315569520000L) + 1;
            LocalDateTime r9 = LocalDateTime.ofEpochSecond(Jdk8Methods.floorMod(r8, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
            if (r5 <= 0) goto L13;
            r18.append('+').append(r5);
        L13:
            r18.append(r9);
            if (r9.getSecond() != 0) goto L29;
            r18.append(":00");
        L29:
            int r10 = this.fractionalDigits;
            if (r10 != (-2)) goto L42;
            if (r4 == 0) goto L51;
            r18.append('.');
            int r0 = 1000000;
            if ((r4 % 1000000) != 0) goto L37;
            int r11 = (r4 / 1000000) + 1000;
        L35:
            r18.append(Integer.toString(r11).substring(1));
            goto L51
        L37:
            if ((r4 % 1000) != 0) goto L39;
            r4 = r4 / 1000;
        L40:
            r11 = r4 + r0;
            goto L35
        L39:
            r0 = 1000000000;
        L51:
            r18.append('Z');
            return true;
        L42:
            if (r10 > 0) goto L45;
            if (r10 != (-1)) goto L51;
            if (r4 <= 0) goto L51;
        L45:
            r18.append('.');
            int r12 = 100000000;
        L46:
            int r13 = this.fractionalDigits;
            if (r13 != (-1)) goto L49;
            if (r4 <= 0) goto L49;
        L50:
            int r14 = r4 / r12;
            r18.append((char) (r14 + 48));
            r4 = r4 - (r14 * r12);
            r12 = r12 / 10;
            r3 = r3 + 1;
        L49:
            if (r3 >= r13) goto L51;
        L16:
            long r15 = r7 + 62167219200L;
            long r16 = r15 / 315569520000L;
            long r19 = r15 % 315569520000L;
            LocalDateTime r110 = LocalDateTime.ofEpochSecond(r19 - 62167219200L, 0, ZoneOffset.UTC);
            int r111 = r18.length();
            r18.append(r110);
            if (r110.getSecond() != 0) goto L20;
            r18.append(":00");
        L20:
            if (r16 >= 0) goto L29;
            if (r110.getYear() != (-10000)) goto L25;
            r18.replace(r111, r111 + 2, Long.toString(r16 - 1));
            goto L29
        L25:
            if (r19 == 0) goto L28;
            r111 = r111 + 1;
            r16 = Math.abs(r16);
        L28:
            r18.insert(r111, r16);
            goto L29
        }

        public String toString() {
            return "Instant()";
        }
    }

    static final class LocalizedOffsetPrinterParser implements DateTimePrinterParser {
        private final TextStyle style;

        public LocalizedOffsetPrinterParser(TextStyle r1) {
            this.style = r1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r15, CharSequence r16, int r17) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r16, CharSequence.class, "com.obric.memorydata.plugin");
            if (r15.subSequenceEquals(r7, r17, "GMT", 0, 3) == false) goto L5;
            int r6 = r17 + 3;
            if (this.style == TextStyle.FULL) goto L9;
            int r0 = r7.length();
            if (r6 == r0) goto L13;
            char r2 = r7.charAt(r6);
            if (r2 == '+') goto L20;
            if (r2 == '-') goto L20;
            return r15.setParsedField(ChronoField.OFFSET_SECONDS, 0, r6, r6);
        L20:
            if (r2 != '-') goto L22;
            int r3 = -1;
        L23:
            if (r6 == r0) goto L25;
            int r8 = r6 + 1;
            char r4 = r7.charAt(r8);
            if (r4 < '0') goto L97;
            if (r4 > '9') goto L97;
            int r9 = r8 + 1;
            int r5 = r4 - '0';
            if (r9 == r0) goto L41;
            char r10 = r7.charAt(r9);
            if (r10 < '0') goto L41;
            if (r10 > '9') goto L41;
            r5 = (r5 * 10) + (r10 - '0');
            if (r5 > 23) goto L39;
            r9 = r9 + 1;
            goto L41
        L39:
            return ~r9;
        L41:
            int r13 = r9;
            if (r13 == r0) goto L95;
            if (r7.charAt(r13) != ':') goto L95;
            int r14 = r13 + 1;
            int r11 = r0 - 2;
            if (r14 > r11) goto L49;
            char r12 = r7.charAt(r14);
            if (r12 < '0') goto L93;
            if (r12 > '9') goto L93;
            int r18 = r14 + 1;
            int r19 = r12 - '0';
            char r110 = r7.charAt(r18);
            if (r110 < '0') goto L91;
            if (r110 > '9') goto L91;
            int r111 = r18 + 1;
            int r112 = (r19 * 10) + (r110 - '0');
            if (r112 > 59) goto L61;
            if (r111 == r0) goto L89;
            if (r7.charAt(r111) != ':') goto L89;
            int r113 = r111 + 1;
            if (r113 > r11) goto L69;
            char r1 = r7.charAt(r113);
            if (r1 < '0') goto L87;
            if (r1 > '9') goto L87;
            int r114 = r113 + 1;
            int r20 = r1 - '0';
            char r21 = r7.charAt(r114);
            if (r21 < '0') goto L85;
            if (r21 > '9') goto L85;
            int r115 = r114 + 1;
            int r22 = (r20 * 10) + (r21 - '0');
            if (r22 <= 59) goto L83;
            return ~r115;
        L83:
            return r15.setParsedField(ChronoField.OFFSET_SECONDS, r3 * (((r5 * 3600) + (r112 * 60)) + r22), r115, r115);
        L85:
            return ~r114;
        L87:
            return ~r113;
        L69:
            return ~r113;
        L89:
            return r15.setParsedField(ChronoField.OFFSET_SECONDS, r3 * ((r5 * 3600) + (r112 * 60)), r111, r111);
        L61:
            return ~r111;
        L91:
            return ~r18;
        L93:
            return ~r14;
        L49:
            return ~r14;
        L95:
            return r15.setParsedField(ChronoField.OFFSET_SECONDS, (r3 * 3600) * r5, r13, r13);
        L97:
            return ~r8;
        L25:
            return ~r6;
        L22:
            r3 = 1;
            goto L23
        L13:
            return r15.setParsedField(ChronoField.OFFSET_SECONDS, 0, r6, r6);
        L9:
            return new OffsetIdPrinterParser("", "+HH:MM:ss").parse(r15, r7, r6);
        L5:
            return ~r17;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r4, StringBuilder r5) {
            Long r0 = r4.getValue(ChronoField.OFFSET_SECONDS);
            if (r0 != null) goto L6;
            return false;
        L6:
            r5.append("GMT");
            if (this.style == TextStyle.FULL) goto L9;
            int r3 = Jdk8Methods.safeToInt(r0.longValue());
            if (r3 == 0) goto L24;
            int r6 = Math.abs((r3 / 3600) % 100);
            int r1 = Math.abs((r3 / 60) % 60);
            int r2 = Math.abs(r3 % 60);
            if (r3 >= 0) goto L15;
            String r7 = "-";
        L16:
            r5.append(r7).append(r6);
            if (r1 > 0) goto L19;
            if (r2 > 0) goto L19;
            return true;
        L19:
            r5.append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append((char) ((r1 / 10) + 48)).append((char) ((r1 % 10) + 48));
            if (r2 <= 0) goto L26;
            r5.append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append((char) ((r2 / 10) + 48)).append((char) ((r2 % 10) + 48));
            return true;
        L26:
            return true;
        L15:
            r7 = Marker.ANY_NON_NULL_MARKER;
            goto L16
        L24:
            return true;
        L9:
            return new OffsetIdPrinterParser("", "+HH:MM:ss").print(r4, r5);
        }
    }

    static class NumberPrinterParser implements DateTimePrinterParser {
        static final int[] EXCEED_POINTS = null;
        final TemporalField field;
        final int maxWidth;
        final int minWidth;
        final SignStyle signStyle;
        final int subsequentWidth;

        static {
            EXCEED_POINTS = new int[]{0, 10, 100, 1000, 10000, 100000, 1000000, PoissonDistribution.DEFAULT_MAX_ITERATIONS, 100000000, 1000000000};
        }

        NumberPrinterParser(TemporalField r3, int r4, int r5, SignStyle r6) {
            this.field = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
            this.minWidth = r4;
            this.maxWidth = r5;
            this.signStyle = r6;
            this.subsequentWidth = 0;
        }

        private NumberPrinterParser(TemporalField r3, int r4, int r5, SignStyle r6, int r7) {
            this.field = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
            this.minWidth = r4;
            this.maxWidth = r5;
            this.signStyle = r6;
            this.subsequentWidth = r7;
        }

        /* synthetic */ NumberPrinterParser(TemporalField r7, int r8, int r9, SignStyle r10, int r11, AnonymousClass1 r12) {
            this((TemporalField) ZeusTransformUtils.wrapperContextForParams(r7, TemporalField.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
        }

        long getValue(DateTimePrintContext r1, long r2) {
            return r2;
        }

        boolean isFixedWidth(DateTimeParseContext r2) {
            int r3 = this.subsequentWidth;
            if (r3 == (-1)) goto L11;
            if (r3 > 0) goto L6;
        L10:
            return false;
        L6:
            if (this.minWidth != this.maxWidth) goto L10;
            if (this.signStyle != SignStyle.NOT_NEGATIVE) goto L10;
        L11:
            return true;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r19, CharSequence r20, int r21) {
            CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r20, CharSequence.class, "com.obric.memorydata.plugin");
            int r3 = r2.length();
            if (r21 == r3) goto L5;
            char r4 = r2.charAt(r21);
            int r6 = 0;
            if (r4 != r19.getSymbols().getPositiveSign()) goto L18;
            SignStyle r5 = this.signStyle;
            boolean r7 = r19.isStrict();
            if (this.minWidth != this.maxWidth) goto L11;
            boolean r8 = true;
        L13:
            if (r5.parse(true, r7, r8) == false) goto L15;
            int r9 = r21 + 1;
            boolean r1 = false;
            boolean r10 = true;
        L36:
            if (r19.isStrict() == false) goto L38;
        L41:
            int r11 = this.minWidth;
        L42:
            int r12 = r9 + r11;
            if (r12 <= r3) goto L47;
            return ~r9;
        L47:
            if (r19.isStrict() == false) goto L49;
        L52:
            int r13 = this.maxWidth;
        L53:
            int r14 = r13 + Math.max(this.subsequentWidth, 0);
        L54:
            BigInteger r15 = null;
            if (r6 >= 2) goto L76;
            int r16 = Math.min(r14 + r9, r3);
            int r17 = r9;
            long r18 = 0;
        L57:
            if (r17 >= r16) goto L71;
            int r110 = r17 + 1;
            int r111 = r19.getSymbols().convertToDigit(r2.charAt(r17));
            if (r111 < 0) goto L60;
            if ((r110 - r9) <= 18) goto L69;
            if (r15 != null) goto L68;
            r15 = BigInteger.valueOf(r18);
        L68:
            r15 = r15.multiply(BigInteger.TEN).add(BigInteger.valueOf(r111));
        L70:
            r17 = r110;
            goto L57
        L69:
            r18 = (r18 * 10) + ((long) r111);
            goto L70
        L60:
            r17 = r110 - 1;
            if (r17 >= r12) goto L71;
            return ~r9;
        L71:
            int r112 = this.subsequentWidth;
            if (r112 <= 0) goto L75;
            if (r6 != 0) goto L75;
            r14 = Math.max(r11, (r17 - r9) - r112);
            r6 = r6 + 1;
        L75:
            long r22 = r18;
        L77:
            if (r1 == false) goto L94;
            if (r15 == null) goto L87;
            if (r15.equals(BigInteger.ZERO) == true) goto L82;
        L85:
            r15 = r15.negate();
        L107:
            if (r15 == null) goto L114;
            if (r15.bitLength() <= 63) goto L112;
            r15 = r15.divide(BigInteger.TEN);
            r17 = r17 - 1;
        L112:
            return setValue(r19, r15.longValue(), r9, r17);
        L114:
            return setValue(r19, r22, r9, r17);
        L82:
            if (r19.isStrict() == false) goto L85;
            return ~(r9 - 1);
        L87:
            if (r22 == 0) goto L89;
        L92:
            r22 = -r22;
            goto L107
        L89:
            if (r19.isStrict() == false) goto L92;
            return ~(r9 - 1);
        L94:
            if (this.signStyle != SignStyle.EXCEEDS_PAD) goto L107;
            if (r19.isStrict() == false) goto L107;
            int r23 = r17 - r9;
            if (r10 == false) goto L104;
            if (r23 > this.minWidth) goto L107;
            return ~(r9 - 1);
        L104:
            if (r23 <= this.minWidth) goto L107;
            return ~r9;
        L76:
            r17 = r9;
            r22 = 0;
            goto L77
        L49:
            if (isFixedWidth(r19) == true) goto L52;
            r13 = 9;
            goto L53
        L38:
            if (isFixedWidth(r19) == true) goto L41;
            r11 = 1;
            goto L42
        L15:
            return ~r21;
        L11:
            r8 = false;
            goto L13
        L18:
            if (r4 != r19.getSymbols().getNegativeSign()) goto L29;
            SignStyle r24 = this.signStyle;
            boolean r25 = r19.isStrict();
            if (this.minWidth != this.maxWidth) goto L22;
            boolean r26 = true;
        L24:
            if (r24.parse(false, r25, r26) == false) goto L26;
            r9 = r21 + 1;
            r10 = false;
            r1 = true;
            goto L36
        L26:
            return ~r21;
        L22:
            r26 = false;
            goto L24
        L29:
            if (this.signStyle == SignStyle.ALWAYS) goto L31;
        L34:
            r9 = r21;
            r1 = false;
            r10 = false;
            goto L36
        L31:
            if (r19.isStrict() == false) goto L34;
            return ~r21;
        L5:
            return ~r21;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r11, StringBuilder r12) {
            Long r0 = r11.getValue(this.field);
            int r1 = 0;
            if (r0 != null) goto L5;
            return false;
        L5:
            long r2 = getValue(r11, r0.longValue());
            DecimalStyle r13 = r11.getSymbols();
            if (r2 != Long.MIN_VALUE) goto L8;
            String r3 = "9223372036854775808";
        L10:
            if (r3.length() > this.maxWidth) goto L41;
            String r4 = r13.convertNumberToI18N(r3);
            if (r2 < 0) goto L24;
            int r5 = AnonymousClass4.$SwitchMap$org$threeten$bp$format$SignStyle[this.signStyle.ordinal()];
            if (r5 == 1) goto L19;
            if (r5 != 2) goto L36;
        L17:
            char r6 = r13.getPositiveSign();
        L18:
            r12.append(r6);
        L36:
            if (r1 >= (this.minWidth - r4.length())) goto L38;
            r12.append(r13.getZeroDigit());
            r1 = r1 + 1;
            goto L36
        L38:
            r12.append(r4);
            return true;
        L19:
            int r7 = this.minWidth;
            if (r7 >= 19) goto L36;
            if (r2 < EXCEED_POINTS[r7]) goto L36;
        L24:
            int r8 = AnonymousClass4.$SwitchMap$org$threeten$bp$format$SignStyle[this.signStyle.ordinal()];
            if (r8 == 1) goto L34;
            if (r8 == 2) goto L34;
            if (r8 == 3) goto L34;
            if (r8 != 4) goto L36;
            throw new DateTimeException("Field " + this.field + " cannot be printed as the value " + r2 + " cannot be negative according to the SignStyle");
        L34:
            r6 = r13.getNegativeSign();
            goto L18
        L41:
            throw new DateTimeException("Field " + this.field + " cannot be printed as the value " + r2 + " exceeds the maximum print width of " + this.maxWidth);
        L8:
            r3 = Long.toString(Math.abs(r2));
            goto L10
        }

        int setValue(DateTimeParseContext r7, long r8, int r10, int r11) {
            return r7.setParsedField(this.field, r8, r10, r11);
        }

        public String toString() {
            if (this.minWidth != 1) goto L13;
            if (this.maxWidth != 19) goto L13;
            if (this.signStyle != SignStyle.NORMAL) goto L13;
            StringBuilder r0 = new StringBuilder().append("Value(");
            Object r5 = this.field;
        L9:
            StringBuilder r6 = r0.append(r5);
        L11:
            return r6.append(")").toString();
        L13:
            if (this.minWidth == this.maxWidth) goto L15;
        L17:
            r0 = new StringBuilder().append("Value(").append(this.field).append(",").append(this.minWidth).append(",").append(this.maxWidth).append(",");
            r5 = this.signStyle;
            goto L9
        L15:
            if (this.signStyle != SignStyle.NOT_NEGATIVE) goto L17;
            r6 = new StringBuilder().append("Value(").append(this.field).append(",").append(this.minWidth);
            goto L11
        }

        NumberPrinterParser withFixedWidth() {
            if (this.subsequentWidth != (-1)) goto L6;
            return this;
        L6:
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, -1);
        }

        NumberPrinterParser withSubsequentWidth(int r8) {
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, this.subsequentWidth + r8);
        }
    }

    static final class OffsetIdPrinterParser implements DateTimePrinterParser {
        static final OffsetIdPrinterParser INSTANCE_ID = null;
        static final String[] PATTERNS = null;
        private final String noOffsetText;
        private final int type;

        static {
            PATTERNS = new String[]{"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
            INSTANCE_ID = new OffsetIdPrinterParser("Z", "+HH:MM:ss");
        }

        OffsetIdPrinterParser(String r2, String r3) {
            Jdk8Methods.requireNonNull(r2, "noOffsetText");
            Jdk8Methods.requireNonNull(r3, XSDatatype.FACET_PATTERN);
            this.noOffsetText = r2;
            this.type = checkPattern(r3);
        }

        private int checkPattern(String r3) {
            int r2 = 0;
        L3:
            String[] r0 = PATTERNS;
            if (r2 >= r0.length) goto L10;
            if (r0[r2].equals(r3) == true) goto L7;
            r2 = r2 + 1;
            goto L3
        L7:
            return r2;
        L10:
            throw new IllegalArgumentException("Invalid zone offset pattern: " + r3);
        }

        private boolean parseNumber(int[] r5, int r6, CharSequence r7, boolean r8) {
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
            int r4 = this.type;
            if (((r4 + 3) / 2) >= r6) goto L5;
            return false;
        L5:
            int r0 = r5[0];
            if ((r4 % 2) != 0) goto L17;
            if (r6 <= 1) goto L17;
            int r10 = r0 + 1;
            if (r10 <= r9.length()) goto L12;
        L15:
            return r8;
        L12:
            if (r9.charAt(r0) != ':') goto L15;
            r0 = r10;
        L17:
            if ((r0 + 2) <= r9.length()) goto L19;
            return r8;
        L19:
            int r11 = r0 + 1;
            char r1 = r9.charAt(r0);
            int r2 = r11 + 1;
            char r12 = r9.charAt(r11);
            if (r1 >= '0') goto L22;
        L33:
            return r8;
        L22:
            if (r1 > '9') goto L33;
            if (r12 < '0') goto L33;
            if (r12 > '9') goto L33;
            int r3 = ((r1 - '0') * 10) + (r12 - '0');
            if (r3 < 0) goto L33;
            if (r3 > 59) goto L33;
            r5[r6] = r3;
            r5[0] = r2;
            return false;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r16, CharSequence r17, int r18) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r17, CharSequence.class, "com.obric.memorydata.plugin");
            int r1 = r8.length();
            int r9 = this.noOffsetText.length();
            if (r9 != 0) goto L8;
            if (r18 != r1) goto L15;
            ChronoField r2 = ChronoField.OFFSET_SECONDS;
            long r3 = 0;
            r16 = r16;
            int r5 = r18;
        L7:
            return r16.setParsedField(r2, r3, r18, r5);
        L15:
            char r4 = r8.charAt(r18);
            if (r4 == '+') goto L19;
            if (r4 == '-') goto L19;
        L37:
            if (r9 != 0) goto L40;
        L13:
            r2 = ChronoField.OFFSET_SECONDS;
            r3 = 0;
            r5 = r18 + r9;
            goto L7
        L40:
            return ~r18;
        L19:
            if (r4 != '-') goto L21;
            int r6 = -1;
        L22:
            int[] r7 = new int[4];
            r7[0] = r18 + 1;
            if (parseNumber(r7, 1, r8, true) == false) goto L25;
        L34:
            boolean r0 = true;
        L35:
            if (r0 == true) goto L37;
            long r10 = (((((long) r7[1]) * TimeUtils.SECONDS_PER_HOUR) + (((long) r7[2]) * 60)) + ((long) r7[3])) * ((long) r6);
            r2 = ChronoField.OFFSET_SECONDS;
            r5 = r7[0];
            r3 = r10;
            goto L7
        L25:
            if (this.type < 3) goto L27;
            boolean r11 = true;
        L29:
            if (parseNumber(r7, 2, r8, r11) == true) goto L34;
            if (parseNumber(r7, 3, r8, false) == true) goto L34;
            r0 = false;
            goto L35
        L27:
            r11 = false;
            goto L29
        L21:
            r6 = 1;
            goto L22
        L8:
            if (r18 != r1) goto L12;
            return ~r18;
        L12:
            if (r16.subSequenceEquals(r8, r18, this.noOffsetText, 0, r9) == false) goto L15;
            goto L13
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r9, StringBuilder r10) {
            Long r11 = r9.getValue(ChronoField.OFFSET_SECONDS);
            if (r11 != null) goto L6;
            return false;
        L6:
            int r12 = Jdk8Methods.safeToInt(r11.longValue());
            if (r12 != 0) goto L9;
        L8:
            r10.append(this.noOffsetText);
        L33:
            return true;
        L9:
            int r1 = Math.abs((r12 / 3600) % 100);
            int r2 = Math.abs((r12 / 60) % 60);
            int r3 = Math.abs(r12 % 60);
            int r4 = r10.length();
            if (r12 >= 0) goto L12;
            String r13 = "-";
        L13:
            r10.append(r13).append((char) ((r1 / 10) + 48)).append((char) ((r1 % 10) + 48));
            int r14 = this.type;
            if (r14 >= 3) goto L17;
            if (r14 < 1) goto L31;
            if (r2 > 0) goto L17;
        L31:
            if (r1 != 0) goto L33;
            r10.setLength(r4);
        L17:
            int r15 = r14 % 2;
            String r5 = ParameterizedMessage.ERROR_MSG_SEPARATOR;
            if (r15 != 0) goto L20;
            String r16 = ParameterizedMessage.ERROR_MSG_SEPARATOR;
        L21:
            r10.append(r16).append((char) ((r2 / 10) + 48)).append((char) ((r2 % 10) + 48));
            r1 = r1 + r2;
            int r17 = this.type;
            if (r17 >= 7) goto L27;
            if (r17 < 5) goto L31;
            if (r3 <= 0) goto L31;
        L27:
            if ((r17 % 2) == 0) goto L30;
            r5 = "";
        L30:
            r10.append(r5).append((char) ((r3 / 10) + 48)).append((char) ((r3 % 10) + 48));
            r1 = r1 + r3;
            goto L31
        L20:
            r16 = "";
            goto L21
        L12:
            r13 = Marker.ANY_NON_NULL_MARKER;
            goto L13
        }

        public String toString() {
            return "Offset(" + PATTERNS[this.type] + ",'" + this.noOffsetText.replace("'", "''") + "')";
        }
    }

    static final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final char padChar;
        private final int padWidth;
        private final DateTimePrinterParser printerParser;

        PadPrinterParserDecorator(DateTimePrinterParser r3, int r4, char r5) {
            this.printerParser = (DateTimePrinterParser) ZeusTransformUtils.wrapperContextForParams(r3, DateTimePrinterParser.class, "com.obric.memorydata.plugin");
            this.padWidth = r4;
            this.padChar = r5;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r7, CharSequence r8, int r9) {
            CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
            boolean r0 = r7.isStrict();
            boolean r1 = r7.isCaseSensitive();
            if (r9 > r10.length()) goto L29;
            if (r9 == r10.length()) goto L7;
            int r2 = this.padWidth + r9;
            if (r2 <= r10.length()) goto L14;
            if (r0 == true) goto L12;
            r2 = r10.length();
            goto L14
        L12:
            return ~r9;
        L14:
            int r3 = r9;
        L15:
            if (r3 >= r2) goto L23;
            char r4 = r10.charAt(r3);
            char r5 = this.padChar;
            if (r1 == false) goto L21;
            if (r4 != r5) goto L23;
        L22:
            r3 = r3 + 1;
            goto L15
        L21:
            if (r7.charEquals(r4, r5) == true) goto L22;
        L23:
            CharSequence r11 = r10.subSequence(0, r2);
            int r6 = this.printerParser.parse(r7, r11, r3);
            if (r6 == r2) goto L35;
            if (r0 == true) goto L27;
            return r6;
        L27:
            return ~(r9 + r3);
        L35:
            return r6;
        L7:
            return ~r9;
        L29:
            throw new IndexOutOfBoundsException();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r4, StringBuilder r5) {
            int r0 = r5.length();
            int r1 = 0;
            if (this.printerParser.print(r4, r5) == true) goto L5;
            return false;
        L5:
            int r6 = r5.length() - r0;
            if (r6 > this.padWidth) goto L13;
        L8:
            if (r1 >= (this.padWidth - r6)) goto L10;
            r5.insert(r0, this.padChar);
            r1 = r1 + 1;
            goto L8
        L10:
            return true;
        L13:
            throw new DateTimeException("Cannot print as output of " + r6 + " characters exceeds pad width of " + this.padWidth);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder().append("Pad(").append(this.printerParser).append(",").append(this.padWidth);
            if (this.padChar != ' ') goto L5;
            String r3 = ")";
        L7:
            return r0.append(r3).toString();
        L5:
            r3 = ",'" + this.padChar + "')";
            goto L7
        }
    }

    static final class ReducedPrinterParser extends NumberPrinterParser {
        static final LocalDate BASE_DATE = null;
        private final ChronoLocalDate baseDate;
        private final int baseValue;

        static {
            BASE_DATE = LocalDate.of(2000, 1, 1);
        }

        ReducedPrinterParser(TemporalField r3, int r4, int r5, int r6, ChronoLocalDate r7) {
            TemporalField r8 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
            super(r8, r4, r5, SignStyle.NOT_NEGATIVE);
            if (r4 < 1) goto L26;
            if (r4 > 10) goto L26;
            if (r5 < 1) goto L24;
            if (r5 > 10) goto L24;
            if (r5 < r4) goto L22;
            if (r7 != null) goto L19;
            long r0 = r6;
            if (r8.range().isValidValue(r0) == false) goto L18;
            if ((r0 + ((long) EXCEED_POINTS[r4])) <= 2147483647L) goto L19;
            throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
        L18:
            throw new IllegalArgumentException("The base value must be within the range of the field");
        L19:
            this.baseValue = r6;
            this.baseDate = r7;
            return;
        L22:
            throw new IllegalArgumentException("The maxWidth must be greater than the width");
        L24:
            throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + r5);
        L26:
            throw new IllegalArgumentException("The width must be from 1 to 10 inclusive but was " + r4);
        }

        private ReducedPrinterParser(TemporalField r8, int r9, int r10, int r11, ChronoLocalDate r12, int r13) {
            super((TemporalField) ZeusTransformUtils.wrapperContextForParams(r8, TemporalField.class, "com.obric.memorydata.plugin"), r9, r10, SignStyle.NOT_NEGATIVE, r13, null);
            this.baseValue = r11;
            this.baseDate = r12;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        long getValue(DateTimePrintContext r6, long r7) {
            long r0 = Math.abs(r7);
            int r2 = this.baseValue;
            if (this.baseDate == null) goto L6;
            r2 = Chronology.from(r6.getTemporal()).date(this.baseDate).get(this.field);
        L6:
            if (r7 >= r2) goto L8;
        L12:
            int r5 = EXCEED_POINTS[this.maxWidth];
        L11:
            return r0 % ((long) r5);
        L8:
            if (r7 >= (r2 + EXCEED_POINTS[this.minWidth])) goto L12;
            r5 = EXCEED_POINTS[this.minWidth];
            goto L11
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        boolean isFixedWidth(DateTimeParseContext r2) {
            if (r2.isStrict() == true) goto L7;
            return false;
        L7:
            return super.isFixedWidth(r2);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        int setValue(DateTimeParseContext r8, long r9, int r11, int r12) {
            int r0 = this.baseValue;
            if (this.baseDate == null) goto L6;
            r0 = r8.getEffectiveChronology().date(this.baseDate).get(this.field);
            r8.addChronologyChangedParser(this, r9, r11, r12);
        L6:
            if ((r12 - r11) != this.minWidth) goto L17;
            if (r9 < 0) goto L17;
            long r1 = EXCEED_POINTS[this.minWidth];
            long r3 = r0;
            long r5 = r3 - (r3 % r1);
            if (r0 <= 0) goto L12;
            long r6 = r5 + r9;
        L13:
            r9 = r6;
            if (r9 >= r3) goto L17;
            r9 = r9 + r1;
            goto L17
        L12:
            r6 = r5 - r9;
        L17:
            return r8.setParsedField(this.field, r9, r11, r12);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        public String toString() {
            StringBuilder r0 = new StringBuilder().append("ReducedValue(").append(this.field).append(",").append(this.minWidth).append(",").append(this.maxWidth).append(",");
            Object r1 = this.baseDate;
            if (r1 != null) goto L7;
            r1 = Integer.valueOf(this.baseValue);
        L7:
            return r0.append(r1).append(")").toString();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        NumberPrinterParser withFixedWidth() {
            if (this.subsequentWidth != (-1)) goto L6;
            return this;
        L6:
            return new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, -1);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        /* bridge */ /* synthetic */ NumberPrinterParser withSubsequentWidth(int r1) {
            return withSubsequentWidth(r1);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        ReducedPrinterParser withSubsequentWidth(int r9) {
            return new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, this.subsequentWidth + r9);
        }
    }

    static final enum SettingsParser extends Enum<SettingsParser> implements DateTimePrinterParser {
        private static final /* synthetic */ SettingsParser[] $VALUES = null;
        public static final SettingsParser INSENSITIVE = null;
        public static final SettingsParser LENIENT = null;
        public static final SettingsParser SENSITIVE = null;
        public static final SettingsParser STRICT = null;

        static {
            SettingsParser r0 = new SettingsParser("SENSITIVE", 0);
            SENSITIVE = r0;
            SettingsParser r1 = new SettingsParser("INSENSITIVE", 1);
            INSENSITIVE = r1;
            SettingsParser r3 = new SettingsParser("STRICT", 2);
            STRICT = r3;
            SettingsParser r5 = new SettingsParser("LENIENT", 3);
            LENIENT = r5;
            $VALUES = new SettingsParser[]{r0, r1, r3, r5};
        }

        private SettingsParser(String r1, int r2) {
            super(r1, r2);
        }

        public static SettingsParser valueOf(String r2) {
            return (SettingsParser) ZeusTransformUtils.preCheckCast(Enum.valueOf(SettingsParser.class, r2), SettingsParser.class, "com.obric.memorydata.plugin");
        }

        public static SettingsParser[] values() {
            return (SettingsParser[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SettingsParser[].class, "com.obric.memorydata.plugin");
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r3, CharSequence r4, int r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            int r2 = ordinal();
            if (r2 != 0) goto L5;
            r3.setCaseSensitive(true);
        L15:
            return r5;
        L5:
            if (r2 != 1) goto L7;
            r3.setCaseSensitive(false);
            goto L15
        L7:
            if (r2 != 2) goto L9;
            r3.setStrict(true);
            goto L15
        L9:
            if (r2 != 3) goto L15;
            r3.setStrict(false);
            goto L15
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r1, StringBuilder r2) {
            return true;
        }

        @Override // java.lang.Enum
        public String toString() {
            int r1 = ordinal();
            if (r1 != 0) goto L5;
            return "ParseCaseSensitive(true)";
        L5:
            if (r1 != 1) goto L7;
            return "ParseCaseSensitive(false)";
        L7:
            if (r1 != 2) goto L9;
            return "ParseStrict(true)";
        L9:
            if (r1 != 3) goto L13;
            return "ParseStrict(false)";
        L13:
            throw new IllegalStateException("Unreachable");
        }
    }

    static final class StringLiteralPrinterParser implements DateTimePrinterParser {
        private final String literal;

        StringLiteralPrinterParser(String r1) {
            this.literal = r1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r7, CharSequence r8, int r9) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
            if (r9 > r1.length()) goto L12;
            if (r9 < 0) goto L12;
            String r3 = this.literal;
            if (r7.subSequenceEquals(r1, r9, r3, 0, r3.length()) == true) goto L10;
            return ~r9;
        L10:
            return r9 + this.literal.length();
        L12:
            throw new IndexOutOfBoundsException();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r1, StringBuilder r2) {
            r2.append(this.literal);
            return true;
        }

        public String toString() {
            return "'" + this.literal.replace("'", "''") + "'";
        }
    }

    static final class TextPrinterParser implements DateTimePrinterParser {
        private final TemporalField field;
        private volatile NumberPrinterParser numberPrinterParser;
        private final DateTimeTextProvider provider;
        private final TextStyle textStyle;

        TextPrinterParser(TemporalField r3, TextStyle r4, DateTimeTextProvider r5) {
            this.field = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
            this.textStyle = r4;
            this.provider = r5;
        }

        private NumberPrinterParser numberPrinterParser() {
            if (this.numberPrinterParser != null) goto L6;
            this.numberPrinterParser = new NumberPrinterParser(this.field, 1, 19, SignStyle.NORMAL);
        L6:
            return this.numberPrinterParser;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r14, CharSequence r15, int r16) {
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.memorydata.plugin");
            int r1 = r9.length();
            if (r16 < 0) goto L24;
            if (r16 > r1) goto L24;
            if (r14.isStrict() == false) goto L8;
            TextStyle r2 = this.textStyle;
        L9:
            Iterator<Map.Entry<String, Long>> r10 = this.provider.getTextIterator(this.field, r2, r14.getLocale());
            if (r10 == null) goto L22;
        L12:
            if (r10.hasNext() == false) goto L18;
            Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r12 = (String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.memorydata.plugin");
            if (r14.subSequenceEquals(r12, 0, r9, r16, r12.length()) == false) goto L12;
            return r14.setParsedField(this.field, ((Long) ZeusTransformUtils.preCheckCast(r11.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue(), r16, r16 + r12.length());
        L18:
            if (r14.isStrict() == false) goto L22;
            return ~r16;
        L22:
            return numberPrinterParser().parse(r14, r9, r16);
        L8:
            r2 = null;
        L24:
            throw new IndexOutOfBoundsException();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r8, StringBuilder r9) {
            Long r0 = r8.getValue(this.field);
            if (r0 != null) goto L6;
            return false;
        L6:
            String r1 = this.provider.getText(this.field, r0.longValue(), this.textStyle, r8.getLocale());
            if (r1 == null) goto L9;
            r9.append(r1);
            return true;
        L9:
            return numberPrinterParser().print(r8, r9);
        }

        public String toString() {
            if (this.textStyle != TextStyle.FULL) goto L7;
            StringBuilder r0 = new StringBuilder().append("Text(");
            Object r4 = this.field;
        L6:
            return r0.append(r4).append(")").toString();
        L7:
            r0 = new StringBuilder().append("Text(").append(this.field).append(",");
            r4 = this.textStyle;
            goto L6
        }
    }

    static final class WeekFieldsPrinterParser implements DateTimePrinterParser {
        private final int count;
        private final char letter;

        public WeekFieldsPrinterParser(char r1, int r2) {
            this.letter = r1;
            this.count = r2;
        }

        private DateTimePrinterParser evaluate(WeekFields r18) {
            char r1 = this.letter;
            if (r1 == 'W') goto L26;
            if (r1 == 'Y') goto L18;
            if (r1 != 'c') goto L9;
            NumberPrinterParser r2 = new NumberPrinterParser(r18.dayOfWeek(), this.count, 2, SignStyle.NOT_NEGATIVE);
        L28:
            return r2;
        L9:
            if (r1 != 'e') goto L11;
            r2 = new NumberPrinterParser(r18.dayOfWeek(), this.count, 2, SignStyle.NOT_NEGATIVE);
            goto L28
        L11:
            if (r1 == 'w') goto L13;
            return null;
        L13:
            r2 = new NumberPrinterParser(r18.weekOfWeekBasedYear(), this.count, 2, SignStyle.NOT_NEGATIVE);
            goto L28
        L18:
            if (this.count == 2) goto L29;
            TemporalField r11 = r18.weekBasedYear();
            int r12 = this.count;
            int r13 = 19;
            if (r12 >= 4) goto L23;
            SignStyle r0 = SignStyle.NORMAL;
        L24:
            r2 = new NumberPrinterParser(r11, r12, r13, r0, -1, null);
            goto L28
        L23:
            r0 = SignStyle.EXCEEDS_PAD;
            goto L24
        L29:
            return new ReducedPrinterParser(r18.weekBasedYear(), 2, 2, 0, ReducedPrinterParser.BASE_DATE);
        L26:
            return new NumberPrinterParser(r18.weekOfMonth(), 1, 2, SignStyle.NOT_NEGATIVE);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r3, CharSequence r4, int r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            return evaluate(WeekFields.of(r3.getLocale())).parse(r3, r6, r5);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r2, StringBuilder r3) {
            return evaluate(WeekFields.of(r2.getLocale())).print(r2, r3);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder(30);
            r0.append("Localized(");
            char r1 = this.letter;
            if (r1 != 'Y') goto L17;
            int r2 = this.count;
            if (r2 != 1) goto L9;
            String r4 = "WeekBasedYear";
        L7:
            r0.append(r4);
        L30:
            r0.append(")");
            return r0.toString();
        L9:
            if (r2 != 2) goto L11;
            r4 = "ReducedValue(WeekBasedYear,2,2,2000-01-01)";
            goto L7
        L11:
            StringBuilder r3 = r0.append("WeekBasedYear,").append(this.count).append(",").append(19).append(",");
            if (this.count >= 4) goto L14;
            SignStyle r5 = SignStyle.NORMAL;
        L15:
            r3.append(r5);
            goto L30
        L14:
            r5 = SignStyle.EXCEEDS_PAD;
            goto L15
        L17:
            if (r1 != 'c') goto L19;
        L27:
            String r6 = "DayOfWeek";
        L28:
            r0.append(r6);
        L29:
            r0.append(",");
            r0.append(this.count);
            goto L30
        L19:
            if (r1 == 'e') goto L27;
            if (r1 != 'w') goto L25;
            r6 = "WeekOfWeekBasedYear";
            goto L28
        L25:
            if (r1 != 'W') goto L29;
            r6 = "WeekOfMonth";
            goto L28
        }
    }

    static final class ZoneIdPrinterParser implements DateTimePrinterParser {
        private static volatile Map.Entry<Integer, SubstringTree> cachedSubstringTree;
        private final String description;
        private final TemporalQuery<ZoneId> query;

        private static final class SubstringTree {
            final int length;
            private final Map<CharSequence, SubstringTree> substringMap;
            private final Map<String, SubstringTree> substringMapCI;

            private SubstringTree(int r2) {
                this.substringMap = new HashMap();
                this.substringMapCI = new HashMap();
                this.length = r2;
            }

            /* synthetic */ SubstringTree(int r1, AnonymousClass1 r2) {
                this(r1);
            }

            static /* synthetic */ SubstringTree access$100(SubstringTree r2, CharSequence r3, boolean r4) {
                return r2.get((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
            }

            static /* synthetic */ void access$300(SubstringTree r0, String r1) {
                r0.add(r1);
            }

            private void add(String r6) {
                int r0 = r6.length();
                int r1 = this.length;
                if (r0 != r1) goto L5;
                this.substringMap.put(r6, null);
                this.substringMapCI.put(r6.toLowerCase(Locale.ENGLISH), null);
                return;
            L5:
                if (r0 <= r1) goto L12;
                String r2 = r6.substring(0, r1);
                SubstringTree r3 = (SubstringTree) ZeusTransformUtils.preCheckCast(this.substringMap.get(r2), SubstringTree.class, "com.obric.memorydata.plugin");
                if (r3 != null) goto L9;
                r3 = new SubstringTree(r0);
                this.substringMap.put(r2, r3);
                this.substringMapCI.put(r2.toLowerCase(Locale.ENGLISH), r3);
            L9:
                r3.add(r6);
                return;
            }

            private SubstringTree get(CharSequence r4, boolean r5) {
                Object r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
                if (r5 == false) goto L7;
                Map r3 = this.substringMap;
            L6:
                return (SubstringTree) ZeusTransformUtils.preCheckCast(r3.get(r6), SubstringTree.class, "com.obric.memorydata.plugin");
            L7:
                r3 = this.substringMapCI;
                r6 = r6.toString().toLowerCase(Locale.ENGLISH);
                goto L6
            }
        }

        ZoneIdPrinterParser(TemporalQuery<ZoneId> r3, String r4) {
            this.query = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin");
            this.description = r4;
        }

        private ZoneId convertToZone(Set<String> r3, String r4, boolean r5) {
            Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
            return null;
        L5:
            if (r5 == true) goto L7;
            Iterator r6 = r2.iterator();
        L12:
            if (r6.hasNext() == false) goto L17;
            String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
            if (r7.equalsIgnoreCase(r4) == false) goto L12;
            return ZoneId.of(r7);
        L17:
            return null;
        L7:
            if (r2.contains(r4) == true) goto L9;
            return null;
        L9:
            return ZoneId.of(r4);
        }

        private int parsePrefixedOffset(DateTimeParseContext r3, CharSequence r4, int r5, int r6) {
            CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            String r7 = r2.subSequence(r5, r6).toString().toUpperCase();
            DateTimeParseContext r8 = r3.copy();
            if (r6 < r2.length()) goto L5;
        L8:
            int r9 = OffsetIdPrinterParser.INSTANCE_ID.parse(r8, r2, r6);
            if (r9 < 0) goto L6;
            r3.setParsed(ZoneId.ofOffset(r7, ZoneOffset.ofTotalSeconds((int) r8.getParsed(ChronoField.OFFSET_SECONDS).longValue())));
            return r9;
        L6:
            r3.setParsed(ZoneId.ofOffset(r7, ZoneOffset.UTC));
            return r6;
        L5:
            if (r3.charEquals(r2.charAt(r6), 'Z') == false) goto L8;
            goto L6
        }

        private static SubstringTree prepareParser(Set<String> r4) {
            ArrayList r0 = new ArrayList((Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"));
            Collections.sort(r0, DateTimeFormatterBuilder.LENGTH_SORT);
            SubstringTree r5 = new SubstringTree(((String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.memorydata.plugin")).length(), null);
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            SubstringTree.access$300(r5, (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin"));
            goto L4
        L6:
            return r5;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r10, CharSequence r11, int r12) {
            CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
            int r0 = r13.length();
            if (r12 > r0) goto L75;
            if (r12 == r0) goto L6;
            char r1 = r13.charAt(r12);
            if (r1 != '+') goto L10;
        L69:
            DateTimeParseContext r9 = r10.copy();
            int r14 = OffsetIdPrinterParser.INSTANCE_ID.parse(r9, r13, r12);
            if (r14 >= 0) goto L72;
            return r14;
        L72:
            r10.setParsed(ZoneOffset.ofTotalSeconds((int) r9.getParsed(ChronoField.OFFSET_SECONDS).longValue()));
            return r14;
        L10:
            if (r1 == '-') goto L69;
            int r2 = r12 + 2;
            if (r0 < r2) goto L36;
            char r3 = r13.charAt(r12 + 1);
            if (r10.charEquals(r1, 'U') == false) goto L27;
            if (r10.charEquals(r3, 'T') == false) goto L27;
            int r4 = r12 + 3;
            if (r0 < r4) goto L25;
            if (r10.charEquals(r13.charAt(r2), 'C') == false) goto L25;
            return parsePrefixedOffset(r10, r13, r12, r4);
        L25:
            return parsePrefixedOffset(r10, r13, r12, r2);
        L27:
            if (r10.charEquals(r1, 'G') == false) goto L36;
            int r5 = r12 + 3;
            if (r0 < r5) goto L36;
            if (r10.charEquals(r3, 'M') == false) goto L36;
            if (r10.charEquals(r13.charAt(r2), 'T') == false) goto L36;
            return parsePrefixedOffset(r10, r13, r12, r5);
        L36:
            Set<String> r6 = ZoneRulesProvider.getAvailableZoneIds();
            int r7 = r6.size();
            Map.Entry<Integer, SubstringTree> r8 = cachedSubstringTree;
            if (r8 != null) goto L39;
        L40:
            monitor-enter(this);
            r8 = cachedSubstringTree;     // Catch: Throwable -> L66
            if (r8 != null) goto L44;
        L45:
            r8 = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(r7), prepareParser(r6));     // Catch: Throwable -> L66
            cachedSubstringTree = r8;     // Catch: Throwable -> L66
        L46:
            monitor-exit(this);     // Catch: Throwable -> L66
        L47:
            SubstringTree r15 = (SubstringTree) ZeusTransformUtils.preCheckCast(r8.getValue(), SubstringTree.class, "com.obric.memorydata.plugin");
            String r16 = null;
            String r17 = null;
        L48:
            if (r15 == null) goto L53;
            int r18 = r15.length + r12;
            if (r18 > r0) goto L53;
            String r19 = r13.subSequence(r12, r18).toString();
            r15 = SubstringTree.access$100(r15, r19, r10.isCaseSensitive());
            r17 = r16;
            r16 = r19;
        L53:
            ZoneId r110 = convertToZone(r6, r16, r10.isCaseSensitive());
            if (r110 != null) goto L64;
            r110 = convertToZone(r6, r17, r10.isCaseSensitive());
            if (r110 == null) goto L58;
            r16 = r17;
            goto L64
        L58:
            if (r10.charEquals(r1, 'Z') == false) goto L62;
            r10.setParsed(ZoneOffset.UTC);
            return r12 + 1;
        L62:
            return ~r12;
        L64:
            r10.setParsed(r110);
            return r12 + r16.length();
        L44:
            if (((Integer) ZeusTransformUtils.preCheckCast(r8.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() == r7) goto L46;
        L66:
            th = move-exception;
            throw th;
        L39:
            if (((Integer) ZeusTransformUtils.preCheckCast(r8.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() == r7) goto L47;
        L6:
            return ~r12;
        L75:
            throw new IndexOutOfBoundsException();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r2, StringBuilder r3) {
            ZoneId r1 = (ZoneId) ZeusTransformUtils.preCheckCast(r2.getValue(this.query), ZoneId.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L6;
            return false;
        L6:
            r3.append(r1.getId());
            return true;
        }

        public String toString() {
            return this.description;
        }
    }

    static final class ZoneTextPrinterParser implements DateTimePrinterParser {
        private static final Comparator<String> LENGTH_COMPARATOR = null;
        private final TextStyle textStyle;

        static {
            LENGTH_COMPARATOR = new AnonymousClass1();
        }

        ZoneTextPrinterParser(TextStyle r3) {
            this.textStyle = (TextStyle) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r3, "textStyle"), TextStyle.class, "com.obric.memorydata.plugin");
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r10, CharSequence r11, int r12) {
            CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
            TreeMap r0 = new TreeMap(LENGTH_COMPARATOR);
            Iterator<String> r2 = ZoneId.getAvailableZoneIds().iterator();
        L4:
            if (r2.hasNext() == false) goto L10;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
            r0.put(r3, r3);
            TimeZone r4 = TimeZone.getTimeZone(r3);
            if (this.textStyle.asNormal() != TextStyle.FULL) goto L8;
            int r5 = 1;
        L9:
            r0.put(r4.getDisplayName(false, r5, r10.getLocale()), r3);
            r0.put(r4.getDisplayName(true, r5, r10.getLocale()), r3);
            goto L4
        L8:
            r5 = 0;
            goto L9
        L10:
            Iterator r9 = r0.entrySet().iterator();
        L12:
            if (r9.hasNext() == false) goto L18;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r8 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
            if (r10.subSequenceEquals(r13, r12, r8, 0, r8.length()) == false) goto L12;
            r10.setParsed(ZoneId.of((String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin")));
            return r12 + r8.length();
        L18:
            return ~r12;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r7, StringBuilder r8) {
            ZoneId r0 = (ZoneId) ZeusTransformUtils.preCheckCast(r7.getValue(TemporalQueries.zoneId()), ZoneId.class, "com.obric.memorydata.plugin");
            int r1 = 0;
            if (r0 != null) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r0.normalized(), ZoneOffset.class) == false) goto L10;
            String r6 = r0.getId();
        L8:
            r8.append(r6);
            return true;
        L10:
            TemporalAccessor r2 = r7.getTemporal();
            if (r2.isSupported(ChronoField.INSTANT_SECONDS) == false) goto L13;
            boolean r3 = r0.getRules().isDaylightSavings(Instant.ofEpochSecond(r2.getLong(ChronoField.INSTANT_SECONDS)));
        L14:
            TimeZone r4 = TimeZone.getTimeZone(r0.getId());
            if (this.textStyle.asNormal() != TextStyle.FULL) goto L17;
            r1 = 1;
        L17:
            r6 = r4.getDisplayName(r3, r1, r7.getLocale());
            goto L8
        L13:
            r3 = false;
            goto L14
        }

        public String toString() {
            return "ZoneText(" + this.textStyle + ")";
        }
    }

    static {
        QUERY_REGION_ONLY = new AnonymousClass1();
        HashMap r0 = new HashMap();
        FIELD_MAP = r0;
        r0.put('G', ChronoField.ERA);
        r0.put('y', ChronoField.YEAR_OF_ERA);
        r0.put('u', ChronoField.YEAR);
        r0.put('Q', IsoFields.QUARTER_OF_YEAR);
        r0.put('q', IsoFields.QUARTER_OF_YEAR);
        r0.put('M', ChronoField.MONTH_OF_YEAR);
        r0.put('L', ChronoField.MONTH_OF_YEAR);
        r0.put('D', ChronoField.DAY_OF_YEAR);
        r0.put('d', ChronoField.DAY_OF_MONTH);
        r0.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        r0.put('E', ChronoField.DAY_OF_WEEK);
        r0.put('c', ChronoField.DAY_OF_WEEK);
        r0.put('e', ChronoField.DAY_OF_WEEK);
        r0.put('a', ChronoField.AMPM_OF_DAY);
        r0.put('H', ChronoField.HOUR_OF_DAY);
        r0.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        r0.put('K', ChronoField.HOUR_OF_AMPM);
        r0.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        r0.put('m', ChronoField.MINUTE_OF_HOUR);
        r0.put('s', ChronoField.SECOND_OF_MINUTE);
        r0.put('S', ChronoField.NANO_OF_SECOND);
        r0.put('A', ChronoField.MILLI_OF_DAY);
        r0.put('n', ChronoField.NANO_OF_SECOND);
        r0.put('N', ChronoField.NANO_OF_DAY);
        LENGTH_SORT = new AnonymousClass3();
    }

    public DateTimeFormatterBuilder() {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = null;
        this.optional = false;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder r2, boolean r3) {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = r2;
        this.optional = r3;
    }

    private int appendInternal(DateTimePrinterParser r4) {
        DateTimePrinterParser r5 = (DateTimePrinterParser) ZeusTransformUtils.wrapperContextForParams(r4, DateTimePrinterParser.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r5, "pp");
        if (this.active.padNextWidth <= 0) goto L7;
        if (r5 == null) goto L6;
        DateTimeFormatterBuilder r1 = this.active;
        r5 = new PadPrinterParserDecorator(r5, r1.padNextWidth, r1.padNextChar);
    L6:
        DateTimeFormatterBuilder r0 = this.active;
        r0.padNextWidth = 0;
        r0.padNextChar = 0;
    L7:
        this.active.printerParsers.add(r5);
        DateTimeFormatterBuilder r3 = this.active;
        r3.valueParserIndex = -1;
        return r3.printerParsers.size() - 1;
    }

    private DateTimeFormatterBuilder appendValue(NumberPrinterParser r5) {
        DateTimeFormatterBuilder r0 = this.active;
        int r1 = r0.valueParserIndex;
        if (r1 >= 0) goto L5;
    L13:
        DateTimeFormatterBuilder r2 = this.active;
        r2.valueParserIndex = appendInternal(r5);
    L14:
        return this;
    L5:
        if (ZeusTransformUtils.instanceOf(r0.printerParsers.get(r1), NumberPrinterParser.class) == false) goto L13;
        DateTimeFormatterBuilder r3 = this.active;
        int r4 = r3.valueParserIndex;
        NumberPrinterParser r6 = (NumberPrinterParser) ZeusTransformUtils.preCheckCast(r3.printerParsers.get(r4), NumberPrinterParser.class, "com.obric.memorydata.plugin");
        if (r5.minWidth == r5.maxWidth) goto L9;
    L11:
        NumberPrinterParser r7 = r6.withFixedWidth();
        DateTimeFormatterBuilder r8 = this.active;
        r8.valueParserIndex = appendInternal(r5);
    L12:
        this.active.printerParsers.set(r4, r7);
        goto L14
    L9:
        if (r5.signStyle != SignStyle.NOT_NEGATIVE) goto L11;
        r7 = r6.withSubsequentWidth(r5.maxWidth);
        appendInternal(r5.withFixedWidth());
        this.active.valueParserIndex = r4;
        goto L12
    }

    private void parseField(char r8, int r9, TemporalField r10) {
        TemporalField r11 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r10, TemporalField.class, "com.obric.memorydata.plugin");
        if (r8 != 'Q') goto L5;
    L99:
        if (r9 != 1) goto L100;
    L65:
        appendValue(r11);
        return;
    L100:
        if (r9 != 2) goto L101;
    L87:
        appendValue(r11, 2);
        return;
    L101:
        if (r9 != 3) goto L102;
    L62:
        TextStyle r12 = TextStyle.SHORT;
    L63:
        appendText(r11, r12);
        return;
    L102:
        if (r9 != 4) goto L103;
    L61:
        r12 = TextStyle.FULL;
        goto L63
    L103:
        if (r9 != 5) goto L106;
    L58:
        r12 = TextStyle.NARROW;
        goto L63
    L106:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L5:
        if (r8 != 'S') goto L7;
        appendFraction(ChronoField.NANO_OF_SECOND, r9, r9, false);
        return;
    L7:
        if (r8 != 'a') goto L9;
        if (r9 == 1) goto L62;
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L9:
        if (r8 != 'h') goto L11;
    L88:
        if (r9 == 1) goto L65;
        if (r9 != 2) goto L93;
    L27:
        appendValue(r11, r9);
        return;
    L93:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L11:
        if (r8 == 'k') goto L88;
        if (r8 == 'm') goto L88;
        if (r8 != 'q') goto L17;
    L77:
        if (r9 == 1) goto L65;
        if (r9 == 2) goto L87;
        if (r9 == 3) goto L86;
        if (r9 == 4) goto L85;
        if (r9 != 5) goto L84;
    L82:
        r12 = TextStyle.NARROW_STANDALONE;
        goto L63
    L84:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L85:
        r12 = TextStyle.FULL_STANDALONE;
    L86:
        r12 = TextStyle.SHORT_STANDALONE;
        goto L63
    L17:
        if (r8 == 's') goto L88;
        if (r8 != 'u') goto L21;
    L70:
        if (r9 != 2) goto L73;
        appendValueReduced(r11, 2, 2, ReducedPrinterParser.BASE_DATE);
        return;
    L73:
        if (r9 >= 4) goto L75;
        SignStyle r0 = SignStyle.NORMAL;
    L76:
        appendValue(r11, r9, 19, r0);
        return;
    L75:
        r0 = SignStyle.EXCEEDS_PAD;
        goto L76
    L21:
        if (r8 == 'y') goto L70;
        switch(r8) {
            case 68: goto L64;
            case 69: goto L53;
            case 70: goto L49;
            case 71: goto L53;
            case 72: goto L88;
            default: goto L23;
        };
    L23:
        switch(r8) {
            case 75: goto L88;
            case 76: goto L77;
            case 77: goto L99;
            default: goto L24;
        };
    L24:
        switch(r8) {
            case 99: goto L37;
            case 100: goto L88;
            case 101: goto L28;
            default: goto L25;
        };
    L25:
        if (r9 != 1) goto L27;
    L28:
        if (r9 == 1) goto L36;
        if (r9 == 2) goto L36;
        if (r9 == 3) goto L62;
        if (r9 == 4) goto L61;
        if (r9 == 5) goto L58;
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L36:
        WeekFieldsPrinterParser r13 = new WeekFieldsPrinterParser('e', r9);
    L48:
        appendInternal(r13);
        return;
    L37:
        if (r9 == 1) goto L47;
        if (r9 == 2) goto L46;
        if (r9 == 3) goto L86;
        if (r9 == 4) goto L85;
        if (r9 == 5) goto L82;
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L46:
        throw new IllegalArgumentException("Invalid number of pattern letters: " + r8);
    L47:
        r13 = new WeekFieldsPrinterParser('c', r9);
        goto L48
    L49:
        if (r9 == 1) goto L65;
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L53:
        if (r9 == 1) goto L62;
        if (r9 == 2) goto L62;
        if (r9 == 3) goto L62;
        if (r9 == 4) goto L61;
        if (r9 == 5) goto L58;
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L64:
        if (r9 == 1) goto L65;
        if (r9 <= 3) goto L27;
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    }

    private void parsePattern(String r13) {
        int r1 = 0;
    L4:
        if (r1 >= r13.length()) goto L163;
        char r2 = r13.charAt(r1);
        if (r2 < 'A') goto L8;
        if (r2 > 'Z') goto L8;
    L10:
        int r8 = r1 + 1;
    L12:
        if (r8 >= r13.length()) goto L16;
        if (r13.charAt(r8) != r2) goto L16;
        r8 = r8 + 1;
    L16:
        int r3 = r8 - r1;
        if (r2 == 'p') goto L19;
    L37:
        TemporalField r4 = (TemporalField) ZeusTransformUtils.preCheckCast(FIELD_MAP.get(Character.valueOf(r2)), TemporalField.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L41;
        parseField(r2, r3, r4);
    L118:
        r1 = r8 - 1;
    L160:
        r1 = r1 + 1;
        goto L4
    L41:
        if (r2 != 'z') goto L50;
        if (r3 > 4) goto L48;
        if (r3 != 4) goto L45;
        TextStyle r5 = TextStyle.FULL;
    L46:
        appendZoneText(r5);
        goto L118
    L45:
        r5 = TextStyle.SHORT;
        goto L46
    L48:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L50:
        if (r2 != 'V') goto L55;
        if (r3 != 2) goto L54;
        appendZoneId();
        goto L118
    L54:
        throw new IllegalArgumentException("Pattern letter count must be 2: " + r2);
    L55:
        String r10 = "+0000";
        if (r2 != 'Z') goto L68;
        if (r3 >= 4) goto L60;
        String r6 = "+HHMM";
    L59:
        appendOffset(r6, r10);
        goto L118
    L60:
        if (r3 != 4) goto L62;
    L61:
        TextStyle r7 = TextStyle.FULL;
    L71:
        appendLocalizedOffset(r7);
        goto L118
    L62:
        if (r3 != 5) goto L66;
        String r9 = "+HH:MM:ss";
    L64:
        appendOffset(r9, "Z");
        goto L118
    L66:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L68:
        if (r2 != 'O') goto L77;
        if (r3 != 1) goto L72;
        r7 = TextStyle.SHORT;
        goto L71
    L72:
        if (r3 == 4) goto L61;
        throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + r2);
    L77:
        if (r2 != 'X') goto L87;
        if (r3 > 5) goto L85;
        String[] r11 = OffsetIdPrinterParser.PATTERNS;
        if (r3 != 1) goto L82;
        int r12 = 0;
    L83:
        r9 = r11[r3 + r12];
        goto L64
    L82:
        r12 = 1;
        goto L83
    L85:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L87:
        if (r2 != 'x') goto L103;
        if (r3 > 5) goto L101;
        if (r3 != 1) goto L92;
        r10 = "+00";
    L95:
        String[] r14 = OffsetIdPrinterParser.PATTERNS;
        if (r3 != 1) goto L98;
        int r15 = 0;
    L99:
        r6 = r14[r3 + r15];
        goto L59
    L98:
        r15 = 1;
        goto L99
    L92:
        if ((r3 % 2) == 0) goto L95;
        r10 = "+00:00";
        goto L95
    L101:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L103:
        if (r2 != 'W') goto L110;
        if (r3 > 1) goto L108;
        WeekFieldsPrinterParser r16 = new WeekFieldsPrinterParser('W', r3);
    L106:
        appendInternal(r16);
        goto L118
    L108:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L110:
        if (r2 != 'w') goto L116;
        if (r3 > 2) goto L114;
        r16 = new WeekFieldsPrinterParser('w', r3);
        goto L106
    L114:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L116:
        if (r2 != 'Y') goto L120;
        r16 = new WeekFieldsPrinterParser('Y', r3);
        goto L106
    L120:
        throw new IllegalArgumentException("Unknown pattern letter: " + r2);
    L19:
        if (r8 >= r13.length()) goto L32;
        r2 = r13.charAt(r8);
        if (r2 < 'A') goto L23;
        if (r2 > 'Z') goto L23;
    L25:
        int r17 = r8 + 1;
    L27:
        if (r17 >= r13.length()) goto L31;
        if (r13.charAt(r17) != r2) goto L31;
        r17 = r17 + 1;
    L31:
        int r18 = r17 - r8;
        r8 = r17;
    L33:
        if (r3 == 0) goto L36;
        padNext(r3);
        r3 = r18;
        goto L37
    L36:
        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + r13);
    L23:
        if (r2 < 'a') goto L32;
        if (r2 <= 'z') goto L25;
    L32:
        r18 = r3;
        r3 = 0;
    L8:
        if (r2 < 'a') goto L122;
        if (r2 <= 'z') goto L10;
    L122:
        if (r2 != '\'') goto L144;
        int r19 = r1 + 1;
        int r20 = r19;
    L125:
        if (r20 >= r13.length()) goto L135;
        if (r13.charAt(r20) != '\'') goto L133;
        int r21 = r20 + 1;
        if (r21 >= r13.length()) goto L135;
        if (r13.charAt(r21) != '\'') goto L135;
        r20 = r21;
    L133:
        r20 = r20 + 1;
    L135:
        if (r20 >= r13.length()) goto L142;
        String r22 = r13.substring(r19, r20);
        if (r22.length() != 0) goto L139;
        appendLiteral('\'');
    L140:
        r1 = r20;
        goto L160
    L139:
        appendLiteral(r22.replace("''", "'"));
        goto L140
    L142:
        throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + r13);
    L144:
        if (r2 != '[') goto L147;
        optionalStart();
        goto L160
    L147:
        if (r2 != ']') goto L154;
        if (this.active.parent == null) goto L152;
        optionalEnd();
        goto L160
    L152:
        throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
    L154:
        if (r2 == '{') goto L162;
        if (r2 == '}') goto L162;
        if (r2 == '#') goto L162;
        appendLiteral(r2);
    L162:
        throw new IllegalArgumentException("Pattern includes reserved character: '" + r2 + "'");
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        appendInternal(r2.toPrinterParser(false));
        return this;
    }

    public DateTimeFormatterBuilder appendChronologyText(TextStyle r2) {
        Jdk8Methods.requireNonNull(r2, "textStyle");
        appendInternal(new ChronoPrinterParser(r2));
        return this;
    }

    public DateTimeFormatterBuilder appendFraction(TemporalField r3, int r4, int r5, boolean r6) {
        appendInternal(new FractionPrinterParser((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"), r4, r5, r6));
        return this;
    }

    public DateTimeFormatterBuilder appendInstant() {
        appendInternal(new InstantPrinterParser(-2));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(char r2) {
        appendInternal(new CharLiteralPrinterParser(r2));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(String r3) {
        Jdk8Methods.requireNonNull(r3, "literal");
        if (r3.length() > 0) goto L5;
    L9:
        return this;
    L5:
        if (r3.length() != 1) goto L7;
        DateTimePrinterParser r0 = new CharLiteralPrinterParser(r3.charAt(0));
    L8:
        appendInternal(r0);
        goto L9
    L7:
        r0 = new StringLiteralPrinterParser(r3);
        goto L8
    }

    public DateTimeFormatterBuilder appendLocalizedOffset(TextStyle r2) {
        Jdk8Methods.requireNonNull(r2, "style");
        if (r2 != TextStyle.FULL) goto L5;
    L9:
        appendInternal(new LocalizedOffsetPrinterParser(r2));
        return this;
    L5:
        if (r2 == TextStyle.SHORT) goto L9;
        throw new IllegalArgumentException("Style must be either full or short");
    }

    public DateTimeFormatterBuilder appendOffset(String r2, String r3) {
        appendInternal(new OffsetIdPrinterParser(r3, r2));
        return this;
    }

    public DateTimeFormatterBuilder appendOffsetId() {
        appendInternal(OffsetIdPrinterParser.INSTANCE_ID);
        return this;
    }

    public DateTimeFormatterBuilder appendPattern(String r2) {
        Jdk8Methods.requireNonNull(r2, XSDatatype.FACET_PATTERN);
        parsePattern(r2);
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField r3, Map<Long, String> r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r5, "field");
        Jdk8Methods.requireNonNull(r6, "textLookup");
        LinkedHashMap r0 = new LinkedHashMap(r6);
        final SimpleDateTimeTextProvider.LocaleStore r1 = new SimpleDateTimeTextProvider.LocaleStore(Collections.singletonMap(TextStyle.FULL, r0));
        DateTimeTextProvider r7 = new AnonymousClass2(this, r1);
        appendInternal(new TextPrinterParser(r5, TextStyle.FULL, r7));
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField r3, TextStyle r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r5, "field");
        Jdk8Methods.requireNonNull(r4, "textStyle");
        appendInternal(new TextPrinterParser(r5, r4, DateTimeTextProvider.getInstance()));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField r5) {
        TemporalField r6 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r5, TemporalField.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r6, "field");
        appendValue(new NumberPrinterParser(r6, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField r3, int r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r5, "field");
        if (r4 < 1) goto L9;
        if (r4 > 19) goto L9;
        appendValue(new NumberPrinterParser(r5, r4, r4, SignStyle.NOT_NEGATIVE));
        return this;
    L9:
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + r4);
    }

    public DateTimeFormatterBuilder appendValue(TemporalField r3, int r4, int r5, SignStyle r6) {
        TemporalField r7 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (r4 == r5) goto L5;
    L8:
        Jdk8Methods.requireNonNull(r7, "field");
        Jdk8Methods.requireNonNull(r6, "signStyle");
        if (r4 < 1) goto L22;
        if (r4 > 19) goto L22;
        if (r5 < 1) goto L20;
        if (r5 > 19) goto L20;
        if (r5 < r4) goto L18;
        appendValue(new NumberPrinterParser(r7, r4, r5, r6));
        return this;
    L18:
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + r5 + " < " + r4);
    L20:
        throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + r5);
    L22:
        throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + r4);
    L5:
        if (r6 != SignStyle.NOT_NEGATIVE) goto L8;
        return appendValue(r7, r5);
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField r7, int r8, int r9, ChronoLocalDate r10) {
        TemporalField r1 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r7, TemporalField.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r1, "field");
        Jdk8Methods.requireNonNull(r10, "baseDate");
        appendValue(new ReducedPrinterParser(r1, r8, r9, 0, r10));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zoneId(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneRegionId() {
        appendInternal(new ZoneIdPrinterParser(QUERY_REGION_ONLY, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle r2) {
        appendInternal(new ZoneTextPrinterParser(r2));
        return this;
    }

    public DateTimeFormatterBuilder optionalEnd() {
        DateTimeFormatterBuilder r0 = this.active;
        if (r0.parent == null) goto L10;
        if (r0.printerParsers.size() <= 0) goto L7;
        DateTimeFormatterBuilder r1 = this.active;
        CompositePrinterParser r2 = new CompositePrinterParser(r1.printerParsers, r1.optional);
        this.active = this.active.parent;
        appendInternal(r2);
    L8:
        return this;
    L7:
        this.active = this.active.parent;
        goto L8
    L10:
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    public DateTimeFormatterBuilder optionalStart() {
        this.active.valueParserIndex = -1;
        this.active = new DateTimeFormatterBuilder(this.active, true);
        return this;
    }

    public DateTimeFormatterBuilder padNext(int r2) {
        return padNext(r2, ' ');
    }

    public DateTimeFormatterBuilder padNext(int r2, char r3) {
        if (r2 < 1) goto L7;
        DateTimeFormatterBuilder r0 = this.active;
        r0.padNextWidth = r2;
        r0.padNextChar = r3;
        r0.valueParserIndex = -1;
        return this;
    L7:
        throw new IllegalArgumentException("The pad width must be at least one but was " + r2);
    }

    public DateTimeFormatterBuilder parseCaseInsensitive() {
        appendInternal(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseCaseSensitive() {
        appendInternal(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseLenient() {
        appendInternal(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatter toFormatter() {
        return toFormatter(Locale.getDefault());
    }

    public DateTimeFormatter toFormatter(Locale r10) {
        Jdk8Methods.requireNonNull(r10, "locale");
    L4:
        if (this.active.parent == null) goto L7;
        optionalEnd();
        goto L4
    L7:
        return new DateTimeFormatter(new CompositePrinterParser(this.printerParsers, false), r10, DecimalStyle.STANDARD, ResolverStyle.SMART, null, null, null);
    }

    DateTimeFormatter toFormatter(ResolverStyle r1) {
        return toFormatter().withResolverStyle(r1);
    }
}
