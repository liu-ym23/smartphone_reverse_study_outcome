package kotlin.ranges;

import com.bytedance.apm6.util.constant.CommonConsts;
import java.lang.Comparable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class ComparableOpenEndRange<T extends Comparable<? super T>> implements OpenEndRange<T> {
    private final T endExclusive;
    private final T start;

    public ComparableOpenEndRange(T r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, CommonConsts.APM_INNER_EVENT_COST_START);
        Intrinsics.checkNotNullParameter(r11, "endExclusive");
        this.start = r10;
        this.endExclusive = r11;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean contains(T r10) {
        return OpenEndRange.DefaultImpls.contains(this, r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ComparableOpenEndRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ComparableOpenEndRange r11 = (ComparableOpenEndRange) r10;
        if (Intrinsics.areEqual(getStart(), r11.getStart()) == false) goto L13;
        if (Intrinsics.areEqual(getEndExclusive(), r11.getEndExclusive()) == false) goto L13;
    L12:
        return true;
    L7:
        if (((ComparableOpenEndRange) r10).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // kotlin.ranges.OpenEndRange
    public T getEndExclusive() {
        return this.endExclusive;
    }

    @Override // kotlin.ranges.OpenEndRange
    public T getStart() {
        return this.start;
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r10 = getStart().hashCode() * 31;
        return getEndExclusive().hashCode() + r10;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        return OpenEndRange.DefaultImpls.isEmpty(this);
    }

    public String toString() {
        return getStart() + "..<" + getEndExclusive();
    }
}
