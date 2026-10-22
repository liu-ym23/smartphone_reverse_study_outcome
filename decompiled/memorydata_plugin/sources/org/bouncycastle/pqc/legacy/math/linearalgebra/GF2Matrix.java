package org.bouncycastle.pqc.legacy.math.linearalgebra;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class GF2Matrix extends Matrix {
    private int length;
    private int[][] matrix;

    public GF2Matrix(int r6, int[][] r7) {
        int r0 = 0;
        if (r7[0].length != ((r6 + 31) >> 5)) goto L14;
        this.numColumns = r6;
        this.numRows = r7.length;
        this.length = r7[0].length;
        int r8 = r6 & 31;
        if (r8 != 0) goto L7;
        int r9 = -1;
    L9:
        if (r0 >= this.numRows) goto L11;
        int[] r2 = r7[r0];
        int r3 = this.length - 1;
        r2[r3] = r2[r3] & r9;
        r0 = r0 + 1;
        goto L9
    L11:
        this.matrix = r7;
        return;
    L7:
        r9 = (1 << r8) - 1;
        goto L9
    L14:
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public GF2Matrix(GF2Matrix r4) {
        this.numColumns = r4.getNumColumns();
        this.numRows = r4.getNumRows();
        this.length = r4.length;
        this.matrix = new int[r4.matrix.length][];
        int r0 = 0;
    L3:
        int[][] r1 = this.matrix;
        if (r0 >= r1.length) goto L6;
        r1[r0] = IntUtils.clone(r4.matrix[r0]);
        r0 = r0 + 1;
        goto L3
    }

    public GF2Matrix(byte[] r10) {
        if (r10.length < 9) goto L22;
        this.numRows = LittleEndianConversions.OS2IP(r10, 0);
        this.numColumns = LittleEndianConversions.OS2IP(r10, 4);
        int r2 = ((this.numColumns + 7) >>> 3) * this.numRows;
        if (this.numRows <= 0) goto L20;
        int r4 = 8;
        if (r2 != (r10.length - 8)) goto L20;
        this.length = (this.numColumns + 31) >>> 5;
        this.matrix = (int[][]) Array.newInstance(int.class, new int[]{this.numRows, this.length});
        int r1 = this.numColumns >> 5;
        int r3 = this.numColumns & 31;
        int r5 = 0;
    L10:
        if (r5 >= this.numRows) goto L18;
        int r6 = 0;
    L12:
        if (r6 >= r1) goto L14;
        this.matrix[r5][r6] = LittleEndianConversions.OS2IP(r10, r4);
        r6 = r6 + 1;
        r4 = r4 + 4;
        goto L12
    L14:
        int r7 = 0;
    L15:
        if (r7 >= r3) goto L17;
        int[] r8 = this.matrix[r5];
        r8[r1] = ((r10[r4] & 255) << r7) ^ r8[r1];
        r7 = r7 + 8;
        r4 = r4 + 1;
        goto L15
    L17:
        r5 = r5 + 1;
        goto L10
    L18:
        return;
    L20:
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    L22:
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, GF2Matrix.class) == true) goto L5;
        return false;
    L5:
        GF2Matrix r6 = (GF2Matrix) ZeusTransformUtils.preCheckCast(r5, GF2Matrix.class, "com.obric.memorydata.plugin");
        if (this.numRows == r6.numRows) goto L8;
    L21:
        return false;
    L8:
        if (this.numColumns != r6.numColumns) goto L21;
        if (this.length != r6.length) goto L21;
        int r0 = 0;
    L14:
        if (r0 >= this.numRows) goto L19;
        if (IntUtils.equals(this.matrix[r0], r6.matrix[r0]) == false) goto L17;
        r0 = r0 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public byte[] getEncoded() {
        int r1 = 8;
        byte[] r0 = new byte[(((this.numColumns + 7) >>> 3) * this.numRows) + 8];
        LittleEndianConversions.I2OSP(this.numRows, r0, 0);
        LittleEndianConversions.I2OSP(this.numColumns, r0, 4);
        int r2 = this.numColumns >>> 5;
        int r4 = this.numColumns & 31;
        int r5 = 0;
    L4:
        if (r5 >= this.numRows) goto L12;
        int r6 = 0;
    L6:
        if (r6 >= r2) goto L8;
        LittleEndianConversions.I2OSP(this.matrix[r5][r6], r0, r1);
        r6 = r6 + 1;
        r1 = r1 + 4;
        goto L6
    L8:
        int r7 = 0;
    L9:
        if (r7 >= r4) goto L11;
        r0[r1] = (byte) ((this.matrix[r5][r2] >>> r7) & 255);
        r7 = r7 + 8;
        r1 = r1 + 1;
        goto L9
    L11:
        r5 = r5 + 1;
        goto L4
    L12:
        return r0;
    }

    public int hashCode() {
        int r0 = (((this.numRows * 31) + this.numColumns) * 31) + this.length;
        int r1 = 0;
    L4:
        if (r1 >= this.numRows) goto L6;
        r0 = (r0 * 31) + Arrays.hashCode(this.matrix[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public String toString() {
        int r0 = this.numColumns & 31;
        int r1 = this.length;
        if (r0 == 0) goto L6;
        r1 = r1 - 1;
    L6:
        StringBuffer r2 = new StringBuffer();
        int r4 = 0;
    L8:
        if (r4 >= this.numRows) goto L30;
        r2.append(r4 + ": ");
        int r5 = 0;
    L11:
        if (r5 >= r1) goto L21;
        int r8 = this.matrix[r4][r5];
        int r9 = 0;
    L14:
        if (r9 >= 32) goto L20;
        if (((r8 >>> r9) & 1) != 0) goto L18;
        r2.append('0');
    L19:
        r9 = r9 + 1;
        goto L14
    L18:
        r2.append('1');
        goto L19
    L20:
        r2.append(' ');
        r5 = r5 + 1;
        goto L11
    L21:
        int r6 = this.matrix[r4][this.length - 1];
        int r10 = 0;
    L22:
        if (r10 >= r0) goto L28;
        if (((r6 >>> r10) & 1) != 0) goto L26;
        r2.append('0');
    L27:
        r10 = r10 + 1;
        goto L22
    L26:
        r2.append('1');
        goto L27
    L28:
        r2.append('\n');
        r4 = r4 + 1;
        goto L8
    L30:
        return r2.toString();
    }
}
