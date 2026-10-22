package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.format.SimpleFraction;
import org.apache.poi.ss.formula.eval.NotImplementedException;

/* JADX INFO: loaded from: classes7.dex */
public class FractionFormat extends Format {
    private static final Pattern DENOM_FORMAT_PATTERN = null;
    private static final c LOGGER = null;
    private static final int MAX_DENOM_POW = 4;
    private final int exactDenom;
    private final int maxDenom;
    private final String wholePartFormatString;

    static {
        LOGGER = b.a(FractionFormat.class);
        DENOM_FORMAT_PATTERN = Pattern.compile("(?:(#+)|(\\d+))");
    }

    public FractionFormat(String r6, String r7) {
        this.wholePartFormatString = r6;
        Matcher r8 = DENOM_FORMAT_PATTERN.matcher(r7);
        int r0 = 100;
        int r1 = -1;
        if (r8.find() == true) goto L5;
        int r9 = -1;
    L18:
        if (r1 > 0) goto L21;
        if (r9 > 0) goto L21;
    L22:
        this.exactDenom = r0;
        this.maxDenom = r9;
        return;
    L21:
        r0 = r1;
        goto L22
    L5:
        if (r8.group(2) == null) goto L14;
        int r10 = Integer.parseInt(r8.group(2));     // Catch: NumberFormatException -> L10
        if (r10 != 0) goto L9;
        r10 = -1;
    L9:
        r1 = r10;
        r9 = -1;
    L10:
        e = move-exception;
        throw new IllegalStateException(e);
    L14:
        if (r8.group(1) == null) goto L16;
        r9 = (int) Math.pow(10.0d, Math.min(r8.group(1).length(), 4));
        goto L18
    L16:
        r9 = -1;
        r1 = 100;
        goto L18
    }

    private String format(BigDecimal r8) {
        if (r8.compareTo(BigDecimal.ZERO) >= 0) goto L5;
        boolean r0 = true;
    L6:
        BigDecimal r1 = r8.abs();
        BigDecimal r2 = new BigDecimal(r1.toBigInteger());
        BigDecimal r3 = r1.remainder(BigDecimal.ONE);
        if (r2.add(r3).compareTo(BigDecimal.ZERO) != 0) goto L11;
        return "0";
    L11:
        if (r3.compareTo(BigDecimal.ZERO) != 0) goto L47;
        StringBuilder r7 = new StringBuilder();
        if (r0 == false) goto L15;
        r7.append('-');
    L15:
        r7.append(r2);
        return r7.toString();
    L47:
    L44:
        e = move-exception;
        LOGGER.atWarn().a(e).a("Can't format fraction");
        return Double.toString(r8.doubleValue());
    L18:
        if (this.exactDenom <= 0) goto L20;
        SimpleFraction r9 = SimpleFraction.buildFractionExactDenominator(r3.doubleValue(), this.exactDenom);     // Catch: RuntimeException -> L44
    L21:
        StringBuilder r4 = new StringBuilder();
        if (r0 == false) goto L24;
        r4.append('-');
    L24:
        String r10 = this.wholePartFormatString;
        if (r10 != null) goto L27;
    L42:
        int r11 = r9.getDenominator();
        r4.append(r2.multiply(BigDecimal.valueOf(r11)).add(BigDecimal.valueOf(r9.getNumerator())).toBigInteger()).append("/").append(r11);
        return r4.toString();
    L27:
        if (r10.isEmpty() == true) goto L42;
        if (r9.getNumerator() != 0) goto L34;
        r4.append(r2);
        return r4.toString();
    L34:
        if (r9.getNumerator() != r9.getDenominator()) goto L38;
        r4.append(r2.add(BigDecimal.ONE));
        return r4.toString();
    L38:
        if (r2.compareTo(BigDecimal.ZERO) <= 0) goto L40;
        r4.append(r2).append(" ");
    L40:
        r4.append(r9.getNumerator()).append("/").append(r9.getDenominator());
        return r4.toString();
    L20:
        r9 = SimpleFraction.buildFractionMaxDenominator(r3.doubleValue(), this.maxDenom);     // Catch: RuntimeException -> L44
        goto L21
    L5:
        r0 = false;
        goto L6
    }

    public String format(Number r3) {
        return format(new BigDecimal(r3.doubleValue()));
    }

    @Override // java.text.Format
    public StringBuffer format(Object r2, StringBuffer r3, FieldPosition r4) {
        return r3.append(format((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")));
    }

    @Override // java.text.Format
    public Object parseObject(String r1, ParsePosition r2) {
        throw new NotImplementedException("Reverse parsing not supported");
    }
}
