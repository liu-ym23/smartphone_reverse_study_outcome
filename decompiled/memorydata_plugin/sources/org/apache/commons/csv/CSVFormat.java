package org.apache.commons.csv;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
public final class CSVFormat implements Serializable {
    public static final CSVFormat DEFAULT = null;
    public static final CSVFormat EXCEL = null;
    public static final CSVFormat INFORMIX_UNLOAD = null;
    public static final CSVFormat INFORMIX_UNLOAD_CSV = null;
    public static final CSVFormat MONGODB_CSV = null;
    public static final CSVFormat MONGODB_TSV = null;
    public static final CSVFormat MYSQL = null;
    public static final CSVFormat ORACLE = null;
    public static final CSVFormat POSTGRESQL_CSV = null;
    public static final CSVFormat POSTGRESQL_TEXT = null;
    public static final CSVFormat RFC4180 = null;
    public static final CSVFormat TDF = null;
    private static final long serialVersionUID = 1;
    private final boolean allowDuplicateHeaderNames;
    private final boolean allowMissingColumnNames;
    private final boolean autoFlush;
    private final Character commentMarker;
    private final char delimiter;
    private final Character escapeCharacter;
    private final String[] header;
    private final String[] headerComments;
    private final boolean ignoreEmptyLines;
    private final boolean ignoreHeaderCase;
    private final boolean ignoreSurroundingSpaces;
    private final String nullString;
    private final Character quoteCharacter;
    private final QuoteMode quoteMode;
    private final String quotedNullString;
    private final String recordSeparator;
    private final boolean skipHeaderRecord;
    private final boolean trailingDelimiter;
    private final boolean trim;

    /* JADX INFO: renamed from: org.apache.commons.csv.CSVFormat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$csv$QuoteMode = null;

        static {
            int[] r0 = new int[QuoteMode.values().length];
            $SwitchMap$org$apache$commons$csv$QuoteMode = r0;
            r0[QuoteMode.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.ALL_NON_NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.NON_NUMERIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.MINIMAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum Predefined extends Enum<Predefined> {
        private static final /* synthetic */ Predefined[] $VALUES = null;
        public static final Predefined Default = null;
        public static final Predefined Excel = null;
        public static final Predefined InformixUnload = null;
        public static final Predefined InformixUnloadCsv = null;
        public static final Predefined MongoDBCsv = null;
        public static final Predefined MongoDBTsv = null;
        public static final Predefined MySQL = null;
        public static final Predefined Oracle = null;
        public static final Predefined PostgreSQLCsv = null;
        public static final Predefined PostgreSQLText = null;
        public static final Predefined RFC4180 = null;
        public static final Predefined TDF = null;
        private final CSVFormat format;

        static {
            Predefined r0 = new Predefined("Default", 0, CSVFormat.DEFAULT);
            Default = r0;
            Predefined r1 = new Predefined("Excel", 1, CSVFormat.EXCEL);
            Excel = r1;
            Predefined r2 = new Predefined("InformixUnload", 2, CSVFormat.INFORMIX_UNLOAD);
            InformixUnload = r2;
            Predefined r4 = new Predefined("InformixUnloadCsv", 3, CSVFormat.INFORMIX_UNLOAD_CSV);
            InformixUnloadCsv = r4;
            Predefined r6 = new Predefined("MongoDBCsv", 4, CSVFormat.MONGODB_CSV);
            MongoDBCsv = r6;
            Predefined r8 = new Predefined("MongoDBTsv", 5, CSVFormat.MONGODB_TSV);
            MongoDBTsv = r8;
            Predefined r10 = new Predefined("MySQL", 6, CSVFormat.MYSQL);
            MySQL = r10;
            Predefined r12 = new Predefined("Oracle", 7, CSVFormat.ORACLE);
            Oracle = r12;
            Predefined r14 = new Predefined("PostgreSQLCsv", 8, CSVFormat.POSTGRESQL_CSV);
            PostgreSQLCsv = r14;
            Predefined r13 = new Predefined("PostgreSQLText", 9, CSVFormat.POSTGRESQL_TEXT);
            PostgreSQLText = r13;
            Predefined r11 = new Predefined("RFC4180", 10, CSVFormat.RFC4180);
            RFC4180 = r11;
            Predefined r9 = new Predefined("TDF", 11, CSVFormat.TDF);
            TDF = r9;
            $VALUES = new Predefined[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9};
        }

        private Predefined(String r1, int r2, CSVFormat r3) {
            super(r1, r2);
            this.format = r3;
        }

