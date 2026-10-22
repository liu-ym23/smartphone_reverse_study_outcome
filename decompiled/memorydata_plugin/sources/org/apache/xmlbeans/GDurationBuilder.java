package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes7.dex */
public class GDurationBuilder implements Serializable, GDurationSpecification {
    private static final GDate[] _compDate = null;
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _sign;

    static {
        _compDate = new GDate[]{new GDate(1696, 9, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1697, 2, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1903, 3, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1903, 7, 1, 0, 0, 0, null, 0, 0, 0)};
    }

    public GDurationBuilder() {
        this._sign = 1;
        this._fs = GDate._zero;
    }

    public GDurationBuilder(int r2, int r3, int r4, int r5, int r6, int r7, int r8, BigDecimal r9) {
        if (r2 != 1) goto L5;
    L9:
        this._sign = r2;
        this._CY = r3;
        this._M = r4;
        this._D = r5;
        this._h = r6;
        this._m = r7;
        this._s = r8;
        if (r9 != null) goto L12;
        r9 = GDate._zero;
    L12:
        this._fs = r9;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        throw new IllegalArgumentException();
    }

    public GDurationBuilder(String r2) {
        this(new GDuration(r2));
    }

    public GDurationBuilder(GDurationSpecification r3) {
        GDurationSpecification r4 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin");
        this._sign = r4.getSign();
        this._CY = r4.getYear();
        this._M = r4.getMonth();
        this._D = r4.getDay();
        this._h = r4.getHour();
        this._m = r4.getMinute();
        this._s = r4.getSecond();
        this._fs = r4.getFraction();
    }

    private void _add(GDurationSpecification r3, int r4) {
        GDurationSpecification r5 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin");
        this._CY += r5.getYear() * r4;
        this._M += r5.getMonth() * r4;
        this._D += r5.getDay() * r4;
        this._h += r5.getHour() * r4;
        this._m += r5.getMinute() * r4;
        this._s += r5.getSecond() * r4;
        if (r5.getFraction().signum() != 0) goto L6;
        return;
    L6:
        if (this._fs.signum() == 0) goto L8;
    L11:
        if (r4 <= 0) goto L13;
        BigDecimal r6 = this._fs.add(r5.getFraction());
    L10:
        this._fs = r6;
        return;
    L13:
        r6 = this._fs.subtract(r5.getFraction());
        goto L10
    L8:
        if (r4 != 1) goto L11;
        r6 = r5.getFraction();
        goto L10
    }

    private static long _fQuotient(long r4, int r6) {
        boolean r1 = true;
        if (r4 >= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r6 < 0) goto L9;
        r1 = false;
    L9:
        if (r0 == r1) goto L11;
        long r2 = r6;
        return -(((r2 - r4) - 1) / r2);
    L11:
        return r4 / ((long) r6);
    L5:
        r0 = false;
        goto L6
    }

    private int _getTotalSignSlowly() {
        GDateBuilder r0 = new GDateBuilder();
        GDate[] r1 = _compDate;
        int r2 = r1.length;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L4:
        if (r4 >= r2) goto L14;
        GDate r10 = r1[r4];
        r0.setGDate(r10);
        r0.addGDuration(this);
        int r11 = r0.compareToGDate(r10);
        if (r11 == (-1)) goto L12;
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L13;
        r5 = r5 + 1;
    L13:
        r4 = r4 + 1;
        goto L4
    L11:
        r7 = r7 + 1;
        goto L13
    L12:
        r6 = r6 + 1;
        goto L13
    L14:
        GDate[] r12 = _compDate;
        if (r5 != r12.length) goto L18;
        return 1;
    L18:
        if (r6 != r12.length) goto L21;
        return -1;
    L21:
        if (r7 != r12.length) goto L23;
        return 0;
    L23:
        return 2;
    }

    private static int _mod(long r2, int r4, long r5) {
        return (int) (r2 - (r5 * ((long) r4)));
    }

