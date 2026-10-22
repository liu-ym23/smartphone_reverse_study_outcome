package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m1876partitionnroSd4(long[] r6, int r7, int r8) {
        long r0 = ULongArray.m1655getsVKNKU(r6, (r7 + r8) / 2);
    L3:
        if (r7 > r8) goto L12;
    L5:
        if (Long.compareUnsigned(ULongArray.m1655getsVKNKU(r6, r7), r0) >= 0) goto L8;
        r7 = r7 + 1;
    L8:
        if (Long.compareUnsigned(ULongArray.m1655getsVKNKU(r6, r8), r0) <= 0) goto L10;
        r8 = r8 - 1;
        goto L8
    L10:
        if (r7 > r8) goto L3;
        long r2 = ULongArray.m1655getsVKNKU(r6, r7);
        ULongArray.m1660setk8EXiF4(r6, r7, ULongArray.m1655getsVKNKU(r6, r8));
        ULongArray.m1660setk8EXiF4(r6, r8, r2);
        r7 = r7 + 1;
        r8 = r8 - 1;
        goto L3
    L12:
        return r7;
    }

    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m1877partition4UcCI2c(byte[] r3, int r4, int r5) {
        byte r0 = UByteArray.m1497getw2LRezQ(r3, (r4 + r5) / 2);
    L3:
        if (r4 > r5) goto L12;
    L4:
        int r2 = r0 & 255;
        if (Intrinsics.compare(UByteArray.m1497getw2LRezQ(r3, r4) & 255, r2) >= 0) goto L8;
        r4 = r4 + 1;
    L8:
        if (Intrinsics.compare(UByteArray.m1497getw2LRezQ(r3, r5) & 255, r2) <= 0) goto L10;
        r5 = r5 - 1;
        goto L8
    L10:
        if (r4 > r5) goto L3;
        byte r1 = UByteArray.m1497getw2LRezQ(r3, r4);
        UByteArray.m1502setVurrAj0(r3, r4, UByteArray.m1497getw2LRezQ(r3, r5));
        UByteArray.m1502setVurrAj0(r3, r5, r1);
        r4 = r4 + 1;
        r5 = r5 - 1;
        goto L3
    L12:
        return r4;
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m1878partitionAa5vz7o(short[] r4, int r5, int r6) {
        short r0 = UShortArray.m1760getMh2AYeg(r4, (r5 + r6) / 2);
    L3:
        if (r5 > r6) goto L12;
    L4:
        int r1 = UShortArray.m1760getMh2AYeg(r4, r5) & UShort.MAX_VALUE;
        int r3 = r0 & UShort.MAX_VALUE;
        if (Intrinsics.compare(r1, r3) >= 0) goto L8;
        r5 = r5 + 1;
    L8:
        if (Intrinsics.compare(UShortArray.m1760getMh2AYeg(r4, r6) & UShort.MAX_VALUE, r3) <= 0) goto L10;
        r6 = r6 - 1;
        goto L8
    L10:
        if (r5 > r6) goto L3;
        short r2 = UShortArray.m1760getMh2AYeg(r4, r5);
        UShortArray.m1765set01HTLdE(r4, r5, UShortArray.m1760getMh2AYeg(r4, r6));
        UShortArray.m1765set01HTLdE(r4, r6, r2);
        r5 = r5 + 1;
        r6 = r6 - 1;
        goto L3
    L12:
        return r5;
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m1879partitionoBK06Vg(int[] r3, int r4, int r5) {
        int r0 = UIntArray.m1576getpVg5ArA(r3, (r4 + r5) / 2);
    L3:
        if (r4 > r5) goto L12;
    L5:
        if (Integer.compareUnsigned(UIntArray.m1576getpVg5ArA(r3, r4), r0) >= 0) goto L8;
        r4 = r4 + 1;
    L8:
        if (Integer.compareUnsigned(UIntArray.m1576getpVg5ArA(r3, r5), r0) <= 0) goto L10;
        r5 = r5 - 1;
        goto L8
    L10:
        if (r4 > r5) goto L3;
        int r1 = UIntArray.m1576getpVg5ArA(r3, r4);
        UIntArray.m1581setVXSXFK8(r3, r4, UIntArray.m1576getpVg5ArA(r3, r5));
        UIntArray.m1581setVXSXFK8(r3, r5, r1);
        r4 = r4 + 1;
        r5 = r5 - 1;
        goto L3
    L12:
        return r4;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m1880quickSortnroSd4(long[] r2, int r3, int r4) {
        int r0 = m1876partitionnroSd4(r2, r3, r4);
        int r1 = r0 - 1;
        if (r3 >= r1) goto L5;
        m1880quickSortnroSd4(r2, r3, r1);
    L5:
        if (r0 >= r4) goto L8;
        m1880quickSortnroSd4(r2, r0, r4);
        return;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m1881quickSort4UcCI2c(byte[] r2, int r3, int r4) {
        int r0 = m1877partition4UcCI2c(r2, r3, r4);
        int r1 = r0 - 1;
        if (r3 >= r1) goto L5;
        m1881quickSort4UcCI2c(r2, r3, r1);
    L5:
        if (r0 >= r4) goto L8;
        m1881quickSort4UcCI2c(r2, r0, r4);
        return;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m1882quickSortAa5vz7o(short[] r2, int r3, int r4) {
        int r0 = m1878partitionAa5vz7o(r2, r3, r4);
        int r1 = r0 - 1;
        if (r3 >= r1) goto L5;
        m1882quickSortAa5vz7o(r2, r3, r1);
    L5:
        if (r0 >= r4) goto L8;
        m1882quickSortAa5vz7o(r2, r0, r4);
        return;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m1883quickSortoBK06Vg(int[] r2, int r3, int r4) {
        int r0 = m1879partitionoBK06Vg(r2, r3, r4);
        int r1 = r0 - 1;
        if (r3 >= r1) goto L5;
        m1883quickSortoBK06Vg(r2, r3, r1);
    L5:
        if (r0 >= r4) goto L8;
        m1883quickSortoBK06Vg(r2, r0, r4);
        return;
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m1884sortArraynroSd4(long[] r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "array");
        m1880quickSortnroSd4(r1, r2, r3 - 1);
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m1885sortArray4UcCI2c(byte[] r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "array");
        m1881quickSort4UcCI2c(r1, r2, r3 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m1886sortArrayAa5vz7o(short[] r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "array");
        m1882quickSortAa5vz7o(r1, r2, r3 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m1887sortArrayoBK06Vg(int[] r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "array");
        m1883quickSortoBK06Vg(r1, r2, r3 - 1);
    }
}
