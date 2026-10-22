package org.apache.commons.math3.linear;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public class RealVectorFormat {
    private final NumberFormat format;
    private final String prefix;
    private final String separator;
    private final String suffix;
    private final String trimmedPrefix;
    private final String trimmedSeparator;
    private final String trimmedSuffix;

    public RealVectorFormat() {
        this("{", "}", "; ", CompositeFormat.getDefaultNumberFormat());
    }

    public RealVectorFormat(String r1, String r2, String r3, NumberFormat r4) {
        this.prefix = r1;
        this.suffix = r2;
        this.separator = r3;
        this.trimmedPrefix = r1.trim();
        this.trimmedSuffix = r2.trim();
        this.trimmedSeparator = r3.trim();
        this.format = r4;
    }

    public RealVectorFormat(NumberFormat r4) {
        this("{", "}", "; ", r4);
    }

    public static RealVectorFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static RealVectorFormat getInstance(Locale r1) {
        return new RealVectorFormat(CompositeFormat.getDefaultNumberFormat(r1));
    }

    public String format(RealVector r4) {
        return format(r4, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public StringBuffer format(RealVector r5, StringBuffer r6, FieldPosition r7) {
        int r0 = 0;
        r7.setBeginIndex(0);
        r7.setEndIndex(0);
        r6.append(this.prefix);
    L4:
        if (r0 >= r5.getDimension()) goto L8;
        if (r0 <= 0) goto L7;
        r6.append(this.separator);
    L7:
        CompositeFormat.formatDouble(r5.getEntry(r0), this.format, r6, r7);
        r0 = r0 + 1;
        goto L4
    L8:
        r6.append(this.suffix);
        return r6;
    }
}