    private void _normalizeImpl(boolean r7) {
        int r0 = this._M;
        if (r0 >= 0) goto L5;
    L6:
        long r1 = r0;
        long r3 = _fQuotient(r1, 12);
        this._M = _mod(r1, 12, r3);
        this._CY = Math.addExact(this._CY, Math.toIntExact(r3));
    L7:
        BigDecimal r2 = this._fs;
        if (r2 != null) goto L10;
    L14:
        long r4 = 0;
    L16:
        if (r4 != 0) goto L29;
        int r5 = this._s;
        if (r5 < 0) goto L29;
        if (r5 > 59) goto L29;
        int r6 = this._m;
        if (r6 < 0) goto L29;
        if (r6 > 50) goto L29;
        int r8 = this._h;
        if (r8 < 0) goto L29;
        if (r8 > 23) goto L29;
    L30:
        int r9 = 1;
        if (this._CY == 0) goto L33;
    L47:
        if (r7 == false) goto L76;
        int r10 = this._D;
        if (r10 >= 0) goto L51;
    L52:
        if (r10 > 0) goto L59;
        int r11 = this._CY;
        if (r11 < 0) goto L58;
        if (r11 != 0) goto L59;
        if (this._M != 0) goto L59;
    L58:
        int r12 = -this._sign;
    L61:
        if (r12 == 2) goto L63;
    L66:
        if (r12 == 0) goto L70;
        r9 = r12;
    L70:
        if (r9 == this._sign) goto L74;
        this._sign = r9;
        this._CY = -this._CY;
        this._M = -this._M;
        this._D = -this._D;
        this._h = -this._h;
        this._m = -this._m;
        this._s = -this._s;
        BigDecimal r13 = this._fs;
        if (r13 == null) goto L74;
        this._fs = r13.negate();
    L74:
        _normalizeImpl(false);
        return;
    L63:
        if (this._CY >= 0) goto L65;
        r12 = -this._sign;
        goto L66
    L65:
        r12 = this._sign;
    L59:
        r12 = _getTotalSignSlowly();
        goto L61
    L51:
        if (this._CY < 0) goto L52;
        return;
    L76:
        return;
    L33:
        if (this._M != 0) goto L47;
        if (this._D != 0) goto L47;
        if (this._h != 0) goto L47;
        if (this._m != 0) goto L47;
        if (this._s != 0) goto L47;
        BigDecimal r14 = this._fs;
        if (r14 != null) goto L45;
    L46:
        this._sign = 1;
        goto L47
    L45:
        if (r14.signum() != 0) goto L47;
    L29:
        long r15 = ((long) this._s) + r4;
        long r16 = _fQuotient(r15, 60);
        this._s = _mod(r15, 60, r16);
        long r17 = ((long) this._m) + r16;
        long r18 = _fQuotient(r17, 60);
        this._m = _mod(r17, 60, r18);
        long r19 = ((long) this._h) + r18;
        long r20 = _fQuotient(r19, 24);
        this._h = _mod(r19, 24, r20);
        this._D = Math.addExact(this._D, Math.toIntExact(r20));
        goto L30
    L10:
        if (r2.signum() >= 0) goto L12;
    L13:
        BigDecimal r21 = this._fs.setScale(0, RoundingMode.FLOOR);
        this._fs = this._fs.subtract(r21);
        r4 = r21.intValue();
        goto L16
    L12:
        if (this._fs.compareTo(GDate._one) < 0) goto L14;
    L5:
        if (r0 <= 11) goto L7;
        goto L6
    }

