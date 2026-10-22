package org.bouncycastle.util.test;

import java.math.BigInteger;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes7.dex */
public class TestRandomBigInteger extends FixedSecureRandom {
    public TestRandomBigInteger(int r3, byte[] r4) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(r3, r4)});
    }

    public TestRandomBigInteger(String r2) {
        this(r2, 10);
    }

    public TestRandomBigInteger(String r4, int r5) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(BigIntegers.asUnsignedByteArray(new BigInteger(r4, r5)))});
    }

    public TestRandomBigInteger(byte[] r3) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(r3)});
    }
}
