package com.google.common.hash;

import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f9291a = null;

    static {
        f9291a = "0123456789abcdef".toCharArray();
    }

    public j() {
    }

    public static int a(char r5) {
        if (r5 < '0') goto L9;
        if (r5 > '9') goto L9;
        return r5 - '0';
    L9:
        if (r5 >= 'a') goto L11;
    L14:
        StringBuilder r10 = new StringBuilder(32);
        r10.append("Illegal hexadecimal character: ");
        r10.append(r5);
        throw new IllegalArgumentException(r10.toString());
    L11:
        if (r5 > 'f') goto L14;
        return r5 - 'W';
    }

    public static j fromBytes(byte[] r5) {
        boolean r10 = true;
        if (r5.length >= 1) goto L6;
        r10 = false;
    L6:
        com.google.common.base.b0.g("A HashCode must contain at least 1 byte.", r10);
        return fromBytesNoCopy((byte[]) r5.clone());
    }

    public static j fromBytesNoCopy(byte[] r5) {
        return new HashCode$BytesHashCode(r5);
    }

    public static j fromInt(int r5) {
        return new HashCode$IntHashCode(r5);
    }

    public static j fromLong(long r5) {
        return new HashCode$LongHashCode(r5);
    }

    public static j fromString(String r5) {
        int r10 = 0;
        boolean r11 = true;
        if (r5.length() < 2) goto L5;
        boolean r12 = true;
    L6:
        com.google.common.base.b0.h("input string (%s) must have at least 2 characters", r12, r5);
        if ((r5.length() % 2) == 0) goto L10;
        r11 = false;
    L10:
        com.google.common.base.b0.h("input string (%s) must have an even number of characters", r11, r5);
        byte[] r13 = new byte[r5.length() / 2];
    L12:
        if (r10 >= r5.length()) goto L15;
        r13[r10 / 2] = (byte) ((a(r5.charAt(r10)) << 4) + a(r5.charAt(r10 + 1)));
        r10 = r10 + 2;
        goto L12
    L15:
        return fromBytesNoCopy(r13);
    L5:
        r12 = false;
        goto L6
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public final boolean equals(Object r5) {
        if ((r5 instanceof j) == false) goto L10;
        j r10 = (j) r5;
        if (bits() == r10.bits()) goto L7;
        return false;
    L7:
        if (equalsSameBits(r10) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public abstract boolean equalsSameBits(j r5);

    public byte[] getBytesInternal() {
        return asBytes();
    }

    public final int hashCode() {
        if (bits() >= 32) goto L5;
        byte[] r5 = getBytesInternal();
        int r10 = r5[0] & UByte.MAX_VALUE;
        int r11 = 1;
    L8:
        if (r11 >= r5.length) goto L10;
        r10 = r10 | ((r5[r11] & UByte.MAX_VALUE) << (r11 * 8));
        r11 = r11 + 1;
        goto L8
    L10:
        return r10;
    L5:
        return asInt();
    }

    public final String toString() {
        byte[] r10 = getBytesInternal();
        StringBuilder r5 = new StringBuilder(r10.length * 2);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        byte r13 = r10[r12];
        char[] r14 = f9291a;
        r5.append(r14[(r13 >> 4) & 15]);
        r5.append(r14[r13 & 15]);
        r12 = r12 + 1;
        goto L3
    L6:
        return r5.toString();
    }

    public int writeBytesTo(byte[] r5, int r10, int r11) {
        int[] r12 = {r11, bits() / 8};
        int r13 = r12[0];
        int r14 = r12[1];
        if (r14 >= r13) goto L5;
        r13 = r14;
    L5:
        com.google.common.base.b0.p(r10, r10 + r13, r5.length);
        writeBytesToImpl(r5, r10, r13);
        return r13;
    }

    public abstract void writeBytesToImpl(byte[] r5, int r10, int r11);
}
