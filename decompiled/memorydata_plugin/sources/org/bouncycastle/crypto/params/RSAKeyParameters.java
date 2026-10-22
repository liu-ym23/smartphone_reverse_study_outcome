package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.math.Primes;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
public class RSAKeyParameters extends AsymmetricKeyParameter {
    private static final BigInteger ONE = null;
    private static final BigInteger SMALL_PRIMES_PRODUCT = null;
    private static final BigIntegers.Cache validated = null;
    private BigInteger exponent;
    private BigInteger modulus;

    static {
        validated = new BigIntegers.Cache();
        SMALL_PRIMES_PRODUCT = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);
        ONE = BigInteger.valueOf(1);
    }

    public RSAKeyParameters(boolean r2, BigInteger r3, BigInteger r4) {
        this(r2, r3, r4, false);
    }

    public RSAKeyParameters(boolean r1, BigInteger r2, BigInteger r3, boolean r4) {
        super(r1);
        if (r1 == true) goto L10;
        if ((r3.intValue() & 1) != 0) goto L10;
        throw new IllegalArgumentException("RSA publicExponent is even");
    L10:
        if (validated.contains(r2) == true) goto L13;
        r2 = validate(r2, r4);
    L13:
        this.modulus = r2;
        this.exponent = r3;
    }

    private BigInteger validate(BigInteger r1, boolean r2) {
        if (r2 == false) goto L6;
    L3:
        validated.add(r1);
        return r1;
    L6:
        if ((r1.intValue() & 1) == 0) goto L34;
        if (Properties.isOverrideSet("org.bouncycastle.rsa.allow_unsafe_mod") == false) goto L11;
        return r1;
    L11:
        if (Properties.asInteger("org.bouncycastle.rsa.max_size", 15360) < r1.bitLength()) goto L32;
        if (r1.gcd(SMALL_PRIMES_PRODUCT).equals(ONE) == false) goto L30;
        int r0 = r1.bitLength() / 2;
        if (r0 < 1536) goto L18;
        int r3 = 3;
    L25:
        if (Primes.enhancedMRProbablePrimeTest(r1, CryptoServicesRegistrar.getSecureRandom(), r3).isProvablyComposite() == true) goto L3;
        throw new IllegalArgumentException("RSA modulus is not composite");
    L18:
        if (r0 < 1024) goto L21;
        r3 = 4;
        goto L25
    L21:
        if (r0 < 512) goto L23;
        r3 = 7;
        goto L25
    L23:
        r3 = 50;
        goto L25
    L30:
        throw new IllegalArgumentException("RSA modulus has a small prime factor");
    L32:
        throw new IllegalArgumentException("modulus value out of range");
    L34:
        throw new IllegalArgumentException("RSA modulus is even");
    }

    public BigInteger getExponent() {
        return this.exponent;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }
}
