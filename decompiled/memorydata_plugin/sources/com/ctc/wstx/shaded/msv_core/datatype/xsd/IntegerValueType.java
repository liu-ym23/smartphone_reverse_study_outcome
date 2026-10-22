package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class IntegerValueType extends Number implements Serializable, Comparable {
    private static final long serialVersionUID = 1;
    private final String value;

    private IntegerValueType(long r1) {
        this.value = Long.toString(r1);
    }

    private IntegerValueType(String r1) {
        this.value = r1;
    }

    public static IntegerValueType create(String r7) {
        int r0 = r7.length();
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r2 = 0;
        char r3 = r7.charAt(0);
        String r6 = "";
        if (r3 != '+') goto L8;
    L12:
        r2 = 1;
    L13:
        if (r2 != r0) goto L16;
        return null;
    L16:
        if (r2 >= r0) goto L20;
        if (r7.charAt(r2) != '0') goto L20;
        r2 = r2 + 1;
    L20:
        if (r2 == r0) goto L22;
    L23:
        if (r2 >= r0) goto L31;
        int r4 = r2 + 1;
        char r5 = r7.charAt(r2);
        if ('0' > r5) goto L29;
        if (r5 > '9') goto L29;
        r6 = r6 + r5;
        r2 = r4;
    L29:
        return null;
    L31:
        return new IntegerValueType(r6);
    L22:
        return new IntegerValueType("0");
    L8:
        if (r3 == '-') goto L11;
        switch(r3) {
            case 48: goto L13;
            case 49: goto L13;
            case 50: goto L13;
            case 51: goto L13;
            case 52: goto L13;
            case 53: goto L13;
            case 54: goto L13;
            case 55: goto L13;
            case 56: goto L13;
            case 57: goto L13;
            default: goto L10;
        };
    L10:
        return null;
    L11:
        r6 = "-";
        goto L12
    }

    public static IntegerValueType create(BigInteger r0) {
        return create(r0.toString());
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r11) {
        if (ZeusTransformUtils.instanceOf(r11, IntegerValueType.class) == false) goto L5;
        IntegerValueType r12 = (IntegerValueType) ZeusTransformUtils.preCheckCast(r11, IntegerValueType.class, "com.obric.memorydata.plugin");
    L7:
        if (this.value.charAt(0) != '-') goto L9;
        boolean r0 = true;
    L11:
        if (r12.value.charAt(0) != '-') goto L13;
        boolean r2 = true;
    L15:
        if (r0 == false) goto L18;
        if (r2 == true) goto L18;
        return -1;
    L18:
        if (r2 == false) goto L21;
        if (r0 == true) goto L21;
        return 1;
    L21:
        if (r0 == false) goto L24;
        if (r2 == false) goto L24;
        int r3 = 1;
    L25:
        int r5 = this.value.length() - r3;
        int r6 = r12.value.length() - r3;
        if (r5 <= r6) goto L30;
        if (r0 == true) goto L29;
        return 1;
    L29:
        return -1;
    L30:
        if (r5 >= r6) goto L35;
        if (r0 == false) goto L34;
        return 1;
    L34:
        return -1;
    L35:
        int r7 = r5;
        int r8 = r3;
    L36:
        if (r7 <= 0) goto L48;
        int r9 = r3 + 1;
        char r4 = this.value.charAt(r3);
        int r10 = r8 + 1;
        char r13 = r12.value.charAt(r8);
        if (r4 > r13) goto L39;
        if (r4 < r13) goto L43;
        r7 = r7 - 1;
        r3 = r9;
        r8 = r10;
        goto L36
    L43:
        if (r0 == false) goto L46;
        return 1;
    L46:
        return -1;
    L39:
        if (r0 == true) goto L41;
        return 1;
    L41:
        return -1;
    L48:
        return 0;
    L24:
        r3 = 0;
        goto L25
    L13:
        r2 = false;
        goto L15
    L9:
        r0 = false;
        goto L11
    L5:
        r12 = new IntegerValueType(((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L7
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return toBigInteger().doubleValue();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, IntegerValueType.class) == true) goto L5;
        return false;
    L5:
        return this.value.equals(((IntegerValueType) ZeusTransformUtils.preCheckCast(r3, IntegerValueType.class, "com.obric.memorydata.plugin")).value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return toBigInteger().intValue();
    }

    public boolean isNegative() {
        if (this.value.charAt(0) != '-') goto L6;
        return true;
    L6:
        return false;
    }

    public boolean isNonNegative() {
        if (this.value.charAt(0) == '-') goto L6;
        return true;
    L6:
        return false;
    }

    public boolean isNonPositive() {
        char r2 = this.value.charAt(0);
        if (r2 != '-') goto L5;
        return true;
    L5:
        if (r2 == '0') goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isPositive() {
        char r2 = this.value.charAt(0);
        if (r2 != '-') goto L5;
    L9:
        return false;
    L5:
        if (r2 == '0') goto L9;
        return true;
    }

    @Override // java.lang.Number
    public long longValue() {
        return toBigInteger().longValue();
    }

    public int precision() {
        int r0 = this.value.length();
        if (this.value.charAt(0) == '-') goto L5;
        return r0;
    L5:
        return r0 - 1;
    }

    public BigInteger toBigInteger() {
        return new BigInteger(this.value);
    }

    public String toString() {
        return this.value;
    }
}
