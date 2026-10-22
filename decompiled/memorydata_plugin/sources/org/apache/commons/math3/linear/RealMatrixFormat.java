package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public class RealMatrixFormat {
    private final String columnSeparator;
    private final NumberFormat format;
    private final String prefix;
    private final String rowPrefix;
    private final String rowSeparator;
    private final String rowSuffix;
    private final String suffix;

    public RealMatrixFormat() {
        this("{", "}", "{", "}", ",", ",", CompositeFormat.getDefaultNumberFormat());
    }

    public RealMatrixFormat(String r9, String r10, String r11, String r12, String r13, String r14) {
        this(r9, r10, r11, r12, r13, r14, CompositeFormat.getDefaultNumberFormat());
    }

    public RealMatrixFormat(String r1, String r2, String r3, String r4, String r5, String r6, NumberFormat r7) {
        this.prefix = r1;
        this.suffix = r2;
        this.rowPrefix = r3;
        this.rowSuffix = r4;
        this.rowSeparator = r5;
        this.columnSeparator = r6;
        this.format = r7;
        r7.setGroupingUsed(false);
    }

    public RealMatrixFormat(NumberFormat r9) {
        this("{", "}", "{", "}", ",", ",", r9);
    }

    public static RealMatrixFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static RealMatrixFormat getInstance(Locale r1) {
        return new RealMatrixFormat(CompositeFormat.getDefaultNumberFormat(r1));
    }

    public String format(RealMatrix r4) {
        return format((RealMatrix) ZeusTransformUtils.wrapperContextForParams(r4, RealMatrix.class, "com.obric.memorydata.plugin"), new StringBuffer(), new FieldPosition(0)).toString();
    }

    public StringBuffer format(RealMatrix r8, StringBuffer r9, FieldPosition r10) {
        RealMatrix r11 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r8, RealMatrix.class, "com.obric.memorydata.plugin");
        r10.setBeginIndex(0);
        r10.setEndIndex(0);
        r9.append(this.prefix);
        int r1 = r11.getRowDimension();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        r9.append(this.rowPrefix);
        int r3 = 0;
    L6:
        if (r3 >= r11.getColumnDimension()) goto L10;
        if (r3 <= 0) goto L9;
        r9.append(this.columnSeparator);
    L9:
        CompositeFormat.formatDouble(r11.getEntry(r2, r3), this.format, r9, r10);
        r3 = r3 + 1;
        goto L6
    L10:
        r9.append(this.rowSuffix);
        if (r2 >= (r1 - 1)) goto L13;
        r9.append(this.rowSeparator);
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        r9.append(this.suffix);
        return r9;
    }

    public NumberFormat getFormat() {
        return this.format;
    }
}
