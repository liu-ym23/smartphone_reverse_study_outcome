package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes7.dex */
public final class GDate implements Serializable, GDateSpecification {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final TimeZone GMTZONE = null;
    static final int MAX_YEAR = 292277265;
    private static final TimeZone[] MINUSZONE = null;
    static final int MIN_YEAR = -292275295;
    private static final TimeZone[] PLUSZONE = null;
    static final BigDecimal _one = null;
    private static final char[] _onesDigit = null;
    private static final char[] _tensDigit = null;
    static final BigDecimal _zero = null;
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private int _bits;
    private transient String _canonicalString;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private transient String _string;
    private int _tzh;
    private int _tzm;
    private int _tzsign;

    static {
        _zero = BigDecimal.ZERO;
        _one = BigDecimal.ONE;
        _tensDigit = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        _onesDigit = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        GMTZONE = TimeZone.getTimeZone("GMT");
        MINUSZONE = new TimeZone[]{TimeZone.getTimeZone("GMT-00:00"), TimeZone.getTimeZone("GMT-01:00"), TimeZone.getTimeZone("GMT-02:00"), TimeZone.getTimeZone("GMT-03:00"), TimeZone.getTimeZone("GMT-04:00"), TimeZone.getTimeZone("GMT-05:00"), TimeZone.getTimeZone("GMT-06:00"), TimeZone.getTimeZone("GMT-07:00"), TimeZone.getTimeZone("GMT-08:00"), TimeZone.getTimeZone("GMT-09:00"), TimeZone.getTimeZone("GMT-10:00"), TimeZone.getTimeZone("GMT-11:00"), TimeZone.getTimeZone("GMT-12:00"), TimeZone.getTimeZone("GMT-13:00"), TimeZone.getTimeZone("GMT-14:00")};
        PLUSZONE = new TimeZone[]{TimeZone.getTimeZone("GMT+00:00"), TimeZone.getTimeZone("GMT+01:00"), TimeZone.getTimeZone("GMT+02:00"), TimeZone.getTimeZone("GMT+03:00"), TimeZone.getTimeZone("GMT+04:00"), TimeZone.getTimeZone("GMT+05:00"), TimeZone.getTimeZone("GMT+06:00"), TimeZone.getTimeZone("GMT+07:00"), TimeZone.getTimeZone("GMT+08:00"), TimeZone.getTimeZone("GMT+09:00"), TimeZone.getTimeZone("GMT+10:00"), TimeZone.getTimeZone("GMT+11:00"), TimeZone.getTimeZone("GMT+12:00"), TimeZone.getTimeZone("GMT+13:00"), TimeZone.getTimeZone("GMT+14:00")};
    }

