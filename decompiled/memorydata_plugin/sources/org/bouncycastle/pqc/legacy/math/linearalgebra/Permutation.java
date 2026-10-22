package org.bouncycastle.pqc.legacy.math.linearalgebra;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class Permutation {
    private int[] perm;

    public Permutation(byte[] r8) {
        if (r8.length <= 4) goto L17;
        int r0 = 0;
        int r3 = LittleEndianConversions.OS2IP(r8, 0);
        int r4 = IntegerFunctions.ceilLog256(r3 - 1);
        if (r8.length != ((r3 * r4) + 4)) goto L15;
        this.perm = new int[r3];
    L7:
        if (r0 >= r3) goto L10;
        this.perm[r0] = LittleEndianConversions.OS2IP(r8, (r0 * r4) + 4, r4);
        r0 = r0 + 1;
        goto L7
    L10:
        if (isPermutation(this.perm) == false) goto L13;
        return;
    L13:
        throw new IllegalArgumentException("invalid encoding");
    L15:
        throw new IllegalArgumentException("invalid encoding");
    L17:
        throw new IllegalArgumentException("invalid encoding");
    }

    private boolean isPermutation(int[] r6) {
        int r5 = r6.length;
        boolean[] r0 = new boolean[r5];
        int r2 = 0;
    L4:
        if (r2 >= r5) goto L14;
        if (r6[r2] < 0) goto L13;
        if (r6[r2] >= r5) goto L13;
        if (r0[r6[r2]] == true) goto L13;
        r0[r6[r2]] = true;
        r2 = r2 + 1;
    L13:
        return false;
    L14:
        return true;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Permutation.class) == true) goto L6;
        return false;
    L6:
        Permutation r4 = (Permutation) ZeusTransformUtils.preCheckCast(r3, Permutation.class, "com.obric.memorydata.plugin");
        return IntUtils.equals(this.perm, r4.perm);
    }

    public byte[] getEncoded() {
        int r0 = this.perm.length;
        int r1 = IntegerFunctions.ceilLog256(r0 - 1);
        byte[] r2 = new byte[(r0 * r1) + 4];
        int r3 = 0;
        LittleEndianConversions.I2OSP(r0, r2, 0);
    L3:
        if (r3 >= r0) goto L5;
        LittleEndianConversions.I2OSP(this.perm[r3], r2, (r3 * r1) + 4, r1);
        r3 = r3 + 1;
        goto L3
    L5:
        return r2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.perm);
    }

    public String toString() {
        String r0 = "[" + this.perm[0];
        int r1 = 1;
    L4:
        if (r1 >= this.perm.length) goto L7;
        r0 = r0 + ", " + this.perm[r1];
        r1 = r1 + 1;
        goto L4
    L7:
        return r0 + "]";
    }
}
