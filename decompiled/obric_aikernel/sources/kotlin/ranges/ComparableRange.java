package kotlin.ranges;

import com.bytedance.apm6.util.constant.CommonConsts;
import java.lang.Comparable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class ComparableRange<T extends Comparable<? super T>> implements ClosedRange<T> {
    private final T endInclusive;
    private final T start;

    public ComparableRange(T r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, CommonConsts.APM_INNER_EVENT_COST_START);
        Intrinsics.checkNotNullParameter(r11, "endInclusive");
        this.start = r10;
        this.endInclusive = r11;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean contains(T r10) {
        return ClosedRange.DefaultImpls.contains(this, r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ComparableRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ComparableRange r11 = (ComparableRange) r10;
        if (Intrinsics.areEqual(getStart(), r11.getStart()) == false) goto L13;
        if (Intrinsics.areEqual(getEndInclusive(), r11.getEndInclusive()) == false) goto L13;
    L12:
        return true;
    L7:
        if (((ComparableRange) r10).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // kotlin.ranges.ClosedRange
    public T getEndInclusive() {
        return this.endInclusive;
    }

    @Override // kotlin.ranges.ClosedRange
    public T getStart() {
        return this.start;
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r10 = getStart().hashCode() * 31;
        return getEndInclusive().hashCode() + r10;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
