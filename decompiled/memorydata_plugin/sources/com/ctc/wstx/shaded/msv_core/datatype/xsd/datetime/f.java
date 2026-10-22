package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class f extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BigInteger f3579b;
    private Integer c;
    private Integer d;
    private Integer e;
    private Integer f;
    private BigDecimal g;
    private java.util.TimeZone h;

    private f(String r1, String r2) {
        super(r1, r2);
    }

    public static BigDateTimeValueType a(String r1, String r2) {
        f r0 = new f(r1, r2);
        r0.a();
        return r0.d();
    }

    private BigDateTimeValueType d() {
        return new BigDateTimeValueType(this.f3579b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void a(int r4) {
        BigDecimal r0 = new BigDecimal(BigInteger.valueOf(r4));
        BigDecimal r5 = this.g;
        if (r5 != null) goto L5;
        this.g = r0;
        return;
    L5:
        this.g = r5.add(r0);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void a(java.util.TimeZone r2) {
        if (r2 != TimeZone.MISSING) goto L5;
        r2 = null;
    L5:
        this.h = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void b(int r2) {
        this.f = new Integer(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void c() {
        int r0 = this.f3574a;
        BigDecimal r2 = new BigDecimal(b(1, Integer.MAX_VALUE), this.f3574a - r0);
        BigDecimal r1 = this.g;
        if (r1 != null) goto L5;
        this.g = r2;
        return;
    L5:
        this.g = r1.add(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void c(int r2) {
        this.e = new Integer(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void d(int r2) {
        this.d = new Integer(r2 - 1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void e(int r2) {
        this.c = new Integer(r2 - 1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void f(int r3) {
        this.f3579b = BigInteger.valueOf(r3);
    }
}