        public static Predefined valueOf(String r2) {
            return (Predefined) ZeusTransformUtils.preCheckCast(Enum.valueOf(Predefined.class, r2), Predefined.class, "com.obric.memorydata.plugin");
        }

        public static Predefined[] values() {
            return (Predefined[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Predefined[].class, "com.obric.memorydata.plugin");
        }

        public CSVFormat getFormat() {
            return this.format;
        }
    }

    static {
        CSVFormat r15 = new CSVFormat(',', Constants.DOUBLE_QUOTE_CHAR, null, null, null, false, true, "\r\n", null, null, null, false, false, false, false, false, false, true);
        DEFAULT = r15;
        EXCEL = r15.withIgnoreEmptyLines(false).withAllowMissingColumnNames();
        INFORMIX_UNLOAD = r15.withDelimiter('|').withEscape('\\').withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator('\n');
        INFORMIX_UNLOAD_CSV = r15.withDelimiter(',').withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator('\n');
        MONGODB_CSV = r15.withDelimiter(',').withEscape(Constants.DOUBLE_QUOTE_CHAR).withQuote(Constants.DOUBLE_QUOTE_CHAR).withQuoteMode(QuoteMode.MINIMAL).withSkipHeaderRecord(false);
        MONGODB_TSV = r15.withDelimiter('\t').withEscape(Constants.DOUBLE_QUOTE_CHAR).withQuote(Constants.DOUBLE_QUOTE_CHAR).withQuoteMode(QuoteMode.MINIMAL).withSkipHeaderRecord(false);
        MYSQL = r15.withDelimiter('\t').withEscape('\\').withIgnoreEmptyLines(false).withQuote(null).withRecordSeparator('\n').withNullString("\\N").withQuoteMode(QuoteMode.ALL_NON_NULL);
        ORACLE = r15.withDelimiter(',').withEscape('\\').withIgnoreEmptyLines(false).withQuote(Constants.DOUBLE_QUOTE_CHAR).withNullString("\\N").withTrim().withSystemRecordSeparator().withQuoteMode(QuoteMode.MINIMAL);
        POSTGRESQL_CSV = r15.withDelimiter(',').withEscape(Constants.DOUBLE_QUOTE_CHAR).withIgnoreEmptyLines(false).withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator('\n').withNullString("").withQuoteMode(QuoteMode.ALL_NON_NULL);
        POSTGRESQL_TEXT = r15.withDelimiter('\t').withEscape('\\').withIgnoreEmptyLines(false).withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator('\n').withNullString("\\N").withQuoteMode(QuoteMode.ALL_NON_NULL);
        RFC4180 = r15.withIgnoreEmptyLines(false);
        TDF = r15.withDelimiter('\t').withIgnoreSurroundingSpaces();
    }

    private CSVFormat(char r7, Character r8, QuoteMode r9, Character r10, Character r11, boolean r12, boolean r13, String r14, String r15, Object[] r16, String[] r17, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24) {
        this.delimiter = r7;
        this.quoteCharacter = r8;
        this.quoteMode = r9;
        this.commentMarker = r10;
        this.escapeCharacter = r11;
        this.ignoreSurroundingSpaces = r12;
        this.allowMissingColumnNames = r19;
        this.ignoreEmptyLines = r13;
        this.recordSeparator = r14;
        this.nullString = r15;
        this.headerComments = toStringArray(r16);
        if (r17 != null) goto L5;
        String[] r3 = null;
    L6:
        this.header = r3;
        this.skipHeaderRecord = r18;
        this.ignoreHeaderCase = r20;
        this.trailingDelimiter = r22;
        this.trim = r21;
        this.autoFlush = r23;
        this.quotedNullString = r8 + r15 + r8;
        this.allowDuplicateHeaderNames = r24;
        validate();
        return;
    L5:
        r3 = (String[]) ZeusTransformUtils.preCheckCast(r17.clone(), String[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    private static boolean isLineBreak(char r1) {
        if (r1 != '\n') goto L5;
    L8:
        return true;
    L5:
        if (r1 == '\r') goto L8;
        return false;
    }

    private static boolean isLineBreak(Character r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (isLineBreak(r0.charValue()) == false) goto L6;
        return true;
    }

    public static CSVFormat newFormat(char r20) {
        return new CSVFormat(r20, null, null, null, null, false, false, null, null, null, null, false, false, false, false, false, false, true);
    }

    private void print(Reader r3, Appendable r4, boolean r5) {
        Appendable r6 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.memorydata.plugin");
        if (r5 == true) goto L6;
        r6.append(getDelimiter());
    L6:
        if (isQuoteCharacterSet() == false) goto L9;
        printWithQuotes(r3, r6);
        return;
    L9:
        if (isEscapeCharacterSet() == false) goto L12;
        printWithEscapes(r3, r6);
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r6, Writer.class) == false) goto L14;
        IOUtils.copyLarge(r3, (Writer) ZeusTransformUtils.preCheckCast(r6, Writer.class, "com.obric.memorydata.plugin"));
        return;
    L14:
        IOUtils.copy(r3, r6);
    }

    private void print(Object r3, CharSequence r4, Appendable r5, boolean r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Appendable r8 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r5, Appendable.class, "com.obric.memorydata.plugin");
        int r0 = r7.length();
        if (r6 == true) goto L5;
        r8.append(getDelimiter());
    L5:
        if (r3 != null) goto L8;
        r8.append(r7);
        return;
    L8:
        if (isQuoteCharacterSet() == false) goto L11;
        printWithQuotes(r3, r7, r8, r6);
        return;
    L11:
        if (isEscapeCharacterSet() == false) goto L13;
        printWithEscapes(r7, r8);
        return;
    L13:
        r8.append(r7, 0, r0);
    }

