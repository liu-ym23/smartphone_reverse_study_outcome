package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes2.dex */
public class BigDateTimeValueType implements IDateTimeValueType {
    private static final long serialVersionUID = 1;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private Integer month;
    private IDateTimeValueType normalizedValue;
    private BigDecimal second;
    private BigInteger year;
    private java.util.TimeZone zone;

    public BigDateTimeValueType() {
        this.normalizedValue = null;
    }

    public BigDateTimeValueType(BigDateTimeValueType r9, java.util.TimeZone r10) {
        this(r9.year, r9.month, r9.day, r9.hour, r9.minute, r9.second, r10);
    }

    public BigDateTimeValueType(BigInteger r9, int r10, int r11, int r12, int r13, BigDecimal r14, java.util.TimeZone r15) {
        this(r9, new Integer(r10), new Integer(r11), new Integer(r12), new Integer(r13), r14, r15);
    }

    public BigDateTimeValueType(BigInteger r2, Integer r3, Integer r4, Integer r5, Integer r6, BigDecimal r7, java.util.TimeZone r8) {
        this.normalizedValue = null;
        this.year = r2;
        this.month = r3;
        this.day = r4;
        this.hour = r5;
        this.minute = r6;
        this.second = r7;
        this.zone = r8;
    }

    public static int compare(BigDateTimeValueType r7, BigDateTimeValueType r8) {
        BigDateTimeValueType r9 = (BigDateTimeValueType) ZeusTransformUtils.preCheckCast(r7.normalize(), BigDateTimeValueType.class, "com.obric.memorydata.plugin");
        BigDateTimeValueType r10 = (BigDateTimeValueType) ZeusTransformUtils.preCheckCast(r8.normalize(), BigDateTimeValueType.class, "com.obric.memorydata.plugin");
        java.util.TimeZone r2 = r9.zone;
        if (r2 != null) goto L5;
    L6:
        if (r2 != null) goto L32;
        if (r10.zone != null) goto L32;
    L10:
        if (g.a(r9.year, r10.year) == true) goto L15;
        Comparable r11 = r9.year;
        Comparable r12 = r10.year;
    L13:
        return g.a(r11, r12);
    L15:
        if (g.a(r9.month, r10.month) == true) goto L18;
        r11 = r9.month;
        r12 = r10.month;
        goto L13
    L18:
        if (g.a(r9.day, r10.day) == true) goto L21;
        r11 = r9.day;
        r12 = r10.day;
        goto L13
    L21:
        if (g.a(r9.hour, r10.hour) == true) goto L24;
        r11 = r9.hour;
        r12 = r10.hour;
        goto L13
    L24:
        if (g.a(r9.minute, r10.minute) == true) goto L27;
        r11 = r9.minute;
        r12 = r10.minute;
        goto L13
    L27:
        if (g.a(r9.second, r10.second) == true) goto L29;
        r11 = r9.second;
        r12 = r10.second;
        goto L13
    L29:
        return 0;
    L32:
        if (r2 != null) goto L44;
        int r3 = compare((BigDateTimeValueType) ZeusTransformUtils.preCheckCast(new BigDateTimeValueType(r9, g.l).normalize(), BigDateTimeValueType.class, "com.obric.memorydata.plugin"), r10);
        if (r3 == 0) goto L43;
        if (r3 == (-1)) goto L43;
        int r13 = compare((BigDateTimeValueType) ZeusTransformUtils.preCheckCast(new BigDateTimeValueType(r9, g.k).normalize(), BigDateTimeValueType.class, "com.obric.memorydata.plugin"), r10);
        if (r13 == 0) goto L42;
        if (r13 == 1) goto L42;
        return 999;
    L42:
        return 1;
    L43:
        return -1;
    L44:
        int r0 = compare(r9, new BigDateTimeValueType(r10, g.k));
        if (r0 == 0) goto L54;
        if (r0 == (-1)) goto L54;
        int r14 = compare(r9, new BigDateTimeValueType(r10, g.l));
        if (r14 == 0) goto L53;
        if (r14 == 1) goto L53;
        return 999;
    L53:
        return 1;
    L54:
        return -1;
    L5:
        if (r10.zone != null) goto L10;
        goto L6
    }

