package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e f3578a = null;

    static {
        f3578a = new e();
    }

    private e() {
    }

    public static String a(String r2, IDateTimeValueType r3) {
        IDateTimeValueType r4 = (IDateTimeValueType) ZeusTransformUtils.wrapperContextForParams(r3, IDateTimeValueType.class, "com.obric.memorydata.plugin");
        return f3578a.a(r2, r4.getBigValue());
    }

    private void a(Integer r1, int r2, StringBuffer r3) {
        if (r1 != null) goto L4;
        r3.append("00");
        return;
    L4:
        a(r1.intValue() + r2, r3);
    }

    private void a(Integer r2, StringBuffer r3) {
        a(r2, 0, r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public /* bridge */ /* synthetic */ String a(String r1, Object r2) {
        return super.a(r1, r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public Calendar a(Object r2) {
        return ((BigDateTimeValueType) ZeusTransformUtils.preCheckCast(r2, BigDateTimeValueType.class, "com.obric.memorydata.plugin")).toCalendar();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void a(Object r2, StringBuffer r3) {
        BigInteger r1 = ((IDateTimeValueType) ZeusTransformUtils.preCheckCast(r2, IDateTimeValueType.class, "com.obric.memorydata.plugin")).getBigValue().getYear();
        if (r1 != null) goto L7;
        r3.append("0000");
        return;
    L7:
        if (r1.signum() > 0) goto L9;
        r3.append('-');
        r1 = r1.negate().add(BigInteger.ONE);
    L9:
        String r4 = r1.toString();
    L11:
        if (r4.length() >= 4) goto L13;
        r4 = "0" + r4;
        goto L11
    L13:
        r3.append(r4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void b(Object r3, StringBuffer r4) {
        a(((IDateTimeValueType) ZeusTransformUtils.preCheckCast(r3, IDateTimeValueType.class, "com.obric.memorydata.plugin")).getBigValue().getMonth(), 1, r4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void c(Object r3, StringBuffer r4) {
        a(((IDateTimeValueType) ZeusTransformUtils.preCheckCast(r3, IDateTimeValueType.class, "com.obric.memorydata.plugin")).getBigValue().getDay(), 1, r4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void d(Object r3, StringBuffer r4) {
        a(((IDateTimeValueType) ZeusTransformUtils.preCheckCast(r3, IDateTimeValueType.class, "com.obric.memorydata.plugin")).getBigValue().getHour(), r4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void e(Object r3, StringBuffer r4) {
        a(((IDateTimeValueType) ZeusTransformUtils.preCheckCast(r3, IDateTimeValueType.class, "com.obric.memorydata.plugin")).getBigValue().getMinute(), r4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void f(Object r4, StringBuffer r5) {
        BigDecimal r3 = ((IDateTimeValueType) ZeusTransformUtils.preCheckCast(r4, IDateTimeValueType.class, "com.obric.memorydata.plugin")).getBigValue().getSecond();
        if (r3 != null) goto L7;
        r5.append("00");
        return;
    L7:
        if (r3.scale() <= 0) goto L11;
        if (r3.toString().endsWith("0") == false) goto L11;
        r3 = r3.movePointLeft(1);
    L11:
        String r6 = r3.toString();
        if (r3.compareTo(new BigDecimal("10")) >= 0) goto L14;
        r6 = "0" + r6;
    L14:
        r5.append(r6);
    }
}
