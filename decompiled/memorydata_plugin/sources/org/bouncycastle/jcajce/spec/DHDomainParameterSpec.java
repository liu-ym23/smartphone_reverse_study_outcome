package org.bouncycastle.jcajce.spec;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;

/* JADX INFO: loaded from: classes7.dex */
public class DHDomainParameterSpec extends DHParameterSpec {
    private final BigInteger j;
    private final int m;
    private final BigInteger q;
    private DHValidationParameters validationParameters;

    public DHDomainParameterSpec(BigInteger r8, BigInteger r9, BigInteger r10, BigInteger r11, int r12) {
        this(r8, r9, r10, r11, 0, r12);
    }

    public DHDomainParameterSpec(BigInteger r1, BigInteger r2, BigInteger r3, BigInteger r4, int r5, int r6) {
        super(r1, r3, r6);
        this.q = r2;
        this.j = r4;
        this.m = r5;
    }

    public DHDomainParameterSpec(DHParameters r8) {
        this(r8.getP(), r8.getQ(), r8.getG(), r8.getJ(), r8.getM(), r8.getL());
        this.validationParameters = r8.getValidationParameters();
    }

    public DHParameters getDomainParameters() {
        return new DHParameters(getP(), getG(), this.q, this.m, getL(), this.j, this.validationParameters);
    }

    public BigInteger getQ() {
        return this.q;
    }
}
