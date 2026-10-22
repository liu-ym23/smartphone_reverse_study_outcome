package com.alibaba.excel.metadata.format;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.excel.i.e;
import com.tom_roush.pdfbox.pdmodel.a.c.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.format.CellFormatResult;
import org.apache.poi.ss.usermodel.ExcelStyleDateFormatter;
import org.apache.poi.ss.usermodel.FractionFormat;
import org.slf4j.c;
import org.slf4j.d;

/* JADX INFO: loaded from: classes.dex */
public class DataFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f288a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f289b = null;
    private static final Pattern c = null;
    private static final Pattern d = null;
    private static final Pattern e = null;
    private static final Pattern f = null;
    private static final Pattern g = null;
    private static final Pattern h = null;
    private static final Pattern i = null;
    private static final Pattern j = null;
    private static final Pattern k = null;
    private static final String l = null;
    private DecimalFormatSymbols m;
    private DateFormatSymbols n;
    private Format o;
    private final Map<String, Format> p;
    private Locale q;
    private Boolean r;
    private Boolean s;

    /* JADX INFO: renamed from: com.alibaba.excel.metadata.format.DataFormatter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
            return r2.append(this.result.text.trim());
        }

        @Override // java.text.Format
        public Object parseObject(String r1, ParsePosition r2) {
            return null;
        }
    }

    private static class InternalDecimalFormatWithScale extends Format {
        private static final BigDecimal ONE_THOUSAND = null;
        private static final Pattern endsWithCommas = null;
        private final DecimalFormat df;
        private BigDecimal divider;

        static {
            endsWithCommas = Pattern.compile("(,+)$");
            ONE_THOUSAND = new BigDecimal(1000);
        }

        public InternalDecimalFormatWithScale(String r3, DecimalFormatSymbols r4) {
            DecimalFormat r0 = new DecimalFormat(trimTrailingCommas(r3), r4);
            this.df = r0;
            DataFormatter.a(r0);
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

        static {
            df = DataFormatter.a("##########");
        }

        private PhoneFormat() {
        }

        /* synthetic */ PhoneFormat(AnonymousClass1 r1) {
            this();
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
            if (r9.trim().length() <= 0) goto L9;
            r0.append('(').append(r9).append(") ");
        L9:
            if (r5.trim().length() <= 0) goto L11;
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

        static {
            df = DataFormatter.a("000000000");
        }

        private SSNFormat() {
        }

        /* synthetic */ SSNFormat(AnonymousClass1 r1) {
            this();
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

        static {
            df = DataFormatter.a("000000000");
        }

        private ZipPlusFourFormat() {
        }

        /* synthetic */ ZipPlusFourFormat(AnonymousClass1 r1) {
            this();
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
        f288a = d.a(DataFormatter.class);
        f289b = Pattern.compile("[0#]+");
        c = Pattern.compile("([d]{3,})", 2);
        d = Pattern.compile("(([AP])[M/P]*)|(([上下])[午/下]*)", 2);
        e = Pattern.compile(".*\\[\\s*(>|>=|<|<=|=)\\s*[0-9]*\\.*[0-9].*");
        f = Pattern.compile("(\\[\\$[^-\\]]*-[0-9A-Z]+])");
        g = Pattern.compile("(\\[BLACK])|(\\[BLUE])|(\\[CYAN])|(\\[GREEN])|(\\[MAGENTA])|(\\[RED])|(\\[WHITE])|(\\[YELLOW])|(\\[COLOR\\s*\\d])|(\\[COLOR\\s*[0-5]\\d])|(\\[DBNum(1|2|3)])|(\\[\\$-\\d{0,3}])", 2);
        h = Pattern.compile("(?:([#\\d]+)\\s+)?(#+)\\s*/\\s*([#\\d]+)");
        i = Pattern.compile("(\"[^\"]*\")|([^ ?#\\d/]+)");
        j = Pattern.compile("([#0]([^.#0])[#0]{3})");
        k = Pattern.compile("E(\\d)");
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= 255) goto L6;
        r0.append('#');
        r1 = r1 + 1;
        goto L4
    L6:
        l = r0.toString();
    }

    public DataFormatter(Boolean r2, Locale r3, Boolean r4) {
        this.p = new HashMap();
        if (r2 != null) goto L5;
        this.r = Boolean.FALSE;
    L6:
        if (r3 != null) goto L8;
        r3 = Locale.getDefault();
    L8:
        this.q = r3;
        if (r2 != null) goto L11;
        this.s = Boolean.FALSE;
    L12:
        this.n = DateFormatSymbols.getInstance(this.q);
        this.m = DecimalFormatSymbols.getInstance(this.q);
        return;
    L11:
        this.s = r4;
        goto L12
    L5:
        this.r = r2;
        goto L6
    }

    private String a(Date r1, Format r2) {
        if (r2 != null) goto L6;
        r2 = a();
    L6:
        return r2.format(r1);
    }

    static /* synthetic */ DecimalFormat a(String r0) {
        return f(r0);
    }

    private Format a() {
        Format r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ExcelGeneralNumberFormat r1 = new ExcelGeneralNumberFormat(this.q, this.s.booleanValue());
        this.o = r1;
        return r1;
    }

    private Format a(Double r6, Short r7, String r8) {
        if (r8.contains(";") == true) goto L5;
    L17:
        Format r9 = (Format) ZeusTransformUtils.preCheckCast(this.p.get(r8), Format.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L21;
        return r9;
    L21:
        if ("General".equalsIgnoreCase(r8) == false) goto L23;
    L28:
        Format r10 = a();
    L26:
        a(r8, r10);
        return r10;
    L23:
        if ("@".equals(r8) == true) goto L28;
        r10 = a(r7, r8);
        goto L26
    L5:
        if (r8.indexOf(59) == r8.lastIndexOf(59)) goto L7;
    L29:
        CellFormat r0 = CellFormat.getInstance(this.q, r8);     // Catch: Exception -> L15
        Object r11 = r6;
        if (e.a(r7, r8) == false) goto L13;
        double r1 = r6.doubleValue();     // Catch: Exception -> L15
        r11 = r6;
        if (r1 == 0.0d) goto L13;
        r11 = e.a(r6.doubleValue(), this.r.booleanValue());     // Catch: Exception -> L15
    L13:
        return new CellFormatResultWrapper(this, r0.apply(r11), null);
    L15:
        e = move-exception;
        f288a.warn("Formatting failed for format {}, falling back", r8, e);
        goto L17
    L7:
        if (e.matcher(r8).matches() == false) goto L17;
        goto L17
    }

    private Format a(Short r8, String r9) {
        Format r0 = b(r9);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Matcher r1 = g.matcher(r9);
        String r10 = r9;
    L6:
        int r3 = 0;
        if (r1.find() == false) goto L15;
        String r2 = r1.group();
        int r4 = r10.indexOf(r2);
        if (r4 == (-1)) goto L15;
        String r5 = r10.substring(0, r4) + r10.substring(r4 + r2.length());
        if (r5.equals(r10) == true) goto L15;
        r1 = g.matcher(r5);
        r10 = r5;
    L15:
        Matcher r6 = f.matcher(r10);
        if (r6.find() == false) goto L21;
        String r11 = r6.group();
        String r12 = r11.substring(r11.indexOf(36) + 1, r11.indexOf(45));
        if (r12.indexOf(36) <= (-1)) goto L20;
        r12 = r12.substring(0, r12.indexOf(36)) + '\\' + r12.substring(r12.indexOf(36));
    L20:
        r10 = r6.replaceAll(r12);
        goto L15
    L21:
        if (r10 == null) goto L61;
        if (r10.trim().length() == 0) goto L61;
        if ("General".equalsIgnoreCase(r10) == true) goto L59;
        if ("@".equals(r10) == true) goto L59;
        if (e.a(r8, r10) == false) goto L35;
        return c(r10);
    L35:
        if (r10.contains("#/") == false) goto L37;
    L45:
        String[] r7 = r10.split(";");
        int r13 = r7.length;
    L46:
        String r14 = "#";
        if (r3 >= r13) goto L57;
        Matcher r15 = h.matcher(i.matcher(r7[r3].replaceAll("\\?", "#")).replaceAll(" ").replaceAll(" +", " "));
        if (r15.find() == true) goto L51;
        r3 = r3 + 1;
        goto L46
    L51:
        if (r15.group(1) != null) goto L54;
        r14 = "";
    L54:
        return new FractionFormat(r14, r15.group(3));
    L57:
        return new FractionFormat("#", "#/##");
    L37:
        if (r10.contains("?/") == true) goto L45;
        if (f289b.matcher(r10).find() == false) goto L44;
        return e(r10);
    L44:
        return a();
    L59:
        return a();
    L61:
        return a();
    }

    public static void a(DecimalFormat r1) {
        a(r1, RoundingMode.HALF_UP);
    }

    public static void a(DecimalFormat r0, RoundingMode r1) {
        r0.setRoundingMode(r1);
    }

    private String b(Double r3, Short r4, String r5) {
        Format r6 = a(r3, r4, r5);
        if (ZeusTransformUtils.instanceOf(r6, ExcelStyleDateFormatter.class) == false) goto L6;
        ((ExcelStyleDateFormatter) ZeusTransformUtils.preCheckCast(r6, ExcelStyleDateFormatter.class, "com.obric.memorydata.plugin")).setDateToBeFormatted(r3.doubleValue());
    L6:
        return a(e.a(r3.doubleValue(), this.r.booleanValue()), r6);
    }

    private String b(BigDecimal r3, Short r4, String r5) {
        Format r2 = a(Double.valueOf(r3.doubleValue()), r4, r5);
        return k.matcher(r2.format(r3)).replaceFirst("E+$1");
    }

    private Format b(String r2) {
        AnonymousClass1 r0 = null;
        if ("00000\\-0000".equals(r2) == true) goto L27;
        if ("00000-0000".equals(r2) == true) goto L27;
        if ("[<=9999999]###\\-####;\\(###\\)\\ ###\\-####".equals(r2) == true) goto L25;
        if ("[<=9999999]###-####;(###) ###-####".equals(r2) == true) goto L25;
        if ("###\\-####;\\(###\\)\\ ###\\-####".equals(r2) == true) goto L25;
        if ("###-####;(###) ###-####".equals(r2) == true) goto L25;
        if ("000\\-00\\-0000".equals(r2) == true) goto L23;
        if ("000-00-0000".equals(r2) == true) goto L23;
        return null;
    L23:
        return new SSNFormat(r0);
    L25:
        return new PhoneFormat(r0);
    L27:
        return new ZipPlusFourFormat(r0);
    }

    private Format c(String r17) {
        String r0 = r17.replaceAll("\\\\-", "-").replaceAll("\\\\,", ",").replaceAll("\\\\\\.", ".").replaceAll("\\\\ ", " ").replaceAll("\\\\/", "/").replaceAll(";@", "").replaceAll("\"/\"", "/").replace("\"\"", "'").replaceAll("\\\\T", "'T'").replace("\"", "");
        Matcher r1 = d.matcher(r0);
        boolean r4 = false;
    L4:
        if (r1.find() == false) goto L6;
        r0 = r1.replaceAll("@");
        r1 = d.matcher(r0);
        r4 = true;
        goto L4
    L6:
        String r2 = r0.replaceAll("@", "a");
        Matcher r3 = c.matcher(r2);
        if (r3.find() == false) goto L9;
        r2 = r3.replaceAll(r3.group(0).toUpperCase(Locale.ROOT).replaceAll(a.f16161b, ExifInterface.LONGITUDE_EAST));
    L9:
        StringBuilder r5 = new StringBuilder();
        char[] r6 = r2.toCharArray();
        ArrayList r7 = new ArrayList();
        int r8 = 0;
        boolean r9 = false;
        boolean r10 = true;
    L11:
        if (r8 >= r6.length) goto L84;
        char r11 = r6[r8];
        if (r11 != '\'') goto L21;
        r5.append(r11);
    L15:
        r8 = r8 + 1;
        if (r8 >= r6.length) goto L83;
        char r12 = r6[r8];
        r5.append(r12);
        if (r12 != '\'') goto L15;
    L83:
        r8 = r8 + 1;
        goto L11
    L21:
        if (r11 != '[') goto L25;
        if (r9 == true) goto L25;
        r5.append(r11);
        r10 = false;
        r9 = true;
    L25:
        if (r11 != ']') goto L29;
        if (r9 == false) goto L29;
        r5.append(r11);
        r9 = false;
    L29:
        if (r9 == false) goto L43;
        if (r11 == 'h') goto L42;
        if (r11 == 'H') goto L42;
        if (r11 == 'm') goto L41;
        if (r11 == 'M') goto L41;
        if (r11 == 's') goto L40;
        if (r11 == 'S') goto L40;
    L39:
        r5.append(r11);
    L40:
        r5.append('s');
    L41:
        r5.append('m');
    L42:
        r5.append('H');
        goto L83
    L43:
        if (r11 == 'h') goto L79;
        if (r11 == 'H') goto L79;
        if (r11 == 'm') goto L77;
        if (r11 == 'M') goto L77;
        if (r11 == 's') goto L69;
        if (r11 == 'S') goto L69;
        if (Character.isLetter(r11) == false) goto L67;
        r7.clear();
        char r13 = 'y';
        if (r11 != 'y') goto L57;
    L65:
        r5.append(r13);
    L76:
        r10 = true;
        goto L83
    L57:
        if (r11 == 'Y') goto L65;
        r13 = 'd';
        if (r11 == 'd') goto L65;
        if (r11 == 'D') goto L65;
        r5.append(r11);
        goto L76
    L67:
        if (Character.isWhitespace(r11) == false) goto L39;
        r7.clear();
    L69:
        r5.append('s');
        Iterator r14 = r7.iterator();
    L71:
        if (r14.hasNext() == false) goto L75;
        int r15 = ((Integer) ZeusTransformUtils.preCheckCast(r14.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r5.charAt(r15) != 'M') goto L71;
        r5.replace(r15, r15 + 1, "m");
        goto L71
    L75:
        r7.clear();
    L77:
        if (r10 == false) goto L41;
        r5.append('M');
        r7.add(Integer.valueOf(r5.length() - 1));
    L79:
        if (r4 == false) goto L81;
        r5.append('h');
    L82:
        r10 = false;
        goto L83
    L81:
        r5.append('H');
        goto L82
    L84:
        String r16 = r5.toString();
        return new ExcelStyleDateFormatter(r16, this.n);
    L89:
        e = e;
    L93:
        f288a.debug("Formatting failed for format {}, falling back", r16, e);
        return a();
    L91:
        e = e;
        goto L93
    }

    private String d(String r5) {
        StringBuilder r4 = new StringBuilder(r5);
        int r6 = 0;
        int r0 = 0;
    L4:
        if (r0 >= r4.length()) goto L19;
        char r1 = r4.charAt(r0);
        if (r1 != '_') goto L8;
    L9:
        if (r0 <= 0) goto L14;
        if (r4.charAt(r0 - 1) != '\\') goto L14;
    L17:
        r0 = r0 + 1;
    L14:
        if (r0 >= (r4.length() - 1)) goto L16;
        r4.deleteCharAt(r0 + 1);
    L16:
        r4.deleteCharAt(r0);
        r0 = r0 - 1;
        goto L17
    L8:
        if (r1 != '*') goto L17;
    L19:
        if (r6 >= r4.length()) goto L33;
        char r2 = r4.charAt(r6);
        if (r2 != '\\') goto L23;
    L30:
        r4.deleteCharAt(r6);
        r6 = r6 - 1;
    L31:
        r6 = r6 + 1;
        goto L19
    L23:
        if (r2 == '\"') goto L30;
        if (r2 != '+') goto L31;
        if (r6 <= 0) goto L31;
        if (r4.charAt(r6 - 1) != 'E') goto L31;
    L33:
        return r4.toString();
    }

    private Format e(String r7) {
        String r0 = d(r7);
        DecimalFormatSymbols r1 = this.m;
        Matcher r2 = j.matcher(r0);
        if (r2.find() == false) goto L12;
        char r3 = r2.group(2).charAt(0);
        if (r3 == ',') goto L12;
        r1 = DecimalFormatSymbols.getInstance(this.q);
        r1.setGroupingSeparator(r3);
        String r4 = r2.group(1);
        r0 = r0.replace(r4, r4.replace(r3, ','));
    L12:
        return new InternalDecimalFormatWithScale(r0, r1);
    L9:
        e = move-exception;
        f288a.error("Formatting failed for format {}, falling back", r7, e);
        return a();
    }

    private static DecimalFormat f(String r2) {
        DecimalFormat r1 = new DecimalFormat(r2, DecimalFormatSymbols.getInstance(Locale.ROOT));
        r1.setParseIntegerOnly(true);
        return r1;
    }

    public String a(BigDecimal r3, Short r4, String r5) {
        if (e.a(r4, r5) == false) goto L7;
        return b(Double.valueOf(r3.doubleValue()), r4, r5);
    L7:
        return b(r3, r4, r5);
    }

    public void a(String r1, Format r2) {
        this.p.put(r1, r2);
    }
}
