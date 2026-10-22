package org.apache.poi.ss.usermodel;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.format.CellFormatResult;
import org.apache.poi.ss.formula.ConditionalFormattingEvaluator;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class DataFormatter {
    private static final c LOG = null;
    private static final Pattern alternateGrouping = null;
    private static final Pattern amPmPattern = null;
    private static final Pattern colorPattern = null;
    private static final Pattern daysAsText = null;
    private static final Pattern fractionPattern = null;
    private static final Pattern fractionStripper = null;
    private static final String invalidDateTimeString = null;
    private static final Pattern localePatternGroup = null;
    private static final Pattern numPattern = null;
    private static final Pattern rangeConditionalPattern = null;
    private DateFormatSymbols dateSymbols;
    private DecimalFormatSymbols decimalSymbols;
    private DateFormat defaultDateformat;
    private Format defaultNumFormat;
    private boolean emulateCSV;
    private final Map<String, Format> formats;
    private Format generalNumberFormat;
    private Locale locale;
    private boolean localeIsAdapting;
    private final PropertyChangeSupport pcs;
    private boolean use4DigitYearsInAllDateFormats;
    private boolean useCachedValuesForFormulaCells;

    /* JADX INFO: renamed from: org.apache.poi.ss.usermodel.DataFormatter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType = null;

        static {
            int[] r0 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = r0;
            r0[CellType.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private final class CellFormatResultWrapper extends Format {
        private final CellFormatResult result;
        final /* synthetic */ DataFormatter this$0;

        private CellFormatResultWrapper(DataFormatter r1, CellFormatResult r2) {
            this.this$0 = r1;
            this.result = r2;
        }

        /* synthetic */ CellFormatResultWrapper(DataFormatter r1, CellFormatResult r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // java.text.Format
        public StringBuffer format(Object r1, StringBuffer r2, FieldPosition r3) {
            boolean r4 = DataFormatter.access$200(this.this$0);
            String r0 = this.result.text;
            if (r4 == false) goto L7;
            return r2.append(r0);
        L7:
            return r2.append(r0.trim());
        }

        @Override // java.text.Format
        public Object parseObject(String r1, ParsePosition r2) {
            return null;
        }
    }

    private static final class ConstantStringFormat extends Format {
        private static final DecimalFormat df = null;
        private final String str;

        static {
            df = DataFormatter.access$100("##########");
        }

        public ConstantStringFormat(String r1) {
            this.str = r1;
        }

        @Override // java.text.Format
        public StringBuffer format(Object r1, StringBuffer r2, FieldPosition r3) {
            return r2.append(this.str);
        }

        @Override // java.text.Format
        public Object parseObject(String r1, ParsePosition r2) {
            return df.parseObject(r1, r2);
        }
    }

    private static class InternalDecimalFormatWithScale extends Format {
        private static final BigDecimal ONE_THOUSAND = null;
        private static final Pattern endsWithCommas = null;
        private final DecimalFormat df;
        private final BigDecimal divider;

        static {
            endsWithCommas = Pattern.compile("(,+)$");
            ONE_THOUSAND = BigDecimal.valueOf(1000);
        }

        public InternalDecimalFormatWithScale(String r3, DecimalFormatSymbols r4) {
            DecimalFormat r0 = new DecimalFormat(trimTrailingCommas(r3), r4);
            this.df = r0;
            DataFormatter.setExcelStyleRoundingMode(r0);
            Matcher r5 = endsWithCommas.matcher(r3);
            if (r5.find() == false) goto L9;
            String r6 = r5.group(1);
            BigDecimal r7 = BigDecimal.ONE;
            int r1 = 0;
        L6:
            if (r1 >= r6.length()) goto L8;
            r7 = r7.multiply(ONE_THOUSAND);
            r1 = r1 + 1;
            goto L6
        L8:
            this.divider = r7;
            return;
        L9:
            this.divider = null;
        }

        private Object scaleInput(Object r3) {
            if (this.divider != null) goto L5;
            return r3;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, BigDecimal.class) == false) goto L8;
            return ((BigDecimal) ZeusTransformUtils.preCheckCast(r3, BigDecimal.class, "com.obric.memorydata.plugin")).divide(this.divider, RoundingMode.HALF_UP);
        L8:
            if (ZeusTransformUtils.instanceOf(r3, Double.class) == false) goto L11;
            return Double.valueOf(((Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.memorydata.plugin")).doubleValue() / this.divider.doubleValue());
        L11:
            throw new UnsupportedOperationException();
        }

        private static String trimTrailingCommas(String r2) {
            return r2.replaceAll(",+$", "");
        }

        @Override // java.text.Format
        public StringBuffer format(Object r1, StringBuffer r2, FieldPosition r3) {
            Object r4 = scaleInput(r1);
            return this.df.format(r4, r2, r3);
        }

        @Override // java.text.Format
        public Object parseObject(String r1, ParsePosition r2) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class PhoneFormat extends Format {
        private static final DecimalFormat df = null;
        public static final Format instance = null;

        static {
            instance = new PhoneFormat();
            df = DataFormatter.access$100("##########");
        }

        private PhoneFormat() {
        }

        public static String format(Number r7) {
            String r8 = df.format(r7);
            StringBuilder r0 = new StringBuilder();
            int r1 = r8.length();
            if (r1 > 4) goto L5;
            return r8;
        L5:
            int r2 = r1 - 4;
            String r3 = r8.substring(r2, r1);
            int r4 = r1 - 7;
            String r5 = r8.substring(Math.max(0, r4), r2);
            String r9 = r8.substring(Math.max(0, r1 - 10), Math.max(0, r4));
            if (StringUtil.isNotBlank(r9) == false) goto L9;
            r0.append('(').append(r9).append(") ");
        L9:
            if (StringUtil.isNotBlank(r5) == false) goto L11;
            r0.append(r5).append('-');
        L11:
            r0.append(r3);
            return r0.toString();
        }

        @Override // java.text.Format
        public StringBuffer format(Object r1, StringBuffer r2, FieldPosition r3) {
            return r2.append(format((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")));
        }

        @Override // java.text.Format
        public Object parseObject(String r1, ParsePosition r2) {
            return df.parseObject(r1, r2);
        }
    }

    private static final class SSNFormat extends Format {
        private static final DecimalFormat df = null;
        public static final Format instance = null;

        static {
            instance = new SSNFormat();
            df = DataFormatter.access$100("000000000");
        }

        private SSNFormat() {
        }

        public static String format(Number r4) {
            String r5 = df.format(r4);
            return r5.substring(0, 3) + '-' + r5.substring(3, 5) + '-' + r5.substring(5, 9);
        }

        @Override // java.text.Format
        public StringBuffer format(Object r1, StringBuffer r2, FieldPosition r3) {
            return r2.append(format((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")));
        }

        @Override // java.text.Format
        public Object parseObject(String r1, ParsePosition r2) {
            return df.parseObject(r1, r2);
        }
    }

    private static final class ZipPlusFourFormat extends Format {
        private static final DecimalFormat df = null;
        public static final Format instance = null;

        static {
            instance = new ZipPlusFourFormat();
            df = DataFormatter.access$100("000000000");
        }

        private ZipPlusFourFormat() {
        }

        public static String format(Number r3) {
            String r4 = df.format(r3);
            return r4.substring(0, 5) + '-' + r4.substring(5, 9);
        }

        @Override // java.text.Format
        public StringBuffer format(Object r1, StringBuffer r2, FieldPosition r3) {
            return r2.append(format((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")));
        }

        @Override // java.text.Format
        public Object parseObject(String r1, ParsePosition r2) {
            return df.parseObject(r1, r2);
        }
    }

    static {
        numPattern = Pattern.compile("[0#]+");
        daysAsText = Pattern.compile("([d]{3,})", 2);
        amPmPattern = Pattern.compile("(([AP])[M/P]*)", 2);
        rangeConditionalPattern = Pattern.compile(".*\\[\\s*(>|>=|<|<=|=)\\s*[0-9]*\\.*[0-9].*");
        localePatternGroup = Pattern.compile("(\\[\\$[^-\\]]*-[0-9A-Z]+])");
        colorPattern = Pattern.compile("(\\[BLACK])|(\\[BLUE])|(\\[CYAN])|(\\[GREEN])|(\\[MAGENTA])|(\\[RED])|(\\[WHITE])|(\\[YELLOW])|(\\[COLOR\\s*\\d])|(\\[COLOR\\s*[0-5]\\d])", 2);
        fractionPattern = Pattern.compile("(?:([#\\d]+)\\s+)?(#+)\\s*/\\s*([#\\d]+)");
        fractionStripper = Pattern.compile("(\"[^\"]*\")|([^ ?#\\d/]+)");
        alternateGrouping = Pattern.compile("([#0]([^.#0])[#0]{3})");
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= 255) goto L6;
        r0.append('#');
        r1 = r1 + 1;
        goto L4
    L6:
        invalidDateTimeString = r0.toString();
        LOG = b.a(DataFormatter.class);
    }

    public DataFormatter() {
        this(false);
    }

    public DataFormatter(Locale r2) {
        this(r2, false);
    }

    public DataFormatter(Locale r2, boolean r3) {
        this(r2, false, r3);
    }

    public DataFormatter(Locale r2, boolean r3, boolean r4) {
        this.formats = new HashMap();
        this.emulateCSV = false;
        this.use4DigitYearsInAllDateFormats = false;
        this.useCachedValuesForFormulaCells = false;
        this.localeIsAdapting = true;
        this.pcs = new PropertyChangeSupport(this);
        checkForLocaleChange(r2);
        this.localeIsAdapting = r3;
        this.emulateCSV = r4;
    }

    public DataFormatter(boolean r3) {
        this(LocaleUtil.getUserLocale(), true, r3);
    }

    static /* synthetic */ DecimalFormat access$100(String r0) {
        return createIntegerOnlyFormat(r0);
    }

    static /* synthetic */ boolean access$200(DataFormatter r0) {
        return r0.emulateCSV;
    }

    private void checkForLocaleChange() {
        checkForLocaleChange(LocaleUtil.getUserLocale());
    }

    private void checkForLocaleChange(Locale r3) {
        if (this.localeIsAdapting == true) goto L6;
        return;
    L6:
        if (r3.equals(this.locale) == false) goto L8;
        return;
    L8:
        updateLocale(r3);
        this.pcs.firePropertyChange("locale", this.locale, r3);
    }

    private String cleanFormatForNumber(String r8) {
        StringBuilder r0 = new StringBuilder(r8.replace("\\%", "'%'"));
        int r3 = 0;
        if (this.emulateCSV == false) goto L25;
        int r7 = 0;
    L6:
        if (r7 >= r0.length()) goto L41;
        char r4 = r0.charAt(r7);
        if (r4 == '_') goto L11;
        if (r4 == '*') goto L11;
        if (r4 == '?') goto L11;
    L24:
        r7 = r7 + 1;
    L11:
        if (r7 <= 0) goto L16;
        if (r0.charAt(r7 - 1) == '\\') goto L24;
    L16:
        if (r4 != '?') goto L19;
        r0.setCharAt(r7, ' ');
        goto L24
    L19:
        if (r7 >= (r0.length() - 1)) goto L24;
        if (r4 != '_') goto L22;
        r0.setCharAt(r7 + 1, ' ');
    L23:
        r0.deleteCharAt(r7);
        r7 = r7 - 1;
        goto L24
    L22:
        r0.deleteCharAt(r7 + 1);
    L41:
        if (r3 >= r0.length()) goto L57;
        char r9 = r0.charAt(r3);
        if (r9 != '\\') goto L45;
    L54:
        r0.deleteCharAt(r3);
        r3 = r3 - 1;
    L55:
        r3 = r3 + 1;
        goto L41
    L45:
        if (r9 == '\"') goto L54;
        if (r9 != '+') goto L50;
    L51:
        if (r3 <= 0) goto L55;
        if (r0.charAt(r3 - 1) != 'E') goto L55;
    L50:
        if (r9 != '-') goto L55;
    L57:
        return r0.toString();
    L25:
        int r10 = 0;
    L27:
        if (r10 >= r0.length()) goto L41;
        char r5 = r0.charAt(r10);
        if (r5 == '_') goto L31;
        if (r5 == '*') goto L31;
    L39:
        r10 = r10 + 1;
    L31:
        if (r10 <= 0) goto L36;
        if (r0.charAt(r10 - 1) == '\\') goto L39;
    L36:
        if (r10 >= (r0.length() - 1)) goto L38;
        r0.deleteCharAt(r10 + 1);
    L38:
        r0.deleteCharAt(r10);
        r10 = r10 - 1;
        goto L39
    }

    private Format createDateFormat(String r17, double r18) {
        String r0 = adjustTo4DigitYearsIfConfigured(r17).replace("\\-", "-").replace("\\,", ",").replace("\\.", ".").replace("\\ ", " ").replace("\\/", "/").replace(";@", "").replace("\"/\"", "/").replace("\"\"", "'").replace("\\T", "'T'");
        Matcher r2 = amPmPattern.matcher(r0);
        boolean r3 = false;
        boolean r5 = false;
    L4:
        if (r2.find() == false) goto L6;
        r0 = r2.replaceAll("@");
        r2 = amPmPattern.matcher(r0);
        r5 = true;
        goto L4
    L6:
        String r1 = r0.replace('@', 'a');
        Matcher r4 = daysAsText.matcher(r1);
        if (r4.find() == false) goto L9;
        r1 = r4.replaceAll(r4.group(0).toUpperCase(Locale.ROOT).replace('D', 'E'));
    L9:
        StringBuilder r6 = new StringBuilder();
        char[] r7 = r1.toCharArray();
        ArrayList r8 = new ArrayList();
        int r9 = 0;
        boolean r10 = false;
        boolean r11 = true;
    L11:
        if (r9 >= r7.length) goto L83;
        char r12 = r7[r9];
        if (r12 != '\'') goto L21;
        r6.append(r12);
    L15:
        r9 = r9 + 1;
        if (r9 >= r7.length) goto L19;
        char r13 = r7[r9];
        r6.append(r13);
        if (r13 != '\'') goto L15;
    L19:
        int r14 = 1;
    L82:
        r9 = r9 + r14;
        r3 = false;
        goto L11
    L21:
        if (r12 != '[') goto L25;
        if (r10 == true) goto L25;
        r6.append(r12);
        r11 = r3;
        r14 = 1;
        r10 = true;
    L25:
        if (r12 != ']') goto L29;
        if (r10 == false) goto L29;
        r6.append(r12);
        r10 = r3;
    L29:
        if (r10 == false) goto L43;
        if (r12 == 'h') goto L42;
        if (r12 == 'H') goto L42;
        if (r12 == 'm') goto L41;
        if (r12 == 'M') goto L41;
        if (r12 == 's') goto L40;
        if (r12 == 'S') goto L40;
    L39:
        r6.append(r12);
    L40:
        r6.append('s');
    L41:
        r6.append('m');
    L42:
        r6.append('H');
        goto L19
    L43:
        if (r12 == 'h') goto L78;
        if (r12 == 'H') goto L78;
        if (r12 == 'm') goto L76;
        if (r12 == 'M') goto L76;
        if (r12 == 's') goto L68;
        if (r12 == 'S') goto L68;
        if (Character.isLetter(r12) == false) goto L66;
        r8.clear();
        char r15 = 'y';
        if (r12 != 'y') goto L57;
    L64:
        r6.append(r15);
    L75:
        r14 = 1;
        r11 = true;
        goto L82
    L57:
        if (r12 == 'Y') goto L64;
        r15 = 'd';
        if (r12 == 'd') goto L64;
        if (r12 == 'D') goto L64;
        r6.append(r12);
        goto L75
    L66:
        if (Character.isWhitespace(r12) == false) goto L39;
        r8.clear();
    L68:
        r6.append('s');
        Iterator r16 = r8.iterator();
    L70:
        if (r16.hasNext() == false) goto L74;
        int r19 = ((Integer) ZeusTransformUtils.preCheckCast(r16.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r6.charAt(r19) != 'M') goto L70;
        r6.replace(r19, r19 + 1, "m");
        goto L70
    L74:
        r8.clear();
    L76:
        if (r11 == false) goto L41;
        r6.append('M');
        r8.add(Integer.valueOf(r6.length() - 1));
    L78:
        if (r5 == false) goto L80;
        r6.append('h');
    L81:
        r14 = 1;
        r11 = false;
        goto L82
    L80:
        r6.append('H');
        goto L81
    L83:
        String r20 = r6.toString();
        return new ExcelStyleDateFormatter(r20, this.dateSymbols);
    L86:
        e = move-exception;
        LOG.atDebug().a(e).a("Formatting failed for format {}, falling back", r20);
        return getDefaultFormat(r18);
    }

    private Format createFormat(double r9, int r11, String r12) {
        checkForLocaleChange();
        int r1 = 0;
        if (r12 == null) goto L15;
        Matcher r2 = colorPattern.matcher(r12);
    L6:
        if (r2.find() == false) goto L15;
        String r3 = r2.group();
        int r4 = r12.indexOf(r3);
        if (r4 == (-1)) goto L15;
        String r5 = r12.substring(0, r4) + r12.substring(r4 + r3.length());
        if (r5.equals(r12) == true) goto L15;
        r2 = colorPattern.matcher(r5);
        r12 = r5;
    L15:
        if (r12 == null) goto L23;
    L16:
        Matcher r6 = localePatternGroup.matcher(r12);
        if (r6.find() == false) goto L23;
        String r13 = r6.group();
        String r14 = r13.substring(r13.indexOf(36) + 1, r13.indexOf(45));
        if (r14.indexOf(36) <= (-1)) goto L21;
        r14 = r14.substring(0, r14.indexOf(36)) + '\\' + r14.substring(r14.indexOf(36));
    L21:
        r12 = r6.replaceAll(r14);
    L23:
        if (StringUtil.isBlank(r12) == false) goto L27;
        return getDefaultFormat(r9);
    L27:
        if ("General".equalsIgnoreCase(r12) == true) goto L66;
        if ("@".equals(r12) == true) goto L66;
        if (DateUtil.isADateFormat(r11, r12) == false) goto L38;
        if (DateUtil.isValidExcelDate(r9) == false) goto L38;
        return createDateFormat(r12, r9);
    L38:
        if (r12.contains("#/") == false) goto L40;
    L52:
        String[] r8 = r12.split(";");
        int r10 = r8.length;
    L53:
        String r15 = "#";
        if (r1 >= r10) goto L64;
        Matcher r16 = fractionPattern.matcher(fractionStripper.matcher(r8[r1].replace("?", "#")).replaceAll(" ").replaceAll(" +", " "));
        if (r16.find() == true) goto L58;
        r1 = r1 + 1;
        goto L53
    L58:
        if (r16.group(1) != null) goto L61;
        r15 = "";
    L61:
        return new FractionFormat(r15, r16.group(3));
    L64:
        return new FractionFormat("#", "#/##");
    L40:
        if (r12.contains("?/") == true) goto L52;
        if (numPattern.matcher(r12).find() == false) goto L47;
        return createNumberFormat(r12, r9);
    L47:
        if (this.emulateCSV == true) goto L49;
        return null;
    L49:
        return new ConstantStringFormat(cleanFormatForNumber(r12));
    L66:
        return this.generalNumberFormat;
    }

    private static DecimalFormat createIntegerOnlyFormat(String r2) {
        DecimalFormat r1 = new DecimalFormat(r2, DecimalFormatSymbols.getInstance(Locale.ROOT));
        r1.setParseIntegerOnly(true);
        return r1;
    }

    private Format createNumberFormat(String r7, double r8) {
        String r0 = cleanFormatForNumber(r7);
        DecimalFormatSymbols r1 = this.decimalSymbols;
        Matcher r2 = alternateGrouping.matcher(r0);
        if (r2.find() == false) goto L12;
        char r3 = r2.group(2).charAt(0);
        if (r3 == ',') goto L12;
        r1 = DecimalFormatSymbols.getInstance(this.locale);
        r1.setGroupingSeparator(r3);
        String r4 = r2.group(1);
        r0 = r0.replace(r4, r4.replace(r3, ','));
    L12:
        return new InternalDecimalFormatWithScale(r0, r1);
    L9:
        e = move-exception;
        LOG.atDebug().a(e).a("Formatting failed for format {}, falling back", r7);
        return getDefaultFormat(r8);
    }

    private Format getDefaultFormat(double r1) {
        checkForLocaleChange();
        Format r2 = this.defaultNumFormat;
        if (r2 == null) goto L6;
        return r2;
    L6:
        return this.generalNumberFormat;
    }

    private Format getFormat(double r5, int r7, String r8, boolean r9) {
        checkForLocaleChange();
        String r10 = r8.replace("\\%", "'%'");
        if (r10.contains(";") == false) goto L19;
        if (r10.indexOf(59) == r10.lastIndexOf(59)) goto L7;
    L39:
        CellFormat r0 = CellFormat.getInstance(this.locale, r10);     // Catch: Exception -> L16
        if (r5 != 0.0d) goto L11;
    L13:
        Object r11 = Double.valueOf(r5);     // Catch: Exception -> L16
    L14:
        return new CellFormatResultWrapper(this, r0.apply(r11), null);
    L11:
        if (DateUtil.isADateFormat(r7, r10) == false) goto L13;
        r11 = DateUtil.getJavaDate(r5, r9);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        LOG.atWarn().a(e).a("Formatting failed for format {}, falling back", r10);
        goto L19
    L7:
        if (rangeConditionalPattern.matcher(r10).matches() == true) goto L39;
    L19:
        if (this.emulateCSV == true) goto L21;
    L27:
        Format r12 = (Format) ZeusTransformUtils.preCheckCast(this.formats.get(r10), Format.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L31;
        return r12;
    L31:
        if ("General".equalsIgnoreCase(r10) == true) goto L38;
        if ("@".equals(r10) == true) goto L38;
        Format r6 = createFormat(r5, r7, r10);
        this.formats.put(r10, r6);
        return r6;
    L38:
        return this.generalNumberFormat;
    L21:
        if (r5 != 0.0d) goto L27;
        if (r10.contains("#") == false) goto L27;
        if (r10.contains("0") == true) goto L27;
        r10 = r10.replace("#", "");
        goto L27
    }

    private Format getFormat(Cell r8, ConditionalFormattingEvaluator r9) {
        Cell r10 = (Cell) ZeusTransformUtils.wrapperContextForParams(r8, Cell.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L5;
        return null;
    L5:
        ExcelNumberFormat r11 = ExcelNumberFormat.from(r10, r9);
        if (r11 != null) goto L8;
        return null;
    L8:
        int r4 = r11.getIdx();
        String r5 = r11.getFormat();
        if (StringUtil.isBlank(r5) == false) goto L12;
        return null;
    L12:
        return getFormat(r10.getNumericCellValue(), r4, r5, isDate1904(r10));
    }

    private String getFormattedDateString(Cell r4, ConditionalFormattingEvaluator r5) {
        Cell r6 = (Cell) ZeusTransformUtils.wrapperContextForParams(r4, Cell.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return null;
    L6:
        Format r7 = getFormat(r6, r5);
        if (r7 == null) goto L9;
    L12:
        monitor-enter(r7);
    L19:
        th = move-exception;
        throw th;
    L14:
        if (ZeusTransformUtils.instanceOf(r7, ExcelStyleDateFormatter.class) == false) goto L16;
        ((ExcelStyleDateFormatter) ZeusTransformUtils.preCheckCast(r7, ExcelStyleDateFormatter.class, "com.obric.memorydata.plugin")).setDateToBeFormatted(r6.getNumericCellValue());     // Catch: Throwable -> L19
    L16:
        String r3 = performDateFormatting(r6.getDateCellValue(), r7);     // Catch: Throwable -> L19
        monitor-exit(r7);     // Catch: Throwable -> L19
        return r3;
    L9:
        if (this.defaultDateformat != null) goto L11;
        SimpleDateFormat r0 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", DateFormatSymbols.getInstance(LocaleUtil.getUserLocale()));
        r0.setTimeZone(LocaleUtil.getUserTimeZone());
        r7 = r0;
        goto L12
    L11:
        r7 = this.defaultNumFormat;
        goto L12
    }

    private String getFormattedNumberString(Cell r3, ConditionalFormattingEvaluator r4) {
        Cell r5 = (Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return null;
    L6:
        Format r2 = getFormat(r5, r4);
        double r6 = r5.getNumericCellValue();
        if (r2 == null) goto L9;
        String r7 = r2.format(BigDecimal.valueOf(r6));     // Catch: NumberFormatException -> L12
    L14:
        return r7.replaceFirst("E(\\d)", "E+$1");
    L12:
        r7 = r2.format(Double.valueOf(r6));
        goto L14
    L9:
        return Double.toString(r6);
    }

    private boolean isDate1904(Cell r3) {
        Cell r2 = (Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r2.getSheet().getWorkbook(), Date1904Support.class) == true) goto L7;
        return false;
    L7:
        return ((Date1904Support) ZeusTransformUtils.preCheckCast(r2.getSheet().getWorkbook(), Date1904Support.class, "com.obric.memorydata.plugin")).isDate1904();
    }

    private String performDateFormatting(Date r1, Format r2) {
        if (r2 != null) goto L5;
        r2 = this.defaultDateformat;
    L5:
        monitor-enter(r2);
        String r0 = r2.format(r1);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public static void setExcelStyleRoundingMode(DecimalFormat r1) {
        setExcelStyleRoundingMode(r1, RoundingMode.HALF_UP);
    }

    public static void setExcelStyleRoundingMode(DecimalFormat r0, RoundingMode r1) {
        r0.setRoundingMode(r1);
    }

    public void addFormat(String r1, Format r2) {
        this.formats.put(r1, r2);
    }

    String adjustTo4DigitYearsIfConfigured(String r6) {
        if (this.use4DigitYearsInAllDateFormats == false) goto L15;
        String r0 = "yy";
        int r1 = r6.indexOf("yy");
        if (r1 >= 0) goto L7;
        return r6;
    L7:
        int r2 = r6.indexOf("yyy");
        if (r6.indexOf("yyyy") != r1) goto L12;
        int r3 = r1 + 4;
        r0 = r6.substring(0, r3);
        String r7 = r6.substring(r3);
        StringBuilder r4 = new StringBuilder();
    L11:
        return r4.append(r0).append(adjustTo4DigitYearsIfConfigured(r7)).toString();
    L12:
        if (r2 != r1) goto L14;
        return r6;
    L14:
        int r5 = r1 + 2;
        String r8 = r6.substring(0, r5);
        r7 = r6.substring(r5);
        r4 = new StringBuilder().append(r8);
        goto L11
    L15:
        return r6;
    }

    public String formatCellValue(Cell r3) {
        return formatCellValue((Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin"), null);
    }

    public String formatCellValue(Cell r3, FormulaEvaluator r4) {
        return formatCellValue((Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin"), (FormulaEvaluator) ZeusTransformUtils.wrapperContextForParams(r4, FormulaEvaluator.class, "com.obric.memorydata.plugin"), null);
    }

    public String formatCellValue(Cell r4, FormulaEvaluator r5, ConditionalFormattingEvaluator r6) {
        Cell r7 = (Cell) ZeusTransformUtils.wrapperContextForParams(r4, Cell.class, "com.obric.memorydata.plugin");
        FormulaEvaluator r8 = (FormulaEvaluator) ZeusTransformUtils.wrapperContextForParams(r5, FormulaEvaluator.class, "com.obric.memorydata.plugin");
        checkForLocaleChange();
        if (r7 != null) goto L5;
        return "";
    L5:
        CellType r1 = r7.getCellType();
        if (r1 != CellType.FORMULA) goto L17;
        if (r8 == null) goto L9;
        r1 = r8.evaluateFormulaCell(r7);
        goto L17
    L9:
        if (this.useCachedValuesForFormulaCells == false) goto L15;
        r1 = r7.getCachedFormulaResultType();     // Catch: Exception -> L12
    L13:
        return r7.getCellFormula();
    L15:
        return r7.getCellFormula();
    L17:
        int r9 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r1.ordinal()];
        if (r9 == 1) goto L40;
        if (r9 == 2) goto L38;
        if (r9 == 3) goto L33;
        if (r9 != 4) goto L26;
        return "";
    L26:
        if (r9 != 5) goto L30;
        return FormulaError.forInt(r7.getErrorCellValue()).getString();
    L30:
        throw new RuntimeException("Unexpected celltype (" + r1 + ")");
    L33:
        if (r7.getBooleanCellValue() == false) goto L35;
        return "TRUE";
    L35:
        return "FALSE";
    L38:
        return r7.getRichStringCellValue().getString();
    L40:
        if (DateUtil.isCellDateFormatted(r7, r6) == false) goto L44;
        return getFormattedDateString(r7, r6);
    L44:
        return getFormattedNumberString(r7, r6);
    }

    public String formatRawCellContents(double r7, int r9, String r10) {
        return formatRawCellContents(r7, r9, r10, false);
    }

    public String formatRawCellContents(double r2, int r4, String r5, boolean r6) {
        checkForLocaleChange();
        if (DateUtil.isADateFormat(r4, r5) == true) goto L5;
    L15:
        Format r1 = getFormat(r2, r4, r5, r6);
        if (r1 == null) goto L18;
        String r7 = NumberToTextConverter.toText(r2);
        if (r7.indexOf(69) <= (-1)) goto L22;
        Object r3 = Double.valueOf(r2);
    L23:
        String r8 = r1.format(r3);
        String r9 = r5.toLowerCase(Locale.ROOT);
        if (r9.contains(SlardarSettingsConstants.SETTING_GENERAL) == true) goto L28;
        if (r9.contains("e+0") == true) goto L28;
        return r8;
    L28:
        if (r8.contains(ExifInterface.LONGITUDE_EAST) == true) goto L30;
        return r8;
    L30:
        if (r8.contains("E-") == false) goto L32;
        return r8;
    L32:
        return r8.replaceFirst(ExifInterface.LONGITUDE_EAST, "E+");
    L22:
        r3 = new BigDecimal(r7);
        goto L23
    L18:
        return String.valueOf(r2);
    L5:
        if (DateUtil.isValidExcelDate(r2) == false) goto L12;
        Format r10 = getFormat(r2, r4, r5, r6);
        if (ZeusTransformUtils.instanceOf(r10, ExcelStyleDateFormatter.class) == false) goto L10;
        ((ExcelStyleDateFormatter) ZeusTransformUtils.preCheckCast(r10, ExcelStyleDateFormatter.class, "com.obric.memorydata.plugin")).setDateToBeFormatted(r2);
    L10:
        return performDateFormatting(DateUtil.getJavaDate(r2, r6), r10);
    L12:
        if (this.emulateCSV == false) goto L15;
        return invalidDateTimeString;
    }

    public void updateLocale(Locale r3) {
        if (this.localeIsAdapting == true) goto L5;
        return;
    L5:
        if (r3.equals(this.locale) == true) goto L10;
        this.locale = r3;
        this.dateSymbols = DateFormatSymbols.getInstance(r3);
        this.decimalSymbols = DecimalFormatSymbols.getInstance(this.locale);
        this.generalNumberFormat = new ExcelGeneralNumberFormat(this.locale);
        SimpleDateFormat r4 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", this.dateSymbols);
        this.defaultDateformat = r4;
        r4.setTimeZone(LocaleUtil.getUserTimeZone());
        this.formats.clear();
        Format r5 = ZipPlusFourFormat.instance;
        addFormat("00000\\-0000", r5);
        addFormat("00000-0000", r5);
        Format r6 = PhoneFormat.instance;
        addFormat("[<=9999999]###\\-####;\\(###\\)\\ ###\\-####", r6);
        addFormat("[<=9999999]###-####;(###) ###-####", r6);
        addFormat("###\\-####;\\(###\\)\\ ###\\-####", r6);
        addFormat("###-####;(###) ###-####", r6);
        Format r7 = SSNFormat.instance;
        addFormat("000\\-00\\-0000", r7);
        addFormat("000-00-0000", r7);
        return;
    }
}
