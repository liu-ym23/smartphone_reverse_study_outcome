package org.apache.commons.math3.fraction;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ProperFractionFormat extends FractionFormat {
    private static final long serialVersionUID = 760934726031766749L;
    private NumberFormat wholeFormat;

    public ProperFractionFormat() {
        this(getDefaultNumberFormat());
    }

    public ProperFractionFormat(NumberFormat r5) {
        this(r5, (NumberFormat) ZeusTransformUtils.preCheckCast(r5.clone(), NumberFormat.class, "com.obric.memorydata.plugin"), (NumberFormat) ZeusTransformUtils.preCheckCast(r5.clone(), NumberFormat.class, "com.obric.memorydata.plugin"));
    }

    public ProperFractionFormat(NumberFormat r1, NumberFormat r2, NumberFormat r3) {
        super(r2, r3);
        setWholeFormat(r1);
    }

    @Override // org.apache.commons.math3.fraction.FractionFormat
    public StringBuffer format(Fraction r6, StringBuffer r7, FieldPosition r8) {
        r8.setBeginIndex(0);
        r8.setEndIndex(0);
        int r0 = r6.getNumerator();
        int r9 = r6.getDenominator();
        int r1 = r0 / r9;
        int r2 = r0 % r9;
        if (r1 == 0) goto L5;
        getWholeFormat().format(r1, r7, r8);
        r7.append(' ');
        r2 = FastMath.abs(r2);
    L5:
        getNumeratorFormat().format(r2, r7, r8);
        r7.append(" / ");
        getDenominatorFormat().format(r9, r7, r8);
        return r7;
    }

    public NumberFormat getWholeFormat() {
        return this.wholeFormat;
    }

    @Override // org.apache.commons.math3.fraction.FractionFormat, java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1, ParsePosition r2) {
        return parse(r1, r2);
    }

    @Override // org.apache.commons.math3.fraction.FractionFormat, java.text.NumberFormat
    public Fraction parse(String r9, ParsePosition r10) {
        Fraction r0 = super.parse(r9, r10);
        if (r0 == null) goto L5;
        return r0;
    L5:
        int r1 = r10.getIndex();
        parseAndIgnoreWhitespace(r9, r10);
        Number r2 = getWholeFormat().parse(r9, r10);
        if (r2 != null) goto L9;
        r10.setIndex(r1);
        return null;
    L9:
        parseAndIgnoreWhitespace(r9, r10);
        Number r3 = getNumeratorFormat().parse(r9, r10);
        if (r3 != null) goto L14;
        r10.setIndex(r1);
        return null;
    L14:
        if (r3.intValue() >= 0) goto L17;
        r10.setIndex(r1);
        return null;
    L17:
        int r4 = r10.getIndex();
        char r5 = parseNextCharacter(r9, r10);
        if (r5 == 0) goto L34;
        if (r5 == '/') goto L23;
        r10.setIndex(r1);
        r10.setErrorIndex(r4);
        return null;
    L23:
        parseAndIgnoreWhitespace(r9, r10);
        Number r8 = getDenominatorFormat().parse(r9, r10);
        if (r8 != null) goto L28;
        r10.setIndex(r1);
        return null;
    L28:
        if (r8.intValue() >= 0) goto L31;
        r10.setIndex(r1);
        return null;
    L31:
        int r11 = r2.intValue();
        int r12 = r3.intValue();
        int r13 = r8.intValue();
        return new Fraction(((FastMath.abs(r11) * r13) + r12) * MathUtils.copySign(1, r11), r13);
    L34:
        return new Fraction(r3.intValue(), 1);
    }

    public void setWholeFormat(NumberFormat r2) {
        if (r2 == null) goto L6;
        this.wholeFormat = r2;
        return;
    L6:
        throw new NullArgumentException(LocalizedFormats.WHOLE_FORMAT, new Object[0]);
    }
}
