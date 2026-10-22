package kotlin.collections;

import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", OpenPageMethod.ALIGN_LEFT, "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m579partitionnroSd4(long[] r10, int r11, int r12) {
        long r5 = ULongArray.m358getsVKNKU(r10, (r11 + r12) / 2);
    L3:
        if (r11 > r12) goto L12;
    L5:
        if (Long.compareUnsigned(ULongArray.m358getsVKNKU(r10, r11), r5) >= 0) goto L8;
        r11 = r11 + 1;
    L8:
        if (Long.compareUnsigned(ULongArray.m358getsVKNKU(r10, r12), r5) <= 0) goto L10;
        r12 = r12 - 1;
        goto L8
    L10:
        if (r11 > r12) goto L3;
        long r13 = ULongArray.m358getsVKNKU(r10, r11);
        ULongArray.m363setk8EXiF4(r10, r11, ULongArray.m358getsVKNKU(r10, r12));
        ULongArray.m363setk8EXiF4(r10, r12, r13);
        r11 = r11 + 1;
        r12 = r12 - 1;
        goto L3
    L12:
        return r11;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m580partition4UcCI2c(byte[] r5, int r10, int r11) {
        byte r12 = UByteArray.m200getw2LRezQ(r5, (r10 + r11) / 2);
    L3:
        if (r10 > r11) goto L12;
    L4:
        int r13 = UByteArray.m200getw2LRezQ(r5, r10) & UByte.MAX_VALUE;
        int r14 = r12 & UByte.MAX_VALUE;
        if (Intrinsics.compare(r13, r14) >= 0) goto L8;
        r10 = r10 + 1;
    L8:
        if (Intrinsics.compare(UByteArray.m200getw2LRezQ(r5, r11) & UByte.MAX_VALUE, r14) <= 0) goto L10;
        r11 = r11 - 1;
        goto L8
    L10:
        if (r10 > r11) goto L3;
        byte r15 = UByteArray.m200getw2LRezQ(r5, r10);
        UByteArray.m205setVurrAj0(r5, r10, UByteArray.m200getw2LRezQ(r5, r11));
        UByteArray.m205setVurrAj0(r5, r11, r15);
        r10 = r10 + 1;
        r11 = r11 - 1;
        goto L3
    L12:
        return r10;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m581partitionAa5vz7o(short[] r5, int r10, int r11) {
        short r12 = UShortArray.m463getMh2AYeg(r5, (r10 + r11) / 2);
    L3:
        if (r10 > r11) goto L12;
    L4:
        int r13 = UShortArray.m463getMh2AYeg(r5, r10) & UShort.MAX_VALUE;
        int r14 = r12 & UShort.MAX_VALUE;
        if (Intrinsics.compare(r13, r14) >= 0) goto L8;
        r10 = r10 + 1;
    L8:
        if (Intrinsics.compare(UShortArray.m463getMh2AYeg(r5, r11) & UShort.MAX_VALUE, r14) <= 0) goto L10;
        r11 = r11 - 1;
        goto L8
    L10:
        if (r10 > r11) goto L3;
        short r15 = UShortArray.m463getMh2AYeg(r5, r10);
        UShortArray.m468set01HTLdE(r5, r10, UShortArray.m463getMh2AYeg(r5, r11));
        UShortArray.m468set01HTLdE(r5, r11, r15);
        r10 = r10 + 1;
        r11 = r11 - 1;
        goto L3
    L12:
        return r10;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m582partitionoBK06Vg(int[] r5, int r10, int r11) {
        int r12 = UIntArray.m279getpVg5ArA(r5, (r10 + r11) / 2);
    L3:
        if (r10 > r11) goto L12;
    L5:
        if (Integer.compareUnsigned(UIntArray.m279getpVg5ArA(r5, r10), r12) >= 0) goto L8;
        r10 = r10 + 1;
    L8:
        if (Integer.compareUnsigned(UIntArray.m279getpVg5ArA(r5, r11), r12) <= 0) goto L10;
        r11 = r11 - 1;
        goto L8
    L10:
        if (r10 > r11) goto L3;
        int r13 = UIntArray.m279getpVg5ArA(r5, r10);
        UIntArray.m284setVXSXFK8(r5, r10, UIntArray.m279getpVg5ArA(r5, r11));
        UIntArray.m284setVXSXFK8(r5, r11, r13);
        r10 = r10 + 1;
        r11 = r11 - 1;
        goto L3
    L12:
        return r10;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m583quickSortnroSd4(long[] r5, int r10, int r11) {
        int r12 = m579partitionnroSd4(r5, r10, r11);
        int r13 = r12 - 1;
        if (r10 >= r13) goto L5;
        m583quickSortnroSd4(r5, r10, r13);
    L5:
        if (r12 >= r11) goto L8;
        m583quickSortnroSd4(r5, r12, r11);
        return;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m584quickSort4UcCI2c(byte[] r5, int r10, int r11) {
        int r12 = m580partition4UcCI2c(r5, r10, r11);
        int r13 = r12 - 1;
        if (r10 >= r13) goto L5;
        m584quickSort4UcCI2c(r5, r10, r13);
    L5:
        if (r12 >= r11) goto L8;
        m584quickSort4UcCI2c(r5, r12, r11);
        return;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m585quickSortAa5vz7o(short[] r5, int r10, int r11) {
        int r12 = m581partitionAa5vz7o(r5, r10, r11);
        int r13 = r12 - 1;
        if (r10 >= r13) goto L5;
        m585quickSortAa5vz7o(r5, r10, r13);
    L5:
        if (r12 >= r11) goto L8;
        m585quickSortAa5vz7o(r5, r12, r11);
        return;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m586quickSortoBK06Vg(int[] r5, int r10, int r11) {
        int r12 = m582partitionoBK06Vg(r5, r10, r11);
        int r13 = r12 - 1;
        if (r10 >= r13) goto L5;
        m586quickSortoBK06Vg(r5, r10, r13);
    L5:
        if (r12 >= r11) goto L8;
        m586quickSortoBK06Vg(r5, r12, r11);
        return;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m587sortArraynroSd4(long[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "array");
        m583quickSortnroSd4(r5, r10, r11 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m588sortArray4UcCI2c(byte[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "array");
        m584quickSort4UcCI2c(r5, r10, r11 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m589sortArrayAa5vz7o(short[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "array");
        m585quickSortAa5vz7o(r5, r10, r11 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m590sortArrayoBK06Vg(int[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "array");
        m586quickSortoBK06Vg(r5, r10, r11 - 1);
    }
}
