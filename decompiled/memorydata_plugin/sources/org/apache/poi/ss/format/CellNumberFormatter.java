package org.apache.poi.ss.format;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.zaxxer.sparsebits.SparseBitSet;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class CellNumberFormatter extends CellFormatter {
    private static final c LOG = null;
    private final CellFormatter SIMPLE_NUMBER;
    private final Special afterFractional;
    private final Special afterInteger;
    private final DecimalFormat decimalFmt;
    private final Special decimalPoint;
    private final String denominatorFmt;
    private final List<Special> denominatorSpecials;
    private final String desc;
    private final Special exponent;
    private final List<Special> exponentDigitSpecials;
    private final List<Special> exponentSpecials;
    private final List<Special> fractionalSpecials;
    private final boolean improperFraction;
    private final List<Special> integerSpecials;
    private final int maxDenominator;
    private final Special numerator;
    private final String numeratorFmt;
    private final List<Special> numeratorSpecials;
    private final String printfFmt;
    private final double scale;
    private final boolean showGroupingSeparator;
    private final Special slash;
    private final List<Special> specials;

    /* JADX INFO: renamed from: org.apache.poi.ss.format.CellNumberFormatter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class GeneralNumberFormatter extends CellFormatter {
        private GeneralNumberFormatter(Locale r2) {
            super(r2, "General");
        }

        /* synthetic */ GeneralNumberFormatter(Locale r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.apache.poi.ss.format.CellFormatter
        public void formatValue(StringBuffer r5, Object r6) {
            if (r6 != null) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r6, Number.class) == true) goto L7;
            CellFormatter r0 = CellTextFormatter.SIMPLE_TEXT;
        L11:
            r0.formatValue(r5, r6);
            return;
        L7:
            if ((((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).doubleValue() % 1.0d) != 0.0d) goto L9;
            r0 = new CellNumberFormatter(this.locale, "#");
            goto L11
        L9:
            r0 = new CellNumberFormatter(this.locale, "#.#");
            goto L11
        }

        @Override // org.apache.poi.ss.format.CellFormatter
        public void simpleValue(StringBuffer r1, Object r2) {
            formatValue(r1, r2);
        }
    }

    static class Special {
        final char ch;
        int pos;

        Special(char r1, int r2) {
            this.ch = r1;
            this.pos = r2;
        }

        public String toString() {
            return "'" + this.ch + "' @ " + this.pos;
        }
    }

    static {
        LOG = b.a(CellNumberFormatter.class);
    }

    public CellNumberFormatter(String r2) {
        this(LocaleUtil.getUserLocale(), r2);
    }

    public CellNumberFormatter(Locale r23, String r24) {
        super(r23, r24);
        ArrayList r7 = new ArrayList();
        this.specials = r7;
        ArrayList r8 = new ArrayList();
        this.integerSpecials = r8;
        ArrayList r9 = new ArrayList();
        this.fractionalSpecials = r9;
        ArrayList r10 = new ArrayList();
        this.numeratorSpecials = r10;
        ArrayList r11 = new ArrayList();
        this.denominatorSpecials = r11;
        ArrayList r12 = new ArrayList();
        this.exponentSpecials = r12;
        ArrayList r13 = new ArrayList();
        this.exponentDigitSpecials = r13;
        this.SIMPLE_NUMBER = new GeneralNumberFormatter(this.locale, null);
        CellNumberPartHandler r1 = new CellNumberPartHandler();
        StringBuffer r15 = CellFormatPart.parseFormat(r24, CellFormatType.NUMBER, r1);
        Special r6 = r1.getExponent();
        this.exponent = r6;
        r7.addAll(r1.getSpecials());
        this.improperFraction = r1.isImproperFraction();
        if (r1.getDecimalPoint() != null) goto L7;
        if (r1.getExponent() != null) goto L7;
    L9:
        this.slash = r1.getSlash();
        this.numerator = r1.getNumerator();
    L10:
        int r5 = interpretPrecision(r1.getDecimalPoint(), r7);
        if (r1.getDecimalPoint() == null) goto L17;
        int r2 = r5 + 1;
        Special r3 = r1.getDecimalPoint();
        if (r5 != 0) goto L15;
        r7.remove(r3);
        this.decimalPoint = null;
    L16:
        int r16 = r2;
    L18:
        Special r4 = this.decimalPoint;
        if (r4 == null) goto L21;
    L20:
        this.afterInteger = r4;
    L27:
        if (r6 == null) goto L29;
        this.afterFractional = r6;
    L33:
        double[] r14 = {r1.getScale()};
        this.showGroupingSeparator = interpretIntegerCommas(r15, r7, this.decimalPoint, integerEnd(), fractionalEnd(), r14);
        if (r6 != null) goto L36;
        this.scale = r14[0];
    L38:
        if (r5 == 0) goto L41;
        r9.addAll(r7.subList(r7.indexOf(this.decimalPoint) + 1, fractionalEnd()));
    L41:
        if (r6 == null) goto L44;
        int r17 = r7.indexOf(r6);
        r12.addAll(specialsFor(r17, 2));
        r13.addAll(specialsFor(r17 + 2));
    L44:
        if (this.slash == null) goto L52;
        Special r18 = this.numerator;
        if (r18 == null) goto L48;
        r10.addAll(specialsFor(r7.indexOf(r18)));
    L48:
        r11.addAll(specialsFor(r7.indexOf(this.slash) + 1));
        if (r11.isEmpty() == false) goto L51;
        r10.clear();
        this.maxDenominator = 1;
        String r19 = null;
    L53:
        this.numeratorFmt = r19;
        this.denominatorFmt = r19;
    L54:
        r8.addAll(r7.subList(0, integerEnd()));
        if (r6 != null) goto L61;
        int r20 = calculateIntegerPartWidth() + r16;
        if (r20 != 0) goto L59;
        String r21 = "";
    L60:
        this.printfFmt = r21;
        this.decimalFmt = null;
    L84:
        this.desc = r15.toString();
        return;
    L59:
        r21 = "%0" + r20 + '.' + r5 + f.f1488a;
        goto L60
    L61:
        StringBuffer r22 = new StringBuffer();
        boolean r25 = true;
        if (r8.size() != 1) goto L64;
        r22.append("0");
        r25 = false;
    L74:
        if (this.fractionalSpecials.isEmpty() == true) goto L83;
        r22.append('.');
        Iterator<Special> r26 = this.fractionalSpecials.iterator();
    L77:
        if (r26.hasNext() == false) goto L83;
        if (isDigitFmt((Special) ZeusTransformUtils.preCheckCast(r26.next(), Special.class, "com.obric.memorydata.plugin")) == false) goto L77;
        if (r25 == true) goto L82;
        r22.append('0');
    L82:
        r25 = false;
    L83:
        r22.append('E');
        List<Special> r27 = this.exponentSpecials;
        placeZeros(r22, r27.subList(2, r27.size()));
        this.decimalFmt = new DecimalFormat(r22.toString(), getDecimalFormatSymbols());
        this.printfFmt = null;
        goto L84
    L64:
        Iterator r28 = r8.iterator();
    L66:
        if (r28.hasNext() == false) goto L74;
        if (isDigitFmt((Special) ZeusTransformUtils.preCheckCast(r28.next(), Special.class, "com.obric.memorydata.plugin")) == false) goto L66;
        if (r25 == false) goto L71;
        char r29 = '#';
    L72:
        r22.append(r29);
        r25 = false;
        goto L66
    L71:
        r29 = '0';
        goto L72
    L51:
        this.maxDenominator = maxValue(r11);
        this.numeratorFmt = singleNumberFormat(r10);
        this.denominatorFmt = singleNumberFormat(r11);
        goto L54
    L52:
        r19 = null;
        this.maxDenominator = 1;
        goto L53
    L36:
        this.scale = 1.0d;
        goto L38
    L29:
        Special r30 = this.numerator;
        if (r30 == null) goto L32;
        this.afterFractional = r30;
        goto L33
    L32:
        this.afterFractional = null;
        goto L33
    L21:
        if (r6 == null) goto L23;
        this.afterInteger = r6;
        goto L27
    L23:
        r4 = this.numerator;
        if (r4 != null) goto L20;
        this.afterInteger = null;
        goto L27
    L15:
        this.decimalPoint = r3;
        goto L16
    L17:
        this.decimalPoint = null;
        r16 = 0;
    L7:
        if (r1.getSlash() == null) goto L9;
        this.slash = null;
        this.numerator = null;
        goto L10
    }

    private int calculateIntegerPartWidth() {
        Iterator<Special> r0 = this.specials.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L11;
        Special r2 = (Special) ZeusTransformUtils.preCheckCast(r0.next(), Special.class, "com.obric.memorydata.plugin");
        if (r2 == this.afterInteger) goto L11;
        if (isDigitFmt(r2) == false) goto L4;
        r1 = r1 + 1;
    L11:
        return r1;
    }

    private static CellNumberStringMod deleteMod(Special r1, boolean r2, Special r3, boolean r4) {
        return new CellNumberStringMod(r1, r2, r3, r4);
    }

    private int fractionalEnd() {
        Special r0 = this.afterFractional;
        List<Special> r1 = this.specials;
        if (r0 != null) goto L6;
        return r1.size();
    L6:
        return r1.indexOf(r0);
    }

    private DecimalFormatSymbols getDecimalFormatSymbols() {
        return DecimalFormatSymbols.getInstance(this.locale);
    }

    private static boolean hasChar(char r3, List<Special> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (((Special) ZeusTransformUtils.preCheckCast(r5.next(), Special.class, "com.obric.memorydata.plugin")).ch != r3) goto L4;
        return true;
    L9:
        return false;
    }

    private static boolean hasChar(char r2, List<Special> r3, List<Special> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (hasChar(r2, r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (hasChar(r2, r6) == true) goto L8;
        return false;
    }

    private static boolean hasChar(char r2, List<Special> r3, List<Special> r4, List<Special> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (hasChar(r2, r6) == false) goto L5;
    L10:
        return true;
    L5:
        if (hasChar(r2, r7) == true) goto L10;
        if (hasChar(r2, r8) == true) goto L10;
        return false;
    }

    private static CellNumberStringMod insertMod(Special r2, CharSequence r3, int r4) {
        return new CellNumberStringMod(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
    }

    private int integerEnd() {
        Special r0 = this.afterInteger;
        List<Special> r1 = this.specials;
        if (r0 != null) goto L6;
        return r1.size();
    L6:
        return r1.indexOf(r0);
    }

    private static boolean interpretIntegerCommas(StringBuffer r10, List<Special> r11, Special r12, int r13, int r14, double[] r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        ListIterator r17 = r16.listIterator(r13);
        int r2 = 0;
        boolean r3 = true;
        boolean r4 = false;
    L4:
        if (r17.hasPrevious() == false) goto L11;
        if (((Special) ZeusTransformUtils.preCheckCast(r17.previous(), Special.class, "com.obric.memorydata.plugin")).ch != ',') goto L7;
        if (r3 == true) goto L9;
        r4 = true;
        goto L4
    L9:
        r15[0] = r15[0] / 1000.0d;
        goto L4
    L7:
        r3 = false;
        goto L4
    L11:
        if (r12 == null) goto L19;
        ListIterator r18 = r16.listIterator(r14);
    L14:
        if (r18.hasPrevious() == false) goto L19;
        if (((Special) ZeusTransformUtils.preCheckCast(r18.previous(), Special.class, "com.obric.memorydata.plugin")).ch != ',') goto L19;
        r15[0] = r15[0] / 1000.0d;
    L19:
        ListIterator r19 = r16.listIterator();
    L21:
        if (r19.hasNext() == false) goto L25;
        Special r110 = (Special) ZeusTransformUtils.preCheckCast(r19.next(), Special.class, "com.obric.memorydata.plugin");
        r110.pos -= r2;
        if (r110.ch != ',') goto L21;
        r2 = r2 + 1;
        r19.remove();
        r10.deleteCharAt(r110.pos);
        goto L21
    L25:
        return r4;
    }

    private static int interpretPrecision(Special r3, List<Special> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        int r6 = r5.indexOf(r3);
        int r0 = 0;
        if (r6 == (-1)) goto L11;
        ListIterator r7 = r5.listIterator(r6 + 1);
    L6:
        if (r7.hasNext() == false) goto L11;
        if (isDigitFmt((Special) ZeusTransformUtils.preCheckCast(r7.next(), Special.class, "com.obric.memorydata.plugin")) == false) goto L11;
        r0 = r0 + 1;
    L11:
        return r0;
    }

    private static boolean isDigitFmt(Special r2) {
        if (r2.ch != '0') goto L5;
    L10:
        return true;
    L5:
        if (r2.ch == '?') goto L10;
        if (r2.ch == '#') goto L10;
        return false;
    }

    private static Special lastSpecial(List<Special> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        return (Special) ZeusTransformUtils.preCheckCast(r3.get(r3.size() - 1), Special.class, "com.obric.memorydata.plugin");
    }

    private String localiseFormat(String r5) {
        DecimalFormatSymbols r4 = getDecimalFormatSymbols();
        if (r5.contains(",") == false) goto L13;
        if (r4.getGroupingSeparator() == ',') goto L13;
        if (r5.contains(".") == false) goto L19;
        if (r4.getDecimalSeparator() == '.') goto L19;
        return replaceLast(r5, "\\.", "[DECIMAL_SEPARATOR]").replace(',', r4.getGroupingSeparator()).replace("[DECIMAL_SEPARATOR]", Character.toString(r4.getDecimalSeparator()));
    L19:
        return r5.replace(',', r4.getGroupingSeparator());
    L13:
        if (r5.contains(".") == true) goto L15;
        return r5;
    L15:
        if (r4.getDecimalSeparator() != '.') goto L17;
        return r5;
    L17:
        return r5.replace('.', r4.getDecimalSeparator());
    }

    private static int maxValue(List<Special> r4) {
        return Math.toIntExact(Math.round(Math.pow(10.0d, ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).size()) - 1.0d));
    }

    private static void placeZeros(StringBuffer r3, List<Special> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (isDigitFmt((Special) ZeusTransformUtils.preCheckCast(r5.next(), Special.class, "com.obric.memorydata.plugin")) == false) goto L4;
        r3.append('0');
        goto L4
    }

    private static String replaceLast(String r2, String r3, String r4) {
        return r2.replaceFirst("(?s)(.*)" + r3, "$1" + r4);
    }

    private static CellNumberStringMod replaceMod(Special r7, boolean r8, Special r9, boolean r10, char r11) {
        return new CellNumberStringMod(r7, r8, r9, r10, r11);
    }

    private static String singleNumberFormat(List<Special> r2) {
        return "%0" + ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin")).size() + "d";
    }

    private List<Special> specialsFor(int r2) {
        return specialsFor(r2, 0);
    }

    private List<Special> specialsFor(int r7, int r8) {
        if (r7 >= this.specials.size()) goto L5;
        int r9 = r8 + r7;
        ListIterator<Special> r0 = this.specials.listIterator(r9);
        Special r1 = (Special) ZeusTransformUtils.preCheckCast(r0.next(), Special.class, "com.obric.memorydata.plugin");
    L8:
        if (r0.hasNext() == false) goto L16;
        Special r2 = (Special) ZeusTransformUtils.preCheckCast(r0.next(), Special.class, "com.obric.memorydata.plugin");
        if (isDigitFmt(r2) == false) goto L16;
        if ((r2.pos - r1.pos) > 1) goto L16;
        r9 = r9 + 1;
        r1 = r2;
    L16:
        return this.specials.subList(r7, r9 + 1);
    L5:
        return Collections.emptyList();
    }

    private void writeFraction(double r17, StringBuffer r19, double r20, StringBuffer r22, Set<CellNumberStringMod> r23) {
        Set<CellNumberStringMod> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r23, Set.class, "com.obric.memorydata.plugin");
        int r12 = 1;
        if (this.improperFraction == true) goto L43;
        if (r20 == 0.0d) goto L7;
    L14:
        boolean r3 = !hasChar('0', this.numeratorSpecials);
        boolean r2 = !hasChar('0', this.integerSpecials);
        if (this.integerSpecials.isEmpty() == false) goto L17;
    L22:
        boolean r4 = true;
    L23:
        if (r20 != 0.0d) goto L27;
        if (r4 == true) goto L26;
        if (r3 == false) goto L27;
    L26:
        boolean r5 = true;
    L28:
        if (r20 == 0.0d) goto L31;
        if (r2 == false) goto L31;
        boolean r1 = true;
    L33:
        if (r17 != 0.0d) goto L41;
        if (r5 == true) goto L36;
        if (r1 == false) goto L41;
    L36:
        Special r6 = lastSpecial(this.integerSpecials);
        if (hasChar('?', this.integerSpecials, this.numeratorSpecials) == false) goto L39;
        CellNumberStringMod r7 = replaceMod(r6, true, this.numerator, false, ' ');
    L40:
        r9.add(r7);
        goto L43
    L39:
        r7 = deleteMod(r6, true, this.numerator, false);
    L41:
        writeInteger(r19, r22, this.integerSpecials, r9, false);
    L31:
        r1 = false;
    L27:
        r5 = false;
        goto L28
    L17:
        if (this.integerSpecials.size() == 1) goto L19;
    L21:
        r4 = false;
        goto L23
    L19:
        if (hasChar('#', this.integerSpecials) == false) goto L21;
    L7:
        if (hasChar('0', this.numeratorSpecials) == true) goto L14;
        writeInteger(r19, r22, this.integerSpecials, r9, false);
        Special r8 = lastSpecial(this.integerSpecials);
        Special r10 = lastSpecial(this.denominatorSpecials);
        if (hasChar('?', this.integerSpecials, this.numeratorSpecials, this.denominatorSpecials) == false) goto L11;
        CellNumberStringMod r0 = replaceMod(r8, false, r10, true, ' ');
    L12:
        r9.add(r0);
        return;
    L11:
        r0 = deleteMod(r8, false, r10, true);
    L43:
        if (r20 != 0.0d) goto L60;
    L50:
        int r11 = (int) Math.round(r20);     // Catch: RuntimeException -> L57
    L52:
        if (this.improperFraction == false) goto L54;
        int r13 = Math.toIntExact(((long) r11) + Math.round(((double) r12) * r17));     // Catch: RuntimeException -> L57
    L55:
        writeSingleInteger(this.numeratorFmt, r13, r22, this.numeratorSpecials, r9);     // Catch: RuntimeException -> L57
        writeSingleInteger(this.denominatorFmt, r12, r22, this.denominatorSpecials, r9);     // Catch: RuntimeException -> L57
        return;
    L57:
        e = move-exception;
        LOG.atError().a(e).a("error while fraction evaluation");
        return;
    L54:
        r13 = r11;
        goto L55
    L60:
        if (this.improperFraction == true) goto L47;
    L49:
        SimpleFraction r14 = SimpleFraction.buildFractionMaxDenominator(r20, this.maxDenominator);     // Catch: RuntimeException -> L57
        r11 = r14.getNumerator();     // Catch: RuntimeException -> L57
        r12 = r14.getDenominator();     // Catch: RuntimeException -> L57
        goto L52
    L47:
        if ((r20 % 1.0d) != 0.0d) goto L49;
        goto L49
    }

    private void writeFractional(StringBuffer r7, StringBuffer r8) {
        if (this.fractionalSpecials.isEmpty() == true) goto L29;
        int r0 = r7.indexOf(Character.toString(getDecimalFormatSymbols().getDecimalSeparator())) + 1;
        if (this.exponent == null) goto L7;
        int r1 = r7.indexOf("e");
    L9:
        r1 = r1 - 1;
        if (r1 <= r0) goto L14;
        if (r7.charAt(r1) == '0') goto L9;
    L14:
        Iterator<Special> r6 = this.fractionalSpecials.iterator();
    L16:
        if (r6.hasNext() == false) goto L36;
        Special r3 = (Special) ZeusTransformUtils.preCheckCast(r6.next(), Special.class, "com.obric.memorydata.plugin");
        char r4 = r7.charAt(r0);
        if (r4 == '0') goto L20;
    L26:
        int r5 = r3.pos;
    L27:
        r8.setCharAt(r5, r4);
    L28:
        r0 = r0 + 1;
        goto L16
    L20:
        if (r3.ch == '0') goto L26;
        if (r0 < r1) goto L26;
        if (r3.ch != '?') goto L28;
        r5 = r3.pos;
        r4 = ' ';
        goto L27
    L36:
        return;
    L7:
        r1 = r7.length();
        goto L9
    }

    private void writeInteger(StringBuffer r17, StringBuffer r18, List<Special> r19, Set<CellNumberStringMod> r20, boolean r21) {
        List<Special> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r20, Set.class, "com.obric.memorydata.plugin");
        DecimalFormatSymbols r5 = getDecimalFormatSymbols();
        String r6 = Character.toString(r5.getDecimalSeparator());
        String r7 = Character.toString(r5.getGroupingSeparator());
        int r8 = r17.indexOf(r6) - 1;
        if (r8 < 0) goto L5;
    L11:
        int r9 = 0;
    L13:
        if (r9 >= r8) goto L20;
        char r11 = r17.charAt(r9);
        if (r11 == '0') goto L19;
        if (r11 != r5.getGroupingSeparator()) goto L20;
    L19:
        r9 = r9 + 1;
    L20:
        ListIterator<Special> r3 = r2.listIterator(r2.size());
        Special r10 = null;
        int r12 = 0;
    L22:
        if (r3.hasPrevious() == false) goto L57;
        if (r8 < 0) goto L25;
        char r13 = r17.charAt(r8);
    L26:
        Special r14 = (Special) ZeusTransformUtils.preCheckCast(r3.previous(), Special.class, "com.obric.memorydata.plugin");
        if (r21 == false) goto L32;
        if (r12 <= 0) goto L32;
        if ((r12 % 3) != 0) goto L32;
        boolean r15 = true;
    L34:
        if (r13 != '0') goto L43;
        if (r14.ch == '0') goto L43;
        if (r14.ch == '?') goto L43;
        if (r8 >= r9) goto L43;
        boolean r0 = false;
    L51:
        if (r15 == false) goto L56;
        if (r0 == false) goto L54;
        String r1 = " ";
    L55:
        r4.add(insertMod(r14, r1, 2));
        goto L56
    L54:
        r1 = r7;
    L56:
        r12 = r12 + 1;
        r8 = r8 - 1;
    L43:
        if (r14.ch != '?') goto L46;
        if (r8 >= r9) goto L46;
        r0 = true;
    L47:
        int r16 = r14.pos;
        if (r0 == false) goto L50;
        r13 = ' ';
    L50:
        r18.setCharAt(r16, r13);
        r10 = r14;
    L46:
        r0 = false;
    L32:
        r15 = false;
        goto L34
    L25:
        r13 = '0';
        goto L26
    L57:
        if (r8 < 0) goto L79;
        int r22 = r8 + 1;
        StringBuffer r23 = new StringBuffer(r17.substring(0, r22));
        if (r21 == false) goto L66;
    L60:
        if (r22 <= 0) goto L66;
        if (r12 <= 0) goto L65;
        if ((r12 % 3) != 0) goto L65;
        r23.insert(r22, r7);
    L65:
        r12 = r12 + 1;
        r22 = r22 - 1;
    L66:
        r4.add(insertMod(r10, r23, 1));
        return;
    L79:
        return;
    L5:
        if (this.exponent != null) goto L7;
    L9:
        int r24 = r17.length();
    L10:
        r8 = r24 - 1;
        goto L11
    L7:
        if (r2 != this.integerSpecials) goto L9;
        r24 = r17.indexOf(ExifInterface.LONGITUDE_EAST);
        goto L10
    }

    private void writeScientific(double r11, StringBuffer r13, Set<CellNumberStringMod> r14) {
        Set<CellNumberStringMod> r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.memorydata.plugin");
        StringBuffer r0 = new StringBuffer();
        FieldPosition r8 = new FieldPosition(1);
        this.decimalFmt.format(r11, r0, r8);
        writeInteger(r0, r13, this.integerSpecials, r15, this.showGroupingSeparator);
        writeFractional(r0, r13);
        int r12 = r8.getEndIndex() + 1;
        char r16 = r0.charAt(r12);
        if (r16 == '-') goto L5;
        r0.insert(r12, '+');
        r16 = '+';
    L5:
        Special r1 = (Special) ZeusTransformUtils.preCheckCast(this.exponentSpecials.listIterator(1).next(), Special.class, "com.obric.memorydata.plugin");
        char r4 = r1.ch;
        if (r16 == '-') goto L10;
        if (r4 == '+') goto L10;
        CellNumberStringMod r17 = deleteMod(r1, true, r1, true);
    L11:
        r15.add(r17);
        writeInteger(new StringBuffer(r0.substring(r12 + 1)), r13, this.exponentDigitSpecials, r15, false);
        return;
    L10:
        r17 = replaceMod(r1, true, r1, true, r16);
        goto L11
    }

    private void writeSingleInteger(String r9, int r10, StringBuffer r11, List<Special> r12, Set<CellNumberStringMod> r13) {
        List<Special> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Set<CellNumberStringMod> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.memorydata.plugin");
        StringBuffer r3 = new StringBuffer();
        Formatter r14 = new Formatter(r3, this.locale);
        r14.format(this.locale, r9, new Object[]{Integer.valueOf(r10)});     // Catch: Throwable -> L6
        r14.close();
        writeInteger(r3, r11, r5, r6, false);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer r20, Object r21) {
        double r1 = BigDecimal.valueOf(((Number) ZeusTransformUtils.preCheckCast(r21, Number.class, "com.obric.memorydata.plugin")).doubleValue()).multiply(BigDecimal.valueOf(this.scale)).doubleValue();
        double r3 = 0.0d;
        int r12 = 1;
        if (r1 >= 0.0d) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L9;
        r1 = -r1;
    L9:
        if (this.slash != null) goto L11;
    L14:
        double r5 = r3;
        double r2 = r1;
    L15:
        TreeSet r14 = new TreeSet();
        StringBuffer r15 = new StringBuffer(localiseFormat(this.desc));
        if (this.exponent == null) goto L19;
        writeScientific(r2, r15, r14);
    L29:
        String r4 = Character.toString(getDecimalFormatSymbols().getGroupingSeparator());
        Iterator<CellNumberStringMod> r6 = r14.iterator();
        if (r6.hasNext() == false) goto L32;
        CellNumberStringMod r7 = (CellNumberStringMod) ZeusTransformUtils.preCheckCast(r6.next(), CellNumberStringMod.class, "com.obric.memorydata.plugin");
    L33:
        SparseBitSet r8 = new SparseBitSet();
        Iterator<Special> r9 = this.specials.iterator();
        int r17 = 0;
    L35:
        if (r9.hasNext() == false) goto L87;
        Special r10 = (Special) ZeusTransformUtils.preCheckCast(r9.next(), Special.class, "com.obric.memorydata.plugin");
        int r11 = r10.pos + r17;
        if (r8.get(r10.pos) == true) goto L41;
        if (r15.charAt(r11) != '#') goto L41;
        r15.deleteCharAt(r11);
        r17 = r17 - 1;
        r8.set(r10.pos);
    L41:
        if (r7 == null) goto L86;
        if (r10 != r7.getSpecial()) goto L86;
        int r16 = r15.length();
        int r18 = r10.pos + r17;
        int r19 = r7.getOp();
        if (r19 == r12) goto L80;
        if (r19 == 2) goto L74;
        if (r19 != 3) goto L72;
        int r110 = r10.pos;
        if (r7.isStartInclusive() == true) goto L54;
        r110 = r110 + 1;
        r18 = r18 + 1;
    L54:
        if (r8.get(r110) == false) goto L56;
        r110 = r110 + 1;
        r18 = r18 + 1;
        goto L54
    L56:
        int r111 = r7.getEnd().pos;
        if (r7.isEndInclusive() == false) goto L59;
        r111 = r111 + 1;
    L59:
        int r22 = r111 + r17;
        if (r18 >= r22) goto L81;
        if (r7.getToAdd() != null) goto L64;
    L66:
        char r23 = r7.getToAdd().charAt(0);
    L67:
        if (r18 >= r22) goto L69;
        r15.setCharAt(r18, r23);
        r18 = r18 + 1;
    L69:
        r8.set(r110, r111);
        goto L81
    L64:
        if (r7.getToAdd().length() != 0) goto L66;
        r15.delete(r18, r22);
    L81:
        r17 = r17 + (r15.length() - r16);
        if (r6.hasNext() == false) goto L84;
        r7 = (CellNumberStringMod) ZeusTransformUtils.preCheckCast(r6.next(), CellNumberStringMod.class, "com.obric.memorydata.plugin");
    L85:
        r12 = 1;
        goto L41
    L84:
        r7 = null;
        goto L85
    L72:
        throw new IllegalStateException("Unknown op: " + r7.getOp());
    L74:
        if (r7.getToAdd().equals(r4) == true) goto L76;
    L78:
        r18 = r18 + 1;
        goto L80
    L76:
        if (r8.get(r10.pos) == false) goto L78;
    L80:
        r15.insert(r18, r7.getToAdd());
    L86:
        r12 = 1;
        goto L35
    L87:
        if (r13 == false) goto L89;
        r20.append('-');
    L89:
        r20.append(r15);
        return;
    L32:
        r7 = null;
        goto L33
    L19:
        if (this.improperFraction == false) goto L22;
        StringBuffer r24 = null;
    L21:
        writeFraction(r2, r24, r5, r15, r14);
        goto L29
    L22:
        r24 = new StringBuffer();
        Formatter r25 = new Formatter(r24, this.locale);     // Catch: IllegalFormatException -> L102
        r25.format(this.locale, this.printfFmt, new Object[]{Double.valueOf(r2)});     // Catch: Throwable -> L91
        r25.close();     // Catch: IllegalFormatException -> L102
        if (this.numerator != null) goto L21;
        writeFractional(r24, r15);
        writeInteger(r24, r15, this.integerSpecials, r14, this.showGroupingSeparator);
        goto L29
    L91:
        th = move-exception;
        throw th;     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        r25.close();     // Catch: Throwable -> L98
    L123:
        throw th;     // Catch: IllegalFormatException -> L102
    L98:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalFormatException -> L102
        throw th;     // Catch: IllegalFormatException -> L102
    L102:
        e = move-exception;
        throw new IllegalArgumentException("Format: " + this.printfFmt, e);
    L11:
        if (this.improperFraction == false) goto L13;
        r5 = r1;
        r2 = 0.0d;
        goto L15
    L13:
        r3 = r1 % 1.0d;
        r1 = (long) r1;
        goto L14
    L5:
        r13 = false;
        goto L6
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer r1, Object r2) {
        this.SIMPLE_NUMBER.formatValue(r1, r2);
    }
}