    public GDate(int r2, int r3, int r4, int r5, int r6, int r7, BigDecimal r8) {
        this._bits = 30;
        this._CY = r2;
        this._M = r3;
        this._D = r4;
        this._h = r5;
        this._m = r6;
        this._s = r7;
        if (r8 != null) goto L5;
        r8 = _zero;
    L5:
        this._fs = r8;
        if (isValid() == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException();
    }

    public GDate(int r2, int r3, int r4, int r5, int r6, int r7, BigDecimal r8, int r9, int r10, int r11) {
        this._bits = 31;
        this._CY = r2;
        this._M = r3;
        this._D = r4;
        this._h = r5;
        this._m = r6;
        this._s = r7;
        if (r8 != null) goto L5;
        r8 = _zero;
    L5:
        this._fs = r8;
        this._tzsign = r9;
        this._tzh = r10;
        this._tzm = r11;
        if (isValid() == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException();
    }

    public GDate(CharSequence r22) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        int r2 = r1.length();
    L3:
        if (r2 <= 0) goto L7;
        if (isSpace(r1.charAt(r2 - 1)) == false) goto L7;
        r2 = r2 - 1;
    L7:
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L12;
        if (isSpace(r1.charAt(r4)) == false) goto L12;
        r4 = r4 + 1;
    L12:
        int r5 = r2 - r4;
        if (r5 >= 1) goto L15;
    L17:
        if (r5 >= 6) goto L19;
    L36:
        if (r4 >= r2) goto L133;
        int r6 = r4 + 2;
        if (r6 >= r2) goto L42;
        if (r1.charAt(r6) == ':') goto L133;
    L42:
        if (r1.charAt(r4) != '-') goto L44;
        r4 = r4 + 1;
        boolean r7 = true;
    L45:
        int r10 = -r4;
        if (r4 < r2) goto L48;
    L50:
        boolean r11 = false;
    L51:
        int r12 = 0;
    L52:
        if (r4 >= r2) goto L54;
        char r13 = r1.charAt(r4);
    L56:
        if (isDigit(r13) == false) goto L57;
        if (r11 == false) goto L131;
        if ((r4 + r10) < 4) goto L131;
        throw new IllegalArgumentException("year value starting with zero must be 4 or less digits: " + r1);
    L131:
        r12 = (r12 * 10) + digitVal(r13);
        r4 = r4 + 1;
        goto L52
    L57:
        int r14 = r10 + r4;
        if (r14 > 9) goto L124;
        if (r14 < 4) goto L69;
        this._bits |= 2;
        if (r7 == false) goto L64;
        r12 = -r12;
    L64:
        this._CY = r12;
        if (r12 == 0) goto L68;
    L70:
        int r15 = this._CY;
        if (r15 > MAX_YEAR) goto L120;
        if (r15 < MIN_YEAR) goto L118;
        if (r13 == '-') goto L81;
        if (r7 == false) goto L133;
        if (hasYear() == true) goto L133;
        throw new IllegalArgumentException();
    L81:
        r4 = r4 + 1;
        if ((r2 - r4) < 2) goto L88;
        int r8 = twoDigit(r1, r4);
        if (r8 < 1) goto L88;
        if (r8 > 12) goto L88;
        this._bits |= 4;
        this._M = r8;
        r4 = r4 + 2;
    L88:
        if (r4 >= r2) goto L90;
        char r9 = r1.charAt(r4);
    L91:
        if (r9 != '-') goto L93;
        r4 = r4 + 1;
        if ((r2 - r4) < 2) goto L105;
        int r16 = twoDigit(r1, r4);
        if (r16 < 1) goto L105;
        if (r16 > 31) goto L105;
        this._bits |= 8;
        this._D = r16;
        r4 = r4 + 2;
    L105:
        if (hasDay() == true) goto L133;
        if (hasMonth() == false) goto L116;
        if (hasYear() == true) goto L116;
        if (r4 >= r2) goto L112;
        char r17 = r1.charAt(r4);
    L113:
        if (r17 != '-') goto L116;
        r4 = r4 + 1;
        goto L133
    L112:
        r17 = 0;
    L116:
        throw new IllegalArgumentException();
    L93:
        if (hasMonth() == true) goto L133;
        throw new IllegalArgumentException();
    L90:
        r9 = 0;
        goto L91
    L118:
        throw new IllegalArgumentException("year values not supported: too small, must be bigger than -292275295");
    L120:
        throw new IllegalArgumentException("year value not supported: too big, must be less than 292277265");
    L68:
        throw new IllegalArgumentException("year must not be zero");
    L69:
        if (r14 <= 0) goto L70;
        throw new IllegalArgumentException("year must be four digits (may pad with zeroes, e.g., 0560)");
    L124:
        throw new IllegalArgumentException("year too long (up to 9 digits)");
    L54:
        r13 = 0;
        goto L56
    L48:
        if (digitVal(r1.charAt(r4)) != 0) goto L50;
        r11 = true;
        goto L51
    L44:
        r7 = false;
    L133:
        if (r4 >= r2) goto L185;
        if (hasYear() == true) goto L141;
        if (hasMonth() == true) goto L141;
        if (hasDay() == true) goto L141;
    L143:
        int r18 = r4 + 8;
        if (r2 < r18) goto L181;
        if (r1.charAt(r4 + 2) != ':') goto L181;
        if (r1.charAt(r4 + 5) != ':') goto L181;
        int r19 = twoDigit(r1, r4);
        if (r19 > 24) goto L179;
        int r110 = twoDigit(r1, r4 + 3);
        if (r110 >= 60) goto L177;
        int r20 = twoDigit(r1, r4 + 6);
        if (r20 >= 60) goto L175;
        BigDecimal r21 = _zero;
        if (r18 < r2) goto L158;
    L173:
        this._bits |= 16;
        this._h = r19;
        this._m = r110;
        this._s = r20;
        this._fs = r21;
        goto L185
    L158:
        if (r1.charAt(r18) != '.') goto L172;
        int r111 = r18 + 1;
        if (r111 >= r2) goto L173;
    L161:
        if (r111 < r2) goto L163;
        r21 = new BigDecimal(r1.subSequence(r18, r2).toString());     // Catch: Throwable -> L169
    L170:
        throw new IllegalArgumentException();
    L163:
        if (isDigit(r1.charAt(r111)) == false) goto L166;
        r111 = r111 + 1;
        goto L161
    L166:
        throw new IllegalArgumentException();
    L172:
        throw new IllegalArgumentException();
    L175:
        throw new IllegalArgumentException("second must be between 00 and 59");
    L177:
        throw new IllegalArgumentException("minute must be between 00 and 59");
    L179:
        throw new IllegalArgumentException("hour must be between 00 and 23");
    L181:
        throw new IllegalArgumentException();
    L141:
        if (r1.charAt(r4) != 'T') goto L183;
        r4 = r4 + 1;
        goto L143
    L183:
        throw new IllegalArgumentException("date and time must be separated by 'T'");
    L185:
        if (hasTime() == false) goto L204;
        if (this._h != 24) goto L204;
        if (this._m != 0) goto L202;
        if (this._s != 0) goto L202;
        if (this._fs.compareTo(_zero) != 0) goto L202;
        if (hasDate() == false) goto L199;
        GDateBuilder r3 = new GDateBuilder(this._CY, this._M, this._D, this._h, this._m, this._s, this._fs, this._tzsign, this._tzh, this._tzm);
        r3.normalize24h();
        this._D = r3.getDay();
        this._M = r3.getMonth();
        this._CY = r3.getYear();
    L197:
        this._h = 0;
        goto L204
    L199:
        if (hasDay() == false) goto L204;
        this._D++;
    L202:
        throw new IllegalArgumentException("if hour is 24, minutes, seconds and fraction must be 0");
    L204:
        if (isValid() == false) goto L207;
        return;
    L207:
        throw new IllegalArgumentException("invalid date");
    L19:
        if (r1.charAt(r2 - 3) != ':') goto L36;
        char r23 = r1.charAt(r2 - 6);
        if (r23 == '+') goto L26;
        if (r23 != '-') goto L36;
        int r24 = -1;
    L27:
        int r112 = twoDigit(r1, r2 - 5);
        int r113 = twoDigit(r1, r2 - 2);
        if (r112 > 14) goto L35;
        if (r113 > 59) goto L33;
        this._bits |= 1;
        this._tzsign = r24;
        this._tzh = r112;
        this._tzm = r113;
        r2 = r2 - 6;
        goto L36
    L33:
        throw new IllegalArgumentException("time zone minute must be two digits between 00 and 59");
    L35:
        throw new IllegalArgumentException("time zone hour must be two digits between -14 and +14");
    L26:
        r24 = 1;
        goto L27
    L15:
        if (r1.charAt(r2 - 1) != 'Z') goto L17;
        this._bits |= 1;
        r2 = r2 - 1;
        goto L36
    }

    public GDate(Calendar r22) {
        int r2 = 1;
        boolean r3 = r22.isSet(1);
        boolean r5 = r22.isSet(0);
        boolean r7 = r22.isSet(2);
        boolean r9 = r22.isSet(5);
        boolean r11 = r22.isSet(11);
        boolean r13 = r22.isSet(10);
        boolean r15 = r22.isSet(9);
        boolean r16 = r22.isSet(12);
        boolean r17 = r22.isSet(13);
        boolean r18 = r22.isSet(14);
        boolean r19 = r22.isSet(15);
        boolean r20 = r22.isSet(16);
        if (r3 == false) goto L12;
        int r4 = r22.get(1);
        if (r5 == true) goto L7;
    L11:
        this._bits |= 2;
        this._CY = r4;
        goto L12
    L7:
        if (ZeusTransformUtils.instanceOf(r22, GregorianCalendar.class) == false) goto L11;
        if (r22.get(0) != 0) goto L11;
        r4 = -r4;
    L12:
        if (r7 == false) goto L14;
        this._bits |= 4;
        this._M = r22.get(2) + 1;
    L14:
        if (r9 == false) goto L16;
        this._bits |= 8;
        this._D = r22.get(5);
    L16:
        BigDecimal r6 = _zero;
        if (r11 == false) goto L19;
        int r8 = r22.get(11);
        boolean r10 = true;
        int r12 = 12;
    L23:
        if (r16 == false) goto L25;
        int r14 = r22.get(r12);
        r10 = true;
    L26:
        if (r17 == false) goto L28;
        int r21 = r22.get(13);
        r10 = true;
    L30:
        if (r18 == false) goto L32;
        r6 = BigDecimal.valueOf(r22.get(14), 3);
        r10 = true;
    L32:
        if (r10 == false) goto L34;
        this._bits |= 16;
        this._h = r8;
        this._m = r14;
        this._s = r21;
        this._fs = r6;
    L34:
        if (r19 == false) goto L55;
        int r23 = r22.get(15);
        if (r20 == false) goto L38;
        r23 = r23 + r22.get(16);
    L38:
        this._bits |= 1;
        if (r23 != 0) goto L51;
        this._tzsign = 0;
        this._tzh = 0;
        this._tzm = 0;
        String r1 = r22.getTimeZone().getID();
        if (r1 != null) goto L43;
        return;
    L43:
        if (r1.length() <= 3) goto L57;
        char r24 = r1.charAt(3);
        if (r24 != '+') goto L47;
        this._tzsign = 1;
        return;
    L47:
        if (r24 != '-') goto L60;
        this._tzsign = -1;
        return;
    L60:
        return;
    L57:
        return;
    L51:
        if (r23 >= 0) goto L53;
        r2 = -1;
    L53:
        this._tzsign = r2;
        int r25 = r23 * r2;
        int r26 = r25 / 3600000;
        this._tzh = r26;
        this._tzm = (r25 - (r26 * 3600000)) / 60000;
        return;
    L55:
        return;
    L28:
        r21 = 0;
        goto L30
    L25:
        r14 = 0;
        goto L26
    L19:
        if (r13 == false) goto L22;
        if (r15 == false) goto L22;
        r12 = 12;
        r8 = r22.get(10) + (r22.get(9) * 12);
        r10 = true;
    L22:
        r12 = 12;
        r8 = 0;
        r10 = false;
        goto L23
    }

    public GDate(Date r2) {
        this(new GDateBuilder(r2));
    }

    public GDate(GDateSpecification r3) {
        GDateSpecification r4 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDateSpecification.class, "com.obric.memorydata.plugin");
        if (r4.hasTimeZone() == false) goto L6;
        this._bits |= 1;
        this._tzsign = r4.getTimeZoneSign();
        this._tzh = r4.getTimeZoneHour();
        this._tzm = r4.getTimeZoneMinute();
    L6:
        if (r4.hasTime() == false) goto L9;
        this._bits |= 16;
        this._h = r4.getHour();
        this._m = r4.getMinute();
        this._s = r4.getSecond();
        this._fs = r4.getFraction();
    L9:
        if (r4.hasDay() == false) goto L12;
        this._bits |= 8;
        this._D = r4.getDay();
    L12:
        if (r4.hasMonth() == false) goto L15;
        this._bits |= 4;
        this._M = r4.getMonth();
    L15:
        if (r4.hasYear() == false) goto L18;
        this._bits |= 2;
        this._CY = r4.getYear();
        return;
    }

