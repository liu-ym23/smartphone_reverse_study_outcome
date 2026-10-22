package org.apache.commons.math3.random;

import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractWell extends BitsStreamGenerator implements Serializable {
    private static final long serialVersionUID = -817701723016583596L;
    protected final int[] i1;
    protected final int[] i2;
    protected final int[] i3;
    protected final int[] iRm1;
    protected final int[] iRm2;
    protected int index;
    protected final int[] v;

    public AbstractWell(int r7, int r8, int r9, int r10) {
        this(r7, r8, r9, r10, null);
    }

    public AbstractWell(int r8, int r9, int r10, int r11, int r12) {
        this(r8, r9, r10, r11, new int[]{r12});
    }

    public AbstractWell(int r8, int r9, int r10, int r11, long r12) {
        this(r8, r9, r10, r11, new int[]{(int) (r12 >>> 32), (int) (r12 & 4294967295L)});
    }

    public AbstractWell(int r5, int r6, int r7, int r8, int[] r9) {
        int r10 = ((r5 + 32) - 1) / 32;
        this.v = new int[r10];
        int r0 = 0;
        this.index = 0;
        this.iRm1 = new int[r10];
        this.iRm2 = new int[r10];
        this.i1 = new int[r10];
        this.i2 = new int[r10];
        this.i3 = new int[r10];
    L3:
        if (r0 >= r10) goto L5;
        int r2 = r0 + r10;
        this.iRm1[r0] = (r2 - 1) % r10;
        this.iRm2[r0] = (r2 - 2) % r10;
        this.i1[r0] = (r0 + r6) % r10;
        this.i2[r0] = (r0 + r7) % r10;
        this.i3[r0] = (r0 + r8) % r10;
        r0 = r0 + 1;
        goto L3
    L5:
        setSeed(r9);
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator
    public abstract int next(int r1);

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int r3) {
        setSeed(new int[]{r3});
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(long r4) {
        setSeed(new int[]{(int) (r4 >>> 32), (int) (r4 & 4294967295L)});
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int[] r10) {
        if (r10 != null) goto L5;
        setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
        return;
    L5:
        int[] r0 = this.v;
        System.arraycopy(r10, 0, r0, 0, FastMath.min(r10.length, r0.length));
        if (r10.length >= this.v.length) goto L11;
        int r1 = r10.length;
    L8:
        int[] r2 = this.v;
        if (r1 >= r2.length) goto L11;
        long r3 = r2[r1 - r10.length];
        r2[r1] = (int) ((((r3 ^ (r3 >> 30)) * 1812433253) + ((long) r1)) & 4294967295L);
        r1 = r1 + 1;
    L11:
        this.index = 0;
        clear();
    }
}
