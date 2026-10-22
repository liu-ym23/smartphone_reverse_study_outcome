package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class BigTimeDurationValueType implements ITimeDurationValueType {
    private static final long serialVersionUID = 1;
    private static final BigDateTimeValueType[] testInstance = null;
    protected BigInteger day;
    protected BigInteger hour;
    protected BigInteger minute;
    protected BigInteger month;
    protected BigDecimal second;
    protected int signum;
    protected BigInteger year;

    static {
        testInstance = new BigDateTimeValueType[]{new BigDateTimeValueType(new BigInteger("1696"), 8, 0, 0, 0, new BigDecimal(0), TimeZone.ZERO), new BigDateTimeValueType(new BigInteger("1697"), 1, 0, 0, 0, new BigDecimal(0), TimeZone.ZERO), new BigDateTimeValueType(new BigInteger("1903"), 2, 0, 0, 0, new BigDecimal(0), TimeZone.ZERO), new BigDateTimeValueType(new BigInteger("1903"), 6, 0, 0, 0, new BigDecimal(0), TimeZone.ZERO)};
    }

    public BigTimeDurationValueType(int r1, BigInteger r2, BigInteger r3, BigInteger r4, BigInteger r5, BigInteger r6, BigDecimal r7) {
        this.signum = r1;
        if (r2 != null) goto L6;
        r2 = BigInteger.ZERO;
    L6:
        this.year = r2;
        if (r3 != null) goto L10;
        r3 = BigInteger.ZERO;
    L10:
        this.month = r3;
        if (r4 != null) goto L14;
        r4 = BigInteger.ZERO;
    L14:
        this.day = r4;
        if (r5 != null) goto L18;
        r5 = BigInteger.ZERO;
    L18:
        this.hour = r5;
        if (r6 != null) goto L22;
        r6 = BigInteger.ZERO;
    L22:
        this.minute = r6;
        if (r7 != null) goto L26;
        r7 = g.i;
    L26:
        this.second = r7;
    }

    public BigTimeDurationValueType(String r14) {
        int[] r1 = new int[1];
        if (r14.charAt(r1[0]) != '-') goto L5;
        r1[0] = r1[0] + 1;
        boolean r3 = false;
    L6:
        int r4 = r1[0];
        r1[0] = r4 + 1;
        if (r14.charAt(r4) != 'P') goto L80;
        String[] r5 = new String[3];
        int[] r6 = new int[3];
        int r7 = 0;
    L10:
        if (r14.length() == r1[0]) goto L16;
        if (isDigit(r14.charAt(r1[0])) == false) goto L16;
        if (r7 >= 3) goto L16;
        r6[r7] = r1[0];
        r5[r7] = parsePiece(r14, r1);
        r7 = r7 + 1;
    L16:
        if (r14.length() == r1[0]) goto L22;
        int r8 = r1[0];
        r1[0] = r8 + 1;
        if (r14.charAt(r8) == 'T') goto L22;
        throw new IllegalArgumentException(r14);
    L22:
        String[] r9 = new String[3];
        int[] r10 = new int[3];
        int r11 = 0;
    L24:
        if (r14.length() == r1[0]) goto L30;
        if (isDigitOrPeriod(r14.charAt(r1[0])) == false) goto L30;
        if (r11 >= 3) goto L30;
        r10[r11] = r1[0];
        r9[r11] = parsePiece(r14, r1);
        r11 = r11 + 1;
    L30:
        if (r14.length() != r1[0]) goto L78;
        if (r7 != 0) goto L36;
        if (r11 != 0) goto L36;
        throw new IllegalArgumentException(r14);
    L36:
        organizeParts(r14, r5, r6, r7, "YMD");
        organizeParts(r14, r9, r10, r11, "HMS");
        this.year = parseBigInteger(r14, r5[0], r6[0]);
        this.month = parseBigInteger(r14, r5[1], r6[1]);
        this.day = parseBigInteger(r14, r5[2], r6[2]);
        this.hour = parseBigInteger(r14, r9[0], r10[0]);
        this.minute = parseBigInteger(r14, r9[1], r10[1]);
        this.second = parseBigDecimal(r14, r9[2], r10[2]);
        BigInteger r15 = this.year;
        if (r15 != null) goto L40;
        r15 = BigInteger.ZERO;
    L40:
        this.year = r15;
        BigInteger r16 = this.month;
        if (r16 != null) goto L44;
        r16 = BigInteger.ZERO;
    L44:
        this.month = r16;
        BigInteger r17 = this.day;
        if (r17 != null) goto L48;
        r17 = BigInteger.ZERO;
    L48:
        this.day = r17;
        BigInteger r18 = this.hour;
        if (r18 != null) goto L52;
        r18 = BigInteger.ZERO;
    L52:
        this.hour = r18;
        BigInteger r19 = this.minute;
        if (r19 != null) goto L56;
        r19 = BigInteger.ZERO;
    L56:
        this.minute = r19;
        BigDecimal r110 = this.second;
        if (r110 != null) goto L60;
        r110 = g.i;
    L60:
        this.second = r110;
        if (getSignum(this.year) == 0) goto L63;
    L73:
        if (r3 == false) goto L75;
        this.signum = 1;
        return;
    L75:
        this.signum = -1;
        return;
    L63:
        if (getSignum(this.month) != 0) goto L73;
        if (getSignum(this.day) != 0) goto L73;
        if (getSignum(this.hour) != 0) goto L73;
        if (getSignum(this.minute) != 0) goto L73;
        if (getSignum(this.second) != 0) goto L73;
        this.signum = 0;
        return;
    L78:
        throw new IllegalArgumentException(r14);
    L80:
        throw new IllegalArgumentException(r14);
    L5:
        r3 = true;
        goto L6
    }

    private static int compare(BigTimeDurationValueType r10, BigTimeDurationValueType r11) {
        int r1 = 0;
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
    L3:
        BigDateTimeValueType[] r5 = testInstance;
        if (r1 >= r5.length) goto L16;
        BigDateTimeValueType r6 = (BigDateTimeValueType) ZeusTransformUtils.preCheckCast(r5[r1].add(r10), BigDateTimeValueType.class, "com.obric.memorydata.plugin");
        BigDateTimeValueType r7 = (BigDateTimeValueType) ZeusTransformUtils.preCheckCast(r5[r1].add(r11), BigDateTimeValueType.class, "com.obric.memorydata.plugin");
        int r8 = BigDateTimeValueType.compare(r6, r7);
        if (r8 >= 0) goto L8;
        r3 = true;
    L8:
        if (r8 <= 0) goto L10;
        r4 = true;
    L10:
        if (r8 != 0) goto L14;
        if (r6.equals(r7) == true) goto L14;
        r2 = true;
    L14:
        r1 = r1 + 1;
        goto L3
    L16:
        if (r2 == false) goto L18;
        return 999;
    L18:
        if (r3 == false) goto L21;
        if (r4 == false) goto L21;
        return 999;
    L21:
        if (r3 == false) goto L24;
        return -1;
    L24:
        if (r4 == false) goto L26;
        return 1;
    L26:
        return 0;
    }

    public static BigTimeDurationValueType fromMinutes(int r0) {
        return fromMinutes(g.a(r0));
    }

    public static BigTimeDurationValueType fromMinutes(BigInteger r9) {
        return new BigTimeDurationValueType(r9.signum(), null, null, null, null, r9.abs(), null);
    }

    private int getSignum(BigDecimal r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.signum();
    }

    private int getSignum(BigInteger r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.signum();
    }

    private static boolean isDigit(char r1) {
        if ('0' <= r1) goto L5;
    L7:
        return false;
    L5:
        if (r1 > '9') goto L7;
        return true;
    }

    private static boolean isDigitOrPeriod(char r1) {
        if (isDigit(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1 == '.') goto L8;
        return false;
    }

    private BigInteger nullAsZero(BigInteger r1) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return BigInteger.ZERO;
    }

    private static void organizeParts(String r5, String[] r6, int[] r7, int r8, String r9) {
        int r0 = r9.length();
        int r10 = r8 - 1;
    L4:
        if (r10 < 0) goto L13;
        int r3 = r9.lastIndexOf(r6[r10].charAt(r6[r10].length() - 1), r0 - 1);
        if (r3 == (-1)) goto L12;
        int r2 = r3 + 1;
    L8:
        if (r2 >= r0) goto L10;
        r6[r2] = null;
        r2 = r2 + 1;
        goto L8
    L10:
        r6[r3] = r6[r10];
        r7[r3] = r7[r10];
        r10 = r10 - 1;
        r0 = r3;
        goto L4
    L12:
        throw new IllegalArgumentException(r5);
    L13:
        int r1 = r0 - 1;
    L14:
        if (r1 < 0) goto L16;
        r6[r1] = null;
        r1 = r1 - 1;
        goto L14
    }

    private static BigDecimal parseBigDecimal(String r0, String r1, int r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new BigDecimal(r1.substring(0, r1.length() - 1));
    }

    private static BigInteger parseBigInteger(String r0, String r1, int r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new BigInteger(r1.substring(0, r1.length() - 1));
    }

    private static String parsePiece(String r4, int[] r5) {
        int r1 = r5[0];
    L4:
        if (r5[0] >= r4.length()) goto L9;
        if (isDigitOrPeriod(r4.charAt(r5[0])) == false) goto L9;
        r5[0] = r5[0] + 1;
    L9:
        if (r5[0] == r4.length()) goto L13;
        r5[0] = r5[0] + 1;
        return r4.substring(r1, r5[0]);
    L13:
        throw new IllegalArgumentException(r4);
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        int r4 = this.year.signum();
        if (r4 != (-1)) goto L5;
        this.signum = -1;
        this.year = this.year.negate();
        return;
    L5:
        if (r4 == 1) goto L43;
        int r5 = this.month.signum();
        if (r5 == (-1)) goto L41;
        if (r5 == 1) goto L39;
        int r6 = this.day.signum();
        if (r6 == (-1)) goto L37;
        if (r6 == 1) goto L35;
        int r7 = this.hour.signum();
        if (r7 == (-1)) goto L33;
        if (r7 == 1) goto L31;
        int r8 = this.minute.signum();
        if (r8 == (-1)) goto L29;
        if (r8 == 1) goto L27;
        int r9 = this.second.signum();
        if (r9 == (-1)) goto L25;
        if (r9 == 1) goto L23;
        this.signum = 0;
        return;
    L23:
        this.signum = 1;
        return;
    L25:
        this.signum = -1;
        this.second = this.second.negate();
        return;
    L27:
        this.signum = 1;
        return;
    L29:
        this.signum = -1;
        this.minute = this.minute.negate();
        return;
    L31:
        this.signum = 1;
        return;
    L33:
        this.signum = -1;
        this.hour = this.hour.negate();
        return;
    L35:
        this.signum = 1;
        return;
    L37:
        this.signum = -1;
        this.day = this.day.negate();
        return;
    L39:
        this.signum = 1;
        return;
    L41:
        this.signum = -1;
        this.month = this.month.negate();
        return;
    L43:
        this.signum = 1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.ITimeDurationValueType
    public int compare(ITimeDurationValueType r4) {
        ITimeDurationValueType r5 = (ITimeDurationValueType) ZeusTransformUtils.wrapperContextForParams(r4, ITimeDurationValueType.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, BigTimeDurationValueType.class) == true) goto L6;
        r5 = r5.getBigValue();
    L6:
        return compare(this, (BigTimeDurationValueType) ZeusTransformUtils.preCheckCast(r5, BigTimeDurationValueType.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(ITimeDurationValueType r3) {
        if (compare((ITimeDurationValueType) ZeusTransformUtils.wrapperContextForParams(r3, ITimeDurationValueType.class, "com.obric.memorydata.plugin")) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r3) {
        return equals((ITimeDurationValueType) ZeusTransformUtils.preCheckCast(r3, ITimeDurationValueType.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.ITimeDurationValueType
    public BigTimeDurationValueType getBigValue() {
        return this;
    }

    public BigInteger getDay() {
        return this.day;
    }

    public BigInteger getHour() {
        return this.hour;
    }

    public BigInteger getMinute() {
        return this.minute;
    }

    public BigInteger getMonth() {
        return this.month;
    }

    public BigDecimal getSecond() {
        return this.second;
    }

    public BigInteger getYear() {
        return this.year;
    }

    public int hashCode() {
        return nullAsZero(this.day).multiply(g.d).add(nullAsZero(this.hour)).multiply(g.e).add(nullAsZero(this.minute)).mod(g.h).hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        String r2 = "";
        if (this.signum >= 0) goto L5;
        String r1 = "-";
    L6:
        StringBuilder r3 = r0.append(r1).append(i.m).append(nullAsZero(this.year).abs()).append("Y").append(nullAsZero(this.month)).append("M").append(nullAsZero(this.day)).append("DT").append(nullAsZero(this.hour)).append(i.n).append(nullAsZero(this.minute)).append("M");
        BigDecimal r4 = this.second;
        if (r4 == null) goto L11;
        r2 = r4.toString();
    L11:
        return r3.append(r2).append("S").toString();
    L5:
        r1 = "";
        goto L6
    }
}
