package org.bouncycastle.pqc.math.linearalgebra;

/* JADX INFO: loaded from: classes7.dex */
public final class IntUtils {
    public static int[] clone(int[] r3) {
        int[] r0 = new int[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }
}
