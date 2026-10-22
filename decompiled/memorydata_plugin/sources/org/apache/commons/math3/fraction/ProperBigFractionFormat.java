package org.apache.commons.math3.fraction;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class ProperBigFractionFormat extends BigFractionFormat {
    private static final long serialVersionUID = -6337346779577272307L;
    private NumberFormat wholeFormat;

    public ProperBigFractionFormat() {
        this(getDefaultNumberFormat());
    }

    public ProperBigFractionFormat(NumberFormat r5) {
        this(r5, (NumberFormat) ZeusTransformUtils.preCheckCast(r5.clone(), NumberFormat.class, "com.obric.memorydata.plugin"), (NumberFormat) ZeusTransformUtils.preCheckCast(r5.clone(), NumberFormat.class, "com.obric.memorydata.plugin"));
    }

    public ProperBigFractionFormat(NumberFormat r1, NumberFormat r2, NumberFormat r3) {
        super(r2, r3);
        setWholeFormat(r1);
    }

    @Override // org.apache.commons.math3.fraction.BigFractionFormat
    public StringBuffer format(BigFraction r4, StringBuffer r5, FieldPosition r6) {
        r6.setBeginIndex(0);
        r6.setEndIndex(0);
        BigInteger r0 = r4.getNumerator();
        BigInteger r7 = r4.getDenominator();
        BigInteger r1 = r0.divide(r7);
        BigInteger r2 = r0.remainder(r7);
        if (BigInteger.ZERO.equals(r1) == true) goto L7;
        getWholeFormat().format(r1, r5, r6);
        r5.append(' ');
        if (r2.compareTo(BigInteger.ZERO) >= 0) goto L7;
        r2 = r2.negate();
    L7:
        getNumeratorFormat().format(r2, r5, r6);
        r5.append(" / ");
        getDenominatorFormat().format(r7, r5, r6);
        return r5;
    }

    public NumberFormat getWholeFormat() {
        return this.wholeFormat;
    }

    @Override // org.apache.commons.math3.fraction.BigFractionFormat, java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1, ParsePosition r2) {
        return parse(r1, r2);
    }

    @Override // org.apache.commons.math3.fraction.BigFractionFormat, java.text.NumberFormat
    public BigFraction parse(String r8, ParsePosition r9) {
        BigFraction r0 = super.parse(r8, r9);
        if (r0 == null) goto L5;
        return r0;
    L5:
        int r1 = r9.getIndex();
        parseAndIgnoreWhitespace(r8, r9);
        BigInteger r2 = parseNextBigInteger(r8, r9);
        if (r2 != null) goto L9;
        r9.setIndex(r1);
        return null;
    L9:
        parseAndIgnoreWhitespace(r8, r9);
        BigInteger r3 = parseNextBigInteger(r8, r9);
        if (r3 != null) goto L14;
        r9.setIndex(r1);
        return null;
    L14:
        if (r3.compareTo(BigInteger.ZERO) >= 0) goto L17;
        r9.setIndex(r1);
        return null;
    L17:
        int r4 = r9.getIndex();
        char r5 = parseNextCharacter(r8, r9);
        if (r5 == 0) goto L43;
        if (r5 == '/') goto L23;
        r9.setIndex(r1);
        r9.setErrorIndex(r4);
        return null;
    L23:
        parseAndIgnoreWhitespace(r8, r9);
        BigInteger r7 = parseNextBigInteger(r8, r9);
        if (r7 != null) goto L28;
        r9.setIndex(r1);
        return null;
    L28:
        if (r7.compareTo(BigInteger.ZERO) >= 0) goto L32;
        r9.setIndex(r1);
        return null;
    L32:
        if (r2.compareTo(BigInteger.ZERO) >= 0) goto L34;
        boolean r10 = true;
    L35:
        if (r10 == false) goto L37;
        r2 = r2.negate();
    L37:
        BigInteger r11 = r2.multiply(r7).add(r3);
        if (r10 == false) goto L41;
        r11 = r11.negate();
    L41:
        return new BigFraction(r11, r7);
    L34:
        r10 = false;
        goto L35
    L43:
        return new BigFraction(r3);
    }

    public void setWholeFormat(NumberFormat r2) {
        if (r2 == null) goto L6;
        this.wholeFormat = r2;
        return;
    L6:
        throw new NullArgumentException(LocalizedFormats.WHOLE_FORMAT, new Object[0]);
    }
}
