package kotlin.internal;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;

/* JADX INFO: loaded from: classes2.dex */
public final class UProgressionUtilKt {
    /* JADX INFO: renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m1248differenceModuloWZ9TVnA(int r10, int r11, int r12) {
        int r13 = Integer.remainderUnsigned(r10, r12);
        int r14 = Integer.remainderUnsigned(r11, r12);
        int r15 = Integer.compareUnsigned(r13, r14);
        int r16 = UInt.m127constructorimpl(r13 - r14);
        if (r15 < 0) goto L6;
        return r16;
    L6:
        return UInt.m127constructorimpl(r16 + r12);
    }

    /* JADX INFO: renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m1249differenceModulosambcqE(long r10, long r11, long r12) {
        long r13 = Long.remainderUnsigned(r10, r12);
        long r14 = Long.remainderUnsigned(r11, r12);
        int r15 = Long.compareUnsigned(r13, r14);
        long r16 = ULong.m206constructorimpl(r13 - r14);
        if (r15 < 0) goto L6;
        return r16;
    L6:
        return ULong.m206constructorimpl(r16 + r12);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* JADX INFO: renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m1250getProgressionLastElement7ftBX0g(long r10, long r11, long r12) {
        if (r12 > 0) goto L5;
        if (r12 >= 0) goto L16;
        if (Long.compareUnsigned(r10, r11) <= 0) goto L18;
        long r13 = r11 + m1249differenceModulosambcqE(r10, r11, ULong.m206constructorimpl(-r12));
    L14:
        return ULong.m206constructorimpl(r13);
    L18:
        return r11;
    L16:
        throw new IllegalArgumentException("Step is zero.");
    L5:
        if (Long.compareUnsigned(r10, r11) >= 0) goto L17;
        r13 = r11 - m1249differenceModulosambcqE(r11, r10, ULong.m206constructorimpl(r12));
        goto L14
    L17:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* JADX INFO: renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m1251getProgressionLastElementNkh28Cs(int r10, int r11, int r12) {
        if (r12 > 0) goto L4;
        if (r12 >= 0) goto L15;
        if (Integer.compareUnsigned(r10, r11) <= 0) goto L17;
        int r13 = r11 + m1248differenceModuloWZ9TVnA(r10, r11, UInt.m127constructorimpl(-r12));
    L13:
        return UInt.m127constructorimpl(r13);
    L17:
        return r11;
    L15:
        throw new IllegalArgumentException("Step is zero.");
    L4:
        if (Integer.compareUnsigned(r10, r11) >= 0) goto L16;
        r13 = r11 - m1248differenceModuloWZ9TVnA(r11, r10, UInt.m127constructorimpl(r12));
        goto L13
    L16:
        return r11;
    }
}
