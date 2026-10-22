package com.alibaba.excel.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public static Short a(String r1, com.alibaba.excel.metadata.a.c r2) {
        if (a(r2) == true) goto L7;
        short r3 = new BigDecimal(r1).shortValue();
    L6:
        return Short.valueOf(r3);
    L7:
        r3 = h(r1, r2).shortValue();
        goto L6
    }

    public static String a(Number r2, com.alibaba.excel.metadata.a.c r3) {
        if (r3 == null) goto L11;
        if (r3.d() == null) goto L11;
        if (o.a(r3.d().a()) == true) goto L11;
        String r0 = r3.d().a();
        RoundingMode r4 = r3.d().b();
        DecimalFormat r1 = new DecimalFormat(r0);
        r1.setRoundingMode(r4);
        return r1.format(r2);
    L11:
        if (ZeusTransformUtils.instanceOf(r2, BigDecimal.class) == false) goto L15;
        return ((BigDecimal) ZeusTransformUtils.preCheckCast(r2, BigDecimal.class, "com.obric.memorydata.plugin")).toPlainString();
    L15:
        return r2.toString();
    }

    private static boolean a(com.alibaba.excel.metadata.a.c r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.d() == null) goto L8;
        if (o.a(r1.d().a()) == true) goto L8;
        return true;
    }

    public static Long b(String r1, com.alibaba.excel.metadata.a.c r2) {
        if (a(r2) == true) goto L7;
        long r3 = new BigDecimal(r1).longValue();
    L6:
        return Long.valueOf(r3);
    L7:
        r3 = h(r1, r2).longValue();
        goto L6
    }

    public static Integer c(String r1, com.alibaba.excel.metadata.a.c r2) {
        if (a(r2) == true) goto L7;
        int r3 = new BigDecimal(r1).intValue();
    L6:
        return Integer.valueOf(r3);
    L7:
        r3 = h(r1, r2).intValue();
        goto L6
    }

    public static Float d(String r1, com.alibaba.excel.metadata.a.c r2) {
        if (a(r2) == true) goto L7;
        float r3 = new BigDecimal(r1).floatValue();
    L6:
        return Float.valueOf(r3);
    L7:
        r3 = h(r1, r2).floatValue();
        goto L6
    }

    public static BigDecimal e(String r1, com.alibaba.excel.metadata.a.c r2) {
        if (a(r2) == true) goto L7;
        return new BigDecimal(r1);
    L7:
        return new BigDecimal(h(r1, r2).toString());
    }

    public static Byte f(String r1, com.alibaba.excel.metadata.a.c r2) {
        if (a(r2) == true) goto L7;
        byte r3 = new BigDecimal(r1).byteValue();
    L6:
        return Byte.valueOf(r3);
    L7:
        r3 = h(r1, r2).byteValue();
        goto L6
    }

    public static Double g(String r1, com.alibaba.excel.metadata.a.c r2) {
        if (a(r2) == true) goto L7;
        double r3 = new BigDecimal(r1).doubleValue();
    L6:
        return Double.valueOf(r3);
    L7:
        r3 = h(r1, r2).doubleValue();
        goto L6
    }

    private static Number h(String r2, com.alibaba.excel.metadata.a.c r3) {
        String r0 = r3.d().a();
        RoundingMode r4 = r3.d().b();
        DecimalFormat r1 = new DecimalFormat(r0);
        r1.setRoundingMode(r4);
        r1.setParseBigDecimal(true);
        return r1.parse(r2);
    }
}