    private void printWithEscapes(Reader r9, Appendable r10) {
        Appendable r11 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r10, Appendable.class, "com.obric.memorydata.plugin");
        char r0 = getDelimiter();
        char r8 = getEscapeCharacter().charValue();
        StringBuilder r1 = new StringBuilder(4096);
        int r3 = 0;
        int r4 = 0;
    L3:
        int r6 = r9.read();
        if ((-1) == r6) goto L18;
        r1.append((char) r6);
        if (r6 == 13) goto L10;
        if (r6 == 10) goto L10;
        if (r6 == r0) goto L10;
        if (r6 == r8) goto L10;
    L17:
        r3 = r3 + 1;
    L10:
        if (r3 <= r4) goto L12;
        r11.append(r1.substring(r4, r3));
        r1.setLength(0);
    L12:
        if (r6 != 10) goto L14;
        r6 = 110;
    L16:
        r11.append(r8);
        r11.append((char) r6);
        r4 = r3 + 1;
        goto L17
    L14:
        if (r6 != 13) goto L16;
        r6 = 114;
        goto L16
    L18:
        if (r3 <= r4) goto L24;
        r11.append(r1.substring(r4, r3));
        return;
    }

    private void printWithEscapes(CharSequence r8, Appendable r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        Appendable r11 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r9, Appendable.class, "com.obric.memorydata.plugin");
        int r0 = r10.length();
        char r1 = getDelimiter();
        char r7 = getEscapeCharacter().charValue();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L17;
        char r4 = r10.charAt(r2);
        if (r4 == '\r') goto L9;
        if (r4 == '\n') goto L9;
        if (r4 == r1) goto L9;
        if (r4 == r7) goto L9;
    L16:
        r2 = r2 + 1;
    L9:
        if (r2 <= r3) goto L11;
        r11.append(r10, r3, r2);
    L11:
        if (r4 != '\n') goto L13;
        r4 = 'n';
    L15:
        r11.append(r7);
        r11.append(r4);
        r3 = r2 + 1;
        goto L16
    L13:
        if (r4 != '\r') goto L15;
        r4 = 'r';
        goto L15
    L17:
        if (r2 <= r3) goto L23;
        r11.append(r10, r3, r2);
        return;
    }

    private void printWithQuotes(Reader r7, Appendable r8) {
        Appendable r9 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r8, Appendable.class, "com.obric.memorydata.plugin");
        if (getQuoteMode() != QuoteMode.NONE) goto L6;
        printWithEscapes(r7, r9);
        return;
    L6:
        char r6 = getQuoteCharacter().charValue();
        StringBuilder r0 = new StringBuilder(4096);
        r9.append(r6);
        int r2 = 0;
    L7:
        int r3 = r7.read();
        if ((-1) == r3) goto L15;
        char r5 = (char) r3;
        r0.append(r5);
        if (r3 != r6) goto L14;
        if (r2 <= 0) goto L13;
        r9.append(r0.substring(0, r2));
        r0.setLength(0);
        r2 = -1;
    L13:
        r9.append(r6);
        r9.append(r5);
    L14:
        r2 = r2 + 1;
        goto L7
    L15:
        if (r2 <= 0) goto L17;
        r9.append(r0.substring(0, r2));
    L17:
        r9.append(r6);
    }

    private void printWithQuotes(Object r10, CharSequence r11, Appendable r12, boolean r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        Appendable r15 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r12, Appendable.class, "com.obric.memorydata.plugin");
        int r0 = r14.length();
        char r1 = getDelimiter();
        char r2 = getQuoteCharacter().charValue();
        if (isEscapeCharacterSet() == false) goto L5;
        char r3 = getEscapeCharacter().charValue();
    L6:
        QuoteMode r4 = getQuoteMode();
        if (r4 != null) goto L9;
        r4 = QuoteMode.MINIMAL;
    L9:
        int r5 = AnonymousClass1.$SwitchMap$org$apache$commons$csv$QuoteMode[r4.ordinal()];
        int r6 = 0;
        boolean r7 = true;
        if (r5 != 1) goto L12;
    L52:
        int r9 = 0;
    L53:
        if (r7 == true) goto L56;
        r15.append(r14, 0, r0);
        return;
    L56:
        r15.append(r2);
    L57:
        if (r9 >= r0) goto L63;
        char r16 = r14.charAt(r9);
        if (r16 == r2) goto L61;
        if (r16 == r3) goto L61;
    L62:
        r9 = r9 + 1;
    L61:
        r15.append(r14, r6, r9);
        r15.append(r3);
        r6 = r9;
        goto L62
    L63:
        r15.append(r14, r6, r9);
        r15.append(r2);
        return;
    L12:
        if (r5 == 2) goto L52;
        if (r5 != 3) goto L16;
        r7 = true ^ ZeusTransformUtils.instanceOf(r10, Number.class);
        goto L52
    L16:
        if (r5 != 4) goto L18;
        printWithEscapes(r14, r15);
        return;
    L18:
        if (r5 != 5) goto L48;
        if (r0 > 0) goto L24;
        if (r13 == true) goto L25;
        r9 = 0;
        r7 = false;
    L44:
        if (r7 == true) goto L53;
        r15.append(r14, 0, r0);
        return;
    L25:
        r9 = 0;
        goto L44
    L24:
        if (r14.charAt(0) <= '#') goto L25;
        r9 = 0;
    L27:
        if (r9 >= r0) goto L38;
        char r17 = r14.charAt(r9);
        if (r17 == '\n') goto L37;
        if (r17 == '\r') goto L37;
        if (r17 == r2) goto L37;
        if (r17 == r1) goto L37;
        if (r17 == r3) goto L37;
        r9 = r9 + 1;
    L37:
        boolean r18 = true;
    L39:
        if (r18 == true) goto L43;
        r9 = r0 - 1;
        if (r14.charAt(r9) <= ' ') goto L44;
    L43:
        r7 = r18;
        goto L44
    L38:
        r18 = false;
        goto L39
    L48:
        throw new IllegalStateException("Unexpected Quote value: " + r4);
    L5:
        r3 = r2;
        goto L6
    }

    private String[] toStringArray(Object[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        String[] r0 = new String[r4.length];
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L13;
        Object r2 = r4[r1];
        if (r2 != null) goto L11;
        String r3 = null;
    L12:
        r0[r1] = r3;
        r1 = r1 + 1;
        goto L7
    L11:
        r3 = r2.toString();
        goto L12
    L13:
        return r0;
    }

    private CharSequence trim(CharSequence r5) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L5;
        int r6 = r4.length();
        int r0 = 0;
    L8:
        if (r0 >= r6) goto L12;
        if (r4.charAt(r0) > ' ') goto L12;
        r0 = r0 + 1;
    L12:
        int r2 = r6;
    L13:
        if (r0 >= r2) goto L17;
        if (r4.charAt(r2 - 1) > ' ') goto L17;
        r2 = r2 - 1;
    L17:
        if (r0 > 0) goto L20;
        if (r2 < r6) goto L20;
        return r4;
    L20:
        return r4.subSequence(r0, r2);
    L5:
        return ((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin")).trim();
    }

    private void validate() {
        if (isLineBreak(this.delimiter) == true) goto L59;
        Character r0 = this.quoteCharacter;
        if (r0 != null) goto L7;
    L11:
        Character r1 = this.escapeCharacter;
        if (r1 != null) goto L14;
    L18:
        Character r2 = this.commentMarker;
        if (r2 != null) goto L21;
    L25:
        Character r3 = this.quoteCharacter;
        if (r3 != null) goto L28;
    L32:
        Character r4 = this.escapeCharacter;
        if (r4 == null) goto L40;
        if (r4.equals(this.commentMarker) == false) goto L40;
        throw new IllegalArgumentException("The comment start and the escape character cannot be the same ('" + this.commentMarker + "')");
    L40:
        if (this.escapeCharacter != null) goto L47;
        if (this.quoteMode != QuoteMode.NONE) goto L47;
        throw new IllegalArgumentException("No quotes mode set but no escape character is set");
    L47:
        if (this.header != null) goto L49;
        return;
    L49:
        if (this.allowDuplicateHeaderNames == true) goto L62;
        HashSet r5 = new HashSet();
        String[] r6 = this.header;
        int r7 = r6.length;
        int r8 = 0;
    L51:
        if (r8 >= r7) goto L63;
        String r9 = r6[r8];
        if (r5.add(r9) == false) goto L56;
        r8 = r8 + 1;
        goto L51
    L56:
        throw new IllegalArgumentException("The header contains a duplicate entry: '" + r9 + "' in " + Arrays.toString(this.header));
    L63:
        return;
    L62:
        return;
    L28:
        if (r3.equals(this.commentMarker) == false) goto L32;
        throw new IllegalArgumentException("The comment start character and the quoteChar cannot be the same ('" + this.commentMarker + "')");
    L21:
        if (this.delimiter != r2.charValue()) goto L25;
        throw new IllegalArgumentException("The comment start character and the delimiter cannot be the same ('" + this.commentMarker + "')");
    L14:
        if (this.delimiter != r1.charValue()) goto L18;
        throw new IllegalArgumentException("The escape character and the delimiter cannot be the same ('" + this.escapeCharacter + "')");
    L7:
        if (this.delimiter != r0.charValue()) goto L11;
        throw new IllegalArgumentException("The quoteChar character and the delimiter cannot be the same ('" + this.quoteCharacter + "')");
    L59:
        throw new IllegalArgumentException("The delimiter cannot be a line break");
    }

    public static CSVFormat valueOf(String r0) {
        return Predefined.valueOf(r0).getFormat();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        CSVFormat r6 = (CSVFormat) ZeusTransformUtils.preCheckCast(r5, CSVFormat.class, "com.obric.memorydata.plugin");
        if (this.delimiter == r6.delimiter) goto L15;
        return false;
    L15:
        if (this.trailingDelimiter == r6.trailingDelimiter) goto L18;
        return false;
    L18:
        if (this.autoFlush == r6.autoFlush) goto L21;
        return false;
    L21:
        if (this.trim == r6.trim) goto L24;
        return false;
    L24:
        if (this.allowMissingColumnNames == r6.allowMissingColumnNames) goto L27;
        return false;
    L27:
        if (this.allowDuplicateHeaderNames == r6.allowDuplicateHeaderNames) goto L30;
        return false;
    L30:
        if (this.ignoreHeaderCase == r6.ignoreHeaderCase) goto L33;
        return false;
    L33:
        if (this.quoteMode == r6.quoteMode) goto L35;
        return false;
    L35:
        Character r2 = this.quoteCharacter;
        if (r2 != null) goto L41;
        if (r6.quoteCharacter == null) goto L43;
        return false;
    L43:
        Character r3 = this.commentMarker;
        if (r3 != null) goto L49;
        if (r6.commentMarker == null) goto L51;
        return false;
    L51:
        Character r4 = this.escapeCharacter;
        if (r4 != null) goto L57;
        if (r6.escapeCharacter == null) goto L59;
        return false;
    L59:
        String r7 = this.nullString;
        if (r7 != null) goto L65;
        if (r6.nullString == null) goto L68;
        return false;
    L68:
        if (Arrays.equals(this.header, r6.header) == true) goto L71;
        return false;
    L71:
        if (this.ignoreSurroundingSpaces == r6.ignoreSurroundingSpaces) goto L74;
        return false;
    L74:
        if (this.ignoreEmptyLines == r6.ignoreEmptyLines) goto L77;
        return false;
    L77:
        if (this.skipHeaderRecord == r6.skipHeaderRecord) goto L79;
        return false;
    L79:
        String r8 = this.recordSeparator;
        if (r8 != null) goto L85;
        if (r6.recordSeparator == null) goto L88;
        return false;
    L88:
        if (Arrays.equals(this.headerComments, r6.headerComments) == true) goto L90;
        return false;
    L90:
        return true;
    L85:
        if (r8.equals(r6.recordSeparator) == true) goto L88;
        return false;
    L65:
        if (r7.equals(r6.nullString) == true) goto L68;
        return false;
    L57:
        if (r4.equals(r6.escapeCharacter) == true) goto L59;
        return false;
    L49:
        if (r3.equals(r6.commentMarker) == true) goto L51;
        return false;
    L41:
        if (r2.equals(r6.quoteCharacter) == true) goto L43;
        return false;
    }

    public String format(Object... r3) {
        StringWriter r0 = new StringWriter();
        CSVPrinter r1 = new CSVPrinter(r0, this);     // Catch: IOException -> L15
        r1.printRecord(r3);     // Catch: Throwable -> L7
        String r2 = r0.toString().trim();     // Catch: Throwable -> L7
        r1.close();     // Catch: IOException -> L15
        return r2;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: IOException -> L15
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L15
    L15:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public boolean getAllowDuplicateHeaderNames() {
        return this.allowDuplicateHeaderNames;
    }

    public boolean getAllowMissingColumnNames() {
        return this.allowMissingColumnNames;
    }

    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public Character getCommentMarker() {
        return this.commentMarker;
    }

    public char getDelimiter() {
        return this.delimiter;
    }

    public Character getEscapeCharacter() {
        return this.escapeCharacter;
    }

    public String[] getHeader() {
        String[] r2 = this.header;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (String[]) ZeusTransformUtils.preCheckCast(r2.clone(), String[].class, "com.obric.memorydata.plugin");
    }

    public String[] getHeaderComments() {
        String[] r2 = this.headerComments;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (String[]) ZeusTransformUtils.preCheckCast(r2.clone(), String[].class, "com.obric.memorydata.plugin");
    }

    public boolean getIgnoreEmptyLines() {
        return this.ignoreEmptyLines;
    }

    public boolean getIgnoreHeaderCase() {
        return this.ignoreHeaderCase;
    }

    public boolean getIgnoreSurroundingSpaces() {
        return this.ignoreSurroundingSpaces;
    }

    public String getNullString() {
        return this.nullString;
    }

    public Character getQuoteCharacter() {
        return this.quoteCharacter;
    }

    public QuoteMode getQuoteMode() {
        return this.quoteMode;
    }

    public String getRecordSeparator() {
        return this.recordSeparator;
    }

    public boolean getSkipHeaderRecord() {
        return this.skipHeaderRecord;
    }

    public boolean getTrailingDelimiter() {
        return this.trailingDelimiter;
    }

    public boolean getTrim() {
        return this.trim;
    }

    public int hashCode() {
        int r0 = (this.delimiter + 31) * 31;
        QuoteMode r2 = this.quoteMode;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r1 = (r0 + r4) * 31;
        Character r5 = this.quoteCharacter;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r1 + r6) * 31;
        Character r8 = this.commentMarker;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Character r11 = this.escapeCharacter;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.nullString;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        int r17 = 1231;
        if (this.ignoreSurroundingSpaces == false) goto L25;
        int r18 = 1231;
    L26:
        int r19 = (r16 + r18) * 31;
        if (this.ignoreHeaderCase == false) goto L29;
        int r20 = 1231;
    L30:
        int r21 = (r19 + r20) * 31;
        if (this.ignoreEmptyLines == false) goto L33;
        int r22 = 1231;
    L34:
        int r23 = (r21 + r22) * 31;
        if (this.skipHeaderRecord == false) goto L37;
        int r24 = 1231;
    L38:
        int r25 = (r23 + r24) * 31;
        if (this.allowDuplicateHeaderNames == false) goto L41;
        int r26 = 1231;
    L42:
        int r27 = (r25 + r26) * 31;
        if (this.trim == false) goto L45;
        int r28 = 1231;
    L46:
        int r29 = (r27 + r28) * 31;
        if (this.autoFlush == false) goto L49;
        int r30 = 1231;
    L50:
        int r31 = (r29 + r30) * 31;
        if (this.trailingDelimiter == false) goto L53;
        int r32 = 1231;
    L54:
        int r33 = (r31 + r32) * 31;
        if (this.allowMissingColumnNames == true) goto L58;
        r17 = 1237;
    L58:
        int r34 = (r33 + r17) * 31;
        String r35 = this.recordSeparator;
        if (r35 == null) goto L63;
        r3 = r35.hashCode();
    L63:
        return ((((r34 + r3) * 31) + Arrays.hashCode(this.header)) * 31) + Arrays.hashCode(this.headerComments);
    L53:
        r32 = 1237;
        goto L54
    L49:
        r30 = 1237;
        goto L50
    L45:
        r28 = 1237;
        goto L46
    L41:
        r26 = 1237;
        goto L42
    L37:
        r24 = 1237;
        goto L38
    L33:
        r22 = 1237;
        goto L34
    L29:
        r20 = 1237;
        goto L30
    L25:
        r18 = 1237;
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public boolean isCommentMarkerSet() {
        if (this.commentMarker == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEscapeCharacterSet() {
        if (this.escapeCharacter == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNullStringSet() {
        if (this.nullString == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isQuoteCharacterSet() {
        if (this.quoteCharacter == null) goto L5;
        return true;
    L5:
        return false;
    }

    public CSVParser parse(Reader r2) {
        return new CSVParser(r2, this);
    }

    public CSVPrinter print(File r4, Charset r5) {
        return new CSVPrinter(new OutputStreamWriter(new FileOutputStream(r4), r5), this);
    }

    public CSVPrinter print(Appendable r3) {
        return new CSVPrinter((Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin"), this);
    }

    public CSVPrinter print(Path r3, Charset r4) {
        return print(Files.newBufferedWriter((Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin"), r4, new OpenOption[0]));
    }

    public void print(Object r3, Appendable r4, boolean r5) {
        Appendable r6 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
        if (this.nullString != null) goto L8;
        CharSequence r0 = "";
    L20:
        if (getTrim() == false) goto L22;
        r0 = trim(r0);
    L22:
        print(r3, r0, r6, r5);
        return;
    L8:
        if (QuoteMode.ALL != this.quoteMode) goto L10;
        r0 = this.quotedNullString;
        goto L20
    L10:
        r0 = this.nullString;
        goto L20
    L12:
        if (ZeusTransformUtils.instanceOf(r3, CharSequence.class) == false) goto L15;
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        goto L20
    L15:
        if (ZeusTransformUtils.instanceOf(r3, Reader.class) == false) goto L18;
        print((Reader) ZeusTransformUtils.preCheckCast(r3, Reader.class, "com.obric.memorydata.plugin"), r6, r5);
        return;
    L18:
        r0 = r3.toString();
        goto L20
    }

    public void printRecord(Appendable r5, Object... r6) {
        Appendable r7 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r5, Appendable.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L10;
        Object r2 = r6[r1];
        if (r1 != 0) goto L8;
        boolean r3 = true;
    L9:
        print(r2, r7, r3);
        r1 = r1 + 1;
        goto L4
    L8:
        r3 = false;
        goto L9
    L10:
        println(r7);
    }

    public CSVPrinter printer() {
        return new CSVPrinter(System.out, this);
    }

    public void println(Appendable r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        if (getTrailingDelimiter() == false) goto L5;
        r4.append(getDelimiter());
    L5:
        String r2 = this.recordSeparator;
        if (r2 == null) goto L9;
        r4.append(r2);
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Delimiter=<").append(this.delimiter).append(Typography.greater);
        if (isEscapeCharacterSet() == false) goto L6;
        r0.append(' ');
        r0.append("Escape=<").append(this.escapeCharacter).append(Typography.greater);
    L6:
        if (isQuoteCharacterSet() == false) goto L9;
        r0.append(' ');
        r0.append("QuoteChar=<").append(this.quoteCharacter).append(Typography.greater);
    L9:
        if (this.quoteMode == null) goto L12;
        r0.append(' ');
        r0.append("QuoteMode=<").append(this.quoteMode).append(Typography.greater);
    L12:
        if (isCommentMarkerSet() == false) goto L15;
        r0.append(' ');
        r0.append("CommentStart=<").append(this.commentMarker).append(Typography.greater);
    L15:
        if (isNullStringSet() == false) goto L18;
        r0.append(' ');
        r0.append("NullString=<").append(this.nullString).append(Typography.greater);
    L18:
        if (this.recordSeparator == null) goto L21;
        r0.append(' ');
        r0.append("RecordSeparator=<").append(this.recordSeparator).append(Typography.greater);
    L21:
        if (getIgnoreEmptyLines() == false) goto L24;
        r0.append(" EmptyLines:ignored");
    L24:
        if (getIgnoreSurroundingSpaces() == false) goto L27;
        r0.append(" SurroundingSpaces:ignored");
    L27:
        if (getIgnoreHeaderCase() == false) goto L29;
        r0.append(" IgnoreHeaderCase:ignored");
    L29:
        r0.append(" SkipHeaderRecord:").append(this.skipHeaderRecord);
        if (this.headerComments == null) goto L33;
        r0.append(' ');
        r0.append("HeaderComments:").append(Arrays.toString(this.headerComments));
    L33:
        if (this.header == null) goto L36;
        r0.append(' ');
        r0.append("Header:").append(Arrays.toString(this.header));
    L36:
        return r0.toString();
    }

    public CSVFormat withAllowDuplicateHeaderNames() {
        return withAllowDuplicateHeaderNames(true);
    }

    public CSVFormat withAllowDuplicateHeaderNames(boolean r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, r22);
    }

    public CSVFormat withAllowMissingColumnNames() {
        return withAllowMissingColumnNames(true);
    }

    public CSVFormat withAllowMissingColumnNames(boolean r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, r22, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withAutoFlush(boolean r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, r22, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withCommentMarker(char r1) {
        return withCommentMarker(Character.valueOf(r1));
    }

    public CSVFormat withCommentMarker(Character r22) {
        if (isLineBreak(r22) == true) goto L7;
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, r22, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    L7:
        throw new IllegalArgumentException("The comment start marker character cannot be a line break");
    }

    public CSVFormat withDelimiter(char r22) {
        if (isLineBreak(r22) == true) goto L7;
        return new CSVFormat(r22, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    L7:
        throw new IllegalArgumentException("The delimiter cannot be a line break");
    }

    public CSVFormat withEscape(char r1) {
        return withEscape(Character.valueOf(r1));
    }

    public CSVFormat withEscape(Character r22) {
        if (isLineBreak(r22) == true) goto L7;
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, r22, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    L7:
        throw new IllegalArgumentException("The escape character cannot be a line break");
    }

    public CSVFormat withFirstRecordAsHeader() {
        return withHeader(new String[0]).withSkipHeaderRecord();
    }

    public CSVFormat withHeader(Class<? extends Enum<?>> r4) {
        if (r4 == null) goto L7;
        Enum[] r5 = (Enum[]) ZeusTransformUtils.preCheckCast(r4.getEnumConstants(), Enum[].class, "com.obric.memorydata.plugin");
        String[] r0 = new String[r5.length];
        int r1 = 0;
    L5:
        if (r1 >= r5.length) goto L9;
        r0[r1] = r5[r1].name();
        r1 = r1 + 1;
    L9:
        return withHeader(r0);
    L7:
        r0 = null;
        goto L9
    }

    public CSVFormat withHeader(ResultSet r3) {
        ResultSet r4 = (ResultSet) ZeusTransformUtils.wrapperContextForParams(r3, ResultSet.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        ResultSetMetaData r5 = r4.getMetaData();
    L7:
        return withHeader(r5);
    L5:
        r5 = null;
        goto L7
    }

    public CSVFormat withHeader(ResultSetMetaData r6) {
        ResultSetMetaData r7 = (ResultSetMetaData) ZeusTransformUtils.wrapperContextForParams(r6, ResultSetMetaData.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L7;
        int r0 = r7.getColumnCount();
        String[] r1 = new String[r0];
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L9;
        int r3 = r2 + 1;
        r1[r2] = r7.getColumnLabel(r3);
        r2 = r3;
    L9:
        return withHeader(r1);
    L7:
        r1 = null;
        goto L9
    }

    public CSVFormat withHeader(String... r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, r22, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withHeaderComments(Object... r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, r22, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withIgnoreEmptyLines() {
        return withIgnoreEmptyLines(true);
    }

    public CSVFormat withIgnoreEmptyLines(boolean r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, r22, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withIgnoreHeaderCase() {
        return withIgnoreHeaderCase(true);
    }

    public CSVFormat withIgnoreHeaderCase(boolean r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, r22, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withIgnoreSurroundingSpaces() {
        return withIgnoreSurroundingSpaces(true);
    }

    public CSVFormat withIgnoreSurroundingSpaces(boolean r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, r22, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withNullString(String r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, r22, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withQuote(char r1) {
        return withQuote(Character.valueOf(r1));
    }

    public CSVFormat withQuote(Character r22) {
        if (isLineBreak(r22) == true) goto L7;
        return new CSVFormat(this.delimiter, r22, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    L7:
        throw new IllegalArgumentException("The quoteChar cannot be a line break");
    }

    public CSVFormat withQuoteMode(QuoteMode r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, r22, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withRecordSeparator(char r1) {
        return withRecordSeparator(String.valueOf(r1));
    }

    public CSVFormat withRecordSeparator(String r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, r22, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withSkipHeaderRecord() {
        return withSkipHeaderRecord(true);
    }

    public CSVFormat withSkipHeaderRecord(boolean r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, r22, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withSystemRecordSeparator() {
        return withRecordSeparator(System.getProperty("line.separator"));
    }

    public CSVFormat withTrailingDelimiter() {
        return withTrailingDelimiter(true);
    }

    public CSVFormat withTrailingDelimiter(boolean r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, r22, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withTrim() {
        return withTrim(true);
    }

    public CSVFormat withTrim(boolean r22) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, r22, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }
}
