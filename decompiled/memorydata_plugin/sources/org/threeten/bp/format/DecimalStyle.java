package org.threeten.bp.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes8.dex */
public final class DecimalStyle {
    private static final ConcurrentMap<Locale, DecimalStyle> CACHE = null;
    public static final DecimalStyle STANDARD = null;
    private final char decimalSeparator;
    private final char negativeSign;
    private final char positiveSign;
    private final char zeroDigit;

    static {
        STANDARD = new DecimalStyle('0', '+', '-', '.');
        CACHE = new ConcurrentHashMap(16, 0.75f, 2);
    }

    private DecimalStyle(char r1, char r2, char r3, char r4) {
        this.zeroDigit = r1;
        this.positiveSign = r2;
        this.negativeSign = r3;
        this.decimalSeparator = r4;
    }

    String convertNumberToI18N(String r3) {
        char r2 = this.zeroDigit;
        if (r2 != '0') goto L5;
        return r3;
    L5:
        int r4 = r2 - '0';
        char[] r5 = r3.toCharArray();
        int r0 = 0;
    L7:
        if (r0 >= r5.length) goto L10;
        r5[r0] = (char) (r5[r0] + r4);
        r0 = r0 + 1;
        goto L7
    L10:
        return new String(r5);
    }

    int convertToDigit(char r1) {
        int r2 = r1 - this.zeroDigit;
        if (r2 >= 0) goto L5;
    L7:
        return -1;
    L5:
        if (r2 > 9) goto L7;
        return r2;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DecimalStyle.class) == false) goto L18;
        DecimalStyle r6 = (DecimalStyle) ZeusTransformUtils.preCheckCast(r5, DecimalStyle.class, "com.obric.memorydata.plugin");
        if (this.zeroDigit != r6.zeroDigit) goto L17;
        if (this.positiveSign != r6.positiveSign) goto L17;
        if (this.negativeSign != r6.negativeSign) goto L17;
        if (this.decimalSeparator != r6.decimalSeparator) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public char getNegativeSign() {
        return this.negativeSign;
    }

    public char getPositiveSign() {
        return this.positiveSign;
    }

    public char getZeroDigit() {
        return this.zeroDigit;
    }

    public int hashCode() {
        return ((this.zeroDigit + this.positiveSign) + this.negativeSign) + this.decimalSeparator;
    }

    public String toString() {
        return "DecimalStyle[" + this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator + "]";
    }
}
