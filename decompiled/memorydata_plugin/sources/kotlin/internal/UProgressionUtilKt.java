package kotlin.internal;

import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", CommonConsts.APM_INNER_EVENT_COST_START, "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UProgressionUtilKt {
    /* JADX INFO: renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m2628differenceModuloWZ9TVnA(int r1, int r2, int r3) {
        int r4 = Integer.remainderUnsigned(r1, r3);
        int r5 = Integer.remainderUnsigned(r2, r3);
        int r0 = Integer.compareUnsigned(r4, r5);
        int r6 = UInt.m1516constructorimpl(r4 - r5);
        if (r0 < 0) goto L6;
        return r6;
    L6:
        return UInt.m1516constructorimpl(r6 + r3);
    }

    /* JADX INFO: renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m2629differenceModulosambcqE(long r1, long r3, long r5) {
        long r2 = Long.remainderUnsigned(r1, r5);
        long r4 = Long.remainderUnsigned(r3, r5);
        int r0 = Long.compareUnsigned(r2, r4);
        long r6 = ULong.m1595constructorimpl(r2 - r4);
        if (r0 < 0) goto L6;
        return r6;
    L6:
        return ULong.m1595constructorimpl(r6 + r5);
    }

    /* JADX INFO: renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m2630getProgressionLastElement7ftBX0g(long r7, long r9, long r11) {
        if (r11 > 0) goto L5;
        if (r11 >= 0) goto L16;
        if (Long.compareUnsigned(r7, r9) <= 0) goto L18;
        long r10 = r9 + m2629differenceModulosambcqE(r7, r9, ULong.m1595constructorimpl(-r11));
    L14:
        return ULong.m1595constructorimpl(r10);
    L18:
        return r9;
    L16:
        throw new IllegalArgumentException("Step is zero.");
    L5:
        if (Long.compareUnsigned(r7, r9) >= 0) goto L17;
        r10 = r9 - m2629differenceModulosambcqE(r9, r7, ULong.m1595constructorimpl(r11));
        goto L14
    L17:
        return r9;
    }

    /* JADX INFO: renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m2631getProgressionLastElementNkh28Cs(int r1, int r2, int r3) {
        if (r3 > 0) goto L4;
        if (r3 >= 0) goto L15;
        if (Integer.compareUnsigned(r1, r2) <= 0) goto L17;
        int r4 = r2 + m2628differenceModuloWZ9TVnA(r1, r2, UInt.m1516constructorimpl(-r3));
    L13:
        return UInt.m1516constructorimpl(r4);
    L17:
        return r2;
    L15:
        throw new IllegalArgumentException("Step is zero.");
    L4:
        if (Integer.compareUnsigned(r1, r2) >= 0) goto L16;
        r4 = r2 - m2628differenceModuloWZ9TVnA(r2, r1, UInt.m1516constructorimpl(r3));
        goto L13
    L16:
        return r2;
    }
}
