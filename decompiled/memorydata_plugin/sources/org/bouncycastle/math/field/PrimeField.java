package org.bouncycastle.math.field;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
class PrimeField implements FiniteField {
    protected final BigInteger characteristic;

    PrimeField(BigInteger r1) {
        this.characteristic = r1;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, PrimeField.class) == true) goto L10;
        return false;
    L10:
        PrimeField r4 = (PrimeField) ZeusTransformUtils.preCheckCast(r3, PrimeField.class, "com.obric.memorydata.plugin");
        return this.characteristic.equals(r4.characteristic);
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public BigInteger getCharacteristic() {
        return this.characteristic;
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public int getDimension() {
        return 1;
    }

    public int hashCode() {
        return this.characteristic.hashCode();
    }
}