    private static int _padFourAppend(char[] r5, int r6) {
        if (r6 >= 0) goto L5;
        r5[0] = '-';
        r6 = -r6;
        int r1 = 1;
    L7:
        if (r6 < 10000) goto L10;
        String r7 = Integer.toString(r6);
        r7.getChars(0, r7.length(), r5, r1);
        return r1 + r7.length();
    L10:
        int r0 = r6 / 100;
        int r8 = r6 - (r0 * 100);
        char[] r2 = _tensDigit;
        r5[r1] = r2[r0];
        char[] r4 = _onesDigit;
        r5[r1 + 1] = r4[r0];
        r5[r1 + 2] = r2[r8];
        r5[r1 + 3] = r4[r8];
        return r1 + 4;
    L5:
        r1 = 0;
        goto L7
    }

    private static int _padTwoAppend(char[] r2, int r3, int r4) {
        r2[r3] = _tensDigit[r4];
        r2[r3 + 1] = _onesDigit[r4];
        return r3 + 2;
    }

    static int digitVal(char r0) {
        return r0 - '0';
    }

    private void ensureCanonicalString() {
        if (this._canonicalString == null) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (hasTimeZone() == true) goto L8;
    L16:
        boolean r0 = false;
    L17:
        if (r0 == false) goto L19;
    L27:
        if (r0 == true) goto L29;
        String r2 = toString();
    L30:
        this._canonicalString = r2;
        return;
    L29:
        GDateBuilder r3 = new GDateBuilder(this);
        r3.normalize();
        r2 = r3.toString();
        goto L30
    L19:
        if (getFraction() == null) goto L27;
        if (getFraction().scale() <= 0) goto L27;
        if (getFraction().unscaledValue().mod(GDateBuilder.TEN).signum() == 0) goto L26;
        r1 = false;
    L26:
        r0 = r1;
        goto L27
    L8:
        if (getTimeZoneSign() == 0) goto L16;
        if (hasTime() == false) goto L16;
        if (hasDay() != hasMonth()) goto L16;
        if (hasDay() != hasYear()) goto L16;
        r0 = true;
        goto L17
    }

