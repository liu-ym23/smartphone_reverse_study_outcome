package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.SimpleTimeZone;

/* JADX INFO: loaded from: classes2.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final BigInteger f3580a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final BigInteger f3581b = null;
    protected static final BigInteger c = null;
    protected static final BigInteger d = null;
    protected static final BigInteger e = null;
    protected static final BigInteger f = null;
    protected static final BigInteger g = null;
    protected static final BigInteger h = null;
    protected static final BigDecimal i = null;
    protected static final Integer j = null;
    protected static java.util.TimeZone k;
    protected static java.util.TimeZone l;
    private static final int[] m = null;

    static {
        f3580a = new BigInteger("4");
        f3581b = new BigInteger("10");
        c = new BigInteger("12");
        d = new BigInteger(BDLocationException.ERROR_UNKNOWN);
        e = new BigInteger(BDLocationException.ERROR_NO_LOCATE);
        f = new BigInteger(BDLocationException.ERROR_BEACON_ADVERTISING);
        g = new BigInteger("400");
        h = new BigInteger("210379680");
        i = new BigDecimal(BigInteger.ZERO, 0);
        j = new Integer(0);
        k = new SimpleTimeZone(50400000, "");
        l = new SimpleTimeZone(-50400000, "");
        m = new int[]{31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    }

    public static int a(Comparable r2, Comparable r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r4 == null) goto L16;
        if (r5 == null) goto L18;
        int r6 = r4.compareTo(r5);
        if (r6 >= 0) goto L12;
        return -1;
    L12:
        if (r6 <= 0) goto L15;
        return 1;
    L15:
        return 0;
    L18:
        return 999;
    L16:
        return 999;
    }

    public static int a(Object r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public static int a(BigInteger r1, int r2) {
        if (r2 != 1) goto L15;
        if (r1.mod(g).intValue() != 0) goto L8;
        return 29;
    L8:
        if (r1.mod(f3580a).intValue() == 0) goto L10;
        return 28;
    L10:
        if (r1.mod(f).intValue() == 0) goto L16;
        return 29;
    L16:
        return 28;
    L15:
        return m[r2];
    }

    public static BigInteger a(int r1) {
        return new BigInteger(Integer.toString(r1));
    }

    public static BigInteger a(Integer r1) {
        if (r1 != null) goto L6;
        return BigInteger.ZERO;
    L6:
        return new BigInteger(r1.toString());
    }

    public static boolean a(Object r1, Object r2) {
        if (r1 != null) goto L6;
        if (r2 != null) goto L6;
        return true;
    L6:
        if (r1 == null) goto L11;
        if (r2 != null) goto L9;
        return false;
    L9:
        if (r1.equals(r2) == false) goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    }
}
