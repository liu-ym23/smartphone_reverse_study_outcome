package org.apache.commons.math3.fraction;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractFormat extends NumberFormat implements Serializable {
    private static final long serialVersionUID = -6981118387974191891L;
    private NumberFormat denominatorFormat;
    private NumberFormat numeratorFormat;

    public AbstractFormat() {
        this(getDefaultNumberFormat());
    }

    public AbstractFormat(NumberFormat r4) {
        this(r4, (NumberFormat) ZeusTransformUtils.preCheckCast(r4.clone(), NumberFormat.class, "com.obric.memorydata.plugin"));
    }

    public AbstractFormat(NumberFormat r1, NumberFormat r2) {
        this.numeratorFormat = r1;
        this.denominatorFormat = r2;
    }

    public static NumberFormat getDefaultNumberFormat() {
        return getDefaultNumberFormat(Locale.getDefault());
    }

    public static NumberFormat getDefaultNumberFormat(Locale r1) {
        NumberFormat r2 = NumberFormat.getNumberInstance(r1);
        r2.setMaximumFractionDigits(0);
        r2.setParseIntegerOnly(true);
        return r2;
    }

    public static void parseAndIgnoreWhitespace(String r0, ParsePosition r1) {
        parseNextCharacter(r0, r1);
        r1.setIndex(r1.getIndex() - 1);
    }

    public static char parseNextCharacter(String r4, ParsePosition r5) {
        int r0 = r5.getIndex();
        int r1 = r4.length();
        if (r0 >= r1) goto L12;
    L4:
        int r2 = r0 + 1;
        char r3 = r4.charAt(r0);
        if (Character.isWhitespace(r3) == false) goto L9;
        if (r2 >= r1) goto L9;
        r0 = r2;
    L9:
        r5.setIndex(r2);
        if (r2 >= r1) goto L12;
        return r3;
    L12:
        return 0;
    }

    @Override // java.text.NumberFormat
    public StringBuffer format(double r1, StringBuffer r3, FieldPosition r4) {
        return format(Double.valueOf(r1), r3, r4);
    }

    @Override // java.text.NumberFormat
    public StringBuffer format(long r1, StringBuffer r3, FieldPosition r4) {
        return format(Long.valueOf(r1), r3, r4);
    }

    public NumberFormat getDenominatorFormat() {
        return this.denominatorFormat;
    }

    public NumberFormat getNumeratorFormat() {
        return this.numeratorFormat;
    }

    public void setDenominatorFormat(NumberFormat r2) {
        if (r2 == null) goto L6;
        this.denominatorFormat = r2;
        return;
    L6:
        throw new NullArgumentException(LocalizedFormats.DENOMINATOR_FORMAT, new Object[0]);
    }

    public void setNumeratorFormat(NumberFormat r2) {
        if (r2 == null) goto L6;
        this.numeratorFormat = r2;
        return;
    L6:
        throw new NullArgumentException(LocalizedFormats.NUMERATOR_FORMAT, new Object[0]);
    }
}
