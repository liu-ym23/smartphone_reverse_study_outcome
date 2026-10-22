package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UProgressionUtilKt {
    /* JADX INFO: renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m1329differenceModuloWZ9TVnA(int r5, int r10, int r11) {
        int r12 = Integer.remainderUnsigned(r5, r11);
        int r13 = Integer.remainderUnsigned(r10, r11);
        int r14 = Integer.compareUnsigned(r12, r13);
        int r15 = UInt.m219constructorimpl(r12 - r13);
        if (r14 < 0) goto L6;
        return r15;
    L6:
        return UInt.m219constructorimpl(r15 + r11);
    }

    /* JADX INFO: renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m1330differenceModulosambcqE(long r5, long r10, long r11) {
        long r12 = Long.remainderUnsigned(r5, r11);
        long r13 = Long.remainderUnsigned(r10, r11);
        int r14 = Long.compareUnsigned(r12, r13);
        long r15 = ULong.m298constructorimpl(r12 - r13);
        if (r14 < 0) goto L6;
        return r15;
    L6:
        return ULong.m298constructorimpl(r15 + r11);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* JADX INFO: renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m1331getProgressionLastElement7ftBX0g(long r10, long r11, long r12) {
        if (r12 > 0) goto L5;
        if (r12 >= 0) goto L15;
        if (Long.compareUnsigned(r10, r11) > 0) goto L13;
        return r11;
    L13:
        return ULong.m298constructorimpl(r11 + m1330differenceModulosambcqE(r10, r11, ULong.m298constructorimpl(-r12)));
    L15:
        throw new IllegalArgumentException("Step is zero.");
    L5:
        if (Long.compareUnsigned(r10, r11) < 0) goto L16;
        return r11;
    L16:
        return ULong.m298constructorimpl(r11 - m1330differenceModulosambcqE(r11, r10, ULong.m298constructorimpl(r12)));
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* JADX INFO: renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m1332getProgressionLastElementNkh28Cs(int r5, int r10, int r11) {
        if (r11 > 0) goto L4;
        if (r11 >= 0) goto L14;
        if (Integer.compareUnsigned(r5, r10) > 0) goto L12;
        return r10;
    L12:
        return UInt.m219constructorimpl(r10 + m1329differenceModuloWZ9TVnA(r5, r10, UInt.m219constructorimpl(-r11)));
    L14:
        throw new IllegalArgumentException("Step is zero.");
    L4:
        if (Integer.compareUnsigned(r5, r10) < 0) goto L15;
        return r10;
    L15:
        return UInt.m219constructorimpl(r10 - m1329differenceModuloWZ9TVnA(r10, r5, UInt.m219constructorimpl(r11)));
    }
}
