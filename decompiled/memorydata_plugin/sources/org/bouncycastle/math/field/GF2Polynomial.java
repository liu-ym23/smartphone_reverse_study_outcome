package org.bouncycastle.math.field;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
class GF2Polynomial implements Polynomial {
    protected final int[] exponents;

    GF2Polynomial(int[] r1) {
        this.exponents = Arrays.clone(r1);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, GF2Polynomial.class) == true) goto L10;
        return false;
    L10:
        GF2Polynomial r4 = (GF2Polynomial) ZeusTransformUtils.preCheckCast(r3, GF2Polynomial.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.exponents, r4.exponents);
    }

    @Override // org.bouncycastle.math.field.Polynomial
    public int getDegree() {
        int[] r1 = this.exponents;
        return r1[r1.length - 1];
    }

    @Override // org.bouncycastle.math.field.Polynomial
    public int[] getExponentsPresent() {
        return Arrays.clone(this.exponents);
    }

    public int hashCode() {
        return Arrays.hashCode(this.exponents);
    }
}