    private static BigInteger[] divideAndRemainder(BigInteger r2, BigInteger r3) {
        BigInteger[] r4 = r2.divideAndRemainder(r3);
        if (r4[1].signum() >= 0) goto L5;
        r4[1] = r4[1].add(r3);
        r4[0] = r4[0].subtract(BigInteger.ONE);
    L5:
        return r4;
    }

    private static BigDecimal nullAs0(BigDecimal r0) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        return g.i;
    }

    private static BigInteger nullAs0(BigInteger r0) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        return BigInteger.ZERO;
    }

    private BigDecimal signed(BigTimeDurationValueType r1, BigDecimal r2) {
        if (r1.signum < 0) goto L5;
        return r2;
    L5:
        return r2.negate();
    }

    private BigInteger signed(BigTimeDurationValueType r1, BigInteger r2) {
        if (r1.signum < 0) goto L5;
        return r2;
    L5:
        return r2.negate();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.IDateTimeValueType
    public IDateTimeValueType add(ITimeDurationValueType r19) {
        ITimeDurationValueType r1 = (ITimeDurationValueType) ZeusTransformUtils.wrapperContextForParams(r19, ITimeDurationValueType.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, BigTimeDurationValueType.class) == false) goto L50;
        BigTimeDurationValueType r2 = (BigTimeDurationValueType) ZeusTransformUtils.preCheckCast(r1, BigTimeDurationValueType.class, "com.obric.memorydata.plugin");
        BigInteger[] r3 = divideAndRemainder(g.a(this.month).add(signed(r2, r2.month)), g.c);
        int r4 = r3[1].intValue();
        BigInteger r5 = r3[0].add(nullAs0(this.year)).add(signed(r2, r2.year));
        BigDecimal r6 = nullAs0(this.second).add(signed(r2, r2.second));
        BigInteger[] r7 = divideAndRemainder(r6.unscaledValue(), g.e.multiply(g.f3581b.pow(r6.scale())));
        BigDecimal r8 = new BigDecimal(r7[1], r6.scale());
        BigInteger[] r9 = divideAndRemainder(r7[0].add(g.a(this.minute)).add(signed(r2, r2.minute)), g.e);
        int r10 = r9[1].intValue();
        BigInteger[] r11 = divideAndRemainder(r9[0].add(g.a(this.hour)).add(signed(r2, r2.hour)), g.d);
        int r12 = r11[1].intValue();
        int r13 = g.a(r5, r4);
        Integer r14 = this.day;
        if (r14 == null) goto L7;
        int r15 = r14.intValue();
    L8:
        if (r15 >= 0) goto L10;
        r15 = 0;
    L12:
        BigInteger r16 = signed(r2, r2.day).add(r11[0]).add(g.a(r15));
    L13:
        int r17 = -1;
        if (r16.signum() != (-1)) goto L16;
        r16 = r16.add(g.a(g.a(r5, (r4 + 11) % 12)));
    L19:
        int r18 = r4 + r17;
        if (r18 >= 0) goto L22;
        r18 = r18 + 12;
        r5 = r5.subtract(BigInteger.ONE);
    L22:
        r5 = r5.add(g.a(r18 / 12));
        r4 = r18 % 12;
        goto L13
    L16:
        BigInteger r20 = g.a(g.a(r5, r4));
        if (r16.compareTo(r20) < 0) goto L24;
        r16 = r16.subtract(r20);
        r17 = 1;
        goto L19
    L24:
        if (this.year == null) goto L26;
        BigInteger r110 = r5;
    L28:
        if (this.month == null) goto L30;
        Integer r111 = new Integer(r4);
    L32:
        if (this.day == null) goto L34;
        Integer r112 = new Integer(r16.intValue());
    L36:
        if (this.hour == null) goto L38;
        Integer r113 = new Integer(r12);
    L40:
        if (this.minute == null) goto L42;
        Integer r114 = new Integer(r10);
    L44:
        if (this.second == null) goto L46;
        BigDecimal r115 = r8;
    L48:
        return new BigDateTimeValueType(r110, r111, r112, r113, r114, r115, this.zone);
    L46:
        r115 = null;
        goto L48
    L42:
        r114 = null;
        goto L44
    L38:
        r113 = null;
        goto L40
    L34:
        r112 = null;
        goto L36
    L30:
        r111 = null;
        goto L32
    L26:
        r110 = null;
        goto L28
    L10:
        if (r15 < r13) goto L12;
        r15 = r13 - 1;
        goto L12
    L7:
        r15 = 0;
        goto L8
    L50:
        return add(r1.getBigValue());
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.IDateTimeValueType
    public int compare(IDateTimeValueType r4) {
        IDateTimeValueType r5 = (IDateTimeValueType) ZeusTransformUtils.wrapperContextForParams(r4, IDateTimeValueType.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, BigDateTimeValueType.class) == true) goto L6;
        r5 = r5.getBigValue();
    L6:
        return compare(this, (BigDateTimeValueType) ZeusTransformUtils.preCheckCast(r5, BigDateTimeValueType.class, "com.obric.memorydata.plugin"));
    }

    public java.util.TimeZone createJavaTimeZone() {
        java.util.TimeZone r0 = getTimeZone();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return TimeZone.MISSING;
    }

    public boolean equals(BigDateTimeValueType r1, BigDateTimeValueType r2) {
        if (compare(r1, r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(IDateTimeValueType r4) {
        IDateTimeValueType r5 = (IDateTimeValueType) ZeusTransformUtils.wrapperContextForParams(r4, IDateTimeValueType.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, BigDateTimeValueType.class) == true) goto L6;
        r5 = r5.getBigValue();
    L6:
        return equals(this, (BigDateTimeValueType) ZeusTransformUtils.preCheckCast(r5, BigDateTimeValueType.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r3) {
        return equals((IDateTimeValueType) ZeusTransformUtils.preCheckCast(r3, IDateTimeValueType.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.IDateTimeValueType
    public BigDateTimeValueType getBigValue() {
        return this;
    }

    public Integer getDay() {
        return this.day;
    }

    public Integer getHour() {
        return this.hour;
    }

    public Integer getMinute() {
        return this.minute;
    }

    public Integer getMonth() {
        return this.month;
    }

    public BigDecimal getSecond() {
        return this.second;
    }

    public java.util.TimeZone getTimeZone() {
        return this.zone;
    }

    public BigInteger getYear() {
        return this.year;
    }

    public int hashCode() {
        BigDateTimeValueType r2 = (BigDateTimeValueType) ZeusTransformUtils.preCheckCast(normalize(), BigDateTimeValueType.class, "com.obric.memorydata.plugin");
        return (((((g.a(r2.year) + g.a(r2.month)) + g.a(r2.day)) + g.a(r2.hour)) + g.a(r2.minute)) + g.a(r2.second)) + g.a(r2.zone);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.IDateTimeValueType
    public IDateTimeValueType normalize() {
        if (this.zone == TimeZone.ZERO) goto L12;
        java.util.TimeZone r0 = this.zone;
        if (r0 == null) goto L13;
        IDateTimeValueType r1 = this.normalizedValue;
        if (r1 == null) goto L10;
        return r1;
    L10:
        IDateTimeValueType r2 = add(BigTimeDurationValueType.fromMinutes((-r0.getRawOffset()) / 60000));
        this.normalizedValue = r2;
        BigDateTimeValueType r3 = (BigDateTimeValueType) ZeusTransformUtils.preCheckCast(r2, BigDateTimeValueType.class, "com.obric.memorydata.plugin");
        r3.zone = TimeZone.ZERO;
        return this.normalizedValue;
    L13:
        return this;
    L12:
        return this;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.IDateTimeValueType
    public Calendar toCalendar() {
        GregorianCalendar r0 = new GregorianCalendar(0, 0, 0);
        r0.setTimeZone(createJavaTimeZone());
        r0.clear(1);
        r0.clear(2);
        r0.clear(5);
        if (getYear() == null) goto L6;
        r0.set(1, getYear().intValue());
    L6:
        if (getMonth() == null) goto L9;
        r0.set(2, getMonth().intValue());
    L9:
        if (getDay() == null) goto L12;
        r0.set(5, getDay().intValue() + 1);
    L12:
        if (getHour() == null) goto L15;
        r0.set(11, getHour().intValue());
    L15:
        if (getMinute() == null) goto L18;
        r0.set(12, getMinute().intValue());
    L18:
        if (getSecond() == null) goto L20;
        r0.set(13, getSecond().intValue());
        r0.set(14, getSecond().movePointRight(3).intValue() % 1000);
    L20:
        return r0;
    }

    public String toString() {
        return e.a("%Y-%M-%DT%h:%m:%s%z", this);
    }
}
