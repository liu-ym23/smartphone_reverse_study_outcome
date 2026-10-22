package org.apache.xmlbeans;

import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
public final class GDateBuilder implements Serializable, GDateSpecification {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final BigInteger TEN = null;
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private int _bits;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _tzh;
    private int _tzm;
    private int _tzsign;

    static {
        TEN = BigInteger.valueOf(10);
    }

    public GDateBuilder() {
    }

    public GDateBuilder(int r2, int r3, int r4, int r5, int r6, int r7, BigDecimal r8) {
        this._bits = 30;
        if (r2 == 0) goto L16;
        if (r2 > 0) goto L7;
        r2 = r2 + 1;
    L7:
        this._CY = r2;
        this._M = r3;
        this._D = r4;
        this._h = r5;
        this._m = r6;
        this._s = r7;
        if (r8 != null) goto L10;
        r8 = GDate._zero;
    L10:
        this._fs = r8;
        if (isValid() == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException();
    L16:
        throw new IllegalArgumentException();
    }

    public GDateBuilder(int r2, int r3, int r4, int r5, int r6, int r7, BigDecimal r8, int r9, int r10, int r11) {
        this._bits = 31;
        if (r2 == 0) goto L16;
        if (r2 > 0) goto L7;
        r2 = r2 + 1;
    L7:
        this._CY = r2;
        this._M = r3;
        this._D = r4;
        this._h = r5;
        this._m = r6;
        this._s = r7;
        if (r8 != null) goto L10;
        r8 = GDate._zero;
    L10:
        this._fs = r8;
        this._tzsign = r9;
        this._tzh = r10;
        this._tzm = r11;
        if (isValid() == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException();
    L16:
        throw new IllegalArgumentException();
    }

    public GDateBuilder(CharSequence r3) {
        this(new GDate((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")));
    }

    public GDateBuilder(Calendar r2) {
        this(new GDate(r2));
    }

    public GDateBuilder(Date r1) {
        setDate(r1);
    }

    public GDateBuilder(GDateSpecification r5) {
        GDateSpecification r6 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r5, GDateSpecification.class, "com.obric.memorydata.plugin");
        if (r6.hasTimeZone() == false) goto L6;
        setTimeZone(r6.getTimeZoneSign(), r6.getTimeZoneHour(), r6.getTimeZoneMinute());
    L6:
        if (r6.hasTime() == false) goto L9;
        setTime(r6.getHour(), r6.getMinute(), r6.getSecond(), r6.getFraction());
    L9:
        if (r6.hasDay() == false) goto L12;
        setDay(r6.getDay());
    L12:
        if (r6.hasMonth() == false) goto L15;
        setMonth(r6.getMonth());
    L15:
        if (r6.hasYear() == false) goto L18;
        setYear(r6.getYear());
        return;
    }

    private static long _fQuotient(long r4, int r6) {
        boolean r1 = true;
        if (r4 >= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r6 < 0) goto L9;
        r1 = false;
    L9:
        if (r0 == r1) goto L13;
        long r2 = r6;
        return -(((r2 - r4) - 1) / r2);
    L13:
        return r4 / ((long) r6);
    L5:
        r0 = false;
        goto L6
    }

    private static long _fQuotient(long r2, int r4, int r5) {
        return _fQuotient(r2 - ((long) r4), r5 - r4);
    }

    private static boolean _isLeapYear(int r1) {
        if ((r1 % 4) == 0) goto L5;
    L9:
        return false;
    L5:
        if ((r1 % 100) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r1 % 400) != 0) goto L9;
        goto L8
    }

    private static int _maxDayInMonth(int r1) {
        if (r1 != 4) goto L5;
        return 30;
    L5:
        if (r1 != 6) goto L7;
        return 30;
    L7:
        if (r1 != 9) goto L9;
        return 30;
    L9:
        if (r1 != 11) goto L12;
        return 30;
    L12:
        if (r1 != 2) goto L14;
        return 29;
    L14:
        return 31;
    }

    private static int _maxDayInMonthFor(int r1, int r2) {
        if (r2 != 4) goto L5;
        return 30;
    L5:
        if (r2 != 6) goto L7;
        return 30;
    L7:
        if (r2 != 9) goto L9;
        return 30;
    L9:
        if (r2 != 11) goto L12;
        return 30;
    L12:
        if (r2 == 2) goto L14;
        return 31;
    L14:
        if (_isLeapYear(r1) == false) goto L16;
        return 29;
    L16:
        return 28;
    }

    private static int _mod(long r2, int r4, long r5) {
        return (int) (r2 - (r5 * ((long) r4)));
    }

    private static int _modulo(long r2, int r4, int r5) {
        long r3 = r2 - ((long) r4);
        int r6 = r5 - r4;
        return _mod(r3, r6, _fQuotient(r3, r6)) + r4;
    }

    private void _normalizeDate() {
        int r0 = this._M;
        if (r0 >= 1) goto L5;
    L10:
        long r2 = this._M;
        this._M = _modulo(r2, 1, 13);
        this._CY += (int) _fQuotient(r2, 1, 13);
        int r1 = this._D - 1;
        this._D = 1;
        setJulianDate(getJulianDate() + r1);
        return;
    L5:
        if (r0 > 12) goto L10;
        int r3 = this._D;
        if (r3 < 1) goto L10;
        if (r3 > _maxDayInMonthFor(this._CY, r0)) goto L10;
    }

    private long _normalizeTime() {
        BigDecimal r0 = this._fs;
        if (r0 != null) goto L5;
    L9:
        long r3 = 0;
    L11:
        if (r3 != 0) goto L24;
        int r1 = this._s;
        if (r1 < 0) goto L24;
        if (r1 > 59) goto L24;
        int r2 = this._m;
        if (r2 < 0) goto L24;
        if (r2 > 50) goto L24;
        int r4 = this._h;
        if (r4 < 0) goto L24;
        if (r4 > 23) goto L24;
        return r3;
    L24:
        long r5 = ((long) this._s) + r3;
        long r6 = _fQuotient(r5, 60);
        this._s = _mod(r5, 60, r6);
        long r7 = ((long) this._m) + r6;
        long r8 = _fQuotient(r7, 60);
        this._m = _mod(r7, 60, r8);
        long r9 = ((long) this._h) + r8;
        long r10 = _fQuotient(r9, 24);
        this._h = _mod(r9, 24, r10);
        return r10;
    L5:
        if (r0.signum() >= 0) goto L7;
    L8:
        BigDecimal r11 = this._fs.setScale(0, RoundingMode.FLOOR);
        this._fs = this._fs.subtract(r11);
        r3 = r11.longValue();
        goto L11
    L7:
        if (this._fs.compareTo(GDate._one) < 0) goto L9;
        goto L8
    }

    private void _normalizeTimeAndDate() {
        if (hasTime() == false) goto L5;
        long r0 = _normalizeTime();
    L7:
        if (hasDay() == false) goto L10;
        this._D = Math.addExact(this._D, Math.toIntExact(r0));
    L10:
        if (hasDate() == false) goto L13;
        _normalizeDate();
        return;
    L13:
        if (hasMonth() == false) goto L23;
        int r1 = this._M;
        if (r1 >= 1) goto L17;
    L18:
        long r2 = r1;
        this._M = _modulo(r2, 1, 13);
        if (hasYear() == false) goto L25;
        this._CY += (int) _fQuotient(r2, 1, 13);
        return;
    L25:
        return;
    L17:
        if (r1 > 12) goto L18;
        return;
    L23:
        return;
    L5:
        r0 = 0;
        goto L7
    }

    private void _setToFirstMoment() {
        if (hasYear() == true) goto L6;
        setYear(1584);
    L6:
        if (hasMonth() == true) goto L9;
        setMonth(1);
    L9:
        if (hasDay() == true) goto L12;
        setDay(1);
    L12:
        if (hasTime() == true) goto L15;
        setTime(0, 0, 0, GDate._zero);
        return;
    }

    static int btcForFlags(int r3) {
        int r4 = r3 & 30;
        if (r4 != 2) goto L5;
        return 18;
    L5:
        if (r4 != 4) goto L7;
        return 21;
    L7:
        if (r4 != 6) goto L9;
        return 17;
    L9:
        if (r4 != 8) goto L11;
        return 20;
    L11:
        if (r4 != 12) goto L13;
        return 19;
    L13:
        if (r4 == 14) goto L21;
        if (r4 == 16) goto L19;
        if (r4 == 30) goto L18;
        return 0;
    L18:
        return 14;
    L19:
        return 15;
    L21:
        return 16;
    }

    static int compareGDate(GDateSpecification r9, GDateSpecification r10) {
        GDateSpecification r11 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r9, GDateSpecification.class, "com.obric.memorydata.plugin");
        GDateSpecification r12 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r10, GDateSpecification.class, "com.obric.memorydata.plugin");
        int r1 = r11.getFlags() ^ r12.getFlags();
        if ((r1 & 31) != 0) goto L22;
        if (r11.hasTimeZone() == false) goto L20;
        if (r12.getTimeZoneHour() == r11.getTimeZoneHour()) goto L9;
    L12:
        GDateBuilder r2 = new GDateBuilder(r12);
        int r13 = r11.getFlags() & 14;
        if (r13 == 0) goto L16;
        if (r13 == 14) goto L16;
    L17:
        ((GDateBuilder) ZeusTransformUtils.preCheckCast(r2, GDateBuilder.class, "com.obric.memorydata.plugin"))._setToFirstMoment();
        GDateBuilder r14 = new GDateBuilder(r11);
        ((GDateBuilder) ZeusTransformUtils.preCheckCast(r14, GDateBuilder.class, "com.obric.memorydata.plugin"))._setToFirstMoment();
        r11 = r14;
    L18:
        ((GDateBuilder) ZeusTransformUtils.preCheckCast(r2, GDateBuilder.class, "com.obric.memorydata.plugin")).normalizeToTimeZone(r11.getTimeZoneSign(), r11.getTimeZoneHour(), r11.getTimeZoneMinute());
        r12 = r2;
    L16:
        if (r11.hasTime() == true) goto L18;
    L9:
        if (r12.getTimeZoneMinute() != r11.getTimeZoneMinute()) goto L12;
        if (r12.getTimeZoneSign() != r11.getTimeZoneSign()) goto L12;
    L20:
        return fieldwiseCompare(r11, r12);
    L22:
        if ((r1 & 30) == 0) goto L25;
        return 2;
    L25:
        if (r11.hasTimeZone() == true) goto L31;
        int r15 = compareGDate(r12, r11);
        if (r15 != 2) goto L30;
        return 2;
    L30:
        return -r15;
    L31:
        GDateBuilder r0 = new GDateBuilder(r11);
        if ((r11.getFlags() & 14) == 12) goto L34;
    L51:
        r0._setToFirstMoment();
        GDateBuilder r3 = new GDateBuilder(r12);
        r3._setToFirstMoment();
        r3.setTimeZone(1, 14, 0);
        r3.normalizeToTimeZone(r11.getTimeZoneSign(), r11.getTimeZoneHour(), r11.getTimeZoneMinute());
        if (fieldwiseCompare(r0, r3) != (-1)) goto L54;
        return -1;
    L54:
        r3.setGDate(r12);
        r3._setToFirstMoment();
        r3.setTimeZone(-1, 14, 0);
        r3.normalizeToTimeZone(r11.getTimeZoneSign(), r11.getTimeZoneHour(), r11.getTimeZoneMinute());
        if (fieldwiseCompare(r0, r3) != 1) goto L57;
        return 1;
    L57:
        return 2;
    L34:
        if (r11.getDay() != 28) goto L43;
        if (r11.getMonth() != 2) goto L43;
        if (r12.getDay() != 1) goto L51;
        if (r12.getMonth() != 3) goto L51;
    L41:
        r0.setDay(29);
    L43:
        if (r12.getDay() != 28) goto L51;
        if (r12.getMonth() != 2) goto L51;
        if (r11.getDay() != 1) goto L51;
        if (r11.getMonth() != 3) goto L51;
        r0.setMonth(2);
        goto L41
    }

    static Date dateForGDate(GDateSpecification r6) {
        GDateSpecification r7 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r6, GDateSpecification.class, "com.obric.memorydata.plugin");
        long r0 = (((((((long) julianDateForGDate(r7)) - 2440588) * WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) + ((long) r7.getMillisecond())) + (((long) r7.getSecond()) * 1000)) + (((long) (r7.getMinute() * 60)) * 1000)) + (((long) ((r7.getHour() * 60) * 60)) * 1000);
        if (r7.hasTimeZone() == false) goto L5;
        r0 = r0 - (((long) ((r7.getTimeZoneMinute() * r7.getTimeZoneSign()) * 60)) * 1000);
        long r2 = ((long) (((r7.getTimeZoneHour() * r7.getTimeZoneSign()) * 60) * 60)) * 1000;
    L7:
        return new Date(r0 - r2);
    L5:
        r2 = TimeZone.getDefault().getOffset(r0);
        goto L7
    }

