package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
public class DHParameters implements CipherParameters {
    private BigInteger g;
    private BigInteger j;
    private int l;
    private int m;
    private BigInteger p;
    private BigInteger q;
    private DHValidationParameters validation;

    public DHParameters(BigInteger r3, BigInteger r4) {
        this(r3, r4, null, 0);
    }

    public DHParameters(BigInteger r9, BigInteger r10, BigInteger r11, int r12) {
        this(r9, r10, r11, getDefaultMParam(r12), r12, null, null);
    }

    public DHParameters(BigInteger r2, BigInteger r3, BigInteger r4, int r5, int r6, BigInteger r7, DHValidationParameters r8) {
        if (r6 == 0) goto L13;
        if (r6 > r2.bitLength()) goto L11;
        if (r6 >= r5) goto L13;
        throw new IllegalArgumentException("when l value specified, it may not be less than m value");
    L11:
        throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
    L13:
        if (r5 > r2.bitLength()) goto L15;
    L19:
        this.g = r3;
        this.p = r2;
        this.q = r4;
        this.m = r5;
        this.l = r6;
        this.j = r7;
        this.validation = r8;
        return;
    L15:
        if (Properties.isOverrideSet("org.bouncycastle.dh.allow_unsafe_p_value") == true) goto L19;
        throw new IllegalArgumentException("unsafe p value so small specific l required");
    }

    public DHParameters(BigInteger r9, BigInteger r10, BigInteger r11, BigInteger r12, DHValidationParameters r13) {
        this(r9, r10, r11, 160, 0, r12, r13);
    }

    private static int getDefaultMParam(int r1) {
        if (r1 != 0) goto L5;
        return 160;
    L5:
        if (r1 >= 160) goto L8;
        return r1;
    L8:
        return 160;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DHParameters.class) == true) goto L5;
        return false;
    L5:
        DHParameters r5 = (DHParameters) ZeusTransformUtils.preCheckCast(r4, DHParameters.class, "com.obric.memorydata.plugin");
        if (getQ() == null) goto L11;
        if (getQ().equals(r5.getQ()) == true) goto L14;
        return false;
    L14:
        if (r5.getP().equals(this.p) == true) goto L16;
        return false;
    L16:
        if (r5.getG().equals(this.g) == false) goto L20;
        return true;
    L20:
        return false;
    L11:
        if (r5.getQ() == null) goto L14;
        return false;
    }

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getJ() {
        return this.j;
    }

    public int getL() {
        return this.l;
    }

    public int getM() {
        return this.m;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public DHValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        int r0 = getP().hashCode() ^ getG().hashCode();
        if (getQ() == null) goto L5;
        int r2 = getQ().hashCode();
    L7:
        return r2 ^ r0;
    L5:
        r2 = 0;
        goto L7
    }
}