    static String formatGDate(GDateSpecification r8) {
        GDateSpecification r9 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r8, GDateSpecification.class, "com.obric.memorydata.plugin");
        BigDecimal r0 = r9.getFraction();
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        char[] r3 = new char[r2 + 33];
        char r4 = '-';
        if (r9.hasYear() == true) goto L15;
        if (r9.hasMonth() == true) goto L15;
        if (r9.hasDay() == true) goto L15;
        int r5 = 0;
    L35:
        if (r9.hasTime() == false) goto L44;
        int r6 = _padTwoAppend(r3, r5, r9.getHour());
        r3[r6] = ':';
        int r7 = _padTwoAppend(r3, r6 + 1, r9.getMinute());
        r3[r7] = ':';
        r5 = _padTwoAppend(r3, r7 + 1, r9.getSecond());
        if (r0 == null) goto L44;
        if (_zero.equals(r0) == true) goto L44;
        String r1 = r0.toString();
        int r10 = r1.indexOf(46);
        if (r10 < 0) goto L44;
        r1.getChars(r10, r1.length(), r3, r5);
        r5 = r5 + (r1.length() - r10);
    L44:
        if (r9.hasTimeZone() == false) goto L53;
        if (r9.getTimeZoneSign() != 0) goto L48;
        r3[r5] = 'Z';
        r5 = r5 + 1;
        goto L53
    L48:
        int r11 = r5 + 1;
        if (r9.getTimeZoneSign() <= 0) goto L51;
        r4 = '+';
    L51:
        r3[r5] = r4;
        int r12 = _padTwoAppend(r3, r11, r9.getTimeZoneHour());
        r3[r12] = ':';
        r5 = _padTwoAppend(r3, r12 + 1, r9.getTimeZoneMinute());
    L53:
        return new String(r3, 0, r5);
    L15:
        if (r9.hasYear() == false) goto L17;
        r5 = _padFourAppend(r3, r9.getYear());
    L19:
        if (r9.hasMonth() == false) goto L21;
    L23:
        int r13 = r5 + 1;
        r3[r5] = '-';
        if (r9.hasMonth() == false) goto L26;
        r5 = _padTwoAppend(r3, r13, r9.getMonth());
    L28:
        if (r9.hasDay() == false) goto L32;
        r3[r5] = '-';
        r5 = _padTwoAppend(r3, r5 + 1, r9.getDay());
    L32:
        if (r9.hasTime() == false) goto L35;
        r3[r5] = 'T';
        r5 = r5 + 1;
        goto L35
    L26:
        r5 = r13;
        goto L28
    L21:
        if (r9.hasDay() == true) goto L23;
    L17:
        r3[0] = '-';
        r5 = 1;
        goto L19
    L5:
        r2 = r0.scale();
        goto L6
    }

    static boolean isDigit(char r1) {
        if (((char) (r1 - '0')) > '\t') goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isSpace(char r1) {
        if (r1 != '\t') goto L5;
        return true;
    L5:
        if (r1 != '\n') goto L7;
        return true;
    L7:
        if (r1 != '\r') goto L9;
        return true;
    L9:
        if (r1 == ' ') goto L16;
        return false;
    L16:
        return true;
    }

    static TimeZone timeZoneForGDate(GDateSpecification r3) {
        GDateSpecification r4 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDateSpecification.class, "com.obric.memorydata.plugin");
        if (r4.hasTimeZone() == true) goto L7;
        return TimeZone.getDefault();
    L7:
        if (r4.getTimeZoneSign() != 0) goto L11;
        return GMTZONE;
    L11:
        if (r4.getTimeZoneMinute() == 0) goto L13;
    L21:
        char[] r0 = new char[9];
        r0[0] = 'G';
        r0[1] = 'M';
        r0[2] = 'T';
        if (r4.getTimeZoneSign() >= 0) goto L24;
        char r2 = '-';
    L25:
        r0[3] = r2;
        _padTwoAppend(r0, 4, r4.getTimeZoneHour());
        r0[6] = ':';
        _padTwoAppend(r0, 7, r4.getTimeZoneMinute());
        return TimeZone.getTimeZone(new String(r0));
    L24:
        r2 = '+';
        goto L25
    L13:
        if (r4.getTimeZoneHour() > 14) goto L21;
        if (r4.getTimeZoneHour() < 0) goto L21;
        if (r4.getTimeZoneSign() >= 0) goto L20;
        return MINUSZONE[r4.getTimeZoneHour()];
    L20:
        return PLUSZONE[r4.getTimeZoneHour()];
    }

    private static int twoDigit(CharSequence r2, int r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        char r0 = r4.charAt(r3);
        char r5 = r4.charAt(r3 + 1);
        if (isDigit(r0) == true) goto L5;
        return 100;
    L5:
        if (isDigit(r5) == true) goto L8;
        return 100;
    L8:
        return (digitVal(r0) * 10) + digitVal(r5);
    }

    public GDate add(GDurationSpecification r3) {
        GDurationSpecification r4 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin");
        GDateBuilder r0 = new GDateBuilder(this);
        r0.addGDuration(r4);
        return r0.toGDate();
    }

    public String canonicalString() {
        ensureCanonicalString();
        return this._canonicalString;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int compareToGDate(GDateSpecification r3) {
        return GDateBuilder.compareGDate(this, (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDateSpecification.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, GDate.class) == true) goto L10;
        return false;
    L10:
        ensureCanonicalString();
        return this._canonicalString.equals(((GDate) ZeusTransformUtils.preCheckCast(r3, GDate.class, "com.obric.memorydata.plugin")).canonicalString());
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getBuiltinTypeCode() {
        return GDateBuilder.btcForFlags(this._bits);
    }

    public XmlCalendar getCalendar() {
        return new XmlCalendar(this);
    }

    public Date getDate() {
        return GDateBuilder.dateForGDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getDay() {
        return this._D;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getFlags() {
        return this._bits;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final BigDecimal getFraction() {
        return this._fs;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getHour() {
        return this._h;
    }

    public int getJulianDate() {
        return GDateBuilder.julianDateForGDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getMillisecond() {
        BigDecimal r2 = this._fs;
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.setScale(3, RoundingMode.DOWN).unscaledValue().intValue();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMinute() {
        return this._m;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMonth() {
        return this._M;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getSecond() {
        return this._s;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneHour() {
        return this._tzh;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneMinute() {
        return this._tzm;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneSign() {
        return this._tzsign;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getYear() {
        return this._CY;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasDate() {
        if ((this._bits & 14) != 14) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasDay() {
        if ((this._bits & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasMonth() {
        if ((this._bits & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasTime() {
        if ((this._bits & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasTimeZone() {
        if ((this._bits & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasYear() {
        if ((this._bits & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        ensureCanonicalString();
        return this._canonicalString.hashCode();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean isImmutable() {
        return true;
    }

    public boolean isValid() {
        return GDateBuilder.isValidGDate(this);
    }

    public GDate subtract(GDurationSpecification r3) {
        GDurationSpecification r4 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin");
        GDateBuilder r0 = new GDateBuilder(this);
        r0.subtractGDuration(r4);
        return r0.toGDate();
    }

    public String toString() {
        if (this._string != null) goto L6;
        this._string = formatGDate(this);
    L6:
        return this._string;
    }
}
