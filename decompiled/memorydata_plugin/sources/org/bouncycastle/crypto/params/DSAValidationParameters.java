package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class DSAValidationParameters {
    private int counter;
    private byte[] seed;
    private int usageIndex;

    public DSAValidationParameters(byte[] r2, int r3) {
        this(r2, r3, -1);
    }

    public DSAValidationParameters(byte[] r1, int r2, int r3) {
        this.seed = Arrays.clone(r1);
        this.counter = r2;
        this.usageIndex = r3;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DSAValidationParameters.class) == true) goto L5;
        return false;
    L5:
        DSAValidationParameters r5 = (DSAValidationParameters) ZeusTransformUtils.preCheckCast(r4, DSAValidationParameters.class, "com.obric.memorydata.plugin");
        if (r5.counter == this.counter) goto L9;
        return false;
    L9:
        return Arrays.areEqual(this.seed, r5.seed);
    }

    public int getCounter() {
        return this.counter;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public int hashCode() {
        int r0 = this.counter;
        return Arrays.hashCode(this.seed) ^ r0;
    }
}
