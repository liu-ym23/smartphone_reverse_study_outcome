package org.apache.commons.compress.archivers.zip;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes6.dex */
class BinaryTree {
    private final int[] tree;

    public BinaryTree(int r5) {
        if (r5 < 0) goto L9;
        if (r5 > 30) goto L9;
        int[] r6 = new int[(int) ((1 << (r5 + 1)) - 1)];
        this.tree = r6;
        Arrays.fill(r6, -1);
        return;
    L9:
        throw new IllegalArgumentException("depth must be bigger than 0 and not bigger than 30 but is " + r5);
    }

    static BinaryTree decode(InputStream r11, int r12) {
        if (r12 < 0) goto L47;
        int r0 = r11.read() + 1;
        if (r0 == 0) goto L45;
        byte[] r13 = IOUtils.readRange(r11, r0);
        if (r13.length != r0) goto L43;
        int[] r1 = new int[r12];
        int r2 = r13.length;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L8:
        if (r4 >= r2) goto L17;
        byte r7 = r13[r4];
        int r8 = ((r7 & 240) >> 4) + 1;
        if ((r5 + r8) > r12) goto L16;
        int r9 = (r7 & 15) + 1;
        int r10 = 0;
    L12:
        if (r10 >= r8) goto L14;
        r1[r5] = r9;
        r10 = r10 + 1;
        r5 = r5 + 1;
        goto L12
    L14:
        r6 = Math.max(r6, r9);
        r4 = r4 + 1;
        goto L8
    L16:
        throw new IOException("Number of values exceeds given total number of values");
    L17:
        int[] r14 = new int[r12];
        int r3 = 0;
    L18:
        if (r3 >= r12) goto L20;
        r14[r3] = r3;
        r3 = r3 + 1;
        goto L18
    L20:
        int[] r15 = new int[r12];
        int r16 = 0;
        int r17 = 0;
    L21:
        if (r16 >= r12) goto L29;
        int r18 = 0;
    L23:
        if (r18 >= r12) goto L28;
        if (r1[r18] != r16) goto L27;
        r15[r17] = r16;
        r14[r17] = r18;
        r17 = r17 + 1;
    L27:
        r18 = r18 + 1;
        goto L23
    L28:
        r16 = r16 + 1;
        goto L21
    L29:
        int[] r19 = new int[r12];
        int r20 = r12 - 1;
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
    L30:
        if (r20 < 0) goto L35;
        r21 = r21 + r22;
        if (r15[r20] == r23) goto L34;
        r23 = r15[r20];
        r22 = 1 << (16 - r23);
    L34:
        r19[r14[r20]] = r21;
        r20 = r20 - 1;
        goto L30
    L35:
        BinaryTree r110 = new BinaryTree(r6);
        int r24 = 0;
    L36:
        if (r24 >= r12) goto L41;
        int r25 = r1[r24];
        if (r25 <= 0) goto L40;
        r110.addLeaf(0, Integer.reverse(r19[r24] << 16), r25, r24);
    L40:
        r24 = r24 + 1;
        goto L36
    L41:
        return r110;
    L43:
        throw new EOFException();
    L45:
        throw new IOException("Cannot read the size of the encoded tree, unexpected end of stream");
    L47:
        throw new IllegalArgumentException("totalNumberOfValues must be bigger than 0, is " + r12);
    }

    public void addLeaf(int r3, int r4, int r5, int r6) {
        if (r5 != 0) goto L8;
        int[] r7 = this.tree;
        if (r7[r3] != (-1)) goto L7;
        r7[r3] = r6;
        return;
    L7:
        throw new IllegalArgumentException("Tree value at index " + r3 + " has already been assigned (" + this.tree[r3] + ")");
    L8:
        this.tree[r3] = -2;
        addLeaf(((r3 * 2) + 1) + (r4 & 1), r4 >>> 1, r5 - 1, r6);
    }

    public int read(BitStream r7) {
        int r0 = 0;
    L3:
        int r1 = r7.nextBit();
        if (r1 == (-1)) goto L5;
        int r3 = ((r0 * 2) + 1) + r1;
        int r4 = this.tree[r3];
        if (r4 != (-2)) goto L9;
        r0 = r3;
        goto L3
    L9:
        if (r4 == (-1)) goto L12;
        return r4;
    L12:
        throw new IOException("The child " + r1 + " of node at index " + r0 + " is not defined");
    L5:
        return -1;
    }
}
