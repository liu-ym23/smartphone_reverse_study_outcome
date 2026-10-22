package org.apache.commons.math3.util;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class CompositeFormat {
    public static StringBuffer formatDouble(double r1, NumberFormat r3, StringBuffer r4, FieldPosition r5) {
        if (Double.isNaN(r1) == false) goto L5;
    L8:
        r4.append('(');
        r4.append(r1);
        r4.append(')');
    L9:
        return r4;
    L5:
        if (Double.isInfinite(r1) == true) goto L8;
        r3.format(r1, r4, r5);
        goto L9
    }

    public static NumberFormat getDefaultNumberFormat() {
        return getDefaultNumberFormat(Locale.getDefault());
    }

    public static NumberFormat getDefaultNumberFormat(Locale r1) {
        NumberFormat r2 = NumberFormat.getInstance(r1);
        r2.setMaximumFractionDigits(10);
        return r2;
    }
}
