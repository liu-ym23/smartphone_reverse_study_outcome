package org.bouncycastle.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public final class Arrays {

    public static class Iterator<T> implements java.util.Iterator<T> {
        private final T[] dataArray;
        private int position;

        public Iterator(T[] r2) {
            this.position = 0;
            this.dataArray = r2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.position >= this.dataArray.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            int r0 = this.position;
            T[] r1 = this.dataArray;
            if (r0 == r1.length) goto L7;
            this.position = r0 + 1;
            return r1[r0];
        L7:
            throw new NoSuchElementException("Out of elements: " + this.position);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    public static boolean areEqual(byte[] r3, int r4, int r5, byte[] r6, int r7, int r8) {
        int r9 = r5 - r4;
        if (r9 == (r8 - r7)) goto L5;
        return false;
    L5:
        int r10 = 0;
    L6:
        if (r10 >= r9) goto L11;
        if (r3[r4 + r10] != r6[r7 + r10]) goto L9;
        r10 = r10 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static boolean areEqual(byte[] r0, byte[] r1) {
        return java.util.Arrays.equals(r0, r1);
    }

    public static boolean areEqual(char[] r0, char[] r1) {
        return java.util.Arrays.equals(r0, r1);
    }

    public static boolean areEqual(int[] r0, int[] r1) {
        return java.util.Arrays.equals(r0, r1);
    }

    public static boolean areEqual(short[] r0, short[] r1) {
        return java.util.Arrays.equals(r0, r1);
    }

    public static void clear(byte[] r1) {
        if (r1 == null) goto L5;
        java.util.Arrays.fill(r1, (byte) 0);
        return;
    }

    public static byte[] clone(byte[] r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return (byte[]) ZeusTransformUtils.preCheckCast(r2.clone(), byte[].class, "com.obric.memorydata.plugin");
    }

    public static char[] clone(char[] r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return (char[]) ZeusTransformUtils.preCheckCast(r2.clone(), char[].class, "com.obric.memorydata.plugin");
    }

    public static int[] clone(int[] r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return (int[]) ZeusTransformUtils.preCheckCast(r2.clone(), int[].class, "com.obric.memorydata.plugin");
    }

    public static long[] clone(long[] r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return (long[]) ZeusTransformUtils.preCheckCast(r2.clone(), long[].class, "com.obric.memorydata.plugin");
    }

    public static short[] clone(short[] r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return (short[]) ZeusTransformUtils.preCheckCast(r2.clone(), short[].class, "com.obric.memorydata.plugin");
    }

    public static boolean[] clone(boolean[] r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return (boolean[]) ZeusTransformUtils.preCheckCast(r2.clone(), boolean[].class, "com.obric.memorydata.plugin");
    }

    public static byte[] concatenate(byte[] r3, byte[] r4) {
        if (r3 == null) goto L4;
        if (r4 == null) goto L7;
        byte[] r0 = new byte[r3.length + r4.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        System.arraycopy(r4, 0, r0, r3.length, r4.length);
        return r0;
    L7:
        return clone(r3);
    L4:
        return clone(r4);
    }

    public static byte[] concatenate(byte[] r3, byte[] r4, byte[] r5) {
        if (r3 == null) goto L4;
        if (r4 == null) goto L7;
        if (r5 == null) goto L10;
        byte[] r0 = new byte[(r3.length + r4.length) + r5.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        int r6 = r3.length + 0;
        System.arraycopy(r4, 0, r0, r6, r4.length);
        System.arraycopy(r5, 0, r0, r6 + r4.length, r5.length);
        return r0;
    L10:
        return concatenate(r3, r4);
    L7:
        return concatenate(r3, r5);
    L4:
        return concatenate(r4, r5);
    }

    public static byte[] concatenate(byte[] r3, byte[] r4, byte[] r5, byte[] r6) {
        if (r3 == null) goto L4;
        if (r4 == null) goto L7;
        if (r5 == null) goto L10;
        if (r6 == null) goto L13;
        byte[] r0 = new byte[((r3.length + r4.length) + r5.length) + r6.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        int r7 = r3.length + 0;
        System.arraycopy(r4, 0, r0, r7, r4.length);
        int r8 = r7 + r4.length;
        System.arraycopy(r5, 0, r0, r8, r5.length);
        System.arraycopy(r6, 0, r0, r8 + r5.length, r6.length);
        return r0;
    L13:
        return concatenate(r3, r4, r5);
    L10:
        return concatenate(r3, r4, r6);
    L7:
        return concatenate(r3, r5, r6);
    L4:
        return concatenate(r4, r5, r6);
    }

    public static byte[] concatenate(byte[][] r6) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 == r6.length) goto L6;
        r2 = r2 + r6[r1].length;
        r1 = r1 + 1;
        goto L4
    L6:
        byte[] r3 = new byte[r2];
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 == r6.length) goto L10;
        System.arraycopy(r6[r4], 0, r3, r5, r6[r4].length);
        r5 = r5 + r6[r4].length;
        r4 = r4 + 1;
        goto L8
    L10:
        return r3;
    }

    public static boolean constantTimeAreEqual(byte[] r7, byte[] r8) {
        if (r7 == null) goto L24;
        if (r8 != null) goto L7;
        return false;
    L7:
        if (r7 != r8) goto L10;
        return true;
    L10:
        if (r7.length >= r8.length) goto L12;
        int r2 = r7.length;
    L13:
        int r3 = r7.length ^ r8.length;
        int r4 = 0;
    L14:
        if (r4 == r2) goto L17;
        r3 = r3 | (r7[r4] ^ r8[r4]);
        r4 = r4 + 1;
    L17:
        if (r2 >= r8.length) goto L19;
        r3 = r3 | (r8[r2] ^ (~r8[r2]));
        r2 = r2 + 1;
        goto L17
    L19:
        if (r3 == 0) goto L21;
        return false;
    L21:
        return true;
    L12:
        r2 = r8.length;
        goto L13
    L24:
        return false;
    }

    public static byte[] copyOf(byte[] r2, int r3) {
        byte[] r0 = new byte[r3];
        System.arraycopy(r2, 0, r0, 0, Math.min(r2.length, r3));
        return r0;
    }

    public static char[] copyOf(char[] r2, int r3) {
        char[] r0 = new char[r3];
        System.arraycopy(r2, 0, r0, 0, Math.min(r2.length, r3));
        return r0;
    }

    public static BigInteger[] copyOf(BigInteger[] r2, int r3) {
        BigInteger[] r0 = new BigInteger[r3];
        System.arraycopy(r2, 0, r0, 0, Math.min(r2.length, r3));
        return r0;
    }

    public static byte[] copyOfRange(byte[] r2, int r3, int r4) {
        int r5 = getLength(r3, r4);
        byte[] r0 = new byte[r5];
        System.arraycopy(r2, r3, r0, 0, Math.min(r2.length - r3, r5));
        return r0;
    }

    public static int[] copyOfRange(int[] r2, int r3, int r4) {
        int r5 = getLength(r3, r4);
        int[] r0 = new int[r5];
        System.arraycopy(r2, r3, r0, 0, Math.min(r2.length - r3, r5));
        return r0;
    }

    public static void fill(byte[] r0, byte r1) {
        java.util.Arrays.fill(r0, r1);
    }

    public static void fill(byte[] r0, int r1, int r2, byte r3) {
        java.util.Arrays.fill(r0, r1, r2, r3);
    }

    public static void fill(char[] r0, char r1) {
        java.util.Arrays.fill(r0, r1);
    }

    public static void fill(int[] r0, int r1) {
        java.util.Arrays.fill(r0, r1);
    }

    private static int getLength(int r1, int r2) {
        int r0 = r2 - r1;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        StringBuffer r3 = new StringBuffer(r1);
        r3.append(" > ").append(r2);
        throw new IllegalArgumentException(r3.toString());
    }

    public static int hashCode(byte[] r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r0 = r3.length;
        int r1 = r0 + 1;
    L6:
        r0 = r0 - 1;
        if (r0 < 0) goto L9;
        r1 = (r1 * 257) ^ r3[r0];
        goto L6
    L9:
        return r1;
    }

    public static int hashCode(byte[] r2, int r3, int r4) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        int r0 = r4 + 1;
    L6:
        r4 = r4 - 1;
        if (r4 < 0) goto L9;
        r0 = (r0 * 257) ^ r2[r3 + r4];
        goto L6
    L9:
        return r0;
    }

    public static int hashCode(char[] r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r0 = r3.length;
        int r1 = r0 + 1;
    L6:
        r0 = r0 - 1;
        if (r0 < 0) goto L9;
        r1 = (r1 * 257) ^ r3[r0];
        goto L6
    L9:
        return r1;
    }

    public static int hashCode(int[] r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r0 = r3.length;
        int r1 = r0 + 1;
    L6:
        r0 = r0 - 1;
        if (r0 < 0) goto L9;
        r1 = (r1 * 257) ^ r3[r0];
        goto L6
    L9:
        return r1;
    }

    public static int hashCode(int[] r2, int r3, int r4) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        int r0 = r4 + 1;
    L6:
        r4 = r4 - 1;
        if (r4 < 0) goto L9;
        r0 = (r0 * 257) ^ r2[r3 + r4];
        goto L6
    L9:
        return r0;
    }

    public static int hashCode(long[] r4, int r5, int r6) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        int r0 = r6 + 1;
    L6:
        r6 = r6 - 1;
        if (r6 < 0) goto L9;
        long r1 = r4[r5 + r6];
        r0 = (((r0 * 257) ^ ((int) r1)) * 257) ^ ((int) (r1 >>> 32));
        goto L6
    L9:
        return r0;
    }

    public static int hashCode(short[] r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r0 = r3.length;
        int r1 = r0 + 1;
    L6:
        r0 = r0 - 1;
        if (r0 < 0) goto L9;
        r1 = (r1 * 257) ^ (r3[r0] & 255);
        goto L6
    L9:
        return r1;
    }

    public static int hashCode(short[][] r3) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 == r3.length) goto L6;
        r1 = (r1 * 257) + hashCode(r3[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public static int hashCode(short[][][] r3) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 == r3.length) goto L6;
        r1 = (r1 * 257) + hashCode(r3[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public static boolean isNullOrContainsNull(Object[] r5) {
        if (r5 != null) goto L5;
        return true;
    L5:
        int r1 = r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        if (r5[r3] == null) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    public static byte[] prepend(byte[] r4, byte r5) {
        if (r4 == null) goto L5;
        int r2 = r4.length;
        byte[] r3 = new byte[r2 + 1];
        System.arraycopy(r4, 0, r3, 1, r2);
        r3[0] = r5;
        return r3;
    L5:
        return new byte[]{r5};
    }

    public static byte[] reverse(byte[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = 0;
        int r1 = r4.length;
        byte[] r2 = new byte[r1];
    L6:
        r1 = r1 - 1;
        if (r1 < 0) goto L9;
        r2[r1] = r4[r0];
        r0 = r0 + 1;
        goto L6
    L9:
        return r2;
    }

    public static byte[] reverseInPlace(byte[] r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r0 = 0;
        int r1 = r5.length - 1;
    L6:
        if (r0 >= r1) goto L8;
        byte r2 = r5[r0];
        r5[r0] = r5[r1];
        r5[r1] = r2;
        r1 = r1 - 1;
        r0 = r0 + 1;
        goto L6
    L8:
        return r5;
    }

    public static int[] reverseInPlace(int[] r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r0 = 0;
        int r1 = r5.length - 1;
    L6:
        if (r0 >= r1) goto L8;
        int r2 = r5[r0];
        r5[r0] = r5[r1];
        r5[r1] = r2;
        r1 = r1 - 1;
        r0 = r0 + 1;
        goto L6
    L8:
        return r5;
    }
}
