package org.apache.poi.ss.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes7.dex */
public class CellNumberPartHandler implements CellFormatPart.PartHandler {
    private CellNumberFormatter.Special decimalPoint;
    private CellNumberFormatter.Special exponent;
    private boolean improperFraction;
    private char insertSignForExponent;
    private CellNumberFormatter.Special numerator;
    private double scale;
    private CellNumberFormatter.Special slash;
    private final List<CellNumberFormatter.Special> specials;

    public CellNumberPartHandler() {
        this.scale = 1.0d;
        this.specials = new LinkedList();
    }

    private static CellNumberFormatter.Special firstDigit(List<CellNumberFormatter.Special> r3) {
        Iterator r4 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        CellNumberFormatter.Special r0 = (CellNumberFormatter.Special) ZeusTransformUtils.preCheckCast(r4.next(), CellNumberFormatter.Special.class, "com.obric.memorydata.plugin");
        if (isDigitFmt(r0) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private static boolean isDigitFmt(CellNumberFormatter.Special r2) {
        if (r2.ch != '0') goto L5;
    L10:
        return true;
    L5:
        if (r2.ch == '?') goto L10;
        if (r2.ch == '#') goto L10;
        return false;
    }

    private CellNumberFormatter.Special previousNumber() {
        List<CellNumberFormatter.Special> r5 = this.specials;
        ListIterator<CellNumberFormatter.Special> r6 = r5.listIterator(r5.size());
    L4:
        if (r6.hasPrevious() == false) goto L16;
        CellNumberFormatter.Special r0 = (CellNumberFormatter.Special) ZeusTransformUtils.preCheckCast(r6.previous(), CellNumberFormatter.Special.class, "com.obric.memorydata.plugin");
        if (isDigitFmt(r0) == false) goto L4;
    L8:
        if (r6.hasPrevious() == false) goto L15;
        CellNumberFormatter.Special r1 = (CellNumberFormatter.Special) ZeusTransformUtils.preCheckCast(r6.previous(), CellNumberFormatter.Special.class, "com.obric.memorydata.plugin");
        if ((r0.pos - r1.pos) > 1) goto L15;
        if (isDigitFmt(r1) == false) goto L15;
        r0 = r1;
    L15:
        return r0;
    L16:
        return null;
    }

    public CellNumberFormatter.Special getDecimalPoint() {
        return this.decimalPoint;
    }

    public CellNumberFormatter.Special getExponent() {
        return this.exponent;
    }

    public CellNumberFormatter.Special getNumerator() {
        return this.numerator;
    }

    public double getScale() {
        return this.scale;
    }

    public CellNumberFormatter.Special getSlash() {
        return this.slash;
    }

    public List<CellNumberFormatter.Special> getSpecials() {
        return this.specials;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
    public String handlePart(Matcher r5, String r6, CellFormatType r7, StringBuffer r8) {
        int r9 = r8.length();
        int r10 = 0;
        char r0 = r6.charAt(0);
        if (r0 == '#') goto L37;
        if (r0 != '%') goto L7;
        this.scale *= 100.0d;
    L42:
        return r6;
    L7:
        if (r0 == '?') goto L37;
        if (r0 == 'E') goto L30;
        if (r0 == 'e') goto L30;
        switch(r0) {
            case 46: goto L24;
            case 47: goto L16;
            case 48: goto L37;
            default: goto L13;
        };
    L13:
        return null;
    L16:
        if (this.slash != null) goto L42;
        if (this.specials.isEmpty() == true) goto L42;
        CellNumberFormatter.Special r11 = previousNumber();
        this.numerator = r11;
        boolean r1 = this.improperFraction;
        if (r11 != firstDigit(this.specials)) goto L22;
        r10 = 1;
    L22:
        this.improperFraction = r10 | (r1 ? 1 : 0);
        CellNumberFormatter.Special r12 = new CellNumberFormatter.Special('.', r9);
        this.slash = r12;
    L28:
        this.specials.add(r12);
        goto L42
    L24:
        if (this.decimalPoint != null) goto L42;
        if (this.specials.isEmpty() == true) goto L42;
        r12 = new CellNumberFormatter.Special('.', r9);
        this.decimalPoint = r12;
    L30:
        if (this.exponent != null) goto L42;
        if (this.specials.isEmpty() == true) goto L42;
        CellNumberFormatter.Special r13 = new CellNumberFormatter.Special('.', r9);
        this.exponent = r13;
        this.specials.add(r13);
        this.insertSignForExponent = r6.charAt(1);
        return r6.substring(0, 1);
    L37:
        if (this.insertSignForExponent == 0) goto L40;
        this.specials.add(new CellNumberFormatter.Special(this.insertSignForExponent, r9));
        r8.append(this.insertSignForExponent);
        this.insertSignForExponent = 0;
        r9 = r9 + 1;
    L40:
        if (r10 >= r6.length()) goto L42;
        this.specials.add(new CellNumberFormatter.Special(r6.charAt(r10), r9 + r10));
        r10 = r10 + 1;
        goto L40
    }

    public boolean isImproperFraction() {
        return this.improperFraction;
    }
}
