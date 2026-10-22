package org.bouncycastle.crypto.agreement.jpake;

import com.loc.o;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class JPAKEPrimeOrderGroup {
    private final BigInteger g;
    private final BigInteger p;
    private final BigInteger q;

    JPAKEPrimeOrderGroup(BigInteger r3, BigInteger r4, BigInteger r5, boolean r6) {
        JPAKEUtil.validateNotNull(r3, "p");
        JPAKEUtil.validateNotNull(r4, "q");
        JPAKEUtil.validateNotNull(r5, o.f);
        if (r6 == false) goto L5;
    L27:
        this.p = r3;
        this.q = r4;
        this.g = r5;
        return;
    L5:
        if (r3.subtract(JPAKEUtil.ONE).mod(r4).equals(JPAKEUtil.ZERO) == false) goto L26;
        if (r5.compareTo(BigInteger.valueOf(2)) == (-1)) goto L24;
        if (r5.compareTo(r3.subtract(JPAKEUtil.ONE)) == 1) goto L24;
        if (r5.modPow(r4, r3).equals(JPAKEUtil.ONE) == false) goto L22;
        if (r3.isProbablePrime(20) == false) goto L20;
        if (r4.isProbablePrime(20) == true) goto L27;
        throw new IllegalArgumentException("q must be prime");
    L20:
        throw new IllegalArgumentException("p must be prime");
    L22:
        throw new IllegalArgumentException("g^q mod p must equal 1");
    L24:
        throw new IllegalArgumentException("g must be in [2, p-1]");
    L26:
        throw new IllegalArgumentException("p-1 must be evenly divisible by q");
    }

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }
}
