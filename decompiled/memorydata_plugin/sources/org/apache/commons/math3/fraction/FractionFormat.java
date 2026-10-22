package org.apache.commons.math3.fraction;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class FractionFormat extends AbstractFormat {
    private static final long serialVersionUID = 3008655719530972611L;

    public FractionFormat() {
    }

    public FractionFormat(NumberFormat r1) {
        super(r1);
    }

    public FractionFormat(NumberFormat r1, NumberFormat r2) {
        super(r1, r2);
    }

    public static String formatFraction(Fraction r1) {
        return getImproperInstance().format(r1);
    }

    public static Locale[] getAvailableLocales() {
        return NumberFormat.getAvailableLocales();
    }

    public static NumberFormat getDefaultNumberFormat() {
        return getDefaultNumberFormat(Locale.getDefault());
    }

    public static FractionFormat getImproperInstance() {
        return getImproperInstance(Locale.getDefault());
    }

    public static FractionFormat getImproperInstance(Locale r1) {
        return new FractionFormat(getDefaultNumberFormat(r1));
    }

    public static FractionFormat getProperInstance() {
        return getProperInstance(Locale.getDefault());
    }

    public static FractionFormat getProperInstance(Locale r1) {
        return new ProperFractionFormat(getDefaultNumberFormat(r1));
    }

    @Override // java.text.NumberFormat, java.text.Format
    public StringBuffer format(Object r4, StringBuffer r5, FieldPosition r6) {
        if (ZeusTransformUtils.instanceOf(r4, Fraction.class) == false) goto L6;
        return format((Fraction) ZeusTransformUtils.preCheckCast(r4, Fraction.class, "com.obric.memorydata.plugin"), r5, r6);
    L6:
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L10;
        return format(new Fraction(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).doubleValue()), r5, r6);
    L10:
        throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_FORMAT_OBJECT_TO_FRACTION, new Object[0]);
    }

    public StringBuffer format(Fraction r4, StringBuffer r5, FieldPosition r6) {
        r6.setBeginIndex(0);
        r6.setEndIndex(0);
        getNumeratorFormat().format(r4.getNumerator(), r5, r6);
        r5.append(" / ");
        getDenominatorFormat().format(r4.getDenominator(), r5, r6);
        return r5;
    }

    @Override // java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1) {
        return parse(r1);
    }

    @Override // java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1, ParsePosition r2) {
        return parse(r1, r2);
    }

    @Override // java.text.NumberFormat
    public Fraction parse(String r3) {
        ParsePosition r0 = new ParsePosition(0);
        Fraction r2 = parse(r3, r0);
        if (r0.getIndex() == 0) goto L6;
        return r2;
    L6:
        throw new MathParseException(r3, r0.getErrorIndex(), Fraction.class);
    }

    @Override // java.text.NumberFormat
    public Fraction parse(String r7, ParsePosition r8) {
        int r0 = r8.getIndex();
        parseAndIgnoreWhitespace(r7, r8);
        Number r1 = getNumeratorFormat().parse(r7, r8);
        if (r1 != null) goto L6;
        r8.setIndex(r0);
        return null;
    L6:
        int r3 = r8.getIndex();
        char r4 = parseNextCharacter(r7, r8);
        if (r4 == 0) goto L19;
        if (r4 == '/') goto L12;
        r8.setIndex(r0);
        r8.setErrorIndex(r3);
        return null;
    L12:
        parseAndIgnoreWhitespace(r7, r8);
        Number r6 = getDenominatorFormat().parse(r7, r8);
        if (r6 != null) goto L17;
        r8.setIndex(r0);
        return null;
    L17:
        return new Fraction(r1.intValue(), r6.intValue());
    L19:
        return new Fraction(r1.intValue(), 1);
    }
}
