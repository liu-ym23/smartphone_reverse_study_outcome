package com.tom_roush.pdfbox.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes6.dex */
public class f extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigDecimal f16050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16051b;

    public f(float r2) {
        BigDecimal r0 = new BigDecimal(String.valueOf(r2));
        this.f16050a = r0;
        this.f16051b = b(r0.toPlainString());
    }

    public f(String r7) {
        this.f16051b = r7;     // Catch: NumberFormatException -> L5
        this.f16050a = new BigDecimal(this.f16051b);     // Catch: NumberFormatException -> L5
        d();     // Catch: NumberFormatException -> L5
        return;
    L5:
        e = move-exception;
        if (r7.startsWith("--") == false) goto L11;
        String r0 = r7.substring(1);
    L9:
        this.f16051b = r0;
        this.f16050a = new BigDecimal(this.f16051b);     // Catch: NumberFormatException -> L15
        d();     // Catch: NumberFormatException -> L15
        return;
    L15:
        e = move-exception;
        throw new IOException("Error expected floating point number actual='" + r7 + "'", e);
    L11:
        if (r7.matches("^0\\.0*\\-\\d+") == false) goto L19;
        r0 = "-" + this.f16051b.replaceFirst("\\-", "");
        goto L9
    L19:
        throw new IOException("Error expected floating point number actual='" + r7 + "'", e);
    }

    private String b(String r3) {
        if (r3.indexOf(46) > (-1)) goto L5;
    L11:
        return r3;
    L5:
        if (r3.endsWith(".0") == true) goto L11;
    L7:
        if (r3.endsWith("0") == false) goto L11;
        if (r3.endsWith(".0") == true) goto L11;
        r3 = r3.substring(0, r3.length() - 1);
        goto L7
    }

    private void d() {
        float r0 = this.f16050a.floatValue();
        double r1 = this.f16050a.doubleValue();
        boolean r5 = true;
        if (r0 == Float.NEGATIVE_INFINITY) goto L15;
        if (r0 == Float.POSITIVE_INFINITY) goto L15;
        if (r0 == 0.0f) goto L10;
    L21:
        r5 = false;
    L22:
        if (r5 == false) goto L25;
        BigDecimal r2 = BigDecimal.valueOf(r0);
        this.f16050a = r2;
        this.f16051b = b(r2.toPlainString());
        return;
    L25:
        return;
    L10:
        if (r1 == 0.0d) goto L21;
        if (Math.abs(r1) >= 1.1754943508222875E-38d) goto L21;
    L15:
        if (Math.abs(r1) <= 3.4028234663852886E38d) goto L21;
        if (r0 != Float.POSITIVE_INFINITY) goto L19;
        int r3 = 1;
    L20:
        r0 = r3 * Float.MAX_VALUE;
        goto L22
    L19:
        r3 = -1;
        goto L20
    }

    @Override // com.tom_roush.pdfbox.a.k
    public float a() {
        return this.f16050a.floatValue();
    }

    @Override // com.tom_roush.pdfbox.a.k
    public long b() {
        return this.f16050a.longValue();
    }

    @Override // com.tom_roush.pdfbox.a.k
    public int c() {
        return this.f16050a.intValue();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, f.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Float.floatToIntBits(((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin")).f16050a.floatValue()) != Float.floatToIntBits(this.f16050a.floatValue())) goto L7;
        return true;
    }

    public int hashCode() {
        return this.f16050a.hashCode();
    }

    public String toString() {
        return "COSFloat{" + this.f16051b + "}";
    }
}
