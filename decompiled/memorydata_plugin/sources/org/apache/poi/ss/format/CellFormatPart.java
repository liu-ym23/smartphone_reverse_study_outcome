package org.apache.poi.ss.format;

import com.loc.o;
import com.tom_roush.pdfbox.pdmodel.a.c.a;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.util.CodepointsUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class CellFormatPart {
    public static final int COLOR_GROUP = 0;
    public static final Pattern COLOR_PAT = null;
    public static final int CONDITION_OPERATOR_GROUP = 0;
    public static final Pattern CONDITION_PAT = null;
    public static final int CONDITION_VALUE_GROUP = 0;
    public static final Pattern CURRENCY_PAT = null;
    public static final Pattern FORMAT_PAT = null;
    private static final c LOG = null;
    static final Map<String, Color> NAMED_COLORS = null;
    public static final int SPECIFICATION_GROUP = 0;
    public static final Pattern SPECIFICATION_PAT = null;
    private final Color color;
    private final CellFormatCondition condition;
    private final CellFormatter format;
    private final CellFormatType type;

    interface PartHandler {
        String handlePart(Matcher r1, String r2, CellFormatType r3, StringBuffer r4);
    }

    static {
        LOG = b.a(CellFormatPart.class);
        NAMED_COLORS = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        HSSFColor.HSSFColorPredefined[] r0 = HSSFColor.HSSFColorPredefined.values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        HSSFColor.HSSFColorPredefined r4 = r0[r3];
        String r5 = r4.name();
        short[] r6 = r4.getTriplet();
        Color r7 = new Color(r6[0], r6[1], r6[2]);
        Map<String, Color> r8 = NAMED_COLORS;
        r8.put(r5, r7);
        if (r5.indexOf(95) <= 0) goto L8;
        r8.put(r5.replace('_', ' '), r7);
    L8:
        if (r5.indexOf("_PERCENT") <= 0) goto L10;
        r8.put(r5.replace("_PERCENT", "%").replace('_', ' '), r7);
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        String r9 = "\\\\.                     # Quoted single character\n|\"([^\\\\\"]|\\\\.)*\"         # Quoted string of characters (handles escaped quotes like \\\") \n|(\\[\\$.{0,3}(-[0-9a-f]{3,4})?])                   # Currency symbol in a given locale\n|_.                             # Space as wide as a given character\n|\\*.                           # Repeating fill character\n|@                              # Text: cell text\n|([0?\\#][0?\\#,]*)             # Number: digit + other digits and commas\n|e[-+]                          # Number: Scientific: Exponent\n|m{1,5}                         # Date: month or minute spec\n|d{1,4}                         # Date: day/date spec\n|y{2,4}                         # Date: year spec\n|h{1,2}                         # Date: hour spec\n|s{1,2}                         # Date: second spec\n|am?/pm?                        # Date: am/pm spec\n|\\[h{1,2}]                     # Elapsed time: hour spec\n|\\[m{1,2}]                     # Elapsed time: minute spec\n|\\[s{1,2}]                     # Elapsed time: second spec\n|[^;]                           # A character\n";
        COLOR_PAT = Pattern.compile("\\[(black|blue|cyan|green|magenta|red|white|yellow|color [0-9]+)]", 6);
        CONDITION_PAT = Pattern.compile("([<>=]=?|!=|<>)    # The operator\n  \\s*(-?([0-9]+(?:\\.[0-9]*)?)|(\\.[0-9]*))\\s*  # The constant to test against\n", 6);
        SPECIFICATION_PAT = Pattern.compile(r9, 6);
        CURRENCY_PAT = Pattern.compile("(\\[\\$.{0,3}(-[0-9a-f]{3,4})?])", 6);
        Pattern r2 = Pattern.compile("(?:\\[(black|blue|cyan|green|magenta|red|white|yellow|color [0-9]+)])?                 # Text color\n(?:\\[([<>=]=?|!=|<>)    # The operator\n  \\s*(-?([0-9]+(?:\\.[0-9]*)?)|(\\.[0-9]*))\\s*  # The constant to test against\n])?               # Condition\n(?:\\[\\$-[0-9a-fA-F]+])?                # Optional locale id, ignored currently\n((?:" + r9 + ")+)                        # Format spec\n", 6);
        FORMAT_PAT = r2;
        COLOR_GROUP = findGroup(r2, "[Blue]@", "Blue");
        CONDITION_OPERATOR_GROUP = findGroup(r2, "[>=1]@", ">=");
        CONDITION_VALUE_GROUP = findGroup(r2, "[>=1]@", "1");
        SPECIFICATION_GROUP = findGroup(r2, "[Blue][>1]\\a ?", "\\a ?");
    }

    public CellFormatPart(String r2) {
        this(LocaleUtil.getUserLocale(), r2);
    }

    public CellFormatPart(Locale r3, String r4) {
        Matcher r0 = FORMAT_PAT.matcher(r4);
        if (r0.matches() == false) goto L7;
        this.color = getColor(r0);
        this.condition = getCondition(r0);
        this.type = getCellFormatType(r0);
        this.format = getFormatter(r3, r0);
        return;
    L7:
        throw new IllegalArgumentException("Unrecognized format: " + CellFormatter.quote(r4));
    }

    static String expandChar(String r2) {
        final ArrayList r0 = new ArrayList();
        CodepointsUtil.iteratorFor(r2).forEachRemaining(new $$Lambda$TVSypUoTQEoHmun5Sp_V0Q9Va4(r0));
        if (r0.size() < 2) goto L7;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r0.get(1), String.class, "com.obric.memorydata.plugin");
        return r3 + r3 + r3;
    L7:
        throw new IllegalArgumentException("Expected part string to have at least 2 chars");
    }

    private static int findGroup(Pattern r3, String r4, String r5) {
        Matcher r0 = r3.matcher(r4);
        if (r0.find() == false) goto L16;
        int r6 = 1;
    L6:
        if (r6 > r0.groupCount()) goto L14;
        String r1 = r0.group(r6);
        if (r1 == null) goto L12;
        if (r1.equals(r5) == false) goto L12;
        return r6;
    L12:
        r6 = r6 + 1;
        goto L6
    L14:
        throw new IllegalArgumentException("\"" + r5 + "\" not found in \"" + r3.pattern() + "\"");
    L16:
        throw new IllegalArgumentException("Pattern \"" + r3.pattern() + "\" doesn't match \"" + r4 + "\"");
    }

    private CellFormatType formatType(String r13) {
        String r12 = r13.trim();
        if (r12.isEmpty() == true) goto L112;
        if (r12.equalsIgnoreCase("General") == true) goto L112;
        Matcher r14 = SPECIFICATION_PAT.matcher(r12);
        boolean r1 = false;
        boolean r2 = false;
    L9:
        if (r14.find() == false) goto L103;
        String r3 = r14.group(0);
        Iterator<String> r4 = CodepointsUtil.iteratorFor(r3);
        if (r4.hasNext() == false) goto L9;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        String r7 = null;
        if (r4.hasNext() == false) goto L15;
        r7 = ((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);
    L15:
        r5.hashCode();
        byte r6 = -1;
        switch(r5.hashCode()) {
            case 35: goto L75;
            case 48: goto L71;
            case 63: goto L67;
            case 64: goto L63;
            case 68: goto L59;
            case 72: goto L55;
            case 77: goto L51;
            case 83: goto L47;
            case 89: goto L43;
            case 91: goto L39;
            case 100: goto L35;
            case 104: goto L31;
            case 109: goto L27;
            case 115: goto L23;
            case 121: goto L19;
            default: goto L78;
        };
    L78:
        switch(r6) {
            case 0: goto L102;
            case 1: goto L100;
            case 2: goto L102;
            case 3: goto L99;
            case 4: goto L97;
            case 5: goto L95;
            case 6: goto L95;
            case 7: goto L95;
            case 8: goto L97;
            case 9: goto L81;
            case 10: goto L97;
            case 11: goto L95;
            case 12: goto L95;
            case 13: goto L95;
            case 14: goto L97;
            default: goto L9;
        };
    L81:
        if (o.g.equals(r7) == true) goto L94;
        if ("m".equals(r7) == true) goto L94;
        if ("s".equals(r7) == true) goto L94;
        if ("$".equals(r7) == false) goto L92;
        return CellFormatType.NUMBER;
    L92:
        throw new IllegalArgumentException("Unsupported [] format block '" + r3 + "' in '" + r12 + "' with c2: " + r7);
    L94:
        return CellFormatType.ELAPSED;
    L95:
        r1 = true;
        goto L9
    L97:
        return CellFormatType.DATE;
    L99:
        return CellFormatType.TEXT;
    L100:
        r2 = true;
        goto L9
    L102:
        return CellFormatType.NUMBER;
    L19:
        if (r5.equals("y") == false) goto L78;
        r6 = 14;
        goto L78
    L23:
        if (r5.equals("s") == false) goto L78;
        r6 = 13;
        goto L78
    L27:
        if (r5.equals("m") == false) goto L78;
        r6 = 12;
        goto L78
    L31:
        if (r5.equals(o.g) == false) goto L78;
        r6 = 11;
        goto L78
    L35:
        if (r5.equals("d") == false) goto L78;
        r6 = 10;
        goto L78
    L39:
        if (r5.equals("[") == false) goto L78;
        r6 = 9;
        goto L78
    L43:
        if (r5.equals("Y") == false) goto L78;
        r6 = 8;
        goto L78
    L47:
        if (r5.equals("S") == false) goto L78;
        r6 = 7;
        goto L78
    L51:
        if (r5.equals("M") == false) goto L78;
        r6 = 6;
        goto L78
    L55:
        if (r5.equals(i.n) == false) goto L78;
        r6 = 5;
        goto L78
    L59:
        if (r5.equals(a.f16161b) == false) goto L78;
        r6 = 4;
        goto L78
    L63:
        if (r5.equals("@") == false) goto L78;
        r6 = 3;
        goto L78
    L67:
        if (r5.equals("?") == false) goto L78;
        r6 = 2;
        goto L78
    L71:
        if (r5.equals("0") == false) goto L78;
        r6 = 1;
        goto L78
    L75:
        if (r5.equals("#") == false) goto L78;
        r6 = 0;
        goto L78
    L103:
        if (r1 == true) goto L105;
        if (r2 == false) goto L110;
        return CellFormatType.NUMBER;
    L110:
        return CellFormatType.TEXT;
    L105:
        return CellFormatType.DATE;
    L112:
        return CellFormatType.GENERAL;
    }

    private CellFormatType getCellFormatType(Matcher r2) {
        return formatType(r2.group(SPECIFICATION_GROUP));
    }

    private static Color getColor(Matcher r4) {
        String r5 = r4.group(COLOR_GROUP);
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.length() == 0) goto L13;
        Color r0 = (Color) ZeusTransformUtils.preCheckCast(NAMED_COLORS.get(r5), Color.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        LOG.warn("Unknown color: " + CellFormatter.quote(r5));
    L10:
        return r0;
    L13:
        return null;
    }

    private CellFormatCondition getCondition(Matcher r2) {
        int r1 = CONDITION_OPERATOR_GROUP;
        String r0 = r2.group(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.length() != 0) goto L8;
        return null;
    L8:
        return CellFormatCondition.getInstance(r2.group(r1), r2.group(CONDITION_VALUE_GROUP));
    }

    private CellFormatter getFormatter(Locale r4, Matcher r5) {
        String r6 = r5.group(SPECIFICATION_GROUP);
        Matcher r0 = CURRENCY_PAT.matcher(r6);
        if (r0.find() == false) goto L14;
        String r1 = r0.group(1);
        if (r1.startsWith("[$-") == false) goto L8;
        String r2 = "$";
    L12:
        r6 = r6.replace(r1, r2);
        goto L14
    L8:
        if (r1.contains("-") == true) goto L10;
        int r3 = r1.indexOf("]");
    L11:
        r2 = r1.substring(2, r3);
        goto L12
    L10:
        r3 = r1.lastIndexOf(45);
    L14:
        return this.type.formatter(r4, r6);
    }

    public static String group(Matcher r0, int r1) {
        String r2 = r0.group(r1);
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    public static StringBuffer parseFormat(String r6, CellFormatType r7, PartHandler r8) {
        PartHandler r9 = (PartHandler) ZeusTransformUtils.wrapperContextForParams(r8, PartHandler.class, "com.obric.memorydata.plugin");
        Matcher r10 = SPECIFICATION_PAT.matcher(r6);
        StringBuffer r0 = new StringBuffer();
    L3:
        int r3 = 0;
        if (r10.find() == false) goto L25;
        String r2 = group(r10, 0);
        if (r2.length() <= 0) goto L3;
        String r5 = r9.handlePart(r10, r2, r7, r0);
        if (r5 != null) goto L23;
        char r4 = r2.charAt(0);
        if (r4 != '\"') goto L12;
        String r11 = r2.substring(1, r2.length() - 1);
    L22:
        r2 = quoteSpecial(r11, r7);
    L24:
        r10.appendReplacement(r0, Matcher.quoteReplacement(r2));
        goto L3
    L12:
        if (r4 != '*') goto L14;
        r2 = expandChar(r2);
        goto L24
    L14:
        if (r4 != '\\') goto L16;
        r11 = r2.substring(1);
        goto L22
    L16:
        if (r4 != '_') goto L24;
        r2 = " ";
        goto L24
    L23:
        r2 = r5;
        goto L24
    L25:
        r10.appendTail(r0);
        if (r7.isSpecial('\'') == false) goto L38;
        int r12 = 0;
    L28:
        r12 = r0.indexOf("''", r12);
        if (r12 < 0) goto L33;
        r0.delete(r12, r12 + 2);
        if (ZeusTransformUtils.instanceOf(r9, CellDateFormatter.DatePartHandler.class) == false) goto L28;
        ((CellDateFormatter.DatePartHandler) ZeusTransformUtils.preCheckCast(r9, CellDateFormatter.DatePartHandler.class, "com.obric.memorydata.plugin")).updatePositions(r12, -2);
    L33:
        r3 = r0.indexOf("\u0000", r3);
        if (r3 < 0) goto L38;
        r0.replace(r3, r3 + 1, "''");
        if (ZeusTransformUtils.instanceOf(r9, CellDateFormatter.DatePartHandler.class) == false) goto L33;
        ((CellDateFormatter.DatePartHandler) ZeusTransformUtils.preCheckCast(r9, CellDateFormatter.DatePartHandler.class, "com.obric.memorydata.plugin")).updatePositions(r3, 1);
    L38:
        return r0;
    }

    static String quoteSpecial(String r5, CellFormatType r6) {
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r7 = CodepointsUtil.iteratorFor(r5);
    L4:
        if (r7.hasNext() == false) goto L17;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if ("'".equals(r1) == false) goto L10;
        if (r6.isSpecial('\'') == false) goto L10;
        r0.append(0);
    L10:
        boolean r2 = r6.isSpecial(r1.charAt(0));
        if (r2 == false) goto L13;
        r0.append('\'');
    L13:
        r0.append(r1);
        if (r2 == false) goto L4;
        r0.append('\'');
        goto L4
    L17:
        return r0.toString();
    }

    public boolean applies(Object r3) {
        if (this.condition != null) goto L5;
    L9:
        Objects.requireNonNull(r3, "valueObject");
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, Number.class) == false) goto L9;
        Number r4 = (Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin");
        return this.condition.pass(r4.doubleValue());
    }

    public CellFormatResult apply(Object r3) {
        boolean r0 = applies(r3);
        if (r0 == false) goto L5;
        String r4 = this.format.format(r3);
        Color r2 = this.color;
    L7:
        return new CellFormatResult(r0, r4, r2);
    L5:
        r4 = this.format.simpleFormat(r3);
        r2 = null;
        goto L7
    }

    boolean hasCondition() {
        if (this.condition == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return this.format.format;
    }
}
