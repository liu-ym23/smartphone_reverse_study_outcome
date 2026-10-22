package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes7.dex */
public final class GDuration implements Serializable, GDurationSpecification {
    private static final int SEEN_DAY = 3;
    private static final int SEEN_HOUR = 4;
    private static final int SEEN_MINUTE = 5;
    private static final int SEEN_MONTH = 2;
    private static final int SEEN_NOTHING = 0;
    private static final int SEEN_SECOND = 6;
    private static final int SEEN_YEAR = 1;
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _sign;

    public GDuration() {
        this._sign = 1;
        this._fs = GDate._zero;
    }

    public GDuration(int r2, int r3, int r4, int r5, int r6, int r7, int r8, BigDecimal r9) {
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

    public GDuration(CharSequence r17) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r17, CharSequence.class, "com.obric.memorydata.plugin");
        int r2 = r1.length();
    L3:
        if (r2 <= 0) goto L7;
        if (GDate.isSpace(r1.charAt(r2 - 1)) == false) goto L7;
        r2 = r2 - 1;
    L7:
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L12;
        if (GDate.isSpace(r1.charAt(r4)) == false) goto L12;
        r4 = r4 + 1;
    L12:
        this._sign = 1;
        if (r4 < r2) goto L15;
    L17:
        if (r4 >= r2) goto L100;
        if (r1.charAt(r4) != 'P') goto L100;
        int r5 = r4 + 1;
        this._fs = GDate._zero;
        char r6 = 0;
        boolean r7 = false;
    L21:
        if (r5 >= r2) goto L95;
        char r8 = r1.charAt(r5);
        if (r8 != 'T') goto L36;
        if (r7 == true) goto L34;
        if (r6 > 3) goto L32;
        r5 = r5 + 1;
        if (r5 >= r2) goto L30;
        r8 = r1.charAt(r5);
        r7 = true;
        r6 = 3;
        goto L36
    L30:
        throw new IllegalArgumentException("illegal duration");
    L32:
        throw new IllegalArgumentException("T in duration must precede time fields");
    L34:
        throw new IllegalArgumentException("duration must have no more than one T'");
    L36:
        if (GDate.isDigit(r8) == false) goto L94;
        int r9 = GDate.digitVal(r8);
    L38:
        r5 = r5 + 1;
        if (r5 >= r2) goto L41;
        char r10 = r1.charAt(r5);
    L43:
        if (GDate.isDigit(r10) == false) goto L45;
        r9 = (r9 * 10) + GDate.digitVal(r10);
        goto L38
    L45:
        if (r10 != '.') goto L58;
        int r12 = r5;
    L47:
        r12 = r12 + 1;
        if (r12 >= r2) goto L51;
        r10 = r1.charAt(r12);
        if (GDate.isDigit(r10) == true) goto L47;
    L51:
        this._fs = new BigDecimal(r1.subSequence(r5, r12).toString());
        if (r12 >= r2) goto L56;
        if (r10 != 'S') goto L56;
        r5 = r12;
    L56:
        throw new IllegalArgumentException("illegal duration");
    L58:
        if (r6 == 0) goto L66;
        if (r6 == 1) goto L68;
        if (r6 == 2) goto L71;
        if (r6 == 3) goto L74;
        if (r6 == 4) goto L79;
        if (r6 != 5) goto L91;
    L84:
        if (r10 != 'S') goto L91;
        if (r7 == false) goto L89;
        this._s = r9;
        r6 = 6;
    L87:
        r5 = r5 + 1;
        goto L21
    L89:
        throw new IllegalArgumentException("time in duration must follow T");
    L91:
        throw new IllegalArgumentException("duration must specify Y M D T H M S in order");
    L79:
        if (r10 != 'M') goto L84;
        if (r7 == false) goto L83;
        this._m = r9;
        r6 = 5;
        goto L87
    L83:
        throw new IllegalArgumentException("time in duration must follow T");
    L74:
        if (r10 != 'H') goto L79;
        if (r7 == false) goto L78;
        this._h = r9;
        r6 = 4;
        goto L87
    L78:
        throw new IllegalArgumentException("time in duration must follow T");
    L71:
        if (r10 != 'D') goto L74;
        this._D = r9;
        r6 = 3;
    L68:
        if (r10 != 'M') goto L71;
        this._M = r9;
        r6 = 2;
        goto L87
    L66:
        if (r10 != 'Y') goto L68;
        this._CY = r9;
        r6 = 1;
        goto L87
    L41:
        r10 = 0;
        goto L43
    L94:
        throw new IllegalArgumentException("illegal duration at char[" + r5 + "]: '" + r8 + "'");
    L95:
        if (r6 == 0) goto L98;
        return;
    L98:
        throw new IllegalArgumentException("duration must contain at least one number and its designator: " + r1);
    L100:
        throw new IllegalArgumentException("duration must begin with P");
    L15:
        if (r1.charAt(r4) != '-') goto L17;
        this._sign = -1;
        r4 = r4 + 1;
        goto L17
    }

    public GDuration(GDurationSpecification r3) {
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

    private GDuration _add(GDurationSpecification r3, int r4) {
        GDurationSpecification r5 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin");
        GDuration r0 = new GDuration(this);
        r0._CY += r5.getYear() * r4;
        r0._M += r5.getMonth() * r4;
        r0._D += r5.getDay() * r4;
        r0._h += r5.getHour() * r4;
        r0._m += r5.getMinute() * r4;
        r0._s += r5.getSecond() * r4;
        if (r5.getFraction().signum() != 0) goto L6;
        return r0;
    L6:
        if (r0._fs.signum() == 0) goto L8;
    L11:
        BigDecimal r2 = r0._fs;
        BigDecimal r6 = r5.getFraction();
        if (r4 <= 0) goto L14;
        BigDecimal r7 = r2.add(r6);
    L10:
        r0._fs = r7;
        return r0;
    L14:
        r7 = r2.subtract(r6);
        goto L10
    L8:
        if (r4 != 1) goto L11;
        r7 = r5.getFraction();
        goto L10
    }

    public GDuration add(GDurationSpecification r3) {
        GDurationSpecification r4 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin");
        return _add(r4, this._sign * r4.getSign());
    }

    public Object clone() {
        return new GDuration(this);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int compareToGDuration(GDurationSpecification r3) {
        return GDurationBuilder.compareDurations(this, (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GDuration.class) == true) goto L8;
        return false;
    L8:
        GDuration r6 = (GDuration) ZeusTransformUtils.preCheckCast(r5, GDuration.class, "com.obric.memorydata.plugin");
        if (this._sign != r6.getSign()) goto L26;
        if (this._CY != r6.getYear()) goto L26;
        if (this._M != r6.getMonth()) goto L26;
        if (this._D != r6.getDay()) goto L26;
        if (this._h != r6.getHour()) goto L26;
        if (this._m != r6.getMinute()) goto L26;
        if (this._s != r6.getSecond()) goto L26;
        if (this._fs.equals(r6.getFraction()) == false) goto L26;
        return true;
    L26:
        return false;
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

    public int hashCode() {
        return (((((this._s + (this._m * 67)) + (this._h * 3607)) + (this._D * 86407)) + (this._M * 2678407)) + (this._CY * 32140807)) + (this._sign * 11917049);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final boolean isImmutable() {
        return true;
    }

    public boolean isValid() {
        return GDurationBuilder.isValidDuration(this);
    }

    public GDuration subtract(GDurationSpecification r3) {
        GDurationSpecification r4 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin");
        return _add(r4, (-this._sign) * r4.getSign());
    }

    public String toString() {
        return GDurationBuilder.formatDuration(this);
    }
}
