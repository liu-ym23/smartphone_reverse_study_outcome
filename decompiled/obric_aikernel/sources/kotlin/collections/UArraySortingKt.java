package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m487partitionnroSd4(long[] r10, int r11, int r12) {
        long r13 = ULongArray.m266getsVKNKU(r10, (r11 + r12) / 2);
    L3:
        if (r11 > r12) goto L12;
    L5:
        if (Long.compareUnsigned(ULongArray.m266getsVKNKU(r10, r11), r13) >= 0) goto L8;
        r11 = r11 + 1;
    L8:
        if (Long.compareUnsigned(ULongArray.m266getsVKNKU(r10, r12), r13) <= 0) goto L10;
        r12 = r12 - 1;
        goto L8
    L10:
        if (r11 > r12) goto L3;
        long r14 = ULongArray.m266getsVKNKU(r10, r11);
        ULongArray.m271setk8EXiF4(r10, r11, ULongArray.m266getsVKNKU(r10, r12));
        ULongArray.m271setk8EXiF4(r10, r12, r14);
        r11 = r11 + 1;
        r12 = r12 - 1;
        goto L3
    L12:
        return r11;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m488partition4UcCI2c(byte[] r10, int r11, int r12) {
        byte r13 = UByteArray.m108getw2LRezQ(r10, (r11 + r12) / 2);
    L3:
        if (r11 > r12) goto L12;
    L4:
        int r14 = r13 & 255;
        if (Intrinsics.compare(UByteArray.m108getw2LRezQ(r10, r11) & 255, r14) >= 0) goto L8;
        r11 = r11 + 1;
    L8:
        if (Intrinsics.compare(UByteArray.m108getw2LRezQ(r10, r12) & 255, r14) <= 0) goto L10;
        r12 = r12 - 1;
        goto L8
    L10:
        if (r11 > r12) goto L3;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r11);
        UByteArray.m113setVurrAj0(r10, r11, UByteArray.m108getw2LRezQ(r10, r12));
        UByteArray.m113setVurrAj0(r10, r12, r15);
        r11 = r11 + 1;
        r12 = r12 - 1;
        goto L3
    L12:
        return r11;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m489partitionAa5vz7o(short[] r10, int r11, int r12) {
        short r13 = UShortArray.m371getMh2AYeg(r10, (r11 + r12) / 2);
    L3:
        if (r11 > r12) goto L12;
    L4:
        int r14 = UShortArray.m371getMh2AYeg(r10, r11) & UShort.MAX_VALUE;
        int r15 = r13 & UShort.MAX_VALUE;
        if (Intrinsics.compare(r14, r15) >= 0) goto L8;
        r11 = r11 + 1;
    L8:
        if (Intrinsics.compare(UShortArray.m371getMh2AYeg(r10, r12) & UShort.MAX_VALUE, r15) <= 0) goto L10;
        r12 = r12 - 1;
        goto L8
    L10:
        if (r11 > r12) goto L3;
        short r16 = UShortArray.m371getMh2AYeg(r10, r11);
        UShortArray.m376set01HTLdE(r10, r11, UShortArray.m371getMh2AYeg(r10, r12));
        UShortArray.m376set01HTLdE(r10, r12, r16);
        r11 = r11 + 1;
        r12 = r12 - 1;
        goto L3
    L12:
        return r11;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m490partitionoBK06Vg(int[] r10, int r11, int r12) {
        int r13 = UIntArray.m187getpVg5ArA(r10, (r11 + r12) / 2);
    L3:
        if (r11 > r12) goto L12;
    L5:
        if (Integer.compareUnsigned(UIntArray.m187getpVg5ArA(r10, r11), r13) >= 0) goto L8;
        r11 = r11 + 1;
    L8:
        if (Integer.compareUnsigned(UIntArray.m187getpVg5ArA(r10, r12), r13) <= 0) goto L10;
        r12 = r12 - 1;
        goto L8
    L10:
        if (r11 > r12) goto L3;
        int r14 = UIntArray.m187getpVg5ArA(r10, r11);
        UIntArray.m192setVXSXFK8(r10, r11, UIntArray.m187getpVg5ArA(r10, r12));
        UIntArray.m192setVXSXFK8(r10, r12, r14);
        r11 = r11 + 1;
        r12 = r12 - 1;
        goto L3
    L12:
        return r11;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m491quickSortnroSd4(long[] r10, int r11, int r12) {
        int r13 = m487partitionnroSd4(r10, r11, r12);
        int r14 = r13 - 1;
        if (r11 >= r14) goto L5;
        m491quickSortnroSd4(r10, r11, r14);
    L5:
        if (r13 >= r12) goto L8;
        m491quickSortnroSd4(r10, r13, r12);
        return;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m492quickSort4UcCI2c(byte[] r10, int r11, int r12) {
        int r13 = m488partition4UcCI2c(r10, r11, r12);
        int r14 = r13 - 1;
        if (r11 >= r14) goto L5;
        m492quickSort4UcCI2c(r10, r11, r14);
    L5:
        if (r13 >= r12) goto L8;
        m492quickSort4UcCI2c(r10, r13, r12);
        return;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m493quickSortAa5vz7o(short[] r10, int r11, int r12) {
        int r13 = m489partitionAa5vz7o(r10, r11, r12);
        int r14 = r13 - 1;
        if (r11 >= r14) goto L5;
        m493quickSortAa5vz7o(r10, r11, r14);
    L5:
        if (r13 >= r12) goto L8;
        m493quickSortAa5vz7o(r10, r13, r12);
        return;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m494quickSortoBK06Vg(int[] r10, int r11, int r12) {
        int r13 = m490partitionoBK06Vg(r10, r11, r12);
        int r14 = r13 - 1;
        if (r11 >= r14) goto L5;
        m494quickSortoBK06Vg(r10, r11, r14);
    L5:
        if (r13 >= r12) goto L8;
        m494quickSortoBK06Vg(r10, r13, r12);
        return;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m495sortArraynroSd4(long[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "array");
        m491quickSortnroSd4(r10, r11, r12 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m496sortArray4UcCI2c(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "array");
        m492quickSort4UcCI2c(r10, r11, r12 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m497sortArrayAa5vz7o(short[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "array");
        m493quickSortAa5vz7o(r10, r11, r12 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m498sortArrayoBK06Vg(int[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "array");
        m494quickSortoBK06Vg(r10, r11, r12 - 1);
    }
}