    private static int fieldwiseCompare(GDateSpecification r5, GDateSpecification r6) {
        GDateSpecification r7 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r5, GDateSpecification.class, "com.obric.memorydata.plugin");
        GDateSpecification r8 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r6, GDateSpecification.class, "com.obric.memorydata.plugin");
        if (r7.hasYear() == false) goto L10;
        int r0 = r8.getYear();
        int r3 = r7.getYear();
        if (r3 >= r0) goto L7;
        return -1;
    L7:
        if (r3 <= r0) goto L10;
        return 1;
    L10:
        if (r7.hasMonth() == false) goto L17;
        int r1 = r8.getMonth();
        int r4 = r7.getMonth();
        if (r4 >= r1) goto L14;
        return -1;
    L14:
        if (r4 <= r1) goto L17;
        return 1;
    L17:
        if (r7.hasDay() == false) goto L24;
        int r2 = r8.getDay();
        int r9 = r7.getDay();
        if (r9 >= r2) goto L21;
        return -1;
    L21:
        if (r9 <= r2) goto L24;
        return 1;
    L24:
        if (r7.hasTime() == false) goto L50;
        int r10 = r8.getHour();
        int r11 = r7.getHour();
        if (r11 >= r10) goto L28;
        return -1;
    L28:
        if (r11 <= r10) goto L30;
        return 1;
    L30:
        int r12 = r8.getMinute();
        int r13 = r7.getMinute();
        if (r13 >= r12) goto L33;
        return -1;
    L33:
        if (r13 <= r12) goto L35;
        return 1;
    L35:
        int r14 = r8.getSecond();
        int r15 = r7.getSecond();
        if (r15 >= r14) goto L38;
        return -1;
    L38:
        if (r15 <= r14) goto L40;
        return 1;
    L40:
        BigDecimal r16 = r8.getFraction();
        BigDecimal r17 = r7.getFraction();
        if (r17 != null) goto L44;
        if (r16 != null) goto L44;
        return 0;
    L44:
        if (r17 != null) goto L46;
        r17 = GDate._zero;
    L46:
        if (r16 != null) goto L49;
        r16 = GDate._zero;
    L49:
        return r17.compareTo(r16);
    L50:
        return 0;
    }

    static boolean isValidGDate(GDateSpecification r5) {
        GDateSpecification r6 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r5, GDateSpecification.class, "com.obric.memorydata.plugin");
        if (r6.hasYear() == false) goto L8;
        if (r6.getYear() != 0) goto L8;
        return false;
    L8:
        if (r6.hasMonth() == false) goto L15;
        if (r6.getMonth() >= 1) goto L12;
    L13:
        return false;
    L12:
        if (r6.getMonth() > 12) goto L13;
    L15:
        if (r6.hasDay() == false) goto L37;
        if (r6.getDay() >= 1) goto L19;
    L35:
        return false;
    L19:
        if (r6.getDay() > 31) goto L35;
        if (r6.getDay() <= 28) goto L37;
        if (r6.hasMonth() == false) goto L37;
        if (r6.hasYear() == false) goto L34;
        int r0 = r6.getDay();
        if (r6.getYear() <= 0) goto L29;
        int r3 = r6.getYear();
    L31:
        if (r0 <= _maxDayInMonthFor(r3, r6.getMonth())) goto L37;
    L29:
        r3 = r6.getYear() + 1;
        goto L31
    L34:
        if (r6.getDay() > _maxDayInMonth(r6.getMonth())) goto L35;
    L37:
        if (r6.hasTime() == false) goto L64;
        if (r6.getHour() < 0) goto L55;
        if (r6.getHour() > 23) goto L55;
        if (r6.getMinute() < 0) goto L55;
        if (r6.getMinute() > 59) goto L55;
        if (r6.getSecond() < 0) goto L55;
        if (r6.getSecond() > 59) goto L55;
        if (r6.getFraction().signum() < 0) goto L55;
        if (r6.getFraction().compareTo(GDate._one) < 0) goto L64;
    L55:
        if (r6.getHour() == 24) goto L57;
    L62:
        return false;
    L57:
        if (r6.getMinute() != 0) goto L62;
        if (r6.getSecond() != 0) goto L62;
        if (r6.getFraction().compareTo(GDate._zero) != 0) goto L62;
    L64:
        if (r6.hasTimeZone() == true) goto L66;
    L88:
        return true;
    L66:
        if (r6.getTimeZoneSign() != 0) goto L72;
        if (r6.getTimeZoneHour() != 0) goto L72;
        if (r6.getTimeZoneMinute() == 0) goto L88;
    L72:
        if (r6.getTimeZoneSign() == (-1)) goto L76;
        if (r6.getTimeZoneSign() == 1) goto L76;
    L87:
        return false;
    L76:
        if (r6.getTimeZoneHour() < 0) goto L87;
        if (r6.getTimeZoneMinute() < 0) goto L87;
        if (r6.getTimeZoneHour() != 14) goto L84;
        if (r6.getTimeZoneMinute() == 0) goto L88;
    L84:
        if (r6.getTimeZoneHour() >= 14) goto L87;
        if (r6.getTimeZoneMinute() < 60) goto L88;
        goto L87
    }

    static int julianDateForGDate(GDateSpecification r4) {
        GDateSpecification r5 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r4, GDateSpecification.class, "com.obric.memorydata.plugin");
        if (r5.hasDate() == false) goto L14;
        int r0 = r5.getDay();
        int r1 = r5.getMonth();
        int r6 = r5.getYear();
        if (r6 > 0) goto L8;
        r6 = r6 + 1;
    L8:
        int r3 = (r1 - 14) / 12;
        int r2 = (((r0 - 32075) + ((((r6 + 4800) + r3) * 1461) / 4)) + ((((r1 - 2) - (r3 * 12)) * 367) / 12)) - (((((r6 + 4900) + r3) / 100) * 3) / 4);
        if (r2 < 0) goto L12;
        return r2;
    L12:
        throw new IllegalStateException("date too far in the past (year allowed to -4713)");
    L14:
        throw new IllegalStateException("cannot do date math without a complete date");
    }

    public void addDuration(int r7, int r8, int r9, int r10, int r11, int r12, int r13, BigDecimal r14) {
        boolean r0 = false;
        if (r11 != 0) goto L11;
        if (r12 != 0) goto L11;
        if (r13 != 0) goto L11;
        if (r14 != null) goto L8;
    L10:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L19;
        if (hasTime() == true) goto L19;
        throw new IllegalStateException("cannot do time math without a complete time");
    L19:
        if (hasDay() == false) goto L23;
        if (r10 != 0) goto L22;
        if (r2 == false) goto L23;
    L22:
        r0 = true;
    L23:
        if (r0 == true) goto L25;
    L29:
        if (r9 != 0) goto L32;
        if (r8 != 0) goto L32;
    L39:
        long r15 = 0;
        if (r2 == false) goto L54;
        if (r14 != null) goto L43;
    L53:
        this._s += r13 * r7;
        this._m += r12 * r7;
        this._h += r11 * r7;
        r15 = _normalizeTime();
        goto L54
    L43:
        if (r14.signum() == 0) goto L53;
        if (this._fs.signum() != 0) goto L48;
        if (r7 != 1) goto L48;
        this._fs = r14;
    L48:
        BigDecimal r16 = this._fs;
        if (r7 != 1) goto L51;
        BigDecimal r17 = r16.add(r14);
    L52:
        this._fs = r17;
        goto L53
    L51:
        r17 = r16.subtract(r14);
    L54:
        if (r0 == false) goto L57;
        this._D = Math.addExact(this._D, Math.toIntExact(Math.addExact(Math.multiplyExact(r7, r10), r15)));
        _normalizeDate();
        return;
    L57:
        return;
    L32:
        if (hasDay() == false) goto L34;
        _normalizeDate();
    L34:
        long r3 = this._M + (r9 * r7);
        this._M = _modulo(r3, 1, 13);
        this._CY = (this._CY + (r8 * r7)) + ((int) _fQuotient(r3, 1, 13));
        if (hasDay() == false) goto L39;
        int r18 = _maxDayInMonthFor(this._CY, this._M);
        if (this._D <= r18) goto L39;
        this._D = r18;
        goto L39
    L25:
        if (hasDate() == true) goto L29;
        throw new IllegalStateException("cannot do date math without a complete date");
    L8:
        if (r14.signum() == 0) goto L10;
    L11:
        r2 = true;
        goto L12
    }

    public void addGDuration(GDurationSpecification r10) {
        GDurationSpecification r11 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r10, GDurationSpecification.class, "com.obric.memorydata.plugin");
        addDuration(r11.getSign(), r11.getYear(), r11.getMonth(), r11.getDay(), r11.getHour(), r11.getMinute(), r11.getSecond(), r11.getFraction());
    }

    public String canonicalString() {
        boolean r1 = true;
        if (hasTimeZone() == true) goto L5;
    L13:
        boolean r0 = false;
    L14:
        if (r0 == false) goto L16;
    L24:
        if (r0 == false) goto L26;
        GDateBuilder r2 = new GDateBuilder(this);
        r2.normalize();
        return r2.toString();
    L26:
        return toString();
    L16:
        if (getFraction() == null) goto L24;
        if (getFraction().scale() <= 0) goto L24;
        if (getFraction().unscaledValue().mod(TEN).signum() == 0) goto L23;
        r1 = false;
    L23:
        r0 = r1;
        goto L24
    L5:
        if (getTimeZoneSign() == 0) goto L13;
        if (hasTime() == false) goto L13;
        if (hasDay() != hasMonth()) goto L13;
        if (hasDay() != hasYear()) goto L13;
        r0 = true;
        goto L14
    }

    public void clearDay() {
        this._bits &= -9;
        this._D = 0;
    }

    public void clearMonth() {
        this._bits &= -5;
        this._M = 0;
    }

    public void clearTime() {
        this._bits &= -17;
        this._h = 0;
        this._m = 0;
        this._s = 0;
        this._fs = null;
    }

    public void clearTimeZone() {
        this._bits &= -2;
        this._tzsign = 0;
        this._tzh = 0;
        this._tzm = 0;
    }

    public void clearYear() {
        this._bits &= -3;
        this._CY = 0;
    }

    public Object clone() {
        return new GDateBuilder(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int compareToGDate(GDateSpecification r3) {
        return compareGDate(this, (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDateSpecification.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getBuiltinTypeCode() {
        return btcForFlags(this._bits);
    }

    public XmlCalendar getCalendar() {
        return new XmlCalendar(this);
    }

    public Date getDate() {
        return dateForGDate(this);
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

    public final int getJulianDate() {
        return julianDateForGDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMillisecond() {
        if (this._fs != null) goto L5;
        return 0;
    L5:
        if (GDate._zero.equals(this._fs) == false) goto L8;
        return 0;
    L8:
        return this._fs.setScale(3, RoundingMode.HALF_UP).unscaledValue().intValue();
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
        int r0 = this._CY;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return r0 - 1;
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

    @Override // org.apache.xmlbeans.GDateSpecification
    public boolean isImmutable() {
        return false;
    }

    public boolean isValid() {
        return isValidGDate(this);
    }

    public void normalize() {
        if (hasDay() == hasMonth()) goto L5;
    L11:
        _normalizeTimeAndDate();
    L13:
        if (hasTime() == false) goto L31;
        BigDecimal r0 = this._fs;
        if (r0 != null) goto L17;
        return;
    L17:
        if (r0.scale() > 0) goto L19;
        return;
    L19:
        if (this._fs.signum() != 0) goto L22;
        BigDecimal r1 = GDate._zero;
    L21:
        this._fs = r1;
        return;
    L22:
        String r2 = this._fs.unscaledValue().toString();
        int r3 = r2.length();
    L23:
        if (r3 <= 0) goto L29;
        if (r2.charAt(r3 - 1) != '0') goto L29;
        r3 = r3 - 1;
    L29:
        if (r3 >= r2.length()) goto L37;
        BigDecimal r4 = this._fs;
        r1 = r4.setScale((r4.scale() - r2.length()) + r3, RoundingMode.UNNECESSARY);
        goto L21
    L37:
        return;
    L31:
        return;
    L5:
        if (hasDay() != hasYear()) goto L11;
        if (hasTimeZone() == false) goto L11;
        if (hasTime() == false) goto L11;
        normalizeToTimeZone(0, 0, 0);
        goto L13
    }

    void normalize24h() {
        if (hasTime() == true) goto L5;
        return;
    L5:
        if (getHour() != 24) goto L10;
        _normalizeTimeAndDate();
        return;
    }

    public void normalizeToTimeZone(int r4) {
        if (r4 < (-840)) goto L9;
        if (r4 > 840) goto L9;
        int r0 = Integer.compare(r4, 0);
        int r5 = r4 * r0;
        int r1 = r5 / 60;
        normalizeToTimeZone(r0, r1, r5 - (r1 * 60));
        return;
    L9:
        throw new IllegalArgumentException("time zone out of range (-840 to 840 minutes). (" + r4 + ")");
    }

    public void normalizeToTimeZone(int r13, int r14, int r15) {
        if (r13 != 0) goto L6;
        if (r14 != 0) goto L6;
        if (r15 != 0) goto L6;
    L18:
        if (hasTimeZone() == false) goto L30;
        if (hasTime() == false) goto L30;
        if (hasDay() != hasMonth()) goto L28;
        if (hasDay() != hasYear()) goto L28;
        int r1 = this._tzsign;
        int r8 = (r13 * r14) - (this._tzh * r1);
        int r9 = (r13 * r15) - (r1 * this._tzm);
        this._tzsign = r13;
        this._tzh = r14;
        this._tzm = r15;
        addDuration(1, 0, 0, 0, r8, r9, 0, null);
        return;
    L28:
        throw new IllegalStateException("cannot do date math without a complete date");
    L30:
        throw new IllegalStateException("cannot normalize time zone without both time and timezone");
    L6:
        if (r13 != (-1)) goto L8;
    L9:
        if (r14 < 0) goto L32;
        if (r15 < 0) goto L32;
        if (r14 != 14) goto L14;
        if (r15 == 0) goto L18;
    L14:
        if (r14 >= 14) goto L32;
        if (r15 < 60) goto L18;
    L32:
        throw new IllegalArgumentException("time zone must be between -14:00 and +14:00");
    L8:
        if (r13 != 1) goto L32;
        goto L9
    }

    public void setBuiltinTypeCode(int r1) {
        switch(r1) {
            case 14: goto L19;
            case 15: goto L17;
            case 16: goto L15;
            case 17: goto L13;
            case 18: goto L11;
            case 19: goto L9;
            case 20: goto L7;
            case 21: goto L5;
            default: goto L4;
        };
    L5:
        clearYear();
        clearDay();
        clearTime();
        return;
    L7:
        clearYear();
        clearMonth();
        clearTime();
        return;
    L9:
        clearYear();
        clearTime();
        return;
    L11:
        clearMonth();
        clearDay();
        clearTime();
        return;
    L13:
        clearDay();
        clearTime();
        return;
    L15:
        clearTime();
        return;
    L17:
        clearYear();
        clearMonth();
        clearDay();
        return;
    L19:
        return;
    L4:
        throw new IllegalArgumentException("codeType must be one of SchemaType BTC_  DATE TIME related types.");
    }

    public void setDate(Date r14) {
        int r0 = TimeZone.getDefault().getOffset(r14.getTime());
        if (r0 >= 0) goto L5;
        int r2 = -1;
        r0 = -r0;
    L6:
        int r1 = r0 / 60000;
        int r3 = r1 / 60;
        int r4 = r3 * 60;
        int r5 = r1 - r4;
        setTimeZone(r2, r3, r5);
        setTime(0, 0, 0, GDate._zero);
        this._bits |= 14;
        this._CY = 1970;
        this._M = 1;
        this._D = 1;
        addGDuration(new GDuration(1, 0, 0, 0, 0, 0, 0, BigDecimal.valueOf(r14.getTime() + ((long) (((r2 * (r4 + r5)) * 60) * 1000)), 3)));
        if (this._fs.signum() != 0) goto L10;
        this._fs = GDate._zero;
        return;
    L10:
        return;
    L5:
        r2 = 1;
        goto L6
    }

    public void setDay(int r2) {
        if (r2 < 1) goto L9;
        if (r2 > 31) goto L9;
        this._bits |= 8;
        this._D = r2;
        return;
    L9:
        throw new IllegalArgumentException("day out of range");
    }

    public void setGDate(GDateSpecification r3) {
        GDateSpecification r4 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDateSpecification.class, "com.obric.memorydata.plugin");
        this._bits = r4.getFlags() & 31;
        int r0 = r4.getYear();
        if (r0 > 0) goto L6;
        r0 = r0 + 1;
    L6:
        this._CY = r0;
        this._M = r4.getMonth();
        this._D = r4.getDay();
        this._h = r4.getHour();
        this._m = r4.getMinute();
        this._s = r4.getSecond();
        this._fs = r4.getFraction();
        this._tzsign = r4.getTimeZoneSign();
        this._tzh = r4.getTimeZoneHour();
        this._tzm = r4.getTimeZoneMinute();
    }

    public void setJulianDate(int r5) {
        if (r5 < 0) goto L6;
        int r6 = r5 + 68569;
        int r0 = (r6 * 4) / 146097;
        int r7 = r6 - (((146097 * r0) + 3) / 4);
        int r1 = ((r7 + 1) * 4000) / 1461001;
        this._CY = r1;
        int r8 = (r7 - ((r1 * 1461) / 4)) + 31;
        int r2 = (r8 * 80) / 2447;
        this._M = r2;
        this._D = r8 - ((r2 * 2447) / 80);
        int r9 = r2 / 11;
        this._M = (r2 + 2) - (r9 * 12);
        this._CY = (((r0 - 49) * 100) + r1) + r9;
        this._bits |= 14;
        return;
    L6:
        throw new IllegalArgumentException("date before year -4713");
    }

    public void setMonth(int r2) {
        if (r2 < 1) goto L9;
        if (r2 > 12) goto L9;
        this._bits |= 4;
        this._M = r2;
        return;
    L9:
        throw new IllegalArgumentException("month out of range");
    }

    public void setTime(int r3, int r4, int r5, BigDecimal r6) {
        if (r3 < 0) goto L37;
        if (r3 > 24) goto L37;
        if (r4 < 0) goto L35;
        if (r4 > 59) goto L35;
        if (r5 < 0) goto L33;
        if (r5 > 59) goto L33;
        if (r6 != null) goto L12;
    L18:
        if (r3 != 24) goto L27;
        if (r4 != 0) goto L26;
        if (r5 != 0) goto L26;
        if (r6 == null) goto L27;
        if (GDate._zero.compareTo(r6) == 0) goto L27;
    L26:
        throw new IllegalArgumentException("when hour is 24, min sec and fracton must be 0");
    L27:
        this._bits |= 16;
        this._h = r3;
        this._m = r4;
        this._s = r5;
        if (r6 != null) goto L30;
        r6 = GDate._zero;
    L30:
        this._fs = r6;
        return;
    L12:
        if (r6.signum() < 0) goto L17;
        if (GDate._one.compareTo(r6) > 0) goto L18;
    L17:
        throw new IllegalArgumentException("fraction out of range");
    L33:
        throw new IllegalArgumentException("second out of range");
    L35:
        throw new IllegalArgumentException("minute out of range");
    L37:
        throw new IllegalArgumentException("hour out of range");
    }

    public void setTimeZone(int r4) {
        if (r4 < (-840)) goto L9;
        if (r4 > 840) goto L9;
        int r0 = Integer.compare(r4, 0);
        int r5 = r4 * r0;
        int r1 = r5 / 60;
        setTimeZone(r0, r1, r5 - (r1 * 60));
        return;
    L9:
        throw new IllegalArgumentException("time zone out of range (-840 to 840 minutes). (" + r4 + ")");
    }

    public void setTimeZone(int r3, int r4, int r5) {
        if (r3 != 0) goto L7;
        if (r4 != 0) goto L7;
        if (r5 != 0) goto L7;
    L18:
        this._bits = 1 | this._bits;
        this._tzsign = r3;
        this._tzh = r4;
        this._tzm = r5;
        return;
    L7:
        if (r3 == (-1)) goto L9;
        if (r3 == 1) goto L9;
    L20:
        StringBuilder r0 = new StringBuilder().append("time zone out of range (-14:00 to +14:00). (");
        if (r3 >= 0) goto L23;
        String r6 = "-";
    L25:
        throw new IllegalArgumentException(r0.append(r6).append(r4).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(r5).append(")").toString());
    L23:
        r6 = Marker.ANY_NON_NULL_MARKER;
    L9:
        if (r4 < 0) goto L20;
        if (r5 < 0) goto L20;
        if (r4 != 14) goto L14;
        if (r5 == 0) goto L18;
    L14:
        if (r4 >= 14) goto L20;
        if (r5 < 60) goto L18;
        goto L18
    }

    public void setYear(int r2) {
        if (r2 < (-292275295)) goto L16;
        if (r2 > 292277265) goto L16;
        if (r2 == 0) goto L14;
        this._bits |= 2;
        if (r2 > 0) goto L11;
        r2 = r2 + 1;
    L11:
        this._CY = r2;
        return;
    L14:
        throw new IllegalArgumentException("year cannot be 0");
    L16:
        throw new IllegalArgumentException("year out of range");
    }

    public void subtractGDuration(GDurationSpecification r11) {
        GDurationSpecification r12 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r11, GDurationSpecification.class, "com.obric.memorydata.plugin");
        addDuration(-r12.getSign(), r12.getYear(), r12.getMonth(), r12.getDay(), r12.getHour(), r12.getMinute(), r12.getSecond(), r12.getFraction());
    }

    public GDate toGDate() {
        return new GDate(this);
    }

    public final String toString() {
        return GDate.formatGDate(this);
    }
}
