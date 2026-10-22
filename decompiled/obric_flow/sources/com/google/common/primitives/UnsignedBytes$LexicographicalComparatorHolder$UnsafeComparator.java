package com.google.common.primitives;

import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.Comparator;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final enum UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator extends Enum<UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator> implements Comparator<byte[]> {
    static final boolean BIG_ENDIAN = false;
    static final int BYTE_ARRAY_BASE_OFFSET = 0;
    public static final UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[] f9330a = null;
    static final Unsafe theUnsafe = null;

    static {
        UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator r5 = new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator("INSTANCE", 0);
        INSTANCE = r5;
        f9330a = new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[]{r5};
        BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
        Unsafe r10 = a();
        theUnsafe = r10;
        int r11 = r10.arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = r11;
        if ("64".equals(System.getProperty("sun.arch.data.model")) == false) goto L10;
        if ((r11 % 8) != 0) goto L10;
        if (r10.arrayIndexScale(byte[].class) != 1) goto L10;
        return;
    L10:
        throw new Error();
    }

    public static Unsafe a() {
        return Unsafe.getUnsafe();
    L4:
        return (Unsafe) AccessController.doPrivileged(new i());
    L6:
        e = move-exception;
        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator valueOf(String r5) {
        return (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator) Enum.valueOf(UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.class, r5);
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[] values() {
        return (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[]) f9330a.clone();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(byte[] r5, byte[] r10) {
        return compare2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(byte[] r11, byte[] r12) {
        int r10 = Math.min(r11.length, r12.length);
        int r5 = r10 & (-8);
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L13;
        Unsafe r14 = theUnsafe;
        int r15 = BYTE_ARRAY_BASE_OFFSET;
        long r16 = r13;
        long r17 = r14.getLong(r11, ((long) r15) + r16);
        long r18 = r14.getLong(r12, ((long) r15) + r16);
        if (r17 != r18) goto L7;
        r13 = r13 + 8;
        goto L3
    L7:
        if (BIG_ENDIAN == true) goto L9;
        int r19 = Long.numberOfTrailingZeros(r17 ^ r18) & (-8);
        return ((int) ((r17 >>> r19) & 255)) - ((int) (255 & (r18 >>> r19)));
    L9:
        return f8.b.l(r17, r18);
    L13:
        if (r13 >= r10) goto L19;
        int r20 = f4.b.f(r11[r13], r12[r13]);
        if (r20 != 0) goto L16;
        r13 = r13 + 1;
        goto L13
    L16:
        return r20;
    L19:
        return r11.length - r12.length;
    }
}
