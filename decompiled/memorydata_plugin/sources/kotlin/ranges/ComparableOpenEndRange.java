package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Lkotlin/ranges/ComparableOpenEndRange;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/ranges/OpenEndRange;", CommonConsts.APM_INNER_EVENT_COST_START, "endExclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getEndExclusive", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getStart", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
class ComparableOpenEndRange<T extends Comparable<? super T>> implements OpenEndRange<T> {
    private final T endExclusive;
    private final T start;

    public ComparableOpenEndRange(T r3, T r4) {
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        T r6 = (T) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, CommonConsts.APM_INNER_EVENT_COST_START);
        Intrinsics.checkNotNullParameter(r6, "endExclusive");
        this.start = r5;
        this.endExclusive = r6;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean contains(T r3) {
        return OpenEndRange.DefaultImpls.contains(this, (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, ComparableOpenEndRange.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == false) goto L9;
        if (((ComparableOpenEndRange) ZeusTransformUtils.preCheckCast(r5, ComparableOpenEndRange.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L12:
        return true;
    L9:
        if (Intrinsics.areEqual(getStart(), ((ComparableOpenEndRange) ZeusTransformUtils.preCheckCast(r5, ComparableOpenEndRange.class, "com.obric.memorydata.plugin")).getStart()) == false) goto L13;
        if (Intrinsics.areEqual(getEndExclusive(), ((ComparableOpenEndRange) ZeusTransformUtils.preCheckCast(r5, ComparableOpenEndRange.class, "com.obric.memorydata.plugin")).getEndExclusive()) == false) goto L13;
        goto L12
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
        int r0 = getStart().hashCode() * 31;
        return getEndExclusive().hashCode() + r0;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        return OpenEndRange.DefaultImpls.isEmpty(this);
    }

    public String toString() {
        return getStart() + "..<" + getEndExclusive();
    }
}
