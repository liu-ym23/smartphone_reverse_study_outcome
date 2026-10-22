package com.alibaba.excel.metadata.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ExcelGeneralNumberFormat extends Format {
    private static final MathContext TO_10_SF = null;
    private static final long serialVersionUID = 1;
    private final DecimalFormat decimalFormat;
    private final DecimalFormatSymbols decimalSymbols;
    private final DecimalFormat integerFormat;
    private final DecimalFormat scientificFormat;

    static {
        TO_10_SF = new MathContext(10, RoundingMode.HALF_UP);
    }

    public ExcelGeneralNumberFormat(Locale r3, boolean r4) {
        DecimalFormatSymbols r5 = DecimalFormatSymbols.getInstance(r3);
        this.decimalSymbols = r5;
        if (r4 == false) goto L5;
        DecimalFormat r6 = new DecimalFormat("0.#####E0", r5);
    L6:
        this.scientificFormat = r6;
        org.apache.poi.ss.usermodel.DataFormatter.setExcelStyleRoundingMode(this.scientificFormat);
        DecimalFormat r7 = new DecimalFormat("#", r5);
        this.integerFormat = r7;
        org.apache.poi.ss.usermodel.DataFormatter.setExcelStyleRoundingMode(r7);
        DecimalFormat r8 = new DecimalFormat("#.##########", r5);
        this.decimalFormat = r8;
        org.apache.poi.ss.usermodel.DataFormatter.setExcelStyleRoundingMode(r8);
        return;
    L5:
        r6 = new DecimalFormat("#", r5);
        goto L6
    }

    @Override // java.text.Format
    public StringBuffer format(Object r7, StringBuffer r8, FieldPosition r9) {
        if (ZeusTransformUtils.instanceOf(r7, Number.class) == false) goto L30;
        double r0 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        if (Double.isInfinite(r0) == true) goto L28;
        if (Double.isNaN(r0) == true) goto L28;
        double r2 = Math.abs(r0);
        if (r2 >= 1.0E11d) goto L26;
        if (r2 > 1.0E-10d) goto L17;
        if (r2 > 0.0d) goto L26;
    L17:
        if (Math.floor(r0) == r0) goto L24;
        if (r2 >= 1.0E10d) goto L24;
        double r1 = new BigDecimal(r0).round(TO_10_SF).doubleValue();
        return this.decimalFormat.format(r1, r8, r9);
    L24:
        return this.integerFormat.format(r7, r8, r9);
    L26:
        return this.scientificFormat.format(r7, r8, r9);
    L28:
        return this.integerFormat.format(r7, r8, r9);
    L30:
        return this.integerFormat.format(r7, r8, r9);
    }

    @Override // java.text.Format
    public Object parseObject(String r1, ParsePosition r2) {
        throw new UnsupportedOperationException();
    }
}