    static int compareDurations(GDurationSpecification r16, GDurationSpecification r17) {
        GDurationSpecification r0 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r16, GDurationSpecification.class, "com.obric.memorydata.plugin");
        GDurationSpecification r1 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r17, GDurationSpecification.class, "com.obric.memorydata.plugin");
        if (r0.getFraction().signum() == 0) goto L5;
    L24:
        GDurationBuilder r2 = new GDurationBuilder(r0);
        r2.subtractGDuration(r1);
        return r2._getTotalSignSlowly();
    L5:
        if (r1.getFraction().signum() != 0) goto L24;
        int r3 = r0.getSign();
        int r4 = r1.getSign();
        long r5 = r3;
        long r6 = ((((long) r0.getYear()) * 12) + ((long) r0.getMonth())) * r5;
        long r7 = r4;
        long r10 = ((((long) r1.getYear()) * 12) + ((long) r1.getMonth())) * r7;
        long r8 = r5 * ((((((((long) r0.getDay()) * 24) + ((long) r0.getHour())) * 60) + ((long) r0.getMinute())) * 60) + ((long) r0.getSecond()));
        long r9 = r7 * ((((((((long) r1.getDay()) * 24) + ((long) r1.getHour())) * 60) + ((long) r1.getMinute())) * 60) + ((long) r1.getSecond()));
        if (r6 != r10) goto L16;
        if (r8 != r9) goto L12;
        return 0;
    L12:
        if (r8 < r9) goto L14;
        return 1;
    L14:
        return -1;
    L16:
        if (r6 < r10) goto L18;
    L20:
        if (r6 <= r10) goto L24;
        if ((r9 - r8) >= 2419200) goto L24;
        return 1;
    L18:
        if ((r8 - r9) >= 2419200) goto L20;
        return -1;
    }

    static String formatDuration(GDurationSpecification r5) {
        GDurationSpecification r6 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r5, GDurationSpecification.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder(30);
        if (r6.getSign() >= 0) goto L5;
        r0.append('-');
    L5:
        r0.append('P');
        if (r6.getYear() == 0) goto L9;
        r0.append(r6.getYear());
        r0.append('Y');
    L9:
        if (r6.getMonth() == 0) goto L12;
        r0.append(r6.getMonth());
        r0.append('M');
    L12:
        if (r6.getDay() == 0) goto L15;
        r0.append(r6.getDay());
        r0.append('D');
    L15:
        if (r6.getHour() == 0) goto L17;
    L22:
        r0.append('T');
    L24:
        if (r6.getHour() == 0) goto L27;
        r0.append(r6.getHour());
        r0.append('H');
    L27:
        if (r6.getMinute() == 0) goto L30;
        r0.append(r6.getMinute());
        r0.append('M');
    L30:
        if (r6.getFraction().signum() == 0) goto L36;
        BigDecimal r1 = r6.getFraction();
        if (r6.getSecond() == 0) goto L34;
        r1 = r1.add(BigDecimal.valueOf(r6.getSecond()));
    L34:
        r0.append(stripTrailingZeros(toPlainString(r1)));
    L38:
        r0.append('S');
    L43:
        return r0.toString();
    L36:
        if (r6.getSecond() == 0) goto L40;
        r0.append(r6.getSecond());
        goto L38
    L40:
        if (r0.length() > 2) goto L43;
        r0.append("T0S");
        goto L43
    L17:
        if (r6.getMinute() != 0) goto L22;
        if (r6.getSecond() != 0) goto L22;
        if (r6.getFraction().signum() == 0) goto L24;
        goto L22
    }

    static boolean isValidDuration(GDurationSpecification r4) {
        GDurationSpecification r5 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r4, GDurationSpecification.class, "com.obric.memorydata.plugin");
        if (r5.getSign() == 1) goto L8;
        if (r5.getSign() == (-1)) goto L8;
        return false;
    L8:
        if (r5.getYear() >= 0) goto L10;
        return false;
    L10:
        if (r5.getMonth() >= 0) goto L12;
        return false;
    L12:
        if (r5.getDay() >= 0) goto L14;
        return false;
    L14:
        if (r5.getHour() >= 0) goto L16;
        return false;
    L16:
        if (r5.getMinute() >= 0) goto L18;
        return false;
    L18:
        if (r5.getSecond() >= 0) goto L20;
        return false;
    L20:
        if (r5.getFraction().signum() >= 0) goto L22;
        return false;
    L22:
        return true;
    }

    public static String stripTrailingZeros(String r6) {
        int r0 = r6.length() - 1;
        int r2 = r0;
    L3:
        if (r0 < 0) goto L9;
        if (r6.charAt(r0) != '0') goto L9;
        r0 = r0 - 1;
        r2 = r2 - 1;
    L9:
        if (r0 < 0) goto L17;
        if (r6.charAt(r0) == 'E') goto L12;
        if (r6.charAt(r0) == '.') goto L15;
        r0 = r0 - 1;
        goto L9
    L15:
        boolean r1 = true;
    L18:
        if (r1 == true) goto L20;
        return r6;
    L20:
        return r6.substring(0, r2 + 1);
    L12:
        return r6;
    L17:
        r1 = false;
        goto L18
    }

    public static String toPlainString(BigDecimal r8) {
        BigInteger r0 = r8.unscaledValue();
        int r9 = r8.scale();
        String r1 = r0.toString();
        if (r9 != 0) goto L5;
        return r1;
    L5:
        int r2 = 0;
        if (r1.charAt(0) != '-') goto L8;
        int r3 = 1;
    L9:
        int r6 = (r1.length() - r9) - r3;
        int r7 = r1.length() + 2;
        if (r6 > 0) goto L12;
        r2 = (-r6) + 1;
    L12:
        StringBuilder r10 = new StringBuilder(r7 + r2);
        if (r6 > 0) goto L20;
        if (r3 == 0) goto L16;
        r10.append('-');
    L16:
        r10.append('0').append('.');
    L17:
        if (r6 >= 0) goto L19;
        r10.append('0');
        r6 = r6 + 1;
        goto L17
    L19:
        r10.append(r1.substring(r3));
    L29:
        return r10.toString();
    L20:
        int r4 = r1.length();
        r10.append(r1);
        if (r6 >= r4) goto L24;
        r10.insert(r6 + r3, '.');
        goto L29
    L24:
        if (r0.equals(BigInteger.ZERO) == true) goto L29;
        int r5 = r1.length();
    L26:
        if (r5 >= r6) goto L29;
        r10.append('0');
        r5 = r5 + 1;
        goto L26
    L8:
        r3 = 0;
        goto L9
    }

    public void addGDuration(GDurationSpecification r3) {
        GDurationSpecification r4 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin");
        _add(r4, this._sign * r4.getSign());
    }

    public Object clone() {
        return new GDurationBuilder(this);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int compareToGDuration(GDurationSpecification r3) {
        return compareDurations(this, (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getDay() {
        return this._D;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public BigDecimal getFraction() {
        return this._fs;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getHour() {
        return this._h;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getMinute() {
        return this._m;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getMonth() {
        return this._M;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getSecond() {
        return this._s;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getSign() {
        return this._sign;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getYear() {
        return this._CY;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final boolean isImmutable() {
        return true;
    }

    public boolean isValid() {
        return isValidDuration(this);
    }

    public void normalize() {
        _normalizeImpl(true);
    }

    public void setDay(int r1) {
        this._D = r1;
    }

    public void setFraction(BigDecimal r1) {
        if (r1 != null) goto L4;
        r1 = GDate._zero;
    L4:
        this._fs = r1;
    }

    public void setHour(int r1) {
        this._h = r1;
    }

    public void setMinute(int r1) {
        this._m = r1;
    }

    public void setMonth(int r1) {
        this._M = r1;
    }

    public void setSecond(int r1) {
        this._s = r1;
    }

    public final void setSign(int r2) {
        if (r2 != 1) goto L5;
    L9:
        this._sign = r2;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        throw new IllegalArgumentException();
    }

    public void setYear(int r1) {
        this._CY = r1;
    }

    public void subtractGDuration(GDurationSpecification r3) {
        GDurationSpecification r4 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin");
        _add(r4, (-this._sign) * r4.getSign());
    }

    public GDuration toGDuration() {
        return new GDuration(this);
    }

    public String toString() {
        return formatDuration(this);
    }
}
